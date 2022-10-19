<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="tags.jsp" %>
<style>	
	.nav-container {
		display: flex;
		flex-wrap: inherit;
		align-items: center;
		justify-content: space-between;
		width: 100%;
		padding-right: calc(var(--bs-gutter-x) * .5);
		padding-left: calc(var(--bs-gutter-x) * .5);
		margin-right: auto;
		margin-left: auto;
		max-width: 1320px;
		--bs-gutter-x: 1.5rem;
		--bs-gutter-y: 0;
		padding: var(--bs-navbar-padding-y) var(--bs-navbar-padding-x);
	}
</style>

<nav class="navbar">
	<div class="nav-container">
		<!-- 홈버튼 -->
		<a class="navbar-brand" href="/">
			<img src="/resources/images/logo.svg" alt="" width="100" height="auto">
		</a>
		<ul class="navbar-nav">			
			<div class="container-fluid" style="width:700px; height:auto">
				<form id="nav-form-search" class="d-flex justify-content-center my-auto" action="/acco" autocomplete="off">
				<input class="form-control" type="text" id="nav-search" name="keyword" placeholder="지역, 숙소명" style="max-width:600px;height:auto">
				<button class="btn" type="submit"></button>
				<!-- 최근 검색어 box -->
				<ul id="nav-box-keywords" class="position-absolute" style="top:50px; left:0; z-index: 1000;">
					<li class="list-group-item">
						<div class="d-flex justify-content-between py-1 align-items-middle">
							<span class="fw-lighter">최근검색어</span>
							<button id="nav-delete-all-keyword" type="button" class="float-end btn text-danger border-0 btn-sm">모두 지우기</button>
						</div>
					</li>
					<div id="nav-list-group-keywords">
					</div>
				</ul>
				</form>
			</div>
			<!-- 로그인 상태 -->
			<li class="nav-item" style="width:80px; height:auto"><a class="nav-link ${menu eq 'login' ? 'active' : '' }" href="/near">내주변</a></li>
			<li class="nav-item ${empty LOGIN_USER ? 'd-none' : ''}" style="width:90px;height:auto"><a class="nav-link ${menu eq 'register' ? 'active' : '' } " href="/user/information?cat=CAT_002">예약내역</a></li>
			<li class="nav-item dropdown" style="width:90px;height:auto">
   			<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="" role="button" aria-expanded="false">더보기</a>
   				<ul class="dropdown-menu">
    				<li><a class="dropdown-item" href="/qaform">1:1 문의</a></li>
     				<li><a class="dropdown-item" href="/acco/best">핫한 숙소</a></li>
     				<li><a class="dropdown-item" href="/restaurant">인기 맛집</a></li>
   				</ul>
			</li>
			<li class="nav-item dropdown ${empty LOGIN_USER ? 'd-none' : ''}" style="width:80px;height:auto">
				<a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="" role="button" aria-expanded="false">내정보</a>
    			<ul class="dropdown-menu">
      				<li><a class="dropdown-item" href="/user/information?cat=CAT_001">내 정보</a></li>
      				<li><a class="dropdown-item" href="/user/information?cat=CAT_002">예약 내역</a></li>
      				<li><a class="dropdown-item" href="/user/information?cat=CAT_003">내가 찜한 목록</a></li>
      				<li><a class="dropdown-item" href="/user/information?cat=CAT_004">내 리뷰 보기</a></li>
      				<li><hr class="dropdown-divider"></li>
					<li class=" ${empty LOGIN_USER ? 'd-none' : ''}"><a class="dropdown-item" href="/logout">로그아웃</a></li>					
    			</ul>
   			</li>
			
			<!-- 로그아웃 상태 -->
			<c:if test="${empty LOGIN_USER }">
				<li class="nav-item" style="width:80px;height:auto"><a class="nav-link ${menu eq 'login' ? 'active' : '' }" href="/login">로그인</a></li>
				<li class="nav-item" style="width:80px;height:auto"><a class="nav-link ${menu eq 'register' ? 'active' : '' }" href="/register">회원가입</a></li>
			</c:if>
		</ul>
	</div>
</nav>