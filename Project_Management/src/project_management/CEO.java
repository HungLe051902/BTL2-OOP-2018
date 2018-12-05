/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management;

/**
 *
 * @author Le Hung
 */
public class CEO extends User{
    boolean isAssignForManager;

    public CEO(){
        isAssignForManager = false;
    }
    public CEO(boolean isAssignForManager, String username, String password, String name, int id) {
        super(username, password, name, id);
        this.isAssignForManager = isAssignForManager;
    }

    public CEO(boolean isAssignForManager) {
        this.isAssignForManager = isAssignForManager;
    }


    public boolean isIsAssignForManager() {
        return isAssignForManager;
    }

    public void setIsAssignForManager(boolean isAssignForManager) {
        this.isAssignForManager = isAssignForManager;
    }
    public void CreateNewUser(){
        
    }
    public String toString(){
        return "CEO ( username = "+username+",password = "+password
                +", name = "+name+")";
    }
}
