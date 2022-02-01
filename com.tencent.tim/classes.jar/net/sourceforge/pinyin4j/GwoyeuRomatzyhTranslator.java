package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.Document;
import com.hp.hpl.sparta.Element;
import com.hp.hpl.sparta.ParseException;

class GwoyeuRomatzyhTranslator
{
  private static String[] tones = { "_I", "_II", "_III", "_IV", "_V" };
  
  static String convertHanyuPinyinToGwoyeuRomatzyh(String paramString)
  {
    Object localObject = TextHelper.extractPinyinString(paramString);
    String str = TextHelper.extractToneNumber(paramString);
    paramString = null;
    try
    {
      localObject = "//" + PinyinRomanizationType.HANYU_PINYIN.getTagName() + "[text()='" + (String)localObject + "']";
      localObject = GwoyeuRomatzyhResource.getInstance().getPinyinToGwoyeuMappingDoc().xpathSelectElement((String)localObject);
      if (localObject != null) {
        paramString = ((Element)localObject).xpathSelectString("../" + PinyinRomanizationType.GWOYEU_ROMATZYH.getTagName() + tones[(java.lang.Integer.parseInt(str) - 1)] + "/text()");
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
 * Qualified Name:     net.sourceforge.pinyin4j.GwoyeuRomatzyhTranslator
 * JD-Core Version:    0.7.0.1
 */