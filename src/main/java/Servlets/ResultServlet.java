package Servlets;

import Model.Employee;
import Model.EmployeeDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.InsufficientResourcesException;
import javax.servlet.*;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ResultServlet implements Servlet {
    ServletConfig config = null;

    static Logger log = Logger.getLogger(ResultServlet.class.getName());

    public void init(ServletConfig config) {
        this.config = config;
        System.out.println("Servlet is initialized");
    }


    public void service(ServletRequest req, ServletResponse res) throws IOException,ServletException
    {
        String command = req.getParameter("command");
        if (command.equals("getById")) {
            log.info("Go to doGetById method");
            doGetById(req, res);
        }
        else if (command.equals("getAll")) {
            log.debug("Go to doGetAll method");
            doGetAll(req, res);
        }
        else if (command.equals("insert")) {
            log.debug("Go to insert method");
            insert(req, res);
        }
    }


    public void insert(ServletRequest req, ServletResponse res) throws IOException,ServletException {
        res.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/insert.jsp").forward(req,res);
    }


    public void doGetById(ServletRequest req, ServletResponse res) throws IOException,ServletException {
        res.setContentType("text/html");
        req.getRequestDispatcher("WEB-INF/getById.jsp").forward(req,res);
    }

    public void doGetAll(ServletRequest req, ServletResponse res) throws IOException,ServletException{
        log.info("Start connection with database in doGetAll method");
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        log.info("applicationContext file was loaded: database connection on");

        EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");

        List<Employee> employees = dao.getAllEmployeesRowMapper();

        int i =1;

        Collections.reverse(employees);

        for (int j  = 0 ; j < 6; j++) {
            if (i <= 5) {
                req.setAttribute("id" + i, employees.get(j).getId());
                req.setAttribute("name" + i, employees.get(j).getName());
                req.setAttribute("salary" + i, employees.get(j).getSalary());
                i++;
            }
        }
        log.debug("Parameters were set");
        req.getRequestDispatcher("WEB-INF/getAll.jsp").forward(req,res);
    }


    public void destroy(){System.out.println("servlet is destroyed");}
    public ServletConfig getServletConfig(){return config;}
    public String getServletInfo(){return "copyright 2007-1010";}
}
