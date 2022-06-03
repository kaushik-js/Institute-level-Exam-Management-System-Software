package majorproject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author K A U S H I K
 */
public class blockseat extends javax.swing.JFrame
{
    int k=0;
    int str=0;
    int[] seat;
    Connection cn;
    String dt;
    String tm;
    String bno;
    String sch;
    public blockseat()
    {
        initComponents();
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
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery("select blockno from seatchart where dt='"+t1.getSelectedItem().toString()+"' and session='"+t2.getSelectedItem().toString()+"'");
                        while(rs.next())
                        {
                            jComboBox1.addItem(rs.getString(1));
                        }
                   
                   }catch(Exception e1){}
                    
                }
            });
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sublb = new javax.swing.JLabel();
        timelb = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtlb = new javax.swing.JLabel();
        blcklb = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        t1 = new javax.swing.JComboBox();
        t2 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 900));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GOVERNMENT POLTECHNIC MIRAJ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(jLabel1);
        jLabel1.setBounds(10, 10, 640, 30);

        sublb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sublb.setText("-");
        jPanel3.add(sublb);
        sublb.setBounds(100, 80, 340, 20);

        timelb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timelb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timelb.setText("-");
        jPanel3.add(timelb);
        timelb.setBounds(300, 50, 110, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("TIME");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(240, 50, 34, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("BLOCK");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(490, 50, 50, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("SCHEME");
        jPanel3.add(jLabel6);
        jLabel6.setBounds(30, 80, 60, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("DATE");
        jPanel3.add(jLabel7);
        jLabel7.setBounds(30, 50, 40, 17);

        dtlb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dtlb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dtlb.setText("-");
        jPanel3.add(dtlb);
        dtlb.setBounds(80, 50, 130, 17);

        blcklb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        blcklb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        blcklb.setText("-");
        jPanel3.add(blcklb);
        blcklb.setBounds(580, 50, 70, 15);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(10, 10, 660, 110);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(null);

        jLabel2.setText("TOTAL");
        jPanel4.add(jLabel2);
        jLabel2.setBounds(500, 10, 60, 14);

        jLabel3.setText("PRESENT");
        jPanel4.add(jLabel3);
        jLabel3.setBounds(60, 10, 60, 14);

        jLabel8.setText("ABSENT");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(280, 10, 60, 14);

        jLabel10.setText("SIGN OF OFFICER INCHARGE");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(370, 80, 150, 14);

        jLabel11.setText("SIGN OF SUPERVISOR");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(140, 80, 110, 14);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(10, 570, 660, 110);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "SR NO", "SEAT NO", "ANS.BOOK NO", "ATTENDANCE", "SIGN"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0)
        {
            jTable1.getColumnModel().getColumn(0).setMinWidth(45);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("SR NO");
            jTable1.getColumnModel().getColumn(1).setMinWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("SEAT NO");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("ANS.BOOK NO");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("ATTENDANCE");
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("SIGN");
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 330, 430);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String []
            {
                "SR NO", "SEAT NO", "ANS.BOOK NO", "ATTENDANCE", "SIGN"
            }
        ));
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0)
        {
            jTable2.getColumnModel().getColumn(0).setMinWidth(45);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(45);
            jTable2.getColumnModel().getColumn(0).setHeaderValue("SR NO");
            jTable2.getColumnModel().getColumn(1).setMinWidth(60);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable2.getColumnModel().getColumn(1).setHeaderValue("SEAT NO");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("ANS.BOOK NO");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("ATTENDANCE");
            jTable2.getColumnModel().getColumn(4).setMinWidth(50);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(4).setHeaderValue("SIGN");
        }

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(350, 130, 320, 430);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 160, 680, 690);

        jLabel12.setBackground(new java.awt.Color(0, 0, 255));
        jLabel12.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BLOCK WISE SEATING ARRANGEMENT ");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel12.setOpaque(true);
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 10, 680, 40);

        jPanel5.setBackground(new java.awt.Color(255, 255, 0));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel5.setLayout(null);

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 153));
        jLabel15.setText("DATE");
        jLabel15.setToolTipText("");
        jPanel5.add(jLabel15);
        jLabel15.setBounds(40, 10, 60, 30);

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 153));
        jLabel13.setText("TIME");
        jLabel13.setToolTipText("");
        jPanel5.add(jLabel13);
        jLabel13.setBounds(250, 10, 50, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1);
        jButton1.setBounds(100, 50, 150, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3);
        jButton3.setBounds(270, 50, 150, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("PRINT");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton2);
        jButton2.setBounds(440, 50, 150, 30);

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 153));
        jLabel9.setText("BLOCK");
        jLabel9.setToolTipText("");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(470, 10, 60, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jComboBox1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel5.add(jComboBox1);
        jComboBox1.setBounds(540, 10, 110, 30);

        t1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.add(t1);
        t1.setBounds(90, 10, 130, 30);

        t2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.add(t2);
        t2.setBounds(310, 10, 130, 30);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(10, 60, 680, 90);

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        try
       {
          
           int flag=0;
           dt=t1.getSelectedItem().toString();
           tm=t2.getSelectedItem().toString();
           bno=jComboBox1.getSelectedItem().toString();
           Statement st  = cn.createStatement();
          
           ResultSet rs = st.executeQuery("select * from seatchart where dt='"+dt+"' and session='"+tm+"' and blockno='"+bno+"'");
           while(rs.next())
           {
               flag=1;
               blockseat1(rs.getString(4),rs.getString(5),rs.getString(6),bno);
           }
           timelb.setText(tm);
           blcklb.setText(bno);
           dtlb.setText(dt);
           if(flag==0)
               JOptionPane.showMessageDialog(null,"NO RECORD FOUND !!!");
       }
       catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        new blockseat().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
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
                 jPanel1.print(g2);
                 
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jComboBox1ActionPerformed
    {//GEN-HEADEREND:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    public void blockseat1(String start,String end,String scheme,String bno)
    {
        try
        {
            sublb.setText(scheme);
            int strt = Integer.parseInt(start);
            int ed = Integer.parseInt(end);
            String sc[]=scheme.split(",");
            int len=0;
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery("select * from blockstr where blockno='"+bno+"'");
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
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("SRNO");
            model.addColumn("SEAT NO");
            model.addColumn("ANSBOOK NO");
            model.addColumn("ATTENDANCE");
            model.addColumn("SIGN");
            jTable1.setModel(model);
            if (jTable1.getColumnModel().getColumnCount() > 0)
            {
            jTable1.getColumnModel().getColumn(0).setMinWidth(45);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(45);
            jTable1.getColumnModel().getColumn(0).setHeaderValue("SR NO");
            jTable1.getColumnModel().getColumn(1).setMinWidth(60);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable1.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable1.getColumnModel().getColumn(1).setHeaderValue("SEAT NO");
            jTable1.getColumnModel().getColumn(2).setHeaderValue("ANS.BOOK NO");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("ATTENDANCE");
            jTable1.getColumnModel().getColumn(4).setMinWidth(50);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable1.getColumnModel().getColumn(4).setHeaderValue("SIGN");
            }
           /* for(int hh=0;hh<25;hh++)
            {
                if(seat[hh]!=0)
                {
                    model.addRow(new Object[]{hh+1,seat[hh]});
                }
            }*/
            DefaultTableModel model1 = new DefaultTableModel();
            model1.addColumn("SRNO");
            model1.addColumn("SEAT NO");
            model1.addColumn("ANSBOOK NO");
            model1.addColumn("ATTENDANCE");
            model1.addColumn("SIGN");
            jTable2.setModel(model1); 
            if (jTable2.getColumnModel().getColumnCount() > 0)
            {
            jTable2.getColumnModel().getColumn(0).setMinWidth(45);
            jTable2.getColumnModel().getColumn(0).setPreferredWidth(45);
            jTable2.getColumnModel().getColumn(0).setMaxWidth(45);
            jTable2.getColumnModel().getColumn(0).setHeaderValue("SR NO");
            jTable2.getColumnModel().getColumn(1).setMinWidth(60);
            jTable2.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable2.getColumnModel().getColumn(1).setMaxWidth(60);
            jTable2.getColumnModel().getColumn(1).setHeaderValue("SEAT NO");
            jTable2.getColumnModel().getColumn(2).setHeaderValue("ANS.BOOK NO");
            jTable2.getColumnModel().getColumn(3).setHeaderValue("ATTENDANCE");
            jTable2.getColumnModel().getColumn(4).setMinWidth(50);
            jTable2.getColumnModel().getColumn(4).setPreferredWidth(50);
            jTable2.getColumnModel().getColumn(4).setMaxWidth(50);
            jTable2.getColumnModel().getColumn(4).setHeaderValue("SIGN");
            }
            /*int kk=0;
            for(int hh=25;hh<(seat.length);hh++)
            {
                if(seat[hh]!=0)
                {
                    model.addRow(new Object[]{hh+1,seat[hh],"","",""});
                    kk=hh;
                }
            }
            for(int sb=kk+1;sb<50;sb++)
            {
                 model1.addRow(new Object[]{"","","","",""});
            }*/
            int c=0;int c1=0;
           for(int i=0;i<seat.length;i++)
            {
               if(seat[i]!=0)
               { 
                        if(i<25)
                        {
                            model.addRow(new Object[]{i+1,seat[i]});
                            c++;
                        }
                        else
                        {
                            model1.addRow(new Object[]{i+1,seat[i]});
                            c1++;
                        }
                       
               }    
                                         

                
            }
            int kk=0;
            for(int hh=c;hh<25;hh++)
            {
                model.addRow(new Object[]{"","","","",""});
                kk=hh;
            }
            for(int sb=c1;sb<25;sb++)
            {
                 model1.addRow(new Object[]{"","","","",""});
            }
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }
   
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
                new blockseat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel blcklb;
    private javax.swing.JLabel dtlb;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel sublb;
    private javax.swing.JComboBox t1;
    private javax.swing.JComboBox t2;
    private javax.swing.JLabel timelb;
    // End of variables declaration//GEN-END:variables
}
