package com.tencent.mm.platformtools;

public class CnToSpell
{
  public static String getFullSpell(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      if ("".equals(paramString.trim())) {
        return paramString;
      }
      paramString = paramString.toCharArray();
      localObject = new StringBuffer();
      int i = 0;
      int j = paramString.length;
      while (i < j)
      {
        String str = SpellMap.getSpell(paramString[i]);
        if (str != null) {
          ((StringBuffer)localObject).append(str);
        }
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString();
    }
    return localObject;
  }
  
  public static String getInitial(String paramString)
  {
    Object localObject = paramString;
    if (paramString != null)
    {
      if ("".equals(paramString.trim())) {
        return paramString;
      }
      paramString = paramString.toCharArray();
      localObject = new StringBuffer();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        if (!Character.isSpace(paramString[i]))
        {
          String str = SpellMap.getSpell(paramString[i]);
          if ((str != null) && (str.length() > 0)) {
            ((StringBuffer)localObject).append(str.charAt(0));
          }
        }
        i += 1;
      }
      localObject = ((StringBuffer)localObject).toString().toUpperCase();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.CnToSpell
 * JD-Core Version:    0.7.0.1
 */