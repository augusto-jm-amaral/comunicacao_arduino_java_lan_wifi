package org.comarduino.call;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.comarduino.talk.TalkArduino;

public class CallArduino {

	private final int port;
	private ServerSocket serverSocket;

	public CallArduino(int port) {
		this.port = port;
	}

	public TalkArduino connect() throws IOException {

		serverSocket = new ServerSocket(this.port);

		Socket arduinoSocket = serverSocket.accept();

		return new TalkArduino(arduinoSocket);
	}

	public int getPort() {
		return port;
	}

}
