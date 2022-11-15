import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			Socket clientSocket = new Socket("127.0.0.1", 8080);

			
			/* Socket Connection In  Receiving Data */
			InputStream in = clientSocket.getInputStream();
			/* Pass Receiving data to Buffered Reader*/
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			/* Socket Connection Out Sending Data */
			OutputStream out = clientSocket.getOutputStream();
			
			
			/* Formatted Text output */
			PrintWriter pr = new PrintWriter(out);
			String inputLine = null;
			
			String outputLine = "2, 4";
			System.out.println("Sending "+outputLine+" to server");
			pr.println(outputLine);
			
			pr.flush();

			/* 
			 * while input is not equal to null or nothing 
			 * get the response for the server
			 * 
			 * */
			while((inputLine = br.readLine()) != null)
			{
				System.out.println("Response from server: "+ inputLine);
			}

			clientSocket.close();
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}

}
