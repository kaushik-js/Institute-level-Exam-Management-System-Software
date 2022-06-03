package majorproject;

import com.sun.jmx.snmp.BerDecoder;
import com.sun.org.apache.xalan.internal.lib.Extensions;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class All_blck_chart extends javax.swing.JFrame {
    Object[] strt = new Object[100];
    Object[] ed = new Object[100];
    Connection cn;  
    int i=0,c=0,l=0;
    int s[]=new int[1000];
    int k[];
    DefaultTableModel model1;
    DefaultTableModel model;
    String dt="",time="";
    String tte="";
    String sub22="";
    String sub23="";
    
    Object ss[] =new Object[20];

    Object stt[] = new Object[20];
    Object edd[]=new Object[20];
    Object bbl[] = new Object[20];
    
    public All_blck_chart() 
    {
       
       
        
        initComponents();
        model1 = new DefaultTableModel();
        model1.addColumn("DATE");
        model1.addColumn("TIME");
        jTable2.setModel(model1);
        try
        {
            jComboBox1.addItem("SELECT");
            jComboBox2.addItem("MORNING");jComboBox2.addItem("AFTERNOON");
            
            cn = DriverManager.getConnection("jdbc:odbc:gpm");
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select distinct(dt) from timetable2020");
            while(rs.next())
            {
                jComboBox1.addItem(rs.getString(1));
            }
            
            
            model1 = new DefaultTableModel();
            model1.addColumn("DATE");
            model1.addColumn("TIME");
            jTable2.setModel(model1);
            Statement st23 = cn.createStatement();
            ResultSet rs23= st23.executeQuery("select distinct(dt),session from seatchart");
            while(rs23.next())
            {
                model1.addRow(new Object[]{rs23.getString(1),rs23.getString(2)});
            }
        }
        catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        
      }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BLOCK SEATING CHART");
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(830, 600));
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("DATE");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 20, 50, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("TIME");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 60, 50, 30);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(80, 20, 130, 30);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.add(jComboBox2);
        jComboBox2.setBounds(80, 60, 130, 30);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("SAVE");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(370, 50, 130, 40);

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("ARRANGE");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(230, 10, 130, 80);

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
        jPanel1.add(jButton3);
        jButton3.setBounds(370, 10, 130, 30);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(10, 90, 540, 110);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {}
            },
            new String []
            {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(10, 210, 540, 340);

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ARRANGEMENT OF SEATING BLOCKS");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel1.setOpaque(true);
        jPanel2.add(jLabel1);
        jLabel1.setBounds(100, 10, 450, 70);

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(570, 110, 230, 440);

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VIEW ARRANGEMENT");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel2.setOpaque(true);
        jPanel2.add(jLabel2);
        jLabel2.setBounds(570, 10, 230, 40);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logs/KPMS.png"))); // NOI18N
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jLabel3.setInheritsPopupMenu(false);
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 10, 80, 65);

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("DELETE PREVIOUS");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButton4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(570, 60, 230, 40);

        getContentPane().add(jPanel2, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        model = new DefaultTableModel();
        model.addColumn("BLOCK NO");
        model.addColumn("SEAT NO");
        model.addColumn("SCHEME");
        jTable1.setModel(model);
        int start=0,end=0,str=0;
        dt=jComboBox1.getSelectedItem().toString();
        time=jComboBox2.getSelectedItem().toString();
        
        int mm=0;
        String sub1="";
        int ti=0;
        if(time.equals("AFTERNOON"))
           ti=2;
        if(time.equals("MORNING"))
           ti=9;
       
        try
        {
            Statement st1 = cn.createStatement();
            ResultSet rs1=st1.executeQuery("select * from timetable2020 where dt='"+dt+"' and val(left(tm,2)) = "+ti);
            String sub;
            int len;
            while(rs1.next())
            {
                sub=rs1.getString(5);
                mm=subject(sub);
            }
            Arrays.sort(s,0,mm);
            k = new int[mm];
            for(int k1=0;k1<mm;k1++)
            {
                k[k1]=s[k1];
            }
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from blockstr");
            while(rs.next())
            {
                str=rs.getInt(3);
                end=(start+str)-1;
               
                if(end>mm)
                {
                   String block=rs.getString(2);
                   bbl[i]=block;
                   stt[i]=k[start];
                   edd[i]=k[mm-1];
                   getSub(block,start,(mm-1),i);
                   break;
                }
                else
                {                    
                    String block=rs.getString(2);
                    bbl[i]=block;
                    stt[i]=k[start];
                    edd[i]=k[end];
                    getSub(block,start,end,i);
                }
                start=end+1;
                i++;
            }
            JOptionPane.showMessageDialog(null,"DONE");
          
        }catch(Exception e){JOptionPane.showMessageDialog(null,"NO SCHEDULE !!");};
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void getSub(String block,int start,int end,int y)
    {
        try
        {
            String s1="";
            String s2="";
            Statement st99 = cn.createStatement();
            ResultSet rs99 = st99.executeQuery("select distinct(scheme) from student2020 where seat between '"+k[start]+"' and '"+k[end]+"'");
            int kk=0;
            while(rs99.next())
            {
                s1=s1+","+rs99.getString(1);
            }
            s2=s1.substring(1);
            
            
            String sub1[]=s2.split(",");
            
            sub23=sub22.substring(1);
            String sub33="";
            
            String sub2[]=sub23.split(",");
            
            for(int ia=0;ia<sub1.length;ia++)
            {
                for(int ib=0;ib<sub2.length;ib++)
                {
                    if(sub2[ib].equals(sub1[ia]))
                    {
                        sub33=sub33+","+sub1[ia];
                    }
                }
            }
            ss[y]=sub33.substring(1);
            
            model.addRow(new Object[]{block,k[start]+" to "+k[end],ss[y]});
            
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        
    }
    int subject(String sub)
    {
        try
        { 
            sub22=sub22+","+sub;
            int sr=0;
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("select * from student2020 where scheme='%"+sub.trim()+"' or scheme='"+sub.trim()+"'");
            
            while(rs.next())
            {
                sr=rs.getInt("seat");
                s[c] = sr;
                c++;
            }
            
            
        }catch(Exception e){JOptionPane.showMessageDialog(null,e);}
        return c;
    }  
    
       
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            model = new DefaultTableModel();
            model.addColumn("BLOCK NO");
            model.addColumn("SEAT NO");
            model.addColumn("SCHEME");
            jTable1.setModel(model);
            int ti=0;
            if(time.equals("AFTERNOON"))
               ti=2;
            if(time.equals("MORNING"))
               ti=9;
                      
            Statement st33 = cn.createStatement();
            ResultSet rs33 = st33.executeQuery("select distinct(tm) from timetable2020 where dt='"+dt+"' and val(left(tm,2)) = "+ti);
            while(rs33.next())
            {
                tte=tte+rs33.getString(1)+" and ";
            }
            tte=tte.substring(0,(tte.length()-4)).trim();
            for(int jj=0;jj<=i;jj++)
            {
                 PreparedStatement ps = cn.prepareStatement("insert into seatchart values(?,?,?,?,?,?,?)");
                 ps.setString(1,dt);
                 ps.setString(2,tte);
                 ps.setString(3,""+bbl[jj]);
                 ps.setString(4,""+stt[jj]);
                 ps.setString(5,""+edd[jj]);
                 ps.setString(6,""+ss[jj]);
                 ps.setString(7,""+jComboBox2.getSelectedItem().toString());
                 ps.execute();                 
            }
            model1 = new DefaultTableModel();
            model1.addColumn("DATE");
            model1.addColumn("TIME");
            jTable2.setModel(model1);
            Statement st23 = cn.createStatement();
            ResultSet rs23= st23.executeQuery("select distinct(dt),session from seatchart");
            while(rs23.next())
            {
                model1.addRow(new Object[]{rs23.getString(1),rs23.getString(2)});
            }
           
            JOptionPane.showMessageDialog(null,"SAVED !!!");
            
        }catch(Exception e){JOptionPane.showMessageDialog(null, e);};
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            
          new All_blck_chart().setVisible(true);
          this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        try
        {
            Statement st23 = cn.createStatement();
            st23.execute("delete from seatchart");
            DefaultTableModel model55 = new DefaultTableModel();
            model55.addColumn("DATE");
            model55.addColumn("TIME");
            jTable2.setModel(model55);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(All_blck_chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(All_blck_chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(All_blck_chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(All_blck_chart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new All_blck_chart().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables

    
}
