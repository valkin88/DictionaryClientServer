package Core;

import Contracts.Core.ILanguageInterpreter;
import Contracts.Core.IServerExecutioner;
import Contracts.IO.IReader;
import Contracts.IO.IWriter;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExecutioner implements IServerExecutioner {

    // Name of the txt file
    private static final String FILE_NAME = "..\\Dictionary.txt";

    private IReader reader;
    private IWriter writer;

    public ServerExecutioner(IReader reader, IWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void Execute() throws IOException {

        BufferedReader bufferedReader = null;

        try {

            // uploading the txt file
            File inputFile = new File(FILE_NAME);
            FileReader fileReader = new FileReader(inputFile);

            bufferedReader = new BufferedReader(fileReader);

        }
        catch (FileNotFoundException e) {

            // Error msg if the file is not found
            System.err.println("File " + FILE_NAME + " not found. Serving time instead.");

        }

        try {

            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.print("Server is running!");

            // Listen for connection request from client
            Socket socket = serverSocket.accept();

            ILanguageInterpreter interpreter = new LanguageInterpreter();

            interpreter.Interprete(reader, writer, bufferedReader, socket);

            // Free resources
            socket.close();
        }
        catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }//Execute

}//ServerExecutioner
