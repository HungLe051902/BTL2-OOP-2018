package GUI;

import javax.swing.JOptionPane;
import project_management.DataBase.Connect_List_Task;
import project_management.DataBase.DAO;
import project_management.Date;
import project_management.Task;

public class Create_Task extends javax.swing.JFrame {

    Task new_task = new Task();

    public Create_Task() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void createTask() {

        new_task.setID(Integer.parseInt(jID.getText()));
        new_task.setProjectId(Integer.parseInt(jIDproject.getText()));
        Connect_List_Task.SeperateID1(jDeveloperIDs.getText(), new_task.getDeveloperIds());
        Connect_List_Task.SeperateID2(jTesterIDs.getText(), new_task.getTesterIds());
        setCreateDate(new_task.getCreateDate());
    }

    public void setCreateDate(Date d) {
        int day = Integer.parseInt(jCreateDate.getText().substring(0, 2));
        int month = Integer.parseInt(jCreateDate.getText().substring(3, 5));
        int year = Integer.parseInt(jCreateDate.getText().substring(6, 10));
        d.setDay(day);
        d.setMonth(month);
        d.setYear(year);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jID = new javax.swing.JTextField();
        jIDproject = new javax.swing.JTextField();
        jDeveloperIDs = new javax.swing.JTextField();
        jTesterIDs = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jCreateDate = new javax.swing.JTextField();
        j_Button_Create = new javax.swing.JButton();
        j_Back = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Task");

        jLabel1.setText("ID Task");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Create Task");

        jLabel3.setText("ID Project");

        jLabel4.setText("DeveloperIDs");

        jLabel5.setText("TesterIDs");

        jLabel6.setText("Create Date");

        j_Button_Create.setText("Create");
        j_Button_Create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_Button_CreateActionPerformed(evt);
            }
        });

        j_Back.setText("Back");
        j_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_BackActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jID)
                                    .addComponent(jIDproject)
                                    .addComponent(jDeveloperIDs)
                                    .addComponent(jTesterIDs)
                                    .addComponent(jCreateDate, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(j_Button_Create)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 233, Short.MAX_VALUE)
                                .addComponent(j_Back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(24, 24, 24)))))
                .addGap(58, 58, 58))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jIDproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jDeveloperIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jTesterIDs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jCreateDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j_Button_Create)
                    .addComponent(j_Back)
                    .addComponent(jButton3))
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_Button_CreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_Button_CreateActionPerformed
        createTask();
        DAO dao = new DAO();
        dao.CreateTask(new_task);
        JOptionPane.showMessageDialog(rootPane, "Create Success ");
    }//GEN-LAST:event_j_Button_CreateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void j_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_BackActionPerformed
        this.dispose();
        if (List_Project_Interface.STEP3 == 1) {
            new List_Task_Interface(List_Task_Interface.IDproject);
        } else {
            new List_Task_Interface();
        }
    }//GEN-LAST:event_j_BackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JTextField jCreateDate;
    private javax.swing.JTextField jDeveloperIDs;
    private javax.swing.JTextField jID;
    private javax.swing.JTextField jIDproject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTesterIDs;
    private javax.swing.JButton j_Back;
    private javax.swing.JButton j_Button_Create;
    // End of variables declaration//GEN-END:variables
}
