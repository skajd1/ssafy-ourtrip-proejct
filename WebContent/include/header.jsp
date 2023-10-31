<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="<%= request.getContextPath() %>"/>

	<nav class="navbar navbar-expand-sm bg navbar fw-bolder">
       <div class="container p-3">
           <a class="navbar-brand " href="index">
               <img src = "/images/logo.png" alt="logo" width="130" height="140" class=" align-text-top">	
           </a>
           <div class="collapse navbar-collapse flex-row-reverse" id="collapsibleNavbar">
               <ul class="navbar-nav">
                   <li class="nav-item">
                       <a class="nav-link" href="#">여행지 조회</a>
                   </li>
                   <li class="nav-item">
                       <a class="nav-link" href="#">나의 여행 계획</a>
                   </li>  
                   <li class="nav-item">
                    <c:if test="${empty sessionScope.user}">
                        <li><a class="nav-link" href="login">로그인</a></li>
                        <li><a class="nav-link" href="regist">회원가입</a></li>
                    </c:if>
                    <c:if test="${not empty sessionScope.user}">
                        <li><a class="nav-link" href="logout">로그아웃</a></li>
                        <li><a class="nav-link" href="mypage">마이페이지</a></li>
                    </c:if>
                       </ul>
                   </li>
               </ul>
           </div>
       </div>
   </nav>