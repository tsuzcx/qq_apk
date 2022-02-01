package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class b
{
  private static final String a = b.class.getSimpleName();
  private static final Pattern b = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  
  public static String a(String paramString)
  {
    return a(paramString, "SHA-256");
  }
  
  private static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = paramString1.getBytes("UTF-8");
      return null;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      try
      {
        paramString1 = a(MessageDigest.getInstance(paramString2).digest(paramString1));
        return paramString1;
      }
      catch (NoSuchAlgorithmException paramString1)
      {
        Logger.w(a, "encrypt NoSuchAlgorithmException");
      }
      paramString1 = paramString1;
      Logger.w(a, "encrypt UnsupportedEncodingException");
      return null;
    }
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() == 1) {
        localStringBuffer.append("0");
      }
      localStringBuffer.append(str);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String b(String paramString)
  {
    int j = 1;
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (paramString.length() == 1) {
      return "*";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramString.length())
    {
      String str1 = paramString.charAt(i) + "";
      int k = j;
      String str2 = str1;
      if (b.matcher(str1).matches())
      {
        if (j % 2 == 0) {
          str1 = "*";
        }
        k = j + 1;
        str2 = str1;
      }
      localStringBuffer.append(str2);
      i += 1;
      j = k;
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.b
 * JD-Core Version:    0.7.0.1
 */