package majorproject;

import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;

public class blockDetails extends javax.swing.JFrame
{
    Connection cn=null;
    int nm;
    int last;
    DefaultTableModel model;
    public blockDetails() 
    {
        
        initComponents();
        model=new DefaultTableModel();
         model.addColumn("SR NO");
        model.addColumn("BLOCK NAME");
        model.addColumn("STRENGTH");
        jTable1.setModel(model);
        
        try
        {
            cn=DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from blockstr");
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                
            }
                    
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
        
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BLOCK DETAILS");
        setMinimumSize(new java.awt.Dimension(360, 290));
        setPreferredSize(new java.awt.Dimension(880, 580));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(null);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(390, 140, 450, 370);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("REFRESH");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(390, 90, 110, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("DELETE ALL");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(710, 90, 130, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("DELETE SELECTED");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(510, 90, 190, 40);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("BLOCK NO");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 30, 280, 30);

        jTextField1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(50, 70, 240, 40);

        jTextField2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(50, 170, 240, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("STRENGTH");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(30, 130, 280, 30);

        jButton1.setBackground(new java.awt.Color(204, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(70, 240, 190, 40);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5);
        jLabel5.setBounds(80, 250, 190, 40);

        jButton6.setBackground(new java.awt.Color(204, 255, 255));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton6.setText("SAVE DEFAULT");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(60, 320, 210, 40);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6);
        jLabel6.setBounds(70, 330, 210, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 90, 350, 430);

        jLabel4.setBackground(new java.awt.Color(0, 0, 255));
        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 0, 40)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GOVERNMENT POLYECHNIC MIRAJ");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 10, 820, 70);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            cn  = DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            ResultSet rs=st.executeQuery("select * from blockstr  order by blockid");    
         
            while(rs.next())
            {                
                    nm=rs.getInt(1);
            }
            
            PreparedStatement ps = cn.prepareStatement("insert into blockstr values(?,?,?)");
            ps.setInt(1,nm+1);
            ps.setString(2,jTextField1.getText());
            ps.setString(3,jTextField2.getText());
            ps.execute();
            JOptionPane.showMessageDialog(null,"SAVED!!!");
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        try
        {model=new DefaultTableModel();
         model.addColumn("SR NO");
        model.addColumn("BLOCK NAME");
        model.addColumn("STRENGTH");
        jTable1.setModel(model);
            
            cn=DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from blockstr");
            while(rs.next())
            {
                model.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getString(3)});
                
            }
                    
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        model = new DefaultTableModel();
         model.addColumn("SR NO");
        model.addColumn("BLOCK NAME");
        model.addColumn("STRENGTH");
        jTable1.setModel(model);
        try
        {
            Statement st = cn.createStatement();
            st.execute("delete from blockstr");
                    
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        int op=JOptionPane.showConfirmDialog(null,"Are you Sure !!!","",YES_NO_OPTION);
        if(op==0)
        {
            
            try
            {
                Statement st = cn.createStatement();
                st.execute("delete from blockstr where blockno='"+model.getValueAt(jTable1.getSelectedRow(),1)+"'");
            }catch(Exception e){JOptionPane.showMessageDialog(null,"Removed!!!");}
            model.removeRow(jTable1.getSelectedRow());
        }
       
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton6ActionPerformed
    {//GEN-HEADEREND:event_jButton6ActionPerformed
      DefaultTableModel model = new DefaultTableModel();
      model.addColumn("SR NO");
      model.addColumn("BLOCK NAME");
      model.addColumn("STRENGTH");
      jTable1.setModel(model);    
      model.addRow(new Object[]{"1","201","35"});
      model.addRow(new Object[]{"2","203","30"});
      model.addRow(new Object[]{"3","205","30"});
      model.addRow(new Object[]{"4","206","30"});
      model.addRow(new Object[]{"5","210","30"});
      model.addRow(new Object[]{"6","211","30"});
      model.addRow(new Object[]{"7","212","35"});
      model.addRow(new Object[]{"8","213","30"});
      model.addRow(new Object[]{"9","215","35"});
      model.addRow(new Object[]{"10","101","35"});
      model.addRow(new Object[]{"11","103","35"});
      model.addRow(new Object[]{"12","108","35"});
      model.addRow(new Object[]{"13","109","35"});
      model.addRow(new Object[]{"14","112","35"});
      model.addRow(new Object[]{"15","pdh","32"});
      model.addRow(new Object[]{"16","cdh1","32"});
      model.addRow(new Object[]{"17","cdh2","32"});
      model.addRow(new Object[]{"18","mdh1","32"});
      model.addRow(new Object[]{"19","mdh2","32"});
      model.addRow(new Object[]{"20","apm","32"});
      
      try
      {
      Statement ps = cn.createStatement();
      ps.execute("insert into blockstr values(1,'201',35)");
      ps.execute("insert into blockstr values(2,'203',30)");
      ps.execute("insert into blockstr values(3,'205',30)");
      ps.execute("insert into blockstr values(4,'206',30)");
      ps.execute("insert into blockstr values(5,'210',30)");
      ps.execute("insert into blockstr values(6,'211',30)");
      ps.execute("insert into blockstr values(7,'212',35)");
      ps.execute("insert into blockstr values(8,'213',30)");
      ps.execute("insert into blockstr values(9,'215',35)");
      ps.execute("insert into blockstr values(10,'101',35)");
      ps.execute("insert into blockstr values(11,'103',35)");
      ps.execute("insert into blockstr values(12,'108',35)");
      ps.execute("insert into blockstr values(13,'109',35)");
      ps.execute("insert into blockstr values(14,'112',35)");
      ps.execute("insert into blockstr values(15,'pdh',32)");
      ps.execute("insert into blockstr values(16,'cdh1',32)");
      ps.execute("insert into blockstr values(17,'cdh2',32)");
      ps.execute("insert into blockstr values(18,'mdh1',32)");
      ps.execute("insert into blockstr values(19,'mdh2',32)");
      ps.execute("insert into blockstr values(20,'apm',32)");
      
          
          JOptionPane.showMessageDialog(null,"DONE");
          
      }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
      
      
    }//GEN-LAST:event_jButton6ActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(blockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(blockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(blockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(blockDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run()
            {
                new blockDetails().setVisible(true);
            }});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
