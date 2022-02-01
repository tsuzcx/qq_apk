package com.tmsdk.common.util;

import android.util.Log;

public final class TmsLog
{
  private static boolean sIsLoggable = true;
  
  public static void d(String paramString1, String paramString2)
  {
    println(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    println(6, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramThrowable.getMessage());
    println(6, paramString1, localStringBuilder.toString());
  }
  
  public static void f(String paramString1, String paramString2)
  {
    writeLog(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    println(4, paramString1, paramString2);
  }
  
  static void println(int paramInt, String paramString1, String paramString2)
  {
    if (!sIsLoggable) {
      return;
    }
    String str = paramString2;
    if (paramString2 == null) {
      str = "(null)";
    }
    Log.println(paramInt, "TMSDK_".concat(String.valueOf(paramString1)), str);
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    sIsLoggable = paramBoolean;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    println(2, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    println(5, paramString1, paramString2);
  }
  
  /* Error */
  static void writeLog(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 44	com/tmsdk/common/util/TmsLog:sIsLoggable	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_2
    //   9: ldc 71
    //   11: invokestatic 76	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   14: invokevirtual 80	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +96 -> 113
    //   20: new 23	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   27: astore_3
    //   28: aload_3
    //   29: invokestatic 84	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   32: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_3
    //   37: ldc 89
    //   39: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_3
    //   44: aload_0
    //   45: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 91	java/io/File
    //   52: dup
    //   53: aload_3
    //   54: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 94	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 98	java/io/File:exists	()Z
    //   65: ifne +19 -> 84
    //   68: aload_0
    //   69: invokevirtual 101	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   72: invokevirtual 104	java/io/File:getParentFile	()Ljava/io/File;
    //   75: invokevirtual 107	java/io/File:mkdirs	()Z
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 110	java/io/File:createNewFile	()Z
    //   83: pop
    //   84: new 112	java/io/FileOutputStream
    //   87: dup
    //   88: aload_0
    //   89: iconst_0
    //   90: invokespecial 115	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   93: astore_0
    //   94: aload_0
    //   95: aload_1
    //   96: invokevirtual 119	java/lang/String:getBytes	()[B
    //   99: invokevirtual 123	java/io/FileOutputStream:write	([B)V
    //   102: goto +13 -> 115
    //   105: astore_1
    //   106: aload_0
    //   107: astore_2
    //   108: aload_1
    //   109: astore_0
    //   110: goto +15 -> 125
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: ifnull +30 -> 146
    //   119: aload_0
    //   120: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   123: return
    //   124: astore_0
    //   125: aload_2
    //   126: ifnull +7 -> 133
    //   129: aload_2
    //   130: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   133: aload_0
    //   134: athrow
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: ifnull +8 -> 146
    //   141: aload_0
    //   142: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   145: return
    //   146: return
    //   147: astore_0
    //   148: goto -13 -> 135
    //   151: astore_1
    //   152: goto -15 -> 137
    //   155: astore_0
    //   156: return
    //   157: astore_1
    //   158: goto -25 -> 133
    //   161: astore_0
    //   162: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramString1	String
    //   0	163	1	paramString2	String
    //   8	122	2	str	String
    //   27	27	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	102	105	finally
    //   9	84	124	finally
    //   84	94	124	finally
    //   9	84	147	java/lang/Throwable
    //   84	94	147	java/lang/Throwable
    //   94	102	151	java/lang/Throwable
    //   119	123	155	java/io/IOException
    //   129	133	157	java/io/IOException
    //   141	145	161	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.common.util.TmsLog
 * JD-Core Version:    0.7.0.1
 */