package IO;

import Contracts.IO.IReader;

import java.io.DataInputStream;
import java.io.IOException;

public class ConsoleReader implements IReader {

    public String ReadLine(DataInputStream inputFromClient) throws IOException {
        return inputFromClient.readUTF();
    }//ReadLine

}//ConsoleReader
