package com.tencent.halley.common;

import android.util.Log;
import java.io.FileWriter;

public class b
{
  private static volatile boolean a = true;
  private static volatile boolean b = false;
  private static FileWriter c = null;
  
  public static void a(String paramString1, String paramString2)
  {
    if (a) {
      Log.d(paramString1, paramString2);
    }
    if (b) {
      a("D", paramString1, paramString2, null);
    }
  }
  
  /* Error */
  private static void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    // Byte code:
    //   0: invokestatic 42	com/tencent/halley/common/f:a	()Landroid/content/Context;
    //   3: ifnonnull +4 -> 7
    //   6: return
    //   7: new 44	java/lang/StringBuilder
    //   10: dup
    //   11: new 44	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   18: aload_0
    //   19: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc 51
    //   24: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   33: astore 5
    //   35: aload 5
    //   37: new 44	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   44: new 60	java/text/SimpleDateFormat
    //   47: dup
    //   48: ldc 62
    //   50: getstatic 68	java/util/Locale:US	Ljava/util/Locale;
    //   53: invokespecial 71	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   56: new 73	java/util/Date
    //   59: dup
    //   60: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   63: invokespecial 82	java/util/Date:<init>	(J)V
    //   66: invokevirtual 86	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   69: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc 51
    //   74: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 5
    //   86: new 44	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   93: aload_1
    //   94: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 51
    //   99: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   105: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: ifnull +30 -> 140
    //   113: aload 5
    //   115: new 44	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 88
    //   121: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload_2
    //   125: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 51
    //   130: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_3
    //   141: ifnull +28 -> 169
    //   144: aload 5
    //   146: new 44	java/lang/StringBuilder
    //   149: dup
    //   150: ldc 90
    //   152: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   155: aload_3
    //   156: invokestatic 94	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload 5
    //   171: ldc 96
    //   173: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 2
    //   179: monitorenter
    //   180: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   183: astore_0
    //   184: aload_0
    //   185: ifnull +20 -> 205
    //   188: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   191: aload 5
    //   193: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 101	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   199: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   202: invokevirtual 104	java/io/FileWriter:flush	()V
    //   205: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   208: ifnonnull +200 -> 408
    //   211: new 60	java/text/SimpleDateFormat
    //   214: dup
    //   215: ldc 106
    //   217: getstatic 68	java/util/Locale:US	Ljava/util/Locale;
    //   220: invokespecial 71	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   223: new 73	java/util/Date
    //   226: dup
    //   227: invokestatic 79	java/lang/System:currentTimeMillis	()J
    //   230: invokespecial 82	java/util/Date:<init>	(J)V
    //   233: invokevirtual 86	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   236: astore_0
    //   237: new 44	java/lang/StringBuilder
    //   240: dup
    //   241: ldc 108
    //   243: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   246: aload_0
    //   247: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: astore_1
    //   254: invokestatic 113	com/tencent/halley/common/h:a	()Z
    //   257: ifeq +256 -> 513
    //   260: new 44	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   267: astore_2
    //   268: invokestatic 113	com/tencent/halley/common/h:a	()Z
    //   271: ifeq +253 -> 524
    //   274: invokestatic 116	com/tencent/halley/common/h:e	()Ljava/lang/String;
    //   277: astore_0
    //   278: new 44	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   285: invokestatic 122	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   288: invokevirtual 127	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   291: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 129
    //   296: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: aload_0
    //   300: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: astore_0
    //   307: aload_2
    //   308: aload_0
    //   309: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 131
    //   314: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: astore_0
    //   321: new 124	java/io/File
    //   324: dup
    //   325: aload_0
    //   326: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   329: astore_2
    //   330: aload_2
    //   331: invokevirtual 135	java/io/File:exists	()Z
    //   334: ifne +8 -> 342
    //   337: aload_2
    //   338: invokevirtual 138	java/io/File:mkdirs	()Z
    //   341: pop
    //   342: new 124	java/io/File
    //   345: dup
    //   346: aload_0
    //   347: aload_1
    //   348: invokespecial 140	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: astore_0
    //   352: aload_0
    //   353: invokevirtual 143	java/io/File:isDirectory	()Z
    //   356: ifeq +8 -> 364
    //   359: aload_0
    //   360: invokevirtual 146	java/io/File:delete	()Z
    //   363: pop
    //   364: aload_0
    //   365: invokevirtual 135	java/io/File:exists	()Z
    //   368: istore 4
    //   370: iload 4
    //   372: ifne +8 -> 380
    //   375: aload_0
    //   376: invokevirtual 149	java/io/File:createNewFile	()Z
    //   379: pop
    //   380: new 98	java/io/FileWriter
    //   383: dup
    //   384: aload_0
    //   385: invokespecial 152	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   388: astore_0
    //   389: aload_0
    //   390: putstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   393: aload_0
    //   394: aload 5
    //   396: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokevirtual 101	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   402: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   405: invokevirtual 104	java/io/FileWriter:flush	()V
    //   408: ldc 2
    //   410: monitorexit
    //   411: return
    //   412: astore_0
    //   413: ldc 2
    //   415: monitorexit
    //   416: aload_0
    //   417: athrow
    //   418: astore_0
    //   419: aload_0
    //   420: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   423: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   426: invokevirtual 158	java/io/FileWriter:close	()V
    //   429: aconst_null
    //   430: putstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   433: goto -228 -> 205
    //   436: astore_0
    //   437: aload_0
    //   438: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   441: goto -12 -> 429
    //   444: astore_0
    //   445: aload_0
    //   446: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   449: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   452: astore_0
    //   453: aload_0
    //   454: ifnull +13 -> 467
    //   457: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   460: invokevirtual 158	java/io/FileWriter:close	()V
    //   463: aconst_null
    //   464: putstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   467: ldc 2
    //   469: monitorexit
    //   470: return
    //   471: astore_0
    //   472: aload_0
    //   473: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   476: goto -13 -> 463
    //   479: astore_0
    //   480: aload_0
    //   481: invokevirtual 155	java/io/IOException:printStackTrace	()V
    //   484: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   487: astore_0
    //   488: aload_0
    //   489: ifnull -81 -> 408
    //   492: getstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   495: invokevirtual 158	java/io/FileWriter:close	()V
    //   498: aconst_null
    //   499: putstatic 17	com/tencent/halley/common/b:c	Ljava/io/FileWriter;
    //   502: goto -94 -> 408
    //   505: astore_0
    //   506: aload_0
    //   507: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   510: goto -12 -> 498
    //   513: ldc 161
    //   515: ldc 163
    //   517: invokestatic 166	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   520: pop
    //   521: goto -113 -> 408
    //   524: ldc 168
    //   526: astore_0
    //   527: goto -220 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramString1	String
    //   0	530	1	paramString2	String
    //   0	530	2	paramString3	String
    //   0	530	3	paramThrowable	Throwable
    //   368	3	4	bool	boolean
    //   33	362	5	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   180	184	412	finally
    //   188	205	412	finally
    //   205	307	412	finally
    //   307	342	412	finally
    //   342	364	412	finally
    //   364	370	412	finally
    //   375	380	412	finally
    //   380	408	412	finally
    //   408	411	412	finally
    //   419	423	412	finally
    //   423	429	412	finally
    //   429	433	412	finally
    //   437	441	412	finally
    //   445	453	412	finally
    //   457	463	412	finally
    //   463	467	412	finally
    //   467	470	412	finally
    //   472	476	412	finally
    //   480	488	412	finally
    //   492	498	412	finally
    //   498	502	412	finally
    //   506	510	412	finally
    //   513	521	412	finally
    //   188	205	418	java/io/IOException
    //   423	429	436	java/io/IOException
    //   375	380	444	java/io/IOException
    //   457	463	471	java/lang/Exception
    //   380	408	479	java/io/IOException
    //   492	498	505	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.w(paramString1, paramString2, paramThrowable);
    }
    if (b) {
      a("W", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a) {
      Log.w(paramString, paramThrowable);
    }
    if (b) {
      a("W", paramString, null, paramThrowable);
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    if (a) {
      Log.i(paramString1, paramString2);
    }
    if (b) {
      a("I", paramString1, paramString2, null);
    }
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a) {
      Log.e(paramString1, paramString2, paramThrowable);
    }
    if (b) {
      a("E", paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if (a) {
      Log.w(paramString1, paramString2);
    }
    if (b) {
      a("W", paramString1, paramString2, null);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (a) {
      Log.e(paramString1, paramString2);
    }
    if (b) {
      a("E", paramString1, paramString2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.b
 * JD-Core Version:    0.7.0.1
 */