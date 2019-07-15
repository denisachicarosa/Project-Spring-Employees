<!DOCTYPE html>
<%@ page isELIgnored ="false" %>
<html>
<body>
<h2>Table employees</h2>
<form action="employee" method="get" >
    <p>Choose your command: </p>
    <input type="radio" name="command" value="getById" > get employee by id<br>
    <input type="radio" name="command" value="getAll"> get all employees<br>
    <input type="radio" name="command" value="insert"> insert employee <br>

    <p> Employee added: <p>
    <p> Name:- ${name} </p>
    <p> Salary:- ${salary} </p>

    <button>done</button>
</form>
</body>
</html>
