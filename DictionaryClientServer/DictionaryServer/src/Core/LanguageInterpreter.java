package Core;

import Contracts.Core.ILanguageInterpreter;
import Contracts.Factory.ILanguageFactory;
import Contracts.IO.IReader;
import Contracts.IO.IWriter;
import Contracts.Languages.ILanguage;
import Factory.LanguageFactory;
import LanguageDetection.LanguageTextDetector;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class LanguageInterpreter implements ILanguageInterpreter {

    private DataInputStream inputFromClient;
    private DataOutputStream outputFromServer;

    // Name of the txt file
    private static final String FILE_NAME = "C:\\Users\\Valkin\\Desktop\\Java Project\\Dictionary.txt";

    @Override
    public void Interprete(IReader reader, IWriter writer, BufferedReader bufferedReader, Socket socket) throws IOException {

        // Data input and output streams
        DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
        DataOutputStream outputFromServer = new DataOutputStream(socket.getOutputStream());

        HashMap<String,String> dictionary = (HashMap<String, String>) getLanguageMap(bufferedReader);

        while (true) {

            try {

                // Receive request from the client
                String inputText = reader.ReadLine(inputFromClient);

                if (inputText.equalsIgnoreCase("END PROGRAM!")){

                    // Send a response for ending the program
                    writer.WriteLine(outputFromServer, "Have a nice day!");

                    break;
                }

                LanguageTextDetector identifier = new LanguageTextDetector(inputText);

                ILanguageFactory languageFactory = new LanguageFactory();

                ILanguage language = languageFactory.CreateLanguage(identifier.toString());

                String translatedText = language.Translate(dictionary, inputText);

                // Send the response to the Client
                writer.WriteLine(outputFromServer, translatedText);

            }
            catch (IllegalArgumentException | IOException ex){
                writer.WriteLine(outputFromServer, ex.getMessage());
            }

        }

    }//Interprete

    private Map<String, String> getLanguageMap(BufferedReader bufferedReader) {

        // Initialize a HashMap
        Map<String, String> tempDictionary = new HashMap<String, String>();

        try {

            // Read the current line
            String currentLine = bufferedReader.readLine();

            while (currentLine != null){

                // Split the current line into two parts - the word in english and the second the translation
                String[] lineWordsArr = currentLine.split(" - ");

                // Adding key and value to the HashMap
                tempDictionary.put(lineWordsArr[0], lineWordsArr[1]);
                tempDictionary.put(lineWordsArr[1], lineWordsArr[0]);

                // Read the current line
                currentLine = bufferedReader.readLine();
            }
        } catch (IOException e){}

        // Return the completed HashMap
        return tempDictionary;

    }//getStringStringMap

}//LanguageInterpreter
