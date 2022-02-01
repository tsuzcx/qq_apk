package com.tencent.token;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ahy
{
  private static final Pattern a = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
  
  public static String a(String paramString1, String[] paramArrayOfString, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    if ((TextUtils.isEmpty(null)) && (!TextUtils.isEmpty(null))) {
      throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!a.matcher(paramString6).matches())) {
      throw new IllegalArgumentException("invalid LIMIT clauses:".concat(String.valueOf(paramString6)));
    }
    paramString3 = new StringBuilder(120);
    paramString3.append("SELECT ");
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0)) {
      a(paramString3, paramArrayOfString);
    } else {
      paramString3.append("* ");
    }
    paramString3.append("FROM ");
    paramString3.append(paramString1);
    a(paramString3, " WHERE ", paramString2);
    a(paramString3, " GROUP BY ", null);
    a(paramString3, " HAVING ", null);
    a(paramString3, " ORDER BY ", paramString5);
    a(paramString3, " LIMIT ", paramString6);
    return paramString3.toString();
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
 * Qualified Name:     com.tencent.token.ahy
 * JD-Core Version:    0.7.0.1
 */