package br.com.mail;

import br.com.type.SendType;

public class Main {

	public static void main(String[] args) {
		SendType sendType = new SendType();

		sendType.EmailWithoutAuth();
		sendType.EmailWithSSL();
		sendType.EmailWithTLS();
	}
}
