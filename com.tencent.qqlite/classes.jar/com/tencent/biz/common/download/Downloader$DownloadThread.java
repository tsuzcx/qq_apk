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
    //   4: aload_0
    //   5: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokestatic 75	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: aload_0
    //   15: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   18: bipush 21
    //   20: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   23: return
    //   24: aload_0
    //   25: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   28: ifle +59 -> 87
    //   31: aload_0
    //   32: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   35: aload_0
    //   36: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   39: isub
    //   40: aload_0
    //   41: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   44: iconst_1
    //   45: isub
    //   46: if_icmpne +41 -> 87
    //   49: aload_0
    //   50: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   53: iconst_0
    //   54: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   57: aload_0
    //   58: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   61: new 30	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   68: ldc 80
    //   70: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 20	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_Int	I
    //   77: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   86: return
    //   87: aload_0
    //   88: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   91: aload_0
    //   92: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   95: if_icmpge +22 -> 117
    //   98: aload_0
    //   99: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   102: bipush 22
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
    //   128: astore 5
    //   130: aload_0
    //   131: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   134: astore 6
    //   136: new 88	org/apache/http/client/methods/HttpGet
    //   139: dup
    //   140: aload 6
    //   142: invokespecial 89	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   145: astore 4
    //   147: new 91	org/apache/http/params/BasicHttpParams
    //   150: dup
    //   151: invokespecial 92	org/apache/http/params/BasicHttpParams:<init>	()V
    //   154: astore 6
    //   156: aload 6
    //   158: ldc 94
    //   160: ldc 95
    //   162: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   165: invokeinterface 107 3 0
    //   170: pop
    //   171: aload 6
    //   173: ldc 109
    //   175: ldc 95
    //   177: invokestatic 101	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: invokeinterface 107 3 0
    //   185: pop
    //   186: invokestatic 114	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   189: astore 7
    //   191: invokestatic 118	android/net/Proxy:getDefaultPort	()I
    //   194: istore_3
    //   195: iload_2
    //   196: istore_1
    //   197: aload_0
    //   198: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   201: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   204: ifnull +202 -> 406
    //   207: aload_0
    //   208: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   211: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   214: invokevirtual 126	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   217: astore 8
    //   219: aload_0
    //   220: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   223: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   226: invokestatic 129	com/tencent/biz/common/download/Downloader:a	(Landroid/net/NetworkInfo;)Z
    //   229: ifeq +47 -> 276
    //   232: aload 8
    //   234: ifnull +13 -> 247
    //   237: aload 8
    //   239: ldc 131
    //   241: invokevirtual 137	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   244: ifeq +32 -> 276
    //   247: aload 7
    //   249: ifnull +27 -> 276
    //   252: iload_3
    //   253: ifle +23 -> 276
    //   256: aload 6
    //   258: ldc 139
    //   260: new 141	org/apache/http/HttpHost
    //   263: dup
    //   264: aload 7
    //   266: iload_3
    //   267: invokespecial 144	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   270: invokeinterface 107 3 0
    //   275: pop
    //   276: aload_0
    //   277: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   280: getfield 121	com/tencent/biz/common/download/Downloader:jdField_a_of_type_AndroidNetNetworkInfo	Landroid/net/NetworkInfo;
    //   283: invokestatic 129	com/tencent/biz/common/download/Downloader:a	(Landroid/net/NetworkInfo;)Z
    //   286: ifeq +207 -> 493
    //   289: iload_2
    //   290: istore_1
    //   291: aload 6
    //   293: ldc 146
    //   295: iload_1
    //   296: invokeinterface 150 3 0
    //   301: pop
    //   302: aload 4
    //   304: ldc 152
    //   306: new 30	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   313: ldc 154
    //   315: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_0
    //   319: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   322: aload_0
    //   323: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   326: iadd
    //   327: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: ldc 156
    //   332: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   339: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   342: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokevirtual 160	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   348: aload_0
    //   349: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   352: new 30	java/lang/StringBuilder
    //   355: dup
    //   356: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   359: ldc 162
    //   361: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: aload_0
    //   365: getfield 22	com/tencent/biz/common/download/Downloader$DownloadThread:b	I
    //   368: aload_0
    //   369: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   372: iadd
    //   373: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: ldc 156
    //   378: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc 164
    //   383: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_0
    //   387: getfield 24	com/tencent/biz/common/download/Downloader$DownloadThread:c	I
    //   390: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   399: aload 4
    //   401: aload 6
    //   403: invokevirtual 168	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   406: new 141	org/apache/http/HttpHost
    //   409: dup
    //   410: aload 5
    //   412: invokevirtual 171	java/net/URL:getHost	()Ljava/lang/String;
    //   415: invokespecial 172	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   418: astore 5
    //   420: aload 5
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: ifnonnull +73 -> 500
    //   430: aload_0
    //   431: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   434: bipush 25
    //   436: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   439: return
    //   440: astore 4
    //   442: aload 4
    //   444: invokevirtual 175	java/net/MalformedURLException:printStackTrace	()V
    //   447: aload_0
    //   448: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   451: bipush 23
    //   453: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   456: return
    //   457: astore 4
    //   459: new 88	org/apache/http/client/methods/HttpGet
    //   462: dup
    //   463: aload 6
    //   465: invokestatic 178	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokespecial 89	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   471: astore 4
    //   473: goto -326 -> 147
    //   476: astore 4
    //   478: aload 4
    //   480: invokevirtual 179	java/lang/IllegalArgumentException:printStackTrace	()V
    //   483: aload_0
    //   484: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   487: bipush 24
    //   489: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   492: return
    //   493: sipush 4096
    //   496: istore_1
    //   497: goto -206 -> 291
    //   500: new 91	org/apache/http/params/BasicHttpParams
    //   503: dup
    //   504: invokespecial 92	org/apache/http/params/BasicHttpParams:<init>	()V
    //   507: astore 6
    //   509: aload 6
    //   511: getstatic 185	org/apache/http/HttpVersion:HTTP_1_1	Lorg/apache/http/HttpVersion;
    //   514: invokestatic 191	org/apache/http/params/HttpProtocolParams:setVersion	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/ProtocolVersion;)V
    //   517: aload 6
    //   519: ldc 193
    //   521: invokestatic 197	org/apache/http/params/HttpProtocolParams:setContentCharset	(Lorg/apache/http/params/HttpParams;Ljava/lang/String;)V
    //   524: aload 6
    //   526: iconst_1
    //   527: invokestatic 201	org/apache/http/params/HttpProtocolParams:setUseExpectContinue	(Lorg/apache/http/params/HttpParams;Z)V
    //   530: new 203	org/apache/http/conn/scheme/SchemeRegistry
    //   533: dup
    //   534: invokespecial 204	org/apache/http/conn/scheme/SchemeRegistry:<init>	()V
    //   537: astore 7
    //   539: aload 7
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
    //   567: aload 6
    //   569: aload 7
    //   571: invokespecial 228	org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager:<init>	(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V
    //   574: aload 6
    //   576: invokespecial 231	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V
    //   579: astore 6
    //   581: aload 6
    //   583: new 233	org/apache/http/impl/client/DefaultHttpRequestRetryHandler
    //   586: dup
    //   587: invokespecial 234	org/apache/http/impl/client/DefaultHttpRequestRetryHandler:<init>	()V
    //   590: invokevirtual 238	org/apache/http/impl/client/DefaultHttpClient:setHttpRequestRetryHandler	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   593: aload 6
    //   595: aload 5
    //   597: aload 4
    //   599: invokevirtual 242	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   602: astore 4
    //   604: aload 4
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
    //   634: astore 8
    //   636: aload 8
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
    //   707: if_icmpne +609 -> 1316
    //   710: aconst_null
    //   711: astore 6
    //   713: aload 4
    //   715: invokeinterface 273 1 0
    //   720: astore 5
    //   722: aload 5
    //   724: astore 6
    //   726: aload 5
    //   728: invokeinterface 279 1 0
    //   733: astore 4
    //   735: aload 5
    //   737: astore 6
    //   739: iload_1
    //   740: newarray byte
    //   742: astore 9
    //   744: aload 5
    //   746: astore 6
    //   748: iload_1
    //   749: newarray byte
    //   751: astore 7
    //   753: iconst_m1
    //   754: istore_2
    //   755: iconst_1
    //   756: istore_1
    //   757: aload 5
    //   759: astore 6
    //   761: aload 4
    //   763: aload 9
    //   765: invokevirtual 285	java/io/InputStream:read	([B)I
    //   768: istore_3
    //   769: iload_3
    //   770: iconst_m1
    //   771: if_icmpeq +420 -> 1191
    //   774: iload_1
    //   775: ifne +68 -> 843
    //   778: aload 5
    //   780: astore 6
    //   782: aload 8
    //   784: aload 7
    //   786: iconst_0
    //   787: iload_2
    //   788: invokevirtual 289	java/io/RandomAccessFile:write	([BII)V
    //   791: aload 5
    //   793: astore 6
    //   795: aload_0
    //   796: aload_0
    //   797: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   800: iload_2
    //   801: iadd
    //   802: putfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   805: aload 5
    //   807: astore 6
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
    //   833: astore 6
    //   835: aload_0
    //   836: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   839: iload_2
    //   840: invokevirtual 299	com/tencent/biz/common/download/Downloader:b	(I)V
    //   843: aload 5
    //   845: astore 6
    //   847: aload 9
    //   849: invokevirtual 305	[B:clone	()Ljava/lang/Object;
    //   852: checkcast 301	[B
    //   855: astore 7
    //   857: aload 5
    //   859: astore 6
    //   861: iconst_3
    //   862: aload_0
    //   863: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   866: getfield 308	com/tencent/biz/common/download/Downloader:z	I
    //   869: if_icmpne +550 -> 1419
    //   872: aload 5
    //   874: astore 6
    //   876: aload_0
    //   877: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   880: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   883: invokevirtual 310	com/tencent/biz/common/download/DownloadDao:a	()V
    //   886: aload 5
    //   888: astore 6
    //   890: aload 4
    //   892: invokevirtual 313	java/io/InputStream:close	()V
    //   895: aload 8
    //   897: ifnull +12 -> 909
    //   900: aload 5
    //   902: astore 6
    //   904: aload 8
    //   906: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   909: aload 5
    //   911: ifnull -888 -> 23
    //   914: aload 5
    //   916: invokeinterface 317 1 0
    //   921: return
    //   922: astore 4
    //   924: aload 4
    //   926: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   929: return
    //   930: astore 4
    //   932: aload 4
    //   934: invokevirtual 319	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   937: aload_0
    //   938: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   941: bipush 26
    //   943: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   946: return
    //   947: astore 4
    //   949: aload 4
    //   951: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   954: aload_0
    //   955: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   958: bipush 26
    //   960: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   963: return
    //   964: astore 4
    //   966: aload 4
    //   968: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   971: aload_0
    //   972: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   975: bipush 26
    //   977: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   980: return
    //   981: astore 4
    //   983: aload 4
    //   985: invokevirtual 321	java/io/FileNotFoundException:printStackTrace	()V
    //   988: aload_0
    //   989: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   992: bipush 27
    //   994: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   997: return
    //   998: astore 4
    //   1000: aload 4
    //   1002: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1005: aload_0
    //   1006: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1009: bipush 28
    //   1011: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   1014: aload 8
    //   1016: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   1019: return
    //   1020: astore 4
    //   1022: aload 4
    //   1024: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1027: return
    //   1028: astore 7
    //   1030: aload 5
    //   1032: astore 6
    //   1034: aload 7
    //   1036: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1039: aload 5
    //   1041: astore 6
    //   1043: aload_0
    //   1044: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1047: ldc_w 323
    //   1050: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1053: goto -158 -> 895
    //   1056: astore 7
    //   1058: aload 5
    //   1060: astore 6
    //   1062: aload 4
    //   1064: astore 5
    //   1066: aload 7
    //   1068: astore 4
    //   1070: aload 4
    //   1072: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1075: aload_0
    //   1076: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1079: ldc_w 325
    //   1082: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1085: bipush 29
    //   1087: istore_2
    //   1088: iload_2
    //   1089: istore_1
    //   1090: aload 5
    //   1092: astore 4
    //   1094: aload 6
    //   1096: ifnull +16 -> 1112
    //   1099: aload 6
    //   1101: invokeinterface 317 1 0
    //   1106: aload 5
    //   1108: astore 4
    //   1110: iload_2
    //   1111: istore_1
    //   1112: aload_0
    //   1113: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1116: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1119: invokevirtual 310	com/tencent/biz/common/download/DownloadDao:a	()V
    //   1122: aload 4
    //   1124: invokevirtual 313	java/io/InputStream:close	()V
    //   1127: aload 8
    //   1129: ifnull +8 -> 1137
    //   1132: aload 8
    //   1134: invokevirtual 314	java/io/RandomAccessFile:close	()V
    //   1137: aload_0
    //   1138: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1141: iload_1
    //   1142: invokevirtual 78	com/tencent/biz/common/download/Downloader:c	(I)V
    //   1145: return
    //   1146: astore 7
    //   1148: aload 5
    //   1150: astore 6
    //   1152: aload 7
    //   1154: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1157: aload 5
    //   1159: astore 6
    //   1161: aload_0
    //   1162: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1165: ldc_w 327
    //   1168: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1171: goto -262 -> 909
    //   1174: astore 4
    //   1176: aload 6
    //   1178: ifnull +10 -> 1188
    //   1181: aload 6
    //   1183: invokeinterface 317 1 0
    //   1188: aload 4
    //   1190: athrow
    //   1191: iload_2
    //   1192: iconst_m1
    //   1193: if_icmpeq +68 -> 1261
    //   1196: aload 5
    //   1198: astore 6
    //   1200: aload 8
    //   1202: aload 7
    //   1204: iconst_0
    //   1205: iload_2
    //   1206: invokevirtual 289	java/io/RandomAccessFile:write	([BII)V
    //   1209: aload 5
    //   1211: astore 6
    //   1213: aload_0
    //   1214: aload_0
    //   1215: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1218: iload_2
    //   1219: iadd
    //   1220: putfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1223: aload 5
    //   1225: astore 6
    //   1227: aload_0
    //   1228: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1231: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1234: aload_0
    //   1235: getfield 20	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_Int	I
    //   1238: aload_0
    //   1239: getfield 26	com/tencent/biz/common/download/Downloader$DownloadThread:d	I
    //   1242: aload_0
    //   1243: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1246: invokevirtual 297	com/tencent/biz/common/download/DownloadDao:a	(IILjava/lang/String;)V
    //   1249: aload 5
    //   1251: astore 6
    //   1253: aload_0
    //   1254: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1257: iload_2
    //   1258: invokevirtual 299	com/tencent/biz/common/download/Downloader:b	(I)V
    //   1261: aload 5
    //   1263: ifnull +151 -> 1414
    //   1266: aload 5
    //   1268: invokeinterface 317 1 0
    //   1273: iconst_0
    //   1274: istore_1
    //   1275: goto -163 -> 1112
    //   1278: astore 5
    //   1280: aload 5
    //   1282: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1285: iconst_0
    //   1286: istore_1
    //   1287: goto -175 -> 1112
    //   1290: astore 4
    //   1292: aload 4
    //   1294: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1297: iload_2
    //   1298: istore_1
    //   1299: aload 5
    //   1301: astore 4
    //   1303: goto -191 -> 1112
    //   1306: astore 5
    //   1308: aload 5
    //   1310: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1313: goto -125 -> 1188
    //   1316: sipush 404
    //   1319: iload_2
    //   1320: if_icmpne +17 -> 1337
    //   1323: aload_0
    //   1324: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1327: getfield 292	com/tencent/biz/common/download/Downloader:jdField_a_of_type_ComTencentBizCommonDownloadDownloadDao	Lcom/tencent/biz/common/download/DownloadDao;
    //   1330: aload_0
    //   1331: getfield 28	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1334: invokevirtual 328	com/tencent/biz/common/download/DownloadDao:a	(Ljava/lang/String;)V
    //   1337: bipush 30
    //   1339: istore_1
    //   1340: aconst_null
    //   1341: astore 4
    //   1343: goto -231 -> 1112
    //   1346: astore 4
    //   1348: aload 4
    //   1350: invokevirtual 320	java/lang/Exception:printStackTrace	()V
    //   1353: aload_0
    //   1354: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1357: ldc_w 323
    //   1360: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1363: goto -236 -> 1127
    //   1366: astore 4
    //   1368: aload 4
    //   1370: invokevirtual 318	java/io/IOException:printStackTrace	()V
    //   1373: aload_0
    //   1374: getfield 15	com/tencent/biz/common/download/Downloader$DownloadThread:jdField_a_of_type_ComTencentBizCommonDownloadDownloader	Lcom/tencent/biz/common/download/Downloader;
    //   1377: ldc_w 330
    //   1380: invokevirtual 55	com/tencent/biz/common/download/Downloader:a	(Ljava/lang/String;)V
    //   1383: goto -246 -> 1137
    //   1386: astore 4
    //   1388: goto -212 -> 1176
    //   1391: astore 4
    //   1393: aconst_null
    //   1394: astore 6
    //   1396: aconst_null
    //   1397: astore 5
    //   1399: goto -329 -> 1070
    //   1402: astore 4
    //   1404: aload 5
    //   1406: astore 6
    //   1408: aconst_null
    //   1409: astore 5
    //   1411: goto -341 -> 1070
    //   1414: iconst_0
    //   1415: istore_1
    //   1416: goto -304 -> 1112
    //   1419: iload_3
    //   1420: istore_2
    //   1421: iconst_0
    //   1422: istore_1
    //   1423: goto -666 -> 757
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1426	0	this	DownloadThread
    //   196	1227	1	i	int
    //   3	1418	2	j	int
    //   194	1226	3	k	int
    //   145	281	4	localHttpGet1	org.apache.http.client.methods.HttpGet
    //   440	3	4	localMalformedURLException	java.net.MalformedURLException
    //   457	1	4	localIllegalArgumentException1	java.lang.IllegalArgumentException
    //   471	1	4	localHttpGet2	org.apache.http.client.methods.HttpGet
    //   476	122	4	localIllegalArgumentException2	java.lang.IllegalArgumentException
    //   602	289	4	localObject1	java.lang.Object
    //   922	3	4	localIOException1	java.io.IOException
    //   930	3	4	localClientProtocolException	org.apache.http.client.ClientProtocolException
    //   947	3	4	localIOException2	java.io.IOException
    //   964	3	4	localException1	java.lang.Exception
    //   981	3	4	localFileNotFoundException	java.io.FileNotFoundException
    //   998	3	4	localIOException3	java.io.IOException
    //   1020	43	4	localIOException4	java.io.IOException
    //   1068	55	4	localObject2	java.lang.Object
    //   1174	15	4	localObject3	java.lang.Object
    //   1290	3	4	localIOException5	java.io.IOException
    //   1301	41	4	localIOException6	java.io.IOException
    //   1346	3	4	localException2	java.lang.Exception
    //   1366	3	4	localIOException7	java.io.IOException
    //   1386	1	4	localObject4	java.lang.Object
    //   1391	1	4	localException3	java.lang.Exception
    //   1402	1	4	localException4	java.lang.Exception
    //   128	1139	5	localObject5	java.lang.Object
    //   1278	22	5	localIOException8	java.io.IOException
    //   1306	3	5	localIOException9	java.io.IOException
    //   1397	13	5	localObject6	java.lang.Object
    //   134	1273	6	localObject7	java.lang.Object
    //   189	667	7	localObject8	java.lang.Object
    //   1028	7	7	localException5	java.lang.Exception
    //   1056	11	7	localException6	java.lang.Exception
    //   1146	57	7	localIOException10	java.io.IOException
    //   217	984	8	localObject9	java.lang.Object
    //   742	106	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   117	130	440	java/net/MalformedURLException
    //   136	147	457	java/lang/IllegalArgumentException
    //   459	473	476	java/lang/IllegalArgumentException
    //   914	921	922	java/io/IOException
    //   593	604	930	org/apache/http/client/ClientProtocolException
    //   593	604	947	java/io/IOException
    //   593	604	964	java/lang/Exception
    //   617	636	981	java/io/FileNotFoundException
    //   636	651	998	java/io/IOException
    //   1014	1019	1020	java/io/IOException
    //   890	895	1028	java/lang/Exception
    //   739	744	1056	java/lang/Exception
    //   748	753	1056	java/lang/Exception
    //   761	769	1056	java/lang/Exception
    //   782	791	1056	java/lang/Exception
    //   795	805	1056	java/lang/Exception
    //   809	831	1056	java/lang/Exception
    //   835	843	1056	java/lang/Exception
    //   847	857	1056	java/lang/Exception
    //   861	872	1056	java/lang/Exception
    //   876	886	1056	java/lang/Exception
    //   904	909	1056	java/lang/Exception
    //   1034	1039	1056	java/lang/Exception
    //   1043	1053	1056	java/lang/Exception
    //   1152	1157	1056	java/lang/Exception
    //   1161	1171	1056	java/lang/Exception
    //   1200	1209	1056	java/lang/Exception
    //   1213	1223	1056	java/lang/Exception
    //   1227	1249	1056	java/lang/Exception
    //   1253	1261	1056	java/lang/Exception
    //   904	909	1146	java/io/IOException
    //   713	722	1174	finally
    //   726	735	1174	finally
    //   739	744	1174	finally
    //   748	753	1174	finally
    //   761	769	1174	finally
    //   782	791	1174	finally
    //   795	805	1174	finally
    //   809	831	1174	finally
    //   835	843	1174	finally
    //   847	857	1174	finally
    //   861	872	1174	finally
    //   876	886	1174	finally
    //   890	895	1174	finally
    //   904	909	1174	finally
    //   1034	1039	1174	finally
    //   1043	1053	1174	finally
    //   1152	1157	1174	finally
    //   1161	1171	1174	finally
    //   1200	1209	1174	finally
    //   1213	1223	1174	finally
    //   1227	1249	1174	finally
    //   1253	1261	1174	finally
    //   1266	1273	1278	java/io/IOException
    //   1099	1106	1290	java/io/IOException
    //   1181	1188	1306	java/io/IOException
    //   1122	1127	1346	java/lang/Exception
    //   1132	1137	1366	java/io/IOException
    //   1070	1085	1386	finally
    //   713	722	1391	java/lang/Exception
    //   726	735	1402	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.common.download.Downloader.DownloadThread
 * JD-Core Version:    0.7.0.1
 */