/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import office.Employee;
import office.EmployeeFacadeLocal;

/**
 *
 * @author Manpreet
 */
@WebServlet(urlPatterns = {"/updateservlet"})
public class updateservlet extends HttpServlet {

    
    @EJB
    EmployeeFacadeLocal empFacadeLocal;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
       if(request.getParameter("id")!=null){
           String getId = request.getParameter("id");
           long sid = Long.parseLong(getId);
            Long id = new Long(sid);
           Employee employee= empFacadeLocal.find(id);
          request.setAttribute("employees", employee);
          request.getRequestDispatcher("create.jsp").forward(request, response);
       }
        }catch(Exception e){
          e.printStackTrace();
         }
           
       
               
               
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Employee employee =  new Employee();
            String id = request.getParameter("id");            
             employee.setId(Long.parseLong(id));
            employee.setName(request.getParameter("name"));
            employee.setAddress(request.getParameter("address"));
            employee.setDept(request.getParameter("dept"));
            empFacadeLocal.edit(employee);
            List<Employee> empList = empFacadeLocal.findAll();
            request.setAttribute("employees", empList);
            request.getRequestDispatcher("list.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
