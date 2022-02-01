package org.apache.commons.lang3.text;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;

public class WordUtils
{
  public static String capitalize(String paramString)
  {
    return capitalize(paramString, null);
  }
  
  public static String capitalize(String paramString, char... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (int i = -1; (StringUtils.isEmpty(paramString)) || (i == 0); i = paramVarArgs.length) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int j = 0;
    int k = 1;
    if (j < paramString.length)
    {
      char c = paramString[j];
      if (isDelimiter(c, paramVarArgs)) {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (k != 0)
        {
          paramString[j] = Character.toTitleCase(c);
          i = 0;
        }
      }
    }
    return new String(paramString);
  }
  
  public static String capitalizeFully(String paramString)
  {
    return capitalizeFully(paramString, null);
  }
  
  public static String capitalizeFully(String paramString, char... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (int i = -1; (StringUtils.isEmpty(paramString)) || (i == 0); i = paramVarArgs.length) {
      return paramString;
    }
    return capitalize(paramString.toLowerCase(), paramVarArgs);
  }
  
  public static String initials(String paramString)
  {
    return initials(paramString, null);
  }
  
  public static String initials(String paramString, char... paramVarArgs)
  {
    if (StringUtils.isEmpty(paramString)) {
      return paramString;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 0)) {
      return "";
    }
    int i1 = paramString.length();
    char[] arrayOfChar = new char[i1 / 2 + 1];
    int j = 0;
    int n = 1;
    int k = 0;
    if (j < i1)
    {
      char c = paramString.charAt(j);
      int i;
      int m;
      if (isDelimiter(c, paramVarArgs))
      {
        i = 1;
        m = k;
      }
      for (;;)
      {
        j += 1;
        n = i;
        k = m;
        break;
        i = n;
        m = k;
        if (n != 0)
        {
          arrayOfChar[k] = c;
          m = k + 1;
          i = 0;
        }
      }
    }
    return new String(arrayOfChar, 0, k);
  }
  
  private static boolean isDelimiter(char paramChar, char[] paramArrayOfChar)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfChar == null)
    {
      bool1 = Character.isWhitespace(paramChar);
      return bool1;
    }
    int j = paramArrayOfChar.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      if (paramChar == paramArrayOfChar[i]) {
        return true;
      }
      i += 1;
    }
  }
  
  public static String swapCase(String paramString)
  {
    if (StringUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    boolean bool = true;
    int i = 0;
    if (i < paramString.length)
    {
      char c = paramString[i];
      if (Character.isUpperCase(c))
      {
        paramString[i] = Character.toLowerCase(c);
        bool = false;
      }
      for (;;)
      {
        i += 1;
        break;
        if (Character.isTitleCase(c))
        {
          paramString[i] = Character.toLowerCase(c);
          bool = false;
        }
        else if (Character.isLowerCase(c))
        {
          if (bool)
          {
            paramString[i] = Character.toTitleCase(c);
            bool = false;
          }
          else
          {
            paramString[i] = Character.toUpperCase(c);
          }
        }
        else
        {
          bool = Character.isWhitespace(c);
        }
      }
    }
    return new String(paramString);
  }
  
  public static String uncapitalize(String paramString)
  {
    return uncapitalize(paramString, null);
  }
  
  public static String uncapitalize(String paramString, char... paramVarArgs)
  {
    if (paramVarArgs == null) {}
    for (int i = -1; (StringUtils.isEmpty(paramString)) || (i == 0); i = paramVarArgs.length) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int j = 0;
    int k = 1;
    if (j < paramString.length)
    {
      char c = paramString[j];
      if (isDelimiter(c, paramVarArgs)) {
        i = 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        i = k;
        if (k != 0)
        {
          paramString[j] = Character.toLowerCase(c);
          i = 0;
        }
      }
    }
    return new String(paramString);
  }
  
  public static String wrap(String paramString, int paramInt)
  {
    return wrap(paramString, paramInt, null, false);
  }
  
  public static String wrap(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    if (paramString1 == null) {
      return null;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = SystemUtils.LINE_SEPARATOR;
    }
    int i = paramInt;
    if (paramInt < 1) {
      i = 1;
    }
    int j = paramString1.length();
    paramInt = 0;
    paramString2 = new StringBuilder(j + 32);
    for (;;)
    {
      if (paramInt < j)
      {
        if (paramString1.charAt(paramInt) == ' ')
        {
          paramInt += 1;
          continue;
        }
        if (j - paramInt > i) {}
      }
      else
      {
        paramString2.append(paramString1.substring(paramInt));
        return paramString2.toString();
      }
      int k = paramString1.lastIndexOf(' ', i + paramInt);
      if (k >= paramInt)
      {
        paramString2.append(paramString1.substring(paramInt, k));
        paramString2.append(str);
        paramInt = k + 1;
      }
      else if (paramBoolean)
      {
        paramString2.append(paramString1.substring(paramInt, i + paramInt));
        paramString2.append(str);
        paramInt += i;
      }
      else
      {
        k = paramString1.indexOf(' ', i + paramInt);
        if (k >= 0)
        {
          paramString2.append(paramString1.substring(paramInt, k));
          paramString2.append(str);
          paramInt = k + 1;
        }
        else
        {
          paramString2.append(paramString1.substring(paramInt));
          paramInt = j;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.text.WordUtils
 * JD-Core Version:    0.7.0.1
 */