import com.tencent.mobileqq.music.QQPlayerService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

public class dyk
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
  
  public dyk(QQPlayerService paramQQPlayerService, String paramString1, String paramString2, int paramInt1, int paramInt2)
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
    //   39: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   42: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   45: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   48: return
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   54: invokespecial 125	dyk:a	(Ljava/lang/String;)Ljava/io/File;
    //   57: astore 8
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 25	dyk:jdField_c_of_type_Boolean	Z
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
    //   85: ldc 136
    //   87: aload_0
    //   88: getfield 35	dyk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   91: invokestatic 142	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 143	java/net/URL:<init>	(Ljava/lang/String;)V
    //   97: astore 9
    //   99: aload 5
    //   101: astore 4
    //   103: invokestatic 146	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   106: getfield 149	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: aload_0
    //   110: getfield 35	dyk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   113: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifeq +2353 -> 2469
    //   119: aload 5
    //   121: astore 4
    //   123: aload_0
    //   124: getfield 27	dyk:d	Z
    //   127: ifeq +2342 -> 2469
    //   130: aload 5
    //   132: astore 4
    //   134: aload_0
    //   135: getfield 43	dyk:jdField_a_of_type_Int	I
    //   138: aload_0
    //   139: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   142: getfield 158	com/tencent/mobileqq/music/QQPlayerService:t	I
    //   145: if_icmple +336 -> 481
    //   148: aload 5
    //   150: astore 4
    //   152: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +15 -> 170
    //   158: aload 5
    //   160: astore 4
    //   162: ldc 85
    //   164: iconst_2
    //   165: ldc 160
    //   167: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 5
    //   172: astore 4
    //   174: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   177: invokevirtual 168	android/media/MediaPlayer:reset	()V
    //   180: aload 5
    //   182: astore 4
    //   184: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   187: aload 8
    //   189: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   192: invokevirtual 174	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   195: aload 5
    //   197: astore 4
    //   199: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   202: invokevirtual 177	android/media/MediaPlayer:prepare	()V
    //   205: aload 5
    //   207: astore 4
    //   209: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   212: invokevirtual 180	android/media/MediaPlayer:start	()V
    //   215: aload 5
    //   217: astore 4
    //   219: aload_0
    //   220: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   223: iconst_2
    //   224: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   227: aload 5
    //   229: astore 4
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield 27	dyk:d	Z
    //   236: goto +2233 -> 2469
    //   239: iload_1
    //   240: istore_2
    //   241: aload 4
    //   243: astore 6
    //   245: iload_1
    //   246: ifgt +147 -> 393
    //   249: iload_1
    //   250: istore_2
    //   251: aload 4
    //   253: astore 6
    //   255: iload_3
    //   256: iconst_5
    //   257: if_icmpgt +136 -> 393
    //   260: aload 5
    //   262: astore 4
    //   264: aload 9
    //   266: invokevirtual 187	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   269: checkcast 189	java/net/HttpURLConnection
    //   272: astore 6
    //   274: aload 5
    //   276: astore 4
    //   278: aload 6
    //   280: iconst_1
    //   281: invokevirtual 193	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   284: aload 5
    //   286: astore 4
    //   288: aload 6
    //   290: ldc 195
    //   292: ldc 197
    //   294: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload 5
    //   299: astore 4
    //   301: aload_0
    //   302: getfield 39	dyk:jdField_c_of_type_Int	I
    //   305: ifeq +63 -> 368
    //   308: aload 5
    //   310: astore 4
    //   312: aload_0
    //   313: getfield 39	dyk:jdField_c_of_type_Int	I
    //   316: aload_0
    //   317: getfield 43	dyk:jdField_a_of_type_Int	I
    //   320: if_icmple +48 -> 368
    //   323: aload 5
    //   325: astore 4
    //   327: aload 6
    //   329: ldc 203
    //   331: new 65	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   338: ldc 205
    //   340: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: aload_0
    //   344: getfield 43	dyk:jdField_a_of_type_Int	I
    //   347: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   350: ldc 210
    //   352: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_0
    //   356: getfield 39	dyk:jdField_c_of_type_Int	I
    //   359: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   362: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: aload 5
    //   370: astore 4
    //   372: aload 6
    //   374: invokevirtual 213	java/net/HttpURLConnection:connect	()V
    //   377: aload 5
    //   379: astore 4
    //   381: aload 6
    //   383: invokevirtual 217	java/net/HttpURLConnection:getContentLength	()I
    //   386: istore_1
    //   387: iload_1
    //   388: ifle +269 -> 657
    //   391: iload_1
    //   392: istore_2
    //   393: iload_2
    //   394: ifgt +334 -> 728
    //   397: aload 5
    //   399: astore 4
    //   401: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   404: ifeq +15 -> 419
    //   407: aload 5
    //   409: astore 4
    //   411: ldc 85
    //   413: iconst_2
    //   414: ldc 219
    //   416: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 5
    //   421: astore 4
    //   423: aload_0
    //   424: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   427: bipush 7
    //   429: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   432: aload_0
    //   433: iconst_0
    //   434: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   437: aload 5
    //   439: ifnull +8 -> 447
    //   442: aload 5
    //   444: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   447: aload_0
    //   448: getfield 43	dyk:jdField_a_of_type_Int	I
    //   451: aload_0
    //   452: getfield 41	dyk:jdField_b_of_type_Int	I
    //   455: if_icmpge -407 -> 48
    //   458: aload_0
    //   459: getfield 41	dyk:jdField_b_of_type_Int	I
    //   462: ifle -414 -> 48
    //   465: aload_0
    //   466: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   469: aload_0
    //   470: getfield 43	dyk:jdField_a_of_type_Int	I
    //   473: aload_0
    //   474: getfield 41	dyk:jdField_b_of_type_Int	I
    //   477: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   480: return
    //   481: aload 5
    //   483: astore 4
    //   485: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +15 -> 503
    //   491: aload 5
    //   493: astore 4
    //   495: ldc 85
    //   497: iconst_2
    //   498: ldc 232
    //   500: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload 5
    //   505: astore 4
    //   507: aload_0
    //   508: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   511: iconst_1
    //   512: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   515: goto +1954 -> 2469
    //   518: astore 6
    //   520: aload 5
    //   522: astore 4
    //   524: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +38 -> 565
    //   530: aload 5
    //   532: astore 4
    //   534: ldc 85
    //   536: iconst_2
    //   537: new 65	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   544: ldc 234
    //   546: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload 6
    //   551: invokevirtual 235	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   554: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: aload 6
    //   562: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aload 5
    //   567: astore 4
    //   569: aload_0
    //   570: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   573: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   576: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   579: aload_0
    //   580: iconst_0
    //   581: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   584: aload 5
    //   586: ifnull +8 -> 594
    //   589: aload 5
    //   591: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   594: aload_0
    //   595: getfield 43	dyk:jdField_a_of_type_Int	I
    //   598: aload_0
    //   599: getfield 41	dyk:jdField_b_of_type_Int	I
    //   602: if_icmpge +25 -> 627
    //   605: aload_0
    //   606: getfield 41	dyk:jdField_b_of_type_Int	I
    //   609: ifle +18 -> 627
    //   612: aload_0
    //   613: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   616: aload_0
    //   617: getfield 43	dyk:jdField_a_of_type_Int	I
    //   620: aload_0
    //   621: getfield 41	dyk:jdField_b_of_type_Int	I
    //   624: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   627: aload_0
    //   628: getfield 23	dyk:jdField_b_of_type_Boolean	Z
    //   631: ifeq +6 -> 637
    //   634: invokestatic 237	com/tencent/mobileqq/utils/MusicCacheManager:a	()V
    //   637: aload_0
    //   638: iconst_0
    //   639: putfield 23	dyk:jdField_b_of_type_Boolean	Z
    //   642: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq -597 -> 48
    //   648: ldc 85
    //   650: iconst_2
    //   651: ldc 239
    //   653: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   656: return
    //   657: iload_3
    //   658: iconst_1
    //   659: iadd
    //   660: istore_3
    //   661: aload 5
    //   663: astore 4
    //   665: ldc2_w 240
    //   668: invokestatic 245	java/lang/Thread:sleep	(J)V
    //   671: aload 6
    //   673: astore 4
    //   675: goto -436 -> 239
    //   678: astore 7
    //   680: aload 5
    //   682: astore 4
    //   684: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   687: ifeq +1793 -> 2480
    //   690: aload 5
    //   692: astore 4
    //   694: ldc 85
    //   696: iconst_2
    //   697: new 65	java/lang/StringBuilder
    //   700: dup
    //   701: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   704: ldc 247
    //   706: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: aload 7
    //   711: invokevirtual 248	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   714: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: aload 7
    //   722: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   725: goto +1755 -> 2480
    //   728: iload_2
    //   729: istore_1
    //   730: aload 5
    //   732: astore 4
    //   734: aload_0
    //   735: getfield 43	dyk:jdField_a_of_type_Int	I
    //   738: ifle +14 -> 752
    //   741: aload 5
    //   743: astore 4
    //   745: iload_2
    //   746: aload_0
    //   747: getfield 43	dyk:jdField_a_of_type_Int	I
    //   750: iadd
    //   751: istore_1
    //   752: aload 5
    //   754: astore 4
    //   756: aload_0
    //   757: iload_1
    //   758: putfield 41	dyk:jdField_b_of_type_Int	I
    //   761: iload_1
    //   762: istore_2
    //   763: aload 6
    //   765: astore 7
    //   767: aload 5
    //   769: astore 4
    //   771: aload_0
    //   772: getfield 39	dyk:jdField_c_of_type_Int	I
    //   775: ifeq +243 -> 1018
    //   778: iload_1
    //   779: istore_2
    //   780: aload 6
    //   782: astore 7
    //   784: aload 5
    //   786: astore 4
    //   788: aload_0
    //   789: getfield 39	dyk:jdField_c_of_type_Int	I
    //   792: iload_1
    //   793: if_icmpeq +225 -> 1018
    //   796: aload 5
    //   798: astore 4
    //   800: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   803: ifeq +44 -> 847
    //   806: aload 5
    //   808: astore 4
    //   810: ldc 85
    //   812: iconst_2
    //   813: new 65	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   820: ldc 250
    //   822: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: aload_0
    //   826: getfield 39	dyk:jdField_c_of_type_Int	I
    //   829: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: ldc 252
    //   834: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: iload_1
    //   838: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   841: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload 5
    //   849: astore 4
    //   851: aload_0
    //   852: iconst_0
    //   853: putfield 43	dyk:jdField_a_of_type_Int	I
    //   856: aload 5
    //   858: astore 4
    //   860: aload_0
    //   861: iconst_1
    //   862: putfield 27	dyk:d	Z
    //   865: aload 5
    //   867: astore 4
    //   869: aload 9
    //   871: invokevirtual 187	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   874: checkcast 189	java/net/HttpURLConnection
    //   877: astore 7
    //   879: aload 5
    //   881: astore 4
    //   883: aload 7
    //   885: iconst_1
    //   886: invokevirtual 193	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   889: aload 5
    //   891: astore 4
    //   893: aload 7
    //   895: ldc 195
    //   897: ldc 197
    //   899: invokevirtual 201	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   902: aload 5
    //   904: astore 4
    //   906: aload 7
    //   908: invokevirtual 213	java/net/HttpURLConnection:connect	()V
    //   911: aload 5
    //   913: astore 4
    //   915: aload 7
    //   917: invokevirtual 217	java/net/HttpURLConnection:getContentLength	()I
    //   920: istore_2
    //   921: iload_2
    //   922: ifge +87 -> 1009
    //   925: aload 5
    //   927: astore 4
    //   929: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq +15 -> 947
    //   935: aload 5
    //   937: astore 4
    //   939: ldc 85
    //   941: iconst_2
    //   942: ldc 254
    //   944: invokestatic 222	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: aload 5
    //   949: astore 4
    //   951: aload_0
    //   952: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   955: bipush 7
    //   957: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   960: aload_0
    //   961: iconst_0
    //   962: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   965: aload 5
    //   967: ifnull +8 -> 975
    //   970: aload 5
    //   972: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   975: aload_0
    //   976: getfield 43	dyk:jdField_a_of_type_Int	I
    //   979: aload_0
    //   980: getfield 41	dyk:jdField_b_of_type_Int	I
    //   983: if_icmpge -935 -> 48
    //   986: aload_0
    //   987: getfield 41	dyk:jdField_b_of_type_Int	I
    //   990: ifle -942 -> 48
    //   993: aload_0
    //   994: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   997: aload_0
    //   998: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1001: aload_0
    //   1002: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1005: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1008: return
    //   1009: aload 5
    //   1011: astore 4
    //   1013: aload_0
    //   1014: iload_2
    //   1015: putfield 41	dyk:jdField_b_of_type_Int	I
    //   1018: aload 5
    //   1020: astore 4
    //   1022: aload 5
    //   1024: iload_2
    //   1025: i2l
    //   1026: invokevirtual 257	java/io/RandomAccessFile:setLength	(J)V
    //   1029: aload 5
    //   1031: astore 4
    //   1033: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1036: ifeq +62 -> 1098
    //   1039: aload 5
    //   1041: astore 4
    //   1043: ldc 85
    //   1045: iconst_2
    //   1046: new 65	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1053: ldc_w 259
    //   1056: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: aload_0
    //   1060: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1063: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1066: ldc_w 261
    //   1069: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1072: aload_0
    //   1073: getfield 39	dyk:jdField_c_of_type_Int	I
    //   1076: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1079: ldc_w 263
    //   1082: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: aload_0
    //   1086: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1089: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1092: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1095: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1098: aload 5
    //   1100: astore 4
    //   1102: aload 7
    //   1104: invokevirtual 267	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1107: astore 6
    //   1109: aload 5
    //   1111: astore 4
    //   1113: sipush 8192
    //   1116: newarray byte
    //   1118: astore 7
    //   1120: aload 5
    //   1122: astore 4
    //   1124: aload 5
    //   1126: aload_0
    //   1127: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1130: i2l
    //   1131: invokevirtual 270	java/io/RandomAccessFile:seek	(J)V
    //   1134: aload 5
    //   1136: astore 4
    //   1138: aload_0
    //   1139: getfield 39	dyk:jdField_c_of_type_Int	I
    //   1142: ifne +22 -> 1164
    //   1145: aload 5
    //   1147: astore 4
    //   1149: aload_0
    //   1150: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1153: aload_0
    //   1154: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1157: aload_0
    //   1158: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1161: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1164: aload 5
    //   1166: astore 4
    //   1168: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1171: ifeq +1316 -> 2487
    //   1174: aload 5
    //   1176: astore 4
    //   1178: ldc 85
    //   1180: iconst_2
    //   1181: new 65	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1188: ldc_w 272
    //   1191: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: aload_0
    //   1195: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1198: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: ldc_w 263
    //   1204: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: aload_0
    //   1208: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1211: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1214: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1217: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1220: goto +1267 -> 2487
    //   1223: aload 5
    //   1225: astore 4
    //   1227: aload_0
    //   1228: getfield 21	dyk:jdField_a_of_type_Boolean	Z
    //   1231: ifne +464 -> 1695
    //   1234: aload 5
    //   1236: astore 4
    //   1238: aload_0
    //   1239: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1242: aload_0
    //   1243: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1246: if_icmpge +449 -> 1695
    //   1249: iload_1
    //   1250: bipush 10
    //   1252: if_icmpge +443 -> 1695
    //   1255: aload 5
    //   1257: astore 4
    //   1259: aload_0
    //   1260: getfield 27	dyk:d	Z
    //   1263: ifeq +180 -> 1443
    //   1266: aload 5
    //   1268: astore 4
    //   1270: invokestatic 146	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1273: getfield 149	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1276: aload_0
    //   1277: getfield 35	dyk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1280: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1283: ifeq +160 -> 1443
    //   1286: aload 5
    //   1288: astore 4
    //   1290: aload_0
    //   1291: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1294: aload_0
    //   1295: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1298: getfield 158	com/tencent/mobileqq/music/QQPlayerService:t	I
    //   1301: if_icmple +142 -> 1443
    //   1304: aload 5
    //   1306: astore 4
    //   1308: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1311: invokevirtual 168	android/media/MediaPlayer:reset	()V
    //   1314: aload 5
    //   1316: astore 4
    //   1318: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1321: aload 8
    //   1323: invokevirtual 171	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1326: invokevirtual 174	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   1329: aload 5
    //   1331: astore 4
    //   1333: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1336: invokevirtual 177	android/media/MediaPlayer:prepare	()V
    //   1339: aload 5
    //   1341: astore 4
    //   1343: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1346: ifeq +52 -> 1398
    //   1349: aload 5
    //   1351: astore 4
    //   1353: ldc 85
    //   1355: iconst_2
    //   1356: new 65	java/lang/StringBuilder
    //   1359: dup
    //   1360: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1363: ldc_w 274
    //   1366: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1369: aload_0
    //   1370: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1373: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1376: ldc_w 276
    //   1379: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1382: aload_0
    //   1383: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1386: invokestatic 279	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1389: invokevirtual 282	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1392: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1395: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1398: aload 5
    //   1400: astore 4
    //   1402: aload_0
    //   1403: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1406: invokestatic 279	com/tencent/mobileqq/music/QQPlayerService:b	(Lcom/tencent/mobileqq/music/QQPlayerService;)Z
    //   1409: ifne +25 -> 1434
    //   1412: aload 5
    //   1414: astore 4
    //   1416: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1419: invokevirtual 180	android/media/MediaPlayer:start	()V
    //   1422: aload 5
    //   1424: astore 4
    //   1426: aload_0
    //   1427: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1430: iconst_2
    //   1431: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1434: aload 5
    //   1436: astore 4
    //   1438: aload_0
    //   1439: iconst_0
    //   1440: putfield 27	dyk:d	Z
    //   1443: aload 5
    //   1445: astore 4
    //   1447: aload 6
    //   1449: aload 7
    //   1451: invokevirtual 288	java/io/InputStream:read	([B)I
    //   1454: istore_2
    //   1455: iload_2
    //   1456: ifgt +207 -> 1663
    //   1459: aload 5
    //   1461: astore 4
    //   1463: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1466: ifeq +16 -> 1482
    //   1469: aload 5
    //   1471: astore 4
    //   1473: ldc 85
    //   1475: iconst_2
    //   1476: ldc_w 290
    //   1479: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1482: aload 5
    //   1484: astore 4
    //   1486: ldc2_w 240
    //   1489: invokestatic 245	java/lang/Thread:sleep	(J)V
    //   1492: iload_1
    //   1493: iconst_1
    //   1494: iadd
    //   1495: istore_1
    //   1496: goto -273 -> 1223
    //   1499: astore 9
    //   1501: aload 5
    //   1503: astore 4
    //   1505: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1508: ifeq -16 -> 1492
    //   1511: aload 5
    //   1513: astore 4
    //   1515: ldc 85
    //   1517: iconst_2
    //   1518: new 65	java/lang/StringBuilder
    //   1521: dup
    //   1522: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1525: ldc_w 292
    //   1528: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1531: aload 9
    //   1533: invokevirtual 248	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   1536: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1539: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1542: aload 9
    //   1544: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1547: goto -55 -> 1492
    //   1550: astore 6
    //   1552: aload 5
    //   1554: astore 4
    //   1556: aload_0
    //   1557: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1560: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   1563: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   1566: aload 5
    //   1568: astore 4
    //   1570: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1573: ifeq +39 -> 1612
    //   1576: aload 5
    //   1578: astore 4
    //   1580: ldc 85
    //   1582: iconst_2
    //   1583: new 65	java/lang/StringBuilder
    //   1586: dup
    //   1587: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1590: ldc_w 294
    //   1593: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1596: aload 6
    //   1598: invokevirtual 295	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   1601: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1604: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1607: aload 6
    //   1609: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1612: aload_0
    //   1613: iconst_0
    //   1614: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   1617: aload 5
    //   1619: ifnull +8 -> 1627
    //   1622: aload 5
    //   1624: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   1627: aload_0
    //   1628: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1631: aload_0
    //   1632: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1635: if_icmpge -1008 -> 627
    //   1638: aload_0
    //   1639: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1642: ifle -1015 -> 627
    //   1645: aload_0
    //   1646: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1649: aload_0
    //   1650: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1653: aload_0
    //   1654: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1657: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1660: goto -1033 -> 627
    //   1663: aload 5
    //   1665: astore 4
    //   1667: aload_0
    //   1668: aload_0
    //   1669: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1672: iload_2
    //   1673: iadd
    //   1674: putfield 43	dyk:jdField_a_of_type_Int	I
    //   1677: aload 5
    //   1679: astore 4
    //   1681: aload 5
    //   1683: aload 7
    //   1685: iconst_0
    //   1686: iload_2
    //   1687: invokevirtual 299	java/io/RandomAccessFile:write	([BII)V
    //   1690: iconst_0
    //   1691: istore_1
    //   1692: goto -469 -> 1223
    //   1695: aload 5
    //   1697: astore 4
    //   1699: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1702: ifeq +72 -> 1774
    //   1705: aload 5
    //   1707: astore 4
    //   1709: ldc 85
    //   1711: iconst_2
    //   1712: new 65	java/lang/StringBuilder
    //   1715: dup
    //   1716: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1719: ldc_w 301
    //   1722: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1725: aload_0
    //   1726: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1729: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1732: ldc_w 303
    //   1735: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1738: iload_1
    //   1739: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1742: ldc_w 263
    //   1745: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: aload_0
    //   1749: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1752: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1755: ldc_w 261
    //   1758: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: aload_0
    //   1762: getfield 39	dyk:jdField_c_of_type_Int	I
    //   1765: invokevirtual 208	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1768: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1774: aload 6
    //   1776: ifnull +12 -> 1788
    //   1779: aload 5
    //   1781: astore 4
    //   1783: aload 6
    //   1785: invokevirtual 304	java/io/InputStream:close	()V
    //   1788: aload 5
    //   1790: astore 4
    //   1792: aload_0
    //   1793: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1796: aload_0
    //   1797: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1800: if_icmpne +25 -> 1825
    //   1803: aload 5
    //   1805: astore 4
    //   1807: aload_0
    //   1808: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1811: ifle +14 -> 1825
    //   1814: aload 5
    //   1816: astore 4
    //   1818: aload_0
    //   1819: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1822: invokestatic 306	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;)V
    //   1825: aload_0
    //   1826: iconst_0
    //   1827: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   1830: aload 5
    //   1832: ifnull +8 -> 1840
    //   1835: aload 5
    //   1837: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   1840: aload_0
    //   1841: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1844: aload_0
    //   1845: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1848: if_icmpge -1221 -> 627
    //   1851: aload_0
    //   1852: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1855: ifle -1228 -> 627
    //   1858: aload_0
    //   1859: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1862: aload_0
    //   1863: getfield 43	dyk:jdField_a_of_type_Int	I
    //   1866: aload_0
    //   1867: getfield 41	dyk:jdField_b_of_type_Int	I
    //   1870: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   1873: goto -1246 -> 627
    //   1876: astore 6
    //   1878: aconst_null
    //   1879: astore 5
    //   1881: aload 5
    //   1883: astore 4
    //   1885: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1888: ifeq +39 -> 1927
    //   1891: aload 5
    //   1893: astore 4
    //   1895: ldc 85
    //   1897: iconst_2
    //   1898: new 65	java/lang/StringBuilder
    //   1901: dup
    //   1902: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   1905: ldc_w 308
    //   1908: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1911: aload 6
    //   1913: invokevirtual 90	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1916: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1919: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1922: aload 6
    //   1924: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1927: aload 5
    //   1929: astore 4
    //   1931: invokestatic 146	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1934: ifnull +56 -> 1990
    //   1937: aload 5
    //   1939: astore 4
    //   1941: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1944: ifnull +46 -> 1990
    //   1947: aload 5
    //   1949: astore 4
    //   1951: aload_0
    //   1952: getfield 35	dyk:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1955: invokestatic 146	com/tencent/mobileqq/music/QQPlayerService:b	()Lcom/tencent/mobileqq/music/SongInfo;
    //   1958: getfield 149	com/tencent/mobileqq/music/SongInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1961: invokevirtual 155	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1964: ifeq +26 -> 1990
    //   1967: aload 5
    //   1969: astore 4
    //   1971: invokestatic 163	com/tencent/mobileqq/music/QQPlayerService:a	()Landroid/media/MediaPlayer;
    //   1974: invokevirtual 168	android/media/MediaPlayer:reset	()V
    //   1977: aload 5
    //   1979: astore 4
    //   1981: aload_0
    //   1982: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   1985: bipush 6
    //   1987: invokestatic 183	com/tencent/mobileqq/music/QQPlayerService:a	(Lcom/tencent/mobileqq/music/QQPlayerService;I)V
    //   1990: aload 5
    //   1992: astore 4
    //   1994: invokestatic 311	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   1997: ifnull +52 -> 2049
    //   2000: aload 5
    //   2002: astore 4
    //   2004: invokestatic 311	com/tencent/mobileqq/music/QQPlayerService:b	()[Lcom/tencent/mobileqq/music/SongInfo;
    //   2007: arraylength
    //   2008: iconst_1
    //   2009: if_icmpne +40 -> 2049
    //   2012: aload 5
    //   2014: astore 4
    //   2016: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2019: ifeq +16 -> 2035
    //   2022: aload 5
    //   2024: astore 4
    //   2026: ldc 85
    //   2028: iconst_2
    //   2029: ldc_w 313
    //   2032: invokestatic 116	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2035: aload 5
    //   2037: astore 4
    //   2039: aload_0
    //   2040: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2043: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2046: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2049: aload_0
    //   2050: iconst_0
    //   2051: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   2054: aload 5
    //   2056: ifnull +8 -> 2064
    //   2059: aload 5
    //   2061: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   2064: aload_0
    //   2065: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2068: aload_0
    //   2069: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2072: if_icmpge -1445 -> 627
    //   2075: aload_0
    //   2076: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2079: ifle -1452 -> 627
    //   2082: aload_0
    //   2083: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2086: aload_0
    //   2087: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2090: aload_0
    //   2091: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2094: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2097: goto -1470 -> 627
    //   2100: astore 6
    //   2102: aconst_null
    //   2103: astore 5
    //   2105: aload 5
    //   2107: astore 4
    //   2109: aload_0
    //   2110: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2113: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2116: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2119: aload 5
    //   2121: astore 4
    //   2123: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2126: ifeq +39 -> 2165
    //   2129: aload 5
    //   2131: astore 4
    //   2133: ldc 85
    //   2135: iconst_2
    //   2136: new 65	java/lang/StringBuilder
    //   2139: dup
    //   2140: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2143: ldc_w 315
    //   2146: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2149: aload 6
    //   2151: invokevirtual 316	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   2154: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2157: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2160: aload 6
    //   2162: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2165: aload_0
    //   2166: iconst_0
    //   2167: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   2170: aload 5
    //   2172: ifnull +8 -> 2180
    //   2175: aload 5
    //   2177: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   2180: aload_0
    //   2181: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2184: aload_0
    //   2185: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2188: if_icmpge -1561 -> 627
    //   2191: aload_0
    //   2192: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2195: ifle -1568 -> 627
    //   2198: aload_0
    //   2199: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2202: aload_0
    //   2203: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2206: aload_0
    //   2207: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2210: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2213: goto -1586 -> 627
    //   2216: astore 6
    //   2218: aconst_null
    //   2219: astore 5
    //   2221: aload 5
    //   2223: astore 4
    //   2225: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2228: ifeq +39 -> 2267
    //   2231: aload 5
    //   2233: astore 4
    //   2235: ldc 85
    //   2237: iconst_2
    //   2238: new 65	java/lang/StringBuilder
    //   2241: dup
    //   2242: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   2245: ldc_w 318
    //   2248: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: aload 6
    //   2253: invokevirtual 319	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2256: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2259: invokevirtual 75	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2262: aload 6
    //   2264: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2267: aload 5
    //   2269: astore 4
    //   2271: aload_0
    //   2272: getfield 16	dyk:jdField_a_of_type_ComTencentMobileqqMusicQQPlayerService	Lcom/tencent/mobileqq/music/QQPlayerService;
    //   2275: invokevirtual 120	com/tencent/mobileqq/music/QQPlayerService:getApplicationContext	()Landroid/content/Context;
    //   2278: invokestatic 123	com/tencent/mobileqq/music/QQPlayerService:c	(Landroid/content/Context;)V
    //   2281: aload_0
    //   2282: iconst_0
    //   2283: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   2286: aload 5
    //   2288: ifnull +8 -> 2296
    //   2291: aload 5
    //   2293: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   2296: aload_0
    //   2297: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2300: aload_0
    //   2301: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2304: if_icmpge -1677 -> 627
    //   2307: aload_0
    //   2308: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2311: ifle -1684 -> 627
    //   2314: aload_0
    //   2315: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2318: aload_0
    //   2319: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2322: aload_0
    //   2323: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2326: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2329: goto -1702 -> 627
    //   2332: astore 5
    //   2334: aconst_null
    //   2335: astore 4
    //   2337: aload_0
    //   2338: iconst_0
    //   2339: putfield 25	dyk:jdField_c_of_type_Boolean	Z
    //   2342: aload 4
    //   2344: ifnull +8 -> 2352
    //   2347: aload 4
    //   2349: invokevirtual 225	java/io/RandomAccessFile:close	()V
    //   2352: aload_0
    //   2353: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2356: aload_0
    //   2357: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2360: if_icmpge +25 -> 2385
    //   2363: aload_0
    //   2364: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2367: ifle +18 -> 2385
    //   2370: aload_0
    //   2371: getfield 37	dyk:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2374: aload_0
    //   2375: getfield 43	dyk:jdField_a_of_type_Int	I
    //   2378: aload_0
    //   2379: getfield 41	dyk:jdField_b_of_type_Int	I
    //   2382: invokestatic 230	com/tencent/mobileqq/utils/MusicCacheManager:a	(Ljava/lang/String;II)V
    //   2385: aload 5
    //   2387: athrow
    //   2388: astore 4
    //   2390: goto -1943 -> 447
    //   2393: astore 4
    //   2395: goto -1420 -> 975
    //   2398: astore 4
    //   2400: goto -560 -> 1840
    //   2403: astore 4
    //   2405: goto -1811 -> 594
    //   2408: astore 4
    //   2410: goto -783 -> 1627
    //   2413: astore 4
    //   2415: goto -351 -> 2064
    //   2418: astore 4
    //   2420: goto -240 -> 2180
    //   2423: astore 4
    //   2425: goto -129 -> 2296
    //   2428: astore 4
    //   2430: goto -78 -> 2352
    //   2433: astore 5
    //   2435: goto -98 -> 2337
    //   2438: astore 6
    //   2440: goto -219 -> 2221
    //   2443: astore 6
    //   2445: goto -340 -> 2105
    //   2448: astore 6
    //   2450: goto -569 -> 1881
    //   2453: astore 6
    //   2455: aconst_null
    //   2456: astore 5
    //   2458: goto -906 -> 1552
    //   2461: astore 6
    //   2463: aconst_null
    //   2464: astore 5
    //   2466: goto -1946 -> 520
    //   2469: iconst_0
    //   2470: istore_3
    //   2471: iconst_0
    //   2472: istore_1
    //   2473: aload 6
    //   2475: astore 4
    //   2477: goto -2238 -> 239
    //   2480: aload 6
    //   2482: astore 4
    //   2484: goto -2245 -> 239
    //   2487: iconst_0
    //   2488: istore_1
    //   2489: goto -1266 -> 1223
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2492	0	this	dyk
    //   239	2250	1	i	int
    //   240	1447	2	j	int
    //   255	2216	3	k	int
    //   6	2342	4	localObject1	java.lang.Object
    //   2388	1	4	localIOException1	IOException
    //   2393	1	4	localIOException2	IOException
    //   2398	1	4	localIOException3	IOException
    //   2403	1	4	localIOException4	IOException
    //   2408	1	4	localIOException5	IOException
    //   2413	1	4	localIOException6	IOException
    //   2418	1	4	localIOException7	IOException
    //   2423	1	4	localIOException8	IOException
    //   2428	1	4	localIOException9	IOException
    //   2475	8	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   75	2217	5	localRandomAccessFile	java.io.RandomAccessFile
    //   2332	54	5	localObject2	java.lang.Object
    //   2433	1	5	localObject3	java.lang.Object
    //   2456	9	5	localObject4	java.lang.Object
    //   1	381	6	localObject5	java.lang.Object
    //   518	263	6	localFileNotFoundException2	java.io.FileNotFoundException
    //   1107	341	6	localInputStream	java.io.InputStream
    //   1550	234	6	localMalformedURLException1	java.net.MalformedURLException
    //   1876	47	6	localIOException10	IOException
    //   2100	61	6	localIllegalStateException1	java.lang.IllegalStateException
    //   2216	47	6	localException1	java.lang.Exception
    //   2438	1	6	localException2	java.lang.Exception
    //   2443	1	6	localIllegalStateException2	java.lang.IllegalStateException
    //   2448	1	6	localIOException11	IOException
    //   2453	1	6	localMalformedURLException2	java.net.MalformedURLException
    //   2461	20	6	localFileNotFoundException3	java.io.FileNotFoundException
    //   678	43	7	localInterruptedException1	java.lang.InterruptedException
    //   765	919	7	localObject6	java.lang.Object
    //   57	1265	8	localFile	File
    //   97	773	9	localURL	java.net.URL
    //   1499	44	9	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   81	99	518	java/io/FileNotFoundException
    //   103	119	518	java/io/FileNotFoundException
    //   123	130	518	java/io/FileNotFoundException
    //   134	148	518	java/io/FileNotFoundException
    //   152	158	518	java/io/FileNotFoundException
    //   162	170	518	java/io/FileNotFoundException
    //   174	180	518	java/io/FileNotFoundException
    //   184	195	518	java/io/FileNotFoundException
    //   199	205	518	java/io/FileNotFoundException
    //   209	215	518	java/io/FileNotFoundException
    //   219	227	518	java/io/FileNotFoundException
    //   231	236	518	java/io/FileNotFoundException
    //   264	274	518	java/io/FileNotFoundException
    //   278	284	518	java/io/FileNotFoundException
    //   288	297	518	java/io/FileNotFoundException
    //   301	308	518	java/io/FileNotFoundException
    //   312	323	518	java/io/FileNotFoundException
    //   327	368	518	java/io/FileNotFoundException
    //   372	377	518	java/io/FileNotFoundException
    //   381	387	518	java/io/FileNotFoundException
    //   401	407	518	java/io/FileNotFoundException
    //   411	419	518	java/io/FileNotFoundException
    //   423	432	518	java/io/FileNotFoundException
    //   485	491	518	java/io/FileNotFoundException
    //   495	503	518	java/io/FileNotFoundException
    //   507	515	518	java/io/FileNotFoundException
    //   665	671	518	java/io/FileNotFoundException
    //   684	690	518	java/io/FileNotFoundException
    //   694	725	518	java/io/FileNotFoundException
    //   734	741	518	java/io/FileNotFoundException
    //   745	752	518	java/io/FileNotFoundException
    //   756	761	518	java/io/FileNotFoundException
    //   771	778	518	java/io/FileNotFoundException
    //   788	796	518	java/io/FileNotFoundException
    //   800	806	518	java/io/FileNotFoundException
    //   810	847	518	java/io/FileNotFoundException
    //   851	856	518	java/io/FileNotFoundException
    //   860	865	518	java/io/FileNotFoundException
    //   869	879	518	java/io/FileNotFoundException
    //   883	889	518	java/io/FileNotFoundException
    //   893	902	518	java/io/FileNotFoundException
    //   906	911	518	java/io/FileNotFoundException
    //   915	921	518	java/io/FileNotFoundException
    //   929	935	518	java/io/FileNotFoundException
    //   939	947	518	java/io/FileNotFoundException
    //   951	960	518	java/io/FileNotFoundException
    //   1013	1018	518	java/io/FileNotFoundException
    //   1022	1029	518	java/io/FileNotFoundException
    //   1033	1039	518	java/io/FileNotFoundException
    //   1043	1098	518	java/io/FileNotFoundException
    //   1102	1109	518	java/io/FileNotFoundException
    //   1113	1120	518	java/io/FileNotFoundException
    //   1124	1134	518	java/io/FileNotFoundException
    //   1138	1145	518	java/io/FileNotFoundException
    //   1149	1164	518	java/io/FileNotFoundException
    //   1168	1174	518	java/io/FileNotFoundException
    //   1178	1220	518	java/io/FileNotFoundException
    //   1227	1234	518	java/io/FileNotFoundException
    //   1238	1249	518	java/io/FileNotFoundException
    //   1259	1266	518	java/io/FileNotFoundException
    //   1270	1286	518	java/io/FileNotFoundException
    //   1290	1304	518	java/io/FileNotFoundException
    //   1308	1314	518	java/io/FileNotFoundException
    //   1318	1329	518	java/io/FileNotFoundException
    //   1333	1339	518	java/io/FileNotFoundException
    //   1343	1349	518	java/io/FileNotFoundException
    //   1353	1398	518	java/io/FileNotFoundException
    //   1402	1412	518	java/io/FileNotFoundException
    //   1416	1422	518	java/io/FileNotFoundException
    //   1426	1434	518	java/io/FileNotFoundException
    //   1438	1443	518	java/io/FileNotFoundException
    //   1447	1455	518	java/io/FileNotFoundException
    //   1463	1469	518	java/io/FileNotFoundException
    //   1473	1482	518	java/io/FileNotFoundException
    //   1486	1492	518	java/io/FileNotFoundException
    //   1505	1511	518	java/io/FileNotFoundException
    //   1515	1547	518	java/io/FileNotFoundException
    //   1667	1677	518	java/io/FileNotFoundException
    //   1681	1690	518	java/io/FileNotFoundException
    //   1699	1705	518	java/io/FileNotFoundException
    //   1709	1774	518	java/io/FileNotFoundException
    //   1783	1788	518	java/io/FileNotFoundException
    //   1792	1803	518	java/io/FileNotFoundException
    //   1807	1814	518	java/io/FileNotFoundException
    //   1818	1825	518	java/io/FileNotFoundException
    //   665	671	678	java/lang/InterruptedException
    //   1486	1492	1499	java/lang/InterruptedException
    //   81	99	1550	java/net/MalformedURLException
    //   103	119	1550	java/net/MalformedURLException
    //   123	130	1550	java/net/MalformedURLException
    //   134	148	1550	java/net/MalformedURLException
    //   152	158	1550	java/net/MalformedURLException
    //   162	170	1550	java/net/MalformedURLException
    //   174	180	1550	java/net/MalformedURLException
    //   184	195	1550	java/net/MalformedURLException
    //   199	205	1550	java/net/MalformedURLException
    //   209	215	1550	java/net/MalformedURLException
    //   219	227	1550	java/net/MalformedURLException
    //   231	236	1550	java/net/MalformedURLException
    //   264	274	1550	java/net/MalformedURLException
    //   278	284	1550	java/net/MalformedURLException
    //   288	297	1550	java/net/MalformedURLException
    //   301	308	1550	java/net/MalformedURLException
    //   312	323	1550	java/net/MalformedURLException
    //   327	368	1550	java/net/MalformedURLException
    //   372	377	1550	java/net/MalformedURLException
    //   381	387	1550	java/net/MalformedURLException
    //   401	407	1550	java/net/MalformedURLException
    //   411	419	1550	java/net/MalformedURLException
    //   423	432	1550	java/net/MalformedURLException
    //   485	491	1550	java/net/MalformedURLException
    //   495	503	1550	java/net/MalformedURLException
    //   507	515	1550	java/net/MalformedURLException
    //   665	671	1550	java/net/MalformedURLException
    //   684	690	1550	java/net/MalformedURLException
    //   694	725	1550	java/net/MalformedURLException
    //   734	741	1550	java/net/MalformedURLException
    //   745	752	1550	java/net/MalformedURLException
    //   756	761	1550	java/net/MalformedURLException
    //   771	778	1550	java/net/MalformedURLException
    //   788	796	1550	java/net/MalformedURLException
    //   800	806	1550	java/net/MalformedURLException
    //   810	847	1550	java/net/MalformedURLException
    //   851	856	1550	java/net/MalformedURLException
    //   860	865	1550	java/net/MalformedURLException
    //   869	879	1550	java/net/MalformedURLException
    //   883	889	1550	java/net/MalformedURLException
    //   893	902	1550	java/net/MalformedURLException
    //   906	911	1550	java/net/MalformedURLException
    //   915	921	1550	java/net/MalformedURLException
    //   929	935	1550	java/net/MalformedURLException
    //   939	947	1550	java/net/MalformedURLException
    //   951	960	1550	java/net/MalformedURLException
    //   1013	1018	1550	java/net/MalformedURLException
    //   1022	1029	1550	java/net/MalformedURLException
    //   1033	1039	1550	java/net/MalformedURLException
    //   1043	1098	1550	java/net/MalformedURLException
    //   1102	1109	1550	java/net/MalformedURLException
    //   1113	1120	1550	java/net/MalformedURLException
    //   1124	1134	1550	java/net/MalformedURLException
    //   1138	1145	1550	java/net/MalformedURLException
    //   1149	1164	1550	java/net/MalformedURLException
    //   1168	1174	1550	java/net/MalformedURLException
    //   1178	1220	1550	java/net/MalformedURLException
    //   1227	1234	1550	java/net/MalformedURLException
    //   1238	1249	1550	java/net/MalformedURLException
    //   1259	1266	1550	java/net/MalformedURLException
    //   1270	1286	1550	java/net/MalformedURLException
    //   1290	1304	1550	java/net/MalformedURLException
    //   1308	1314	1550	java/net/MalformedURLException
    //   1318	1329	1550	java/net/MalformedURLException
    //   1333	1339	1550	java/net/MalformedURLException
    //   1343	1349	1550	java/net/MalformedURLException
    //   1353	1398	1550	java/net/MalformedURLException
    //   1402	1412	1550	java/net/MalformedURLException
    //   1416	1422	1550	java/net/MalformedURLException
    //   1426	1434	1550	java/net/MalformedURLException
    //   1438	1443	1550	java/net/MalformedURLException
    //   1447	1455	1550	java/net/MalformedURLException
    //   1463	1469	1550	java/net/MalformedURLException
    //   1473	1482	1550	java/net/MalformedURLException
    //   1486	1492	1550	java/net/MalformedURLException
    //   1505	1511	1550	java/net/MalformedURLException
    //   1515	1547	1550	java/net/MalformedURLException
    //   1667	1677	1550	java/net/MalformedURLException
    //   1681	1690	1550	java/net/MalformedURLException
    //   1699	1705	1550	java/net/MalformedURLException
    //   1709	1774	1550	java/net/MalformedURLException
    //   1783	1788	1550	java/net/MalformedURLException
    //   1792	1803	1550	java/net/MalformedURLException
    //   1807	1814	1550	java/net/MalformedURLException
    //   1818	1825	1550	java/net/MalformedURLException
    //   64	77	1876	java/io/IOException
    //   64	77	2100	java/lang/IllegalStateException
    //   64	77	2216	java/lang/Exception
    //   64	77	2332	finally
    //   442	447	2388	java/io/IOException
    //   970	975	2393	java/io/IOException
    //   1835	1840	2398	java/io/IOException
    //   589	594	2403	java/io/IOException
    //   1622	1627	2408	java/io/IOException
    //   2059	2064	2413	java/io/IOException
    //   2175	2180	2418	java/io/IOException
    //   2291	2296	2423	java/io/IOException
    //   2347	2352	2428	java/io/IOException
    //   81	99	2433	finally
    //   103	119	2433	finally
    //   123	130	2433	finally
    //   134	148	2433	finally
    //   152	158	2433	finally
    //   162	170	2433	finally
    //   174	180	2433	finally
    //   184	195	2433	finally
    //   199	205	2433	finally
    //   209	215	2433	finally
    //   219	227	2433	finally
    //   231	236	2433	finally
    //   264	274	2433	finally
    //   278	284	2433	finally
    //   288	297	2433	finally
    //   301	308	2433	finally
    //   312	323	2433	finally
    //   327	368	2433	finally
    //   372	377	2433	finally
    //   381	387	2433	finally
    //   401	407	2433	finally
    //   411	419	2433	finally
    //   423	432	2433	finally
    //   485	491	2433	finally
    //   495	503	2433	finally
    //   507	515	2433	finally
    //   524	530	2433	finally
    //   534	565	2433	finally
    //   569	579	2433	finally
    //   665	671	2433	finally
    //   684	690	2433	finally
    //   694	725	2433	finally
    //   734	741	2433	finally
    //   745	752	2433	finally
    //   756	761	2433	finally
    //   771	778	2433	finally
    //   788	796	2433	finally
    //   800	806	2433	finally
    //   810	847	2433	finally
    //   851	856	2433	finally
    //   860	865	2433	finally
    //   869	879	2433	finally
    //   883	889	2433	finally
    //   893	902	2433	finally
    //   906	911	2433	finally
    //   915	921	2433	finally
    //   929	935	2433	finally
    //   939	947	2433	finally
    //   951	960	2433	finally
    //   1013	1018	2433	finally
    //   1022	1029	2433	finally
    //   1033	1039	2433	finally
    //   1043	1098	2433	finally
    //   1102	1109	2433	finally
    //   1113	1120	2433	finally
    //   1124	1134	2433	finally
    //   1138	1145	2433	finally
    //   1149	1164	2433	finally
    //   1168	1174	2433	finally
    //   1178	1220	2433	finally
    //   1227	1234	2433	finally
    //   1238	1249	2433	finally
    //   1259	1266	2433	finally
    //   1270	1286	2433	finally
    //   1290	1304	2433	finally
    //   1308	1314	2433	finally
    //   1318	1329	2433	finally
    //   1333	1339	2433	finally
    //   1343	1349	2433	finally
    //   1353	1398	2433	finally
    //   1402	1412	2433	finally
    //   1416	1422	2433	finally
    //   1426	1434	2433	finally
    //   1438	1443	2433	finally
    //   1447	1455	2433	finally
    //   1463	1469	2433	finally
    //   1473	1482	2433	finally
    //   1486	1492	2433	finally
    //   1505	1511	2433	finally
    //   1515	1547	2433	finally
    //   1556	1566	2433	finally
    //   1570	1576	2433	finally
    //   1580	1612	2433	finally
    //   1667	1677	2433	finally
    //   1681	1690	2433	finally
    //   1699	1705	2433	finally
    //   1709	1774	2433	finally
    //   1783	1788	2433	finally
    //   1792	1803	2433	finally
    //   1807	1814	2433	finally
    //   1818	1825	2433	finally
    //   1885	1891	2433	finally
    //   1895	1927	2433	finally
    //   1931	1937	2433	finally
    //   1941	1947	2433	finally
    //   1951	1967	2433	finally
    //   1971	1977	2433	finally
    //   1981	1990	2433	finally
    //   1994	2000	2433	finally
    //   2004	2012	2433	finally
    //   2016	2022	2433	finally
    //   2026	2035	2433	finally
    //   2039	2049	2433	finally
    //   2109	2119	2433	finally
    //   2123	2129	2433	finally
    //   2133	2165	2433	finally
    //   2225	2231	2433	finally
    //   2235	2267	2433	finally
    //   2271	2281	2433	finally
    //   81	99	2438	java/lang/Exception
    //   103	119	2438	java/lang/Exception
    //   123	130	2438	java/lang/Exception
    //   134	148	2438	java/lang/Exception
    //   152	158	2438	java/lang/Exception
    //   162	170	2438	java/lang/Exception
    //   174	180	2438	java/lang/Exception
    //   184	195	2438	java/lang/Exception
    //   199	205	2438	java/lang/Exception
    //   209	215	2438	java/lang/Exception
    //   219	227	2438	java/lang/Exception
    //   231	236	2438	java/lang/Exception
    //   264	274	2438	java/lang/Exception
    //   278	284	2438	java/lang/Exception
    //   288	297	2438	java/lang/Exception
    //   301	308	2438	java/lang/Exception
    //   312	323	2438	java/lang/Exception
    //   327	368	2438	java/lang/Exception
    //   372	377	2438	java/lang/Exception
    //   381	387	2438	java/lang/Exception
    //   401	407	2438	java/lang/Exception
    //   411	419	2438	java/lang/Exception
    //   423	432	2438	java/lang/Exception
    //   485	491	2438	java/lang/Exception
    //   495	503	2438	java/lang/Exception
    //   507	515	2438	java/lang/Exception
    //   665	671	2438	java/lang/Exception
    //   684	690	2438	java/lang/Exception
    //   694	725	2438	java/lang/Exception
    //   734	741	2438	java/lang/Exception
    //   745	752	2438	java/lang/Exception
    //   756	761	2438	java/lang/Exception
    //   771	778	2438	java/lang/Exception
    //   788	796	2438	java/lang/Exception
    //   800	806	2438	java/lang/Exception
    //   810	847	2438	java/lang/Exception
    //   851	856	2438	java/lang/Exception
    //   860	865	2438	java/lang/Exception
    //   869	879	2438	java/lang/Exception
    //   883	889	2438	java/lang/Exception
    //   893	902	2438	java/lang/Exception
    //   906	911	2438	java/lang/Exception
    //   915	921	2438	java/lang/Exception
    //   929	935	2438	java/lang/Exception
    //   939	947	2438	java/lang/Exception
    //   951	960	2438	java/lang/Exception
    //   1013	1018	2438	java/lang/Exception
    //   1022	1029	2438	java/lang/Exception
    //   1033	1039	2438	java/lang/Exception
    //   1043	1098	2438	java/lang/Exception
    //   1102	1109	2438	java/lang/Exception
    //   1113	1120	2438	java/lang/Exception
    //   1124	1134	2438	java/lang/Exception
    //   1138	1145	2438	java/lang/Exception
    //   1149	1164	2438	java/lang/Exception
    //   1168	1174	2438	java/lang/Exception
    //   1178	1220	2438	java/lang/Exception
    //   1227	1234	2438	java/lang/Exception
    //   1238	1249	2438	java/lang/Exception
    //   1259	1266	2438	java/lang/Exception
    //   1270	1286	2438	java/lang/Exception
    //   1290	1304	2438	java/lang/Exception
    //   1308	1314	2438	java/lang/Exception
    //   1318	1329	2438	java/lang/Exception
    //   1333	1339	2438	java/lang/Exception
    //   1343	1349	2438	java/lang/Exception
    //   1353	1398	2438	java/lang/Exception
    //   1402	1412	2438	java/lang/Exception
    //   1416	1422	2438	java/lang/Exception
    //   1426	1434	2438	java/lang/Exception
    //   1438	1443	2438	java/lang/Exception
    //   1447	1455	2438	java/lang/Exception
    //   1463	1469	2438	java/lang/Exception
    //   1473	1482	2438	java/lang/Exception
    //   1486	1492	2438	java/lang/Exception
    //   1505	1511	2438	java/lang/Exception
    //   1515	1547	2438	java/lang/Exception
    //   1667	1677	2438	java/lang/Exception
    //   1681	1690	2438	java/lang/Exception
    //   1699	1705	2438	java/lang/Exception
    //   1709	1774	2438	java/lang/Exception
    //   1783	1788	2438	java/lang/Exception
    //   1792	1803	2438	java/lang/Exception
    //   1807	1814	2438	java/lang/Exception
    //   1818	1825	2438	java/lang/Exception
    //   81	99	2443	java/lang/IllegalStateException
    //   103	119	2443	java/lang/IllegalStateException
    //   123	130	2443	java/lang/IllegalStateException
    //   134	148	2443	java/lang/IllegalStateException
    //   152	158	2443	java/lang/IllegalStateException
    //   162	170	2443	java/lang/IllegalStateException
    //   174	180	2443	java/lang/IllegalStateException
    //   184	195	2443	java/lang/IllegalStateException
    //   199	205	2443	java/lang/IllegalStateException
    //   209	215	2443	java/lang/IllegalStateException
    //   219	227	2443	java/lang/IllegalStateException
    //   231	236	2443	java/lang/IllegalStateException
    //   264	274	2443	java/lang/IllegalStateException
    //   278	284	2443	java/lang/IllegalStateException
    //   288	297	2443	java/lang/IllegalStateException
    //   301	308	2443	java/lang/IllegalStateException
    //   312	323	2443	java/lang/IllegalStateException
    //   327	368	2443	java/lang/IllegalStateException
    //   372	377	2443	java/lang/IllegalStateException
    //   381	387	2443	java/lang/IllegalStateException
    //   401	407	2443	java/lang/IllegalStateException
    //   411	419	2443	java/lang/IllegalStateException
    //   423	432	2443	java/lang/IllegalStateException
    //   485	491	2443	java/lang/IllegalStateException
    //   495	503	2443	java/lang/IllegalStateException
    //   507	515	2443	java/lang/IllegalStateException
    //   665	671	2443	java/lang/IllegalStateException
    //   684	690	2443	java/lang/IllegalStateException
    //   694	725	2443	java/lang/IllegalStateException
    //   734	741	2443	java/lang/IllegalStateException
    //   745	752	2443	java/lang/IllegalStateException
    //   756	761	2443	java/lang/IllegalStateException
    //   771	778	2443	java/lang/IllegalStateException
    //   788	796	2443	java/lang/IllegalStateException
    //   800	806	2443	java/lang/IllegalStateException
    //   810	847	2443	java/lang/IllegalStateException
    //   851	856	2443	java/lang/IllegalStateException
    //   860	865	2443	java/lang/IllegalStateException
    //   869	879	2443	java/lang/IllegalStateException
    //   883	889	2443	java/lang/IllegalStateException
    //   893	902	2443	java/lang/IllegalStateException
    //   906	911	2443	java/lang/IllegalStateException
    //   915	921	2443	java/lang/IllegalStateException
    //   929	935	2443	java/lang/IllegalStateException
    //   939	947	2443	java/lang/IllegalStateException
    //   951	960	2443	java/lang/IllegalStateException
    //   1013	1018	2443	java/lang/IllegalStateException
    //   1022	1029	2443	java/lang/IllegalStateException
    //   1033	1039	2443	java/lang/IllegalStateException
    //   1043	1098	2443	java/lang/IllegalStateException
    //   1102	1109	2443	java/lang/IllegalStateException
    //   1113	1120	2443	java/lang/IllegalStateException
    //   1124	1134	2443	java/lang/IllegalStateException
    //   1138	1145	2443	java/lang/IllegalStateException
    //   1149	1164	2443	java/lang/IllegalStateException
    //   1168	1174	2443	java/lang/IllegalStateException
    //   1178	1220	2443	java/lang/IllegalStateException
    //   1227	1234	2443	java/lang/IllegalStateException
    //   1238	1249	2443	java/lang/IllegalStateException
    //   1259	1266	2443	java/lang/IllegalStateException
    //   1270	1286	2443	java/lang/IllegalStateException
    //   1290	1304	2443	java/lang/IllegalStateException
    //   1308	1314	2443	java/lang/IllegalStateException
    //   1318	1329	2443	java/lang/IllegalStateException
    //   1333	1339	2443	java/lang/IllegalStateException
    //   1343	1349	2443	java/lang/IllegalStateException
    //   1353	1398	2443	java/lang/IllegalStateException
    //   1402	1412	2443	java/lang/IllegalStateException
    //   1416	1422	2443	java/lang/IllegalStateException
    //   1426	1434	2443	java/lang/IllegalStateException
    //   1438	1443	2443	java/lang/IllegalStateException
    //   1447	1455	2443	java/lang/IllegalStateException
    //   1463	1469	2443	java/lang/IllegalStateException
    //   1473	1482	2443	java/lang/IllegalStateException
    //   1486	1492	2443	java/lang/IllegalStateException
    //   1505	1511	2443	java/lang/IllegalStateException
    //   1515	1547	2443	java/lang/IllegalStateException
    //   1667	1677	2443	java/lang/IllegalStateException
    //   1681	1690	2443	java/lang/IllegalStateException
    //   1699	1705	2443	java/lang/IllegalStateException
    //   1709	1774	2443	java/lang/IllegalStateException
    //   1783	1788	2443	java/lang/IllegalStateException
    //   1792	1803	2443	java/lang/IllegalStateException
    //   1807	1814	2443	java/lang/IllegalStateException
    //   1818	1825	2443	java/lang/IllegalStateException
    //   81	99	2448	java/io/IOException
    //   103	119	2448	java/io/IOException
    //   123	130	2448	java/io/IOException
    //   134	148	2448	java/io/IOException
    //   152	158	2448	java/io/IOException
    //   162	170	2448	java/io/IOException
    //   174	180	2448	java/io/IOException
    //   184	195	2448	java/io/IOException
    //   199	205	2448	java/io/IOException
    //   209	215	2448	java/io/IOException
    //   219	227	2448	java/io/IOException
    //   231	236	2448	java/io/IOException
    //   264	274	2448	java/io/IOException
    //   278	284	2448	java/io/IOException
    //   288	297	2448	java/io/IOException
    //   301	308	2448	java/io/IOException
    //   312	323	2448	java/io/IOException
    //   327	368	2448	java/io/IOException
    //   372	377	2448	java/io/IOException
    //   381	387	2448	java/io/IOException
    //   401	407	2448	java/io/IOException
    //   411	419	2448	java/io/IOException
    //   423	432	2448	java/io/IOException
    //   485	491	2448	java/io/IOException
    //   495	503	2448	java/io/IOException
    //   507	515	2448	java/io/IOException
    //   665	671	2448	java/io/IOException
    //   684	690	2448	java/io/IOException
    //   694	725	2448	java/io/IOException
    //   734	741	2448	java/io/IOException
    //   745	752	2448	java/io/IOException
    //   756	761	2448	java/io/IOException
    //   771	778	2448	java/io/IOException
    //   788	796	2448	java/io/IOException
    //   800	806	2448	java/io/IOException
    //   810	847	2448	java/io/IOException
    //   851	856	2448	java/io/IOException
    //   860	865	2448	java/io/IOException
    //   869	879	2448	java/io/IOException
    //   883	889	2448	java/io/IOException
    //   893	902	2448	java/io/IOException
    //   906	911	2448	java/io/IOException
    //   915	921	2448	java/io/IOException
    //   929	935	2448	java/io/IOException
    //   939	947	2448	java/io/IOException
    //   951	960	2448	java/io/IOException
    //   1013	1018	2448	java/io/IOException
    //   1022	1029	2448	java/io/IOException
    //   1033	1039	2448	java/io/IOException
    //   1043	1098	2448	java/io/IOException
    //   1102	1109	2448	java/io/IOException
    //   1113	1120	2448	java/io/IOException
    //   1124	1134	2448	java/io/IOException
    //   1138	1145	2448	java/io/IOException
    //   1149	1164	2448	java/io/IOException
    //   1168	1174	2448	java/io/IOException
    //   1178	1220	2448	java/io/IOException
    //   1227	1234	2448	java/io/IOException
    //   1238	1249	2448	java/io/IOException
    //   1259	1266	2448	java/io/IOException
    //   1270	1286	2448	java/io/IOException
    //   1290	1304	2448	java/io/IOException
    //   1308	1314	2448	java/io/IOException
    //   1318	1329	2448	java/io/IOException
    //   1333	1339	2448	java/io/IOException
    //   1343	1349	2448	java/io/IOException
    //   1353	1398	2448	java/io/IOException
    //   1402	1412	2448	java/io/IOException
    //   1416	1422	2448	java/io/IOException
    //   1426	1434	2448	java/io/IOException
    //   1438	1443	2448	java/io/IOException
    //   1447	1455	2448	java/io/IOException
    //   1463	1469	2448	java/io/IOException
    //   1473	1482	2448	java/io/IOException
    //   1486	1492	2448	java/io/IOException
    //   1505	1511	2448	java/io/IOException
    //   1515	1547	2448	java/io/IOException
    //   1667	1677	2448	java/io/IOException
    //   1681	1690	2448	java/io/IOException
    //   1699	1705	2448	java/io/IOException
    //   1709	1774	2448	java/io/IOException
    //   1783	1788	2448	java/io/IOException
    //   1792	1803	2448	java/io/IOException
    //   1807	1814	2448	java/io/IOException
    //   1818	1825	2448	java/io/IOException
    //   64	77	2453	java/net/MalformedURLException
    //   64	77	2461	java/io/FileNotFoundException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dyk
 * JD-Core Version:    0.7.0.1
 */