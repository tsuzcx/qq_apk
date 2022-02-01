package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ResourcesReader
  implements ConfigReader
{
  private static final String RES_NAME_PREFIX = "agc_";
  private static final String RES_TYPE_STRING = "string";
  private final Context mContext;
  
  ResourcesReader(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private static String getResName(String paramString)
  {
    try
    {
      paramString = "agc_" + Hex.encodeHexString(sha256(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "";
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  private static byte[] sha256(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    return MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = getResName(paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    int i;
    do
    {
      return paramString2;
      String str = this.mContext.getPackageName();
      i = this.mContext.getResources().getIdentifier(paramString1, "string", str);
    } while (i == 0);
    try
    {
      paramString1 = this.mContext.getResources().getString(i);
      return paramString1;
    }
    catch (Resources.NotFoundException paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.agconnect.config.impl.ResourcesReader
 * JD-Core Version:    0.7.0.1
 */