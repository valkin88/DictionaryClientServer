package Contracts.Core;

import Contracts.IO.IReader;
import Contracts.IO.IWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public interface ILanguageInterpreter {

    void Interprete(IReader reader, IWriter writer, BufferedReader bufferedReader, Socket socket) throws IOException;

}//ILanguage
