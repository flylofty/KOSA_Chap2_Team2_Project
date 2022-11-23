package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberRegisterOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String nickname = request.getParameter("nickname");
			String email = request.getParameter("email");
			
			MemberDto member = new MemberDto();
			member.setId(id);
			member.setPassword(pw);
			member.setNickName(nickname);
			member.setEmail(email);
			
			System.out.println("================================");
			System.out.println(member);
			
			MemberDao dao = new MemberDao();
			int result = dao.saveOne(member);
			
			forward = new ActionForward();
			if (result > 0) {
				// 로그인 페이지로 리다이렉트
				forward.setRedirect(true);
				// 일단 야매 "http://localhost:8090/team2" 이부분 어떻게 뽑음??
				forward.setPath(request.getContextPath() + "/loginView.do");
			} else {
				forward = null;
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("UTF-8");
				out.print("<script>");
					out.print("alert('잠시후 다시 시도해주세요')");
				out.print("</script>");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return forward;
	}
}
