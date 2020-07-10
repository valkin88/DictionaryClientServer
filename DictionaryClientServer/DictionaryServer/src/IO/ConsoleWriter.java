package IO;

import Contracts.IO.IWriter;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConsoleWriter implements IWriter {

    public void WriteLine(DataOutputStream outputFromServer, String translatedText) throws IOException {
        outputFromServer.writeUTF(translatedText);
    }//WriteLine

}//ConsoleWriter
