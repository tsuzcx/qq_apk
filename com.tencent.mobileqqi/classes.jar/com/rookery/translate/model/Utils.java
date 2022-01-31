package com.rookery.translate.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Utils
{
  @TargetApi(8)
  public static File a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 8) {
      return paramContext.getExternalCacheDir();
    }
    paramContext = "/Android/data/" + paramContext.getPackageName() + "/cache/";
    return new File(Environment.getExternalStorageDirectory().getPath() + paramContext);
  }
  
  public static String a(String paramString)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      paramString = new BigInteger(1, localMessageDigest.digest()).toString(16);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      throw new AssertionError();
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new AssertionError();
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + "{@}" + paramString2;
  }
  
  public static String a(String paramString1, String paramString2, long paramLong)
  {
    return paramString1 + "[@]" + paramString2 + "[id:]" + paramLong;
  }
  
  @TargetApi(9)
  public static boolean a()
  {
    if (Build.VERSION.SDK_INT >= 9) {
      return Environment.isExternalStorageRemovable();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.rookery.translate.model.Utils
 * JD-Core Version:    0.7.0.1
 */