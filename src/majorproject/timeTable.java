package majorproject;
import java.io.File;
import java.io.FileInputStream;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class timeTable extends javax.swing.JFrame 
{
    DefaultTableModel model;
    PreparedStatement ps11;
    File file;
    FileInputStream fis;
    XSSFWorkbook wb=null;
    XSSFSheet sheet=null;
    XSSFRow row=null;
    XSSFCell cell=null;
    Object dt[];
    String data[];
    Connection cn;
    int lastRow;
    public timeTable() 
    {
        setVisible(true);
        initComponents();
        try
        {
            cn = DriverManager.getConnection("jdbc:odbc:gpm");
        }catch(Exception e){}
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 530));
        setPreferredSize(new java.awt.Dimension(530, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        jTable1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTable1.setFillsViewportHeight(true);
        jTable1.setGridColor(new java.awt.Color(255, 255, 204));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 480, 320);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("GET EXCEL FILE");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(20, 90, 160, 40);

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("SAVE");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(390, 90, 110, 40);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("TIME TABLE");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 10, 400, 64);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("DELETE PREVIOUS");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(190, 90, 190, 40);

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logs/KPMS.png"))); // NOI18N
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel28.setInheritsPopupMenu(false);
        jPanel1.add(jLabel28);
        jLabel28.setBounds(10, 10, 80, 65);

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try
        {
            model  = new DefaultTableModel();
            jTable1.setModel(model);
            model.addColumn("DATE");
            model.addColumn("TIME");
            model.addColumn("CODE");
            model.addColumn("SUBJECT");
            model.addColumn("SCHEME");
            JFileChooser jf =  new JFileChooser();
            jf.showOpenDialog(null);
            file = jf.getSelectedFile();
            fis = new FileInputStream(file);
            wb = new XSSFWorkbook(fis);
            sheet = wb.getSheetAt(0);
            lastRow = sheet.getLastRowNum();
            int k=0;
            dt = new Object[50];
            
           
            for(int i=0;i<lastRow;i++)
            {
              try
              {
                row=sheet.getRow(i);
                if((row.getCell(0).toString().equals(" ") || row.getCell(0).toString().equals(" ") )|| row.getCell(0).toString()==null)
                {
                    continue;
                }
               
                if((((row.getCell(0).toString().substring(0,4).toUpperCase()).equals("DATE"))))
                {
                    dt[k]=row.getCell(0).toString().substring(5,16).trim(); 
                    i++;
                    k++;
                }
                else
                {
                    
                        String subj[] = row.getCell(3).toString().split(",");
                        for(int h=0;h<subj.length;h++)
                        {
                            model.addRow(new Object[]{dt[k-1].toString().trim(),row.getCell(0).toString().replace(" A.M. to ",",").replace(" P.M. to ",",").trim().replace(" P.M.","").replace(" A.M.",""),row.getCell(1).toString().trim().replace(".0",""),row.getCell(2).toString().trim(),subj[h].trim()});
                        }  
                               
                    
                }
              }catch(Exception e){continue;}
            }
            
              
        }
        catch (Exception e){JOptionPane.showMessageDialog(null,e);}
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    }//GEN-LAST:event_formWindowClosed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        try
        {
         
            int op=JOptionPane.showConfirmDialog(null,"Are you Sure You want to delete previous data and save it !!!","CONFIRM YOUR CHOICE",YES_NO_OPTION);
        if(op==0)
        {
             Statement st = cn.createStatement();
           Statement st2 = cn.createStatement();
           st.execute("drop table timetable2020");
           st2.execute("create table timetable2020(dt varchar(30),tm varchar(30),code varchar(10),sub varchar(100),scheme varchar(20))");

        }
            int j=0;
            int i=0;
            int rcnt=model.getRowCount();
            int ccnt=model.getColumnCount();
            String nm;
             ps11 = cn.prepareStatement("insert into timetable2020 values(?,?,?,?,?)");

            for(i=0;i<rcnt;i++)
            {
              
                j=0;
                for(j=0;j<ccnt;j++)
                {
                    nm = model.getValueAt(i,j).toString();
                    ps11.setString((j+1),nm);
                }
                ps11.execute();
       
            }
            JOptionPane.showMessageDialog(null,"DONE !!!");
        }
        catch (Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       try
       {
           Statement st = cn.createStatement();
           Statement st2 = cn.createStatement();
           st.execute("drop table timetable2020");
           st2.execute("create table timetable2020(dt varchar(30),tm varchar(30),code varchar(10),sub varchar(100),scheme varchar(20))");

           JOptionPane.showMessageDialog(null,"DELETED !!!");
           
       }catch(Exception e){JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton1ActionPerformed
  
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
                new timeTable();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
