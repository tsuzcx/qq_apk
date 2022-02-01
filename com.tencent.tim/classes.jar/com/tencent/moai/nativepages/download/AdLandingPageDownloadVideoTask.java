package com.tencent.moai.nativepages.download;

import android.os.AsyncTask;
import java.util.HashSet;
import java.util.Set;

public class AdLandingPageDownloadVideoTask
  extends AsyncTask<String, Void, Void>
{
  private static Set<String> DownloadSightTaskSet = new HashSet();
  final Callback callback;
  final String filePath;
  final String tmpPath;
  
  public AdLandingPageDownloadVideoTask(String paramString, Callback paramCallback)
  {
    this.filePath = paramString;
    this.tmpPath = (paramString + ".tmp");
    this.callback = paramCallback;
  }
  
  /* Error */
  protected Void doInBackground(String... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: getstatic 25	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:DownloadSightTaskSet	Ljava/util/Set;
    //   6: aload_1
    //   7: iconst_0
    //   8: aaload
    //   9: invokeinterface 64 2 0
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: getstatic 25	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:DownloadSightTaskSet	Ljava/util/Set;
    //   22: aload_1
    //   23: iconst_0
    //   24: aaload
    //   25: invokeinterface 67 2 0
    //   30: pop
    //   31: aload_0
    //   32: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   35: invokestatic 73	com/tencent/moai/nativepages/util/FileUtil:fileExists	(Ljava/lang/String;)Z
    //   38: ifeq +11 -> 49
    //   41: aload_0
    //   42: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   45: invokestatic 76	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   48: pop
    //   49: aload_0
    //   50: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   53: invokestatic 73	com/tencent/moai/nativepages/util/FileUtil:fileExists	(Ljava/lang/String;)Z
    //   56: ifeq +11 -> 67
    //   59: aload_0
    //   60: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   63: invokestatic 76	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   66: pop
    //   67: new 78	java/net/URL
    //   70: dup
    //   71: aload_1
    //   72: iconst_0
    //   73: aaload
    //   74: invokespecial 81	java/net/URL:<init>	(Ljava/lang/String;)V
    //   77: invokevirtual 85	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   80: checkcast 87	java/net/HttpURLConnection
    //   83: astore 4
    //   85: aload 4
    //   87: invokevirtual 90	java/net/HttpURLConnection:connect	()V
    //   90: aload 4
    //   92: invokevirtual 94	java/net/HttpURLConnection:getResponseCode	()I
    //   95: istore_2
    //   96: iload_2
    //   97: sipush 200
    //   100: if_icmpeq +31 -> 131
    //   103: aload_0
    //   104: getfield 47	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask$Callback;
    //   107: new 32	java/lang/StringBuilder
    //   110: dup
    //   111: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   114: ldc 96
    //   116: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: iload_2
    //   120: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokeinterface 102 2 0
    //   131: aload 4
    //   133: invokevirtual 106	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   136: astore 7
    //   138: new 108	java/io/FileOutputStream
    //   141: dup
    //   142: aload_0
    //   143: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   146: invokespecial 109	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   149: astore 6
    //   151: sipush 4096
    //   154: newarray byte
    //   156: astore 5
    //   158: iconst_0
    //   159: istore_2
    //   160: aload 7
    //   162: aload 5
    //   164: invokevirtual 115	java/io/InputStream:read	([B)I
    //   167: istore_3
    //   168: iload_3
    //   169: iconst_m1
    //   170: if_icmpeq +93 -> 263
    //   173: aload 6
    //   175: aload 5
    //   177: iconst_0
    //   178: iload_3
    //   179: invokevirtual 121	java/io/OutputStream:write	([BII)V
    //   182: iload_2
    //   183: iload_3
    //   184: iadd
    //   185: istore_2
    //   186: aload_0
    //   187: getfield 47	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask$Callback;
    //   190: aload_0
    //   191: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   194: iload_2
    //   195: invokeinterface 125 3 0
    //   200: goto -40 -> 160
    //   203: astore 5
    //   205: aload_0
    //   206: getfield 47	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask$Callback;
    //   209: aload 5
    //   211: invokevirtual 128	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   214: invokeinterface 102 2 0
    //   219: aload 6
    //   221: ifnull +8 -> 229
    //   224: aload 6
    //   226: invokevirtual 131	java/io/OutputStream:close	()V
    //   229: aload 7
    //   231: ifnull +8 -> 239
    //   234: aload 7
    //   236: invokevirtual 132	java/io/InputStream:close	()V
    //   239: aload 4
    //   241: ifnull +8 -> 249
    //   244: aload 4
    //   246: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   249: getstatic 25	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:DownloadSightTaskSet	Ljava/util/Set;
    //   252: aload_1
    //   253: iconst_0
    //   254: aaload
    //   255: invokeinterface 138 2 0
    //   260: pop
    //   261: aconst_null
    //   262: areturn
    //   263: aload_0
    //   264: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   271: invokestatic 142	com/tencent/moai/nativepages/util/FileUtil:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   274: ifeq +68 -> 342
    //   277: aload_0
    //   278: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   281: invokestatic 76	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   284: pop
    //   285: aload_0
    //   286: getfield 47	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask$Callback;
    //   289: aload_0
    //   290: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   293: invokeinterface 145 2 0
    //   298: aload 6
    //   300: ifnull +8 -> 308
    //   303: aload 6
    //   305: invokevirtual 131	java/io/OutputStream:close	()V
    //   308: aload 7
    //   310: ifnull +8 -> 318
    //   313: aload 7
    //   315: invokevirtual 132	java/io/InputStream:close	()V
    //   318: aload 4
    //   320: ifnull +8 -> 328
    //   323: aload 4
    //   325: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   328: getstatic 25	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:DownloadSightTaskSet	Ljava/util/Set;
    //   331: aload_1
    //   332: iconst_0
    //   333: aaload
    //   334: invokeinterface 138 2 0
    //   339: pop
    //   340: aconst_null
    //   341: areturn
    //   342: aload_0
    //   343: getfield 47	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask$Callback;
    //   346: new 32	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   353: ldc 147
    //   355: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_0
    //   359: getfield 45	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:tmpPath	Ljava/lang/String;
    //   362: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   365: ldc 149
    //   367: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_0
    //   371: getfield 30	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:filePath	Ljava/lang/String;
    //   374: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokeinterface 102 2 0
    //   385: goto -87 -> 298
    //   388: astore 8
    //   390: aload 4
    //   392: astore 5
    //   394: aload 8
    //   396: astore 4
    //   398: aload 6
    //   400: ifnull +8 -> 408
    //   403: aload 6
    //   405: invokevirtual 131	java/io/OutputStream:close	()V
    //   408: aload 7
    //   410: ifnull +8 -> 418
    //   413: aload 7
    //   415: invokevirtual 132	java/io/InputStream:close	()V
    //   418: aload 5
    //   420: ifnull +8 -> 428
    //   423: aload 5
    //   425: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   428: getstatic 25	com/tencent/moai/nativepages/download/AdLandingPageDownloadVideoTask:DownloadSightTaskSet	Ljava/util/Set;
    //   431: aload_1
    //   432: iconst_0
    //   433: aaload
    //   434: invokeinterface 138 2 0
    //   439: pop
    //   440: aload 4
    //   442: athrow
    //   443: astore 6
    //   445: goto -27 -> 418
    //   448: astore 4
    //   450: aconst_null
    //   451: astore 6
    //   453: aconst_null
    //   454: astore 7
    //   456: goto -58 -> 398
    //   459: astore 8
    //   461: aconst_null
    //   462: astore 6
    //   464: aconst_null
    //   465: astore 7
    //   467: aload 4
    //   469: astore 5
    //   471: aload 8
    //   473: astore 4
    //   475: goto -77 -> 398
    //   478: astore 8
    //   480: aconst_null
    //   481: astore 6
    //   483: aload 4
    //   485: astore 5
    //   487: aload 8
    //   489: astore 4
    //   491: goto -93 -> 398
    //   494: astore 8
    //   496: aload 4
    //   498: astore 5
    //   500: aload 8
    //   502: astore 4
    //   504: goto -106 -> 398
    //   507: astore 5
    //   509: goto -270 -> 239
    //   512: astore 5
    //   514: aconst_null
    //   515: astore 4
    //   517: aconst_null
    //   518: astore 6
    //   520: aconst_null
    //   521: astore 7
    //   523: goto -318 -> 205
    //   526: astore 5
    //   528: aconst_null
    //   529: astore 6
    //   531: aconst_null
    //   532: astore 7
    //   534: goto -329 -> 205
    //   537: astore 5
    //   539: aconst_null
    //   540: astore 6
    //   542: goto -337 -> 205
    //   545: astore 5
    //   547: goto -229 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	this	AdLandingPageDownloadVideoTask
    //   0	550	1	paramVarArgs	String[]
    //   95	100	2	i	int
    //   167	18	3	j	int
    //   83	358	4	localObject1	Object
    //   448	20	4	localObject2	Object
    //   473	43	4	localObject3	Object
    //   1	175	5	arrayOfByte	byte[]
    //   203	7	5	localException1	java.lang.Exception
    //   392	107	5	localObject4	Object
    //   507	1	5	localIOException1	java.io.IOException
    //   512	1	5	localException2	java.lang.Exception
    //   526	1	5	localException3	java.lang.Exception
    //   537	1	5	localException4	java.lang.Exception
    //   545	1	5	localIOException2	java.io.IOException
    //   149	255	6	localFileOutputStream	java.io.FileOutputStream
    //   443	1	6	localIOException3	java.io.IOException
    //   451	90	6	localObject5	Object
    //   136	397	7	localInputStream	java.io.InputStream
    //   388	7	8	localObject6	Object
    //   459	13	8	localObject7	Object
    //   478	10	8	localObject8	Object
    //   494	7	8	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   151	158	203	java/lang/Exception
    //   160	168	203	java/lang/Exception
    //   173	182	203	java/lang/Exception
    //   186	200	203	java/lang/Exception
    //   263	298	203	java/lang/Exception
    //   342	385	203	java/lang/Exception
    //   151	158	388	finally
    //   160	168	388	finally
    //   173	182	388	finally
    //   186	200	388	finally
    //   263	298	388	finally
    //   342	385	388	finally
    //   403	408	443	java/io/IOException
    //   413	418	443	java/io/IOException
    //   31	49	448	finally
    //   49	67	448	finally
    //   67	85	448	finally
    //   85	96	459	finally
    //   103	131	459	finally
    //   131	138	459	finally
    //   138	151	478	finally
    //   205	219	494	finally
    //   224	229	507	java/io/IOException
    //   234	239	507	java/io/IOException
    //   31	49	512	java/lang/Exception
    //   49	67	512	java/lang/Exception
    //   67	85	512	java/lang/Exception
    //   85	96	526	java/lang/Exception
    //   103	131	526	java/lang/Exception
    //   131	138	526	java/lang/Exception
    //   138	151	537	java/lang/Exception
    //   303	308	545	java/io/IOException
    //   313	318	545	java/io/IOException
  }
  
  public static abstract interface Callback
  {
    public abstract void onFail(String paramString);
    
    public abstract void onFinish(String paramString);
    
    public abstract void onProgress(String paramString, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPageDownloadVideoTask
 * JD-Core Version:    0.7.0.1
 */