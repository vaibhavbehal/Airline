//
package airlinemanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class BookFlight extends JFrame implements ActionListener {
    JTextField tfaadhar;
    JLabel tfname, tfnationality, tfaddress, labelgender, labelfname, labelfcode;
    JButton bookflight, fetchbutton, flight;
    Choice source, destination;
    JDateChooser dcdate;       
     
    public BookFlight() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 26));
        heading.setForeground(Color.blue); 
        add(heading);   

        JLabel lblaadhar = new JLabel("Aadhar");
        lblaadhar.setBounds(60, 80, 150, 25);
        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblaadhar);

        tfaadhar = new JTextField();
        tfaadhar.setBounds(200, 80, 150, 25);
        add(tfaadhar);

        fetchbutton = new JButton("Fetch User");
        fetchbutton.setBackground(Color.BLACK);
        fetchbutton.setForeground(Color.WHITE);
        fetchbutton.setBounds(380, 80, 120, 25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 500, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JLabel();
        tfname.setBounds(200, 130, 150, 25);
        add(tfname);

        JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 180, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);

        tfnationality = new JLabel();
        tfnationality.setBounds(200, 180, 150, 25);
        add(tfnationality);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(60, 230, 150, 25);
        lbladdress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbladdress);

        tfaddress = new JLabel();
        tfaddress.setBounds(200, 230, 150, 25);
        add(tfaddress);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 280, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);

        labelgender = new JLabel();
        labelgender.setBounds(200, 280, 150, 25);
        add(labelgender);

        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 330, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);

        source = new Choice();
        source.setBounds(220, 330, 150, 25);
        add(source);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 380, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);

        destination = new Choice();
        destination.setBounds(220, 380, 150, 25);
        add(destination);

        try {
            Conn c = new Conn();
            String query = "Select * from flight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.BLACK);
        flight.setForeground(Color.WHITE);
        flight.setBounds(380, 380, 120, 25);
        flight.addActionListener(this);
        add(flight);

        JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 430, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);

        labelfname = new JLabel();
        labelfname.setBounds(200, 430, 150, 25);
        add(labelfname);

        JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 480, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        labelfcode = new JLabel();
        labelfcode.setBounds(200, 480, 150, 25);
        add(labelfcode);

        JLabel lbldate = new JLabel("Date of Travel");
        lbldate.setBounds(60, 530, 150, 25);
        lbldate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(200, 530, 150, 25);
        add(dcdate);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/details.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 320, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);

        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550, 80, 500, 410);
        add(lblimage);

        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.BLACK);
        bookflight.setForeground(Color.WHITE);
        bookflight.setBounds(200, 580, 150, 25);
        bookflight.addActionListener(this);
        add(bookflight);

        setSize(1100, 700);
        setLocation(200, 50);
        setVisible(true);
    }

