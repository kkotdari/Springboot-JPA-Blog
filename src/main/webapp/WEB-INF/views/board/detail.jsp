<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

<div class="container-fluid mt-3">
    <button class="btn btn-primary" onclick="history.back()">돌아가기</button>
    <c:if test="${board.user.id == principal.user.id}">
    <a href="/board/${board.id}/update-form"><button class="btn btn-info">수정</button></a>
    <button class="btn btn-info" id="btn-delete">삭제</button>
    </c:if>
    <hr />
    <div>
        글 번호: <span id="id"><i>${board.id} </i></span>
        작성자: <span><i>${board.user.username} </i></span>
    </div>
    <hr />
    <div class="form-group">
        <h3>${board.title}</h3>
    </div>
    <hr />
    <div class="form-group">
      <div>${board.content}</div>
    </div>

    <div class="card">
    		<div class="card-header">댓글 리스트</div>
    		<ul id="reply-box" class="list-group">
    			<c:forEach var="reply" items="${board.replies}">

    				<li id="reply-${reply.id}" class="list-group-item d-flex justify-content-between">
    					<div>${reply.content}</div>
    					<div class="d-flex">
    						<div class="font-italic">작성자 : ${reply.user.username} &nbsp;</div>
    						<c:if test="${reply.user.id eq principal.user.id}">
    							<button onClick="index.replyDelete(${board.id}, ${reply.id})" class="btn btn-primary btn-sm" style="width: 50px;">삭제</button>
    						</c:if>
    						<c:if test="${reply.user.id ne principal.user.id}">
    							<div style="width: 50px; height:30.33px;"></div>
    						</c:if>

    					</div>
    				</li>

    			</c:forEach>
    		</ul>
    	</div>

</div>

<script src="/js/board.js"></script>
<%@ include file="../layout/footer.jsp"%>