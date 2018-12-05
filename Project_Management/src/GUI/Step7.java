package GUI;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_management.DataBase.Connect_List_Project;
import project_management.DataBase.Connect_List_Task;
import project_management.DataBase.Connect_List_User;
import project_management.DataBase.DAO;
import project_management.Date;
import project_management.Developer;
import project_management.Employee;
import project_management.Manager;
import project_management.Task;
import project_management.TaskActionLog_;
import project_management.Tester;

public class Step7 extends javax.swing.JFrame {

    DefaultTableModel model1;
    DefaultTableModel model2;
    Task t;
    Manager m;
    Developer d;
    Tester tester;
    Connect_List_User u = new Connect_List_User();
    Connect_List_Task ct = new Connect_List_Task();

    public Step7(Task t) {
        initComponents();
        this.t = t;
        model1 = (DefaultTableModel) jTable1.getModel();
        model2 = (DefaultTableModel) jTable2.getModel();
        u.ReadFromSQLite();
        if (Login_Interface.manager == 1) {
            for (Manager as : u.managers_) {
                if (as.getId() == Login_Interface.IDuser) {
                    m = as;
                    m.setTask(t);
                    break;
                }
            }
        } else if (Login_Interface.employee == 1) {
            for (Employee as : u.employees_) {
                if (as.getId() == Login_Interface.IDuser) {
                    if (as.getId() < 9999) {
                        ArrayList<Integer> list_project_participation = new ArrayList<Integer>();
                        d = new Developer(t, list_project_participation, as.getUsername(), as.getPassword(), as.getName(), as.getId());
                        AddIDproject(d);
                        break;
                    } else {
                        ArrayList<Integer> list_project_participation = new ArrayList<Integer>();
                        tester = new Tester(true, t, list_project_participation, as.getUsername(), as.getPassword(), as.getName(), as.getId());
                        AddIDproject(d);
                        break;
                    }
                }
            }
        }
        ct.ReadFromSQLite();
        showTaskAndEmployees();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("step7");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Task Information");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Project ID", "DeveloperIDs", "TesterIDs", "CreateDate", "EndDate", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Employee Information");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee", "ID", "Name", "List ID project participant"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton1.setText("Change Status");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Assign Task");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Exit");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void AddIDproject(Employee x) {
        for (Task a : ct.task) {
            if (a.getDeveloperIds().contains(x.getId())) {
                if (x.getList_IDproject_participation().contains(a.getID()) == false) {
                    x.getList_IDproject_participation().add(a.getID());
                }
            }
        }
        for (Task a : ct.task) {
            if (a.getTesterIds().contains(x.getId())) {
                if (x.getList_IDproject_participation().contains(a.getID()) == false) {
                    x.getList_IDproject_participation().add(a.getID());
                }
            }
        }
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
        if (List_Project_Interface.STEP3 == 1) {
            new List_Task_Interface(List_Task_Interface.IDproject);
        } else {
            new List_Task_Interface();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (Login_Interface.employee == 1) {
            if (d != null) {
                if (d.changeStatus() == true) {
                    Date date = new Date();
                    TaskActionLog_ log = new TaskActionLog_(d.getTask().getStatus(), date);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không trong phạm vi thay đổi ");
                }
            } else if (tester != null) {
                if (tester.changeStatus()) {
                    Date date = new Date();
                    TaskActionLog_ log = new TaskActionLog_(d.getTask().getStatus(), date);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không trong phạm vi thay đổi ");
                }
            }
        } else if (Login_Interface.manager == 1) {
            if (m.changeStatus() == true) {
                Date date = new Date();
                TaskActionLog_ log = new TaskActionLog_(d.getTask().getStatus(), date);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không trong phạm vi thay đổi ");
            }
        }
        DAO d = new DAO();
        try {
            d.editWord(t.getStatus(), t.getID());
        } catch (SQLException ex) {
            Logger.getLogger(Step7.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(t.getStatus());
        model1.setRowCount(0);
        model1.addRow(new Object[]{
            t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (Login_Interface.manager == 1) {
            this.dispose();
            new AssignTask(t);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn không phải là Manager !!! ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void showTaskAndEmployees() {
        model1.addRow(new Object[]{
            t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
        });
        for (Integer i : t.getDeveloperIds()) {
            for (Employee e : u.employees_) {
                if (e.getId() == i) {
                    AddIDproject(e);
                    model2.addRow(new Object[]{
                        "Developer", e.getId(), e.getName(), e.getList_IDproject_participation().toString()
                    });
                    break;

                }
            }
        }
        for (Integer i : t.getTesterIds()) {
            for (Employee e : u.employees_) {
                if (e.getId() == i) {
                    AddIDproject(e);
                    model2.addRow(new Object[]{
                        "Tester", e.getId(), e.getName(), e.getList_IDproject_participation().toString()
                    });
                    break;
                }
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
