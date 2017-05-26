<%-- 
    Document   : login
    Created on : May 6, 2017, 12:33:50 AM
    Author     : hclakb
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>




<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
	<style>
	.class1{
	font-size:15px;;
	font-family:Arial,helvetica;
	background-color:#FFFFFF;
	font-weight:bold;
	}
	.button {
    background-color: #cc0000; 
    border:none;
	color: white;
    padding: 6px 9px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 13px;
	font-weight:bold;
	font-family:Arial,helvetica;
	border-radius: 12px;
}
	</style>
    <body>
	<script>
	function hover_submit(id) {

    document.getElementById(id).style.backgroundColor="#1c1e1c";
}
function unhover_submit(id) {
    document.getElementById(id).style.backgroundColor="#cc0000";
}
	</script>

<form name="form1" method="post" action="/XPO_HR_Merit_System/Login_Submit" >
    
	
    <table width="" cellspacing="20" cellpadding="" align="">
	<tr>
	<td width="51%"></td>
	<td>
	<table width="" cellspacing="20" cellpadding="" align=""><tr>
	<td valign="top" style="color:#cc0000;font-size:20">
	<IMG alt="" border=0 height=35 src="WEB-INF/Images/XPO.jpg" hspace="20"><b>Merit Tracker</b>
	</td>
	</tr>
	<tr>
	<td><form:errors path="user.*"/></td>
	</tr>
	<tr>
	<td>${errorMessage}</td>
	</tr>
	<tr>
	<td class="class1">
		Please enter your User Name and Password to proceed.
	</td>
	</tr>
         <tr>
		 <td class="class1">User Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    
                      <input type="text" name="userName" size="18">
					  </td>
					</tr>
                     <tr>
                <td class="class1">Password:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="password" size="19">
                </td>
                            
        </table>
		<p align="center" style="padding-right:120px">
                    <input type="submit" name="Submit" id="Submit" class="button" value="Submit" onmouseover="hover_submit('Submit')" onmouseout="unhover_submit('Submit')">
                </p>  ${message}
				</td></tr>
				</table>
        
    </form>
    </body>
</html>


