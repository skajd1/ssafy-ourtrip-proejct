<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
</head>
<%@ include file="/include/header.jsp" %>
<body>
    <div class = "container">
        <form action = "regist" method = "post">
            <input type="text" class="form-control border border-secondary mt-2" name="id" placeholder="아이디"/>
            <input type="text" class="form-control border border-secondary mt-2" name="name" placeholder="이름"/>
            <input type="password" class="form-control border border-secondary mt-2" name="pw" placeholder="비밀번호"/>
            <input type="text" class="form-control border border-secondary mt-2" name="email" placeholder="이메일"/>
            <input type="text" class="form-control border border-secondary mt-2" name="domain" placeholder="도메인"/>
    
            <button type="submit" class="btn btn-primary btn-block" type="submit">가입 완료</button>     
        </form>

    </div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>
