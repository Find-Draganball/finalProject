<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="tags.jsp" %>
<style>	
	.nav-container {
		display: flex;
		flex-direction: row;
		flex-wrap: wrap;
		align-items: center;
		justify-content: space-between;
		
		width: 100%;
		max-width: 1320px;
		background-color: #cccccc;
	}
	
	.search-box {
		flex-shrink: 0;
		height: 100%;
		padding: 10px;
	}
	
	.nav-item-menu-div {
		display: none;
	}
	
	.nav-item-my-div {
		display: none;
	}
	
	.search-txt {
		float: left;
		padding: 0;
		border: none;
		font-size: 15px;
		line-height: 30px;
	}
	
	.search-btn {
		color: white;
		float: right;
		width: 30px;
		height: 30px;
		border-radius: 17%;
		background: green;
		display: flex;
		align-items: center;
		justify-content: center;
	}
	
	.nav-item {
		
	}
	
	.logo {
	display: flex;
	}
</style>

<nav class="navbar">
	<div class="nav-container">
		<!-- 홈버튼 -->
		<div class="logo">
		<a href="#"> <!-- 홈페이지로 이동 -->
			<img src="images/dragonball_logo2.png" width="100" height="40">
		</a>
		</div>
		<!-- 검색창 -->
		<div class="search-box">
			<form action="." method="post">
				<input class="search-txt" type="text" placeholder="지역, 숙소명" size="30">
				<button class="search-btn" type="submit">
					<i class="fas fa-search"></i>
				</button>
			</form>
		</div>
		<!-- 로그인 상태라면 -->
		<%-- <c:if test=""> --%>
		<div class="nav-item">
			<a href="">내주변</a>
			<a href="">예약내역</a>
			<a href="">내정보</a>
		</div>
		<%-- </c:if> --%>
		<!-- 로그아웃 상태라면 -->
		<%-- <c:if test="">
			<li class="nav-item" style="width: 80px; height: auto;"><a href="">로그인</a></li>
			<li class="nav-item" style="width: 80px; height: auto;"><a href="">회원가입</a></li>
		</c:if> --%>
	</div>
	<div class="nav-item-menu-div">
		<ul class="nav-item-menu-list">
			<li><a href="">1:1문의</a>
			<li><a href="">핫한 숙소</a>
			<li><a href="">인기 맛집</a>
		</ul>
	</div>
	<div class="nav-item-my-div">
		<ul class="nav-item-my-list">
			<li><a href="">내 정보</a></li>
			<li><a href="">예약 내역</a></li>
			<li><a href="">내가 찜한 목록</a></li>
			<li><a href="">내 리뷰 보기</a></li>
			<li><a href="">로그아웃</a>
		</ul>
	</div>
</nav>