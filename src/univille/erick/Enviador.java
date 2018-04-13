package univille.erick;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Enviador extends Thread {
	private PrintStream saida;
	
	public Enviador(Socket socket) throws IOException {
		saida = new PrintStream(socket.getOutputStream());
	}
	
	public void enviar(String mensagem) {
		saida.println(mensagem);
	}
} 