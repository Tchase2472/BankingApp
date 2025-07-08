package guis;

import db_objs.User;

import javax.swing.*;


public abstract class BaseFrame extends JFrame {
    // store user information
    protected User user;


    public BaseFrame(String title){
        initialize(title);
    }
    public BaseFrame(String title, User user){
        // initialize user
        this.user = user;

        initialize(title);
    }

    private void initialize(String title){
        // instantiate JFrame properties and add a title to the bar
        setTitle(title);

        // set the size in pixels
        setSize(420,600);

        // close the app on closing the panel
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // set layout to null to have absolute layout which allows us to manually specify size and position of each gui component
        setLayout(null);

        // prevent gui from being resized
        setResizable(false);

        // launch the gui in the center of the screen
        setLocationRelativeTo(null);

        // call on the sublass's addGuiComponent()
        addGuiComponents();
    }
    protected abstract void addGuiComponents();
}

