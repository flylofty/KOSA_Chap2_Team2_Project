<!-- 마이페이지 수정 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script
	src="https://code.iconify.design/iconify-icon/1.0.1/iconify-icon.min.js"></script>
<script src="js/common.js" type="module"></script>
<link href="style/header-footer.css" rel="stylesheet" type="text/css" />
<link href="style/culture-place.css" rel="stylesheet" type="text/css" />
<link href="style/common.css" rel="stylesheet" type="text/css" />
<link href="style/management-page.css" rel="stylesheet" type="text/css" />
<link href="style/information-page.css" rel="stylesheet" type="text/css" />
<link href="style/mypage.css" rel="stylesheet" type="text/css" />
<body>
	<!-- header -->
	<%
	pageContext.include("/WEB-INF/views/include/header.jsp");
	%>

	<div class="culture-container">
		<div class="culture-information">
			<span class="culture-sub-heading">마이 페이지</span>
			<ul class="page-category">
				<a href="${request.getContextPath}memberEdit.do">
					<li class="sub-heading">수정</li>
				</a>
				<a href="${request.getContextPath}memberUnregister.do">
					<li>탈퇴</li>
				</a>
			</ul>

			<div class="information-container">
				<div class="information">
					<span class="member-information">회원정보</span>
					<form action="" method="post">
						<input type="text" name="id" placeholder="admin" readonly><br>
						<input type="password" name="pw" placeholder="비밀번호" required><br>
						<input type="password" name="pw-confirm" placeholder="비밀번호 확인"
							required><br> <input type="text" name="nickname"
							placeholder="닉네임" required><br> <input type="email"
							name="email" placeholder="이메일" required><br> <input
							type="text" name="address" placeholder="주소" required><br>
						<input type="hidden" name="member" value="ordinary"><br>
						<input type="submit" value="완료">
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%
	pageContext.include("/WEB-INF/views/include/footer.jsp");
	%>
</body>
</html>