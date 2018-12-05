
package GUI;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_management.DataBase.Connect_List_User;
import project_management.Employee;
import project_management.Manager;

public class List_User_Interface extends javax.swing.JFrame {
    DefaultTableModel model ;
    DefaultComboBoxModel modelBox;
    Connect_List_User c = new Connect_List_User();
    public List_User_Interface() {
        initComponents();
        c.ReadFromSQLite();
        model = (DefaultTableModel) jTable1.getModel();
        modelBox = new DefaultComboBoxModel();
        modelBox.addElement("All");
        modelBox.addElement("Manager");
        modelBox.addElement("Developer");
        modelBox.addElement("Tester");
        jComboBox2.setModel(modelBox);
        Show();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Show(){
        for (Manager m:c.managers_){
            model.addRow(new Object[]{
                "Manager",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
        }
        for (Employee m:c.employees_){
            if (m.getId()<9999){
            model.addRow(new Object[]{
                "Developer",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
            }
            else {
                model.addRow(new Object[]{
                "Tester",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("List User");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funtion", "ID", "Name", "Username", "Password"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Create user");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Staff_Management_Interface();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.dispose();
       new Create_User();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        //JOptionPane.showMessageDialog(rootPane, "HAHAHA");
//        if (modelBox.getSelectedItem().equals("All")){
//            model.setRowCount(0);
//            Show();
//        }
//        else if((modelBox.getSelectedItem().equals("Manager"))) {
//            model.setRowCount(0);
//            for (Manager m:c.managers_){
//                model.addRow(new Object[]{
//                "Manager",m.getId(),m.getName(),m.getUsername(),m.getPassword()
//            });
//            }
//        }
//        else if ((modelBox.getSelectedItem().equals("Developer"))){
//            model.setRowCount(0);
//            for (Employee m:c.employees_){
//                if (m.getId()<9999)
//                model.addRow(new Object[]{
//                "Developer",m.getId(),m.getName(),m.getUsername(),m.getPassword()
//            });
//            }
//        }
//        else if ((modelBox.getSelectedItem().equals("Tester"))){
//            model.setRowCount(0);
//            for (Employee m:c.employees_){
//                if (m.getId()>9999)
//                model.addRow(new Object[]{
//                "Tester",m.getId(),m.getName(),m.getUsername(),m.getPassword()
//            });
//            }
//        }
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        if (modelBox.getSelectedItem().equals("All")){
            model.setRowCount(0);
            Show();
        }
        else if((modelBox.getSelectedItem().equals("Manager"))) {
            model.setRowCount(0);
            for (Manager m:c.managers_){
                model.addRow(new Object[]{
                "Manager",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
            }
        }
        else if ((modelBox.getSelectedItem().equals("Developer"))){
            model.setRowCount(0);
            for (Employee m:c.employees_){
                if (m.getId()<9999)
                model.addRow(new Object[]{
                "Developer",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
            }
        }
        else if ((modelBox.getSelectedItem().equals("Tester"))){
            model.setRowCount(0);
            for (Employee m:c.employees_){
                if (m.getId()>9999)
                model.addRow(new Object[]{
                "Tester",m.getId(),m.getName(),m.getUsername(),m.getPassword()
            });
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
