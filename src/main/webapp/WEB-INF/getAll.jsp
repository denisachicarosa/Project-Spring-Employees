<!DOCTYPE html>
<%@ page isELIgnored ="false" %>

<html>
<style>
table {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

table td, th {
  border: 1px solid #ddd;
  padding: 8px;
}

table tr:nth-child(even){background-color: #f2f2f2;}

table tr:hover {background-color: #ddd;}

table th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
input {
    outline:none;
    border:none;
}

</style>

<body>

<h2>Employees table</h2>

<form action = "employee_update" method="get">

<table style="width:100%">
  <tr>
    <th>ID      </th>
    <th>Name    </th>
    <th>Salary  </th>
  </tr>

  <tr>
    <td><input type ="text" name="id1" value= ${id1}>          </td>
    <td><input type ="text" name="name1" value= ${name1}>     </td>
    <td><input type ="text" name="salary1" value= ${salary1}>  </td>
  </tr>

  <tr>
     <td><input type ="text" name="id2" value= ${id2}>          </td>
     <td><input type ="text" name="name2" value= ${name2}>     </td>
     <td><input type ="text" name="salary2" value= ${salary2}>  </td>
  </tr>

  <tr>
     <td><input type ="text" name="id3" value= ${id3}>          </td>
     <td><input type ="text" name="name3" value= ${name3}>     </td>
     <td><input type ="text" name="salary3" value= ${salary3}>  </td>
  </tr>

  <tr>
    <td><input type ="text" name="id4" value= ${id4}>          </td>
    <td><input type ="text" name="name4" value= ${name4}>     </td>
    <td><input type ="text" name="salary4" value= ${salary4}>  </td>
  </tr>

  <tr>
    <td><input type ="text" name="id5" value= ${id5}>          </td>
    <td><input type ="text" name="name5" value= ${name5}>     </td>
    <td><input type ="text" name="salary5" value= ${salary5}>  </td>
  </tr>

</table>
<button> Submit </button>
<form>
</body>
</html>
