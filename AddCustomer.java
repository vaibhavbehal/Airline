
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public  class AddCustomer extends JFrame implements ActionListener{
    JTextField tfname,tfphone,tfaadhar,tfaddress,tfnationality;
    JRadioButton male,female;
    public AddCustomer(){
       getContentPane().setBackground(Color.white);
       setLayout(null);
       
       JLabel heading=new JLabel("Add Customer Details");
       heading.setBounds(220,20,500,35);
       heading.setFont(new Font ("Tahoma",Font.PLAIN,26));
       heading.setForeground(Color.blue); 
       add(heading);
       
        JLabel lblname=new JLabel("Name");
       lblname.setBounds(60,80,500,25);
       lblname.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lblname);
       
        tfname=new JTextField();
       tfname.setBounds(200,80,150,25);
       add(tfname);
       
       JLabel lblnationality=new JLabel("Nationality");
       lblnationality.setBounds(60,130,150,25);
       lblnationality.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lblnationality);
       
       tfnationality=new JTextField();
       tfnationality.setBounds(200,129,150,25);
       add(tfnationality);
       
        JLabel lblaadhar=new JLabel("Aadhar No");
       lblaadhar.setBounds(60,180,150,25);
       lblaadhar.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lblaadhar);
       
        tfaadhar=new JTextField();
       tfaadhar.setBounds(200,180,150,25);
       add(tfaadhar);
       
        JLabel lbladdress=new JLabel("Address");
       lbladdress.setBounds(60,230,150,25);
       lbladdress.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lbladdress);
       
       tfaddress=new JTextField();
       tfaddress.setBounds(200,230,150,25);
       add(tfaddress);
       
        JLabel lblgender=new JLabel("Gender");
       lblgender.setBounds(60,280,150,25);
       lblgender.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lblgender);
       
       ButtonGroup gendergroup =new ButtonGroup();
       
       male=new JRadioButton("Male");
       male.setBounds(200,280,70,25);
       male.setBackground(Color.white);
       add(male);
       
       female=new JRadioButton("Female");
       female.setBounds(300,280,70,25);
       female.setBackground(Color.white);
       add(female);
       
       gendergroup.add(male);
       gendergroup.add(female);
       
        JLabel lblphone=new JLabel("Pnone");
       lblphone.setBounds(60,330,150,25);
       lblphone.setFont(new Font ("Tahoma",Font.PLAIN,16));
       add(lblphone);
       
       tfphone=new JTextField();
       tfphone.setBounds(200,330,150,25);
       add(tfphone);
       
       JButton save=new JButton("Save");
       save.setBackground(Color.BLACK);
       save.setForeground(Color.WHITE);
       save.setBounds(200, 380, 150, 30); 
       save.addActionListener(this);
       add(save);
       
       ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/emp.png"));
       JLabel lblimage=new JLabel(image);
       lblimage.setBounds(450, 80, 280, 400);
       add(lblimage);
        
              
      setSize(900,600);
      setLocation(300,150);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String address = tfaddress.getText();
        String aadhar = tfaadhar.getText();
        String gender = null;

        if (male.isSelected()) {
            gender = "Male";
        } else if (female.isSelected()) { 
            gender = "Female";
        } 

        try {
            Conn conn = new Conn();
            String query = String.format(
                "INSERT INTO passenger (name, nationality, phone, address, aadhar, gender) VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                name, nationality, phone, address, aadhar, gender                
            );
            System.out.println(query);
            conn.s.executeUpdate(query);    /* it is important it is dml command*/
            JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public static void main(String args[]){
        new AddCustomer();
        
    }
}
