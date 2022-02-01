package com.huawei.updatesdk.a.a.c;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.a.a.a;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Locale;

public abstract class g
{
  public static String a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("~", "%7E");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      a.a("StringUtils", "encode2utf8 error", paramString);
    }
    return null;
  }
  
  public static boolean b(String paramString)
  {
    return (paramString != null) && (paramString.trim().startsWith("{")) && (paramString.trim().endsWith("}"));
  }
  
  public static String c(String paramString)
  {
    paramString = e(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.toLowerCase(Locale.getDefault());
  }
  
  public static byte[] d(String paramString)
  {
    paramString = paramString.toCharArray();
    int m = paramString.length / 2;
    byte[] arrayOfByte = new byte[m];
    int i = 0;
    while (i < m)
    {
      int k = Character.digit(paramString[(i * 2)], 16) << 4 | Character.digit(paramString[(i * 2 + 1)], 16);
      int j = k;
      if (k > 127) {
        j = k - 256;
      }
      arrayOfByte[i] = Byte.valueOf(String.valueOf(j)).byteValue();
      i += 1;
    }
    return arrayOfByte;
  }
  
  private static String e(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      Object localObject = MessageDigest.getInstance("SHA-256");
      ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
      paramString = new StringBuffer();
      localObject = ((MessageDigest)localObject).digest();
      int j = localObject.length;
      while (i < j)
      {
        byte b = localObject[i];
        paramString.append(String.format(Locale.ROOT, "%02X", new Object[] { Byte.valueOf(b) }));
        i += 1;
      }
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      a.d("StringUtils", "sha256EncryptStr error:Exception");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.g
 * JD-Core Version:    0.7.0.1
 */