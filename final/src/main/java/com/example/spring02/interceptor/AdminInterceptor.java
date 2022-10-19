package com.example.spring02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AdminInterceptor extends HandlerInterceptorAdapter {
	//전처리
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//세션 객체 생성
		HttpSession session=request.getSession();
		//세션이 없으면(로그인되지 않은 상태)
		if(session.getAttribute("admin_userid") == null) {
			//관리자 로그인 페이지로 이동
			response.sendRedirect(request.getContextPath()
					+"/admin/login.do?message=nologin");
			return false; //메인 액션으로 가지 않음
		}else {//로그인 했으면
			return true; //메인 액션으로 이동
		}
	}
	
	//후처리
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}

}
