package project_management.DataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import project_management.Date;
import project_management.Task;

public class Connect_List_Task {

    public Connect_List_Task() {
    }

    public ArrayList<Task> task = new ArrayList<>();

    public void ReadFromSQLite() {
        DAO dao = new DAO();
        String sqlite = "SELECT * FROM tbl_ListTask";

        try {
            PreparedStatement ps = dao.conn.prepareStatement(sqlite);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
//                System.out.println(rs.getString("DeveloperIDs"));

                Task x = new Task();
                x.setID(rs.getInt("ID"));
                //System.out.println(x.getID());
                x.setProjectId(rs.getInt("ProjectID"));
                //System.out.println(x.getProjectId());
                ArrayList<Integer> devIDs = new ArrayList<>();

                SeperateID1(rs.getString("DeveloperIDs"), devIDs);

                x.setDeveloperIds(devIDs);
                //System.out.println(x.getDeveloperIds().toString());
                ArrayList<Integer> testIDs = new ArrayList<>();
                SeperateID2(rs.getString("TesterIDs"), testIDs);
                x.setTesterIds(testIDs);
                //System.out.println(x.getTesterIds().toString());
                Date create_date = new Date();
                SeperateDate(rs.getString("CreateDate"), create_date);
                x.setCreateDate(create_date);
                //System.out.println(x.getCreateDate().toString());
                Date end_date = new Date();
                SeperateDate(rs.getString("EndDate"), end_date);
                x.setEndDate(end_date);
                //System.out.println(x.getEndDate().toString());
                x.setStatus(rs.getString("Status"));
                //System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                task.add(x);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SeperateID1(String s, ArrayList<Integer> ids) {
        int i = 0;
        while (i < s.length() && i + 3 < s.length()) {
            String k = s.substring(i, i + 4);
            //if (ids.contains(Integer.parseInt(k)) == false) {
                ids.add(Integer.parseInt(k));
                i += 5;
            //}
        }
    }

    public static void SeperateID2(String s, ArrayList<Integer> ids) {
        int i = 0;
        while (i < s.length() && i + 4 < s.length()) {
            String k = s.substring(i, i + 5);
            ///if (ids.contains(Integer.parseInt(k))) {
                ids.add(Integer.parseInt(k));
                i += 6;
            //}
        }
    }

    public void SeperateDate(String s, Date date) {
        if (s.length() > 0) {
            date.setDay(Integer.parseInt(s.substring(0, 2)));
            date.setMonth(Integer.parseInt(s.substring(3, 5)));
            date.setYear(Integer.parseInt(s.substring(6, 10)));
        }
    }
}
