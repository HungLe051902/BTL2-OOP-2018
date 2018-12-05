/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_management.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import project_management.Employee;
import project_management.Manager;
import project_management.Project;
import project_management.Task;
import project_management.User;

/**
 *
 * @author Le Hung
 */
public class Connect_Project {

    public ArrayList<Project> project = new ArrayList<>();
    Connect_List_User c = new Connect_List_User();

    public Connect_Project() {

        c.ReadFromSQLite();
        System.out.println(c.employees_.toString());
    }

    public void ReadFromSQLite() {
        System.out.println("dsfsd");
        DAO dao = new DAO();
        String sqlite = "SELECT * FROM tbl_ListProject";
        Connect_List_Task con = new Connect_List_Task();
        con.ReadFromSQLite();
        try {
            PreparedStatement ps = dao.conn.prepareStatement(sqlite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("dfsd");
                Project a = new Project();
                a.setName(rs.getString("Project_Name"));
                a.setManagerId(rs.getInt("Manager_ID"));
                FindAndSetManager(a, a.getManagerId());
                a.setId(rs.getInt("idx"));

                //a.setTask(con_task.task);
                for (Task t : con.task) {
                    if (t.getProjectId() == a.getId()) {
                        addIDemployee(t.getDeveloperIds(), a);
                        addIDemployee(t.getTesterIds(), a);
                        a.getTask().add(t);
                        //AddEmployeeAndManager(a);
                    }
//                    for (Employee us : c.employees_) {
//                        if (a.getEmployeeIds().contains(us.getId())) {
//                            if (!us.getList_IDproject_participation().contains(a.getId())) {
//                                us.getList_IDproject_participation().add(a.getId());
//                            }
//                        }
//                    }
                }
                //System.out.println(c.employees_.toString());
//                for (Employee u : c.employees_) {
//                    System.out.println(u.toString());
//                    //System.out.println("1212121212");
//                    if (a.getEmployeeIds().contains(u.getId())) {
//                        System.out.println(u.toString());
//                        a.getList_employees().add(u);
//                    }
//
//                }
                a.setNumber_Current_Task(rs.getInt("Number_Current_Task"));
                a.setNumber_Completed_Task(rs.getInt("Number_Task_Completed"));

                //
                System.out.println(a.toString());
//                System.out.println(a.toString());
//                System.out.println("23");
//                project.add(a);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addIDemployee(ArrayList<Integer> x, Project a) {
        for (Integer k : x) {
            if (!a.getEmployeeIds().contains(k)) {
                a.getEmployeeIds().add(k);
            }

        }
    }

    public void AddEmployeeAndManager(Project a) {

        for (Employee u : c.employees_) {
            if (a.getEmployeeIds().contains(u.getId())) {
                a.getList_employees().add(u);
            }

        }
//        for (Manager m:c.managers_){
//            if (m.getName().equals(a.getManager().getName())){
//                a.setManager(m);
//                break;
//            }
//        }
    }

    public void FindAndSetManager(Project a, int id) {
        for (Manager m : c.managers_) {
            if (m.getId() == id) {
                a.setManager(m);
                break;
            }
        }
    }
}
