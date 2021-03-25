<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>Hello JSP</h1>
    <%
    String name = request.getParameter("name");
    if (name== null){
         name = "Anonymous";
         }
         %>
         <p>Welcome, <%= name %>!</p>
</body>
</html>

<!--  Hello JSP   vs HelloServlet    //49-50-51p/123
정적html 내부에  자바코드가 있다. 만약 안에 처리해야할 로직이 많다면 
실제 처리해야할 로직과  표시를 위한 포시 코드가 있으면 알아볼수 없게 된다. 
편리하지만 복잡하다. 유지보수가 어렵다. 

->HelloServlet에서 로직을 처리후  -> JSP에서 코드출력 --> 