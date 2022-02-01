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
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("VERSION.RELEASE:[");
    localStringBuilder2.append(Build.VERSION.RELEASE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] VERSION.CODENAME:[");
    localStringBuilder2.append(Build.VERSION.CODENAME);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] VERSION.INCREMENTAL:[");
    localStringBuilder2.append(Build.VERSION.INCREMENTAL);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] BOARD:[");
    localStringBuilder2.append(Build.BOARD);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] DEVICE:[");
    localStringBuilder2.append(Build.DEVICE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] DISPLAY:[");
    localStringBuilder2.append(Build.DISPLAY);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] FINGERPRINT:[");
    localStringBuilder2.append(Build.FINGERPRINT);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] HOST:[");
    localStringBuilder2.append(Build.HOST);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] MANUFACTURER:[");
    localStringBuilder2.append(Build.MANUFACTURER);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] MODEL:[");
    localStringBuilder2.append(Build.MODEL);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] PRODUCT:[");
    localStringBuilder2.append(Build.PRODUCT);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] TAGS:[");
    localStringBuilder2.append(Build.TAGS);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] TYPE:[");
    localStringBuilder2.append(Build.TYPE);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder("] USER:[");
    localStringBuilder2.append(Build.USER);
    localStringBuilder2.append("]");
    localStringBuilder1.append(localStringBuilder2.toString());
    Y = localStringBuilder1.toString();
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 1)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.d(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("D/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 4)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.e(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("E/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 5)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.e(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("F/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
      MMHandlerThread.postToMainThread(new Log.1(paramString2));
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
    if (level <= 2)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.i(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("I/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
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
    StringBuilder localStringBuilder = new StringBuilder("new log level: ");
    localStringBuilder.append(paramInt);
    android.util.Log.w("MicroMsg.SDK.Log", localStringBuilder.toString());
    if (paramBoolean) {
      android.util.Log.e("MicroMsg.SDK.Log", "no jni log level support");
    }
  }
  
  public static void setOutputPath(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString3 != null)) {
      if (paramString3.length() == 0) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new File(paramString1);
        if (!((File)localObject).exists()) {
          return;
        }
        if (((File)localObject).length() <= 0L) {
          break label99;
        }
        localObject = new FileInputStream(paramString1);
        setOutputStream((InputStream)localObject, new FileOutputStream(paramString1, true), paramString2, paramString3, paramInt);
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      return;
      label99:
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
      else
      {
        l = System.currentTimeMillis();
        LogHelper.initLogHeader(W, paramString1, paramString2, l, paramInt);
      }
      paramInputStream = new StringBuffer();
      paramInputStream.append(paramString2);
      paramInputStream.append(l);
      paramInputStream.append("dfdhgc");
      X = MD5.getMessageDigest(paramInputStream.toString().getBytes()).substring(7, 21).getBytes();
      android.util.Log.d("MicroMsg.SDK.Log", "set up out put stream");
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
    if (level <= 0)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.v(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("V/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (level <= 3)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      android.util.Log.w(paramString1, paramString2);
      paramVarArgs = W;
      byte[] arrayOfByte = X;
      StringBuilder localStringBuilder = new StringBuilder("W/");
      localStringBuilder.append(paramString1);
      LogHelper.writeToStream(paramVarArgs, arrayOfByte, localStringBuilder.toString(), paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.Log
 * JD-Core Version:    0.7.0.1
 */