package model;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author azmi
 */
public class FirstModel implements BusinessModel{
    public void doBusiness(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Response from model</h1>");
    }
}
