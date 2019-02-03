package com.lixin.lime.protocol.util.factory;

import com.lixin.lime.protocol.util.crypto.AesCipher;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.util.Calendar;

/**
 * @author lixin
 */
public class MyStaticFactory {
    /**
     * The Strings
     * Name Format: THE_[Name]*
     */
    public static final String THE_TITLE = "Lixin Messenger";
    public static final String THE_BRAND = "LiMe";
    public static final String THE_AUTHOR = "Lixin";
    public static final String THE_COPYRIGHT = "™ and © 2015-" + getLiMeYear() + " " + THE_AUTHOR + ". All Rights Reserved.";
    public static final String THE_LIME_VERSION = "C_v 0.2";
    public static final String THE_SERVER_TITLE = THE_TITLE + " Server";
    public static final String THE_SERVER_BRAND = THE_BRAND + " Server";
    public static final String THE_SERVER_VERSION = "S_v 0.2";

    /**
     * The Actions
     * Name Format: ACTION_[Frame]_[Button]*
     */
    public static final String ACTION_LOGIN_LOGIN = "login";
    public static final String ACTION_LOGIN_REGISTER = "register";
    public static final String ACTION_LOGIN_FIND_PASSWORD = "find_password";
    public static final String ACTION_REGISTER_REGISTER = "commit_register";
    public static final String ACTION_REGISTER_CANCEL = "cancel_register";
    public static final String ACTION_CHAT_LOGOUT = "logout";
    public static final String ACTION_CHAT_SEND_MESSAGE = "send_message";
    public static final String ACTION_CHAT_SEND_FILE = "send_file";

    /**
     * The Server Actions
     * Name Format: SERVER_ACTION_[Button]* = "server_[button]"
     */
    public static final String SERVER_ACTION_START = "server_start";
    public static final String SERVER_ACTION_STOP = "server_stop";
    public static final String SERVER_ACTION_KICK = "server_kick";
    public static final String SERVER_ACTION_BAN = "server_ban";
    public static final String SERVER_ACTION_CLEAR_LOG = "server_clear_log";
    public static final String SERVER_ACTION_CLEAR_HISTORY = "server_clear_history";

    /**
     * GOLDEN_KEY : Ab-16-Byte-String
     */
    public static final String GOLDEN_KEY = "FuckYouMicrosoft";

    public static final String PASSWORD_FILE_PATH = "soil.lime";

    /**
     * communication information
     * <p>
     * PORT to choose
     * <p>
     * 5463 = T9 keyboard - LiMe
     * 54946 = T9 keyboard - lixin
     */
    public static final int PORT = 5463;

    /**
     * communication information
     * <p>
     * HOST domain to choose
     * <p>
     * 1. limeler.xyz
     * 2. limeler.top
     * <p>
     * WANTED DOMAIN: lime.com | lime.online
     */
    public static final String DOMAIN_NAME = "lixin-computer.com";
    public static final String HOST_NAME = "lime";
    public static final String WEB_MOST = HOST_NAME + "." + DOMAIN_NAME;

    public static final String HOST = "127.0.0.1";

    private static final String ADMIN_EMAIL = "JustinDellAdam@live.com";
    private static final String STAFF_EMAIL = "lixin@" + DOMAIN_NAME;
    private static final String URL_LIME_HOMEPAGE = WEB_MOST;
    private static final String URL_LIME_AGREEMENT = WEB_MOST + "/Agreement";


    // SQL properties

    public static final String SQL_HOST = "admin.lixin-computer.com";
    public static final int SQL_PORT = 3306;
    public static final String SQL_DATABASE = "lime";
    public static final String SQL_USERNAME = "lixin";
    public static final String SQL_PASSWORD = "BASNDAFWAUSMC";
    public static final String SQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

    // The public methods

    public static String getLiMeTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().toString();
    }

    public static String getLiMeYear() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(Calendar.YEAR));
    }

    public static void limeInfo(String message) {
        JOptionPane.showMessageDialog(null, message, THE_BRAND + " 提示", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void limeWarning(String message) {
        JOptionPane.showMessageDialog(null, message, THE_BRAND + " 警告", JOptionPane.WARNING_MESSAGE);
    }

    public static void limeInternalError(String address, String param) {
        JOptionPane.showMessageDialog(null,
                "错误地址：" + address + "\n" + "参数：" + param,
                THE_BRAND + " 内部错误", JOptionPane.ERROR_MESSAGE);
        System.exit(0);
    }

    public static void limeExternalError(String detail, String message) {
        JOptionPane.showMessageDialog(null, detail, message, JOptionPane.ERROR_MESSAGE);
    }

    public static void showCopyright() {
        JOptionPane.showMessageDialog(null,
                THE_TITLE + " " + THE_LIME_VERSION + "\n" + THE_COPYRIGHT,
                THE_BRAND,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showServerCopyright() {
        JOptionPane.showMessageDialog(null,
                THE_SERVER_TITLE + " " + THE_SERVER_VERSION + "\n" + THE_COPYRIGHT,
                THE_SERVER_BRAND,
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showHomepage() {
        // TODO: 打开 LiMe 主页
        showUrl(URL_LIME_HOMEPAGE);
    }

    public static void showAgreement() {
        // TODO: 打开用户协议网页
        showUrl(URL_LIME_AGREEMENT);
    }

    public static void limeEmailAdmin() {
        sendEmailFromLiMe(ADMIN_EMAIL);
    }

    public static void limeEmailStaff() {
        sendEmailFromLiMe(STAFF_EMAIL);
    }

    public static String encrypt(String password) {
        try {
            return AesCipher.aesEncryptString(password, GOLDEN_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String password) {
        try {
            return AesCipher.aesDecryptString(password, GOLDEN_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // The private methods

    private static void showUrl(String url) {
        try {
            Desktop desktop = Desktop.getDesktop();
            String message = "https://" + url;
            URI uri = URI.create(message);
            desktop.browse(uri);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    private static void sendEmailFromLiMe(String to) {
        try {
            Desktop desktop = Desktop.getDesktop();
            String message = "mailto:" + to;
            URI uri = URI.create(message);
            desktop.mail(uri);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
