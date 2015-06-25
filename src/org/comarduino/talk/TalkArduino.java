package org.comarduino.talk;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkArduino {

	private Socket arduinoSocket;

	public TalkArduino(Socket arduinoSocket) {
		this.arduinoSocket = arduinoSocket;
	}

	public Socket getArduinoSocket() {
		return arduinoSocket;
	}

	public void sendData(String data) throws IOException {

		new PrintWriter(arduinoSocket.getOutputStream()).println(data);
	}
}
