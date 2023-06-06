package controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BusinessModel;
import java.util.*;
import java.io.*;

/**
 *
 * @author azmi
 */
public class FrontController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @throws ServletException if a servletx-specific error occurs
     */

    @Override
    public void init(ServletConfig conf) throws ServletException {
        try {
            InputStream is = conf.getServletContext().getResourceAsStream("/WEB-INF/mappings.properties");
            Properties prop = new Properties();
            prop.load(is);
            conf.getServletContext().setAttribute("mappings.properties", prop);
            super.init(conf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InstantiationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FrontController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");

            Properties prop = (Properties) getServletContext().getAttribute("mappings.properties");
            out.println(prop.getProperty("name"));

            String type = request.getParameter("type").trim();
            String page = request.getParameter("page").trim();
            out.print(page + " " + type);
            if (type.equals("view")) {
                request.getRequestDispatcher("/WEB-INF/pages/" + page + ".jsp").forward(request, response);
            } else if (type.equals("model")) {
                try {
                    BusinessModel fd = (BusinessModel) Class.forName("model." + page).newInstance();
                    fd.doBusiness(request, response,getServletContext());
                } catch (ClassNotFoundException cnf) {
                    cnf.printStackTrace();
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servletx request
     * @param response servletx response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servletx request
     * @param response servletx response
     * @throws ServletException if a servletx-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (InstantiationException ex) {
            Logger.getLogger(FrontController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Returns a short description of the servletx.
     *
     * @return a String containing servletx description
     */

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
