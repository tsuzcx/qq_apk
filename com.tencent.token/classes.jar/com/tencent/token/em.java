package com.tencent.token;

import android.content.Context;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import tmsdk.common.e.a;
import tmsdk.common.tcc.TccCryptor;

public class em
{
  public static String a(Context paramContext, String paramString)
  {
    if (paramString == null) {
      return null;
    }
    byte[] arrayOfByte2;
    try
    {
      byte[] arrayOfByte1 = paramString.getBytes("gbk");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      arrayOfByte2 = null;
    }
    if (arrayOfByte2 != null) {
      return a.b(TccCryptor.encrypt(paramContext, arrayOfByte2, null), 0);
    }
    return paramString;
  }
  
  public static String b(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      byte[] arrayOfByte = a.a(paramString, 0);
      try
      {
        paramContext = TccCryptor.decrypt(paramContext, arrayOfByte, null);
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        paramContext = null;
      }
      if (paramContext == null) {}
    }
    catch (Exception paramContext)
    {
      label51:
      return null;
    }
    try
    {
      paramContext = new String(paramContext, "gbk");
    }
    catch (UnsupportedEncodingException paramContext)
    {
      break label51;
    }
    paramContext = null;
    if (paramContext != null) {
      return paramContext;
    }
    return paramString;
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.em
 * JD-Core Version:    0.7.0.1
 */