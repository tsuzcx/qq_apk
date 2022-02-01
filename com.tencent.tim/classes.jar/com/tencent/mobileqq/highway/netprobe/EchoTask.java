package com.tencent.mobileqq.highway.netprobe;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Pair;

public class EchoTask
{
  private static final int DEFAULT_2G_TIMEOUT = 20000;
  private static final int DEFAULT_3G_TIMEOUT = 15000;
  private static final int DEFAULT_4G_TIMEOUT = 10000;
  private static final int DEFAULT_WIFI_TIMEOUT = 10000;
  private static Pair<String, String>[] ECHO_ADDRESS = { new Pair("http://183.60.50.149:8080/cgi-bin/httpecho?len=20", null), new Pair("http://112.90.137.111:8080/cgi-bin/httpecho?len=20", null), new Pair("http://120.198.191.71:8080/cgi-bin/httpecho?len=20", null) };
  public static final int ECHO_EXCEPTION = 3;
  public static final int ECHO_NORMAL = 1;
  public static final int ECHO_REDIRECT_EXCEPTION = -1000;
  public static final int ECHO_RESPONSECODE_EXCEPTION = -999;
  public static final int ECHO_RESP_LENGTH = 20;
  public static final int ECHO_SERVER_EXCEPTION = -998;
  public static final int ECHO_UNKONW_EXCEPTION = -997;
  public static final int ECHO_WRONG_CONTENT = 2;
  private static final int MAX_REDIRECT_TIME = 5;
  private String errorMsg = "unkonw";
  private Context mContext;
  private String mExpectContent;
  private String mRealResponse;
  private String mRequestURL;
  private String mResponseURL;
  private int mTimeout;
  public int mType;
  private int responseCode;
  
  public EchoTask(Context paramContext)
  {
    this(paramContext, 1);
  }
  
  public EchoTask(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
    this.mTimeout = getTimeoutMills();
  }
  
