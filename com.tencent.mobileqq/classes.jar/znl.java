import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.util.QRUtils.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class znl
{
  protected static String a = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  protected static String b = ".*(\\+86|086)?\\d{5,12}.*";
  public static String c = "qm.qq.com";
  protected static String d = "183.61.32.185";
  protected static String e = "58.250.135.158";
  protected static String f = "120.198.189.104";
  protected static String g = "182.254.1.144";
  private static String h = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  private static String i = "^https?://url\\.cn/.+#flyticket";
  
  protected static int a(int paramInt)
  {
    if (paramInt < 21) {
      return 1;
    }
    if (paramInt > 177) {
      return 39;
    }
    return (paramInt - 21) / 4 + 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("my_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getMyQrBgIndexFromSp().settingValue:" + j);
    }
    return j;
  }
  
  public static long a(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k)
    {
      l += ((paramArrayOfByte[(k - j - 1)] & 0xFF) << j * 8);
      j += 1;
    }
    return l;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, ArrayList<Rect> paramArrayList, int paramInt4)
  {
    // Byte code:
    //   0: sipush 540
    //   3: sipush 740
    //   6: getstatic 119	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 125	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: iload 12
    //   16: ifeq +1243 -> 1259
    //   19: aload_0
    //   20: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload 12
    //   25: invokestatic 137	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   28: astore 14
    //   30: aload 15
    //   32: ifnonnull +24 -> 56
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc 87
    //   46: iconst_2
    //   47: aload_0
    //   48: invokevirtual 140	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   51: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: new 145	android/graphics/Canvas
    //   59: dup
    //   60: aload 15
    //   62: invokespecial 148	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   65: astore 16
    //   67: aload_1
    //   68: ifnull +664 -> 732
    //   71: new 150	android/graphics/Paint
    //   74: dup
    //   75: invokespecial 151	android/graphics/Paint:<init>	()V
    //   78: astore 17
    //   80: new 153	android/graphics/Rect
    //   83: dup
    //   84: iconst_0
    //   85: iconst_0
    //   86: sipush 540
    //   89: sipush 740
    //   92: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   95: astore 18
    //   97: aload 17
    //   99: iconst_1
    //   100: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   103: aload 16
    //   105: aload_1
    //   106: aconst_null
    //   107: aload 18
    //   109: aload 17
    //   111: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: aload_2
    //   115: ifnull +41 -> 156
    //   118: new 150	android/graphics/Paint
    //   121: dup
    //   122: invokespecial 151	android/graphics/Paint:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: iconst_1
    //   128: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   131: aload 16
    //   133: aload_2
    //   134: aconst_null
    //   135: new 153	android/graphics/Rect
    //   138: dup
    //   139: bipush 20
    //   141: sipush 621
    //   144: bipush 120
    //   146: sipush 721
    //   149: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   152: aload_1
    //   153: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   156: iconst_0
    //   157: istore 12
    //   159: aload 14
    //   161: ifnull +52 -> 213
    //   164: iconst_1
    //   165: istore 12
    //   167: new 150	android/graphics/Paint
    //   170: dup
    //   171: invokespecial 151	android/graphics/Paint:<init>	()V
    //   174: astore_1
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   180: aload_1
    //   181: iconst_1
    //   182: invokevirtual 167	android/graphics/Paint:setFilterBitmap	(Z)V
    //   185: aload 16
    //   187: aload 14
    //   189: aconst_null
    //   190: new 153	android/graphics/Rect
    //   193: dup
    //   194: sipush 140
    //   197: sipush 633
    //   200: sipush 176
    //   203: sipush 669
    //   206: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   209: aload_1
    //   210: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   213: new 150	android/graphics/Paint
    //   216: dup
    //   217: invokespecial 151	android/graphics/Paint:<init>	()V
    //   220: astore 17
    //   222: aload 17
    //   224: getstatic 173	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   227: invokevirtual 177	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   230: aload 17
    //   232: iconst_1
    //   233: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   236: aload 17
    //   238: iload_3
    //   239: invokevirtual 181	android/graphics/Paint:setColor	(I)V
    //   242: aload 17
    //   244: ldc 182
    //   246: invokevirtual 186	android/graphics/Paint:setTextSize	(F)V
    //   249: aload 17
    //   251: iconst_1
    //   252: invokevirtual 189	android/graphics/Paint:setFlags	(I)V
    //   255: aload 17
    //   257: getstatic 195	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   260: invokevirtual 199	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   263: pop
    //   264: iload 12
    //   266: ifeq +570 -> 836
    //   269: sipush 342
    //   272: istore_3
    //   273: aload 4
    //   275: ifnull +112 -> 387
    //   278: iconst_2
    //   279: aload 4
    //   281: invokevirtual 205	java/lang/String:length	()I
    //   284: invokestatic 211	java/lang/Math:max	(II)I
    //   287: istore 13
    //   289: aload 4
    //   291: astore 14
    //   293: aload 17
    //   295: aload 4
    //   297: invokevirtual 215	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   300: iload_3
    //   301: i2f
    //   302: fcmpl
    //   303: ifle +62 -> 365
    //   306: iload 13
    //   308: iconst_2
    //   309: isub
    //   310: istore 13
    //   312: new 89	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   319: aload 4
    //   321: iconst_0
    //   322: iload 13
    //   324: invokevirtual 219	java/lang/String:substring	(II)Ljava/lang/String;
    //   327: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 221
    //   332: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_1
    //   339: aload_1
    //   340: astore 14
    //   342: iload 13
    //   344: ifle +21 -> 365
    //   347: aload_1
    //   348: astore 4
    //   350: aload 17
    //   352: aload_1
    //   353: invokevirtual 215	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   356: iload_3
    //   357: i2f
    //   358: fcmpl
    //   359: ifgt -53 -> 306
    //   362: aload_1
    //   363: astore 14
    //   365: iload 12
    //   367: ifeq +476 -> 843
    //   370: sipush 182
    //   373: istore_3
    //   374: aload 16
    //   376: aload 14
    //   378: iload_3
    //   379: i2f
    //   380: ldc 222
    //   382: aload 17
    //   384: invokevirtual 226	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   387: aload 5
    //   389: ifnull +27 -> 416
    //   392: aload 16
    //   394: aload 5
    //   396: aconst_null
    //   397: new 153	android/graphics/Rect
    //   400: dup
    //   401: iconst_0
    //   402: iconst_0
    //   403: sipush 540
    //   406: sipush 600
    //   409: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   412: aconst_null
    //   413: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   416: aload 10
    //   418: ifnull +432 -> 850
    //   421: aload 6
    //   423: astore_1
    //   424: invokestatic 228	znl:a	()Z
    //   427: ifeq +146 -> 573
    //   430: aload 6
    //   432: astore_1
    //   433: aload 10
    //   435: invokevirtual 231	android/graphics/Rect:width	()I
    //   438: sipush 350
    //   441: if_icmple +132 -> 573
    //   444: aload 6
    //   446: astore_1
    //   447: aload 10
    //   449: invokevirtual 234	android/graphics/Rect:height	()I
    //   452: sipush 350
    //   455: if_icmple +118 -> 573
    //   458: aload 6
    //   460: astore_1
    //   461: aload 6
    //   463: ifnull +110 -> 573
    //   466: aload 6
    //   468: aload 10
    //   470: invokevirtual 231	android/graphics/Rect:width	()I
    //   473: iconst_2
    //   474: idiv
    //   475: aload 10
    //   477: invokevirtual 234	android/graphics/Rect:height	()I
    //   480: iconst_2
    //   481: idiv
    //   482: iconst_0
    //   483: invokestatic 238	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   486: astore 4
    //   488: aload 6
    //   490: astore_1
    //   491: aload 4
    //   493: ifnull +80 -> 573
    //   496: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +71 -> 570
    //   502: ldc 87
    //   504: iconst_2
    //   505: new 89	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   512: ldc 240
    //   514: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 4
    //   519: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   522: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: ldc 245
    //   527: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 4
    //   532: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   535: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc 250
    //   540: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 6
    //   545: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   548: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc 252
    //   553: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 6
    //   558: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   561: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: astore_1
    //   573: aload 11
    //   575: ifnull +475 -> 1050
    //   578: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +47 -> 628
    //   584: aload_1
    //   585: ifnull +43 -> 628
    //   588: ldc 87
    //   590: iconst_2
    //   591: new 89	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   598: ldc 254
    //   600: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   607: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: ldc 245
    //   612: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_1
    //   616: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   619: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload_1
    //   629: aload 10
    //   631: invokevirtual 231	android/graphics/Rect:width	()I
    //   634: aload 10
    //   636: invokevirtual 234	android/graphics/Rect:height	()I
    //   639: iconst_0
    //   640: invokestatic 238	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   643: astore_1
    //   644: new 145	android/graphics/Canvas
    //   647: dup
    //   648: aload_1
    //   649: invokespecial 148	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   652: astore 4
    //   654: new 150	android/graphics/Paint
    //   657: dup
    //   658: invokespecial 151	android/graphics/Paint:<init>	()V
    //   661: astore 5
    //   663: aload 5
    //   665: iconst_0
    //   666: invokevirtual 257	android/graphics/Paint:setAlpha	(I)V
    //   669: aload 5
    //   671: iconst_1
    //   672: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   675: aload 5
    //   677: new 259	android/graphics/PorterDuffXfermode
    //   680: dup
    //   681: getstatic 265	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   684: invokespecial 268	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   687: invokevirtual 272	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   690: pop
    //   691: iconst_0
    //   692: istore_3
    //   693: iload_3
    //   694: aload 11
    //   696: invokevirtual 277	java/util/ArrayList:size	()I
    //   699: if_icmpge +209 -> 908
    //   702: aload 4
    //   704: new 153	android/graphics/Rect
    //   707: dup
    //   708: aload 11
    //   710: iload_3
    //   711: invokevirtual 281	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   714: checkcast 153	android/graphics/Rect
    //   717: invokespecial 284	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   720: aload 5
    //   722: invokevirtual 288	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   725: iload_3
    //   726: iconst_1
    //   727: iadd
    //   728: istore_3
    //   729: goto -36 -> 693
    //   732: new 150	android/graphics/Paint
    //   735: dup
    //   736: invokespecial 151	android/graphics/Paint:<init>	()V
    //   739: astore_1
    //   740: aload_1
    //   741: new 290	android/graphics/LinearGradient
    //   744: dup
    //   745: fconst_0
    //   746: fconst_0
    //   747: fconst_0
    //   748: ldc_w 291
    //   751: ldc_w 292
    //   754: ldc_w 293
    //   757: getstatic 299	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   760: invokespecial 302	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   763: invokevirtual 306	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   766: pop
    //   767: aload 16
    //   769: fconst_0
    //   770: fconst_0
    //   771: ldc_w 307
    //   774: ldc_w 291
    //   777: aload_1
    //   778: invokevirtual 310	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   781: aload_1
    //   782: aconst_null
    //   783: invokevirtual 306	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   786: pop
    //   787: aload_1
    //   788: ldc_w 311
    //   791: invokevirtual 181	android/graphics/Paint:setColor	(I)V
    //   794: aload 16
    //   796: fconst_0
    //   797: ldc_w 291
    //   800: ldc_w 307
    //   803: ldc_w 291
    //   806: aload_1
    //   807: invokevirtual 314	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   810: aload_1
    //   811: ldc_w 315
    //   814: invokevirtual 181	android/graphics/Paint:setColor	(I)V
    //   817: aload 16
    //   819: fconst_0
    //   820: ldc_w 316
    //   823: ldc_w 307
    //   826: ldc_w 317
    //   829: aload_1
    //   830: invokevirtual 310	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   833: goto -719 -> 114
    //   836: sipush 380
    //   839: istore_3
    //   840: goto -567 -> 273
    //   843: sipush 140
    //   846: istore_3
    //   847: goto -473 -> 374
    //   850: new 153	android/graphics/Rect
    //   853: dup
    //   854: bipush 70
    //   856: bipush 100
    //   858: sipush 470
    //   861: sipush 500
    //   864: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   867: astore 10
    //   869: goto -448 -> 421
    //   872: astore_1
    //   873: ldc 87
    //   875: iconst_2
    //   876: new 89	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   883: ldc_w 319
    //   886: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_1
    //   890: invokevirtual 320	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   893: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aload 6
    //   904: astore_1
    //   905: goto -332 -> 573
    //   908: aload 16
    //   910: aload_1
    //   911: aconst_null
    //   912: aload 10
    //   914: aconst_null
    //   915: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   918: aload_1
    //   919: invokevirtual 323	android/graphics/Bitmap:recycle	()V
    //   922: iload 7
    //   924: iconst_1
    //   925: if_icmpne +142 -> 1067
    //   928: new 150	android/graphics/Paint
    //   931: dup
    //   932: invokespecial 151	android/graphics/Paint:<init>	()V
    //   935: astore_1
    //   936: aload_1
    //   937: iconst_1
    //   938: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   941: new 153	android/graphics/Rect
    //   944: dup
    //   945: sipush 217
    //   948: sipush 247
    //   951: sipush 323
    //   954: sipush 353
    //   957: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   960: astore_2
    //   961: aload_0
    //   962: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   965: ldc_w 324
    //   968: invokestatic 137	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   971: astore_0
    //   972: aload 16
    //   974: aload_0
    //   975: aconst_null
    //   976: aload_2
    //   977: aload_1
    //   978: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   981: aload_0
    //   982: invokevirtual 323	android/graphics/Bitmap:recycle	()V
    //   985: new 150	android/graphics/Paint
    //   988: dup
    //   989: invokespecial 151	android/graphics/Paint:<init>	()V
    //   992: astore_0
    //   993: aload_0
    //   994: getstatic 173	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   997: invokevirtual 177	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   1000: aload_0
    //   1001: iconst_1
    //   1002: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   1005: aload_0
    //   1006: iload 8
    //   1008: invokevirtual 181	android/graphics/Paint:setColor	(I)V
    //   1011: aload_0
    //   1012: ldc_w 325
    //   1015: invokevirtual 186	android/graphics/Paint:setTextSize	(F)V
    //   1018: aload_0
    //   1019: getstatic 195	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   1022: invokevirtual 199	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   1025: pop
    //   1026: aload 16
    //   1028: aload 9
    //   1030: ldc_w 326
    //   1033: ldc_w 327
    //   1036: aload_0
    //   1037: invokevirtual 226	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1040: aload 15
    //   1042: areturn
    //   1043: astore_0
    //   1044: aload_0
    //   1045: invokevirtual 330	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1048: aconst_null
    //   1049: areturn
    //   1050: aload_1
    //   1051: ifnull -129 -> 922
    //   1054: aload 16
    //   1056: aload_1
    //   1057: aconst_null
    //   1058: aload 10
    //   1060: aconst_null
    //   1061: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1064: goto -142 -> 922
    //   1067: iload 7
    //   1069: iconst_2
    //   1070: if_icmpne +57 -> 1127
    //   1073: aload_2
    //   1074: ifnull +53 -> 1127
    //   1077: new 150	android/graphics/Paint
    //   1080: dup
    //   1081: invokespecial 151	android/graphics/Paint:<init>	()V
    //   1084: astore_0
    //   1085: aload_0
    //   1086: iconst_1
    //   1087: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   1090: aload 16
    //   1092: aload_2
    //   1093: aconst_null
    //   1094: new 153	android/graphics/Rect
    //   1097: dup
    //   1098: sipush 217
    //   1101: sipush 247
    //   1104: sipush 323
    //   1107: sipush 353
    //   1110: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   1113: aload_0
    //   1114: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1117: goto -132 -> 985
    //   1120: astore_0
    //   1121: aload_0
    //   1122: invokevirtual 330	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1125: aconst_null
    //   1126: areturn
    //   1127: iload 7
    //   1129: iconst_3
    //   1130: if_icmpne +63 -> 1193
    //   1133: new 150	android/graphics/Paint
    //   1136: dup
    //   1137: invokespecial 151	android/graphics/Paint:<init>	()V
    //   1140: astore_1
    //   1141: aload_1
    //   1142: iconst_1
    //   1143: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   1146: new 153	android/graphics/Rect
    //   1149: dup
    //   1150: sipush 217
    //   1153: sipush 247
    //   1156: sipush 323
    //   1159: sipush 353
    //   1162: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   1165: astore_2
    //   1166: aload_0
    //   1167: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1170: ldc_w 324
    //   1173: invokestatic 137	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1176: astore_0
    //   1177: aload 16
    //   1179: aload_0
    //   1180: aconst_null
    //   1181: aload_2
    //   1182: aload_1
    //   1183: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1186: aload_0
    //   1187: invokevirtual 323	android/graphics/Bitmap:recycle	()V
    //   1190: goto -205 -> 985
    //   1193: iload 7
    //   1195: iconst_4
    //   1196: if_icmpne -211 -> 985
    //   1199: new 150	android/graphics/Paint
    //   1202: dup
    //   1203: invokespecial 151	android/graphics/Paint:<init>	()V
    //   1206: astore_1
    //   1207: aload_1
    //   1208: iconst_1
    //   1209: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   1212: new 153	android/graphics/Rect
    //   1215: dup
    //   1216: sipush 217
    //   1219: sipush 247
    //   1222: sipush 323
    //   1225: sipush 353
    //   1228: invokespecial 156	android/graphics/Rect:<init>	(IIII)V
    //   1231: astore_2
    //   1232: aload_0
    //   1233: invokevirtual 131	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1236: ldc_w 324
    //   1239: invokestatic 137	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1242: astore_0
    //   1243: aload 16
    //   1245: aload_0
    //   1246: aconst_null
    //   1247: aload_2
    //   1248: aload_1
    //   1249: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1252: aload_0
    //   1253: invokevirtual 323	android/graphics/Bitmap:recycle	()V
    //   1256: goto -271 -> 985
    //   1259: aconst_null
    //   1260: astore 14
    //   1262: goto -1232 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1265	0	paramContext	Context
    //   0	1265	1	paramBitmap1	Bitmap
    //   0	1265	2	paramBitmap2	Bitmap
    //   0	1265	3	paramInt1	int
    //   0	1265	4	paramString1	String
    //   0	1265	5	paramBitmap3	Bitmap
    //   0	1265	6	paramBitmap4	Bitmap
    //   0	1265	7	paramInt2	int
    //   0	1265	8	paramInt3	int
    //   0	1265	9	paramString2	String
    //   0	1265	10	paramRect	Rect
    //   0	1265	11	paramArrayList	ArrayList<Rect>
    //   0	1265	12	paramInt4	int
    //   287	56	13	j	int
    //   28	1233	14	localObject	Object
    //   12	1029	15	localBitmap	Bitmap
    //   65	1179	16	localCanvas	Canvas
    //   78	305	17	localPaint	Paint
    //   95	13	18	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/OutOfMemoryError
    //   19	30	37	java/lang/OutOfMemoryError
    //   466	488	872	java/lang/Throwable
    //   496	570	872	java/lang/Throwable
    //   628	691	1043	java/lang/OutOfMemoryError
    //   693	725	1043	java/lang/OutOfMemoryError
    //   908	922	1043	java/lang/OutOfMemoryError
    //   928	985	1120	java/lang/OutOfMemoryError
    //   1077	1117	1120	java/lang/OutOfMemoryError
    //   1133	1190	1120	java/lang/OutOfMemoryError
    //   1199	1256	1120	java/lang/OutOfMemoryError
  }
  
  public static arfa a(QQAppInterface paramQQAppInterface, arey paramarey, int paramInt)
  {
    if ((paramarey == null) || (paramarey.a == null) || (paramarey.a.size() <= 0)) {
      return null;
    }
    int k = 0;
    for (int j = (int)(Math.random() * paramarey.a.size()); (paramInt != -1) && (j == paramInt) && (k < 50); j = (int)(Math.random() * paramarey.a.size())) {
      k += 1;
    }
    return (arfa)paramarey.a.get(j);
  }
  
  public static gr a(String paramString, int paramInt)
  {
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    Object localObject = a(paramString);
    if (localObject != null) {
      localEnumMap.put(EncodeHintType.CHARACTER_SET, localObject);
    }
    if (paramInt != -1) {
      localEnumMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(a(paramInt)));
    }
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject = new gv();
    try
    {
      paramString = ((gv)localObject).a(paramString, 0, 0, localEnumMap);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("QRUtils", 1, "encode error:" + paramString.getMessage());
    }
    return null;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("host", 0).getString(paramString, null);
    if (paramContext != null) {
      return paramContext;
    }
    if (paramString.equals(c)) {
      return d;
    }
    return null;
  }
  
  /* Error */
  @android.annotation.TargetApi(8)
  public static String a(Context paramContext, String paramString, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 425	java/io/File
    //   9: dup
    //   10: ldc_w 427
    //   13: invokestatic 433	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 436	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 439	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnonnull +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 443	android/content/Context:getCacheDir	()Ljava/io/File;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -37 -> 4
    //   44: aload_3
    //   45: invokevirtual 446	java/io/File:canWrite	()Z
    //   48: ifeq -44 -> 4
    //   51: new 425	java/io/File
    //   54: dup
    //   55: aload_3
    //   56: invokevirtual 449	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 452	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 449	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: astore 5
    //   70: aload_0
    //   71: invokevirtual 455	java/io/File:exists	()Z
    //   74: ifeq +8 -> 82
    //   77: aload_0
    //   78: invokevirtual 458	java/io/File:delete	()Z
    //   81: pop
    //   82: new 460	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 463	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: new 465	java/io/BufferedOutputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 468	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: getstatic 474	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload 4
    //   114: invokevirtual 478	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   117: pop
    //   118: aload 4
    //   120: astore_3
    //   121: aload_0
    //   122: astore_1
    //   123: aload 4
    //   125: invokevirtual 481	java/io/BufferedOutputStream:flush	()V
    //   128: aload 4
    //   130: ifnull +8 -> 138
    //   133: aload 4
    //   135: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 485	java/io/FileOutputStream:close	()V
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 486	java/io/IOException:printStackTrace	()V
    //   154: goto -8 -> 146
    //   157: astore 5
    //   159: aconst_null
    //   160: astore_2
    //   161: aconst_null
    //   162: astore_0
    //   163: aload_2
    //   164: astore_3
    //   165: aload_0
    //   166: astore_1
    //   167: aload 5
    //   169: invokevirtual 487	java/io/FileNotFoundException:printStackTrace	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   180: aload_0
    //   181: ifnull -177 -> 4
    //   184: aload_0
    //   185: invokevirtual 485	java/io/FileOutputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 486	java/io/IOException:printStackTrace	()V
    //   195: aconst_null
    //   196: areturn
    //   197: astore 5
    //   199: aconst_null
    //   200: astore_2
    //   201: aconst_null
    //   202: astore_0
    //   203: aload_2
    //   204: astore_3
    //   205: aload_0
    //   206: astore_1
    //   207: aload 5
    //   209: invokevirtual 486	java/io/IOException:printStackTrace	()V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   220: aload_0
    //   221: ifnull -217 -> 4
    //   224: aload_0
    //   225: invokevirtual 485	java/io/FileOutputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 486	java/io/IOException:printStackTrace	()V
    //   235: aconst_null
    //   236: areturn
    //   237: astore_2
    //   238: aconst_null
    //   239: astore_3
    //   240: aconst_null
    //   241: astore_0
    //   242: aload_3
    //   243: ifnull +7 -> 250
    //   246: aload_3
    //   247: invokevirtual 484	java/io/BufferedOutputStream:close	()V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 485	java/io/FileOutputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 486	java/io/IOException:printStackTrace	()V
    //   265: goto -7 -> 258
    //   268: astore_1
    //   269: goto -131 -> 138
    //   272: astore_1
    //   273: goto -93 -> 180
    //   276: astore_1
    //   277: goto -57 -> 220
    //   280: astore_1
    //   281: goto -31 -> 250
    //   284: astore_2
    //   285: aconst_null
    //   286: astore_3
    //   287: goto -45 -> 242
    //   290: astore_2
    //   291: aload_1
    //   292: astore_0
    //   293: goto -51 -> 242
    //   296: astore 5
    //   298: aconst_null
    //   299: astore_2
    //   300: goto -97 -> 203
    //   303: astore 5
    //   305: aload 4
    //   307: astore_2
    //   308: goto -105 -> 203
    //   311: astore 5
    //   313: aconst_null
    //   314: astore_2
    //   315: goto -152 -> 163
    //   318: astore 5
    //   320: aload 4
    //   322: astore_2
    //   323: goto -160 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramContext	Context
    //   0	326	1	paramString	String
    //   0	326	2	paramBitmap	Bitmap
    //   29	258	3	localObject1	Object
    //   19	302	4	localObject2	Object
    //   68	79	5	str	String
    //   157	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   197	11	5	localIOException1	java.io.IOException
    //   296	1	5	localIOException2	java.io.IOException
    //   303	1	5	localIOException3	java.io.IOException
    //   311	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   318	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   142	146	149	java/io/IOException
    //   82	91	157	java/io/FileNotFoundException
    //   184	188	190	java/io/IOException
    //   82	91	197	java/io/IOException
    //   224	228	230	java/io/IOException
    //   82	91	237	finally
    //   254	258	260	java/io/IOException
    //   133	138	268	java/io/IOException
    //   176	180	272	java/io/IOException
    //   216	220	276	java/io/IOException
    //   246	250	280	java/io/IOException
    //   91	101	284	finally
    //   106	118	290	finally
    //   123	128	290	finally
    //   167	172	290	finally
    //   207	212	290	finally
    //   91	101	296	java/io/IOException
    //   106	118	303	java/io/IOException
    //   123	128	303	java/io/IOException
    //   91	101	311	java/io/FileNotFoundException
    //   106	118	318	java/io/FileNotFoundException
    //   123	128	318	java/io/FileNotFoundException
  }
  
  protected static String a(CharSequence paramCharSequence)
  {
    int j = 0;
    while (j < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(j) > 'ÿ') {
        return "UTF-8";
      }
      j += 1;
    }
    return null;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131299080));
  }
  
  private static void a(int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    Paint localPaint = new Paint();
    paramInt1 = paramInt1 / 2 - 70;
    RectF localRectF = new RectF(paramInt1, paramInt2 - 66, paramInt1 + 140, paramInt2 - 66 + 140);
    localPaint.setAntiAlias(true);
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setStrokeWidth(16.0F);
    localPaint.setColor(Color.parseColor("#E6FFFFFF"));
    paramCanvas.drawArc(localRectF, 182.0F, 176.0F, false, localPaint);
  }
  
  private static void a(int paramInt1, String paramString, int paramInt2, Canvas paramCanvas, int paramInt3, int paramInt4)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      int j = (int)localPaint.measureText(paramString);
      paramInt1 = paramInt2 / 2;
      paramInt2 = j / 2;
      paramInt4 = (paramInt4 - (paramInt3 + 228 + 440)) / 2;
      paramCanvas.drawText(paramString, paramInt1 - paramInt2, paramInt4 + 14 + (paramInt3 + 228 + 440), localPaint);
    }
  }
  
  private static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(48.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString2 != null)
    {
      paramInt1 = Math.max(2, paramString1.length());
      paramString2 = paramString1;
      if (localPaint.measureText(paramString1) > 500)
      {
        paramString2 = paramString1;
        do
        {
          paramInt1 -= 2;
          paramString1 = paramString2.substring(0, paramInt1) + "…";
          paramString2 = paramString1;
          if (paramInt1 <= 0) {
            break;
          }
          paramString2 = paramString1;
        } while (localPaint.measureText(paramString1) > 500);
        paramString2 = paramString1;
      }
      paramInt1 = (int)localPaint.measureText(paramString2);
      paramCanvas.drawText(paramString2, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72, localPaint);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getSharedPreferences("host", 0);
    try
    {
      paramContext = InetAddress.getByName(paramString).getHostAddress();
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, paramContext);
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("QRUtils", 2, "lookup address: " + paramString + ", ip: " + paramContext);
      }
      return;
    }
    catch (UnknownHostException paramContext)
    {
      paramContext.printStackTrace();
      return;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  private static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int j = paramInt1 / 2 - 68;
    paramInt2 = paramInt3 + 74;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    Rect localRect = new Rect(j, paramInt1, j + 136, paramInt1 + 67);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localPaint.setColorFilter(new PorterDuffColorFilter(Color.parseColor(paramString), PorterDuff.Mode.SRC_ATOP));
      paramCanvas.drawBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2130846958), null, localRect, localPaint);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        QLog.d("QRUtils", 1, "logoColor is illegal please check manage info logoColor = " + paramString);
      }
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  private static void a(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      paramInt1 = (paramInt1 - 440) / 2;
      Rect localRect = new Rect(paramInt1, paramInt2 + 228, paramInt1 + 440, paramInt2 + 228 + 440);
      localPaint.setAntiAlias(true);
      paramCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, zjt paramzjt)
  {
    paramString1 = zjr.a(paramInt1, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt1);
      }
      return;
    }
    paramString1 = paramString1.a();
    paramString2 = new znm(paramzjt);
    paramContext = new NewIntent(paramContext, zju.class);
    paramContext.putExtra("skey", paramString3);
    paramContext.putExtra("d", paramString1);
    paramContext.putExtra("cmd", "QRCodeSvc.encode");
    if (paramInt1 == 2) {
      paramContext.putExtra("no_verify_token", paramInt2);
    }
    paramContext.setObserver(paramString2);
    paramQQAppInterface.startServlet(paramContext);
  }
  
  private static void a(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setTextAlign(Paint.Align.LEFT);
    localPaint.setAntiAlias(true);
    localPaint.setColor(paramInt1);
    localPaint.setTextSize(28.0F);
    localPaint.setFlags(1);
    localPaint.setTypeface(Typeface.SANS_SERIF);
    if (paramString != null)
    {
      paramInt1 = (int)localPaint.measureText(paramString);
      paramCanvas.drawText(paramString, paramInt2 / 2 - paramInt1 / 2, paramInt3 - 66 + 140 + 72 + 42, localPaint);
    }
  }
  
  public static boolean a()
  {
    String str1 = Build.MANUFACTURER.toLowerCase();
    String str2 = Build.MODEL.toLowerCase();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ("meizu".equals(str1))
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(str2))
      {
        bool1 = bool2;
        if (str2.contains("pro 6 plus")) {
          bool1 = true;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "isMeizuRubbishDevices device: " + str1 + "   model:" + str2 + "  return:" + bool1);
    }
    return bool1;
  }
  
  /* Error */
  private static boolean a(Bitmap paramBitmap, ArrayList<Rect> paramArrayList, Canvas paramCanvas, Rect paramRect)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 5
    //   3: invokestatic 228	znl:a	()Z
    //   6: ifeq +139 -> 145
    //   9: aload_0
    //   10: astore 5
    //   12: aload_3
    //   13: invokevirtual 231	android/graphics/Rect:width	()I
    //   16: sipush 350
    //   19: if_icmple +126 -> 145
    //   22: aload_0
    //   23: astore 5
    //   25: aload_3
    //   26: invokevirtual 234	android/graphics/Rect:height	()I
    //   29: sipush 350
    //   32: if_icmple +113 -> 145
    //   35: aload_0
    //   36: astore 5
    //   38: aload_0
    //   39: ifnull +106 -> 145
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 231	android/graphics/Rect:width	()I
    //   47: iconst_2
    //   48: idiv
    //   49: aload_3
    //   50: invokevirtual 234	android/graphics/Rect:height	()I
    //   53: iconst_2
    //   54: idiv
    //   55: iconst_0
    //   56: invokestatic 238	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   59: astore 6
    //   61: aload_0
    //   62: astore 5
    //   64: aload 6
    //   66: ifnull +79 -> 145
    //   69: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +69 -> 141
    //   75: ldc 87
    //   77: iconst_2
    //   78: new 89	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   85: ldc 240
    //   87: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 6
    //   92: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   95: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc 245
    //   100: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload 6
    //   105: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   108: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: ldc 250
    //   113: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_0
    //   117: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   120: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: ldc 252
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_0
    //   129: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   132: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   135: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   141: aload 6
    //   143: astore 5
    //   145: aload_1
    //   146: ifnull +221 -> 367
    //   149: invokestatic 85	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +50 -> 202
    //   155: aload 5
    //   157: ifnull +45 -> 202
    //   160: ldc 87
    //   162: iconst_2
    //   163: new 89	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   170: ldc 254
    //   172: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 5
    //   177: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   180: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: ldc 245
    //   185: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: aload 5
    //   190: invokevirtual 248	android/graphics/Bitmap:getHeight	()I
    //   193: invokevirtual 101	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 143	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: aload 5
    //   204: aload_3
    //   205: invokevirtual 231	android/graphics/Rect:width	()I
    //   208: aload_3
    //   209: invokevirtual 234	android/graphics/Rect:height	()I
    //   212: iconst_0
    //   213: invokestatic 238	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   216: astore_0
    //   217: new 145	android/graphics/Canvas
    //   220: dup
    //   221: aload_0
    //   222: invokespecial 148	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   225: astore 5
    //   227: new 150	android/graphics/Paint
    //   230: dup
    //   231: invokespecial 151	android/graphics/Paint:<init>	()V
    //   234: astore 6
    //   236: aload 6
    //   238: iconst_0
    //   239: invokevirtual 257	android/graphics/Paint:setAlpha	(I)V
    //   242: aload 6
    //   244: iconst_1
    //   245: invokevirtual 160	android/graphics/Paint:setAntiAlias	(Z)V
    //   248: aload 6
    //   250: new 259	android/graphics/PorterDuffXfermode
    //   253: dup
    //   254: getstatic 265	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   257: invokespecial 268	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   260: invokevirtual 272	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   263: pop
    //   264: iconst_0
    //   265: istore 4
    //   267: iload 4
    //   269: aload_1
    //   270: invokevirtual 277	java/util/ArrayList:size	()I
    //   273: if_icmpge +73 -> 346
    //   276: aload 5
    //   278: new 153	android/graphics/Rect
    //   281: dup
    //   282: aload_1
    //   283: iload 4
    //   285: invokevirtual 281	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   288: checkcast 153	android/graphics/Rect
    //   291: invokespecial 284	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   294: aload 6
    //   296: invokevirtual 288	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   299: iload 4
    //   301: iconst_1
    //   302: iadd
    //   303: istore 4
    //   305: goto -38 -> 267
    //   308: astore 5
    //   310: ldc 87
    //   312: iconst_1
    //   313: new 89	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   320: ldc_w 319
    //   323: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: aload 5
    //   328: invokevirtual 320	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   331: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 107	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: aload_0
    //   341: astore 5
    //   343: goto -198 -> 145
    //   346: aload_2
    //   347: aload_0
    //   348: aconst_null
    //   349: aload_3
    //   350: aconst_null
    //   351: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   354: aload_0
    //   355: invokevirtual 323	android/graphics/Bitmap:recycle	()V
    //   358: iconst_0
    //   359: ireturn
    //   360: astore_0
    //   361: aload_0
    //   362: invokevirtual 330	java/lang/OutOfMemoryError:printStackTrace	()V
    //   365: iconst_1
    //   366: ireturn
    //   367: aload 5
    //   369: ifnull -11 -> 358
    //   372: aload_2
    //   373: aload 5
    //   375: aconst_null
    //   376: aload_3
    //   377: aconst_null
    //   378: invokevirtual 164	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   381: goto -23 -> 358
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	paramBitmap	Bitmap
    //   0	384	1	paramArrayList	ArrayList<Rect>
    //   0	384	2	paramCanvas	Canvas
    //   0	384	3	paramRect	Rect
    //   265	39	4	j	int
    //   1	276	5	localObject1	Object
    //   308	19	5	localThrowable	Throwable
    //   341	33	5	localBitmap	Bitmap
    //   59	236	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	61	308	java/lang/Throwable
    //   69	141	308	java/lang/Throwable
    //   202	264	360	java/lang/OutOfMemoryError
    //   267	299	360	java/lang/OutOfMemoryError
    //   346	358	360	java/lang/OutOfMemoryError
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("my_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveMyQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(a, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static final Bitmap[] a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ArrayList<Rect> paramArrayList, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    Bitmap[] arrayOfBitmap = new Bitmap[2];
    int n = Math.min(750, ScreenUtil.getRealWidth(paramContext));
    int i1 = Math.min(1344, ScreenUtil.getRealHeight(paramContext));
    if (QLog.isColorLevel()) {
      QLog.w("QRUtils", 2, "getMyQRCard() shareWidth=" + n + ",shareHeight=" + i1);
    }
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    try
    {
      localBitmap1 = Bitmap.createBitmap(440, 440, Bitmap.Config.ARGB_8888);
      localBitmap2 = Bitmap.createBitmap(n, i1, Bitmap.Config.ARGB_8888);
      if ((localBitmap1 == null) || (localBitmap2 == null))
      {
        QLog.d("QRUtils", 1, "getMyQRCard() myCode == null || myShare == null");
        return arrayOfBitmap;
      }
    }
    catch (OutOfMemoryError paramContext)
    {
      QLog.w("QRUtils", 1, paramContext.getMessage());
      return arrayOfBitmap;
    }
    if (a(paramBitmap3, paramArrayList, new Canvas(localBitmap1), new Rect(0, 0, 440, 440))) {
      return null;
    }
    arrayOfBitmap[0] = localBitmap1;
    paramBitmap3 = new Canvas(localBitmap2);
    if (QLog.isColorLevel()) {
      QLog.d("QRUtils", 2, " shareWidth = " + n + " shareHeight = " + i1);
    }
    a(paramBitmap1, n, i1, paramBitmap3);
    paramBitmap1 = new Paint();
    int i2 = (n - 550) / 2;
    int j = (i1 - 982) / 2;
    int k;
    if (j > 0)
    {
      j += 78;
      int m = j + 772;
      k = m;
      if (paramBoolean2) {
        k = m - 42;
      }
      paramArrayList = new RectF(i2, j, i2 + 550, k);
      paramBitmap1.setAntiAlias(true);
      paramBitmap1.setColor(Color.parseColor("#E6FFFFFF"));
      paramBitmap3.drawRoundRect(paramArrayList, 32.0F, 32.0F, paramBitmap1);
      a(n, paramBitmap3, j);
      b(paramBitmap2, n, paramBitmap3, j);
      a(paramInt1, paramString1, paramString2, n, paramBitmap3, j);
      if (paramBoolean2) {
        break label455;
      }
      a(localBitmap1, n, paramBitmap3, j - 42);
      a(paramInt1, paramString3, n, paramBitmap3, j - 42, k);
    }
    for (;;)
    {
      if (paramBoolean1) {
        a(paramContext, paramString4, n, i1, paramBitmap3, k);
      }
      arrayOfBitmap[1] = localBitmap2;
      return arrayOfBitmap;
      j = 78;
      break;
      label455:
      a(paramString2, paramInt2, n, paramBitmap3, j);
      a(localBitmap1, n, paramBitmap3, j);
      a(paramInt1, paramString3, n, paramBitmap3, j, k);
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    int j = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("troop_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getTroopQrBgIndexFromSp().settingValue:" + j);
    }
    return j;
  }
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QRUtils.2(paramInt1, paramInt2));
  }
  
  private static void b(Bitmap paramBitmap, int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    if (paramBitmap != null)
    {
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      paramInt1 = paramInt1 / 2 - 70;
      paramCanvas.drawBitmap(paramBitmap, null, new Rect(paramInt1, paramInt2 - 66, paramInt1 + 140, paramInt2 - 66 + 140), localPaint);
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("troop_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveTroopQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(h, paramString)) && (!Pattern.matches(i, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(i, paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://i.qianbao.qq.com/wallet/sqrcode.htm"))) {
      return false;
    }
    return true;
  }
  
  public static boolean e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://qpay.qq.com/qr/")) && (!paramString.startsWith("https://qpay.qq.com/qr/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://mqq.tenpay.com/qrhb")) && (!paramString.startsWith("https://mqq.tenpay.com/qrhb"))) {
      return false;
    }
    return true;
  }
  
  public static boolean g(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return URLUtil.isValidUrl(paramString);
  }
  
  public static boolean h(String paramString)
  {
    return (g(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean i(String paramString)
  {
    return Pattern.matches(b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     znl
 * JD-Core Version:    0.7.0.1
 */