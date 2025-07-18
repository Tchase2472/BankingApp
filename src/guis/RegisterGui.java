package guis;

import javax.swing.*;
import java.awt.*;

public class RegisterGui extends BaseFrame{
    public RegisterGui(){
        super("Banking App Register");
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
        passwordLabel.setBounds(20, 220, getWidth() - 30, 24);

        passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(passwordLabel);

        // create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(20, 260, getWidth() - 50, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28 ));
        add(passwordField);

        // re-type password label
        JLabel rePasswordLabel = new JLabel("Re-type Password:");
        rePasswordLabel.setBounds(20, 320, getWidth() - 50, 40);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20 ));
        add(rePasswordLabel);

        // create re-type password
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(20, 360, getWidth() - 50, 40);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 28 ));
        add(rePasswordField);

        // create login button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(20, 460, getWidth() - 50, 40);
        registerButton.setFont(new Font("Dialog", Font.BOLD, 20 ));
        add(registerButton);

        // create login label
        JLabel loginLabel = new JLabel("<html><a href=\"#\">Have an account? Sign-in here</a></html>");
        loginLabel.setBounds(20, 510, getWidth() - 10, 30);
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 15));
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);


        add(loginLabel);

    }
}
