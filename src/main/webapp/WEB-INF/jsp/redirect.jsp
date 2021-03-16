<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	var jsAlertMsg = '${jsAlertMsg}';
	
	if (jsAlertMsg){
		alert(jsAlertMsg);
	}
	
	var jsLocationReplaceUrl = '${jsLocationReplaceUrl}';
	
	if (jsLocationReplaceUrl){
		alert(jsLocationReplaceUrl);
	}
	
	var jsHistoryBack = '${jsHistoryBack}' == 'true';
	
	if (jsHistoryBack){
		history.back();
	}
</script>