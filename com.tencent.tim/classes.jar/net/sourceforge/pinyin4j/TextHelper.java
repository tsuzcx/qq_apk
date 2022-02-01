package net.sourceforge.pinyin4j;

class TextHelper
{
  static String extractPinyinString(String paramString)
  {
    return paramString.substring(0, paramString.length() - 1);
  }
  
  static String extractToneNumber(String paramString)
  {
    return paramString.substring(paramString.length() - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     net.sourceforge.pinyin4j.TextHelper
 * JD-Core Version:    0.7.0.1
 */