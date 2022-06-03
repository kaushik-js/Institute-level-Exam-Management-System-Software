package majorproject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import javax.swing.*;
import java.sql.*;
import java.util.Arrays;
public class ansSlip extends javax.swing.JFrame
{
    Connection cn=null;
    String dte=null;
    String tm=null;
    String blck=null;
    String schme[]=null;
    String sc2[]=null;
    int[] seat;
    public ansSlip()
    {
        initComponents();
         ImageIcon icon = new ImageIcon("\\Majorproject\\src\\logs\\msbtelogo.jpg");
       jLabel13.setIcon(icon);
        try
       {
            cn = DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            t1.addItem("SELECT");
            ResultSet rs = st.executeQuery("select distinct(dt) from seatchart");
            while(rs.next())
            {
                t1.addItem(rs.getString(1));
            }
            t1.addItemListener(new ItemListener()
            {

                @Override
                public void itemStateChanged(ItemEvent e)
                {
                   try
                   {
                        t2.removeAllItems();
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select distinct(session) from seatchart where dt='"+t1.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                            t2.addItem(rs.getString(1));
                        }
                   
                   }catch(Exception e1){}
                    
                }
            });
            t2.addItemListener(new ItemListener()
            {

                @Override
                public void itemStateChanged(ItemEvent e)
                {
                   try
                   {
                        jComboBox1.removeAllItems();
                        jComboBox2.removeAllItems();
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select blockno from seatchart where dt='"+t1.getSelectedItem().toString()+"' and session='"+t2.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                            jComboBox1.addItem(rs.getString(1));
                        }
                   
                   }catch(Exception e1){}
                    
                }
            });
           
        
           jComboBox1.addItemListener(new ItemListener()
           {

               @Override
               public void itemStateChanged(ItemEvent e)
               {
                   blck = jComboBox1.getSelectedItem().toString();
                   tm = t2.getSelectedItem().toString();
                   dte = t1.getSelectedItem().toString();
                   jComboBox2.removeAllItems();
                   try
                   {
                       
                         Statement st2 = cn.createStatement();
                         ResultSet rs2 = st2.executeQuery("select * from seatchart where dt='"+dte+"' and session='"+tm+"' and blockno='"+blck+"'");
                         
                         while(rs2.next())
                         {
                            sc2 = rs2.getString(6).split(",");
                         }
                         for(int i=0;i<sc2.length;i++)
                         {
                            jComboBox2.addItem(sc2[i].toUpperCase());
                         }
                         
                   }
                   catch (Exception e1){JOptionPane.showMessageDialog(null,e); }
               }
           });
       }
       catch (Exception e){JOptionPane.showMessageDialog(null,e);}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        yrs = new javax.swing.JLabel();
        mst = new javax.swing.JLabel();
        crs = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        tm1 = new javax.swing.JLabel();
        tm2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        pcode = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        sublb = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        t1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        t2 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 665));
        setPreferredSize(new java.awt.Dimension(709, 610));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANSWERBOOK SLIP");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(99, 7, 600, 63);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("CENTER CODE : ");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(10, 10, 110, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("MASTER :");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(490, 10, 70, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("COURSE : ");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(200, 10, 70, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("YEAR : ");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(370, 10, 50, 30);

        yrs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        yrs.setText("-");
        jPanel4.add(yrs);
        yrs.setBounds(420, 10, 50, 30);

        mst.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mst.setText("-");
        jPanel4.add(mst);
        mst.setBounds(560, 10, 80, 30);

        crs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        crs.setText("-");
        jPanel4.add(crs);
        crs.setBounds(270, 10, 80, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("TIME :");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(330, 60, 50, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("0131");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel14);
        jLabel14.setBounds(120, 10, 50, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("TO");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(440, 60, 30, 30);

        date.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        date.setText("-");
        jPanel4.add(date);
        date.setBounds(60, 60, 160, 30);

        tm1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tm1.setText("-");
        jPanel4.add(tm1);
        tm1.setBounds(380, 60, 60, 30);

        tm2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tm2.setText("-");
        jPanel4.add(tm2);
        tm2.setBounds(470, 60, 60, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("DATE :");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(10, 60, 50, 30);

        pcode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        pcode.setText("-");
        jPanel4.add(pcode);
        pcode.setBounds(130, 100, 130, 30);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("PAPER CODE :");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(10, 100, 100, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText(" SUBJECT : ");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(10, 140, 73, 30);

        sublb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sublb.setText("-");
        jPanel4.add(sublb);
        sublb.setBounds(90, 140, 530, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("NO. OF ANS. BOOK :");
        jPanel4.add(jLabel21);
        jLabel21.setBounds(10, 180, 130, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("MARKSHEET NO. :");
        jPanel4.add(jLabel23);
        jLabel23.setBounds(290, 180, 120, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jTextField1);
        jTextField1.setBounds(140, 180, 70, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("SEALING TIME :");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(300, 230, 100, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jTextField2);
        jTextField2.setBounds(420, 180, 180, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("SEALED ON :");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(10, 230, 90, 30);

        jLabel22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel4.add(jLabel22);
        jLabel22.setBounds(410, 230, 190, 30);

        jLabel26.setText("OFFICER IN-CHARGE");
        jPanel4.add(jLabel26);
        jLabel26.setBounds(400, 320, 140, 30);

        jLabel27.setText("SEALING SUPERVISOR");
        jPanel4.add(jLabel27);
        jLabel27.setBounds(110, 320, 110, 30);

        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(jTextField3);
        jTextField3.setBounds(100, 230, 150, 30);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(20, 80, 650, 350);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("MAHARASHTRA STATE BOARD OF TECHNICAL EDUCAITON, MUMBAI.");
        jPanel5.add(jLabel2);
        jLabel2.setBounds(10, 0, 550, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("INSTITUTE : GOVERNMENT POLYTECHNIC, MIRAJ");
        jPanel5.add(jLabel3);
        jLabel3.setBounds(20, 30, 490, 20);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(110, 10, 560, 60);

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jLabel13);
        jLabel13.setBounds(20, 10, 80, 60);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 180, 690, 440);

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(null);

        t1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(t1);
        t1.setBounds(90, 17, 150, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("DATE");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(20, 20, 34, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("SCHEME");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(20, 60, 60, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(jComboBox2);
        jComboBox2.setBounds(90, 60, 140, 30);

        t2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.add(t2);
        t2.setBounds(300, 17, 150, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TIME");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(250, 17, 30, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("BLOCK");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(470, 17, 50, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(520, 17, 100, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setText("CANCEL");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);
        jButton2.setBounds(390, 60, 110, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(260, 60, 110, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setText("PRINT");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(520, 60, 100, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 74, 690, 100);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logs/KPMS.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel28.setInheritsPopupMenu(false);
        jPanel1.add(jLabel28);
        jLabel28.setBounds(10, 5, 80, 65);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        new ansSlip().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       schme=jComboBox2.getSelectedItem().toString().split("-");
       dte=t1.getSelectedItem().toString();
       date.setText(dte);
       crs.setText(schme[0]);
       yrs.setText(schme[1]);
       mst.setText(schme[2]);
       String tme[];
      
       try
        {
           Statement st = cn.createStatement();
           ResultSet rs = st.executeQuery("select * from timetable2020 where dt='"+dte+"' and scheme like '"+jComboBox2.getSelectedItem().toString()+"' or scheme like '"+jComboBox2.getSelectedItem().toString()+"'");
           while(rs.next())
           {
              tme=rs.getString("tm").split(",");
              tm1.setText(tme[0]);
              tm2.setText(tme[1]);
              pcode.setText(rs.getString("code"));
              sublb.setText(rs.getString("sub"));
           }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed
   
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setJobName("print");
        job.setPrintable(new Printable()
            {

                public int print(Graphics pg, PageFormat pf, int pn)
                {
                    if(pn>0)
                    return Printable.NO_SUCH_PAGE;

                    Graphics2D g2= (Graphics2D)pg;
                    g2.translate(30,30);
                    g2.scale(0.7,0.9);
                    jPanel2.print(g2);

                    return Printable.PAGE_EXISTS;
                }
            });
            if(job.printDialog()==true)
            {

                try
                {
                    job.print();
                }
                catch(Exception e){}
            }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new ansSlip().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crs;
    private javax.swing.JLabel date;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel mst;
    private javax.swing.JLabel pcode;
    private javax.swing.JLabel sublb;
    private javax.swing.JComboBox t1;
    private javax.swing.JComboBox t2;
    private javax.swing.JLabel tm1;
    private javax.swing.JLabel tm2;
    private javax.swing.JLabel yrs;
    // End of variables declaration//GEN-END:variables
}
