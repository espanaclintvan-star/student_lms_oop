import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
    
    JTextField text1; 
    JButton button;
    JLabel label1;
    JLabel label2;
    JCheckBox checkbox1;
    JCheckBox checkbox2;
    ImageIcon logo;
    JLabel label3;
    JPasswordField passwords;

    Login(){
         
         DatabaseInitializer.initializeDatabase();
    
         text1 = new JTextField();
         button = new JButton("login");
         label1 = new JLabel("Email: ");
         passwords = new JPasswordField();
         label2 = new JLabel("Password: ");
         checkbox1 = new JCheckBox("Student");
         checkbox2 = new JCheckBox("Admin");
         logo = new ImageIcon("logo_edited.png");
         label3 = new JLabel(logo);

         setLayout(null);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setSize(500, 300);
         
         text1.setBounds(120, 120, 250, 30);
         passwords.setBounds(120, 170, 250, 30);
         text1.setBorder(null);
         passwords.setBorder(null);

         label1.setBounds(80, 128, 50, 10);
         label2.setBounds(50, 178, 70, 10);
         label3.setBounds(180, -10,130, 130);
         label1.setForeground(Color.WHITE);
         label2.setForeground(Color.WHITE);

         button.setBounds(200, 228, 80, 30);
         button.setFocusable(false);
         button.setForeground(Color.WHITE); 
         button.setBackground(new Color(120, 0, 98));
         button.setBorder(null);
         button.addActionListener(this);
         
         checkbox1.setBounds(120, 210, 90, 10);
         checkbox2.setBounds(210, 210, 90, 10);
         checkbox1.setBackground(new Color(0, 0, 98));
         checkbox2.setBackground(new Color(0, 0, 98));
         checkbox1.setForeground(Color.WHITE);
         checkbox2.setForeground(Color.WHITE);

         getContentPane().setBackground(new Color(0, 0, 98));
         setTitle("Student Information Management System");
         setIconImage(logo.getImage());

         add(label1);
         add(text1);
         add(label2);
         add(button);
         add(checkbox1);
         add(checkbox2);
         add(label3);
         add(passwords);
         setVisible(true);
    }

    @Override 
    public void actionPerformed (ActionEvent e){
        if(e.getSource()==button){
            String username = text1.getText();
            String password = String.valueOf(passwords.getPassword());

            if(username.isEmpty() && password.isEmpty()){
                System.out.println("must enter username and password");
                return;
            }else if(username.isEmpty()){
                System.out.println("must enter username");
                return;
            }else if(password.isEmpty()){
                System.out.println("must enter password");
                return;
            }

            String checkbox="";
            if(checkbox1.isSelected()){
                checkbox+="student";
            }
            if(checkbox2.isSelected()){
                checkbox+="admin";
            }

            switch(checkbox){
                case "student":
                    if(checkAdminCredentials(username, password, "student")){
                        new mainPageStudent(this);
                        this.setVisible(false);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "admin":
                    if(checkAdminCredentials(username, password, "admin")){
                        new mainPageAdmin(this);
                        this.setVisible(false);
                    }else{
                        System.out.println("error");
                    }
                    break;
                case "studentadmin":
                    System.out.println("error, pick one");
                    break;
                default:
                    System.out.println("must enter one");
            }
        }
    }

    public boolean checkAdminCredentials(String username, String password, String role) {
        String query = "SELECT username, passwords, roles FROM login WHERE username = ? AND roles = ?";
        
        try (Connection conn = database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, role);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String postgresUsername = rs.getString("username");
                    String postgresPassword = rs.getString("passwords");
                    String postgresRole = rs.getString("roles"); 

                    if (username.equals(postgresUsername) && password.equals(postgresPassword) && role.equals(postgresRole)) {
                        return true; 
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
