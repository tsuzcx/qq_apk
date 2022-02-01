import android.content.Context;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vip.DownloaderFactory.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class aqva
  implements Manager
{
  public static ConcurrentHashMap<Integer, aqvc> C;
  public static ConcurrentHashMap<String, Integer> D;
  private static final int[] ay = WebpSoLoader.getDecoderVersion();
  static ConnectivityManager connectivityManager;
  public static volatile boolean eW = true;
  private static Map<String, Integer> ox = new DownloaderFactory.2();
  
  public aqva(AppRuntime paramAppRuntime)
  {
    D = new ConcurrentHashMap();
    C = new ConcurrentHashMap();
    if (connectivityManager == null) {
      connectivityManager = (ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity");
    }
  }
  
  /* Error */
  public static int a(aquz paramaquz, String paramString, Context paramContext)
  {
    // Byte code:
    //   0: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +11 -> 14
    //   6: ldc 85
    //   8: iconst_2
    //   9: ldc 87
    //   11: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   14: bipush 254
    //   16: istore_3
    //   17: aload_0
    //   18: invokevirtual 96	aquz:a	()Laquy;
    //   21: ifnonnull +14 -> 35
    //   24: aload_0
    //   25: new 98	aqvb
    //   28: dup
    //   29: invokespecial 99	aqvb:<init>	()V
    //   32: invokevirtual 103	aquz:c	(Laquy;)V
    //   35: aload_1
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 106	aquz:a	Laquz$a;
    //   43: getfield 112	aquz$a:iUin	J
    //   46: lconst_0
    //   47: lcmp
    //   48: ifge +14 -> 62
    //   51: aload_0
    //   52: getfield 106	aquz:a	Laquz$a;
    //   55: aload_1
    //   56: invokestatic 118	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   59: putfield 112	aquz$a:iUin	J
    //   62: iload_3
    //   63: istore 4
    //   65: aload_0
    //   66: ifnull +2577 -> 2643
    //   69: iload_3
    //   70: istore 5
    //   72: aload_0
    //   73: invokestatic 124	com/tencent/mobileqq/apollo/utils/ApolloUtil:b	(Laquz;)V
    //   76: iload_3
    //   77: istore 5
    //   79: aload_0
    //   80: invokestatic 126	com/tencent/mobileqq/apollo/utils/ApolloUtil:c	(Laquz;)V
    //   83: aload_0
    //   84: invokevirtual 129	aquz:Ai	()Z
    //   87: ifne +47 -> 134
    //   90: aload_0
    //   91: bipush 147
    //   93: putfield 133	aquz:errCode	I
    //   96: aload_0
    //   97: invokevirtual 136	aquz:cCN	()V
    //   100: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +8198 -> 8301
    //   106: ldc 85
    //   108: iconst_2
    //   109: new 138	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   116: ldc 141
    //   118: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: goto +8170 -> 8301
    //   134: new 154	org/apache/http/params/BasicHttpParams
    //   137: dup
    //   138: invokespecial 155	org/apache/http/params/BasicHttpParams:<init>	()V
    //   141: astore 40
    //   143: aload 40
    //   145: ldc 157
    //   147: sipush 10000
    //   150: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   153: invokeinterface 169 3 0
    //   158: pop
    //   159: aload 40
    //   161: ldc 171
    //   163: aload_0
    //   164: getfield 174	aquz:akN	I
    //   167: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 169 3 0
    //   175: pop
    //   176: aload_0
    //   177: getfield 177	aquz:cWw	Z
    //   180: ifeq +8127 -> 8307
    //   183: ldc 179
    //   185: astore 29
    //   187: aload 40
    //   189: ldc 181
    //   191: aload 29
    //   193: invokeinterface 169 3 0
    //   198: pop
    //   199: aconst_null
    //   200: astore 31
    //   202: aconst_null
    //   203: astore 30
    //   205: sipush 2048
    //   208: istore_3
    //   209: aload_0
    //   210: getfield 185	aquz:GP	Ljava/util/List;
    //   213: ifnull +15 -> 228
    //   216: aload_0
    //   217: getfield 185	aquz:GP	Ljava/util/List;
    //   220: invokeinterface 191 1 0
    //   225: ifgt +47 -> 272
    //   228: aload_0
    //   229: bipush 149
    //   231: putfield 133	aquz:errCode	I
    //   234: aload_0
    //   235: invokevirtual 136	aquz:cCN	()V
    //   238: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +8064 -> 8305
    //   244: ldc 85
    //   246: iconst_2
    //   247: new 138	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   254: ldc 193
    //   256: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: goto +8036 -> 8305
    //   272: aload_0
    //   273: getfield 185	aquz:GP	Ljava/util/List;
    //   276: invokeinterface 191 1 0
    //   281: istore 9
    //   283: iconst_0
    //   284: istore 14
    //   286: getstatic 198	com/tencent/common/app/BaseApplicationImpl:sProcessId	I
    //   289: istore 4
    //   291: iconst_1
    //   292: iload 4
    //   294: if_icmpne +1797 -> 2091
    //   297: iconst_1
    //   298: istore 10
    //   300: iconst_0
    //   301: istore 11
    //   303: aconst_null
    //   304: astore 29
    //   306: iconst_m1
    //   307: istore 8
    //   309: iload 8
    //   311: istore 4
    //   313: iload 11
    //   315: aload_0
    //   316: getfield 185	aquz:GP	Ljava/util/List;
    //   319: invokeinterface 191 1 0
    //   324: if_icmpge +7079 -> 7403
    //   327: iconst_m1
    //   328: istore 4
    //   330: iload 4
    //   332: istore 8
    //   334: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   337: lstore 25
    //   339: iload 4
    //   341: istore 8
    //   343: new 4	java/lang/Object
    //   346: dup
    //   347: invokespecial 45	java/lang/Object:<init>	()V
    //   350: astore 41
    //   352: lconst_0
    //   353: lstore 17
    //   355: iload 4
    //   357: istore 8
    //   359: new 206	java/util/HashMap
    //   362: dup
    //   363: invokespecial 207	java/util/HashMap:<init>	()V
    //   366: astore 37
    //   368: iload 4
    //   370: istore 8
    //   372: aload_0
    //   373: getfield 185	aquz:GP	Ljava/util/List;
    //   376: iload 11
    //   378: invokeinterface 211 2 0
    //   383: checkcast 213	java/lang/String
    //   386: astore 33
    //   388: iload 4
    //   390: istore 8
    //   392: aload_0
    //   393: aload 33
    //   395: putfield 217	aquz:currUrl	Ljava/lang/String;
    //   398: iload 4
    //   400: istore 8
    //   402: aload_0
    //   403: getfield 220	aquz:bju	I
    //   406: iconst_3
    //   407: if_icmpne +49 -> 456
    //   410: iload 10
    //   412: ifeq +44 -> 456
    //   415: iload 4
    //   417: istore 8
    //   419: bipush 30
    //   421: aconst_null
    //   422: aload_0
    //   423: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   426: invokestatic 225	abwh:C	(ILjava/lang/String;Ljava/lang/String;)V
    //   429: iload 4
    //   431: istore 8
    //   433: bipush 30
    //   435: aload_0
    //   436: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   439: sipush 300
    //   442: invokestatic 229	abwh:v	(ILjava/lang/String;I)V
    //   445: iload 4
    //   447: istore 8
    //   449: aload_0
    //   450: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   453: invokestatic 233	com/tencent/mobileqq/apollo/utils/ApolloUtil:Dc	(Ljava/lang/String;)V
    //   456: iload 4
    //   458: istore 8
    //   460: aload_0
    //   461: getfield 236	aquz:ov	Ljava/util/Map;
    //   464: aload 33
    //   466: invokeinterface 241 2 0
    //   471: checkcast 243	java/io/File
    //   474: astore 38
    //   476: ldc 245
    //   478: astore 34
    //   480: aload 38
    //   482: ifnull +6819 -> 7301
    //   485: iload 4
    //   487: istore 8
    //   489: aload 38
    //   491: invokevirtual 249	java/io/File:getParentFile	()Ljava/io/File;
    //   494: astore 42
    //   496: iload 4
    //   498: istore 8
    //   500: aload_0
    //   501: getfield 252	aquz:cWq	Z
    //   504: ifeq +1593 -> 2097
    //   507: iload 4
    //   509: istore 8
    //   511: new 243	java/io/File
    //   514: dup
    //   515: aload 42
    //   517: new 138	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   524: aload 38
    //   526: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   529: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: ldc_w 257
    //   535: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokestatic 260	java/lang/System:nanoTime	()J
    //   541: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   544: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   547: invokespecial 266	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   550: astore 36
    //   552: aload 33
    //   554: astore 32
    //   556: iload 4
    //   558: istore 8
    //   560: aload_0
    //   561: getfield 269	aquz:cxW	Ljava/lang/String;
    //   564: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   567: ifne +18 -> 585
    //   570: iload 4
    //   572: istore 8
    //   574: aload_0
    //   575: getfield 269	aquz:cxW	Ljava/lang/String;
    //   578: aload 33
    //   580: invokestatic 281	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   583: astore 32
    //   585: iload 4
    //   587: istore 8
    //   589: new 283	afka
    //   592: dup
    //   593: aload 32
    //   595: aconst_null
    //   596: iconst_0
    //   597: invokespecial 286	afka:<init>	(Ljava/lang/String;Ljava/io/File;I)V
    //   600: astore 39
    //   602: aload 32
    //   604: astore 34
    //   606: iconst_0
    //   607: istore 7
    //   609: iconst_m1
    //   610: istore 12
    //   612: iconst_m1
    //   613: istore 6
    //   615: lconst_0
    //   616: lstore 19
    //   618: aload 29
    //   620: astore 33
    //   622: aload 30
    //   624: astore 32
    //   626: aload 34
    //   628: astore 29
    //   630: iload 6
    //   632: istore 4
    //   634: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   637: lstore 27
    //   639: iload 6
    //   641: istore 4
    //   643: new 138	java/lang/StringBuilder
    //   646: dup
    //   647: ldc_w 288
    //   650: invokespecial 290	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   653: ldc_w 292
    //   656: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_0
    //   660: getfield 177	aquz:cWw	Z
    //   663: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   666: ldc_w 297
    //   669: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: aload_0
    //   673: getfield 300	aquz:cWy	Z
    //   676: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   679: ldc_w 302
    //   682: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_0
    //   686: getfield 305	aquz:retryCount	I
    //   689: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   692: astore 43
    //   694: iconst_0
    //   695: istore 8
    //   697: iconst_0
    //   698: istore 5
    //   700: iconst_0
    //   701: istore 13
    //   703: aload 29
    //   705: astore 35
    //   707: aload 29
    //   709: astore 34
    //   711: iload 5
    //   713: istore 4
    //   715: aload 39
    //   717: invokevirtual 311	afka:cZT	()V
    //   720: iconst_1
    //   721: istore 14
    //   723: aload 42
    //   725: ifnull +23 -> 748
    //   728: aload 29
    //   730: astore 35
    //   732: aload 29
    //   734: astore 34
    //   736: iload 5
    //   738: istore 4
    //   740: aload 42
    //   742: invokevirtual 314	java/io/File:exists	()Z
    //   745: ifeq +27 -> 772
    //   748: aload 29
    //   750: astore 35
    //   752: aload 29
    //   754: astore 34
    //   756: iload 5
    //   758: istore 4
    //   760: aload 42
    //   762: invokevirtual 317	java/io/File:isDirectory	()Z
    //   765: istore 14
    //   767: iload 14
    //   769: ifne +1370 -> 2139
    //   772: iload 14
    //   774: ifne +21 -> 795
    //   777: aload 29
    //   779: astore 35
    //   781: aload 29
    //   783: astore 34
    //   785: iload 5
    //   787: istore 4
    //   789: aload 42
    //   791: invokevirtual 320	java/io/File:delete	()Z
    //   794: pop
    //   795: aload 29
    //   797: astore 35
    //   799: aload 29
    //   801: astore 34
    //   803: iload 5
    //   805: istore 4
    //   807: aload 42
    //   809: invokevirtual 323	java/io/File:mkdirs	()Z
    //   812: ifne +1327 -> 2139
    //   815: iconst_1
    //   816: istore 4
    //   818: iconst_1
    //   819: istore 13
    //   821: bipush 153
    //   823: istore 8
    //   825: aload 29
    //   827: astore 35
    //   829: aload 29
    //   831: astore 34
    //   833: aload_0
    //   834: bipush 153
    //   836: putfield 133	aquz:errCode	I
    //   839: iload 13
    //   841: istore 5
    //   843: iload 8
    //   845: istore 4
    //   847: iload 8
    //   849: istore 6
    //   851: aload 43
    //   853: ldc_w 325
    //   856: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: aload 42
    //   861: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   864: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: ldc_w 330
    //   870: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: invokestatic 335	aqft:cC	()Z
    //   876: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   879: ldc_w 337
    //   882: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   885: invokestatic 340	aqft:hE	()J
    //   888: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   891: pop
    //   892: iload 13
    //   894: istore 5
    //   896: iload 8
    //   898: istore 4
    //   900: iload 8
    //   902: istore 6
    //   904: new 75	java/lang/Exception
    //   907: dup
    //   908: ldc_w 342
    //   911: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   914: athrow
    //   915: astore 34
    //   917: iload_3
    //   918: istore 6
    //   920: iconst_0
    //   921: istore 14
    //   923: iload 5
    //   925: istore 8
    //   927: iload 4
    //   929: istore_3
    //   930: aload 32
    //   932: astore 30
    //   934: aload 33
    //   936: astore 32
    //   938: iload 6
    //   940: istore 5
    //   942: iload 8
    //   944: istore 4
    //   946: iload 7
    //   948: istore 6
    //   950: aload 34
    //   952: astore 33
    //   954: iconst_0
    //   955: istore 7
    //   957: aload 33
    //   959: instanceof 345
    //   962: ifne +7353 -> 8315
    //   965: aload 33
    //   967: instanceof 347
    //   970: ifne +7345 -> 8315
    //   973: aload 33
    //   975: instanceof 349
    //   978: ifeq +6 -> 984
    //   981: goto +7334 -> 8315
    //   984: aload 33
    //   986: instanceof 73
    //   989: ifeq +6007 -> 6996
    //   992: aload_0
    //   993: bipush 145
    //   995: putfield 133	aquz:errCode	I
    //   998: aload_0
    //   999: aload 33
    //   1001: invokevirtual 352	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1004: putfield 355	aquz:errMsg	Ljava/lang/String;
    //   1007: iload 14
    //   1009: ifne +18 -> 1027
    //   1012: iload 7
    //   1014: ifeq +13 -> 1027
    //   1017: iload 6
    //   1019: ifeq +6052 -> 7071
    //   1022: aload_0
    //   1023: iconst_1
    //   1024: putfield 358	aquz:bJO	Z
    //   1027: aload 43
    //   1029: ldc_w 360
    //   1032: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokestatic 365	aqhq:aCJ	()Z
    //   1038: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1041: ldc_w 367
    //   1044: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: invokestatic 371	aqhq:bB	()F
    //   1050: ldc_w 372
    //   1053: fdiv
    //   1054: invokevirtual 375	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   1057: pop
    //   1058: aload 43
    //   1060: ldc_w 377
    //   1063: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1066: aload 33
    //   1068: invokevirtual 352	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   1071: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: pop
    //   1075: iload_3
    //   1076: istore 8
    //   1078: ldc 85
    //   1080: iconst_1
    //   1081: new 138	java/lang/StringBuilder
    //   1084: dup
    //   1085: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1088: aload 43
    //   1090: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1093: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: ldc_w 379
    //   1099: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1102: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1105: lload 27
    //   1107: lsub
    //   1108: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1111: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1114: invokestatic 382	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1117: iload_3
    //   1118: istore 8
    //   1120: aload_0
    //   1121: getfield 220	aquz:bju	I
    //   1124: iconst_3
    //   1125: if_icmpne +63 -> 1188
    //   1128: iload 10
    //   1130: ifeq +58 -> 1188
    //   1133: iload_3
    //   1134: istore 8
    //   1136: bipush 30
    //   1138: aload_0
    //   1139: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   1142: sipush 300
    //   1145: iconst_1
    //   1146: anewarray 4	java/lang/Object
    //   1149: dup
    //   1150: iconst_0
    //   1151: new 138	java/lang/StringBuilder
    //   1154: dup
    //   1155: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1158: aload 43
    //   1160: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1163: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1166: ldc_w 379
    //   1169: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1172: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1175: lload 27
    //   1177: lsub
    //   1178: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1181: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: aastore
    //   1185: invokestatic 385	abwh:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   1188: iload_3
    //   1189: ifeq +112 -> 1301
    //   1192: iload_3
    //   1193: istore 8
    //   1195: aload_0
    //   1196: invokevirtual 388	aquz:isCancel	()Z
    //   1199: ifne +102 -> 1301
    //   1202: iload_3
    //   1203: istore 8
    //   1205: aload_0
    //   1206: getfield 391	aquz:cWo	Z
    //   1209: ifeq +92 -> 1301
    //   1212: iload_3
    //   1213: istore 8
    //   1215: aload 39
    //   1217: getfield 394	afka:bYr	Z
    //   1220: ifeq +5893 -> 7113
    //   1223: iload_3
    //   1224: istore 8
    //   1226: aload 39
    //   1228: getfield 397	afka:ip	Ljava/lang/String;
    //   1231: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1234: ifne +5845 -> 7079
    //   1237: iload_3
    //   1238: istore 8
    //   1240: invokestatic 402	aopd:a	()Laopd;
    //   1243: aload 39
    //   1245: getfield 405	afka:host	Ljava/lang/String;
    //   1248: aload 39
    //   1250: getfield 397	afka:ip	Ljava/lang/String;
    //   1253: getstatic 42	aqva:ox	Ljava/util/Map;
    //   1256: aload 39
    //   1258: getfield 405	afka:host	Ljava/lang/String;
    //   1261: invokeinterface 241 2 0
    //   1266: checkcast 159	java/lang/Integer
    //   1269: invokevirtual 408	java/lang/Integer:intValue	()I
    //   1272: invokevirtual 412	aopd:X	(Ljava/lang/String;Ljava/lang/String;I)V
    //   1275: iload_3
    //   1276: istore 8
    //   1278: aload 39
    //   1280: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   1283: aload 38
    //   1285: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   1288: iconst_m1
    //   1289: aload_2
    //   1290: invokestatic 418	aqva:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   1293: iload_3
    //   1294: istore 8
    //   1296: aload_0
    //   1297: iconst_0
    //   1298: putfield 421	aquz:cWn	Z
    //   1301: iload_3
    //   1302: istore 8
    //   1304: new 138	java/lang/StringBuilder
    //   1307: dup
    //   1308: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1311: astore 34
    //   1313: iload_3
    //   1314: istore 8
    //   1316: aload 39
    //   1318: getfield 424	afka:isHttps	Z
    //   1321: ifeq +7248 -> 8569
    //   1324: ldc_w 426
    //   1327: astore 33
    //   1329: iload_3
    //   1330: istore 8
    //   1332: aload 34
    //   1334: aload 33
    //   1336: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1339: astore 34
    //   1341: iload_3
    //   1342: istore 8
    //   1344: aload 39
    //   1346: getfield 394	afka:bYr	Z
    //   1349: ifeq +7228 -> 8577
    //   1352: ldc_w 428
    //   1355: astore 33
    //   1357: iload_3
    //   1358: istore 8
    //   1360: aload 34
    //   1362: aload 33
    //   1364: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1370: astore 33
    //   1372: iload 12
    //   1374: iconst_1
    //   1375: iadd
    //   1376: istore 7
    //   1378: aload 32
    //   1380: ifnull +13 -> 1393
    //   1383: iload_3
    //   1384: istore 8
    //   1386: aload 32
    //   1388: invokeinterface 433 1 0
    //   1393: aload 31
    //   1395: ifnull +11 -> 1406
    //   1398: iload_3
    //   1399: istore 8
    //   1401: aload 31
    //   1403: invokevirtual 438	java/io/InputStream:close	()V
    //   1406: aload 30
    //   1408: ifnull +11 -> 1419
    //   1411: iload_3
    //   1412: istore 8
    //   1414: aload 30
    //   1416: invokevirtual 441	java/io/BufferedOutputStream:close	()V
    //   1419: iload 7
    //   1421: istore 8
    //   1423: lload 19
    //   1425: lstore 21
    //   1427: iload 4
    //   1429: istore 7
    //   1431: iload 5
    //   1433: istore 4
    //   1435: lload 17
    //   1437: lstore 19
    //   1439: lload 21
    //   1441: lstore 17
    //   1443: iload 8
    //   1445: istore 5
    //   1447: iload_3
    //   1448: ifeq +34 -> 1482
    //   1451: iload 7
    //   1453: ifne +29 -> 1482
    //   1456: iload_3
    //   1457: istore 8
    //   1459: iload 5
    //   1461: aload_0
    //   1462: getfield 305	aquz:retryCount	I
    //   1465: if_icmpge +17 -> 1482
    //   1468: iload_3
    //   1469: istore 8
    //   1471: aload_0
    //   1472: invokevirtual 388	aquz:isCancel	()Z
    //   1475: istore 15
    //   1477: iload 15
    //   1479: ifeq +6781 -> 8260
    //   1482: aload 30
    //   1484: astore 34
    //   1486: lload 19
    //   1488: lstore 21
    //   1490: aload 32
    //   1492: astore 30
    //   1494: aload 31
    //   1496: astore 35
    //   1498: lload 17
    //   1500: lstore 19
    //   1502: lload 21
    //   1504: lstore 17
    //   1506: aload 29
    //   1508: astore 32
    //   1510: iload 5
    //   1512: istore 6
    //   1514: aload 30
    //   1516: astore 31
    //   1518: aload 35
    //   1520: astore 30
    //   1522: aload 34
    //   1524: astore 29
    //   1526: iload 4
    //   1528: istore 5
    //   1530: iload_3
    //   1531: istore 4
    //   1533: aload_0
    //   1534: invokevirtual 444	aquz:efQ	()V
    //   1537: aload 37
    //   1539: ifnonnull +6688 -> 8227
    //   1542: iload_3
    //   1543: istore 4
    //   1545: new 206	java/util/HashMap
    //   1548: dup
    //   1549: invokespecial 207	java/util/HashMap:<init>	()V
    //   1552: astore 34
    //   1554: iload_3
    //   1555: istore 4
    //   1557: aload 34
    //   1559: ldc_w 446
    //   1562: aload 32
    //   1564: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1567: pop
    //   1568: iload_3
    //   1569: istore 4
    //   1571: aload 34
    //   1573: ldc_w 452
    //   1576: aload_0
    //   1577: getfield 133	aquz:errCode	I
    //   1580: invokestatic 455	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1583: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1586: pop
    //   1587: iload_3
    //   1588: istore 4
    //   1590: aload 34
    //   1592: ldc_w 457
    //   1595: aload_0
    //   1596: getfield 460	aquz:httpCode	I
    //   1599: invokestatic 455	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1602: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1605: pop
    //   1606: iload_3
    //   1607: istore 4
    //   1609: aload 34
    //   1611: ldc_w 462
    //   1614: iload 6
    //   1616: invokestatic 455	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1619: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1622: pop
    //   1623: iload_3
    //   1624: istore 4
    //   1626: aload 34
    //   1628: ldc_w 464
    //   1631: lload 17
    //   1633: invokestatic 467	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1636: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1639: pop
    //   1640: iload_3
    //   1641: istore 4
    //   1643: aload 34
    //   1645: ldc_w 469
    //   1648: aload_0
    //   1649: getfield 185	aquz:GP	Ljava/util/List;
    //   1652: invokeinterface 191 1 0
    //   1657: invokestatic 455	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1660: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1663: pop
    //   1664: iload_3
    //   1665: istore 4
    //   1667: aload 34
    //   1669: ldc_w 471
    //   1672: aload_0
    //   1673: getfield 474	aquz:cxX	Ljava/lang/String;
    //   1676: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1679: pop
    //   1680: iload_3
    //   1681: istore 4
    //   1683: aload 34
    //   1685: ldc_w 476
    //   1688: iload 14
    //   1690: invokestatic 481	java/lang/Boolean:toString	(Z)Ljava/lang/String;
    //   1693: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1696: pop
    //   1697: iload_3
    //   1698: istore 4
    //   1700: aload 34
    //   1702: ldc_w 483
    //   1705: aload 33
    //   1707: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1710: pop
    //   1711: ldc 245
    //   1713: astore 35
    //   1715: iload_3
    //   1716: istore 4
    //   1718: aload_0
    //   1719: getfield 355	aquz:errMsg	Ljava/lang/String;
    //   1722: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1725: ifne +6596 -> 8321
    //   1728: iload_3
    //   1729: istore 4
    //   1731: aload 34
    //   1733: ldc_w 485
    //   1736: aload_0
    //   1737: getfield 355	aquz:errMsg	Ljava/lang/String;
    //   1740: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1743: pop
    //   1744: iload_3
    //   1745: istore 4
    //   1747: aload_0
    //   1748: getfield 355	aquz:errMsg	Ljava/lang/String;
    //   1751: astore 35
    //   1753: goto +6568 -> 8321
    //   1756: iload_3
    //   1757: istore 4
    //   1759: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   1762: lstore 21
    //   1764: aload_2
    //   1765: ifnull +281 -> 2046
    //   1768: iload_3
    //   1769: istore 4
    //   1771: aload_1
    //   1772: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1775: istore 16
    //   1777: iload 16
    //   1779: ifne +267 -> 2046
    //   1782: ldc_w 487
    //   1785: aload 32
    //   1787: new 138	java/lang/StringBuilder
    //   1790: dup
    //   1791: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1794: aload_0
    //   1795: getfield 133	aquz:errCode	I
    //   1798: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1801: ldc 245
    //   1803: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1806: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1809: new 138	java/lang/StringBuilder
    //   1812: dup
    //   1813: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1816: lload 17
    //   1818: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1821: ldc 245
    //   1823: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1829: aload_0
    //   1830: getfield 474	aquz:cxX	Ljava/lang/String;
    //   1833: new 138	java/lang/StringBuilder
    //   1836: dup
    //   1837: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   1840: iload 14
    //   1842: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1845: ldc 245
    //   1847: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: aload 35
    //   1855: aload 33
    //   1857: ldc 245
    //   1859: ldc_w 489
    //   1862: invokestatic 494	aqrm:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1865: aload_0
    //   1866: getfield 220	aquz:bju	I
    //   1869: iconst_3
    //   1870: if_icmpne +79 -> 1949
    //   1873: iload 10
    //   1875: ifeq +74 -> 1949
    //   1878: bipush 30
    //   1880: aload_0
    //   1881: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   1884: sipush 300
    //   1887: aload_0
    //   1888: getfield 133	aquz:errCode	I
    //   1891: invokestatic 498	com/tencent/mobileqq/apollo/utils/ApolloUtil:gn	(I)I
    //   1894: iconst_4
    //   1895: anewarray 4	java/lang/Object
    //   1898: dup
    //   1899: iconst_0
    //   1900: ldc_w 500
    //   1903: aastore
    //   1904: dup
    //   1905: iconst_1
    //   1906: aload_0
    //   1907: getfield 133	aquz:errCode	I
    //   1910: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1913: aastore
    //   1914: dup
    //   1915: iconst_2
    //   1916: ldc_w 502
    //   1919: aastore
    //   1920: dup
    //   1921: iconst_3
    //   1922: aload_0
    //   1923: getfield 460	aquz:httpCode	I
    //   1926: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1929: aastore
    //   1930: invokestatic 505	abwh:a	(ILjava/lang/String;II[Ljava/lang/Object;)V
    //   1933: aload_0
    //   1934: getfield 133	aquz:errCode	I
    //   1937: ifne +12 -> 1949
    //   1940: bipush 30
    //   1942: aload_0
    //   1943: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   1946: invokestatic 509	abwh:bV	(ILjava/lang/String;)V
    //   1949: ldc_w 511
    //   1952: astore 33
    //   1954: aload 33
    //   1956: astore 32
    //   1958: aload_0
    //   1959: getfield 474	aquz:cxX	Ljava/lang/String;
    //   1962: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1965: ifne +57 -> 2022
    //   1968: aload 33
    //   1970: astore 32
    //   1972: aload_0
    //   1973: getfield 474	aquz:cxX	Ljava/lang/String;
    //   1976: ldc_w 513
    //   1979: invokevirtual 516	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1982: ifeq +40 -> 2022
    //   1985: ldc_w 518
    //   1988: astore 32
    //   1990: aload 34
    //   1992: ldc_w 520
    //   1995: aload_0
    //   1996: getfield 523	aquz:cWA	Z
    //   1999: invokestatic 525	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2002: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2005: pop
    //   2006: aload 34
    //   2008: ldc_w 527
    //   2011: aload_0
    //   2012: getfield 530	aquz:cWz	Z
    //   2015: invokestatic 525	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   2018: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2021: pop
    //   2022: aload_2
    //   2023: invokestatic 535	anpc:a	(Landroid/content/Context;)Lanpc;
    //   2026: aload_1
    //   2027: aload 32
    //   2029: iload 15
    //   2031: lload 21
    //   2033: lload 25
    //   2035: lsub
    //   2036: lload 19
    //   2038: aload 34
    //   2040: ldc 245
    //   2042: iconst_0
    //   2043: invokevirtual 539	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2046: iload_3
    //   2047: ifne +5338 -> 7385
    //   2050: iload 9
    //   2052: iconst_1
    //   2053: isub
    //   2054: istore 4
    //   2056: iload 11
    //   2058: iconst_1
    //   2059: iadd
    //   2060: istore 11
    //   2062: aload 31
    //   2064: astore 32
    //   2066: iload_3
    //   2067: istore 8
    //   2069: aload 30
    //   2071: astore 31
    //   2073: iload 5
    //   2075: istore_3
    //   2076: aload 29
    //   2078: astore 30
    //   2080: aload 32
    //   2082: astore 29
    //   2084: iload 4
    //   2086: istore 9
    //   2088: goto -1779 -> 309
    //   2091: iconst_0
    //   2092: istore 10
    //   2094: goto -1794 -> 300
    //   2097: iload 4
    //   2099: istore 8
    //   2101: new 243	java/io/File
    //   2104: dup
    //   2105: aload 42
    //   2107: new 138	java/lang/StringBuilder
    //   2110: dup
    //   2111: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2114: aload 38
    //   2116: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   2119: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: ldc_w 541
    //   2125: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2128: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2131: invokespecial 266	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   2134: astore 36
    //   2136: goto -1584 -> 552
    //   2139: aload 29
    //   2141: astore 35
    //   2143: aload 29
    //   2145: astore 34
    //   2147: iload 5
    //   2149: istore 4
    //   2151: getstatic 54	aqva:connectivityManager	Landroid/net/ConnectivityManager;
    //   2154: ifnonnull +29 -> 2183
    //   2157: aload 29
    //   2159: astore 35
    //   2161: aload 29
    //   2163: astore 34
    //   2165: iload 5
    //   2167: istore 4
    //   2169: invokestatic 60	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2172: ldc 62
    //   2174: invokevirtual 66	com/tencent/qphone/base/util/BaseApplication:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   2177: checkcast 68	android/net/ConnectivityManager
    //   2180: putstatic 54	aqva:connectivityManager	Landroid/net/ConnectivityManager;
    //   2183: aload 29
    //   2185: astore 35
    //   2187: aload 29
    //   2189: astore 34
    //   2191: iload 5
    //   2193: istore 4
    //   2195: invokestatic 547	com/tencent/mobileqq/msf/sdk/AppNetConnInfo:getRecentNetworkInfo	()Landroid/net/NetworkInfo;
    //   2198: astore 44
    //   2200: aload 44
    //   2202: ifnonnull +480 -> 2682
    //   2205: bipush 152
    //   2207: istore 8
    //   2209: aload 29
    //   2211: astore 35
    //   2213: aload 29
    //   2215: astore 34
    //   2217: iload 5
    //   2219: istore 4
    //   2221: aload_0
    //   2222: bipush 152
    //   2224: putfield 133	aquz:errCode	I
    //   2227: iload 13
    //   2229: istore 5
    //   2231: iload 8
    //   2233: istore 4
    //   2235: iload 8
    //   2237: istore 6
    //   2239: aload 43
    //   2241: ldc_w 549
    //   2244: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2247: pop
    //   2248: iload 13
    //   2250: istore 5
    //   2252: iload 8
    //   2254: istore 4
    //   2256: iload 8
    //   2258: istore 6
    //   2260: new 75	java/lang/Exception
    //   2263: dup
    //   2264: ldc_w 551
    //   2267: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   2270: athrow
    //   2271: astore_1
    //   2272: iload 6
    //   2274: istore 4
    //   2276: ldc 85
    //   2278: iconst_1
    //   2279: new 138	java/lang/StringBuilder
    //   2282: dup
    //   2283: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2286: aload 43
    //   2288: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2291: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2294: ldc_w 379
    //   2297: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2300: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   2303: lload 27
    //   2305: lsub
    //   2306: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2309: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2312: invokestatic 382	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2315: iload 6
    //   2317: istore 4
    //   2319: aload_0
    //   2320: getfield 220	aquz:bju	I
    //   2323: iconst_3
    //   2324: if_icmpne +64 -> 2388
    //   2327: iload 10
    //   2329: ifeq +59 -> 2388
    //   2332: iload 6
    //   2334: istore 4
    //   2336: bipush 30
    //   2338: aload_0
    //   2339: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   2342: sipush 300
    //   2345: iconst_1
    //   2346: anewarray 4	java/lang/Object
    //   2349: dup
    //   2350: iconst_0
    //   2351: new 138	java/lang/StringBuilder
    //   2354: dup
    //   2355: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2358: aload 43
    //   2360: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2363: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2366: ldc_w 379
    //   2369: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2372: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   2375: lload 27
    //   2377: lsub
    //   2378: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2381: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2384: aastore
    //   2385: invokestatic 385	abwh:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   2388: iload 6
    //   2390: ifeq +119 -> 2509
    //   2393: iload 6
    //   2395: istore 4
    //   2397: aload_0
    //   2398: invokevirtual 388	aquz:isCancel	()Z
    //   2401: ifne +108 -> 2509
    //   2404: iload 6
    //   2406: istore 4
    //   2408: aload_0
    //   2409: getfield 391	aquz:cWo	Z
    //   2412: ifeq +97 -> 2509
    //   2415: iload 6
    //   2417: istore 4
    //   2419: aload 39
    //   2421: getfield 394	afka:bYr	Z
    //   2424: ifeq +4817 -> 7241
    //   2427: iload 6
    //   2429: istore 4
    //   2431: aload 39
    //   2433: getfield 397	afka:ip	Ljava/lang/String;
    //   2436: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   2439: ifne +4766 -> 7205
    //   2442: iload 6
    //   2444: istore 4
    //   2446: invokestatic 402	aopd:a	()Laopd;
    //   2449: aload 39
    //   2451: getfield 405	afka:host	Ljava/lang/String;
    //   2454: aload 39
    //   2456: getfield 397	afka:ip	Ljava/lang/String;
    //   2459: getstatic 42	aqva:ox	Ljava/util/Map;
    //   2462: aload 39
    //   2464: getfield 405	afka:host	Ljava/lang/String;
    //   2467: invokeinterface 241 2 0
    //   2472: checkcast 159	java/lang/Integer
    //   2475: invokevirtual 408	java/lang/Integer:intValue	()I
    //   2478: invokevirtual 412	aopd:X	(Ljava/lang/String;Ljava/lang/String;I)V
    //   2481: iload 6
    //   2483: istore 4
    //   2485: aload 39
    //   2487: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   2490: aload 38
    //   2492: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   2495: iconst_m1
    //   2496: aload_2
    //   2497: invokestatic 418	aqva:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   2500: iload 6
    //   2502: istore 4
    //   2504: aload_0
    //   2505: iconst_0
    //   2506: putfield 421	aquz:cWn	Z
    //   2509: iload 6
    //   2511: istore 4
    //   2513: new 138	java/lang/StringBuilder
    //   2516: dup
    //   2517: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2520: astore_2
    //   2521: iload 6
    //   2523: istore 4
    //   2525: aload 39
    //   2527: getfield 424	afka:isHttps	Z
    //   2530: ifeq +6055 -> 8585
    //   2533: ldc_w 426
    //   2536: astore_0
    //   2537: iload 6
    //   2539: istore 4
    //   2541: aload_2
    //   2542: aload_0
    //   2543: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2546: astore_2
    //   2547: iload 6
    //   2549: istore 4
    //   2551: aload 39
    //   2553: getfield 394	afka:bYr	Z
    //   2556: ifeq +6036 -> 8592
    //   2559: ldc_w 428
    //   2562: astore_0
    //   2563: iload 6
    //   2565: istore 4
    //   2567: aload_2
    //   2568: aload_0
    //   2569: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2572: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2575: pop
    //   2576: aload 33
    //   2578: ifnull +14 -> 2592
    //   2581: iload 6
    //   2583: istore 4
    //   2585: aload 33
    //   2587: invokeinterface 433 1 0
    //   2592: aload 31
    //   2594: ifnull +12 -> 2606
    //   2597: iload 6
    //   2599: istore 4
    //   2601: aload 31
    //   2603: invokevirtual 438	java/io/InputStream:close	()V
    //   2606: aload 32
    //   2608: ifnull +12 -> 2620
    //   2611: iload 6
    //   2613: istore 4
    //   2615: aload 32
    //   2617: invokevirtual 441	java/io/BufferedOutputStream:close	()V
    //   2620: iload 6
    //   2622: istore 4
    //   2624: aload_1
    //   2625: athrow
    //   2626: astore_0
    //   2627: iload 4
    //   2629: istore_3
    //   2630: ldc 85
    //   2632: iconst_1
    //   2633: aload_0
    //   2634: invokevirtual 352	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   2637: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   2640: iload_3
    //   2641: istore 4
    //   2643: iload 4
    //   2645: istore_3
    //   2646: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2649: ifeq +5654 -> 8303
    //   2652: ldc 85
    //   2654: iconst_2
    //   2655: new 138	java/lang/StringBuilder
    //   2658: dup
    //   2659: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2662: ldc_w 556
    //   2665: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2668: iload 4
    //   2670: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2673: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2676: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2679: iload 4
    //   2681: ireturn
    //   2682: aload 29
    //   2684: astore 30
    //   2686: aload 29
    //   2688: astore 35
    //   2690: aload 29
    //   2692: astore 34
    //   2694: iload 5
    //   2696: istore 4
    //   2698: aload_0
    //   2699: getfield 530	aquz:cWz	Z
    //   2702: ifeq +122 -> 2824
    //   2705: aload 29
    //   2707: astore 30
    //   2709: aload 29
    //   2711: astore 35
    //   2713: aload 29
    //   2715: astore 34
    //   2717: iload 5
    //   2719: istore 4
    //   2721: aload 29
    //   2723: ldc_w 558
    //   2726: invokevirtual 516	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2729: ifne +95 -> 2824
    //   2732: aload 29
    //   2734: astore 35
    //   2736: aload 29
    //   2738: astore 34
    //   2740: iload 5
    //   2742: istore 4
    //   2744: new 560	java/util/Random
    //   2747: dup
    //   2748: aload_1
    //   2749: invokestatic 565	alkt:stringToLong	(Ljava/lang/String;)J
    //   2752: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   2755: lor
    //   2756: invokespecial 568	java/util/Random:<init>	(J)V
    //   2759: invokevirtual 571	java/util/Random:nextInt	()I
    //   2762: istore 13
    //   2764: aload 29
    //   2766: astore 35
    //   2768: aload 29
    //   2770: astore 34
    //   2772: iload 5
    //   2774: istore 4
    //   2776: aload 29
    //   2778: invokestatic 575	aqva:rH	(Ljava/lang/String;)Z
    //   2781: ifeq +383 -> 3164
    //   2784: aload 29
    //   2786: astore 35
    //   2788: aload 29
    //   2790: astore 34
    //   2792: iload 5
    //   2794: istore 4
    //   2796: new 138	java/lang/StringBuilder
    //   2799: dup
    //   2800: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2803: aload 29
    //   2805: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2808: ldc_w 577
    //   2811: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2814: iload 13
    //   2816: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2819: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2822: astore 30
    //   2824: aload 30
    //   2826: astore 35
    //   2828: aload 30
    //   2830: astore 34
    //   2832: iload 5
    //   2834: istore 4
    //   2836: aload 30
    //   2838: invokestatic 581	com/tencent/mobileqq/apollo/utils/ApolloUtil:iV	(Ljava/lang/String;)Ljava/lang/String;
    //   2841: astore 29
    //   2843: aload 29
    //   2845: astore 35
    //   2847: aload 29
    //   2849: astore 34
    //   2851: iload 5
    //   2853: istore 4
    //   2855: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2858: ifeq +42 -> 2900
    //   2861: aload 29
    //   2863: astore 35
    //   2865: aload 29
    //   2867: astore 34
    //   2869: iload 5
    //   2871: istore 4
    //   2873: ldc 85
    //   2875: iconst_2
    //   2876: new 138	java/lang/StringBuilder
    //   2879: dup
    //   2880: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   2883: ldc_w 583
    //   2886: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2889: aload 29
    //   2891: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2894: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2897: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2900: aload 29
    //   2902: astore 35
    //   2904: aload 29
    //   2906: astore 34
    //   2908: iload 5
    //   2910: istore 4
    //   2912: aload_0
    //   2913: getfield 460	aquz:httpCode	I
    //   2916: sipush 302
    //   2919: if_icmpne +5334 -> 8253
    //   2922: iload 12
    //   2924: ifne +5329 -> 8253
    //   2927: aload 29
    //   2929: astore 35
    //   2931: aload 29
    //   2933: astore 34
    //   2935: iload 5
    //   2937: istore 4
    //   2939: aload_0
    //   2940: getfield 523	aquz:cWA	Z
    //   2943: ifeq +5310 -> 8253
    //   2946: aload 29
    //   2948: astore 35
    //   2950: aload 29
    //   2952: astore 34
    //   2954: iload 5
    //   2956: istore 4
    //   2958: aload 29
    //   2960: ldc_w 585
    //   2963: invokevirtual 588	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   2966: ifeq +5287 -> 8253
    //   2969: aload 29
    //   2971: astore 35
    //   2973: aload 29
    //   2975: astore 34
    //   2977: iload 5
    //   2979: istore 4
    //   2981: aload_0
    //   2982: iconst_0
    //   2983: putfield 391	aquz:cWo	Z
    //   2986: iconst_1
    //   2987: istore 4
    //   2989: iconst_1
    //   2990: istore 5
    //   2992: aload 29
    //   2994: astore 35
    //   2996: aload 29
    //   2998: astore 34
    //   3000: aload 29
    //   3002: ldc_w 590
    //   3005: ldc_w 592
    //   3008: invokevirtual 595	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   3011: astore 29
    //   3013: new 597	org/apache/http/client/methods/HttpGet
    //   3016: dup
    //   3017: aload 29
    //   3019: invokespecial 598	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   3022: astore 34
    //   3024: aload_0
    //   3025: invokevirtual 602	aquz:aC	()Ljava/util/Map;
    //   3028: astore 30
    //   3030: aload 30
    //   3032: ifnull +175 -> 3207
    //   3035: aload 30
    //   3037: invokeinterface 606 1 0
    //   3042: invokeinterface 612 1 0
    //   3047: astore 35
    //   3049: aload 35
    //   3051: invokeinterface 617 1 0
    //   3056: ifeq +151 -> 3207
    //   3059: aload 35
    //   3061: invokeinterface 621 1 0
    //   3066: checkcast 213	java/lang/String
    //   3069: astore 45
    //   3071: aload 30
    //   3073: aload 45
    //   3075: invokeinterface 241 2 0
    //   3080: checkcast 213	java/lang/String
    //   3083: astore 46
    //   3085: aload 34
    //   3087: aload 45
    //   3089: aload 46
    //   3091: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3094: aload 43
    //   3096: ldc_w 627
    //   3099: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3102: aload 45
    //   3104: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3107: ldc_w 629
    //   3110: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3113: aload 46
    //   3115: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3118: pop
    //   3119: goto -70 -> 3049
    //   3122: astore 35
    //   3124: aload 33
    //   3126: astore 34
    //   3128: iconst_0
    //   3129: istore 14
    //   3131: iload 5
    //   3133: istore 4
    //   3135: aload 32
    //   3137: astore 30
    //   3139: iload 6
    //   3141: istore 8
    //   3143: aload 35
    //   3145: astore 33
    //   3147: iload 7
    //   3149: istore 6
    //   3151: iload_3
    //   3152: istore 5
    //   3154: aload 34
    //   3156: astore 32
    //   3158: iload 8
    //   3160: istore_3
    //   3161: goto -2207 -> 954
    //   3164: aload 29
    //   3166: astore 35
    //   3168: aload 29
    //   3170: astore 34
    //   3172: iload 5
    //   3174: istore 4
    //   3176: new 138	java/lang/StringBuilder
    //   3179: dup
    //   3180: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   3183: aload 29
    //   3185: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3188: ldc_w 631
    //   3191: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3194: iload 13
    //   3196: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3199: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3202: astore 30
    //   3204: goto -380 -> 2824
    //   3207: aload_0
    //   3208: getfield 634	aquz:cWt	Z
    //   3211: ifeq +41 -> 3252
    //   3214: getstatic 639	aszy:dgS	Z
    //   3217: ifeq +35 -> 3252
    //   3220: invokestatic 642	aszy:aIU	()Z
    //   3223: ifeq +29 -> 3252
    //   3226: aload 34
    //   3228: ldc_w 644
    //   3231: ldc_w 646
    //   3234: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3237: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3240: ifeq +12 -> 3252
    //   3243: ldc 85
    //   3245: iconst_2
    //   3246: ldc_w 648
    //   3249: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3252: aload_0
    //   3253: getfield 651	aquz:cWu	Z
    //   3256: ifeq +154 -> 3410
    //   3259: invokestatic 656	com/tencent/mobileqq/app/DeviceProfileManager:b	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   3262: getstatic 662	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:AcceptType	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   3265: invokevirtual 665	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   3268: invokevirtual 668	com/tencent/mobileqq/app/DeviceProfileManager:jf	(Ljava/lang/String;)Ljava/lang/String;
    //   3271: astore 30
    //   3273: aload 30
    //   3275: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3278: ifne +1010 -> 4288
    //   3281: aload 30
    //   3283: invokestatic 672	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   3286: iconst_1
    //   3287: iand
    //   3288: iconst_1
    //   3289: if_icmpne +999 -> 4288
    //   3292: aload 34
    //   3294: ldc_w 644
    //   3297: ldc_w 674
    //   3300: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3303: ldc_w 676
    //   3306: iconst_3
    //   3307: anewarray 4	java/lang/Object
    //   3310: dup
    //   3311: iconst_0
    //   3312: getstatic 35	aqva:ay	[I
    //   3315: iconst_0
    //   3316: iaload
    //   3317: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3320: aastore
    //   3321: dup
    //   3322: iconst_1
    //   3323: getstatic 35	aqva:ay	[I
    //   3326: iconst_1
    //   3327: iaload
    //   3328: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3331: aastore
    //   3332: dup
    //   3333: iconst_2
    //   3334: getstatic 35	aqva:ay	[I
    //   3337: iconst_2
    //   3338: iaload
    //   3339: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3342: aastore
    //   3343: invokestatic 680	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3346: astore 30
    //   3348: aload 34
    //   3350: ldc_w 682
    //   3353: new 138	java/lang/StringBuilder
    //   3356: dup
    //   3357: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   3360: ldc_w 684
    //   3363: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3366: aload 30
    //   3368: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3371: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3374: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3377: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3380: ifeq +30 -> 3410
    //   3383: ldc 85
    //   3385: iconst_2
    //   3386: new 138	java/lang/StringBuilder
    //   3389: dup
    //   3390: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   3393: ldc_w 686
    //   3396: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3399: aload 29
    //   3401: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3404: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3407: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3410: aload 36
    //   3412: ifnull +80 -> 3492
    //   3415: aload 36
    //   3417: invokevirtual 314	java/io/File:exists	()Z
    //   3420: ifeq +72 -> 3492
    //   3423: aload 36
    //   3425: invokevirtual 689	java/io/File:length	()J
    //   3428: lstore 21
    //   3430: aload 34
    //   3432: ldc_w 691
    //   3435: new 138	java/lang/StringBuilder
    //   3438: dup
    //   3439: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   3442: ldc_w 693
    //   3445: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3448: lload 21
    //   3450: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3453: ldc_w 695
    //   3456: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3459: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3462: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3465: aload 43
    //   3467: new 138	java/lang/StringBuilder
    //   3470: dup
    //   3471: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   3474: ldc_w 697
    //   3477: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3480: lload 21
    //   3482: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3485: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3488: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3491: pop
    //   3492: aload_0
    //   3493: getfield 700	aquz:cWv	Z
    //   3496: ifne +119 -> 3615
    //   3499: aload_0
    //   3500: getfield 703	aquz:cWs	Z
    //   3503: ifeq +112 -> 3615
    //   3506: aload 38
    //   3508: ifnull +107 -> 3615
    //   3511: aload 38
    //   3513: invokevirtual 314	java/io/File:exists	()Z
    //   3516: ifeq +99 -> 3615
    //   3519: aload_0
    //   3520: getfield 706	aquz:lastModifiedTime	J
    //   3523: lconst_0
    //   3524: lcmp
    //   3525: ifle +781 -> 4306
    //   3528: aload_0
    //   3529: getfield 706	aquz:lastModifiedTime	J
    //   3532: lstore 21
    //   3534: lload 21
    //   3536: lconst_0
    //   3537: lcmp
    //   3538: ifle +77 -> 3615
    //   3541: new 708	java/text/SimpleDateFormat
    //   3544: dup
    //   3545: ldc_w 710
    //   3548: getstatic 716	java/util/Locale:US	Ljava/util/Locale;
    //   3551: invokespecial 719	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   3554: astore 30
    //   3556: aload 30
    //   3558: ldc_w 721
    //   3561: invokestatic 727	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   3564: invokevirtual 731	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   3567: aload 30
    //   3569: new 733	java/util/Date
    //   3572: dup
    //   3573: lload 21
    //   3575: invokespecial 734	java/util/Date:<init>	(J)V
    //   3578: invokevirtual 737	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   3581: astore 30
    //   3583: aload 30
    //   3585: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3588: ifne +27 -> 3615
    //   3591: aload 34
    //   3593: ldc_w 739
    //   3596: aload 30
    //   3598: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3601: aload 43
    //   3603: ldc_w 741
    //   3606: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3609: aload 30
    //   3611: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3614: pop
    //   3615: getstatic 27	aqva:eW	Z
    //   3618: ifeq +105 -> 3723
    //   3621: aload_0
    //   3622: getfield 391	aquz:cWo	Z
    //   3625: ifeq +98 -> 3723
    //   3628: aload_0
    //   3629: getfield 421	aquz:cWn	Z
    //   3632: ifeq +91 -> 3723
    //   3635: aload 39
    //   3637: getfield 424	afka:isHttps	Z
    //   3640: ifne +83 -> 3723
    //   3643: aload 39
    //   3645: invokestatic 744	aqva:a	(Lafka;)V
    //   3648: aload 39
    //   3650: getfield 394	afka:bYr	Z
    //   3653: ifeq +70 -> 3723
    //   3656: aload 34
    //   3658: new 746	java/net/URI
    //   3661: dup
    //   3662: aload 39
    //   3664: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   3667: invokespecial 747	java/net/URI:<init>	(Ljava/lang/String;)V
    //   3670: invokevirtual 751	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   3673: aload 34
    //   3675: ldc_w 753
    //   3678: aload 39
    //   3680: getfield 405	afka:host	Ljava/lang/String;
    //   3683: invokevirtual 625	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3686: aload 43
    //   3688: ldc_w 755
    //   3691: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3694: aload 39
    //   3696: getfield 405	afka:host	Ljava/lang/String;
    //   3699: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3702: ldc_w 757
    //   3705: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3708: aload 39
    //   3710: getfield 397	afka:ip	Ljava/lang/String;
    //   3713: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3716: ldc_w 759
    //   3719: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3722: pop
    //   3723: aload 44
    //   3725: invokevirtual 764	android/net/NetworkInfo:getExtraInfo	()Ljava/lang/String;
    //   3728: invokestatic 769	aqoj:getApnType	(Ljava/lang/String;)Ljava/lang/String;
    //   3731: astore 30
    //   3733: aload 30
    //   3735: aload_0
    //   3736: getfield 772	aquz:bqw	Ljava/lang/String;
    //   3739: invokevirtual 776	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3742: ifne +14 -> 3756
    //   3745: aload_0
    //   3746: iconst_0
    //   3747: putfield 358	aquz:bJO	Z
    //   3750: aload_0
    //   3751: aload 30
    //   3753: putfield 772	aquz:bqw	Ljava/lang/String;
    //   3756: aload 44
    //   3758: invokestatic 782	aqiw:isMobileNetworkInfo	(Landroid/net/NetworkInfo;)Z
    //   3761: ifeq +555 -> 4316
    //   3764: aload_0
    //   3765: getfield 358	aquz:bJO	Z
    //   3768: ifne +4476 -> 8244
    //   3771: invokestatic 787	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   3774: astore 30
    //   3776: invokestatic 790	android/net/Proxy:getDefaultPort	()I
    //   3779: istore 8
    //   3781: aload 30
    //   3783: ifnull +4454 -> 8237
    //   3786: iload 8
    //   3788: ifle +4449 -> 8237
    //   3791: aload 40
    //   3793: ldc_w 792
    //   3796: new 794	org/apache/http/HttpHost
    //   3799: dup
    //   3800: aload 30
    //   3802: iload 8
    //   3804: invokespecial 797	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   3807: invokeinterface 169 3 0
    //   3812: pop
    //   3813: iconst_1
    //   3814: istore 4
    //   3816: aload 43
    //   3818: ldc_w 799
    //   3821: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3824: iconst_1
    //   3825: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   3828: ldc_w 801
    //   3831: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3834: aload 30
    //   3836: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3839: ldc_w 803
    //   3842: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3845: iload 8
    //   3847: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3850: pop
    //   3851: iload 4
    //   3853: istore 7
    //   3855: iload_3
    //   3856: istore 4
    //   3858: iload 7
    //   3860: istore_3
    //   3861: aload_0
    //   3862: getfield 300	aquz:cWy	Z
    //   3865: ifne +18 -> 3883
    //   3868: invokestatic 60	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3871: invokestatic 807	aqiw:isWifiConnected	(Landroid/content/Context;)Z
    //   3874: ifeq +9 -> 3883
    //   3877: aload 40
    //   3879: iconst_0
    //   3880: invokestatic 813	org/apache/http/client/params/HttpClientParams:setRedirecting	(Lorg/apache/http/params/HttpParams;Z)V
    //   3883: aload 40
    //   3885: ldc_w 815
    //   3888: iload 4
    //   3890: invokeinterface 819 3 0
    //   3895: pop
    //   3896: aload 34
    //   3898: aload 40
    //   3900: invokevirtual 823	org/apache/http/client/methods/HttpGet:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   3903: aload_0
    //   3904: getfield 177	aquz:cWw	Z
    //   3907: ifeq +419 -> 4326
    //   3910: ldc 179
    //   3912: astore 30
    //   3914: aload 34
    //   3916: ldc 181
    //   3918: aload 30
    //   3920: invokevirtual 826	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   3923: getstatic 831	com/tencent/mobileqq/utils/HttpDownloadUtil:c	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   3926: aload 34
    //   3928: invokevirtual 837	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   3931: astore 35
    //   3933: iload 5
    //   3935: istore 7
    //   3937: aload 35
    //   3939: invokeinterface 843 1 0
    //   3944: invokeinterface 848 1 0
    //   3949: istore 8
    //   3951: iload 5
    //   3953: istore 7
    //   3955: aload_0
    //   3956: iload 8
    //   3958: putfield 460	aquz:httpCode	I
    //   3961: iload 5
    //   3963: istore 7
    //   3965: aload 39
    //   3967: iload 8
    //   3969: putfield 851	afka:cRn	I
    //   3972: iload 5
    //   3974: istore 7
    //   3976: aload 43
    //   3978: ldc_w 853
    //   3981: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3984: aload 34
    //   3986: invokevirtual 857	org/apache/http/client/methods/HttpGet:getURI	()Ljava/net/URI;
    //   3989: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3992: ldc_w 859
    //   3995: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3998: iload 8
    //   4000: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4003: ldc_w 861
    //   4006: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4009: pop
    //   4010: iload 5
    //   4012: istore 7
    //   4014: aload 35
    //   4016: invokeinterface 865 1 0
    //   4021: astore 30
    //   4023: iload 5
    //   4025: istore 7
    //   4027: aload 30
    //   4029: invokeinterface 868 1 0
    //   4034: ifeq +300 -> 4334
    //   4037: iload 5
    //   4039: istore 7
    //   4041: aload 30
    //   4043: invokeinterface 872 1 0
    //   4048: astore 34
    //   4050: iload 5
    //   4052: istore 7
    //   4054: aload 34
    //   4056: invokeinterface 875 1 0
    //   4061: astore 44
    //   4063: iload 5
    //   4065: istore 7
    //   4067: ldc_w 877
    //   4070: aload 44
    //   4072: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4075: ifne +138 -> 4213
    //   4078: iload 5
    //   4080: istore 7
    //   4082: ldc_w 882
    //   4085: aload 44
    //   4087: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4090: ifne +123 -> 4213
    //   4093: iload 5
    //   4095: istore 7
    //   4097: ldc_w 884
    //   4100: aload 44
    //   4102: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4105: ifne +108 -> 4213
    //   4108: iload 5
    //   4110: istore 7
    //   4112: ldc_w 886
    //   4115: aload 44
    //   4117: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4120: ifne +93 -> 4213
    //   4123: iload 5
    //   4125: istore 7
    //   4127: ldc_w 888
    //   4130: aload 44
    //   4132: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4135: ifne +78 -> 4213
    //   4138: iload 5
    //   4140: istore 7
    //   4142: ldc_w 890
    //   4145: aload 44
    //   4147: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4150: ifne +63 -> 4213
    //   4153: iload 5
    //   4155: istore 7
    //   4157: ldc_w 892
    //   4160: aload 44
    //   4162: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4165: ifne +48 -> 4213
    //   4168: iload 5
    //   4170: istore 7
    //   4172: ldc_w 894
    //   4175: aload 44
    //   4177: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4180: ifne +33 -> 4213
    //   4183: iload 5
    //   4185: istore 7
    //   4187: ldc_w 896
    //   4190: aload 44
    //   4192: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4195: ifne +18 -> 4213
    //   4198: iload 5
    //   4200: istore 7
    //   4202: ldc_w 898
    //   4205: aload 44
    //   4207: invokevirtual 880	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   4210: ifeq -187 -> 4023
    //   4213: iload 5
    //   4215: istore 7
    //   4217: aload 43
    //   4219: ldc_w 627
    //   4222: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4225: aload 44
    //   4227: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4230: ldc_w 900
    //   4233: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4236: aload 34
    //   4238: invokeinterface 903 1 0
    //   4243: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4246: pop
    //   4247: goto -224 -> 4023
    //   4250: astore 34
    //   4252: iconst_1
    //   4253: istore 14
    //   4255: iload 4
    //   4257: istore 5
    //   4259: aload 32
    //   4261: astore 30
    //   4263: aload 33
    //   4265: astore 32
    //   4267: iload 6
    //   4269: istore 8
    //   4271: aload 34
    //   4273: astore 33
    //   4275: iload_3
    //   4276: istore 6
    //   4278: iload 7
    //   4280: istore 4
    //   4282: iload 8
    //   4284: istore_3
    //   4285: goto -3331 -> 954
    //   4288: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4291: ifeq -881 -> 3410
    //   4294: ldc 85
    //   4296: iconst_2
    //   4297: ldc_w 905
    //   4300: invokestatic 908	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   4303: goto -893 -> 3410
    //   4306: aload 38
    //   4308: invokevirtual 911	java/io/File:lastModified	()J
    //   4311: lstore 21
    //   4313: goto -779 -> 3534
    //   4316: sipush 4096
    //   4319: istore 4
    //   4321: iconst_0
    //   4322: istore_3
    //   4323: goto -462 -> 3861
    //   4326: ldc_w 913
    //   4329: astore 30
    //   4331: goto -417 -> 3914
    //   4334: sipush 200
    //   4337: iload 8
    //   4339: if_icmpeq +11 -> 4350
    //   4342: sipush 206
    //   4345: iload 8
    //   4347: if_icmpne +2081 -> 6428
    //   4350: iload 5
    //   4352: istore 7
    //   4354: aload 35
    //   4356: invokeinterface 917 1 0
    //   4361: astore 30
    //   4363: aload 30
    //   4365: invokeinterface 920 1 0
    //   4370: lstore 23
    //   4372: lload 23
    //   4374: lstore 21
    //   4376: iload 5
    //   4378: istore 7
    //   4380: aload 43
    //   4382: ldc_w 922
    //   4385: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4388: lload 23
    //   4390: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4393: pop
    //   4394: lload 23
    //   4396: lstore 21
    //   4398: iload 5
    //   4400: istore 7
    //   4402: aload 35
    //   4404: ldc_w 924
    //   4407: invokeinterface 928 2 0
    //   4412: astore 33
    //   4414: lload 23
    //   4416: lstore 21
    //   4418: iload 5
    //   4420: istore 7
    //   4422: aload 35
    //   4424: ldc_w 884
    //   4427: invokeinterface 928 2 0
    //   4432: astore 34
    //   4434: aload 33
    //   4436: ifnull +250 -> 4686
    //   4439: lload 23
    //   4441: lstore 21
    //   4443: iload 5
    //   4445: istore 7
    //   4447: aload 33
    //   4449: invokeinterface 903 1 0
    //   4454: ldc_w 930
    //   4457: invokevirtual 934	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   4460: iconst_1
    //   4461: aaload
    //   4462: invokestatic 672	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4465: i2l
    //   4466: lstore 17
    //   4468: lload 17
    //   4470: lstore 21
    //   4472: iload 5
    //   4474: istore 7
    //   4476: aload 36
    //   4478: invokevirtual 689	java/io/File:length	()J
    //   4481: lstore 23
    //   4483: lload 17
    //   4485: lstore 21
    //   4487: iload 5
    //   4489: istore 7
    //   4491: aload 43
    //   4493: ldc_w 936
    //   4496: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4499: lload 17
    //   4501: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4504: ldc_w 938
    //   4507: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4510: lload 23
    //   4512: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4515: pop
    //   4516: lload 17
    //   4518: lstore 21
    //   4520: iload 5
    //   4522: istore 7
    //   4524: aload_0
    //   4525: getfield 941	aquz:cWp	Z
    //   4528: ifne +10 -> 4538
    //   4531: lload 17
    //   4533: lconst_1
    //   4534: lcmp
    //   4535: iflt +38 -> 4573
    //   4538: lload 17
    //   4540: lstore 21
    //   4542: iload 5
    //   4544: istore 7
    //   4546: aload_0
    //   4547: getfield 944	aquz:atX	J
    //   4550: lconst_0
    //   4551: lcmp
    //   4552: ifle +167 -> 4719
    //   4555: lload 17
    //   4557: lstore 21
    //   4559: iload 5
    //   4561: istore 7
    //   4563: lload 17
    //   4565: aload_0
    //   4566: getfield 944	aquz:atX	J
    //   4569: lcmp
    //   4570: ifle +149 -> 4719
    //   4573: iconst_1
    //   4574: istore 7
    //   4576: iconst_1
    //   4577: istore 13
    //   4579: bipush 138
    //   4581: istore 8
    //   4583: lload 17
    //   4585: lstore 21
    //   4587: aload_0
    //   4588: bipush 138
    //   4590: putfield 133	aquz:errCode	I
    //   4593: iload 8
    //   4595: istore 6
    //   4597: iload 13
    //   4599: istore 5
    //   4601: iload 8
    //   4603: istore 7
    //   4605: aload 43
    //   4607: ldc_w 946
    //   4610: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4613: aload_0
    //   4614: getfield 944	aquz:atX	J
    //   4617: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4620: pop
    //   4621: iload 8
    //   4623: istore 6
    //   4625: iload 13
    //   4627: istore 5
    //   4629: iload 8
    //   4631: istore 7
    //   4633: new 75	java/lang/Exception
    //   4636: dup
    //   4637: ldc_w 948
    //   4640: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4643: athrow
    //   4644: astore 33
    //   4646: iload 6
    //   4648: istore 7
    //   4650: iload 4
    //   4652: istore 8
    //   4654: aload 30
    //   4656: astore 34
    //   4658: iload 5
    //   4660: istore 4
    //   4662: iconst_1
    //   4663: istore 14
    //   4665: iload_3
    //   4666: istore 6
    //   4668: iload 8
    //   4670: istore 5
    //   4672: aload 32
    //   4674: astore 30
    //   4676: aload 34
    //   4678: astore 32
    //   4680: iload 7
    //   4682: istore_3
    //   4683: goto -3729 -> 954
    //   4686: lload 23
    //   4688: lstore 17
    //   4690: aload 34
    //   4692: ifnull -224 -> 4468
    //   4695: lload 23
    //   4697: lstore 21
    //   4699: iload 5
    //   4701: istore 7
    //   4703: aload 34
    //   4705: invokeinterface 903 1 0
    //   4710: invokestatic 672	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   4713: i2l
    //   4714: lstore 17
    //   4716: goto -248 -> 4468
    //   4719: lconst_0
    //   4720: lload 23
    //   4722: lcmp
    //   4723: ifeq +74 -> 4797
    //   4726: lload 23
    //   4728: lload 17
    //   4730: lcmp
    //   4731: iflt +66 -> 4797
    //   4734: lload 17
    //   4736: lstore 21
    //   4738: iload 5
    //   4740: istore 7
    //   4742: aload 36
    //   4744: invokevirtual 320	java/io/File:delete	()Z
    //   4747: pop
    //   4748: bipush 139
    //   4750: istore 8
    //   4752: lload 17
    //   4754: lstore 21
    //   4756: iload 5
    //   4758: istore 7
    //   4760: aload_0
    //   4761: bipush 139
    //   4763: putfield 133	aquz:errCode	I
    //   4766: iload 8
    //   4768: istore 6
    //   4770: iload 8
    //   4772: istore 7
    //   4774: new 75	java/lang/Exception
    //   4777: dup
    //   4778: ldc_w 950
    //   4781: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4784: athrow
    //   4785: astore_1
    //   4786: iload 7
    //   4788: istore 6
    //   4790: aload 30
    //   4792: astore 33
    //   4794: goto -2522 -> 2272
    //   4797: lload 23
    //   4799: lconst_0
    //   4800: lcmp
    //   4801: ifeq +335 -> 5136
    //   4804: iconst_1
    //   4805: istore 14
    //   4807: lload 17
    //   4809: lstore 21
    //   4811: iload 5
    //   4813: istore 7
    //   4815: new 440	java/io/BufferedOutputStream
    //   4818: dup
    //   4819: new 952	java/io/FileOutputStream
    //   4822: dup
    //   4823: aload 36
    //   4825: iload 14
    //   4827: invokespecial 955	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   4830: invokespecial 958	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   4833: astore 33
    //   4835: aload 35
    //   4837: ldc_w 896
    //   4840: invokeinterface 928 2 0
    //   4845: ifnull +297 -> 5142
    //   4848: ldc 179
    //   4850: aload 35
    //   4852: ldc_w 896
    //   4855: invokeinterface 928 2 0
    //   4860: invokeinterface 903 1 0
    //   4865: invokevirtual 776	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4868: ifeq +274 -> 5142
    //   4871: new 960	java/util/zip/GZIPInputStream
    //   4874: dup
    //   4875: aload 30
    //   4877: invokeinterface 964 1 0
    //   4882: invokespecial 967	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   4885: astore 32
    //   4887: aload 43
    //   4889: ldc_w 969
    //   4892: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4895: pop
    //   4896: aload 32
    //   4898: astore 31
    //   4900: invokestatic 975	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   4903: iload 4
    //   4905: invokevirtual 979	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   4908: astore 44
    //   4910: iconst_0
    //   4911: istore 7
    //   4913: lload 19
    //   4915: lstore 21
    //   4917: aload_0
    //   4918: invokevirtual 388	aquz:isCancel	()Z
    //   4921: ifne +326 -> 5247
    //   4924: lload 19
    //   4926: lstore 21
    //   4928: aload 31
    //   4930: aload 44
    //   4932: invokevirtual 983	java/io/InputStream:read	([B)I
    //   4935: istore 8
    //   4937: iload 8
    //   4939: iconst_m1
    //   4940: if_icmpeq +307 -> 5247
    //   4943: lload 19
    //   4945: lstore 21
    //   4947: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4950: ifeq +64 -> 5014
    //   4953: lconst_0
    //   4954: lload 23
    //   4956: lcmp
    //   4957: ifne +57 -> 5014
    //   4960: aconst_null
    //   4961: astore 34
    //   4963: iload 8
    //   4965: iconst_4
    //   4966: if_icmple +192 -> 5158
    //   4969: iconst_m1
    //   4970: aload 44
    //   4972: iconst_0
    //   4973: baload
    //   4974: if_icmpne +184 -> 5158
    //   4977: bipush 216
    //   4979: aload 44
    //   4981: iconst_1
    //   4982: baload
    //   4983: if_icmpne +175 -> 5158
    //   4986: ldc_w 985
    //   4989: astore 32
    //   4991: aload 32
    //   4993: ifnull +21 -> 5014
    //   4996: lload 19
    //   4998: lstore 21
    //   5000: aload 43
    //   5002: ldc_w 987
    //   5005: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5008: aload 32
    //   5010: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5013: pop
    //   5014: lload 19
    //   5016: lstore 21
    //   5018: aload 33
    //   5020: aload 44
    //   5022: iconst_0
    //   5023: iload 8
    //   5025: invokevirtual 991	java/io/BufferedOutputStream:write	([BII)V
    //   5028: lload 23
    //   5030: iload 8
    //   5032: i2l
    //   5033: ladd
    //   5034: lstore 23
    //   5036: lload 19
    //   5038: iload 8
    //   5040: i2l
    //   5041: ladd
    //   5042: lstore 19
    //   5044: iload 7
    //   5046: iload 8
    //   5048: iadd
    //   5049: istore 7
    //   5051: lload 17
    //   5053: lconst_0
    //   5054: lcmp
    //   5055: ifle +3179 -> 8234
    //   5058: lload 19
    //   5060: lstore 21
    //   5062: aload_0
    //   5063: getfield 994	aquz:atY	J
    //   5066: lconst_0
    //   5067: lcmp
    //   5068: ifne +17 -> 5085
    //   5071: lload 19
    //   5073: lstore 21
    //   5075: aload_0
    //   5076: lload 17
    //   5078: ldc2_w 995
    //   5081: ldiv
    //   5082: putfield 994	aquz:atY	J
    //   5085: lload 19
    //   5087: lstore 21
    //   5089: iload 7
    //   5091: i2l
    //   5092: aload_0
    //   5093: getfield 994	aquz:atY	J
    //   5096: lcmp
    //   5097: ifge +11 -> 5108
    //   5100: lload 23
    //   5102: lload 17
    //   5104: lcmp
    //   5105: iflt +3129 -> 8234
    //   5108: lload 19
    //   5110: lstore 21
    //   5112: aload_0
    //   5113: lload 17
    //   5115: lload 23
    //   5117: iload 11
    //   5119: invokevirtual 1000	aquz:t	(JJI)V
    //   5122: lload 19
    //   5124: lstore 21
    //   5126: aload_0
    //   5127: invokevirtual 1003	aquz:efP	()V
    //   5130: iconst_0
    //   5131: istore 7
    //   5133: goto -220 -> 4913
    //   5136: iconst_0
    //   5137: istore 14
    //   5139: goto -332 -> 4807
    //   5142: aload 30
    //   5144: invokeinterface 964 1 0
    //   5149: astore 32
    //   5151: aload 32
    //   5153: astore 31
    //   5155: goto -255 -> 4900
    //   5158: iload 8
    //   5160: bipush 8
    //   5162: if_icmple +3173 -> 8335
    //   5165: bipush 137
    //   5167: aload 44
    //   5169: iconst_0
    //   5170: baload
    //   5171: if_icmpne +3164 -> 8335
    //   5174: bipush 80
    //   5176: aload 44
    //   5178: iconst_1
    //   5179: baload
    //   5180: if_icmpne +3155 -> 8335
    //   5183: bipush 78
    //   5185: aload 44
    //   5187: iconst_2
    //   5188: baload
    //   5189: if_icmpne +3146 -> 8335
    //   5192: bipush 71
    //   5194: aload 44
    //   5196: iconst_3
    //   5197: baload
    //   5198: if_icmpne +3137 -> 8335
    //   5201: bipush 13
    //   5203: aload 44
    //   5205: iconst_4
    //   5206: baload
    //   5207: if_icmpne +3128 -> 8335
    //   5210: bipush 10
    //   5212: aload 44
    //   5214: iconst_5
    //   5215: baload
    //   5216: if_icmpne +3119 -> 8335
    //   5219: bipush 26
    //   5221: aload 44
    //   5223: bipush 6
    //   5225: baload
    //   5226: if_icmpne +3109 -> 8335
    //   5229: bipush 10
    //   5231: aload 44
    //   5233: bipush 7
    //   5235: baload
    //   5236: if_icmpne +3099 -> 8335
    //   5239: ldc_w 1005
    //   5242: astore 32
    //   5244: goto -253 -> 4991
    //   5247: lload 19
    //   5249: lstore 21
    //   5251: aload 33
    //   5253: invokevirtual 1008	java/io/BufferedOutputStream:flush	()V
    //   5256: lload 19
    //   5258: lstore 21
    //   5260: invokestatic 975	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   5263: aload 44
    //   5265: invokevirtual 1012	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   5268: lload 19
    //   5270: lstore 21
    //   5272: aload 36
    //   5274: invokevirtual 689	java/io/File:length	()J
    //   5277: lstore 23
    //   5279: lload 19
    //   5281: lstore 21
    //   5283: aload 43
    //   5285: ldc_w 1014
    //   5288: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5291: lload 23
    //   5293: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5296: pop
    //   5297: lload 23
    //   5299: lload 17
    //   5301: lcmp
    //   5302: ifeq +80 -> 5382
    //   5305: lload 17
    //   5307: lconst_1
    //   5308: lcmp
    //   5309: ifge +21 -> 5330
    //   5312: lload 19
    //   5314: lstore 21
    //   5316: aload_0
    //   5317: getfield 941	aquz:cWp	Z
    //   5320: ifeq +10 -> 5330
    //   5323: lload 23
    //   5325: lconst_0
    //   5326: lcmp
    //   5327: ifgt +55 -> 5382
    //   5330: lload 19
    //   5332: lstore 21
    //   5334: aload 35
    //   5336: ldc_w 896
    //   5339: invokeinterface 928 2 0
    //   5344: ifnull +898 -> 6242
    //   5347: lload 19
    //   5349: lstore 21
    //   5351: ldc 179
    //   5353: aload 35
    //   5355: ldc_w 896
    //   5358: invokeinterface 928 2 0
    //   5363: invokeinterface 903 1 0
    //   5368: invokevirtual 776	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5371: ifeq +871 -> 6242
    //   5374: lload 23
    //   5376: lload 17
    //   5378: lcmp
    //   5379: iflt +863 -> 6242
    //   5382: lload 19
    //   5384: lstore 21
    //   5386: aload_0
    //   5387: iconst_0
    //   5388: putfield 133	aquz:errCode	I
    //   5391: aload 38
    //   5393: invokevirtual 314	java/io/File:exists	()Z
    //   5396: ifeq +9 -> 5405
    //   5399: aload 38
    //   5401: invokevirtual 320	java/io/File:delete	()Z
    //   5404: pop
    //   5405: aload 36
    //   5407: aload 38
    //   5409: invokevirtual 1018	java/io/File:renameTo	(Ljava/io/File;)Z
    //   5412: istore 14
    //   5414: aload 43
    //   5416: ldc_w 1020
    //   5419: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5422: iload 14
    //   5424: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5427: pop
    //   5428: aload_0
    //   5429: getfield 703	aquz:cWs	Z
    //   5432: ifeq +158 -> 5590
    //   5435: aload 35
    //   5437: ldc_w 888
    //   5440: invokeinterface 1023 2 0
    //   5445: ifeq +145 -> 5590
    //   5448: aload 35
    //   5450: ldc_w 888
    //   5453: invokeinterface 928 2 0
    //   5458: invokeinterface 903 1 0
    //   5463: astore 32
    //   5465: aload 32
    //   5467: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5470: istore 14
    //   5472: iload 14
    //   5474: ifne +116 -> 5590
    //   5477: new 708	java/text/SimpleDateFormat
    //   5480: dup
    //   5481: ldc_w 1025
    //   5484: getstatic 716	java/util/Locale:US	Ljava/util/Locale;
    //   5487: invokespecial 719	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   5490: astore 34
    //   5492: aload 34
    //   5494: ldc_w 721
    //   5497: invokestatic 727	java/util/TimeZone:getTimeZone	(Ljava/lang/String;)Ljava/util/TimeZone;
    //   5500: invokevirtual 731	java/text/SimpleDateFormat:setTimeZone	(Ljava/util/TimeZone;)V
    //   5503: aload 34
    //   5505: aload 32
    //   5507: invokevirtual 1029	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   5510: invokevirtual 1032	java/util/Date:getTime	()J
    //   5513: lstore 21
    //   5515: aload 38
    //   5517: lload 21
    //   5519: invokevirtual 1036	java/io/File:setLastModified	(J)Z
    //   5522: pop
    //   5523: aload_0
    //   5524: lload 21
    //   5526: putfield 706	aquz:lastModifiedTime	J
    //   5529: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5532: ifeq +58 -> 5590
    //   5535: ldc 85
    //   5537: iconst_2
    //   5538: new 138	java/lang/StringBuilder
    //   5541: dup
    //   5542: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   5545: ldc_w 1038
    //   5548: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5551: lload 21
    //   5553: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5556: ldc_w 1040
    //   5559: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5562: aload 38
    //   5564: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   5567: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5570: ldc_w 1042
    //   5573: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5576: aload 38
    //   5578: invokevirtual 911	java/io/File:lastModified	()J
    //   5581: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5584: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5587: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   5590: iconst_0
    //   5591: istore 7
    //   5593: iload 5
    //   5595: istore 6
    //   5597: iload 7
    //   5599: istore 5
    //   5601: lload 19
    //   5603: lstore 21
    //   5605: aload 30
    //   5607: astore 32
    //   5609: aload 33
    //   5611: astore 30
    //   5613: iload 5
    //   5615: istore 7
    //   5617: iload 6
    //   5619: istore 5
    //   5621: lload 17
    //   5623: lstore 19
    //   5625: lload 21
    //   5627: lstore 17
    //   5629: iload 5
    //   5631: istore 6
    //   5633: getstatic 50	aqva:D	Ljava/util/concurrent/ConcurrentHashMap;
    //   5636: ifnonnull +17 -> 5653
    //   5639: iload 5
    //   5641: istore 6
    //   5643: new 47	java/util/concurrent/ConcurrentHashMap
    //   5646: dup
    //   5647: invokespecial 48	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   5650: putstatic 50	aqva:D	Ljava/util/concurrent/ConcurrentHashMap;
    //   5653: iload 7
    //   5655: ifeq +1204 -> 6859
    //   5658: iload 5
    //   5660: istore 6
    //   5662: aload_0
    //   5663: invokevirtual 388	aquz:isCancel	()Z
    //   5666: ifne +1193 -> 6859
    //   5669: iload 5
    //   5671: istore 6
    //   5673: iload 12
    //   5675: aload_0
    //   5676: getfield 305	aquz:retryCount	I
    //   5679: if_icmpge +1077 -> 6756
    //   5682: iload 5
    //   5684: istore 6
    //   5686: aload 41
    //   5688: monitorenter
    //   5689: sipush 2000
    //   5692: i2l
    //   5693: lstore 21
    //   5695: aload 41
    //   5697: lload 21
    //   5699: invokevirtual 1045	java/lang/Object:wait	(J)V
    //   5702: aload 41
    //   5704: monitorexit
    //   5705: iload 5
    //   5707: istore 6
    //   5709: aload_0
    //   5710: getfield 133	aquz:errCode	I
    //   5713: sipush 302
    //   5716: if_icmpne +44 -> 5760
    //   5719: iload 5
    //   5721: istore 6
    //   5723: aload 35
    //   5725: ldc_w 890
    //   5728: invokeinterface 928 2 0
    //   5733: astore 33
    //   5735: aload 33
    //   5737: ifnull +23 -> 5760
    //   5740: iload 5
    //   5742: istore 6
    //   5744: aload 37
    //   5746: ldc_w 1047
    //   5749: aload 33
    //   5751: invokeinterface 903 1 0
    //   5756: invokevirtual 450	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   5759: pop
    //   5760: iload 7
    //   5762: istore 8
    //   5764: ldc 85
    //   5766: iconst_1
    //   5767: new 138	java/lang/StringBuilder
    //   5770: dup
    //   5771: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   5774: aload 43
    //   5776: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5779: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5782: ldc_w 379
    //   5785: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5788: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   5791: lload 27
    //   5793: lsub
    //   5794: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5797: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5800: invokestatic 382	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5803: iload 7
    //   5805: istore 8
    //   5807: aload_0
    //   5808: getfield 220	aquz:bju	I
    //   5811: iconst_3
    //   5812: if_icmpne +64 -> 5876
    //   5815: iload 10
    //   5817: ifeq +59 -> 5876
    //   5820: iload 7
    //   5822: istore 8
    //   5824: bipush 30
    //   5826: aload_0
    //   5827: getfield 217	aquz:currUrl	Ljava/lang/String;
    //   5830: sipush 300
    //   5833: iconst_1
    //   5834: anewarray 4	java/lang/Object
    //   5837: dup
    //   5838: iconst_0
    //   5839: new 138	java/lang/StringBuilder
    //   5842: dup
    //   5843: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   5846: aload 43
    //   5848: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5851: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5854: ldc_w 379
    //   5857: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5860: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   5863: lload 27
    //   5865: lsub
    //   5866: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5869: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5872: aastore
    //   5873: invokestatic 385	abwh:a	(ILjava/lang/String;I[Ljava/lang/Object;)V
    //   5876: iload 7
    //   5878: ifeq +119 -> 5997
    //   5881: iload 7
    //   5883: istore 8
    //   5885: aload_0
    //   5886: invokevirtual 388	aquz:isCancel	()Z
    //   5889: ifne +108 -> 5997
    //   5892: iload 7
    //   5894: istore 8
    //   5896: aload_0
    //   5897: getfield 391	aquz:cWo	Z
    //   5900: ifeq +97 -> 5997
    //   5903: iload 7
    //   5905: istore 8
    //   5907: aload 39
    //   5909: getfield 394	afka:bYr	Z
    //   5912: ifeq +1001 -> 6913
    //   5915: iload 7
    //   5917: istore 8
    //   5919: aload 39
    //   5921: getfield 397	afka:ip	Ljava/lang/String;
    //   5924: invokestatic 275	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5927: ifne +950 -> 6877
    //   5930: iload 7
    //   5932: istore 8
    //   5934: invokestatic 402	aopd:a	()Laopd;
    //   5937: aload 39
    //   5939: getfield 405	afka:host	Ljava/lang/String;
    //   5942: aload 39
    //   5944: getfield 397	afka:ip	Ljava/lang/String;
    //   5947: getstatic 42	aqva:ox	Ljava/util/Map;
    //   5950: aload 39
    //   5952: getfield 405	afka:host	Ljava/lang/String;
    //   5955: invokeinterface 241 2 0
    //   5960: checkcast 159	java/lang/Integer
    //   5963: invokevirtual 408	java/lang/Integer:intValue	()I
    //   5966: invokevirtual 412	aopd:X	(Ljava/lang/String;Ljava/lang/String;I)V
    //   5969: iload 7
    //   5971: istore 8
    //   5973: aload 39
    //   5975: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   5978: aload 38
    //   5980: invokevirtual 255	java/io/File:getName	()Ljava/lang/String;
    //   5983: iconst_m1
    //   5984: aload_2
    //   5985: invokestatic 418	aqva:a	(Ljava/lang/String;Ljava/lang/String;ILandroid/content/Context;)V
    //   5988: iload 7
    //   5990: istore 8
    //   5992: aload_0
    //   5993: iconst_0
    //   5994: putfield 421	aquz:cWn	Z
    //   5997: iload 7
    //   5999: istore 8
    //   6001: new 138	java/lang/StringBuilder
    //   6004: dup
    //   6005: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   6008: astore 34
    //   6010: iload 7
    //   6012: istore 8
    //   6014: aload 39
    //   6016: getfield 424	afka:isHttps	Z
    //   6019: ifeq +2519 -> 8538
    //   6022: ldc_w 426
    //   6025: astore 33
    //   6027: iload 7
    //   6029: istore 8
    //   6031: aload 34
    //   6033: aload 33
    //   6035: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6038: astore 34
    //   6040: iload 7
    //   6042: istore 8
    //   6044: aload 39
    //   6046: getfield 394	afka:bYr	Z
    //   6049: ifeq +2497 -> 8546
    //   6052: ldc_w 428
    //   6055: astore 33
    //   6057: iload 7
    //   6059: istore 8
    //   6061: aload 34
    //   6063: aload 33
    //   6065: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6068: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6071: astore 33
    //   6073: iload 12
    //   6075: iconst_1
    //   6076: iadd
    //   6077: istore 6
    //   6079: aload 32
    //   6081: ifnull +14 -> 6095
    //   6084: iload 7
    //   6086: istore 8
    //   6088: aload 32
    //   6090: invokeinterface 433 1 0
    //   6095: aload 31
    //   6097: ifnull +12 -> 6109
    //   6100: iload 7
    //   6102: istore 8
    //   6104: aload 31
    //   6106: invokevirtual 438	java/io/InputStream:close	()V
    //   6109: aload 30
    //   6111: ifnull +12 -> 6123
    //   6114: iload 7
    //   6116: istore 8
    //   6118: aload 30
    //   6120: invokevirtual 441	java/io/BufferedOutputStream:close	()V
    //   6123: iload 5
    //   6125: istore 8
    //   6127: iconst_1
    //   6128: istore 14
    //   6130: iload 6
    //   6132: istore 5
    //   6134: iload_3
    //   6135: istore 6
    //   6137: iload 7
    //   6139: istore_3
    //   6140: iload 8
    //   6142: istore 7
    //   6144: goto -4697 -> 1447
    //   6147: astore 34
    //   6149: ldc 85
    //   6151: iconst_1
    //   6152: new 138	java/lang/StringBuilder
    //   6155: dup
    //   6156: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   6159: ldc_w 1049
    //   6162: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6165: aload 32
    //   6167: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6170: ldc_w 1051
    //   6173: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6176: aload 34
    //   6178: invokevirtual 1052	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   6181: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6184: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6187: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6190: goto -600 -> 5590
    //   6193: astore 34
    //   6195: aload 33
    //   6197: astore 32
    //   6199: iconst_0
    //   6200: istore 8
    //   6202: aload 34
    //   6204: astore 33
    //   6206: iload 4
    //   6208: istore 7
    //   6210: aload 30
    //   6212: astore 34
    //   6214: iload 5
    //   6216: istore 4
    //   6218: iconst_1
    //   6219: istore 14
    //   6221: iload_3
    //   6222: istore 6
    //   6224: iload 7
    //   6226: istore 5
    //   6228: aload 32
    //   6230: astore 30
    //   6232: aload 34
    //   6234: astore 32
    //   6236: iload 8
    //   6238: istore_3
    //   6239: goto -5285 -> 954
    //   6242: lload 19
    //   6244: lstore 21
    //   6246: aload_0
    //   6247: invokevirtual 388	aquz:isCancel	()Z
    //   6250: istore 14
    //   6252: iload 14
    //   6254: ifeq +85 -> 6339
    //   6257: iconst_1
    //   6258: istore 7
    //   6260: bipush 150
    //   6262: istore 5
    //   6264: aload_0
    //   6265: bipush 150
    //   6267: putfield 133	aquz:errCode	I
    //   6270: iload 5
    //   6272: istore 6
    //   6274: aload 43
    //   6276: ldc_w 1054
    //   6279: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6282: pop
    //   6283: iload 7
    //   6285: istore 6
    //   6287: goto -686 -> 5601
    //   6290: astore 34
    //   6292: aload 33
    //   6294: astore 32
    //   6296: bipush 150
    //   6298: istore 7
    //   6300: iconst_1
    //   6301: istore 8
    //   6303: iconst_1
    //   6304: istore 14
    //   6306: aload 34
    //   6308: astore 33
    //   6310: iload 4
    //   6312: istore 5
    //   6314: aload 30
    //   6316: astore 34
    //   6318: iload_3
    //   6319: istore 6
    //   6321: iload 8
    //   6323: istore 4
    //   6325: aload 32
    //   6327: astore 30
    //   6329: aload 34
    //   6331: astore 32
    //   6333: iload 7
    //   6335: istore_3
    //   6336: goto -5382 -> 954
    //   6339: bipush 151
    //   6341: istore 7
    //   6343: lload 19
    //   6345: lstore 21
    //   6347: aload_0
    //   6348: bipush 151
    //   6350: putfield 133	aquz:errCode	I
    //   6353: iload 7
    //   6355: istore 6
    //   6357: aload 36
    //   6359: invokevirtual 320	java/io/File:delete	()Z
    //   6362: pop
    //   6363: iload 7
    //   6365: istore 6
    //   6367: new 75	java/lang/Exception
    //   6370: dup
    //   6371: ldc_w 1056
    //   6374: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6377: athrow
    //   6378: astore 35
    //   6380: aload 33
    //   6382: astore 32
    //   6384: bipush 151
    //   6386: istore 8
    //   6388: iload 4
    //   6390: istore 7
    //   6392: aload 30
    //   6394: astore 34
    //   6396: iconst_1
    //   6397: istore 14
    //   6399: iload 5
    //   6401: istore 4
    //   6403: aload 35
    //   6405: astore 33
    //   6407: iload_3
    //   6408: istore 6
    //   6410: iload 7
    //   6412: istore 5
    //   6414: aload 32
    //   6416: astore 30
    //   6418: aload 34
    //   6420: astore 32
    //   6422: iload 8
    //   6424: istore_3
    //   6425: goto -5471 -> 954
    //   6428: sipush 404
    //   6431: iload 8
    //   6433: if_icmpne +2029 -> 8462
    //   6436: iconst_1
    //   6437: istore 5
    //   6439: iconst_1
    //   6440: istore 7
    //   6442: aload_0
    //   6443: iload 8
    //   6445: putfield 133	aquz:errCode	I
    //   6448: lload 17
    //   6450: lstore 21
    //   6452: iload 8
    //   6454: istore 7
    //   6456: aload 32
    //   6458: astore 30
    //   6460: lload 19
    //   6462: lstore 17
    //   6464: lload 21
    //   6466: lstore 19
    //   6468: aload 33
    //   6470: astore 32
    //   6472: goto -843 -> 5629
    //   6475: iload 5
    //   6477: istore 7
    //   6479: aload_0
    //   6480: getfield 300	aquz:cWy	Z
    //   6483: ifne +82 -> 6565
    //   6486: iconst_1
    //   6487: istore 13
    //   6489: iconst_1
    //   6490: istore 7
    //   6492: iload 13
    //   6494: istore 5
    //   6496: aload_0
    //   6497: getfield 523	aquz:cWA	Z
    //   6500: ifeq +28 -> 6528
    //   6503: iload 13
    //   6505: istore 5
    //   6507: iload 8
    //   6509: sipush 302
    //   6512: if_icmpne +16 -> 6528
    //   6515: iload 13
    //   6517: istore 5
    //   6519: iload 12
    //   6521: iconst_m1
    //   6522: if_icmpne +6 -> 6528
    //   6525: iconst_0
    //   6526: istore 5
    //   6528: iload 5
    //   6530: istore 7
    //   6532: aload_0
    //   6533: iload 8
    //   6535: putfield 133	aquz:errCode	I
    //   6538: lload 17
    //   6540: lstore 21
    //   6542: iload 8
    //   6544: istore 7
    //   6546: aload 32
    //   6548: astore 30
    //   6550: lload 19
    //   6552: lstore 17
    //   6554: lload 21
    //   6556: lstore 19
    //   6558: aload 33
    //   6560: astore 32
    //   6562: goto -933 -> 5629
    //   6565: sipush 304
    //   6568: iload 8
    //   6570: if_icmpne +38 -> 6608
    //   6573: iload 5
    //   6575: istore 7
    //   6577: aload_0
    //   6578: iconst_0
    //   6579: putfield 133	aquz:errCode	I
    //   6582: lload 17
    //   6584: lstore 21
    //   6586: iconst_0
    //   6587: istore 7
    //   6589: aload 32
    //   6591: astore 30
    //   6593: lload 19
    //   6595: lstore 17
    //   6597: lload 21
    //   6599: lstore 19
    //   6601: aload 33
    //   6603: astore 32
    //   6605: goto -976 -> 5629
    //   6608: sipush 416
    //   6611: iload 8
    //   6613: if_icmpne +62 -> 6675
    //   6616: iload 5
    //   6618: istore 7
    //   6620: aload 36
    //   6622: invokevirtual 314	java/io/File:exists	()Z
    //   6625: ifeq +13 -> 6638
    //   6628: iload 5
    //   6630: istore 7
    //   6632: aload 36
    //   6634: invokevirtual 320	java/io/File:delete	()Z
    //   6637: pop
    //   6638: iload 5
    //   6640: istore 7
    //   6642: aload_0
    //   6643: iload 8
    //   6645: putfield 133	aquz:errCode	I
    //   6648: lload 17
    //   6650: lstore 21
    //   6652: iload 8
    //   6654: istore 7
    //   6656: aload 32
    //   6658: astore 30
    //   6660: lload 19
    //   6662: lstore 17
    //   6664: lload 21
    //   6666: lstore 19
    //   6668: aload 33
    //   6670: astore 32
    //   6672: goto -1043 -> 5629
    //   6675: iload 5
    //   6677: istore 7
    //   6679: aload_0
    //   6680: iload 8
    //   6682: putfield 133	aquz:errCode	I
    //   6685: lload 17
    //   6687: lstore 21
    //   6689: iload 8
    //   6691: istore 7
    //   6693: aload 32
    //   6695: astore 30
    //   6697: lload 19
    //   6699: lstore 17
    //   6701: lload 21
    //   6703: lstore 19
    //   6705: aload 33
    //   6707: astore 32
    //   6709: goto -1080 -> 5629
    //   6712: astore 33
    //   6714: ldc 85
    //   6716: iconst_1
    //   6717: new 138	java/lang/StringBuilder
    //   6720: dup
    //   6721: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   6724: ldc_w 1058
    //   6727: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6730: aload 29
    //   6732: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6735: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6738: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6741: goto -1039 -> 5702
    //   6744: astore 33
    //   6746: aload 41
    //   6748: monitorexit
    //   6749: iload 5
    //   6751: istore 6
    //   6753: aload 33
    //   6755: athrow
    //   6756: iload 5
    //   6758: istore 6
    //   6760: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   6763: ldc2_w 1059
    //   6766: ldiv
    //   6767: l2i
    //   6768: istore 8
    //   6770: iload 5
    //   6772: istore 6
    //   6774: aload_0
    //   6775: getfield 1063	aquz:cWm	Z
    //   6778: ifeq +23 -> 6801
    //   6781: iload 5
    //   6783: istore 6
    //   6785: getstatic 50	aqva:D	Ljava/util/concurrent/ConcurrentHashMap;
    //   6788: aload_0
    //   6789: getfield 1066	aquz:key	Ljava/lang/String;
    //   6792: iload 8
    //   6794: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   6797: invokevirtual 1067	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6800: pop
    //   6801: iconst_1
    //   6802: istore 6
    //   6804: new 75	java/lang/Exception
    //   6807: dup
    //   6808: new 138	java/lang/StringBuilder
    //   6811: dup
    //   6812: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   6815: ldc_w 1069
    //   6818: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6821: aload 29
    //   6823: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6826: ldc_w 1071
    //   6829: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6832: aload_0
    //   6833: getfield 391	aquz:cWo	Z
    //   6836: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6839: ldc_w 1073
    //   6842: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6845: aload_0
    //   6846: getfield 421	aquz:cWn	Z
    //   6849: invokevirtual 295	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6852: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6855: invokespecial 343	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   6858: athrow
    //   6859: iload 5
    //   6861: istore 6
    //   6863: getstatic 50	aqva:D	Ljava/util/concurrent/ConcurrentHashMap;
    //   6866: aload_0
    //   6867: getfield 1066	aquz:key	Ljava/lang/String;
    //   6870: invokevirtual 1076	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6873: pop
    //   6874: goto -1169 -> 5705
    //   6877: iload 7
    //   6879: istore 8
    //   6881: invokestatic 1081	aokl:a	()Laokl;
    //   6884: astore 33
    //   6886: aload 33
    //   6888: ifnull -919 -> 5969
    //   6891: iload 7
    //   6893: istore 8
    //   6895: aload 33
    //   6897: aload 39
    //   6899: getfield 1084	afka:cRo	I
    //   6902: aload 39
    //   6904: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   6907: invokevirtual 1087	aokl:onFailed	(ILjava/lang/String;)V
    //   6910: goto -941 -> 5969
    //   6913: iload 7
    //   6915: istore 8
    //   6917: aload_0
    //   6918: iconst_1
    //   6919: putfield 421	aquz:cWn	Z
    //   6922: goto -925 -> 5997
    //   6925: astore 34
    //   6927: iload 7
    //   6929: istore 8
    //   6931: ldc 85
    //   6933: iconst_1
    //   6934: new 138	java/lang/StringBuilder
    //   6937: dup
    //   6938: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   6941: ldc_w 1089
    //   6944: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6947: aload 34
    //   6949: invokevirtual 1090	java/io/IOException:getMessage	()Ljava/lang/String;
    //   6952: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6955: ldc_w 1092
    //   6958: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6961: aload 29
    //   6963: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6966: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6969: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   6972: iload 5
    //   6974: istore 8
    //   6976: iconst_1
    //   6977: istore 14
    //   6979: iload 6
    //   6981: istore 5
    //   6983: iload_3
    //   6984: istore 6
    //   6986: iload 7
    //   6988: istore_3
    //   6989: iload 8
    //   6991: istore 7
    //   6993: goto -5546 -> 1447
    //   6996: aload 33
    //   6998: instanceof 1094
    //   7001: ifeq +12 -> 7013
    //   7004: aload_0
    //   7005: bipush 144
    //   7007: putfield 133	aquz:errCode	I
    //   7010: goto -6012 -> 998
    //   7013: aload 33
    //   7015: instanceof 345
    //   7018: ifne +11 -> 7029
    //   7021: aload 33
    //   7023: instanceof 347
    //   7026: ifeq +12 -> 7038
    //   7029: aload_0
    //   7030: bipush 143
    //   7032: putfield 133	aquz:errCode	I
    //   7035: goto -6037 -> 998
    //   7038: aload 33
    //   7040: instanceof 349
    //   7043: ifeq +12 -> 7055
    //   7046: aload_0
    //   7047: bipush 142
    //   7049: putfield 133	aquz:errCode	I
    //   7052: goto -6054 -> 998
    //   7055: aload_0
    //   7056: getfield 133	aquz:errCode	I
    //   7059: ifne -6061 -> 998
    //   7062: aload_0
    //   7063: bipush 141
    //   7065: putfield 133	aquz:errCode	I
    //   7068: goto -6070 -> 998
    //   7071: aload_0
    //   7072: iconst_0
    //   7073: putfield 358	aquz:bJO	Z
    //   7076: goto -6049 -> 1027
    //   7079: iload_3
    //   7080: istore 8
    //   7082: invokestatic 1081	aokl:a	()Laokl;
    //   7085: astore 33
    //   7087: aload 33
    //   7089: ifnull -5814 -> 1275
    //   7092: iload_3
    //   7093: istore 8
    //   7095: aload 33
    //   7097: aload 39
    //   7099: getfield 1084	afka:cRo	I
    //   7102: aload 39
    //   7104: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   7107: invokevirtual 1087	aokl:onFailed	(ILjava/lang/String;)V
    //   7110: goto -5835 -> 1275
    //   7113: iload_3
    //   7114: istore 8
    //   7116: aload_0
    //   7117: iconst_1
    //   7118: putfield 421	aquz:cWn	Z
    //   7121: goto -5820 -> 1301
    //   7124: astore 34
    //   7126: iload_3
    //   7127: istore 8
    //   7129: ldc 85
    //   7131: iconst_1
    //   7132: new 138	java/lang/StringBuilder
    //   7135: dup
    //   7136: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   7139: ldc_w 1089
    //   7142: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7145: aload 34
    //   7147: invokevirtual 1090	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7150: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7153: ldc_w 1092
    //   7156: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7159: aload 29
    //   7161: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7164: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7167: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7170: iload 7
    //   7172: istore 8
    //   7174: lload 17
    //   7176: lstore 21
    //   7178: iload 5
    //   7180: istore 12
    //   7182: iload 4
    //   7184: istore 7
    //   7186: lload 19
    //   7188: lstore 17
    //   7190: iload 8
    //   7192: istore 5
    //   7194: lload 21
    //   7196: lstore 19
    //   7198: iload 12
    //   7200: istore 4
    //   7202: goto -5755 -> 1447
    //   7205: iload 6
    //   7207: istore 4
    //   7209: invokestatic 1081	aokl:a	()Laokl;
    //   7212: astore 30
    //   7214: aload 30
    //   7216: ifnull -4735 -> 2481
    //   7219: iload 6
    //   7221: istore 4
    //   7223: aload 30
    //   7225: aload 39
    //   7227: getfield 1084	afka:cRo	I
    //   7230: aload 39
    //   7232: getfield 415	afka:reqUrl	Ljava/lang/String;
    //   7235: invokevirtual 1087	aokl:onFailed	(ILjava/lang/String;)V
    //   7238: goto -4757 -> 2481
    //   7241: iload 6
    //   7243: istore 4
    //   7245: aload_0
    //   7246: iconst_1
    //   7247: putfield 421	aquz:cWn	Z
    //   7250: goto -4741 -> 2509
    //   7253: astore_0
    //   7254: iload 6
    //   7256: istore 4
    //   7258: ldc 85
    //   7260: iconst_1
    //   7261: new 138	java/lang/StringBuilder
    //   7264: dup
    //   7265: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   7268: ldc_w 1089
    //   7271: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7274: aload_0
    //   7275: invokevirtual 1090	java/io/IOException:getMessage	()Ljava/lang/String;
    //   7278: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7281: ldc_w 1092
    //   7284: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7287: aload 29
    //   7289: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7292: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7295: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7298: goto -4678 -> 2620
    //   7301: iload 4
    //   7303: istore 8
    //   7305: aload_0
    //   7306: bipush 146
    //   7308: putfield 133	aquz:errCode	I
    //   7311: iload 4
    //   7313: istore 8
    //   7315: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7318: ifeq +16 -> 7334
    //   7321: iload 4
    //   7323: istore 8
    //   7325: ldc 85
    //   7327: iconst_2
    //   7328: ldc_w 1096
    //   7331: invokestatic 908	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7334: lconst_0
    //   7335: lstore 19
    //   7337: iconst_m1
    //   7338: istore 6
    //   7340: iconst_m1
    //   7341: istore 4
    //   7343: lconst_0
    //   7344: lstore 17
    //   7346: aload 29
    //   7348: astore 32
    //   7350: iload_3
    //   7351: istore 5
    //   7353: aload 30
    //   7355: astore 29
    //   7357: aload 31
    //   7359: astore 30
    //   7361: aload 32
    //   7363: astore 31
    //   7365: aload 33
    //   7367: astore 32
    //   7369: aload 34
    //   7371: astore 33
    //   7373: iload 4
    //   7375: istore_3
    //   7376: goto -5846 -> 1530
    //   7379: iconst_0
    //   7380: istore 15
    //   7382: goto -5626 -> 1756
    //   7385: iload_3
    //   7386: istore 4
    //   7388: aload_0
    //   7389: getfield 1099	aquz:cWx	Z
    //   7392: istore 15
    //   7394: iload 15
    //   7396: iconst_1
    //   7397: if_icmpne +823 -> 8220
    //   7400: iload_3
    //   7401: istore 4
    //   7403: iload 9
    //   7405: ifle +809 -> 8214
    //   7408: iload 4
    //   7410: istore 8
    //   7412: aload_0
    //   7413: getfield 185	aquz:GP	Ljava/util/List;
    //   7416: invokeinterface 191 1 0
    //   7421: iconst_1
    //   7422: if_icmple +792 -> 8214
    //   7425: iload 4
    //   7427: istore 8
    //   7429: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7432: ifeq +52 -> 7484
    //   7435: iload 4
    //   7437: istore 8
    //   7439: ldc 85
    //   7441: iconst_2
    //   7442: new 138	java/lang/StringBuilder
    //   7445: dup
    //   7446: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   7449: ldc_w 1101
    //   7452: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7455: iload 9
    //   7457: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7460: ldc_w 1103
    //   7463: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7466: aload_0
    //   7467: getfield 185	aquz:GP	Ljava/util/List;
    //   7470: invokeinterface 191 1 0
    //   7475: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7478: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7481: invokestatic 908	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   7484: iload 4
    //   7486: istore 8
    //   7488: aload_0
    //   7489: bipush 148
    //   7491: putfield 133	aquz:errCode	I
    //   7494: iconst_m1
    //   7495: istore_3
    //   7496: iload_3
    //   7497: istore 5
    //   7499: aload_0
    //   7500: invokevirtual 388	aquz:isCancel	()Z
    //   7503: ifeq +43 -> 7546
    //   7506: iload_3
    //   7507: istore 5
    //   7509: aload_0
    //   7510: getfield 1106	aquz:cWr	Z
    //   7513: ifne +33 -> 7546
    //   7516: iload_3
    //   7517: istore 4
    //   7519: iload_3
    //   7520: istore 5
    //   7522: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7525: ifeq -4882 -> 2643
    //   7528: iload_3
    //   7529: istore 5
    //   7531: ldc 85
    //   7533: iconst_2
    //   7534: ldc_w 1108
    //   7537: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7540: iload_3
    //   7541: istore 4
    //   7543: goto -4900 -> 2643
    //   7546: iload_3
    //   7547: istore 5
    //   7549: aload_0
    //   7550: invokevirtual 388	aquz:isCancel	()Z
    //   7553: ifeq +1053 -> 8606
    //   7556: iload_3
    //   7557: istore 5
    //   7559: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7562: ifeq +15 -> 7577
    //   7565: iload_3
    //   7566: istore 5
    //   7568: ldc 85
    //   7570: iconst_2
    //   7571: ldc_w 1110
    //   7574: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7577: iload_3
    //   7578: istore 5
    //   7580: aload_0
    //   7581: iconst_2
    //   7582: invokevirtual 1114	aquz:setStatus	(I)V
    //   7585: iload_3
    //   7586: istore 5
    //   7588: aload_0
    //   7589: invokevirtual 1117	aquz:onCancel	()V
    //   7592: iload_3
    //   7593: istore 5
    //   7595: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7598: ifeq +15 -> 7613
    //   7601: iload_3
    //   7602: istore 5
    //   7604: ldc 85
    //   7606: iconst_2
    //   7607: ldc_w 1119
    //   7610: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7613: iload_3
    //   7614: istore 5
    //   7616: aload_0
    //   7617: invokevirtual 136	aquz:cCN	()V
    //   7620: iload_3
    //   7621: istore 4
    //   7623: goto -4980 -> 2643
    //   7626: iload_3
    //   7627: istore 5
    //   7629: aload_0
    //   7630: iload 4
    //   7632: invokevirtual 1114	aquz:setStatus	(I)V
    //   7635: goto -43 -> 7592
    //   7638: iconst_m1
    //   7639: istore 4
    //   7641: goto -15 -> 7626
    //   7644: astore_0
    //   7645: iconst_m1
    //   7646: istore_3
    //   7647: goto -5017 -> 2630
    //   7650: astore 32
    //   7652: goto -5606 -> 2046
    //   7655: astore_1
    //   7656: aload 35
    //   7658: astore 29
    //   7660: goto -5388 -> 2272
    //   7663: astore_1
    //   7664: aload 30
    //   7666: astore 33
    //   7668: goto -5396 -> 2272
    //   7671: astore_1
    //   7672: aload 33
    //   7674: astore 32
    //   7676: aload 30
    //   7678: astore 33
    //   7680: goto -5408 -> 2272
    //   7683: astore_1
    //   7684: aload 32
    //   7686: astore 31
    //   7688: aload 33
    //   7690: astore 32
    //   7692: aload 30
    //   7694: astore 33
    //   7696: goto -5424 -> 2272
    //   7699: astore_1
    //   7700: aload 33
    //   7702: astore 32
    //   7704: aload 30
    //   7706: astore 33
    //   7708: goto -5436 -> 2272
    //   7711: astore_1
    //   7712: iconst_0
    //   7713: istore 6
    //   7715: aload 33
    //   7717: astore 32
    //   7719: aload 30
    //   7721: astore 33
    //   7723: goto -5451 -> 2272
    //   7726: astore_1
    //   7727: aload 33
    //   7729: astore 32
    //   7731: aload 30
    //   7733: astore 33
    //   7735: goto -5463 -> 2272
    //   7738: astore 29
    //   7740: aload 33
    //   7742: astore 35
    //   7744: iconst_0
    //   7745: istore 14
    //   7747: aload 32
    //   7749: astore 30
    //   7751: iload 6
    //   7753: istore 8
    //   7755: aload 29
    //   7757: astore 33
    //   7759: aload 34
    //   7761: astore 29
    //   7763: iload 7
    //   7765: istore 6
    //   7767: iload_3
    //   7768: istore 5
    //   7770: aload 35
    //   7772: astore 32
    //   7774: iload 8
    //   7776: istore_3
    //   7777: goto -6823 -> 954
    //   7780: astore 30
    //   7782: iconst_1
    //   7783: istore 8
    //   7785: aload 33
    //   7787: astore 34
    //   7789: iconst_0
    //   7790: istore 14
    //   7792: aload 30
    //   7794: astore 33
    //   7796: iload 5
    //   7798: istore 4
    //   7800: aload 32
    //   7802: astore 30
    //   7804: iload 6
    //   7806: istore 7
    //   7808: iload 8
    //   7810: istore 6
    //   7812: iload_3
    //   7813: istore 5
    //   7815: aload 34
    //   7817: astore 32
    //   7819: iload 7
    //   7821: istore_3
    //   7822: goto -6868 -> 954
    //   7825: astore 35
    //   7827: iload_3
    //   7828: istore 7
    //   7830: iload 4
    //   7832: istore_3
    //   7833: iconst_0
    //   7834: istore 14
    //   7836: aload 33
    //   7838: astore 34
    //   7840: iload 5
    //   7842: istore 4
    //   7844: aload 32
    //   7846: astore 30
    //   7848: iload 6
    //   7850: istore 8
    //   7852: aload 35
    //   7854: astore 33
    //   7856: iload 7
    //   7858: istore 6
    //   7860: iload_3
    //   7861: istore 5
    //   7863: aload 34
    //   7865: astore 32
    //   7867: iload 8
    //   7869: istore_3
    //   7870: goto -6916 -> 954
    //   7873: astore 33
    //   7875: iconst_1
    //   7876: istore 14
    //   7878: iload 4
    //   7880: istore 7
    //   7882: aload 30
    //   7884: astore 34
    //   7886: iload 6
    //   7888: istore 8
    //   7890: iload_3
    //   7891: istore 6
    //   7893: iload 5
    //   7895: istore 4
    //   7897: iload 7
    //   7899: istore 5
    //   7901: aload 32
    //   7903: astore 30
    //   7905: aload 34
    //   7907: astore 32
    //   7909: iload 8
    //   7911: istore_3
    //   7912: goto -6958 -> 954
    //   7915: astore 33
    //   7917: iload 6
    //   7919: istore 8
    //   7921: iload 4
    //   7923: istore 5
    //   7925: aload 30
    //   7927: astore 34
    //   7929: iconst_1
    //   7930: istore 14
    //   7932: iload 7
    //   7934: istore 4
    //   7936: lload 21
    //   7938: lstore 17
    //   7940: iload_3
    //   7941: istore 6
    //   7943: aload 32
    //   7945: astore 30
    //   7947: aload 34
    //   7949: astore 32
    //   7951: iload 8
    //   7953: istore_3
    //   7954: goto -7000 -> 954
    //   7957: astore 35
    //   7959: aload 33
    //   7961: astore 32
    //   7963: iload 6
    //   7965: istore 7
    //   7967: iload 4
    //   7969: istore 8
    //   7971: aload 30
    //   7973: astore 34
    //   7975: iconst_1
    //   7976: istore 14
    //   7978: iload 5
    //   7980: istore 4
    //   7982: aload 35
    //   7984: astore 33
    //   7986: iload_3
    //   7987: istore 6
    //   7989: iload 8
    //   7991: istore 5
    //   7993: aload 32
    //   7995: astore 30
    //   7997: aload 34
    //   7999: astore 32
    //   8001: iload 7
    //   8003: istore_3
    //   8004: goto -7050 -> 954
    //   8007: astore 35
    //   8009: aload 33
    //   8011: astore 31
    //   8013: iload 6
    //   8015: istore 7
    //   8017: iload 4
    //   8019: istore 8
    //   8021: aload 30
    //   8023: astore 34
    //   8025: iload 5
    //   8027: istore 4
    //   8029: iconst_1
    //   8030: istore 14
    //   8032: aload 35
    //   8034: astore 33
    //   8036: iload_3
    //   8037: istore 6
    //   8039: iload 8
    //   8041: istore 5
    //   8043: aload 31
    //   8045: astore 30
    //   8047: aload 32
    //   8049: astore 31
    //   8051: aload 34
    //   8053: astore 32
    //   8055: iload 7
    //   8057: istore_3
    //   8058: goto -7104 -> 954
    //   8061: astore 35
    //   8063: aload 33
    //   8065: astore 32
    //   8067: iload 6
    //   8069: istore 7
    //   8071: iload 4
    //   8073: istore 8
    //   8075: aload 30
    //   8077: astore 34
    //   8079: iconst_1
    //   8080: istore 14
    //   8082: iload 5
    //   8084: istore 4
    //   8086: aload 35
    //   8088: astore 33
    //   8090: iload_3
    //   8091: istore 6
    //   8093: iload 8
    //   8095: istore 5
    //   8097: aload 32
    //   8099: astore 30
    //   8101: aload 34
    //   8103: astore 32
    //   8105: iload 7
    //   8107: istore_3
    //   8108: goto -7154 -> 954
    //   8111: astore 35
    //   8113: lload 21
    //   8115: lstore 19
    //   8117: aload 33
    //   8119: astore 32
    //   8121: iload 6
    //   8123: istore 7
    //   8125: iload 4
    //   8127: istore 8
    //   8129: aload 30
    //   8131: astore 34
    //   8133: iconst_1
    //   8134: istore 14
    //   8136: iload 5
    //   8138: istore 4
    //   8140: aload 35
    //   8142: astore 33
    //   8144: iload_3
    //   8145: istore 6
    //   8147: iload 8
    //   8149: istore 5
    //   8151: aload 32
    //   8153: astore 30
    //   8155: aload 34
    //   8157: astore 32
    //   8159: iload 7
    //   8161: istore_3
    //   8162: goto -7208 -> 954
    //   8165: astore 34
    //   8167: aload 33
    //   8169: astore 32
    //   8171: iload 6
    //   8173: istore 7
    //   8175: iconst_1
    //   8176: istore 8
    //   8178: iconst_1
    //   8179: istore 14
    //   8181: aload 34
    //   8183: astore 33
    //   8185: iload 4
    //   8187: istore 5
    //   8189: aload 30
    //   8191: astore 34
    //   8193: iload_3
    //   8194: istore 6
    //   8196: iload 8
    //   8198: istore 4
    //   8200: aload 32
    //   8202: astore 30
    //   8204: aload 34
    //   8206: astore 32
    //   8208: iload 7
    //   8210: istore_3
    //   8211: goto -7257 -> 954
    //   8214: iload 4
    //   8216: istore_3
    //   8217: goto -721 -> 7496
    //   8220: iload 9
    //   8222: istore 4
    //   8224: goto -6168 -> 2056
    //   8227: aload 37
    //   8229: astore 34
    //   8231: goto -6677 -> 1554
    //   8234: goto -3321 -> 4913
    //   8237: iload 7
    //   8239: istore 4
    //   8241: goto -4390 -> 3851
    //   8244: iload_3
    //   8245: istore 4
    //   8247: iload 7
    //   8249: istore_3
    //   8250: goto -4389 -> 3861
    //   8253: iload 8
    //   8255: istore 5
    //   8257: goto -5244 -> 3013
    //   8260: aload 32
    //   8262: astore 33
    //   8264: iload_3
    //   8265: istore 8
    //   8267: iload 4
    //   8269: istore_3
    //   8270: lload 19
    //   8272: lstore 21
    //   8274: iload 6
    //   8276: istore 7
    //   8278: lload 17
    //   8280: lstore 19
    //   8282: lload 21
    //   8284: lstore 17
    //   8286: aload 30
    //   8288: astore 32
    //   8290: iload 8
    //   8292: istore 6
    //   8294: iload 5
    //   8296: istore 12
    //   8298: goto -7668 -> 630
    //   8301: iconst_m1
    //   8302: istore_3
    //   8303: iload_3
    //   8304: ireturn
    //   8305: iconst_m1
    //   8306: ireturn
    //   8307: ldc_w 913
    //   8310: astore 29
    //   8312: goto -8125 -> 187
    //   8315: iconst_1
    //   8316: istore 7
    //   8318: goto -7334 -> 984
    //   8321: iload_3
    //   8322: ifne -943 -> 7379
    //   8325: iconst_1
    //   8326: istore 15
    //   8328: goto -6572 -> 1756
    //   8331: astore_1
    //   8332: goto -6060 -> 2272
    //   8335: aload 34
    //   8337: astore 32
    //   8339: iload 8
    //   8341: bipush 12
    //   8343: if_icmple -3352 -> 4991
    //   8346: aload 34
    //   8348: astore 32
    //   8350: bipush 82
    //   8352: aload 44
    //   8354: iconst_0
    //   8355: baload
    //   8356: if_icmpne -3365 -> 4991
    //   8359: aload 34
    //   8361: astore 32
    //   8363: bipush 73
    //   8365: aload 44
    //   8367: iconst_1
    //   8368: baload
    //   8369: if_icmpne -3378 -> 4991
    //   8372: aload 34
    //   8374: astore 32
    //   8376: bipush 70
    //   8378: aload 44
    //   8380: iconst_2
    //   8381: baload
    //   8382: if_icmpne -3391 -> 4991
    //   8385: aload 34
    //   8387: astore 32
    //   8389: bipush 70
    //   8391: aload 44
    //   8393: iconst_3
    //   8394: baload
    //   8395: if_icmpne -3404 -> 4991
    //   8398: aload 34
    //   8400: astore 32
    //   8402: bipush 87
    //   8404: aload 44
    //   8406: bipush 8
    //   8408: baload
    //   8409: if_icmpne -3418 -> 4991
    //   8412: aload 34
    //   8414: astore 32
    //   8416: bipush 69
    //   8418: aload 44
    //   8420: bipush 9
    //   8422: baload
    //   8423: if_icmpne -3432 -> 4991
    //   8426: aload 34
    //   8428: astore 32
    //   8430: bipush 66
    //   8432: aload 44
    //   8434: bipush 10
    //   8436: baload
    //   8437: if_icmpne -3446 -> 4991
    //   8440: aload 34
    //   8442: astore 32
    //   8444: bipush 80
    //   8446: aload 44
    //   8448: bipush 11
    //   8450: baload
    //   8451: if_icmpne -3460 -> 4991
    //   8454: ldc_w 1121
    //   8457: astore 32
    //   8459: goto -3468 -> 4991
    //   8462: sipush 302
    //   8465: iload 8
    //   8467: if_icmpeq -1992 -> 6475
    //   8470: sipush 301
    //   8473: iload 8
    //   8475: if_icmpne -1910 -> 6565
    //   8478: goto -2003 -> 6475
    //   8481: astore 33
    //   8483: iconst_1
    //   8484: istore 14
    //   8486: iload 4
    //   8488: istore 5
    //   8490: lload 19
    //   8492: lstore 21
    //   8494: iload 6
    //   8496: istore 4
    //   8498: iload_3
    //   8499: istore 6
    //   8501: lload 17
    //   8503: lstore 19
    //   8505: lload 21
    //   8507: lstore 17
    //   8509: iload 7
    //   8511: istore_3
    //   8512: goto -7558 -> 954
    //   8515: astore_1
    //   8516: aload 32
    //   8518: astore 33
    //   8520: iload 7
    //   8522: istore 6
    //   8524: aload 30
    //   8526: astore 32
    //   8528: goto -6256 -> 2272
    //   8531: astore_0
    //   8532: iload 8
    //   8534: istore_3
    //   8535: goto -5905 -> 2630
    //   8538: ldc_w 1123
    //   8541: astore 33
    //   8543: goto -2516 -> 6027
    //   8546: ldc_w 1125
    //   8549: astore 33
    //   8551: goto -2494 -> 6057
    //   8554: astore_1
    //   8555: aload 32
    //   8557: astore 33
    //   8559: aload 30
    //   8561: astore 32
    //   8563: iload_3
    //   8564: istore 6
    //   8566: goto -6294 -> 2272
    //   8569: ldc_w 1123
    //   8572: astore 33
    //   8574: goto -7245 -> 1329
    //   8577: ldc_w 1125
    //   8580: astore 33
    //   8582: goto -7225 -> 1357
    //   8585: ldc_w 1123
    //   8588: astore_0
    //   8589: goto -6052 -> 2537
    //   8592: ldc_w 1125
    //   8595: astore_0
    //   8596: goto -6033 -> 2563
    //   8599: astore_0
    //   8600: iload 5
    //   8602: istore_3
    //   8603: goto -5973 -> 2630
    //   8606: iload_3
    //   8607: ifne -969 -> 7638
    //   8610: iconst_3
    //   8611: istore 4
    //   8613: goto -987 -> 7626
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8616	0	paramaquz	aquz
    //   0	8616	1	paramString	String
    //   0	8616	2	paramContext	Context
    //   16	8591	3	i	int
    //   63	8549	4	j	int
    //   70	8531	5	k	int
    //   613	7952	6	m	int
    //   607	7914	7	n	int
    //   307	8226	8	i1	int
    //   281	7940	9	i2	int
    //   298	5518	10	i3	int
    //   301	4817	11	i4	int
    //   610	7687	12	i5	int
    //   701	5815	13	i6	int
    //   284	8201	14	bool1	boolean
    //   1475	6852	15	bool2	boolean
    //   1775	3	16	bool3	boolean
    //   353	8155	17	l1	long
    //   616	7888	19	l2	long
    //   1425	7081	21	l3	long
    //   4370	1005	23	l4	long
    //   337	1697	25	l5	long
    //   637	5227	27	l6	long
    //   185	7474	29	localObject1	Object
    //   7738	18	29	localThrowable1	java.lang.Throwable
    //   7761	550	29	localObject2	Object
    //   203	7547	30	localObject3	Object
    //   7780	13	30	localThrowable2	java.lang.Throwable
    //   7802	758	30	localObject4	Object
    //   200	7850	31	localObject5	Object
    //   554	6814	32	localObject6	Object
    //   7650	1	32	localThrowable3	java.lang.Throwable
    //   7674	888	32	localObject7	Object
    //   386	4062	33	localObject8	Object
    //   4644	1	33	localThrowable4	java.lang.Throwable
    //   4792	1914	33	localObject9	Object
    //   6712	1	33	localInterruptedException	java.lang.InterruptedException
    //   6744	10	33	localObject10	Object
    //   6884	971	33	localObject11	Object
    //   7873	1	33	localThrowable5	java.lang.Throwable
    //   7915	45	33	localThrowable6	java.lang.Throwable
    //   7984	279	33	localObject12	Object
    //   8481	1	33	localThrowable7	java.lang.Throwable
    //   8518	63	33	localObject13	Object
    //   478	354	34	localObject14	Object
    //   915	36	34	localThrowable8	java.lang.Throwable
    //   1311	2926	34	localObject15	Object
    //   4250	22	34	localThrowable9	java.lang.Throwable
    //   4432	1630	34	localObject16	Object
    //   6147	30	34	localException	java.lang.Exception
    //   6193	10	34	localThrowable10	java.lang.Throwable
    //   6212	21	34	localObject17	Object
    //   6290	17	34	localThrowable11	java.lang.Throwable
    //   6316	103	34	localObject18	Object
    //   6925	23	34	localIOException1	java.io.IOException
    //   7124	636	34	localIOException2	java.io.IOException
    //   7787	369	34	localObject19	Object
    //   8165	17	34	localThrowable12	java.lang.Throwable
    //   8191	250	34	localObject20	Object
    //   705	2355	35	localObject21	Object
    //   3122	22	35	localThrowable13	java.lang.Throwable
    //   3166	2558	35	localObject22	Object
    //   6378	1279	35	localThrowable14	java.lang.Throwable
    //   7742	29	35	localObject23	Object
    //   7825	28	35	localThrowable15	java.lang.Throwable
    //   7957	26	35	localThrowable16	java.lang.Throwable
    //   8007	26	35	localThrowable17	java.lang.Throwable
    //   8061	26	35	localThrowable18	java.lang.Throwable
    //   8111	30	35	localThrowable19	java.lang.Throwable
    //   550	6083	36	localFile1	java.io.File
    //   366	7862	37	localHashMap	java.util.HashMap
    //   474	5505	38	localFile2	java.io.File
    //   600	6631	39	localafka	afka
    //   141	3758	40	localBasicHttpParams	org.apache.http.params.BasicHttpParams
    //   350	6397	41	localObject24	Object
    //   494	1612	42	localFile3	java.io.File
    //   692	5583	43	localStringBuilder	java.lang.StringBuilder
    //   2198	6249	44	localObject25	Object
    //   3069	34	45	str1	String
    //   3083	31	46	str2	String
    // Exception table:
    //   from	to	target	type
    //   851	892	915	java/lang/Throwable
    //   904	915	915	java/lang/Throwable
    //   2239	2248	915	java/lang/Throwable
    //   2260	2271	915	java/lang/Throwable
    //   851	892	2271	finally
    //   904	915	2271	finally
    //   2239	2248	2271	finally
    //   2260	2271	2271	finally
    //   634	639	2626	java/lang/Throwable
    //   643	694	2626	java/lang/Throwable
    //   1533	1537	2626	java/lang/Throwable
    //   1545	1554	2626	java/lang/Throwable
    //   1557	1568	2626	java/lang/Throwable
    //   1571	1587	2626	java/lang/Throwable
    //   1590	1606	2626	java/lang/Throwable
    //   1609	1623	2626	java/lang/Throwable
    //   1626	1640	2626	java/lang/Throwable
    //   1643	1664	2626	java/lang/Throwable
    //   1667	1680	2626	java/lang/Throwable
    //   1683	1697	2626	java/lang/Throwable
    //   1700	1711	2626	java/lang/Throwable
    //   1718	1728	2626	java/lang/Throwable
    //   1731	1744	2626	java/lang/Throwable
    //   1747	1753	2626	java/lang/Throwable
    //   1759	1764	2626	java/lang/Throwable
    //   1771	1777	2626	java/lang/Throwable
    //   2276	2315	2626	java/lang/Throwable
    //   2319	2327	2626	java/lang/Throwable
    //   2336	2388	2626	java/lang/Throwable
    //   2397	2404	2626	java/lang/Throwable
    //   2408	2415	2626	java/lang/Throwable
    //   2419	2427	2626	java/lang/Throwable
    //   2431	2442	2626	java/lang/Throwable
    //   2446	2481	2626	java/lang/Throwable
    //   2485	2500	2626	java/lang/Throwable
    //   2504	2509	2626	java/lang/Throwable
    //   2513	2521	2626	java/lang/Throwable
    //   2525	2533	2626	java/lang/Throwable
    //   2541	2547	2626	java/lang/Throwable
    //   2551	2559	2626	java/lang/Throwable
    //   2567	2576	2626	java/lang/Throwable
    //   2585	2592	2626	java/lang/Throwable
    //   2601	2606	2626	java/lang/Throwable
    //   2615	2620	2626	java/lang/Throwable
    //   2624	2626	2626	java/lang/Throwable
    //   7209	7214	2626	java/lang/Throwable
    //   7223	7238	2626	java/lang/Throwable
    //   7245	7250	2626	java/lang/Throwable
    //   7258	7298	2626	java/lang/Throwable
    //   7388	7394	2626	java/lang/Throwable
    //   3013	3030	3122	java/lang/Throwable
    //   3035	3049	3122	java/lang/Throwable
    //   3049	3119	3122	java/lang/Throwable
    //   3207	3252	3122	java/lang/Throwable
    //   3252	3410	3122	java/lang/Throwable
    //   3415	3492	3122	java/lang/Throwable
    //   3492	3506	3122	java/lang/Throwable
    //   3511	3534	3122	java/lang/Throwable
    //   3541	3615	3122	java/lang/Throwable
    //   3615	3723	3122	java/lang/Throwable
    //   3723	3756	3122	java/lang/Throwable
    //   3756	3781	3122	java/lang/Throwable
    //   3791	3813	3122	java/lang/Throwable
    //   4288	4303	3122	java/lang/Throwable
    //   4306	4313	3122	java/lang/Throwable
    //   3937	3951	4250	java/lang/Throwable
    //   3955	3961	4250	java/lang/Throwable
    //   3965	3972	4250	java/lang/Throwable
    //   3976	4010	4250	java/lang/Throwable
    //   4014	4023	4250	java/lang/Throwable
    //   4027	4037	4250	java/lang/Throwable
    //   4041	4050	4250	java/lang/Throwable
    //   4054	4063	4250	java/lang/Throwable
    //   4067	4078	4250	java/lang/Throwable
    //   4082	4093	4250	java/lang/Throwable
    //   4097	4108	4250	java/lang/Throwable
    //   4112	4123	4250	java/lang/Throwable
    //   4127	4138	4250	java/lang/Throwable
    //   4142	4153	4250	java/lang/Throwable
    //   4157	4168	4250	java/lang/Throwable
    //   4172	4183	4250	java/lang/Throwable
    //   4187	4198	4250	java/lang/Throwable
    //   4202	4213	4250	java/lang/Throwable
    //   4217	4247	4250	java/lang/Throwable
    //   4354	4363	4250	java/lang/Throwable
    //   6442	6448	4250	java/lang/Throwable
    //   6479	6486	4250	java/lang/Throwable
    //   6496	6503	4250	java/lang/Throwable
    //   6532	6538	4250	java/lang/Throwable
    //   6577	6582	4250	java/lang/Throwable
    //   6620	6628	4250	java/lang/Throwable
    //   6632	6638	4250	java/lang/Throwable
    //   6642	6648	4250	java/lang/Throwable
    //   6679	6685	4250	java/lang/Throwable
    //   4605	4621	4644	java/lang/Throwable
    //   4633	4644	4644	java/lang/Throwable
    //   4774	4785	4644	java/lang/Throwable
    //   4605	4621	4785	finally
    //   4633	4644	4785	finally
    //   4774	4785	4785	finally
    //   5477	5590	6147	java/lang/Exception
    //   5391	5405	6193	java/lang/Throwable
    //   5405	5472	6193	java/lang/Throwable
    //   5477	5590	6193	java/lang/Throwable
    //   6149	6190	6193	java/lang/Throwable
    //   6274	6283	6290	java/lang/Throwable
    //   6357	6363	6378	java/lang/Throwable
    //   6367	6378	6378	java/lang/Throwable
    //   5695	5702	6712	java/lang/InterruptedException
    //   5695	5702	6744	finally
    //   5702	5705	6744	finally
    //   6714	6741	6744	finally
    //   6746	6749	6744	finally
    //   6088	6095	6925	java/io/IOException
    //   6104	6109	6925	java/io/IOException
    //   6118	6123	6925	java/io/IOException
    //   1386	1393	7124	java/io/IOException
    //   1401	1406	7124	java/io/IOException
    //   1414	1419	7124	java/io/IOException
    //   2585	2592	7253	java/io/IOException
    //   2601	2606	7253	java/io/IOException
    //   2615	2620	7253	java/io/IOException
    //   83	131	7644	java/lang/Throwable
    //   134	183	7644	java/lang/Throwable
    //   187	199	7644	java/lang/Throwable
    //   209	228	7644	java/lang/Throwable
    //   228	269	7644	java/lang/Throwable
    //   272	283	7644	java/lang/Throwable
    //   286	291	7644	java/lang/Throwable
    //   1782	1873	7650	java/lang/Throwable
    //   1878	1949	7650	java/lang/Throwable
    //   1958	1968	7650	java/lang/Throwable
    //   1972	1985	7650	java/lang/Throwable
    //   1990	2022	7650	java/lang/Throwable
    //   2022	2046	7650	java/lang/Throwable
    //   715	720	7655	finally
    //   740	748	7655	finally
    //   760	767	7655	finally
    //   789	795	7655	finally
    //   807	815	7655	finally
    //   833	839	7655	finally
    //   2151	2157	7655	finally
    //   2169	2183	7655	finally
    //   2195	2200	7655	finally
    //   2221	2227	7655	finally
    //   2698	2705	7655	finally
    //   2721	2732	7655	finally
    //   2744	2764	7655	finally
    //   2776	2784	7655	finally
    //   2796	2824	7655	finally
    //   2836	2843	7655	finally
    //   2855	2861	7655	finally
    //   2873	2900	7655	finally
    //   2912	2922	7655	finally
    //   2939	2946	7655	finally
    //   2958	2969	7655	finally
    //   2981	2986	7655	finally
    //   3000	3013	7655	finally
    //   3176	3204	7655	finally
    //   4363	4372	7663	finally
    //   4380	4394	7663	finally
    //   4402	4414	7663	finally
    //   4422	4434	7663	finally
    //   4447	4468	7663	finally
    //   4476	4483	7663	finally
    //   4491	4516	7663	finally
    //   4524	4531	7663	finally
    //   4546	4555	7663	finally
    //   4563	4573	7663	finally
    //   4587	4593	7663	finally
    //   4703	4716	7663	finally
    //   4742	4748	7663	finally
    //   4760	4766	7663	finally
    //   4815	4835	7663	finally
    //   4835	4887	7671	finally
    //   5142	5151	7671	finally
    //   4887	4896	7683	finally
    //   4900	4910	7699	finally
    //   4917	4924	7699	finally
    //   4928	4937	7699	finally
    //   4947	4953	7699	finally
    //   5000	5014	7699	finally
    //   5018	5028	7699	finally
    //   5062	5071	7699	finally
    //   5075	5085	7699	finally
    //   5089	5100	7699	finally
    //   5112	5122	7699	finally
    //   5126	5130	7699	finally
    //   5251	5256	7699	finally
    //   5260	5268	7699	finally
    //   5272	5279	7699	finally
    //   5283	5297	7699	finally
    //   5316	5323	7699	finally
    //   5334	5347	7699	finally
    //   5351	5374	7699	finally
    //   5386	5391	7699	finally
    //   6246	6252	7699	finally
    //   6264	6270	7699	finally
    //   6347	6353	7699	finally
    //   5391	5405	7711	finally
    //   5405	5472	7711	finally
    //   5477	5590	7711	finally
    //   6149	6190	7711	finally
    //   6274	6283	7726	finally
    //   6357	6363	7726	finally
    //   6367	6378	7726	finally
    //   715	720	7738	java/lang/Throwable
    //   740	748	7738	java/lang/Throwable
    //   760	767	7738	java/lang/Throwable
    //   789	795	7738	java/lang/Throwable
    //   807	815	7738	java/lang/Throwable
    //   833	839	7738	java/lang/Throwable
    //   2151	2157	7738	java/lang/Throwable
    //   2169	2183	7738	java/lang/Throwable
    //   2195	2200	7738	java/lang/Throwable
    //   2221	2227	7738	java/lang/Throwable
    //   2698	2705	7738	java/lang/Throwable
    //   2721	2732	7738	java/lang/Throwable
    //   2744	2764	7738	java/lang/Throwable
    //   2776	2784	7738	java/lang/Throwable
    //   2796	2824	7738	java/lang/Throwable
    //   2836	2843	7738	java/lang/Throwable
    //   2855	2861	7738	java/lang/Throwable
    //   2873	2900	7738	java/lang/Throwable
    //   2912	2922	7738	java/lang/Throwable
    //   2939	2946	7738	java/lang/Throwable
    //   2958	2969	7738	java/lang/Throwable
    //   2981	2986	7738	java/lang/Throwable
    //   3000	3013	7738	java/lang/Throwable
    //   3176	3204	7738	java/lang/Throwable
    //   3816	3851	7780	java/lang/Throwable
    //   3861	3883	7825	java/lang/Throwable
    //   3883	3910	7825	java/lang/Throwable
    //   3914	3933	7825	java/lang/Throwable
    //   4363	4372	7873	java/lang/Throwable
    //   4380	4394	7915	java/lang/Throwable
    //   4402	4414	7915	java/lang/Throwable
    //   4422	4434	7915	java/lang/Throwable
    //   4447	4468	7915	java/lang/Throwable
    //   4476	4483	7915	java/lang/Throwable
    //   4491	4516	7915	java/lang/Throwable
    //   4524	4531	7915	java/lang/Throwable
    //   4546	4555	7915	java/lang/Throwable
    //   4563	4573	7915	java/lang/Throwable
    //   4587	4593	7915	java/lang/Throwable
    //   4703	4716	7915	java/lang/Throwable
    //   4742	4748	7915	java/lang/Throwable
    //   4760	4766	7915	java/lang/Throwable
    //   4815	4835	7915	java/lang/Throwable
    //   4835	4887	7957	java/lang/Throwable
    //   5142	5151	7957	java/lang/Throwable
    //   4887	4896	8007	java/lang/Throwable
    //   4900	4910	8061	java/lang/Throwable
    //   4917	4924	8111	java/lang/Throwable
    //   4928	4937	8111	java/lang/Throwable
    //   4947	4953	8111	java/lang/Throwable
    //   5000	5014	8111	java/lang/Throwable
    //   5018	5028	8111	java/lang/Throwable
    //   5062	5071	8111	java/lang/Throwable
    //   5075	5085	8111	java/lang/Throwable
    //   5089	5100	8111	java/lang/Throwable
    //   5112	5122	8111	java/lang/Throwable
    //   5126	5130	8111	java/lang/Throwable
    //   5251	5256	8111	java/lang/Throwable
    //   5260	5268	8111	java/lang/Throwable
    //   5272	5279	8111	java/lang/Throwable
    //   5283	5297	8111	java/lang/Throwable
    //   5316	5323	8111	java/lang/Throwable
    //   5334	5347	8111	java/lang/Throwable
    //   5351	5374	8111	java/lang/Throwable
    //   5386	5391	8111	java/lang/Throwable
    //   6246	6252	8111	java/lang/Throwable
    //   6347	6353	8111	java/lang/Throwable
    //   6264	6270	8165	java/lang/Throwable
    //   3013	3030	8331	finally
    //   3035	3049	8331	finally
    //   3049	3119	8331	finally
    //   3207	3252	8331	finally
    //   3252	3410	8331	finally
    //   3415	3492	8331	finally
    //   3492	3506	8331	finally
    //   3511	3534	8331	finally
    //   3541	3615	8331	finally
    //   3615	3723	8331	finally
    //   3723	3756	8331	finally
    //   3756	3781	8331	finally
    //   3791	3813	8331	finally
    //   3816	3851	8331	finally
    //   3861	3883	8331	finally
    //   3883	3910	8331	finally
    //   3914	3933	8331	finally
    //   3937	3951	8331	finally
    //   3955	3961	8331	finally
    //   3965	3972	8331	finally
    //   3976	4010	8331	finally
    //   4014	4023	8331	finally
    //   4027	4037	8331	finally
    //   4041	4050	8331	finally
    //   4054	4063	8331	finally
    //   4067	4078	8331	finally
    //   4082	4093	8331	finally
    //   4097	4108	8331	finally
    //   4112	4123	8331	finally
    //   4127	4138	8331	finally
    //   4142	4153	8331	finally
    //   4157	4168	8331	finally
    //   4172	4183	8331	finally
    //   4187	4198	8331	finally
    //   4202	4213	8331	finally
    //   4217	4247	8331	finally
    //   4288	4303	8331	finally
    //   4306	4313	8331	finally
    //   4354	4363	8331	finally
    //   6442	6448	8331	finally
    //   6479	6486	8331	finally
    //   6496	6503	8331	finally
    //   6532	6538	8331	finally
    //   6577	6582	8331	finally
    //   6620	6628	8331	finally
    //   6632	6638	8331	finally
    //   6642	6648	8331	finally
    //   6679	6685	8331	finally
    //   5633	5639	8481	java/lang/Throwable
    //   5643	5653	8481	java/lang/Throwable
    //   5662	5669	8481	java/lang/Throwable
    //   5673	5682	8481	java/lang/Throwable
    //   5686	5689	8481	java/lang/Throwable
    //   5709	5719	8481	java/lang/Throwable
    //   5723	5735	8481	java/lang/Throwable
    //   5744	5760	8481	java/lang/Throwable
    //   6753	6756	8481	java/lang/Throwable
    //   6760	6770	8481	java/lang/Throwable
    //   6774	6781	8481	java/lang/Throwable
    //   6785	6801	8481	java/lang/Throwable
    //   6804	6859	8481	java/lang/Throwable
    //   6863	6874	8481	java/lang/Throwable
    //   5633	5639	8515	finally
    //   5643	5653	8515	finally
    //   5662	5669	8515	finally
    //   5673	5682	8515	finally
    //   5686	5689	8515	finally
    //   5709	5719	8515	finally
    //   5723	5735	8515	finally
    //   5744	5760	8515	finally
    //   6753	6756	8515	finally
    //   6760	6770	8515	finally
    //   6774	6781	8515	finally
    //   6785	6801	8515	finally
    //   6804	6859	8515	finally
    //   6863	6874	8515	finally
    //   313	327	8531	java/lang/Throwable
    //   334	339	8531	java/lang/Throwable
    //   343	352	8531	java/lang/Throwable
    //   359	368	8531	java/lang/Throwable
    //   372	388	8531	java/lang/Throwable
    //   392	398	8531	java/lang/Throwable
    //   402	410	8531	java/lang/Throwable
    //   419	429	8531	java/lang/Throwable
    //   433	445	8531	java/lang/Throwable
    //   449	456	8531	java/lang/Throwable
    //   460	476	8531	java/lang/Throwable
    //   489	496	8531	java/lang/Throwable
    //   500	507	8531	java/lang/Throwable
    //   511	552	8531	java/lang/Throwable
    //   560	570	8531	java/lang/Throwable
    //   574	585	8531	java/lang/Throwable
    //   589	602	8531	java/lang/Throwable
    //   1078	1117	8531	java/lang/Throwable
    //   1120	1128	8531	java/lang/Throwable
    //   1136	1188	8531	java/lang/Throwable
    //   1195	1202	8531	java/lang/Throwable
    //   1205	1212	8531	java/lang/Throwable
    //   1215	1223	8531	java/lang/Throwable
    //   1226	1237	8531	java/lang/Throwable
    //   1240	1275	8531	java/lang/Throwable
    //   1278	1293	8531	java/lang/Throwable
    //   1296	1301	8531	java/lang/Throwable
    //   1304	1313	8531	java/lang/Throwable
    //   1316	1324	8531	java/lang/Throwable
    //   1332	1341	8531	java/lang/Throwable
    //   1344	1352	8531	java/lang/Throwable
    //   1360	1372	8531	java/lang/Throwable
    //   1386	1393	8531	java/lang/Throwable
    //   1401	1406	8531	java/lang/Throwable
    //   1414	1419	8531	java/lang/Throwable
    //   1459	1468	8531	java/lang/Throwable
    //   1471	1477	8531	java/lang/Throwable
    //   2101	2136	8531	java/lang/Throwable
    //   5764	5803	8531	java/lang/Throwable
    //   5807	5815	8531	java/lang/Throwable
    //   5824	5876	8531	java/lang/Throwable
    //   5885	5892	8531	java/lang/Throwable
    //   5896	5903	8531	java/lang/Throwable
    //   5907	5915	8531	java/lang/Throwable
    //   5919	5930	8531	java/lang/Throwable
    //   5934	5969	8531	java/lang/Throwable
    //   5973	5988	8531	java/lang/Throwable
    //   5992	5997	8531	java/lang/Throwable
    //   6001	6010	8531	java/lang/Throwable
    //   6014	6022	8531	java/lang/Throwable
    //   6031	6040	8531	java/lang/Throwable
    //   6044	6052	8531	java/lang/Throwable
    //   6061	6073	8531	java/lang/Throwable
    //   6088	6095	8531	java/lang/Throwable
    //   6104	6109	8531	java/lang/Throwable
    //   6118	6123	8531	java/lang/Throwable
    //   6881	6886	8531	java/lang/Throwable
    //   6895	6910	8531	java/lang/Throwable
    //   6917	6922	8531	java/lang/Throwable
    //   6931	6972	8531	java/lang/Throwable
    //   7082	7087	8531	java/lang/Throwable
    //   7095	7110	8531	java/lang/Throwable
    //   7116	7121	8531	java/lang/Throwable
    //   7129	7170	8531	java/lang/Throwable
    //   7305	7311	8531	java/lang/Throwable
    //   7315	7321	8531	java/lang/Throwable
    //   7325	7334	8531	java/lang/Throwable
    //   7412	7425	8531	java/lang/Throwable
    //   7429	7435	8531	java/lang/Throwable
    //   7439	7484	8531	java/lang/Throwable
    //   7488	7494	8531	java/lang/Throwable
    //   957	973	8554	finally
    //   973	981	8554	finally
    //   984	998	8554	finally
    //   998	1007	8554	finally
    //   1022	1027	8554	finally
    //   1027	1075	8554	finally
    //   6996	7010	8554	finally
    //   7013	7029	8554	finally
    //   7029	7035	8554	finally
    //   7038	7052	8554	finally
    //   7055	7068	8554	finally
    //   7071	7076	8554	finally
    //   72	76	8599	java/lang/Throwable
    //   79	83	8599	java/lang/Throwable
    //   7499	7506	8599	java/lang/Throwable
    //   7509	7516	8599	java/lang/Throwable
    //   7522	7528	8599	java/lang/Throwable
    //   7531	7540	8599	java/lang/Throwable
    //   7549	7556	8599	java/lang/Throwable
    //   7559	7565	8599	java/lang/Throwable
    //   7568	7577	8599	java/lang/Throwable
    //   7580	7585	8599	java/lang/Throwable
    //   7588	7592	8599	java/lang/Throwable
    //   7595	7601	8599	java/lang/Throwable
    //   7604	7613	8599	java/lang/Throwable
    //   7616	7620	8599	java/lang/Throwable
    //   7629	7635	8599	java/lang/Throwable
  }
  
  public static int a(aquz paramaquz, AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null)
    {
      if ((paramaquz.cWt) && (!aszy.cv(paramAppRuntime.getApplication()))) {
        QLog.e("AIOAudioPanel", 1, "sharpp load error");
      }
      return a(paramaquz, paramAppRuntime.getAccount(), paramAppRuntime.getApplication());
    }
    return a(paramaquz, null, null);
  }
  
  public static void a(afka paramafka)
  {
    if ((paramafka == null) || (TextUtils.isEmpty(paramafka.bDA))) {}
    do
    {
      String str1;
      String str2;
      do
      {
        return;
        str1 = aopd.getHostFromUrl(paramafka.bDA);
        if ((!ox.containsKey(str1)) || (!paramafka.bDA.startsWith("http"))) {
          break;
        }
        str2 = aopd.a().aC(str1, ((Integer)ox.get(str1)).intValue());
      } while (TextUtils.isEmpty(str2));
      String str3 = bJ(paramafka.bDA, str2);
      if (!TextUtils.isEmpty(str3))
      {
        paramafka.reqUrl = str3;
        paramafka.host = str1;
        paramafka.ip = str2;
        paramafka.bYr = true;
        return;
      }
      paramafka.reqUrl = paramafka.bDA;
      return;
      HttpDownloadUtil.a(paramafka);
    } while (!QLog.isColorLevel());
    QLog.d("DownloaderFactory", 2, "use new httpDNS. url: " + paramafka.bDA);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = Integer.toString(aqiw.getSystemNetwork(paramContext));
    if (paramString2 != null) {}
    for (;;)
    {
      anot.a(null, "P_CliOper", "VipDownload", "0", "VipDownload", "ip", 0, paramInt, "", paramContext, paramString2, paramString1);
      return;
      paramString2 = "unknow";
    }
  }
  
  public static boolean a(aquz paramaquz)
  {
    if (paramaquz == null) {
      return false;
    }
    if ((paramaquz.GP == null) || (paramaquz.ov == null) || (paramaquz.GP.size() < 1) || (paramaquz.ov.size() < 1) || (TextUtils.isEmpty(paramaquz.key))) {
      return false;
    }
    paramaquz = paramaquz.GP.iterator();
    while (paramaquz.hasNext())
    {
      String str = (String)paramaquz.next();
      if ((TextUtils.isEmpty(str)) || (!URLUtil.isNetworkUrl(str))) {
        return false;
      }
    }
    return true;
  }
  
  /* Error */
  public static boolean a(java.io.File paramFile1, java.io.File paramFile2, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iconst_0
    //   4: istore 7
    //   6: iconst_0
    //   7: istore 8
    //   9: iload 8
    //   11: istore 6
    //   13: aload_0
    //   14: ifnull +18 -> 32
    //   17: aload_0
    //   18: invokevirtual 314	java/io/File:exists	()Z
    //   21: istore 6
    //   23: iload 6
    //   25: ifne +13 -> 38
    //   28: iload 8
    //   30: istore 6
    //   32: ldc 2
    //   34: monitorexit
    //   35: iload 6
    //   37: ireturn
    //   38: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   41: lstore 13
    //   43: aload_1
    //   44: invokevirtual 314	java/io/File:exists	()Z
    //   47: ifeq +368 -> 415
    //   50: aload_1
    //   51: invokevirtual 1193	java/io/File:listFiles	()[Ljava/io/File;
    //   54: astore 15
    //   56: iconst_0
    //   57: istore_3
    //   58: iload_3
    //   59: aload 15
    //   61: arraylength
    //   62: if_icmpge +358 -> 420
    //   65: aload 15
    //   67: iload_3
    //   68: aaload
    //   69: astore 16
    //   71: aload 16
    //   73: invokevirtual 317	java/io/File:isDirectory	()Z
    //   76: ifeq +57 -> 133
    //   79: aload 16
    //   81: invokevirtual 1193	java/io/File:listFiles	()[Ljava/io/File;
    //   84: astore 17
    //   86: aload 17
    //   88: ifnull +535 -> 623
    //   91: aload 17
    //   93: arraylength
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: iload 5
    //   103: if_icmpge +21 -> 124
    //   106: aload 17
    //   108: iload 4
    //   110: aaload
    //   111: invokevirtual 320	java/io/File:delete	()Z
    //   114: pop
    //   115: iload 4
    //   117: iconst_1
    //   118: iadd
    //   119: istore 4
    //   121: goto -22 -> 99
    //   124: aload 16
    //   126: invokevirtual 320	java/io/File:delete	()Z
    //   129: pop
    //   130: goto +493 -> 623
    //   133: aload 15
    //   135: iload_3
    //   136: aaload
    //   137: invokevirtual 320	java/io/File:delete	()Z
    //   140: pop
    //   141: goto +482 -> 623
    //   144: astore 15
    //   146: ldc 85
    //   148: iconst_2
    //   149: new 138	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 1195
    //   159: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_1
    //   163: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   166: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: aload 15
    //   171: invokevirtual 1052	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 7
    //   185: istore_2
    //   186: invokestatic 1201	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   189: invokestatic 1204	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   192: if_acmpeq +158 -> 350
    //   195: aload_0
    //   196: invokevirtual 689	java/io/File:length	()J
    //   199: lstore 11
    //   201: aload_0
    //   202: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   205: invokestatic 1209	arwv:encodeFileHexStr	(Ljava/lang/String;)Ljava/lang/String;
    //   208: astore 17
    //   210: aconst_null
    //   211: astore 16
    //   213: lload 11
    //   215: ldc2_w 1210
    //   218: lcmp
    //   219: ifle +277 -> 496
    //   222: ldc2_w 1210
    //   225: lstore 9
    //   227: lload 9
    //   229: l2i
    //   230: newarray char
    //   232: astore 18
    //   234: new 1213	java/io/FileInputStream
    //   237: dup
    //   238: aload_0
    //   239: invokespecial 1216	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   242: astore_0
    //   243: new 1218	java/io/InputStreamReader
    //   246: dup
    //   247: aload_0
    //   248: ldc_w 1220
    //   251: invokespecial 1223	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   254: astore 15
    //   256: aload 15
    //   258: aload 18
    //   260: invokevirtual 1226	java/io/InputStreamReader:read	([C)I
    //   263: pop
    //   264: aload_0
    //   265: ifnull +7 -> 272
    //   268: aload_0
    //   269: invokevirtual 438	java/io/InputStream:close	()V
    //   272: aload 15
    //   274: ifnull +8 -> 282
    //   277: aload 15
    //   279: invokevirtual 1227	java/io/InputStreamReader:close	()V
    //   282: ldc 85
    //   284: iconst_2
    //   285: new 138	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   292: ldc_w 1195
    //   295: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: aload_1
    //   299: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   302: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: ldc_w 1229
    //   308: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: lload 11
    //   313: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   316: ldc_w 1231
    //   319: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: aload 17
    //   324: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: ldc_w 1233
    //   330: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload 18
    //   335: invokestatic 1236	java/lang/String:valueOf	([C)Ljava/lang/String;
    //   338: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   344: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: iload 7
    //   349: istore_2
    //   350: iload_2
    //   351: istore 6
    //   353: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq -324 -> 32
    //   359: ldc 85
    //   361: iconst_2
    //   362: new 138	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 1238
    //   372: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   378: lload 13
    //   380: lsub
    //   381: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   384: ldc_w 1240
    //   387: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_1
    //   391: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload_2
    //   404: istore 6
    //   406: goto -374 -> 32
    //   409: astore_0
    //   410: ldc 2
    //   412: monitorexit
    //   413: aload_0
    //   414: athrow
    //   415: aload_1
    //   416: invokevirtual 323	java/io/File:mkdirs	()Z
    //   419: pop
    //   420: aload_0
    //   421: new 138	java/lang/StringBuilder
    //   424: dup
    //   425: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   428: aload_1
    //   429: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   432: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: getstatic 1243	java/io/File:separatorChar	C
    //   438: invokevirtual 1246	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   441: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 1250	jqp:b	(Ljava/io/File;Ljava/lang/String;)V
    //   447: iload_2
    //   448: ifeq +8 -> 456
    //   451: aload_0
    //   452: invokevirtual 320	java/io/File:delete	()Z
    //   455: pop
    //   456: invokestatic 83	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   459: ifeq +32 -> 491
    //   462: ldc 85
    //   464: iconst_2
    //   465: new 138	java/lang/StringBuilder
    //   468: dup
    //   469: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   472: ldc_w 1252
    //   475: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: invokevirtual 328	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   482: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 91	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: iconst_1
    //   492: istore_2
    //   493: goto -143 -> 350
    //   496: lload 11
    //   498: lstore 9
    //   500: goto -273 -> 227
    //   503: astore_0
    //   504: aconst_null
    //   505: astore 15
    //   507: aconst_null
    //   508: astore_0
    //   509: aload 15
    //   511: ifnull +8 -> 519
    //   514: aload 15
    //   516: invokevirtual 438	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull -238 -> 282
    //   523: aload_0
    //   524: invokevirtual 1227	java/io/InputStreamReader:close	()V
    //   527: goto -245 -> 282
    //   530: astore_0
    //   531: goto -249 -> 282
    //   534: astore_1
    //   535: aconst_null
    //   536: astore_0
    //   537: aload 16
    //   539: astore 15
    //   541: aload_0
    //   542: ifnull +7 -> 549
    //   545: aload_0
    //   546: invokevirtual 438	java/io/InputStream:close	()V
    //   549: aload 15
    //   551: ifnull +8 -> 559
    //   554: aload 15
    //   556: invokevirtual 1227	java/io/InputStreamReader:close	()V
    //   559: aload_1
    //   560: athrow
    //   561: astore_0
    //   562: goto -290 -> 272
    //   565: astore_0
    //   566: goto -284 -> 282
    //   569: astore 15
    //   571: goto -52 -> 519
    //   574: astore_0
    //   575: goto -26 -> 549
    //   578: astore_0
    //   579: goto -20 -> 559
    //   582: astore_1
    //   583: aload 16
    //   585: astore 15
    //   587: goto -46 -> 541
    //   590: astore_1
    //   591: goto -50 -> 541
    //   594: astore 15
    //   596: aconst_null
    //   597: astore 16
    //   599: aload_0
    //   600: astore 15
    //   602: aload 16
    //   604: astore_0
    //   605: goto -96 -> 509
    //   608: astore 16
    //   610: aload_0
    //   611: astore 16
    //   613: aload 15
    //   615: astore_0
    //   616: aload 16
    //   618: astore 15
    //   620: goto -111 -> 509
    //   623: iload_3
    //   624: iconst_1
    //   625: iadd
    //   626: istore_3
    //   627: goto -569 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	630	0	paramFile1	java.io.File
    //   0	630	1	paramFile2	java.io.File
    //   0	630	2	paramBoolean	boolean
    //   57	570	3	i	int
    //   97	23	4	j	int
    //   94	10	5	k	int
    //   11	394	6	bool1	boolean
    //   4	344	7	bool2	boolean
    //   7	22	8	bool3	boolean
    //   225	274	9	l1	long
    //   199	298	11	l2	long
    //   41	338	13	l3	long
    //   54	80	15	arrayOfFile	java.io.File[]
    //   144	26	15	localException1	java.lang.Exception
    //   254	301	15	localObject1	Object
    //   569	1	15	localException2	java.lang.Exception
    //   585	1	15	localObject2	Object
    //   594	1	15	localException3	java.lang.Exception
    //   600	19	15	localObject3	Object
    //   69	534	16	localFile1	java.io.File
    //   608	1	16	localException4	java.lang.Exception
    //   611	6	16	localFile2	java.io.File
    //   84	239	17	localObject4	Object
    //   232	102	18	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   43	56	144	java/lang/Exception
    //   58	65	144	java/lang/Exception
    //   71	86	144	java/lang/Exception
    //   91	96	144	java/lang/Exception
    //   106	115	144	java/lang/Exception
    //   124	130	144	java/lang/Exception
    //   133	141	144	java/lang/Exception
    //   415	420	144	java/lang/Exception
    //   420	447	144	java/lang/Exception
    //   451	456	144	java/lang/Exception
    //   456	491	144	java/lang/Exception
    //   17	23	409	finally
    //   38	43	409	finally
    //   43	56	409	finally
    //   58	65	409	finally
    //   71	86	409	finally
    //   91	96	409	finally
    //   106	115	409	finally
    //   124	130	409	finally
    //   133	141	409	finally
    //   146	183	409	finally
    //   186	210	409	finally
    //   227	234	409	finally
    //   268	272	409	finally
    //   277	282	409	finally
    //   282	347	409	finally
    //   353	403	409	finally
    //   415	420	409	finally
    //   420	447	409	finally
    //   451	456	409	finally
    //   456	491	409	finally
    //   514	519	409	finally
    //   523	527	409	finally
    //   545	549	409	finally
    //   554	559	409	finally
    //   559	561	409	finally
    //   234	243	503	java/lang/Exception
    //   523	527	530	java/lang/Exception
    //   234	243	534	finally
    //   268	272	561	java/lang/Exception
    //   277	282	565	java/lang/Exception
    //   514	519	569	java/lang/Exception
    //   545	549	574	java/lang/Exception
    //   554	559	578	java/lang/Exception
    //   243	256	582	finally
    //   256	264	590	finally
    //   243	256	594	java/lang/Exception
    //   256	264	608	java/lang/Exception
  }
  
  public static boolean aa(String paramString)
  {
    int i;
    if (D.containsKey(paramString)) {
      i = ((Integer)D.get(paramString)).intValue();
    }
    while (i > 0) {
      if ((int)(System.currentTimeMillis() / 1000L) < i + 600)
      {
        return true;
        i = 0;
      }
      else
      {
        D.remove(paramString);
        return false;
      }
    }
    return false;
  }
  
  private static String bJ(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      String str2 = "http://[^/\\s]*/";
      String str1 = "http://" + paramString2 + "/";
      if (paramString1.startsWith("https"))
      {
        str2 = "https://[^/\\s]*/";
        str1 = "https://" + paramString2 + "/";
      }
      return paramString1.replaceFirst(str2, str1);
    }
    return null;
  }
  
  public static boolean ci(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      int i = aqiw.getSystemNetwork(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("DownloaderFactory", 2, "isQualityNetwork type=" + i);
      }
      if ((i != 3) && (i != 4))
      {
        bool1 = bool2;
        if (i != 1) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean rH(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.indexOf('?') > -1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  /* Error */
  public aqvc a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: ifnull +251 -> 256
    //   8: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   11: astore_3
    //   12: aload_3
    //   13: monitorenter
    //   14: iload_1
    //   15: tableswitch	default:+25 -> 40, 1:+29->44, 2:+103->118, 3:+172->187
    //   41: monitorexit
    //   42: aload_2
    //   43: areturn
    //   44: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   47: iload_1
    //   48: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: invokevirtual 1254	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   54: ifeq +20 -> 74
    //   57: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   60: iload_1
    //   61: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   64: invokevirtual 1255	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   67: checkcast 1270	aqvc
    //   70: astore_2
    //   71: goto -31 -> 40
    //   74: new 8	aqva$a
    //   77: dup
    //   78: iconst_0
    //   79: invokespecial 1273	aqva$a:<init>	(Z)V
    //   82: astore_2
    //   83: new 1275	aqvm
    //   86: dup
    //   87: invokestatic 1278	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   90: invokevirtual 1282	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   93: aload_2
    //   94: invokespecial 1285	aqvm:<init>	(Lmqq/app/AppRuntime;Laqva$a;)V
    //   97: astore_2
    //   98: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   101: iload_1
    //   102: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: aload_2
    //   106: invokevirtual 1067	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   109: pop
    //   110: goto -70 -> 40
    //   113: astore_2
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   121: iload_1
    //   122: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: invokevirtual 1254	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   128: ifeq +20 -> 148
    //   131: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   134: iload_1
    //   135: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   138: invokevirtual 1255	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   141: checkcast 1270	aqvc
    //   144: astore_2
    //   145: goto -105 -> 40
    //   148: new 8	aqva$a
    //   151: dup
    //   152: iconst_0
    //   153: invokespecial 1273	aqva$a:<init>	(Z)V
    //   156: astore_2
    //   157: new 1275	aqvm
    //   160: dup
    //   161: invokestatic 1278	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   164: invokevirtual 1282	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   167: aload_2
    //   168: invokespecial 1285	aqvm:<init>	(Lmqq/app/AppRuntime;Laqva$a;)V
    //   171: astore_2
    //   172: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   175: iload_1
    //   176: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aload_2
    //   180: invokevirtual 1067	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: goto -144 -> 40
    //   187: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   190: iload_1
    //   191: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: invokevirtual 1254	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   197: ifeq +20 -> 217
    //   200: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   203: iload_1
    //   204: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   207: invokevirtual 1255	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   210: checkcast 1270	aqvc
    //   213: astore_2
    //   214: goto -174 -> 40
    //   217: new 8	aqva$a
    //   220: dup
    //   221: iconst_0
    //   222: invokespecial 1273	aqva$a:<init>	(Z)V
    //   225: astore_2
    //   226: new 1287	abhv
    //   229: dup
    //   230: invokestatic 1278	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   233: invokevirtual 1282	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   236: aload_2
    //   237: invokespecial 1288	abhv:<init>	(Lmqq/app/AppRuntime;Laqva$a;)V
    //   240: astore_2
    //   241: getstatic 52	aqva:C	Ljava/util/concurrent/ConcurrentHashMap;
    //   244: iload_1
    //   245: invokestatic 163	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aload_2
    //   249: invokevirtual 1067	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   252: pop
    //   253: goto -213 -> 40
    //   256: aconst_null
    //   257: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	this	aqva
    //   0	258	1	paramInt	int
    //   1	105	2	localObject1	Object
    //   113	4	2	localObject2	Object
    //   144	105	2	localObject3	Object
    //   11	104	3	localConcurrentHashMap	ConcurrentHashMap
    // Exception table:
    //   from	to	target	type
    //   40	42	113	finally
    //   44	71	113	finally
    //   74	110	113	finally
    //   114	116	113	finally
    //   118	145	113	finally
    //   148	184	113	finally
    //   187	214	113	finally
    //   217	253	113	finally
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DownloaderFactory", 2, "onDestroy...");
    }
    synchronized (D)
    {
      D.clear();
      synchronized (C)
      {
        Iterator localIterator = C.entrySet().iterator();
        if (localIterator.hasNext()) {
          ((aqvc)((Map.Entry)localIterator.next()).getValue()).onDestroy();
        }
      }
    }
    C.clear();
  }
  
  public static class a
  {
    public boolean eX;
    
    public a()
    {
      this.eX = false;
    }
    
    public a(boolean paramBoolean)
    {
      this.eX = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqva
 * JD-Core Version:    0.7.0.1
 */