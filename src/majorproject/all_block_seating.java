package majorproject;

import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.*;

public class all_block_seating extends javax.swing.JFrame {
    Connection cn=null;
    DefaultTableModel model;
    public all_block_seating() {
        initComponents();
        model = new DefaultTableModel();
        model.addColumn("BLOCK NO");
        model.addColumn("SEAT NO");
        model.addColumn("SCHEME");
        jTable1.setModel(model);
        try
        {
           
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
            
        }
        catch (Exception e)
        {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JComboBox();
        jTextField2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 700));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
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
        jScrollPane1.setBounds(10, 212, 680, 410);

        jPanel2.setBackground(new java.awt.Color(0, 0, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("DATE");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 50, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("SESSION");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(170, 10, 100, 30);

        jButton2.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton2.setText("SEARCH");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(340, 10, 90, 70);

        jButton3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(600, 10, 70, 70);

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(10, 50, 150, 30);

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(170, 50, 150, 30);

        jButton1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jButton1.setText("PRINT");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(440, 10, 150, 70);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 100, 680, 100);

        jLabel5.setBackground(new java.awt.Color(255, 255, 0));
        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ALL BLOCKS SEATING ARRANGEMENT");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5);
        jLabel5.setBounds(110, 20, 580, 70);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logs/KPMS.png"))); // NOI18N
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel4.setInheritsPopupMenu(false);
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 20, 80, 65);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try
        {
             String date = jTextField1.getSelectedItem().toString();
             String time = jTextField2.getSelectedItem().toString();
             Connection cn = DriverManager.getConnection("jdbc:odbc:gpm");
             Statement st = cn.createStatement();
             ResultSet rs = st.executeQuery("select * from seatchart where dt='"+date+"' and session='"+time+"'");
             while(rs.next())
             {
                 model.addRow(new Object[]{rs.getString(3),rs.getString(4)+" to "+rs.getString(5),rs.getString(6)});
             }
             
        }catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            Object dt = jTextField1.getSelectedItem().toString();
            Object tm = jTextField2.getSelectedItem().toString();
            File file = new File("\\Majorproject\\Reports\\allblocks.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook wb= new XSSFWorkbook(fis);
            XSSFSheet sheet=wb.getSheetAt(0);
            XSSFRow row=sheet.getRow(2);
            row.createCell(0).setCellValue((String) ("DATE : "+dt)); 
            XSSFRow row1=sheet.getRow(2);
            row1.createCell(2).setCellValue((String)("TIME : "+tm)); 
            int i=5;
            Object bno;
            Object seat;
            Object sc;
            
            for(int cc=5;cc<30;cc++)
            {
                try
                {
                    XSSFRow rx = sheet.getRow(cc);
                    sheet.removeRow(rx);
                }catch(Exception e){break;}
            }
            sheet.setPrintGridlines(false);
            CellStyle sty = wb.createCellStyle();
            XSSFFont ft = wb.createFont();
            ft.setFontHeightInPoints((short) 21);
            sty.setFont(ft);
            
            
            Connection cn = DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from seatchart where dt='"+dt+"' and session='"+tm+"'");
            
            while(rs.next())
            {
                XSSFRow row2=sheet.createRow(i);
                
                bno = rs.getString(3);
                XSSFCell cell10 = row2.createCell(0);
                CellStyle style = wb.createCellStyle();
                style.setWrapText(true);
                style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                style.setAlignment(CellStyle.ALIGN_CENTER);
                cell10.setCellStyle(style);
                cell10.setCellValue((String)bno);
                
                seat = rs.getString(4)+" to "+rs.getString(5);
                XSSFCell cell11 = row2.createCell(1);
                CellStyle style1 = wb.createCellStyle();
                style1.setWrapText(true);
                style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                style.setVerticalAlignment(CellStyle.ALIGN_CENTER);
                style1.setAlignment(CellStyle.ALIGN_CENTER);
                cell11.setCellStyle(style1);
                cell11.setCellValue((String)seat);
                
                sc = rs.getString(6);
                XSSFCell cell12 = row2.createCell(2);
                CellStyle style2 = wb.createCellStyle();
                style2.setWrapText(true);
                style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
                style2.setAlignment(CellStyle.ALIGN_CENTER);
                cell12.setCellStyle(style2);
                cell12.setCellValue((String)sc);
                i++;
            }
            FileOutputStream fileOut = new FileOutputStream(file); 
            wb.write(fileOut);
            wb.close();
            
            
            Desktop.getDesktop().print(file);
            
            
           JOptionPane.showMessageDialog(null,"DONE !!!");
                     
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
       new all_block_seating().setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
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
        new all_block_seating().setVisible(true);
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox jTextField1;
    private javax.swing.JComboBox jTextField2;
    // End of variables declaration//GEN-END:variables
}
