package Servlets;

import Model.Employee;
import Model.EmployeeDao;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class ByIdServlet implements Servlet {

    static Logger log = Logger.getLogger(ByIdServlet.class.getName());

    ServletConfig config = null;


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = config;
        log.debug("ByIdServlet is initialized");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        doGet(servletRequest,servletResponse);
    }

    public void doGet(ServletRequest req, ServletResponse res) throws IOException,ServletException {
        res.setContentType("text/html");
        Integer id = Integer.parseInt(req.getParameter("id"));

        Employee employee = getEmployee(id);

        req.setAttribute("id", employee.getId());
        req.setAttribute("name", employee.getName());
        req.setAttribute("salary", employee.getSalary());

        req.getRequestDispatcher("WEB-INF/page.jsp").forward(req,res);

    }

    public Employee getEmployee(Integer id) {
        log.info("Start connection with database");
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");

        log.info("applicationContext file was loaded: database connection on");

        EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");

        List<Employee> employeeById = dao.getEmployeeById(id);

        return employeeById.get(0);
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        log.debug("ByIdServlet is destroyed");
    }
}
