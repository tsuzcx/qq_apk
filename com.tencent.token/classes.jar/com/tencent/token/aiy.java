package com.tencent.token;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class aiy
{
  private static final Pattern a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  
  public static String a(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4)
  {
    if ((TextUtils.isEmpty(null)) && (!TextUtils.isEmpty(null))) {
      throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!a.matcher(paramString4).matches())) {
      throw new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(paramString4)));
    }
    StringBuilder localStringBuilder = new StringBuilder(120);
    localStringBuilder.append("SELECT ");
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      a(localStringBuilder, paramArrayOfString);
    } else {
      localStringBuilder.append("* ");
    }
    localStringBuilder.append("FROM ");
    localStringBuilder.append(paramString1);
    a(localStringBuilder, " WHERE ", paramString2);
    a(localStringBuilder, " GROUP BY ", null);
    a(localStringBuilder, " HAVING ", null);
    a(localStringBuilder, " ORDER BY ", paramString3);
    a(localStringBuilder, " LIMIT ", paramString4);
    return localStringBuilder.toString();
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      paramStringBuilder.append(paramString1);
      paramStringBuilder.append(paramString2);
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      if (str != null)
      {
        if (i > 0) {
          paramStringBuilder.append(", ");
        }
        paramStringBuilder.append(str);
      }
      i += 1;
    }
    paramStringBuilder.append(' ');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aiy
 * JD-Core Version:    0.7.0.1
 */