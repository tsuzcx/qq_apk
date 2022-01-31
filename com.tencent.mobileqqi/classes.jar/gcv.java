import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class gcv
  extends Thread
{
  public int a;
  public String a;
  public volatile boolean a;
  public int b;
  public String b;
  public volatile boolean b;
  private int c;
  public volatile boolean c;
  public volatile boolean d = true;
  
  public gcv(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    setName("QQPlayerService-DownloadThread");
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Int = paramInt1;
  }
  
  private File a(String paramString)
  {
    File localFile = new File(QQPlayerService.b());
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString = new File(QQPlayerService.b() + "/" + paramString);
    if (!paramString.exists()) {}
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QQPlayerService", 2, "createNewFile:" + localIOException.getMessage(), localIOException);
    }
    return paramString;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: invokestatic 109	com/tencent/mobileqq/utils/DeviceInfoUtil:b	()[J
    //   6: astore 4
    //   8: aload 4
    //   10: ifnull +39 -> 49
    //   13: aload 4
    //   15: iconst_1
    //   16: laload
    //   17: ldc2_w 110
    //   20: lcmp
    //   21: ifgt +28 -> 49
    //   24: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 85
    //   32: iconst_2
    //   33: ldc 113
    //   35: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: aload_0
    //   39: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   42: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   45: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   48: return
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 125	gcv:a	(Ljava/lang/String;)Ljava/io/File;
    //   57: astore 8
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   64: new 127	java/io/RandomAccessFile
    //   67: dup
    //   68: aload 8
    //   70: ldc 129
    //   72: invokespecial 132	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   75: astore 5
    //   77: aload 5
    //   79: astore 4
    //   81: new 134	java/net/URL
    //   84: dup
    //   85: aload_0
    //   86: getfield 35	gcv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   92: astore 9
    //   94: aload 5
    //   96: astore 4
    //   98: invokestatic 138	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   101: getfield 141	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   104: aload_0
    //   105: getfield 35	gcv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   108: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   111: ifeq +2347 -> 2458
    //   114: aload 5
    //   116: astore 4
    //   118: aload_0
    //   119: getfield 27	gcv:d	Z
    //   122: ifeq +2336 -> 2458
    //   125: aload 5
    //   127: astore 4
    //   129: aload_0
    //   130: getfield 43	gcv:jdField_a_of_type_Int	I
    //   133: aload_0
    //   134: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   137: getfield 150	com/tencent/mobileqq/music/QQPlayerService:s	I
    //   140: if_icmple +336 -> 476
    //   143: aload 5
    //   145: astore 4
    //   147: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +15 -> 165
    //   153: aload 5
    //   155: astore 4
    //   157: ldc 85
    //   159: iconst_2
    //   160: ldc 152
    //   162: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: aload 5
    //   167: astore 4
    //   169: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   172: invokevirtual 160	android/media/MediaPlayer:reset	()V
    //   175: aload 5
    //   177: astore 4
    //   179: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   182: aload 8
    //   184: invokevirtual 163	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   187: invokevirtual 166	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   190: aload 5
    //   192: astore 4
    //   194: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   197: invokevirtual 169	android/media/MediaPlayer:prepare	()V
    //   200: aload 5
    //   202: astore 4
    //   204: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   207: invokevirtual 172	android/media/MediaPlayer:start	()V
    //   210: aload 5
    //   212: astore 4
    //   214: aload_0
    //   215: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   218: iconst_2
    //   219: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   222: aload 5
    //   224: astore 4
    //   226: aload_0
    //   227: iconst_0
    //   228: putfield 27	gcv:d	Z
    //   231: goto +2227 -> 2458
    //   234: iload_1
    //   235: istore_2
    //   236: aload 4
    //   238: astore 6
    //   240: iload_1
    //   241: ifgt +147 -> 388
    //   244: iload_1
    //   245: istore_2
    //   246: aload 4
    //   248: astore 6
    //   250: iload_3
    //   251: iconst_5
    //   252: if_icmpgt +136 -> 388
    //   255: aload 5
    //   257: astore 4
    //   259: aload 9
    //   261: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   264: checkcast 181	java/net/HttpURLConnection
    //   267: astore 6
    //   269: aload 5
    //   271: astore 4
    //   273: aload 6
    //   275: iconst_1
    //   276: invokevirtual 185	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   279: aload 5
    //   281: astore 4
    //   283: aload 6
    //   285: ldc 187
    //   287: ldc 189
    //   289: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   292: aload 5
    //   294: astore 4
    //   296: aload_0
    //   297: getfield 39	gcv:jdField_c_of_type_Int	I
    //   300: ifeq +63 -> 363
    //   303: aload 5
    //   305: astore 4
    //   307: aload_0
    //   308: getfield 39	gcv:jdField_c_of_type_Int	I
    //   311: aload_0
    //   312: getfield 43	gcv:jdField_a_of_type_Int	I
    //   315: if_icmple +48 -> 363
    //   318: aload 5
    //   320: astore 4
    //   322: aload 6
    //   324: ldc 195
    //   326: new 65	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   333: ldc 197
    //   335: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_0
    //   339: getfield 43	gcv:jdField_a_of_type_Int	I
    //   342: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc 202
    //   347: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_0
    //   351: getfield 39	gcv:jdField_c_of_type_Int	I
    //   354: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: aload 5
    //   365: astore 4
    //   367: aload 6
    //   369: invokevirtual 205	java/net/HttpURLConnection:connect	()V
    //   372: aload 5
    //   374: astore 4
    //   376: aload 6
    //   378: invokevirtual 209	java/net/HttpURLConnection:getContentLength	()I
    //   381: istore_1
    //   382: iload_1
    //   383: ifle +269 -> 652
    //   386: iload_1
    //   387: istore_2
    //   388: iload_2
    //   389: ifgt +334 -> 723
    //   392: aload 5
    //   394: astore 4
    //   396: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq +15 -> 414
    //   402: aload 5
    //   404: astore 4
    //   406: ldc 85
    //   408: iconst_2
    //   409: ldc 211
    //   411: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aload 5
    //   416: astore 4
    //   418: aload_0
    //   419: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   422: bipush 7
    //   424: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   427: aload_0
    //   428: iconst_0
    //   429: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   432: aload 5
    //   434: ifnull +8 -> 442
    //   437: aload 5
    //   439: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   442: aload_0
    //   443: getfield 43	gcv:jdField_a_of_type_Int	I
    //   446: aload_0
    //   447: getfield 41	gcv:jdField_b_of_type_Int	I
    //   450: if_icmpge -402 -> 48
    //   453: aload_0
    //   454: getfield 41	gcv:jdField_b_of_type_Int	I
    //   457: ifle -409 -> 48
    //   460: aload_0
    //   461: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   464: aload_0
    //   465: getfield 43	gcv:jdField_a_of_type_Int	I
    //   468: aload_0
    //   469: getfield 41	gcv:jdField_b_of_type_Int	I
    //   472: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   475: return
    //   476: aload 5
    //   478: astore 4
    //   480: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +15 -> 498
    //   486: aload 5
    //   488: astore 4
    //   490: ldc 85
    //   492: iconst_2
    //   493: ldc 224
    //   495: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   498: aload 5
    //   500: astore 4
    //   502: aload_0
    //   503: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   506: iconst_1
    //   507: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   510: goto +1948 -> 2458
    //   513: astore 6
    //   515: aload 5
    //   517: astore 4
    //   519: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +38 -> 560
    //   525: aload 5
    //   527: astore 4
    //   529: ldc 85
    //   531: iconst_2
    //   532: new 65	java/lang/StringBuilder
    //   535: dup
    //   536: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   539: ldc 226
    //   541: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: aload 6
    //   546: invokevirtual 227	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   555: aload 6
    //   557: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 5
    //   562: astore 4
    //   564: aload_0
    //   565: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   568: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   571: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   574: aload_0
    //   575: iconst_0
    //   576: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   579: aload 5
    //   581: ifnull +8 -> 589
    //   584: aload 5
    //   586: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   589: aload_0
    //   590: getfield 43	gcv:jdField_a_of_type_Int	I
    //   593: aload_0
    //   594: getfield 41	gcv:jdField_b_of_type_Int	I
    //   597: if_icmpge +25 -> 622
    //   600: aload_0
    //   601: getfield 41	gcv:jdField_b_of_type_Int	I
    //   604: ifle +18 -> 622
    //   607: aload_0
    //   608: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   611: aload_0
    //   612: getfield 43	gcv:jdField_a_of_type_Int	I
    //   615: aload_0
    //   616: getfield 41	gcv:jdField_b_of_type_Int	I
    //   619: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   622: aload_0
    //   623: getfield 23	gcv:jdField_b_of_type_Boolean	Z
    //   626: ifeq +6 -> 632
    //   629: invokestatic 229	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   632: aload_0
    //   633: iconst_0
    //   634: putfield 23	gcv:jdField_b_of_type_Boolean	Z
    //   637: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq -592 -> 48
    //   643: ldc 85
    //   645: iconst_2
    //   646: ldc 231
    //   648: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: return
    //   652: iload_3
    //   653: iconst_1
    //   654: iadd
    //   655: istore_3
    //   656: aload 5
    //   658: astore 4
    //   660: ldc2_w 232
    //   663: invokestatic 237	java/lang/Thread:sleep	(J)V
    //   666: aload 6
    //   668: astore 4
    //   670: goto -436 -> 234
    //   673: astore 7
    //   675: aload 5
    //   677: astore 4
    //   679: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   682: ifeq +1787 -> 2469
    //   685: aload 5
    //   687: astore 4
    //   689: ldc 85
    //   691: iconst_2
    //   692: new 65	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   699: ldc 239
    //   701: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: aload 7
    //   706: invokevirtual 240	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   709: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   715: aload 7
    //   717: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   720: goto +1749 -> 2469
    //   723: iload_2
    //   724: istore_1
    //   725: aload 5
    //   727: astore 4
    //   729: aload_0
    //   730: getfield 43	gcv:jdField_a_of_type_Int	I
    //   733: ifle +14 -> 747
    //   736: aload 5
    //   738: astore 4
    //   740: iload_2
    //   741: aload_0
    //   742: getfield 43	gcv:jdField_a_of_type_Int	I
    //   745: iadd
    //   746: istore_1
    //   747: aload 5
    //   749: astore 4
    //   751: aload_0
    //   752: iload_1
    //   753: putfield 41	gcv:jdField_b_of_type_Int	I
    //   756: iload_1
    //   757: istore_2
    //   758: aload 6
    //   760: astore 7
    //   762: aload 5
    //   764: astore 4
    //   766: aload_0
    //   767: getfield 39	gcv:jdField_c_of_type_Int	I
    //   770: ifeq +243 -> 1013
    //   773: iload_1
    //   774: istore_2
    //   775: aload 6
    //   777: astore 7
    //   779: aload 5
    //   781: astore 4
    //   783: aload_0
    //   784: getfield 39	gcv:jdField_c_of_type_Int	I
    //   787: iload_1
    //   788: if_icmpeq +225 -> 1013
    //   791: aload 5
    //   793: astore 4
    //   795: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   798: ifeq +44 -> 842
    //   801: aload 5
    //   803: astore 4
    //   805: ldc 85
    //   807: iconst_2
    //   808: new 65	java/lang/StringBuilder
    //   811: dup
    //   812: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   815: ldc 242
    //   817: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   820: aload_0
    //   821: getfield 39	gcv:jdField_c_of_type_Int	I
    //   824: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   827: ldc 244
    //   829: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: iload_1
    //   833: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   836: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   839: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: aload 5
    //   844: astore 4
    //   846: aload_0
    //   847: iconst_0
    //   848: putfield 43	gcv:jdField_a_of_type_Int	I
    //   851: aload 5
    //   853: astore 4
    //   855: aload_0
    //   856: iconst_1
    //   857: putfield 27	gcv:d	Z
    //   860: aload 5
    //   862: astore 4
    //   864: aload 9
    //   866: invokevirtual 179	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   869: checkcast 181	java/net/HttpURLConnection
    //   872: astore 7
    //   874: aload 5
    //   876: astore 4
    //   878: aload 7
    //   880: iconst_1
    //   881: invokevirtual 185	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   884: aload 5
    //   886: astore 4
    //   888: aload 7
    //   890: ldc 187
    //   892: ldc 189
    //   894: invokevirtual 193	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   897: aload 5
    //   899: astore 4
    //   901: aload 7
    //   903: invokevirtual 205	java/net/HttpURLConnection:connect	()V
    //   906: aload 5
    //   908: astore 4
    //   910: aload 7
    //   912: invokevirtual 209	java/net/HttpURLConnection:getContentLength	()I
    //   915: istore_2
    //   916: iload_2
    //   917: ifge +87 -> 1004
    //   920: aload 5
    //   922: astore 4
    //   924: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   927: ifeq +15 -> 942
    //   930: aload 5
    //   932: astore 4
    //   934: ldc 85
    //   936: iconst_2
    //   937: ldc 246
    //   939: invokestatic 214	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   942: aload 5
    //   944: astore 4
    //   946: aload_0
    //   947: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   950: bipush 7
    //   952: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   955: aload_0
    //   956: iconst_0
    //   957: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   960: aload 5
    //   962: ifnull +8 -> 970
    //   965: aload 5
    //   967: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   970: aload_0
    //   971: getfield 43	gcv:jdField_a_of_type_Int	I
    //   974: aload_0
    //   975: getfield 41	gcv:jdField_b_of_type_Int	I
    //   978: if_icmpge -930 -> 48
    //   981: aload_0
    //   982: getfield 41	gcv:jdField_b_of_type_Int	I
    //   985: ifle -937 -> 48
    //   988: aload_0
    //   989: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   992: aload_0
    //   993: getfield 43	gcv:jdField_a_of_type_Int	I
    //   996: aload_0
    //   997: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1000: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1003: return
    //   1004: aload 5
    //   1006: astore 4
    //   1008: aload_0
    //   1009: iload_2
    //   1010: putfield 41	gcv:jdField_b_of_type_Int	I
    //   1013: aload 5
    //   1015: astore 4
    //   1017: aload 5
    //   1019: iload_2
    //   1020: i2l
    //   1021: invokevirtual 249	java/io/RandomAccessFile:setLength	(J)V
    //   1024: aload 5
    //   1026: astore 4
    //   1028: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1031: ifeq +59 -> 1090
    //   1034: aload 5
    //   1036: astore 4
    //   1038: ldc 85
    //   1040: iconst_2
    //   1041: new 65	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1048: ldc 251
    //   1050: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_0
    //   1054: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1057: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1060: ldc 253
    //   1062: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload_0
    //   1066: getfield 39	gcv:jdField_c_of_type_Int	I
    //   1069: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1072: ldc 255
    //   1074: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload_0
    //   1078: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1081: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: aload 5
    //   1092: astore 4
    //   1094: aload 7
    //   1096: invokevirtual 259	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1099: astore 6
    //   1101: aload 5
    //   1103: astore 4
    //   1105: sipush 8192
    //   1108: newarray byte
    //   1110: astore 7
    //   1112: aload 5
    //   1114: astore 4
    //   1116: aload 5
    //   1118: aload_0
    //   1119: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1122: i2l
    //   1123: invokevirtual 262	java/io/RandomAccessFile:seek	(J)V
    //   1126: aload 5
    //   1128: astore 4
    //   1130: aload_0
    //   1131: getfield 39	gcv:jdField_c_of_type_Int	I
    //   1134: ifne +22 -> 1156
    //   1137: aload 5
    //   1139: astore 4
    //   1141: aload_0
    //   1142: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1145: aload_0
    //   1146: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1149: aload_0
    //   1150: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1153: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1156: aload 5
    //   1158: astore 4
    //   1160: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1163: ifeq +1313 -> 2476
    //   1166: aload 5
    //   1168: astore 4
    //   1170: ldc 85
    //   1172: iconst_2
    //   1173: new 65	java/lang/StringBuilder
    //   1176: dup
    //   1177: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1180: ldc_w 264
    //   1183: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: aload_0
    //   1187: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1190: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1193: ldc 255
    //   1195: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1198: aload_0
    //   1199: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1202: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1205: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1208: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1211: goto +1265 -> 2476
    //   1214: aload 5
    //   1216: astore 4
    //   1218: aload_0
    //   1219: getfield 21	gcv:jdField_a_of_type_Boolean	Z
    //   1222: ifne +464 -> 1686
    //   1225: aload 5
    //   1227: astore 4
    //   1229: aload_0
    //   1230: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1233: aload_0
    //   1234: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1237: if_icmpge +449 -> 1686
    //   1240: iload_1
    //   1241: bipush 10
    //   1243: if_icmpge +443 -> 1686
    //   1246: aload 5
    //   1248: astore 4
    //   1250: aload_0
    //   1251: getfield 27	gcv:d	Z
    //   1254: ifeq +180 -> 1434
    //   1257: aload 5
    //   1259: astore 4
    //   1261: invokestatic 138	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1264: getfield 141	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1267: aload_0
    //   1268: getfield 35	gcv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1271: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1274: ifeq +160 -> 1434
    //   1277: aload 5
    //   1279: astore 4
    //   1281: aload_0
    //   1282: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1285: aload_0
    //   1286: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1289: getfield 150	com/tencent/mobileqq/music/QQPlayerService:s	I
    //   1292: if_icmple +142 -> 1434
    //   1295: aload 5
    //   1297: astore 4
    //   1299: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1302: invokevirtual 160	android/media/MediaPlayer:reset	()V
    //   1305: aload 5
    //   1307: astore 4
    //   1309: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1312: aload 8
    //   1314: invokevirtual 163	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1317: invokevirtual 166	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1320: aload 5
    //   1322: astore 4
    //   1324: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1327: invokevirtual 169	android/media/MediaPlayer:prepare	()V
    //   1330: aload 5
    //   1332: astore 4
    //   1334: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1337: ifeq +52 -> 1389
    //   1340: aload 5
    //   1342: astore 4
    //   1344: ldc 85
    //   1346: iconst_2
    //   1347: new 65	java/lang/StringBuilder
    //   1350: dup
    //   1351: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1354: ldc_w 266
    //   1357: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: aload_0
    //   1361: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1364: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1367: ldc_w 268
    //   1370: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: aload_0
    //   1374: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1377: invokestatic 271	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1380: invokevirtual 274	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1383: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1386: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1389: aload 5
    //   1391: astore 4
    //   1393: aload_0
    //   1394: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1397: invokestatic 271	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1400: ifne +25 -> 1425
    //   1403: aload 5
    //   1405: astore 4
    //   1407: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1410: invokevirtual 172	android/media/MediaPlayer:start	()V
    //   1413: aload 5
    //   1415: astore 4
    //   1417: aload_0
    //   1418: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1421: iconst_2
    //   1422: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1425: aload 5
    //   1427: astore 4
    //   1429: aload_0
    //   1430: iconst_0
    //   1431: putfield 27	gcv:d	Z
    //   1434: aload 5
    //   1436: astore 4
    //   1438: aload 6
    //   1440: aload 7
    //   1442: invokevirtual 280	java/io/InputStream:read	([B)I
    //   1445: istore_2
    //   1446: iload_2
    //   1447: ifgt +207 -> 1654
    //   1450: aload 5
    //   1452: astore 4
    //   1454: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1457: ifeq +16 -> 1473
    //   1460: aload 5
    //   1462: astore 4
    //   1464: ldc 85
    //   1466: iconst_2
    //   1467: ldc_w 282
    //   1470: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1473: aload 5
    //   1475: astore 4
    //   1477: ldc2_w 232
    //   1480: invokestatic 237	java/lang/Thread:sleep	(J)V
    //   1483: iload_1
    //   1484: iconst_1
    //   1485: iadd
    //   1486: istore_1
    //   1487: goto -273 -> 1214
    //   1490: astore 9
    //   1492: aload 5
    //   1494: astore 4
    //   1496: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1499: ifeq -16 -> 1483
    //   1502: aload 5
    //   1504: astore 4
    //   1506: ldc 85
    //   1508: iconst_2
    //   1509: new 65	java/lang/StringBuilder
    //   1512: dup
    //   1513: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1516: ldc_w 284
    //   1519: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1522: aload 9
    //   1524: invokevirtual 240	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1527: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1530: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1533: aload 9
    //   1535: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1538: goto -55 -> 1483
    //   1541: astore 6
    //   1543: aload 5
    //   1545: astore 4
    //   1547: aload_0
    //   1548: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1551: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1554: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1557: aload 5
    //   1559: astore 4
    //   1561: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1564: ifeq +39 -> 1603
    //   1567: aload 5
    //   1569: astore 4
    //   1571: ldc 85
    //   1573: iconst_2
    //   1574: new 65	java/lang/StringBuilder
    //   1577: dup
    //   1578: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1581: ldc_w 286
    //   1584: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1587: aload 6
    //   1589: invokevirtual 287	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1592: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1595: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1598: aload 6
    //   1600: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1603: aload_0
    //   1604: iconst_0
    //   1605: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   1608: aload 5
    //   1610: ifnull +8 -> 1618
    //   1613: aload 5
    //   1615: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   1618: aload_0
    //   1619: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1622: aload_0
    //   1623: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1626: if_icmpge -1004 -> 622
    //   1629: aload_0
    //   1630: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1633: ifle -1011 -> 622
    //   1636: aload_0
    //   1637: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1640: aload_0
    //   1641: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1644: aload_0
    //   1645: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1648: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1651: goto -1029 -> 622
    //   1654: aload 5
    //   1656: astore 4
    //   1658: aload_0
    //   1659: aload_0
    //   1660: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1663: iload_2
    //   1664: iadd
    //   1665: putfield 43	gcv:jdField_a_of_type_Int	I
    //   1668: aload 5
    //   1670: astore 4
    //   1672: aload 5
    //   1674: aload 7
    //   1676: iconst_0
    //   1677: iload_2
    //   1678: invokevirtual 291	java/io/RandomAccessFile:write	([BII)V
    //   1681: iconst_0
    //   1682: istore_1
    //   1683: goto -469 -> 1214
    //   1686: aload 5
    //   1688: astore 4
    //   1690: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1693: ifeq +70 -> 1763
    //   1696: aload 5
    //   1698: astore 4
    //   1700: ldc 85
    //   1702: iconst_2
    //   1703: new 65	java/lang/StringBuilder
    //   1706: dup
    //   1707: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1710: ldc_w 293
    //   1713: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: aload_0
    //   1717: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1720: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1723: ldc_w 295
    //   1726: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1729: iload_1
    //   1730: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1733: ldc 255
    //   1735: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: aload_0
    //   1739: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1742: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1745: ldc 253
    //   1747: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: aload_0
    //   1751: getfield 39	gcv:jdField_c_of_type_Int	I
    //   1754: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1757: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1760: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1763: aload 6
    //   1765: ifnull +12 -> 1777
    //   1768: aload 5
    //   1770: astore 4
    //   1772: aload 6
    //   1774: invokevirtual 296	java/io/InputStream:close	()V
    //   1777: aload 5
    //   1779: astore 4
    //   1781: aload_0
    //   1782: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1785: aload_0
    //   1786: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1789: if_icmpne +25 -> 1814
    //   1792: aload 5
    //   1794: astore 4
    //   1796: aload_0
    //   1797: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1800: ifle +14 -> 1814
    //   1803: aload 5
    //   1805: astore 4
    //   1807: aload_0
    //   1808: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1811: invokestatic 298	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   1814: aload_0
    //   1815: iconst_0
    //   1816: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   1819: aload 5
    //   1821: ifnull +8 -> 1829
    //   1824: aload 5
    //   1826: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   1829: aload_0
    //   1830: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1833: aload_0
    //   1834: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1837: if_icmpge -1215 -> 622
    //   1840: aload_0
    //   1841: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1844: ifle -1222 -> 622
    //   1847: aload_0
    //   1848: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1851: aload_0
    //   1852: getfield 43	gcv:jdField_a_of_type_Int	I
    //   1855: aload_0
    //   1856: getfield 41	gcv:jdField_b_of_type_Int	I
    //   1859: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1862: goto -1240 -> 622
    //   1865: astore 6
    //   1867: aconst_null
    //   1868: astore 5
    //   1870: aload 5
    //   1872: astore 4
    //   1874: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1877: ifeq +39 -> 1916
    //   1880: aload 5
    //   1882: astore 4
    //   1884: ldc 85
    //   1886: iconst_2
    //   1887: new 65	java/lang/StringBuilder
    //   1890: dup
    //   1891: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1894: ldc_w 300
    //   1897: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: aload 6
    //   1902: invokevirtual 90	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1905: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1908: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1911: aload 6
    //   1913: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1916: aload 5
    //   1918: astore 4
    //   1920: invokestatic 138	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1923: ifnull +56 -> 1979
    //   1926: aload 5
    //   1928: astore 4
    //   1930: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1933: ifnull +46 -> 1979
    //   1936: aload 5
    //   1938: astore 4
    //   1940: aload_0
    //   1941: getfield 35	gcv:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1944: invokestatic 138	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1947: getfield 141	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1950: invokevirtual 147	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1953: ifeq +26 -> 1979
    //   1956: aload 5
    //   1958: astore 4
    //   1960: invokestatic 155	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1963: invokevirtual 160	android/media/MediaPlayer:reset	()V
    //   1966: aload 5
    //   1968: astore 4
    //   1970: aload_0
    //   1971: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1974: bipush 6
    //   1976: invokestatic 175	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1979: aload 5
    //   1981: astore 4
    //   1983: invokestatic 303	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   1986: ifnull +52 -> 2038
    //   1989: aload 5
    //   1991: astore 4
    //   1993: invokestatic 303	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   1996: arraylength
    //   1997: iconst_1
    //   1998: if_icmpne +40 -> 2038
    //   2001: aload 5
    //   2003: astore 4
    //   2005: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2008: ifeq +16 -> 2024
    //   2011: aload 5
    //   2013: astore 4
    //   2015: ldc 85
    //   2017: iconst_2
    //   2018: ldc_w 305
    //   2021: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2024: aload 5
    //   2026: astore 4
    //   2028: aload_0
    //   2029: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2032: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2035: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2038: aload_0
    //   2039: iconst_0
    //   2040: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   2043: aload 5
    //   2045: ifnull +8 -> 2053
    //   2048: aload 5
    //   2050: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   2053: aload_0
    //   2054: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2057: aload_0
    //   2058: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2061: if_icmpge -1439 -> 622
    //   2064: aload_0
    //   2065: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2068: ifle -1446 -> 622
    //   2071: aload_0
    //   2072: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2075: aload_0
    //   2076: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2079: aload_0
    //   2080: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2083: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2086: goto -1464 -> 622
    //   2089: astore 6
    //   2091: aconst_null
    //   2092: astore 5
    //   2094: aload 5
    //   2096: astore 4
    //   2098: aload_0
    //   2099: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2102: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2105: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2108: aload 5
    //   2110: astore 4
    //   2112: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2115: ifeq +39 -> 2154
    //   2118: aload 5
    //   2120: astore 4
    //   2122: ldc 85
    //   2124: iconst_2
    //   2125: new 65	java/lang/StringBuilder
    //   2128: dup
    //   2129: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2132: ldc_w 307
    //   2135: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2138: aload 6
    //   2140: invokevirtual 308	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2143: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2146: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2149: aload 6
    //   2151: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2154: aload_0
    //   2155: iconst_0
    //   2156: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   2159: aload 5
    //   2161: ifnull +8 -> 2169
    //   2164: aload 5
    //   2166: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   2169: aload_0
    //   2170: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2173: aload_0
    //   2174: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2177: if_icmpge -1555 -> 622
    //   2180: aload_0
    //   2181: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2184: ifle -1562 -> 622
    //   2187: aload_0
    //   2188: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2191: aload_0
    //   2192: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2195: aload_0
    //   2196: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2199: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2202: goto -1580 -> 622
    //   2205: astore 6
    //   2207: aconst_null
    //   2208: astore 5
    //   2210: aload 5
    //   2212: astore 4
    //   2214: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2217: ifeq +39 -> 2256
    //   2220: aload 5
    //   2222: astore 4
    //   2224: ldc 85
    //   2226: iconst_2
    //   2227: new 65	java/lang/StringBuilder
    //   2230: dup
    //   2231: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2234: ldc_w 310
    //   2237: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: aload 6
    //   2242: invokevirtual 311	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2245: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2251: aload 6
    //   2253: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2256: aload 5
    //   2258: astore 4
    //   2260: aload_0
    //   2261: getfield 16	gcv:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2264: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2267: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2270: aload_0
    //   2271: iconst_0
    //   2272: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   2275: aload 5
    //   2277: ifnull +8 -> 2285
    //   2280: aload 5
    //   2282: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   2285: aload_0
    //   2286: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2289: aload_0
    //   2290: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2293: if_icmpge -1671 -> 622
    //   2296: aload_0
    //   2297: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2300: ifle -1678 -> 622
    //   2303: aload_0
    //   2304: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2307: aload_0
    //   2308: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2311: aload_0
    //   2312: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2315: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2318: goto -1696 -> 622
    //   2321: astore 5
    //   2323: aconst_null
    //   2324: astore 4
    //   2326: aload_0
    //   2327: iconst_0
    //   2328: putfield 25	gcv:jdField_c_of_type_Boolean	Z
    //   2331: aload 4
    //   2333: ifnull +8 -> 2341
    //   2336: aload 4
    //   2338: invokevirtual 217	java/io/RandomAccessFile:close	()V
    //   2341: aload_0
    //   2342: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2345: aload_0
    //   2346: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2349: if_icmpge +25 -> 2374
    //   2352: aload_0
    //   2353: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2356: ifle +18 -> 2374
    //   2359: aload_0
    //   2360: getfield 37	gcv:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2363: aload_0
    //   2364: getfield 43	gcv:jdField_a_of_type_Int	I
    //   2367: aload_0
    //   2368: getfield 41	gcv:jdField_b_of_type_Int	I
    //   2371: invokestatic 222	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2374: aload 5
    //   2376: athrow
    //   2377: astore 4
    //   2379: goto -1937 -> 442
    //   2382: astore 4
    //   2384: goto -1414 -> 970
    //   2387: astore 4
    //   2389: goto -560 -> 1829
    //   2392: astore 4
    //   2394: goto -1805 -> 589
    //   2397: astore 4
    //   2399: goto -781 -> 1618
    //   2402: astore 4
    //   2404: goto -351 -> 2053
    //   2407: astore 4
    //   2409: goto -240 -> 2169
    //   2412: astore 4
    //   2414: goto -129 -> 2285
    //   2417: astore 4
    //   2419: goto -78 -> 2341
    //   2422: astore 5
    //   2424: goto -98 -> 2326
    //   2427: astore 6
    //   2429: goto -219 -> 2210
    //   2432: astore 6
    //   2434: goto -340 -> 2094
    //   2437: astore 6
    //   2439: goto -569 -> 1870
    //   2442: astore 6
    //   2444: aconst_null
    //   2445: astore 5
    //   2447: goto -904 -> 1543
    //   2450: astore 6
    //   2452: aconst_null
    //   2453: astore 5
    //   2455: goto -1940 -> 515
    //   2458: iconst_0
    //   2459: istore_3
    //   2460: iconst_0
    //   2461: istore_1
    //   2462: aload 6
    //   2464: astore 4
    //   2466: goto -2232 -> 234
    //   2469: aload 6
    //   2471: astore 4
    //   2473: goto -2239 -> 234
    //   2476: iconst_0
    //   2477: istore_1
    //   2478: goto -1264 -> 1214
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2481	0	this	gcv
    //   234	2244	1	i	int
    //   235	1443	2	j	int
    //   250	2210	3	k	int
    //   6	2331	4	localObject1	java.lang.Object
    //   2377	1	4	localIOException1	IOException
    //   2382	1	4	localIOException2	IOException
    //   2387	1	4	localIOException3	IOException
    //   2392	1	4	localIOException4	IOException
    //   2397	1	4	localIOException5	IOException
    //   2402	1	4	localIOException6	IOException
    //   2407	1	4	localIOException7	IOException
    //   2412	1	4	localIOException8	IOException
    //   2417	1	4	localIOException9	IOException
    //   2464	8	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   75	2206	5	localRandomAccessFile	java.io.RandomAccessFile
    //   2321	54	5	localObject2	java.lang.Object
    //   2422	1	5	localObject3	java.lang.Object
    //   2445	9	5	localObject4	java.lang.Object
    //   1	376	6	localObject5	java.lang.Object
    //   513	263	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1099	340	6	localInputStream	java.io.InputStream
    //   1541	232	6	localMalformedURLException1	java.net.MalformedURLException
    //   1865	47	6	localIOException10	IOException
    //   2089	61	6	localIllegalStateException1	java.lang.IllegalStateException
    //   2205	47	6	localException1	java.lang.Exception
    //   2427	1	6	localException2	java.lang.Exception
    //   2432	1	6	localIllegalStateException2	java.lang.IllegalStateException
    //   2437	1	6	localIOException11	IOException
    //   2442	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   2450	20	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   673	43	7	localInterruptedException1	java.lang.InterruptedException
    //   760	915	7	localObject6	java.lang.Object
    //   57	1256	8	localFile	File
    //   92	773	9	localURL	java.net.URL
    //   1490	44	9	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   81	94	513	java/io/FileNotFoundException
    //   98	114	513	java/io/FileNotFoundException
    //   118	125	513	java/io/FileNotFoundException
    //   129	143	513	java/io/FileNotFoundException
    //   147	153	513	java/io/FileNotFoundException
    //   157	165	513	java/io/FileNotFoundException
    //   169	175	513	java/io/FileNotFoundException
    //   179	190	513	java/io/FileNotFoundException
    //   194	200	513	java/io/FileNotFoundException
    //   204	210	513	java/io/FileNotFoundException
    //   214	222	513	java/io/FileNotFoundException
    //   226	231	513	java/io/FileNotFoundException
    //   259	269	513	java/io/FileNotFoundException
    //   273	279	513	java/io/FileNotFoundException
    //   283	292	513	java/io/FileNotFoundException
    //   296	303	513	java/io/FileNotFoundException
    //   307	318	513	java/io/FileNotFoundException
    //   322	363	513	java/io/FileNotFoundException
    //   367	372	513	java/io/FileNotFoundException
    //   376	382	513	java/io/FileNotFoundException
    //   396	402	513	java/io/FileNotFoundException
    //   406	414	513	java/io/FileNotFoundException
    //   418	427	513	java/io/FileNotFoundException
    //   480	486	513	java/io/FileNotFoundException
    //   490	498	513	java/io/FileNotFoundException
    //   502	510	513	java/io/FileNotFoundException
    //   660	666	513	java/io/FileNotFoundException
    //   679	685	513	java/io/FileNotFoundException
    //   689	720	513	java/io/FileNotFoundException
    //   729	736	513	java/io/FileNotFoundException
    //   740	747	513	java/io/FileNotFoundException
    //   751	756	513	java/io/FileNotFoundException
    //   766	773	513	java/io/FileNotFoundException
    //   783	791	513	java/io/FileNotFoundException
    //   795	801	513	java/io/FileNotFoundException
    //   805	842	513	java/io/FileNotFoundException
    //   846	851	513	java/io/FileNotFoundException
    //   855	860	513	java/io/FileNotFoundException
    //   864	874	513	java/io/FileNotFoundException
    //   878	884	513	java/io/FileNotFoundException
    //   888	897	513	java/io/FileNotFoundException
    //   901	906	513	java/io/FileNotFoundException
    //   910	916	513	java/io/FileNotFoundException
    //   924	930	513	java/io/FileNotFoundException
    //   934	942	513	java/io/FileNotFoundException
    //   946	955	513	java/io/FileNotFoundException
    //   1008	1013	513	java/io/FileNotFoundException
    //   1017	1024	513	java/io/FileNotFoundException
    //   1028	1034	513	java/io/FileNotFoundException
    //   1038	1090	513	java/io/FileNotFoundException
    //   1094	1101	513	java/io/FileNotFoundException
    //   1105	1112	513	java/io/FileNotFoundException
    //   1116	1126	513	java/io/FileNotFoundException
    //   1130	1137	513	java/io/FileNotFoundException
    //   1141	1156	513	java/io/FileNotFoundException
    //   1160	1166	513	java/io/FileNotFoundException
    //   1170	1211	513	java/io/FileNotFoundException
    //   1218	1225	513	java/io/FileNotFoundException
    //   1229	1240	513	java/io/FileNotFoundException
    //   1250	1257	513	java/io/FileNotFoundException
    //   1261	1277	513	java/io/FileNotFoundException
    //   1281	1295	513	java/io/FileNotFoundException
    //   1299	1305	513	java/io/FileNotFoundException
    //   1309	1320	513	java/io/FileNotFoundException
    //   1324	1330	513	java/io/FileNotFoundException
    //   1334	1340	513	java/io/FileNotFoundException
    //   1344	1389	513	java/io/FileNotFoundException
    //   1393	1403	513	java/io/FileNotFoundException
    //   1407	1413	513	java/io/FileNotFoundException
    //   1417	1425	513	java/io/FileNotFoundException
    //   1429	1434	513	java/io/FileNotFoundException
    //   1438	1446	513	java/io/FileNotFoundException
    //   1454	1460	513	java/io/FileNotFoundException
    //   1464	1473	513	java/io/FileNotFoundException
    //   1477	1483	513	java/io/FileNotFoundException
    //   1496	1502	513	java/io/FileNotFoundException
    //   1506	1538	513	java/io/FileNotFoundException
    //   1658	1668	513	java/io/FileNotFoundException
    //   1672	1681	513	java/io/FileNotFoundException
    //   1690	1696	513	java/io/FileNotFoundException
    //   1700	1763	513	java/io/FileNotFoundException
    //   1772	1777	513	java/io/FileNotFoundException
    //   1781	1792	513	java/io/FileNotFoundException
    //   1796	1803	513	java/io/FileNotFoundException
    //   1807	1814	513	java/io/FileNotFoundException
    //   660	666	673	java/lang/InterruptedException
    //   1477	1483	1490	java/lang/InterruptedException
    //   81	94	1541	java/net/MalformedURLException
    //   98	114	1541	java/net/MalformedURLException
    //   118	125	1541	java/net/MalformedURLException
    //   129	143	1541	java/net/MalformedURLException
    //   147	153	1541	java/net/MalformedURLException
    //   157	165	1541	java/net/MalformedURLException
    //   169	175	1541	java/net/MalformedURLException
    //   179	190	1541	java/net/MalformedURLException
    //   194	200	1541	java/net/MalformedURLException
    //   204	210	1541	java/net/MalformedURLException
    //   214	222	1541	java/net/MalformedURLException
    //   226	231	1541	java/net/MalformedURLException
    //   259	269	1541	java/net/MalformedURLException
    //   273	279	1541	java/net/MalformedURLException
    //   283	292	1541	java/net/MalformedURLException
    //   296	303	1541	java/net/MalformedURLException
    //   307	318	1541	java/net/MalformedURLException
    //   322	363	1541	java/net/MalformedURLException
    //   367	372	1541	java/net/MalformedURLException
    //   376	382	1541	java/net/MalformedURLException
    //   396	402	1541	java/net/MalformedURLException
    //   406	414	1541	java/net/MalformedURLException
    //   418	427	1541	java/net/MalformedURLException
    //   480	486	1541	java/net/MalformedURLException
    //   490	498	1541	java/net/MalformedURLException
    //   502	510	1541	java/net/MalformedURLException
    //   660	666	1541	java/net/MalformedURLException
    //   679	685	1541	java/net/MalformedURLException
    //   689	720	1541	java/net/MalformedURLException
    //   729	736	1541	java/net/MalformedURLException
    //   740	747	1541	java/net/MalformedURLException
    //   751	756	1541	java/net/MalformedURLException
    //   766	773	1541	java/net/MalformedURLException
    //   783	791	1541	java/net/MalformedURLException
    //   795	801	1541	java/net/MalformedURLException
    //   805	842	1541	java/net/MalformedURLException
    //   846	851	1541	java/net/MalformedURLException
    //   855	860	1541	java/net/MalformedURLException
    //   864	874	1541	java/net/MalformedURLException
    //   878	884	1541	java/net/MalformedURLException
    //   888	897	1541	java/net/MalformedURLException
    //   901	906	1541	java/net/MalformedURLException
    //   910	916	1541	java/net/MalformedURLException
    //   924	930	1541	java/net/MalformedURLException
    //   934	942	1541	java/net/MalformedURLException
    //   946	955	1541	java/net/MalformedURLException
    //   1008	1013	1541	java/net/MalformedURLException
    //   1017	1024	1541	java/net/MalformedURLException
    //   1028	1034	1541	java/net/MalformedURLException
    //   1038	1090	1541	java/net/MalformedURLException
    //   1094	1101	1541	java/net/MalformedURLException
    //   1105	1112	1541	java/net/MalformedURLException
    //   1116	1126	1541	java/net/MalformedURLException
    //   1130	1137	1541	java/net/MalformedURLException
    //   1141	1156	1541	java/net/MalformedURLException
    //   1160	1166	1541	java/net/MalformedURLException
    //   1170	1211	1541	java/net/MalformedURLException
    //   1218	1225	1541	java/net/MalformedURLException
    //   1229	1240	1541	java/net/MalformedURLException
    //   1250	1257	1541	java/net/MalformedURLException
    //   1261	1277	1541	java/net/MalformedURLException
    //   1281	1295	1541	java/net/MalformedURLException
    //   1299	1305	1541	java/net/MalformedURLException
    //   1309	1320	1541	java/net/MalformedURLException
    //   1324	1330	1541	java/net/MalformedURLException
    //   1334	1340	1541	java/net/MalformedURLException
    //   1344	1389	1541	java/net/MalformedURLException
    //   1393	1403	1541	java/net/MalformedURLException
    //   1407	1413	1541	java/net/MalformedURLException
    //   1417	1425	1541	java/net/MalformedURLException
    //   1429	1434	1541	java/net/MalformedURLException
    //   1438	1446	1541	java/net/MalformedURLException
    //   1454	1460	1541	java/net/MalformedURLException
    //   1464	1473	1541	java/net/MalformedURLException
    //   1477	1483	1541	java/net/MalformedURLException
    //   1496	1502	1541	java/net/MalformedURLException
    //   1506	1538	1541	java/net/MalformedURLException
    //   1658	1668	1541	java/net/MalformedURLException
    //   1672	1681	1541	java/net/MalformedURLException
    //   1690	1696	1541	java/net/MalformedURLException
    //   1700	1763	1541	java/net/MalformedURLException
    //   1772	1777	1541	java/net/MalformedURLException
    //   1781	1792	1541	java/net/MalformedURLException
    //   1796	1803	1541	java/net/MalformedURLException
    //   1807	1814	1541	java/net/MalformedURLException
    //   64	77	1865	java/io/IOException
    //   64	77	2089	java/lang/IllegalStateException
    //   64	77	2205	java/lang/Exception
    //   64	77	2321	finally
    //   437	442	2377	java/io/IOException
    //   965	970	2382	java/io/IOException
    //   1824	1829	2387	java/io/IOException
    //   584	589	2392	java/io/IOException
    //   1613	1618	2397	java/io/IOException
    //   2048	2053	2402	java/io/IOException
    //   2164	2169	2407	java/io/IOException
    //   2280	2285	2412	java/io/IOException
    //   2336	2341	2417	java/io/IOException
    //   81	94	2422	finally
    //   98	114	2422	finally
    //   118	125	2422	finally
    //   129	143	2422	finally
    //   147	153	2422	finally
    //   157	165	2422	finally
    //   169	175	2422	finally
    //   179	190	2422	finally
    //   194	200	2422	finally
    //   204	210	2422	finally
    //   214	222	2422	finally
    //   226	231	2422	finally
    //   259	269	2422	finally
    //   273	279	2422	finally
    //   283	292	2422	finally
    //   296	303	2422	finally
    //   307	318	2422	finally
    //   322	363	2422	finally
    //   367	372	2422	finally
    //   376	382	2422	finally
    //   396	402	2422	finally
    //   406	414	2422	finally
    //   418	427	2422	finally
    //   480	486	2422	finally
    //   490	498	2422	finally
    //   502	510	2422	finally
    //   519	525	2422	finally
    //   529	560	2422	finally
    //   564	574	2422	finally
    //   660	666	2422	finally
    //   679	685	2422	finally
    //   689	720	2422	finally
    //   729	736	2422	finally
    //   740	747	2422	finally
    //   751	756	2422	finally
    //   766	773	2422	finally
    //   783	791	2422	finally
    //   795	801	2422	finally
    //   805	842	2422	finally
    //   846	851	2422	finally
    //   855	860	2422	finally
    //   864	874	2422	finally
    //   878	884	2422	finally
    //   888	897	2422	finally
    //   901	906	2422	finally
    //   910	916	2422	finally
    //   924	930	2422	finally
    //   934	942	2422	finally
    //   946	955	2422	finally
    //   1008	1013	2422	finally
    //   1017	1024	2422	finally
    //   1028	1034	2422	finally
    //   1038	1090	2422	finally
    //   1094	1101	2422	finally
    //   1105	1112	2422	finally
    //   1116	1126	2422	finally
    //   1130	1137	2422	finally
    //   1141	1156	2422	finally
    //   1160	1166	2422	finally
    //   1170	1211	2422	finally
    //   1218	1225	2422	finally
    //   1229	1240	2422	finally
    //   1250	1257	2422	finally
    //   1261	1277	2422	finally
    //   1281	1295	2422	finally
    //   1299	1305	2422	finally
    //   1309	1320	2422	finally
    //   1324	1330	2422	finally
    //   1334	1340	2422	finally
    //   1344	1389	2422	finally
    //   1393	1403	2422	finally
    //   1407	1413	2422	finally
    //   1417	1425	2422	finally
    //   1429	1434	2422	finally
    //   1438	1446	2422	finally
    //   1454	1460	2422	finally
    //   1464	1473	2422	finally
    //   1477	1483	2422	finally
    //   1496	1502	2422	finally
    //   1506	1538	2422	finally
    //   1547	1557	2422	finally
    //   1561	1567	2422	finally
    //   1571	1603	2422	finally
    //   1658	1668	2422	finally
    //   1672	1681	2422	finally
    //   1690	1696	2422	finally
    //   1700	1763	2422	finally
    //   1772	1777	2422	finally
    //   1781	1792	2422	finally
    //   1796	1803	2422	finally
    //   1807	1814	2422	finally
    //   1874	1880	2422	finally
    //   1884	1916	2422	finally
    //   1920	1926	2422	finally
    //   1930	1936	2422	finally
    //   1940	1956	2422	finally
    //   1960	1966	2422	finally
    //   1970	1979	2422	finally
    //   1983	1989	2422	finally
    //   1993	2001	2422	finally
    //   2005	2011	2422	finally
    //   2015	2024	2422	finally
    //   2028	2038	2422	finally
    //   2098	2108	2422	finally
    //   2112	2118	2422	finally
    //   2122	2154	2422	finally
    //   2214	2220	2422	finally
    //   2224	2256	2422	finally
    //   2260	2270	2422	finally
    //   81	94	2427	java/lang/Exception
    //   98	114	2427	java/lang/Exception
    //   118	125	2427	java/lang/Exception
    //   129	143	2427	java/lang/Exception
    //   147	153	2427	java/lang/Exception
    //   157	165	2427	java/lang/Exception
    //   169	175	2427	java/lang/Exception
    //   179	190	2427	java/lang/Exception
    //   194	200	2427	java/lang/Exception
    //   204	210	2427	java/lang/Exception
    //   214	222	2427	java/lang/Exception
    //   226	231	2427	java/lang/Exception
    //   259	269	2427	java/lang/Exception
    //   273	279	2427	java/lang/Exception
    //   283	292	2427	java/lang/Exception
    //   296	303	2427	java/lang/Exception
    //   307	318	2427	java/lang/Exception
    //   322	363	2427	java/lang/Exception
    //   367	372	2427	java/lang/Exception
    //   376	382	2427	java/lang/Exception
    //   396	402	2427	java/lang/Exception
    //   406	414	2427	java/lang/Exception
    //   418	427	2427	java/lang/Exception
    //   480	486	2427	java/lang/Exception
    //   490	498	2427	java/lang/Exception
    //   502	510	2427	java/lang/Exception
    //   660	666	2427	java/lang/Exception
    //   679	685	2427	java/lang/Exception
    //   689	720	2427	java/lang/Exception
    //   729	736	2427	java/lang/Exception
    //   740	747	2427	java/lang/Exception
    //   751	756	2427	java/lang/Exception
    //   766	773	2427	java/lang/Exception
    //   783	791	2427	java/lang/Exception
    //   795	801	2427	java/lang/Exception
    //   805	842	2427	java/lang/Exception
    //   846	851	2427	java/lang/Exception
    //   855	860	2427	java/lang/Exception
    //   864	874	2427	java/lang/Exception
    //   878	884	2427	java/lang/Exception
    //   888	897	2427	java/lang/Exception
    //   901	906	2427	java/lang/Exception
    //   910	916	2427	java/lang/Exception
    //   924	930	2427	java/lang/Exception
    //   934	942	2427	java/lang/Exception
    //   946	955	2427	java/lang/Exception
    //   1008	1013	2427	java/lang/Exception
    //   1017	1024	2427	java/lang/Exception
    //   1028	1034	2427	java/lang/Exception
    //   1038	1090	2427	java/lang/Exception
    //   1094	1101	2427	java/lang/Exception
    //   1105	1112	2427	java/lang/Exception
    //   1116	1126	2427	java/lang/Exception
    //   1130	1137	2427	java/lang/Exception
    //   1141	1156	2427	java/lang/Exception
    //   1160	1166	2427	java/lang/Exception
    //   1170	1211	2427	java/lang/Exception
    //   1218	1225	2427	java/lang/Exception
    //   1229	1240	2427	java/lang/Exception
    //   1250	1257	2427	java/lang/Exception
    //   1261	1277	2427	java/lang/Exception
    //   1281	1295	2427	java/lang/Exception
    //   1299	1305	2427	java/lang/Exception
    //   1309	1320	2427	java/lang/Exception
    //   1324	1330	2427	java/lang/Exception
    //   1334	1340	2427	java/lang/Exception
    //   1344	1389	2427	java/lang/Exception
    //   1393	1403	2427	java/lang/Exception
    //   1407	1413	2427	java/lang/Exception
    //   1417	1425	2427	java/lang/Exception
    //   1429	1434	2427	java/lang/Exception
    //   1438	1446	2427	java/lang/Exception
    //   1454	1460	2427	java/lang/Exception
    //   1464	1473	2427	java/lang/Exception
    //   1477	1483	2427	java/lang/Exception
    //   1496	1502	2427	java/lang/Exception
    //   1506	1538	2427	java/lang/Exception
    //   1658	1668	2427	java/lang/Exception
    //   1672	1681	2427	java/lang/Exception
    //   1690	1696	2427	java/lang/Exception
    //   1700	1763	2427	java/lang/Exception
    //   1772	1777	2427	java/lang/Exception
    //   1781	1792	2427	java/lang/Exception
    //   1796	1803	2427	java/lang/Exception
    //   1807	1814	2427	java/lang/Exception
    //   81	94	2432	java/lang/IllegalStateException
    //   98	114	2432	java/lang/IllegalStateException
    //   118	125	2432	java/lang/IllegalStateException
    //   129	143	2432	java/lang/IllegalStateException
    //   147	153	2432	java/lang/IllegalStateException
    //   157	165	2432	java/lang/IllegalStateException
    //   169	175	2432	java/lang/IllegalStateException
    //   179	190	2432	java/lang/IllegalStateException
    //   194	200	2432	java/lang/IllegalStateException
    //   204	210	2432	java/lang/IllegalStateException
    //   214	222	2432	java/lang/IllegalStateException
    //   226	231	2432	java/lang/IllegalStateException
    //   259	269	2432	java/lang/IllegalStateException
    //   273	279	2432	java/lang/IllegalStateException
    //   283	292	2432	java/lang/IllegalStateException
    //   296	303	2432	java/lang/IllegalStateException
    //   307	318	2432	java/lang/IllegalStateException
    //   322	363	2432	java/lang/IllegalStateException
    //   367	372	2432	java/lang/IllegalStateException
    //   376	382	2432	java/lang/IllegalStateException
    //   396	402	2432	java/lang/IllegalStateException
    //   406	414	2432	java/lang/IllegalStateException
    //   418	427	2432	java/lang/IllegalStateException
    //   480	486	2432	java/lang/IllegalStateException
    //   490	498	2432	java/lang/IllegalStateException
    //   502	510	2432	java/lang/IllegalStateException
    //   660	666	2432	java/lang/IllegalStateException
    //   679	685	2432	java/lang/IllegalStateException
    //   689	720	2432	java/lang/IllegalStateException
    //   729	736	2432	java/lang/IllegalStateException
    //   740	747	2432	java/lang/IllegalStateException
    //   751	756	2432	java/lang/IllegalStateException
    //   766	773	2432	java/lang/IllegalStateException
    //   783	791	2432	java/lang/IllegalStateException
    //   795	801	2432	java/lang/IllegalStateException
    //   805	842	2432	java/lang/IllegalStateException
    //   846	851	2432	java/lang/IllegalStateException
    //   855	860	2432	java/lang/IllegalStateException
    //   864	874	2432	java/lang/IllegalStateException
    //   878	884	2432	java/lang/IllegalStateException
    //   888	897	2432	java/lang/IllegalStateException
    //   901	906	2432	java/lang/IllegalStateException
    //   910	916	2432	java/lang/IllegalStateException
    //   924	930	2432	java/lang/IllegalStateException
    //   934	942	2432	java/lang/IllegalStateException
    //   946	955	2432	java/lang/IllegalStateException
    //   1008	1013	2432	java/lang/IllegalStateException
    //   1017	1024	2432	java/lang/IllegalStateException
    //   1028	1034	2432	java/lang/IllegalStateException
    //   1038	1090	2432	java/lang/IllegalStateException
    //   1094	1101	2432	java/lang/IllegalStateException
    //   1105	1112	2432	java/lang/IllegalStateException
    //   1116	1126	2432	java/lang/IllegalStateException
    //   1130	1137	2432	java/lang/IllegalStateException
    //   1141	1156	2432	java/lang/IllegalStateException
    //   1160	1166	2432	java/lang/IllegalStateException
    //   1170	1211	2432	java/lang/IllegalStateException
    //   1218	1225	2432	java/lang/IllegalStateException
    //   1229	1240	2432	java/lang/IllegalStateException
    //   1250	1257	2432	java/lang/IllegalStateException
    //   1261	1277	2432	java/lang/IllegalStateException
    //   1281	1295	2432	java/lang/IllegalStateException
    //   1299	1305	2432	java/lang/IllegalStateException
    //   1309	1320	2432	java/lang/IllegalStateException
    //   1324	1330	2432	java/lang/IllegalStateException
    //   1334	1340	2432	java/lang/IllegalStateException
    //   1344	1389	2432	java/lang/IllegalStateException
    //   1393	1403	2432	java/lang/IllegalStateException
    //   1407	1413	2432	java/lang/IllegalStateException
    //   1417	1425	2432	java/lang/IllegalStateException
    //   1429	1434	2432	java/lang/IllegalStateException
    //   1438	1446	2432	java/lang/IllegalStateException
    //   1454	1460	2432	java/lang/IllegalStateException
    //   1464	1473	2432	java/lang/IllegalStateException
    //   1477	1483	2432	java/lang/IllegalStateException
    //   1496	1502	2432	java/lang/IllegalStateException
    //   1506	1538	2432	java/lang/IllegalStateException
    //   1658	1668	2432	java/lang/IllegalStateException
    //   1672	1681	2432	java/lang/IllegalStateException
    //   1690	1696	2432	java/lang/IllegalStateException
    //   1700	1763	2432	java/lang/IllegalStateException
    //   1772	1777	2432	java/lang/IllegalStateException
    //   1781	1792	2432	java/lang/IllegalStateException
    //   1796	1803	2432	java/lang/IllegalStateException
    //   1807	1814	2432	java/lang/IllegalStateException
    //   81	94	2437	java/io/IOException
    //   98	114	2437	java/io/IOException
    //   118	125	2437	java/io/IOException
    //   129	143	2437	java/io/IOException
    //   147	153	2437	java/io/IOException
    //   157	165	2437	java/io/IOException
    //   169	175	2437	java/io/IOException
    //   179	190	2437	java/io/IOException
    //   194	200	2437	java/io/IOException
    //   204	210	2437	java/io/IOException
    //   214	222	2437	java/io/IOException
    //   226	231	2437	java/io/IOException
    //   259	269	2437	java/io/IOException
    //   273	279	2437	java/io/IOException
    //   283	292	2437	java/io/IOException
    //   296	303	2437	java/io/IOException
    //   307	318	2437	java/io/IOException
    //   322	363	2437	java/io/IOException
    //   367	372	2437	java/io/IOException
    //   376	382	2437	java/io/IOException
    //   396	402	2437	java/io/IOException
    //   406	414	2437	java/io/IOException
    //   418	427	2437	java/io/IOException
    //   480	486	2437	java/io/IOException
    //   490	498	2437	java/io/IOException
    //   502	510	2437	java/io/IOException
    //   660	666	2437	java/io/IOException
    //   679	685	2437	java/io/IOException
    //   689	720	2437	java/io/IOException
    //   729	736	2437	java/io/IOException
    //   740	747	2437	java/io/IOException
    //   751	756	2437	java/io/IOException
    //   766	773	2437	java/io/IOException
    //   783	791	2437	java/io/IOException
    //   795	801	2437	java/io/IOException
    //   805	842	2437	java/io/IOException
    //   846	851	2437	java/io/IOException
    //   855	860	2437	java/io/IOException
    //   864	874	2437	java/io/IOException
    //   878	884	2437	java/io/IOException
    //   888	897	2437	java/io/IOException
    //   901	906	2437	java/io/IOException
    //   910	916	2437	java/io/IOException
    //   924	930	2437	java/io/IOException
    //   934	942	2437	java/io/IOException
    //   946	955	2437	java/io/IOException
    //   1008	1013	2437	java/io/IOException
    //   1017	1024	2437	java/io/IOException
    //   1028	1034	2437	java/io/IOException
    //   1038	1090	2437	java/io/IOException
    //   1094	1101	2437	java/io/IOException
    //   1105	1112	2437	java/io/IOException
    //   1116	1126	2437	java/io/IOException
    //   1130	1137	2437	java/io/IOException
    //   1141	1156	2437	java/io/IOException
    //   1160	1166	2437	java/io/IOException
    //   1170	1211	2437	java/io/IOException
    //   1218	1225	2437	java/io/IOException
    //   1229	1240	2437	java/io/IOException
    //   1250	1257	2437	java/io/IOException
    //   1261	1277	2437	java/io/IOException
    //   1281	1295	2437	java/io/IOException
    //   1299	1305	2437	java/io/IOException
    //   1309	1320	2437	java/io/IOException
    //   1324	1330	2437	java/io/IOException
    //   1334	1340	2437	java/io/IOException
    //   1344	1389	2437	java/io/IOException
    //   1393	1403	2437	java/io/IOException
    //   1407	1413	2437	java/io/IOException
    //   1417	1425	2437	java/io/IOException
    //   1429	1434	2437	java/io/IOException
    //   1438	1446	2437	java/io/IOException
    //   1454	1460	2437	java/io/IOException
    //   1464	1473	2437	java/io/IOException
    //   1477	1483	2437	java/io/IOException
    //   1496	1502	2437	java/io/IOException
    //   1506	1538	2437	java/io/IOException
    //   1658	1668	2437	java/io/IOException
    //   1672	1681	2437	java/io/IOException
    //   1690	1696	2437	java/io/IOException
    //   1700	1763	2437	java/io/IOException
    //   1772	1777	2437	java/io/IOException
    //   1781	1792	2437	java/io/IOException
    //   1796	1803	2437	java/io/IOException
    //   1807	1814	2437	java/io/IOException
    //   64	77	2442	java/net/MalformedURLException
    //   64	77	2450	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gcv
 * JD-Core Version:    0.7.0.1
 */