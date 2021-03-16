<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageName" value="회원가입" />
<%@ include file="../part/head.jspf" %>

<script>
function isAlphaNumeric(str) {
	var code, i, len;
	alert("str >> " + str);
	for ( i=0, len=str.length; i<len; i++){
		code = str.charCodeAt(i);
		alert("code >> " + code);	
		if ( !(code > 47 && code <58) && // numeric (0-9)
			!(code > 64 && code <91) && // upper alpha (A-Z)
			!(code > 96 && code <123)) { // lower alpha (a-z)
			return false;
		}		
	}
	return true;
}

function submitJoinForm(form) {
	form.loginId.value = form.loginId.value.trim();
	if ( form.loginId.value.length == 0 ){
		alert('아이디를 입력해주세요.');
		form.loginId.focus();		
		return false;
	} 
	
	if ( form.loginId.value.length < 4 ){
		alert('로그인 아이디를 4자이상 입력해주세요');
		form.loginId.focus();		
		return false;
	}
	
	if ( isAlphaNumeric(form.loginId.value) == false ){
		alert('로그인 아이디는 영문자 소문자와 숫자만 사용할 수 있습니다.');
		return false;
	}
	
	form.loginId.value = form.loginId.value.toLowerCase();
	
	form.loginPw.value = form.loginPw.value.trim();
	if ( form.loginPw.value.length == 0 ){
		alert('비밀번호를 입력해주세요.');
		form.loginPw.focus();		
		return false;
	}
	
	form.loginPwConfirm.value = form.loginPwConfirm.value.trim();
	if ( form.loginPwConfirm.value.length == 0 ){
		alert('비밀번호 확인을 입력해주세요.');
		form.loginPwConfirm.focus();		
		return false;
	}  
	
	if ( form.loginPw.value != form.loginPwConfirm.value ){
		alert('로그인 비밀번호 확인이 일치하지 않습니다.');
		form.loginPwConfirm.focus();		
		return false;
	}
	
	form.usrNm.value = form.usrNm.value.trim();
	if ( form.usrNm.value.length == 0 ){
		alert('이름을 입력해주세요.');
		form.usrNm.focus();		
		return false;
	}
	
	if ( form.usrNm.value.length < 2 ){
		alert('이름을 2자이상 입력해주세요');
		form.usrNm.focus();		
		return false;
	}
	
	form.submit();
}
</script>

<form class="con common-form" action="./doJoin" method="POST"
	onsubmit="submitJoinForm(this); return false;">
	<div>
		<span> 아이디 </span>
		<div>
			<input name="loginId" type="text" maxlenght="30" placeholder="아이디" autofocus="autofocus"  >
		</div>
	</div>
	
	<div>
		<span> 비밀번호 </span>
		<div>
			<input name="loginPw" type="password" placeholder="비밀번호" >
		</div>
	</div>
	
	<div>
		<span> 비밀번호 확인 </span>
		<div>
			<input name="loginPwConfirm" type="password" placeholder="비밀번호 확인" >
		</div>
	</div>

	<div>
		<span> 이름 </span>
		<div>
			<input name="usrNm" type="text" maxlenght="100" placeholder="이름" >
		</div>
	</div>
	
	<div>
		<span> 회원가입 </span>
		<div>
			<input type="submit" value="가입">
			<input type="button" value="취소" onclick="history.back();">
		</div>
	</div>
</form>

<%@ include file="../part/foot.jspf" %>