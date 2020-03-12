<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<a href="insertForm.do">글쓰기</a>
	<br>
	<input type="button" name="btn1" value="3개씩 보기"
		onclick="window.location='/?number=3'">
	<input type="button" name="btn2" value="4개씩 보기"
		onclick="window.location='/?number=4'">
	<input type="button" name="btn3" value="5개씩 보기"
		onclick="window.location='/?number=5'">
	</br>
	</br>
	<c:set var="i" value="1"></c:set>
	<c:set var="page" value="1"></c:set>
	<c:forEach var="board" items="${boardList }">
		<img src="http://localhost:8191/image/${board.image_name }">
		<c:if test="${i%number == 0 }">
			<br>
		</c:if>
		<c:set var="i" value="${i+1 }"></c:set>
	</c:forEach>


	<!-- 페이징 처리 -->
	<c:set var="Start" value="${boardPage.startPageNo}"></c:set>
	<br />
	<%--            <c:set var="done_loop" value="false"/>--%>
	<c:set var="nowpage" value="${boardPage.startPageNo}" />
	<c:forEach begin="${boardPage.startPageNo}"
		end="${boardPage.countPage}" step="1">
		<%--<c:if test="${done_loop ne true}">--%>
		<c:if test="${nowpage-1 < boardPage.countPage}">
			<a href="/?currentPageNo=${nowpage}&number=${number}">[${nowpage}]</a>
			<c:set var="nowpage" value="${nowpage+1}"></c:set>
		</c:if>
		<%--</c:if>--%>
	</c:forEach>

</body>
</html>