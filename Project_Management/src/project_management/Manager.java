/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management;

import GUI.Update_EndDate;

/**
 *
 * @author Le Hung
 */
public class Manager extends User implements TaskActionLog{
    boolean isAssign;
    Task task;

    public Manager(){
        isAssign = true;
        task = new Task();
    }
    public Manager(boolean isAssign, Task task, String username, String password, String name, int id) {
        super(username, password, name, id);
        this.isAssign = isAssign;
        this.task = task;
    }

    public Manager(boolean isAssign, Task task) {
        this.isAssign = isAssign;
        this.task = task;
    }

    public boolean isIsAssign() {
        return isAssign;
    }

    public void setIsAssign(boolean isAssign) {
        this.isAssign = isAssign;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
    @Override
    public boolean changeStatus(){
        if (task.status.equals("Created")){
            task.setStatus("Assigned");
            return true;
        }
        else if (task.status.equals("Done")){
            task.setStatus("Close");
            Date end_date = new Date();
            new Update_EndDate(end_date,task.getID(),task.getStatus());
            task.setEndDate(end_date);
            return true;
        }
        return false;
    }
    public String toString(){
        return "-Manager ( name = " + name + ",ID = "+id + " , username = "+username+", password = "+password+")";
    }
}
