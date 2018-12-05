/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.Login_Interface;
import GUI.List_Project_Interface;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.scripts.JO;
import project_management.DataBase.Connect_List_Task;

/**
 *
 * @author Le Hung
 */
public class Staff_Management_Interface extends javax.swing.JFrame {

    public Staff_Management_Interface() {
        initComponents();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        j_List_Project = new javax.swing.JButton();
        J_Task_List = new javax.swing.JButton();
        j_User_List = new javax.swing.JButton();
        j_Employee_List = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        j_Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Management Information");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Management Information");

        j_List_Project.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_List_Project.setText("Project List");
        j_List_Project.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_List_ProjectActionPerformed(evt);
            }
        });

        J_Task_List.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        J_Task_List.setText("Task List");
        J_Task_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                J_Task_ListActionPerformed(evt);
            }
        });

        j_User_List.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_User_List.setText("User List");
        j_User_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_User_ListActionPerformed(evt);
            }
        });

        j_Employee_List.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        j_Employee_List.setText("Employee List");
        j_Employee_List.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_Employee_ListActionPerformed(evt);
            }
        });

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        j_Back.setText("Back");
        j_Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(j_Back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(j_List_Project, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(J_Task_List, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j_User_List, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j_Employee_List))))
                .addGap(0, 79, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(j_List_Project)
                .addGap(18, 18, 18)
                .addComponent(J_Task_List)
                .addGap(18, 18, 18)
                .addComponent(j_User_List)
                .addGap(18, 18, 18)
                .addComponent(j_Employee_List)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(j_Back))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_BackActionPerformed
        this.dispose();
        new Login_Interface();
    }//GEN-LAST:event_j_BackActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void j_List_ProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_List_ProjectActionPerformed
        this.dispose();
        new List_Project_Interface();

    }//GEN-LAST:event_j_List_ProjectActionPerformed

    private void J_Task_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_J_Task_ListActionPerformed
        if (Login_Interface.employee==1){
            this.dispose();
            new List_Task_Interface();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn không phải là Employee ");
        }
    }//GEN-LAST:event_J_Task_ListActionPerformed

    private void j_User_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_User_ListActionPerformed
        if (Login_Interface.ceo==1){
            this.dispose();
            new List_User_Interface();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn không phải là CEO ");
        }
    }//GEN-LAST:event_j_User_ListActionPerformed

    private void j_Employee_ListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_Employee_ListActionPerformed
        if(Login_Interface.manager==1){
            this.dispose();
            new List_Employee_Interface();
        }
        else {
            JOptionPane.showMessageDialog(rootPane, "Bạn không phải là Manager ");
        }
    }//GEN-LAST:event_j_Employee_ListActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton J_Task_List;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton j_Back;
    private javax.swing.JButton j_Employee_List;
    private javax.swing.JButton j_List_Project;
    private javax.swing.JButton j_User_List;
    // End of variables declaration//GEN-END:variables
}
