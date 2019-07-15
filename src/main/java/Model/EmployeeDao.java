package Model;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class EmployeeDao {
    private JdbcTemplate template;
    static Logger log = Logger.getLogger(EmployeeDao.class.getName());

    public void setJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<Employee> getAllEmployeesRowMapper(){
        log.info("Get all employees method");

        return template.query("select * from employee ",new RowMapper<Employee>(){
            @Override
            public Employee mapRow(ResultSet rs, int rownumber) throws SQLException {
                log.debug("select method is running");
                Employee e=new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getInt(3));
                log.info("result: id = " + e.getId() + " name = " + e.getName()+" salary = " + e.getSalary());
                return e;
            }
        });
    }


    public List<Employee> getEmployeeById (Integer id) {
        log.debug("Searching for employee id = " + id);
        return template.query
                ("SELECT * FROM employee WHERE id = ?",
                        new Object[]{id}, new RowMapper<Employee>() {
                            @Override
                            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                                log.debug("select method is running");
                                Employee e=new Employee();
                                e.setId(resultSet.getInt(1));
                                e.setName(resultSet.getString(2));
                                e.setSalary(resultSet.getInt(3));
                                log.debug("result: id = " + e.getId() + " name = " + e.getName()+" salary = " + e.getSalary());
                                return e;
                            }
                        });

    }

    public Integer updateEmployee (Employee employee) {

        System.out.println("update employee id = " + employee.getId());
        log.debug("Update employee with id = " + employee.getId());
        String updateQuery = "UPDATE employee SET name = ?, salary = ? WHERE id = ? ";
        Object[] params = {employee.getName(), employee.getSalary(), employee.getId()};
        int[] types = {Types.VARCHAR, Types.INTEGER, Types.INTEGER};
        return template.update(updateQuery, params, types);

    }

    public Integer insertEmployee (String name, Float salary) {
        log.debug("Insert employee with name = " + name + " and salary = "+salary);
        String insertQuery = "INSERT INTO employee ( name, salary ) VALUES (?, ?)";
        Object[] params = {name, salary};
        int[] types = {Types.VARCHAR, Types.FLOAT};

        return template.update(insertQuery, params, types);
    }
}