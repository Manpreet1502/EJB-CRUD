<%-- 
    Document   : list
    Created on : 18-Jun-2019, 11:43:28 PM
    Author     : Manpreet
--%>

<%@page import="office.Employee"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Employee Dashboard</h1>
         
         
         <% try{
            List<Employee> list = (List<Employee>) request.getAttribute("employees");  %>
            
            <table border = 1>
                <th>Name</th>
                 <th>Address</th>
                 <th>Department</th>  
                <%
                for(Employee ls: list){ %>
                 <tr><td><%=ls.getName()%></td>
                 <td><%=ls.getAddress()%></td>
                 <td><%=ls.getDept()%></td>
                 <td><a href="deleteservlet?id=<%=ls.getId()%>">Delete</a></td> 
                 <td><a href="updateservlet?id=<%=ls.getId()%>">Update</a></td></tr>  
                 
          <%}
            }catch(Exception e){
                e.printStackTrace();
            }%> 
            <a href="create.jsp">Add Employee</a>
           

    </body>
</html>
