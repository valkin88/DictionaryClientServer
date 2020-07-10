package Languages;

import Contracts.Languages.ILanguage;

import java.util.HashMap;

public class BulgarianLanguage extends Language implements ILanguage {

    public BulgarianLanguage(String languageType) {
        super(languageType);
    }

    /**
     * The method finds if the word for translation is present and returns a response
     * @param dictionary is a HashMap which contains the words with translation
     * @param inputText is the word that is send from the client for translation
     * @return the response if the word is found
     */
    @Override
    public String Translate(HashMap<String,String> dictionary, String inputText) {

        StringBuilder builder = new StringBuilder();

        String translatedWord = "";

        String[] textArray = inputText.split(" ");
        int counter = 0;

        for (String wordOrSymbol : textArray) {

            String currentWordOrSymbol = wordOrSymbol.toLowerCase();

            if (dictionary.containsKey(currentWordOrSymbol)){
                translatedWord = dictionary.get(currentWordOrSymbol);

                if (counter != textArray.length - 1){
                    translatedWord = translatedWord + " ";
                }

            }
            else {
                translatedWord = currentWordOrSymbol;

                if (counter != textArray.length - 1){
                    translatedWord = translatedWord + " ";
                }
            }

            builder.append(translatedWord);

            counter++;
        }

        return builder.toString();

    }//Translate

}//BulgarianLanguage
