<%-- 
    Document   : Results
    Created on : May 6, 2017, 9:59:12 PM
    Author     : hclakb
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sun.javafx.font.Metrics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
	<style>
	.class1{
	font-size:10pt;
	font-family:Arial,helvetica;
	background-color:#FFFFFF;
	font-weight:bold;
	font-color:#000000;
	}
.tablevalue th{
border-width: 1px 1px 1px 1px; 
                       border-collapse: collapse; 
                       border-style: solid;
					    border-style: inset; 
                       border-color : #CCCCCC;
                       border-style:solid;

}
.textbox{
border-color:#CCCCCC;
border-collapse:collapse;
border-style:inset;
border:none;
font-weight:normal;
}
	</style>
    <body style="background-color:#f2f2f2">
	<script>
	
	</script>
	<script type="text/javascript">
	/* function update(count){
		
		var total = 0;
		var value;
		var i;
		var rcmsalamt=parseFloat(document.getElementById("recomendedsalaryamt"+count).value);
		var cursal= parseFloat(document.getElementById("currentsalary_"+count).value);
		var adjbudget= document.getElementById("Adj_budget").value;
		var totalspend= document.getElementById("total_spend").value;
		document.getElementById("salaryaftermerit_"+count).value = cursal + rcmsalamt;
                document.getElementById("salaryaftermerit"+count).value = cursal + rcmsalamt;
		var percal= (rcmsalamt/cursal)*100;
		document.getElementById("receomendedsalarypercentage_"+count).value= percal.toFixed(2);
                document.getElementById("receomendedsalarypercentage"+count).value= percal.toFixed(2);
		
		for (i=0 ; i < document.getElementById("iteration_cnt").value ; i++){
			value = parseFloat(document.getElementById("recomendedsalaryamt"+i).value);
			total = total + value;
			
		}
		
		
		document.getElementById("total_spend").value = total.toFixed(2);
		
		var budget_over = adjbudget - total;
		document.getElementById("budget_over").value= budget_over.toFixed(2);
		if (budget_over > 0){
			document.getElementById("budget_over").style.color="#008000";		
		}else {
			document.getElementById("budget_over").style.color="#ff0000";
		}
		
	} */
	
	</script>
	
	<form method="post" action="/XPO_HR_Merit_System/merit/saveEmpMeritDetails.html" modelAttribute="empMeritDetailsListBean">
	
	<form:select path="directManagersName">
                      <form:option value="" label="...." />
                      <form:options items="${directManagers}" />
</form:select>
	
	
	</form>
	<form method="post" action="/XPO_HR_Merit_System/merit/saveEmpMeritDetails.html" modelAttribute="empMeritDetailsListBean">
	<span style="background-color:#CC0000;float:right;padding-left:68%" >
    
    
    <table>
      <tr>


          <td><table><tr> <td id="welcome" width="800" style="color:#FFFFFF;font-size:12px;font-family:Arial,helvetica;padding:0px 0 0 0px">Welcome, ${UserName}   </td></tr></table></td>
        <td> <img src="Images/XPO_LOGO.jpg" style="padding:0px 0 0 0" width="132" height="32" id="logoXPO" /> </td>
      </tr>
    </table>
 
</span> 

           <c:set var="appraiserStage" value="${AppraiserStage}"/>
           <c:set var="reviewerStage"  value="${ReviewerStage}"/>
           <c:set var="counter" value="0" />
            <c:forEach items="${empMeritDetailsListBean.empMeritDetail}" var="empMeritDetail">
                <c:set var="counter" value="${counter+empMeritDetail.targetSalary}" /> 
            </c:forEach>
            <c:set var="rcmdsalary" value="0" />
            <c:forEach items="${empMeritDetailsListBean.empMeritDetail}" var="empMeritDetail">
                <c:set var="rcmdsalary" value="${rcmdsalary+empMeritDetail.recommendedSalAmt}" />      
            </c:forEach> 
			</br></br></br></br></br>
            <table border="0" align="center" id="Overall_Values" class="class1">
            <tr>
                <td ><input class="textbox" type="text" disabled id="Adj_budget" name="Adj_budget" value="${counter}"/></td>
                <td>Formalized Adjustment Budget</td>
            </tr>
            <tr>
                <td><input class="textbox" type="text" disabled id="total_spend" name="total_spend" value="${rcmdsalary}"/></td>
                <td>Total Spend</td>
            </tr>
            <tr>
                <td><input  class="textbox" type="text" disabled id="budget_over" name="budget_over" value="${counter-rcmdsalary}"/></td>
                <td>BUDGET OVER (+) OR UNDER (-)</td>
            </tr>
        </table>
        <br><br><br><br>
        <div align="center"><a href="/XPO_HR_Merit_System/merit/export">Export</a></div>
        <br><br>
        <div style="overflow:scroll">
		<table border="0" align="" id="Line_values" class="class1 tablevalue">
                    <thead>
            <tr>
