package com.bit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequst;
import javax.servlet.http.HttpServletResponse;

//	Servlet은 HttpServlet을 상속 받아 필요한 메서드를 Override한다
//	 HelloServlet은    url-pattern="/hs"  에 반응하고 있다. -> index.html에서 이용함<!-- 55p/123 -->
public class HelloServlet extends HttpServlet {

	@Override  //49-50-51p/123
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	GET 요청을 처리하는 메서드 오버라이드
		//	하고자 하는것은? 클라이언트에서 name 파라미터를 전송 받아서 환영 메시지 출력
		//	JSP에서는 사용자 요청을 자동으로 request라는 이름으로 전달   String name = request.getParameter("name");
		//		-> Servlet에서는 인수로 전달된 req
		String name = req.getParameter("name");
		if (name == null) {
			name = "Anonymous";
		}
		//	출력
		//	응답 객체에서 Writer를 얻어온다
		PrintWriter out = resp.getWriter();
		out.println("<h1>Hello, Servlet</h1>");
		out.println("<p>Hello, " + name + "</p>");
		//이 servlet은 어떤 용건을 처리해야하는지 연결이 안됐다. 어떤 url에 연결되어있는지 없다. 등록해야한다. 매핑 해야한다. //49-50p/123 
		//jsp는 연걸안해도됨 어떤 디렉토리에 있는지 명확함 그래서 url뽑아낼수 있다. servlet은 소스코드안에 있어서 url이 명확하지 않다. //web.xml 과 같이 보기 넘어가 그쪾으로 	<!-- 서블릿 등록 -->보기 
	}
//       Hello JSP   vs HelloServlet
//       안쪽에 처리코드가 복잡해도 구성을 잘 하면 유지보수가 용이하다. 
//       직접 PRINTLN 다 뽑아야한다. 
//       단점은 출력코드 작성이 힘들다. 
//      
//	  ->HelloServlet에서 로직을 처리후  -> JSP에서 코드출력
 
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POST 방식 요청을 처리하기 위한 메서드
		//	폼으로 전송된 파라미터 받아오기
		
//req.setCharacterEncoding("UTF-8");  //	폼의 입력 데이터의 인코딩을 맞춰준다 한글로 나오도록
                                      //주석처리 해주는 이유는 encoding fiter에서 처리해 줄것이다. 65-66p/123 서블릿에 등록을 하자
		
		//		폼 내의 input 태그의 name 속성
		String firstName = req.getParameter("first_name");
		String lastName = req.getParameter("last_name");
		
		//	응답 객체에서 Writer 얻어온다
		//	응답되는 데이터가 text/html임을 브라우저에게 알림
//resp.setContentType("text/html;charset=UTF-8");  // 응답되는 데이터가 text/html임을 브라우저에게 알림
		 //주석처리 해주는 이유는 encoding fiter에서 처리해 줄것이다. 65-66p/123 서블릿에 등록을 하자
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>Form Data</h1>");
		out.println("<p>성:" + lastName + "</p>");
		out.println("<p>이름:" + firstName + "</p>");
		
	}
	
	
	

}