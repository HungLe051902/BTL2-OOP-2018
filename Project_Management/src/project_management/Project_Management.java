package project_management;

import GUI.List_Project_Interface;
import GUI.List_Task_Interface;
import GUI.Login_Interface;
import java.util.ArrayList;
import project_management.DataBase.Connect_List_Project;
import project_management.DataBase.Connect_List_Task;
import project_management.DataBase.Connect_List_TaskActionLog;
import project_management.DataBase.Connect_Project;
import project_management.DataBase.DAO;

public class Project_Management {

    public static void main(String[] args) {
        //CEO ceo = new CEO(true,"lexuanhung","1234","hung",1);
        // new Connect_List_Task().ReadFromSQLite();
        //new List_Task_Interface();
        // new Connect_List_Project().ReadFromSQLite();
//         ArrayList<Integer> s = new ArrayList<>();
//         s.add(4);
//         s.add(5);
//         s.add(4);
//         System.out.println(s.toString());
//           Connect_List_Project b = new Connect_List_Project();
        //b.ReadFromSQLite();
        new Login_Interface();
//        Connect_List_TaskActionLog c = new Connect_List_TaskActionLog();
//        c.ReadFromSQLite();
//        System.out.println(c.logs.toString());
//        List_Task_Interface k = new List_Task_Interface();
//        k.showTask_Filter_StarteDate();
    }

}
