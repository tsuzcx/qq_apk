package com.google.android.exoplayer2.ext.mediaplayer;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

public class ExoMediaPlayerUtils
{
  public static String getLogcatContent()
  {
    return getLogcatContent(0, null, 10);
  }
  
  /* Error */
  public static String getLogcatContent(int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 24	java/lang/System:currentTimeMillis	()J
    //   3: lstore 5
    //   5: iload_2
    //   6: sipush 1000
    //   9: imul
    //   10: i2l
    //   11: lstore 7
    //   13: invokestatic 30	java/util/Calendar:getInstance	()Ljava/util/Calendar;
    //   16: iconst_1
    //   17: invokevirtual 34	java/util/Calendar:get	(I)I
    //   20: istore 4
    //   22: new 36	java/text/SimpleDateFormat
    //   25: dup
    //   26: ldc 38
    //   28: invokestatic 44	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   31: invokespecial 47	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   34: astore 14
    //   36: aload_1
    //   37: ifnonnull +202 -> 239
    //   40: iconst_4
    //   41: anewarray 49	java/lang/String
    //   44: astore_1
    //   45: aload_1
    //   46: iconst_0
    //   47: ldc 51
    //   49: aastore
    //   50: aload_1
    //   51: iconst_1
    //   52: ldc 53
    //   54: aastore
    //   55: aload_1
    //   56: iconst_2
    //   57: ldc 55
    //   59: aastore
    //   60: aload_1
    //   61: iconst_3
    //   62: ldc 57
    //   64: aastore
    //   65: aconst_null
    //   66: astore 12
    //   68: new 59	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   75: astore 13
    //   77: invokestatic 66	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   80: aload_1
    //   81: invokevirtual 70	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   84: astore_1
    //   85: new 72	java/io/BufferedReader
    //   88: dup
    //   89: new 74	java/io/InputStreamReader
    //   92: dup
    //   93: aload_1
    //   94: invokevirtual 80	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   97: invokespecial 83	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   100: invokespecial 86	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   103: astore 11
    //   105: iconst_0
    //   106: istore_2
    //   107: aload 11
    //   109: invokevirtual 89	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   112: astore 12
    //   114: aload 12
    //   116: ifnull +72 -> 188
    //   119: aload 12
    //   121: ldc 91
    //   123: invokevirtual 95	java/lang/String:matches	(Ljava/lang/String;)Z
    //   126: ifeq -19 -> 107
    //   129: aload 12
    //   131: iconst_0
    //   132: bipush 18
    //   134: invokevirtual 99	java/lang/String:substring	(II)Ljava/lang/String;
    //   137: astore 15
    //   139: aload 14
    //   141: new 59	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   148: iload 4
    //   150: invokevirtual 103	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: ldc 105
    //   155: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload 15
    //   160: iconst_0
    //   161: bipush 18
    //   163: invokevirtual 99	java/lang/String:substring	(II)Ljava/lang/String;
    //   166: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokevirtual 115	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   175: invokevirtual 120	java/util/Date:getTime	()J
    //   178: lstore 9
    //   180: lload 9
    //   182: lload 5
    //   184: lcmp
    //   185: ifle +102 -> 287
    //   188: aload 13
    //   190: ldc 122
    //   192: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 13
    //   198: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore 11
    //   203: aload 11
    //   205: astore 12
    //   207: aload_1
    //   208: ifnull +28 -> 236
    //   211: aload_1
    //   212: invokevirtual 126	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   215: invokevirtual 131	java/io/OutputStream:close	()V
    //   218: aload_1
    //   219: invokevirtual 80	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   222: invokevirtual 134	java/io/InputStream:close	()V
    //   225: aload_1
    //   226: invokevirtual 137	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   229: invokevirtual 134	java/io/InputStream:close	()V
    //   232: aload 11
    //   234: astore 12
    //   236: aload 12
    //   238: areturn
    //   239: bipush 6
    //   241: anewarray 49	java/lang/String
    //   244: astore 11
    //   246: aload 11
    //   248: iconst_0
    //   249: ldc 51
    //   251: aastore
    //   252: aload 11
    //   254: iconst_1
    //   255: ldc 53
    //   257: aastore
    //   258: aload 11
    //   260: iconst_2
    //   261: ldc 55
    //   263: aastore
    //   264: aload 11
    //   266: iconst_3
    //   267: ldc 57
    //   269: aastore
    //   270: aload 11
    //   272: iconst_4
    //   273: ldc 139
    //   275: aastore
    //   276: aload 11
    //   278: iconst_5
    //   279: aload_1
    //   280: aastore
    //   281: aload 11
    //   283: astore_1
    //   284: goto -219 -> 65
    //   287: iload_2
    //   288: istore_3
    //   289: lload 9
    //   291: lload 5
    //   293: lload 7
    //   295: lsub
    //   296: lcmp
    //   297: ifle +32 -> 329
    //   300: iload_2
    //   301: istore_3
    //   302: iload_2
    //   303: ifne +13 -> 316
    //   306: aload 13
    //   308: ldc 141
    //   310: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: iconst_1
    //   315: istore_3
    //   316: aload 13
    //   318: aload 12
    //   320: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: ldc 143
    //   325: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: iload_3
    //   330: istore_2
    //   331: iload_0
    //   332: ifle -225 -> 107
    //   335: iload_3
    //   336: istore_2
    //   337: aload 13
    //   339: invokevirtual 147	java/lang/StringBuilder:length	()I
    //   342: iload_0
    //   343: if_icmple -236 -> 107
    //   346: aload 13
    //   348: iconst_0
    //   349: aload 13
    //   351: invokevirtual 147	java/lang/StringBuilder:length	()I
    //   354: iload_0
    //   355: isub
    //   356: invokevirtual 151	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: iload_3
    //   361: istore_2
    //   362: goto -255 -> 107
    //   365: astore 11
    //   367: aload 13
    //   369: new 59	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 60	java/lang/StringBuilder:<init>	()V
    //   376: ldc 153
    //   378: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: aload 11
    //   383: invokevirtual 154	java/lang/Throwable:toString	()Ljava/lang/String;
    //   386: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: ldc 156
    //   391: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: astore 11
    //   405: aload 11
    //   407: astore 12
    //   409: aload_1
    //   410: ifnull -174 -> 236
    //   413: aload_1
    //   414: invokevirtual 126	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   417: invokevirtual 131	java/io/OutputStream:close	()V
    //   420: aload_1
    //   421: invokevirtual 80	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   424: invokevirtual 134	java/io/InputStream:close	()V
    //   427: aload_1
    //   428: invokevirtual 137	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   431: invokevirtual 134	java/io/InputStream:close	()V
    //   434: aload 11
    //   436: areturn
    //   437: astore_1
    //   438: aload_1
    //   439: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   442: aload 11
    //   444: areturn
    //   445: astore 12
    //   447: aload 12
    //   449: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   452: goto -234 -> 218
    //   455: astore 12
    //   457: aload 12
    //   459: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   462: goto -237 -> 225
    //   465: astore_1
    //   466: aload_1
    //   467: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   470: aload 11
    //   472: areturn
    //   473: astore 12
    //   475: aload 12
    //   477: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   480: goto -60 -> 420
    //   483: astore 12
    //   485: aload 12
    //   487: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   490: goto -63 -> 427
    //   493: astore 11
    //   495: aconst_null
    //   496: astore_1
    //   497: aload_1
    //   498: ifnull +24 -> 522
    //   501: aload_1
    //   502: invokevirtual 126	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   505: invokevirtual 131	java/io/OutputStream:close	()V
    //   508: aload_1
    //   509: invokevirtual 80	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   512: invokevirtual 134	java/io/InputStream:close	()V
    //   515: aload_1
    //   516: invokevirtual 137	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   519: invokevirtual 134	java/io/InputStream:close	()V
    //   522: aload 11
    //   524: athrow
    //   525: astore 12
    //   527: aload 12
    //   529: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   532: goto -24 -> 508
    //   535: astore 12
    //   537: aload 12
    //   539: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   542: goto -27 -> 515
    //   545: astore_1
    //   546: aload_1
    //   547: invokevirtual 159	java/io/IOException:printStackTrace	()V
    //   550: goto -28 -> 522
    //   553: astore 11
    //   555: goto -58 -> 497
    //   558: astore 11
    //   560: goto -63 -> 497
    //   563: astore 11
    //   565: aload 12
    //   567: astore_1
    //   568: goto -201 -> 367
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	571	0	paramInt1	int
    //   0	571	1	paramString	String
    //   0	571	2	paramInt2	int
    //   288	73	3	i	int
    //   20	129	4	j	int
    //   3	289	5	l1	long
    //   11	283	7	l2	long
    //   178	112	9	l3	long
    //   103	179	11	localObject1	Object
    //   365	17	11	localThrowable1	Throwable
    //   403	68	11	str1	String
    //   493	30	11	localObject2	Object
    //   553	1	11	localObject3	Object
    //   558	1	11	localObject4	Object
    //   563	1	11	localThrowable2	Throwable
    //   66	342	12	localObject5	Object
    //   445	3	12	localIOException1	java.io.IOException
    //   455	3	12	localIOException2	java.io.IOException
    //   473	3	12	localIOException3	java.io.IOException
    //   483	3	12	localIOException4	java.io.IOException
    //   525	3	12	localIOException5	java.io.IOException
    //   535	31	12	localIOException6	java.io.IOException
    //   75	293	13	localStringBuilder	StringBuilder
    //   34	106	14	localSimpleDateFormat	java.text.SimpleDateFormat
    //   137	22	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   85	105	365	java/lang/Throwable
    //   107	114	365	java/lang/Throwable
    //   119	180	365	java/lang/Throwable
    //   188	203	365	java/lang/Throwable
    //   306	314	365	java/lang/Throwable
    //   316	329	365	java/lang/Throwable
    //   337	360	365	java/lang/Throwable
    //   427	434	437	java/io/IOException
    //   211	218	445	java/io/IOException
    //   218	225	455	java/io/IOException
    //   225	232	465	java/io/IOException
    //   413	420	473	java/io/IOException
    //   420	427	483	java/io/IOException
    //   77	85	493	finally
    //   501	508	525	java/io/IOException
    //   508	515	535	java/io/IOException
    //   515	522	545	java/io/IOException
    //   85	105	553	finally
    //   107	114	553	finally
    //   119	180	553	finally
    //   188	203	553	finally
    //   306	314	553	finally
    //   316	329	553	finally
    //   337	360	553	finally
    //   367	405	558	finally
    //   77	85	563	java/lang/Throwable
  }
  
