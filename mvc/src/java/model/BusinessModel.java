package model;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author azmi
 */
public interface BusinessModel {
    public void doBusiness(HttpServletRequest request, HttpServletResponse response, ServletContext ctx) throws IOException;
}
