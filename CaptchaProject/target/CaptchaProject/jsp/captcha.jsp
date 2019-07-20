<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Captcha</title>

<style>
.error {
	color: red;
}
</style>

</head>

<body bgcolor="#EAEBEE">

	<form:form action="captcha" method="post" >
		<div >
			<table border="0" align="center">
				
					<td>Image#</td>
					<td>
						<div>
							<img id="captcha_id" name="imgCaptcha" src="captcha.jpg">
						</div>
					</td>


					<td align="left"><a href="javascript:;"
						title="change captcha text"
						onclick="document.getElementById('captcha_id').src = 'captcha.jpg?' + Math.random();  return false">
							<img src="images/refresh.png" />
					</a></td>

				</tr>
				<tr>
					<td colspan="2"><form:errors path="captcha" cssClass="error" /></td>
				</tr>

				<tr>
					<td>Enter above Image text#</td>
					<td><form:input path="captcha" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Submit" /></td>
				</tr>

			</table>
		</div>

	</form:form>


</body>
</html>