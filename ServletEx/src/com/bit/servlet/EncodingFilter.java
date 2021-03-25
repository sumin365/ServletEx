package com.bit.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}

	
	//65-66p/123
	@Override
	public void doFilter(ServletRequest req, 
			ServletResponse resp, 
			FilterChain chain)
			throws IOException, ServletException {
		// 요청의 캐릭터 인코딩을 UTF-8로 변환
		req.setCharacterEncoding("UTF-8");	//	변환 작업 수행
//		응답에 관련된 필터 처리 거꾸로 나온다. 처리가 완료되면 사용자에게 돌려준다. 
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		//	그다음에 연결된 필터에 요청과 응답을 전달 (필터 필터가 연결된걸 필터체인이라고 함 )
		chain.doFilter(req, resp);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}
}