package com.tencent.mobileqq.highway.netprobe;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingProbe
  extends ProbeItem
{
  public static final int DEFAULT_PING_COUNT = 3;
  public static final int DEFAULT_PING_TIMEOUT = 10;
  private static final String PING_RESULT_REGEX = "(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*";
  public static String PROBE_NAME = "Ping_Probe";
  public static final int RESULT_CONN_BLOCKING = 2;
  public static final int RESULT_EXCEPTION = 1;
  
  /* Error */
  public static String execPing(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_3
    //   4: invokestatic 40	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifeq +10 -> 17
    //   10: aload 8
    //   12: astore 5
    //   14: aload 5
    //   16: areturn
    //   17: iload_0
    //   18: ifle +274 -> 292
    //   21: new 42	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   28: ldc 45
    //   30: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: ldc 51
    //   35: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_0
    //   39: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: astore 5
    //   47: aload 5
    //   49: astore 4
    //   51: iload_1
    //   52: ifle +29 -> 81
    //   55: new 42	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   62: aload 5
    //   64: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 60
    //   69: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload_1
    //   73: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore 4
    //   81: aload 4
    //   83: astore 5
    //   85: iload_2
    //   86: ifle +29 -> 115
    //   89: new 42	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   96: aload 4
    //   98: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 62
    //   103: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: iload_2
    //   107: invokevirtual 54	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore 5
    //   115: new 42	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   122: aload 5
    //   124: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 64
    //   129: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: astore_3
    //   140: aconst_null
    //   141: astore 7
    //   143: aconst_null
    //   144: astore 9
    //   146: aconst_null
    //   147: astore 6
    //   149: aconst_null
    //   150: astore 4
    //   152: aload 7
    //   154: astore 5
    //   156: invokestatic 70	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   159: aload_3
    //   160: invokevirtual 74	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   163: astore_3
    //   164: aload_3
    //   165: astore 4
    //   167: aload 7
    //   169: astore 5
    //   171: aload_3
    //   172: astore 6
    //   174: aload_3
    //   175: invokevirtual 80	java/lang/Process:waitFor	()I
    //   178: istore_0
    //   179: aload_3
    //   180: astore 4
    //   182: aload 7
    //   184: astore 5
    //   186: aload_3
    //   187: astore 6
    //   189: new 82	java/io/BufferedReader
    //   192: dup
    //   193: new 84	java/io/InputStreamReader
    //   196: dup
    //   197: aload_3
    //   198: invokevirtual 88	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   201: invokespecial 91	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   204: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   207: astore 7
    //   209: new 42	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   216: astore 4
    //   218: aload 7
    //   220: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   223: astore 5
    //   225: aload 5
    //   227: ifnull +90 -> 317
    //   230: aload 4
    //   232: aload 5
    //   234: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 99
    //   239: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: goto -25 -> 218
    //   246: astore 4
    //   248: aload 7
    //   250: astore 6
    //   252: aload 4
    //   254: astore 7
    //   256: aload_3
    //   257: astore 4
    //   259: aload 6
    //   261: astore 5
    //   263: aload 7
    //   265: invokevirtual 102	java/lang/Throwable:printStackTrace	()V
    //   268: aload 6
    //   270: ifnull +8 -> 278
    //   273: aload 6
    //   275: invokevirtual 105	java/io/BufferedReader:close	()V
    //   278: aload 8
    //   280: astore 5
    //   282: aload_3
    //   283: ifnull -269 -> 14
    //   286: aload_3
    //   287: invokevirtual 108	java/lang/Process:destroy	()V
    //   290: aconst_null
    //   291: areturn
    //   292: new 42	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   299: ldc 45
    //   301: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: ldc 110
    //   306: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: astore 5
    //   314: goto -267 -> 47
    //   317: aload 4
    //   319: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: astore 4
    //   324: iload_0
    //   325: ifeq +14 -> 339
    //   328: aload 4
    //   330: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   333: invokevirtual 118	java/lang/String:length	()I
    //   336: ifeq +35 -> 371
    //   339: aload 4
    //   341: invokevirtual 115	java/lang/String:trim	()Ljava/lang/String;
    //   344: astore 4
    //   346: aload 7
    //   348: ifnull +8 -> 356
    //   351: aload 7
    //   353: invokevirtual 105	java/io/BufferedReader:close	()V
    //   356: aload 4
    //   358: astore 5
    //   360: aload_3
    //   361: ifnull -347 -> 14
    //   364: aload_3
    //   365: invokevirtual 108	java/lang/Process:destroy	()V
    //   368: aload 4
    //   370: areturn
    //   371: aload 7
    //   373: ifnull +8 -> 381
    //   376: aload 7
    //   378: invokevirtual 105	java/io/BufferedReader:close	()V
    //   381: aload_3
    //   382: ifnull +76 -> 458
    //   385: aload_3
    //   386: invokevirtual 108	java/lang/Process:destroy	()V
    //   389: aconst_null
    //   390: areturn
    //   391: astore 6
    //   393: aload 4
    //   395: astore_3
    //   396: aload 5
    //   398: ifnull +8 -> 406
    //   401: aload 5
    //   403: invokevirtual 105	java/io/BufferedReader:close	()V
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 108	java/lang/Process:destroy	()V
    //   414: aload 6
    //   416: athrow
    //   417: astore 5
    //   419: goto -63 -> 356
    //   422: astore 4
    //   424: goto -43 -> 381
    //   427: astore 4
    //   429: goto -151 -> 278
    //   432: astore 4
    //   434: goto -28 -> 406
    //   437: astore 6
    //   439: aload 7
    //   441: astore 5
    //   443: goto -47 -> 396
    //   446: astore 7
    //   448: aload 6
    //   450: astore_3
    //   451: aload 9
    //   453: astore 6
    //   455: goto -199 -> 256
    //   458: aconst_null
    //   459: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	paramInt1	int
    //   0	460	1	paramInt2	int
    //   0	460	2	paramInt3	int
    //   0	460	3	paramString	String
    //   49	182	4	localObject1	Object
    //   246	7	4	localThrowable1	java.lang.Throwable
    //   257	137	4	str	String
    //   422	1	4	localException1	java.lang.Exception
    //   427	1	4	localException2	java.lang.Exception
    //   432	1	4	localException3	java.lang.Exception
    //   12	390	5	localObject2	Object
    //   417	1	5	localException4	java.lang.Exception
    //   441	1	5	localObject3	Object
    //   147	127	6	localObject4	Object
    //   391	24	6	localObject5	Object
    //   437	12	6	localObject6	Object
    //   453	1	6	localObject7	Object
    //   141	299	7	localObject8	Object
    //   446	1	7	localThrowable2	java.lang.Throwable
    //   1	278	8	localObject9	Object
    //   144	308	9	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   209	218	246	java/lang/Throwable
    //   218	225	246	java/lang/Throwable
    //   230	243	246	java/lang/Throwable
    //   317	324	246	java/lang/Throwable
    //   328	339	246	java/lang/Throwable
    //   339	346	246	java/lang/Throwable
    //   156	164	391	finally
    //   174	179	391	finally
    //   189	209	391	finally
    //   263	268	391	finally
    //   351	356	417	java/lang/Exception
    //   376	381	422	java/lang/Exception
    //   273	278	427	java/lang/Exception
    //   401	406	432	java/lang/Exception
    //   209	218	437	finally
    //   218	225	437	finally
    //   230	243	437	finally
    //   317	324	437	finally
    //   328	339	437	finally
    //   339	346	437	finally
    //   156	164	446	java/lang/Throwable
    //   174	179	446	java/lang/Throwable
    //   189	209	446	java/lang/Throwable
  }
  
  public static String execPing(int paramInt1, int paramInt2, String paramString)
  {
    return execPing(paramInt1, paramInt2, -1, paramString);
  }
  
  public static String execPing(int paramInt, String paramString)
  {
    return execPing(3, paramInt, paramString);
  }
  
  public static String execPing(String paramString)
  {
    return execPing(3, 10, paramString);
  }
  
  public void doProbe()
  {
    Object localObject = execPing(this.mRequest.getIp());
    if ((localObject == null) || (TextUtils.isEmpty((CharSequence)localObject)))
    {
      this.mResult.success = false;
      this.mResult.errCode = 1;
      this.mResult.errDesc = "ping progress has exception!";
    }
    do
    {
      return;
      localObject = Pattern.compile("(\\d+) packets transmitted, (\\d+)[\\s\\S]* received, (\\d+).*").matcher((CharSequence)localObject);
    } while ((!((Matcher)localObject).find()) || (((Matcher)localObject).groupCount() != 3));
    this.mResult.extra = ((Matcher)localObject).group();
    try
    {
      if (Integer.valueOf(((Matcher)localObject).group(2)).intValue() > 0)
      {
        this.mResult.success = true;
        this.mResult.appendResult(((Matcher)localObject).group());
        return;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      this.mResult.success = false;
      this.mResult.errCode = 1;
      this.mResult.errDesc = localNumberFormatException.toString();
      return;
    }
    this.mResult.success = false;
    this.mResult.errCode = 2;
    this.mResult.errDesc = localNumberFormatException.group();
  }
  
  public String getProbeName()
  {
    return PROBE_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.PingProbe
 * JD-Core Version:    0.7.0.1
 */