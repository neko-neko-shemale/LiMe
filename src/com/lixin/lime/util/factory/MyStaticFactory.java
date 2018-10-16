package com.lixin.lime.util.factory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;

/**
 * @author lixin
 */
public class MyStaticFactory {
    /**
     * The Strings
     * Name Format: THE_[Name]
     */
    public static final String THE_TITLE = "Lixin Messenger";
    public static final String THE_BRAND = "LiMe";
    public static final String THE_COPYRIGHT = "Copyright © 2018 Lixin. All rights reserved.";
    public static final String THE_VERSION = "v0.1";

    /**
     * The Actions
     * Name Format: ACTION_[Frame]_[Button]
     */
    public static final String ACTION_LOGIN_LOGIN = "login";
    public static final String ACTION_LOGIN_REGISTER = "register";
    public static final String ACTION_LOGIN_FIND_PASSWORD = "find_password";
    public static final String ACTION_REGISTER_REGISTER = "commit_register";
    public static final String ACTION_REGISTER_CANCEL = "cancel_register";
    public static final String ACTION_CHAT_LOGOUT = "logout";

    /**
     * GOLDEN_KEY : A-16-Byte-String
     */
    public static final String GOLDEN_KEY = "FuckYouMicrosoft";

    /**
     * communication information
     */
    public static final int PORT = 5005;
    public static final String HOST = "lime.lixin-computer.com";

    public static void showCopyright() {
        JOptionPane.showMessageDialog(null,
                THE_TITLE + " " + THE_VERSION + "\n" + THE_COPYRIGHT,
                THE_BRAND,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void limeWarning(String message) {
        JOptionPane.showMessageDialog(null, message, "LiMe Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void limeUnknownError(String address, String param) {
        JOptionPane.showMessageDialog(null,
                "错误地址：" + address + "\n" + "参数：" + param,
                "发生未知错误", JOptionPane.ERROR_MESSAGE);
    }

    public static void showAgreement() {
        // TODO: 打开用户协议网页
        try {
            Desktop desktop = Desktop.getDesktop();
            String message = "lime.lixin-computer.com/Agreement";
            URI uri = URI.create(message);
            desktop.browse(uri);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void showHomepage() {
        // TODO: 打开 LiMeController 主页
        try {
            Desktop desktop = Desktop.getDesktop();
            // TODO: message 改成 LiMeController 主页
            String message = "lime.lixin-computer.com/";
            URI uri = URI.create(message);
            desktop.browse(uri);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public static void emailAdmin() {
        try {
            Desktop desktop = Desktop.getDesktop();
            String message = "mailto:JustinDellAdam@live.com";
            URI uri = URI.create(message);
            desktop.mail(uri);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
