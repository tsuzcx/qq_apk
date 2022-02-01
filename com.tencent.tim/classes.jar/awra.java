import android.content.Context;
import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.utils.NetworkUtils;
import cooperation.weiyun.upload.WyUploadJob;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

public class awra
  implements awqz
{
  private final awqz.a a;
  protected final UploadRequest a;
  protected final WyUploadJob a;
  public ArrayList<SoftReference<awra.a>> list = new ArrayList();
  private long mCurSize;
  protected final byte[] mFileHash;
  protected DefaultHttpClient mHttpClient;
  protected int mRewardThreshold = 4;
  protected int mSliceSize;
  protected int mSuccSliceTimes;
  protected int mTimeoutTimes;
  private long mTotalSize;
  protected final byte[] mUkey;
  
  public awra(UploadRequest paramUploadRequest, WyUploadJob paramWyUploadJob)
  {
    this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest = paramUploadRequest;
    this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob = paramWyUploadJob;
    this.mUkey = awrh.hexStringToByteArray(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.checkKey());
    this.mFileHash = awrh.hexStringToByteArray(this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.sha());
    this.mCurSize = 0L;
    this.mTotalSize = this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.size();
    this.jdField_a_of_type_Awqz$a = new awqz.a();
    try
    {
      this.jdField_a_of_type_Awqz$a.url = createUrl().toString();
      label99:
      this.jdField_a_of_type_Awqz$a.flowId = generateRandomId(new Object[] { this.jdField_a_of_type_Awqz$a.url, this });
      this.jdField_a_of_type_Awqz$a.startTime = SystemClock.uptimeMillis();
      return;
    }
    catch (MalformedURLException paramUploadRequest)
    {
      break label99;
    }
  }
  
  public static int generateRandomId(Object... paramVarArgs)
  {
    int i = 17;
    int k = i;
    if (paramVarArgs != null)
    {
      int m = paramVarArgs.length;
      int j = 0;
      k = i;
      if (j < m)
      {
        Object localObject = paramVarArgs[j];
        if (localObject == null) {}
        for (;;)
        {
          j += 1;
          break;
          i = i * 31 + localObject.hashCode();
        }
      }
    }
    return k * 31 + new Random().nextInt();
  }
  
  public static int getPacketSize(Context paramContext)
  {
    int i = NetworkUtils.getNetworkType(paramContext);
    if (i == 2) {
      return 32768;
    }
    if (i == 1) {
      return 16384;
    }
    if (i == 3) {
      return 65536;
    }
    return -1;
  }
  
  /* Error */
  int a(awqy paramawqy, URL paramURL, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	awra:a	()Lawra$a;
    //   4: astore 20
    //   6: aconst_null
    //   7: astore 17
    //   9: aload_0
    //   10: iconst_0
    //   11: putfield 140	awra:mTimeoutTimes	I
    //   14: iconst_0
    //   15: istore 10
    //   17: iconst_0
    //   18: istore 8
    //   20: iconst_0
    //   21: istore 12
    //   23: iconst_0
    //   24: istore 9
    //   26: iload 12
    //   28: iconst_3
    //   29: if_icmplt +22 -> 51
    //   32: iload 9
    //   34: istore 11
    //   36: iload 10
    //   38: ifeq +1175 -> 1213
    //   41: iload 9
    //   43: istore 11
    //   45: iload 8
    //   47: iconst_3
    //   48: if_icmpge +1165 -> 1213
    //   51: aload_0
    //   52: getfield 46	awra:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   55: invokevirtual 146	cooperation/weiyun/upload/WyUploadJob:isAlive	()Z
    //   58: ifne +26 -> 84
    //   61: ldc 147
    //   63: istore 4
    //   65: iload 4
    //   67: ifne +1082 -> 1149
    //   70: iconst_1
    //   71: istore 14
    //   73: aload_0
    //   74: aload 20
    //   76: iload 14
    //   78: invokevirtual 150	awra:a	(Lawra$a;Z)V
    //   81: iload 4
    //   83: ireturn
    //   84: iload 5
    //   86: sipush 8192
    //   89: if_icmple +1117 -> 1206
    //   92: iload 12
    //   94: i2d
    //   95: dstore 6
    //   97: iload 5
    //   99: ldc2_w 151
    //   102: dload 6
    //   104: invokestatic 158	java/lang/Math:pow	(DD)D
    //   107: d2i
    //   108: idiv
    //   109: sipush 8192
    //   112: invokestatic 162	java/lang/Math:max	(II)I
    //   115: istore 11
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 67	awra:mCurSize	J
    //   122: iload 11
    //   124: aload_3
    //   125: iconst_0
    //   126: iload 4
    //   128: invokevirtual 168	awqy:buildUploadRequestHead	(JI[BII)I
    //   131: istore 13
    //   133: aload_0
    //   134: aload_2
    //   135: invokevirtual 172	awra:configHttpClient	(Ljava/net/URL;)Lorg/apache/http/client/methods/HttpPost;
    //   138: astore 18
    //   140: aload 18
    //   142: new 174	awqx
    //   145: dup
    //   146: aload_3
    //   147: iconst_0
    //   148: iload 13
    //   150: iload 11
    //   152: iadd
    //   153: invokespecial 177	awqx:<init>	([BII)V
    //   156: invokevirtual 183	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   159: iconst_0
    //   160: istore 13
    //   162: aload_0
    //   163: getfield 185	awra:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   166: aload 18
    //   168: invokevirtual 191	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   171: astore 18
    //   173: aload 18
    //   175: astore 17
    //   177: aload 17
    //   179: ifnonnull +59 -> 238
    //   182: aload 17
    //   184: astore 18
    //   186: aload_0
    //   187: invokevirtual 194	awra:closeHttpClient	()V
    //   190: iload 9
    //   192: istore 10
    //   194: aload 17
    //   196: ifnull +1035 -> 1231
    //   199: iload 9
    //   201: istore 10
    //   203: aload 17
    //   205: invokeinterface 200 1 0
    //   210: ifnull +1021 -> 1231
    //   213: aload 17
    //   215: invokeinterface 200 1 0
    //   220: invokeinterface 205 1 0
    //   225: iload 13
    //   227: istore 10
    //   229: iload 12
    //   231: iconst_1
    //   232: iadd
    //   233: istore 12
    //   235: goto -209 -> 26
    //   238: aload 17
    //   240: astore 18
    //   242: aload 17
    //   244: invokeinterface 209 1 0
    //   249: invokeinterface 214 1 0
    //   254: istore 9
    //   256: iload 9
    //   258: sipush 200
    //   261: if_icmpeq +116 -> 377
    //   264: iload 9
    //   266: ldc 215
    //   268: iadd
    //   269: istore 10
    //   271: aload 17
    //   273: astore 18
    //   275: aload 17
    //   277: ldc 217
    //   279: invokeinterface 221 2 0
    //   284: astore 19
    //   286: iload 10
    //   288: istore 9
    //   290: aload 19
    //   292: ifnull +35 -> 327
    //   295: iload 10
    //   297: istore 9
    //   299: aload 17
    //   301: astore 18
    //   303: aload 19
    //   305: arraylength
    //   306: ifle +21 -> 327
    //   309: aload 17
    //   311: astore 18
    //   313: aload 19
    //   315: iconst_0
    //   316: aaload
    //   317: invokeinterface 226 1 0
    //   322: invokestatic 232	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   325: istore 9
    //   327: aload 17
    //   329: astore 18
    //   331: aload_0
    //   332: invokevirtual 194	awra:closeHttpClient	()V
    //   335: iload 9
    //   337: istore 10
    //   339: aload 17
    //   341: ifnull +890 -> 1231
    //   344: iload 9
    //   346: istore 10
    //   348: aload 17
    //   350: invokeinterface 200 1 0
    //   355: ifnull +876 -> 1231
    //   358: aload 17
    //   360: invokeinterface 200 1 0
    //   365: invokeinterface 205 1 0
    //   370: iload 13
    //   372: istore 10
    //   374: goto -145 -> 229
    //   377: aload 17
    //   379: astore 18
    //   381: new 234	java/io/BufferedInputStream
    //   384: dup
    //   385: aload 17
    //   387: invokeinterface 200 1 0
    //   392: invokeinterface 238 1 0
    //   397: invokespecial 241	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   400: aload 20
    //   402: getfield 244	awra$a:backingArray	[B
    //   405: invokevirtual 250	java/io/InputStream:read	([B)I
    //   408: istore 10
    //   410: iload 10
    //   412: ifgt +53 -> 465
    //   415: ldc 251
    //   417: istore 9
    //   419: iload 9
    //   421: istore 10
    //   423: aload 17
    //   425: ifnull +806 -> 1231
    //   428: iload 9
    //   430: istore 10
    //   432: aload 17
    //   434: invokeinterface 200 1 0
    //   439: ifnull +792 -> 1231
    //   442: aload 17
    //   444: invokeinterface 200 1 0
    //   449: invokeinterface 205 1 0
    //   454: ldc 251
    //   456: istore 9
    //   458: iload 13
    //   460: istore 10
    //   462: goto -233 -> 229
    //   465: iload 9
    //   467: sipush 200
    //   470: if_icmpne +177 -> 647
    //   473: iconst_1
    //   474: istore 14
    //   476: aload 17
    //   478: astore 18
    //   480: aload_1
    //   481: iload 14
    //   483: aload 20
    //   485: getfield 244	awra$a:backingArray	[B
    //   488: iload 10
    //   490: invokevirtual 255	awqy:parseUploadRsp	(Z[BI)I
    //   493: istore 9
    //   495: iload 9
    //   497: ifne +392 -> 889
    //   500: aload 17
    //   502: astore 18
    //   504: aload_0
    //   505: iconst_0
    //   506: putfield 140	awra:mTimeoutTimes	I
    //   509: aload 17
    //   511: astore 18
    //   513: aload_0
    //   514: iload 11
    //   516: putfield 257	awra:mSliceSize	I
    //   519: iload 12
    //   521: ifne +57 -> 578
    //   524: aload 17
    //   526: astore 18
    //   528: aload_0
    //   529: aload_0
    //   530: getfield 259	awra:mSuccSliceTimes	I
    //   533: iconst_1
    //   534: iadd
    //   535: putfield 259	awra:mSuccSliceTimes	I
    //   538: aload 17
    //   540: astore 18
    //   542: aload_0
    //   543: getfield 259	awra:mSuccSliceTimes	I
    //   546: aload_0
    //   547: getfield 37	awra:mRewardThreshold	I
    //   550: if_icmplt +28 -> 578
    //   553: aload 17
    //   555: astore 18
    //   557: aload_0
    //   558: aload_0
    //   559: getfield 257	awra:mSliceSize	I
    //   562: sipush 8192
    //   565: iadd
    //   566: putfield 257	awra:mSliceSize	I
    //   569: aload 17
    //   571: astore 18
    //   573: aload_0
    //   574: iconst_0
    //   575: putfield 259	awra:mSuccSliceTimes	I
    //   578: aload 17
    //   580: astore 18
    //   582: aload_0
    //   583: getfield 257	awra:mSliceSize	I
    //   586: sipush 8192
    //   589: if_icmpge +64 -> 653
    //   592: aload 17
    //   594: astore 18
    //   596: aload_0
    //   597: sipush 8192
    //   600: putfield 257	awra:mSliceSize	I
    //   603: iconst_0
    //   604: istore 4
    //   606: iload 4
    //   608: istore 11
    //   610: aload 17
    //   612: ifnull +601 -> 1213
    //   615: iload 4
    //   617: istore 11
    //   619: aload 17
    //   621: invokeinterface 200 1 0
    //   626: ifnull +587 -> 1213
    //   629: aload 17
    //   631: invokeinterface 200 1 0
    //   636: invokeinterface 205 1 0
    //   641: iconst_0
    //   642: istore 4
    //   644: goto -579 -> 65
    //   647: iconst_0
    //   648: istore 14
    //   650: goto -174 -> 476
    //   653: aload 17
    //   655: astore 18
    //   657: aload_0
    //   658: getfield 257	awra:mSliceSize	I
    //   661: ldc 126
    //   663: if_icmple -60 -> 603
    //   666: aload 17
    //   668: astore 18
    //   670: aload_0
    //   671: ldc 126
    //   673: putfield 257	awra:mSliceSize	I
    //   676: goto -73 -> 603
    //   679: astore 19
    //   681: iconst_0
    //   682: istore 10
    //   684: aload 17
    //   686: astore 18
    //   688: aload_0
    //   689: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   692: aload 19
    //   694: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   697: aload 17
    //   699: astore 18
    //   701: aload 19
    //   703: invokestatic 269	com/tencent/weiyun/transmission/utils/ErrorCodeUtil:getErrorCode4IOException	(Ljava/io/IOException;)I
    //   706: istore 13
    //   708: iload 10
    //   710: istore 11
    //   712: iload 13
    //   714: istore 9
    //   716: aload 17
    //   718: astore 18
    //   720: aload 17
    //   722: ifnull +49 -> 771
    //   725: iload 10
    //   727: istore 11
    //   729: iload 13
    //   731: istore 9
    //   733: aload 17
    //   735: astore 18
    //   737: aload 17
    //   739: invokeinterface 200 1 0
    //   744: ifnull +27 -> 771
    //   747: aload 17
    //   749: invokeinterface 200 1 0
    //   754: invokeinterface 205 1 0
    //   759: aload 17
    //   761: astore 18
    //   763: iload 13
    //   765: istore 9
    //   767: iload 10
    //   769: istore 11
    //   771: aload_0
    //   772: iconst_0
    //   773: putfield 259	awra:mSuccSliceTimes	I
    //   776: aload_0
    //   777: aload_0
    //   778: getfield 37	awra:mRewardThreshold	I
    //   781: i2d
    //   782: ldc2_w 270
    //   785: dmul
    //   786: d2i
    //   787: putfield 37	awra:mRewardThreshold	I
    //   790: iload 9
    //   792: ldc_w 272
    //   795: if_icmpne +305 -> 1100
    //   798: aload_0
    //   799: aload_0
    //   800: getfield 140	awra:mTimeoutTimes	I
    //   803: iconst_1
    //   804: iadd
    //   805: putfield 140	awra:mTimeoutTimes	I
    //   808: iload 9
    //   810: ldc_w 273
    //   813: if_icmpeq +59 -> 872
    //   816: iload 9
    //   818: ldc_w 272
    //   821: if_icmpeq +51 -> 872
    //   824: iload 9
    //   826: ldc_w 274
    //   829: if_icmpeq +43 -> 872
    //   832: iload 9
    //   834: ldc_w 275
    //   837: if_icmpeq +35 -> 872
    //   840: iload 9
    //   842: ldc_w 276
    //   845: if_icmpeq +27 -> 872
    //   848: iload 9
    //   850: ldc_w 277
    //   853: if_icmpeq +19 -> 872
    //   856: iload 9
    //   858: ldc_w 278
    //   861: if_icmpeq +11 -> 872
    //   864: iload 9
    //   866: ldc_w 279
    //   869: if_icmpne +351 -> 1220
    //   872: invokestatic 285	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   875: invokestatic 289	com/tencent/weiyun/utils/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   878: ifne +230 -> 1108
    //   881: ldc_w 290
    //   884: istore 4
    //   886: goto -821 -> 65
    //   889: ldc_w 291
    //   892: iload 9
    //   894: if_icmpne +45 -> 939
    //   897: iload 9
    //   899: istore 10
    //   901: aload 17
    //   903: ifnull +328 -> 1231
    //   906: iload 9
    //   908: istore 10
    //   910: aload 17
    //   912: invokeinterface 200 1 0
    //   917: ifnull +314 -> 1231
    //   920: aload 17
    //   922: invokeinterface 200 1 0
    //   927: invokeinterface 205 1 0
    //   932: iload 13
    //   934: istore 10
    //   936: goto -707 -> 229
    //   939: iload 9
    //   941: istore 11
    //   943: aload 17
    //   945: ifnull +268 -> 1213
    //   948: iload 9
    //   950: istore 11
    //   952: aload 17
    //   954: invokeinterface 200 1 0
    //   959: ifnull +254 -> 1213
    //   962: aload 17
    //   964: invokeinterface 200 1 0
    //   969: invokeinterface 205 1 0
    //   974: iload 9
    //   976: istore 4
    //   978: goto -913 -> 65
    //   981: astore 19
    //   983: iconst_0
    //   984: istore 10
    //   986: aload 17
    //   988: astore 18
    //   990: aload_0
    //   991: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   994: aload 19
    //   996: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   999: ldc_w 292
    //   1002: istore 13
    //   1004: iload 10
    //   1006: istore 11
    //   1008: iload 13
    //   1010: istore 9
    //   1012: aload 17
    //   1014: astore 18
    //   1016: aload 17
    //   1018: ifnull -247 -> 771
    //   1021: iload 10
    //   1023: istore 11
    //   1025: iload 13
    //   1027: istore 9
    //   1029: aload 17
    //   1031: astore 18
    //   1033: aload 17
    //   1035: invokeinterface 200 1 0
    //   1040: ifnull -269 -> 771
    //   1043: aload 17
    //   1045: invokeinterface 200 1 0
    //   1050: invokeinterface 205 1 0
    //   1055: iload 10
    //   1057: istore 11
    //   1059: iload 13
    //   1061: istore 9
    //   1063: aload 17
    //   1065: astore 18
    //   1067: goto -296 -> 771
    //   1070: astore_1
    //   1071: aload 18
    //   1073: ifnull +25 -> 1098
    //   1076: aload 18
    //   1078: invokeinterface 200 1 0
    //   1083: ifnull +15 -> 1098
    //   1086: aload 18
    //   1088: invokeinterface 200 1 0
    //   1093: invokeinterface 205 1 0
    //   1098: aload_1
    //   1099: athrow
    //   1100: aload_0
    //   1101: iconst_0
    //   1102: putfield 140	awra:mTimeoutTimes	I
    //   1105: goto -297 -> 808
    //   1108: iload 8
    //   1110: iconst_1
    //   1111: iadd
    //   1112: istore 8
    //   1114: ldc2_w 293
    //   1117: ldc2_w 151
    //   1120: iload 12
    //   1122: i2d
    //   1123: ldc2_w 295
    //   1126: invokestatic 158	java/lang/Math:pow	(DD)D
    //   1129: dadd
    //   1130: dmul
    //   1131: d2l
    //   1132: lstore 15
    //   1134: lload 15
    //   1136: invokestatic 302	java/lang/Thread:sleep	(J)V
    //   1139: aload 18
    //   1141: astore 17
    //   1143: iconst_1
    //   1144: istore 10
    //   1146: goto -917 -> 229
    //   1149: iconst_0
    //   1150: istore 14
    //   1152: goto -1079 -> 73
    //   1155: astore_1
    //   1156: iload 9
    //   1158: istore 4
    //   1160: goto -1095 -> 65
    //   1163: astore_1
    //   1164: aload 17
    //   1166: astore 18
    //   1168: goto -97 -> 1071
    //   1171: astore 19
    //   1173: goto -187 -> 986
    //   1176: astore 19
    //   1178: iconst_0
    //   1179: istore 10
    //   1181: goto -195 -> 986
    //   1184: astore 19
    //   1186: goto -502 -> 684
    //   1189: astore 19
    //   1191: iconst_0
    //   1192: istore 10
    //   1194: goto -510 -> 684
    //   1197: astore 18
    //   1199: iload 10
    //   1201: istore 9
    //   1203: goto -876 -> 327
    //   1206: iload 5
    //   1208: istore 11
    //   1210: goto -1093 -> 117
    //   1213: iload 11
    //   1215: istore 4
    //   1217: goto -1152 -> 65
    //   1220: aload 18
    //   1222: astore 17
    //   1224: iload 11
    //   1226: istore 10
    //   1228: goto -999 -> 229
    //   1231: iload 10
    //   1233: istore 9
    //   1235: iload 13
    //   1237: istore 10
    //   1239: goto -1010 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1242	0	this	awra
    //   0	1242	1	paramawqy	awqy
    //   0	1242	2	paramURL	URL
    //   0	1242	3	paramArrayOfByte	byte[]
    //   0	1242	4	paramInt1	int
    //   0	1242	5	paramInt2	int
    //   95	8	6	d	double
    //   18	1095	8	i	int
    //   24	1210	9	j	int
    //   15	1223	10	k	int
    //   34	1191	11	m	int
    //   21	1100	12	n	int
    //   131	1105	13	i1	int
    //   71	1080	14	bool	boolean
    //   1132	3	15	l	long
    //   7	1216	17	localObject1	Object
    //   138	1029	18	localObject2	Object
    //   1197	24	18	localThrowable	java.lang.Throwable
    //   284	30	19	arrayOfHeader	org.apache.http.Header[]
    //   679	23	19	localIOException1	IOException
    //   981	14	19	localException1	java.lang.Exception
    //   1171	1	19	localException2	java.lang.Exception
    //   1176	1	19	localException3	java.lang.Exception
    //   1184	1	19	localIOException2	IOException
    //   1189	1	19	localIOException3	IOException
    //   4	480	20	locala	awra.a
    // Exception table:
    //   from	to	target	type
    //   186	190	679	java/io/IOException
    //   242	256	679	java/io/IOException
    //   275	286	679	java/io/IOException
    //   303	309	679	java/io/IOException
    //   313	327	679	java/io/IOException
    //   331	335	679	java/io/IOException
    //   381	410	679	java/io/IOException
    //   480	495	679	java/io/IOException
    //   504	509	679	java/io/IOException
    //   513	519	679	java/io/IOException
    //   528	538	679	java/io/IOException
    //   542	553	679	java/io/IOException
    //   557	569	679	java/io/IOException
    //   573	578	679	java/io/IOException
    //   582	592	679	java/io/IOException
    //   596	603	679	java/io/IOException
    //   657	666	679	java/io/IOException
    //   670	676	679	java/io/IOException
    //   186	190	981	java/lang/Exception
    //   242	256	981	java/lang/Exception
    //   275	286	981	java/lang/Exception
    //   303	309	981	java/lang/Exception
    //   313	327	981	java/lang/Exception
    //   331	335	981	java/lang/Exception
    //   381	410	981	java/lang/Exception
    //   480	495	981	java/lang/Exception
    //   504	509	981	java/lang/Exception
    //   513	519	981	java/lang/Exception
    //   528	538	981	java/lang/Exception
    //   542	553	981	java/lang/Exception
    //   557	569	981	java/lang/Exception
    //   573	578	981	java/lang/Exception
    //   582	592	981	java/lang/Exception
    //   596	603	981	java/lang/Exception
    //   657	666	981	java/lang/Exception
    //   670	676	981	java/lang/Exception
    //   186	190	1070	finally
    //   242	256	1070	finally
    //   275	286	1070	finally
    //   303	309	1070	finally
    //   313	327	1070	finally
    //   331	335	1070	finally
    //   381	410	1070	finally
    //   480	495	1070	finally
    //   504	509	1070	finally
    //   513	519	1070	finally
    //   528	538	1070	finally
    //   542	553	1070	finally
    //   557	569	1070	finally
    //   573	578	1070	finally
    //   582	592	1070	finally
    //   596	603	1070	finally
    //   657	666	1070	finally
    //   670	676	1070	finally
    //   688	697	1070	finally
    //   701	708	1070	finally
    //   990	999	1070	finally
    //   1134	1139	1155	java/lang/InterruptedException
    //   97	117	1163	finally
    //   117	159	1163	finally
    //   162	173	1163	finally
    //   97	117	1171	java/lang/Exception
    //   117	159	1171	java/lang/Exception
    //   162	173	1176	java/lang/Exception
    //   97	117	1184	java/io/IOException
    //   117	159	1184	java/io/IOException
    //   162	173	1189	java/io/IOException
    //   275	286	1197	java/lang/Throwable
    //   303	309	1197	java/lang/Throwable
    //   313	327	1197	java/lang/Throwable
  }
  
  public awra.a a()
  {
    for (;;)
    {
      try
      {
        int i = this.list.size();
        if (i > 0)
        {
          awra.a locala1 = (awra.a)((SoftReference)this.list.remove(i - 1)).get();
          if (locala1 != null)
          {
            awra.a locala2 = locala1;
            if (locala1 == null) {
              locala2 = new awra.a(new byte[40960]);
            }
            return locala2;
          }
          i -= 1;
        }
        else
        {
          Object localObject2 = null;
        }
      }
      finally {}
    }
  }
  
  void a(awqy paramawqy, int paramInt)
  {
    switch (paramawqy.getUploadRspFlag())
    {
    default: 
      return;
    case 1: 
      this.mCurSize = this.mTotalSize;
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.notifyProgressChanged(this.mCurSize, this.mTotalSize);
      return;
    }
    a(paramawqy, this.mCurSize + paramInt);
  }
  
  void a(awqy paramawqy, long paramLong)
  {
    if (paramLong != paramawqy.getUploadRspNextOffset()) {}
    for (this.mCurSize = paramawqy.getUploadRspNextOffset();; this.mCurSize = paramLong)
    {
      this.jdField_a_of_type_CooperationWeiyunUploadWyUploadJob.notifyProgressChanged(this.mCurSize, this.mTotalSize);
      return;
    }
  }
  
  /* Error */
  public void a(awra.a parama, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	awra:list	Ljava/util/ArrayList;
    //   6: invokevirtual 305	java/util/ArrayList:size	()I
    //   9: istore_3
    //   10: iload_3
    //   11: bipush 10
    //   13: if_icmple +6 -> 19
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: aload_0
    //   20: getfield 42	awra:list	Ljava/util/ArrayList;
    //   23: new 311	java/lang/ref/SoftReference
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 337	java/lang/ref/SoftReference:<init>	(Ljava/lang/Object;)V
    //   31: invokevirtual 341	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   34: pop
    //   35: goto -19 -> 16
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	awra
    //   0	43	1	parama	awra.a
    //   0	43	2	paramBoolean	boolean
    //   9	5	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	10	38	finally
    //   19	35	38	finally
  }
  
  void closeFile(RandomAccessFile paramRandomAccessFile)
  {
    if (paramRandomAccessFile != null) {}
    try
    {
      paramRandomAccessFile.close();
      return;
    }
    catch (IOException paramRandomAccessFile) {}
  }
  
  void closeHttpClient()
  {
    if (this.mHttpClient != null)
    {
      this.mHttpClient.getConnectionManager().shutdown();
      this.mHttpClient = null;
    }
  }
  
  HttpPost configHttpClient(URL paramURL)
  {
    paramURL = new HttpPost(paramURL.toString());
    paramURL.addHeader("Accept", "*/*");
    paramURL.addHeader("User-Agent", "QdiskAndroid1.1.0");
    paramURL.addHeader("Accept-Language", "zh-CN");
    paramURL.addHeader("Referer", "http://udisk.qq.com/android");
    paramURL.addHeader("Charset", "UTF-8");
    paramURL.addHeader("Proxy-Connection", "Keep-Alive");
    paramURL.addHeader("Pragma", "no-cache");
    paramURL.addHeader("Content-type", "text/octet");
    if (this.mHttpClient == null) {
      this.mHttpClient = awpn.a();
    }
    awpn.a(this.mHttpClient, this.mTimeoutTimes);
    return paramURL;
  }
  
  URL createUrl()
    throws MalformedURLException
  {
    return new URL("http", this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverIp(), this.jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest.serverPort(), getUrlFile(31532));
  }
  
  String getUrlFile(int paramInt)
  {
    return String.format("/ftn_handler/?cn=%d&cv=%d", new Object[] { Integer.valueOf(NetworkUtils.getNetworkType(BaseApplicationImpl.getApplication())), Integer.valueOf(paramInt) });
  }
  
  /* Error */
  int processUpload()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 82	awra:createUrl	()Ljava/net/URL;
    //   4: astore 15
    //   6: new 345	java/io/RandomAccessFile
    //   9: dup
    //   10: aload_0
    //   11: getfield 44	awra:jdField_a_of_type_ComTencentWeiyunUploaderUploadRequest	Lcom/tencent/weiyun/uploader/UploadRequest;
    //   14: invokevirtual 439	com/tencent/weiyun/uploader/UploadRequest:path	()Ljava/lang/String;
    //   17: ldc_w 441
    //   20: invokespecial 443	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: astore 14
    //   25: aload_0
    //   26: getfield 73	awra:mTotalSize	J
    //   29: ldc2_w 444
    //   32: lcmp
    //   33: ifle +95 -> 128
    //   36: new 164	awqy
    //   39: dup
    //   40: sipush 1007
    //   43: aload_0
    //   44: getfield 65	awra:mFileHash	[B
    //   47: aload_0
    //   48: getfield 73	awra:mTotalSize	J
    //   51: aload_0
    //   52: getfield 60	awra:mUkey	[B
    //   55: iconst_0
    //   56: i2l
    //   57: invokespecial 448	awqy:<init>	(I[BJ[BJ)V
    //   60: astore 13
    //   62: ldc_w 449
    //   65: newarray byte
    //   67: astore 16
    //   69: iconst_0
    //   70: istore_1
    //   71: aload_0
    //   72: getfield 46	awra:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   75: invokevirtual 146	cooperation/weiyun/upload/WyUploadJob:isAlive	()Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifne +90 -> 172
    //   85: aload_0
    //   86: aload 14
    //   88: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   91: aload_0
    //   92: invokevirtual 194	awra:closeHttpClient	()V
    //   95: ldc 147
    //   97: ireturn
    //   98: astore 13
    //   100: aload_0
    //   101: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   104: aload 13
    //   106: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   109: ldc_w 452
    //   112: ireturn
    //   113: astore 13
    //   115: aload_0
    //   116: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   119: aload 13
    //   121: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   124: ldc_w 453
    //   127: ireturn
    //   128: new 164	awqy
    //   131: dup
    //   132: sipush 1000
    //   135: aload_0
    //   136: getfield 65	awra:mFileHash	[B
    //   139: aload_0
    //   140: getfield 73	awra:mTotalSize	J
    //   143: aload_0
    //   144: getfield 60	awra:mUkey	[B
    //   147: iconst_0
    //   148: i2l
    //   149: invokespecial 448	awqy:<init>	(I[BJ[BJ)V
    //   152: astore 13
    //   154: goto -92 -> 62
    //   157: astore 13
    //   159: aload_0
    //   160: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   163: aload 13
    //   165: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   168: ldc_w 454
    //   171: ireturn
    //   172: aload_0
    //   173: getfield 257	awra:mSliceSize	I
    //   176: ifgt +33 -> 209
    //   179: invokestatic 285	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   182: invokestatic 456	awra:getPacketSize	(Landroid/content/Context;)I
    //   185: istore_2
    //   186: iload_2
    //   187: ifge +17 -> 204
    //   190: aload_0
    //   191: aload 14
    //   193: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   196: aload_0
    //   197: invokevirtual 194	awra:closeHttpClient	()V
    //   200: ldc_w 290
    //   203: ireturn
    //   204: aload_0
    //   205: iload_2
    //   206: putfield 257	awra:mSliceSize	I
    //   209: invokestatic 103	android/os/SystemClock:uptimeMillis	()J
    //   212: lstore 5
    //   214: aload_0
    //   215: getfield 67	awra:mCurSize	J
    //   218: lstore 7
    //   220: aload 14
    //   222: lload 7
    //   224: invokevirtual 459	java/io/RandomAccessFile:seek	(J)V
    //   227: aload 13
    //   229: invokevirtual 462	awqy:getHeadLength	()I
    //   232: istore_3
    //   233: aload 14
    //   235: aload 16
    //   237: iload_3
    //   238: aload_0
    //   239: getfield 257	awra:mSliceSize	I
    //   242: invokevirtual 465	java/io/RandomAccessFile:read	([BII)I
    //   245: istore_2
    //   246: iload_2
    //   247: ifgt +37 -> 284
    //   250: aload_0
    //   251: getfield 67	awra:mCurSize	J
    //   254: lstore 9
    //   256: aload_0
    //   257: getfield 73	awra:mTotalSize	J
    //   260: lstore 11
    //   262: lload 9
    //   264: lload 11
    //   266: lcmp
    //   267: ifge +17 -> 284
    //   270: aload_0
    //   271: aload 14
    //   273: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   276: aload_0
    //   277: invokevirtual 194	awra:closeHttpClient	()V
    //   280: ldc_w 466
    //   283: ireturn
    //   284: iload_2
    //   285: ifgt +35 -> 320
    //   288: aload_0
    //   289: getfield 67	awra:mCurSize	J
    //   292: lstore 9
    //   294: aload_0
    //   295: getfield 73	awra:mTotalSize	J
    //   298: lstore 11
    //   300: lload 9
    //   302: lload 11
    //   304: lcmp
    //   305: ifne +15 -> 320
    //   308: aload_0
    //   309: aload 14
    //   311: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   314: aload_0
    //   315: invokevirtual 194	awra:closeHttpClient	()V
    //   318: iconst_0
    //   319: ireturn
    //   320: iload_1
    //   321: iconst_1
    //   322: iadd
    //   323: istore_1
    //   324: iload_1
    //   325: i2l
    //   326: lstore 9
    //   328: aload 13
    //   330: lload 9
    //   332: invokevirtual 469	awqy:setSeq	(J)V
    //   335: aload_0
    //   336: aload 13
    //   338: aload 15
    //   340: aload 16
    //   342: iload_3
    //   343: iload_2
    //   344: invokevirtual 471	awra:a	(Lawqy;Ljava/net/URL;[BII)I
    //   347: istore_3
    //   348: iload_3
    //   349: ifeq +15 -> 364
    //   352: aload_0
    //   353: aload 14
    //   355: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   358: aload_0
    //   359: invokevirtual 194	awra:closeHttpClient	()V
    //   362: iload_3
    //   363: ireturn
    //   364: aload_0
    //   365: getfield 46	awra:jdField_a_of_type_CooperationWeiyunUploadWyUploadJob	Lcooperation/weiyun/upload/WyUploadJob;
    //   368: invokevirtual 146	cooperation/weiyun/upload/WyUploadJob:isAlive	()Z
    //   371: istore 4
    //   373: iload 4
    //   375: ifne +16 -> 391
    //   378: aload_0
    //   379: aload 14
    //   381: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   384: aload_0
    //   385: invokevirtual 194	awra:closeHttpClient	()V
    //   388: ldc 147
    //   390: ireturn
    //   391: aload_0
    //   392: aload 13
    //   394: iload_2
    //   395: invokevirtual 473	awra:a	(Lawqy;I)V
    //   398: aload_0
    //   399: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   402: astore 17
    //   404: aload 17
    //   406: aload 17
    //   408: getfield 476	awqz$a:transferDataTimeCost	J
    //   411: invokestatic 103	android/os/SystemClock:uptimeMillis	()J
    //   414: lload 5
    //   416: lsub
    //   417: ladd
    //   418: putfield 476	awqz$a:transferDataTimeCost	J
    //   421: aload_0
    //   422: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   425: astore 17
    //   427: aload 17
    //   429: aload 17
    //   431: getfield 479	awqz$a:transferDataSize	J
    //   434: aload_0
    //   435: getfield 67	awra:mCurSize	J
    //   438: lload 7
    //   440: lsub
    //   441: ladd
    //   442: putfield 479	awqz$a:transferDataSize	J
    //   445: aload_0
    //   446: getfield 67	awra:mCurSize	J
    //   449: aload_0
    //   450: getfield 73	awra:mTotalSize	J
    //   453: lcmp
    //   454: ifeq -146 -> 308
    //   457: aload_0
    //   458: getfield 67	awra:mCurSize	J
    //   461: lstore 5
    //   463: aload_0
    //   464: getfield 73	awra:mTotalSize	J
    //   467: lstore 7
    //   469: lload 5
    //   471: lload 7
    //   473: lcmp
    //   474: ifle +17 -> 491
    //   477: aload_0
    //   478: aload 14
    //   480: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   483: aload_0
    //   484: invokevirtual 194	awra:closeHttpClient	()V
    //   487: ldc_w 480
    //   490: ireturn
    //   491: goto -420 -> 71
    //   494: astore 13
    //   496: aload_0
    //   497: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   500: aload 13
    //   502: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   505: aload_0
    //   506: aload 14
    //   508: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   511: aload_0
    //   512: invokevirtual 194	awra:closeHttpClient	()V
    //   515: ldc_w 481
    //   518: ireturn
    //   519: astore 13
    //   521: aload_0
    //   522: getfield 78	awra:jdField_a_of_type_Awqz$a	Lawqz$a;
    //   525: aload 13
    //   527: putfield 263	awqz$a:failException	Ljava/lang/Throwable;
    //   530: aload_0
    //   531: aload 14
    //   533: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   536: aload_0
    //   537: invokevirtual 194	awra:closeHttpClient	()V
    //   540: ldc_w 292
    //   543: ireturn
    //   544: astore 13
    //   546: aload_0
    //   547: aload 14
    //   549: invokevirtual 451	awra:closeFile	(Ljava/io/RandomAccessFile;)V
    //   552: aload_0
    //   553: invokevirtual 194	awra:closeHttpClient	()V
    //   556: aload 13
    //   558: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	awra
    //   70	255	1	i	int
    //   185	210	2	j	int
    //   232	131	3	k	int
    //   78	296	4	bool	boolean
    //   212	258	5	l1	long
    //   218	254	7	l2	long
    //   254	77	9	l3	long
    //   260	43	11	l4	long
    //   60	1	13	localawqy1	awqy
    //   98	7	13	localFileNotFoundException	java.io.FileNotFoundException
    //   113	7	13	localMalformedURLException	MalformedURLException
    //   152	1	13	localawqy2	awqy
    //   157	236	13	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   494	7	13	localIOException	IOException
    //   519	7	13	localException	java.lang.Exception
    //   544	13	13	localObject	Object
    //   23	525	14	localRandomAccessFile	RandomAccessFile
    //   4	335	15	localURL	URL
    //   67	274	16	arrayOfByte	byte[]
    //   402	28	17	locala	awqz.a
    // Exception table:
    //   from	to	target	type
    //   0	25	98	java/io/FileNotFoundException
    //   0	25	113	java/net/MalformedURLException
    //   25	62	157	java/lang/IllegalArgumentException
    //   128	154	157	java/lang/IllegalArgumentException
    //   71	80	494	java/io/IOException
    //   172	186	494	java/io/IOException
    //   204	209	494	java/io/IOException
    //   209	246	494	java/io/IOException
    //   250	262	494	java/io/IOException
    //   288	300	494	java/io/IOException
    //   328	348	494	java/io/IOException
    //   364	373	494	java/io/IOException
    //   391	469	494	java/io/IOException
    //   71	80	519	java/lang/Exception
    //   172	186	519	java/lang/Exception
    //   204	209	519	java/lang/Exception
    //   209	246	519	java/lang/Exception
    //   250	262	519	java/lang/Exception
    //   288	300	519	java/lang/Exception
    //   328	348	519	java/lang/Exception
    //   364	373	519	java/lang/Exception
    //   391	469	519	java/lang/Exception
    //   71	80	544	finally
    //   172	186	544	finally
    //   204	209	544	finally
    //   209	246	544	finally
    //   250	262	544	finally
    //   288	300	544	finally
    //   328	348	544	finally
    //   364	373	544	finally
    //   391	469	544	finally
    //   496	505	544	finally
    //   521	530	544	finally
  }
  
  public int transfer()
  {
    return processUpload();
  }
  
  public static final class a
  {
    public final byte[] backingArray;
    
    a(byte[] paramArrayOfByte)
    {
      this.backingArray = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awra
 * JD-Core Version:    0.7.0.1
 */