<!DOCTYPE HTML>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en-US">
<head>
  <meta charset="UTF-8">
	<title>File Format Management</title>
	<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/themes/pepper-grinder/jquery-ui.css" media="screen" rel="stylesheet" type="text/css">
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.0/jquery.min.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.2/jquery-ui.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="lib/jquery.ui.core.js"></script>
	<script type="text/javascript" src="lib/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery-ui-form.js"></script>
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript">
		$(function()
		{
			//$("#customtheme").form();
		});

		$('document').ready(function() {
				$('.eventTrig').click(function(me) {
									if( $(this).val() == 'searchByTitle') {
										$('#titleBlock').show();
										$('#departmentBlock').hide();
									}
									else if( $(this).val() == 'searchByDepartment') {
											$('#departmentBlock').show();
											$('#titleBlock').hide();
									}else {
										$('#departmentBlock').hide();
										$('#titleBlock').hide();
									}	
								});
		});
	</script>
	
	<style>
.block {
display: block;
}
</style>
</head>
<body>
	<div id="container">
		<h1>Search Employees</h1>
		<form:form  method="post" action="searchEmployee.htm" id="customtheme">
			
			
			<label class="block"><input type="radio" class="eventTrig" name="radgroup" value="searchEmployees">Search All Employees</label>
			<label class="block"><input type="radio" class="eventTrig" name="radgroup" value="searchDepartment">Search All Departments</label>
			<label class="block"><input type="radio" class="eventTrig" name="radgroup" value="searchByTitle">Search By Titles</label>
			<label class="block"><input type="radio" class="eventTrig" name="radgroup" value="searchByDepartment">Search By Department</label>
			
			<p id="titleBlock" style="text-align: center; display:none;">
				<label for="title">Title</label>
				<select name="title" id="title">
					<option value="Engineer">Engineer</option>
					<option value="Staff">Staff</option>
					<option value="Assistant Engineer">Assistant Engineer</option>
					<option value="Technique Leader">Technique Leader</option>
				</select>
			</p>

			<p id="departmentBlock" style="text-align: center; display:none;" >
				<label for="department">Department</label>
				
				<%--<form:select path="titles">
				     <form:options items="${titles}"/>
				</form:select>
				
				--%>
				<select name="department" id="department">
					<option value="d005">Development</option>
					<option value="d002">Finance</option>
					<option value="d001">Marketing</option>
					<option value="d004">Production</option>
				</select>
			
			
			</p>
			
			<p style="text-align: center;">
				<label for="title">Document Format</label>
				<select name="format" id="format">
					<option value="13">PDF</option>
					<option value="0">Excel</option>
					<option value="12">HTML</option>
					<option value="-1">Image</option>
				</select>
			</p>
			<%if( Boolean.valueOf(request.getAttribute("showDownload").toString())==true) {%>
               <p style="text-align: center;"><a href="download.htm?filePath=<%=request.getAttribute("filePath").toString() %>">Click here to download file</a></p>
			<%} %>
			<p style="text-align: center;">
				<input type="submit" name="submit" value="Submit" id="submitbutton" />
			</p>
		</form:form>
	</div>
</body>
</html>