package com.tencent.biz.common.download;

public class Downloader$DownloadThread
  extends Thread
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private int b;
  private int c;
  private int d;
  
  public Downloader$DownloadThread(Downloader paramDownloader, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.jdField_a_of_type_JavaLangString = paramString;
    paramDownloader.a("DownloadThread init :threadId:" + paramInt1 + ", start:" + paramInt2 + ", end:" + paramInt3 + ", completeSize:" + paramInt4);
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: sipush 2048
    //   3: istore_2
    //   4: iconst_2
    //   5: istore_3
    //   6: aload_0
    //   7: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   10: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +12 -> 25
    //   16: aload_0
    //   17: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   20: iconst_2
    //   21: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   24: return
    //   25: aload_0
    //   26: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   29: ifle +59 -> 88
    //   32: aload_0
    //   33: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   36: aload_0
    //   37: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   40: isub
    //   41: aload_0
    //   42: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   45: iconst_1
    //   46: isub
    //   47: if_icmpne +41 -> 88
    //   50: aload_0
    //   51: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   54: iconst_0
    //   55: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   58: aload_0
    //   59: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   62: new 30	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   69: ldc 80
    //   71: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload_0
    //   75: getfield 20	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_Int	I
    //   78: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   81: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   87: return
    //   88: aload_0
    //   89: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   92: aload_0
    //   93: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   96: if_icmpge +21 -> 117
    //   99: aload_0
    //   100: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   103: iconst_2
    //   104: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   107: aload_0
    //   108: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   111: ldc 82
    //   113: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   116: return
    //   117: new 84	java/net/URL
    //   120: dup
    //   121: aload_0
    //   122: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   125: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   128: astore 6
    //   130: aload_0
    //   131: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: astore 7
    //   136: new 88	org/apache/http/client/methods/HttpGet
    //   139: dup
    //   140: aload 7
    //   142: invokespecial 89	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   145: astore 5
    //   147: new 91	org/apache/http/params/BasicHttpParams
    //   150: dup
    //   151: invokespecial 92	org/apache/http/params/BasicHttpParams:<init>	()V
    //   154: astore 7
    //   156: aload 7
    //   158: ldc 94
    //   160: ldc 95
    //   162: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokeinterface 107 3 0
    //   170: pop
    //   171: aload 7
    //   173: ldc 109
    //   175: ldc 95
    //   177: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokeinterface 107 3 0
    //   185: pop
    //   186: invokestatic 114	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   189: astore 8
    //   191: invokestatic 118	android/net/Proxy:getDefaultPort	()I
    //   194: istore 4
    //   196: iload_2
    //   197: istore_1
    //   198: aload_0
    //   199: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   202: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   205: ifnull +204 -> 409
    //   208: aload_0
    //   209: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   212: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   215: invokevirtual 126	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   218: astore 9
    //   220: aload_0
    //   221: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   224: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   227: invokestatic 129	com/tencent/biz/common/download/Downloader:a	(Landroid/net/NetworkInfo;)Z
    //   230: ifeq +49 -> 279
    //   233: aload 9
    //   235: ifnull +13 -> 248
    //   238: aload 9
    //   240: ldc 131
    //   242: invokevirtual 137	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   245: ifeq +34 -> 279
    //   248: aload 8
    //   250: ifnull +29 -> 279
    //   253: iload 4
    //   255: ifle +24 -> 279
    //   258: aload 7
    //   260: ldc 139
    //   262: new 141	org/apache/http/HttpHost
    //   265: dup
    //   266: aload 8
    //   268: iload 4
    //   270: invokespecial 144	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   273: invokeinterface 107 3 0
    //   278: pop
    //   279: aload_0
    //   280: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   283: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   286: invokestatic 129	com/tencent/biz/common/download/Downloader:a	(Landroid/net/NetworkInfo;)Z
    //   289: ifeq +204 -> 493
    //   292: iload_2
    //   293: istore_1
    //   294: aload 7
    //   296: ldc 146
    //   298: iload_1
    //   299: invokeinterface 150 3 0
    //   304: pop
    //   305: aload 5
    //   307: ldc 152
    //   309: new 30	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   316: ldc 154
    //   318: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   325: aload_0
    //   326: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   329: iadd
    //   330: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc 156
    //   335: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_0
    //   339: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   342: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokevirtual 160	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_0
    //   352: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   355: new 30	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   362: ldc 162
    //   364: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: aload_0
    //   368: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   371: aload_0
    //   372: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   375: iadd
    //   376: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   379: ldc 156
    //   381: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: ldc 164
    //   386: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_0
    //   390: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   393: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   402: aload 5
    //   404: aload 7
    //   406: invokevirtual 168	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   409: new 141	org/apache/http/HttpHost
    //   412: dup
    //   413: aload 6
    //   415: invokevirtual 171	java/net/URL:getHost	()Ljava/lang/String;
    //   418: invokespecial 172	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   421: astore 6
    //   423: aload 6
    //   425: ifnull +8 -> 433
    //   428: aload 5
    //   430: ifnonnull +70 -> 500
    //   433: aload_0
    //   434: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   437: iconst_2
    //   438: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   441: return
    //   442: astore 5
    //   444: aload 5
    //   446: invokevirtual 175	java/net/MalformedURLException:printStackTrace	()V
    //   449: aload_0
    //   450: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   453: iconst_2
    //   454: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   457: return
    //   458: astore 5
    //   460: new 88	org/apache/http/client/methods/HttpGet
    //   463: dup
    //   464: aload 7
    //   466: invokestatic 178	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   469: invokespecial 89	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   472: astore 5
    //   474: goto -327 -> 147
    //   477: astore 5
    //   479: aload 5
    //   481: invokevirtual 179	java/lang/IllegalArgumentException:printStackTrace	()V
    //   484: aload_0
    //   485: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   488: iconst_2
    //   489: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   492: return
    //   493: sipush 4096
    //   496: istore_1
    //   497: goto -203 -> 294
    //   500: new 91	org/apache/http/params/BasicHttpParams
    //   503: dup
    //   504: invokespecial 92	org/apache/http/params/BasicHttpParams:<init>	()V
    //   507: astore 7
    //   509: aload 7
    //   511: getstatic 185	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   514: invokestatic 191	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   517: aload 7
    //   519: ldc 193
    //   521: invokestatic 197	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   524: aload 7
    //   526: iconst_1
    //   527: invokestatic 201	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   530: new 203	org/apache/http/conn/scheme/SchemeRegistry
    //   533: dup
    //   534: invokespecial 204	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   537: astore 8
    //   539: aload 8
    //   541: new 206	org/apache/http/conn/scheme/Scheme
    //   544: dup
    //   545: ldc 208
    //   547: invokestatic 214	org/apache/http/conn/scheme/PlainSocketFactory:getSocketFactory	()Lorg/apache/http/conn/scheme/PlainSocketFactory;
    //   550: bipush 80
    //   552: invokespecial 217	org/apache/http/conn/scheme/Scheme:<init>	(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V
    //   555: invokevirtual 221	org/apache/http/conn/scheme/SchemeRegistry:register	(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;
    //   558: pop
    //   559: new 223	org/apache/http/impl/client/DefaultHttpClient
    //   562: dup
    //   563: new 225	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager
    //   566: dup
    //   567: aload 7
    //   569: aload 8
    //   571: invokespecial 228	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   574: aload 7
    //   576: invokespecial 231	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   579: astore 7
    //   581: aload 7
    //   583: new 233	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   586: dup
    //   587: invokespecial 234	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   590: invokevirtual 238	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   593: aload 7
    //   595: aload 6
    //   597: aload 5
    //   599: invokevirtual 242	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   602: astore 5
    //   604: aload 5
    //   606: invokeinterface 248 1 0
    //   611: invokeinterface 253 1 0
    //   616: istore_2
    //   617: new 255	java/io/RandomAccessFile
    //   620: dup
    //   621: aload_0
    //   622: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   625: getfield 257	com/tencent/biz/common/download/Downloader:c	Ljava/lang/String;
    //   628: ldc_w 259
    //   631: invokespecial 261	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   634: astore 9
    //   636: aload 9
    //   638: aload_0
    //   639: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   642: aload_0
    //   643: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   646: iadd
    //   647: i2l
    //   648: invokevirtual 265	java/io/RandomAccessFile:seek	(J)V
    //   651: aload_0
    //   652: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   655: new 30	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 267
    //   665: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: aload_0
    //   669: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   672: aload_0
    //   673: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   676: iadd
    //   677: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   680: ldc_w 269
    //   683: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: iload_2
    //   687: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   696: sipush 200
    //   699: iload_2
    //   700: if_icmpeq +10 -> 710
    //   703: sipush 206
    //   706: iload_2
    //   707: if_icmpne +595 -> 1302
    //   710: aconst_null
    //   711: astore 7
    //   713: aload 5
    //   715: invokeinterface 273 1 0
    //   720: astore 5
    //   722: aload 5
    //   724: astore 7
    //   726: aload 5
    //   728: invokeinterface 279 1 0
    //   733: astore 6
    //   735: aload 5
    //   737: astore 7
    //   739: iload_1
    //   740: newarray byte
    //   742: astore 10
    //   744: aload 5
    //   746: astore 7
    //   748: iload_1
    //   749: newarray byte
    //   751: astore 8
    //   753: iconst_m1
    //   754: istore_2
    //   755: iconst_1
    //   756: istore_1
    //   757: aload 5
    //   759: astore 7
    //   761: aload 6
    //   763: aload 10
    //   765: invokevirtual 285	java/io/InputStream:read	([B)I
    //   768: istore_3
    //   769: iload_3
    //   770: iconst_m1
    //   771: if_icmpeq +402 -> 1173
    //   774: iload_1
    //   775: ifne +68 -> 843
    //   778: aload 5
    //   780: astore 7
    //   782: aload 9
    //   784: aload 8
    //   786: iconst_0
    //   787: iload_2
    //   788: invokevirtual 289	java/io/RandomAccessFile:write	([BII)V
    //   791: aload 5
    //   793: astore 7
    //   795: aload_0
    //   796: aload_0
    //   797: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   800: iload_2
    //   801: iadd
    //   802: putfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   805: aload 5
    //   807: astore 7
    //   809: aload_0
    //   810: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   813: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   816: aload_0
    //   817: getfield 20	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_Int	I
    //   820: aload_0
    //   821: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   824: aload_0
    //   825: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   828: invokevirtual 297	com/tencent/biz/common/download/DownloadDao:a	(IILjava/lang/String;)V
    //   831: aload 5
    //   833: astore 7
    //   835: aload_0
    //   836: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   839: iload_2
    //   840: invokevirtual 299	com/tencent/biz/common/download/Downloader:b	(I)V
    //   843: aload 5
    //   845: astore 7
    //   847: aload 10
    //   849: invokevirtual 305	[B:clone	()Ljava/lang/Object;
    //   852: checkcast 301	[B
    //   855: astore 8
    //   857: aload 5
    //   859: astore 7
    //   861: iconst_3
    //   862: aload_0
    //   863: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   866: getfield 308	com/tencent/biz/common/download/Downloader:n	I
    //   869: if_icmpne +548 -> 1417
    //   872: aload 5
    //   874: astore 7
    //   876: aload_0
    //   877: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   880: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   883: invokevirtual 310	com/tencent/biz/common/download/DownloadDao:a	()V
    //   886: aload 5
    //   888: astore 7
    //   890: aload 6
    //   892: invokevirtual 313	java/io/InputStream:close	()V
    //   895: aload 9
    //   897: ifnull +12 -> 909
    //   900: aload 5
    //   902: astore 7
    //   904: aload 9
    //   906: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   909: aload 5
    //   911: ifnull -887 -> 24
    //   914: aload 5
    //   916: invokeinterface 317 1 0
    //   921: return
    //   922: astore 5
    //   924: aload 5
    //   926: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   929: return
    //   930: astore 5
    //   932: aload 5
    //   934: invokevirtual 319	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   937: aload_0
    //   938: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   941: iconst_2
    //   942: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   945: return
    //   946: astore 5
    //   948: aload 5
    //   950: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   953: aload_0
    //   954: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   957: iconst_2
    //   958: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   961: return
    //   962: astore 5
    //   964: aload 5
    //   966: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   969: aload_0
    //   970: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   973: iconst_2
    //   974: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   977: return
    //   978: astore 5
    //   980: aload 5
    //   982: invokevirtual 321	java/io/FileNotFoundException:printStackTrace	()V
    //   985: aload_0
    //   986: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   989: iconst_2
    //   990: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   993: return
    //   994: astore 5
    //   996: aload 5
    //   998: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1001: aload_0
    //   1002: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1005: iconst_2
    //   1006: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   1009: aload 9
    //   1011: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   1014: return
    //   1015: astore 5
    //   1017: aload 5
    //   1019: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1022: return
    //   1023: astore 8
    //   1025: aload 5
    //   1027: astore 7
    //   1029: aload 8
    //   1031: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1034: aload 5
    //   1036: astore 7
    //   1038: aload_0
    //   1039: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1042: ldc_w 323
    //   1045: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1048: goto -153 -> 895
    //   1051: astore 7
    //   1053: aload 5
    //   1055: astore 8
    //   1057: aload 6
    //   1059: astore 5
    //   1061: aload 8
    //   1063: astore 6
    //   1065: aload 7
    //   1067: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1070: aload_0
    //   1071: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1074: ldc_w 325
    //   1077: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1080: aload 6
    //   1082: ifnull +321 -> 1403
    //   1085: aload 6
    //   1087: invokeinterface 317 1 0
    //   1092: iconst_2
    //   1093: istore_1
    //   1094: aload_0
    //   1095: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1098: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1101: invokevirtual 310	com/tencent/biz/common/download/DownloadDao:a	()V
    //   1104: aload 5
    //   1106: invokevirtual 313	java/io/InputStream:close	()V
    //   1109: aload 9
    //   1111: ifnull +8 -> 1119
    //   1114: aload 9
    //   1116: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   1119: aload_0
    //   1120: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1123: iload_1
    //   1124: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   1127: return
    //   1128: astore 8
    //   1130: aload 5
    //   1132: astore 7
    //   1134: aload 8
    //   1136: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1139: aload 5
    //   1141: astore 7
    //   1143: aload_0
    //   1144: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1147: ldc_w 327
    //   1150: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1153: goto -244 -> 909
    //   1156: astore 5
    //   1158: aload 7
    //   1160: ifnull +10 -> 1170
    //   1163: aload 7
    //   1165: invokeinterface 317 1 0
    //   1170: aload 5
    //   1172: athrow
    //   1173: iload_2
    //   1174: iconst_m1
    //   1175: if_icmpeq +68 -> 1243
    //   1178: aload 5
    //   1180: astore 7
    //   1182: aload 9
    //   1184: aload 8
    //   1186: iconst_0
    //   1187: iload_2
    //   1188: invokevirtual 289	java/io/RandomAccessFile:write	([BII)V
    //   1191: aload 5
    //   1193: astore 7
    //   1195: aload_0
    //   1196: aload_0
    //   1197: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1200: iload_2
    //   1201: iadd
    //   1202: putfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1205: aload 5
    //   1207: astore 7
    //   1209: aload_0
    //   1210: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1213: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1216: aload_0
    //   1217: getfield 20	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_Int	I
    //   1220: aload_0
    //   1221: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1224: aload_0
    //   1225: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1228: invokevirtual 297	com/tencent/biz/common/download/DownloadDao:a	(IILjava/lang/String;)V
    //   1231: aload 5
    //   1233: astore 7
    //   1235: aload_0
    //   1236: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1239: iload_2
    //   1240: invokevirtual 299	com/tencent/biz/common/download/Downloader:b	(I)V
    //   1243: aload 5
    //   1245: ifnull +163 -> 1408
    //   1248: aload 5
    //   1250: invokeinterface 317 1 0
    //   1255: iconst_0
    //   1256: istore_1
    //   1257: aload 6
    //   1259: astore 5
    //   1261: goto -167 -> 1094
    //   1264: astore 5
    //   1266: aload 5
    //   1268: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1271: iconst_0
    //   1272: istore_1
    //   1273: aload 6
    //   1275: astore 5
    //   1277: goto -183 -> 1094
    //   1280: astore 6
    //   1282: aload 6
    //   1284: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1287: iconst_2
    //   1288: istore_1
    //   1289: goto -195 -> 1094
    //   1292: astore 6
    //   1294: aload 6
    //   1296: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1299: goto -129 -> 1170
    //   1302: sipush 404
    //   1305: iload_2
    //   1306: if_icmpne +17 -> 1323
    //   1309: aload_0
    //   1310: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1313: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1316: aload_0
    //   1317: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1320: invokevirtual 328	com/tencent/biz/common/download/DownloadDao:a	(Ljava/lang/String;)V
    //   1323: aconst_null
    //   1324: astore 5
    //   1326: iload_3
    //   1327: istore_1
    //   1328: goto -234 -> 1094
    //   1331: astore 5
    //   1333: aload 5
    //   1335: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1338: aload_0
    //   1339: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1342: ldc_w 323
    //   1345: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1348: goto -239 -> 1109
    //   1351: astore 5
    //   1353: aload 5
    //   1355: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1358: aload_0
    //   1359: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1362: ldc_w 330
    //   1365: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1368: goto -249 -> 1119
    //   1371: astore 5
    //   1373: aload 6
    //   1375: astore 7
    //   1377: goto -219 -> 1158
    //   1380: astore 7
    //   1382: aconst_null
    //   1383: astore 6
    //   1385: aconst_null
    //   1386: astore 5
    //   1388: goto -323 -> 1065
    //   1391: astore 7
    //   1393: aload 5
    //   1395: astore 6
    //   1397: aconst_null
    //   1398: astore 5
    //   1400: goto -335 -> 1065
    //   1403: iconst_2
    //   1404: istore_1
    //   1405: goto -311 -> 1094
    //   1408: iconst_0
    //   1409: istore_1
    //   1410: aload 6
    //   1412: astore 5
    //   1414: goto -320 -> 1094
    //   1417: iload_3
    //   1418: istore_2
    //   1419: iconst_0
    //   1420: istore_1
    //   1421: goto -664 -> 757
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1424	0	this	DownloadThread
    //   197	1224	1	i	int
    //   3	1416	2	j	int
    //   5	1413	3	k	int
    //   194	75	4	m	int
    //   145	284	5	localHttpGet1	org.apache.http.client.methods.HttpGet
    //   442	3	5	localMalformedURLException	java.net.MalformedURLException
    //   458	1	5	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   472	1	5	localHttpGet2	org.apache.http.client.methods.HttpGet
    //   477	121	5	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   602	313	5	localObject1	java.lang.Object
    //   922	3	5	localIOException1	java.io.IOException
    //   930	3	5	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   946	3	5	localIOException2	java.io.IOException
    //   962	3	5	localException1	java.lang.Exception
    //   978	3	5	localFileNotFoundException	java.io.FileNotFoundException
    //   994	3	5	localIOException3	java.io.IOException
    //   1015	39	5	localIOException4	java.io.IOException
    //   1059	81	5	localObject2	java.lang.Object
    //   1156	93	5	localObject3	java.lang.Object
    //   1259	1	5	localObject4	java.lang.Object
    //   1264	3	5	localIOException5	java.io.IOException
    //   1275	50	5	localObject5	java.lang.Object
    //   1331	3	5	localException2	java.lang.Exception
    //   1351	3	5	localIOException6	java.io.IOException
    //   1371	1	5	localObject6	java.lang.Object
    //   1386	27	5	localObject7	java.lang.Object
    //   128	1146	6	localObject8	java.lang.Object
    //   1280	3	6	localIOException7	java.io.IOException
    //   1292	82	6	localIOException8	java.io.IOException
    //   1383	28	6	localObject9	java.lang.Object
    //   134	903	7	localObject10	java.lang.Object
    //   1051	15	7	localException3	java.lang.Exception
    //   1132	244	7	localObject11	java.lang.Object
    //   1380	1	7	localException4	java.lang.Exception
    //   1391	1	7	localException5	java.lang.Exception
    //   189	667	8	localObject12	java.lang.Object
    //   1023	7	8	localException6	java.lang.Exception
    //   1055	7	8	localIOException9	java.io.IOException
    //   1128	57	8	localIOException10	java.io.IOException
    //   218	965	9	localObject13	java.lang.Object
    //   742	106	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   117	130	442	java/net/MalformedURLException
    //   136	147	458	java/lang/IllegalArgumentException
    //   460	474	477	java/lang/IllegalArgumentException
    //   914	921	922	java/io/IOException
    //   593	604	930	org/apache/http/client/ClientProtocolException
    //   593	604	946	java/io/IOException
    //   593	604	962	java/lang/Exception
    //   617	636	978	java/io/FileNotFoundException
    //   636	651	994	java/io/IOException
    //   1009	1014	1015	java/io/IOException
    //   890	895	1023	java/lang/Exception
    //   739	744	1051	java/lang/Exception
    //   748	753	1051	java/lang/Exception
    //   761	769	1051	java/lang/Exception
    //   782	791	1051	java/lang/Exception
    //   795	805	1051	java/lang/Exception
    //   809	831	1051	java/lang/Exception
    //   835	843	1051	java/lang/Exception
    //   847	857	1051	java/lang/Exception
    //   861	872	1051	java/lang/Exception
    //   876	886	1051	java/lang/Exception
    //   904	909	1051	java/lang/Exception
    //   1029	1034	1051	java/lang/Exception
    //   1038	1048	1051	java/lang/Exception
    //   1134	1139	1051	java/lang/Exception
    //   1143	1153	1051	java/lang/Exception
    //   1182	1191	1051	java/lang/Exception
    //   1195	1205	1051	java/lang/Exception
    //   1209	1231	1051	java/lang/Exception
    //   1235	1243	1051	java/lang/Exception
    //   904	909	1128	java/io/IOException
    //   713	722	1156	finally
    //   726	735	1156	finally
    //   739	744	1156	finally
    //   748	753	1156	finally
    //   761	769	1156	finally
    //   782	791	1156	finally
    //   795	805	1156	finally
    //   809	831	1156	finally
    //   835	843	1156	finally
    //   847	857	1156	finally
    //   861	872	1156	finally
    //   876	886	1156	finally
    //   890	895	1156	finally
    //   904	909	1156	finally
    //   1029	1034	1156	finally
    //   1038	1048	1156	finally
    //   1134	1139	1156	finally
    //   1143	1153	1156	finally
    //   1182	1191	1156	finally
    //   1195	1205	1156	finally
    //   1209	1231	1156	finally
    //   1235	1243	1156	finally
    //   1248	1255	1264	java/io/IOException
    //   1085	1092	1280	java/io/IOException
    //   1163	1170	1292	java/io/IOException
    //   1104	1109	1331	java/lang/Exception
    //   1114	1119	1351	java/io/IOException
    //   1065	1080	1371	finally
    //   713	722	1380	java/lang/Exception
    //   726	735	1391	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.common.download.Downloader.DownloadThread
 * JD-Core Version:    0.7.0.1
 */