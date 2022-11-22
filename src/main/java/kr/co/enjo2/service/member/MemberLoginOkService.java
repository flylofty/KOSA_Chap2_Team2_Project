package kr.co.enjo2.service.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.dao.member.MemberDao;
import kr.co.enjo2.dto.member.MemberDto;

public class MemberLoginOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward forward = null;
		
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			//System.out.println("id : " + id);
			//System.out.println("pwd : " + pwd);
			
			MemberDao dao = new MemberDao();
			MemberDto member = dao.findOne(id);
			
			forward = new ActionForward();
			// isRedirect ==> default == false 
			//forward.setRedirect(false);
			
			if (member == null) { // 없는 사용자인 경우
				// 회원가입 페이지로 갑니다.
				// 알러트 창 어떻게 띄우죠?
				forward.setPath("/WEB-INF/views/member/join.jsp");
			} else {
				if (member.getPassword().equals(pwd)) {
					// 로그인 성공
					request.getSession().setAttribute("memberSessionId", member.getId());
					// 일단 로그인에 성공하면 랜딩 페이지로 갑니다.
					// redirectURI 받아서 처리하면 좋을 것 같음
					forward.setRedirect(true);
					forward.setPath(request.getContextPath());
				} else {
					forward = null;
					PrintWriter out = response.getWriter();
					response.setCharacterEncoding("UTF-8");
					out.print("<script>");
						out.print("alert('아이디와 비밀번호를 다시 한 번 확인해주세요')");
					out.print("</script>");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return forward;
	}

}
