package Client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        try {

            Socket socket = new Socket("localhost", 9999);

            while (true) {
                System.out.print("Enter Text: ");

                // The Client enters a response
                InputStreamReader streamReader = new InputStreamReader(System.in);

                // Data input and output streams
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputFromServer = new DataOutputStream(socket.getOutputStream());

                BufferedReader inputBufferedReader = new BufferedReader(streamReader);

                // The response from the Client as String
                String currentWord = inputBufferedReader.readLine();

                // Send response to the Server
                outputFromServer.writeUTF(currentWord);
                outputFromServer.flush();

                // Receive the response from the server
                System.out.print(inputFromClient.readUTF());

                if (currentWord.equalsIgnoreCase("END PROGRAM!")){
                    break;
                }

                System.out.println();
            }

            // Free resources
            socket.close();

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }//main

}//ClientServer