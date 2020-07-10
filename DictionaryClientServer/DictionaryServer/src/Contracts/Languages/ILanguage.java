package Contracts.Languages;

import java.util.HashMap;

public interface ILanguage {

    String Translate(HashMap<String,String> dictionary, String inputText);

}//ILanguage
