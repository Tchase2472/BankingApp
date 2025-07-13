package guis;

import db_objs.MyJDBC;
import db_objs.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends BaseFrame{
   public LoginGui(){
       super("Banking App Login");
   }
    @Override
    protected void addGuiComponents(){
        // create banking app label
        JLabel bankingAppLabel = new JLabel("Banking Application");

        // set the location and the size of the gui component
        bankingAppLabel.setBounds (0,20, super.getWidth(), 40);

        // Change the font style
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 32 ));

        // center text in the JLabel
        bankingAppLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add to gui
        add(bankingAppLabel);

        // username Label
        JLabel usernameLabel = new JLabel("Username: ");

        // getWidth() returns us the width of our frame which is about 420
        usernameLabel.setBounds(20, 120, getWidth() - 30, 24);

        usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(usernameLabel);

        // create username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(20, 160, getWidth() - 50, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28 ));
        add(usernameField);

        // create password label
        JLabel passwordLabel = new JLabel("Password: ");

        // getWidth() returns us the width of our frame which is about 420
        passwordLabel.setBounds(20, 280, getWidth() - 30, 24);

        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        // create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 320, getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28 ));
        add(passwordField);

        // create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(20, 460, getWidth() - 50, 40);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 20 ));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // get username
                String username = usernameField.getText();

                // get password
                String password = String.valueOf(passwordField.getPassword());

                // validate login
                User user = MyJDBC.validateLogin(username, password);

                // if user is null it means invalid otherwise it is a valid account
                if(user != null){
                    // means valid login
                    //dispose this gui
                    LoginGui.this.dispose();

                    // launch the bank app gui
                    BankingAppGui bankingAppGui = new BankingAppGui(user);
                    bankingAppGui.setVisible(true);

                    // show success dialog
                    JOptionPane.showMessageDialog(bankingAppGui, "Login Successful" );
                }else{
                    JOptionPane.showMessageDialog(LoginGui.this, "Login failed....");
                }
            }
        });
        add(loginButton);

        // create register label
        JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? register Here</a></html>");
        registerLabel.setBounds(20, 510, getWidth() - 10, 30);
        registerLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(registerLabel);



    }
}