  private void fillErrorMsg(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case -998: 
      this.errorMsg = ("echo connect exception:" + paramString);
      return;
    case -1000: 
      this.errorMsg = ("echo connect redirect error:" + paramString);
      return;
    case -997: 
      this.errorMsg = ("echo unkonw exception:" + paramString);
      return;
    }
    this.errorMsg = ("echo response exception,the responseCode is:" + paramString);
  }
  
  private String getMethod(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "GET";
    }
    return "POST";
  }
  
  private int getSystemNetwork()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isAvailable())) {}
    switch (localNetworkInfo.getType())
    {
    case 7: 
    case 8: 
    default: 
      return 0;
    case 9: 
      return 5;
    case 1: 
    case 6: 
      return 1;
    }
    switch (((TelephonyManager)this.mContext.getSystemService("phone")).getNetworkType())
    {
    case 4: 
    case 7: 
    case 11: 
    default: 
      return 2;
    case 13: 
      return 4;
    }
    return 3;
  }
  
  private int getTimeoutMills()
  {
    switch (getSystemNetwork())
    {
    case 2: 
    default: 
      return 20000;
    case 3: 
      return 15000;
    case 4: 
      return 10000;
    }
    return 10000;
  }
  
  public boolean checkEchoResp(String paramString)
  {
    paramString = paramString.toCharArray();
    if (paramString.length != 20) {
      return false;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label47;
      }
      if (('A' > paramString[i]) || (paramString[i] > 'Z')) {
        break;
      }
      i += 1;
    }
    label47:
    return true;
  }
  
  /* Error */
  public int doEcho()
  {
    // Byte code:
    //   0: getstatic 66	com/tencent/mobileqq/highway/netprobe/EchoTask:ECHO_ADDRESS	[Landroid/util/Pair;
    //   3: astore 9
    //   5: aconst_null
    //   6: astore 5
    //   8: aload 9
    //   10: arraylength
    //   11: istore_3
    //   12: iconst_0
    //   13: istore_2
    //   14: iload_2
    //   15: iload_3
    //   16: if_icmpge +852 -> 868
    //   19: aload 5
    //   21: astore 6
    //   23: aload 5
    //   25: astore 7
    //   27: aload_0
    //   28: aload 9
    //   30: iload_2
    //   31: aaload
    //   32: getfield 164	android/util/Pair:first	Ljava/lang/Object;
    //   35: checkcast 151	java/lang/String
    //   38: putfield 166	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   41: aload 5
    //   43: astore 6
    //   45: aload 5
    //   47: astore 7
    //   49: aload_0
    //   50: aload 9
    //   52: iload_2
    //   53: aaload
    //   54: getfield 169	android/util/Pair:second	Ljava/lang/Object;
    //   57: checkcast 151	java/lang/String
    //   60: putfield 171	com/tencent/mobileqq/highway/netprobe/EchoTask:mExpectContent	Ljava/lang/String;
    //   63: aload 5
    //   65: astore 6
    //   67: aload 5
    //   69: astore 7
    //   71: aload_0
    //   72: getfield 166	com/tencent/mobileqq/highway/netprobe/EchoTask:mRequestURL	Ljava/lang/String;
    //   75: astore 8
    //   77: iconst_0
    //   78: istore_1
    //   79: iload_1
    //   80: iconst_5
    //   81: if_icmpge +813 -> 894
    //   84: aload 5
    //   86: astore 6
    //   88: aload 5
    //   90: astore 7
    //   92: new 173	java/net/URL
    //   95: dup
    //   96: aload 8
    //   98: invokespecial 176	java/net/URL:<init>	(Ljava/lang/String;)V
    //   101: invokevirtual 180	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   104: checkcast 182	java/net/HttpURLConnection
    //   107: astore 5
    //   109: aload 5
    //   111: astore 7
    //   113: aload 5
    //   115: astore 6
    //   117: aload 5
    //   119: iconst_1
    //   120: invokevirtual 186	java/net/HttpURLConnection:setDoInput	(Z)V
    //   123: aload 5
    //   125: astore 7
    //   127: aload 5
    //   129: astore 6
    //   131: aload 5
    //   133: iconst_1
    //   134: invokevirtual 189	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   137: aload 5
    //   139: astore 7
    //   141: aload 5
    //   143: astore 6
    //   145: aload 5
    //   147: iconst_0
    //   148: invokevirtual 192	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   151: aload 5
    //   153: astore 7
    //   155: aload 5
    //   157: astore 6
    //   159: aload 5
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   166: invokespecial 194	com/tencent/mobileqq/highway/netprobe/EchoTask:getMethod	(I)Ljava/lang/String;
    //   169: invokevirtual 197	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   172: aload 5
    //   174: astore 7
    //   176: aload 5
    //   178: astore 6
    //   180: aload 5
    //   182: aload_0
    //   183: getfield 87	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   186: invokevirtual 201	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   189: aload 5
    //   191: astore 7
    //   193: aload 5
    //   195: astore 6
    //   197: aload 5
    //   199: aload_0
    //   200: getfield 87	com/tencent/mobileqq/highway/netprobe/EchoTask:mTimeout	I
    //   203: invokevirtual 204	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   206: aload 5
    //   208: astore 7
    //   210: aload 5
    //   212: astore 6
    //   214: aload 5
    //   216: invokevirtual 207	java/net/HttpURLConnection:connect	()V
    //   219: aload 5
    //   221: astore 7
    //   223: aload 5
    //   225: astore 6
    //   227: aload_0
    //   228: getfield 81	com/tencent/mobileqq/highway/netprobe/EchoTask:mType	I
    //   231: iconst_2
    //   232: if_icmpne +81 -> 313
    //   235: aload 5
    //   237: astore 7
    //   239: aload 5
    //   241: astore 6
    //   243: aload 5
    //   245: invokevirtual 211	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   248: astore 8
    //   250: aload 5
    //   252: astore 7
    //   254: aload 5
    //   256: astore 6
    //   258: sipush 2048
    //   261: newarray byte
    //   263: astore 10
    //   265: aload 5
    //   267: astore 7
    //   269: aload 5
    //   271: astore 6
    //   273: new 213	java/util/Random
    //   276: dup
    //   277: invokespecial 214	java/util/Random:<init>	()V
    //   280: aload 10
    //   282: invokevirtual 218	java/util/Random:nextBytes	([B)V
    //   285: aload 5
    //   287: astore 7
    //   289: aload 5
    //   291: astore 6
    //   293: aload 8
    //   295: aload 10
    //   297: invokevirtual 223	java/io/OutputStream:write	([B)V
    //   300: aload 5
    //   302: astore 7
    //   304: aload 5
    //   306: astore 6
    //   308: aload 8
    //   310: invokevirtual 226	java/io/OutputStream:flush	()V
    //   313: aload 5
    //   315: astore 7
    //   317: aload 5
    //   319: astore 6
    //   321: aload_0
    //   322: aload 5
    //   324: invokevirtual 229	java/net/HttpURLConnection:getResponseCode	()I
    //   327: putfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   330: aload 5
    //   332: astore 7
    //   334: aload 5
    //   336: astore 6
    //   338: aload_0
    //   339: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   342: sipush 301
    //   345: if_icmpeq +21 -> 366
    //   348: aload 5
    //   350: astore 7
    //   352: aload 5
    //   354: astore 6
    //   356: aload_0
    //   357: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   360: sipush 302
    //   363: if_icmpne +316 -> 679
    //   366: iload_1
    //   367: iconst_1
    //   368: iadd
    //   369: iconst_5
    //   370: if_icmpne +263 -> 633
    //   373: aload 5
    //   375: astore 7
    //   377: aload 5
    //   379: astore 6
    //   381: aload_0
    //   382: sipush -1000
    //   385: ldc 233
    //   387: invokespecial 235	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   390: iconst_1
    //   391: istore_1
    //   392: iload_1
    //   393: ifne +439 -> 832
    //   396: aload 5
    //   398: astore 7
    //   400: aload 5
    //   402: astore 6
    //   404: aload_0
    //   405: aload 5
    //   407: invokevirtual 239	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   410: invokevirtual 240	java/net/URL:toString	()Ljava/lang/String;
    //   413: putfield 242	com/tencent/mobileqq/highway/netprobe/EchoTask:mResponseURL	Ljava/lang/String;
    //   416: aload 5
    //   418: astore 7
    //   420: aload 5
    //   422: astore 6
    //   424: aload_0
    //   425: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   428: sipush 200
    //   431: if_icmpeq +21 -> 452
    //   434: aload 5
    //   436: astore 7
    //   438: aload 5
    //   440: astore 6
    //   442: aload_0
    //   443: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   446: sipush 206
    //   449: if_icmpne +333 -> 782
    //   452: aload 5
    //   454: astore 7
    //   456: aload 5
    //   458: astore 6
    //   460: new 244	java/io/BufferedReader
    //   463: dup
    //   464: new 246	java/io/InputStreamReader
    //   467: dup
    //   468: aload 5
    //   470: invokevirtual 250	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   473: invokespecial 253	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   476: invokespecial 256	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   479: astore 8
    //   481: aload 5
    //   483: astore 7
    //   485: aload 5
    //   487: astore 6
    //   489: new 91	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   496: astore 10
    //   498: aload 5
    //   500: astore 7
    //   502: aload 5
    //   504: astore 6
    //   506: aload 8
    //   508: invokevirtual 259	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   511: astore 11
    //   513: aload 11
    //   515: ifnull +187 -> 702
    //   518: aload 5
    //   520: astore 7
    //   522: aload 5
    //   524: astore 6
    //   526: aload 10
    //   528: new 91	java/lang/StringBuilder
    //   531: dup
    //   532: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   535: aload 11
    //   537: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: ldc_w 261
    //   543: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: goto -55 -> 498
    //   556: astore 8
    //   558: aload 7
    //   560: astore 5
    //   562: aload 5
    //   564: astore 6
    //   566: aload 5
    //   568: invokevirtual 264	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   571: astore 7
    //   573: aload 5
    //   575: astore 6
    //   577: aload 7
    //   579: invokevirtual 269	java/io/InputStream:read	()I
    //   582: istore_1
    //   583: iload_1
    //   584: iconst_m1
    //   585: if_icmpne -12 -> 573
    //   588: aload 5
    //   590: astore 6
    //   592: aload_0
    //   593: sipush -997
    //   596: aload 8
    //   598: invokevirtual 270	java/io/IOException:toString	()Ljava/lang/String;
    //   601: invokespecial 235	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   604: aload 5
    //   606: astore 6
    //   608: aload 5
    //   610: ifnull +12 -> 622
    //   613: aload 5
    //   615: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   618: aload 5
    //   620: astore 6
    //   622: iload_2
    //   623: iconst_1
    //   624: iadd
    //   625: istore_2
    //   626: aload 6
    //   628: astore 5
    //   630: goto -616 -> 14
    //   633: aload 5
    //   635: astore 7
    //   637: aload 5
    //   639: astore 6
    //   641: aload 5
    //   643: ldc_w 275
    //   646: invokevirtual 279	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   649: astore 8
    //   651: aload 8
    //   653: ifnonnull +246 -> 899
    //   656: aload 5
    //   658: astore 7
    //   660: aload 5
    //   662: astore 6
    //   664: aload_0
    //   665: sipush -1000
    //   668: ldc_w 281
    //   671: invokespecial 235	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   674: iconst_1
    //   675: istore_1
    //   676: goto -284 -> 392
    //   679: aload 5
    //   681: astore 7
    //   683: aload 5
    //   685: astore 6
    //   687: aload_0
    //   688: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   691: sipush 404
    //   694: if_icmpne +195 -> 889
    //   697: iconst_1
    //   698: istore_1
    //   699: goto -307 -> 392
    //   702: aload 5
    //   704: astore 7
    //   706: aload 5
    //   708: astore 6
    //   710: aload 8
    //   712: invokevirtual 284	java/io/BufferedReader:close	()V
    //   715: aload 5
    //   717: astore 7
    //   719: aload 5
    //   721: astore 6
    //   723: aload_0
    //   724: aload 10
    //   726: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   729: invokevirtual 287	java/lang/String:trim	()Ljava/lang/String;
    //   732: putfield 289	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   735: aload 5
    //   737: astore 7
    //   739: aload 5
    //   741: astore 6
    //   743: aload_0
    //   744: aload_0
    //   745: getfield 289	com/tencent/mobileqq/highway/netprobe/EchoTask:mRealResponse	Ljava/lang/String;
    //   748: invokevirtual 291	com/tencent/mobileqq/highway/netprobe/EchoTask:checkEchoResp	(Ljava/lang/String;)Z
    //   751: istore 4
    //   753: iload 4
    //   755: ifeq +15 -> 770
    //   758: aload 5
    //   760: ifnull +8 -> 768
    //   763: aload 5
    //   765: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   768: iconst_1
    //   769: ireturn
    //   770: aload 5
    //   772: ifnull +8 -> 780
    //   775: aload 5
    //   777: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   780: iconst_2
    //   781: ireturn
    //   782: aload 5
    //   784: astore 7
    //   786: aload 5
    //   788: astore 6
    //   790: aload_0
    //   791: sipush -999
    //   794: new 91	java/lang/StringBuilder
    //   797: dup
    //   798: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   801: aload_0
    //   802: getfield 231	com/tencent/mobileqq/highway/netprobe/EchoTask:responseCode	I
    //   805: invokevirtual 294	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   808: ldc_w 296
    //   811: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokespecial 235	com/tencent/mobileqq/highway/netprobe/EchoTask:fillErrorMsg	(ILjava/lang/String;)V
    //   820: aload 5
    //   822: ifnull +8 -> 830
    //   825: aload 5
    //   827: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   830: iconst_3
    //   831: ireturn
    //   832: aload 5
    //   834: astore 6
    //   836: aload 5
    //   838: ifnull -216 -> 622
    //   841: aload 5
    //   843: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   846: aload 5
    //   848: astore 6
    //   850: goto -228 -> 622
    //   853: astore 5
    //   855: aload 6
    //   857: ifnull +8 -> 865
    //   860: aload 6
    //   862: invokevirtual 273	java/net/HttpURLConnection:disconnect	()V
    //   865: aload 5
    //   867: athrow
    //   868: iconst_3
    //   869: ireturn
    //   870: astore 5
    //   872: goto -17 -> 855
    //   875: astore 6
    //   877: goto -289 -> 588
    //   880: astore 8
    //   882: aload 7
    //   884: astore 5
    //   886: goto -324 -> 562
    //   889: iconst_0
    //   890: istore_1
    //   891: goto -499 -> 392
    //   894: iconst_0
    //   895: istore_1
    //   896: goto -504 -> 392
    //   899: iload_1
    //   900: iconst_1
    //   901: iadd
    //   902: istore_1
    //   903: goto -824 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	906	0	this	EchoTask
    //   78	825	1	i	int
    //   13	613	2	j	int
    //   11	6	3	k	int
    //   751	3	4	bool	boolean
    //   6	841	5	localObject1	Object
    //   853	13	5	localObject2	Object
    //   870	1	5	localObject3	Object
    //   884	1	5	localObject4	Object
    //   21	840	6	localObject5	Object
    //   875	1	6	localException	java.lang.Exception
    //   25	858	7	localObject6	Object
    //   75	432	8	localObject7	Object
    //   556	41	8	localIOException1	java.io.IOException
    //   649	62	8	str1	String
    //   880	1	8	localIOException2	java.io.IOException
    //   3	48	9	arrayOfPair	Pair[]
    //   263	462	10	localObject8	Object
    //   511	25	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   117	123	556	java/io/IOException
    //   131	137	556	java/io/IOException
    //   145	151	556	java/io/IOException
    //   159	172	556	java/io/IOException
    //   180	189	556	java/io/IOException
    //   197	206	556	java/io/IOException
    //   214	219	556	java/io/IOException
    //   227	235	556	java/io/IOException
    //   243	250	556	java/io/IOException
    //   258	265	556	java/io/IOException
    //   273	285	556	java/io/IOException
    //   293	300	556	java/io/IOException
    //   308	313	556	java/io/IOException
    //   321	330	556	java/io/IOException
    //   338	348	556	java/io/IOException
    //   356	366	556	java/io/IOException
    //   381	390	556	java/io/IOException
    //   404	416	556	java/io/IOException
    //   424	434	556	java/io/IOException
    //   442	452	556	java/io/IOException
    //   460	481	556	java/io/IOException
    //   489	498	556	java/io/IOException
    //   506	513	556	java/io/IOException
    //   526	553	556	java/io/IOException
    //   641	651	556	java/io/IOException
    //   664	674	556	java/io/IOException
    //   687	697	556	java/io/IOException
    //   710	715	556	java/io/IOException
    //   723	735	556	java/io/IOException
    //   743	753	556	java/io/IOException
    //   790	820	556	java/io/IOException
    //   117	123	853	finally
    //   131	137	853	finally
    //   145	151	853	finally
    //   159	172	853	finally
    //   180	189	853	finally
    //   197	206	853	finally
    //   214	219	853	finally
    //   227	235	853	finally
    //   243	250	853	finally
    //   258	265	853	finally
    //   273	285	853	finally
    //   293	300	853	finally
    //   308	313	853	finally
    //   321	330	853	finally
    //   338	348	853	finally
    //   356	366	853	finally
    //   381	390	853	finally
    //   404	416	853	finally
    //   424	434	853	finally
    //   442	452	853	finally
    //   460	481	853	finally
    //   489	498	853	finally
    //   506	513	853	finally
    //   526	553	853	finally
    //   566	573	853	finally
    //   577	583	853	finally
    //   592	604	853	finally
    //   641	651	853	finally
    //   664	674	853	finally
    //   687	697	853	finally
    //   710	715	853	finally
    //   723	735	853	finally
    //   743	753	853	finally
    //   790	820	853	finally
    //   27	41	870	finally
    //   49	63	870	finally
    //   71	77	870	finally
    //   92	109	870	finally
    //   566	573	875	java/lang/Exception
    //   577	583	875	java/lang/Exception
    //   27	41	880	java/io/IOException
    //   49	63	880	java/io/IOException
    //   71	77	880	java/io/IOException
    //   92	109	880	java/io/IOException
  }
  
  public String getErrorMsg()
  {
    return this.errorMsg;
  }
  
  public String getExpectContent()
  {
    return this.mExpectContent;
  }
  
  public String getResponseContent()
  {
    return this.mRealResponse;
  }
  
  public String getResponseUrl()
  {
    return this.mResponseURL;
  }
  
  public int getTimeout()
  {
    return this.mTimeout;
  }
  
  public static abstract interface ECHO_TYPE
  {
    public static final int HTTP_GET = 1;
    public static final int HTTP_POST = 2;
  }
  
  static abstract interface NetType
  {
    public static final int CABLE = 5;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.netprobe.EchoTask
 * JD-Core Version:    0.7.0.1
 */