package univille.erick;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		
		Socket socket = serverSocket.accept();
		
		Enviador enviador = new Enviador(socket);
		Receptor receptor = new Receptor(socket);
		
		Thread threadEnviador = new Thread(enviador);
		Thread threadReceptor = new Thread(receptor);
		
		threadEnviador.start();
		threadReceptor.start();
		
		Scanner teclado = new Scanner(System.in);
		
		while(socket.isConnected()) {
			String mensagem = teclado.nextLine();
			enviador.enviar("Servidor: " + mensagem);
		}
		
		teclado.close();
		serverSocket.close();
	}
}