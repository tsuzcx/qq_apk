import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public class aobk
{
  /* Error */
  public static final String a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +11 -> 15
    //   7: aload 5
    //   9: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifeq +13 -> 25
    //   15: ldc 18
    //   17: iconst_1
    //   18: ldc 20
    //   20: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_0
    //   26: sipush 142
    //   29: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   32: checkcast 34	aoam
    //   35: astore 14
    //   37: new 36	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   44: astore_0
    //   45: aload_0
    //   46: aload_1
    //   47: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aconst_null
    //   57: astore_0
    //   58: new 50	anzp
    //   61: dup
    //   62: invokespecial 51	anzp:<init>	()V
    //   65: astore 13
    //   67: ldc 53
    //   69: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   72: astore 15
    //   74: aload 15
    //   76: aconst_null
    //   77: iconst_1
    //   78: anewarray 61	javax/net/ssl/TrustManager
    //   81: dup
    //   82: iconst_0
    //   83: aload 13
    //   85: aastore
    //   86: aconst_null
    //   87: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   90: new 67	anzr
    //   93: dup
    //   94: aload 15
    //   96: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   99: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   102: astore 15
    //   104: aload 15
    //   106: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   109: new 81	java/net/URL
    //   112: dup
    //   113: aload_1
    //   114: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   117: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   120: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   123: astore 13
    //   125: aload 13
    //   127: aload 15
    //   129: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   132: aload 13
    //   134: sipush 5000
    //   137: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   140: aload 13
    //   142: sipush 30000
    //   145: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   148: aload 13
    //   150: iconst_1
    //   151: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   154: aload 13
    //   156: iconst_1
    //   157: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   160: aload 13
    //   162: iconst_0
    //   163: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   166: aload 13
    //   168: ldc 110
    //   170: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   173: aload 13
    //   175: ldc 115
    //   177: ldc 117
    //   179: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   182: aload 13
    //   184: ldc 123
    //   186: new 36	java/lang/StringBuilder
    //   189: dup
    //   190: ldc 125
    //   192: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   195: ldc 128
    //   197: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   203: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   214: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 128
    //   219: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   225: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 128
    //   230: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc 144
    //   235: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc 128
    //   240: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: ldc 146
    //   245: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: ldc 148
    //   250: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 13
    //   261: ldc 150
    //   263: ldc 152
    //   265: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: aload 13
    //   270: ldc 154
    //   272: new 36	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   279: ldc 156
    //   281: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 158
    //   286: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   295: new 160	java/util/HashMap
    //   298: dup
    //   299: invokespecial 161	java/util/HashMap:<init>	()V
    //   302: astore 15
    //   304: aload 15
    //   306: ldc 115
    //   308: ldc 163
    //   310: invokeinterface 169 3 0
    //   315: pop
    //   316: aload 15
    //   318: ldc 171
    //   320: aload_3
    //   321: invokeinterface 169 3 0
    //   326: pop
    //   327: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   330: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   333: iconst_2
    //   334: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   337: checkcast 189	mqq/manager/TicketManager
    //   340: astore_0
    //   341: aload_0
    //   342: aload 5
    //   344: invokeinterface 193 2 0
    //   349: pop
    //   350: aload_1
    //   351: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   354: ifne +683 -> 1037
    //   357: aload_0
    //   358: aload 5
    //   360: ldc 195
    //   362: invokeinterface 199 3 0
    //   367: astore_0
    //   368: aload_0
    //   369: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   372: ifeq +157 -> 529
    //   375: ldc 18
    //   377: iconst_1
    //   378: ldc 201
    //   380: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   386: astore_0
    //   387: aload_0
    //   388: ifnull +18 -> 406
    //   391: aload 15
    //   393: ldc 208
    //   395: aload_0
    //   396: aload_1
    //   397: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   400: invokeinterface 169 3 0
    //   405: pop
    //   406: aload 15
    //   408: invokeinterface 215 1 0
    //   413: invokeinterface 221 1 0
    //   418: astore_0
    //   419: aload_0
    //   420: invokeinterface 227 1 0
    //   425: ifeq +144 -> 569
    //   428: aload_0
    //   429: invokeinterface 231 1 0
    //   434: checkcast 233	java/util/Map$Entry
    //   437: astore_1
    //   438: aload 13
    //   440: aload_1
    //   441: invokeinterface 236 1 0
    //   446: checkcast 238	java/lang/String
    //   449: aload_1
    //   450: invokeinterface 241 1 0
    //   455: checkcast 238	java/lang/String
    //   458: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: goto -42 -> 419
    //   464: astore_1
    //   465: aload 13
    //   467: astore_0
    //   468: ldc 243
    //   470: iconst_1
    //   471: new 36	java/lang/StringBuilder
    //   474: dup
    //   475: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   478: ldc 245
    //   480: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   487: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload 14
    //   498: iconst_1
    //   499: iconst_1
    //   500: iconst_2
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: ldc 250
    //   508: invokestatic 256	acfp:m	(I)Ljava/lang/String;
    //   511: aastore
    //   512: dup
    //   513: iconst_1
    //   514: aload_3
    //   515: aastore
    //   516: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   519: aload_0
    //   520: ifnull +7 -> 527
    //   523: aload_0
    //   524: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   527: aconst_null
    //   528: areturn
    //   529: aload 15
    //   531: ldc_w 265
    //   534: new 36	java/lang/StringBuilder
    //   537: dup
    //   538: aload 4
    //   540: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   543: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokeinterface 169 3 0
    //   551: pop
    //   552: goto -146 -> 406
    //   555: astore_0
    //   556: aload 13
    //   558: astore_1
    //   559: aload_1
    //   560: ifnull +7 -> 567
    //   563: aload_1
    //   564: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   567: aload_0
    //   568: athrow
    //   569: aload 13
    //   571: invokevirtual 268	javax/net/ssl/HttpsURLConnection:connect	()V
    //   574: aload 13
    //   576: invokevirtual 272	javax/net/ssl/HttpsURLConnection:getContentLength	()I
    //   579: istore 7
    //   581: invokestatic 276	aobk:hg	()J
    //   584: lstore 9
    //   586: iload 7
    //   588: i2l
    //   589: lload 9
    //   591: lcmp
    //   592: ifle +40 -> 632
    //   595: aload 14
    //   597: iconst_1
    //   598: iconst_1
    //   599: iconst_2
    //   600: anewarray 4	java/lang/Object
    //   603: dup
    //   604: iconst_0
    //   605: ldc_w 277
    //   608: invokestatic 256	acfp:m	(I)Ljava/lang/String;
    //   611: aastore
    //   612: dup
    //   613: iconst_1
    //   614: aload_3
    //   615: aastore
    //   616: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   619: aload 13
    //   621: ifnull -94 -> 527
    //   624: aload 13
    //   626: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   629: goto -102 -> 527
    //   632: aload 13
    //   634: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   637: astore 4
    //   639: new 283	java/io/ByteArrayOutputStream
    //   642: dup
    //   643: invokespecial 284	java/io/ByteArrayOutputStream:<init>	()V
    //   646: astore 5
    //   648: iconst_0
    //   649: istore 6
    //   651: sipush 10240
    //   654: newarray byte
    //   656: astore_0
    //   657: lconst_0
    //   658: lstore 9
    //   660: aload 4
    //   662: aload_0
    //   663: invokevirtual 290	java/io/InputStream:read	([B)I
    //   666: istore 8
    //   668: iload 8
    //   670: iconst_m1
    //   671: if_icmpeq +68 -> 739
    //   674: iload 6
    //   676: iload 8
    //   678: iadd
    //   679: istore 6
    //   681: aload 5
    //   683: aload_0
    //   684: iconst_0
    //   685: iload 8
    //   687: invokevirtual 294	java/io/ByteArrayOutputStream:write	([BII)V
    //   690: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   693: lstore 11
    //   695: lload 11
    //   697: lload 9
    //   699: lsub
    //   700: ldc2_w 300
    //   703: lcmp
    //   704: iflt +330 -> 1034
    //   707: aload 14
    //   709: iconst_4
    //   710: iconst_1
    //   711: iconst_1
    //   712: anewarray 4	java/lang/Object
    //   715: dup
    //   716: iconst_0
    //   717: iload 6
    //   719: bipush 100
    //   721: imul
    //   722: iload 7
    //   724: idiv
    //   725: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   728: aastore
    //   729: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   732: lload 11
    //   734: lstore 9
    //   736: goto +306 -> 1042
    //   739: aload 5
    //   741: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   744: aload 5
    //   746: invokevirtual 314	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   749: astore 15
    //   751: new 36	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   758: getstatic 319	acbn:bmg	Ljava/lang/String;
    //   761: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_2
    //   765: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   771: invokestatic 324	ahav:kW	(Ljava/lang/String;)Ljava/lang/String;
    //   774: astore_2
    //   775: new 326	java/io/FileOutputStream
    //   778: dup
    //   779: new 328	java/io/File
    //   782: dup
    //   783: aload_2
    //   784: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   787: invokespecial 332	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   790: astore_1
    //   791: aload_1
    //   792: astore_0
    //   793: aload_1
    //   794: aload 15
    //   796: invokevirtual 335	java/io/FileOutputStream:write	([B)V
    //   799: iload 6
    //   801: iload 7
    //   803: if_icmplt +55 -> 858
    //   806: aload_1
    //   807: astore_0
    //   808: aload 14
    //   810: iconst_3
    //   811: iconst_1
    //   812: iconst_2
    //   813: anewarray 4	java/lang/Object
    //   816: dup
    //   817: iconst_0
    //   818: aload_2
    //   819: aastore
    //   820: dup
    //   821: iconst_1
    //   822: aload_3
    //   823: aastore
    //   824: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   827: aload 5
    //   829: ifnull +8 -> 837
    //   832: aload 5
    //   834: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   837: aload_1
    //   838: ifnull +7 -> 845
    //   841: aload_1
    //   842: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   845: aload 4
    //   847: ifnull -228 -> 619
    //   850: aload 4
    //   852: invokevirtual 337	java/io/InputStream:close	()V
    //   855: goto -236 -> 619
    //   858: aload_1
    //   859: astore_0
    //   860: aload 14
    //   862: iconst_1
    //   863: iconst_1
    //   864: iconst_2
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: ldc_w 338
    //   873: invokestatic 256	acfp:m	(I)Ljava/lang/String;
    //   876: aastore
    //   877: dup
    //   878: iconst_1
    //   879: aload_3
    //   880: aastore
    //   881: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   884: goto -57 -> 827
    //   887: astore_2
    //   888: aload_1
    //   889: astore_0
    //   890: ldc 243
    //   892: iconst_1
    //   893: new 36	java/lang/StringBuilder
    //   896: dup
    //   897: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   900: ldc_w 340
    //   903: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: aload_2
    //   907: invokevirtual 341	java/io/IOException:toString	()Ljava/lang/String;
    //   910: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   916: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   919: aload_1
    //   920: astore_0
    //   921: aload 14
    //   923: iconst_1
    //   924: iconst_1
    //   925: iconst_2
    //   926: anewarray 4	java/lang/Object
    //   929: dup
    //   930: iconst_0
    //   931: ldc_w 342
    //   934: invokestatic 256	acfp:m	(I)Ljava/lang/String;
    //   937: aastore
    //   938: dup
    //   939: iconst_1
    //   940: aload_3
    //   941: aastore
    //   942: invokevirtual 260	aoam:notifyUI	(IZLjava/lang/Object;)V
    //   945: aload 5
    //   947: ifnull +8 -> 955
    //   950: aload 5
    //   952: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   955: aload_1
    //   956: ifnull +7 -> 963
    //   959: aload_1
    //   960: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   963: aload 4
    //   965: ifnull -346 -> 619
    //   968: aload 4
    //   970: invokevirtual 337	java/io/InputStream:close	()V
    //   973: goto -354 -> 619
    //   976: aload 5
    //   978: ifnull +8 -> 986
    //   981: aload 5
    //   983: invokevirtual 310	java/io/ByteArrayOutputStream:close	()V
    //   986: aload_0
    //   987: ifnull +7 -> 994
    //   990: aload_0
    //   991: invokevirtual 336	java/io/FileOutputStream:close	()V
    //   994: aload 4
    //   996: ifnull +8 -> 1004
    //   999: aload 4
    //   1001: invokevirtual 337	java/io/InputStream:close	()V
    //   1004: aload_1
    //   1005: athrow
    //   1006: astore_0
    //   1007: aconst_null
    //   1008: astore_1
    //   1009: goto -450 -> 559
    //   1012: astore_2
    //   1013: aload_0
    //   1014: astore_1
    //   1015: aload_2
    //   1016: astore_0
    //   1017: goto -458 -> 559
    //   1020: astore_1
    //   1021: goto -553 -> 468
    //   1024: astore_1
    //   1025: goto -49 -> 976
    //   1028: astore_2
    //   1029: aconst_null
    //   1030: astore_1
    //   1031: goto -143 -> 888
    //   1034: goto +8 -> 1042
    //   1037: aconst_null
    //   1038: astore_0
    //   1039: goto -671 -> 368
    //   1042: goto -382 -> 660
    //   1045: astore_1
    //   1046: aconst_null
    //   1047: astore_0
    //   1048: goto -72 -> 976
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1051	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1051	1	paramString1	String
    //   0	1051	2	paramString2	String
    //   0	1051	3	paramString3	String
    //   0	1051	4	paramString4	String
    //   0	1051	5	paramString5	String
    //   649	155	6	i	int
    //   579	225	7	j	int
    //   666	20	8	k	int
    //   584	151	9	l1	long
    //   693	40	11	l2	long
    //   65	568	13	localObject1	Object
    //   35	887	14	localaoam	aoam
    //   72	723	15	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   125	368	464	java/lang/Exception
    //   368	387	464	java/lang/Exception
    //   391	406	464	java/lang/Exception
    //   406	419	464	java/lang/Exception
    //   419	461	464	java/lang/Exception
    //   529	552	464	java/lang/Exception
    //   569	586	464	java/lang/Exception
    //   595	619	464	java/lang/Exception
    //   632	648	464	java/lang/Exception
    //   832	837	464	java/lang/Exception
    //   841	845	464	java/lang/Exception
    //   850	855	464	java/lang/Exception
    //   950	955	464	java/lang/Exception
    //   959	963	464	java/lang/Exception
    //   968	973	464	java/lang/Exception
    //   981	986	464	java/lang/Exception
    //   990	994	464	java/lang/Exception
    //   999	1004	464	java/lang/Exception
    //   1004	1006	464	java/lang/Exception
    //   125	368	555	finally
    //   368	387	555	finally
    //   391	406	555	finally
    //   406	419	555	finally
    //   419	461	555	finally
    //   529	552	555	finally
    //   569	586	555	finally
    //   595	619	555	finally
    //   632	648	555	finally
    //   832	837	555	finally
    //   841	845	555	finally
    //   850	855	555	finally
    //   950	955	555	finally
    //   959	963	555	finally
    //   968	973	555	finally
    //   981	986	555	finally
    //   990	994	555	finally
    //   999	1004	555	finally
    //   1004	1006	555	finally
    //   793	799	887	java/io/IOException
    //   808	827	887	java/io/IOException
    //   860	884	887	java/io/IOException
    //   58	125	1006	finally
    //   468	519	1012	finally
    //   58	125	1020	java/lang/Exception
    //   793	799	1024	finally
    //   808	827	1024	finally
    //   860	884	1024	finally
    //   890	919	1024	finally
    //   921	945	1024	finally
    //   651	657	1028	java/io/IOException
    //   660	668	1028	java/io/IOException
    //   681	695	1028	java/io/IOException
    //   707	732	1028	java/io/IOException
    //   739	791	1028	java/io/IOException
    //   651	657	1045	finally
    //   660	668	1045	finally
    //   681	695	1045	finally
    //   707	732	1045	finally
    //   739	791	1045	finally
  }
  
  /* Error */
  public static final String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: ifnull +20 -> 27
    //   10: aload_0
    //   11: getfield 351	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   14: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifne +10 -> 27
    //   20: aload_1
    //   21: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +16 -> 40
    //   27: ldc 18
    //   29: iconst_1
    //   30: ldc_w 353
    //   33: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: aconst_null
    //   37: astore_3
    //   38: aload_3
    //   39: areturn
    //   40: aload_0
    //   41: getfield 351	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   44: astore 5
    //   46: new 36	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   53: astore 4
    //   55: new 328	java/io/File
    //   58: dup
    //   59: aload 5
    //   61: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   64: astore 8
    //   66: aload 8
    //   68: ifnull +697 -> 765
    //   71: aload 8
    //   73: invokevirtual 356	java/io/File:exists	()Z
    //   76: ifeq +689 -> 765
    //   79: aload 5
    //   81: invokestatic 359	aobk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   84: astore_3
    //   85: aload 4
    //   87: ldc_w 361
    //   90: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc_w 363
    //   100: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc_w 365
    //   106: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload_3
    //   110: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 367
    //   116: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload 8
    //   121: invokevirtual 370	java/io/File:getName	()Ljava/lang/String;
    //   124: ldc_w 372
    //   127: invokestatic 377	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   130: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: ldc_w 379
    //   136: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 381
    //   142: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: ldc_w 383
    //   148: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: astore 9
    //   153: aload_0
    //   154: getfield 386	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjG	Ljava/lang/String;
    //   157: ifnull +8 -> 165
    //   160: aload_0
    //   161: getfield 386	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:cjG	Ljava/lang/String;
    //   164: astore_3
    //   165: aload 9
    //   167: aload_3
    //   168: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 388
    //   174: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_0
    //   178: getfield 392	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filetype	I
    //   181: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   184: ldc_w 397
    //   187: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 400	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   194: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_0
    //   199: invokestatic 405	aoag:d	(Lcom/tencent/mobileqq/teamwork/TeamWorkFileImportInfo;)Z
    //   202: ifeq +22 -> 224
    //   205: aload 4
    //   207: ldc_w 407
    //   210: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload_0
    //   214: getfield 410	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:peerUin	Ljava/lang/String;
    //   217: invokestatic 415	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   220: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 4
    //   226: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: astore 9
    //   231: aload 7
    //   233: astore 4
    //   235: new 50	anzp
    //   238: dup
    //   239: invokespecial 51	anzp:<init>	()V
    //   242: astore_3
    //   243: aload 7
    //   245: astore 4
    //   247: ldc 53
    //   249: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   252: astore 10
    //   254: aload 7
    //   256: astore 4
    //   258: aload 10
    //   260: aconst_null
    //   261: iconst_1
    //   262: anewarray 61	javax/net/ssl/TrustManager
    //   265: dup
    //   266: iconst_0
    //   267: aload_3
    //   268: aastore
    //   269: aconst_null
    //   270: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   273: aload 7
    //   275: astore 4
    //   277: new 67	anzr
    //   280: dup
    //   281: aload 10
    //   283: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   286: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   289: astore 10
    //   291: aload 7
    //   293: astore 4
    //   295: aload 10
    //   297: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   300: aload 7
    //   302: astore 4
    //   304: new 81	java/net/URL
    //   307: dup
    //   308: aload 9
    //   310: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   313: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   316: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   319: astore_3
    //   320: aload_3
    //   321: aload 10
    //   323: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   326: aload_3
    //   327: sipush 5000
    //   330: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   333: aload_3
    //   334: sipush 30000
    //   337: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   340: aload_3
    //   341: iconst_1
    //   342: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   345: aload_3
    //   346: iconst_1
    //   347: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   350: aload_3
    //   351: iconst_0
    //   352: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   355: aload_3
    //   356: ldc_w 420
    //   359: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   362: aload_3
    //   363: ldc 115
    //   365: ldc 117
    //   367: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_3
    //   371: ldc 123
    //   373: new 36	java/lang/StringBuilder
    //   376: dup
    //   377: ldc 125
    //   379: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   382: ldc 128
    //   384: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   390: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: ldc 128
    //   395: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   401: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: ldc 128
    //   406: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   412: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: ldc 128
    //   417: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: ldc 144
    //   422: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc 128
    //   427: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: ldc 146
    //   432: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc 148
    //   437: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload_3
    //   447: ldc 150
    //   449: ldc 152
    //   451: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   454: aload_3
    //   455: ldc 154
    //   457: new 36	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   464: ldc 156
    //   466: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: ldc 158
    //   471: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   477: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   480: new 160	java/util/HashMap
    //   483: dup
    //   484: invokespecial 161	java/util/HashMap:<init>	()V
    //   487: astore 10
    //   489: aload 10
    //   491: ldc 115
    //   493: ldc 163
    //   495: invokeinterface 169 3 0
    //   500: pop
    //   501: aload 10
    //   503: ldc 171
    //   505: aload 9
    //   507: invokeinterface 169 3 0
    //   512: pop
    //   513: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   516: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   519: iconst_2
    //   520: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   523: checkcast 189	mqq/manager/TicketManager
    //   526: astore 4
    //   528: aload 4
    //   530: aload_1
    //   531: invokeinterface 193 2 0
    //   536: astore 11
    //   538: aload 9
    //   540: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   543: ifne +818 -> 1361
    //   546: aload 4
    //   548: aload_1
    //   549: ldc 195
    //   551: invokeinterface 199 3 0
    //   556: astore 4
    //   558: aload 8
    //   560: ifnull +795 -> 1355
    //   563: aload 8
    //   565: invokevirtual 356	java/io/File:exists	()Z
    //   568: ifeq +787 -> 1355
    //   571: aload 5
    //   573: invokestatic 359	aobk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   576: astore 5
    //   578: aload 4
    //   580: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   583: ifeq +193 -> 776
    //   586: ldc 18
    //   588: iconst_1
    //   589: ldc_w 422
    //   592: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   598: astore_1
    //   599: aload_1
    //   600: ifnull +20 -> 620
    //   603: aload 10
    //   605: ldc_w 265
    //   608: aload_1
    //   609: aload 9
    //   611: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   614: invokeinterface 169 3 0
    //   619: pop
    //   620: aload 10
    //   622: invokeinterface 215 1 0
    //   627: invokeinterface 221 1 0
    //   632: astore_1
    //   633: aload_1
    //   634: invokeinterface 227 1 0
    //   639: ifeq +247 -> 886
    //   642: aload_1
    //   643: invokeinterface 231 1 0
    //   648: checkcast 233	java/util/Map$Entry
    //   651: astore 4
    //   653: aload_3
    //   654: aload 4
    //   656: invokeinterface 236 1 0
    //   661: checkcast 238	java/lang/String
    //   664: aload 4
    //   666: invokeinterface 241 1 0
    //   671: checkcast 238	java/lang/String
    //   674: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   677: goto -44 -> 633
    //   680: astore 4
    //   682: aconst_null
    //   683: astore_0
    //   684: aload_3
    //   685: astore_1
    //   686: aload 4
    //   688: astore_3
    //   689: aload_1
    //   690: astore 4
    //   692: ldc 243
    //   694: iconst_1
    //   695: new 36	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   702: ldc_w 424
    //   705: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: aload_3
    //   709: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   712: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload_0
    //   722: astore_3
    //   723: aload_1
    //   724: ifnull -686 -> 38
    //   727: aload_1
    //   728: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   731: aload_0
    //   732: areturn
    //   733: astore_0
    //   734: ldc 18
    //   736: iconst_1
    //   737: new 36	java/lang/StringBuilder
    //   740: dup
    //   741: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   744: ldc_w 426
    //   747: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: aload_0
    //   751: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   754: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: aconst_null
    //   764: areturn
    //   765: ldc 18
    //   767: iconst_1
    //   768: ldc_w 428
    //   771: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   774: aconst_null
    //   775: areturn
    //   776: new 36	java/lang/StringBuilder
    //   779: dup
    //   780: new 36	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 430
    //   790: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 4
    //   795: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: ldc_w 432
    //   801: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_1
    //   805: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc_w 434
    //   811: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: aload 11
    //   816: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   825: astore_1
    //   826: aload 5
    //   828: ifnull +29 -> 857
    //   831: aload_1
    //   832: new 36	java/lang/StringBuilder
    //   835: dup
    //   836: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   839: ldc_w 436
    //   842: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: aload 5
    //   847: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   850: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: pop
    //   857: aload 10
    //   859: ldc_w 265
    //   862: aload_1
    //   863: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   866: invokeinterface 169 3 0
    //   871: pop
    //   872: goto -252 -> 620
    //   875: astore_0
    //   876: aload_3
    //   877: ifnull +7 -> 884
    //   880: aload_3
    //   881: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   884: aload_0
    //   885: athrow
    //   886: aload_0
    //   887: getfield 400	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:dNR	I
    //   890: iconst_1
    //   891: if_icmpeq +312 -> 1203
    //   894: new 438	java/io/DataOutputStream
    //   897: dup
    //   898: aload_3
    //   899: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   902: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   905: astore_1
    //   906: new 447	java/lang/StringBuffer
    //   909: dup
    //   910: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   913: astore_0
    //   914: aload_0
    //   915: ldc_w 450
    //   918: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   921: ldc_w 455
    //   924: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   927: ldc 158
    //   929: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   932: ldc_w 450
    //   935: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   938: pop
    //   939: aload_0
    //   940: ldc_w 457
    //   943: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   946: ldc_w 459
    //   949: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   952: ldc_w 461
    //   955: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   958: aload 8
    //   960: invokevirtual 370	java/io/File:getName	()Ljava/lang/String;
    //   963: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   966: ldc_w 463
    //   969: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   972: ldc_w 450
    //   975: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   978: pop
    //   979: aload_0
    //   980: new 36	java/lang/StringBuilder
    //   983: dup
    //   984: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   987: ldc_w 465
    //   990: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   993: ldc_w 467
    //   996: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   999: ldc_w 469
    //   1002: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1005: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1008: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1011: pop
    //   1012: aload_1
    //   1013: aload_0
    //   1014: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1017: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1020: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1023: new 478	java/io/BufferedInputStream
    //   1026: dup
    //   1027: new 478	java/io/BufferedInputStream
    //   1030: dup
    //   1031: new 480	java/io/FileInputStream
    //   1034: dup
    //   1035: aload 8
    //   1037: invokespecial 481	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1040: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1043: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1046: astore_0
    //   1047: sipush 3072
    //   1050: newarray byte
    //   1052: astore 4
    //   1054: aload_0
    //   1055: aload 4
    //   1057: invokevirtual 485	java/io/BufferedInputStream:read	([B)I
    //   1060: istore_2
    //   1061: iload_2
    //   1062: iconst_m1
    //   1063: if_icmpeq +94 -> 1157
    //   1066: aload_1
    //   1067: aload 4
    //   1069: iconst_0
    //   1070: iload_2
    //   1071: invokevirtual 486	java/io/OutputStream:write	([BII)V
    //   1074: goto -20 -> 1054
    //   1077: astore 4
    //   1079: ldc 18
    //   1081: iconst_1
    //   1082: new 36	java/lang/StringBuilder
    //   1085: dup
    //   1086: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1089: ldc_w 488
    //   1092: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload 8
    //   1097: invokevirtual 491	java/io/File:length	()J
    //   1100: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1103: ldc_w 496
    //   1106: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload 8
    //   1111: invokevirtual 499	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1114: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1120: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1123: aload_1
    //   1124: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1127: aload_1
    //   1128: invokevirtual 503	java/io/OutputStream:close	()V
    //   1131: aload_3
    //   1132: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1135: aload 7
    //   1137: astore 4
    //   1139: aload_0
    //   1140: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1143: iconst_0
    //   1144: ifeq +11 -> 1155
    //   1147: new 506	java/lang/NullPointerException
    //   1150: dup
    //   1151: invokespecial 507	java/lang/NullPointerException:<init>	()V
    //   1154: athrow
    //   1155: aconst_null
    //   1156: areturn
    //   1157: aload_0
    //   1158: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1161: aload_1
    //   1162: new 36	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1169: ldc_w 509
    //   1172: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: ldc 158
    //   1177: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1180: ldc_w 511
    //   1183: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1189: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1192: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1195: aload_1
    //   1196: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1199: aload_1
    //   1200: invokevirtual 503	java/io/OutputStream:close	()V
    //   1203: new 447	java/lang/StringBuffer
    //   1206: dup
    //   1207: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   1210: astore 4
    //   1212: aload_3
    //   1213: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1216: istore_2
    //   1217: iload_2
    //   1218: sipush 200
    //   1221: if_icmpeq +35 -> 1256
    //   1224: ldc 18
    //   1226: iconst_1
    //   1227: new 36	java/lang/StringBuilder
    //   1230: dup
    //   1231: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1234: ldc_w 516
    //   1237: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: iload_2
    //   1241: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1244: ldc_w 518
    //   1247: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1250: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1253: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1256: new 523	java/io/BufferedReader
    //   1259: dup
    //   1260: new 525	java/io/InputStreamReader
    //   1263: dup
    //   1264: aload_3
    //   1265: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1268: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1271: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1274: astore_1
    //   1275: aload_1
    //   1276: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1279: astore_0
    //   1280: aload_0
    //   1281: ifnull +26 -> 1307
    //   1284: aload 4
    //   1286: aload_0
    //   1287: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1290: ldc_w 534
    //   1293: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1296: pop
    //   1297: goto -22 -> 1275
    //   1300: astore_1
    //   1301: aload_0
    //   1302: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1305: aload_1
    //   1306: athrow
    //   1307: aload 4
    //   1309: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1312: astore_0
    //   1313: aload_1
    //   1314: invokevirtual 535	java/io/BufferedReader:close	()V
    //   1317: aload_3
    //   1318: ifnull +35 -> 1353
    //   1321: aload_3
    //   1322: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1325: aload_0
    //   1326: areturn
    //   1327: astore_0
    //   1328: aload 4
    //   1330: astore_3
    //   1331: goto -455 -> 876
    //   1334: astore_3
    //   1335: aconst_null
    //   1336: astore_0
    //   1337: aload 6
    //   1339: astore_1
    //   1340: goto -651 -> 689
    //   1343: astore 4
    //   1345: aload_3
    //   1346: astore_1
    //   1347: aload 4
    //   1349: astore_3
    //   1350: goto -661 -> 689
    //   1353: aload_0
    //   1354: areturn
    //   1355: aconst_null
    //   1356: astore 5
    //   1358: goto -780 -> 578
    //   1361: aconst_null
    //   1362: astore 4
    //   1364: goto -806 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1367	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1367	1	paramString	String
    //   1060	181	2	i	int
    //   37	1294	3	localObject1	Object
    //   1334	12	3	localException1	java.lang.Exception
    //   1349	1	3	localObject2	Object
    //   53	612	4	localObject3	Object
    //   680	7	4	localException2	java.lang.Exception
    //   690	378	4	localObject4	Object
    //   1077	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1137	192	4	localObject5	Object
    //   1343	5	4	localException3	java.lang.Exception
    //   1362	1	4	localObject6	Object
    //   44	1313	5	str1	String
    //   4	1334	6	localObject7	Object
    //   1	1135	7	localObject8	Object
    //   64	1046	8	localFile	java.io.File
    //   151	459	9	localObject9	Object
    //   252	606	10	localObject10	Object
    //   536	279	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   320	558	680	java/lang/Exception
    //   563	578	680	java/lang/Exception
    //   578	599	680	java/lang/Exception
    //   603	620	680	java/lang/Exception
    //   620	633	680	java/lang/Exception
    //   633	677	680	java/lang/Exception
    //   776	826	680	java/lang/Exception
    //   831	857	680	java/lang/Exception
    //   857	872	680	java/lang/Exception
    //   886	1054	680	java/lang/Exception
    //   1157	1203	680	java/lang/Exception
    //   1203	1217	680	java/lang/Exception
    //   1224	1256	680	java/lang/Exception
    //   1256	1275	680	java/lang/Exception
    //   1275	1280	680	java/lang/Exception
    //   1284	1297	680	java/lang/Exception
    //   1301	1307	680	java/lang/Exception
    //   1307	1313	680	java/lang/Exception
    //   79	153	733	java/lang/Exception
    //   153	165	733	java/lang/Exception
    //   165	224	733	java/lang/Exception
    //   320	558	875	finally
    //   563	578	875	finally
    //   578	599	875	finally
    //   603	620	875	finally
    //   620	633	875	finally
    //   633	677	875	finally
    //   776	826	875	finally
    //   831	857	875	finally
    //   857	872	875	finally
    //   886	1054	875	finally
    //   1157	1203	875	finally
    //   1203	1217	875	finally
    //   1224	1256	875	finally
    //   1256	1275	875	finally
    //   1275	1280	875	finally
    //   1284	1297	875	finally
    //   1301	1307	875	finally
    //   1307	1313	875	finally
    //   1313	1317	875	finally
    //   1054	1061	1077	java/lang/OutOfMemoryError
    //   1066	1074	1077	java/lang/OutOfMemoryError
    //   1054	1061	1300	finally
    //   1066	1074	1300	finally
    //   1079	1135	1300	finally
    //   235	243	1327	finally
    //   247	254	1327	finally
    //   258	273	1327	finally
    //   277	291	1327	finally
    //   295	300	1327	finally
    //   304	320	1327	finally
    //   692	721	1327	finally
    //   1139	1143	1327	finally
    //   235	243	1334	java/lang/Exception
    //   247	254	1334	java/lang/Exception
    //   258	273	1334	java/lang/Exception
    //   277	291	1334	java/lang/Exception
    //   295	300	1334	java/lang/Exception
    //   304	320	1334	java/lang/Exception
    //   1139	1143	1334	java/lang/Exception
    //   1313	1317	1343	java/lang/Exception
  }
  
  /* Error */
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, java.util.Map<String, String> paramMap, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 9
    //   6: aload_2
    //   7: invokevirtual 537	java/lang/String:toString	()Ljava/lang/String;
    //   10: astore 11
    //   12: aload 10
    //   14: astore 8
    //   16: new 50	anzp
    //   19: dup
    //   20: invokespecial 51	anzp:<init>	()V
    //   23: astore_2
    //   24: aload 10
    //   26: astore 8
    //   28: ldc 53
    //   30: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   33: astore 12
    //   35: aload 10
    //   37: astore 8
    //   39: aload 12
    //   41: aconst_null
    //   42: iconst_1
    //   43: anewarray 61	javax/net/ssl/TrustManager
    //   46: dup
    //   47: iconst_0
    //   48: aload_2
    //   49: aastore
    //   50: aconst_null
    //   51: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   54: aload 10
    //   56: astore 8
    //   58: new 67	anzr
    //   61: dup
    //   62: aload 12
    //   64: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   67: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   70: astore 12
    //   72: aload 10
    //   74: astore 8
    //   76: aload 12
    //   78: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   81: aload 10
    //   83: astore 8
    //   85: new 81	java/net/URL
    //   88: dup
    //   89: aload 11
    //   91: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   94: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   97: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   100: astore_2
    //   101: aload_2
    //   102: aload 12
    //   104: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   107: aload_2
    //   108: sipush 5000
    //   111: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   114: aload_2
    //   115: sipush 30000
    //   118: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   121: aload_2
    //   122: iconst_1
    //   123: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   126: aload_2
    //   127: iconst_1
    //   128: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   131: aload_2
    //   132: iconst_0
    //   133: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   136: aload_2
    //   137: ldc_w 420
    //   140: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: aload_2
    //   144: ldc 115
    //   146: ldc 117
    //   148: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_2
    //   152: ldc 123
    //   154: new 36	java/lang/StringBuilder
    //   157: dup
    //   158: ldc 125
    //   160: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: ldc 128
    //   165: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   171: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: ldc 128
    //   176: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   182: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc 128
    //   187: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   193: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc 128
    //   198: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 144
    //   203: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: ldc 128
    //   208: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 146
    //   213: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: ldc 148
    //   218: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: iload 6
    //   229: ifeq +147 -> 376
    //   232: aload_2
    //   233: ldc 154
    //   235: ldc_w 539
    //   238: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   241: aload_2
    //   242: ldc 150
    //   244: ldc 152
    //   246: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: aload_2
    //   250: ldc_w 541
    //   253: ldc_w 372
    //   256: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 5
    //   261: ifnull +138 -> 399
    //   264: aload 5
    //   266: invokeinterface 215 1 0
    //   271: invokeinterface 221 1 0
    //   276: astore 5
    //   278: aload 5
    //   280: invokeinterface 227 1 0
    //   285: ifeq +114 -> 399
    //   288: aload 5
    //   290: invokeinterface 231 1 0
    //   295: checkcast 233	java/util/Map$Entry
    //   298: astore 8
    //   300: aload_2
    //   301: aload 8
    //   303: invokeinterface 236 1 0
    //   308: checkcast 238	java/lang/String
    //   311: aload 8
    //   313: invokeinterface 241 1 0
    //   318: checkcast 238	java/lang/String
    //   321: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: goto -46 -> 278
    //   327: astore_3
    //   328: aconst_null
    //   329: astore_1
    //   330: aload_2
    //   331: astore_0
    //   332: aload_3
    //   333: astore_2
    //   334: aload_0
    //   335: astore 8
    //   337: ldc 18
    //   339: iconst_1
    //   340: new 36	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   347: ldc_w 543
    //   350: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: aload_2
    //   354: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   357: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_0
    //   367: ifnull +7 -> 374
    //   370: aload_0
    //   371: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   374: aload_1
    //   375: areturn
    //   376: aload_2
    //   377: ldc 154
    //   379: ldc_w 545
    //   382: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: goto -144 -> 241
    //   388: astore_0
    //   389: aload_2
    //   390: ifnull +7 -> 397
    //   393: aload_2
    //   394: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   397: aload_0
    //   398: athrow
    //   399: new 160	java/util/HashMap
    //   402: dup
    //   403: invokespecial 161	java/util/HashMap:<init>	()V
    //   406: astore 5
    //   408: aload 5
    //   410: ldc 115
    //   412: ldc 163
    //   414: invokeinterface 169 3 0
    //   419: pop
    //   420: aload 5
    //   422: ldc 171
    //   424: aload 11
    //   426: invokeinterface 169 3 0
    //   431: pop
    //   432: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   435: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   438: iconst_2
    //   439: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   442: checkcast 189	mqq/manager/TicketManager
    //   445: astore 9
    //   447: aload 9
    //   449: aload_1
    //   450: invokeinterface 193 2 0
    //   455: astore 8
    //   457: aload 11
    //   459: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   462: ifne +377 -> 839
    //   465: aload 9
    //   467: aload_1
    //   468: aload_3
    //   469: invokeinterface 199 3 0
    //   474: astore_3
    //   475: aload_3
    //   476: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   479: ifeq +94 -> 573
    //   482: ldc 18
    //   484: iconst_1
    //   485: ldc_w 547
    //   488: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   494: astore_1
    //   495: aload_1
    //   496: ifnull +20 -> 516
    //   499: aload 5
    //   501: ldc_w 265
    //   504: aload_1
    //   505: aload 11
    //   507: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   510: invokeinterface 169 3 0
    //   515: pop
    //   516: aload 5
    //   518: invokeinterface 215 1 0
    //   523: invokeinterface 221 1 0
    //   528: astore_1
    //   529: aload_1
    //   530: invokeinterface 227 1 0
    //   535: ifeq +115 -> 650
    //   538: aload_1
    //   539: invokeinterface 231 1 0
    //   544: checkcast 233	java/util/Map$Entry
    //   547: astore_3
    //   548: aload_2
    //   549: aload_3
    //   550: invokeinterface 236 1 0
    //   555: checkcast 238	java/lang/String
    //   558: aload_3
    //   559: invokeinterface 241 1 0
    //   564: checkcast 238	java/lang/String
    //   567: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   570: goto -41 -> 529
    //   573: new 36	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 430
    //   583: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_3
    //   587: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: ldc_w 432
    //   593: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: ldc_w 434
    //   603: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload 8
    //   608: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: astore_1
    //   612: aload 4
    //   614: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   617: ifne +15 -> 632
    //   620: aload_1
    //   621: bipush 59
    //   623: invokevirtual 550	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   626: aload 4
    //   628: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: pop
    //   632: aload 5
    //   634: ldc_w 265
    //   637: aload_1
    //   638: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokeinterface 169 3 0
    //   646: pop
    //   647: goto -131 -> 516
    //   650: new 438	java/io/DataOutputStream
    //   653: dup
    //   654: aload_2
    //   655: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   658: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   661: astore_1
    //   662: aload_1
    //   663: aload_0
    //   664: ldc_w 372
    //   667: invokevirtual 553	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   670: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   673: aload_1
    //   674: invokevirtual 502	java/io/OutputStream:flush	()V
    //   677: aload_1
    //   678: invokevirtual 503	java/io/OutputStream:close	()V
    //   681: new 447	java/lang/StringBuffer
    //   684: dup
    //   685: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   688: astore_1
    //   689: aload_2
    //   690: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   693: istore 7
    //   695: iload 7
    //   697: sipush 200
    //   700: if_icmpeq +36 -> 736
    //   703: ldc 18
    //   705: iconst_1
    //   706: new 36	java/lang/StringBuilder
    //   709: dup
    //   710: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   713: ldc_w 555
    //   716: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: iload 7
    //   721: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   724: ldc_w 518
    //   727: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   730: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   733: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   736: new 523	java/io/BufferedReader
    //   739: dup
    //   740: new 525	java/io/InputStreamReader
    //   743: dup
    //   744: aload_2
    //   745: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   748: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   751: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   754: astore_0
    //   755: aload_0
    //   756: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   759: astore_3
    //   760: aload_3
    //   761: ifnull +33 -> 794
    //   764: aload_1
    //   765: aload_3
    //   766: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   769: ldc_w 534
    //   772: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   775: pop
    //   776: goto -21 -> 755
    //   779: astore_0
    //   780: aload_1
    //   781: invokevirtual 503	java/io/OutputStream:close	()V
    //   784: aload_2
    //   785: ifnull +7 -> 792
    //   788: aload_2
    //   789: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   792: aconst_null
    //   793: areturn
    //   794: aload_1
    //   795: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   798: astore_1
    //   799: aload_0
    //   800: invokevirtual 535	java/io/BufferedReader:close	()V
    //   803: aload_2
    //   804: ifnull +33 -> 837
    //   807: aload_2
    //   808: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   811: aload_1
    //   812: areturn
    //   813: astore_0
    //   814: aload 8
    //   816: astore_2
    //   817: goto -428 -> 389
    //   820: astore_2
    //   821: aconst_null
    //   822: astore_1
    //   823: aload 9
    //   825: astore_0
    //   826: goto -492 -> 334
    //   829: astore_3
    //   830: aload_2
    //   831: astore_0
    //   832: aload_3
    //   833: astore_2
    //   834: goto -500 -> 334
    //   837: aload_1
    //   838: areturn
    //   839: aconst_null
    //   840: astore_3
    //   841: goto -366 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	844	0	paramString1	String
    //   0	844	1	paramString2	String
    //   0	844	2	paramString3	String
    //   0	844	3	paramString4	String
    //   0	844	4	paramString5	String
    //   0	844	5	paramMap	java.util.Map<String, String>
    //   0	844	6	paramBoolean	boolean
    //   693	27	7	i	int
    //   14	801	8	localObject1	Object
    //   4	820	9	localTicketManager	mqq.manager.TicketManager
    //   1	81	10	localObject2	Object
    //   10	496	11	str	String
    //   33	70	12	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   101	227	327	java/lang/Exception
    //   232	241	327	java/lang/Exception
    //   241	259	327	java/lang/Exception
    //   264	278	327	java/lang/Exception
    //   278	324	327	java/lang/Exception
    //   376	385	327	java/lang/Exception
    //   399	475	327	java/lang/Exception
    //   475	495	327	java/lang/Exception
    //   499	516	327	java/lang/Exception
    //   516	529	327	java/lang/Exception
    //   529	570	327	java/lang/Exception
    //   573	632	327	java/lang/Exception
    //   632	647	327	java/lang/Exception
    //   650	662	327	java/lang/Exception
    //   681	695	327	java/lang/Exception
    //   703	736	327	java/lang/Exception
    //   736	755	327	java/lang/Exception
    //   755	760	327	java/lang/Exception
    //   764	776	327	java/lang/Exception
    //   780	784	327	java/lang/Exception
    //   794	799	327	java/lang/Exception
    //   101	227	388	finally
    //   232	241	388	finally
    //   241	259	388	finally
    //   264	278	388	finally
    //   278	324	388	finally
    //   376	385	388	finally
    //   399	475	388	finally
    //   475	495	388	finally
    //   499	516	388	finally
    //   516	529	388	finally
    //   529	570	388	finally
    //   573	632	388	finally
    //   632	647	388	finally
    //   650	662	388	finally
    //   662	681	388	finally
    //   681	695	388	finally
    //   703	736	388	finally
    //   736	755	388	finally
    //   755	760	388	finally
    //   764	776	388	finally
    //   780	784	388	finally
    //   794	799	388	finally
    //   799	803	388	finally
    //   662	681	779	java/lang/Exception
    //   16	24	813	finally
    //   28	35	813	finally
    //   39	54	813	finally
    //   58	72	813	finally
    //   76	81	813	finally
    //   85	101	813	finally
    //   337	366	813	finally
    //   16	24	820	java/lang/Exception
    //   28	35	820	java/lang/Exception
    //   39	54	820	java/lang/Exception
    //   58	72	820	java/lang/Exception
    //   76	81	820	java/lang/Exception
    //   85	101	820	java/lang/Exception
    //   799	803	829	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: ifnull +10 -> 17
    //   10: aload_2
    //   11: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +16 -> 30
    //   17: ldc 18
    //   19: iconst_1
    //   20: ldc_w 560
    //   23: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   26: aconst_null
    //   27: astore_2
    //   28: aload_2
    //   29: areturn
    //   30: new 36	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc_w 361
    //   44: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_2
    //   48: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: getstatic 565	aoaf:cjB	Ljava/lang/String;
    //   54: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_1
    //   59: getfield 568	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:folderId	Ljava/lang/String;
    //   62: astore_1
    //   63: aload_1
    //   64: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +16 -> 83
    //   70: aload 4
    //   72: ldc_w 570
    //   75: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: astore 7
    //   90: aload 6
    //   92: astore 4
    //   94: new 50	anzp
    //   97: dup
    //   98: invokespecial 51	anzp:<init>	()V
    //   101: astore_1
    //   102: aload 6
    //   104: astore 4
    //   106: ldc 53
    //   108: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   111: astore 8
    //   113: aload 6
    //   115: astore 4
    //   117: aload 8
    //   119: aconst_null
    //   120: iconst_1
    //   121: anewarray 61	javax/net/ssl/TrustManager
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: aconst_null
    //   129: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   132: aload 6
    //   134: astore 4
    //   136: new 67	anzr
    //   139: dup
    //   140: aload 8
    //   142: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   145: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: astore 8
    //   150: aload 6
    //   152: astore 4
    //   154: aload 8
    //   156: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   159: aload 6
    //   161: astore 4
    //   163: new 81	java/net/URL
    //   166: dup
    //   167: aload 7
    //   169: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   172: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   175: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   178: astore_1
    //   179: aload_1
    //   180: aload 8
    //   182: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   185: aload_1
    //   186: sipush 5000
    //   189: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   192: aload_1
    //   193: sipush 30000
    //   196: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   199: aload_1
    //   200: iconst_1
    //   201: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   204: aload_1
    //   205: iconst_1
    //   206: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   209: aload_1
    //   210: iconst_0
    //   211: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   214: aload_1
    //   215: ldc_w 420
    //   218: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   221: aload_1
    //   222: ldc 115
    //   224: ldc 117
    //   226: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_1
    //   230: ldc 123
    //   232: new 36	java/lang/StringBuilder
    //   235: dup
    //   236: ldc 125
    //   238: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: ldc 128
    //   243: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   249: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 128
    //   254: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   260: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 128
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   271: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: ldc 128
    //   276: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: ldc 144
    //   281: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: ldc 128
    //   286: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 146
    //   291: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 148
    //   296: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: ldc 154
    //   308: ldc_w 539
    //   311: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload_1
    //   315: ldc 150
    //   317: ldc 152
    //   319: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: aload_1
    //   323: ldc_w 541
    //   326: ldc_w 372
    //   329: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: new 160	java/util/HashMap
    //   335: dup
    //   336: invokespecial 161	java/util/HashMap:<init>	()V
    //   339: astore 5
    //   341: aload 5
    //   343: ldc 115
    //   345: ldc 163
    //   347: invokeinterface 169 3 0
    //   352: pop
    //   353: aload 5
    //   355: ldc 171
    //   357: aload 7
    //   359: invokeinterface 169 3 0
    //   364: pop
    //   365: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   368: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   371: iconst_2
    //   372: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   375: checkcast 189	mqq/manager/TicketManager
    //   378: astore 4
    //   380: aload 4
    //   382: aload_2
    //   383: invokeinterface 193 2 0
    //   388: astore 6
    //   390: aload 7
    //   392: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   395: ifne +429 -> 824
    //   398: aload 4
    //   400: aload_2
    //   401: ldc 195
    //   403: invokeinterface 199 3 0
    //   408: astore 4
    //   410: aload 4
    //   412: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   415: ifeq +144 -> 559
    //   418: ldc 18
    //   420: iconst_1
    //   421: ldc_w 547
    //   424: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   430: astore_2
    //   431: aload_2
    //   432: ifnull +20 -> 452
    //   435: aload 5
    //   437: ldc_w 265
    //   440: aload_2
    //   441: aload 7
    //   443: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   446: invokeinterface 169 3 0
    //   451: pop
    //   452: aload 5
    //   454: invokeinterface 215 1 0
    //   459: invokeinterface 221 1 0
    //   464: astore_2
    //   465: aload_2
    //   466: invokeinterface 227 1 0
    //   471: ifeq +165 -> 636
    //   474: aload_2
    //   475: invokeinterface 231 1 0
    //   480: checkcast 233	java/util/Map$Entry
    //   483: astore 4
    //   485: aload_1
    //   486: aload 4
    //   488: invokeinterface 236 1 0
    //   493: checkcast 238	java/lang/String
    //   496: aload 4
    //   498: invokeinterface 241 1 0
    //   503: checkcast 238	java/lang/String
    //   506: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: goto -44 -> 465
    //   512: astore_2
    //   513: aconst_null
    //   514: astore_0
    //   515: aload_1
    //   516: astore 4
    //   518: ldc 18
    //   520: iconst_1
    //   521: new 36	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 572
    //   531: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   538: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: aload_0
    //   548: astore_2
    //   549: aload_1
    //   550: ifnull -522 -> 28
    //   553: aload_1
    //   554: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   557: aload_0
    //   558: areturn
    //   559: aload 5
    //   561: ldc_w 265
    //   564: new 36	java/lang/StringBuilder
    //   567: dup
    //   568: new 36	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   575: ldc_w 430
    //   578: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   581: aload 4
    //   583: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: ldc_w 432
    //   589: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: aload_2
    //   593: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc_w 434
    //   599: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload 6
    //   604: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   613: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   616: invokeinterface 169 3 0
    //   621: pop
    //   622: goto -170 -> 452
    //   625: astore_0
    //   626: aload_1
    //   627: ifnull +7 -> 634
    //   630: aload_1
    //   631: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   634: aload_0
    //   635: athrow
    //   636: new 438	java/io/DataOutputStream
    //   639: dup
    //   640: aload_1
    //   641: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   644: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   647: astore_2
    //   648: aload_2
    //   649: aload_0
    //   650: invokevirtual 575	org/json/JSONObject:toString	()Ljava/lang/String;
    //   653: ldc_w 372
    //   656: invokevirtual 553	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   659: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   662: aload_2
    //   663: invokevirtual 502	java/io/OutputStream:flush	()V
    //   666: aload_2
    //   667: invokevirtual 503	java/io/OutputStream:close	()V
    //   670: new 447	java/lang/StringBuffer
    //   673: dup
    //   674: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   677: astore_0
    //   678: aload_1
    //   679: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   682: istore_3
    //   683: iload_3
    //   684: sipush 200
    //   687: if_icmpeq +35 -> 722
    //   690: ldc 18
    //   692: iconst_1
    //   693: new 36	java/lang/StringBuilder
    //   696: dup
    //   697: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   700: ldc_w 577
    //   703: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: iload_3
    //   707: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   710: ldc_w 518
    //   713: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   716: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: new 523	java/io/BufferedReader
    //   725: dup
    //   726: new 525	java/io/InputStreamReader
    //   729: dup
    //   730: aload_1
    //   731: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   734: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   737: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   740: astore_2
    //   741: aload_2
    //   742: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   745: astore 4
    //   747: aload 4
    //   749: ifnull +34 -> 783
    //   752: aload_0
    //   753: aload 4
    //   755: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   758: ldc_w 534
    //   761: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   764: pop
    //   765: goto -24 -> 741
    //   768: astore_0
    //   769: aload_2
    //   770: invokevirtual 503	java/io/OutputStream:close	()V
    //   773: aload_1
    //   774: ifnull +7 -> 781
    //   777: aload_1
    //   778: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   781: aconst_null
    //   782: areturn
    //   783: aload_0
    //   784: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   787: astore_0
    //   788: aload_2
    //   789: invokevirtual 535	java/io/BufferedReader:close	()V
    //   792: aload_1
    //   793: ifnull +29 -> 822
    //   796: aload_1
    //   797: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   800: aload_0
    //   801: areturn
    //   802: astore_0
    //   803: aload 4
    //   805: astore_1
    //   806: goto -180 -> 626
    //   809: astore_2
    //   810: aconst_null
    //   811: astore_0
    //   812: aload 5
    //   814: astore_1
    //   815: goto -300 -> 515
    //   818: astore_2
    //   819: goto -304 -> 515
    //   822: aload_0
    //   823: areturn
    //   824: aconst_null
    //   825: astore 4
    //   827: goto -417 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	paramJSONObject	JSONObject
    //   0	830	1	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	830	2	paramString	String
    //   682	25	3	i	int
    //   37	789	4	localObject1	Object
    //   4	809	5	localHashMap	java.util.HashMap
    //   1	602	6	str1	String
    //   88	354	7	str2	String
    //   111	70	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   179	410	512	java/lang/Exception
    //   410	431	512	java/lang/Exception
    //   435	452	512	java/lang/Exception
    //   452	465	512	java/lang/Exception
    //   465	509	512	java/lang/Exception
    //   559	622	512	java/lang/Exception
    //   636	648	512	java/lang/Exception
    //   670	683	512	java/lang/Exception
    //   690	722	512	java/lang/Exception
    //   722	741	512	java/lang/Exception
    //   741	747	512	java/lang/Exception
    //   752	765	512	java/lang/Exception
    //   769	773	512	java/lang/Exception
    //   783	788	512	java/lang/Exception
    //   179	410	625	finally
    //   410	431	625	finally
    //   435	452	625	finally
    //   452	465	625	finally
    //   465	509	625	finally
    //   559	622	625	finally
    //   636	648	625	finally
    //   648	670	625	finally
    //   670	683	625	finally
    //   690	722	625	finally
    //   722	741	625	finally
    //   741	747	625	finally
    //   752	765	625	finally
    //   769	773	625	finally
    //   783	788	625	finally
    //   788	792	625	finally
    //   648	670	768	java/lang/Exception
    //   94	102	802	finally
    //   106	113	802	finally
    //   117	132	802	finally
    //   136	150	802	finally
    //   154	159	802	finally
    //   163	179	802	finally
    //   518	547	802	finally
    //   94	102	809	java/lang/Exception
    //   106	113	809	java/lang/Exception
    //   117	132	809	java/lang/Exception
    //   136	150	809	java/lang/Exception
    //   154	159	809	java/lang/Exception
    //   163	179	809	java/lang/Exception
    //   788	792	818	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 5
    //   5: aload_0
    //   6: ifnull +10 -> 16
    //   9: aload_1
    //   10: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +16 -> 29
    //   16: ldc 18
    //   18: iconst_1
    //   19: ldc_w 560
    //   22: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_3
    //   27: aload_3
    //   28: areturn
    //   29: new 36	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   36: astore 4
    //   38: aload 4
    //   40: ldc_w 361
    //   43: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_1
    //   47: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: ldc_w 363
    //   53: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 580
    //   59: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload_3
    //   71: astore 4
    //   73: new 50	anzp
    //   76: dup
    //   77: invokespecial 51	anzp:<init>	()V
    //   80: astore 7
    //   82: aload_3
    //   83: astore 4
    //   85: ldc 53
    //   87: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   90: astore 8
    //   92: aload_3
    //   93: astore 4
    //   95: aload 8
    //   97: aconst_null
    //   98: iconst_1
    //   99: anewarray 61	javax/net/ssl/TrustManager
    //   102: dup
    //   103: iconst_0
    //   104: aload 7
    //   106: aastore
    //   107: aconst_null
    //   108: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   111: aload_3
    //   112: astore 4
    //   114: new 67	anzr
    //   117: dup
    //   118: aload 8
    //   120: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   123: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   126: astore 7
    //   128: aload_3
    //   129: astore 4
    //   131: aload 7
    //   133: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   136: aload_3
    //   137: astore 4
    //   139: new 81	java/net/URL
    //   142: dup
    //   143: aload 6
    //   145: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   148: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   151: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   154: astore_3
    //   155: aload_3
    //   156: aload 7
    //   158: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   161: aload_3
    //   162: sipush 5000
    //   165: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   168: aload_3
    //   169: sipush 30000
    //   172: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   175: aload_3
    //   176: iconst_1
    //   177: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   180: aload_3
    //   181: iconst_1
    //   182: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   185: aload_3
    //   186: iconst_0
    //   187: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   190: aload_3
    //   191: ldc_w 420
    //   194: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   197: aload_3
    //   198: ldc 115
    //   200: ldc 117
    //   202: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   205: aload_3
    //   206: ldc 123
    //   208: new 36	java/lang/StringBuilder
    //   211: dup
    //   212: ldc 125
    //   214: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: ldc 128
    //   219: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   225: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc 128
    //   230: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   236: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc 128
    //   241: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   247: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: ldc 128
    //   252: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 144
    //   257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: ldc 128
    //   262: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: ldc 146
    //   267: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 148
    //   272: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_3
    //   282: ldc 154
    //   284: ldc_w 539
    //   287: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: aload_3
    //   291: ldc 150
    //   293: ldc 152
    //   295: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: aload_3
    //   299: ldc_w 541
    //   302: ldc_w 372
    //   305: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: new 160	java/util/HashMap
    //   311: dup
    //   312: invokespecial 161	java/util/HashMap:<init>	()V
    //   315: astore 5
    //   317: aload 5
    //   319: ldc 115
    //   321: ldc 163
    //   323: invokeinterface 169 3 0
    //   328: pop
    //   329: aload 5
    //   331: ldc 171
    //   333: aload 6
    //   335: invokeinterface 169 3 0
    //   340: pop
    //   341: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   344: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   347: iconst_2
    //   348: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   351: checkcast 189	mqq/manager/TicketManager
    //   354: astore 4
    //   356: aload 4
    //   358: aload_1
    //   359: invokeinterface 193 2 0
    //   364: astore 7
    //   366: aload 6
    //   368: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   371: ifne +441 -> 812
    //   374: aload 4
    //   376: aload_1
    //   377: ldc 195
    //   379: invokeinterface 199 3 0
    //   384: astore 4
    //   386: aload 4
    //   388: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifeq +150 -> 541
    //   394: ldc 18
    //   396: iconst_1
    //   397: ldc_w 547
    //   400: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   406: astore_1
    //   407: aload_1
    //   408: ifnull +20 -> 428
    //   411: aload 5
    //   413: ldc_w 265
    //   416: aload_1
    //   417: aload 6
    //   419: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   422: invokeinterface 169 3 0
    //   427: pop
    //   428: aload 5
    //   430: invokeinterface 215 1 0
    //   435: invokeinterface 221 1 0
    //   440: astore_1
    //   441: aload_1
    //   442: invokeinterface 227 1 0
    //   447: ifeq +171 -> 618
    //   450: aload_1
    //   451: invokeinterface 231 1 0
    //   456: checkcast 233	java/util/Map$Entry
    //   459: astore 4
    //   461: aload_3
    //   462: aload 4
    //   464: invokeinterface 236 1 0
    //   469: checkcast 238	java/lang/String
    //   472: aload 4
    //   474: invokeinterface 241 1 0
    //   479: checkcast 238	java/lang/String
    //   482: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   485: goto -44 -> 441
    //   488: astore 4
    //   490: aconst_null
    //   491: astore_0
    //   492: aload_3
    //   493: astore_1
    //   494: aload 4
    //   496: astore_3
    //   497: aload_1
    //   498: astore 4
    //   500: ldc 18
    //   502: iconst_1
    //   503: new 36	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 572
    //   513: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   520: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: astore_3
    //   531: aload_1
    //   532: ifnull -505 -> 27
    //   535: aload_1
    //   536: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   539: aload_0
    //   540: areturn
    //   541: aload 5
    //   543: ldc_w 265
    //   546: new 36	java/lang/StringBuilder
    //   549: dup
    //   550: new 36	java/lang/StringBuilder
    //   553: dup
    //   554: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   557: ldc_w 430
    //   560: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 4
    //   565: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: ldc_w 432
    //   571: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: aload_1
    //   575: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: ldc_w 434
    //   581: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload 7
    //   586: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   595: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokeinterface 169 3 0
    //   603: pop
    //   604: goto -176 -> 428
    //   607: astore_0
    //   608: aload_3
    //   609: ifnull +7 -> 616
    //   612: aload_3
    //   613: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   616: aload_0
    //   617: athrow
    //   618: new 438	java/io/DataOutputStream
    //   621: dup
    //   622: aload_3
    //   623: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   626: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   629: astore_1
    //   630: aload_1
    //   631: aload_0
    //   632: invokevirtual 575	org/json/JSONObject:toString	()Ljava/lang/String;
    //   635: ldc_w 372
    //   638: invokevirtual 553	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   641: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   644: aload_1
    //   645: invokevirtual 502	java/io/OutputStream:flush	()V
    //   648: aload_1
    //   649: invokevirtual 503	java/io/OutputStream:close	()V
    //   652: new 447	java/lang/StringBuffer
    //   655: dup
    //   656: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   659: astore_0
    //   660: aload_3
    //   661: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   664: istore_2
    //   665: iload_2
    //   666: sipush 200
    //   669: if_icmpeq +35 -> 704
    //   672: ldc 18
    //   674: iconst_1
    //   675: new 36	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 577
    //   685: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: iload_2
    //   689: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: ldc_w 518
    //   695: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: new 523	java/io/BufferedReader
    //   707: dup
    //   708: new 525	java/io/InputStreamReader
    //   711: dup
    //   712: aload_3
    //   713: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   716: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   719: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   722: astore_1
    //   723: aload_1
    //   724: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   727: astore 4
    //   729: aload 4
    //   731: ifnull +34 -> 765
    //   734: aload_0
    //   735: aload 4
    //   737: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   740: ldc_w 534
    //   743: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   746: pop
    //   747: goto -24 -> 723
    //   750: astore_0
    //   751: aload_1
    //   752: invokevirtual 503	java/io/OutputStream:close	()V
    //   755: aload_3
    //   756: ifnull +7 -> 763
    //   759: aload_3
    //   760: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   763: aconst_null
    //   764: areturn
    //   765: aload_0
    //   766: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   769: astore_0
    //   770: aload_1
    //   771: invokevirtual 535	java/io/BufferedReader:close	()V
    //   774: aload_3
    //   775: ifnull +35 -> 810
    //   778: aload_3
    //   779: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   782: aload_0
    //   783: areturn
    //   784: astore_0
    //   785: aload 4
    //   787: astore_3
    //   788: goto -180 -> 608
    //   791: astore_3
    //   792: aconst_null
    //   793: astore_0
    //   794: aload 5
    //   796: astore_1
    //   797: goto -300 -> 497
    //   800: astore 4
    //   802: aload_3
    //   803: astore_1
    //   804: aload 4
    //   806: astore_3
    //   807: goto -310 -> 497
    //   810: aload_0
    //   811: areturn
    //   812: aconst_null
    //   813: astore 4
    //   815: goto -429 -> 386
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	818	0	paramJSONObject	JSONObject
    //   0	818	1	paramString	String
    //   664	25	2	i	int
    //   1	787	3	localObject1	Object
    //   791	12	3	localException1	java.lang.Exception
    //   806	1	3	localObject2	Object
    //   36	437	4	localObject3	Object
    //   488	7	4	localException2	java.lang.Exception
    //   498	288	4	str1	String
    //   800	5	4	localException3	java.lang.Exception
    //   813	1	4	localObject4	Object
    //   3	792	5	localHashMap	java.util.HashMap
    //   68	350	6	str2	String
    //   80	505	7	localObject5	Object
    //   90	29	8	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   155	386	488	java/lang/Exception
    //   386	407	488	java/lang/Exception
    //   411	428	488	java/lang/Exception
    //   428	441	488	java/lang/Exception
    //   441	485	488	java/lang/Exception
    //   541	604	488	java/lang/Exception
    //   618	630	488	java/lang/Exception
    //   652	665	488	java/lang/Exception
    //   672	704	488	java/lang/Exception
    //   704	723	488	java/lang/Exception
    //   723	729	488	java/lang/Exception
    //   734	747	488	java/lang/Exception
    //   751	755	488	java/lang/Exception
    //   765	770	488	java/lang/Exception
    //   155	386	607	finally
    //   386	407	607	finally
    //   411	428	607	finally
    //   428	441	607	finally
    //   441	485	607	finally
    //   541	604	607	finally
    //   618	630	607	finally
    //   630	652	607	finally
    //   652	665	607	finally
    //   672	704	607	finally
    //   704	723	607	finally
    //   723	729	607	finally
    //   734	747	607	finally
    //   751	755	607	finally
    //   765	770	607	finally
    //   770	774	607	finally
    //   630	652	750	java/lang/Exception
    //   73	82	784	finally
    //   85	92	784	finally
    //   95	111	784	finally
    //   114	128	784	finally
    //   131	136	784	finally
    //   139	155	784	finally
    //   500	529	784	finally
    //   73	82	791	java/lang/Exception
    //   85	92	791	java/lang/Exception
    //   95	111	791	java/lang/Exception
    //   114	128	791	java/lang/Exception
    //   131	136	791	java/lang/Exception
    //   139	155	791	java/lang/Exception
    //   770	774	800	java/lang/Exception
  }
  
  /* Error */
  public static final String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_1
    //   7: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_3
    //   14: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   17: ifeq +16 -> 33
    //   20: ldc 18
    //   22: iconst_1
    //   23: ldc_w 353
    //   26: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: areturn
    //   33: new 36	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   40: astore 5
    //   42: new 328	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 8
    //   54: ifnull +552 -> 606
    //   57: aload 8
    //   59: invokevirtual 356	java/io/File:exists	()Z
    //   62: ifeq +544 -> 606
    //   65: aload 5
    //   67: aload_2
    //   68: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 5
    //   74: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: astore 9
    //   79: aload 7
    //   81: astore 5
    //   83: new 50	anzp
    //   86: dup
    //   87: invokespecial 51	anzp:<init>	()V
    //   90: astore_2
    //   91: aload 7
    //   93: astore 5
    //   95: ldc 53
    //   97: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   100: astore 10
    //   102: aload 7
    //   104: astore 5
    //   106: aload 10
    //   108: aconst_null
    //   109: iconst_1
    //   110: anewarray 61	javax/net/ssl/TrustManager
    //   113: dup
    //   114: iconst_0
    //   115: aload_2
    //   116: aastore
    //   117: aconst_null
    //   118: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   121: aload 7
    //   123: astore 5
    //   125: new 67	anzr
    //   128: dup
    //   129: aload 10
    //   131: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   134: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   137: astore 10
    //   139: aload 7
    //   141: astore 5
    //   143: aload 10
    //   145: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   148: aload 7
    //   150: astore 5
    //   152: new 81	java/net/URL
    //   155: dup
    //   156: aload 9
    //   158: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   161: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   164: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   167: astore_2
    //   168: aload_2
    //   169: aload 10
    //   171: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   174: aload_2
    //   175: sipush 5000
    //   178: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   181: aload_2
    //   182: sipush 30000
    //   185: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   188: aload_2
    //   189: iconst_1
    //   190: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   193: aload_2
    //   194: iconst_1
    //   195: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   198: aload_2
    //   199: iconst_0
    //   200: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   203: aload_2
    //   204: ldc_w 420
    //   207: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   210: aload_2
    //   211: ldc 115
    //   213: ldc 117
    //   215: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_2
    //   219: ldc 123
    //   221: new 36	java/lang/StringBuilder
    //   224: dup
    //   225: ldc 125
    //   227: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   230: ldc 128
    //   232: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   238: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   241: ldc 128
    //   243: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   249: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: ldc 128
    //   254: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   257: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   260: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: ldc 128
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 144
    //   270: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 128
    //   275: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: ldc 146
    //   280: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 148
    //   285: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_2
    //   295: ldc 150
    //   297: ldc 152
    //   299: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   302: aload_2
    //   303: ldc 154
    //   305: new 36	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   312: ldc 156
    //   314: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: ldc 158
    //   319: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   328: new 160	java/util/HashMap
    //   331: dup
    //   332: invokespecial 161	java/util/HashMap:<init>	()V
    //   335: astore 10
    //   337: aload 10
    //   339: ldc 115
    //   341: ldc 163
    //   343: invokeinterface 169 3 0
    //   348: pop
    //   349: aload 10
    //   351: ldc 171
    //   353: aload 9
    //   355: invokeinterface 169 3 0
    //   360: pop
    //   361: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   364: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   367: iconst_2
    //   368: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   371: checkcast 189	mqq/manager/TicketManager
    //   374: astore 5
    //   376: aload 5
    //   378: aload_3
    //   379: invokeinterface 193 2 0
    //   384: astore 11
    //   386: aload 9
    //   388: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   391: ifne +932 -> 1323
    //   394: aload 5
    //   396: aload_3
    //   397: ldc 195
    //   399: invokeinterface 199 3 0
    //   404: astore 5
    //   406: aload 8
    //   408: ifnull +910 -> 1318
    //   411: aload 8
    //   413: invokevirtual 356	java/io/File:exists	()Z
    //   416: ifeq +902 -> 1318
    //   419: aload_1
    //   420: invokestatic 359	aobk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   423: astore_1
    //   424: aload 5
    //   426: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifeq +188 -> 617
    //   432: ldc 18
    //   434: iconst_1
    //   435: ldc_w 422
    //   438: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   441: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +20 -> 466
    //   449: aload 10
    //   451: ldc_w 265
    //   454: aload_1
    //   455: aload 9
    //   457: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   460: invokeinterface 169 3 0
    //   465: pop
    //   466: aload 10
    //   468: invokeinterface 215 1 0
    //   473: invokeinterface 221 1 0
    //   478: astore_3
    //   479: aload_3
    //   480: invokeinterface 227 1 0
    //   485: ifeq +245 -> 730
    //   488: aload_3
    //   489: invokeinterface 231 1 0
    //   494: checkcast 233	java/util/Map$Entry
    //   497: astore_1
    //   498: aload_2
    //   499: aload_1
    //   500: invokeinterface 236 1 0
    //   505: checkcast 238	java/lang/String
    //   508: aload_1
    //   509: invokeinterface 241 1 0
    //   514: checkcast 238	java/lang/String
    //   517: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: goto -41 -> 479
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_0
    //   526: aload_2
    //   527: astore_1
    //   528: aload_3
    //   529: astore_2
    //   530: aload_1
    //   531: astore 5
    //   533: ldc 243
    //   535: iconst_1
    //   536: new 36	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   543: ldc_w 424
    //   546: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_2
    //   550: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   553: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: aload_0
    //   563: astore_2
    //   564: aload_1
    //   565: ifnull -534 -> 31
    //   568: aload_1
    //   569: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   572: aload_0
    //   573: areturn
    //   574: astore_0
    //   575: ldc 18
    //   577: iconst_1
    //   578: new 36	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 426
    //   588: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: aload_0
    //   592: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   595: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aconst_null
    //   605: areturn
    //   606: ldc 18
    //   608: iconst_1
    //   609: ldc_w 428
    //   612: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aconst_null
    //   616: areturn
    //   617: new 36	java/lang/StringBuilder
    //   620: dup
    //   621: new 36	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   628: ldc_w 430
    //   631: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   634: aload 5
    //   636: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   639: ldc_w 432
    //   642: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: aload_3
    //   646: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: ldc_w 434
    //   652: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload 11
    //   657: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   666: astore_3
    //   667: aload_1
    //   668: ifnull +28 -> 696
    //   671: aload_3
    //   672: new 36	java/lang/StringBuilder
    //   675: dup
    //   676: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   679: ldc_w 436
    //   682: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_1
    //   686: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   689: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   692: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: aload 10
    //   698: ldc_w 265
    //   701: aload_3
    //   702: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: invokeinterface 169 3 0
    //   710: pop
    //   711: goto -245 -> 466
    //   714: astore_0
    //   715: aload_2
    //   716: astore 5
    //   718: aload 5
    //   720: ifnull +8 -> 728
    //   723: aload 5
    //   725: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   728: aload_0
    //   729: athrow
    //   730: new 438	java/io/DataOutputStream
    //   733: dup
    //   734: aload_2
    //   735: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   738: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   741: astore_1
    //   742: aload_0
    //   743: ifnull +132 -> 875
    //   746: new 36	java/lang/StringBuilder
    //   749: dup
    //   750: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   753: astore 5
    //   755: aload_0
    //   756: invokevirtual 584	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   759: astore 10
    //   761: aload 10
    //   763: invokeinterface 227 1 0
    //   768: ifeq +95 -> 863
    //   771: aload 10
    //   773: invokeinterface 231 1 0
    //   778: checkcast 238	java/lang/String
    //   781: astore_3
    //   782: aload_0
    //   783: aload_3
    //   784: invokevirtual 587	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   787: astore 9
    //   789: aload 9
    //   791: ifnull -30 -> 761
    //   794: aload 5
    //   796: ldc_w 450
    //   799: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: ldc_w 455
    //   805: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: ldc 158
    //   810: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: ldc_w 450
    //   816: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload 5
    //   822: new 36	java/lang/StringBuilder
    //   825: dup
    //   826: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   829: ldc_w 457
    //   832: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload_3
    //   836: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: ldc_w 589
    //   842: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   845: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   851: pop
    //   852: aload 5
    //   854: aload 9
    //   856: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: goto -99 -> 761
    //   863: aload_1
    //   864: aload 5
    //   866: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokevirtual 473	java/lang/String:getBytes	()[B
    //   872: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   875: new 447	java/lang/StringBuffer
    //   878: dup
    //   879: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   882: astore_0
    //   883: aload_0
    //   884: ldc_w 450
    //   887: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   890: ldc_w 455
    //   893: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   896: ldc 158
    //   898: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   901: ldc_w 450
    //   904: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   907: pop
    //   908: aload_0
    //   909: ldc_w 457
    //   912: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   915: ldc_w 459
    //   918: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   921: ldc_w 461
    //   924: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   927: aload 8
    //   929: invokevirtual 370	java/io/File:getName	()Ljava/lang/String;
    //   932: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   935: ldc_w 463
    //   938: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   941: ldc_w 450
    //   944: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   947: pop
    //   948: aload_0
    //   949: new 36	java/lang/StringBuilder
    //   952: dup
    //   953: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   956: ldc_w 465
    //   959: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   962: ldc_w 467
    //   965: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: ldc_w 469
    //   971: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   977: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   980: pop
    //   981: aload_1
    //   982: aload_0
    //   983: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   986: invokevirtual 473	java/lang/String:getBytes	()[B
    //   989: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   992: new 478	java/io/BufferedInputStream
    //   995: dup
    //   996: new 478	java/io/BufferedInputStream
    //   999: dup
    //   1000: new 480	java/io/FileInputStream
    //   1003: dup
    //   1004: aload 8
    //   1006: invokespecial 481	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1009: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1012: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1015: astore_0
    //   1016: sipush 3072
    //   1019: newarray byte
    //   1021: astore_3
    //   1022: aload_0
    //   1023: aload_3
    //   1024: invokevirtual 485	java/io/BufferedInputStream:read	([B)I
    //   1027: istore 4
    //   1029: iload 4
    //   1031: iconst_m1
    //   1032: if_icmpeq +93 -> 1125
    //   1035: aload_1
    //   1036: aload_3
    //   1037: iconst_0
    //   1038: iload 4
    //   1040: invokevirtual 486	java/io/OutputStream:write	([BII)V
    //   1043: goto -21 -> 1022
    //   1046: astore_3
    //   1047: ldc 18
    //   1049: iconst_1
    //   1050: new 36	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 488
    //   1060: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload 8
    //   1065: invokevirtual 491	java/io/File:length	()J
    //   1068: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1071: ldc_w 496
    //   1074: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1077: aload 8
    //   1079: invokevirtual 499	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1082: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1091: aload_1
    //   1092: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1095: aload_1
    //   1096: invokevirtual 503	java/io/OutputStream:close	()V
    //   1099: aload_2
    //   1100: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1103: aload 7
    //   1105: astore 5
    //   1107: aload_0
    //   1108: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1111: iconst_0
    //   1112: ifeq +11 -> 1123
    //   1115: new 506	java/lang/NullPointerException
    //   1118: dup
    //   1119: invokespecial 507	java/lang/NullPointerException:<init>	()V
    //   1122: athrow
    //   1123: aconst_null
    //   1124: areturn
    //   1125: aload_0
    //   1126: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1129: aload_1
    //   1130: new 36	java/lang/StringBuilder
    //   1133: dup
    //   1134: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1137: ldc_w 509
    //   1140: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: ldc 158
    //   1145: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: ldc_w 511
    //   1151: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1154: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1157: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1160: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1163: aload_1
    //   1164: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1167: aload_1
    //   1168: invokevirtual 503	java/io/OutputStream:close	()V
    //   1171: new 447	java/lang/StringBuffer
    //   1174: dup
    //   1175: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   1178: astore_3
    //   1179: aload_2
    //   1180: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1183: istore 4
    //   1185: iload 4
    //   1187: sipush 200
    //   1190: if_icmpeq +36 -> 1226
    //   1193: ldc 18
    //   1195: iconst_1
    //   1196: new 36	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1203: ldc_w 516
    //   1206: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: iload 4
    //   1211: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1214: ldc_w 518
    //   1217: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1223: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1226: new 523	java/io/BufferedReader
    //   1229: dup
    //   1230: new 525	java/io/InputStreamReader
    //   1233: dup
    //   1234: aload_2
    //   1235: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1238: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1241: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1244: astore_1
    //   1245: aload_1
    //   1246: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1249: astore_0
    //   1250: aload_0
    //   1251: ifnull +25 -> 1276
    //   1254: aload_3
    //   1255: aload_0
    //   1256: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1259: ldc_w 534
    //   1262: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1265: pop
    //   1266: goto -21 -> 1245
    //   1269: astore_1
    //   1270: aload_0
    //   1271: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1274: aload_1
    //   1275: athrow
    //   1276: aload_3
    //   1277: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1280: astore_0
    //   1281: aload_1
    //   1282: invokevirtual 535	java/io/BufferedReader:close	()V
    //   1285: aload_2
    //   1286: ifnull +30 -> 1316
    //   1289: aload_2
    //   1290: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1293: aload_0
    //   1294: areturn
    //   1295: astore_0
    //   1296: goto -578 -> 718
    //   1299: astore_2
    //   1300: aconst_null
    //   1301: astore_0
    //   1302: aload 6
    //   1304: astore_1
    //   1305: goto -775 -> 530
    //   1308: astore_3
    //   1309: aload_2
    //   1310: astore_1
    //   1311: aload_3
    //   1312: astore_2
    //   1313: goto -783 -> 530
    //   1316: aload_0
    //   1317: areturn
    //   1318: aconst_null
    //   1319: astore_1
    //   1320: goto -896 -> 424
    //   1323: aconst_null
    //   1324: astore 5
    //   1326: goto -920 -> 406
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1329	0	paramJSONObject	JSONObject
    //   0	1329	1	paramString1	String
    //   0	1329	2	paramString2	String
    //   0	1329	3	paramString3	String
    //   1027	183	4	i	int
    //   40	1285	5	localObject1	Object
    //   4	1299	6	localObject2	Object
    //   1	1103	7	localObject3	Object
    //   50	1028	8	localFile	java.io.File
    //   77	778	9	str1	String
    //   100	672	10	localObject4	Object
    //   384	272	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   168	406	523	java/lang/Exception
    //   411	424	523	java/lang/Exception
    //   424	445	523	java/lang/Exception
    //   449	466	523	java/lang/Exception
    //   466	479	523	java/lang/Exception
    //   479	520	523	java/lang/Exception
    //   617	667	523	java/lang/Exception
    //   671	696	523	java/lang/Exception
    //   696	711	523	java/lang/Exception
    //   730	742	523	java/lang/Exception
    //   746	761	523	java/lang/Exception
    //   761	789	523	java/lang/Exception
    //   794	860	523	java/lang/Exception
    //   863	875	523	java/lang/Exception
    //   875	1022	523	java/lang/Exception
    //   1125	1185	523	java/lang/Exception
    //   1193	1226	523	java/lang/Exception
    //   1226	1245	523	java/lang/Exception
    //   1245	1250	523	java/lang/Exception
    //   1254	1266	523	java/lang/Exception
    //   1270	1276	523	java/lang/Exception
    //   1276	1281	523	java/lang/Exception
    //   65	72	574	java/lang/Exception
    //   168	406	714	finally
    //   411	424	714	finally
    //   424	445	714	finally
    //   449	466	714	finally
    //   466	479	714	finally
    //   479	520	714	finally
    //   617	667	714	finally
    //   671	696	714	finally
    //   696	711	714	finally
    //   730	742	714	finally
    //   746	761	714	finally
    //   761	789	714	finally
    //   794	860	714	finally
    //   863	875	714	finally
    //   875	1022	714	finally
    //   1125	1185	714	finally
    //   1193	1226	714	finally
    //   1226	1245	714	finally
    //   1245	1250	714	finally
    //   1254	1266	714	finally
    //   1270	1276	714	finally
    //   1276	1281	714	finally
    //   1281	1285	714	finally
    //   1022	1029	1046	java/lang/OutOfMemoryError
    //   1035	1043	1046	java/lang/OutOfMemoryError
    //   1022	1029	1269	finally
    //   1035	1043	1269	finally
    //   1047	1103	1269	finally
    //   83	91	1295	finally
    //   95	102	1295	finally
    //   106	121	1295	finally
    //   125	139	1295	finally
    //   143	148	1295	finally
    //   152	168	1295	finally
    //   533	562	1295	finally
    //   1107	1111	1295	finally
    //   83	91	1299	java/lang/Exception
    //   95	102	1299	java/lang/Exception
    //   106	121	1299	java/lang/Exception
    //   125	139	1299	java/lang/Exception
    //   143	148	1299	java/lang/Exception
    //   152	168	1299	java/lang/Exception
    //   1107	1111	1299	java/lang/Exception
    //   1281	1285	1308	java/lang/Exception
  }
  
  public static String a(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, paramString4, null, true);
  }
  
  /* Error */
  public static final JSONObject a(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +10 -> 14
    //   7: aload_2
    //   8: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifeq +13 -> 24
    //   14: ldc 18
    //   16: iconst_1
    //   17: ldc 20
    //   19: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aconst_null
    //   23: areturn
    //   24: aload_0
    //   25: sipush 157
    //   28: invokevirtual 32	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   31: checkcast 595	aobx
    //   34: astore 15
    //   36: aload 15
    //   38: iconst_2
    //   39: iconst_1
    //   40: aconst_null
    //   41: invokevirtual 596	aobx:notifyUI	(IZLjava/lang/Object;)V
    //   44: aload 15
    //   46: iconst_4
    //   47: iconst_1
    //   48: iconst_1
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: bipush 20
    //   56: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: invokevirtual 596	aobx:notifyUI	(IZLjava/lang/Object;)V
    //   63: new 36	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   70: astore_0
    //   71: aload_0
    //   72: ldc_w 598
    //   75: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: astore 17
    //   85: new 328	java/io/File
    //   88: dup
    //   89: aload_1
    //   90: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 16
    //   95: aconst_null
    //   96: astore_0
    //   97: aconst_null
    //   98: astore 12
    //   100: aconst_null
    //   101: astore 14
    //   103: aload 12
    //   105: astore 10
    //   107: aload_0
    //   108: astore 11
    //   110: new 50	anzp
    //   113: dup
    //   114: invokespecial 51	anzp:<init>	()V
    //   117: astore 13
    //   119: aload 12
    //   121: astore 10
    //   123: aload_0
    //   124: astore 11
    //   126: ldc 53
    //   128: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   131: astore 18
    //   133: aload 12
    //   135: astore 10
    //   137: aload_0
    //   138: astore 11
    //   140: aload 18
    //   142: aconst_null
    //   143: iconst_1
    //   144: anewarray 61	javax/net/ssl/TrustManager
    //   147: dup
    //   148: iconst_0
    //   149: aload 13
    //   151: aastore
    //   152: aconst_null
    //   153: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   156: aload 12
    //   158: astore 10
    //   160: aload_0
    //   161: astore 11
    //   163: new 67	anzr
    //   166: dup
    //   167: aload 18
    //   169: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   172: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   175: astore 13
    //   177: aload 12
    //   179: astore 10
    //   181: aload_0
    //   182: astore 11
    //   184: aload 13
    //   186: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   189: aload 12
    //   191: astore 10
    //   193: aload_0
    //   194: astore 11
    //   196: new 81	java/net/URL
    //   199: dup
    //   200: aload 17
    //   202: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   205: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   208: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   211: astore_0
    //   212: aload_0
    //   213: astore 10
    //   215: aload_0
    //   216: astore 11
    //   218: aload_0
    //   219: aload 13
    //   221: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   224: aload_0
    //   225: astore 10
    //   227: aload_0
    //   228: astore 11
    //   230: aload_0
    //   231: sipush 5000
    //   234: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   237: aload_0
    //   238: astore 10
    //   240: aload_0
    //   241: astore 11
    //   243: aload_0
    //   244: sipush 30000
    //   247: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   250: aload_0
    //   251: astore 10
    //   253: aload_0
    //   254: astore 11
    //   256: aload_0
    //   257: iconst_1
    //   258: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   261: aload_0
    //   262: astore 10
    //   264: aload_0
    //   265: astore 11
    //   267: aload_0
    //   268: iconst_1
    //   269: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   272: aload_0
    //   273: astore 10
    //   275: aload_0
    //   276: astore 11
    //   278: aload_0
    //   279: iconst_0
    //   280: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   283: aload_0
    //   284: astore 10
    //   286: aload_0
    //   287: astore 11
    //   289: aload_0
    //   290: ldc_w 420
    //   293: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   296: aload_0
    //   297: astore 10
    //   299: aload_0
    //   300: astore 11
    //   302: aload_0
    //   303: ldc 115
    //   305: ldc 117
    //   307: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   310: aload_0
    //   311: astore 10
    //   313: aload_0
    //   314: astore 11
    //   316: aload_0
    //   317: ldc 123
    //   319: new 36	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 125
    //   325: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: ldc 128
    //   330: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   336: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: ldc 128
    //   341: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   347: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: ldc 128
    //   352: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   358: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: ldc 128
    //   363: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc 144
    //   368: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc 128
    //   373: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: ldc 146
    //   378: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: ldc 148
    //   383: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   392: aload_0
    //   393: astore 10
    //   395: aload_0
    //   396: astore 11
    //   398: aload_0
    //   399: ldc 150
    //   401: ldc 152
    //   403: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   406: aload_0
    //   407: astore 10
    //   409: aload_0
    //   410: astore 11
    //   412: aload_0
    //   413: ldc 154
    //   415: new 36	java/lang/StringBuilder
    //   418: dup
    //   419: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   422: ldc 156
    //   424: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: ldc 158
    //   429: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   438: aload_0
    //   439: astore 10
    //   441: aload_0
    //   442: astore 11
    //   444: new 160	java/util/HashMap
    //   447: dup
    //   448: invokespecial 161	java/util/HashMap:<init>	()V
    //   451: astore 18
    //   453: aload_0
    //   454: astore 10
    //   456: aload_0
    //   457: astore 11
    //   459: aload 18
    //   461: ldc 115
    //   463: ldc 163
    //   465: invokeinterface 169 3 0
    //   470: pop
    //   471: aload_0
    //   472: astore 10
    //   474: aload_0
    //   475: astore 11
    //   477: aload 18
    //   479: ldc 171
    //   481: aload 17
    //   483: invokeinterface 169 3 0
    //   488: pop
    //   489: aload_0
    //   490: astore 10
    //   492: aload_0
    //   493: astore 11
    //   495: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   498: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   501: iconst_2
    //   502: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   505: checkcast 189	mqq/manager/TicketManager
    //   508: astore 13
    //   510: aconst_null
    //   511: astore 12
    //   513: aload_0
    //   514: astore 10
    //   516: aload_0
    //   517: astore 11
    //   519: aload 13
    //   521: aload_2
    //   522: invokeinterface 193 2 0
    //   527: astore 19
    //   529: aload_0
    //   530: astore 10
    //   532: aload_0
    //   533: astore 11
    //   535: aload 17
    //   537: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   540: ifne +21 -> 561
    //   543: aload_0
    //   544: astore 10
    //   546: aload_0
    //   547: astore 11
    //   549: aload 13
    //   551: aload_2
    //   552: ldc 195
    //   554: invokeinterface 199 3 0
    //   559: astore 12
    //   561: aconst_null
    //   562: astore 10
    //   564: aload 10
    //   566: astore 13
    //   568: aload 16
    //   570: ifnull +33 -> 603
    //   573: aload 10
    //   575: astore 13
    //   577: aload_0
    //   578: astore 10
    //   580: aload_0
    //   581: astore 11
    //   583: aload 16
    //   585: invokevirtual 356	java/io/File:exists	()Z
    //   588: ifeq +15 -> 603
    //   591: aload_0
    //   592: astore 10
    //   594: aload_0
    //   595: astore 11
    //   597: aload_1
    //   598: invokestatic 359	aobk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   601: astore 13
    //   603: aload_0
    //   604: astore 10
    //   606: aload_0
    //   607: astore 11
    //   609: aload 12
    //   611: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   614: ifeq +164 -> 778
    //   617: aload_0
    //   618: astore 10
    //   620: aload_0
    //   621: astore 11
    //   623: ldc 18
    //   625: iconst_1
    //   626: ldc_w 422
    //   629: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: aload_0
    //   633: astore 10
    //   635: aload_0
    //   636: astore 11
    //   638: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   641: astore_1
    //   642: aload_1
    //   643: ifnull +26 -> 669
    //   646: aload_0
    //   647: astore 10
    //   649: aload_0
    //   650: astore 11
    //   652: aload 18
    //   654: ldc_w 265
    //   657: aload_1
    //   658: aload 17
    //   660: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   663: invokeinterface 169 3 0
    //   668: pop
    //   669: aload_0
    //   670: astore 10
    //   672: aload_0
    //   673: astore 11
    //   675: aload 18
    //   677: invokeinterface 215 1 0
    //   682: invokeinterface 221 1 0
    //   687: astore_1
    //   688: aload_0
    //   689: astore 10
    //   691: aload_0
    //   692: astore 11
    //   694: aload_1
    //   695: invokeinterface 227 1 0
    //   700: ifeq +220 -> 920
    //   703: aload_0
    //   704: astore 10
    //   706: aload_0
    //   707: astore 11
    //   709: aload_1
    //   710: invokeinterface 231 1 0
    //   715: checkcast 233	java/util/Map$Entry
    //   718: astore_2
    //   719: aload_0
    //   720: astore 10
    //   722: aload_0
    //   723: astore 11
    //   725: aload_0
    //   726: aload_2
    //   727: invokeinterface 236 1 0
    //   732: checkcast 238	java/lang/String
    //   735: aload_2
    //   736: invokeinterface 241 1 0
    //   741: checkcast 238	java/lang/String
    //   744: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   747: goto -59 -> 688
    //   750: astore_2
    //   751: aconst_null
    //   752: astore_1
    //   753: aload 10
    //   755: astore_0
    //   756: aload_2
    //   757: invokevirtual 601	java/lang/Exception:printStackTrace	()V
    //   760: aload_1
    //   761: ifnull +7 -> 768
    //   764: aload_1
    //   765: invokevirtual 606	java/util/Timer:cancel	()V
    //   768: aload_0
    //   769: ifnull +890 -> 1659
    //   772: aload_0
    //   773: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   776: aconst_null
    //   777: areturn
    //   778: aload_0
    //   779: astore 10
    //   781: aload_0
    //   782: astore 11
    //   784: new 36	java/lang/StringBuilder
    //   787: dup
    //   788: new 36	java/lang/StringBuilder
    //   791: dup
    //   792: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   795: ldc_w 430
    //   798: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   801: aload 12
    //   803: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: ldc_w 432
    //   809: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_2
    //   813: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 434
    //   819: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 19
    //   824: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   830: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   833: astore_1
    //   834: aload 13
    //   836: ifnull +35 -> 871
    //   839: aload_0
    //   840: astore 10
    //   842: aload_0
    //   843: astore 11
    //   845: aload_1
    //   846: new 36	java/lang/StringBuilder
    //   849: dup
    //   850: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   853: ldc_w 436
    //   856: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 13
    //   861: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload_0
    //   872: astore 10
    //   874: aload_0
    //   875: astore 11
    //   877: aload 18
    //   879: ldc_w 265
    //   882: aload_1
    //   883: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   886: invokeinterface 169 3 0
    //   891: pop
    //   892: goto -223 -> 669
    //   895: astore_1
    //   896: aload 11
    //   898: astore_0
    //   899: aload 14
    //   901: astore_2
    //   902: aload_2
    //   903: ifnull +7 -> 910
    //   906: aload_2
    //   907: invokevirtual 606	java/util/Timer:cancel	()V
    //   910: aload_0
    //   911: ifnull +7 -> 918
    //   914: aload_0
    //   915: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   918: aload_1
    //   919: athrow
    //   920: aload_0
    //   921: astore 10
    //   923: aload_0
    //   924: astore 11
    //   926: new 438	java/io/DataOutputStream
    //   929: dup
    //   930: aload_0
    //   931: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   934: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   937: astore_2
    //   938: aload_0
    //   939: astore 10
    //   941: aload_0
    //   942: astore 11
    //   944: new 447	java/lang/StringBuffer
    //   947: dup
    //   948: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   951: astore_1
    //   952: aload_0
    //   953: astore 10
    //   955: aload_0
    //   956: astore 11
    //   958: aload_1
    //   959: ldc_w 450
    //   962: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   965: ldc_w 455
    //   968: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   971: ldc 158
    //   973: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   976: ldc_w 450
    //   979: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   982: pop
    //   983: aload_0
    //   984: astore 10
    //   986: aload_0
    //   987: astore 11
    //   989: aload_1
    //   990: ldc_w 457
    //   993: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   996: ldc_w 459
    //   999: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1002: ldc_w 461
    //   1005: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1008: aload 16
    //   1010: invokevirtual 370	java/io/File:getName	()Ljava/lang/String;
    //   1013: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1016: ldc_w 463
    //   1019: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1022: ldc_w 450
    //   1025: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1028: pop
    //   1029: aload_0
    //   1030: astore 10
    //   1032: aload_0
    //   1033: astore 11
    //   1035: aload_1
    //   1036: new 36	java/lang/StringBuilder
    //   1039: dup
    //   1040: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1043: ldc_w 465
    //   1046: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: ldc_w 467
    //   1052: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: ldc_w 469
    //   1058: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1067: pop
    //   1068: aload_0
    //   1069: astore 10
    //   1071: aload_0
    //   1072: astore 11
    //   1074: aload_2
    //   1075: aload_1
    //   1076: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1079: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1082: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1085: aload_0
    //   1086: astore 10
    //   1088: aload_0
    //   1089: astore 11
    //   1091: new 478	java/io/BufferedInputStream
    //   1094: dup
    //   1095: new 478	java/io/BufferedInputStream
    //   1098: dup
    //   1099: new 480	java/io/FileInputStream
    //   1102: dup
    //   1103: aload 16
    //   1105: invokespecial 481	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   1108: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1111: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   1114: astore_1
    //   1115: aload_0
    //   1116: astore 10
    //   1118: aload_0
    //   1119: astore 11
    //   1121: sipush 3072
    //   1124: newarray byte
    //   1126: astore 12
    //   1128: aload_0
    //   1129: astore 10
    //   1131: aload_0
    //   1132: astore 11
    //   1134: aload 16
    //   1136: invokevirtual 491	java/io/File:length	()J
    //   1139: lstore 6
    //   1141: lload 6
    //   1143: l2i
    //   1144: istore 4
    //   1146: lconst_0
    //   1147: lstore 6
    //   1149: iconst_0
    //   1150: istore_3
    //   1151: aload_1
    //   1152: aload 12
    //   1154: invokevirtual 485	java/io/BufferedInputStream:read	([B)I
    //   1157: istore 5
    //   1159: iload 5
    //   1161: iconst_m1
    //   1162: if_icmpeq +65 -> 1227
    //   1165: iload_3
    //   1166: iload 5
    //   1168: iadd
    //   1169: istore_3
    //   1170: aload_2
    //   1171: aload 12
    //   1173: iconst_0
    //   1174: iload 5
    //   1176: invokevirtual 486	java/io/OutputStream:write	([BII)V
    //   1179: invokestatic 299	java/lang/System:currentTimeMillis	()J
    //   1182: lstore 8
    //   1184: lload 8
    //   1186: lload 6
    //   1188: lsub
    //   1189: ldc2_w 300
    //   1192: lcmp
    //   1193: iflt +470 -> 1663
    //   1196: aload 15
    //   1198: iconst_4
    //   1199: iconst_1
    //   1200: iconst_1
    //   1201: anewarray 4	java/lang/Object
    //   1204: dup
    //   1205: iconst_0
    //   1206: iload_3
    //   1207: bipush 30
    //   1209: imul
    //   1210: iload 4
    //   1212: idiv
    //   1213: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1216: aastore
    //   1217: invokevirtual 596	aobx:notifyUI	(IZLjava/lang/Object;)V
    //   1220: lload 8
    //   1222: lstore 6
    //   1224: goto -73 -> 1151
    //   1227: aload_0
    //   1228: astore 10
    //   1230: aload_0
    //   1231: astore 11
    //   1233: aload_1
    //   1234: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1237: aload_0
    //   1238: astore 10
    //   1240: aload_0
    //   1241: astore 11
    //   1243: iconst_1
    //   1244: newarray int
    //   1246: astore 12
    //   1248: aload 12
    //   1250: iconst_0
    //   1251: bipush 50
    //   1253: iastore
    //   1254: aload_0
    //   1255: astore 10
    //   1257: aload_0
    //   1258: astore 11
    //   1260: aload 15
    //   1262: iconst_4
    //   1263: iconst_1
    //   1264: iconst_1
    //   1265: anewarray 4	java/lang/Object
    //   1268: dup
    //   1269: iconst_0
    //   1270: aload 12
    //   1272: iconst_0
    //   1273: iaload
    //   1274: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1277: aastore
    //   1278: invokevirtual 596	aobx:notifyUI	(IZLjava/lang/Object;)V
    //   1281: aload_0
    //   1282: astore 10
    //   1284: aload_0
    //   1285: astore 11
    //   1287: new 603	java/util/Timer
    //   1290: dup
    //   1291: invokespecial 607	java/util/Timer:<init>	()V
    //   1294: astore_1
    //   1295: aload_1
    //   1296: new 609	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1
    //   1299: dup
    //   1300: aload 12
    //   1302: aload 15
    //   1304: invokespecial 612	com/tencent/mobileqq/teamwork/TeamWorkHttpUtils$1:<init>	([ILaobx;)V
    //   1307: lconst_0
    //   1308: ldc2_w 300
    //   1311: invokevirtual 616	java/util/Timer:schedule	(Ljava/util/TimerTask;JJ)V
    //   1314: aload_2
    //   1315: new 36	java/lang/StringBuilder
    //   1318: dup
    //   1319: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1322: ldc_w 509
    //   1325: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1328: ldc 158
    //   1330: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1333: ldc_w 511
    //   1336: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1342: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1345: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1348: aload_2
    //   1349: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1352: aload_2
    //   1353: invokevirtual 503	java/io/OutputStream:close	()V
    //   1356: new 447	java/lang/StringBuffer
    //   1359: dup
    //   1360: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   1363: astore 10
    //   1365: aload_0
    //   1366: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1369: istore_3
    //   1370: iload_3
    //   1371: sipush 200
    //   1374: if_icmpeq +35 -> 1409
    //   1377: ldc 18
    //   1379: iconst_1
    //   1380: new 36	java/lang/StringBuilder
    //   1383: dup
    //   1384: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1387: ldc_w 516
    //   1390: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1393: iload_3
    //   1394: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1397: ldc_w 518
    //   1400: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1403: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1406: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1409: new 523	java/io/BufferedReader
    //   1412: dup
    //   1413: new 525	java/io/InputStreamReader
    //   1416: dup
    //   1417: aload_0
    //   1418: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1421: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1424: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1427: astore_2
    //   1428: aload_2
    //   1429: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1432: astore 11
    //   1434: aload 11
    //   1436: ifnull +135 -> 1571
    //   1439: aload 10
    //   1441: aload 11
    //   1443: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1446: ldc_w 534
    //   1449: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1452: pop
    //   1453: goto -25 -> 1428
    //   1456: astore_2
    //   1457: goto -701 -> 756
    //   1460: astore 10
    //   1462: ldc 18
    //   1464: iconst_1
    //   1465: new 36	java/lang/StringBuilder
    //   1468: dup
    //   1469: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1472: ldc_w 488
    //   1475: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1478: aload 16
    //   1480: invokevirtual 491	java/io/File:length	()J
    //   1483: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1486: ldc_w 496
    //   1489: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1492: aload 16
    //   1494: invokevirtual 499	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1497: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1500: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1503: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1506: aload_2
    //   1507: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1510: aload_2
    //   1511: invokevirtual 503	java/io/OutputStream:close	()V
    //   1514: aload_0
    //   1515: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1518: aconst_null
    //   1519: astore 11
    //   1521: aconst_null
    //   1522: astore 10
    //   1524: aload_1
    //   1525: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1528: iconst_0
    //   1529: ifeq +11 -> 1540
    //   1532: new 506	java/lang/NullPointerException
    //   1535: dup
    //   1536: invokespecial 507	java/lang/NullPointerException:<init>	()V
    //   1539: athrow
    //   1540: iconst_0
    //   1541: ifeq -1519 -> 22
    //   1544: new 506	java/lang/NullPointerException
    //   1547: dup
    //   1548: invokespecial 507	java/lang/NullPointerException:<init>	()V
    //   1551: athrow
    //   1552: astore_2
    //   1553: aload_0
    //   1554: astore 10
    //   1556: aload_0
    //   1557: astore 11
    //   1559: aload_1
    //   1560: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1563: aload_0
    //   1564: astore 10
    //   1566: aload_0
    //   1567: astore 11
    //   1569: aload_2
    //   1570: athrow
    //   1571: aload 10
    //   1573: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1576: astore 10
    //   1578: aload_2
    //   1579: invokevirtual 535	java/io/BufferedReader:close	()V
    //   1582: aload 15
    //   1584: iconst_4
    //   1585: iconst_1
    //   1586: iconst_1
    //   1587: anewarray 4	java/lang/Object
    //   1590: dup
    //   1591: iconst_0
    //   1592: bipush 100
    //   1594: invokestatic 307	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1597: aastore
    //   1598: invokevirtual 596	aobx:notifyUI	(IZLjava/lang/Object;)V
    //   1601: new 574	org/json/JSONObject
    //   1604: dup
    //   1605: aload 10
    //   1607: invokespecial 617	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   1610: astore_2
    //   1611: aload_1
    //   1612: ifnull +7 -> 1619
    //   1615: aload_1
    //   1616: invokevirtual 606	java/util/Timer:cancel	()V
    //   1619: aload_0
    //   1620: ifnull +41 -> 1661
    //   1623: aload_0
    //   1624: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1627: aload_2
    //   1628: areturn
    //   1629: astore_2
    //   1630: aload_2
    //   1631: invokevirtual 601	java/lang/Exception:printStackTrace	()V
    //   1634: aconst_null
    //   1635: astore_2
    //   1636: goto -25 -> 1611
    //   1639: astore 10
    //   1641: aload_1
    //   1642: astore_2
    //   1643: aload 10
    //   1645: astore_1
    //   1646: goto -744 -> 902
    //   1649: astore 10
    //   1651: aload_1
    //   1652: astore_2
    //   1653: aload 10
    //   1655: astore_1
    //   1656: goto -754 -> 902
    //   1659: aconst_null
    //   1660: areturn
    //   1661: aload_2
    //   1662: areturn
    //   1663: goto -439 -> 1224
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1666	0	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   0	1666	1	paramString1	String
    //   0	1666	2	paramString2	String
    //   1150	244	3	i	int
    //   1144	69	4	j	int
    //   1157	18	5	k	int
    //   1139	84	6	l1	long
    //   1182	39	8	l2	long
    //   105	1335	10	localObject1	Object
    //   1460	1	10	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1522	84	10	localObject2	Object
    //   1639	5	10	localObject3	Object
    //   1649	5	10	localObject4	Object
    //   108	1460	11	localObject5	Object
    //   98	1203	12	localObject6	Object
    //   117	743	13	localObject7	Object
    //   101	799	14	localObject8	Object
    //   34	1549	15	localaobx	aobx
    //   93	1400	16	localFile	java.io.File
    //   83	576	17	str1	String
    //   131	747	18	localObject9	Object
    //   527	296	19	str2	String
    // Exception table:
    //   from	to	target	type
    //   110	119	750	java/lang/Exception
    //   126	133	750	java/lang/Exception
    //   140	156	750	java/lang/Exception
    //   163	177	750	java/lang/Exception
    //   184	189	750	java/lang/Exception
    //   196	212	750	java/lang/Exception
    //   218	224	750	java/lang/Exception
    //   230	237	750	java/lang/Exception
    //   243	250	750	java/lang/Exception
    //   256	261	750	java/lang/Exception
    //   267	272	750	java/lang/Exception
    //   278	283	750	java/lang/Exception
    //   289	296	750	java/lang/Exception
    //   302	310	750	java/lang/Exception
    //   316	392	750	java/lang/Exception
    //   398	406	750	java/lang/Exception
    //   412	438	750	java/lang/Exception
    //   444	453	750	java/lang/Exception
    //   459	471	750	java/lang/Exception
    //   477	489	750	java/lang/Exception
    //   495	510	750	java/lang/Exception
    //   519	529	750	java/lang/Exception
    //   535	543	750	java/lang/Exception
    //   549	561	750	java/lang/Exception
    //   583	591	750	java/lang/Exception
    //   597	603	750	java/lang/Exception
    //   609	617	750	java/lang/Exception
    //   623	632	750	java/lang/Exception
    //   638	642	750	java/lang/Exception
    //   652	669	750	java/lang/Exception
    //   675	688	750	java/lang/Exception
    //   694	703	750	java/lang/Exception
    //   709	719	750	java/lang/Exception
    //   725	747	750	java/lang/Exception
    //   784	834	750	java/lang/Exception
    //   845	871	750	java/lang/Exception
    //   877	892	750	java/lang/Exception
    //   926	938	750	java/lang/Exception
    //   944	952	750	java/lang/Exception
    //   958	983	750	java/lang/Exception
    //   989	1029	750	java/lang/Exception
    //   1035	1068	750	java/lang/Exception
    //   1074	1085	750	java/lang/Exception
    //   1091	1115	750	java/lang/Exception
    //   1121	1128	750	java/lang/Exception
    //   1134	1141	750	java/lang/Exception
    //   1233	1237	750	java/lang/Exception
    //   1243	1248	750	java/lang/Exception
    //   1260	1281	750	java/lang/Exception
    //   1287	1295	750	java/lang/Exception
    //   1524	1528	750	java/lang/Exception
    //   1559	1563	750	java/lang/Exception
    //   1569	1571	750	java/lang/Exception
    //   110	119	895	finally
    //   126	133	895	finally
    //   140	156	895	finally
    //   163	177	895	finally
    //   184	189	895	finally
    //   196	212	895	finally
    //   218	224	895	finally
    //   230	237	895	finally
    //   243	250	895	finally
    //   256	261	895	finally
    //   267	272	895	finally
    //   278	283	895	finally
    //   289	296	895	finally
    //   302	310	895	finally
    //   316	392	895	finally
    //   398	406	895	finally
    //   412	438	895	finally
    //   444	453	895	finally
    //   459	471	895	finally
    //   477	489	895	finally
    //   495	510	895	finally
    //   519	529	895	finally
    //   535	543	895	finally
    //   549	561	895	finally
    //   583	591	895	finally
    //   597	603	895	finally
    //   609	617	895	finally
    //   623	632	895	finally
    //   638	642	895	finally
    //   652	669	895	finally
    //   675	688	895	finally
    //   694	703	895	finally
    //   709	719	895	finally
    //   725	747	895	finally
    //   784	834	895	finally
    //   845	871	895	finally
    //   877	892	895	finally
    //   926	938	895	finally
    //   944	952	895	finally
    //   958	983	895	finally
    //   989	1029	895	finally
    //   1035	1068	895	finally
    //   1074	1085	895	finally
    //   1091	1115	895	finally
    //   1121	1128	895	finally
    //   1134	1141	895	finally
    //   1233	1237	895	finally
    //   1243	1248	895	finally
    //   1260	1281	895	finally
    //   1287	1295	895	finally
    //   1524	1528	895	finally
    //   1559	1563	895	finally
    //   1569	1571	895	finally
    //   1295	1370	1456	java/lang/Exception
    //   1377	1409	1456	java/lang/Exception
    //   1409	1428	1456	java/lang/Exception
    //   1428	1434	1456	java/lang/Exception
    //   1439	1453	1456	java/lang/Exception
    //   1571	1601	1456	java/lang/Exception
    //   1630	1634	1456	java/lang/Exception
    //   1151	1159	1460	java/lang/OutOfMemoryError
    //   1170	1184	1460	java/lang/OutOfMemoryError
    //   1196	1220	1460	java/lang/OutOfMemoryError
    //   1151	1159	1552	finally
    //   1170	1184	1552	finally
    //   1196	1220	1552	finally
    //   1462	1518	1552	finally
    //   1601	1611	1629	java/lang/Exception
    //   1295	1370	1639	finally
    //   1377	1409	1639	finally
    //   1409	1428	1639	finally
    //   1428	1434	1639	finally
    //   1439	1453	1639	finally
    //   1571	1601	1639	finally
    //   1601	1611	1639	finally
    //   1630	1634	1639	finally
    //   756	760	1649	finally
  }
  
  public static String b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if ((paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramTeamWorkFileImportInfo.srcUrl)) || (TextUtils.isEmpty(paramString))) {
      return "";
    }
    String str = UUID.randomUUID().toString().replaceAll("-", "");
    StringBuilder localStringBuilder = new StringBuilder().append("TOK=").append(str);
    Object localObject2 = paramTeamWorkFileImportInfo.srcUrl;
    try
    {
      localObject1 = URLEncoder.encode((String)localObject2, "UTF-8");
      localObject2 = new StringBuilder("https://docs.qq.com/cgi-go/imp/import_url2doc").append("?xsrf=").append(str);
      if (!TextUtils.isEmpty(paramTeamWorkFileImportInfo.folderId)) {
        ((StringBuilder)localObject2).append("&folderId=").append(paramTeamWorkFileImportInfo.folderId);
      }
      ((StringBuilder)localObject2).append("&url=").append((String)localObject1);
      return i(paramString, ((StringBuilder)localObject2).toString(), "docs.qq.com", localStringBuilder.toString());
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.e("TeamWorkHttpUtils", 2, "url2Doc error", localThrowable);
          localObject1 = localObject2;
        }
      }
    }
  }
  
  public static String b(JSONObject paramJSONObject, String paramString1, String paramString2, String paramString3)
  {
    return a(paramJSONObject.toString(), paramString1, paramString2, paramString3, null, null, true);
  }
  
  public static String bB(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      Object localObject = UUID.randomUUID().toString().replaceAll("-", "");
      paramString1 = new StringBuilder("https://docs.qq.com/cgi-go/discuss/get_unread_reddot").append('?').append("globalPadId=").append(paramString1).append("&type=0").append("&xsrf=").append((String)localObject);
      localObject = new StringBuilder().append("TOK=").append((String)localObject);
      paramString1 = i(paramString2, paramString1.toString(), "docs.qq.com", ((StringBuilder)localObject).toString());
      if (paramString1 != null)
      {
        paramString2 = new JSONObject(paramString1);
        if (paramString2.optInt("ret", -1) == 0) {
          break label169;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHttpUtils", 2, "setPolicy4AllByHttp failed result" + paramString1);
        }
      }
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TeamWorkHttpUtils", 2, paramString1, new Object[0]);
        }
      }
    }
    return "";
    label169:
    paramString1 = paramString2.getString("data");
    return paramString1;
  }
  
  /* Error */
  public static final String c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload_0
    //   7: getfield 351	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   10: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +10 -> 23
    //   16: aload_1
    //   17: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   20: ifeq +16 -> 36
    //   23: ldc 18
    //   25: iconst_1
    //   26: ldc_w 353
    //   29: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   32: aconst_null
    //   33: astore_3
    //   34: aload_3
    //   35: areturn
    //   36: new 36	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   43: astore 4
    //   45: new 328	java/io/File
    //   48: dup
    //   49: aload_0
    //   50: getfield 351	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   53: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore 7
    //   58: aload_0
    //   59: getfield 568	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:folderId	Ljava/lang/String;
    //   62: astore_3
    //   63: aload 7
    //   65: ifnull +588 -> 653
    //   68: aload 7
    //   70: invokevirtual 356	java/io/File:exists	()Z
    //   73: ifeq +580 -> 653
    //   76: aload 4
    //   78: ldc_w 361
    //   81: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_1
    //   85: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: getstatic 686	aoaf:cjA	Ljava/lang/String;
    //   91: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload_3
    //   96: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: ifne +16 -> 115
    //   102: aload 4
    //   104: ldc_w 570
    //   107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_3
    //   111: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload 4
    //   117: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore 8
    //   122: aload 6
    //   124: astore 4
    //   126: new 50	anzp
    //   129: dup
    //   130: invokespecial 51	anzp:<init>	()V
    //   133: astore 9
    //   135: aload 6
    //   137: astore 4
    //   139: ldc 53
    //   141: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   144: astore_3
    //   145: aload 6
    //   147: astore 4
    //   149: aload_3
    //   150: aconst_null
    //   151: iconst_1
    //   152: anewarray 61	javax/net/ssl/TrustManager
    //   155: dup
    //   156: iconst_0
    //   157: aload 9
    //   159: aastore
    //   160: aconst_null
    //   161: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   164: aload 6
    //   166: astore 4
    //   168: new 67	anzr
    //   171: dup
    //   172: aload_3
    //   173: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   176: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   179: astore 9
    //   181: aload 6
    //   183: astore 4
    //   185: aload 9
    //   187: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   190: aload 6
    //   192: astore 4
    //   194: new 81	java/net/URL
    //   197: dup
    //   198: aload 8
    //   200: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   203: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   206: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   209: astore_3
    //   210: aload_3
    //   211: aload 9
    //   213: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   216: aload_3
    //   217: sipush 5000
    //   220: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   223: aload_3
    //   224: sipush 30000
    //   227: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   230: aload_3
    //   231: iconst_1
    //   232: invokevirtual 102	javax/net/ssl/HttpsURLConnection:setDoOutput	(Z)V
    //   235: aload_3
    //   236: iconst_1
    //   237: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   240: aload_3
    //   241: iconst_0
    //   242: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   245: aload_3
    //   246: ldc_w 420
    //   249: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   252: aload_3
    //   253: ldc 115
    //   255: ldc 117
    //   257: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: aload_3
    //   261: ldc 123
    //   263: new 36	java/lang/StringBuilder
    //   266: dup
    //   267: ldc 125
    //   269: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   272: ldc 128
    //   274: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   280: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: ldc 128
    //   285: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   291: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: ldc 128
    //   296: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   302: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc 128
    //   307: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc 144
    //   312: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: ldc 128
    //   317: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 146
    //   322: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 148
    //   327: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   333: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: aload_3
    //   337: ldc 150
    //   339: ldc 152
    //   341: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: aload_3
    //   345: ldc 154
    //   347: new 36	java/lang/StringBuilder
    //   350: dup
    //   351: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   354: ldc 156
    //   356: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: ldc 158
    //   361: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: new 160	java/util/HashMap
    //   373: dup
    //   374: invokespecial 161	java/util/HashMap:<init>	()V
    //   377: astore 9
    //   379: aload 9
    //   381: ldc 115
    //   383: ldc 163
    //   385: invokeinterface 169 3 0
    //   390: pop
    //   391: aload 9
    //   393: ldc 171
    //   395: aload 8
    //   397: invokeinterface 169 3 0
    //   402: pop
    //   403: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   406: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   409: iconst_2
    //   410: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   413: checkcast 189	mqq/manager/TicketManager
    //   416: astore 4
    //   418: aload 4
    //   420: aload_1
    //   421: invokeinterface 193 2 0
    //   426: astore 10
    //   428: aload 8
    //   430: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   433: ifne +801 -> 1234
    //   436: aload 4
    //   438: aload_1
    //   439: ldc 195
    //   441: invokeinterface 199 3 0
    //   446: astore 4
    //   448: aload 7
    //   450: ifnull +779 -> 1229
    //   453: aload 7
    //   455: invokevirtual 356	java/io/File:exists	()Z
    //   458: ifeq +771 -> 1229
    //   461: aload_0
    //   462: getfield 351	com/tencent/mobileqq/teamwork/TeamWorkFileImportInfo:filePath	Ljava/lang/String;
    //   465: invokestatic 359	aobk:dU	(Ljava/lang/String;)Ljava/lang/String;
    //   468: astore_0
    //   469: aload 4
    //   471: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   474: ifeq +190 -> 664
    //   477: ldc 18
    //   479: iconst_1
    //   480: ldc_w 422
    //   483: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   489: astore_0
    //   490: aload_0
    //   491: ifnull +20 -> 511
    //   494: aload 9
    //   496: ldc_w 265
    //   499: aload_0
    //   500: aload 8
    //   502: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   505: invokeinterface 169 3 0
    //   510: pop
    //   511: aload 9
    //   513: invokeinterface 215 1 0
    //   518: invokeinterface 221 1 0
    //   523: astore_0
    //   524: aload_0
    //   525: invokeinterface 227 1 0
    //   530: ifeq +247 -> 777
    //   533: aload_0
    //   534: invokeinterface 231 1 0
    //   539: checkcast 233	java/util/Map$Entry
    //   542: astore_1
    //   543: aload_3
    //   544: aload_1
    //   545: invokeinterface 236 1 0
    //   550: checkcast 238	java/lang/String
    //   553: aload_1
    //   554: invokeinterface 241 1 0
    //   559: checkcast 238	java/lang/String
    //   562: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: goto -41 -> 524
    //   568: astore 4
    //   570: aconst_null
    //   571: astore_0
    //   572: aload_3
    //   573: astore_1
    //   574: aload 4
    //   576: astore_3
    //   577: aload_1
    //   578: astore 4
    //   580: ldc 243
    //   582: iconst_1
    //   583: new 36	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 424
    //   593: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_3
    //   597: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   600: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: aload_0
    //   610: astore_3
    //   611: aload_1
    //   612: ifnull -578 -> 34
    //   615: aload_1
    //   616: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   619: aload_0
    //   620: areturn
    //   621: astore_0
    //   622: ldc 18
    //   624: iconst_1
    //   625: new 36	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 426
    //   635: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload_0
    //   639: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   642: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: aconst_null
    //   652: areturn
    //   653: ldc 18
    //   655: iconst_1
    //   656: ldc_w 428
    //   659: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: aconst_null
    //   663: areturn
    //   664: new 36	java/lang/StringBuilder
    //   667: dup
    //   668: new 36	java/lang/StringBuilder
    //   671: dup
    //   672: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   675: ldc_w 430
    //   678: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: aload 4
    //   683: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: ldc_w 432
    //   689: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_1
    //   693: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: ldc_w 434
    //   699: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: aload 10
    //   704: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   710: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   713: astore_1
    //   714: aload_0
    //   715: ifnull +28 -> 743
    //   718: aload_1
    //   719: new 36	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   726: ldc_w 436
    //   729: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: aload_0
    //   733: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   736: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload 9
    //   745: ldc_w 265
    //   748: aload_1
    //   749: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   752: invokeinterface 169 3 0
    //   757: pop
    //   758: goto -247 -> 511
    //   761: astore_0
    //   762: aload_3
    //   763: astore 4
    //   765: aload 4
    //   767: ifnull +8 -> 775
    //   770: aload 4
    //   772: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   775: aload_0
    //   776: athrow
    //   777: new 438	java/io/DataOutputStream
    //   780: dup
    //   781: aload_3
    //   782: invokevirtual 442	javax/net/ssl/HttpsURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   785: invokespecial 445	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   788: astore_1
    //   789: new 447	java/lang/StringBuffer
    //   792: dup
    //   793: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   796: astore_0
    //   797: aload_0
    //   798: ldc_w 450
    //   801: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   804: ldc_w 455
    //   807: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   810: ldc 158
    //   812: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   815: ldc_w 450
    //   818: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   821: pop
    //   822: aload_0
    //   823: ldc_w 457
    //   826: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   829: ldc_w 459
    //   832: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   835: ldc_w 461
    //   838: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   841: aload 7
    //   843: invokevirtual 370	java/io/File:getName	()Ljava/lang/String;
    //   846: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   849: ldc_w 688
    //   852: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   855: pop
    //   856: aload_0
    //   857: new 36	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 465
    //   867: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: ldc_w 467
    //   873: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: ldc_w 469
    //   879: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   888: pop
    //   889: aload_1
    //   890: aload_0
    //   891: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   894: invokevirtual 473	java/lang/String:getBytes	()[B
    //   897: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   900: new 478	java/io/BufferedInputStream
    //   903: dup
    //   904: new 478	java/io/BufferedInputStream
    //   907: dup
    //   908: new 480	java/io/FileInputStream
    //   911: dup
    //   912: aload 7
    //   914: invokespecial 481	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   917: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   920: invokespecial 484	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   923: astore_0
    //   924: sipush 3072
    //   927: newarray byte
    //   929: astore 4
    //   931: aload_0
    //   932: aload 4
    //   934: invokevirtual 485	java/io/BufferedInputStream:read	([B)I
    //   937: istore_2
    //   938: iload_2
    //   939: iconst_m1
    //   940: if_icmpeq +94 -> 1034
    //   943: aload_1
    //   944: aload 4
    //   946: iconst_0
    //   947: iload_2
    //   948: invokevirtual 486	java/io/OutputStream:write	([BII)V
    //   951: goto -20 -> 931
    //   954: astore 4
    //   956: ldc 18
    //   958: iconst_1
    //   959: new 36	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   966: ldc_w 488
    //   969: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   972: aload 7
    //   974: invokevirtual 491	java/io/File:length	()J
    //   977: invokevirtual 494	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   980: ldc_w 496
    //   983: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: aload 7
    //   988: invokevirtual 499	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   991: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: aload_1
    //   1001: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1004: aload_1
    //   1005: invokevirtual 503	java/io/OutputStream:close	()V
    //   1008: aload_3
    //   1009: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1012: aload 6
    //   1014: astore 4
    //   1016: aload_0
    //   1017: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1020: iconst_0
    //   1021: ifeq +11 -> 1032
    //   1024: new 506	java/lang/NullPointerException
    //   1027: dup
    //   1028: invokespecial 507	java/lang/NullPointerException:<init>	()V
    //   1031: athrow
    //   1032: aconst_null
    //   1033: areturn
    //   1034: aload_0
    //   1035: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1038: aload_1
    //   1039: new 36	java/lang/StringBuilder
    //   1042: dup
    //   1043: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1046: ldc_w 509
    //   1049: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1052: ldc 158
    //   1054: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1057: ldc_w 511
    //   1060: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1066: invokevirtual 473	java/lang/String:getBytes	()[B
    //   1069: invokevirtual 476	java/io/OutputStream:write	([B)V
    //   1072: aload_1
    //   1073: invokevirtual 502	java/io/OutputStream:flush	()V
    //   1076: aload_1
    //   1077: invokevirtual 503	java/io/OutputStream:close	()V
    //   1080: new 447	java/lang/StringBuffer
    //   1083: dup
    //   1084: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   1087: astore_0
    //   1088: aload_3
    //   1089: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   1092: istore_2
    //   1093: iload_2
    //   1094: sipush 200
    //   1097: if_icmpeq +35 -> 1132
    //   1100: ldc 18
    //   1102: iconst_1
    //   1103: new 36	java/lang/StringBuilder
    //   1106: dup
    //   1107: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1110: ldc_w 516
    //   1113: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: iload_2
    //   1117: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1120: ldc_w 518
    //   1123: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1126: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1129: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1132: new 523	java/io/BufferedReader
    //   1135: dup
    //   1136: new 525	java/io/InputStreamReader
    //   1139: dup
    //   1140: aload_3
    //   1141: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1144: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   1147: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   1150: astore_1
    //   1151: aload_1
    //   1152: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   1155: astore 4
    //   1157: aload 4
    //   1159: ifnull +26 -> 1185
    //   1162: aload_0
    //   1163: aload 4
    //   1165: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1168: ldc_w 534
    //   1171: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   1174: pop
    //   1175: goto -24 -> 1151
    //   1178: astore_1
    //   1179: aload_0
    //   1180: invokevirtual 504	java/io/BufferedInputStream:close	()V
    //   1183: aload_1
    //   1184: athrow
    //   1185: aload_0
    //   1186: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   1189: astore_0
    //   1190: aload_1
    //   1191: invokevirtual 535	java/io/BufferedReader:close	()V
    //   1194: aload_3
    //   1195: ifnull +32 -> 1227
    //   1198: aload_3
    //   1199: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   1202: aload_0
    //   1203: areturn
    //   1204: astore_0
    //   1205: goto -440 -> 765
    //   1208: astore_3
    //   1209: aconst_null
    //   1210: astore_0
    //   1211: aload 5
    //   1213: astore_1
    //   1214: goto -637 -> 577
    //   1217: astore 4
    //   1219: aload_3
    //   1220: astore_1
    //   1221: aload 4
    //   1223: astore_3
    //   1224: goto -647 -> 577
    //   1227: aload_0
    //   1228: areturn
    //   1229: aconst_null
    //   1230: astore_0
    //   1231: goto -762 -> 469
    //   1234: aconst_null
    //   1235: astore 4
    //   1237: goto -789 -> 448
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1240	0	paramTeamWorkFileImportInfo	TeamWorkFileImportInfo
    //   0	1240	1	paramString	String
    //   937	180	2	i	int
    //   33	1166	3	localObject1	Object
    //   1208	12	3	localException1	java.lang.Exception
    //   1223	1	3	localObject2	Object
    //   43	427	4	localObject3	Object
    //   568	7	4	localException2	java.lang.Exception
    //   578	367	4	localObject4	Object
    //   954	1	4	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1014	150	4	localObject5	Object
    //   1217	5	4	localException3	java.lang.Exception
    //   1235	1	4	localObject6	Object
    //   4	1208	5	localObject7	Object
    //   1	1012	6	localObject8	Object
    //   56	931	7	localFile	java.io.File
    //   120	381	8	str1	String
    //   133	611	9	localObject9	Object
    //   426	277	10	str2	String
    // Exception table:
    //   from	to	target	type
    //   210	448	568	java/lang/Exception
    //   453	469	568	java/lang/Exception
    //   469	490	568	java/lang/Exception
    //   494	511	568	java/lang/Exception
    //   511	524	568	java/lang/Exception
    //   524	565	568	java/lang/Exception
    //   664	714	568	java/lang/Exception
    //   718	743	568	java/lang/Exception
    //   743	758	568	java/lang/Exception
    //   777	931	568	java/lang/Exception
    //   1034	1093	568	java/lang/Exception
    //   1100	1132	568	java/lang/Exception
    //   1132	1151	568	java/lang/Exception
    //   1151	1157	568	java/lang/Exception
    //   1162	1175	568	java/lang/Exception
    //   1179	1185	568	java/lang/Exception
    //   1185	1190	568	java/lang/Exception
    //   76	115	621	java/lang/Exception
    //   210	448	761	finally
    //   453	469	761	finally
    //   469	490	761	finally
    //   494	511	761	finally
    //   511	524	761	finally
    //   524	565	761	finally
    //   664	714	761	finally
    //   718	743	761	finally
    //   743	758	761	finally
    //   777	931	761	finally
    //   1034	1093	761	finally
    //   1100	1132	761	finally
    //   1132	1151	761	finally
    //   1151	1157	761	finally
    //   1162	1175	761	finally
    //   1179	1185	761	finally
    //   1185	1190	761	finally
    //   1190	1194	761	finally
    //   931	938	954	java/lang/OutOfMemoryError
    //   943	951	954	java/lang/OutOfMemoryError
    //   931	938	1178	finally
    //   943	951	1178	finally
    //   956	1012	1178	finally
    //   126	135	1204	finally
    //   139	145	1204	finally
    //   149	164	1204	finally
    //   168	181	1204	finally
    //   185	190	1204	finally
    //   194	210	1204	finally
    //   580	609	1204	finally
    //   1016	1020	1204	finally
    //   126	135	1208	java/lang/Exception
    //   139	145	1208	java/lang/Exception
    //   149	164	1208	java/lang/Exception
    //   168	181	1208	java/lang/Exception
    //   185	190	1208	java/lang/Exception
    //   194	210	1208	java/lang/Exception
    //   1016	1020	1208	java/lang/Exception
    //   1190	1194	1217	java/lang/Exception
  }
  
  /* Error */
  public static final String dU(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 328	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 329	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: invokevirtual 356	java/io/File:exists	()Z
    //   18: ifeq +116 -> 134
    //   21: ldc_w 690
    //   24: invokestatic 695	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   27: astore 5
    //   29: new 480	java/io/FileInputStream
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 696	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   37: astore 4
    //   39: aload 4
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray byte
    //   47: astore 7
    //   49: aload 4
    //   51: astore_0
    //   52: aload 4
    //   54: aload 7
    //   56: invokevirtual 697	java/io/FileInputStream:read	([B)I
    //   59: istore_1
    //   60: iload_1
    //   61: iconst_m1
    //   62: if_icmpeq +75 -> 137
    //   65: aload 4
    //   67: astore_0
    //   68: aload 5
    //   70: aload 7
    //   72: iconst_0
    //   73: iload_1
    //   74: invokevirtual 700	java/security/MessageDigest:update	([BII)V
    //   77: goto -28 -> 49
    //   80: astore 5
    //   82: aload 4
    //   84: astore_0
    //   85: ldc_w 702
    //   88: iconst_1
    //   89: new 36	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 704
    //   99: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: aload 5
    //   104: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   107: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 6
    //   118: astore 5
    //   120: aload 4
    //   122: ifnull +12 -> 134
    //   125: aload 4
    //   127: invokevirtual 705	java/io/FileInputStream:close	()V
    //   130: aload 6
    //   132: astore 5
    //   134: aload 5
    //   136: areturn
    //   137: aload 4
    //   139: astore_0
    //   140: aload 4
    //   142: invokevirtual 705	java/io/FileInputStream:close	()V
    //   145: aload 4
    //   147: astore_0
    //   148: new 36	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   155: astore 7
    //   157: aload 4
    //   159: astore_0
    //   160: aload 5
    //   162: invokevirtual 708	java/security/MessageDigest:digest	()[B
    //   165: astore 8
    //   167: aload 4
    //   169: astore_0
    //   170: aload 8
    //   172: arraylength
    //   173: istore_2
    //   174: iconst_0
    //   175: istore_1
    //   176: goto +195 -> 371
    //   179: aload 4
    //   181: astore_0
    //   182: aload 7
    //   184: aload 5
    //   186: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: astore_0
    //   193: aload 7
    //   195: iload_3
    //   196: invokestatic 711	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   199: invokevirtual 714	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload_1
    //   207: iconst_1
    //   208: iadd
    //   209: istore_1
    //   210: goto +161 -> 371
    //   213: aload 4
    //   215: astore_0
    //   216: aload 7
    //   218: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: astore 5
    //   223: aload 5
    //   225: astore_0
    //   226: aload_0
    //   227: astore 5
    //   229: aload 4
    //   231: ifnull -97 -> 134
    //   234: aload 4
    //   236: invokevirtual 705	java/io/FileInputStream:close	()V
    //   239: aload_0
    //   240: areturn
    //   241: astore 4
    //   243: ldc_w 702
    //   246: iconst_1
    //   247: new 36	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 716
    //   257: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 4
    //   262: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   265: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: areturn
    //   276: astore_0
    //   277: ldc_w 702
    //   280: iconst_1
    //   281: new 36	java/lang/StringBuilder
    //   284: dup
    //   285: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   288: ldc_w 716
    //   291: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_0
    //   295: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   298: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aconst_null
    //   308: areturn
    //   309: astore 4
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 705	java/io/FileInputStream:close	()V
    //   321: aload 4
    //   323: athrow
    //   324: astore_0
    //   325: ldc_w 702
    //   328: iconst_1
    //   329: new 36	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 716
    //   339: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   346: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   355: goto -34 -> 321
    //   358: astore 4
    //   360: goto -47 -> 313
    //   363: astore 5
    //   365: aconst_null
    //   366: astore 4
    //   368: goto -286 -> 82
    //   371: iload_1
    //   372: iload_2
    //   373: if_icmpge -160 -> 213
    //   376: aload 8
    //   378: iload_1
    //   379: baload
    //   380: sipush 255
    //   383: iand
    //   384: istore_3
    //   385: iload_3
    //   386: bipush 16
    //   388: if_icmpge +11 -> 399
    //   391: ldc_w 718
    //   394: astore 5
    //   396: goto -217 -> 179
    //   399: ldc_w 625
    //   402: astore 5
    //   404: goto -225 -> 179
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramString	String
    //   59	320	1	i	int
    //   173	201	2	j	int
    //   195	194	3	k	int
    //   37	198	4	localFileInputStream	java.io.FileInputStream
    //   241	20	4	localException1	java.lang.Exception
    //   309	13	4	localObject1	Object
    //   358	1	4	localObject2	Object
    //   366	1	4	localObject3	Object
    //   5	64	5	localObject4	Object
    //   80	23	5	localException2	java.lang.Exception
    //   118	110	5	localObject5	Object
    //   363	1	5	localException3	java.lang.Exception
    //   394	9	5	str	String
    //   1	130	6	localObject6	Object
    //   47	170	7	localObject7	Object
    //   165	212	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   42	49	80	java/lang/Exception
    //   52	60	80	java/lang/Exception
    //   68	77	80	java/lang/Exception
    //   140	145	80	java/lang/Exception
    //   148	157	80	java/lang/Exception
    //   160	167	80	java/lang/Exception
    //   170	174	80	java/lang/Exception
    //   182	190	80	java/lang/Exception
    //   193	206	80	java/lang/Exception
    //   216	223	80	java/lang/Exception
    //   234	239	241	java/lang/Exception
    //   125	130	276	java/lang/Exception
    //   21	39	309	finally
    //   317	321	324	java/lang/Exception
    //   42	49	358	finally
    //   52	60	358	finally
    //   68	77	358	finally
    //   85	116	358	finally
    //   140	145	358	finally
    //   148	157	358	finally
    //   160	167	358	finally
    //   170	174	358	finally
    //   182	190	358	finally
    //   193	206	358	finally
    //   216	223	358	finally
    //   21	39	363	java/lang/Exception
  }
  
  private static long hg()
  {
    boolean bool = aqfo.isExistSDCard();
    long l1 = aqfo.getSDCardAvailableSize();
    long l2 = aqfo.getSystemAvailableSize();
    if ((bool) && (l1 != 0L)) {
      return l1 * 1024L;
    }
    return l2 * 1024L;
  }
  
  /* Error */
  public static String i(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aload 5
    //   8: astore 6
    //   10: new 50	anzp
    //   13: dup
    //   14: invokespecial 51	anzp:<init>	()V
    //   17: astore 8
    //   19: aload 5
    //   21: astore 6
    //   23: ldc 53
    //   25: invokestatic 59	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   28: astore 9
    //   30: aload 5
    //   32: astore 6
    //   34: aload 9
    //   36: aconst_null
    //   37: iconst_1
    //   38: anewarray 61	javax/net/ssl/TrustManager
    //   41: dup
    //   42: iconst_0
    //   43: aload 8
    //   45: aastore
    //   46: aconst_null
    //   47: invokevirtual 65	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   50: aload 5
    //   52: astore 6
    //   54: new 67	anzr
    //   57: dup
    //   58: aload 9
    //   60: invokevirtual 71	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   63: invokespecial 74	anzr:<init>	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   66: astore 8
    //   68: aload 5
    //   70: astore 6
    //   72: aload 8
    //   74: invokestatic 79	javax/net/ssl/HttpsURLConnection:setDefaultSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   77: aload 5
    //   79: astore 6
    //   81: new 81	java/net/URL
    //   84: dup
    //   85: aload_1
    //   86: invokespecial 84	java/net/URL:<init>	(Ljava/lang/String;)V
    //   89: invokevirtual 88	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   92: checkcast 76	javax/net/ssl/HttpsURLConnection
    //   95: astore 5
    //   97: aload 5
    //   99: aload 8
    //   101: invokevirtual 91	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   104: aload 5
    //   106: sipush 5000
    //   109: invokevirtual 95	javax/net/ssl/HttpsURLConnection:setConnectTimeout	(I)V
    //   112: aload 5
    //   114: sipush 15000
    //   117: invokevirtual 98	javax/net/ssl/HttpsURLConnection:setReadTimeout	(I)V
    //   120: aload 5
    //   122: iconst_1
    //   123: invokevirtual 105	javax/net/ssl/HttpsURLConnection:setDoInput	(Z)V
    //   126: aload 5
    //   128: iconst_0
    //   129: invokevirtual 108	javax/net/ssl/HttpsURLConnection:setUseCaches	(Z)V
    //   132: aload 5
    //   134: ldc 110
    //   136: invokevirtual 113	javax/net/ssl/HttpsURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   139: aload 5
    //   141: ldc 115
    //   143: ldc 117
    //   145: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 5
    //   150: ldc 123
    //   152: new 36	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 125
    //   158: invokespecial 126	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: ldc 128
    //   163: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: getstatic 134	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   169: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: ldc 128
    //   174: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: getstatic 139	android/os/Build:DEVICE	Ljava/lang/String;
    //   180: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc 128
    //   185: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: getstatic 142	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   191: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: ldc 128
    //   196: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc 144
    //   201: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: ldc 128
    //   206: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: ldc 146
    //   211: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: ldc 148
    //   216: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: aload 5
    //   227: ldc 154
    //   229: ldc_w 539
    //   232: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   235: aload 5
    //   237: ldc 150
    //   239: ldc 152
    //   241: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   244: aload 5
    //   246: ldc_w 541
    //   249: ldc_w 372
    //   252: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: new 160	java/util/HashMap
    //   258: dup
    //   259: invokespecial 161	java/util/HashMap:<init>	()V
    //   262: astore 6
    //   264: aload 6
    //   266: ldc 115
    //   268: ldc 163
    //   270: invokeinterface 169 3 0
    //   275: pop
    //   276: aload 6
    //   278: ldc 171
    //   280: aload_1
    //   281: invokeinterface 169 3 0
    //   286: pop
    //   287: invokestatic 177	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   290: invokevirtual 181	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   293: iconst_2
    //   294: invokevirtual 187	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   297: checkcast 189	mqq/manager/TicketManager
    //   300: astore 8
    //   302: aload 8
    //   304: aload_0
    //   305: invokeinterface 193 2 0
    //   310: astore 7
    //   312: aload_1
    //   313: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   316: ifne +464 -> 780
    //   319: aload 8
    //   321: aload_0
    //   322: aload_2
    //   323: invokeinterface 199 3 0
    //   328: astore_2
    //   329: aload_2
    //   330: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   333: ifeq +143 -> 476
    //   336: ldc 18
    //   338: iconst_1
    //   339: ldc_w 547
    //   342: invokestatic 26	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: invokestatic 206	com/tencent/smtt/sdk/CookieManager:getInstance	()Lcom/tencent/smtt/sdk/CookieManager;
    //   348: astore_0
    //   349: aload_0
    //   350: ifnull +19 -> 369
    //   353: aload 6
    //   355: ldc_w 265
    //   358: aload_0
    //   359: aload_1
    //   360: invokevirtual 211	com/tencent/smtt/sdk/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   363: invokeinterface 169 3 0
    //   368: pop
    //   369: aload 6
    //   371: invokeinterface 215 1 0
    //   376: invokeinterface 221 1 0
    //   381: astore_0
    //   382: aload_0
    //   383: invokeinterface 227 1 0
    //   388: ifeq +210 -> 598
    //   391: aload_0
    //   392: invokeinterface 231 1 0
    //   397: checkcast 233	java/util/Map$Entry
    //   400: astore_1
    //   401: aload 5
    //   403: aload_1
    //   404: invokeinterface 236 1 0
    //   409: checkcast 238	java/lang/String
    //   412: aload_1
    //   413: invokeinterface 241 1 0
    //   418: checkcast 238	java/lang/String
    //   421: invokevirtual 121	javax/net/ssl/HttpsURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: goto -42 -> 382
    //   427: astore_2
    //   428: aload 5
    //   430: astore_1
    //   431: aconst_null
    //   432: astore_0
    //   433: ldc 18
    //   435: iconst_1
    //   436: new 36	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   443: ldc_w 543
    //   446: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_2
    //   450: invokevirtual 246	java/lang/Exception:toString	()Ljava/lang/String;
    //   453: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: aload_0
    //   463: astore_2
    //   464: aload_1
    //   465: ifnull +9 -> 474
    //   468: aload_1
    //   469: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   472: aload_0
    //   473: astore_2
    //   474: aload_2
    //   475: areturn
    //   476: new 36	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 430
    //   486: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_2
    //   490: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: ldc_w 432
    //   496: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_0
    //   500: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc_w 434
    //   506: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 7
    //   511: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: astore_0
    //   515: aload_3
    //   516: invokestatic 16	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   519: ifne +14 -> 533
    //   522: aload_0
    //   523: bipush 59
    //   525: invokevirtual 550	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   528: aload_3
    //   529: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 6
    //   535: ldc_w 265
    //   538: aload_0
    //   539: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokeinterface 169 3 0
    //   547: pop
    //   548: goto -179 -> 369
    //   551: astore_2
    //   552: aconst_null
    //   553: astore_0
    //   554: aload 5
    //   556: astore_1
    //   557: aload_1
    //   558: astore 6
    //   560: ldc 18
    //   562: iconst_1
    //   563: new 36	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 733
    //   573: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_2
    //   577: invokevirtual 418	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 249	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_0
    //   587: astore_2
    //   588: aload_1
    //   589: ifnull -115 -> 474
    //   592: aload_1
    //   593: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   596: aload_0
    //   597: areturn
    //   598: new 447	java/lang/StringBuffer
    //   601: dup
    //   602: invokespecial 448	java/lang/StringBuffer:<init>	()V
    //   605: astore_0
    //   606: aload 5
    //   608: invokevirtual 514	javax/net/ssl/HttpsURLConnection:getResponseCode	()I
    //   611: istore 4
    //   613: iload 4
    //   615: sipush 200
    //   618: if_icmpeq +36 -> 654
    //   621: ldc 18
    //   623: iconst_1
    //   624: new 36	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 555
    //   634: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 4
    //   639: invokevirtual 395	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   642: ldc_w 518
    //   645: invokevirtual 44	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   651: invokestatic 521	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   654: new 523	java/io/BufferedReader
    //   657: dup
    //   658: new 525	java/io/InputStreamReader
    //   661: dup
    //   662: aload 5
    //   664: invokevirtual 281	javax/net/ssl/HttpsURLConnection:getInputStream	()Ljava/io/InputStream;
    //   667: invokespecial 526	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   670: invokespecial 529	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   673: astore_1
    //   674: aload_1
    //   675: invokevirtual 532	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   678: astore_2
    //   679: aload_2
    //   680: ifnull +35 -> 715
    //   683: aload_0
    //   684: aload_2
    //   685: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   688: ldc_w 534
    //   691: invokevirtual 453	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   694: pop
    //   695: goto -21 -> 674
    //   698: astore_0
    //   699: aload 5
    //   701: astore 6
    //   703: aload 6
    //   705: ifnull +8 -> 713
    //   708: aload 6
    //   710: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   713: aload_0
    //   714: athrow
    //   715: aload_0
    //   716: invokevirtual 470	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   719: astore_0
    //   720: aload_1
    //   721: invokevirtual 535	java/io/BufferedReader:close	()V
    //   724: aload 5
    //   726: ifnull +52 -> 778
    //   729: aload 5
    //   731: invokevirtual 263	javax/net/ssl/HttpsURLConnection:disconnect	()V
    //   734: aload_0
    //   735: areturn
    //   736: astore_0
    //   737: goto -34 -> 703
    //   740: astore_0
    //   741: aload_1
    //   742: astore 6
    //   744: goto -41 -> 703
    //   747: astore_2
    //   748: aconst_null
    //   749: astore_0
    //   750: aload 7
    //   752: astore_1
    //   753: goto -196 -> 557
    //   756: astore_2
    //   757: aload 5
    //   759: astore_1
    //   760: goto -203 -> 557
    //   763: astore_2
    //   764: aconst_null
    //   765: astore_1
    //   766: aconst_null
    //   767: astore_0
    //   768: goto -335 -> 433
    //   771: astore_2
    //   772: aload 5
    //   774: astore_1
    //   775: goto -342 -> 433
    //   778: aload_0
    //   779: areturn
    //   780: aconst_null
    //   781: astore_2
    //   782: goto -453 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	785	0	paramString1	String
    //   0	785	1	paramString2	String
    //   0	785	2	paramString3	String
    //   0	785	3	paramString4	String
    //   611	27	4	i	int
    //   1	772	5	localHttpsURLConnection	javax.net.ssl.HttpsURLConnection
    //   8	735	6	localObject1	Object
    //   4	747	7	str	String
    //   17	303	8	localObject2	Object
    //   28	31	9	localSSLContext	javax.net.ssl.SSLContext
    // Exception table:
    //   from	to	target	type
    //   97	329	427	java/lang/Exception
    //   329	349	427	java/lang/Exception
    //   353	369	427	java/lang/Exception
    //   369	382	427	java/lang/Exception
    //   382	424	427	java/lang/Exception
    //   476	533	427	java/lang/Exception
    //   533	548	427	java/lang/Exception
    //   598	613	427	java/lang/Exception
    //   621	654	427	java/lang/Exception
    //   654	674	427	java/lang/Exception
    //   674	679	427	java/lang/Exception
    //   683	695	427	java/lang/Exception
    //   715	720	427	java/lang/Exception
    //   97	329	551	java/lang/OutOfMemoryError
    //   329	349	551	java/lang/OutOfMemoryError
    //   353	369	551	java/lang/OutOfMemoryError
    //   369	382	551	java/lang/OutOfMemoryError
    //   382	424	551	java/lang/OutOfMemoryError
    //   476	533	551	java/lang/OutOfMemoryError
    //   533	548	551	java/lang/OutOfMemoryError
    //   598	613	551	java/lang/OutOfMemoryError
    //   621	654	551	java/lang/OutOfMemoryError
    //   654	674	551	java/lang/OutOfMemoryError
    //   674	679	551	java/lang/OutOfMemoryError
    //   683	695	551	java/lang/OutOfMemoryError
    //   715	720	551	java/lang/OutOfMemoryError
    //   97	329	698	finally
    //   329	349	698	finally
    //   353	369	698	finally
    //   369	382	698	finally
    //   382	424	698	finally
    //   476	533	698	finally
    //   533	548	698	finally
    //   598	613	698	finally
    //   621	654	698	finally
    //   654	674	698	finally
    //   674	679	698	finally
    //   683	695	698	finally
    //   715	720	698	finally
    //   720	724	698	finally
    //   10	19	736	finally
    //   23	30	736	finally
    //   34	50	736	finally
    //   54	68	736	finally
    //   72	77	736	finally
    //   81	97	736	finally
    //   560	586	736	finally
    //   433	462	740	finally
    //   10	19	747	java/lang/OutOfMemoryError
    //   23	30	747	java/lang/OutOfMemoryError
    //   34	50	747	java/lang/OutOfMemoryError
    //   54	68	747	java/lang/OutOfMemoryError
    //   72	77	747	java/lang/OutOfMemoryError
    //   81	97	747	java/lang/OutOfMemoryError
    //   720	724	756	java/lang/OutOfMemoryError
    //   10	19	763	java/lang/Exception
    //   23	30	763	java/lang/Exception
    //   34	50	763	java/lang/Exception
    //   54	68	763	java/lang/Exception
    //   72	77	763	java/lang/Exception
    //   81	97	763	java/lang/Exception
    //   720	724	771	java/lang/Exception
  }
  
  public static String j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return a(paramString1, paramString2, paramString3, paramString4, null, null, false);
  }
  
  public static String m(String paramString1, String paramString2, String paramString3)
  {
    return i(paramString1, paramString2, paramString3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aobk
 * JD-Core Version:    0.7.0.1
 */