package univille.erick;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("127.0.0.1", 12345);
		Enviador enviador = new Enviador(socket);
		Receptor receptor = new Receptor(socket);
		
		Thread threadEnviador = new Thread(enviador);
		Thread threadReceptor = new Thread(receptor);
		
		threadEnviador.start();
		threadReceptor.start();
		
		Scanner teclado = new Scanner(System.in);
		
		while(socket.isConnected()) {
			String mensagem = teclado.nextLine();
			enviador.enviar("Cliente:  " + mensagem);
		}
		
		teclado.close();
	}
}