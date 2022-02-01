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
    paramString2 = new StringBuilder();
    paramString2.append("TMSDK_");
    paramString2.append(paramString1);
    Log.println(paramInt, paramString2.toString(), str);
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
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_2
    //   11: ldc 61
    //   13: invokestatic 66	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   16: invokevirtual 72	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   19: ifeq +104 -> 123
    //   22: new 23	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 24	java/lang/StringBuilder:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: invokestatic 76	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   36: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: ldc 81
    //   44: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 4
    //   50: aload_0
    //   51: invokevirtual 28	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: new 83	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokevirtual 37	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore_0
    //   68: aload_0
    //   69: invokevirtual 90	java/io/File:exists	()Z
    //   72: ifne +19 -> 91
    //   75: aload_0
    //   76: invokevirtual 93	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   79: invokevirtual 96	java/io/File:getParentFile	()Ljava/io/File;
    //   82: invokevirtual 99	java/io/File:mkdirs	()Z
    //   85: pop
    //   86: aload_0
    //   87: invokevirtual 102	java/io/File:createNewFile	()Z
    //   90: pop
    //   91: new 104	java/io/FileOutputStream
    //   94: dup
    //   95: aload_0
    //   96: iconst_0
    //   97: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   100: astore_0
    //   101: aload_0
    //   102: aload_1
    //   103: invokevirtual 111	java/lang/String:getBytes	()[B
    //   106: invokevirtual 115	java/io/FileOutputStream:write	([B)V
    //   109: goto +16 -> 125
    //   112: astore_1
    //   113: aload_0
    //   114: astore_2
    //   115: aload_1
    //   116: astore_0
    //   117: goto +18 -> 135
    //   120: goto +25 -> 145
    //   123: aconst_null
    //   124: astore_0
    //   125: aload_0
    //   126: ifnull +27 -> 153
    //   129: aload_0
    //   130: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: astore_0
    //   135: aload_2
    //   136: ifnull +7 -> 143
    //   139: aload_2
    //   140: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   143: aload_0
    //   144: athrow
    //   145: aload_0
    //   146: ifnull +7 -> 153
    //   149: aload_0
    //   150: invokevirtual 118	java/io/FileOutputStream:close	()V
    //   153: return
    //   154: astore_0
    //   155: aload_3
    //   156: astore_0
    //   157: goto -12 -> 145
    //   160: astore_1
    //   161: goto -41 -> 120
    //   164: astore_0
    //   165: return
    //   166: astore_1
    //   167: goto -24 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString1	String
    //   0	170	1	paramString2	String
    //   10	130	2	str	String
    //   8	148	3	localObject	Object
    //   29	31	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   101	109	112	finally
    //   11	91	134	finally
    //   91	101	134	finally
    //   11	91	154	java/lang/Throwable
    //   91	101	154	java/lang/Throwable
    //   101	109	160	java/lang/Throwable
    //   129	133	164	java/io/IOException
    //   149	153	164	java/io/IOException
    //   139	143	166	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.common.util.TmsLog
 * JD-Core Version:    0.7.0.1
 */