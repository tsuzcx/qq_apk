package com.tencent.mobileqq.utils.traceroute;

import android.content.Context;
import java.io.File;
import java.io.IOException;

public class TracerouteInstaller
{
  private static String a = "TraceRoute";
  
  /* Error */
  public static boolean a(Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 29	android/content/Context:getFilesDir	()Ljava/io/File;
    //   18: invokevirtual 35	java/io/File:getPath	()Ljava/lang/String;
    //   21: astore 9
    //   23: aload_0
    //   24: invokevirtual 39	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   27: ldc 41
    //   29: invokevirtual 47	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   32: astore_0
    //   33: aload_0
    //   34: invokevirtual 53	java/io/InputStream:available	()I
    //   37: istore_1
    //   38: iload_1
    //   39: newarray byte
    //   41: astore 10
    //   43: aload_0
    //   44: aload 10
    //   46: invokevirtual 57	java/io/InputStream:read	([B)I
    //   49: pop
    //   50: new 59	java/io/FileOutputStream
    //   53: dup
    //   54: new 31	java/io/File
    //   57: dup
    //   58: new 61	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   65: aload 9
    //   67: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 68
    //   72: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   81: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: astore_3
    //   85: aload 4
    //   87: astore 5
    //   89: aload_3
    //   90: astore 7
    //   92: aload_0
    //   93: astore 6
    //   95: aload_3
    //   96: aload 10
    //   98: iconst_0
    //   99: iload_1
    //   100: invokevirtual 81	java/io/FileOutputStream:write	([BII)V
    //   103: aload 4
    //   105: astore 5
    //   107: aload_3
    //   108: astore 7
    //   110: aload_0
    //   111: astore 6
    //   113: aload_0
    //   114: invokevirtual 84	java/io/InputStream:close	()V
    //   117: aload 4
    //   119: astore 5
    //   121: aload_3
    //   122: astore 7
    //   124: aload_0
    //   125: astore 6
    //   127: aload_3
    //   128: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   131: aload 4
    //   133: astore 5
    //   135: aload_3
    //   136: astore 7
    //   138: aload_0
    //   139: astore 6
    //   141: invokestatic 91	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   144: new 61	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   151: ldc 93
    //   153: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 9
    //   158: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: ldc 68
    //   163: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokevirtual 97	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   172: astore 4
    //   174: aload 4
    //   176: astore 5
    //   178: aload 5
    //   180: invokevirtual 102	java/lang/Process:waitFor	()I
    //   183: pop
    //   184: aload 5
    //   186: invokevirtual 105	java/lang/Process:destroy	()V
    //   189: iconst_1
    //   190: istore_2
    //   191: aload_0
    //   192: ifnull +7 -> 199
    //   195: aload_0
    //   196: invokevirtual 84	java/io/InputStream:close	()V
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   207: iconst_0
    //   208: ifeq +11 -> 219
    //   211: new 107	java/lang/NullPointerException
    //   214: dup
    //   215: invokespecial 108	java/lang/NullPointerException:<init>	()V
    //   218: athrow
    //   219: iload_2
    //   220: ireturn
    //   221: astore 4
    //   223: aconst_null
    //   224: astore_0
    //   225: aconst_null
    //   226: astore_3
    //   227: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   230: ifeq +33 -> 263
    //   233: getstatic 12	com/tencent/mobileqq/utils/traceroute/TracerouteInstaller:a	Ljava/lang/String;
    //   236: iconst_2
    //   237: new 61	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   244: ldc 116
    //   246: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 4
    //   251: invokevirtual 119	java/io/IOException:getMessage	()Ljava/lang/String;
    //   254: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: aload_3
    //   264: ifnull +7 -> 271
    //   267: aload_3
    //   268: invokevirtual 84	java/io/InputStream:close	()V
    //   271: aload 5
    //   273: ifnull +8 -> 281
    //   276: aload 5
    //   278: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   281: aload_0
    //   282: ifnull -63 -> 219
    //   285: aload_0
    //   286: invokevirtual 105	java/lang/Process:destroy	()V
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_0
    //   292: iconst_0
    //   293: ireturn
    //   294: astore 4
    //   296: aconst_null
    //   297: astore_3
    //   298: aconst_null
    //   299: astore_0
    //   300: aload 8
    //   302: astore 5
    //   304: aload_3
    //   305: astore 7
    //   307: aload_0
    //   308: astore 6
    //   310: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +43 -> 356
    //   316: aload 8
    //   318: astore 5
    //   320: aload_3
    //   321: astore 7
    //   323: aload_0
    //   324: astore 6
    //   326: getstatic 12	com/tencent/mobileqq/utils/traceroute/TracerouteInstaller:a	Ljava/lang/String;
    //   329: iconst_2
    //   330: new 61	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   337: ldc 125
    //   339: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload 4
    //   344: invokevirtual 126	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   347: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 123	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   356: aload_0
    //   357: ifnull +7 -> 364
    //   360: aload_0
    //   361: invokevirtual 84	java/io/InputStream:close	()V
    //   364: aload_3
    //   365: ifnull +7 -> 372
    //   368: aload_3
    //   369: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   372: aload 8
    //   374: ifnull -155 -> 219
    //   377: aload 8
    //   379: invokevirtual 105	java/lang/Process:destroy	()V
    //   382: iconst_0
    //   383: ireturn
    //   384: astore_0
    //   385: iconst_0
    //   386: ireturn
    //   387: astore 4
    //   389: aconst_null
    //   390: astore_3
    //   391: aconst_null
    //   392: astore_0
    //   393: aload 6
    //   395: astore 5
    //   397: aload_0
    //   398: ifnull +7 -> 405
    //   401: aload_0
    //   402: invokevirtual 84	java/io/InputStream:close	()V
    //   405: aload_3
    //   406: ifnull +7 -> 413
    //   409: aload_3
    //   410: invokevirtual 85	java/io/FileOutputStream:close	()V
    //   413: aload 5
    //   415: ifnull +8 -> 423
    //   418: aload 5
    //   420: invokevirtual 105	java/lang/Process:destroy	()V
    //   423: aload 4
    //   425: athrow
    //   426: astore_0
    //   427: goto -228 -> 199
    //   430: astore_0
    //   431: goto -224 -> 207
    //   434: astore_0
    //   435: iconst_1
    //   436: ireturn
    //   437: astore_3
    //   438: goto -167 -> 271
    //   441: astore_3
    //   442: goto -161 -> 281
    //   445: astore_0
    //   446: goto -82 -> 364
    //   449: astore_0
    //   450: goto -78 -> 372
    //   453: astore_0
    //   454: goto -49 -> 405
    //   457: astore_0
    //   458: goto -45 -> 413
    //   461: astore_0
    //   462: goto -39 -> 423
    //   465: astore 4
    //   467: aconst_null
    //   468: astore_3
    //   469: aload 6
    //   471: astore 5
    //   473: goto -76 -> 397
    //   476: astore 4
    //   478: aload 7
    //   480: astore_3
    //   481: aload 6
    //   483: astore_0
    //   484: goto -87 -> 397
    //   487: astore 4
    //   489: goto -92 -> 397
    //   492: astore 4
    //   494: aload_3
    //   495: astore 6
    //   497: aload 5
    //   499: astore_3
    //   500: aload_0
    //   501: astore 5
    //   503: aload 6
    //   505: astore_0
    //   506: goto -109 -> 397
    //   509: astore 4
    //   511: aconst_null
    //   512: astore_3
    //   513: goto -213 -> 300
    //   516: astore 4
    //   518: goto -218 -> 300
    //   521: astore 4
    //   523: aload 5
    //   525: astore 8
    //   527: goto -227 -> 300
    //   530: astore 4
    //   532: aconst_null
    //   533: astore 6
    //   535: aload_0
    //   536: astore_3
    //   537: aload 6
    //   539: astore_0
    //   540: goto -313 -> 227
    //   543: astore 4
    //   545: aconst_null
    //   546: astore 5
    //   548: aload_0
    //   549: astore 6
    //   551: aload 5
    //   553: astore_0
    //   554: aload_3
    //   555: astore 5
    //   557: aload 6
    //   559: astore_3
    //   560: goto -333 -> 227
    //   563: astore 4
    //   565: aload_3
    //   566: astore 6
    //   568: aload_0
    //   569: astore_3
    //   570: aload 5
    //   572: astore_0
    //   573: aload 6
    //   575: astore 5
    //   577: goto -350 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	580	0	paramContext	Context
    //   37	63	1	i	int
    //   1	219	2	bool	boolean
    //   84	326	3	localFileOutputStream1	java.io.FileOutputStream
    //   437	1	3	localException1	java.lang.Exception
    //   441	1	3	localException2	java.lang.Exception
    //   468	102	3	localObject1	Object
    //   9	166	4	localProcess	Process
    //   221	29	4	localIOException1	IOException
    //   294	49	4	localInterruptedException1	InterruptedException
    //   387	37	4	localObject2	Object
    //   465	1	4	localObject3	Object
    //   476	1	4	localObject4	Object
    //   487	1	4	localObject5	Object
    //   492	1	4	localObject6	Object
    //   509	1	4	localInterruptedException2	InterruptedException
    //   516	1	4	localInterruptedException3	InterruptedException
    //   521	1	4	localInterruptedException4	InterruptedException
    //   530	1	4	localIOException2	IOException
    //   543	1	4	localIOException3	IOException
    //   563	1	4	localIOException4	IOException
    //   12	564	5	localObject7	Object
    //   6	568	6	localObject8	Object
    //   90	389	7	localFileOutputStream2	java.io.FileOutputStream
    //   3	523	8	localObject9	Object
    //   21	136	9	str	String
    //   41	56	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	33	221	java/io/IOException
    //   285	289	291	java/lang/Exception
    //   23	33	294	java/lang/InterruptedException
    //   377	382	384	java/lang/Exception
    //   23	33	387	finally
    //   195	199	426	java/lang/Exception
    //   203	207	430	java/lang/Exception
    //   211	219	434	java/lang/Exception
    //   267	271	437	java/lang/Exception
    //   276	281	441	java/lang/Exception
    //   360	364	445	java/lang/Exception
    //   368	372	449	java/lang/Exception
    //   401	405	453	java/lang/Exception
    //   409	413	457	java/lang/Exception
    //   418	423	461	java/lang/Exception
    //   33	85	465	finally
    //   95	103	476	finally
    //   113	117	476	finally
    //   127	131	476	finally
    //   141	174	476	finally
    //   310	316	476	finally
    //   326	356	476	finally
    //   178	189	487	finally
    //   227	263	492	finally
    //   33	85	509	java/lang/InterruptedException
    //   95	103	516	java/lang/InterruptedException
    //   113	117	516	java/lang/InterruptedException
    //   127	131	516	java/lang/InterruptedException
    //   141	174	516	java/lang/InterruptedException
    //   178	189	521	java/lang/InterruptedException
    //   33	85	530	java/io/IOException
    //   95	103	543	java/io/IOException
    //   113	117	543	java/io/IOException
    //   127	131	543	java/io/IOException
    //   141	174	543	java/io/IOException
    //   178	189	563	java/io/IOException
  }
  
  public static boolean b(Context paramContext)
  {
    try
    {
      paramContext = Runtime.getRuntime().exec(paramContext.getFilesDir().getPath() + "/traceroute");
      paramContext.waitFor();
      paramContext.destroy();
      return true;
    }
    catch (InterruptedException paramContext)
    {
      return false;
    }
    catch (IOException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.traceroute.TracerouteInstaller
 * JD-Core Version:    0.7.0.1
 */