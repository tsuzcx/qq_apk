import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.DataUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;

public class awda
  extends HttpDownloadUtil
{
  private static final int eAf = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneOfflineDecodePhotoQuality", 90);
  
  public static String G(String paramString, boolean paramBoolean)
  {
    paramString = H(paramString, paramBoolean);
    if (paramString != null) {
      return paramString.toLowerCase();
    }
    return "";
  }
  
  private static String H(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return "";
    }
    localObject3 = new File(paramString);
    if ((!((File)localObject3).exists()) || (!((File)localObject3).isFile()))
    {
      QLog.w("QZoneHttpDownloadUtil", 2, "encode-File does not exist or is not file:" + paramString);
      return "";
    }
    localObject2 = null;
    paramString = null;
    str2 = paramString;
    localObject1 = localObject2;
    try
    {
      localObject3 = new BufferedInputStream(new FileInputStream((File)localObject3), 8192);
      if (!paramBoolean) {
        break label209;
      }
      str2 = paramString;
      localObject1 = localObject2;
      paramString = new GZIPInputStream((InputStream)localObject3);
    }
    catch (Exception paramString) {}finally
    {
      int i;
      String str1;
      DataUtils.closeDataObject(str1);
    }
    str2 = paramString;
    localObject1 = paramString;
    localObject3 = MessageDigest.getInstance("MD5");
    str2 = paramString;
    localObject1 = paramString;
  }
  
  /* Error */
  private static int a(AppInterface paramAppInterface, URL paramURL, File paramFile, NetworkInfo paramNetworkInfo, int paramInt1, String paramString, int paramInt2)
  {
    // Byte code:
    //   0: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   3: lstore 18
    //   5: new 155	java/lang/Object
    //   8: dup
    //   9: invokespecial 156	java/lang/Object:<init>	()V
    //   12: astore 31
    //   14: aload_2
    //   15: ifnonnull +13 -> 28
    //   18: ldc 61
    //   20: iconst_1
    //   21: ldc 158
    //   23: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: iconst_4
    //   27: ireturn
    //   28: iload 4
    //   30: istore 12
    //   32: iload 4
    //   34: ifge +6 -> 40
    //   37: iconst_2
    //   38: istore 12
    //   40: aload_2
    //   41: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull +15 -> 61
    //   49: aload_0
    //   50: invokevirtual 56	java/io/File:exists	()Z
    //   53: ifne +8 -> 61
    //   56: aload_0
    //   57: invokevirtual 168	java/io/File:mkdirs	()Z
    //   60: pop
    //   61: aconst_null
    //   62: astore_0
    //   63: aload_1
    //   64: invokevirtual 171	java/net/URL:toString	()Ljava/lang/String;
    //   67: astore 30
    //   69: aload 30
    //   71: ldc 173
    //   73: invokestatic 177	awda:cr	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   76: astore 32
    //   78: new 179	org/apache/http/client/methods/HttpGet
    //   81: dup
    //   82: aload 30
    //   84: invokespecial 180	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   87: astore 28
    //   89: new 182	org/apache/http/params/BasicHttpParams
    //   92: dup
    //   93: invokespecial 183	org/apache/http/params/BasicHttpParams:<init>	()V
    //   96: astore 33
    //   98: sipush 20000
    //   101: istore 7
    //   103: ldc 184
    //   105: istore 4
    //   107: aload_3
    //   108: ifnull +101 -> 209
    //   111: invokestatic 189	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   114: astore 23
    //   116: invokestatic 192	android/net/Proxy:getDefaultPort	()I
    //   119: istore 4
    //   121: aload_3
    //   122: invokevirtual 197	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   125: astore 24
    //   127: aload_3
    //   128: invokestatic 203	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   131: ifeq +49 -> 180
    //   134: aload 24
    //   136: ifnull +13 -> 149
    //   139: aload 24
    //   141: ldc 205
    //   143: invokevirtual 209	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   146: ifeq +34 -> 180
    //   149: aload 23
    //   151: ifnull +29 -> 180
    //   154: iload 4
    //   156: ifle +24 -> 180
    //   159: aload 33
    //   161: ldc 211
    //   163: new 213	org/apache/http/HttpHost
    //   166: dup
    //   167: aload 23
    //   169: iload 4
    //   171: invokespecial 216	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   174: invokeinterface 222 3 0
    //   179: pop
    //   180: aload_3
    //   181: invokestatic 203	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   184: ifeq +2231 -> 2415
    //   187: sipush 20000
    //   190: istore 7
    //   192: ldc 184
    //   194: istore 4
    //   196: aload 33
    //   198: ldc 224
    //   200: sipush 2048
    //   203: invokeinterface 228 3 0
    //   208: pop
    //   209: aload 33
    //   211: ldc 230
    //   213: iload 7
    //   215: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: invokeinterface 222 3 0
    //   223: pop
    //   224: aload 33
    //   226: ldc 238
    //   228: iload 4
    //   230: invokestatic 236	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   233: invokeinterface 222 3 0
    //   238: pop
    //   239: aload 28
    //   241: aload 33
    //   243: invokevirtual 242	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   246: new 48	java/io/File
    //   249: dup
    //   250: new 63	java/lang/StringBuilder
    //   253: dup
    //   254: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   257: aload_2
    //   258: invokevirtual 245	java/io/File:getPath	()Ljava/lang/String;
    //   261: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: ldc 247
    //   266: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   275: astore 34
    //   277: aload_2
    //   278: ifnull +15 -> 293
    //   281: aload_2
    //   282: invokevirtual 56	java/io/File:exists	()Z
    //   285: ifeq +8 -> 293
    //   288: aload_2
    //   289: invokevirtual 250	java/io/File:delete	()Z
    //   292: pop
    //   293: aload 34
    //   295: ifnull +17 -> 312
    //   298: aload 34
    //   300: invokevirtual 56	java/io/File:exists	()Z
    //   303: ifeq +9 -> 312
    //   306: aload 34
    //   308: invokevirtual 250	java/io/File:delete	()Z
    //   311: pop
    //   312: aconst_null
    //   313: astore_3
    //   314: iconst_m1
    //   315: istore 13
    //   317: iload 13
    //   319: ifne +35 -> 354
    //   322: aload 33
    //   324: ldc 211
    //   326: new 213	org/apache/http/HttpHost
    //   329: dup
    //   330: aload_1
    //   331: invokevirtual 253	java/net/URL:getHost	()Ljava/lang/String;
    //   334: aload_1
    //   335: invokevirtual 256	java/net/URL:getPort	()I
    //   338: invokespecial 216	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   341: invokeinterface 222 3 0
    //   346: pop
    //   347: aload 28
    //   349: aload 33
    //   351: invokevirtual 242	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   354: iconst_5
    //   355: istore 4
    //   357: aload_3
    //   358: astore 26
    //   360: aload_0
    //   361: astore 25
    //   363: iload 4
    //   365: istore 8
    //   367: aload 30
    //   369: iload 6
    //   371: invokestatic 262	awfu:aX	(Ljava/lang/String;I)Ljava/lang/String;
    //   374: astore 23
    //   376: aload 23
    //   378: ifnull +57 -> 435
    //   381: aload_3
    //   382: astore 26
    //   384: aload_0
    //   385: astore 25
    //   387: iload 4
    //   389: istore 8
    //   391: aload 28
    //   393: ldc_w 264
    //   396: aload 23
    //   398: invokevirtual 268	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload_3
    //   402: astore 26
    //   404: aload_0
    //   405: astore 25
    //   407: iload 4
    //   409: istore 8
    //   411: new 63	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 270
    //   421: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 23
    //   426: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: invokestatic 273	awfu:abg	(Ljava/lang/String;)V
    //   435: aload_3
    //   436: astore 26
    //   438: aload_0
    //   439: astore 25
    //   441: iload 4
    //   443: istore 8
    //   445: invokestatic 276	awfu:aMv	()Z
    //   448: ifeq +24 -> 472
    //   451: aload_3
    //   452: astore 26
    //   454: aload_0
    //   455: astore 25
    //   457: iload 4
    //   459: istore 8
    //   461: aload 28
    //   463: ldc_w 278
    //   466: ldc_w 280
    //   469: invokevirtual 268	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload_3
    //   473: astore 26
    //   475: aload_0
    //   476: astore 25
    //   478: iload 4
    //   480: istore 8
    //   482: aload 28
    //   484: ldc_w 282
    //   487: aload 5
    //   489: invokevirtual 268	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   492: aload_3
    //   493: astore 26
    //   495: aload_0
    //   496: astore 25
    //   498: iload 4
    //   500: istore 8
    //   502: new 63	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   509: ldc_w 284
    //   512: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: aload 5
    //   517: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   523: invokestatic 273	awfu:abg	(Ljava/lang/String;)V
    //   526: aload_3
    //   527: astore 26
    //   529: aload_0
    //   530: astore 25
    //   532: iload 4
    //   534: istore 8
    //   536: getstatic 288	awda:c	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   539: new 213	org/apache/http/HttpHost
    //   542: dup
    //   543: aload_1
    //   544: invokevirtual 253	java/net/URL:getHost	()Ljava/lang/String;
    //   547: invokespecial 289	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   550: aload 28
    //   552: invokevirtual 295	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;)Lorg/apache/http/HttpResponse;
    //   555: astore 23
    //   557: aload_3
    //   558: astore 26
    //   560: aload_0
    //   561: astore 25
    //   563: iload 4
    //   565: istore 8
    //   567: aload 23
    //   569: invokeinterface 301 1 0
    //   574: astore 24
    //   576: aload_3
    //   577: astore 26
    //   579: aload_0
    //   580: astore 25
    //   582: iload 4
    //   584: istore 8
    //   586: aload 23
    //   588: invokeinterface 305 1 0
    //   593: astore 35
    //   595: aload_3
    //   596: astore 26
    //   598: aload_0
    //   599: astore 25
    //   601: iload 4
    //   603: istore 8
    //   605: new 307	java/util/HashMap
    //   608: dup
    //   609: invokespecial 308	java/util/HashMap:<init>	()V
    //   612: astore 36
    //   614: aload_3
    //   615: astore 26
    //   617: aload_0
    //   618: astore 25
    //   620: iload 4
    //   622: istore 8
    //   624: aload 24
    //   626: invokeinterface 313 1 0
    //   631: istore 9
    //   633: aload_3
    //   634: astore 26
    //   636: aload_0
    //   637: astore 25
    //   639: iload 4
    //   641: istore 8
    //   643: aload 23
    //   645: invokeinterface 317 1 0
    //   650: astore 23
    //   652: aload 23
    //   654: astore_3
    //   655: iload 9
    //   657: istore 7
    //   659: aload_0
    //   660: astore 24
    //   662: sipush 200
    //   665: iload 9
    //   667: if_icmpne +1490 -> 2157
    //   670: aload_0
    //   671: astore 23
    //   673: iload 4
    //   675: istore 9
    //   677: aload_0
    //   678: astore 25
    //   680: iload 4
    //   682: istore 10
    //   684: aload_0
    //   685: astore 27
    //   687: iload 4
    //   689: istore 11
    //   691: aload_0
    //   692: astore 24
    //   694: iload 4
    //   696: istore 8
    //   698: aload_3
    //   699: astore 26
    //   701: aload_3
    //   702: invokeinterface 322 1 0
    //   707: lstore 20
    //   709: lconst_0
    //   710: lstore 14
    //   712: aload_0
    //   713: astore 25
    //   715: iload 4
    //   717: istore 10
    //   719: aload_0
    //   720: astore 27
    //   722: iload 4
    //   724: istore 11
    //   726: aload_0
    //   727: astore 24
    //   729: iload 4
    //   731: istore 8
    //   733: aload_3
    //   734: astore 26
    //   736: new 324	java/io/BufferedOutputStream
    //   739: dup
    //   740: new 326	java/io/FileOutputStream
    //   743: dup
    //   744: aload_2
    //   745: invokespecial 327	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   748: invokespecial 330	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   751: astore 23
    //   753: aload 23
    //   755: astore 24
    //   757: iload 4
    //   759: istore 8
    //   761: aload 23
    //   763: astore 25
    //   765: iload 4
    //   767: istore 7
    //   769: aload 23
    //   771: astore 26
    //   773: iload 4
    //   775: istore 9
    //   777: aload_3
    //   778: aload 23
    //   780: invokeinterface 333 2 0
    //   785: aload 23
    //   787: astore 24
    //   789: iload 4
    //   791: istore 8
    //   793: aload 23
    //   795: astore 25
    //   797: iload 4
    //   799: istore 7
    //   801: aload 23
    //   803: astore 26
    //   805: iload 4
    //   807: istore 9
    //   809: aload 23
    //   811: invokevirtual 338	java/io/OutputStream:flush	()V
    //   814: aload 23
    //   816: astore 24
    //   818: iload 4
    //   820: istore 8
    //   822: aload 23
    //   824: astore 25
    //   826: iload 4
    //   828: istore 7
    //   830: aload 23
    //   832: astore 26
    //   834: iload 4
    //   836: istore 9
    //   838: aload_2
    //   839: invokevirtual 340	java/io/File:length	()J
    //   842: lstore 16
    //   844: lload 16
    //   846: lstore 14
    //   848: aload 23
    //   850: astore 24
    //   852: iload 4
    //   854: istore 8
    //   856: aload 23
    //   858: astore 25
    //   860: iload 4
    //   862: istore 7
    //   864: aload 23
    //   866: astore 26
    //   868: iload 4
    //   870: istore 9
    //   872: aload_2
    //   873: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   876: invokevirtual 344	java/io/File:setLastModified	(J)Z
    //   879: pop
    //   880: aload 23
    //   882: astore 24
    //   884: iload 4
    //   886: istore 8
    //   888: aload 23
    //   890: astore 25
    //   892: iload 4
    //   894: istore 7
    //   896: aload 23
    //   898: astore 26
    //   900: iload 4
    //   902: istore 9
    //   904: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   907: ifeq +79 -> 986
    //   910: aload 23
    //   912: astore 24
    //   914: iload 4
    //   916: istore 8
    //   918: aload 23
    //   920: astore 25
    //   922: iload 4
    //   924: istore 7
    //   926: aload 23
    //   928: astore 26
    //   930: iload 4
    //   932: istore 9
    //   934: ldc 61
    //   936: iconst_2
    //   937: new 63	java/lang/StringBuilder
    //   940: dup
    //   941: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   944: ldc_w 346
    //   947: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   950: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   953: lload 18
    //   955: lsub
    //   956: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   959: ldc_w 351
    //   962: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   965: lload 14
    //   967: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   970: ldc_w 353
    //   973: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   976: aload_1
    //   977: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   980: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   983: invokestatic 359	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: iconst_0
    //   987: istore 7
    //   989: iload 7
    //   991: istore 4
    //   993: aload 32
    //   995: ifnull +100 -> 1095
    //   998: iload 7
    //   1000: istore 4
    //   1002: aload 32
    //   1004: invokevirtual 46	java/lang/String:length	()I
    //   1007: ifeq +88 -> 1095
    //   1010: aload_2
    //   1011: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1014: ldc_w 280
    //   1017: aload 35
    //   1019: ldc_w 364
    //   1022: invokestatic 367	awda:a	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1025: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1028: invokestatic 372	awda:G	(Ljava/lang/String;Z)Ljava/lang/String;
    //   1031: astore_0
    //   1032: iload 7
    //   1034: istore 4
    //   1036: aload_0
    //   1037: ifnull +58 -> 1095
    //   1040: iload 7
    //   1042: istore 4
    //   1044: aload_0
    //   1045: aload 32
    //   1047: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1050: ifne +45 -> 1095
    //   1053: ldc 61
    //   1055: iconst_2
    //   1056: new 63	java/lang/StringBuilder
    //   1059: dup
    //   1060: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1063: ldc_w 377
    //   1066: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload 30
    //   1071: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: ldc_w 379
    //   1077: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1080: aload_0
    //   1081: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1084: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1087: invokestatic 80	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1090: sipush -999
    //   1093: istore 4
    //   1095: aload 23
    //   1097: astore_0
    //   1098: iload 4
    //   1100: istore 7
    //   1102: lload 20
    //   1104: lconst_0
    //   1105: lcmp
    //   1106: ifle +136 -> 1242
    //   1109: iload 4
    //   1111: istore 7
    //   1113: lload 14
    //   1115: lload 20
    //   1117: lcmp
    //   1118: ifge +124 -> 1242
    //   1121: aload_0
    //   1122: astore 23
    //   1124: iload 4
    //   1126: istore 9
    //   1128: aload_0
    //   1129: astore 25
    //   1131: iload 4
    //   1133: istore 10
    //   1135: aload_0
    //   1136: astore 27
    //   1138: iload 4
    //   1140: istore 11
    //   1142: aload_0
    //   1143: astore 24
    //   1145: iload 4
    //   1147: istore 8
    //   1149: aload_3
    //   1150: astore 26
    //   1152: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1155: ifeq +2856 -> 4011
    //   1158: aload_0
    //   1159: astore 23
    //   1161: iload 4
    //   1163: istore 9
    //   1165: aload_0
    //   1166: astore 25
    //   1168: iload 4
    //   1170: istore 10
    //   1172: aload_0
    //   1173: astore 27
    //   1175: iload 4
    //   1177: istore 11
    //   1179: aload_0
    //   1180: astore 24
    //   1182: iload 4
    //   1184: istore 8
    //   1186: aload_3
    //   1187: astore 26
    //   1189: ldc 61
    //   1191: iconst_2
    //   1192: new 63	java/lang/StringBuilder
    //   1195: dup
    //   1196: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   1199: ldc_w 381
    //   1202: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1205: lload 20
    //   1207: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1210: ldc_w 383
    //   1213: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload_2
    //   1217: invokevirtual 340	java/io/File:length	()J
    //   1220: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1223: ldc_w 385
    //   1226: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: aload_1
    //   1230: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1233: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1236: invokestatic 80	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1239: goto +2772 -> 4011
    //   1242: iload 7
    //   1244: ifne +2124 -> 3368
    //   1247: aload_0
    //   1248: astore 23
    //   1250: iload 7
    //   1252: istore 9
    //   1254: aload_0
    //   1255: astore 25
    //   1257: iload 7
    //   1259: istore 10
    //   1261: aload_0
    //   1262: astore 27
    //   1264: iload 7
    //   1266: istore 11
    //   1268: aload_0
    //   1269: astore 24
    //   1271: iload 7
    //   1273: istore 8
    //   1275: aload_3
    //   1276: astore 26
    //   1278: ldc_w 387
    //   1281: aload 35
    //   1283: ldc_w 389
    //   1286: invokestatic 367	awda:a	([Lorg/apache/http/Header;Ljava/lang/String;)Ljava/lang/String;
    //   1289: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1292: ifeq +819 -> 2111
    //   1295: aload_0
    //   1296: astore 23
    //   1298: iload 7
    //   1300: istore 9
    //   1302: aload_0
    //   1303: astore 25
    //   1305: iload 7
    //   1307: istore 10
    //   1309: aload_0
    //   1310: astore 27
    //   1312: iload 7
    //   1314: istore 11
    //   1316: aload_0
    //   1317: astore 24
    //   1319: iload 7
    //   1321: istore 8
    //   1323: aload_3
    //   1324: astore 26
    //   1326: invokestatic 395	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   1329: invokestatic 401	aszy:cv	(Landroid/content/Context;)Z
    //   1332: ifeq +1786 -> 3118
    //   1335: aload_0
    //   1336: astore 23
    //   1338: iload 7
    //   1340: istore 9
    //   1342: aload_0
    //   1343: astore 25
    //   1345: iload 7
    //   1347: istore 10
    //   1349: aload_0
    //   1350: astore 27
    //   1352: iload 7
    //   1354: istore 11
    //   1356: aload_0
    //   1357: astore 24
    //   1359: iload 7
    //   1361: istore 8
    //   1363: aload_3
    //   1364: astore 26
    //   1366: aload 30
    //   1368: invokestatic 405	awfu:getFileExt	(Ljava/lang/String;)Ljava/lang/String;
    //   1371: astore 38
    //   1373: aload_0
    //   1374: astore 23
    //   1376: iload 7
    //   1378: istore 9
    //   1380: aload_0
    //   1381: astore 25
    //   1383: iload 7
    //   1385: istore 10
    //   1387: aload_0
    //   1388: astore 27
    //   1390: iload 7
    //   1392: istore 11
    //   1394: aload_0
    //   1395: astore 24
    //   1397: iload 7
    //   1399: istore 8
    //   1401: aload_3
    //   1402: astore 26
    //   1404: ldc_w 407
    //   1407: aload 38
    //   1409: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1412: ifne +87 -> 1499
    //   1415: aload_0
    //   1416: astore 23
    //   1418: iload 7
    //   1420: istore 9
    //   1422: aload_0
    //   1423: astore 25
    //   1425: iload 7
    //   1427: istore 10
    //   1429: aload_0
    //   1430: astore 27
    //   1432: iload 7
    //   1434: istore 11
    //   1436: aload_0
    //   1437: astore 24
    //   1439: iload 7
    //   1441: istore 8
    //   1443: aload_3
    //   1444: astore 26
    //   1446: ldc_w 409
    //   1449: aload 38
    //   1451: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1454: ifne +45 -> 1499
    //   1457: aload_0
    //   1458: astore 23
    //   1460: iload 7
    //   1462: istore 9
    //   1464: aload_0
    //   1465: astore 25
    //   1467: iload 7
    //   1469: istore 10
    //   1471: aload_0
    //   1472: astore 27
    //   1474: iload 7
    //   1476: istore 11
    //   1478: aload_0
    //   1479: astore 24
    //   1481: iload 7
    //   1483: istore 8
    //   1485: aload_3
    //   1486: astore 26
    //   1488: ldc_w 411
    //   1491: aload 38
    //   1493: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1496: ifeq +615 -> 2111
    //   1499: aload_0
    //   1500: astore 23
    //   1502: iload 7
    //   1504: istore 9
    //   1506: aload_0
    //   1507: astore 25
    //   1509: iload 7
    //   1511: istore 10
    //   1513: aload_0
    //   1514: astore 27
    //   1516: iload 7
    //   1518: istore 11
    //   1520: aload_0
    //   1521: astore 24
    //   1523: iload 7
    //   1525: istore 8
    //   1527: aload_3
    //   1528: astore 26
    //   1530: aload_2
    //   1531: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1534: astore 37
    //   1536: aload_0
    //   1537: astore 23
    //   1539: iload 7
    //   1541: istore 9
    //   1543: aload_0
    //   1544: astore 25
    //   1546: iload 7
    //   1548: istore 10
    //   1550: aload_0
    //   1551: astore 27
    //   1553: iload 7
    //   1555: istore 11
    //   1557: aload_0
    //   1558: astore 24
    //   1560: iload 7
    //   1562: istore 8
    //   1564: aload_3
    //   1565: astore 26
    //   1567: aload_2
    //   1568: invokestatic 415	aszy:f	(Ljava/io/File;)Ljava/io/File;
    //   1571: astore 39
    //   1573: aload_0
    //   1574: astore 23
    //   1576: iload 7
    //   1578: istore 9
    //   1580: aload_0
    //   1581: astore 25
    //   1583: iload 7
    //   1585: istore 10
    //   1587: aload_0
    //   1588: astore 27
    //   1590: iload 7
    //   1592: istore 11
    //   1594: aload_0
    //   1595: astore 24
    //   1597: iload 7
    //   1599: istore 8
    //   1601: aload_3
    //   1602: astore 26
    //   1604: aload 39
    //   1606: invokevirtual 362	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1609: invokestatic 421	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1612: astore 40
    //   1614: aload_0
    //   1615: astore 23
    //   1617: iload 7
    //   1619: istore 9
    //   1621: aload_0
    //   1622: astore 25
    //   1624: iload 7
    //   1626: istore 10
    //   1628: aload_0
    //   1629: astore 27
    //   1631: iload 7
    //   1633: istore 11
    //   1635: aload_0
    //   1636: astore 24
    //   1638: iload 7
    //   1640: istore 8
    //   1642: aload_3
    //   1643: astore 26
    //   1645: new 48	java/io/File
    //   1648: dup
    //   1649: aload 37
    //   1651: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
    //   1654: astore 41
    //   1656: aload 40
    //   1658: ifnull +1246 -> 2904
    //   1661: aload_0
    //   1662: astore 23
    //   1664: iload 7
    //   1666: istore 9
    //   1668: aload_0
    //   1669: astore 25
    //   1671: iload 7
    //   1673: istore 10
    //   1675: aload_0
    //   1676: astore 27
    //   1678: iload 7
    //   1680: istore 11
    //   1682: aload_0
    //   1683: astore 24
    //   1685: iload 7
    //   1687: istore 8
    //   1689: aload_3
    //   1690: astore 26
    //   1692: ldc_w 411
    //   1695: aload 38
    //   1697: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1700: ifeq +880 -> 2580
    //   1703: aload_0
    //   1704: astore 23
    //   1706: iload 7
    //   1708: istore 9
    //   1710: aload_0
    //   1711: astore 25
    //   1713: iload 7
    //   1715: istore 10
    //   1717: aload_0
    //   1718: astore 27
    //   1720: iload 7
    //   1722: istore 11
    //   1724: aload_0
    //   1725: astore 24
    //   1727: iload 7
    //   1729: istore 8
    //   1731: aload_3
    //   1732: astore 26
    //   1734: getstatic 427	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   1737: astore 29
    //   1739: aload_0
    //   1740: astore 23
    //   1742: iload 7
    //   1744: istore 9
    //   1746: aload_0
    //   1747: astore 25
    //   1749: iload 7
    //   1751: istore 10
    //   1753: aload_0
    //   1754: astore 27
    //   1756: iload 7
    //   1758: istore 11
    //   1760: aload_0
    //   1761: astore 24
    //   1763: iload 7
    //   1765: istore 8
    //   1767: aload_3
    //   1768: astore 26
    //   1770: aload 40
    //   1772: aload 37
    //   1774: aload 29
    //   1776: getstatic 24	awda:eAf	I
    //   1779: iconst_1
    //   1780: invokestatic 433	awcr:saveBitmapToFile	(Landroid/graphics/Bitmap;Ljava/lang/String;Landroid/graphics/Bitmap$CompressFormat;IZ)Z
    //   1783: ifeq +836 -> 2619
    //   1786: aload_0
    //   1787: astore 23
    //   1789: iload 7
    //   1791: istore 9
    //   1793: aload_0
    //   1794: astore 25
    //   1796: iload 7
    //   1798: istore 10
    //   1800: aload_0
    //   1801: astore 27
    //   1803: iload 7
    //   1805: istore 11
    //   1807: aload_0
    //   1808: astore 24
    //   1810: iload 7
    //   1812: istore 8
    //   1814: aload_3
    //   1815: astore 26
    //   1817: aload 39
    //   1819: invokestatic 439	awcf:deleteFile	(Ljava/io/File;)Z
    //   1822: pop
    //   1823: aload_0
    //   1824: astore 23
    //   1826: iload 7
    //   1828: istore 9
    //   1830: aload_0
    //   1831: astore 25
    //   1833: iload 7
    //   1835: istore 10
    //   1837: aload_0
    //   1838: astore 27
    //   1840: iload 7
    //   1842: istore 11
    //   1844: aload_0
    //   1845: astore 24
    //   1847: iload 7
    //   1849: istore 8
    //   1851: aload_3
    //   1852: astore 26
    //   1854: aload 41
    //   1856: invokevirtual 340	java/io/File:length	()J
    //   1859: lstore 14
    //   1861: aload_0
    //   1862: astore 23
    //   1864: iload 7
    //   1866: istore 9
    //   1868: aload_0
    //   1869: astore 25
    //   1871: iload 7
    //   1873: istore 10
    //   1875: aload_0
    //   1876: astore 27
    //   1878: iload 7
    //   1880: istore 11
    //   1882: aload_0
    //   1883: astore 24
    //   1885: iload 7
    //   1887: istore 8
    //   1889: aload_3
    //   1890: astore 26
    //   1892: ldc_w 411
    //   1895: aload 38
    //   1897: invokevirtual 375	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1900: ifeq +2118 -> 4018
    //   1903: ldc_w 441
    //   1906: astore 29
    //   1908: aload_0
    //   1909: astore 23
    //   1911: iload 7
    //   1913: istore 9
    //   1915: aload_0
    //   1916: astore 25
    //   1918: iload 7
    //   1920: istore 10
    //   1922: aload_0
    //   1923: astore 27
    //   1925: iload 7
    //   1927: istore 11
    //   1929: aload_0
    //   1930: astore 24
    //   1932: iload 7
    //   1934: istore 8
    //   1936: aload_3
    //   1937: astore 26
    //   1939: aload 36
    //   1941: ldc_w 389
    //   1944: aload 29
    //   1946: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1949: pop
    //   1950: aload_0
    //   1951: astore 23
    //   1953: iload 7
    //   1955: istore 9
    //   1957: aload_0
    //   1958: astore 25
    //   1960: iload 7
    //   1962: istore 10
    //   1964: aload_0
    //   1965: astore 27
    //   1967: iload 7
    //   1969: istore 11
    //   1971: aload_0
    //   1972: astore 24
    //   1974: iload 7
    //   1976: istore 8
    //   1978: aload_3
    //   1979: astore 26
    //   1981: aload 36
    //   1983: ldc_w 447
    //   1986: lload 14
    //   1988: invokestatic 450	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1991: invokevirtual 445	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1994: pop
    //   1995: aload_0
    //   1996: astore 23
    //   1998: iload 7
    //   2000: istore 9
    //   2002: aload_0
    //   2003: astore 25
    //   2005: iload 7
    //   2007: istore 10
    //   2009: aload_0
    //   2010: astore 27
    //   2012: iload 7
    //   2014: istore 11
    //   2016: aload_0
    //   2017: astore 24
    //   2019: iload 7
    //   2021: istore 8
    //   2023: aload_3
    //   2024: astore 26
    //   2026: invokestatic 453	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2029: ifeq +82 -> 2111
    //   2032: aload_0
    //   2033: astore 23
    //   2035: iload 7
    //   2037: istore 9
    //   2039: aload_0
    //   2040: astore 25
    //   2042: iload 7
    //   2044: istore 10
    //   2046: aload_0
    //   2047: astore 27
    //   2049: iload 7
    //   2051: istore 11
    //   2053: aload_0
    //   2054: astore 24
    //   2056: iload 7
    //   2058: istore 8
    //   2060: aload_3
    //   2061: astore 26
    //   2063: ldc 61
    //   2065: iconst_4
    //   2066: new 63	java/lang/StringBuilder
    //   2069: dup
    //   2070: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2073: ldc_w 455
    //   2076: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2079: lload 14
    //   2081: invokevirtual 349	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2084: ldc_w 457
    //   2087: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2090: aload_1
    //   2091: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2094: ldc_w 459
    //   2097: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2100: aload 37
    //   2102: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2105: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2108: invokestatic 359	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2111: aload_0
    //   2112: astore 23
    //   2114: iload 7
    //   2116: istore 9
    //   2118: aload_0
    //   2119: astore 25
    //   2121: iload 7
    //   2123: istore 10
    //   2125: aload_0
    //   2126: astore 27
    //   2128: iload 7
    //   2130: istore 11
    //   2132: aload_0
    //   2133: astore 24
    //   2135: iload 7
    //   2137: istore 8
    //   2139: aload_3
    //   2140: astore 26
    //   2142: aload 35
    //   2144: aload 34
    //   2146: aload 30
    //   2148: aload 36
    //   2150: invokestatic 462	awda:a	([Lorg/apache/http/Header;Ljava/io/File;Ljava/lang/String;Ljava/util/HashMap;)Z
    //   2153: pop
    //   2154: aload_0
    //   2155: astore 24
    //   2157: aload_3
    //   2158: ifnull +9 -> 2167
    //   2161: aload_3
    //   2162: invokeinterface 465 1 0
    //   2167: aload 24
    //   2169: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2172: pop
    //   2173: iload 7
    //   2175: ifeq +1831 -> 4006
    //   2178: aload_2
    //   2179: ifnull +75 -> 2254
    //   2182: aload_2
    //   2183: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   2186: astore_0
    //   2187: aload_0
    //   2188: ifnull +15 -> 2203
    //   2191: aload_0
    //   2192: invokevirtual 56	java/io/File:exists	()Z
    //   2195: ifne +8 -> 2203
    //   2198: aload_0
    //   2199: invokevirtual 168	java/io/File:mkdirs	()Z
    //   2202: pop
    //   2203: aload_2
    //   2204: invokevirtual 56	java/io/File:exists	()Z
    //   2207: ifeq +47 -> 2254
    //   2210: aload_2
    //   2211: invokevirtual 250	java/io/File:delete	()Z
    //   2214: istore 22
    //   2216: ldc 61
    //   2218: iconst_1
    //   2219: new 63	java/lang/StringBuilder
    //   2222: dup
    //   2223: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2226: ldc_w 467
    //   2229: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2232: iload 22
    //   2234: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2237: ldc_w 472
    //   2240: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2243: aload 30
    //   2245: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2248: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2251: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2254: aload_3
    //   2255: astore_0
    //   2256: iload 13
    //   2258: iconst_1
    //   2259: iadd
    //   2260: istore 13
    //   2262: iload 7
    //   2264: ifeq +1479 -> 3743
    //   2267: ldc 61
    //   2269: iconst_1
    //   2270: new 63	java/lang/StringBuilder
    //   2273: dup
    //   2274: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2277: ldc_w 474
    //   2280: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2283: iload 7
    //   2285: invokevirtual 477	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2288: ldc_w 385
    //   2291: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: aload_1
    //   2295: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2298: ldc_w 479
    //   2301: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2304: iload 13
    //   2306: invokevirtual 477	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: invokestatic 80	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2315: iload 7
    //   2317: ifeq +31 -> 2348
    //   2320: iload 7
    //   2322: sipush -999
    //   2325: if_icmpeq +23 -> 2348
    //   2328: iload 13
    //   2330: iconst_2
    //   2331: if_icmpge +17 -> 2348
    //   2334: aload 31
    //   2336: monitorenter
    //   2337: aload 31
    //   2339: ldc2_w 480
    //   2342: invokevirtual 485	java/lang/Object:wait	(J)V
    //   2345: aload 31
    //   2347: monitorexit
    //   2348: iload 7
    //   2350: ifeq +18 -> 2368
    //   2353: iload 7
    //   2355: sipush -999
    //   2358: if_icmpeq +10 -> 2368
    //   2361: iload 13
    //   2363: iload 12
    //   2365: if_icmplt +1633 -> 3998
    //   2368: iload 7
    //   2370: ireturn
    //   2371: astore_0
    //   2372: ldc 61
    //   2374: iconst_1
    //   2375: ldc_w 487
    //   2378: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2381: iconst_4
    //   2382: ireturn
    //   2383: astore 23
    //   2385: new 179	org/apache/http/client/methods/HttpGet
    //   2388: dup
    //   2389: aload 30
    //   2391: invokestatic 490	awda:pA	(Ljava/lang/String;)Ljava/lang/String;
    //   2394: invokespecial 180	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   2397: astore 28
    //   2399: goto -2310 -> 89
    //   2402: astore_0
    //   2403: ldc 61
    //   2405: iconst_1
    //   2406: ldc_w 492
    //   2409: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2412: bipush 13
    //   2414: ireturn
    //   2415: sipush 10000
    //   2418: istore 7
    //   2420: sipush 30000
    //   2423: istore 4
    //   2425: aload 33
    //   2427: ldc 224
    //   2429: sipush 4096
    //   2432: invokeinterface 228 3 0
    //   2437: pop
    //   2438: goto -2229 -> 209
    //   2441: astore 24
    //   2443: aload 23
    //   2445: astore_0
    //   2446: iconst_5
    //   2447: istore 4
    //   2449: aload 24
    //   2451: astore 23
    //   2453: ldc 61
    //   2455: iconst_1
    //   2456: new 63	java/lang/StringBuilder
    //   2459: dup
    //   2460: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2463: ldc_w 494
    //   2466: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2469: aload_2
    //   2470: invokevirtual 56	java/io/File:exists	()Z
    //   2473: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2476: ldc_w 496
    //   2479: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2482: aload_2
    //   2483: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   2486: invokevirtual 56	java/io/File:exists	()Z
    //   2489: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2492: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2495: aload 23
    //   2497: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2500: goto -1402 -> 1098
    //   2503: astore_0
    //   2504: lconst_0
    //   2505: lstore 14
    //   2507: aload 23
    //   2509: astore 24
    //   2511: iload 4
    //   2513: istore 8
    //   2515: aload 23
    //   2517: astore 25
    //   2519: iload 4
    //   2521: istore 7
    //   2523: aload 23
    //   2525: astore 26
    //   2527: iload 4
    //   2529: istore 9
    //   2531: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2534: ifeq +37 -> 2571
    //   2537: aload 23
    //   2539: astore 24
    //   2541: iload 4
    //   2543: istore 8
    //   2545: aload 23
    //   2547: astore 25
    //   2549: iload 4
    //   2551: istore 7
    //   2553: aload 23
    //   2555: astore 26
    //   2557: iload 4
    //   2559: istore 9
    //   2561: ldc 61
    //   2563: iconst_2
    //   2564: ldc_w 500
    //   2567: aload_0
    //   2568: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2571: iconst_4
    //   2572: istore 4
    //   2574: aload 23
    //   2576: astore_0
    //   2577: goto -1479 -> 1098
    //   2580: aload_0
    //   2581: astore 23
    //   2583: iload 7
    //   2585: istore 9
    //   2587: aload_0
    //   2588: astore 25
    //   2590: iload 7
    //   2592: istore 10
    //   2594: aload_0
    //   2595: astore 27
    //   2597: iload 7
    //   2599: istore 11
    //   2601: aload_0
    //   2602: astore 24
    //   2604: iload 7
    //   2606: istore 8
    //   2608: aload_3
    //   2609: astore 26
    //   2611: getstatic 503	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   2614: astore 29
    //   2616: goto -877 -> 1739
    //   2619: aload_0
    //   2620: astore 23
    //   2622: iload 7
    //   2624: istore 9
    //   2626: aload_0
    //   2627: astore 25
    //   2629: iload 7
    //   2631: istore 10
    //   2633: aload_0
    //   2634: astore 27
    //   2636: iload 7
    //   2638: istore 11
    //   2640: aload_0
    //   2641: astore 24
    //   2643: iload 7
    //   2645: istore 8
    //   2647: aload_3
    //   2648: astore 26
    //   2650: aload 39
    //   2652: aload 41
    //   2654: invokevirtual 506	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2657: pop
    //   2658: goto -547 -> 2111
    //   2661: astore 24
    //   2663: iload 9
    //   2665: istore 4
    //   2667: aload_3
    //   2668: astore 26
    //   2670: aload 23
    //   2672: astore 25
    //   2674: iload 4
    //   2676: istore 8
    //   2678: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2681: ifeq +42 -> 2723
    //   2684: aload_3
    //   2685: astore 26
    //   2687: aload 23
    //   2689: astore 25
    //   2691: iload 4
    //   2693: istore 8
    //   2695: ldc 61
    //   2697: iconst_2
    //   2698: new 63	java/lang/StringBuilder
    //   2701: dup
    //   2702: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2705: ldc_w 508
    //   2708: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2711: aload_1
    //   2712: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2715: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2718: aload 24
    //   2720: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2723: aload_3
    //   2724: astore 26
    //   2726: aload 23
    //   2728: astore 25
    //   2730: iload 4
    //   2732: istore 8
    //   2734: aload 24
    //   2736: instanceof 510
    //   2739: istore 22
    //   2741: iload 22
    //   2743: ifeq +847 -> 3590
    //   2746: bipush 10
    //   2748: istore 4
    //   2750: aload_3
    //   2751: ifnull +9 -> 2760
    //   2754: aload_3
    //   2755: invokeinterface 465 1 0
    //   2760: aload 23
    //   2762: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   2765: pop
    //   2766: iload 4
    //   2768: istore 7
    //   2770: aload_3
    //   2771: astore_0
    //   2772: aload 23
    //   2774: astore 24
    //   2776: iload 4
    //   2778: ifeq -522 -> 2256
    //   2781: iload 4
    //   2783: istore 7
    //   2785: aload_3
    //   2786: astore_0
    //   2787: aload 23
    //   2789: astore 24
    //   2791: aload_2
    //   2792: ifnull -536 -> 2256
    //   2795: aload_2
    //   2796: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   2799: astore_0
    //   2800: aload_0
    //   2801: ifnull +15 -> 2816
    //   2804: aload_0
    //   2805: invokevirtual 56	java/io/File:exists	()Z
    //   2808: ifne +8 -> 2816
    //   2811: aload_0
    //   2812: invokevirtual 168	java/io/File:mkdirs	()Z
    //   2815: pop
    //   2816: iload 4
    //   2818: istore 7
    //   2820: aload_3
    //   2821: astore_0
    //   2822: aload 23
    //   2824: astore 24
    //   2826: aload_2
    //   2827: invokevirtual 56	java/io/File:exists	()Z
    //   2830: ifeq -574 -> 2256
    //   2833: aload_2
    //   2834: invokevirtual 250	java/io/File:delete	()Z
    //   2837: istore 22
    //   2839: ldc 61
    //   2841: iconst_1
    //   2842: new 63	java/lang/StringBuilder
    //   2845: dup
    //   2846: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2849: ldc_w 467
    //   2852: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2855: iload 22
    //   2857: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   2860: ldc_w 472
    //   2863: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2866: aload 30
    //   2868: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2871: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2874: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2877: iload 4
    //   2879: istore 7
    //   2881: aload_3
    //   2882: astore_0
    //   2883: aload 23
    //   2885: astore 24
    //   2887: goto -631 -> 2256
    //   2890: astore_0
    //   2891: iload 4
    //   2893: istore 7
    //   2895: aload_3
    //   2896: astore_0
    //   2897: aload 23
    //   2899: astore 24
    //   2901: goto -645 -> 2256
    //   2904: aload_0
    //   2905: astore 23
    //   2907: iload 7
    //   2909: istore 9
    //   2911: aload_0
    //   2912: astore 25
    //   2914: iload 7
    //   2916: istore 10
    //   2918: aload_0
    //   2919: astore 27
    //   2921: iload 7
    //   2923: istore 11
    //   2925: aload_0
    //   2926: astore 24
    //   2928: iload 7
    //   2930: istore 8
    //   2932: aload_3
    //   2933: astore 26
    //   2935: aload 39
    //   2937: aload 41
    //   2939: invokevirtual 506	java/io/File:renameTo	(Ljava/io/File;)Z
    //   2942: pop
    //   2943: goto -832 -> 2111
    //   2946: astore_0
    //   2947: iload 10
    //   2949: istore 4
    //   2951: aload 25
    //   2953: astore 23
    //   2955: aload_0
    //   2956: astore 25
    //   2958: aload 23
    //   2960: astore 24
    //   2962: iload 4
    //   2964: istore 8
    //   2966: aload_3
    //   2967: astore 26
    //   2969: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2972: ifeq +42 -> 3014
    //   2975: aload 23
    //   2977: astore 24
    //   2979: iload 4
    //   2981: istore 8
    //   2983: aload_3
    //   2984: astore 26
    //   2986: ldc 61
    //   2988: iconst_2
    //   2989: new 63	java/lang/StringBuilder
    //   2992: dup
    //   2993: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   2996: ldc_w 512
    //   2999: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3002: aload_1
    //   3003: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3006: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3009: aload 25
    //   3011: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3014: iconst_5
    //   3015: istore 7
    //   3017: aload_3
    //   3018: ifnull +9 -> 3027
    //   3021: aload_3
    //   3022: invokeinterface 465 1 0
    //   3027: aload 23
    //   3029: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3032: pop
    //   3033: aload_2
    //   3034: ifnull +75 -> 3109
    //   3037: aload_2
    //   3038: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   3041: astore_0
    //   3042: aload_0
    //   3043: ifnull +15 -> 3058
    //   3046: aload_0
    //   3047: invokevirtual 56	java/io/File:exists	()Z
    //   3050: ifne +8 -> 3058
    //   3053: aload_0
    //   3054: invokevirtual 168	java/io/File:mkdirs	()Z
    //   3057: pop
    //   3058: aload_2
    //   3059: invokevirtual 56	java/io/File:exists	()Z
    //   3062: ifeq +47 -> 3109
    //   3065: aload_2
    //   3066: invokevirtual 250	java/io/File:delete	()Z
    //   3069: istore 22
    //   3071: ldc 61
    //   3073: iconst_1
    //   3074: new 63	java/lang/StringBuilder
    //   3077: dup
    //   3078: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3081: ldc_w 467
    //   3084: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3087: iload 22
    //   3089: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3092: ldc_w 472
    //   3095: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3098: aload 30
    //   3100: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3106: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3109: aload_3
    //   3110: astore_0
    //   3111: aload 23
    //   3113: astore 24
    //   3115: goto -859 -> 2256
    //   3118: aload_0
    //   3119: astore 23
    //   3121: iload 7
    //   3123: istore 9
    //   3125: aload_0
    //   3126: astore 25
    //   3128: iload 7
    //   3130: istore 10
    //   3132: aload_0
    //   3133: astore 27
    //   3135: iload 7
    //   3137: istore 11
    //   3139: aload_0
    //   3140: astore 24
    //   3142: iload 7
    //   3144: istore 8
    //   3146: aload_3
    //   3147: astore 26
    //   3149: invokestatic 453	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3152: ifeq -1041 -> 2111
    //   3155: aload_0
    //   3156: astore 23
    //   3158: iload 7
    //   3160: istore 9
    //   3162: aload_0
    //   3163: astore 25
    //   3165: iload 7
    //   3167: istore 10
    //   3169: aload_0
    //   3170: astore 27
    //   3172: iload 7
    //   3174: istore 11
    //   3176: aload_0
    //   3177: astore 24
    //   3179: iload 7
    //   3181: istore 8
    //   3183: aload_3
    //   3184: astore 26
    //   3186: ldc 61
    //   3188: iconst_4
    //   3189: ldc_w 514
    //   3192: invokestatic 359	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3195: goto -1084 -> 2111
    //   3198: astore 25
    //   3200: iload 11
    //   3202: istore 4
    //   3204: aload 27
    //   3206: astore 23
    //   3208: aload 23
    //   3210: astore 24
    //   3212: iload 4
    //   3214: istore 8
    //   3216: aload_3
    //   3217: astore 26
    //   3219: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3222: ifeq +42 -> 3264
    //   3225: aload 23
    //   3227: astore 24
    //   3229: iload 4
    //   3231: istore 8
    //   3233: aload_3
    //   3234: astore 26
    //   3236: ldc 61
    //   3238: iconst_2
    //   3239: new 63	java/lang/StringBuilder
    //   3242: dup
    //   3243: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3246: ldc_w 512
    //   3249: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3252: aload_1
    //   3253: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3256: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3259: aload 25
    //   3261: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3264: iconst_5
    //   3265: istore 7
    //   3267: aload_3
    //   3268: ifnull +9 -> 3277
    //   3271: aload_3
    //   3272: invokeinterface 465 1 0
    //   3277: aload 23
    //   3279: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3282: pop
    //   3283: aload_2
    //   3284: ifnull +75 -> 3359
    //   3287: aload_2
    //   3288: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   3291: astore_0
    //   3292: aload_0
    //   3293: ifnull +15 -> 3308
    //   3296: aload_0
    //   3297: invokevirtual 56	java/io/File:exists	()Z
    //   3300: ifne +8 -> 3308
    //   3303: aload_0
    //   3304: invokevirtual 168	java/io/File:mkdirs	()Z
    //   3307: pop
    //   3308: aload_2
    //   3309: invokevirtual 56	java/io/File:exists	()Z
    //   3312: ifeq +47 -> 3359
    //   3315: aload_2
    //   3316: invokevirtual 250	java/io/File:delete	()Z
    //   3319: istore 22
    //   3321: ldc 61
    //   3323: iconst_1
    //   3324: new 63	java/lang/StringBuilder
    //   3327: dup
    //   3328: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3331: ldc_w 467
    //   3334: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3337: iload 22
    //   3339: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3342: ldc_w 472
    //   3345: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3348: aload 30
    //   3350: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3353: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3356: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3359: aload_3
    //   3360: astore_0
    //   3361: aload 23
    //   3363: astore 24
    //   3365: goto -1109 -> 2256
    //   3368: aload_0
    //   3369: astore 23
    //   3371: iload 7
    //   3373: istore 9
    //   3375: aload_0
    //   3376: astore 25
    //   3378: iload 7
    //   3380: istore 10
    //   3382: aload_0
    //   3383: astore 27
    //   3385: iload 7
    //   3387: istore 11
    //   3389: aload_0
    //   3390: astore 24
    //   3392: iload 7
    //   3394: istore 8
    //   3396: aload_3
    //   3397: astore 26
    //   3399: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3402: ifeq -1248 -> 2154
    //   3405: aload_0
    //   3406: astore 23
    //   3408: iload 7
    //   3410: istore 9
    //   3412: aload_0
    //   3413: astore 25
    //   3415: iload 7
    //   3417: istore 10
    //   3419: aload_0
    //   3420: astore 27
    //   3422: iload 7
    //   3424: istore 11
    //   3426: aload_0
    //   3427: astore 24
    //   3429: iload 7
    //   3431: istore 8
    //   3433: aload_3
    //   3434: astore 26
    //   3436: ldc 61
    //   3438: iconst_2
    //   3439: new 63	java/lang/StringBuilder
    //   3442: dup
    //   3443: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3446: ldc_w 516
    //   3449: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3452: aload_1
    //   3453: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3456: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3459: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3462: goto -1308 -> 2154
    //   3465: astore_1
    //   3466: aload 26
    //   3468: astore_3
    //   3469: aload 24
    //   3471: astore_0
    //   3472: aload_3
    //   3473: ifnull +9 -> 3482
    //   3476: aload_3
    //   3477: invokeinterface 465 1 0
    //   3482: aload_0
    //   3483: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   3486: pop
    //   3487: iload 8
    //   3489: ifeq +79 -> 3568
    //   3492: aload_2
    //   3493: ifnull +75 -> 3568
    //   3496: aload_2
    //   3497: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   3500: astore_0
    //   3501: aload_0
    //   3502: ifnull +15 -> 3517
    //   3505: aload_0
    //   3506: invokevirtual 56	java/io/File:exists	()Z
    //   3509: ifne +8 -> 3517
    //   3512: aload_0
    //   3513: invokevirtual 168	java/io/File:mkdirs	()Z
    //   3516: pop
    //   3517: aload_2
    //   3518: invokevirtual 56	java/io/File:exists	()Z
    //   3521: ifeq +47 -> 3568
    //   3524: aload_2
    //   3525: invokevirtual 250	java/io/File:delete	()Z
    //   3528: istore 22
    //   3530: ldc 61
    //   3532: iconst_1
    //   3533: new 63	java/lang/StringBuilder
    //   3536: dup
    //   3537: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3540: ldc_w 467
    //   3543: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3546: iload 22
    //   3548: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3551: ldc_w 472
    //   3554: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3557: aload 30
    //   3559: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3562: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3565: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3568: aload_1
    //   3569: athrow
    //   3570: astore_0
    //   3571: ldc 61
    //   3573: iconst_1
    //   3574: ldc_w 518
    //   3577: aload_0
    //   3578: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3581: goto -1414 -> 2167
    //   3584: astore_0
    //   3585: aload_3
    //   3586: astore_0
    //   3587: goto -1331 -> 2256
    //   3590: aload_3
    //   3591: astore 26
    //   3593: aload 23
    //   3595: astore 25
    //   3597: iload 4
    //   3599: istore 8
    //   3601: aload 24
    //   3603: instanceof 522
    //   3606: ifne +420 -> 4026
    //   3609: aload_3
    //   3610: astore 26
    //   3612: aload 23
    //   3614: astore 25
    //   3616: iload 4
    //   3618: istore 8
    //   3620: aload 24
    //   3622: instanceof 524
    //   3625: ifeq +6 -> 3631
    //   3628: goto +398 -> 4026
    //   3631: aload_3
    //   3632: astore 26
    //   3634: aload 23
    //   3636: astore 25
    //   3638: iload 4
    //   3640: istore 8
    //   3642: aload 24
    //   3644: instanceof 526
    //   3647: istore 22
    //   3649: iload 22
    //   3651: ifeq +10 -> 3661
    //   3654: bipush 11
    //   3656: istore 4
    //   3658: goto -908 -> 2750
    //   3661: iconst_4
    //   3662: istore 4
    //   3664: goto -914 -> 2750
    //   3667: astore_0
    //   3668: ldc 61
    //   3670: iconst_1
    //   3671: ldc_w 518
    //   3674: aload_0
    //   3675: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3678: goto -918 -> 2760
    //   3681: astore_0
    //   3682: ldc 61
    //   3684: iconst_1
    //   3685: ldc_w 518
    //   3688: aload_0
    //   3689: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3692: goto -665 -> 3027
    //   3695: astore_0
    //   3696: aload_3
    //   3697: astore_0
    //   3698: aload 23
    //   3700: astore 24
    //   3702: goto -1446 -> 2256
    //   3705: astore_0
    //   3706: ldc 61
    //   3708: iconst_1
    //   3709: ldc_w 518
    //   3712: aload_0
    //   3713: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3716: goto -439 -> 3277
    //   3719: astore_0
    //   3720: aload_3
    //   3721: astore_0
    //   3722: aload 23
    //   3724: astore 24
    //   3726: goto -1470 -> 2256
    //   3729: astore_3
    //   3730: ldc 61
    //   3732: iconst_1
    //   3733: ldc_w 518
    //   3736: aload_3
    //   3737: invokestatic 520	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3740: goto -258 -> 3482
    //   3743: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3746: ifeq -1431 -> 2315
    //   3749: ldc 61
    //   3751: iconst_2
    //   3752: new 63	java/lang/StringBuilder
    //   3755: dup
    //   3756: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   3759: ldc_w 474
    //   3762: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3765: iload 7
    //   3767: invokevirtual 477	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3770: ldc_w 385
    //   3773: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3776: aload_1
    //   3777: invokevirtual 356	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3780: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3783: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3786: goto -1471 -> 2315
    //   3789: astore_0
    //   3790: aload 31
    //   3792: monitorexit
    //   3793: aload_0
    //   3794: athrow
    //   3795: astore_3
    //   3796: goto -1451 -> 2345
    //   3799: astore_0
    //   3800: goto -232 -> 3568
    //   3803: astore_1
    //   3804: aload 24
    //   3806: astore_0
    //   3807: goto -335 -> 3472
    //   3810: astore_1
    //   3811: aload 23
    //   3813: astore_0
    //   3814: iconst_0
    //   3815: istore 8
    //   3817: goto -345 -> 3472
    //   3820: astore_1
    //   3821: iload 4
    //   3823: istore 8
    //   3825: goto -353 -> 3472
    //   3828: astore_1
    //   3829: aload 26
    //   3831: astore_3
    //   3832: aload 25
    //   3834: astore_0
    //   3835: goto -363 -> 3472
    //   3838: astore_0
    //   3839: aload 25
    //   3841: astore 23
    //   3843: aload_0
    //   3844: astore 25
    //   3846: iload 7
    //   3848: istore 4
    //   3850: goto -642 -> 3208
    //   3853: astore 25
    //   3855: iconst_0
    //   3856: istore 4
    //   3858: goto -650 -> 3208
    //   3861: astore 25
    //   3863: aload_0
    //   3864: astore 23
    //   3866: goto -658 -> 3208
    //   3869: astore 25
    //   3871: aload_0
    //   3872: astore 23
    //   3874: goto -666 -> 3208
    //   3877: astore 25
    //   3879: aload 26
    //   3881: astore 23
    //   3883: iload 9
    //   3885: istore 4
    //   3887: goto -929 -> 2958
    //   3890: astore 25
    //   3892: iconst_0
    //   3893: istore 4
    //   3895: goto -937 -> 2958
    //   3898: astore 25
    //   3900: aload_0
    //   3901: astore 23
    //   3903: goto -945 -> 2958
    //   3906: astore 25
    //   3908: aload_0
    //   3909: astore 23
    //   3911: goto -953 -> 2958
    //   3914: astore 24
    //   3916: aload_0
    //   3917: astore 23
    //   3919: goto -1252 -> 2667
    //   3922: astore 24
    //   3924: goto -1257 -> 2667
    //   3927: astore 24
    //   3929: aload_0
    //   3930: astore 23
    //   3932: goto -1265 -> 2667
    //   3935: astore_0
    //   3936: goto -1429 -> 2507
    //   3939: astore_0
    //   3940: iconst_0
    //   3941: istore 4
    //   3943: goto -1436 -> 2507
    //   3946: astore 24
    //   3948: aload_0
    //   3949: astore 23
    //   3951: lconst_0
    //   3952: lstore 14
    //   3954: aload 24
    //   3956: astore_0
    //   3957: goto -1450 -> 2507
    //   3960: astore 24
    //   3962: aload 23
    //   3964: astore_0
    //   3965: iconst_5
    //   3966: istore 4
    //   3968: aload 24
    //   3970: astore 23
    //   3972: goto -1519 -> 2453
    //   3975: astore 24
    //   3977: aload 23
    //   3979: astore_0
    //   3980: iconst_0
    //   3981: istore 4
    //   3983: aload 24
    //   3985: astore 23
    //   3987: goto -1534 -> 2453
    //   3990: astore 23
    //   3992: iconst_5
    //   3993: istore 4
    //   3995: goto -1542 -> 2453
    //   3998: aload_0
    //   3999: astore_3
    //   4000: aload 24
    //   4002: astore_0
    //   4003: goto -3686 -> 317
    //   4006: aload_3
    //   4007: astore_0
    //   4008: goto -1752 -> 2256
    //   4011: bipush 8
    //   4013: istore 7
    //   4015: goto -2773 -> 1242
    //   4018: ldc_w 528
    //   4021: astore 29
    //   4023: goto -2115 -> 1908
    //   4026: iconst_2
    //   4027: istore 4
    //   4029: goto -1279 -> 2750
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4032	0	paramAppInterface	AppInterface
    //   0	4032	1	paramURL	URL
    //   0	4032	2	paramFile	File
    //   0	4032	3	paramNetworkInfo	NetworkInfo
    //   0	4032	4	paramInt1	int
    //   0	4032	5	paramString	String
    //   0	4032	6	paramInt2	int
    //   101	3913	7	i	int
    //   365	3459	8	j	int
    //   631	3253	9	k	int
    //   682	2736	10	m	int
    //   689	2736	11	n	int
    //   30	2336	12	i1	int
    //   315	2051	13	i2	int
    //   710	3243	14	l1	long
    //   842	3	16	l2	long
    //   3	951	18	l3	long
    //   707	499	20	l4	long
    //   2214	1436	22	bool	boolean
    //   114	1999	23	localObject1	Object
    //   2383	61	23	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   2451	1535	23	localObject2	Object
    //   3990	1	23	localFileNotFoundException1	java.io.FileNotFoundException
    //   125	2043	24	localObject3	Object
    //   2441	9	24	localFileNotFoundException2	java.io.FileNotFoundException
    //   2509	133	24	localObject4	Object
    //   2661	74	24	localIOException1	java.io.IOException
    //   2774	1031	24	localObject5	Object
    //   3914	1	24	localIOException2	java.io.IOException
    //   3922	1	24	localIOException3	java.io.IOException
    //   3927	1	24	localIOException4	java.io.IOException
    //   3946	9	24	localIOException5	java.io.IOException
    //   3960	9	24	localFileNotFoundException3	java.io.FileNotFoundException
    //   3975	26	24	localFileNotFoundException4	java.io.FileNotFoundException
    //   361	2803	25	localObject6	Object
    //   3198	62	25	localThrowable1	java.lang.Throwable
    //   3376	469	25	localObject7	Object
    //   3853	1	25	localThrowable2	java.lang.Throwable
    //   3861	1	25	localThrowable3	java.lang.Throwable
    //   3869	1	25	localThrowable4	java.lang.Throwable
    //   3877	1	25	localException1	Exception
    //   3890	1	25	localException2	Exception
    //   3898	1	25	localException3	Exception
    //   3906	1	25	localException4	Exception
    //   358	3522	26	localObject8	Object
    //   685	2736	27	localAppInterface	AppInterface
    //   87	2311	28	localHttpGet	org.apache.http.client.methods.HttpGet
    //   1737	2285	29	localObject9	Object
    //   67	3491	30	str1	String
    //   12	3779	31	localObject10	Object
    //   76	970	32	str2	String
    //   96	2330	33	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   275	1870	34	localFile1	File
    //   593	1550	35	arrayOfHeader	Header[]
    //   612	1537	36	localHashMap	java.util.HashMap
    //   1534	567	37	str3	String
    //   1371	525	38	str4	String
    //   1571	1365	39	localFile2	File
    //   1612	159	40	localBitmap	android.graphics.Bitmap
    //   1654	1284	41	localFile3	File
    // Exception table:
    //   from	to	target	type
    //   40	45	2371	java/lang/Exception
    //   49	61	2371	java/lang/Exception
    //   78	89	2383	java/lang/IllegalArgumentException
    //   2385	2399	2402	java/lang/IllegalArgumentException
    //   777	785	2441	java/io/FileNotFoundException
    //   809	814	2441	java/io/FileNotFoundException
    //   838	844	2441	java/io/FileNotFoundException
    //   777	785	2503	java/io/IOException
    //   809	814	2503	java/io/IOException
    //   838	844	2503	java/io/IOException
    //   701	709	2661	java/io/IOException
    //   1152	1158	2661	java/io/IOException
    //   1189	1239	2661	java/io/IOException
    //   1278	1295	2661	java/io/IOException
    //   1326	1335	2661	java/io/IOException
    //   1366	1373	2661	java/io/IOException
    //   1404	1415	2661	java/io/IOException
    //   1446	1457	2661	java/io/IOException
    //   1488	1499	2661	java/io/IOException
    //   1530	1536	2661	java/io/IOException
    //   1567	1573	2661	java/io/IOException
    //   1604	1614	2661	java/io/IOException
    //   1645	1656	2661	java/io/IOException
    //   1692	1703	2661	java/io/IOException
    //   1734	1739	2661	java/io/IOException
    //   1770	1786	2661	java/io/IOException
    //   1817	1823	2661	java/io/IOException
    //   1854	1861	2661	java/io/IOException
    //   1892	1903	2661	java/io/IOException
    //   1939	1950	2661	java/io/IOException
    //   1981	1995	2661	java/io/IOException
    //   2026	2032	2661	java/io/IOException
    //   2063	2111	2661	java/io/IOException
    //   2142	2154	2661	java/io/IOException
    //   2611	2616	2661	java/io/IOException
    //   2650	2658	2661	java/io/IOException
    //   2935	2943	2661	java/io/IOException
    //   3149	3155	2661	java/io/IOException
    //   3186	3195	2661	java/io/IOException
    //   3399	3405	2661	java/io/IOException
    //   3436	3462	2661	java/io/IOException
    //   2795	2800	2890	java/lang/Exception
    //   2804	2816	2890	java/lang/Exception
    //   2826	2877	2890	java/lang/Exception
    //   701	709	2946	java/lang/Exception
    //   736	753	2946	java/lang/Exception
    //   1152	1158	2946	java/lang/Exception
    //   1189	1239	2946	java/lang/Exception
    //   1278	1295	2946	java/lang/Exception
    //   1326	1335	2946	java/lang/Exception
    //   1366	1373	2946	java/lang/Exception
    //   1404	1415	2946	java/lang/Exception
    //   1446	1457	2946	java/lang/Exception
    //   1488	1499	2946	java/lang/Exception
    //   1530	1536	2946	java/lang/Exception
    //   1567	1573	2946	java/lang/Exception
    //   1604	1614	2946	java/lang/Exception
    //   1645	1656	2946	java/lang/Exception
    //   1692	1703	2946	java/lang/Exception
    //   1734	1739	2946	java/lang/Exception
    //   1770	1786	2946	java/lang/Exception
    //   1817	1823	2946	java/lang/Exception
    //   1854	1861	2946	java/lang/Exception
    //   1892	1903	2946	java/lang/Exception
    //   1939	1950	2946	java/lang/Exception
    //   1981	1995	2946	java/lang/Exception
    //   2026	2032	2946	java/lang/Exception
    //   2063	2111	2946	java/lang/Exception
    //   2142	2154	2946	java/lang/Exception
    //   2611	2616	2946	java/lang/Exception
    //   2650	2658	2946	java/lang/Exception
    //   2935	2943	2946	java/lang/Exception
    //   3149	3155	2946	java/lang/Exception
    //   3186	3195	2946	java/lang/Exception
    //   3399	3405	2946	java/lang/Exception
    //   3436	3462	2946	java/lang/Exception
    //   701	709	3198	java/lang/Throwable
    //   736	753	3198	java/lang/Throwable
    //   1152	1158	3198	java/lang/Throwable
    //   1189	1239	3198	java/lang/Throwable
    //   1278	1295	3198	java/lang/Throwable
    //   1326	1335	3198	java/lang/Throwable
    //   1366	1373	3198	java/lang/Throwable
    //   1404	1415	3198	java/lang/Throwable
    //   1446	1457	3198	java/lang/Throwable
    //   1488	1499	3198	java/lang/Throwable
    //   1530	1536	3198	java/lang/Throwable
    //   1567	1573	3198	java/lang/Throwable
    //   1604	1614	3198	java/lang/Throwable
    //   1645	1656	3198	java/lang/Throwable
    //   1692	1703	3198	java/lang/Throwable
    //   1734	1739	3198	java/lang/Throwable
    //   1770	1786	3198	java/lang/Throwable
    //   1817	1823	3198	java/lang/Throwable
    //   1854	1861	3198	java/lang/Throwable
    //   1892	1903	3198	java/lang/Throwable
    //   1939	1950	3198	java/lang/Throwable
    //   1981	1995	3198	java/lang/Throwable
    //   2026	2032	3198	java/lang/Throwable
    //   2063	2111	3198	java/lang/Throwable
    //   2142	2154	3198	java/lang/Throwable
    //   2611	2616	3198	java/lang/Throwable
    //   2650	2658	3198	java/lang/Throwable
    //   2935	2943	3198	java/lang/Throwable
    //   3149	3155	3198	java/lang/Throwable
    //   3186	3195	3198	java/lang/Throwable
    //   3399	3405	3198	java/lang/Throwable
    //   3436	3462	3198	java/lang/Throwable
    //   701	709	3465	finally
    //   736	753	3465	finally
    //   1152	1158	3465	finally
    //   1189	1239	3465	finally
    //   1278	1295	3465	finally
    //   1326	1335	3465	finally
    //   1366	1373	3465	finally
    //   1404	1415	3465	finally
    //   1446	1457	3465	finally
    //   1488	1499	3465	finally
    //   1530	1536	3465	finally
    //   1567	1573	3465	finally
    //   1604	1614	3465	finally
    //   1645	1656	3465	finally
    //   1692	1703	3465	finally
    //   1734	1739	3465	finally
    //   1770	1786	3465	finally
    //   1817	1823	3465	finally
    //   1854	1861	3465	finally
    //   1892	1903	3465	finally
    //   1939	1950	3465	finally
    //   1981	1995	3465	finally
    //   2026	2032	3465	finally
    //   2063	2111	3465	finally
    //   2142	2154	3465	finally
    //   2611	2616	3465	finally
    //   2650	2658	3465	finally
    //   2935	2943	3465	finally
    //   2969	2975	3465	finally
    //   2986	3014	3465	finally
    //   3149	3155	3465	finally
    //   3186	3195	3465	finally
    //   3219	3225	3465	finally
    //   3236	3264	3465	finally
    //   3399	3405	3465	finally
    //   3436	3462	3465	finally
    //   2161	2167	3570	java/io/IOException
    //   2182	2187	3584	java/lang/Exception
    //   2191	2203	3584	java/lang/Exception
    //   2203	2254	3584	java/lang/Exception
    //   2754	2760	3667	java/io/IOException
    //   3021	3027	3681	java/io/IOException
    //   3037	3042	3695	java/lang/Exception
    //   3046	3058	3695	java/lang/Exception
    //   3058	3109	3695	java/lang/Exception
    //   3271	3277	3705	java/io/IOException
    //   3287	3292	3719	java/lang/Exception
    //   3296	3308	3719	java/lang/Exception
    //   3308	3359	3719	java/lang/Exception
    //   3476	3482	3729	java/io/IOException
    //   2337	2345	3789	finally
    //   2345	2348	3789	finally
    //   3790	3793	3789	finally
    //   2337	2345	3795	java/lang/InterruptedException
    //   3496	3501	3799	java/lang/Exception
    //   3505	3517	3799	java/lang/Exception
    //   3517	3568	3799	java/lang/Exception
    //   777	785	3803	finally
    //   809	814	3803	finally
    //   838	844	3803	finally
    //   872	880	3803	finally
    //   904	910	3803	finally
    //   934	986	3803	finally
    //   2531	2537	3803	finally
    //   2561	2571	3803	finally
    //   1002	1032	3810	finally
    //   1044	1090	3810	finally
    //   2453	2500	3820	finally
    //   367	376	3828	finally
    //   391	401	3828	finally
    //   411	435	3828	finally
    //   445	451	3828	finally
    //   461	472	3828	finally
    //   482	492	3828	finally
    //   502	526	3828	finally
    //   536	557	3828	finally
    //   567	576	3828	finally
    //   586	595	3828	finally
    //   605	614	3828	finally
    //   624	633	3828	finally
    //   643	652	3828	finally
    //   2678	2684	3828	finally
    //   2695	2723	3828	finally
    //   2734	2741	3828	finally
    //   3601	3609	3828	finally
    //   3620	3628	3828	finally
    //   3642	3649	3828	finally
    //   777	785	3838	java/lang/Throwable
    //   809	814	3838	java/lang/Throwable
    //   838	844	3838	java/lang/Throwable
    //   872	880	3838	java/lang/Throwable
    //   904	910	3838	java/lang/Throwable
    //   934	986	3838	java/lang/Throwable
    //   2531	2537	3838	java/lang/Throwable
    //   2561	2571	3838	java/lang/Throwable
    //   1002	1032	3853	java/lang/Throwable
    //   1044	1090	3853	java/lang/Throwable
    //   2453	2500	3861	java/lang/Throwable
    //   367	376	3869	java/lang/Throwable
    //   391	401	3869	java/lang/Throwable
    //   411	435	3869	java/lang/Throwable
    //   445	451	3869	java/lang/Throwable
    //   461	472	3869	java/lang/Throwable
    //   482	492	3869	java/lang/Throwable
    //   502	526	3869	java/lang/Throwable
    //   536	557	3869	java/lang/Throwable
    //   567	576	3869	java/lang/Throwable
    //   586	595	3869	java/lang/Throwable
    //   605	614	3869	java/lang/Throwable
    //   624	633	3869	java/lang/Throwable
    //   643	652	3869	java/lang/Throwable
    //   777	785	3877	java/lang/Exception
    //   809	814	3877	java/lang/Exception
    //   838	844	3877	java/lang/Exception
    //   872	880	3877	java/lang/Exception
    //   904	910	3877	java/lang/Exception
    //   934	986	3877	java/lang/Exception
    //   2531	2537	3877	java/lang/Exception
    //   2561	2571	3877	java/lang/Exception
    //   1002	1032	3890	java/lang/Exception
    //   1044	1090	3890	java/lang/Exception
    //   2453	2500	3898	java/lang/Exception
    //   367	376	3906	java/lang/Exception
    //   391	401	3906	java/lang/Exception
    //   411	435	3906	java/lang/Exception
    //   445	451	3906	java/lang/Exception
    //   461	472	3906	java/lang/Exception
    //   482	492	3906	java/lang/Exception
    //   502	526	3906	java/lang/Exception
    //   536	557	3906	java/lang/Exception
    //   567	576	3906	java/lang/Exception
    //   586	595	3906	java/lang/Exception
    //   605	614	3906	java/lang/Exception
    //   624	633	3906	java/lang/Exception
    //   643	652	3906	java/lang/Exception
    //   2453	2500	3914	java/io/IOException
    //   2531	2537	3922	java/io/IOException
    //   2561	2571	3922	java/io/IOException
    //   367	376	3927	java/io/IOException
    //   391	401	3927	java/io/IOException
    //   411	435	3927	java/io/IOException
    //   445	451	3927	java/io/IOException
    //   461	472	3927	java/io/IOException
    //   482	492	3927	java/io/IOException
    //   502	526	3927	java/io/IOException
    //   536	557	3927	java/io/IOException
    //   567	576	3927	java/io/IOException
    //   586	595	3927	java/io/IOException
    //   605	614	3927	java/io/IOException
    //   624	633	3927	java/io/IOException
    //   643	652	3927	java/io/IOException
    //   872	880	3935	java/io/IOException
    //   904	910	3935	java/io/IOException
    //   934	986	3935	java/io/IOException
    //   1002	1032	3939	java/io/IOException
    //   1044	1090	3939	java/io/IOException
    //   736	753	3946	java/io/IOException
    //   872	880	3960	java/io/FileNotFoundException
    //   904	910	3960	java/io/FileNotFoundException
    //   934	986	3960	java/io/FileNotFoundException
    //   1002	1032	3975	java/io/FileNotFoundException
    //   1044	1090	3975	java/io/FileNotFoundException
    //   736	753	3990	java/io/FileNotFoundException
  }
  
  private static String a(Header[] paramArrayOfHeader, String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      if (paramArrayOfHeader != null)
      {
        int j = paramArrayOfHeader.length;
        int i = 0;
        while (i < j)
        {
          Header localHeader = paramArrayOfHeader[i];
          if ((localHeader != null) && (paramString.equals(localHeader.getName()))) {
            return localHeader.getValue();
          }
          i += 1;
        }
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, String paramString1, File paramFile, String paramString2, int paramInt)
  {
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    if (localNetworkInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QZoneHttpDownloadUtil", 2, "Download failed-----------activeNetworkInfo is null");
      }
      return false;
    }
    paramString1 = sa(paramString1);
    for (;;)
    {
      try
      {
        paramString1 = new URL(paramString1);
        paramInt = a(paramAppInterface, paramString1, paramFile, localNetworkInfo, 2, paramString2, paramInt);
        if (QLog.isColorLevel()) {
          QLog.i("QZoneHttpDownloadUtil", 2, paramString2 + "\nurl = " + paramString1.toString() + "\nRESULT_CODE = " + paramInt);
        }
        if (paramInt == 0)
        {
          bool = true;
          return bool;
        }
      }
      catch (MalformedURLException paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        return false;
      }
      boolean bool = false;
    }
  }
  
  /* Error */
  private static boolean a(Header[] paramArrayOfHeader, File paramFile, String paramString, java.util.HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 7
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 6
    //   9: aload_0
    //   10: ifnonnull +5 -> 15
    //   13: iconst_0
    //   14: ireturn
    //   15: new 564	org/json/JSONObject
    //   18: dup
    //   19: invokespecial 565	org/json/JSONObject:<init>	()V
    //   22: astore 13
    //   24: aconst_null
    //   25: astore 10
    //   27: aload_0
    //   28: arraylength
    //   29: istore 5
    //   31: iload 5
    //   33: ifle -20 -> 13
    //   36: new 326	java/io/FileOutputStream
    //   39: dup
    //   40: aload_1
    //   41: invokespecial 327	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   44: astore 9
    //   46: iconst_0
    //   47: istore 4
    //   49: iload 4
    //   51: iload 5
    //   53: if_icmpge +296 -> 349
    //   56: aload_0
    //   57: iload 4
    //   59: aaload
    //   60: astore 11
    //   62: iload 6
    //   64: istore 7
    //   66: aload 9
    //   68: astore 10
    //   70: aload 11
    //   72: invokeinterface 533 1 0
    //   77: astore 14
    //   79: iload 6
    //   81: istore 7
    //   83: aload 9
    //   85: astore 10
    //   87: aload 11
    //   89: invokeinterface 536 1 0
    //   94: astore 12
    //   96: aload 12
    //   98: astore 11
    //   100: aload_3
    //   101: ifnull +43 -> 144
    //   104: aload 12
    //   106: astore 11
    //   108: iload 6
    //   110: istore 7
    //   112: aload 9
    //   114: astore 10
    //   116: aload_3
    //   117: aload 14
    //   119: invokevirtual 568	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   122: ifeq +22 -> 144
    //   125: iload 6
    //   127: istore 7
    //   129: aload 9
    //   131: astore 10
    //   133: aload_3
    //   134: aload 14
    //   136: invokevirtual 572	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   139: checkcast 32	java/lang/String
    //   142: astore 11
    //   144: iload 6
    //   146: istore 7
    //   148: aload 9
    //   150: astore 10
    //   152: ldc_w 574
    //   155: aload 14
    //   157: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   160: ifne +407 -> 567
    //   163: iload 6
    //   165: istore 7
    //   167: aload 9
    //   169: astore 10
    //   171: ldc_w 576
    //   174: aload 14
    //   176: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   179: ifne +388 -> 567
    //   182: iload 6
    //   184: istore 7
    //   186: aload 9
    //   188: astore 10
    //   190: ldc_w 578
    //   193: aload 14
    //   195: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   198: ifeq +6 -> 204
    //   201: goto +366 -> 567
    //   204: iload 6
    //   206: istore 7
    //   208: aload 9
    //   210: astore 10
    //   212: aload_2
    //   213: invokestatic 581	awfu:tW	(Ljava/lang/String;)Z
    //   216: ifeq +29 -> 245
    //   219: iload 6
    //   221: istore 7
    //   223: aload 9
    //   225: astore 10
    //   227: ldc_w 364
    //   230: aload 14
    //   232: invokevirtual 370	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   235: istore 8
    //   237: iload 8
    //   239: ifeq +6 -> 245
    //   242: goto +325 -> 567
    //   245: iload 6
    //   247: istore 7
    //   249: aload 9
    //   251: astore 10
    //   253: aload 13
    //   255: aload 14
    //   257: aload 11
    //   259: invokevirtual 584	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   262: pop
    //   263: iload 6
    //   265: istore 7
    //   267: aload 9
    //   269: astore 10
    //   271: new 63	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   278: ldc_w 586
    //   281: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload 14
    //   286: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc_w 588
    //   292: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 273	awfu:abg	(Ljava/lang/String;)V
    //   306: goto +261 -> 567
    //   309: astore 11
    //   311: iload 6
    //   313: istore 7
    //   315: aload 9
    //   317: astore 10
    //   319: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +254 -> 576
    //   325: iload 6
    //   327: istore 7
    //   329: aload 9
    //   331: astore 10
    //   333: ldc 61
    //   335: iconst_2
    //   336: aload 11
    //   338: invokevirtual 591	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   341: aload 11
    //   343: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   346: goto +230 -> 576
    //   349: iload 6
    //   351: ifeq +56 -> 407
    //   354: iload 6
    //   356: istore 7
    //   358: aload 9
    //   360: astore 10
    //   362: aload 9
    //   364: aload 13
    //   366: invokevirtual 592	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: ldc_w 594
    //   372: invokevirtual 598	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   375: invokevirtual 602	java/io/FileOutputStream:write	([B)V
    //   378: iload 6
    //   380: istore 7
    //   382: aload 9
    //   384: astore 10
    //   386: aload 9
    //   388: invokevirtual 603	java/io/FileOutputStream:flush	()V
    //   391: iload 6
    //   393: istore 7
    //   395: aload 9
    //   397: astore 10
    //   399: aload_1
    //   400: invokestatic 153	java/lang/System:currentTimeMillis	()J
    //   403: invokevirtual 344	java/io/File:setLastModified	(J)Z
    //   406: pop
    //   407: aload 9
    //   409: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   412: pop
    //   413: iload 6
    //   415: ireturn
    //   416: astore_0
    //   417: iload 7
    //   419: istore 6
    //   421: aload 10
    //   423: astore_0
    //   424: ldc 61
    //   426: iconst_1
    //   427: new 63	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 65	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 494
    //   437: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload_1
    //   441: invokevirtual 56	java/io/File:exists	()Z
    //   444: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   447: ldc_w 496
    //   450: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload_1
    //   454: invokevirtual 165	java/io/File:getParentFile	()Ljava/io/File;
    //   457: invokevirtual 56	java/io/File:exists	()Z
    //   460: invokevirtual 470	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   463: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: aload_0
    //   470: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   473: pop
    //   474: iconst_0
    //   475: ireturn
    //   476: astore_0
    //   477: aconst_null
    //   478: astore 9
    //   480: iload 8
    //   482: istore 6
    //   484: iload 6
    //   486: istore 7
    //   488: aload 9
    //   490: astore 10
    //   492: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +22 -> 517
    //   498: iload 6
    //   500: istore 7
    //   502: aload 9
    //   504: astore 10
    //   506: ldc 61
    //   508: iconst_2
    //   509: aload_0
    //   510: invokevirtual 604	java/io/IOException:getMessage	()Ljava/lang/String;
    //   513: aload_0
    //   514: invokestatic 498	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   517: aload 9
    //   519: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   522: pop
    //   523: iconst_0
    //   524: ireturn
    //   525: astore_0
    //   526: iconst_1
    //   527: istore 6
    //   529: aconst_null
    //   530: astore 10
    //   532: aload 10
    //   534: invokestatic 127	cooperation/qzone/util/DataUtils:closeDataObject	(Ljava/lang/Object;)Z
    //   537: pop
    //   538: iload 6
    //   540: ireturn
    //   541: astore_0
    //   542: iload 7
    //   544: istore 6
    //   546: goto -14 -> 532
    //   549: astore_1
    //   550: aload_0
    //   551: astore 10
    //   553: goto -21 -> 532
    //   556: astore_0
    //   557: goto -73 -> 484
    //   560: astore_0
    //   561: aload 9
    //   563: astore_0
    //   564: goto -140 -> 424
    //   567: iload 4
    //   569: iconst_1
    //   570: iadd
    //   571: istore 4
    //   573: goto -524 -> 49
    //   576: iconst_0
    //   577: istore 6
    //   579: goto -12 -> 567
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	paramArrayOfHeader	Header[]
    //   0	582	1	paramFile	File
    //   0	582	2	paramString	String
    //   0	582	3	paramHashMap	java.util.HashMap<String, String>
    //   47	525	4	i	int
    //   29	25	5	j	int
    //   7	571	6	bool1	boolean
    //   1	542	7	bool2	boolean
    //   4	477	8	bool3	boolean
    //   44	518	9	localFileOutputStream	java.io.FileOutputStream
    //   25	527	10	localObject1	Object
    //   60	236	11	localObject2	Object
    //   309	33	11	localJSONException	org.json.JSONException
    //   94	11	12	str1	String
    //   22	343	13	localJSONObject	org.json.JSONObject
    //   77	208	14	str2	String
    // Exception table:
    //   from	to	target	type
    //   253	263	309	org/json/JSONException
    //   271	306	309	org/json/JSONException
    //   36	46	416	java/io/FileNotFoundException
    //   36	46	476	java/io/IOException
    //   36	46	525	finally
    //   70	79	541	finally
    //   87	96	541	finally
    //   116	125	541	finally
    //   133	144	541	finally
    //   152	163	541	finally
    //   171	182	541	finally
    //   190	201	541	finally
    //   212	219	541	finally
    //   227	237	541	finally
    //   253	263	541	finally
    //   271	306	541	finally
    //   319	325	541	finally
    //   333	346	541	finally
    //   362	378	541	finally
    //   386	391	541	finally
    //   399	407	541	finally
    //   492	498	541	finally
    //   506	517	541	finally
    //   424	469	549	finally
    //   70	79	556	java/io/IOException
    //   87	96	556	java/io/IOException
    //   116	125	556	java/io/IOException
    //   133	144	556	java/io/IOException
    //   152	163	556	java/io/IOException
    //   171	182	556	java/io/IOException
    //   190	201	556	java/io/IOException
    //   212	219	556	java/io/IOException
    //   227	237	556	java/io/IOException
    //   253	263	556	java/io/IOException
    //   271	306	556	java/io/IOException
    //   319	325	556	java/io/IOException
    //   333	346	556	java/io/IOException
    //   362	378	556	java/io/IOException
    //   386	391	556	java/io/IOException
    //   399	407	556	java/io/IOException
    //   70	79	560	java/io/FileNotFoundException
    //   87	96	560	java/io/FileNotFoundException
    //   116	125	560	java/io/FileNotFoundException
    //   133	144	560	java/io/FileNotFoundException
    //   152	163	560	java/io/FileNotFoundException
    //   171	182	560	java/io/FileNotFoundException
    //   190	201	560	java/io/FileNotFoundException
    //   212	219	560	java/io/FileNotFoundException
    //   227	237	560	java/io/FileNotFoundException
    //   253	263	560	java/io/FileNotFoundException
    //   271	306	560	java/io/FileNotFoundException
    //   319	325	560	java/io/FileNotFoundException
    //   333	346	560	java/io/FileNotFoundException
    //   362	378	560	java/io/FileNotFoundException
    //   386	391	560	java/io/FileNotFoundException
    //   399	407	560	java/io/FileNotFoundException
  }
  
  private static String byteArrayToHex(byte[] paramArrayOfByte)
  {
    int i = 0;
    char[] arrayOfChar1 = new char[16];
    char[] tmp10_8 = arrayOfChar1;
    tmp10_8[0] = 48;
    char[] tmp16_10 = tmp10_8;
    tmp16_10[1] = 49;
    char[] tmp22_16 = tmp16_10;
    tmp22_16[2] = 50;
    char[] tmp28_22 = tmp22_16;
    tmp28_22[3] = 51;
    char[] tmp34_28 = tmp28_22;
    tmp34_28[4] = 52;
    char[] tmp40_34 = tmp34_28;
    tmp40_34[5] = 53;
    char[] tmp46_40 = tmp40_34;
    tmp46_40[6] = 54;
    char[] tmp53_46 = tmp46_40;
    tmp53_46[7] = 55;
    char[] tmp60_53 = tmp53_46;
    tmp60_53[8] = 56;
    char[] tmp67_60 = tmp60_53;
    tmp67_60[9] = 57;
    char[] tmp74_67 = tmp67_60;
    tmp74_67[10] = 65;
    char[] tmp81_74 = tmp74_67;
    tmp81_74[11] = 66;
    char[] tmp88_81 = tmp81_74;
    tmp88_81[12] = 67;
    char[] tmp95_88 = tmp88_81;
    tmp95_88[13] = 68;
    char[] tmp102_95 = tmp95_88;
    tmp102_95[14] = 69;
    char[] tmp109_102 = tmp102_95;
    tmp109_102[15] = 70;
    tmp109_102;
    char[] arrayOfChar2 = new char[paramArrayOfByte.length * 2];
    int k = paramArrayOfByte.length;
    int j = 0;
    while (i < k)
    {
      int m = paramArrayOfByte[i];
      int n = j + 1;
      arrayOfChar2[j] = arrayOfChar1[(m >>> 4 & 0xF)];
      j = n + 1;
      arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar2);
  }
  
  public static String cr(String paramString1, String paramString2)
  {
    String str2 = "";
    String str1 = str2;
    if (paramString1 != null)
    {
      str1 = str2;
      if (paramString1.length() != 0)
      {
        str1 = str2;
        if (paramString2 != null)
        {
          if (paramString2.length() != 0) {
            break label45;
          }
          str1 = str2;
        }
      }
    }
    return str1;
    label45:
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("\\&");
    int j = arrayOfString.length;
    int i = 0;
    paramString1 = str2;
    for (;;)
    {
      str1 = paramString1;
      if (i >= j) {
        break;
      }
      str1 = arrayOfString[i];
      if (str1.contains(paramString2)) {
        paramString1 = str1.replace(paramString2 + "=", "");
      }
      i += 1;
    }
  }
  
  public static String sa(String paramString)
  {
    String str = paramString;
    if (!TextUtils.isEmpty(paramString))
    {
      int i = paramString.indexOf("#");
      str = paramString;
      if (i > -1) {
        str = paramString.substring(0, i);
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awda
 * JD-Core Version:    0.7.0.1
 */