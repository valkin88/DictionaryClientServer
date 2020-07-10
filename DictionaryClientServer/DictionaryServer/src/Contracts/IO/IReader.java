package Contracts.IO;

import java.io.DataInputStream;
import java.io.IOException;

public interface IReader {

    String ReadLine(DataInputStream inputFromClient) throws IOException;

}//IReader
