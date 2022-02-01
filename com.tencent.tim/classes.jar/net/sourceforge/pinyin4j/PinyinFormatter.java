package net.sourceforge.pinyin4j;

import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

class PinyinFormatter
{
  private static String convertToneNumber2ToneMark(String paramString)
  {
    String str = paramString.toLowerCase();
    paramString = str;
    int m;
    int i;
    int k;
    int j;
    if (str.matches("[a-z]*[1-5]?"))
    {
      if (!str.matches("[a-z]*[1-5]")) {
        break label264;
      }
      m = Character.getNumericValue(str.charAt(str.length() - 1));
      i = str.indexOf('a');
      k = str.indexOf('e');
      j = str.indexOf("ou");
      if (-1 == i) {
        break label182;
      }
      j = 97;
    }
    label264:
    for (;;)
    {
      paramString = str;
      if (36 != j)
      {
        paramString = str;
        if (-1 != i)
        {
          char c = "āáăàaēéĕèeīíĭìiōóŏòoūúŭùuǖǘǚǜü".charAt("aeiouv".indexOf(j) * 5 + (m - 1));
          paramString = new StringBuffer();
          paramString.append(str.substring(0, i).replaceAll("v", "ü"));
          paramString.append(c);
          paramString.append(str.substring(i + 1, str.length() - 1).replaceAll("v", "ü"));
          paramString = paramString.toString();
        }
      }
      return paramString;
      label182:
      if (-1 != k)
      {
        i = k;
        j = 101;
      }
      else if (-1 != j)
      {
        k = "ou".charAt(0);
        i = j;
        j = k;
      }
      else
      {
        i = str.length() - 1;
        for (;;)
        {
          if (i >= 0)
          {
            if (String.valueOf(str.charAt(i)).matches("[aeiouv]"))
            {
              j = str.charAt(i);
              break;
            }
            i -= 1;
            continue;
            return str.replaceAll("v", "ü");
          }
        }
        i = -1;
        j = 36;
      }
    }
  }
  
  static String formatHanyuPinyin(String paramString, HanyuPinyinOutputFormat paramHanyuPinyinOutputFormat)
    throws BadHanyuPinyinOutputFormatCombination
  {
    if ((HanyuPinyinToneType.WITH_TONE_MARK == paramHanyuPinyinOutputFormat.getToneType()) && ((HanyuPinyinVCharType.WITH_V == paramHanyuPinyinOutputFormat.getVCharType()) || (HanyuPinyinVCharType.WITH_U_AND_COLON == paramHanyuPinyinOutputFormat.getVCharType()))) {
      throw new BadHanyuPinyinOutputFormatCombination("tone marks cannot be added to v or u:");
    }
    String str;
    if (HanyuPinyinToneType.WITHOUT_TONE == paramHanyuPinyinOutputFormat.getToneType())
    {
      str = paramString.replaceAll("[1-5]", "");
      if (HanyuPinyinVCharType.WITH_V != paramHanyuPinyinOutputFormat.getVCharType()) {
        break label124;
      }
      paramString = str.replaceAll("u:", "v");
    }
    for (;;)
    {
      str = paramString;
      if (HanyuPinyinCaseType.UPPERCASE == paramHanyuPinyinOutputFormat.getCaseType()) {
        str = paramString.toUpperCase();
      }
      return str;
      str = paramString;
      if (HanyuPinyinToneType.WITH_TONE_MARK != paramHanyuPinyinOutputFormat.getToneType()) {
        break;
      }
      str = convertToneNumber2ToneMark(paramString.replaceAll("u:", "v"));
      break;
      label124:
      paramString = str;
      if (HanyuPinyinVCharType.WITH_U_UNICODE == paramHanyuPinyinOutputFormat.getVCharType()) {
        paramString = str.replaceAll("u:", "ü");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.PinyinFormatter
 * JD-Core Version:    0.7.0.1
 */