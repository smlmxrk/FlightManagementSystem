package mark.ui.login;

import com.formdev.flatlaf.FlatClientProperties;
import net.miginfocom.swing.MigLayout;
// db import goes here
import java.awt.Desktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class Login extends JPanel {

    public Login() {
        init();
    }

    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JCheckBox rememberMe;


    // login page gui-builder

    private void init() {
        setLayout(new MigLayout("fill, insets 20", "[center]"));

        username = new JTextField();
        password = new JPasswordField();
        rememberMe = new JCheckBox("Remember Me");
        login = new JButton("Login");
        login.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JPanel panel = new JPanel(new MigLayout("wrap, fillx, insets 35 45 30 45", "fill, 250, 280"));
        panel.putClientProperty(FlatClientProperties.STYLE,"" +
                "arc:20;" +
                "[light]background:darken(@background, 3%);" +
                "[dark]background:lighten(@background, 3%);");

        password.putClientProperty(FlatClientProperties.STYLE,""
        + "showRevealButton:true");

        login.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]background:darken(@background, 10%);" +
                "[dark]background:lighten(@background, 10%);" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0;" +
                "hoverBackground:#4CAC50");

        username.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your username");
        password.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");

        JLabel lbTitle = new JLabel("Welcome back!");
        JLabel description = new JLabel("Please log in to access your account");
        lbTitle.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        description.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]foreground:lighten(@foreground, 30%);" +
                "[dark]foreground:darken(@foreground, 30%)");

        panel.add(lbTitle);
        panel.add(description);
        panel.add(new JLabel("Username"), "gapy 8");
        panel.add(username);
        panel.add(new JLabel("Password"), "gapy 8");
        panel.add(password);
        panel.add(rememberMe, "grow 0");
        panel.add(login, "gapy 10");
        panel.add(createHelpLabel(), "gapy 10");

        add(panel);

    }

    private Component createHelpLabel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        panel.putClientProperty(FlatClientProperties.STYLE,"" +
                "background:null");
        JButton getHelp = new JButton(("<html><a href=\"#\">Get help.</a></html>"));
        getHelp.putClientProperty(FlatClientProperties.STYLE,"" +
                "border:3,3,3,3");
        getHelp.setContentAreaFilled(false);
        getHelp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getHelp.addActionListener(e -> {
            System.out.println("Go help form");
                });
        getHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openWebPage("https://github.com/smlmxrk");
            }
        });


        JLabel label = new JLabel("Having trouble signing in?");
        label.putClientProperty(FlatClientProperties.STYLE,"" +
                "[light]foreground:lighten(@foreground, 30%);" +
                "[dark]foreground:darken(@foreground, 30%)");
        panel.add(label);
        panel.add(getHelp);

        return panel;

    }

    public static void openWebPage(String url) {
        try {
          Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
          if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
              desktop.browse(new URI(url));
          }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }
}
