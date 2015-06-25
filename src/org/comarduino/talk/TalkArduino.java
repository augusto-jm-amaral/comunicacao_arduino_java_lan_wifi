package org.comarduino.talk;

import java.net.Socket;

public class TalkArduino {

	private Socket arduinoSocket;

	public TalkArduino(Socket arduinoSocket) {
		this.arduinoSocket = arduinoSocket;
	}

	public Socket getArduinoSocket() {
		return arduinoSocket;
	}
}
