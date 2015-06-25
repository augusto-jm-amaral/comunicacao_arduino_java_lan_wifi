package org.comarduino.test;

import java.io.IOException;

import org.comarduino.call.CallArduino;
import org.comarduino.listener.ArduinoListener;
import org.comarduino.talk.TalkArduino;

public class TestDataExchange {

	public static void main(String[] args) {
		
		CallArduino callArduino = new CallArduino(80);
		try {
		
			TalkArduino talkArduino = callArduino.connect();
			talkArduino.sendData("Hello Arduino");
			
			ArduinoListener arduinoListener = new ArduinoListener(talkArduino) {
				
				@Override
				public void processData(String data) {
					
					System.out.println(data);
				}
			};
			
			Thread threadArduinoListener = new Thread(arduinoListener);
			threadArduinoListener.start();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

}
