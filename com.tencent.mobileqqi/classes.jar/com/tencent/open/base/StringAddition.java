package com.tencent.open.base;

import android.text.TextUtils;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class StringAddition
{
  public static int a(String paramString)
  {
    int j = 0;
    if (paramString == null) {
      return 0;
    }
    int i = 0;
    if (j < paramString.length())
    {
      if (b(paramString.charAt(j))) {
        i += 2;
      }
      for (;;)
      {
        j += 1;
        break;
        i += 1;
      }
    }
    return i;
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("\\n", "\n").replace("&#92;", "\\").replace("&#39;", "'").replace("&quot;", "\"").replace("&gt;", ">").replace("&lt;", "<");
  }
  
  public static String a(String paramString, int paramInt)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label139;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label139:
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return "";
    }
    if (!paramBoolean) {
      return a(paramString, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label154;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label154:
      localStringBuilder.append("…");
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramString == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    CharBuffer localCharBuffer = Charset.forName("UTF-16").decode(Charset.forName("UTF-16").encode(paramString));
    int k = localCharBuffer.length();
    int j = 0;
    int i = paramInt;
    paramInt = j;
    if (paramInt < k)
    {
      if (Character.isHighSurrogate(localCharBuffer.charAt(paramInt)))
      {
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 2).toString();
        paramInt += 2;
      }
      for (;;)
      {
        j = a(paramString);
        if (i < j) {
          break label148;
        }
        i -= j;
        localStringBuilder.append(paramString);
        break;
        paramString = localCharBuffer.subSequence(paramInt, paramInt + 1).toString();
        paramInt += 1;
      }
      label148:
      if ((!paramBoolean1) || (paramBoolean2)) {
        break label188;
      }
      localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
      localStringBuilder.append("…");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label188:
      if ((paramBoolean1) && (paramBoolean2)) {
        localStringBuilder.append("…");
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    LogUtility.c("StringAddition", "replaceUrlParams params url=" + paramString1 + " key=" + paramString2 + " value=" + paramString3);
    if (TextUtils.isEmpty(paramString1)) {
      return "&" + paramString2 + "=" + paramString3;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramString1 = paramString1.split("&");
    if ((paramString1 == null) || (paramString1.length == 0)) {
      return "&" + paramString2 + "=" + paramString3;
    }
    int m = paramString1.length;
    int i = 0;
    int j = 0;
    if (i < m)
    {
      CharSequence localCharSequence = paramString1[i];
      int k = j;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        String[] arrayOfString = localCharSequence.split("=");
        k = j;
        if (arrayOfString != null)
        {
          k = j;
          if (arrayOfString.length > 1)
          {
            if (!arrayOfString[0].endsWith(paramString2)) {
              break label239;
            }
            localStringBuilder.append("&").append(paramString2).append("=").append(paramString3);
          }
        }
      }
      for (k = 1;; k = j)
      {
        i += 1;
        j = k;
        break;
        label239:
        localStringBuilder.append("&").append(localCharSequence);
      }
    }
    if (j == 0) {
      localStringBuilder.append("&").append(paramString2).append("=").append(paramString3);
    }
    LogUtility.c("StringAddition", "replaceUrlParams result=" + localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  protected static boolean a(char paramChar)
  {
    return (paramChar >= '一') && (paramChar <= 171941);
  }
  
  public static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.trim().length() == 0);
  }
  
  public static String[] a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.length() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int j;
    for (int i = 0;; i = paramString2.length() + j)
    {
      j = paramString1.indexOf(paramString2, i);
      if (j < 0)
      {
        localArrayList.add(paramString1.substring(i));
        i = localArrayList.size() - 1;
        while ((i >= 0) && (((String)localArrayList.get(i)).length() == 0))
        {
          localArrayList.remove(i);
          i -= 1;
        }
      }
      localArrayList.add(paramString1.substring(i, j));
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("%7D", "%257D").replace("%3A;", "%253A").replace("%2C';", "%252C").replace("}", "%7D").replace(":", "%3A").replace(",", "%2C");
  }
  
  protected static boolean b(char paramChar)
  {
    return (paramChar >= 'ÿ') || (paramChar < 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.open.base.StringAddition
 * JD-Core Version:    0.7.0.1
 */