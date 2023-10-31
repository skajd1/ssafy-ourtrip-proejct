<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<title>Insert title here</title>
<%@ include file="/include/header.jsp" %>
</head>
<body>
    <div class="section container-fluid">
        <h2 class = 'text-center'> 마이페이지임~</h2>
        <div class = "w-50 h-50 mx-auto">
            <form action="mypage" method = "post">
                <div class="mb-3 mt-3">
                  <label for="email" class="form-label">이메일</label>
                  <input type="email" class="form-control" id="email" placeholder="${member.email}@${member.domain}" name="email" disabled>
                </div>
                <div class="mb-3">
                  <label for="nickname" class="form-label">이름</label>
                  <input type="text" class="form-control" id="name" placeholder="${member.name}" name="name">
                </div>
                <div class="mb-3 mt-3">
                  <label for="pwd" class="form-label">비밀번호</label>
                  <input type="password" class="form-control" id="pw" placeholder="********" name="pw">
                </div>
                <div class="mb-5 mt-3">
                  <label for="pwdc" class="form-label">비밀번호 확인</label>
                  <input type="password" onkeyup = 'check()' class="form-control" id="pwc" placeholder="********" name="pwc">
                </div>
                <div id = 'result'></div>
                <div class ='d-flex'> 
                    <button type="submit" class="btn btn-primary m-5 w-50">수정</button>
                    <button type="button" onclick = 'delete(${member.id})' class="btn btn-danger m-5 w-50">회원탈퇴</button>
                </div>
                
              </form>
        </div>
    </div>
    <script>
        function check(){
            let pw = document.getElementById("pw").value;
            let pwc = document.getElementById("pwc").value;
            if(pw != pwc){
                document.getElementById("result").innerText = "비밀번호가 일치하지 않습니다.";
                return false;
            }
            else {
            	document.getElementById("result").innerText = "비밀번호가 일치합니다.";
            }
            
            return true;
        }
    </script>
<%@ include file="/include/footer.jsp" %>

</body>
