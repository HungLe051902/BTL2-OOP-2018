package project_management;

import java.util.ArrayList;

public class Project {

    String name;
    int id;
    int managerId;
    int Number_Current_Task, Number_Completed_Task;
    ArrayList<Integer> employeeIds;
    Manager manager;
    ArrayList<Employee> list_employees;
    ArrayList<Task> task;

    public Project() {
        id = 0;
        Number_Completed_Task=Number_Current_Task=0;
        name = "Project";
        employeeIds = new ArrayList<>();
        manager = new Manager();
        manager.setId(0);
        managerId = manager.getId();
        list_employees = new ArrayList<>();
        task = new ArrayList<>();
    }

    public Project(String name, ArrayList<Integer> employeeIds, Manager manager, ArrayList<Employee> list_employees, ArrayList<Task> task, int id, int Number_Current_Task, int Number_Completed_Task) {
        this.name = name;
        this.employeeIds = employeeIds;
        this.manager = manager;
        this.managerId = manager.getId();
        this.list_employees = list_employees;
        this.task = task;
        this.id = id;
        this.Number_Current_Task = Number_Current_Task;
        this.Number_Completed_Task = Number_Completed_Task;
    }

    public ArrayList<Task> getTask() {
        return task;
    }

    public void setTask(ArrayList<Task> task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
        manager.setId(managerId);
    }

    public ArrayList<Integer> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(ArrayList<Integer> employeeIds) {
        this.employeeIds = employeeIds;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Employee> getList_employees() {
        return list_employees;
    }

    public void setList_employees(ArrayList<Employee> list_employees) {
        this.list_employees = list_employees;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_Current_Task() {
        return Number_Current_Task;
    }

    public void setNumber_Current_Task(int Number_Current_Task) {
        this.Number_Current_Task = Number_Current_Task;
    }

    public int getNumber_Completed_Task() {
        return Number_Completed_Task;
    }

    public void setNumber_Completed_Task(int Number_Completed_Task) {
        this.Number_Completed_Task = Number_Completed_Task;
    }

    public String toString() {
        return "-Project Name : "+ name + "\n"+"-ID project : " + id + "\n-Manager ID : " + managerId + "\n-List ID Employee "+"\n" + employeeIds.toString() + "\n" + manager.toString()
                + " \n" + task.toString() + "\n-List Employee "+"\n" + list_employees.toString() + "\n" + "\n" 
                + "\n                                            ****************                              " +  "\n"
                ;
    }

}
