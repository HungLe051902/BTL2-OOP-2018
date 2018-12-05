package GUI;

import com.sun.javafx.css.Combinator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_management.DataBase.Connect_List_Task;
import project_management.Date;
import project_management.Task;

public class List_Task_Interface extends javax.swing.JFrame {

    DefaultTableModel model;
    Connect_List_Task con = new Connect_List_Task();
    static int IDproject;
    DefaultComboBoxModel modelBox;

    public List_Task_Interface(int IDproject) {
        initComponents();
        con.ReadFromSQLite();
        model = (DefaultTableModel) jList_Task.getModel();
        modelBox = new DefaultComboBoxModel();
        modelBox.addElement("All Task");
        modelBox.addElement("Status Filter");
        modelBox.addElement("StarteDate Filter");
        jComboBox1.setModel(modelBox);
        this.IDproject = IDproject;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        showTask();

    }

    public List_Task_Interface(String Filter) {
        initComponents();
        con.ReadFromSQLite();
        model = (DefaultTableModel) jList_Task.getModel();
        this.IDproject = IDproject;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        if (Filter.equals("Status Filter")) {
            showTask_Filter_Status();
        } else if (Filter.equals("StarteDate Filter")) {
            showTask_Filter_StarteDate();
        }

    }

    public List_Task_Interface() {
        initComponents();
        con.ReadFromSQLite();
        model = (DefaultTableModel) jList_Task.getModel();
        this.IDproject = IDproject;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        showTask1();

    }
    int i = 0;

    public void showTask() {
        model.setRowCount(0);
        for (Task t : con.task) {
            if (t.getProjectId() == IDproject) {
                model.addRow(new Object[]{
                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                });
            }
        }

    }

    public void showTask1() {
        model.setRowCount(0);
        for (Task t : con.task) {
            if (t.getDeveloperIds().contains(Login_Interface.IDuser)) {
                model.addRow(new Object[]{
                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                });
            }
            if (t.getTesterIds().contains(Login_Interface.IDuser)) {
                model.addRow(new Object[]{
                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                });
            }
        }

    }

    public void showTask_Filter_Status() {
        model.setRowCount(0);
        List<Task> t1 = con.task;
        Collections.sort(t1);
        for (Task t : t1) {
            if (List_Project_Interface.STEP3 == 1) {
                if (t.getProjectId() == IDproject) {
                    model.addRow(new Object[]{
                        t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                    });
                }
            } else {
                if (t.getDeveloperIds().contains(Login_Interface.IDuser)) {
                    model.addRow(new Object[]{
                        t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                    });
                }
                if (t.getTesterIds().contains(Login_Interface.IDuser)) {
                    model.addRow(new Object[]{
                        t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                    });
                }
            }
        }

        /*for (Task t : t1) {
            model.addRow(new Object[]{
                t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
            });
//            if (t.getStatus().equals("Create")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Assigned")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Started")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Completed")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Done")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Reject")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            } else if (t.getStatus().equals("Close")) {
//                model.addRow(new Object[]{
//                    t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                });
//            }
        }*/
    }

    public void showTask_Filter_StarteDate() {
        model.setRowCount(0);
        List<Date> d = new ArrayList<>();
        for (Task t : con.task) {
            if (d.contains(t.getCreateDate()) == false) {

                d.add(t.getCreateDate());

            }
        }
        Collections.sort(d);
        if (List_Project_Interface.STEP3 == 1) {
            for (Date d1 : d) {
                for (Task t : con.task) {
                    if (t.getProjectId() == IDproject) {
                        if (t.getCreateDate().compareTo(d1) == 0) {
                            model.addRow(new Object[]{
                                t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                            });
                            break;
                        }
                    }
                }
            }
        } else {
            for (Date d1 : d) {
                for (Task t : con.task) {

                    if (t.getDeveloperIds().contains(Login_Interface.IDuser)) {
                        if (t.getCreateDate().compareTo(d1) == 0) {
                            model.addRow(new Object[]{
                                t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
                            });
                            break;
                        }
                    }
//                    if (t.getTesterIds().contains(Login_Interface.IDuser)) {
//                        if (t.getCreateDate().compareTo(d1) == 0) {
//                            model.addRow(new Object[]{
//                                t.getID(), t.getProjectId(), t.getDeveloperIds().toString(), t.getTesterIds().toString(), t.getCreateDate().toString(), t.getEndDate().toString(), t.getStatus()
//                            });
//                            break;
//                        }
//                    }

                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList_Task = new javax.swing.JTable();
        jBack_ = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jExit_ = new javax.swing.JButton();
        j_Create_Task = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jList_Task.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Project ID", "DeveloperIDs", "TesterIDs", "CreateDate", "EndDate", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jList_Task.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_TaskMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList_Task);

        jBack_.setText("Back");
        jBack_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBack_ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("List Task");

        jExit_.setText("Exit");
        jExit_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExit_ActionPerformed(evt);
            }
        });

        j_Create_Task.setText("Create Task");
        j_Create_Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_Create_TaskActionPerformed(evt);
            }
        });

        jButton1.setText("File CSV");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton2.setText("File CSV TaskActionLog");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 956, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j_Create_Task)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBack_)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jExit_)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(393, 393, 393))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(j_Create_Task, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBack_)
                        .addComponent(jExit_)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBack_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBack_ActionPerformed
        this.dispose();
        if (List_Project_Interface.STEP3 == 1) {
            new STEP3_1(IDproject);
        } else {
            new Staff_Management_Interface();
        }
    }//GEN-LAST:event_jBack_ActionPerformed

    private void jExit_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExit_ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jExit_ActionPerformed

    private void jList_TaskMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_TaskMouseClicked
        this.dispose();
        int row = jList_Task.getSelectedRow();
        int index = (int) jList_Task.getValueAt(row, 0);
        new Step7(con.task.get(index - 1));
    }//GEN-LAST:event_jList_TaskMouseClicked

    private void j_Create_TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_Create_TaskActionPerformed
        if (Login_Interface.manager == 1) {
            this.dispose();
            new Create_Task();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn không phải là manager !");
        }
    }//GEN-LAST:event_j_Create_TaskActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new FileCSV_Task();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (modelBox.getSelectedItem().equals("All Task")) {
            if (List_Project_Interface.STEP3 == 1) {
                showTask();
            } else {
                showTask1();
            }
        }
        else if (modelBox.getSelectedItem().equals("Status Filter")){
            showTask_Filter_Status();
        }
        else {
            showTask_Filter_StarteDate();
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       this.dispose();
       new FileCSV_TaskActionLog();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBack_;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton jExit_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTable jList_Task;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton j_Create_Task;
    // End of variables declaration//GEN-END:variables
}
