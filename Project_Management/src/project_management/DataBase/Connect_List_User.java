
package project_management.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project_management.CEO;
import project_management.Employee;
import project_management.Manager;
import project_management.Project;
import project_management.Task;
import project_management.User;


public class Connect_List_User {

    public Connect_List_User() {
    }
    
    public ArrayList<CEO> ceo_ = new ArrayList<>();
    public ArrayList<Employee> employees_ = new ArrayList<>();
    public ArrayList<Manager> managers_ = new ArrayList<>();
    public void ReadFromSQLite(){
        DAO dao = new DAO();
        String sqlite = "SELECT * FROM tbl_ListUser";
        try {
            PreparedStatement ps = dao.conn.prepareStatement(sqlite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt("ID")>=1000000){
                   CEO ceo1 = new CEO(true,rs.getString("Username"),rs.getString("Password"),rs.getString("Name"),rs.getInt("ID"));
                   ceo_.add(ceo1);
               }
                if (rs.getInt("ID")<=999999&&rs.getInt("ID")>=100000){
                   Task task = new Task();
                   Manager m = new Manager(true,task,rs.getString("Username"),rs.getString("Password"),rs.getString("Name"),rs.getInt("ID"));
                   managers_.add(m);
               }
                if (rs.getInt("ID")<=99999){
                   ArrayList<Integer> list_project_participation = new ArrayList<>();
                   Employee em = new Employee(list_project_participation, rs.getString("Username"),rs.getString("Password"),rs.getString("Name"),rs.getInt("ID"));
                   employees_.add(em);
               }
                
               
               
               
               
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
