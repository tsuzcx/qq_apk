package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;

class PinyinRomanizationTranslator
{
  static String convertRomanizationSystem(String paramString, PinyinRomanizationType paramPinyinRomanizationType1, PinyinRomanizationType paramPinyinRomanizationType2)
  {
    String str2 = TextHelper.extractPinyinString(paramString);
    String str1 = TextHelper.extractToneNumber(paramString);
    paramString = null;
    try
    {
      paramPinyinRomanizationType1 = "//" + paramPinyinRomanizationType1.getTagName() + "[text()='" + str2 + "']";
      paramPinyinRomanizationType1 = PinyinRomanizationResource.getInstance().getPinyinMappingDoc().xpathSelectElement(paramPinyinRomanizationType1);
      if (paramPinyinRomanizationType1 != null)
      {
        paramString = paramPinyinRomanizationType1.xpathSelectString("../" + paramPinyinRomanizationType2.getTagName() + "/text()");
        paramString = paramString + str1;
      }
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.PinyinRomanizationTranslator
 * JD-Core Version:    0.7.0.1
 */