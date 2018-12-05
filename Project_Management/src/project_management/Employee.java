
package project_management;

import java.util.ArrayList;

public class Employee extends User{
    ArrayList<Integer> list_IDproject_participation = new ArrayList<>();

    public Employee(){
        list_IDproject_participation = new ArrayList<>();
    }
    public Employee(ArrayList<Integer> list_project_participation, String username, String password, String name, int id) {
        super(username, password, name, id);
        this.list_IDproject_participation = list_IDproject_participation;
    }

    public Employee(ArrayList<Integer> list_project_participation) {
        this.list_IDproject_participation = list_IDproject_participation;
    }
    public String toString(){
        String k;
        if (id<9999){
           k = "Developer";
        }
        else {
           k = "Tester";
        }
        return  k+ "( ID = "+id+", username = "+username+",password = " + password+", name = "+name+"List IDproject : "+list_IDproject_participation.toString()+" )\n"
                ;
    }

    public ArrayList<Integer> getList_IDproject_participation() {
        return list_IDproject_participation;
    }

    public void setList_IDproject_participation(ArrayList<Integer> list_IDproject_participation) {
        this.list_IDproject_participation = list_IDproject_participation;
    }
    
    
    
}
