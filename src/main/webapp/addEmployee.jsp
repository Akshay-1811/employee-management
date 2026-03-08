<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
    <h2>Add Employee</h2>
    <form action="add" method="post">
        <label>Employee ID:</label><br/>
        <input type="text" name="empid" required/><br/>
        <label>First Name:</label><br/>
        <input type="text" name="firstname" required/><br/>
        <label>Last Name:</label><br/>
        <input type="text" name="lastname" required/><br/>
        <label>Primary Skill:</label><br/>
        <input type="text" name="primaryskill"/><br/>
        <label>Location:</label><br/>
        <input type="text" name="location"/><br/>
        <button type="submit">Save</button>
    </form>
    <p><a href="index.jsp">Back to Home</a></p>
</div>
</body>
</html>
