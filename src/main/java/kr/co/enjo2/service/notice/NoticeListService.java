package kr.co.enjo2.service.notice;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.notice.NoticeDao;
import kr.co.enjo2.dto.notice.NoticeDto;

public class NoticeListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			int page = Integer.parseInt(request.getParameter("page"));
			List<NoticeDto> noticeArr = new NoticeDao().findAllByPage(page);

			JSONArray noticeList = new JSONArray();
			for (NoticeDto n : noticeArr) {
				JSONObject obj = new JSONObject();
				obj.put("number", n.getNoticeNo());
				obj.put("title", n.getTitle());
				obj.put("writer", n.getMemberId());
				obj.put("date", n.getCreatedAt());
				// 조회수 수정 필요
				obj.put("count", String.valueOf(1));
				noticeList.add(obj);
			}

			PrintWriter out = response.getWriter();
			response.setContentType("application/json; charset=uft-8");
			JSONObject obj = new JSONObject();
			obj.put("noticeList", noticeList);
			String result = obj.toJSONString();
			out.print(result);
			response.setStatus(200);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			response.setStatus(400);
		}

		return null;
	}

}
