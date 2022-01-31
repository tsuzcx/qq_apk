import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.util.QRUtils.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class vvp
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
  public static final android.graphics.Bitmap a(Context paramContext, android.graphics.Bitmap paramBitmap1, android.graphics.Bitmap paramBitmap2, int paramInt1, String paramString1, android.graphics.Bitmap paramBitmap3, android.graphics.Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, android.graphics.Rect paramRect, java.util.ArrayList<android.graphics.Rect> paramArrayList, int paramInt4)
  {
    // Byte code:
    //   0: sipush 540
    //   3: sipush 740
    //   6: getstatic 66	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 72	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: iload 12
    //   16: ifeq +1237 -> 1253
    //   19: aload_0
    //   20: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload 12
    //   25: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   28: astore 14
    //   30: aload 15
    //   32: ifnonnull +24 -> 56
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc 92
    //   46: iconst_2
    //   47: aload_0
    //   48: invokevirtual 96	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   51: invokestatic 100	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: new 102	android/graphics/Canvas
    //   59: dup
    //   60: aload 15
    //   62: invokespecial 106	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   65: astore 16
    //   67: aload_1
    //   68: ifnull +664 -> 732
    //   71: new 108	android/graphics/Paint
    //   74: dup
    //   75: invokespecial 110	android/graphics/Paint:<init>	()V
    //   78: astore 17
    //   80: new 112	android/graphics/Rect
    //   83: dup
    //   84: iconst_0
    //   85: iconst_0
    //   86: sipush 540
    //   89: sipush 740
    //   92: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   95: astore 18
    //   97: aload 17
    //   99: iconst_1
    //   100: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   103: aload 16
    //   105: aload_1
    //   106: aconst_null
    //   107: aload 18
    //   109: aload 17
    //   111: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: aload_2
    //   115: ifnull +41 -> 156
    //   118: new 108	android/graphics/Paint
    //   121: dup
    //   122: invokespecial 110	android/graphics/Paint:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: iconst_1
    //   128: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   131: aload 16
    //   133: aload_2
    //   134: aconst_null
    //   135: new 112	android/graphics/Rect
    //   138: dup
    //   139: bipush 20
    //   141: sipush 621
    //   144: bipush 120
    //   146: sipush 721
    //   149: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   152: aload_1
    //   153: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   156: iconst_0
    //   157: istore 12
    //   159: aload 14
    //   161: ifnull +52 -> 213
    //   164: iconst_1
    //   165: istore 12
    //   167: new 108	android/graphics/Paint
    //   170: dup
    //   171: invokespecial 110	android/graphics/Paint:<init>	()V
    //   174: astore_1
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   180: aload_1
    //   181: iconst_1
    //   182: invokevirtual 126	android/graphics/Paint:setFilterBitmap	(Z)V
    //   185: aload 16
    //   187: aload 14
    //   189: aconst_null
    //   190: new 112	android/graphics/Rect
    //   193: dup
    //   194: sipush 140
    //   197: sipush 633
    //   200: sipush 176
    //   203: sipush 669
    //   206: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   209: aload_1
    //   210: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   213: new 108	android/graphics/Paint
    //   216: dup
    //   217: invokespecial 110	android/graphics/Paint:<init>	()V
    //   220: astore 17
    //   222: aload 17
    //   224: getstatic 132	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   227: invokevirtual 136	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   230: aload 17
    //   232: iconst_1
    //   233: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   236: aload 17
    //   238: iload_3
    //   239: invokevirtual 140	android/graphics/Paint:setColor	(I)V
    //   242: aload 17
    //   244: ldc 141
    //   246: invokevirtual 145	android/graphics/Paint:setTextSize	(F)V
    //   249: aload 17
    //   251: iconst_1
    //   252: invokevirtual 148	android/graphics/Paint:setFlags	(I)V
    //   255: aload 17
    //   257: getstatic 154	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   260: invokevirtual 158	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   263: pop
    //   264: iload 12
    //   266: ifeq +570 -> 836
    //   269: sipush 342
    //   272: istore_3
    //   273: aload 4
    //   275: ifnull +112 -> 387
    //   278: iconst_2
    //   279: aload 4
    //   281: invokevirtual 164	java/lang/String:length	()I
    //   284: invokestatic 170	java/lang/Math:max	(II)I
    //   287: istore 13
    //   289: aload 4
    //   291: astore 14
    //   293: aload 17
    //   295: aload 4
    //   297: invokevirtual 174	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   300: iload_3
    //   301: i2f
    //   302: fcmpl
    //   303: ifle +62 -> 365
    //   306: iload 13
    //   308: iconst_2
    //   309: isub
    //   310: istore 13
    //   312: new 176	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   319: aload 4
    //   321: iconst_0
    //   322: iload 13
    //   324: invokevirtual 181	java/lang/String:substring	(II)Ljava/lang/String;
    //   327: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 187
    //   332: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_1
    //   339: aload_1
    //   340: astore 14
    //   342: iload 13
    //   344: ifle +21 -> 365
    //   347: aload_1
    //   348: astore 4
    //   350: aload 17
    //   352: aload_1
    //   353: invokevirtual 174	android/graphics/Paint:measureText	(Ljava/lang/String;)F
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
    //   380: ldc 191
    //   382: aload 17
    //   384: invokevirtual 195	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   387: aload 5
    //   389: ifnull +27 -> 416
    //   392: aload 16
    //   394: aload 5
    //   396: aconst_null
    //   397: new 112	android/graphics/Rect
    //   400: dup
    //   401: iconst_0
    //   402: iconst_0
    //   403: sipush 540
    //   406: sipush 600
    //   409: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   412: aconst_null
    //   413: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   416: aload 10
    //   418: ifnull +432 -> 850
    //   421: aload 6
    //   423: astore_1
    //   424: invokestatic 197	vvp:a	()Z
    //   427: ifeq +146 -> 573
    //   430: aload 6
    //   432: astore_1
    //   433: aload 10
    //   435: invokevirtual 200	android/graphics/Rect:width	()I
    //   438: sipush 350
    //   441: if_icmple +132 -> 573
    //   444: aload 6
    //   446: astore_1
    //   447: aload 10
    //   449: invokevirtual 203	android/graphics/Rect:height	()I
    //   452: sipush 350
    //   455: if_icmple +118 -> 573
    //   458: aload 6
    //   460: astore_1
    //   461: aload 6
    //   463: ifnull +110 -> 573
    //   466: aload 6
    //   468: aload 10
    //   470: invokevirtual 200	android/graphics/Rect:width	()I
    //   473: iconst_2
    //   474: idiv
    //   475: aload 10
    //   477: invokevirtual 203	android/graphics/Rect:height	()I
    //   480: iconst_2
    //   481: idiv
    //   482: iconst_0
    //   483: invokestatic 207	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   486: astore 4
    //   488: aload 6
    //   490: astore_1
    //   491: aload 4
    //   493: ifnull +80 -> 573
    //   496: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +71 -> 570
    //   502: ldc 92
    //   504: iconst_2
    //   505: new 176	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   512: ldc 209
    //   514: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload 4
    //   519: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   522: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: ldc 217
    //   527: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 4
    //   532: invokevirtual 220	android/graphics/Bitmap:getHeight	()I
    //   535: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: ldc 222
    //   540: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 6
    //   545: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   548: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: ldc 224
    //   553: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 6
    //   558: invokevirtual 220	android/graphics/Bitmap:getHeight	()I
    //   561: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   564: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 100	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: aload 4
    //   572: astore_1
    //   573: aload 11
    //   575: ifnull +473 -> 1048
    //   578: invokestatic 90	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +47 -> 628
    //   584: aload_1
    //   585: ifnull +43 -> 628
    //   588: ldc 92
    //   590: iconst_2
    //   591: new 176	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   598: ldc 226
    //   600: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_1
    //   604: invokevirtual 212	android/graphics/Bitmap:getWidth	()I
    //   607: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   610: ldc 217
    //   612: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: aload_1
    //   616: invokevirtual 220	android/graphics/Bitmap:getHeight	()I
    //   619: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   622: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: invokestatic 100	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: aload_1
    //   629: aload 10
    //   631: invokevirtual 200	android/graphics/Rect:width	()I
    //   634: aload 10
    //   636: invokevirtual 203	android/graphics/Rect:height	()I
    //   639: iconst_0
    //   640: invokestatic 207	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   643: astore_1
    //   644: new 102	android/graphics/Canvas
    //   647: dup
    //   648: aload_1
    //   649: invokespecial 106	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   652: astore 4
    //   654: new 108	android/graphics/Paint
    //   657: dup
    //   658: invokespecial 110	android/graphics/Paint:<init>	()V
    //   661: astore 5
    //   663: aload 5
    //   665: iconst_0
    //   666: invokevirtual 229	android/graphics/Paint:setAlpha	(I)V
    //   669: aload 5
    //   671: iconst_1
    //   672: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   675: aload 5
    //   677: new 231	android/graphics/PorterDuffXfermode
    //   680: dup
    //   681: getstatic 237	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   684: invokespecial 240	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   687: invokevirtual 244	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   690: pop
    //   691: iconst_0
    //   692: istore_3
    //   693: iload_3
    //   694: aload 11
    //   696: invokevirtual 249	java/util/ArrayList:size	()I
    //   699: if_icmpge +209 -> 908
    //   702: aload 4
    //   704: new 112	android/graphics/Rect
    //   707: dup
    //   708: aload 11
    //   710: iload_3
    //   711: invokevirtual 253	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   714: checkcast 112	android/graphics/Rect
    //   717: invokespecial 256	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   720: aload 5
    //   722: invokevirtual 260	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   725: iload_3
    //   726: iconst_1
    //   727: iadd
    //   728: istore_3
    //   729: goto -36 -> 693
    //   732: new 108	android/graphics/Paint
    //   735: dup
    //   736: invokespecial 110	android/graphics/Paint:<init>	()V
    //   739: astore_1
    //   740: aload_1
    //   741: new 262	android/graphics/LinearGradient
    //   744: dup
    //   745: fconst_0
    //   746: fconst_0
    //   747: fconst_0
    //   748: ldc_w 263
    //   751: ldc_w 264
    //   754: ldc_w 265
    //   757: getstatic 271	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   760: invokespecial 274	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   763: invokevirtual 278	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   766: pop
    //   767: aload 16
    //   769: fconst_0
    //   770: fconst_0
    //   771: ldc_w 279
    //   774: ldc_w 263
    //   777: aload_1
    //   778: invokevirtual 282	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   781: aload_1
    //   782: aconst_null
    //   783: invokevirtual 278	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   786: pop
    //   787: aload_1
    //   788: ldc_w 283
    //   791: invokevirtual 140	android/graphics/Paint:setColor	(I)V
    //   794: aload 16
    //   796: fconst_0
    //   797: ldc_w 263
    //   800: ldc_w 279
    //   803: ldc_w 263
    //   806: aload_1
    //   807: invokevirtual 286	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   810: aload_1
    //   811: ldc_w 287
    //   814: invokevirtual 140	android/graphics/Paint:setColor	(I)V
    //   817: aload 16
    //   819: fconst_0
    //   820: ldc_w 288
    //   823: ldc_w 279
    //   826: ldc_w 289
    //   829: aload_1
    //   830: invokevirtual 282	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   833: goto -719 -> 114
    //   836: sipush 380
    //   839: istore_3
    //   840: goto -567 -> 273
    //   843: sipush 140
    //   846: istore_3
    //   847: goto -473 -> 374
    //   850: new 112	android/graphics/Rect
    //   853: dup
    //   854: bipush 70
    //   856: bipush 100
    //   858: sipush 470
    //   861: sipush 500
    //   864: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   867: astore 10
    //   869: goto -448 -> 421
    //   872: astore_1
    //   873: ldc 92
    //   875: iconst_2
    //   876: new 176	java/lang/StringBuilder
    //   879: dup
    //   880: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   883: ldc_w 291
    //   886: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: aload_1
    //   890: invokevirtual 292	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   893: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: invokestatic 294	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   902: aload 6
    //   904: astore_1
    //   905: goto -332 -> 573
    //   908: aload 16
    //   910: aload_1
    //   911: aconst_null
    //   912: aload 10
    //   914: aconst_null
    //   915: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   918: aload_1
    //   919: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   922: iload 7
    //   924: iconst_1
    //   925: if_icmpne +136 -> 1061
    //   928: new 108	android/graphics/Paint
    //   931: dup
    //   932: invokespecial 110	android/graphics/Paint:<init>	()V
    //   935: astore_1
    //   936: aload_1
    //   937: iconst_1
    //   938: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   941: new 112	android/graphics/Rect
    //   944: dup
    //   945: sipush 217
    //   948: sipush 247
    //   951: sipush 323
    //   954: sipush 353
    //   957: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   960: astore_2
    //   961: aload_0
    //   962: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   965: ldc_w 298
    //   968: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   971: astore_0
    //   972: aload 16
    //   974: aload_0
    //   975: aconst_null
    //   976: aload_2
    //   977: aload_1
    //   978: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   981: aload_0
    //   982: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   985: new 108	android/graphics/Paint
    //   988: dup
    //   989: invokespecial 110	android/graphics/Paint:<init>	()V
    //   992: astore_0
    //   993: aload_0
    //   994: getstatic 132	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   997: invokevirtual 136	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   1000: aload_0
    //   1001: iconst_1
    //   1002: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1005: aload_0
    //   1006: iload 8
    //   1008: invokevirtual 140	android/graphics/Paint:setColor	(I)V
    //   1011: aload_0
    //   1012: ldc_w 299
    //   1015: invokevirtual 145	android/graphics/Paint:setTextSize	(F)V
    //   1018: aload_0
    //   1019: aconst_null
    //   1020: invokevirtual 158	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   1023: pop
    //   1024: aload 16
    //   1026: aload 9
    //   1028: ldc_w 300
    //   1031: ldc_w 301
    //   1034: aload_0
    //   1035: invokevirtual 195	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1038: aload 15
    //   1040: areturn
    //   1041: astore_0
    //   1042: aload_0
    //   1043: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1046: aconst_null
    //   1047: areturn
    //   1048: aload 16
    //   1050: aload_1
    //   1051: aconst_null
    //   1052: aload 10
    //   1054: aconst_null
    //   1055: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1058: goto -136 -> 922
    //   1061: iload 7
    //   1063: iconst_2
    //   1064: if_icmpne +57 -> 1121
    //   1067: aload_2
    //   1068: ifnull +53 -> 1121
    //   1071: new 108	android/graphics/Paint
    //   1074: dup
    //   1075: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1078: astore_0
    //   1079: aload_0
    //   1080: iconst_1
    //   1081: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1084: aload 16
    //   1086: aload_2
    //   1087: aconst_null
    //   1088: new 112	android/graphics/Rect
    //   1091: dup
    //   1092: sipush 217
    //   1095: sipush 247
    //   1098: sipush 323
    //   1101: sipush 353
    //   1104: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1107: aload_0
    //   1108: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1111: goto -126 -> 985
    //   1114: astore_0
    //   1115: aload_0
    //   1116: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1119: aconst_null
    //   1120: areturn
    //   1121: iload 7
    //   1123: iconst_3
    //   1124: if_icmpne +63 -> 1187
    //   1127: new 108	android/graphics/Paint
    //   1130: dup
    //   1131: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1134: astore_1
    //   1135: aload_1
    //   1136: iconst_1
    //   1137: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1140: new 112	android/graphics/Rect
    //   1143: dup
    //   1144: sipush 217
    //   1147: sipush 247
    //   1150: sipush 323
    //   1153: sipush 353
    //   1156: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1159: astore_2
    //   1160: aload_0
    //   1161: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1164: ldc_w 298
    //   1167: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1170: astore_0
    //   1171: aload 16
    //   1173: aload_0
    //   1174: aconst_null
    //   1175: aload_2
    //   1176: aload_1
    //   1177: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1180: aload_0
    //   1181: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   1184: goto -199 -> 985
    //   1187: iload 7
    //   1189: iconst_4
    //   1190: if_icmpne -205 -> 985
    //   1193: new 108	android/graphics/Paint
    //   1196: dup
    //   1197: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1200: astore_1
    //   1201: aload_1
    //   1202: iconst_1
    //   1203: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1206: new 112	android/graphics/Rect
    //   1209: dup
    //   1210: sipush 217
    //   1213: sipush 247
    //   1216: sipush 323
    //   1219: sipush 353
    //   1222: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1225: astore_2
    //   1226: aload_0
    //   1227: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1230: ldc_w 298
    //   1233: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1236: astore_0
    //   1237: aload 16
    //   1239: aload_0
    //   1240: aconst_null
    //   1241: aload_2
    //   1242: aload_1
    //   1243: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1246: aload_0
    //   1247: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   1250: goto -265 -> 985
    //   1253: aconst_null
    //   1254: astore 14
    //   1256: goto -1226 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1259	0	paramContext	Context
    //   0	1259	1	paramBitmap1	android.graphics.Bitmap
    //   0	1259	2	paramBitmap2	android.graphics.Bitmap
    //   0	1259	3	paramInt1	int
    //   0	1259	4	paramString1	String
    //   0	1259	5	paramBitmap3	android.graphics.Bitmap
    //   0	1259	6	paramBitmap4	android.graphics.Bitmap
    //   0	1259	7	paramInt2	int
    //   0	1259	8	paramInt3	int
    //   0	1259	9	paramString2	String
    //   0	1259	10	paramRect	android.graphics.Rect
    //   0	1259	11	paramArrayList	java.util.ArrayList<android.graphics.Rect>
    //   0	1259	12	paramInt4	int
    //   287	56	13	j	int
    //   28	1227	14	localObject	Object
    //   12	1027	15	localBitmap	android.graphics.Bitmap
    //   65	1173	16	localCanvas	android.graphics.Canvas
    //   78	305	17	localPaint	android.graphics.Paint
    //   95	13	18	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/OutOfMemoryError
    //   19	30	37	java/lang/OutOfMemoryError
    //   466	488	872	java/lang/Throwable
    //   496	570	872	java/lang/Throwable
    //   628	691	1041	java/lang/OutOfMemoryError
    //   693	725	1041	java/lang/OutOfMemoryError
    //   908	922	1041	java/lang/OutOfMemoryError
    //   928	985	1114	java/lang/OutOfMemoryError
    //   1071	1111	1114	java/lang/OutOfMemoryError
    //   1127	1184	1114	java/lang/OutOfMemoryError
    //   1193	1250	1114	java/lang/OutOfMemoryError
  }
  
  public static gq a(String paramString, int paramInt)
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
    localObject = new gu();
    try
    {
      paramString = ((gu)localObject).a(paramString, 0, 0, localEnumMap);
      return paramString;
    }
    catch (WriterException paramString)
    {
      paramString.printStackTrace();
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
  public static String a(Context paramContext, String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: getstatic 390	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 8
    //   11: if_icmplt +153 -> 164
    //   14: aload_0
    //   15: invokevirtual 394	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   18: astore_3
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 397	android/content/Context:getCacheDir	()Ljava/io/File;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull -30 -> 4
    //   37: aload 4
    //   39: invokevirtual 402	java/io/File:canWrite	()Z
    //   42: ifeq -38 -> 4
    //   45: new 176	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 405	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 408	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore 5
    //   75: new 399	java/io/File
    //   78: dup
    //   79: aload 5
    //   81: invokespecial 411	java/io/File:<init>	(Ljava/lang/String;)V
    //   84: astore_0
    //   85: aload_0
    //   86: invokevirtual 414	java/io/File:exists	()Z
    //   89: ifeq +8 -> 97
    //   92: aload_0
    //   93: invokevirtual 417	java/io/File:delete	()Z
    //   96: pop
    //   97: new 419	java/io/FileOutputStream
    //   100: dup
    //   101: aload_0
    //   102: invokespecial 422	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   105: astore_0
    //   106: new 424	java/io/BufferedOutputStream
    //   109: dup
    //   110: aload_0
    //   111: invokespecial 427	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   114: astore 4
    //   116: aload 4
    //   118: astore_3
    //   119: aload_0
    //   120: astore_1
    //   121: aload_2
    //   122: getstatic 433	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   125: bipush 100
    //   127: aload 4
    //   129: invokevirtual 437	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   132: pop
    //   133: aload 4
    //   135: astore_3
    //   136: aload_0
    //   137: astore_1
    //   138: aload 4
    //   140: invokevirtual 440	java/io/BufferedOutputStream:flush	()V
    //   143: aload 4
    //   145: ifnull +8 -> 153
    //   148: aload 4
    //   150: invokevirtual 443	java/io/BufferedOutputStream:close	()V
    //   153: aload_0
    //   154: ifnull +7 -> 161
    //   157: aload_0
    //   158: invokevirtual 444	java/io/FileOutputStream:close	()V
    //   161: aload 5
    //   163: areturn
    //   164: new 399	java/io/File
    //   167: dup
    //   168: invokestatic 449	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   171: new 176	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 177	java/lang/StringBuilder:<init>	()V
    //   178: ldc_w 451
    //   181: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_0
    //   185: invokevirtual 454	android/content/Context:getPackageName	()Ljava/lang/String;
    //   188: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: ldc_w 456
    //   194: invokevirtual 185	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 459	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   203: astore_3
    //   204: aload_3
    //   205: invokevirtual 462	java/io/File:mkdirs	()Z
    //   208: pop
    //   209: goto -190 -> 19
    //   212: astore_0
    //   213: aload_0
    //   214: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   217: goto -56 -> 161
    //   220: astore 5
    //   222: aconst_null
    //   223: astore_2
    //   224: aconst_null
    //   225: astore_0
    //   226: aload_2
    //   227: astore_3
    //   228: aload_0
    //   229: astore_1
    //   230: aload 5
    //   232: invokevirtual 464	java/io/FileNotFoundException:printStackTrace	()V
    //   235: aload_2
    //   236: ifnull +7 -> 243
    //   239: aload_2
    //   240: invokevirtual 443	java/io/BufferedOutputStream:close	()V
    //   243: aload_0
    //   244: ifnull -240 -> 4
    //   247: aload_0
    //   248: invokevirtual 444	java/io/FileOutputStream:close	()V
    //   251: aconst_null
    //   252: areturn
    //   253: astore_0
    //   254: aload_0
    //   255: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   258: aconst_null
    //   259: areturn
    //   260: astore 5
    //   262: aconst_null
    //   263: astore_2
    //   264: aconst_null
    //   265: astore_0
    //   266: aload_2
    //   267: astore_3
    //   268: aload_0
    //   269: astore_1
    //   270: aload 5
    //   272: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   275: aload_2
    //   276: ifnull +7 -> 283
    //   279: aload_2
    //   280: invokevirtual 443	java/io/BufferedOutputStream:close	()V
    //   283: aload_0
    //   284: ifnull -280 -> 4
    //   287: aload_0
    //   288: invokevirtual 444	java/io/FileOutputStream:close	()V
    //   291: aconst_null
    //   292: areturn
    //   293: astore_0
    //   294: aload_0
    //   295: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   298: aconst_null
    //   299: areturn
    //   300: astore_2
    //   301: aconst_null
    //   302: astore_3
    //   303: aconst_null
    //   304: astore_0
    //   305: aload_3
    //   306: ifnull +7 -> 313
    //   309: aload_3
    //   310: invokevirtual 443	java/io/BufferedOutputStream:close	()V
    //   313: aload_0
    //   314: ifnull +7 -> 321
    //   317: aload_0
    //   318: invokevirtual 444	java/io/FileOutputStream:close	()V
    //   321: aload_2
    //   322: athrow
    //   323: astore_0
    //   324: aload_0
    //   325: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   328: goto -7 -> 321
    //   331: astore_1
    //   332: goto -179 -> 153
    //   335: astore_1
    //   336: goto -93 -> 243
    //   339: astore_1
    //   340: goto -57 -> 283
    //   343: astore_1
    //   344: goto -31 -> 313
    //   347: astore_2
    //   348: aconst_null
    //   349: astore_3
    //   350: goto -45 -> 305
    //   353: astore_2
    //   354: aload_1
    //   355: astore_0
    //   356: goto -51 -> 305
    //   359: astore 5
    //   361: aconst_null
    //   362: astore_2
    //   363: goto -97 -> 266
    //   366: astore 5
    //   368: aload 4
    //   370: astore_2
    //   371: goto -105 -> 266
    //   374: astore 5
    //   376: aconst_null
    //   377: astore_2
    //   378: goto -152 -> 226
    //   381: astore 5
    //   383: aload 4
    //   385: astore_2
    //   386: goto -160 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramContext	Context
    //   0	389	1	paramString	String
    //   0	389	2	paramBitmap	android.graphics.Bitmap
    //   18	332	3	localObject1	Object
    //   20	364	4	localObject2	Object
    //   73	89	5	str	String
    //   220	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   260	11	5	localIOException1	java.io.IOException
    //   359	1	5	localIOException2	java.io.IOException
    //   366	1	5	localIOException3	java.io.IOException
    //   374	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   381	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   157	161	212	java/io/IOException
    //   97	106	220	java/io/FileNotFoundException
    //   247	251	253	java/io/IOException
    //   97	106	260	java/io/IOException
    //   287	291	293	java/io/IOException
    //   97	106	300	finally
    //   317	321	323	java/io/IOException
    //   148	153	331	java/io/IOException
    //   239	243	335	java/io/IOException
    //   279	283	339	java/io/IOException
    //   309	313	343	java/io/IOException
    //   106	116	347	finally
    //   121	133	353	finally
    //   138	143	353	finally
    //   230	235	353	finally
    //   270	275	353	finally
    //   106	116	359	java/io/IOException
    //   121	133	366	java/io/IOException
    //   138	143	366	java/io/IOException
    //   106	116	374	java/io/FileNotFoundException
    //   121	133	381	java/io/FileNotFoundException
    //   138	143	381	java/io/FileNotFoundException
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
    bbmy.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131167766));
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, vsp paramvsp)
  {
    paramString1 = vsn.a(paramInt, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt);
      }
      return;
    }
    paramString1 = paramString1.a();
    paramString2 = new vvq(paramvsp);
    paramContext = new NewIntent(paramContext, vsq.class);
    paramContext.putExtra("skey", paramString3);
    paramContext.putExtra("d", paramString1);
    paramContext.putExtra("cmd", "QRCodeSvc.encode");
    paramContext.setObserver(paramString2);
    paramQQAppInterface.startServlet(paramContext);
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
  
  public static void b(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QRUtils.2(paramInt1, paramInt2));
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
 * Qualified Name:     vvp
 * JD-Core Version:    0.7.0.1
 */