<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="layout/header.jsp"%>

<div class="container-fluid mt-3">
  <c:forEach var="board" items="${boards.content}">
  <div class="card m-2" style="width:100%">
    <div class="card-body">
      <h4 class="card-title">${board.title}</h4>
      <a href="/board/${board.id}" class="btn btn-primary">상세보기</a>
    </div>
  </div>
  </c:forEach>

  <ul class="pagination justify-content-center">
    <c:choose>
    <c:when test="${boards.first}">
    <li class="page-item disabled">
    </c:when>
    <c:otherwise>
    <li class="page-item">
    </c:otherwise>
    </c:choose>
    <a class="page-link" href="/?page=${boards.number - 1}">Previous</a></li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <c:choose>
    <c:when test="${boards.last}">
    <li class="page-item disabled">
    </c:when>
    <c:otherwise>
    <li class="page-item">
    </c:otherwise>
    </c:choose>
    <a class="page-link" href="/?page=${boards.number + 1}">Next</a></li>
  </ul>

</div>

<%@ include file="layout/footer.jsp"%>