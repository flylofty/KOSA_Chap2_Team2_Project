package kr.co.enjo2.controller.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.enjo2.action.Action;
import kr.co.enjo2.action.ActionForward;
import kr.co.enjo2.service.basic.GatherPageMoveService;
import kr.co.enjo2.service.member.JoinServiceAction;
import kr.co.enjo2.service.member.MemberLoginOkService;
import kr.co.enjo2.service.member.MemberLoginViewService;
import kr.co.enjo2.service.member.MemberLogoutService;
import kr.co.enjo2.service.member.MemberRegisterOk;

@WebServlet({ "/BasicController", "*.do" })
public class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasicController() {}
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response, String HttpMethodType) throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String url_Command = requestURI.substring(contextPath.length());
	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if (url_Command.equals("/gatherView.do")) {
    		// 모아보기 페이지 가기
    		action = new GatherPageMoveService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/loginView.do")) {
    		// 로그인 페이지 가기
    		action = new MemberLoginViewService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/loginOk.do")) {
    		// 로그인 하기 (로그인 요청)
    		action = new MemberLoginOkService();
    		forward = action.execute(request, response);
    	} else if (url_Command.equals("/logout.do")) {
    		action = new MemberLogoutService();
    		forward = action.execute(request, response);
    	} else if(url_Command.equals("/joinView.do")) {
    		// 회원가입 페이지 가기
    		action = new JoinServiceAction();
    		forward = action.execute(request, response);
    	}  else if(url_Command.equals("/joinOk.do")) {
    		// 회원가입 하기 (회원가입 요청)
    		action = new MemberRegisterOk();
    		forward = action.execute(request, response);
    	}
    	
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 
    			response.sendRedirect(forward.getPath());
    		} else { //false (모든 자원 ) 사용
    			//UI
    			//UI + 로직
    			//forward url 주소 변환 없어 View 내용을 받을 수 있다
    			RequestDispatcher dis  = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "GET");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response, "POST");
	}

}
