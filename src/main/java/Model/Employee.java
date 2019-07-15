package Model;

public class Employee {
    private int id;
    private String name;

    public Employee() {
    }

    private float salary;

    public Employee(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    //no-arg and parameterized constructors
//getters and setters
    public String toString(){
        return id+" "+name+" "+salary;
    }
}