package com.tencent.mm.sdk.platformtools;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.algorithm.MD5;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

public class Log
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  private static PrintStream W;
  private static byte[] X;
  private static final String Y;
  private static int level = 6;
  
  static
  {
    X = null;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
    localStringBuilder.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
    localStringBuilder.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
    localStringBuilder.append("] BOARD:[" + Build.BOARD);
    localStringBuilder.append("] DEVICE:[" + Build.DEVICE);
    localStringBuilder.append("] DISPLAY:[" + Build.DISPLAY);
    localStringBuilder.append("] FINGERPRINT:[" + Build.FINGERPRINT);
    localStringBuilder.append("] HOST:[" + Build.HOST);
    localStringBuilder.append("] MANUFACTURER:[" + Build.MANUFACTURER);
    localStringBuilder.append("] MODEL:[" + Build.MODEL);
    localStringBuilder.append("] PRODUCT:[" + Build.PRODUCT);
    localStringBuilder.append("] TAGS:[" + Build.TAGS);
    localStringBuilder.append("] TYPE:[" + Build.TYPE);
    localStringBuilder.append("] USER:[" + Build.USER + "]");
    Y = localStringBuilder.toString();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 1) {
      if (paramVarArgs != null) {
        break label44;
      }
    }
    for (;;)
    {
      android.util.Log.d(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "D/" + paramString1, paramString2);
      return;
      label44:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 4) {
      if (paramVarArgs != null) {
        break label44;
      }
    }
    for (;;)
    {
      android.util.Log.e(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "E/" + paramString1, paramString2);
      return;
      label44:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 5) {
      if (paramVarArgs != null) {
        break label55;
      }
    }
    for (;;)
    {
      android.util.Log.e(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "F/" + paramString1, paramString2);
      MMHandlerThread.postToMainThread(new Log.1(paramString2));
      return;
      label55:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static int getLevel()
  {
    return level;
  }
  
  public static String getSysInfo()
  {
    return Y;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, null);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 2) {
      if (paramVarArgs != null) {
        break label44;
      }
    }
    for (;;)
    {
      android.util.Log.i(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "I/" + paramString1, paramString2);
      return;
      label44:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void reset()
  {
    W = null;
    X = null;
  }
  
  public static void setLevel(int paramInt, boolean paramBoolean)
  {
    level = paramInt;
    android.util.Log.w("MicroMsg.SDK.Log", "new log level: " + paramInt);
    if (paramBoolean) {
      android.util.Log.e("MicroMsg.SDK.Log", "no jni log level support");
    }
  }
  
  public static void setOutputPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString3 == null) || (paramString3.length() == 0)) {
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new File(paramString1);
        if (!((File)localObject).exists()) {
          break;
        }
        if (((File)localObject).length() > 0L)
        {
          localObject = new FileInputStream(paramString1);
          setOutputStream((InputStream)localObject, new FileOutputStream(paramString1, true), paramString2, paramString3, paramInt);
          if (localObject == null) {
            break;
          }
          ((InputStream)localObject).close();
          return;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      Object localObject = null;
    }
  }
  
  public static void setOutputStream(InputStream paramInputStream, OutputStream paramOutputStream, String paramString1, String paramString2, int paramInt)
  {
    try
    {
      W = new PrintStream(new BufferedOutputStream(paramOutputStream));
      long l;
      if (paramInputStream != null)
      {
        paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
        paramOutputStream = Util.nullAsNil(paramInputStream.readLine()).substring(2).trim();
        paramString2 = Util.nullAsNil(paramInputStream.readLine()).substring(2).trim();
        l = Util.getLong(Util.nullAsNil(paramInputStream.readLine()).trim().substring(2), 0L);
        d("MicroMsg.SDK.Log", "using provided info, type=%s, user=%s, createtime=%d", new Object[] { paramOutputStream, paramString2, Long.valueOf(l) });
      }
      for (;;)
      {
        paramInputStream = new StringBuffer();
        paramInputStream.append(paramString2);
        paramInputStream.append(l);
        paramInputStream.append("dfdhgc");
        X = MD5.getMessageDigest(paramInputStream.toString().getBytes()).substring(7, 21).getBytes();
        android.util.Log.d("MicroMsg.SDK.Log", "set up out put stream");
        return;
        l = System.currentTimeMillis();
        LogHelper.initLogHeader(W, paramString1, paramString2, l, paramInt);
      }
      return;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 0) {
      if (paramVarArgs != null) {
        break label44;
      }
    }
    for (;;)
    {
      android.util.Log.v(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "V/" + paramString1, paramString2);
      return;
      label44:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 3) {
      if (paramVarArgs != null) {
        break label45;
      }
    }
    for (;;)
    {
      android.util.Log.w(paramString1, paramString2);
      LogHelper.writeToStream(W, X, "W/" + paramString1, paramString2);
      return;
      label45:
      paramString2 = String.format(paramString2, paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Log
 * JD-Core Version:    0.7.0.1
 */