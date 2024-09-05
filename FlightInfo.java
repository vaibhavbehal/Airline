package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
//import java.awt.event.*;
import net.proteanit.sql.DbUtils;
 
public class FlightInfo extends JFrame { 
    public FlightInfo(){  
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JTable table =new JTable();  
           
        try{
             
         Conn conn=new Conn(); 
         ResultSet rs=conn.s.executeQuery("select * from flight");    
//ResultSet rs = conn.s.executeQuery("SELECT f.f_code, f.f_name, f.source, f.destination, p.name, p.nationality FROM flight f JOIN passenger p ON f.f_code = p.f_code");
//
        table.setModel(DbUtils.resultSetToTableModel (rs)); 
        }catch(Exception e){ 
            e.printStackTrace();   
        }   
//        table.setBounds(0,0,800,500);   
//        add(table);         
        JScrollPane jsp=new JScrollPane(table);  
        jsp.setBounds(0, 0, 800, 500);
        add(jsp); 
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
          
    }
public static void main(String[]args){
    new FlightInfo();
}      
}






