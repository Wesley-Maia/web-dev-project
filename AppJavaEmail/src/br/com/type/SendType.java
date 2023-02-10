package br.com.type;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import br.com.util.EmailUtil;

public class SendType {

	public void EmailWithoutAuth() {
		System.out.println("SimpleEmail Start - Without Authentication");

		EmailUtil emailUtil = new EmailUtil();

		final String fromEmail = "wesley.maia@hominiss.com.br"; // requires valid mail id
		final String password = "xyz"; // correct password for mail id
		final String toEmail = "maia.weol@gmail.com"; // can be any email id

		System.out.println("Properties Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com"); // SMTP Host
		props.put("mail.smtp.port", "25"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS
		props.put("mail.smtp.ssl.trust", "smtp-mail.outlook.com");

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		emailUtil.sendEmail(session, toEmail, "Without Authentication Testing Subject",
				"Without Authentication Testing Body");
	}

	public void EmailWithSSL() {
		System.out.println("SimpleEmail Start - SSL");

		EmailUtil emailUtil = new EmailUtil();

		final String fromEmail = "wesley.maia@hominiss.com.br"; // requires valid email id
		final String password = "xyz"; // correct password for email id
		final String toEmail = "maia.weol@gmail.com"; // can be any email id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com"); // SMTP Host
		props.put("mail.smtp.socketFactory.port", "587"); // SSL Port
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); // SSL Factory Class
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		emailUtil.sendEmail(session, toEmail, "SSLEmail Testing Subject", "SSLEmail Testing Body");
	}

	public void EmailWithTLS() {
		System.out.println("SimpleEmail Start - TLS");

		EmailUtil emailUtil = new EmailUtil();

		final String fromEmail = "wesley.maia@hominiss.com.br"; // requires valid email id
		final String password = "xyz"; // correct password for email id
		final String toEmail = "maia.weol@gmail.com"; // can be any email id

		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp-mail.outlook.com"); // SMTP Host
		props.put("mail.smtp.port", "587"); // TLS Port
		props.put("mail.smtp.auth", "true"); // enable authentication
		props.put("mail.smtp.starttls.enable", "true"); // enable STARTTLS

		// create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			// override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};

		Session session = Session.getInstance(props, auth);

		emailUtil.sendEmail(session, toEmail, "TLSEmail Testing Subject", "TLSEmail Testing Body");
	}
}
