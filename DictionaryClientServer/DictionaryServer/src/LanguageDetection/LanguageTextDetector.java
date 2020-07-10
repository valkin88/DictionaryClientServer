package LanguageDetection;

public class LanguageTextDetector {

    private String inputText;
    private String typeOfLanguage;

    public LanguageTextDetector(String text) {
        this.inputText = text;
        this.typeOfLanguage = getTypeOfLanguage();
    }

    private String getTypeOfLanguage(){

        String result = inputText;

        int enCounter = 0;
        int bgCounter = 0;

        for (int i = 0; i < inputText.length(); i++){

            String charToString = String.valueOf(inputText.charAt(i)).toLowerCase();

            if (charToString.matches("a|b|c|d|e|f|g|h|i|j|k|l|m|n|o|p|q|r|s|t|u|v|w|x|y|z|")){
                enCounter++;
            }
            else if (charToString.matches("а|б|в|г|д|е|ж|з|и|й|к|л|м|н|о|п|р|с|т|у|ф|х|ц|ч|ш|щ|ъ|ь|ю|я")) {
                bgCounter++;
            }
        }

        if (enCounter > 0 && bgCounter > 0){
            throw new IllegalArgumentException("Please Enter words in English or Bulgarian!");
        }
        else {
            if (enCounter > bgCounter){
                result = "EnglishLanguage";
            }
            else if (bgCounter > enCounter){
                result = "BulgarianLanguage";
            }
        }

        return result;

    }//getTypeOfLanguage

    @Override
    public String toString() {
        return this.typeOfLanguage;
    }

}//LanguageTextDetector
