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
    println(6, paramString1, paramString2 + paramThrowable.getMessage());
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
    Log.println(paramInt, "TMSDK_" + paramString1, str);
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
    //   0: getstatic 10	com/tmsdk/common/util/TmsLog:sIsLoggable	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: aconst_null
    //   8: astore_2
    //   9: ldc 60
    //   11: invokestatic 65	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   14: invokevirtual 71	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   17: ifeq +127 -> 144
    //   20: new 73	java/io/File
    //   23: dup
    //   24: new 24	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   31: invokestatic 77	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   34: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   37: ldc 82
    //   39: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: aload_0
    //   43: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 85	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore_0
    //   53: aload_0
    //   54: invokevirtual 89	java/io/File:exists	()Z
    //   57: ifne +19 -> 76
    //   60: aload_0
    //   61: invokevirtual 92	java/io/File:getAbsoluteFile	()Ljava/io/File;
    //   64: invokevirtual 95	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 98	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload_0
    //   72: invokevirtual 101	java/io/File:createNewFile	()Z
    //   75: pop
    //   76: new 103	java/io/FileOutputStream
    //   79: dup
    //   80: aload_0
    //   81: iconst_0
    //   82: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   85: astore_0
    //   86: aload_0
    //   87: aload_1
    //   88: invokevirtual 110	java/lang/String:getBytes	()[B
    //   91: invokevirtual 114	java/io/FileOutputStream:write	([B)V
    //   94: aload_0
    //   95: ifnull -89 -> 6
    //   98: aload_0
    //   99: invokevirtual 117	java/io/FileOutputStream:close	()V
    //   102: return
    //   103: astore_0
    //   104: return
    //   105: astore_0
    //   106: aload_2
    //   107: astore_0
    //   108: aload_0
    //   109: ifnull -103 -> 6
    //   112: aload_0
    //   113: invokevirtual 117	java/io/FileOutputStream:close	()V
    //   116: return
    //   117: astore_0
    //   118: return
    //   119: astore_1
    //   120: aconst_null
    //   121: astore_0
    //   122: aload_0
    //   123: ifnull +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 117	java/io/FileOutputStream:close	()V
    //   130: aload_1
    //   131: athrow
    //   132: astore_0
    //   133: goto -3 -> 130
    //   136: astore_1
    //   137: goto -15 -> 122
    //   140: astore_1
    //   141: goto -33 -> 108
    //   144: aconst_null
    //   145: astore_0
    //   146: goto -52 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramString1	String
    //   0	149	1	paramString2	String
    //   8	99	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   98	102	103	java/io/IOException
    //   9	76	105	java/lang/Throwable
    //   76	86	105	java/lang/Throwable
    //   112	116	117	java/io/IOException
    //   9	76	119	finally
    //   76	86	119	finally
    //   126	130	132	java/io/IOException
    //   86	94	136	finally
    //   86	94	140	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tmsdk.common.util.TmsLog
 * JD-Core Version:    0.7.0.1
 */