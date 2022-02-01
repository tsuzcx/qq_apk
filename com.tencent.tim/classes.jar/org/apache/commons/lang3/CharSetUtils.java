package org.apache.commons.lang3;

public class CharSetUtils
{
  public static boolean containsAny(String paramString, String... paramVarArgs)
  {
    if ((StringUtils.isEmpty(paramString)) || (deepEmpty(paramVarArgs))) {}
    for (;;)
    {
      return false;
      paramVarArgs = CharSet.getInstance(paramVarArgs);
      paramString = paramString.toCharArray();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        if (paramVarArgs.contains(paramString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static int count(String paramString, String... paramVarArgs)
  {
    int i = 0;
    int j = 0;
    int k = j;
    if (!StringUtils.isEmpty(paramString))
    {
      if (deepEmpty(paramVarArgs)) {
        k = j;
      }
    }
    else {
      return k;
    }
    paramVarArgs = CharSet.getInstance(paramVarArgs);
    paramString = paramString.toCharArray();
    int m = paramString.length;
    j = 0;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      k = i;
      if (paramVarArgs.contains(paramString[j])) {
        k = i + 1;
      }
      j += 1;
      i = k;
    }
  }
  
  private static boolean deepEmpty(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (StringUtils.isNotEmpty(paramArrayOfString[i])) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  public static String delete(String paramString, String... paramVarArgs)
  {
    if ((StringUtils.isEmpty(paramString)) || (deepEmpty(paramVarArgs))) {
      return paramString;
    }
    return modify(paramString, paramVarArgs, false);
  }
  
  public static String keep(String paramString, String... paramVarArgs)
  {
    if (paramString == null) {
      return null;
    }
    if ((paramString.isEmpty()) || (deepEmpty(paramVarArgs))) {
      return "";
    }
    return modify(paramString, paramVarArgs, true);
  }
  
  private static String modify(String paramString, String[] paramArrayOfString, boolean paramBoolean)
  {
    paramArrayOfString = CharSet.getInstance(paramArrayOfString);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    paramString = paramString.toCharArray();
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfString.contains(paramString[i]) == paramBoolean) {
        localStringBuilder.append(paramString[i]);
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String squeeze(String paramString, String... paramVarArgs)
  {
    if ((StringUtils.isEmpty(paramString)) || (deepEmpty(paramVarArgs))) {
      return paramString;
    }
    paramVarArgs = CharSet.getInstance(paramVarArgs);
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    paramString = paramString.toCharArray();
    int k = paramString.length;
    int i = 0;
    int j = 32;
    if (i < k)
    {
      char c = paramString[i];
      if ((c == j) && (i != 0) && (paramVarArgs.contains(c))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(c);
        j = c;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.CharSetUtils
 * JD-Core Version:    0.7.0.1
 */