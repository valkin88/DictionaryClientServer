package Factory;

import Contracts.Factory.ILanguageFactory;
import Contracts.Languages.ILanguage;
import Languages.BulgarianLanguage;
import Languages.EnglishLanguage;

public class LanguageFactory implements ILanguageFactory {

    @Override
    public ILanguage CreateLanguage(String type) {

        if (type.equals("EnglishLanguage")){
            return new EnglishLanguage(type);
        }
        if (type.equals("BulgarianLanguage")){
            return new BulgarianLanguage(type);
        }

        throw new IllegalArgumentException("Language CLASS NOT FOUND!");

    }//CreateLanguage

}//LanguageFactory
