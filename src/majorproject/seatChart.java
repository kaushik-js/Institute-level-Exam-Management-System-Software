package majorproject;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.*;
import java.util.Arrays;
import javax.print.event.PrintJobEvent;
import javax.swing.table.DefaultTableModel;

public class seatChart extends javax.swing.JFrame {
    Connection cn;
    String dt;
    String tm; 
    String sno;
    int seat[] ;
    JLabel snc[];
    JLabel bnc[];
    JLabel scm[];
    String sch[];
    public seatChart()
    {
       initComponents();
        
       try
       { 
            cn=DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st33=cn.createStatement();
            ResultSet rs33=st33.executeQuery("select * from blockstr");
            while(rs33.next())
            {
                jComboBox1.addItem(rs33.getString("blockno"));
            }
            
            
            cn = DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            jTextField1.addItem("SELECT");
            ResultSet rs = st.executeQuery("select distinct(dt) from seatchart");
            while(rs.next())
            {
                jTextField1.addItem(rs.getString(1));
            }
            jTextField1.addItemListener(new ItemListener()
            {

                @Override
                public void itemStateChanged(ItemEvent e)
                {
                   try
                   {
                        jTextField2.removeAllItems();
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select distinct(session) from seatchart where dt='"+jTextField1.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                            jTextField2.addItem(rs.getString(1));
                        }
                   
                   }catch(Exception e1){}
                    
                }
            });
            jTextField2.addItemListener(new ItemListener()
            {

                @Override
                public void itemStateChanged(ItemEvent e)
                {
                   try
                   {
                        jComboBox1.removeAllItems();
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select blockno from seatchart where dt='"+jTextField1.getSelectedItem().toString()+"' and session='"+jTextField2.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                            jComboBox1.addItem(rs.getString(1));
                        }
                   
                   }catch(Exception e1){}
                    
                }
            });
            
            
            
            
       }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
      snc = new JLabel[40];
      bnc = new JLabel[40];
      scm = new JLabel[40];
          for(int i=0;i<10;i++)
          {
              snc[i] = new JLabel("");
              snc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              bnc[i] = new JLabel("");
              bnc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              scm[i] = new JLabel("");
              scm[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              
              jp1.add(snc[i]);
              jp1.add(bnc[i]);
              jp1.add(scm[i]);
     
          }
          for(int i=19;i>=10;i--)
          {
              snc[i] = new JLabel("");
              snc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              bnc[i] = new JLabel("");
              bnc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              scm[i] = new JLabel("");
              scm[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              
              jp2.add(snc[i]);
              jp2.add(bnc[i]);
              jp2.add(scm[i]);
     
          }
          for(int i=20;i<30;i++)
          {
              snc[i] = new JLabel("");
              snc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              bnc[i] = new JLabel("");
              bnc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              scm[i] = new JLabel("");
              scm[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              
              jp3.add(snc[i]);
              jp3.add(bnc[i]);
              jp3.add(scm[i]);
     
          }
          for(int i=39;i>=30;i--)
          {
              snc[i] = new JLabel("");
              snc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              bnc[i] = new JLabel("");
              bnc[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              scm[i] = new JLabel("");
              scm[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
              
              jp4.add(snc[i]);
              jp4.add(bnc[i]);
              jp4.add(scm[i]);
     
          }
      
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jp = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dt_lb = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tm_lb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bl_lb = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        scheme_lb = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jp4 = new javax.swing.JPanel();
        jp1 = new javax.swing.JPanel();
        jp2 = new javax.swing.JPanel();
        jp3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        dt_label = new javax.swing.JLabel();
        session_label = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        block_label = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SEATING CHART");
        setMinimumSize(new java.awt.Dimension(840, 770));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel1.setLayout(null);

        jp.setBackground(new java.awt.Color(255, 255, 255));
        jp.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GOVERNMENT POLYTECHNIC MIRAJ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jp.add(jLabel1);
        jLabel1.setBounds(10, 10, 770, 50);

        dt_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dt_lb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dt_lb.setText("-");
        jp.add(dt_lb);
        dt_lb.setBounds(100, 70, 140, 20);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DATE :");
        jp.add(jLabel3);
        jLabel3.setBounds(20, 70, 60, 20);

        tm_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tm_lb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        tm_lb.setText("-");
        jp.add(tm_lb);
        tm_lb.setBounds(500, 70, 90, 20);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("TIME : ");
        jp.add(jLabel4);
        jLabel4.setBounds(400, 70, 70, 20);

        bl_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bl_lb.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bl_lb.setText("-");
        jp.add(bl_lb);
        bl_lb.setBounds(100, 100, 160, 20);

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BLOCK :");
        jp.add(jLabel5);
        jLabel5.setBounds(20, 100, 70, 20);

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jp.add(jLabel2);
        jLabel2.setBounds(5, 5, 780, 60);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("SCHEME :");
        jp.add(jLabel6);
        jLabel6.setBounds(400, 100, 80, 21);

        scheme_lb.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        scheme_lb.setText("-");
        jp.add(scheme_lb);
        scheme_lb.setBounds(500, 100, 280, 20);

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jp.add(jLabel8);
        jLabel8.setBounds(10, 130, 770, 10);

        jp4.setBackground(new java.awt.Color(255, 255, 255));
        jp4.setLayout(new java.awt.GridLayout(10, 3, 10, 5));
        jp.add(jp4);
        jp4.setBounds(610, 170, 160, 350);

        jp1.setBackground(new java.awt.Color(255, 255, 255));
        jp1.setLayout(new java.awt.GridLayout(10, 3, 10, 5));
        jp.add(jp1);
        jp1.setBounds(30, 170, 160, 350);

        jp2.setBackground(new java.awt.Color(255, 255, 255));
        jp2.setLayout(new java.awt.GridLayout(10, 3, 10, 5));
        jp.add(jp2);
        jp2.setBounds(220, 170, 160, 350);

        jp3.setBackground(new java.awt.Color(255, 255, 255));
        jp3.setLayout(new java.awt.GridLayout(10, 3, 10, 5));
        jp.add(jp3);
        jp3.setBounds(420, 170, 160, 350);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("<-- DOOR    ");
        jLabel7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        jp.add(jLabel7);
        jLabel7.setBounds(710, 150, 70, 16);

        jPanel1.add(jp);
        jp.setBounds(10, 190, 800, 530);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        dt_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dt_label.setForeground(new java.awt.Color(0, 0, 51));
        dt_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        dt_label.setText("DATE");
        jPanel2.add(dt_label);
        dt_label.setBounds(10, 10, 80, 30);

        session_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        session_label.setForeground(new java.awt.Color(0, 0, 51));
        session_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        session_label.setText("SESSION");
        jPanel2.add(session_label);
        session_label.setBounds(200, 10, 90, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(400, 40, 150, 30);

        block_label.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        block_label.setForeground(new java.awt.Color(0, 0, 51));
        block_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        block_label.setText("BLOCK NO");
        jPanel2.add(block_label);
        block_label.setBounds(420, 10, 110, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(570, 10, 120, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("SEARCH");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(570, 50, 120, 30);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("PRINT");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(700, 10, 90, 70);

        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(210, 40, 150, 30);

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(10, 40, 150, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 90, 800, 90);

        jLabel9.setBackground(new java.awt.Color(0, 0, 255));
        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("SEATING ARRANGEMENT AS PER BLOCK");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel9.setOpaque(true);
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 10, 800, 70);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) 
    {
       try
       {
           int flag=0;
           int str=0;
           dt=jTextField1.getSelectedItem().toString();
           tm=jTextField2.getSelectedItem().toString();
           sno=jComboBox1.getSelectedItem().toString();
           
          dt_lb.setText(""+dt);
          tm_lb.setText(""+tm);
          bl_lb.setText(""+sno);
                  
           
           Statement st  = cn.createStatement();
           ResultSet rs = st.executeQuery("select * from seatchart where dt='"+dt+"' and session='"+tm+"' and blockno='"+sno+"'");
           
           while(rs.next())
           {
               flag=1;
               blockseat(rs.getString(4),rs.getString(5),rs.getString(6),sno);
           }
           if(flag==0)
               JOptionPane.showMessageDialog(null,"NO RECORD FOUND !!!");
       }
       catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }                                        

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        new seatChart().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
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
                 jp.print(g2);
                 
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
    }//GEN-LAST:event_jButton4ActionPerformed
    public void blockseat(String start,String end,String scheme,String sno)
    {
        scheme_lb.setText(scheme);
        try
        {
            int strt = Integer.parseInt(start);
            int ed = Integer.parseInt(end);
            String sc[]=scheme.split(",");
            int len=0;
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("select * from blockstr where blockno='"+sno+"'");
            while(rs2.next())
            {
                len=rs2.getInt(3);
            }
            seat = new int[len];
            int h=0;
            for(int i=0;i<sc.length;i++)
            {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM student2020 WHERE scheme='"+sc[i]+"' and seat between '"+start+"' and '"+end+"'");
                while(rs.next())
                {
                    
                    seat[h]=rs.getInt("seat");
                    h++;
                }
            }
            //Arrays.sort(seat);
            
            for(int o=0;o<seat.length;o++)
            {
                if(seat[o]!=0)
                {snc[o].setHorizontalAlignment(JLabel.CENTER);
                bnc[o].setHorizontalAlignment(JLabel.CENTER);
                scm[o].setHorizontalAlignment(JLabel.CENTER);
                
                snc[o].setFont(new Font("Arial", 1, 11));
                bnc[o].setFont(new Font("Arial", 1, 11));
                scm[o].setFont(new Font("Arial", 1, 11)); 
                
                String schm="";
                snc[o].setText(""+(o+1));
                bnc[o].setText(""+seat[o]);
                Statement s45 = cn.createStatement();
                ResultSet rs45 = s45.executeQuery("select scheme from student2020 where seat='"+seat[o]+"'");
                while(rs45.next())
                {
                   schm=rs45.getString(1);
                }
                scm[o].setText(schm);
            }}
            
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
     private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) 
     {
         
         
     }
    
   
    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new seatChart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bl_lb;
    private javax.swing.JLabel block_label;
    private javax.swing.JLabel dt_label;
    private javax.swing.JLabel dt_lb;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox jTextField1;
    private javax.swing.JComboBox jTextField2;
    private javax.swing.JPanel jp;
    private javax.swing.JPanel jp1;
    private javax.swing.JPanel jp2;
    private javax.swing.JPanel jp3;
    private javax.swing.JPanel jp4;
    private javax.swing.JLabel scheme_lb;
    private javax.swing.JLabel session_label;
    private javax.swing.JLabel tm_lb;
    // End of variables declaration//GEN-END:variables
}
