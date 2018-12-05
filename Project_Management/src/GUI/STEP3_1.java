package GUI;

import javax.swing.JOptionPane;

public class STEP3_1 extends javax.swing.JFrame {

    int IDproject;

    public STEP3_1(int IDproject) {
        initComponents();
        this.IDproject = IDproject;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        j_Button_CreateProject = new javax.swing.JButton();
        jButton_List_Task = new javax.swing.JButton();
        jButton_Filecsv = new javax.swing.JButton();
        jButton_exit = new javax.swing.JButton();
        jButton_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("3.1");

        j_Button_CreateProject.setText("Create Project");
        j_Button_CreateProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_Button_CreateProjectActionPerformed(evt);
            }
        });

        jButton_List_Task.setText("Show List Task");
        jButton_List_Task.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_List_TaskActionPerformed(evt);
            }
        });

        jButton_Filecsv.setText("File csv");
        jButton_Filecsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FilecsvActionPerformed(evt);
            }
        });

        jButton_exit.setText("Exit");
        jButton_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exitActionPerformed(evt);
            }
        });

        jButton_Back.setText("Back");
        jButton_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_exit))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(j_Button_CreateProject, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton_List_Task, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jButton_Filecsv, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(j_Button_CreateProject)
                .addGap(18, 18, 18)
                .addComponent(jButton_List_Task)
                .addGap(18, 18, 18)
                .addComponent(jButton_Filecsv)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_exit)
                    .addComponent(jButton_Back))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton_exitActionPerformed

    private void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_BackActionPerformed
        this.dispose();
        new List_Project_Interface();
    }//GEN-LAST:event_jButton_BackActionPerformed

    private void jButton_FilecsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FilecsvActionPerformed
        this.dispose();
        new FileCSV_Interface();
    }//GEN-LAST:event_jButton_FilecsvActionPerformed

    private void j_Button_CreateProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_Button_CreateProjectActionPerformed

        if (Login_Interface.ceo == 1) {
            this.dispose();
            new Create_Project_Interface();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chỉ có CEO mới có quyền tạo project");
        }
    }//GEN-LAST:event_j_Button_CreateProjectActionPerformed

    private void jButton_List_TaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_List_TaskActionPerformed
        this.dispose();
        new List_Task_Interface(IDproject);
    }//GEN-LAST:event_jButton_List_TaskActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Back;
    private javax.swing.JButton jButton_Filecsv;
    private javax.swing.JButton jButton_List_Task;
    private javax.swing.JButton jButton_exit;
    private javax.swing.JButton j_Button_CreateProject;
    // End of variables declaration//GEN-END:variables
}
