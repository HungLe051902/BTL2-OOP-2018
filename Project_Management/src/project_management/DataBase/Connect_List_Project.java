package project_management.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project_management.Employee;
import project_management.Manager;
import project_management.Project;
import project_management.Task;
import project_management.User;

public class Connect_List_Project {

    public ArrayList<Project> project = new ArrayList<>();
    Connect_List_User c = new Connect_List_User();
    DAO dao ;

    public Connect_List_Project() {
        c.ReadFromSQLite();
        dao = new DAO();
    }

    public void ReadFromSQLite() {
        
        String sqlite = "SELECT * FROM tbl_ListProject";
        Connect_List_Task con_task = new Connect_List_Task();
        con_task.ReadFromSQLite();
        try {
            PreparedStatement ps = dao.conn.prepareStatement(sqlite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                ArrayList<Integer> employeeIds = new ArrayList<>();
//                employeeIds.add(0);
//                ArrayList<Task> task = new ArrayList<>();
//                Manager manager = new Manager();
//                ArrayList<Employee> list_employees = new ArrayList<>();
                Project a = new Project();
                a.setName(rs.getString("Project_Name"));
                a.setManagerId(rs.getInt("Manager_ID"));
                FindAndSetManager(a, a.getManagerId());
                a.setId(rs.getInt("idx"));
                for (Task t : con_task.task) {
                    if (t.getProjectId() == a.getId()) {
                        addIDemployee(t.getDeveloperIds(), a);
                        addIDemployee(t.getTesterIds(), a);
                        a.getTask().add(t);

                    }
                    for (Employee us : c.employees_) {
                        if (a.getEmployeeIds().contains(us.getId())) {
                            if (!us.getList_IDproject_participation().contains(a.getId())) {
                                us.getList_IDproject_participation().add(a.getId());
                            }
                        }
                    }
                }
                a.setNumber_Current_Task(rs.getInt("Number_Current_Task"));
                a.setNumber_Completed_Task(rs.getInt("Number_Task_Completed"));
                AddEmployeeAndManager(a);

                project.add(a);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        for (Task t : con_task.task) {
            for (Project pr : project) {
                for (Employee us : c.employees_) {
                    if (pr.getEmployeeIds().contains(us.getId())) {
                        if (!us.getList_IDproject_participation().contains(pr.getId())) {
                            us.getList_IDproject_participation().add(pr.getId());
                        }
                    }
                }
            }
        }
        //System.out.println(project.toString());
    }

    public static void addIDemployee(ArrayList<Integer> x, Project a) {
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
    public static void AddProjectToSQLite(Project p){
        DAO d = new DAO();
        String sqlite = "INSERT INTO tbl_ListProject (idx,Project_Name,Manager_Name,Status,Number_Current_Task,Number_Task_Completed,Manager_ID)" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = d.conn.prepareStatement(sqlite);
            ps.setInt(1, p.getId());
            ps.setString(2,p.getName());
            ps.setString(3, p.getManager().getName());
            ps.setString(4,"Doing");
            ps.setInt(5,p.getNumber_Current_Task() );
            ps.setInt(6, p.getNumber_Completed_Task());
            ps.setInt(7, p.getManagerId());
            ps.executeUpdate();
            d.conn.close();
           
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
