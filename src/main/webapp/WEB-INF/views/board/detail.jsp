<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container-fluid mt-3">
    <button class="btn btn-primary" onclick="history.back()">돌아가기</button>
    <c:if test="${board.user.id == principal.user.id}">
    <a href="/board/${board.id}/update-form"><button class="btn btn-warning">수정</button></a>
    <button class="btn btn-warning" id="btn-delete">삭제</button>
    </c:if>
    <br />
    <br />
    <div>
        글 번호: <span id="id"><i>${board.id} </i></span>
        작성자: <span><i>${board.user.username} </i></span>
    </div>
    <br />
    <div class="form-group">
        <h3>${board.title}</h3>
    </div>
    <br />
    <div class="form-group">
      <div>${board.content}</div>
    </div>
</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>