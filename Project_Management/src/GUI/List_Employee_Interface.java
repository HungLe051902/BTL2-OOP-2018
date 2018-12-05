package GUI;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import project_management.DataBase.Connect_List_Task;
import project_management.DataBase.Connect_List_User;
import project_management.Employee;
import project_management.Task;

public class List_Employee_Interface extends javax.swing.JFrame {

    Connect_List_User c = new Connect_List_User();
    Connect_List_Task con = new Connect_List_Task();
    DefaultTableModel model;

    public List_Employee_Interface() {
        initComponents();
        c.ReadFromSQLite();
        con.ReadFromSQLite();
        model = (DefaultTableModel) jTable1.getModel();
        Show();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void Show() {
        for (Employee e : c.employees_) {
            if (e.getId() < 9999) {
                int NumberTask = 0;
                ArrayList<Integer> numberProject = new ArrayList<>();
                for (Task t : con.task) {
                    if (t.getDeveloperIds().contains(e.getId())) {
                        NumberTask++;
                        if (numberProject.contains(t.getProjectId()) == false) {
                            numberProject.add(t.getProjectId());
                        }
                    }

                }
                model.addRow(new Object[]{
                    "Developer", e.getId(), e.getName(), e.getUsername(), e.getPassword(), numberProject.size(), NumberTask
                });
            } else {
                int NumberTask = 0;
                ArrayList<Integer> numberProject = new ArrayList<>();
                for (Task t : con.task) {
                    if (t.getTesterIds().contains(e.getId())) {
                        NumberTask++;
                        if (numberProject.contains(t.getProjectId()) == false) {
                            numberProject.add(t.getProjectId());
                        }
                    }

                }
                model.addRow(new Object[]{
                    "Tester", e.getId(), e.getName(), e.getUsername(), e.getPassword(), numberProject.size(), NumberTask
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
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("List Employee");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funtion", "ID", "Name", "Username", "Password", "Number Project Involved", "Assigned Tasks"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 804, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
        new Staff_Management_Interface();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
