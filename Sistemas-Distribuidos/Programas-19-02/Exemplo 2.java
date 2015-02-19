import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServer {
	
	private static final int PORTA = 9666;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			ServerSocket server = new ServerSocket(PORTA);
			System.out.println("Servidor aberto em:" + server.getInetAddress() + ":" + PORTA);
	
			Socket socket = server.accept();
			// Mostrando quem conectou pelo IP e Porta
			System.out.println("Conectou " + socket.getInetAddress() + ":" + socket.getPort());
			
			//Fechando o Socket
			socket.close();
			//Fechando o servidor
			server.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
	
	}

}
