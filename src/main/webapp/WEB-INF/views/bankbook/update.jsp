<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
</head>
<body>
<h1>Update Page</h1>

<form action="update.ssy" method="POST">

	<table>
		<tr>
		<td colspan="2"><input type="hidden" name="bookNum" value=${update.bookNum}></td>
		</tr>
		<tr>
			<td>Account</td>
			<td>Rate</td>
		</tr>
		<tr>
			<td><input type="text" name="bookName" value=${update.bookName}></td>
			<td><input type="text" name="bookRate" value=${update.bookRate}></td>
		</tr>
	</table>
	<br>
	<button type="submit">수정</button>
	<a href="../.ssy"><input type="button" value="메인"></a>
</form>
</body>
</html>