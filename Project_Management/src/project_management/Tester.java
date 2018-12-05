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
public class Tester extends Employee implements TaskActionLog{
    boolean isAssign;
    Task task;

    
    @Override
    public boolean changeStatus(){
        if (task.getStatus().equals("Completed")){
            task.setStatus("Done");
            return true;
        }
        return false;
    }

    public Tester (){
        isAssign = true;
        task = new Task();
    }
    public Tester(boolean isAssign, Task task) {
        this.isAssign = isAssign;
        this.task = task;
    }

    public Tester(boolean isAssign, Task task, ArrayList<Integer> list_project_participation, String username, String password, String name, int id) {
        super(list_project_participation, username, password, name, id);
        this.isAssign = isAssign;
        this.task = task;
    }

    public Tester(boolean isAssign, Task task, ArrayList<Integer> list_project_participation) {
        super(list_project_participation);
        this.isAssign = isAssign;
        this.task = task;
    }
    public String toString(){
        return "Tester ( name = " + name+ ",ID = " + id+"List IDproject participant : "+list_IDproject_participation.toString()+ " )\n";
    }
    
    
}
