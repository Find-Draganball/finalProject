package com.example.spring02.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//인터셉터는 HandlerInterceptorAdapter는 추상클래스를 상속받아야함
public class SampleInterceptor extends HandlerInterceptorAdapter {
	//로깅
	private static final Logger logger=LoggerFactory.getLogger(SampleInterceptor.class);
	
	//Ctrl + Space한 후에 preHandle을 치면 자동 오버라이딩 함.
	//선처리
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("pre handle(선처리)...");
		return true; //true면 계속진행, false면 멈춤
	}
	
	//Ctrl + Space한 후에 postHandle을 치면 자동 오버라이딩 함.
	//후처리
	@Override
	public void postHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("post handle(후처리)...");
	}

}
