package com.tencent.qqmail.utilities.stringextention;

public class CharacterUtil
{
  public static String toBJ(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == '　') {
        paramString[i] = 32;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramString[i] == '。') {
          paramString[i] = 46;
        } else if ((paramString[i] > 65280) && (paramString[i] < 65375)) {
          paramString[i] = ((char)(paramString[i] - 65248));
        }
      }
    }
    return new String(paramString);
  }
  
  public static String toQJ(String paramString)
  {
    paramString = paramString.toCharArray();
    int i = 0;
    if (i < paramString.length)
    {
      if (paramString[i] == ' ') {
        paramString[i] = 12288;
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramString[i] == '.') {
          paramString[i] = 12290;
        } else if (paramString[i] < '') {
          paramString[i] = ((char)(paramString[i] + 65248));
        }
      }
    }
    return new String(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.stringextention.CharacterUtil
 * JD-Core Version:    0.7.0.1
 */