package com.tencent.mm.platformtools;

public class CnToSpell
{
  public static String getFullSpell(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    int j = paramString.length;
    while (i < j)
    {
      String str = SpellMap.getSpell(paramString[i]);
      if (str != null) {
        localStringBuffer.append(str);
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String getInitial(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString.trim()))) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if (!Character.isSpace(paramString[i]))
      {
        String str = SpellMap.getSpell(paramString[i]);
        if ((str != null) && (str.length() > 0)) {
          localStringBuffer.append(str.charAt(0));
        }
      }
      i += 1;
    }
    return localStringBuffer.toString().toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.CnToSpell
 * JD-Core Version:    0.7.0.1
 */