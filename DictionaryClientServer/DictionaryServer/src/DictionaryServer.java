import Contracts.Core.IServerExecutioner;
import Contracts.IO.IReader;
import Contracts.IO.IWriter;
import Core.ServerExecutioner;
import IO.ConsoleReader;
import IO.ConsoleWriter;

import java.io.IOException;

public class DictionaryServer {

    public static void  main(String[] args) throws IOException {

        IReader reader = new ConsoleReader();
        IWriter writer = new ConsoleWriter();

        IServerExecutioner serverExecutioner = new ServerExecutioner(reader, writer);

        serverExecutioner.Execute();

    }//main

}//DictionaryServer
