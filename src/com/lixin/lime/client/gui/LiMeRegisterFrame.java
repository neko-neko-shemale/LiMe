package com.lixin.lime.client.gui;

import com.lixin.lime.util.factory.MyStaticFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import static com.lixin.lime.util.factory.MyStaticFactory.*;

/**
 * @author lixin
 */
public class LiMeRegisterFrame extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JTextField textFieldEmail;
    private JToggleButton toggleButtonGender;
    private JCheckBox checkboxAgree;
    private JButton btnRegister;
    private JButton btnCancel;

    /**
     * Create the frame.
     */
    public LiMeRegisterFrame() {
        setResizable(false);
        setTitle("注册 " + THE_BRAND);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(600, 200, 480, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelTitle = new JLabel(THE_TITLE);
        labelTitle.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MyStaticFactory.showCopyright();
            }
        });
        labelTitle.setForeground(new Color(153, 50, 204));
        labelTitle.setFont(new Font("Harry P", Font.BOLD, 50));
        labelTitle.setBounds(119, 30, 242, 60);
        contentPane.add(labelTitle);

        JLabel labelUsername = new JLabel("用户名");
        labelUsername.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        labelUsername.setBounds(53, 129, 54, 42);
        contentPane.add(labelUsername);

        textFieldUsername = new JTextField();
        textFieldUsername.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(119, 130, 242, 42);
        contentPane.add(textFieldUsername);

        JLabel labelPassowrd = new JLabel("密码");
        labelPassowrd.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        labelPassowrd.setBounds(71, 183, 36, 42);
        contentPane.add(labelPassowrd);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        passwordField.setColumns(10);
        passwordField.setBounds(119, 184, 242, 42);
        contentPane.add(passwordField);

        JLabel labelGender = new JLabel("性别");
        labelGender.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        labelGender.setBounds(71, 237, 36, 42);
        contentPane.add(labelGender);

        toggleButtonGender = new JToggleButton("男");
        toggleButtonGender.addActionListener(this);
        toggleButtonGender.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        toggleButtonGender.setBounds(119, 238, 242, 42);
        contentPane.add(toggleButtonGender);

        checkboxAgree = new JCheckBox("我同意");
        checkboxAgree.addActionListener(this);
        checkboxAgree.setBounds(168, 346, 72, 23);
        contentPane.add(checkboxAgree);

        JLabel labelEmail = new JLabel("Email");
        labelEmail.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        labelEmail.setBounds(62, 291, 45, 42);
        contentPane.add(labelEmail);

        textFieldEmail = new JTextField();
        textFieldEmail.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(119, 292, 242, 42);
        contentPane.add(textFieldEmail);

        JLabel labelCopyright = new JLabel(THE_COPYRIGHT);
        labelCopyright.setForeground(SystemColor.windowBorder);
        labelCopyright.setBounds(100, 556, 280, 16);
        contentPane.add(labelCopyright);

        JLabel labelAgreement = new JLabel("《用户协议》");
        labelAgreement.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showAgreement();
            }
        });
        labelAgreement.setForeground(SystemColor.controlHighlight);
        labelAgreement.setBounds(235, 350, 80, 16);
        contentPane.add(labelAgreement);

        btnRegister = new JButton("注册");
        btnRegister.setActionCommand(ACTION_COMMIT_REGISTER);
        btnRegister.setEnabled(false);
        btnRegister.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        btnRegister.setBounds(119, 378, 117, 36);
        contentPane.add(btnRegister);

        btnCancel = new JButton("取消");
        btnCancel.addActionListener(this);
        btnCancel.setFont(new Font("PingFang SC", Font.PLAIN, 18));
        btnCancel.setBounds(245, 378, 117, 36);
        contentPane.add(btnCancel);

        JLabel labelBrand = new JLabel(THE_BRAND);
        labelBrand.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showHomepage();
            }
        });
        labelBrand.setForeground(SystemColor.windowBorder);
        labelBrand.setFont(new Font("Harry P", Font.BOLD, 99));
        labelBrand.setBounds(157, 444, 166, 100);
        contentPane.add(labelBrand);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == toggleButtonGender) {
            if (toggleButtonGender.isSelected()) {
                toggleButtonGender.setText("女");
            } else {
                toggleButtonGender.setText("男");
            }
        } else if (e.getSource() == checkboxAgree) {
            if (checkboxAgree.isSelected()) {
                btnRegister.setEnabled(true);
            } else {
                btnRegister.setEnabled(false);
            }
        } else if (e.getSource() == btnCancel) {
            clearUI();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null,
                    "错误地址：" + this.getClass().getCanonicalName(),
                    "发生未知错误",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public String getUsername() {
        return textFieldUsername.getText();
    }

    public void setUsername(String username) {
        textFieldUsername.setText(username);
    }

    public String getPassword() {
        return String.valueOf(passwordField.getPassword());
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }

    public String getGender() {
        return toggleButtonGender.getText();
    }

    public void setGender(boolean gender) {
        toggleButtonGender.setSelected(gender);
        if (gender) {
            toggleButtonGender.setText("女");
        } else {
            toggleButtonGender.setText("男");
        }
    }

    public String getEmail() {
        return textFieldEmail.getText();
    }

    public void setEmail(String email) {
        textFieldEmail.setText(email);
    }

    public void clearUI() {
        setUsername(null);
        setPassword(null);
        setEmail(null);
        setGender(false);
    }
}