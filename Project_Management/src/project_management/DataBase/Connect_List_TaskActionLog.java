
package project_management.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import project_management.Date;
import project_management.TaskActionLog_;

public class Connect_List_TaskActionLog {
    public ArrayList<TaskActionLog_> logs = new ArrayList<>();
    public void ReadFromSQLite() {
        DAO dao = new DAO();
        String sqlite = "SELECT * FROM tbl_TaskActionLog";

        try {
            PreparedStatement ps = dao.conn.prepareStatement(sqlite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String k = rs.getString("Update");
                Date d = new Date(Integer.parseInt(k.substring(0, 2)), Integer.parseInt(k.substring(3, 5)), Integer.parseInt(k.substring(6, 10)));
                TaskActionLog_ log = new TaskActionLog_(rs.getString("Status"), d); 
                log.setID_task(rs.getInt("ID_Task"));
                logs.add(log);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}

