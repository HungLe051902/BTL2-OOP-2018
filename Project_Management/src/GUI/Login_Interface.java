package GUI;

import javax.swing.JOptionPane;
import project_management.CEO;
import project_management.DataBase.Connect_List_User;
import project_management.Employee;
import project_management.Login_System;
import project_management.Manager;

public class Login_Interface extends javax.swing.JFrame {

    static int dem = 1;
    Connect_List_User connect = new Connect_List_User();
    static int ceo,employee,manager;
    static int IDuser;
    public Login_Interface() {
        initComponents();
        
        connect.ReadFromSQLite();
        ceo=0;
        employee=0;
        manager=0;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel1.setText("Login System");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Username :");

        jUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password :");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Log-in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addComponent(jButton2))
                            .addComponent(jUsername)
                            .addComponent(jPasswordField1))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean kt(String u,String p){
        for (CEO c1:connect.ceo_){
            if (u.equals(c1.getUsername())&&p.equals(c1.getPassword())){
                ceo=1;
                IDuser = c1.getId();
                return true;  
            }
        }
        for (Employee c1:connect.employees_){
            if (u.equals(c1.getUsername())&&p.equals(c1.getPassword())){
                employee=1;
                IDuser = c1.getId();
                return true;  
            }
        } 
        for (Manager c1:connect.managers_){
            if (u.equals(c1.getUsername())&&p.equals(c1.getPassword())){
                manager=1;
                IDuser = c1.getId();
                return true;  
            }
        }
        return false;
    }
    private void jUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameActionPerformed
        String u = jUsername.getText();
        String p = new String(jPasswordField1.getPassword());
        if (u.equals("") || p.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập đủ thông tin !");
        } else {
            if (kt(u,p)) {
                //JOptionPane.showMessageDialog(rootPane, "SUCCESS !!");
                new Staff_Management_Interface();
                this.dispose();
            } else {
                if (dem <= 3) {
                    dem++;
                    JOptionPane.showMessageDialog(rootPane, "Username or password is not true, please press again !!!");
                } else {
                    System.exit(0);
                }
            }
        }
        
    }//GEN-LAST:event_jUsernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String u = jUsername.getText();
        String p = new String(jPasswordField1.getPassword());
        if (u.equals("") || p.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập đủ thông tin !");
        } else {
            if (kt(u,p)) {
                //JOptionPane.showMessageDialog(rootPane, "SUCCESS !!");
                new Staff_Management_Interface();
                this.dispose();
            } else {
                if (dem <= 3) {
                    dem++;
                    JOptionPane.showMessageDialog(rootPane, "Username or password is not true, please press again !!!");
                } else {
                    System.exit(0);
                }
            }

        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        String u = jUsername.getText();
        String p = new String(jPasswordField1.getPassword());
        if (u.equals("") || p.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn cần phải nhập đủ thông tin !");
        } else {
            if (kt(u,p)) {
                //JOptionPane.showMessageDialog(rootPane, "SUCCESS !!");
                new Staff_Management_Interface();
                this.dispose();
            } else {
                if (dem <= 3) {
                    dem++;
                    JOptionPane.showMessageDialog(rootPane, "Username or password is not true, please press again !!!");
                } else {
                    System.exit(0);
                }
            }
        }
        
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}
