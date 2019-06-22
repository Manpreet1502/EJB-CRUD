<%-- 
    Document   : create
    Created on : 18-Jun-2019, 11:45:46 PM
    Author     : Manpreet
--%>

<%@page import="java.util.List"%>
<%@page import="office.Employee"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
        <% if(request.getParameter("id")== null){ %>         
        <h2>Add Employee</h2>
        <form action="entityservlet" method="POST">
            Employee name:-<input type="text" name="name" value="" size="40" /><br>
            Address:-<input type="text" name="address" value="" size="20" /><br>
            Department:-<input type="text" name="dept" value="" size="20" /><br>
                <input type="submit"  value="Add Employee" name="add" /><br>        
                        
        </form>
        
        <%}else{
         Employee employee = (Employee) request.getAttribute("employees");
%>
        <h2>Update Employee</h2>
        <form action="updateservlet" method="POST">
            <input type="hidden" name="id" value="<%=employee.getId()%>">
            Employee name:-<input type="text" name="name" value="<%=employee.getName()%>" size="40" /><br>
            Address:-<input type="text" name="address" value="<%=employee.getAddress()%>" size="20" /><br>
            Department:-<input type="text" name="dept" value="<%=employee.getDept()%>" size="20" /><br>
                <input type="submit"  value="Update Employee" name="add" /><br>        
                        
        </form>
        <%}%>
        
    
</html>
