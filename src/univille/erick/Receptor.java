package univille.erick;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Receptor extends Thread {
	private Socket socket;
	Scanner entrada;
	
	public Receptor(Socket socket) throws IOException {
		this.socket = socket;
		entrada = new Scanner(socket.getInputStream());
	}
	
	public void run() {
		while(socket.isConnected()) {
			while(entrada.hasNextLine()) {
				System.out.println(entrada.nextLine());
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		entrada.close();
		
	}
} 