
package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.sql.*;        
//import java.awt.event.ActionListener;
import java.awt.event.*;          
 
//public class Login extends JFrame implements ActionListener{
//    JButton reset,submit,close;
//    JTextField tfa;
//    JPasswordField tfb;
//    public Login(){
//        getContentPane().setBackground(Color.white);
//        setLayout(null);
////        Uername store karna ha
//        JLabel a=new JLabel("Username");
//        a.setBounds(20,20,100,20);
//        add(a);
////        Username ke agge box banana ha.
//         tfa=new JTextField();
//        tfa.setBounds(130,20,200,20);
//        add(tfa);
////        Label is for =Pasword ko store karna ha
//        JLabel b=new JLabel("Password");
//        b.setBounds(20,60,100,20);
//        add(b);
////        Password ke aage box banana ha.
//        tfb=new JPasswordField();
//        tfb.setBounds(130,60,200,20);
//        add(tfb);
//        
////       To add buttons=reset,submit,close.
//        reset=new JButton("reset");
//        reset.setBounds(40, 120, 120, 20);
//        reset.addActionListener(this);
//        add(reset);
//        
//        submit=new JButton("submit");
//        submit.setBounds(190, 120, 120, 20);
//        submit.addActionListener(this);
//        add(submit);
//        
//        close=new JButton("close");
//        close.setBounds(120, 160, 120, 20);
//        close.addActionListener(this);
//        add(close);
//
//        setSize(400,250);
//        setLocation(600,250);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae){
//        if(ae.getSource()==submit){
//            String username=tfa.getText();  
//            String password=tfb.getText();
//            
//            try{
//                Conn c=new Conn();
//                String query="select *from login where username='"+username+"' and password='"+password+"'";
//                ResultSet rs=c.s.executeQuery(query);
//                
//                if(rs.next()){
//                    System.out.println("Valid");
//                    setVisible(false); 
//                }
//                else{
//                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
//                    setVisible(false);
//                }
//            } 
//            catch(Exception e){
//                e.printStackTrace();
//            }
//                         
//        }
//        else if(ae.getSource()==close){
//            setVisible(false); 
//        }
//        else if(ae.getSource()==reset){
//            tfa.setText(""); 
//            tfb.setText(""); 
//        }
//    } 
//    public static void main(String[] args){
//        new Login();
//        
//        
//    }
//    
//}


public class Login extends JFrame implements ActionListener {
    JButton reset, submit, close;
    JTextField tfa;
    JPasswordField tfb;

    public Login() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel a = new JLabel("Username");
        a.setBounds(20, 20, 100, 20);
        add(a);

        tfa = new JTextField();
        tfa.setBounds(130, 20, 200, 20);
        add(tfa);

        JLabel b = new JLabel("Password");
        b.setBounds(20, 60, 100, 20);
        add(b);

        tfb = new JPasswordField();
        tfb.setBounds(130, 60, 200, 20);
        add(tfb);

        reset = new JButton("reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);

        submit = new JButton("submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);

        close = new JButton("close");
        close.setBounds(120, 160, 120, 20);
        close.addActionListener(this);
        add(close);

        setSize(400, 250);
        setLocation(600, 250);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String username = tfa.getText();
            String password = String.valueOf(tfb.getPassword());

            try { 
                Conn c = new Conn();
                String query = "SELECT * FROM login WHERE username = ? AND password = ?";
                PreparedStatement pstmt = c.s.getConnection().prepareStatement(query);
                pstmt.setString(1, username);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    new Home(); 
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
                rs.close(); 
                pstmt.close();
                c.s.getConnection().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == close) {
            setVisible(false);
        } else if (ae.getSource() == reset) { 
            tfa.setText("");
            tfb.setText("");
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}