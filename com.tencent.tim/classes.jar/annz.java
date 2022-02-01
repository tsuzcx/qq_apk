import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.collector.ResultObject;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.FDNative;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class annz
  implements Handler.Callback, anpc.f
{
  private static volatile annz jdField_a_of_type_Annz;
  private static long amE = 1800000L;
  static String cfu;
  private static String filePath;
  private static final String[] gX = { "/proc/net/tcp6", "/proc/net/udp6", "/proc/net/tcp", "/proc/net/udp" };
  private static final int[] og = { 4113, 4113, 4097, 4097 };
  private static ThreadLocal<SimpleDateFormat> x = new anoa();
  private anob jdField_a_of_type_Anob = new anob();
  private anpx jdField_a_of_type_Anpx = new anpx();
  private int bGJ = 0;
  private String bos = "/proc/" + Process.myPid() + "/fd";
  private boolean cIN;
  private String cfs = "ls -l " + this.bos;
  private String cft;
  private boolean cpb;
  private int dKp;
  private int dKq;
  AtomicBoolean dO = new AtomicBoolean(false);
  private Handler mHandler = new Handler(ThreadManager.getFileThreadLooper(), this);
  private boolean mStarted;
  
  private void QQ(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if (new File(paramString).exists())
      {
        aqhq.cm(paramString);
        if (QLog.isColorLevel())
        {
          QLog.d("FDStats", 2, "deleteFDFiles");
          return;
        }
      }
    }
    catch (Exception paramString)
    {
      QLog.e("FDStats", 2, "deleteFDFiles");
    }
  }
  
  static long a(File paramFile, boolean paramBoolean)
  {
    paramFile = paramFile.getName();
    try
    {
      paramFile = paramFile.substring(paramFile.lastIndexOf("/") + 1);
      if ((paramFile.endsWith(".txt")) || ((paramBoolean) && (paramFile.endsWith(".zip")))) {
        return Long.valueOf(paramFile.substring(0, paramFile.length() - 4)).longValue();
      }
      if (paramFile.endsWith(".socket"))
      {
        long l = Long.valueOf(paramFile.substring(0, paramFile.length() - 7)).longValue();
        return l;
      }
    }
    catch (Exception paramFile) {}
    return -1L;
  }
  
  public static annz a()
  {
    if (jdField_a_of_type_Annz == null) {}
    try
    {
      if (jdField_a_of_type_Annz == null)
      {
        jdField_a_of_type_Annz = new annz();
        if (anpc.a == null) {
          anpc.a = jdField_a_of_type_Annz;
        }
      }
      return jdField_a_of_type_Annz;
    }
    finally {}
  }
  
  /* Error */
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: invokestatic 233	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: astore 11
    //   5: new 79	java/lang/StringBuilder
    //   8: dup
    //   9: ldc 235
    //   11: invokespecial 236	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   14: astore 16
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield 238	annz:dKq	I
    //   21: invokestatic 243	java/lang/System:currentTimeMillis	()J
    //   24: lstore 7
    //   26: new 245	anoc
    //   29: dup
    //   30: invokespecial 246	anoc:<init>	()V
    //   33: astore 17
    //   35: aload 11
    //   37: aload_1
    //   38: invokevirtual 250	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   41: invokevirtual 256	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   44: astore_1
    //   45: new 258	java/io/BufferedReader
    //   48: dup
    //   49: new 260	java/io/InputStreamReader
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 263	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   57: invokespecial 266	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   60: astore 12
    //   62: aload 12
    //   64: astore 14
    //   66: aload_1
    //   67: astore 13
    //   69: aload 12
    //   71: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   74: astore 15
    //   76: aload 15
    //   78: ifnull +290 -> 368
    //   81: aload 12
    //   83: astore 14
    //   85: aload_1
    //   86: astore 13
    //   88: aload 15
    //   90: ldc_w 271
    //   93: invokevirtual 274	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   96: istore 4
    //   98: aload 15
    //   100: astore 11
    //   102: iload 4
    //   104: ifle +26 -> 130
    //   107: aload 12
    //   109: astore 14
    //   111: aload_1
    //   112: astore 13
    //   114: aload 15
    //   116: iload 4
    //   118: iconst_2
    //   119: iadd
    //   120: aload 15
    //   122: invokevirtual 194	java/lang/String:length	()I
    //   125: invokevirtual 197	java/lang/String:substring	(II)Ljava/lang/String;
    //   128: astore 11
    //   130: aload 12
    //   132: astore 14
    //   134: aload_1
    //   135: astore 13
    //   137: aload 17
    //   139: aload 11
    //   141: invokevirtual 277	anoc:QR	(Ljava/lang/String;)V
    //   144: aload 12
    //   146: astore 14
    //   148: aload_1
    //   149: astore 13
    //   151: aload 16
    //   153: new 79	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   160: aload 11
    //   162: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: ldc_w 279
    //   168: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: aload 12
    //   180: astore 14
    //   182: aload_1
    //   183: astore 13
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 238	annz:dKq	I
    //   190: iconst_1
    //   191: iadd
    //   192: putfield 238	annz:dKq	I
    //   195: iload_3
    //   196: ifeq -134 -> 62
    //   199: aload 12
    //   201: astore 14
    //   203: aload_1
    //   204: astore 13
    //   206: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   209: ifeq -147 -> 62
    //   212: aload 12
    //   214: astore 14
    //   216: aload_1
    //   217: astore 13
    //   219: ldc 160
    //   221: iconst_2
    //   222: new 79	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   229: aload 11
    //   231: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: ldc_w 279
    //   237: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: goto -184 -> 62
    //   249: astore 13
    //   251: aload_1
    //   252: astore 11
    //   254: aload 12
    //   256: astore_1
    //   257: aload 13
    //   259: astore 12
    //   261: ldc 160
    //   263: iconst_2
    //   264: new 79	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 281
    //   274: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload 12
    //   279: invokevirtual 282	java/io/IOException:toString	()Ljava/lang/String;
    //   282: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 238	annz:dKq	I
    //   296: aload_1
    //   297: ifnull +7 -> 304
    //   300: aload_1
    //   301: invokevirtual 285	java/io/BufferedReader:close	()V
    //   304: aload 11
    //   306: ifnull +8 -> 314
    //   309: aload 11
    //   311: invokevirtual 288	java/io/InputStream:close	()V
    //   314: new 290	anpz
    //   317: dup
    //   318: invokespecial 291	anpz:<init>	()V
    //   321: astore_1
    //   322: aload 16
    //   324: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: ldc_w 293
    //   330: invokevirtual 297	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   333: astore 11
    //   335: aload 11
    //   337: arraylength
    //   338: istore 5
    //   340: iconst_0
    //   341: istore 4
    //   343: iload 4
    //   345: iload 5
    //   347: if_icmpge +761 -> 1108
    //   350: aload_1
    //   351: aload 11
    //   353: iload 4
    //   355: aaload
    //   356: invokevirtual 300	anpz:Rj	(Ljava/lang/String;)V
    //   359: iload 4
    //   361: iconst_1
    //   362: iadd
    //   363: istore 4
    //   365: goto -22 -> 343
    //   368: aload 12
    //   370: astore 14
    //   372: aload_1
    //   373: astore 13
    //   375: aload_0
    //   376: getfield 238	annz:dKq	I
    //   379: ifne +375 -> 754
    //   382: aload 12
    //   384: astore 14
    //   386: aload_1
    //   387: astore 13
    //   389: new 142	java/io/File
    //   392: dup
    //   393: aload_0
    //   394: getfield 103	annz:bos	Ljava/lang/String;
    //   397: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   400: astore 11
    //   402: aload 11
    //   404: ifnull +18 -> 422
    //   407: aload 12
    //   409: astore 14
    //   411: aload_1
    //   412: astore 13
    //   414: aload 11
    //   416: invokevirtual 304	java/io/File:list	()[Ljava/lang/String;
    //   419: ifnonnull +67 -> 486
    //   422: aload 12
    //   424: astore 14
    //   426: aload_1
    //   427: astore 13
    //   429: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +54 -> 486
    //   435: aload 12
    //   437: astore 14
    //   439: aload_1
    //   440: astore 13
    //   442: new 79	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   449: ldc_w 306
    //   452: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: astore 15
    //   457: aload 11
    //   459: ifnonnull +209 -> 668
    //   462: iconst_1
    //   463: istore_3
    //   464: aload 12
    //   466: astore 14
    //   468: aload_1
    //   469: astore 13
    //   471: ldc 160
    //   473: iconst_2
    //   474: aload 15
    //   476: iload_3
    //   477: invokevirtual 309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   480: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: aload 12
    //   488: astore 14
    //   490: aload_1
    //   491: astore 13
    //   493: getstatic 314	android/os/Build$VERSION:SDK_INT	I
    //   496: bipush 21
    //   498: if_icmplt +175 -> 673
    //   501: iconst_1
    //   502: istore 4
    //   504: aload 12
    //   506: astore 14
    //   508: aload_1
    //   509: astore 13
    //   511: aload 11
    //   513: invokevirtual 318	java/io/File:listFiles	()[Ljava/io/File;
    //   516: astore 15
    //   518: aload 15
    //   520: ifnull +234 -> 754
    //   523: aload 12
    //   525: astore 14
    //   527: aload_1
    //   528: astore 13
    //   530: new 79	java/lang/StringBuilder
    //   533: dup
    //   534: sipush 200
    //   537: invokespecial 321	java/lang/StringBuilder:<init>	(I)V
    //   540: astore 17
    //   542: aload 12
    //   544: astore 14
    //   546: aload_1
    //   547: astore 13
    //   549: aload 17
    //   551: ldc_w 323
    //   554: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: iconst_0
    //   559: istore 5
    //   561: iconst_0
    //   562: istore 6
    //   564: aload 12
    //   566: astore 14
    //   568: aload_1
    //   569: astore 13
    //   571: iload 5
    //   573: aload 15
    //   575: arraylength
    //   576: if_icmpge +155 -> 731
    //   579: aload 15
    //   581: iload 5
    //   583: aaload
    //   584: astore 18
    //   586: iload 4
    //   588: ifeq +91 -> 679
    //   591: aload 12
    //   593: astore 14
    //   595: aload_1
    //   596: astore 13
    //   598: aload 18
    //   600: invokevirtual 326	java/io/File:getPath	()Ljava/lang/String;
    //   603: invokestatic 332	android/system/Os:readlink	(Ljava/lang/String;)Ljava/lang/String;
    //   606: astore 11
    //   608: aload 12
    //   610: astore 14
    //   612: aload_1
    //   613: astore 13
    //   615: aload 16
    //   617: new 79	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   624: aload 11
    //   626: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: ldc_w 279
    //   632: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: pop
    //   642: aload 12
    //   644: astore 14
    //   646: aload_1
    //   647: astore 13
    //   649: aload_0
    //   650: aload_0
    //   651: getfield 238	annz:dKq	I
    //   654: iconst_1
    //   655: iadd
    //   656: putfield 238	annz:dKq	I
    //   659: iload 5
    //   661: iconst_1
    //   662: iadd
    //   663: istore 5
    //   665: goto -101 -> 564
    //   668: iconst_0
    //   669: istore_3
    //   670: goto -206 -> 464
    //   673: iconst_0
    //   674: istore 4
    //   676: goto -172 -> 504
    //   679: aload 12
    //   681: astore 14
    //   683: aload_1
    //   684: astore 13
    //   686: aload 18
    //   688: invokevirtual 335	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   691: astore 11
    //   693: goto -85 -> 608
    //   696: astore 11
    //   698: aload 12
    //   700: astore 14
    //   702: aload_1
    //   703: astore 13
    //   705: aload 17
    //   707: ldc_w 337
    //   710: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload 18
    //   715: invokevirtual 326	java/io/File:getPath	()Ljava/lang/String;
    //   718: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: pop
    //   722: iload 6
    //   724: iconst_1
    //   725: iadd
    //   726: istore 6
    //   728: goto -86 -> 642
    //   731: iload 6
    //   733: ifle +21 -> 754
    //   736: aload 12
    //   738: astore 14
    //   740: aload_1
    //   741: astore 13
    //   743: ldc 160
    //   745: iconst_2
    //   746: aload 16
    //   748: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   754: aload 12
    //   756: astore 14
    //   758: aload_1
    //   759: astore 13
    //   761: aload 16
    //   763: new 79	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   770: ldc_w 339
    //   773: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: aload_0
    //   777: getfield 238	annz:dKq	I
    //   780: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   783: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload 12
    //   792: astore 14
    //   794: aload_1
    //   795: astore 13
    //   797: aload 16
    //   799: new 79	java/lang/StringBuilder
    //   802: dup
    //   803: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   806: ldc_w 341
    //   809: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: aload_0
    //   813: getfield 343	annz:dKp	I
    //   816: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   819: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   822: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload 12
    //   828: astore 14
    //   830: aload_1
    //   831: astore 13
    //   833: aload 16
    //   835: new 79	java/lang/StringBuilder
    //   838: dup
    //   839: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   842: ldc_w 345
    //   845: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: ldc_w 347
    //   851: lload 7
    //   853: invokestatic 353	android/text/format/DateFormat:format	(Ljava/lang/CharSequence;J)Ljava/lang/CharSequence;
    //   856: invokeinterface 356 1 0
    //   861: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 12
    //   873: astore 14
    //   875: aload_1
    //   876: astore 13
    //   878: aload 16
    //   880: ldc_w 358
    //   883: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: pop
    //   887: aload 12
    //   889: astore 14
    //   891: aload_1
    //   892: astore 13
    //   894: aload 16
    //   896: new 79	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   903: ldc_w 360
    //   906: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: invokestatic 365	com/tencent/common/config/AppSetting:getRevision	()Ljava/lang/String;
    //   912: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   915: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   918: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   921: pop
    //   922: aload 12
    //   924: astore 14
    //   926: aload_1
    //   927: astore 13
    //   929: aload 16
    //   931: new 79	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   938: ldc_w 367
    //   941: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: iconst_2
    //   945: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   948: ldc_w 369
    //   951: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   954: aload_0
    //   955: getfield 77	annz:bGJ	I
    //   958: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   961: ldc_w 279
    //   964: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: pop
    //   974: aload 12
    //   976: ifnull +8 -> 984
    //   979: aload 12
    //   981: invokevirtual 285	java/io/BufferedReader:close	()V
    //   984: aload_1
    //   985: ifnull -671 -> 314
    //   988: aload_1
    //   989: invokevirtual 288	java/io/InputStream:close	()V
    //   992: goto -678 -> 314
    //   995: astore_1
    //   996: goto -682 -> 314
    //   999: astore 15
    //   1001: aconst_null
    //   1002: astore_1
    //   1003: aconst_null
    //   1004: astore 11
    //   1006: aload 11
    //   1008: astore 14
    //   1010: aload_1
    //   1011: astore 13
    //   1013: ldc 160
    //   1015: iconst_2
    //   1016: new 79	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1023: ldc_w 371
    //   1026: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: aload 15
    //   1031: invokevirtual 372	java/lang/NullPointerException:toString	()Ljava/lang/String;
    //   1034: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1040: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1043: aload 11
    //   1045: astore 14
    //   1047: aload_1
    //   1048: astore 13
    //   1050: aload_0
    //   1051: iconst_0
    //   1052: putfield 238	annz:dKq	I
    //   1055: aload 11
    //   1057: ifnull +8 -> 1065
    //   1060: aload 11
    //   1062: invokevirtual 285	java/io/BufferedReader:close	()V
    //   1065: aload_1
    //   1066: ifnull -752 -> 314
    //   1069: aload_1
    //   1070: invokevirtual 288	java/io/InputStream:close	()V
    //   1073: goto -759 -> 314
    //   1076: astore_1
    //   1077: goto -763 -> 314
    //   1080: astore 11
    //   1082: aconst_null
    //   1083: astore_1
    //   1084: aconst_null
    //   1085: astore 12
    //   1087: aload 12
    //   1089: ifnull +8 -> 1097
    //   1092: aload 12
    //   1094: invokevirtual 285	java/io/BufferedReader:close	()V
    //   1097: aload_1
    //   1098: ifnull +7 -> 1105
    //   1101: aload_1
    //   1102: invokevirtual 288	java/io/InputStream:close	()V
    //   1105: aload 11
    //   1107: athrow
    //   1108: aload_0
    //   1109: aload_0
    //   1110: getfield 117	annz:jdField_a_of_type_Anpx	Lanpx;
    //   1113: aload_1
    //   1114: invokevirtual 375	anpx:a	(Lanpz;)Ljava/lang/String;
    //   1117: putfield 377	annz:cft	Ljava/lang/String;
    //   1120: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1123: ifeq +32 -> 1155
    //   1126: ldc 160
    //   1128: iconst_2
    //   1129: new 79	java/lang/StringBuilder
    //   1132: dup
    //   1133: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1136: ldc_w 379
    //   1139: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: aload_0
    //   1143: getfield 377	annz:cft	Ljava/lang/String;
    //   1146: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1149: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1152: invokestatic 382	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1155: getstatic 384	annz:filePath	Ljava/lang/String;
    //   1158: ifnonnull +31 -> 1189
    //   1161: new 79	java/lang/StringBuilder
    //   1164: dup
    //   1165: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1168: invokestatic 390	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1171: invokevirtual 394	com/tencent/common/app/BaseApplicationImpl:getFilesDir	()Ljava/io/File;
    //   1174: invokevirtual 397	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1177: ldc_w 399
    //   1180: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: putstatic 384	annz:filePath	Ljava/lang/String;
    //   1189: invokestatic 390	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1192: ldc_w 401
    //   1195: iconst_0
    //   1196: invokevirtual 405	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1199: astore_1
    //   1200: aload_0
    //   1201: getfield 238	annz:dKq	I
    //   1204: ifne +72 -> 1276
    //   1207: aload_1
    //   1208: ldc_w 407
    //   1211: lconst_0
    //   1212: invokeinterface 413 4 0
    //   1217: lstore 9
    //   1219: invokestatic 243	java/lang/System:currentTimeMillis	()J
    //   1222: lload 9
    //   1224: lsub
    //   1225: ldc2_w 414
    //   1228: lcmp
    //   1229: ifle +47 -> 1276
    //   1232: invokestatic 390	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1235: invokevirtual 419	com/tencent/common/app/BaseApplicationImpl:getApplicationContext	()Landroid/content/Context;
    //   1238: invokestatic 422	anpc:a	(Landroid/content/Context;)Lanpc;
    //   1241: aconst_null
    //   1242: ldc_w 424
    //   1245: iconst_1
    //   1246: lconst_0
    //   1247: lconst_0
    //   1248: aconst_null
    //   1249: aconst_null
    //   1250: invokevirtual 428	anpc:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   1253: aload_1
    //   1254: invokeinterface 432 1 0
    //   1259: ldc_w 407
    //   1262: invokestatic 243	java/lang/System:currentTimeMillis	()J
    //   1265: invokeinterface 438 4 0
    //   1270: invokeinterface 441 1 0
    //   1275: pop
    //   1276: aconst_null
    //   1277: astore_1
    //   1278: iload_2
    //   1279: ifeq +61 -> 1340
    //   1282: invokestatic 446	com/tencent/mobileqq/statistics/FDStatsHooker:getAllStackTrace	()Ljava/lang/String;
    //   1285: astore_1
    //   1286: aload_1
    //   1287: invokestatic 140	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1290: ifne +16 -> 1306
    //   1293: aload 16
    //   1295: ldc_w 448
    //   1298: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1301: aload_1
    //   1302: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1305: pop
    //   1306: new 79	java/lang/StringBuilder
    //   1309: dup
    //   1310: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1313: getstatic 384	annz:filePath	Ljava/lang/String;
    //   1316: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1319: lload 7
    //   1321: invokevirtual 451	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1324: ldc 185
    //   1326: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1329: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1332: astore_1
    //   1333: aload_0
    //   1334: aload_1
    //   1335: aload 16
    //   1337: invokespecial 455	annz:c	(Ljava/lang/String;Ljava/lang/StringBuilder;)V
    //   1340: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1343: ifeq +29 -> 1372
    //   1346: ldc 160
    //   1348: iconst_2
    //   1349: new 79	java/lang/StringBuilder
    //   1352: dup
    //   1353: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   1356: ldc_w 457
    //   1359: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1362: iload_2
    //   1363: invokevirtual 309	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1366: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1369: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1372: aload_1
    //   1373: areturn
    //   1374: astore 11
    //   1376: goto -392 -> 984
    //   1379: astore_1
    //   1380: goto -1076 -> 304
    //   1383: astore_1
    //   1384: goto -1070 -> 314
    //   1387: astore 11
    //   1389: goto -324 -> 1065
    //   1392: astore 12
    //   1394: goto -297 -> 1097
    //   1397: astore_1
    //   1398: goto -293 -> 1105
    //   1401: astore 11
    //   1403: aconst_null
    //   1404: astore 12
    //   1406: goto -319 -> 1087
    //   1409: astore 11
    //   1411: aload 14
    //   1413: astore 12
    //   1415: aload 13
    //   1417: astore_1
    //   1418: goto -331 -> 1087
    //   1421: astore 12
    //   1423: aload 11
    //   1425: astore 13
    //   1427: aload 12
    //   1429: astore 11
    //   1431: aload_1
    //   1432: astore 12
    //   1434: aload 13
    //   1436: astore_1
    //   1437: goto -350 -> 1087
    //   1440: astore 15
    //   1442: aconst_null
    //   1443: astore 11
    //   1445: goto -439 -> 1006
    //   1448: astore 15
    //   1450: aload 12
    //   1452: astore 11
    //   1454: goto -448 -> 1006
    //   1457: astore 12
    //   1459: aconst_null
    //   1460: astore 11
    //   1462: aconst_null
    //   1463: astore_1
    //   1464: goto -1203 -> 261
    //   1467: astore 12
    //   1469: aconst_null
    //   1470: astore 13
    //   1472: aload_1
    //   1473: astore 11
    //   1475: aload 13
    //   1477: astore_1
    //   1478: goto -1217 -> 261
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1481	0	this	annz
    //   0	1481	1	paramString	String
    //   0	1481	2	paramBoolean1	boolean
    //   0	1481	3	paramBoolean2	boolean
    //   96	579	4	i	int
    //   338	326	5	j	int
    //   562	170	6	k	int
    //   24	1296	7	l1	long
    //   1217	6	9	l2	long
    //   3	689	11	localObject1	Object
    //   696	1	11	localThrowable	Throwable
    //   1004	57	11	localObject2	Object
    //   1080	26	11	localObject3	Object
    //   1374	1	11	localIOException1	java.io.IOException
    //   1387	1	11	localIOException2	java.io.IOException
    //   1401	1	11	localObject4	Object
    //   1409	15	11	localObject5	Object
    //   1429	45	11	localObject6	Object
    //   60	1033	12	localObject7	Object
    //   1392	1	12	localIOException3	java.io.IOException
    //   1404	10	12	localObject8	Object
    //   1421	7	12	localObject9	Object
    //   1432	19	12	str1	String
    //   1457	1	12	localIOException4	java.io.IOException
    //   1467	1	12	localIOException5	java.io.IOException
    //   67	151	13	str2	String
    //   249	9	13	localIOException6	java.io.IOException
    //   373	1103	13	localObject10	Object
    //   64	1348	14	localObject11	Object
    //   74	506	15	localObject12	Object
    //   999	31	15	localNullPointerException1	NullPointerException
    //   1440	1	15	localNullPointerException2	NullPointerException
    //   1448	1	15	localNullPointerException3	NullPointerException
    //   14	1322	16	localStringBuilder	StringBuilder
    //   33	673	17	localObject13	Object
    //   584	130	18	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   69	76	249	java/io/IOException
    //   88	98	249	java/io/IOException
    //   114	130	249	java/io/IOException
    //   137	144	249	java/io/IOException
    //   151	178	249	java/io/IOException
    //   185	195	249	java/io/IOException
    //   206	212	249	java/io/IOException
    //   219	246	249	java/io/IOException
    //   375	382	249	java/io/IOException
    //   389	402	249	java/io/IOException
    //   414	422	249	java/io/IOException
    //   429	435	249	java/io/IOException
    //   442	457	249	java/io/IOException
    //   471	486	249	java/io/IOException
    //   493	501	249	java/io/IOException
    //   511	518	249	java/io/IOException
    //   530	542	249	java/io/IOException
    //   549	558	249	java/io/IOException
    //   571	579	249	java/io/IOException
    //   598	608	249	java/io/IOException
    //   615	642	249	java/io/IOException
    //   649	659	249	java/io/IOException
    //   686	693	249	java/io/IOException
    //   705	722	249	java/io/IOException
    //   743	754	249	java/io/IOException
    //   761	790	249	java/io/IOException
    //   797	826	249	java/io/IOException
    //   833	871	249	java/io/IOException
    //   878	887	249	java/io/IOException
    //   894	922	249	java/io/IOException
    //   929	974	249	java/io/IOException
    //   598	608	696	java/lang/Throwable
    //   615	642	696	java/lang/Throwable
    //   686	693	696	java/lang/Throwable
    //   988	992	995	java/io/IOException
    //   35	45	999	java/lang/NullPointerException
    //   1069	1073	1076	java/io/IOException
    //   35	45	1080	finally
    //   979	984	1374	java/io/IOException
    //   300	304	1379	java/io/IOException
    //   309	314	1383	java/io/IOException
    //   1060	1065	1387	java/io/IOException
    //   1092	1097	1392	java/io/IOException
    //   1101	1105	1397	java/io/IOException
    //   45	62	1401	finally
    //   69	76	1409	finally
    //   88	98	1409	finally
    //   114	130	1409	finally
    //   137	144	1409	finally
    //   151	178	1409	finally
    //   185	195	1409	finally
    //   206	212	1409	finally
    //   219	246	1409	finally
    //   375	382	1409	finally
    //   389	402	1409	finally
    //   414	422	1409	finally
    //   429	435	1409	finally
    //   442	457	1409	finally
    //   471	486	1409	finally
    //   493	501	1409	finally
    //   511	518	1409	finally
    //   530	542	1409	finally
    //   549	558	1409	finally
    //   571	579	1409	finally
    //   598	608	1409	finally
    //   615	642	1409	finally
    //   649	659	1409	finally
    //   686	693	1409	finally
    //   705	722	1409	finally
    //   743	754	1409	finally
    //   761	790	1409	finally
    //   797	826	1409	finally
    //   833	871	1409	finally
    //   878	887	1409	finally
    //   894	922	1409	finally
    //   929	974	1409	finally
    //   1013	1043	1409	finally
    //   1050	1055	1409	finally
    //   261	296	1421	finally
    //   45	62	1440	java/lang/NullPointerException
    //   69	76	1448	java/lang/NullPointerException
    //   88	98	1448	java/lang/NullPointerException
    //   114	130	1448	java/lang/NullPointerException
    //   137	144	1448	java/lang/NullPointerException
    //   151	178	1448	java/lang/NullPointerException
    //   185	195	1448	java/lang/NullPointerException
    //   206	212	1448	java/lang/NullPointerException
    //   219	246	1448	java/lang/NullPointerException
    //   375	382	1448	java/lang/NullPointerException
    //   389	402	1448	java/lang/NullPointerException
    //   414	422	1448	java/lang/NullPointerException
    //   429	435	1448	java/lang/NullPointerException
    //   442	457	1448	java/lang/NullPointerException
    //   471	486	1448	java/lang/NullPointerException
    //   493	501	1448	java/lang/NullPointerException
    //   511	518	1448	java/lang/NullPointerException
    //   530	542	1448	java/lang/NullPointerException
    //   549	558	1448	java/lang/NullPointerException
    //   571	579	1448	java/lang/NullPointerException
    //   598	608	1448	java/lang/NullPointerException
    //   615	642	1448	java/lang/NullPointerException
    //   649	659	1448	java/lang/NullPointerException
    //   686	693	1448	java/lang/NullPointerException
    //   705	722	1448	java/lang/NullPointerException
    //   743	754	1448	java/lang/NullPointerException
    //   761	790	1448	java/lang/NullPointerException
    //   797	826	1448	java/lang/NullPointerException
    //   833	871	1448	java/lang/NullPointerException
    //   878	887	1448	java/lang/NullPointerException
    //   894	922	1448	java/lang/NullPointerException
    //   929	974	1448	java/lang/NullPointerException
    //   35	45	1457	java/io/IOException
    //   45	62	1467	java/io/IOException
  }
  
  /* Error */
  private void c(String paramString, StringBuilder paramStringBuilder)
  {
    // Byte code:
    //   0: new 142	java/io/File
    //   3: dup
    //   4: getstatic 384	annz:filePath	Ljava/lang/String;
    //   7: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 142	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 144	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_3
    //   28: astore_1
    //   29: aload 5
    //   31: invokevirtual 148	java/io/File:exists	()Z
    //   34: ifne +11 -> 45
    //   37: aload_3
    //   38: astore_1
    //   39: aload 5
    //   41: invokevirtual 460	java/io/File:mkdirs	()Z
    //   44: pop
    //   45: aload_3
    //   46: astore_1
    //   47: aload 6
    //   49: invokevirtual 148	java/io/File:exists	()Z
    //   52: ifne +11 -> 63
    //   55: aload_3
    //   56: astore_1
    //   57: aload 6
    //   59: invokevirtual 463	java/io/File:createNewFile	()Z
    //   62: pop
    //   63: aload_3
    //   64: astore_1
    //   65: new 465	java/io/BufferedWriter
    //   68: dup
    //   69: new 467	java/io/FileWriter
    //   72: dup
    //   73: aload 6
    //   75: iconst_1
    //   76: invokespecial 470	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   79: sipush 8192
    //   82: invokespecial 473	java/io/BufferedWriter:<init>	(Ljava/io/Writer;I)V
    //   85: astore_3
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokevirtual 476	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   94: aload_3
    //   95: invokevirtual 479	java/io/BufferedWriter:flush	()V
    //   98: aload_3
    //   99: ifnull +7 -> 106
    //   102: aload_3
    //   103: invokevirtual 480	java/io/BufferedWriter:close	()V
    //   106: return
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_2
    //   112: astore_1
    //   113: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   116: ifeq +14 -> 130
    //   119: aload_2
    //   120: astore_1
    //   121: ldc 160
    //   123: iconst_2
    //   124: ldc 235
    //   126: aload_3
    //   127: invokestatic 483	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   130: aload_2
    //   131: ifnull -25 -> 106
    //   134: aload_2
    //   135: invokevirtual 480	java/io/BufferedWriter:close	()V
    //   138: return
    //   139: astore_1
    //   140: return
    //   141: astore_3
    //   142: aload_1
    //   143: astore_2
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull +7 -> 154
    //   150: aload_2
    //   151: invokevirtual 480	java/io/BufferedWriter:close	()V
    //   154: aload_1
    //   155: athrow
    //   156: astore_1
    //   157: return
    //   158: astore_2
    //   159: goto -5 -> 154
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -19 -> 146
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload_1
    //   172: astore_3
    //   173: goto -62 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	annz
    //   0	176	1	paramString	String
    //   0	176	2	paramStringBuilder	StringBuilder
    //   23	80	3	localBufferedWriter	java.io.BufferedWriter
    //   107	20	3	localThrowable	Throwable
    //   141	29	3	localObject1	Object
    //   172	1	3	str	String
    //   25	84	4	localObject2	Object
    //   10	30	5	localFile1	File
    //   20	54	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   29	37	107	java/lang/Throwable
    //   39	45	107	java/lang/Throwable
    //   47	55	107	java/lang/Throwable
    //   57	63	107	java/lang/Throwable
    //   65	86	107	java/lang/Throwable
    //   134	138	139	java/io/IOException
    //   29	37	141	finally
    //   39	45	141	finally
    //   47	55	141	finally
    //   57	63	141	finally
    //   65	86	141	finally
    //   113	119	141	finally
    //   121	130	141	finally
    //   102	106	156	java/io/IOException
    //   150	154	158	java/io/IOException
    //   86	98	162	finally
    //   86	98	168	java/lang/Throwable
  }
  
  private void dSw()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = new File(this.bos);
    boolean bool;
    if (((localObject == null) || (((File)localObject).list() == null)) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("checkFDCount file:");
      if (localObject != null) {
        break label209;
      }
      bool = true;
      QLog.d("FDStats", 2, bool);
    }
    int i;
    int j;
    for (;;)
    {
      try
      {
        i = ((File)localObject).list().length;
      }
      catch (NullPointerException localNullPointerException1)
      {
        label209:
        i = 0;
      }
      try
      {
        anpc.dKS = i;
        anpc.anr = System.currentTimeMillis();
        this.bGJ = 0;
        j = i;
        localObject = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
        if (j == 0)
        {
          l2 = ((SharedPreferences)localObject).getLong("key_last_count_failed_time", 0L);
          if ((System.currentTimeMillis() - l2 > 86400000L) && (l2 != 0L))
          {
            anpc.a(BaseApplicationImpl.getApplication().getApplicationContext()).collectPerformance(null, "fdCountFailed", true, 0L, 0L, null, null);
            ((SharedPreferences)localObject).edit().putLong("key_last_count_failed_time", System.currentTimeMillis()).commit();
          }
        }
        if ((this.cIN) || (this.cpb)) {
          break label241;
        }
        return;
      }
      catch (NullPointerException localNullPointerException2)
      {
        int k;
        long l3;
        long l4;
        int m;
        Message localMessage;
        break label219;
      }
      bool = false;
      break;
      label219:
      if (QLog.isColorLevel()) {
        QLog.e("FDStats", 2, localNullPointerException1.toString());
      }
      j = i;
    }
    label241:
    k = 0;
    long l2 = System.currentTimeMillis();
    l3 = localNullPointerException1.getLong("key_last_report", 0L);
    l4 = localNullPointerException1.getLong("key_last_threadhold_report", 0L);
    if (j >= 800)
    {
      m = localNullPointerException1.getInt("key_last_threadhold_size", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "lastReportTime:" + l3 + " lastThreadHoldTime:" + l4 + " lastSize:" + m);
      }
      if (Math.abs(l2 - l4) <= 86400000L)
      {
        i = k;
        if (j - m < 100) {}
      }
      else
      {
        k = 1;
        a(this.cfs, true, false);
        Qj(true);
        localNullPointerException1.edit().putLong("key_last_threadhold_report", l2).commit();
        localNullPointerException1.edit().putInt("key_last_threadhold_size", j).commit();
        i = k;
        if (this.mHandler != null)
        {
          localMessage = Message.obtain();
          localMessage.obj = Long.valueOf(l3);
          localMessage.what = 1004;
          this.mHandler.sendMessageDelayed(localMessage, 500L);
          i = k;
        }
      }
    }
    for (;;)
    {
      if ((j > 900) && (i != 0) && (this.mHandler != null)) {
        this.mHandler.sendEmptyMessage(1005);
      }
      l2 = System.currentTimeMillis();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FDStats", 2, "checkFDCount count:" + j + " time:" + (l2 - l1));
      return;
      i = k;
      if (Math.abs(l2 - l3) > 43200000L)
      {
        i = k;
        if (j > 800)
        {
          k = 1;
          a(this.cfs, true, false);
          i = k;
          if (this.mHandler != null)
          {
            this.mHandler.sendEmptyMessage(1002);
            i = k;
          }
        }
      }
    }
  }
  
  final String Ai()
  {
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.batteryCfg.name());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("#")))
    {
      localObject = ((String)localObject).split("#");
      if (localObject.length > 2) {
        return localObject[2];
      }
      return "";
    }
    return "";
  }
  
  void Qj(boolean paramBoolean)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
    long l2 = ((SharedPreferences)localObject1).getLong("key_last_report", 0L);
    long l1 = System.currentTimeMillis();
    Object localObject2;
    if ((Math.abs(l1 - l2) > 43200000L) || (paramBoolean))
    {
      localObject2 = a(l2, l1);
      if (localObject2 == null) {
        break label413;
      }
      ((SharedPreferences)localObject1).edit().putLong("key_last_report", l1).commit();
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fileObj1", ((File)localObject2).getAbsolutePath());
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("p_id", MagnifierSDK.getProductId());
        ((JSONObject)localObject2).put("plugin", String.valueOf(137));
        ((JSONObject)localObject2).put("newplugin", String.valueOf(137));
        ((JSONObject)localObject1).put("newplugin", String.valueOf(137));
        ((JSONObject)localObject1).put("fileObj", localJSONObject);
        ((JSONObject)localObject1).put("clientinfo", localObject2);
      }
      catch (Throwable localThrowable)
      {
        QLog.e("FDStats", 2, "report fail.", localThrowable);
        continue;
      }
      try
      {
        localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().waitAppRuntime(null);
        if (localObject2 == null) {
          break label453;
        }
        l1 = Long.parseLong(((QQAppInterface)localObject2).getCurrentUin());
      }
      catch (Exception localException)
      {
        QLog.e("FDStats", 2, "reportFileToAPM get uin " + 0L);
        l1 = 0L;
        continue;
      }
      ReporterMachine.b(new ResultObject(0, "testcase", true, 1L, 1L, (JSONObject)localObject1, true, true, l1));
      localObject1 = formatDate(new Date(anpc.anr));
      annt.e(new Exception(String.format("FDStats countLastChecked: %d at %s", new Object[] { Integer.valueOf(anpc.dKS), localObject1 })), this.cft);
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "reportFileToAPM");
      }
      if (this.mHandler != null)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).obj = Long.valueOf(l2);
        ((Message)localObject1).what = 1004;
        this.mHandler.sendMessageDelayed((Message)localObject1, 500L);
      }
      return;
      label413:
      if (QLog.isColorLevel()) {
        QLog.d("FDStats", 2, "no file to report");
      }
      localThrowable.edit().putLong("key_last_report", l1).commit();
      continue;
      label453:
      l1 = 0L;
    }
  }
  
  File a(long paramLong1, long paramLong2)
  {
    Object localObject2;
    if (filePath == null)
    {
      localObject2 = null;
      return localObject2;
    }
    for (;;)
    {
      Object localObject1;
      int j;
      int i;
      try
      {
        localObject1 = new ArrayList();
        localObject2 = new File(filePath);
        if (!((File)localObject2).exists()) {
          return null;
        }
        localObject2 = ((File)localObject2).listFiles();
        j = localObject2.length;
        i = 0;
        if (i < j)
        {
          File localFile = localObject2[i];
          if (localFile.getName().contains(".zip")) {
            break label342;
          }
          long l = a(localFile, false);
          if ((l == -1L) || (l >= paramLong2) || (l <= paramLong1)) {
            break label342;
          }
          ((List)localObject1).add(localFile.getAbsolutePath());
        }
      }
      catch (Throwable localThrowable1)
      {
        localObject1 = null;
      }
      for (;;)
      {
        for (;;)
        {
          localObject2 = localObject1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("FDStats", 2, "", localThrowable1);
          return localObject1;
          if (cfu != null)
          {
            localObject2 = new File(cfu);
            if (((File)localObject2).exists())
            {
              localObject2 = ((File)localObject2).listFiles();
              j = localObject2.length;
              i = 0;
              while (i < j)
              {
                ((List)localObject1).add(localObject2[i].getAbsolutePath());
                i += 1;
              }
            }
          }
          if (((List)localObject1).size() <= 0) {
            break label335;
          }
          localObject2 = filePath + paramLong2 + ".zip";
          if (aqhq.zipFiles((List)localObject1, (String)localObject2)) {
            localObject1 = new File((String)localObject2);
          }
          label335:
          try
          {
            boolean bool = ((File)localObject1).exists();
            localObject2 = localObject1;
            if (bool) {
              break;
            }
            return null;
          }
          catch (Throwable localThrowable2) {}
        }
        QLog.e("FDStats", 2, "zip fail");
        QQ(filePath);
        QQ(cfu);
        return null;
      }
      label342:
      i += 1;
    }
  }
  
  void cleanStorage(long paramLong)
  {
    int j = 0;
    if (filePath == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new File(filePath);
        if (!((File)localObject).exists()) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        int k = localObject.length;
        i = 0;
        if (i < k)
        {
          File localFile = localObject[i];
          long l = a(localFile, true);
          if ((l == -1L) || (l >= paramLong)) {
            break label220;
          }
          localFile.delete();
          break label220;
        }
        if (cfu != null)
        {
          localObject = new File(cfu);
          if ((((File)localObject).exists()) && (paramLong > 0L) && (System.currentTimeMillis() - paramLong > 86400000L))
          {
            localObject = ((File)localObject).listFiles();
            k = localObject.length;
            i = j;
            if (i < k)
            {
              localObject[i].delete();
              i += 1;
              continue;
            }
          }
        }
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FDStats", 2, "", localThrowable);
        }
      }
      QLog.d("FDStats", 2, "cleanStorage " + paramLong);
      return;
      label220:
      i += 1;
    }
  }
  
  void dRN()
  {
    
    aenj localaenj;
    boolean bool;
    if ((!this.dO.get()) && (FDNative.ayz()))
    {
      localaenj = (aenj)aeif.a().o(546);
      if ((localaenj == null) || (localaenj.cOb != 1)) {
        break label224;
      }
      bool = true;
      if (localaenj == null) {
        break label229;
      }
    }
    label224:
    label229:
    for (int i = localaenj.cOb;; i = 0)
    {
      QLog.d("FDStats", 1, new Object[] { "startHook shouldHook:", Boolean.valueOf(bool), " fdSwitch:", Integer.valueOf(i) });
      if (bool)
      {
        i = new Random().nextInt(3);
        FDNative.a();
        FDNative.nativeInit(false, true, 1);
        FDNative.a();
        FDNative.nativeRegister(".*\\.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libjavacore.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libEGL.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libsqlite_qq.so$");
        FDNative.a();
        FDNative.nativeIgnore(".*/libBugly-rqd.so$");
        FDNative.a();
        FDNative.nativeStart();
        this.dO.set(true);
        QLog.d("FDStats", 1, new Object[] { "fd hook start mode:", Integer.valueOf(i) });
      }
      return;
      bool = false;
      break;
    }
  }
  
  void dSA()
  {
    if (cfu == null) {
      cfu = Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/fdbc/";
    }
    File localFile = new File(cfu);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    FDNative.a().QP(cfu);
  }
  
  public void dSB()
  {
    dSA();
  }
  
  public void dSv()
  {
    if (!this.cpb) {}
    while (this.mHandler == null) {
      return;
    }
    this.mHandler.sendEmptyMessage(1006);
  }
  
  /* Error */
  void dSx()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: getfield 343	annz:dKp	I
    //   6: ifeq +4 -> 10
    //   9: return
    //   10: invokestatic 233	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   13: astore_1
    //   14: aload_1
    //   15: iconst_3
    //   16: anewarray 54	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 805
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: ldc_w 807
    //   30: aastore
    //   31: dup
    //   32: iconst_2
    //   33: ldc_w 809
    //   36: aastore
    //   37: invokevirtual 812	java/lang/Runtime:exec	([Ljava/lang/String;)Ljava/lang/Process;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +126 -> 168
    //   45: aload_1
    //   46: invokevirtual 256	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   49: astore_1
    //   50: new 258	java/io/BufferedReader
    //   53: dup
    //   54: new 260	java/io/InputStreamReader
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 263	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   62: sipush 7777
    //   65: invokespecial 815	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 269	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore 5
    //   75: aload_3
    //   76: astore 4
    //   78: aload_1
    //   79: astore_2
    //   80: aload 5
    //   82: ifnull +91 -> 173
    //   85: invokestatic 158	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +30 -> 118
    //   91: ldc 160
    //   93: iconst_2
    //   94: new 79	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   101: ldc_w 817
    //   104: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 5
    //   109: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: invokevirtual 101	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 166	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: aload 5
    //   121: invokestatic 820	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   124: putfield 343	annz:dKp	I
    //   127: goto -58 -> 69
    //   130: astore 4
    //   132: aload_1
    //   133: astore_2
    //   134: aload_3
    //   135: astore_1
    //   136: aload 4
    //   138: astore_3
    //   139: ldc 160
    //   141: iconst_1
    //   142: ldc_w 281
    //   145: aload_3
    //   146: invokestatic 677	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: aload_1
    //   150: ifnull +7 -> 157
    //   153: aload_1
    //   154: invokevirtual 285	java/io/BufferedReader:close	()V
    //   157: aload_2
    //   158: ifnull -149 -> 9
    //   161: aload_2
    //   162: invokevirtual 288	java/io/InputStream:close	()V
    //   165: return
    //   166: astore_1
    //   167: return
    //   168: aconst_null
    //   169: astore 4
    //   171: aconst_null
    //   172: astore_2
    //   173: aload 4
    //   175: ifnull +8 -> 183
    //   178: aload 4
    //   180: invokevirtual 285	java/io/BufferedReader:close	()V
    //   183: aload_2
    //   184: ifnull -175 -> 9
    //   187: aload_2
    //   188: invokevirtual 288	java/io/InputStream:close	()V
    //   191: return
    //   192: astore_1
    //   193: return
    //   194: astore_2
    //   195: aconst_null
    //   196: astore_3
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_3
    //   200: ifnull +7 -> 207
    //   203: aload_3
    //   204: invokevirtual 285	java/io/BufferedReader:close	()V
    //   207: aload_1
    //   208: ifnull +7 -> 215
    //   211: aload_1
    //   212: invokevirtual 288	java/io/InputStream:close	()V
    //   215: aload_2
    //   216: athrow
    //   217: astore_1
    //   218: goto -35 -> 183
    //   221: astore_1
    //   222: goto -65 -> 157
    //   225: astore_3
    //   226: goto -19 -> 207
    //   229: astore_1
    //   230: goto -15 -> 215
    //   233: astore_2
    //   234: aconst_null
    //   235: astore_3
    //   236: goto -37 -> 199
    //   239: astore_2
    //   240: goto -41 -> 199
    //   243: astore_3
    //   244: aload_2
    //   245: astore 4
    //   247: aload_3
    //   248: astore_2
    //   249: aload_1
    //   250: astore_3
    //   251: aload 4
    //   253: astore_1
    //   254: goto -55 -> 199
    //   257: astore_3
    //   258: aconst_null
    //   259: astore_1
    //   260: goto -121 -> 139
    //   263: astore_3
    //   264: aconst_null
    //   265: astore 4
    //   267: aload_1
    //   268: astore_2
    //   269: aload 4
    //   271: astore_1
    //   272: goto -133 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	275	0	this	annz
    //   13	141	1	localObject1	Object
    //   166	1	1	localIOException1	java.io.IOException
    //   192	1	1	localIOException2	java.io.IOException
    //   198	14	1	localObject2	Object
    //   217	1	1	localIOException3	java.io.IOException
    //   221	1	1	localIOException4	java.io.IOException
    //   229	21	1	localIOException5	java.io.IOException
    //   253	19	1	localObject3	Object
    //   1	187	2	localObject4	Object
    //   194	22	2	localObject5	Object
    //   233	1	2	localObject6	Object
    //   239	6	2	localObject7	Object
    //   248	21	2	localObject8	Object
    //   68	136	3	localObject9	Object
    //   225	1	3	localIOException6	java.io.IOException
    //   235	1	3	localObject10	Object
    //   243	5	3	localObject11	Object
    //   250	1	3	localIOException7	java.io.IOException
    //   257	1	3	localThrowable1	Throwable
    //   263	1	3	localThrowable2	Throwable
    //   76	1	4	localObject12	Object
    //   130	7	4	localThrowable3	Throwable
    //   169	101	4	localObject13	Object
    //   73	47	5	str	String
    // Exception table:
    //   from	to	target	type
    //   69	75	130	java/lang/Throwable
    //   85	118	130	java/lang/Throwable
    //   118	127	130	java/lang/Throwable
    //   161	165	166	java/io/IOException
    //   187	191	192	java/io/IOException
    //   14	41	194	finally
    //   45	50	194	finally
    //   178	183	217	java/io/IOException
    //   153	157	221	java/io/IOException
    //   203	207	225	java/io/IOException
    //   211	215	229	java/io/IOException
    //   50	69	233	finally
    //   69	75	239	finally
    //   85	118	239	finally
    //   118	127	239	finally
    //   139	149	243	finally
    //   14	41	257	java/lang/Throwable
    //   45	50	257	java/lang/Throwable
    //   50	69	263	java/lang/Throwable
  }
  
  void dSy() {}
  
  void dSz()
  {
    QQ(Environment.getExternalStorageDirectory().getPath() + "/tencent/MobileQQ/fdmon/");
  }
  
  String formatDate(Date paramDate)
  {
    try
    {
      paramDate = ((SimpleDateFormat)x.get()).format(paramDate);
      return paramDate;
    }
    catch (Exception paramDate) {}
    return "";
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      dSx();
      this.mHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      dSw();
      this.mHandler.sendEmptyMessageDelayed(1001, 120000L);
      continue;
      Qj(false);
      continue;
      cleanStorage(((Long)paramMessage.obj).longValue());
      continue;
      dSy();
      continue;
      dSw();
    }
  }
  
  public void iz(String paramString)
  {
    try
    {
      dSB();
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("FDStats", 1, "analyseCurFD on crash error", paramString);
    }
  }
  
  public void start()
  {
    boolean bool = true;
    label277:
    for (;;)
    {
      try
      {
        dSz();
        if (this.mStarted)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FDStats", 2, "already start");
          }
          return;
        }
        Object localObject1 = Ai();
        try
        {
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            continue;
          }
          Object localObject3 = ((String)localObject1).split(";");
          localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0);
          long l = ((SharedPreferences)localObject1).getLong("last_rand_timestamp", 0L);
          String str = ((SharedPreferences)localObject1).getString("rand_factor", "");
          localObject3 = localObject3[1];
          if ((Math.abs(System.currentTimeMillis() - l) > 43200000L) || (!str.equals(localObject3))) {
            ((SharedPreferences)localObject1).edit().putLong("last_rand_timestamp", System.currentTimeMillis()).putString("rand_factor", (String)localObject3).commit();
          }
          if (Math.random() >= Float.valueOf((String)localObject3).floatValue()) {
            break label277;
          }
          if (bool) {
            dRN();
          }
          QLog.d("FDStats", 1, new Object[] { "enable background, enableHook:", Boolean.valueOf(bool), " new random.", str, ", ", localObject3 });
          this.cIN = false;
          this.cpb = true;
          this.mStarted = true;
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.d("FDStats", 2, localException.toString());
          continue;
          bool = false;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     annz
 * JD-Core Version:    0.7.0.1
 */