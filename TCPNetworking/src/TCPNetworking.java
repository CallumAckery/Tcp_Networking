import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
//import java.util.Arrays;


public class TCPNetworking {
	
	/* TCP SERVER */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			ServerSocket serverSocket = new ServerSocket(8080);
			System.out.println("Waiting for a client request...");

			Socket clientSocket = serverSocket.accept();

			InputStream in = clientSocket.getInputStream();
			OutputStream out = clientSocket.getOutputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			PrintWriter pr = new PrintWriter(out);
			
			String inputLine = null;
			//String outputLine = null;

			/*  */
			inputLine = br.readLine();
			
			String[] numberStrings = inputLine.split(",");
			
			
			
			int sum = 0;
			
			int sum1 = Integer.parseInt(numberStrings[0].trim());
			int sum2 = Integer.parseInt(numberStrings[1].trim());
			
			sum = sum1 + sum2;
			
			//System.out.println(sum);
			
			/* what i received */
			System.out.println("Received : "+ inputLine);
			
			/* Sending data back */
			System.out.println("Sending back : "+ sum);

			pr.println(sum);
			pr.flush();

			clientSocket.close();
			serverSocket.close();
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
		
		
		
	}

}
