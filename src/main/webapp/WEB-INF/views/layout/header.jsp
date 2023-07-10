<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal" />
</sec:authorize>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<strong>${principal}</strong>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="/">꽃보드</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <c:choose>
        <c:when test="${empty principal}">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/auth/login-form">로그인</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/auth/join-form">회원가입</a>
            </li>
          </ul>
        </c:when>
        <c:otherwise>
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link" href="/board/form">글쓰기</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/user/form">회원정보</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/logout">로그아웃</a>
            </li>
          </ul>
        </c:otherwise>
      </c:choose>
    </div>
  </div>
</nav>