  public static String getPrintableStackTrace(Throwable paramThrowable)
  {
    return getPrintableStackTrace(paramThrowable, false);
  }
  
  private static String getPrintableStackTrace(Throwable paramThrowable, boolean paramBoolean)
  {
    if (paramThrowable == null) {
      return "";
    }
    Object localObject1 = Thread.currentThread();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!paramBoolean)
    {
      localStringBuilder.append("Exception in thread \"");
      localStringBuilder.append(((Thread)localObject1).getName());
      localStringBuilder.append("\"");
      localStringBuilder.append(paramThrowable.toString());
    }
    localObject1 = paramThrowable.getStackTrace();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = localObject1[i];
      localStringBuilder.append("\tat ");
      localStringBuilder.append(localObject2);
      localStringBuilder.append("\n");
      i += 1;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {}
    for (paramThrowable = ((InvocationTargetException)paramThrowable).getTargetException();; paramThrowable = paramThrowable.getCause())
    {
      if (paramThrowable != null)
      {
        localStringBuilder.append("caused by: ");
        localStringBuilder.append(paramThrowable.toString());
        localStringBuilder.append("\n");
        localStringBuilder.append(getPrintableStackTrace(paramThrowable, true));
      }
      return localStringBuilder.toString();
    }
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public static String join(Iterator<String> paramIterator, String paramString)
  {
    Object localObject1 = "";
    Object localObject2 = localObject1;
    if (paramIterator != null) {
      for (;;)
      {
        localObject2 = localObject1;
        if (!paramIterator.hasNext()) {
          break;
        }
        localObject2 = (String)localObject1 + (String)paramIterator.next();
        localObject1 = localObject2;
        if (paramIterator.hasNext()) {
          localObject1 = (String)localObject2 + paramString;
        }
      }
    }
    return localObject2;
  }
  
  public static String join(List<String> paramList)
  {
    return join(paramList, "|");
  }
  
  public static String join(List<String> paramList, String paramString)
  {
    if (paramList != null) {
      return join(paramList.iterator(), paramString);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.ext.mediaplayer.ExoMediaPlayerUtils
 * JD-Core Version:    0.7.0.1
 */