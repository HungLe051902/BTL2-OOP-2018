
package project_management.DataBase;

import GUI.AssignTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.sqlite.SQLiteException;
import project_management.Date;
import project_management.Task;
import project_management.User;

public class DAO {
    protected Connection conn;
    
    public DAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Le Hung\\Downloads\\Project Management");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void editWord(String status,int ID_task) throws SQLException {
        String sqlite = "update tbl_ListTask set Status =? where ID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlite);
            preparedStatement.setInt(2, ID_task);
            preparedStatement.setString(1, status);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
        }
    }
    public void editTask(String DevloperIDs,String TesterIDs ,int ID_task) throws SQLException {
        String sqlite = "update tbl_ListTask set DeveloperIDs = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlite);
            //preparedStatement.setString(2, TesterIDs);
            preparedStatement.setString(1, DevloperIDs);
            preparedStatement.setInt(2, ID_task);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
        }
        sqlite = "update tbl_ListTask set TesterIDs = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlite);
            preparedStatement.setString(1,TesterIDs);
            preparedStatement.setInt(2, ID_task);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
        }
    }
    public void CreateTask(Task new_task){
        String sqlite = "INSERT INTO tbl_ListTask (ID,ProjectID,DeveloperIDs,TesterIds,CreateDate,EndDate,Status)" + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlite);
            ps.setInt(1, new_task.getID());
            ps.setInt(2, new_task.getProjectId());
            ps.setString(3, AssignTask.toText(new_task.getDeveloperIds()));
            ps.setString(4, AssignTask.toText(new_task.getTesterIds()));
            ps.setString(5, new_task.getCreateDate().toString());
            ps.setString(6, "");
            ps.setString(7,"Created");
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void CreateUser(User a){
        String sqlite = "INSERT INTO tbl_ListUser (ID,Name,Username,Password)" + "VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sqlite);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getName());
            ps.setString(3, a.getUsername());
            ps.setString(4, a.getPassword());
          
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void UpdateEndDate(Date d,int ID_task) throws SQLException{
        String sqlite = "update tbl_ListTask set EndDate = ? where ID = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlite);
            preparedStatement.setString(1,d.toString());
            preparedStatement.setInt(2, ID_task);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
        }
    }
    public void UpdateLog(String status,Date d,int ID_task) throws SQLException{
        String sqlite = "update tbl_ListTaskActionLog set Update = ? where ID_Task = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sqlite);
            preparedStatement.setString(1,d.toString());
            preparedStatement.setInt(2, ID_task);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLiteException e) {
            System.out.println(e.getMessage());
        }
    }
}
