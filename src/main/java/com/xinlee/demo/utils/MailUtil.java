package com.xinlee.demo.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by xin.lee on 2017/3/9.
 * 邮件工具类
 */
public class MailUtil {

    /**
     * 发送邮件
     * @param to 收件人
     * @param code 激活验证代码
     * @throws MessagingException
     */
    public static void sendMail(String to, String code) throws MessagingException {
        String active = "http://localhost:8080/active?code=" + code;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.163.com");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("l0veyt@163.com", "iL0veyt&20178@");
            }
        });

        // 创建邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress("l0veyt@163.com"));
        // 设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        // 设置邮件的主题
        message.setSubject("来自XX网站的激活邮件");
        // 设置邮件的正文
        message.setContent("<h1>来自XX网站的激活邮件，激活请点击以下链接</h1><h3><a href='" + active + "'>" + active + "</a></h3>", "text/html;charset=utf-8");
        // 发送邮件
        Transport.send(message);
    }
}
