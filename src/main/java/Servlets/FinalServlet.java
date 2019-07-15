package Servlets;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.io.Serializable;

public class FinalServlet implements Servlet {
    ServletConfig config = null;

    static Logger log = Logger.getLogger(FinalServlet.class.getName());

    public void init(ServletConfig config) {
        this.config = config;
        log.debug("FinalServlet is initialized");
    }

    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/final.jsp").forward(req,res);

    }

    public void destroy() {
        System.out.println("FinalServlet is destroyed");
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public String getServletInfo() {
        return "copyright 2007-1010";
    }

}
