<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.employee.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Employees</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h2>Employees</h2>
    <table>
        <tr>
            <th>EmpID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Primary Skill</th>
            <th>Location</th>
            <th>Actions</th>
        </tr>
        <%
            List<Employee> list = (List<Employee>) request.getAttribute("employees");
            if (list != null) {
                for (Employee emp : list) {
        %>
        <tr>
            <td><%= emp.getEmpid() %></td>
            <td><%= emp.getFirstname() %></td>
            <td><%= emp.getLastname() %></td>
            <td><%= emp.getPrimaryskill() %></td>
            <td><%= emp.getLocation() %></td>
            <td>
                <a href="edit?empid=<%= emp.getEmpid() %>">Edit</a> |
                <a href="delete?empid=<%= emp.getEmpid() %>" onclick="return confirm('Are you sure?');">Delete</a>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>
    <p><a href="index.jsp">Back to Home</a></p>
</div>
</body>
</html>
