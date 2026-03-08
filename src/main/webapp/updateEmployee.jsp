<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.employee.Employee" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Employee</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h2>Update Employee</h2>
    <%
        Employee emp = (Employee) request.getAttribute("employee");
        if (emp == null) {
    %>
    <p>Employee not found</p>
    <p><a href="view">Back to list</a></p>
    <%
        } else {
    %>
    <form action="edit" method="post">
        <input type="hidden" name="empid" value="<%= emp.getEmpid() %>" />
        <label>First Name:</label><br/>
        <input type="text" name="firstname" value="<%= emp.getFirstname() %>" required/><br/>
        <label>Last Name:</label><br/>
        <input type="text" name="lastname" value="<%= emp.getLastname() %>" required/><br/>
        <label>Primary Skill:</label><br/>
        <input type="text" name="primaryskill" value="<%= emp.getPrimaryskill() %>"/><br/>
        <label>Location:</label><br/>
        <input type="text" name="location" value="<%= emp.getLocation() %>"/><br/>
        <button type="submit">Update</button>
    </form>
    <p><a href="view">Back to list</a></p>
    <%
        }
    %>
</div>
</body>
</html>
