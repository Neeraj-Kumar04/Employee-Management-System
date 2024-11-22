package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    // Constructor
    Login() {
        setResizable(false);  // Disable maximize button
        setTitle("ADMIN LOGIN PAGE");


        // Username label and text field
        JLabel username = new JLabel("Username");
        username.setFont(new Font("Arial", Font.BOLD, 20));
        username.setBounds(60, 30, 150, 40);  // Adjusted size and position
        add(username);

        tusername = new JTextField();
        tusername.setBounds(200, 30, 200, 40);  // Adjusted size and position
        add(tusername);

        // Password label and field
        JLabel password = new JLabel("Password");
        password.setFont(new Font("Arial", Font.BOLD, 20));
        password.setBounds(60, 90, 150, 40);  // Adjusted size and position
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(200, 90, 200, 40);  // Adjusted size and position
        add(tpassword);

        // Login and Back buttons
        login = new JButton("LOGIN");
        login.setBounds(200, 160, 200, 40);  // Adjusted size and position
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        back = new JButton("BACK");
        back.setBounds(200, 220, 200, 40);  // Adjusted size and position
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        // Background image 1 (right-side image)
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i22 = i11.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);  // Adjusted size
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(450, 20, 800, 500);  // Adjusted size and position
        add(imgg);

        // Background image 2 (full background)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 500, Image.SCALE_DEFAULT);  // Adjusted size
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 900, 500);  // Adjusted size and position
        add(img);

        // Frame properties
        setSize(900, 500);  // Increased size
        setLocation(300, 100);  // Adjusted position
        setLayout(null);
        setVisible(true);
    }

    // Action event handling
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
           try{
               String username = tusername.getText();
               String password = tpassword.getText();

               Database_Connection conn = new Database_Connection();

               String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
               ResultSet resultSet =conn.statement.executeQuery(query);
               if (resultSet.next()){
                   setVisible(false);
                   new Main_class();
               }else {
                   JOptionPane.showMessageDialog(null,"Invalid username or password");
               }
           }catch(Exception E){
               E.printStackTrace();
           }
        } else if (e.getSource() == back) {
            System.exit(90);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
