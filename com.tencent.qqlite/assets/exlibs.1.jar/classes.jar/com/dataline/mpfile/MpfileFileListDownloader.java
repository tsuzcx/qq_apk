package com.dataline.mpfile;

import com.tencent.mobileqq.app.ThreadManager;
import df;

public class MpfileFileListDownloader
{
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 17
    //   5: astore 4
    //   7: iconst_0
    //   8: istore_1
    //   9: aload 4
    //   11: astore_2
    //   12: iload_1
    //   13: iconst_2
    //   14: if_icmpge +174 -> 188
    //   17: new 19	java/net/URL
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 22	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 26	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 28	java/net/HttpURLConnection
    //   31: astore_2
    //   32: aload_2
    //   33: ldc 30
    //   35: invokevirtual 33	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 37	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   43: aload_2
    //   44: iconst_1
    //   45: invokevirtual 40	java/net/HttpURLConnection:setDoInput	(Z)V
    //   48: aload_2
    //   49: sipush 15000
    //   52: invokevirtual 44	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   55: aload_2
    //   56: sipush 30000
    //   59: invokevirtual 47	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   62: getstatic 53	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   65: ifnull +125 -> 190
    //   68: getstatic 57	android/os/Build$VERSION:SDK_INT	I
    //   71: bipush 13
    //   73: if_icmple +117 -> 190
    //   76: aload_2
    //   77: ldc 59
    //   79: ldc 61
    //   81: invokevirtual 65	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: new 67	java/io/InputStreamReader
    //   87: dup
    //   88: aload_2
    //   89: invokevirtual 71	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   92: invokespecial 74	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   95: astore 5
    //   97: new 76	java/io/BufferedReader
    //   100: dup
    //   101: aload 5
    //   103: invokespecial 79	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   106: astore_3
    //   107: new 81	java/lang/StringBuffer
    //   110: dup
    //   111: invokespecial 82	java/lang/StringBuffer:<init>	()V
    //   114: astore 7
    //   116: aload_3
    //   117: invokevirtual 86	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   120: astore 8
    //   122: aload 8
    //   124: ifnull +84 -> 208
    //   127: aload 7
    //   129: aload 8
    //   131: invokevirtual 90	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   134: pop
    //   135: goto -19 -> 116
    //   138: astore 7
    //   140: aload 5
    //   142: astore_3
    //   143: aload 7
    //   145: astore 5
    //   147: aload 5
    //   149: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   152: ldc 17
    //   154: astore 4
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 98	java/io/InputStreamReader:close	()V
    //   172: ldc 17
    //   174: ifnull +97 -> 271
    //   177: ldc 17
    //   179: invokevirtual 104	java/lang/String:length	()I
    //   182: ifle +89 -> 271
    //   185: aload 4
    //   187: astore_2
    //   188: aload_2
    //   189: areturn
    //   190: aload_2
    //   191: ldc 106
    //   193: ldc 108
    //   195: invokevirtual 65	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto -114 -> 84
    //   201: astore 5
    //   203: aconst_null
    //   204: astore_3
    //   205: goto -58 -> 147
    //   208: aload 7
    //   210: invokevirtual 111	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   213: astore_3
    //   214: aload_2
    //   215: ifnull +7 -> 222
    //   218: aload_2
    //   219: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 98	java/io/InputStreamReader:close	()V
    //   232: aload_3
    //   233: ifnull +12 -> 245
    //   236: aload_3
    //   237: astore_2
    //   238: aload_3
    //   239: invokevirtual 104	java/lang/String:length	()I
    //   242: ifgt -54 -> 188
    //   245: iload_1
    //   246: iconst_1
    //   247: iadd
    //   248: istore_1
    //   249: aload_3
    //   250: astore 4
    //   252: goto -243 -> 9
    //   255: astore_2
    //   256: aload_2
    //   257: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   260: goto -28 -> 232
    //   263: astore_2
    //   264: aload_2
    //   265: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   268: goto -96 -> 172
    //   271: iload_1
    //   272: iconst_1
    //   273: iadd
    //   274: istore_1
    //   275: aload 4
    //   277: astore_3
    //   278: goto -29 -> 249
    //   281: astore_0
    //   282: aconst_null
    //   283: astore_2
    //   284: aload 6
    //   286: astore_3
    //   287: aload_2
    //   288: ifnull +7 -> 295
    //   291: aload_2
    //   292: invokevirtual 96	java/net/HttpURLConnection:disconnect	()V
    //   295: aload_3
    //   296: ifnull +7 -> 303
    //   299: aload_3
    //   300: invokevirtual 98	java/io/InputStreamReader:close	()V
    //   303: aload 4
    //   305: ifnull +14 -> 319
    //   308: aload 4
    //   310: astore_2
    //   311: aload 4
    //   313: invokevirtual 104	java/lang/String:length	()I
    //   316: ifgt -128 -> 188
    //   319: aload_0
    //   320: athrow
    //   321: astore_2
    //   322: aload_2
    //   323: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   326: goto -23 -> 303
    //   329: astore_0
    //   330: aload 6
    //   332: astore_3
    //   333: goto -46 -> 287
    //   336: astore_0
    //   337: aload 5
    //   339: astore_3
    //   340: goto -53 -> 287
    //   343: astore_0
    //   344: goto -57 -> 287
    //   347: astore 5
    //   349: aconst_null
    //   350: astore_3
    //   351: aconst_null
    //   352: astore_2
    //   353: goto -206 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramString	String
    //   8	267	1	i	int
    //   11	227	2	localObject1	Object
    //   255	2	2	localIOException1	java.io.IOException
    //   263	2	2	localIOException2	java.io.IOException
    //   283	28	2	localObject2	Object
    //   321	2	2	localIOException3	java.io.IOException
    //   352	1	2	localObject3	Object
    //   106	245	3	localObject4	Object
    //   5	307	4	localObject5	Object
    //   95	53	5	localObject6	Object
    //   201	137	5	localException1	java.lang.Exception
    //   347	1	5	localException2	java.lang.Exception
    //   1	330	6	localObject7	Object
    //   114	14	7	localStringBuffer	java.lang.StringBuffer
    //   138	71	7	localException3	java.lang.Exception
    //   120	10	8	str	String
    // Exception table:
    //   from	to	target	type
    //   97	116	138	java/lang/Exception
    //   116	122	138	java/lang/Exception
    //   127	135	138	java/lang/Exception
    //   208	214	138	java/lang/Exception
    //   32	84	201	java/lang/Exception
    //   84	97	201	java/lang/Exception
    //   190	198	201	java/lang/Exception
    //   227	232	255	java/io/IOException
    //   168	172	263	java/io/IOException
    //   17	32	281	finally
    //   299	303	321	java/io/IOException
    //   32	84	329	finally
    //   84	97	329	finally
    //   190	198	329	finally
    //   97	116	336	finally
    //   116	122	336	finally
    //   127	135	336	finally
    //   208	214	336	finally
    //   147	152	343	finally
    //   17	32	347	java/lang/Exception
  }
  
  public static void a(int paramInt, String paramString, MpfileFileListDownloader.MpFileHttpDownloadListener paramMpFileHttpDownloadListener)
  {
    ThreadManager.a(new df(paramString, paramMpFileHttpDownloadListener, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.mpfile.MpfileFileListDownloader
 * JD-Core Version:    0.7.0.1
 */