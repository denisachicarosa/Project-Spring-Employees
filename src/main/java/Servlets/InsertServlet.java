package Servlets;

import Model.EmployeeDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet implements Servlet {
    ServletConfig config = null;

    static Logger log = Logger.getLogger(InsertServlet.class.getName());

    public void init(ServletConfig config) {
        this.config = config;
       log.debug("InsertServlet is initialized");
    }
    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html");
        log.debug("In the service method from InsertServlet");
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("edao");


        log.debug("Try to insert into database");

        String name = req.getParameter("name");
        float salary = Float.parseFloat(req.getParameter("salary"));
        employeeDao.insertEmployee(name, salary);
        log.debug("set attributes");
        req.setAttribute("name", name);
        req.setAttribute("salary", salary);
        req.getRequestDispatcher("WEB-INF/updated.jsp").forward(req, res);

    }

    public void destroy(){System.out.println("UpdateServer is destroyed");}
    public ServletConfig getServletConfig(){return config;}
    public String getServletInfo(){return "copyright 2007-1010";}

}
