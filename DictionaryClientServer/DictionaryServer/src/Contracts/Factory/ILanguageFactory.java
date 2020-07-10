package Contracts.Factory;

import Contracts.Languages.ILanguage;

public interface ILanguageFactory {

   ILanguage CreateLanguage(String type);

}//ILanguageFactory
