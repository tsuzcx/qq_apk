package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinHelper
{
  private static String[] convertToGwoyeuRomatzyhStringArray(char paramChar)
  {
    String[] arrayOfString1 = getUnformattedHanyuPinyinStringArray(paramChar);
    if (arrayOfString1 != null)
    {
      String[] arrayOfString2 = new String[arrayOfString1.length];
      int i = 0;
      while (i < arrayOfString1.length)
      {
        arrayOfString2[i] = GwoyeuRomatzyhTranslator.convertHanyuPinyinToGwoyeuRomatzyh(arrayOfString1[i]);
        i += 1;
      }
      return arrayOfString2;
    }
    return null;
  }
  
  private static String[] convertToTargetPinyinStringArray(char paramChar, PinyinRomanizationType paramPinyinRomanizationType)
  {
    String[] arrayOfString1 = getUnformattedHanyuPinyinStringArray(paramChar);
    if (arrayOfString1 != null)
    {
      String[] arrayOfString2 = new String[arrayOfString1.length];
      int i = 0;
      while (i < arrayOfString1.length)
      {
        arrayOfString2[i] = PinyinRomanizationTranslator.convertRomanizationSystem(arrayOfString1[i], PinyinRomanizationType.HANYU_PINYIN, paramPinyinRomanizationType);
        i += 1;
      }
      return arrayOfString2;
    }
    return null;
  }
  
  private static String getFirstHanyuPinyinString(char paramChar, HanyuPinyinOutputFormat paramHanyuPinyinOutputFormat)
    throws BadHanyuPinyinOutputFormatCombination
  {
    paramHanyuPinyinOutputFormat = getFormattedHanyuPinyinStringArray(paramChar, paramHanyuPinyinOutputFormat);
    if ((paramHanyuPinyinOutputFormat != null) && (paramHanyuPinyinOutputFormat.length > 0)) {
      return paramHanyuPinyinOutputFormat[0];
    }
    return null;
  }
  
  private static String[] getFormattedHanyuPinyinStringArray(char paramChar, HanyuPinyinOutputFormat paramHanyuPinyinOutputFormat)
    throws BadHanyuPinyinOutputFormatCombination
  {
    String[] arrayOfString = getUnformattedHanyuPinyinStringArray(paramChar);
    if (arrayOfString != null)
    {
      int i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = PinyinFormatter.formatHanyuPinyin(arrayOfString[i], paramHanyuPinyinOutputFormat);
        i += 1;
      }
      return arrayOfString;
    }
    return null;
  }
  
  private static String[] getUnformattedHanyuPinyinStringArray(char paramChar)
  {
    return ChineseToPinyinResource.getInstance().getHanyuPinyinStringArray(paramChar);
  }
  
  public static String[] toGwoyeuRomatzyhStringArray(char paramChar)
  {
    return convertToGwoyeuRomatzyhStringArray(paramChar);
  }
  
  public static String toHanyuPinyinString(String paramString1, HanyuPinyinOutputFormat paramHanyuPinyinOutputFormat, String paramString2)
    throws BadHanyuPinyinOutputFormatCombination
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    if (i < paramString1.length())
    {
      String str = getFirstHanyuPinyinString(paramString1.charAt(i), paramHanyuPinyinOutputFormat);
      if (str != null)
      {
        localStringBuffer.append(str);
        if (i != paramString1.length() - 1) {
          localStringBuffer.append(paramString2);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuffer.append(paramString1.charAt(i));
      }
    }
    return localStringBuffer.toString();
  }
  
  public static String[] toHanyuPinyinStringArray(char paramChar)
  {
    return getUnformattedHanyuPinyinStringArray(paramChar);
  }
  
  public static String[] toHanyuPinyinStringArray(char paramChar, HanyuPinyinOutputFormat paramHanyuPinyinOutputFormat)
    throws BadHanyuPinyinOutputFormatCombination
  {
    return getFormattedHanyuPinyinStringArray(paramChar, paramHanyuPinyinOutputFormat);
  }
  
  public static String[] toMPS2PinyinStringArray(char paramChar)
  {
    return convertToTargetPinyinStringArray(paramChar, PinyinRomanizationType.MPS2_PINYIN);
  }
  
  public static String[] toTongyongPinyinStringArray(char paramChar)
  {
    return convertToTargetPinyinStringArray(paramChar, PinyinRomanizationType.TONGYONG_PINYIN);
  }
  
  public static String[] toWadeGilesPinyinStringArray(char paramChar)
  {
    return convertToTargetPinyinStringArray(paramChar, PinyinRomanizationType.WADEGILES_PINYIN);
  }
  
  public static String[] toYalePinyinStringArray(char paramChar)
  {
    return convertToTargetPinyinStringArray(paramChar, PinyinRomanizationType.YALE_PINYIN);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.PinyinHelper
 * JD-Core Version:    0.7.0.1
 */