//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == fetchbutton) {
//            String aadhar = tfaadhar.getText();
//
//            try {
//                Conn conn = new Conn();
//                String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
//                ResultSet rs = conn.s.executeQuery(query);
//
//                if (rs.next()) {
//                    tfname.setText(rs.getString("name"));
//                    tfnationality.setText(rs.getString("nationality"));
//                    tfaddress.setText(rs.getString("address"));
//                    labelgender.setText(rs.getString("gender"));
//                } else {
//                    JOptionPane.showMessageDialog(null, "Please enter correct Aadhar card ID");
//                }
// 
//            } catch (Exception e) {
//                e.printStackTrace();
//                // JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//            }
//        }else   if (ae.getSource() == flight) {
//            String src = source.getSelectedItem();
//            String dest= destination.getSelectedItem();
//
//            try {
//                Conn conn = new Conn();
//                String query = "SELECT * FROM flight WHERE source = '" + src + "' and destination = '"+dest + "'";  
//                ResultSet rs = conn.s.executeQuery(query);
//
//                if (rs.next()) {
//                    labelfname.setText(rs.getString("f_name"));
//                    labelfcode.setText(rs.getString("f_code"));
//                    
//                } else {
//                    JOptionPane.showMessageDialog(null, "No Flight Found");
//                }
// 
//            } catch (Exception e) {
//                e.printStackTrace();
//                // JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//            }
//        }
//        else{
//            Random random=new Random();
//            String aadhar= tfaadhar.getText();
//    String name= tfname.getText();
//    String nationality= tfnationality.getText();
//    String flightname=labelfname.getText();
//    String flightcode=labelfcode.getText();
//    
//    
//    String src= source.getSelectedItem();
//    String dest=destination.getSelectedItem();
//    String ddate=((JTextField) dcdate.getDateEditor().getUiComponent()).getText();    
//    
//     try {
//                Conn conn = new Conn();
////                String query = "insert into reservation values ('PNR-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)+"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+dest+"','"+ddate+"')";                                  
////                conn.s.executeUpdate(query);
//String query = "INSERT INTO reservation (PNR, TIC, aadhar, name, nationality, flightname, flightcode, source, destination, ddate) VALUES ('PNR-" + random.nextInt(1000000) + "','TIC-" + random.nextInt(10000) + "','" + aadhar + "','" + name + "','" + nationality + "','" + flightname + "','" + flightcode + "','" + src + "','" + dest + "','" + ddate + "')";
//
//System.out.println(query); // Add this line to print the query
//conn.s.executeUpdate(query);
//
// 
//                
//                JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
//                
//                setVisible(false);
// 
//            } catch (Exception e) {
//                e.printStackTrace();
//                // JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//            }
//        } 
//    }

    
    
    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == fetchbutton) {
        String aadhar = tfaadhar.getText();
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM passenger WHERE aadhar = '" + aadhar + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                tfname.setText(rs.getString("name"));
                tfnationality.setText(rs.getString("nationality"));
                tfaddress.setText(rs.getString("address"));
                labelgender.setText(rs.getString("gender"));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct Aadhar card ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else if (ae.getSource() == flight) {
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        try {
            Conn conn = new Conn();
            String query = "SELECT * FROM flight WHERE source = '" + src + "' and destination = '"+dest + "'";
            ResultSet rs = conn.s.executeQuery(query);
            if (rs.next()) {
                labelfname.setText(rs.getString("f_name"));
                labelfcode.setText(rs.getString("f_code"));
            } else {
                JOptionPane.showMessageDialog(null, "No Flight Found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        Random random = new Random();
        String aadhar = tfaadhar.getText();
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String flightname = labelfname.getText();
        String flightcode = labelfcode.getText();
        String src = source.getSelectedItem();
        String dest = destination.getSelectedItem();
        String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
        
 try {
    Conn conn = new Conn();
    String query = "INSERT INTO reservation (PNR, TIC, aadhar, name, nationality, flightname, flightcode, source, destination, ddate) " +
                   "VALUES ('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dest + "', '" + ddate + "')";
    System.out.println(query);  // Print the query for debugging
    conn.s.executeUpdate(query);

//    conn.c.commit();  // Commit the transaction, if auto-commit is disabled

    JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
} catch (SQLException e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
} catch (Exception e) {
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
}
   
//
//        try {
//            Conn conn = new Conn();
//            String query = "INSERT INTO reservation (PNR, TIC, aadhar, name, nationality, flightname, flightcode, source, destination, ddate) " +
//                           "VALUES ('PNR-" + random.nextInt(1000000) + "', 'TIC-" + random.nextInt(10000) + "', '" + aadhar + "', '" + name + "', '" + nationality + "', '" + flightname + "', '" + flightcode + "', '" + src + "', '" + dest + "', '" + ddate + "')";
//            System.out.println(query); // Print the query for debugging
//            
//
//            conn.s.executeUpdate(query); 
//            
//            JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
//            setVisible(false);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "SQL Error: " + e.getMessage());
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
//        }
    }
}

    public static void main(String[] args) {
        new BookFlight();
    }
}   
