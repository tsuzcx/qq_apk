import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.biz.qrcode.ipc.ScannerParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QWalletHelper;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.manager.WtloginManager;
import org.json.JSONObject;

public class zmk
{
  public static int a;
  public static String a;
  private static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "addDisSource";
    jdField_a_of_type_Int = 1;
  }
  
  private static int a()
  {
    int i = 0;
    try
    {
      int k = bjuq.a(1, "ANY", "UTF-8");
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int j = bjuq.a((int[])localObject, localObject.length);
      localObject = bjuq.a();
      if (QLog.isDevelopLevel()) {
        QLog.d("ScannerUtils", 4, "initQbar init_result1:" + k + ",init_result2:" + j + "version:" + (String)localObject);
      }
      if ((k < 0) || (j < 0)) {
        i = -1;
      }
      return i;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScannerUtils", 1, "initQbar failed:", localThrowable);
    }
    return -1;
  }
  
  /* Error */
  private static int a(Context paramContext, Uri paramUri, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iload_2
    //   1: iload_3
    //   2: iconst_2
    //   3: imul
    //   4: if_icmplt +488 -> 492
    //   7: iload_3
    //   8: sipush 1280
    //   11: if_icmpge +481 -> 492
    //   14: iconst_1
    //   15: istore 9
    //   17: iload_2
    //   18: iconst_2
    //   19: imul
    //   20: iload_3
    //   21: if_icmpgt +477 -> 498
    //   24: iload_2
    //   25: sipush 1280
    //   28: if_icmpge +470 -> 498
    //   31: iconst_1
    //   32: istore 10
    //   34: aload_0
    //   35: invokevirtual 81	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: astore 13
    //   40: iconst_0
    //   41: istore 6
    //   43: iconst_0
    //   44: istore 8
    //   46: iconst_0
    //   47: istore 7
    //   49: iconst_0
    //   50: istore 5
    //   52: iload 10
    //   54: ifeq +450 -> 504
    //   57: aload 13
    //   59: aload_1
    //   60: invokevirtual 87	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   63: astore 12
    //   65: aload 12
    //   67: astore_0
    //   68: aload 12
    //   70: astore 11
    //   72: iload 8
    //   74: istore 6
    //   76: aload 12
    //   78: invokestatic 93	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   81: astore 14
    //   83: aload 12
    //   85: astore_0
    //   86: aload 12
    //   88: astore 11
    //   90: iload 8
    //   92: istore 6
    //   94: aload 12
    //   96: invokevirtual 98	java/io/InputStream:close	()V
    //   99: iload 7
    //   101: istore 6
    //   103: iload_2
    //   104: iload_2
    //   105: imul
    //   106: newarray int
    //   108: astore_0
    //   109: iload 7
    //   111: istore 6
    //   113: aload 14
    //   115: aload_0
    //   116: iconst_0
    //   117: iload_2
    //   118: iconst_0
    //   119: iconst_0
    //   120: iload_2
    //   121: iload_2
    //   122: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   125: iload 7
    //   127: istore 6
    //   129: iload_2
    //   130: iload_2
    //   131: imul
    //   132: newarray byte
    //   134: astore 11
    //   136: iload 7
    //   138: istore 6
    //   140: aload_0
    //   141: aload 11
    //   143: iload_2
    //   144: iload_2
    //   145: invokestatic 110	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   148: pop
    //   149: iload 7
    //   151: istore 6
    //   153: iconst_0
    //   154: aload_0
    //   155: aload 11
    //   157: iload_2
    //   158: iload_2
    //   159: aload 4
    //   161: invokestatic 113	zmk:a	([I[BIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   164: ior
    //   165: istore 5
    //   167: iload 5
    //   169: istore 6
    //   171: aload 4
    //   173: invokevirtual 117	com/tencent/biz/qrcode/activity/ScannerResult:d	()Z
    //   176: ifne +702 -> 878
    //   179: iload 5
    //   181: istore 6
    //   183: aload 14
    //   185: aload_0
    //   186: iconst_0
    //   187: iload_2
    //   188: iconst_0
    //   189: iload_3
    //   190: iload_2
    //   191: isub
    //   192: iload_2
    //   193: iload_2
    //   194: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   197: iload 5
    //   199: istore 6
    //   201: aload_0
    //   202: aload 11
    //   204: iload_2
    //   205: iload_2
    //   206: invokestatic 110	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   209: pop
    //   210: iload 5
    //   212: istore 6
    //   214: aload_0
    //   215: aload 11
    //   217: iload_2
    //   218: iload_2
    //   219: aload 4
    //   221: invokestatic 113	zmk:a	([I[BIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   224: istore 7
    //   226: iload 7
    //   228: iload 5
    //   230: ior
    //   231: istore 5
    //   233: iload 5
    //   235: istore 6
    //   237: aload 14
    //   239: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   242: iload 5
    //   244: istore 6
    //   246: iload_2
    //   247: iload_3
    //   248: invokestatic 126	java/lang/Math:min	(II)I
    //   251: istore_2
    //   252: iload 5
    //   254: istore 6
    //   256: aload 4
    //   258: invokevirtual 117	com/tencent/biz/qrcode/activity/ScannerResult:d	()Z
    //   261: ifne +606 -> 867
    //   264: iload_2
    //   265: sipush 250
    //   268: if_icmple +599 -> 867
    //   271: iload 5
    //   273: istore 6
    //   275: new 128	android/graphics/BitmapFactory$Options
    //   278: dup
    //   279: invokespecial 129	android/graphics/BitmapFactory$Options:<init>	()V
    //   282: astore 12
    //   284: iload 5
    //   286: istore 6
    //   288: aload 12
    //   290: iload_2
    //   291: i2d
    //   292: ldc2_w 130
    //   295: ddiv
    //   296: invokestatic 135	java/lang/Math:ceil	(D)D
    //   299: d2i
    //   300: putfield 138	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   303: iload 5
    //   305: istore 6
    //   307: aload 13
    //   309: aload_1
    //   310: invokevirtual 87	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   313: astore_1
    //   314: aload_1
    //   315: astore_0
    //   316: aload_1
    //   317: astore 11
    //   319: iload 5
    //   321: istore 6
    //   323: aload_1
    //   324: aconst_null
    //   325: aload 12
    //   327: invokestatic 141	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   330: astore 12
    //   332: aload_1
    //   333: astore_0
    //   334: aload_1
    //   335: astore 11
    //   337: iload 5
    //   339: istore 6
    //   341: aload_1
    //   342: invokevirtual 98	java/io/InputStream:close	()V
    //   345: iload 5
    //   347: istore 6
    //   349: aload 12
    //   351: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   354: istore_2
    //   355: iload 5
    //   357: istore 6
    //   359: aload 12
    //   361: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   364: istore_3
    //   365: iload 5
    //   367: istore 6
    //   369: iload_2
    //   370: iload_3
    //   371: imul
    //   372: newarray int
    //   374: astore_0
    //   375: iload 5
    //   377: istore 6
    //   379: aload 12
    //   381: aload_0
    //   382: iconst_0
    //   383: iload_2
    //   384: iconst_0
    //   385: iconst_0
    //   386: iload_2
    //   387: iload_3
    //   388: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   391: iload 5
    //   393: istore 6
    //   395: aload 12
    //   397: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   400: iload 5
    //   402: istore 6
    //   404: aload_0
    //   405: aconst_null
    //   406: iload_2
    //   407: iload_3
    //   408: aload 4
    //   410: invokestatic 113	zmk:a	([I[BIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   413: istore_2
    //   414: iload 5
    //   416: iload_2
    //   417: ior
    //   418: istore_2
    //   419: aconst_null
    //   420: astore_0
    //   421: aload 4
    //   423: invokevirtual 149	com/tencent/biz/qrcode/activity/ScannerResult:a	()V
    //   426: iload_2
    //   427: istore_3
    //   428: aload_0
    //   429: ifnull +9 -> 438
    //   432: aload_0
    //   433: invokevirtual 98	java/io/InputStream:close	()V
    //   436: iload_2
    //   437: istore_3
    //   438: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +49 -> 490
    //   444: ldc 43
    //   446: iconst_2
    //   447: new 45	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   454: ldc 154
    //   456: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: iload 9
    //   461: invokevirtual 157	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   464: ldc 159
    //   466: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: iload 10
    //   471: invokevirtual 157	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   474: ldc 161
    //   476: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: aload 4
    //   481: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   484: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   490: iload_3
    //   491: ireturn
    //   492: iconst_0
    //   493: istore 9
    //   495: goto -478 -> 17
    //   498: iconst_0
    //   499: istore 10
    //   501: goto -467 -> 34
    //   504: iload 9
    //   506: ifeq -264 -> 242
    //   509: aload 13
    //   511: aload_1
    //   512: invokevirtual 87	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   515: astore 12
    //   517: aload 12
    //   519: astore_0
    //   520: aload 12
    //   522: astore 11
    //   524: iload 8
    //   526: istore 6
    //   528: aload 12
    //   530: invokestatic 93	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   533: astore 14
    //   535: aload 12
    //   537: astore_0
    //   538: aload 12
    //   540: astore 11
    //   542: iload 8
    //   544: istore 6
    //   546: aload 12
    //   548: invokevirtual 98	java/io/InputStream:close	()V
    //   551: iload 7
    //   553: istore 6
    //   555: iload_3
    //   556: iload_3
    //   557: imul
    //   558: newarray int
    //   560: astore_0
    //   561: iload 7
    //   563: istore 6
    //   565: aload 14
    //   567: aload_0
    //   568: iconst_0
    //   569: iload_3
    //   570: iconst_0
    //   571: iconst_0
    //   572: iload_3
    //   573: iload_3
    //   574: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   577: iload 7
    //   579: istore 6
    //   581: iload_3
    //   582: iload_3
    //   583: imul
    //   584: newarray byte
    //   586: astore 11
    //   588: iload 7
    //   590: istore 6
    //   592: aload_0
    //   593: aload 11
    //   595: iload_3
    //   596: iload_3
    //   597: invokestatic 110	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   600: pop
    //   601: iload 7
    //   603: istore 6
    //   605: iconst_0
    //   606: aload_0
    //   607: aload 11
    //   609: iload_3
    //   610: iload_3
    //   611: aload 4
    //   613: invokestatic 113	zmk:a	([I[BIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   616: ior
    //   617: istore 5
    //   619: iload 5
    //   621: istore 6
    //   623: aload 4
    //   625: invokevirtual 117	com/tencent/biz/qrcode/activity/ScannerResult:d	()Z
    //   628: ifne +247 -> 875
    //   631: iload 5
    //   633: istore 6
    //   635: aload 14
    //   637: aload_0
    //   638: iconst_0
    //   639: iload_3
    //   640: iload_2
    //   641: iload_3
    //   642: isub
    //   643: iconst_0
    //   644: iload_3
    //   645: iload_3
    //   646: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   649: iload 5
    //   651: istore 6
    //   653: aload_0
    //   654: aload 11
    //   656: iload_3
    //   657: iload_3
    //   658: invokestatic 110	com/tencent/imageboost/ImgProcessScan:TransBytes	([I[BII)I
    //   661: pop
    //   662: iload 5
    //   664: istore 6
    //   666: aload_0
    //   667: aload 11
    //   669: iload_3
    //   670: iload_3
    //   671: aload 4
    //   673: invokestatic 113	zmk:a	([I[BIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   676: istore 7
    //   678: iload 7
    //   680: iload 5
    //   682: ior
    //   683: istore 5
    //   685: iload 5
    //   687: istore 6
    //   689: aload 14
    //   691: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   694: goto -452 -> 242
    //   697: astore_0
    //   698: aload_0
    //   699: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   702: ldc 43
    //   704: iconst_1
    //   705: ldc 169
    //   707: aload_0
    //   708: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   711: iload_2
    //   712: istore_3
    //   713: goto -275 -> 438
    //   716: astore_1
    //   717: aconst_null
    //   718: astore_0
    //   719: iload 6
    //   721: istore_2
    //   722: aload_1
    //   723: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   726: ldc 43
    //   728: iconst_1
    //   729: ldc 174
    //   731: aload_1
    //   732: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   735: iload_2
    //   736: istore_3
    //   737: aload_0
    //   738: ifnull -300 -> 438
    //   741: aload_0
    //   742: invokevirtual 98	java/io/InputStream:close	()V
    //   745: iload_2
    //   746: istore_3
    //   747: goto -309 -> 438
    //   750: astore_0
    //   751: aload_0
    //   752: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   755: ldc 43
    //   757: iconst_1
    //   758: ldc 169
    //   760: aload_0
    //   761: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   764: iload_2
    //   765: istore_3
    //   766: goto -328 -> 438
    //   769: astore_0
    //   770: aconst_null
    //   771: astore_1
    //   772: aload_1
    //   773: ifnull +7 -> 780
    //   776: aload_1
    //   777: invokevirtual 98	java/io/InputStream:close	()V
    //   780: aload_0
    //   781: athrow
    //   782: astore_1
    //   783: aload_1
    //   784: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   787: ldc 43
    //   789: iconst_1
    //   790: ldc 169
    //   792: aload_1
    //   793: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   796: goto -16 -> 780
    //   799: astore 4
    //   801: aload_0
    //   802: astore_1
    //   803: aload 4
    //   805: astore_0
    //   806: goto -34 -> 772
    //   809: aconst_null
    //   810: astore_1
    //   811: astore_0
    //   812: goto -40 -> 772
    //   815: astore 4
    //   817: aload_0
    //   818: astore_1
    //   819: aload 4
    //   821: astore_0
    //   822: goto -50 -> 772
    //   825: astore 4
    //   827: aload_0
    //   828: astore_1
    //   829: aload 4
    //   831: astore_0
    //   832: goto -60 -> 772
    //   835: astore_1
    //   836: aload 11
    //   838: astore_0
    //   839: iload 6
    //   841: istore_2
    //   842: goto -120 -> 722
    //   845: astore_1
    //   846: aconst_null
    //   847: astore_0
    //   848: iload 6
    //   850: istore_2
    //   851: goto -129 -> 722
    //   854: astore_1
    //   855: aconst_null
    //   856: astore_0
    //   857: iload 6
    //   859: istore_2
    //   860: goto -138 -> 722
    //   863: astore_1
    //   864: goto -142 -> 722
    //   867: iload 5
    //   869: istore_2
    //   870: aconst_null
    //   871: astore_0
    //   872: goto -451 -> 421
    //   875: goto -190 -> 685
    //   878: goto -645 -> 233
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	881	0	paramContext	Context
    //   0	881	1	paramUri	Uri
    //   0	881	2	paramInt1	int
    //   0	881	3	paramInt2	int
    //   0	881	4	paramScannerResult	ScannerResult
    //   50	818	5	i	int
    //   41	817	6	j	int
    //   47	636	7	k	int
    //   44	499	8	m	int
    //   15	490	9	bool1	boolean
    //   32	468	10	bool2	boolean
    //   70	767	11	localObject1	Object
    //   63	484	12	localObject2	Object
    //   38	472	13	localContentResolver	android.content.ContentResolver
    //   81	609	14	localBitmap	Bitmap
    // Exception table:
    //   from	to	target	type
    //   432	436	697	java/lang/Throwable
    //   57	65	716	java/lang/Throwable
    //   246	252	716	java/lang/Throwable
    //   256	264	716	java/lang/Throwable
    //   275	284	716	java/lang/Throwable
    //   288	303	716	java/lang/Throwable
    //   307	314	716	java/lang/Throwable
    //   509	517	716	java/lang/Throwable
    //   741	745	750	java/lang/Throwable
    //   57	65	769	finally
    //   246	252	769	finally
    //   256	264	769	finally
    //   275	284	769	finally
    //   288	303	769	finally
    //   307	314	769	finally
    //   509	517	769	finally
    //   776	780	782	java/lang/Throwable
    //   76	83	799	finally
    //   94	99	799	finally
    //   323	332	799	finally
    //   341	345	799	finally
    //   528	535	799	finally
    //   546	551	799	finally
    //   103	109	809	finally
    //   113	125	809	finally
    //   129	136	809	finally
    //   140	149	809	finally
    //   153	167	809	finally
    //   171	179	809	finally
    //   183	197	809	finally
    //   201	210	809	finally
    //   214	226	809	finally
    //   237	242	809	finally
    //   349	355	809	finally
    //   359	365	809	finally
    //   369	375	809	finally
    //   379	391	809	finally
    //   395	400	809	finally
    //   404	414	809	finally
    //   555	561	809	finally
    //   565	577	809	finally
    //   581	588	809	finally
    //   592	601	809	finally
    //   605	619	809	finally
    //   623	631	809	finally
    //   635	649	809	finally
    //   653	662	809	finally
    //   666	678	809	finally
    //   689	694	809	finally
    //   421	426	815	finally
    //   722	735	825	finally
    //   76	83	835	java/lang/Throwable
    //   94	99	835	java/lang/Throwable
    //   323	332	835	java/lang/Throwable
    //   341	345	835	java/lang/Throwable
    //   528	535	835	java/lang/Throwable
    //   546	551	835	java/lang/Throwable
    //   103	109	845	java/lang/Throwable
    //   113	125	845	java/lang/Throwable
    //   129	136	845	java/lang/Throwable
    //   140	149	845	java/lang/Throwable
    //   153	167	845	java/lang/Throwable
    //   171	179	845	java/lang/Throwable
    //   183	197	845	java/lang/Throwable
    //   201	210	845	java/lang/Throwable
    //   214	226	845	java/lang/Throwable
    //   349	355	845	java/lang/Throwable
    //   359	365	845	java/lang/Throwable
    //   369	375	845	java/lang/Throwable
    //   379	391	845	java/lang/Throwable
    //   395	400	845	java/lang/Throwable
    //   404	414	845	java/lang/Throwable
    //   555	561	845	java/lang/Throwable
    //   565	577	845	java/lang/Throwable
    //   581	588	845	java/lang/Throwable
    //   592	601	845	java/lang/Throwable
    //   605	619	845	java/lang/Throwable
    //   623	631	845	java/lang/Throwable
    //   635	649	845	java/lang/Throwable
    //   653	662	845	java/lang/Throwable
    //   666	678	845	java/lang/Throwable
    //   237	242	854	java/lang/Throwable
    //   689	694	854	java/lang/Throwable
    //   421	426	863	java/lang/Throwable
  }
  
  public static int a(Bitmap paramBitmap, boolean paramBoolean, int paramInt, SparseArray<Object> paramSparseArray)
  {
    paramBitmap = a(paramBitmap, paramInt);
    paramInt = 0;
    if (paramBitmap != null)
    {
      paramBitmap.a(paramSparseArray);
      paramInt = paramBitmap.a();
    }
    return paramInt;
  }
  
  private static int a(Bitmap paramBitmap, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, ScannerResult paramScannerResult)
  {
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[paramInt1 * paramInt2];
      ImgProcessScan.TransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      int i = 0;
      if ((paramInt3 & 0x1) == 1) {
        i = 0x0 | a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, paramScannerResult);
      }
      if ((paramInt3 & 0x2) == 2) {
        return a(paramBitmap, paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, paramScannerResult) | i;
      }
      return i;
    }
  }
  
  private static int a(Bitmap paramBitmap, int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    long l1 = System.currentTimeMillis();
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new byte[paramInt1 * paramInt2];
      ImgProcessScan.TransBytes(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      int j = 0;
      if ((RecogUtil.getSupportDetectType() >= 0) && (apnc.b())) {}
      for (boolean bool1 = true; bool1; bool1 = false)
      {
        paramScannerResult.jdField_a_of_type_Boolean = true;
        long l2 = System.currentTimeMillis();
        Object localObject = new ArrayList();
        boolean bool2 = apnc.a().a(paramBitmap, l2, (ArrayList)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("ScannerUtils", 2, String.format("parseMiniCode exec=%b, detectRects=%s", new Object[] { Boolean.valueOf(bool2), localObject }));
        }
        i = j;
        if (!bool2) {
          break label337;
        }
        i = j;
        if (((ArrayList)localObject).isEmpty()) {
          break label337;
        }
        paramBitmap = ((ArrayList)localObject).iterator();
        i = 0;
        while (paramBitmap.hasNext())
        {
          localObject = (apmz)paramBitmap.next();
          if (((apmz)localObject).jdField_a_of_type_Int == 2)
          {
            Rect localRect = new Rect();
            RecogUtil.scaleRect(((apmz)localObject).jdField_a_of_type_AndroidGraphicsRect, localRect, paramInt1, paramInt2, 1.2F);
            StringBuilder localStringBuilder = new StringBuilder();
            j = a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height(), localStringBuilder);
            if ((j & 0x2) != 0) {
              paramScannerResult.a(localStringBuilder.toString(), ((apmz)localObject).jdField_a_of_type_AndroidGraphicsRect, ((apmz)localObject).jdField_a_of_type_Float, paramInt1, paramInt2);
            }
            i = j | i;
          }
        }
      }
      paramScannerResult.jdField_a_of_type_Boolean = false;
      paramBitmap = new StringBuilder();
      paramInt1 = 0x0 | a(paramArrayOfInt, paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, paramBitmap);
      int i = paramInt1;
      if ((paramInt1 & 0x2) != 0)
      {
        paramScannerResult.a(paramBitmap.toString());
        i = paramInt1;
      }
      for (;;)
      {
        label337:
        if (QLog.isColorLevel()) {
          QLog.i("ScannerUtils", 2, String.format(new StringBuilder().append("parseMiniCode cost：").append(System.currentTimeMillis() - l1).toString(), new Object[0]) + " returnResult:" + i + " supportDetect:" + bool1);
        }
        return i;
      }
    }
  }
  
  public static int a(Uri paramUri, Context paramContext, int paramInt, SparseArray<Object> paramSparseArray)
  {
    paramUri = a(paramUri, paramContext, paramInt);
    paramInt = 0;
    if (paramUri != null)
    {
      paramUri.a(paramSparseArray);
      paramInt = paramUri.a();
    }
    return paramInt;
  }
  
  /* Error */
  private static int a(Uri paramUri, Context paramContext, int paramInt, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iload_2
    //   1: iconst_3
    //   2: iand
    //   3: ifne +9 -> 12
    //   6: iconst_0
    //   7: istore 5
    //   9: iload 5
    //   11: ireturn
    //   12: iconst_0
    //   13: istore 5
    //   15: ldc2_w 303
    //   18: lstore 12
    //   20: aload_0
    //   21: invokevirtual 309	android/net/Uri:getPath	()Ljava/lang/String;
    //   24: invokestatic 315	com/tencent/sharpP/SharpPUtils:decodeSharpP	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   27: astore_0
    //   28: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   31: ifeq +29 -> 60
    //   34: ldc 43
    //   36: iconst_4
    //   37: new 45	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   44: ldc_w 317
    //   47: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: aload_0
    //   51: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: aload_0
    //   61: ifnull +394 -> 455
    //   64: aload_0
    //   65: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   68: istore 6
    //   70: aload_0
    //   71: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   74: istore 7
    //   76: iload 6
    //   78: iload 7
    //   80: invokestatic 320	bjuq:a	(II)Z
    //   83: ifne +5 -> 88
    //   86: iconst_0
    //   87: ireturn
    //   88: iload_2
    //   89: iconst_1
    //   90: iand
    //   91: iconst_1
    //   92: if_icmpne +357 -> 449
    //   95: invokestatic 321	zmk:a	()I
    //   98: pop
    //   99: iconst_1
    //   100: istore 4
    //   102: iload_2
    //   103: iconst_2
    //   104: iand
    //   105: iconst_2
    //   106: if_icmpne +332 -> 438
    //   109: lload 12
    //   111: lstore 8
    //   113: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   116: lstore 10
    //   118: lload 10
    //   120: lstore 8
    //   122: lload 10
    //   124: lstore 12
    //   126: lload 10
    //   128: ldc_w 323
    //   131: invokestatic 326	zmk:a	(JLjava/lang/String;)V
    //   134: iconst_1
    //   135: istore 5
    //   137: lload 10
    //   139: lstore 8
    //   141: iload 6
    //   143: iload 7
    //   145: imul
    //   146: newarray int
    //   148: astore_1
    //   149: aload_0
    //   150: aload_1
    //   151: iconst_0
    //   152: iload 6
    //   154: iconst_0
    //   155: iconst_0
    //   156: iload 6
    //   158: iload 7
    //   160: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   163: aload_0
    //   164: aload_1
    //   165: aconst_null
    //   166: iload 6
    //   168: iload 7
    //   170: iload_2
    //   171: aload_3
    //   172: invokestatic 328	zmk:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   175: istore 6
    //   177: iload 6
    //   179: iconst_0
    //   180: ior
    //   181: istore 6
    //   183: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   186: ifeq +38 -> 224
    //   189: ldc 43
    //   191: iconst_4
    //   192: ldc_w 330
    //   195: iconst_3
    //   196: anewarray 4	java/lang/Object
    //   199: dup
    //   200: iconst_0
    //   201: iload_2
    //   202: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   205: aastore
    //   206: dup
    //   207: iconst_1
    //   208: iload 6
    //   210: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: aastore
    //   214: dup
    //   215: iconst_2
    //   216: aload_3
    //   217: aastore
    //   218: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   221: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: aload_0
    //   225: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   228: iload 6
    //   230: istore_2
    //   231: iload 4
    //   233: istore 6
    //   235: iload 5
    //   237: istore 4
    //   239: iload 6
    //   241: ifeq +7 -> 248
    //   244: invokestatic 337	zmk:b	()I
    //   247: pop
    //   248: iload_2
    //   249: istore 5
    //   251: iload 4
    //   253: ifeq -244 -> 9
    //   256: lload 8
    //   258: ldc_w 323
    //   261: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   264: iload_2
    //   265: ireturn
    //   266: astore_0
    //   267: iconst_0
    //   268: istore_2
    //   269: iconst_0
    //   270: istore 4
    //   272: iconst_0
    //   273: istore 5
    //   275: ldc2_w 303
    //   278: lstore 8
    //   280: aload_0
    //   281: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   284: ldc 43
    //   286: iconst_1
    //   287: ldc_w 341
    //   290: aload_0
    //   291: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   294: iload 5
    //   296: ifeq +7 -> 303
    //   299: invokestatic 337	zmk:b	()I
    //   302: pop
    //   303: iload_2
    //   304: istore 5
    //   306: iload 4
    //   308: ifeq -299 -> 9
    //   311: lload 8
    //   313: ldc_w 323
    //   316: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   319: iload_2
    //   320: ireturn
    //   321: astore_0
    //   322: iconst_0
    //   323: istore 4
    //   325: lload 12
    //   327: lstore 8
    //   329: iload 5
    //   331: istore_2
    //   332: iload 4
    //   334: ifeq +7 -> 341
    //   337: invokestatic 337	zmk:b	()I
    //   340: pop
    //   341: iload_2
    //   342: ifeq +11 -> 353
    //   345: lload 8
    //   347: ldc_w 323
    //   350: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   353: aload_0
    //   354: athrow
    //   355: astore_0
    //   356: iload 5
    //   358: istore_2
    //   359: goto -27 -> 332
    //   362: astore_0
    //   363: iload 5
    //   365: istore_2
    //   366: goto -34 -> 332
    //   369: astore_0
    //   370: iload 4
    //   372: istore_2
    //   373: iload 5
    //   375: istore 4
    //   377: goto -45 -> 332
    //   380: astore_0
    //   381: lload 12
    //   383: lstore 8
    //   385: iconst_0
    //   386: istore 6
    //   388: iload 4
    //   390: istore 5
    //   392: iconst_0
    //   393: istore_2
    //   394: iload 6
    //   396: istore 4
    //   398: goto -118 -> 280
    //   401: astore_0
    //   402: iload 4
    //   404: istore 6
    //   406: iconst_0
    //   407: istore_2
    //   408: iload 5
    //   410: istore 4
    //   412: iload 6
    //   414: istore 5
    //   416: goto -136 -> 280
    //   419: astore_0
    //   420: iload 4
    //   422: istore 7
    //   424: iload 6
    //   426: istore_2
    //   427: iload 5
    //   429: istore 4
    //   431: iload 7
    //   433: istore 5
    //   435: goto -155 -> 280
    //   438: ldc2_w 303
    //   441: lstore 8
    //   443: iconst_0
    //   444: istore 5
    //   446: goto -305 -> 141
    //   449: iconst_0
    //   450: istore 4
    //   452: goto -350 -> 102
    //   455: ldc2_w 303
    //   458: lstore 8
    //   460: iconst_0
    //   461: istore 4
    //   463: iconst_0
    //   464: istore 6
    //   466: iconst_0
    //   467: istore_2
    //   468: goto -229 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	471	0	paramUri	Uri
    //   0	471	1	paramContext	Context
    //   0	471	2	paramInt	int
    //   0	471	3	paramScannerResult	ScannerResult
    //   100	362	4	i	int
    //   7	438	5	j	int
    //   68	397	6	k	int
    //   74	358	7	m	int
    //   111	348	8	l1	long
    //   116	22	10	l2	long
    //   18	364	12	l3	long
    // Exception table:
    //   from	to	target	type
    //   20	60	266	java/lang/Throwable
    //   64	86	266	java/lang/Throwable
    //   95	99	266	java/lang/Throwable
    //   20	60	321	finally
    //   64	86	321	finally
    //   95	99	321	finally
    //   113	118	355	finally
    //   126	134	355	finally
    //   141	177	362	finally
    //   183	224	362	finally
    //   224	228	362	finally
    //   280	294	369	finally
    //   113	118	380	java/lang/Throwable
    //   126	134	380	java/lang/Throwable
    //   141	177	401	java/lang/Throwable
    //   183	224	419	java/lang/Throwable
    //   224	228	419	java/lang/Throwable
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, StringBuilder paramStringBuilder)
  {
    paramArrayOfInt = apnc.a().a(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 1);
    if (apnc.a(paramArrayOfInt))
    {
      if (paramStringBuilder.length() > 0) {
        paramStringBuilder.delete(0, paramStringBuilder.length());
      }
      paramStringBuilder.append(paramArrayOfInt);
      return 2;
    }
    return 0;
  }
  
  private static int a(int[] paramArrayOfInt, byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    int i = 1;
    long l = System.currentTimeMillis();
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte == null)
    {
      arrayOfByte = new byte[paramInt1 * paramInt2];
      ImgProcessScan.TransBytes(paramArrayOfInt, arrayOfByte, paramInt1, paramInt2);
    }
    if (bjuq.a(arrayOfByte, paramInt1, paramInt2, 0) == 1) {
      paramScannerResult.jdField_a_of_type_JavaUtilArrayList = bjuq.a();
    }
    for (paramInt1 = i;; paramInt1 = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, String.format(new StringBuilder().append("parseQRCode cost：").append(System.currentTimeMillis() - l).toString(), new Object[0]) + " returnResult:" + paramInt1);
      }
      return paramInt1;
    }
  }
  
  public static Pair<StringBuilder, StringBuilder> a(Uri paramUri, Context paramContext)
  {
    paramUri = a(paramUri, paramContext, 1);
    if (paramUri != null) {
      return paramUri.a();
    }
    return null;
  }
  
  /* Error */
  public static ScannerResult a(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   10: aload_0
    //   11: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   14: invokestatic 320	bjuq:a	(II)Z
    //   17: ifne +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   25: ifeq +39 -> 64
    //   28: ldc 43
    //   30: iconst_4
    //   31: ldc_w 372
    //   34: iconst_2
    //   35: anewarray 4	java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   44: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_0
    //   51: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   54: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   61: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   67: lstore 12
    //   69: iconst_0
    //   70: istore_3
    //   71: iconst_0
    //   72: istore 5
    //   74: iconst_0
    //   75: istore_2
    //   76: iconst_0
    //   77: istore 4
    //   79: ldc2_w 303
    //   82: lstore 6
    //   84: new 115	com/tencent/biz/qrcode/activity/ScannerResult
    //   87: dup
    //   88: invokespecial 373	com/tencent/biz/qrcode/activity/ScannerResult:<init>	()V
    //   91: astore 14
    //   93: iload_1
    //   94: iconst_1
    //   95: iand
    //   96: iconst_1
    //   97: if_icmpne +360 -> 457
    //   100: lload 6
    //   102: lstore 8
    //   104: invokestatic 321	zmk:a	()I
    //   107: pop
    //   108: iconst_1
    //   109: istore_2
    //   110: iload_1
    //   111: iconst_2
    //   112: iand
    //   113: iconst_2
    //   114: if_icmpne +333 -> 447
    //   117: lload 6
    //   119: lstore 8
    //   121: lload 6
    //   123: lstore 10
    //   125: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   128: lstore 6
    //   130: lload 6
    //   132: lstore 8
    //   134: lload 6
    //   136: lstore 10
    //   138: lload 6
    //   140: ldc_w 375
    //   143: invokestatic 326	zmk:a	(JLjava/lang/String;)V
    //   146: iconst_1
    //   147: istore_3
    //   148: aload_0
    //   149: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   152: istore 4
    //   154: aload_0
    //   155: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   158: istore 5
    //   160: iload 4
    //   162: iload 5
    //   164: imul
    //   165: newarray int
    //   167: astore 15
    //   169: aload_0
    //   170: aload 15
    //   172: iconst_0
    //   173: iload 4
    //   175: iconst_0
    //   176: iconst_0
    //   177: iload 4
    //   179: iload 5
    //   181: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   184: aload_0
    //   185: aload 15
    //   187: aconst_null
    //   188: iload 4
    //   190: iload 5
    //   192: iload_1
    //   193: aload 14
    //   195: invokestatic 328	zmk:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   198: istore 4
    //   200: aload_0
    //   201: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   204: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   207: ifeq +41 -> 248
    //   210: ldc 43
    //   212: iconst_4
    //   213: ldc_w 377
    //   216: iconst_3
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: iload_1
    //   223: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   226: aastore
    //   227: dup
    //   228: iconst_1
    //   229: iload 4
    //   231: iconst_0
    //   232: ior
    //   233: invokestatic 335	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: aload 14
    //   241: aastore
    //   242: invokestatic 230	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   245: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   248: iload_2
    //   249: ifeq +7 -> 256
    //   252: invokestatic 337	zmk:b	()I
    //   255: pop
    //   256: iload_3
    //   257: ifeq +11 -> 268
    //   260: lload 6
    //   262: ldc_w 375
    //   265: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   268: invokestatic 41	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   271: ifeq +35 -> 306
    //   274: ldc_w 375
    //   277: iconst_4
    //   278: new 45	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   285: ldc_w 379
    //   288: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   294: lload 12
    //   296: lsub
    //   297: invokevirtual 292	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 68	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: aload 14
    //   308: invokevirtual 380	com/tencent/biz/qrcode/activity/ScannerResult:b	()Z
    //   311: ifeq +97 -> 408
    //   314: aload 14
    //   316: areturn
    //   317: astore_0
    //   318: iload 5
    //   320: istore_1
    //   321: iload 4
    //   323: istore_2
    //   324: lload 6
    //   326: lstore 8
    //   328: iload_1
    //   329: istore_3
    //   330: aload_0
    //   331: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   334: iload 4
    //   336: istore_2
    //   337: lload 6
    //   339: lstore 8
    //   341: iload_1
    //   342: istore_3
    //   343: ldc 43
    //   345: iconst_1
    //   346: ldc_w 382
    //   349: aload_0
    //   350: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   353: iload_1
    //   354: ifeq +7 -> 361
    //   357: invokestatic 337	zmk:b	()I
    //   360: pop
    //   361: iload 4
    //   363: ifeq -95 -> 268
    //   366: lload 6
    //   368: ldc_w 375
    //   371: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   374: goto -106 -> 268
    //   377: astore_0
    //   378: lload 8
    //   380: lstore 6
    //   382: iload_3
    //   383: istore_1
    //   384: iload_2
    //   385: istore_3
    //   386: iload_1
    //   387: ifeq +7 -> 394
    //   390: invokestatic 337	zmk:b	()I
    //   393: pop
    //   394: iload_3
    //   395: ifeq +11 -> 406
    //   398: lload 6
    //   400: ldc_w 375
    //   403: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   406: aload_0
    //   407: athrow
    //   408: aconst_null
    //   409: areturn
    //   410: astore_0
    //   411: lload 8
    //   413: lstore 6
    //   415: iconst_0
    //   416: istore_3
    //   417: iload_2
    //   418: istore_1
    //   419: goto -33 -> 386
    //   422: astore_0
    //   423: iload_2
    //   424: istore_1
    //   425: goto -39 -> 386
    //   428: astore_0
    //   429: iload_2
    //   430: istore_1
    //   431: lload 10
    //   433: lstore 6
    //   435: goto -114 -> 321
    //   438: astore_0
    //   439: iload_2
    //   440: istore_1
    //   441: iload_3
    //   442: istore 4
    //   444: goto -123 -> 321
    //   447: ldc2_w 303
    //   450: lstore 6
    //   452: iconst_0
    //   453: istore_3
    //   454: goto -306 -> 148
    //   457: iconst_0
    //   458: istore_2
    //   459: goto -349 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramBitmap	Bitmap
    //   0	462	1	paramInt	int
    //   75	384	2	i	int
    //   70	384	3	j	int
    //   77	366	4	k	int
    //   72	247	5	m	int
    //   82	369	6	l1	long
    //   102	310	8	l2	long
    //   123	309	10	l3	long
    //   67	228	12	l4	long
    //   91	224	14	localScannerResult	ScannerResult
    //   167	19	15	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   104	108	317	java/lang/Throwable
    //   104	108	377	finally
    //   330	334	377	finally
    //   343	353	377	finally
    //   125	130	410	finally
    //   138	146	410	finally
    //   148	248	422	finally
    //   125	130	428	java/lang/Throwable
    //   138	146	428	java/lang/Throwable
    //   148	248	438	java/lang/Throwable
  }
  
  public static ScannerResult a(Uri paramUri, Context paramContext, int paramInt)
  {
    return a(paramUri, paramContext, paramInt, false);
  }
  
  public static ScannerResult a(Uri paramUri, Context paramContext, int paramInt, boolean paramBoolean)
  {
    return a(paramUri, paramContext, paramBoolean, paramInt);
  }
  
  private static ScannerResult a(Uri paramUri, Context paramContext, boolean paramBoolean, int paramInt)
  {
    if ((paramUri == null) || (paramContext == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "detectQQCode isSharpP:" + paramBoolean + " mode:" + paramInt);
    }
    ScannerResult localScannerResult = new ScannerResult();
    if (paramBoolean) {}
    for (paramInt = 0x0 | a(paramUri, paramContext, paramInt, localScannerResult);; paramInt = 0x0 | b(paramUri, paramContext, paramInt, localScannerResult))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("ScannerUtils", 4, "detectQQCode cost: " + (System.currentTimeMillis() - l) + " result:" + paramInt + "\n scannerResult:" + localScannerResult);
      }
      if (!localScannerResult.b()) {
        break;
      }
      return localScannerResult;
    }
    return null;
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("type", paramInt);
        if (BaseApplicationImpl.getApplication() != null)
        {
          Object localObject = BaseApplicationImpl.getApplication().getRuntime();
          if (localObject != null)
          {
            localObject = (WtloginManager)((AppRuntime)localObject).getManager(1);
            if (localObject != null)
            {
              localObject = ((WtloginManager)localObject).getGUID();
              if ((localObject != null) && (localObject.length > 0))
              {
                localObject = HexUtil.bytes2HexStr((byte[])localObject);
                if (!TextUtils.isEmpty((CharSequence)localObject)) {
                  localJSONObject.put("guid", ((String)localObject).toUpperCase());
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("md5", paramString1.toUpperCase());
        }
        if ((TextUtils.isEmpty(paramString2)) || (paramString2.length() >= 512)) {
          continue;
        }
        localJSONObject.put("url", paramString2);
        if (!TextUtils.isEmpty(paramString4)) {
          localJSONObject.put("fromuin", paramString4);
        }
        if (!TextUtils.isEmpty(paramString5)) {
          localJSONObject.put("touin", paramString5);
        }
        paramString1 = DeviceInfoUtil.getIMEI();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("imei", paramString1.toUpperCase());
        }
        paramString1 = dp.a();
        if (!TextUtils.isEmpty(paramString1)) {
          localJSONObject.put("ip", paramString1);
        }
      }
      catch (Throwable paramString1)
      {
        QLog.i("ScannerUtils", 1, "buildQRScanReportParams error: " + paramString1.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ScannerUtils", 2, "buildQRScanReportParams json: " + localJSONObject.toString());
      }
      return localJSONObject.toString();
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("uuid", paramString3);
      }
    }
  }
  
  public static void a(int paramInt, String paramString, Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    Object localObject;
    if (paramInt == 1) {
      localObject = "ConsumerQRcard";
    }
    for (;;)
    {
      StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", (String)localObject, 1);
      do
      {
        return;
        if (paramInt == 2)
        {
          localObject = "GroupQRcard";
          break;
        }
      } while (paramInt == 3);
      String str = "ThirdpartyQRcard";
      if (znl.g(paramString))
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardurl", 1);
        localObject = str;
      }
      else
      {
        StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardtext", 1);
        localObject = str;
        if (znl.i(paramString))
        {
          StatisticCollector.getInstance(paramActivity.getApplicationContext()).reportButtonClick(paramQQAppInterface, "", "TPQRcardphone", 1);
          localObject = str;
        }
      }
    }
  }
  
  private static void a(long paramLong, String paramString)
  {
    apnc.a().a(BaseApplicationImpl.getContext(), paramLong, paramString);
    if (QLog.isColorLevel()) {
      QLog.i(paramString, 2, String.format("initQMini minicode=%b busiHash=%d", new Object[] { Boolean.valueOf(apnc.a()), Long.valueOf(paramLong) }));
    }
  }
  
  public static void a(Context paramContext)
  {
    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          Object localObject1 = Class.forName("android.gestureboost.GestureBoostManager");
          Object localObject2 = ((Class)localObject1).getDeclaredField("sGestureBoostManager");
          ((Field)localObject2).setAccessible(true);
          localObject2 = ((Field)localObject2).get(localObject1);
          localObject1 = ((Class)localObject1).getDeclaredField("mContext");
          ((Field)localObject1).setAccessible(true);
          if (((Field)localObject1).get(localObject2) == paramContext)
          {
            ((Field)localObject1).set(localObject2, null);
            return;
          }
        }
        catch (Throwable paramContext) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("ScannerUtils", 2, paramContext, new Object[0]);
  }
  
  public static void a(ScannerParams paramScannerParams, String paramString, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, zms paramzms, View paramView)
  {
    paramView.setVisibility(0);
    paramScannerParams = new zmm(paramAppActivity, paramString, paramQQAppInterface, paramScannerParams, paramView, paramzms);
    paramAppActivity = new NewIntent(paramAppActivity, zju.class);
    paramAppActivity.putExtra("d", paramString);
    paramAppActivity.putExtra("cmd", "QRCodeSvc.decode");
    paramAppActivity.putExtra("bqq", "1");
    paramzms = paramzms.a();
    if (paramzms != null)
    {
      paramView = new String[9];
      paramView[0] = "md5";
      paramView[1] = "fromuin";
      paramView[2] = "touin";
      paramView[3] = "imei";
      paramView[4] = "ip";
      paramView[5] = "url";
      paramView[6] = "guid";
      paramView[7] = "uuid";
      paramView[8] = "type";
      int j = paramView.length;
      int i = 0;
      while (i < j)
      {
        String str = paramView[i];
        if (paramzms.has(str)) {
          paramAppActivity.putExtra(str, paramzms.optString(str));
        }
        i += 1;
      }
    }
    paramAppActivity.setObserver(paramScannerParams);
    paramQQAppInterface.startServlet(paramAppActivity);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("://aq.qq.com"))) {
      paramQQAppInterface.sendWirelessPswReq(3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (!arfx.a().jdField_a_of_type_Boolean);
      jdField_a_of_type_Boolean = true;
    } while (axmf.a("https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bjuq.a));
    new axmf().a(paramQQAppInterface, 10090, "prd", "https://mqq-plugin.qq.com/fb813e02d800087a06212ff76487d55e", "fb813e02d800087a06212ff76487d55e", bjuq.a, null);
  }
  
  public static void a(String paramString1, String paramString2, AppActivity paramAppActivity, QQAppInterface paramQQAppInterface, View paramView, ScannerParams paramScannerParams, zms paramzms)
  {
    paramString1 = paramString2.trim();
    if (QLog.isColorLevel()) {
      QLog.d("ScannerUtils", 2, "resultString:" + paramString1);
    }
    if (paramAppActivity == null) {
      if (QLog.isColorLevel()) {
        QLog.d("ScannerUtils", 2, "handleUrl,activity == null");
      }
    }
    label1113:
    label1117:
    for (;;)
    {
      return;
      if (paramScannerParams.jdField_a_of_type_Boolean)
      {
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bhcl.b(2131230757, false);
        }
        paramAppActivity.setResult(-1, paramAppActivity.getIntent().putExtra("scanResult", paramString2));
        paramAppActivity.finish();
        return;
      }
      String str = paramString1.toLowerCase();
      int j = -1;
      int k = 0;
      int i = j;
      if (Pattern.compile("^mecard.*").matcher(str).matches()) {
        if (paramString1.length() <= "MECARD:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 0;
        }
      }
      j = i;
      if (Pattern.compile("^begin:vcard[\\s\\S]*end:vcard").matcher(str).matches()) {
        if (paramString1.length() <= "BEGIN:VCARD\nEND:VCARD".length())
        {
          j = i;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          j = 1;
        }
      }
      i = j;
      if (Pattern.compile("^bizcard.*;;$").matcher(str).matches()) {
        if (paramString1.length() <= "BIZCARD:;;:".length())
        {
          i = j;
          if (!paramString1.contains(":")) {}
        }
        else
        {
          i = 2;
        }
      }
      if (str.startsWith("qqf2f://qf/"))
      {
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bhcl.b(2131230757, false);
        }
        paramQQAppInterface.getQQProxyForQlink().a(paramAppActivity, paramString1, paramzms);
        return;
      }
      if ("qlink".equalsIgnoreCase(paramAppActivity.getIntent().getStringExtra("from")))
      {
        paramQQAppInterface.getQQProxyForQlink().a(paramAppActivity, paramzms);
        return;
      }
      if (str.startsWith("https://cmshow.qq.com/start-apollo-game.html"))
      {
        ApolloGameUtil.a(paramAppActivity, paramQQAppInterface, paramString1);
        paramAppActivity.finish();
        j = k;
        if (i != -1) {
          j = 1;
        }
        if (j == 0) {
          break label485;
        }
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bhcl.b(2131230757, false);
        }
        if (j == 0) {
          break label1113;
        }
        zjv.a(paramQQAppInterface, paramAppActivity, paramString1, i);
        i = 0;
      }
      for (;;)
      {
        if ((i != 0) || (!paramScannerParams.b)) {
          break label1117;
        }
        paramAppActivity.finish();
        return;
        if (!str.startsWith("https://cmshow.qq.com/developer-tool.html")) {
          break;
        }
        ApolloGameUtil.b(paramAppActivity, paramQQAppInterface, paramString1);
        paramAppActivity.finish();
        break;
        label485:
        if (!HttpUtil.isConnect(paramAppActivity))
        {
          paramString1 = bhdj.a(paramAppActivity, 230);
          paramString1.setMessage(2131718197);
          paramString2 = new zml(paramzms);
          paramString1.setPositiveButton(2131694399, paramString2);
          paramString1.setOnCancelListener(paramString2);
          paramString1.show();
          return;
        }
        if ((!paramQQAppInterface.isRingerVibrate()) && (!paramQQAppInterface.isRingerSilent()) && (!paramQQAppInterface.isRingEqualsZero())) {
          bhcl.b(2131230757, false);
        }
        if ((((WtloginManager)paramQQAppInterface.getManager(1)).isWtLoginUrl(str)) && (!znl.a(str)))
        {
          if (bjfi.jdField_a_of_type_Boolean)
          {
            paramView.setVisibility(0);
            paramString2 = bjfi.a();
            if (!TextUtils.isEmpty(paramScannerParams.jdField_e_of_type_JavaLangString)) {}
            for (boolean bool = true;; bool = false)
            {
              paramString2.a(paramQQAppInterface, paramString1, paramView, bool);
              i = 0;
              break;
            }
          }
          paramView.setVisibility(0);
          paramString2 = new Intent(paramAppActivity, QRLoginAuthActivity.class);
          paramString2.putExtra("QR_CODE_STRING", paramString1);
          if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false)) {
            paramAppActivity.startActivityForResult(paramString2, 2);
          }
          for (;;)
          {
            i = 0;
            break;
            paramAppActivity.startActivity(paramString2);
          }
        }
        if (((!TextUtils.isEmpty(str)) && (str.startsWith("http://iot.qq.com/add"))) || (("ScanSmartDevice".equals(paramAppActivity.getIntent().getStringExtra("from"))) && (!TextUtils.isEmpty(str)) && (!str.startsWith("http://qqapp.eprintsw.com"))))
        {
          absy.a().a(1);
          absy.a().jdField_a_of_type_JavaLangString = "";
          absy.a().jdField_a_of_type_Int = 0;
          absy.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
          if (DeviceScanner.openDeviceQCodeUrl(paramAppActivity, paramzms, paramString1)) {
            paramAppActivity.finish();
          }
          i = 0;
        }
        else if (a(paramString1))
        {
          b(paramString1, paramAppActivity);
          i = 0;
        }
        else if (paramString2.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate"))
        {
          a(paramString2, paramAppActivity);
          i = 0;
        }
        else if (znl.d(str))
        {
          QWalletHelper.doQWalletQRCode(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (znl.e(str))
        {
          QWalletHelper.doQRCodePay(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (znl.f(str))
        {
          QWalletHelper.doF2FRedpack(paramQQAppInterface, paramAppActivity, paramString1);
          i = 0;
        }
        else if (com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.isMiniAppUrl(str))
        {
          com.tencent.mobileqq.microapp.sdk.MiniAppLauncher.launchMiniAppByScanCode(paramAppActivity, paramString1);
          i = 0;
        }
        else
        {
          if (com.tencent.mobileqq.mini.sdk.MiniAppLauncher.isMiniAppUrl(str))
          {
            if (paramScannerParams.jdField_e_of_type_Boolean) {}
            for (i = 1012;; i = 1011)
            {
              com.tencent.mobileqq.mini.sdk.MiniAppLauncher.startMiniApp(paramAppActivity, paramString1, i, null);
              paramAppActivity.finish();
              i = 0;
              break;
            }
          }
          if (znl.h(str))
          {
            if (znl.b(str))
            {
              paramString2 = new Intent(paramAppActivity, JoinDiscussionActivity.class);
              paramString2.putExtra("innerSig", paramString1);
              paramString2.putExtra(jdField_a_of_type_JavaLangString, jdField_a_of_type_Int);
              if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
                paramAppActivity.startActivityForResult(paramString2, 2);
              }
              for (;;)
              {
                i = 0;
                break;
                paramAppActivity.startActivity(paramString2);
              }
            }
            if (bhit.a(paramString1))
            {
              bhit.a(paramQQAppInterface, paramAppActivity, paramString1);
              i = 0;
            }
            else
            {
              a(paramScannerParams, paramString1, paramAppActivity, paramQQAppInterface, paramzms, paramView);
              i = 1;
            }
          }
          else
          {
            zjv.a(paramQQAppInterface, paramAppActivity, paramString1);
            i = 0;
          }
        }
      }
    }
  }
  
  private static void a(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("msgbackup_qr_sig", paramString);
    localIntent.putExtra("param_start", 4);
    PublicFragmentActivity.a(paramAppActivity, localIntent, MsgBackupTransportFragment.class);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("app_name=qim");
  }
  
  private static int b()
  {
    try
    {
      int i = bjuq.a();
      if (i < 0) {
        return -1;
      }
      return 0;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ScannerUtils", 1, "releaseQbar failed:", localThrowable);
    }
    return -1;
  }
  
  /* Error */
  private static int b(Uri paramUri, Context paramContext, int paramInt, ScannerResult paramScannerResult)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aconst_null
    //   4: astore 22
    //   6: iconst_0
    //   7: istore 8
    //   9: iconst_0
    //   10: istore 7
    //   12: ldc2_w 303
    //   15: lstore 14
    //   17: aload 22
    //   19: astore 21
    //   21: aload_1
    //   22: invokevirtual 81	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   25: astore 24
    //   27: aload 22
    //   29: astore 21
    //   31: aload 24
    //   33: aload_0
    //   34: invokevirtual 87	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   37: astore 23
    //   39: aload 23
    //   41: ifnonnull +37 -> 78
    //   44: aload 23
    //   46: ifnull +8 -> 54
    //   49: aload 23
    //   51: invokevirtual 98	java/io/InputStream:close	()V
    //   54: iconst_0
    //   55: istore 6
    //   57: iload 6
    //   59: ireturn
    //   60: astore_0
    //   61: aload_0
    //   62: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   65: ldc 43
    //   67: iconst_1
    //   68: ldc_w 975
    //   71: aload_0
    //   72: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   75: goto -21 -> 54
    //   78: aload 23
    //   80: astore 21
    //   82: aload 23
    //   84: astore 22
    //   86: new 128	android/graphics/BitmapFactory$Options
    //   89: dup
    //   90: invokespecial 129	android/graphics/BitmapFactory$Options:<init>	()V
    //   93: astore 25
    //   95: aload 23
    //   97: astore 21
    //   99: aload 23
    //   101: astore 22
    //   103: aload 25
    //   105: iconst_1
    //   106: putfield 978	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   109: aload 23
    //   111: astore 21
    //   113: aload 23
    //   115: astore 22
    //   117: aload 23
    //   119: aconst_null
    //   120: aload 25
    //   122: invokestatic 141	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   125: pop
    //   126: aload 23
    //   128: astore 21
    //   130: aload 23
    //   132: astore 22
    //   134: aload 23
    //   136: invokevirtual 98	java/io/InputStream:close	()V
    //   139: aconst_null
    //   140: astore 22
    //   142: aload 22
    //   144: astore 21
    //   146: aload 25
    //   148: getfield 981	android/graphics/BitmapFactory$Options:outWidth	I
    //   151: istore 11
    //   153: aload 22
    //   155: astore 21
    //   157: aload 25
    //   159: getfield 984	android/graphics/BitmapFactory$Options:outHeight	I
    //   162: istore 10
    //   164: aload 22
    //   166: astore 21
    //   168: aload 25
    //   170: iconst_0
    //   171: putfield 978	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   174: iload 11
    //   176: sipush 12800
    //   179: if_icmpgt +11 -> 190
    //   182: iload 10
    //   184: sipush 12800
    //   187: if_icmple +35 -> 222
    //   190: iconst_0
    //   191: ifeq +11 -> 202
    //   194: new 986	java/lang/NullPointerException
    //   197: dup
    //   198: invokespecial 987	java/lang/NullPointerException:<init>	()V
    //   201: athrow
    //   202: iconst_0
    //   203: ireturn
    //   204: astore_0
    //   205: aload_0
    //   206: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   209: ldc 43
    //   211: iconst_1
    //   212: ldc_w 975
    //   215: aload_0
    //   216: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: goto -17 -> 202
    //   222: aload 22
    //   224: astore 21
    //   226: iload 11
    //   228: iload 10
    //   230: invokestatic 320	bjuq:a	(II)Z
    //   233: istore 20
    //   235: iload 20
    //   237: ifne +35 -> 272
    //   240: iconst_0
    //   241: ifeq +11 -> 252
    //   244: new 986	java/lang/NullPointerException
    //   247: dup
    //   248: invokespecial 987	java/lang/NullPointerException:<init>	()V
    //   251: athrow
    //   252: iconst_0
    //   253: ireturn
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   259: ldc 43
    //   261: iconst_1
    //   262: ldc_w 975
    //   265: aload_0
    //   266: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   269: goto -17 -> 252
    //   272: iload 11
    //   274: iload 10
    //   276: imul
    //   277: ldc_w 988
    //   280: if_icmple +95 -> 375
    //   283: iload 11
    //   285: iload 10
    //   287: imul
    //   288: i2d
    //   289: dstore 4
    //   291: aload 22
    //   293: astore 21
    //   295: aload 25
    //   297: dload 4
    //   299: invokestatic 991	java/lang/Math:sqrt	(D)D
    //   302: ldc2_w 992
    //   305: ddiv
    //   306: invokestatic 135	java/lang/Math:ceil	(D)D
    //   309: d2i
    //   310: putfield 138	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   313: aload 22
    //   315: astore 21
    //   317: aload 24
    //   319: aload_0
    //   320: invokevirtual 87	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   323: astore 23
    //   325: aload 23
    //   327: astore 21
    //   329: aload 23
    //   331: astore 22
    //   333: aload 23
    //   335: aconst_null
    //   336: aload 25
    //   338: invokestatic 141	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   341: astore 24
    //   343: aload 23
    //   345: astore 21
    //   347: aload 23
    //   349: astore 22
    //   351: aload 23
    //   353: invokevirtual 98	java/io/InputStream:close	()V
    //   356: aload 24
    //   358: ifnonnull +125 -> 483
    //   361: iconst_0
    //   362: ifeq +11 -> 373
    //   365: new 986	java/lang/NullPointerException
    //   368: dup
    //   369: invokespecial 987	java/lang/NullPointerException:<init>	()V
    //   372: athrow
    //   373: iconst_0
    //   374: ireturn
    //   375: aload 22
    //   377: astore 21
    //   379: aload 25
    //   381: iconst_1
    //   382: putfield 138	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   385: goto -72 -> 313
    //   388: astore_1
    //   389: aconst_null
    //   390: astore_0
    //   391: iconst_0
    //   392: istore 7
    //   394: iconst_0
    //   395: istore 6
    //   397: iconst_0
    //   398: istore_2
    //   399: aload_1
    //   400: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   403: ldc 43
    //   405: iconst_1
    //   406: ldc_w 995
    //   409: aload_1
    //   410: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   413: iload 7
    //   415: ifeq +7 -> 422
    //   418: invokestatic 337	zmk:b	()I
    //   421: pop
    //   422: iload 6
    //   424: ifeq +11 -> 435
    //   427: lload 14
    //   429: ldc_w 997
    //   432: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   435: iload_2
    //   436: istore 6
    //   438: aload_0
    //   439: ifnull -382 -> 57
    //   442: aload_0
    //   443: invokevirtual 98	java/io/InputStream:close	()V
    //   446: iload_2
    //   447: ireturn
    //   448: astore_0
    //   449: aload_0
    //   450: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   453: ldc 43
    //   455: iconst_1
    //   456: ldc_w 975
    //   459: aload_0
    //   460: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: iload_2
    //   464: ireturn
    //   465: astore_0
    //   466: aload_0
    //   467: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   470: ldc 43
    //   472: iconst_1
    //   473: ldc_w 975
    //   476: aload_0
    //   477: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   480: goto -107 -> 373
    //   483: iload_2
    //   484: iconst_1
    //   485: iand
    //   486: iconst_1
    //   487: if_icmpne +430 -> 917
    //   490: invokestatic 321	zmk:a	()I
    //   493: pop
    //   494: iconst_1
    //   495: istore 6
    //   497: iload_2
    //   498: iconst_2
    //   499: iand
    //   500: iconst_2
    //   501: if_icmpne +405 -> 906
    //   504: lload 14
    //   506: lstore 16
    //   508: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   511: lstore 18
    //   513: lload 18
    //   515: lstore 16
    //   517: lload 18
    //   519: lstore 14
    //   521: lload 18
    //   523: ldc_w 997
    //   526: invokestatic 326	zmk:a	(JLjava/lang/String;)V
    //   529: iconst_1
    //   530: istore 7
    //   532: lload 18
    //   534: lstore 14
    //   536: iload 9
    //   538: istore 8
    //   540: aload 24
    //   542: invokevirtual 144	android/graphics/Bitmap:getWidth	()I
    //   545: istore 13
    //   547: iload 9
    //   549: istore 8
    //   551: aload 24
    //   553: invokevirtual 147	android/graphics/Bitmap:getHeight	()I
    //   556: istore 12
    //   558: iload 9
    //   560: istore 8
    //   562: iload 13
    //   564: iload 12
    //   566: imul
    //   567: newarray int
    //   569: astore 21
    //   571: iload 9
    //   573: istore 8
    //   575: aload 24
    //   577: aload 21
    //   579: iconst_0
    //   580: iload 13
    //   582: iconst_0
    //   583: iconst_0
    //   584: iload 13
    //   586: iload 12
    //   588: invokevirtual 104	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   591: iload 9
    //   593: istore 8
    //   595: iconst_0
    //   596: aload 24
    //   598: aload 21
    //   600: aconst_null
    //   601: iload 13
    //   603: iload 12
    //   605: iload_2
    //   606: aload_3
    //   607: invokestatic 328	zmk:a	(Landroid/graphics/Bitmap;[I[BIIILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   610: ior
    //   611: istore 9
    //   613: iload 9
    //   615: istore 8
    //   617: aload 24
    //   619: invokevirtual 120	android/graphics/Bitmap:recycle	()V
    //   622: iload_2
    //   623: iconst_1
    //   624: iand
    //   625: iconst_1
    //   626: if_icmpne +274 -> 900
    //   629: iload 9
    //   631: istore 8
    //   633: aload_3
    //   634: invokevirtual 380	com/tencent/biz/qrcode/activity/ScannerResult:b	()Z
    //   637: ifne +263 -> 900
    //   640: iload 9
    //   642: istore 8
    //   644: aload_1
    //   645: aload_0
    //   646: iload 11
    //   648: iload 10
    //   650: aload_3
    //   651: invokestatic 999	zmk:a	(Landroid/content/Context;Landroid/net/Uri;IILcom/tencent/biz/qrcode/activity/ScannerResult;)I
    //   654: istore_2
    //   655: iload 9
    //   657: iload_2
    //   658: ior
    //   659: istore_2
    //   660: iload 6
    //   662: ifeq +7 -> 669
    //   665: invokestatic 337	zmk:b	()I
    //   668: pop
    //   669: iload 7
    //   671: ifeq +11 -> 682
    //   674: lload 14
    //   676: ldc_w 997
    //   679: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   682: iload_2
    //   683: istore 6
    //   685: iconst_0
    //   686: ifeq -629 -> 57
    //   689: new 986	java/lang/NullPointerException
    //   692: dup
    //   693: invokespecial 987	java/lang/NullPointerException:<init>	()V
    //   696: athrow
    //   697: astore_0
    //   698: aload_0
    //   699: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   702: ldc 43
    //   704: iconst_1
    //   705: ldc_w 975
    //   708: aload_0
    //   709: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   712: iload_2
    //   713: ireturn
    //   714: astore_0
    //   715: iload 8
    //   717: istore_2
    //   718: iload 7
    //   720: istore 6
    //   722: iload_2
    //   723: ifeq +7 -> 730
    //   726: invokestatic 337	zmk:b	()I
    //   729: pop
    //   730: iload 6
    //   732: ifeq +11 -> 743
    //   735: lload 14
    //   737: ldc_w 997
    //   740: invokestatic 339	zmk:b	(JLjava/lang/String;)V
    //   743: aload 21
    //   745: ifnull +8 -> 753
    //   748: aload 21
    //   750: invokevirtual 98	java/io/InputStream:close	()V
    //   753: aload_0
    //   754: athrow
    //   755: astore_1
    //   756: aload_1
    //   757: invokevirtual 167	java/lang/Throwable:printStackTrace	()V
    //   760: ldc 43
    //   762: iconst_1
    //   763: ldc_w 975
    //   766: aload_1
    //   767: invokestatic 172	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   770: goto -17 -> 753
    //   773: astore_0
    //   774: aconst_null
    //   775: astore 21
    //   777: iload 7
    //   779: istore 6
    //   781: iload 8
    //   783: istore_2
    //   784: goto -62 -> 722
    //   787: astore_0
    //   788: iload 6
    //   790: istore_2
    //   791: aconst_null
    //   792: astore 21
    //   794: iload 7
    //   796: istore 6
    //   798: lload 16
    //   800: lstore 14
    //   802: goto -80 -> 722
    //   805: astore_0
    //   806: iload 6
    //   808: istore_2
    //   809: aconst_null
    //   810: astore 21
    //   812: iload 7
    //   814: istore 6
    //   816: goto -94 -> 722
    //   819: astore_1
    //   820: iload 7
    //   822: istore_2
    //   823: aload_0
    //   824: astore 21
    //   826: aload_1
    //   827: astore_0
    //   828: goto -106 -> 722
    //   831: astore_1
    //   832: aload 22
    //   834: astore_0
    //   835: iconst_0
    //   836: istore 7
    //   838: iconst_0
    //   839: istore 6
    //   841: iconst_0
    //   842: istore_2
    //   843: goto -444 -> 399
    //   846: astore_1
    //   847: iconst_0
    //   848: istore 7
    //   850: aconst_null
    //   851: astore_0
    //   852: iconst_0
    //   853: istore 6
    //   855: iconst_0
    //   856: istore_2
    //   857: goto -458 -> 399
    //   860: astore_1
    //   861: iconst_0
    //   862: istore 8
    //   864: iload 6
    //   866: istore 7
    //   868: aconst_null
    //   869: astore_0
    //   870: iconst_0
    //   871: istore_2
    //   872: iload 8
    //   874: istore 6
    //   876: goto -477 -> 399
    //   879: astore_1
    //   880: iload 7
    //   882: istore 9
    //   884: iload 6
    //   886: istore 7
    //   888: aconst_null
    //   889: astore_0
    //   890: iload 8
    //   892: istore_2
    //   893: iload 9
    //   895: istore 6
    //   897: goto -498 -> 399
    //   900: iload 9
    //   902: istore_2
    //   903: goto -243 -> 660
    //   906: ldc2_w 303
    //   909: lstore 14
    //   911: iconst_0
    //   912: istore 7
    //   914: goto -378 -> 536
    //   917: iconst_0
    //   918: istore 6
    //   920: goto -423 -> 497
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	923	0	paramUri	Uri
    //   0	923	1	paramContext	Context
    //   0	923	2	paramInt	int
    //   0	923	3	paramScannerResult	ScannerResult
    //   289	9	4	d	double
    //   55	864	6	i	int
    //   10	903	7	j	int
    //   7	884	8	k	int
    //   1	900	9	m	int
    //   162	487	10	n	int
    //   151	496	11	i1	int
    //   556	48	12	i2	int
    //   545	57	13	i3	int
    //   15	895	14	l1	long
    //   506	293	16	l2	long
    //   511	22	18	l3	long
    //   233	3	20	bool	boolean
    //   19	806	21	localObject1	Object
    //   4	829	22	localObject2	Object
    //   37	315	23	localInputStream	java.io.InputStream
    //   25	593	24	localObject3	Object
    //   93	287	25	localOptions	android.graphics.BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   49	54	60	java/lang/Throwable
    //   194	202	204	java/lang/Throwable
    //   244	252	254	java/lang/Throwable
    //   21	27	388	java/lang/Throwable
    //   31	39	388	java/lang/Throwable
    //   146	153	388	java/lang/Throwable
    //   157	164	388	java/lang/Throwable
    //   168	174	388	java/lang/Throwable
    //   226	235	388	java/lang/Throwable
    //   295	313	388	java/lang/Throwable
    //   317	325	388	java/lang/Throwable
    //   379	385	388	java/lang/Throwable
    //   442	446	448	java/lang/Throwable
    //   365	373	465	java/lang/Throwable
    //   689	697	697	java/lang/Throwable
    //   21	27	714	finally
    //   31	39	714	finally
    //   86	95	714	finally
    //   103	109	714	finally
    //   117	126	714	finally
    //   134	139	714	finally
    //   146	153	714	finally
    //   157	164	714	finally
    //   168	174	714	finally
    //   226	235	714	finally
    //   295	313	714	finally
    //   317	325	714	finally
    //   333	343	714	finally
    //   351	356	714	finally
    //   379	385	714	finally
    //   748	753	755	java/lang/Throwable
    //   490	494	773	finally
    //   508	513	787	finally
    //   521	529	787	finally
    //   540	547	805	finally
    //   551	558	805	finally
    //   562	571	805	finally
    //   575	591	805	finally
    //   595	613	805	finally
    //   617	622	805	finally
    //   633	640	805	finally
    //   644	655	805	finally
    //   399	413	819	finally
    //   86	95	831	java/lang/Throwable
    //   103	109	831	java/lang/Throwable
    //   117	126	831	java/lang/Throwable
    //   134	139	831	java/lang/Throwable
    //   333	343	831	java/lang/Throwable
    //   351	356	831	java/lang/Throwable
    //   490	494	846	java/lang/Throwable
    //   508	513	860	java/lang/Throwable
    //   521	529	860	java/lang/Throwable
    //   540	547	879	java/lang/Throwable
    //   551	558	879	java/lang/Throwable
    //   562	571	879	java/lang/Throwable
    //   575	591	879	java/lang/Throwable
    //   595	613	879	java/lang/Throwable
    //   617	622	879	java/lang/Throwable
    //   633	640	879	java/lang/Throwable
    //   644	655	879	java/lang/Throwable
  }
  
  private static void b(long paramLong, String paramString)
  {
    apnc.a().a(paramLong, paramString);
  }
  
  private static void b(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent(paramAppActivity, QQBrowserActivity.class);
    localIntent.putExtra("key_isReadModeEnabled", true);
    localIntent.putExtra("fromQrcode", true);
    localIntent.putExtra("url", paramString);
    if (paramAppActivity.getIntent().getBooleanExtra("QRDecode", false) == true) {
      paramAppActivity.startActivityForResult(localIntent, 2);
    }
    for (;;)
    {
      paramAppActivity.finish();
      return;
      paramAppActivity.startActivity(localIntent);
    }
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmk
 * JD-Core Version:    0.7.0.1
 */