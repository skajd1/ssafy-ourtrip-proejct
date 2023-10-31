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
    <div>
        <div class="row m-auto w-75">
            <form method = "post" action = "login">
                <input type="text" class="form-control border border-secondary mt-2" name="id" placeholder="아이디"/>
                <input type="password" class="form-control border border-secondary mt-2" name="pw" placeholder="비밀번호"/>
                <div class="custom-control custom-checkbox mt-2">
                    <input type="checkbox" class="custom-control-input" id="agreement">
                    <label class="custom-control-label" for="agreement">아이디 저장</label>
                <div class="d-grid mt-3">
                    <button type="submit" class="btn btn-primary btn-block">로그인</button>
                </div>
            </form>
        </div>
    </div>


    <ul class="navbar-nav row me-auto">
        <li class="nav-item col-md-4">
            <a class="nav-link" href="regist">회원가입</a>
        </li>
    </ul>

<%@ include file="/include/footer.jsp" %>
</body>
</html>
