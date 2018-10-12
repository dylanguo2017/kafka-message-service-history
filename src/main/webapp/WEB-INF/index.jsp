<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>ECC PCF Flag</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="well">

<h1> ECC QA Flag for Clients</h1>

</div>

	<form:form modelAttribute="eccParamWrapper" method="post"
		action="/PcfParam/setEccPcfParam">
		<div class="col-xs-6 col-md-4" >
		<table>
			<tr>
				<td><input name="Select All" type="checkbox" id="all" />Select All</td>
			</tr>
			<c:forEach var="list" items="${eccParamWrapper.eccParamResponse}"
				varStatus="status">
				<tr>
					<td><input name="eccParamResponse[${status.index}].client"
						value="${list.client}" /></td>
					<td><form:checkbox
							path="eccParamResponse[${status.index}].flag"
							value="${list.flag}" /></td>
				</tr>

			</c:forEach>

		</table>
		<br />
	
		<form:button value="Submit" class="btn btn-warning">Submit</form:button>
			</div>
	</form:form>


	<script type="text/javascript">
		$("#all").change(function() {
			$("input:checkbox").prop('checked', $(this).prop("checked"));
		});
	</script>
</body>
</html>