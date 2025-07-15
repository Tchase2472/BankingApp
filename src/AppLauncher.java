import guis.LoginGui;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        // use invokeLater to make updates to the GUI more thread-safe
        SwingUtilities.invokeLater( new Runnable(){
            @Override
            public void run(){
                new LoginGui().setVisible(true);
//                new RegisterGui().setVisible(true);
               // new BankingAppGui(new User(1, "username", "password", new BigDecimal("20.00"))).setVisible(true);

            }
        });
    }
}
