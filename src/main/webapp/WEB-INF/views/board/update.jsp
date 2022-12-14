<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add Book</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<style>
	</style>
</head>

<body>
	<c:import url="../template/header.jsp"></c:import>
	<h1 class="align-center">${board} Update Page</h1>
	<section class="container-fluid col-lg-4">
	
	<div class="row">
		<form action="./add.ssy" method="post">
			<input type="hidden" name="num" value="${boardDTO.num}" >
			<div class="mb-3">
			  <label for="title" class="form-label">Title</label>
			  <input type="text" name="title" value="${boardDTO.title}" class="form-control" id="title" placeholder="제목 입력">
			  								<!-- 검색을 위해 속성 설정하기 -->
			</div>
			<div class="mb-3">
			  <label for="writer" class="form-label">Writer</label>
			  <input type="text" name="writer" value="${boardDTO.writer}" disabled="disabled" class="form-control" id="Writer" placeholder="작성자 입력">
			</div>
			<div class="mb-3">
			  <label for="contents" class="form-label">Contents</label>
			  <textarea class="form-control" name="contents" id="contents" rows="3">${boardDTO.contents}</textarea>
			</div>
			
			<c:forEach items="${boardDTO.boardFileDTOs}" var="fileDTO">
			    <div class="mb-3">
	    		<span>${fileDTO.oriName}</span>
				<button type="button" class="fileDelete" data-file-num="${fileDTO.fileNum}">삭제</button>
				</div>
			</c:forEach>
			
			<div class="mb-3">
				<button class="btn btn-success">WRITE</button>
			</div>
			
		</form>
	</div>/
	</section>
		
	<c:import url="../template/footer.jsp"></c:import>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<script src="/resources/js/board_files.js"></script>
	<script>
	   setCount(${update.boardFileDTOs.size()});
	</script>
</body>
</html>