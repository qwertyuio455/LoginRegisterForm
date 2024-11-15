/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package loginregisterform;

/**
 *
 * @author Administrator
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginRegisterForm extends JFrame{

    /**
     * @param args the command line arguments
     */
    private JTextField firstNameField, lastNameField, emailField, usernameField, mobileField;
    private JPasswordField passwordField;
    private JButton registerButton, loginButton;

    public LoginRegisterForm(){
        // Thiết lập cửa sổ
        setTitle("New User Register");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Thiết lập font
        Font labelFont = new Font("Serif", Font.PLAIN, 16);
        Font titleFont = new Font("Serif", Font.BOLD, 24);

        // Tạo tiêu đề
        JLabel titleLabel = new JLabel("New User Register", JLabel.CENTER);
        titleLabel.setFont(titleFont);

        // Tạo các thành phần giao diện
        JLabel firstNameLabel = new JLabel("First name");
        firstNameLabel.setFont(labelFont);
        firstNameField = new JTextField(15);

        JLabel lastNameLabel = new JLabel("Last name");
        lastNameLabel.setFont(labelFont);
        lastNameField = new JTextField(15);

        JLabel emailLabel = new JLabel("Email address");
        emailLabel.setFont(labelFont);
        emailField = new JTextField(15);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(labelFont);
        usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField(15);

        JLabel mobileLabel = new JLabel("Mobile number");
        mobileLabel.setFont(labelFont);
        mobileField = new JTextField(15);

        registerButton = new JButton("Register");
        loginButton = new JButton("Login");

        // Panel chính với BoxLayout để căn giữa
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Panel phụ để chứa các trường nhập liệu với GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(3, 4, 10, 10));
        inputPanel.add(firstNameLabel);
        inputPanel.add(firstNameField);
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(lastNameLabel);
        inputPanel.add(lastNameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);
        inputPanel.add(emailLabel);
        inputPanel.add(emailField);
        inputPanel.add(mobileLabel);
        inputPanel.add(mobileField);

        // Căn giữa các thành phần trong mainPanel
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Thêm các thành phần vào mainPanel
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(registerButton);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(loginButton);

        // Thêm sự kiện cho nút đăng ký
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String email = emailField.getText();
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String mobile = mobileField.getText();

                // Lưu thông tin vào file
                try (FileWriter writer = new FileWriter("users.txt", true)) {
                    writer.write(username + "," + password + "," + firstName + "," + lastName + "," + email + "," + mobile + "\n");
                    JOptionPane.showMessageDialog(null, "Welcome, " + lastName + "\nYour account is successfully created.");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error saving user information.");
                }
            }
        });

        // Thêm sự kiện cho nút login để mở giao diện đăng nhập
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Đóng giao diện đăng ký
                new LoginScreen(); // Mở giao diện đăng nhập
            }
        });

        // Thêm mainPanel vào cửa sổ
        add(mainPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> new LoginRegisterForm());
    }
    
}

class LoginScreen extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginScreen() {
        // Thiết lập cửa sổ
        setTitle("Login");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Thiết lập font
        Font labelFont = new Font("Serif", Font.PLAIN, 16);
        Font titleFont = new Font("Serif", Font.BOLD, 24);

        // Tạo tiêu đề
        JLabel titleLabel = new JLabel("Login", JLabel.CENTER);
        titleLabel.setFont(titleFont);

        // Tạo các thành phần giao diện
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setFont(labelFont);
        usernameField = new JTextField(15);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setFont(labelFont);
        passwordField = new JPasswordField(15);

        loginButton = new JButton("Login");

        // Panel chính với BoxLayout để căn giữa
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Panel phụ để chứa các trường nhập liệu với GridLayout
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(passwordLabel);
        inputPanel.add(passwordField);

        // Căn giữa các thành phần trong mainPanel
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Thêm các thành phần vào mainPanel
        mainPanel.add(titleLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(inputPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPanel.add(loginButton);

        // Thêm sự kiện cho nút đăng nhập
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Kiểm tra tên đăng nhập và mật khẩu từ file
                try (Scanner scanner = new Scanner(new File("users.txt"))) {
                    boolean found = false;
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] userDetails = line.split(",");
                        if (userDetails[0].equals(username) && userDetails[1].equals(password)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        JOptionPane.showMessageDialog(null, "You have successfully logged in!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password.");
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LoginScreen.class.getName()).log(Level.SEVERE, null, ex);
                }            
            }
        });

        // Thêm mainPanel vào cửa sổ
        add(mainPanel);
        setVisible(true);
    }
}
