package com.tencent.moai.nativepages.download;

import android.os.AsyncTask;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class AdLandingPageDownloadFileTask
  extends AsyncTask<String, Void, Void>
{
  private static Set<String> DownloadTaskSet = Collections.synchronizedSet(new HashSet());
  public static final String TAG = "MicroMsg.AdLandingPageDownloadFileTask";
  private Callback callback;
  private String filePath;
  private String tmpPath;
  
  public AdLandingPageDownloadFileTask(String paramString, Callback paramCallback)
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
    //   1: astore 6
    //   3: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   6: aload_1
    //   7: iconst_0
    //   8: aaload
    //   9: invokeinterface 73 2 0
    //   14: ifeq +5 -> 19
    //   17: aconst_null
    //   18: areturn
    //   19: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   22: aload_1
    //   23: iconst_0
    //   24: aaload
    //   25: invokeinterface 76 2 0
    //   30: pop
    //   31: aload_0
    //   32: getfield 56	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask$Callback;
    //   35: invokeinterface 79 1 0
    //   40: aload_0
    //   41: getfield 39	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:filePath	Ljava/lang/String;
    //   44: invokestatic 85	com/tencent/moai/nativepages/util/FileUtil:fileExists	(Ljava/lang/String;)Z
    //   47: ifeq +11 -> 58
    //   50: aload_0
    //   51: getfield 39	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:filePath	Ljava/lang/String;
    //   54: invokestatic 88	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 54	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:tmpPath	Ljava/lang/String;
    //   62: invokestatic 85	com/tencent/moai/nativepages/util/FileUtil:fileExists	(Ljava/lang/String;)Z
    //   65: ifeq +11 -> 76
    //   68: aload_0
    //   69: getfield 54	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:tmpPath	Ljava/lang/String;
    //   72: invokestatic 88	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   75: pop
    //   76: new 90	java/net/URL
    //   79: dup
    //   80: aload_1
    //   81: iconst_0
    //   82: aaload
    //   83: invokespecial 93	java/net/URL:<init>	(Ljava/lang/String;)V
    //   86: invokevirtual 97	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   89: checkcast 99	java/net/HttpURLConnection
    //   92: astore 4
    //   94: aload 4
    //   96: invokevirtual 102	java/net/HttpURLConnection:connect	()V
    //   99: aload 4
    //   101: invokevirtual 106	java/net/HttpURLConnection:getResponseCode	()I
    //   104: sipush 200
    //   107: if_icmpeq +12 -> 119
    //   110: aload_0
    //   111: getfield 56	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask$Callback;
    //   114: invokeinterface 109 1 0
    //   119: aload 4
    //   121: invokevirtual 113	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   124: astore 5
    //   126: new 115	java/io/FileOutputStream
    //   129: dup
    //   130: aload_0
    //   131: getfield 54	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:tmpPath	Ljava/lang/String;
    //   134: invokespecial 116	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   137: astore_3
    //   138: aload 4
    //   140: astore 8
    //   142: aload_3
    //   143: astore 6
    //   145: aload 5
    //   147: astore 7
    //   149: sipush 4096
    //   152: newarray byte
    //   154: astore 9
    //   156: aload 4
    //   158: astore 8
    //   160: aload_3
    //   161: astore 6
    //   163: aload 5
    //   165: astore 7
    //   167: aload 5
    //   169: aload 9
    //   171: invokevirtual 122	java/io/InputStream:read	([B)I
    //   174: istore_2
    //   175: iload_2
    //   176: iconst_m1
    //   177: if_icmpeq +165 -> 342
    //   180: aload 4
    //   182: astore 8
    //   184: aload_3
    //   185: astore 6
    //   187: aload 5
    //   189: astore 7
    //   191: aload_0
    //   192: invokevirtual 126	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:isCancelled	()Z
    //   195: ifeq +61 -> 256
    //   198: aload 4
    //   200: astore 8
    //   202: aload_3
    //   203: astore 6
    //   205: aload 5
    //   207: astore 7
    //   209: aload 5
    //   211: invokevirtual 129	java/io/InputStream:close	()V
    //   214: aload_3
    //   215: ifnull +7 -> 222
    //   218: aload_3
    //   219: invokevirtual 132	java/io/OutputStream:close	()V
    //   222: aload 5
    //   224: ifnull +8 -> 232
    //   227: aload 5
    //   229: invokevirtual 129	java/io/InputStream:close	()V
    //   232: aload 4
    //   234: ifnull +8 -> 242
    //   237: aload 4
    //   239: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   242: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   245: aload_1
    //   246: iconst_0
    //   247: aaload
    //   248: invokeinterface 138 2 0
    //   253: pop
    //   254: aconst_null
    //   255: areturn
    //   256: aload 4
    //   258: astore 8
    //   260: aload_3
    //   261: astore 6
    //   263: aload 5
    //   265: astore 7
    //   267: aload_3
    //   268: aload 9
    //   270: iconst_0
    //   271: iload_2
    //   272: invokevirtual 142	java/io/OutputStream:write	([BII)V
    //   275: goto -119 -> 156
    //   278: astore 6
    //   280: aload 4
    //   282: astore 8
    //   284: aload_3
    //   285: astore 6
    //   287: aload 5
    //   289: astore 7
    //   291: aload_0
    //   292: getfield 56	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask$Callback;
    //   295: invokeinterface 109 1 0
    //   300: aload_3
    //   301: ifnull +7 -> 308
    //   304: aload_3
    //   305: invokevirtual 132	java/io/OutputStream:close	()V
    //   308: aload 5
    //   310: ifnull +8 -> 318
    //   313: aload 5
    //   315: invokevirtual 129	java/io/InputStream:close	()V
    //   318: aload 4
    //   320: ifnull +8 -> 328
    //   323: aload 4
    //   325: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   328: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   331: aload_1
    //   332: iconst_0
    //   333: aaload
    //   334: invokeinterface 138 2 0
    //   339: pop
    //   340: aconst_null
    //   341: areturn
    //   342: aload 4
    //   344: astore 8
    //   346: aload_3
    //   347: astore 6
    //   349: aload 5
    //   351: astore 7
    //   353: aload_0
    //   354: getfield 54	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:tmpPath	Ljava/lang/String;
    //   357: aload_0
    //   358: getfield 39	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:filePath	Ljava/lang/String;
    //   361: invokestatic 146	com/tencent/moai/nativepages/util/FileUtil:copyFile	(Ljava/lang/String;Ljava/lang/String;)Z
    //   364: ifeq +84 -> 448
    //   367: aload 4
    //   369: astore 8
    //   371: aload_3
    //   372: astore 6
    //   374: aload 5
    //   376: astore 7
    //   378: aload_0
    //   379: getfield 54	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:tmpPath	Ljava/lang/String;
    //   382: invokestatic 88	com/tencent/moai/nativepages/util/FileUtil:deleteFile	(Ljava/lang/String;)Z
    //   385: pop
    //   386: aload 4
    //   388: astore 8
    //   390: aload_3
    //   391: astore 6
    //   393: aload 5
    //   395: astore 7
    //   397: aload_0
    //   398: getfield 56	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask$Callback;
    //   401: invokeinterface 149 1 0
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 132	java/io/OutputStream:close	()V
    //   414: aload 5
    //   416: ifnull +8 -> 424
    //   419: aload 5
    //   421: invokevirtual 129	java/io/InputStream:close	()V
    //   424: aload 4
    //   426: ifnull +8 -> 434
    //   429: aload 4
    //   431: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   434: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   437: aload_1
    //   438: iconst_0
    //   439: aaload
    //   440: invokeinterface 138 2 0
    //   445: pop
    //   446: aconst_null
    //   447: areturn
    //   448: aload 4
    //   450: astore 8
    //   452: aload_3
    //   453: astore 6
    //   455: aload 5
    //   457: astore 7
    //   459: aload_0
    //   460: getfield 56	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:callback	Lcom/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask$Callback;
    //   463: invokeinterface 109 1 0
    //   468: goto -62 -> 406
    //   471: astore_3
    //   472: aload 8
    //   474: astore 4
    //   476: aload 7
    //   478: astore 5
    //   480: aload 6
    //   482: ifnull +8 -> 490
    //   485: aload 6
    //   487: invokevirtual 132	java/io/OutputStream:close	()V
    //   490: aload 5
    //   492: ifnull +8 -> 500
    //   495: aload 5
    //   497: invokevirtual 129	java/io/InputStream:close	()V
    //   500: aload 4
    //   502: ifnull +8 -> 510
    //   505: aload 4
    //   507: invokevirtual 135	java/net/HttpURLConnection:disconnect	()V
    //   510: getstatic 34	com/tencent/moai/nativepages/download/AdLandingPageDownloadFileTask:DownloadTaskSet	Ljava/util/Set;
    //   513: aload_1
    //   514: iconst_0
    //   515: aaload
    //   516: invokeinterface 138 2 0
    //   521: pop
    //   522: aload_3
    //   523: athrow
    //   524: astore 5
    //   526: goto -26 -> 500
    //   529: astore_3
    //   530: aconst_null
    //   531: astore 7
    //   533: aconst_null
    //   534: astore 5
    //   536: aload 6
    //   538: astore 4
    //   540: aload 7
    //   542: astore 6
    //   544: goto -64 -> 480
    //   547: astore_3
    //   548: aconst_null
    //   549: astore 5
    //   551: aconst_null
    //   552: astore 6
    //   554: goto -74 -> 480
    //   557: astore_3
    //   558: aconst_null
    //   559: astore 6
    //   561: goto -81 -> 480
    //   564: astore_3
    //   565: goto -247 -> 318
    //   568: astore_3
    //   569: aconst_null
    //   570: astore 4
    //   572: aconst_null
    //   573: astore_3
    //   574: aconst_null
    //   575: astore 5
    //   577: goto -297 -> 280
    //   580: astore_3
    //   581: aconst_null
    //   582: astore_3
    //   583: aconst_null
    //   584: astore 5
    //   586: goto -306 -> 280
    //   589: astore_3
    //   590: aconst_null
    //   591: astore_3
    //   592: goto -312 -> 280
    //   595: astore_3
    //   596: goto -172 -> 424
    //   599: astore_3
    //   600: goto -368 -> 232
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	AdLandingPageDownloadFileTask
    //   0	603	1	paramVarArgs	String[]
    //   174	98	2	i	int
    //   137	316	3	localFileOutputStream	java.io.FileOutputStream
    //   471	52	3	localObject1	Object
    //   529	1	3	localObject2	Object
    //   547	1	3	localObject3	Object
    //   557	1	3	localObject4	Object
    //   564	1	3	localIOException1	java.io.IOException
    //   568	1	3	localException1	java.lang.Exception
    //   573	1	3	localObject5	Object
    //   580	1	3	localException2	java.lang.Exception
    //   582	1	3	localObject6	Object
    //   589	1	3	localException3	java.lang.Exception
    //   591	1	3	localObject7	Object
    //   595	1	3	localIOException2	java.io.IOException
    //   599	1	3	localIOException3	java.io.IOException
    //   92	479	4	localObject8	Object
    //   124	372	5	localObject9	Object
    //   524	1	5	localIOException4	java.io.IOException
    //   534	51	5	localObject10	Object
    //   1	261	6	localObject11	Object
    //   278	1	6	localException4	java.lang.Exception
    //   285	275	6	localObject12	Object
    //   147	394	7	localObject13	Object
    //   140	333	8	localObject14	Object
    //   154	115	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   149	156	278	java/lang/Exception
    //   167	175	278	java/lang/Exception
    //   191	198	278	java/lang/Exception
    //   209	214	278	java/lang/Exception
    //   267	275	278	java/lang/Exception
    //   353	367	278	java/lang/Exception
    //   378	386	278	java/lang/Exception
    //   397	406	278	java/lang/Exception
    //   459	468	278	java/lang/Exception
    //   149	156	471	finally
    //   167	175	471	finally
    //   191	198	471	finally
    //   209	214	471	finally
    //   267	275	471	finally
    //   291	300	471	finally
    //   353	367	471	finally
    //   378	386	471	finally
    //   397	406	471	finally
    //   459	468	471	finally
    //   485	490	524	java/io/IOException
    //   495	500	524	java/io/IOException
    //   40	58	529	finally
    //   58	76	529	finally
    //   76	94	529	finally
    //   94	119	547	finally
    //   119	126	547	finally
    //   126	138	557	finally
    //   304	308	564	java/io/IOException
    //   313	318	564	java/io/IOException
    //   40	58	568	java/lang/Exception
    //   58	76	568	java/lang/Exception
    //   76	94	568	java/lang/Exception
    //   94	119	580	java/lang/Exception
    //   119	126	580	java/lang/Exception
    //   126	138	589	java/lang/Exception
    //   410	414	595	java/io/IOException
    //   419	424	595	java/io/IOException
    //   218	222	599	java/io/IOException
    //   227	232	599	java/io/IOException
  }
  
  public static abstract interface Callback
  {
    public abstract void onDownloadError();
    
    public abstract void onDownloaded();
    
    public abstract void onStartDownload();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.nativepages.download.AdLandingPageDownloadFileTask
 * JD-Core Version:    0.7.0.1
 */