package model;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 *
 * @author azmi
 */
public class FirstModel implements BusinessModel{
    
    @Override
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) throws IOException{
        PrintWriter out = response.getWriter();
        out.println("<h1>Response from model</h1>");
        Properties prop = (Properties)ctx.getAttribute("mappings.properties");
        out.println(prop.getProperty("name"));
        out.println(prop.getProperty("city"));
    }
}
