package org.comarduino.listener;

import java.io.IOException;
import java.util.Scanner;

import org.comarduino.talk.TalkArduino;

public abstract class ArduinoListener implements Runnable {

	private TalkArduino arduino;

	public ArduinoListener(TalkArduino arduino) {
		this.arduino = arduino;
	}

	@Override
	public void run() {

		try {
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(arduino.getArduinoSocket()
					.getInputStream());

			while (true) {
				if (scanner.hasNextLine()) {
					String data = scanner.nextLine();
					processData(data);
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public abstract void processData(String data);

}
