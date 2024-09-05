//package airlinemanagementsystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.sql.*;
////import com.toedter.calendar.JDateChooser;
//import java.util.*;
//
//public class BoardingPass extends JFrame implements ActionListener {
//    JTextField tfpnr;
//    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode,labeldate;
//    JButton  fetchbutton;
////    Choice source, destination; 
//          
//     
//    public BoardingPass() {
//        getContentPane().setBackground(Color.white);
//        setLayout(null);
//
//        JLabel heading = new JLabel("AIR INDIA");
//        heading.setBounds(380, 10, 450, 35);
//        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
////        heading.setForeground(Color.blue); 
//        add(heading);   
//        
//        JLabel subheading = new JLabel("BOARDING PASS");
//        subheading.setBounds(360, 50, 300, 30);
//        subheading.setFont(new Font("Tahoma", Font.PLAIN, 26));
//        subheading.setForeground(Color.blue); 
//        add(subheading);
//
//        JLabel lblaadhar = new JLabel("PNR DETAILS");
//        lblaadhar.setBounds(60, 100, 150, 25);
//        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblaadhar);
//
//        tfpnr = new JTextField();
//        tfpnr.setBounds(200, 80, 150, 25);
//        add(tfpnr);
//
//        fetchbutton = new JButton("ENTER");
//        fetchbutton.setBackground(Color.BLACK);
//        fetchbutton.setForeground(Color.WHITE);
//        fetchbutton.setBounds(380, 100, 120, 25);
//        fetchbutton.addActionListener(this);
//        add(fetchbutton);
//
//        JLabel lblname = new JLabel("Name");
//        lblname.setBounds(60, 140, 150, 25);
//        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblname);
//
//        tfname = new JLabel();
//        tfname.setBounds(220, 140, 150, 25);
//        add(tfname);
//
//        JLabel lblnationality = new JLabel("Nationality");
//        lblnationality.setBounds(60, 180, 150, 25);
//        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblnationality);
//
//        tfnationality = new JLabel();
//        tfnationality.setBounds(200, 180, 150, 25);
//        add(tfnationality);
//
//        JLabel lbladdress = new JLabel("SRC");
//        lbladdress.setBounds(60, 220, 150, 25);
//        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lbladdress);
//
//        lblsrc = new JLabel();
//        lblsrc.setBounds(200, 230, 150, 25);
//        add(lblsrc);
//
//        JLabel lblgender = new JLabel("DEST");
//        lblgender.setBounds(380, 210, 150, 25);
//        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblgender);
//
//        lbldest = new JLabel();
//        lbldest.setBounds(200, 280, 150, 25);
//        add(lbldest);
//
//
//        JLabel lblfname = new JLabel("Flight Name");
//        lblfname.setBounds(60, 260, 150, 25);
//        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblfname);
//
//        labelfname = new JLabel();
//        labelfname.setBounds(200, 430, 150, 25);
//        add(labelfname);
//
//        JLabel lblfcode = new JLabel("Flight Code");
//        lblfcode.setBounds(380, 260, 150, 25);
//        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lblfcode);
//
//        labelfcode = new JLabel();
//        labelfcode.setBounds(200, 260, 150, 25);
//        add(labelfcode);
//
//        JLabel lbldate = new JLabel("Date");
//        lbldate.setBounds(60, 300, 150, 25);
//        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        add(lbldate);
//
//        labeldate = new JLabel();
//        labeldate.setBounds(200, 300, 150, 25);
//        add(labeldate);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
//        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
//        ImageIcon image = new ImageIcon(i2);
//
//        JLabel lblimage = new JLabel(image);
//        lblimage.setBounds(600, 0, 300, 300);
//        add(lblimage);
//
//
//
//        setSize(1000, 450);
//        setLocation(300, 150);
//        setVisible(true);
//    }
//     public void actionPerformed(ActionEvent ae) {
////    if (ae.getSource() == fetchbutton) {
//        String pnr = tfpnr.getText(); 
//        try {
//            Conn conn = new Conn();
//            String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
//            ResultSet rs = conn.s.executeQuery(query);
//            
//                if (rs.next()) {
//                tfname.setText(rs.getString("name"));
//                  tfnationality.setText(rs.getString("nationality"));
//                 lblsrc.setText(rs.getString("source"));
//                 lbldest.setText(rs.getString("destination"));
//                 labelfname.setText(rs.getString("flightname"));
//                 labelfcode.setText(rs.getString("flightcode"));
//                labeldate.setText(rs.getString("ddate"));
//    
//            } else { 
//                JOptionPane.showMessageDialog(null, "Please enter correct Aadhar card ID");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } 
////} 
//}
//
//    public static void main(String[] args) {
//        new BoardingPass();
//    }
//}   



package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame implements ActionListener {
    JTextField tfpnr; 
    JLabel tfname, tfnationality, lblsrc, lbldest, labelfname, labelfcode, labeldate;
    JButton fetchbutton;
          
    public BoardingPass() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380, 10, 450, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        add(heading);   
        
        JLabel subheading = new JLabel("BOARDING PASS");
        subheading.setBounds(360, 50, 300, 30);
        subheading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        subheading.setForeground(Color.blue); 
        add(subheading);

        JLabel lblaadhar = new JLabel("PNR DETAILS");
        lblaadhar.setBounds(60, 100, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfpnr = new JTextField();
        tfpnr.setBounds(200, 100, 150, 25);
        add(tfpnr);

        fetchbutton = new JButton("ENTER");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(380, 100, 120, 25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 140, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(220, 140, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25); 
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(220, 180, 150, 25);
        add(tfnationality);

        JLabel lblsrcs = new JLabel("SRC");
        lblsrcs.setBounds(60, 220, 150, 25);
        lblsrcs.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsrcs); 

        lblsrc = new JLabel();
        lblsrc.setBounds(220, 220, 150, 25);
        add(lblsrc);

        JLabel lblgender = new JLabel("DEST");
        lblgender.setBounds(60, 260, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        lbldest = new JLabel();
        lbldest.setBounds(220, 260, 150, 25);
        add(lbldest);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 300, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(220, 300, 150, 25);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 340, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(220, 340, 150, 25);
        add(labelfcode);

        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60, 380, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        labeldate = new JLabel();
        labeldate.setBounds(220, 380, 150, 25);
        add(labeldate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/airindia.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);

        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600, 0, 300, 300);
        add(lblimage);

        setSize(1000, 500);
        setLocation(300, 150);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        String pnr = tfpnr.getText(); 
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM reservation WHERE PNR = '" + pnr + "'";
            ResultSet rs = conn.s.executeQuery(query);
            
            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                lblsrc.setText(rs.getString("source"));
                lbldest.setText(rs.getString("destination"));
                labelfname.setText(rs.getString("flightname"));
                labelfcode.setText(rs.getString("flightcode"));
                labeldate.setText(rs.getString("ddate"));
    
            } else { 
                JOptionPane.showMessageDialog(null, "Please enter correct PNR details");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    public static void main(String[] args) {
        new BoardingPass();
    }
}
