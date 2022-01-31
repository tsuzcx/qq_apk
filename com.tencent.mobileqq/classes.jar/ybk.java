import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.util.QRUtils.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;

public class ybk
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
    //   16: ifeq +1239 -> 1255
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
    //   424: invokestatic 197	ybk:a	()Z
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
    //   575: ifnull +475 -> 1050
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
    //   925: if_icmpne +138 -> 1063
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
    //   1019: getstatic 154	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   1022: invokevirtual 158	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   1025: pop
    //   1026: aload 16
    //   1028: aload 9
    //   1030: ldc_w 300
    //   1033: ldc_w 301
    //   1036: aload_0
    //   1037: invokevirtual 195	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1040: aload 15
    //   1042: areturn
    //   1043: astore_0
    //   1044: aload_0
    //   1045: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1048: aconst_null
    //   1049: areturn
    //   1050: aload 16
    //   1052: aload_1
    //   1053: aconst_null
    //   1054: aload 10
    //   1056: aconst_null
    //   1057: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1060: goto -138 -> 922
    //   1063: iload 7
    //   1065: iconst_2
    //   1066: if_icmpne +57 -> 1123
    //   1069: aload_2
    //   1070: ifnull +53 -> 1123
    //   1073: new 108	android/graphics/Paint
    //   1076: dup
    //   1077: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1080: astore_0
    //   1081: aload_0
    //   1082: iconst_1
    //   1083: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1086: aload 16
    //   1088: aload_2
    //   1089: aconst_null
    //   1090: new 112	android/graphics/Rect
    //   1093: dup
    //   1094: sipush 217
    //   1097: sipush 247
    //   1100: sipush 323
    //   1103: sipush 353
    //   1106: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1109: aload_0
    //   1110: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1113: goto -128 -> 985
    //   1116: astore_0
    //   1117: aload_0
    //   1118: invokevirtual 304	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1121: aconst_null
    //   1122: areturn
    //   1123: iload 7
    //   1125: iconst_3
    //   1126: if_icmpne +63 -> 1189
    //   1129: new 108	android/graphics/Paint
    //   1132: dup
    //   1133: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1136: astore_1
    //   1137: aload_1
    //   1138: iconst_1
    //   1139: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1142: new 112	android/graphics/Rect
    //   1145: dup
    //   1146: sipush 217
    //   1149: sipush 247
    //   1152: sipush 323
    //   1155: sipush 353
    //   1158: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1161: astore_2
    //   1162: aload_0
    //   1163: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1166: ldc_w 298
    //   1169: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1172: astore_0
    //   1173: aload 16
    //   1175: aload_0
    //   1176: aconst_null
    //   1177: aload_2
    //   1178: aload_1
    //   1179: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1182: aload_0
    //   1183: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   1186: goto -201 -> 985
    //   1189: iload 7
    //   1191: iconst_4
    //   1192: if_icmpne -207 -> 985
    //   1195: new 108	android/graphics/Paint
    //   1198: dup
    //   1199: invokespecial 110	android/graphics/Paint:<init>	()V
    //   1202: astore_1
    //   1203: aload_1
    //   1204: iconst_1
    //   1205: invokevirtual 119	android/graphics/Paint:setAntiAlias	(Z)V
    //   1208: new 112	android/graphics/Rect
    //   1211: dup
    //   1212: sipush 217
    //   1215: sipush 247
    //   1218: sipush 323
    //   1221: sipush 353
    //   1224: invokespecial 115	android/graphics/Rect:<init>	(IIII)V
    //   1227: astore_2
    //   1228: aload_0
    //   1229: invokevirtual 78	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1232: ldc_w 298
    //   1235: invokestatic 84	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1238: astore_0
    //   1239: aload 16
    //   1241: aload_0
    //   1242: aconst_null
    //   1243: aload_2
    //   1244: aload_1
    //   1245: invokevirtual 123	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1248: aload_0
    //   1249: invokevirtual 297	android/graphics/Bitmap:recycle	()V
    //   1252: goto -267 -> 985
    //   1255: aconst_null
    //   1256: astore 14
    //   1258: goto -1228 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1261	0	paramContext	Context
    //   0	1261	1	paramBitmap1	android.graphics.Bitmap
    //   0	1261	2	paramBitmap2	android.graphics.Bitmap
    //   0	1261	3	paramInt1	int
    //   0	1261	4	paramString1	String
    //   0	1261	5	paramBitmap3	android.graphics.Bitmap
    //   0	1261	6	paramBitmap4	android.graphics.Bitmap
    //   0	1261	7	paramInt2	int
    //   0	1261	8	paramInt3	int
    //   0	1261	9	paramString2	String
    //   0	1261	10	paramRect	android.graphics.Rect
    //   0	1261	11	paramArrayList	java.util.ArrayList<android.graphics.Rect>
    //   0	1261	12	paramInt4	int
    //   287	56	13	j	int
    //   28	1229	14	localObject	Object
    //   12	1029	15	localBitmap	android.graphics.Bitmap
    //   65	1175	16	localCanvas	android.graphics.Canvas
    //   78	305	17	localPaint	android.graphics.Paint
    //   95	13	18	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/OutOfMemoryError
    //   19	30	37	java/lang/OutOfMemoryError
    //   466	488	872	java/lang/Throwable
    //   496	570	872	java/lang/Throwable
    //   628	691	1043	java/lang/OutOfMemoryError
    //   693	725	1043	java/lang/OutOfMemoryError
    //   908	922	1043	java/lang/OutOfMemoryError
    //   928	985	1116	java/lang/OutOfMemoryError
    //   1073	1113	1116	java/lang/OutOfMemoryError
    //   1129	1186	1116	java/lang/OutOfMemoryError
    //   1195	1252	1116	java/lang/OutOfMemoryError
  }
  
  public static gs a(String paramString, int paramInt)
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
    localObject = new gw();
    try
    {
      paramString = ((gw)localObject).a(paramString, 0, 0, localEnumMap);
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
  public static String a(Context paramContext, String paramString, android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 388	java/io/File
    //   9: dup
    //   10: ldc_w 390
    //   13: invokestatic 395	bdzf:a	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 398	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 401	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnonnull +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 405	android/content/Context:getCacheDir	()Ljava/io/File;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -37 -> 4
    //   44: aload_3
    //   45: invokevirtual 408	java/io/File:canWrite	()Z
    //   48: ifeq -44 -> 4
    //   51: new 388	java/io/File
    //   54: dup
    //   55: aload_3
    //   56: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 414	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 411	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: astore 5
    //   70: aload_0
    //   71: invokevirtual 417	java/io/File:exists	()Z
    //   74: ifeq +8 -> 82
    //   77: aload_0
    //   78: invokevirtual 420	java/io/File:delete	()Z
    //   81: pop
    //   82: new 422	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 425	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: new 427	java/io/BufferedOutputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 430	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: getstatic 436	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload 4
    //   114: invokevirtual 440	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   117: pop
    //   118: aload 4
    //   120: astore_3
    //   121: aload_0
    //   122: astore_1
    //   123: aload 4
    //   125: invokevirtual 443	java/io/BufferedOutputStream:flush	()V
    //   128: aload 4
    //   130: ifnull +8 -> 138
    //   133: aload 4
    //   135: invokevirtual 446	java/io/BufferedOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 448	java/io/IOException:printStackTrace	()V
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
    //   169: invokevirtual 449	java/io/FileNotFoundException:printStackTrace	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 446	java/io/BufferedOutputStream:close	()V
    //   180: aload_0
    //   181: ifnull -177 -> 4
    //   184: aload_0
    //   185: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 448	java/io/IOException:printStackTrace	()V
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
    //   209: invokevirtual 448	java/io/IOException:printStackTrace	()V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 446	java/io/BufferedOutputStream:close	()V
    //   220: aload_0
    //   221: ifnull -217 -> 4
    //   224: aload_0
    //   225: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 448	java/io/IOException:printStackTrace	()V
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
    //   247: invokevirtual 446	java/io/BufferedOutputStream:close	()V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 447	java/io/FileOutputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 448	java/io/IOException:printStackTrace	()V
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
    //   0	326	2	paramBitmap	android.graphics.Bitmap
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
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).b(localBaseApplication.getResources().getDimensionPixelSize(2131298914));
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, xyj paramxyj)
  {
    paramString1 = xyh.a(paramInt, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt);
      }
      return;
    }
    paramString1 = paramString1.a();
    paramString2 = new ybl(paramxyj);
    paramContext = new NewIntent(paramContext, xyk.class);
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
 * Qualified Name:     ybk
 * JD-Core Version:    0.7.0.1
 */