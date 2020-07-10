package Contracts.IO;

import java.io.DataOutputStream;
import java.io.IOException;

public interface IWriter {

    public void WriteLine(DataOutputStream outputFromServer, String translatedText) throws IOException;

}//IWriter
