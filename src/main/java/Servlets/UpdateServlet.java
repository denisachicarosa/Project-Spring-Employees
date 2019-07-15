package Servlets;

import Model.Employee;
import Model.EmployeeDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateServlet implements Servlet {

    ServletConfig config = null;

    static Logger log = Logger.getLogger(UpdateServlet.class.getName());

    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("UpdateServlet is initialized");
    }


    public void service(ServletRequest req, ServletResponse res) throws IOException, ServletException
    {
        log.debug("UpdateServlet's service method");
        res.setContentType("text/html");
        int id;
        String name = "";
        float salary = 0;
        int i =0;
        log.debug("get parameters in UpdateServlet");
        for (i = 1; i < 6; i++) {

            id = Integer.parseInt(req.getParameter("id" + i));
            log.debug("info to update id = " + id);
            name = req.getParameter("name" + i);
            log.debug("info to update name = " + name);
            salary = Float.parseFloat(req.getParameter("salary" + i));
            log.debug("info to update salary = " + salary);
            Employee e = new Employee(id, name, salary);
            doPost(e);

            log.debug("exit doPost in UpdateServlet");
        }


        req.getRequestDispatcher("WEB-INF/updated.jsp").forward(req,res);

    }


    public void doPost(Employee e) {

        log.debug("In the doPost method from UpdateServlet");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao = (EmployeeDao) ctx.getBean("edao");

        log.debug("Try to update database");
        employeeDao.updateEmployee(e);

    }



    public void destroy(){System.out.println("UpdateServer is destroyed");}
    public ServletConfig getServletConfig(){return config;}
    public String getServletInfo(){return "copyright 2007-1010";}
}
