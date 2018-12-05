package GUI;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import project_management.DataBase.Connect_List_Project;
import project_management.Project;

public class List_Project_Interface extends javax.swing.JFrame {

    DefaultTableModel model;
    ArrayList<Project> project = new ArrayList<>();
    static int STEP3=0;
    int i = 1;

    public List_Project_Interface() {
        initComponents();
        Connect_List_Project con = new Connect_List_Project();
        con.ReadFromSQLite();
        project = con.project;
        model = (DefaultTableModel) j_Table_List_Project.getModel();
        showAllProject();
        STEP3 = 1;
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public void showAllProject() {
        if (Login_Interface.manager == 1) {
            for (Project p : project) {
                if (p.getManagerId() == Login_Interface.IDuser) {
                    String s;
                    if (p.getNumber_Current_Task() > 0) {
                        s = "Doing";
                    } else {
                        s = "Completed";
                    }
                    model.addRow(new Object[]{
                        p.getId(), p.getName(), p.getManagerId(), p.getManager().getName(), s, p.getNumber_Current_Task(), p.getNumber_Completed_Task()
                    });
                }
            }
            return;
        }
        if (Login_Interface.ceo == 1) {
            for (Project p : project) {
                String s;
                if (p.getNumber_Current_Task() > 0) {
                    s = "Doing";
                } else {
                    s = "Completed";
                }
                model.addRow(new Object[]{
                    p.getId(), p.getName(), p.getManagerId(), p.getManager().getName(), s, p.getNumber_Current_Task(), p.getNumber_Completed_Task()
                });
            }
            return;
        }
        if (Login_Interface.employee == 1) {
            for (Project p : project) {
                if (p.getEmployeeIds().contains(Login_Interface.IDuser)) {
                    String s;
                    if (p.getNumber_Current_Task() > 0) {
                        s = "Doing";
                    } else {
                        s = "Completed";
                    }
                    model.addRow(new Object[]{
                        p.getId(), p.getName(), p.getManagerId(), p.getManager().getName(), s, p.getNumber_Current_Task(), p.getNumber_Completed_Task()
                    });
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        j_Table_List_Project = new javax.swing.JTable();
        j_back = new javax.swing.JButton();
        j_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("List Project");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("All Project");

        j_Table_List_Project.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID project", "Project Name", "ID Manager", "User Manager", "Status", "Number Current Task", "Number Task Completed"
            }
        ));
        j_Table_List_Project.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                j_Table_List_ProjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(j_Table_List_Project);
        if (j_Table_List_Project.getColumnModel().getColumnCount() > 0) {
            j_Table_List_Project.getColumnModel().getColumn(4).setResizable(false);
        }

        j_back.setText("Back");
        j_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_backActionPerformed(evt);
            }
        });

        j_exit.setText("Exit");
        j_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                j_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 822, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(j_back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(j_exit)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j_back)
                    .addComponent(j_exit))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void j_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_backActionPerformed
        this.setVisible(false);
        new Staff_Management_Interface();
    }//GEN-LAST:event_j_backActionPerformed

    private void j_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_j_exitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_j_exitActionPerformed

    private void j_Table_List_ProjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_j_Table_List_ProjectMouseClicked

        int row = j_Table_List_Project.getSelectedRow();
        System.out.print(row);
// TEST
        STEP3_1 s = new STEP3_1(project.get(row).getId());
        this.dispose();
        System.out.println(Login_Interface.ceo);

    }//GEN-LAST:event_j_Table_List_ProjectMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable j_Table_List_Project;
    private javax.swing.JButton j_back;
    private javax.swing.JButton j_exit;
    // End of variables declaration//GEN-END:variables
}