<th rowspan="3" colspan="1">S No</th>
<th rowspan="3" colspan="1">Employee ID</th>
<th rowspan="3" colspan="1">First Name</th>
<th rowspan="3" colspan="1">Last Name</th>
<th rowspan="3" colspan="1">Direct Manager</th>
<th rowspan="3" colspan="1">1st Level</th>
<th rowspan="3" colspan="1">2nd Level</th>
<th rowspan="3" colspan="1">3rd Level</th>
<th rowspan="3" colspan="1">Job Title</th>
<th rowspan="3" colspan="1">Hire Date</th>
<th rowspan="3" colspan="1">Performance Survey</th>
<th rowspan="3" colspan="1">Current Salary</th>
<th rowspan="3" colspan="1">Target Amount</th>
<th rowspan="3" colspan="1">Target Percentage</th>
<th rowspan="3" colspan="1">Recommended Salary Percentage</th>
<th rowspan="3" colspan="1">Recommended Salary AMT</th>
<th rowspan="3" colspan="1">Salary after merit</th>
<th rowspan="3" colspan="1">Last Salary Hike Date</th>
<th rowspan="3" colspan="1">Merit Cycle</th>
<th rowspan="3" colspan="1">Merit System</th>
<th rowspan="3" colspan="1">Organization</th>
            </tr>
        </thead>
        <tbody>
<%-- <c:set var="cnt" value="0" /> --%>
               <c:forEach items="${empMeritDetailsListBean.empMeritDetail}" var="empMeritDetail" varStatus="status">
                 
        <tr class="textbox">
            <td align="center">${status.count}</td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].empId" value="${empMeritDetail.empId}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].firstName" value="${empMeritDetail.firstName}"/>
            </td>
            <td style="background-color:#E3EDF1"  >
            <input name="empMeritDetail[${status.index}].lastName" value="${empMeritDetail.lastName}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].directManager" value="${empMeritDetail.directManager}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].l1Manager" value="${empMeritDetail.l1Manager}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].l2Manager" value="${empMeritDetail.l2Manager}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].l3Manager" value="${empMeritDetail.l3Manager}"/>
            </td>
            <td style="background-color:#E3EDF1" > 
            <input name="empMeritDetail[${status.index}].jobTitle" value="${empMeritDetail.jobTitle}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].hireDate" value="${empMeritDetail.hireDate}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].performanceSurvey" value="${empMeritDetail.performanceSurvey}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].currentSalary" value="${empMeritDetail.currentSalary}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].targetSalary" value="${empMeritDetail.targetSalary}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].targetPercentage" value="${empMeritDetail.targetPercentage}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input type="text" class="textbox"  name ="empMeritDetail[${status.index}].recommendedSalPerc"
                               value="<c:out value="${empMeritDetail.recommendedSalPerc}" />" />
            </td>                               
            <td style="background-color:#FFFFFF" >
            <input type="text" class="textbox"  name="empMeritDetail[${status.index}].recommendedSalAmt"
                               value="<c:out value="${empMeritDetail.recommendedSalAmt}" />" onchange="update(${cnt})"/>
             </td>
            <td style="background-color:#E3EDF1" >
            <input type="text" class="textbox"  name ="empMeritDetail[${status.index}].salAfterMerit"
                               value="<c:out value="${empMeritDetail.salAfterMerit}" />" />
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].lastSalaryHikeDate" value="${empMeritDetail.lastSalaryHikeDate}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].meritCycle" value="${empMeritDetail.meritCycle}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].meritSystem" value="${empMeritDetail.meritSystem}"/>
            </td>
            <td style="background-color:#E3EDF1" >
            <input name="empMeritDetail[${status.index}].organization" value="${empMeritDetail.organization}"/>
            </td>
        </tr>
        
		
    </c:forEach>
	  
        </tbody>
        </table>
	</div>
	                    <input type="submit" name="Submit" id="Submit" class="button" value="Submit" onclick="validate()">
        </form>
</html>
