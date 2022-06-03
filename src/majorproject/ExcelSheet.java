package majorproject;
import java.io.File;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.*;

public class ExcelSheet extends javax.swing.JFrame {
File file;
FileInputStream fis;
XSSFWorkbook wb=null;
XSSFSheet sheet=null;
XSSFRow row=null;
XSSFCell cell=null;
  int abhi=0;
        int cc=0;
        Connection cn=null;
DefaultTableModel  model;
    public ExcelSheet() 
    {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jt = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EXCEL FILE");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(740, 560));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        setPreferredSize(new java.awt.Dimension(740, 560));
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(null);

        jt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null, null}
            },
            new String []
            {
                " ", " ", " ", " "
            }
        ));
        jt.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(jt);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 700, 370);

        jLabel1.setBackground(new java.awt.Color(0, 51, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IMPORT EXCEL FILE OF ELIGIBLE STUDENT ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 10, 700, 50);

        jPanel2.setBackground(new java.awt.Color(255, 255, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("CHOOSE EXCEL SHEET");
        jButton1.setToolTipText("click to choose excel file");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(10, 10, 300, 40);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(320, 10, 170, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("DELETE PREVIOUS");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(500, 10, 190, 40);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(10, 70, 700, 60);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DataFormatter dataFormatter = new DataFormatter();
        String cellValue;
        JFileChooser jf =  new JFileChooser();
        jf.showOpenDialog(null);
        file = jf.getSelectedFile();
        model = new DefaultTableModel();
        jt.setModel(model);
        try{
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
        }catch(IOException e){JOptionPane.showMessageDialog(null,e);}
        sheet = wb.getSheetAt(0);
        int rc =sheet.getLastRowNum();
        
        String query;
        for(int i=0;i<=rc;i++)
        {
            try
            {
                row=sheet.getRow(i);
                cell=row.getCell(0);
                String s= (cell.getStringCellValue()).toLowerCase().trim();
                if(s.equals("sr no") || s.equals("sr"))
                {
                    abhi=i;
                    cc=row.getLastCellNum();
                }
            }catch(Exception e)
            {continue;}
        }
        for(int m=0;m<cc;m++)
        {
            row=sheet.getRow(abhi);
            cell=row.getCell(m);
            model.addColumn(""+cell);
            try{
                cn = DriverManager.getConnection("jdbc:odbc:gpm");
                Statement st = cn.createStatement();
                query="ALTER TABLE studinfo add COLUMN "+cell.getStringCellValue().replace(" ","_")+" varchar(25)";
                st.execute(query);
            }catch(Exception e){}
        }
        
        int i;
        Object[] o=new Object[10];
        for(int k=abhi+1;k<=rc;k++)
        {
            i=0;
            o = new Object[10];
            row=sheet.getRow(k);
            for(i=0;i<cc;i++)
            {
                cell=row.getCell(i);
                cellValue = dataFormatter.formatCellValue(cell);
                o[i]=(Object)cellValue.trim();
            }
            model.addRow(o);
        }
        JOptionPane.showMessageDialog(null,"DONE...!!!");

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       String query;
       String dt="";
       String dt1="";
       try
       {
        int op=JOptionPane.showConfirmDialog(null,"Are you Sure You want to delete previous data and save it !!!","CONFIRM YOUR CHOICE",YES_NO_OPTION);
        if(op==0)
        {
           cn = DriverManager.getConnection("jdbc:odbc:gpm");
           Statement st11 = cn.createStatement();
           Statement st12 = cn.createStatement();
           st11.execute("drop table student2020");
           st12.execute("create table student2020(id int)");    
        } 
           
       Connection cn = DriverManager.getConnection("jdbc:odbc:gpm");
       Statement st2 = cn.createStatement();
       Statement st1 = cn.createStatement();
       for(int m=0;m<cc;m++)
       {
           row=sheet.getRow(abhi);
           cell=row.getCell(m);
           Statement st = cn.createStatement();
           query="ALTER TABLE student2020 add COLUMN "+cell.getStringCellValue().replace(" ","_")+" varchar(25)";
           st.execute(query);
        }
        st1.execute("alter table student2020 drop column id");
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        try
        {
            Statement st = cn.createStatement();
            int rcnt = jt.getRowCount();
            int ccnt = jt.getColumnCount();
            st.execute("alter table student2020 alter column sr int");
            int j=0;
        int i=0;
        String col = "(?";
        for(int m=1;m<ccnt;m++)
        {
            col=col+",?";
        }
        col=col+")";
       PreparedStatement ps = cn.prepareStatement("insert into student2020 values"+col);
       String nm="";
       for(i=0;i<rcnt;i++)
       {
        j=0;
        String nm1="";
        for(j=0;j<ccnt;j++)
        {
            
            nm=jt.getValueAt(i,j).toString().trim();
            if(j==0)
            {
                ps.setInt(1,Integer.parseInt(nm));
            }
            else
            {
                if(j==4)
                {
                    nm=nm.substring(nm.length()-6,nm.length());
                }
                ps.setString((j+1),nm.trim());
            }
        }
        ps.execute();
       }
       JOptionPane.showMessageDialog(null,"DONE");
       }
        catch(Exception e)
        { JOptionPane.showMessageDialog(null,e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
       try
       {
          

           JOptionPane.showMessageDialog(null,"DELETED !!!");
           
       }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExcelSheet().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jt;
    // End of variables declaration//GEN-END:variables
}
