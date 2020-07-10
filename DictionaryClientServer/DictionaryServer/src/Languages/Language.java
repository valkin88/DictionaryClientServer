package Languages;

import Contracts.Languages.ILanguage;

import java.util.HashMap;

public class Language implements ILanguage {

    private String languageType;

    protected Language(String languageType) {
        this.languageType = languageType;
    }

    public String getLanguageType() {
        return languageType;
    }

    /**
     * The method finds if the word for translation is present and returns a response
     * @param inputText is the word that is send from the claent for translation
     * @return the response if the word is found
     */
    public String Translate(HashMap<String,String> dictionary, String inputText) {

        return this.toString();

    }//Translate

}//Language
