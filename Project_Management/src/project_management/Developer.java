/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management;

import java.util.ArrayList;

/**
 *
 * @author Le Hung
 */
public class Developer extends Employee implements TaskActionLog{
    Task task;

    public Developer(){
        task = new Task();
    }
    public Developer(Task task) {
        this.task = task;
    }

    public Developer(Task task, ArrayList<Integer> list_project_participation, String username, String password, String name, int id) {
        super(list_project_participation, username, password, name, id);
        this.task = task;
    }

    public Developer(Task task, ArrayList<Integer> list_project_participation) {
        super(list_project_participation);
        this.task = task;
    }

   
    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    /**
     *
     */
    @Override
    public boolean changeStatus(){
        if (task.status.equals("Assigned")){
            task.setStatus("Started");
            return true;
        }
        else if (task.status.equals("Started")){
            task.setStatus("Completed");
            return true;
        }
        else if (task.status.equals("Reject")){
            task.setStatus("Started");
            return true;
        }
        return false;
    }
    public String toString(){
        return "Developer ( name = " + name+ ",ID = " + id+"List IDproject participant : "+list_IDproject_participation.toString()+ " )\n";
    }
}
