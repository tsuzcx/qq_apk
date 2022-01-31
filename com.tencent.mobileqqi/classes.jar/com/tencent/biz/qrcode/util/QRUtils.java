package com.tencent.biz.qrcode.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import btj;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.QRActionEntity;
import com.tencent.biz.qrcode.QRCodeEncodeCallback;
import com.tencent.biz.qrcode.QRCodeServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.EnumMap;
import java.util.Map;
import java.util.regex.Pattern;
import mqq.app.NewIntent;

public class QRUtils
{
  protected static String A = "182.254.1.144";
  private static String B;
  private static String C;
  public static final int a = 540;
  protected static final String a = "QRUtils";
  public static final int b = 740;
  public static final String b = "";
  public static final int c = 600;
  public static final String c = "addfriend_QR";
  public static final String d = "find_QR";
  public static final String e = "bigpicture_QR";
  public static final String f = "bulb_QR";
  public static final String g = "shareConsumerQRcard";
  public static final String h = "shareGroupQRcard";
  public static final String i = "saveConsumerQRcard";
  public static final String j = "saveGroupQRcard";
  public static final String k = "ConsumerQRcard";
  public static final String l = "GroupQRcard";
  public static final String m = "PublicAccountQRcard";
  public static final String n = "ThirdpartyQRcard";
  public static final String o = "TPQRcardurl";
  public static final String p = "TPQRcardtext";
  public static final String q = "TPQRcardphone";
  public static final String r = "changeConsumerQRcard";
  public static final String s = "changeGroupQRcard";
  protected static String t = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  protected static String u;
  protected static String v;
  public static String w;
  protected static String x;
  protected static String y;
  protected static String z;
  
  static
  {
    B = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
    C = "^https?://url\\.cn/.+#flyticket";
    u = "^((?:(?i)https?://|www\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)$";
    v = ".*(\\+86|086)?\\d{5,12}.*";
    w = "qm.qq.com";
    x = "183.61.32.185";
    y = "58.250.135.158";
    z = "120.198.189.104";
  }
  
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
    long l1 = 0L;
    int i2 = paramArrayOfByte.length;
    int i1 = 0;
    while (i1 < i2)
    {
      l1 += ((paramArrayOfByte[(i2 - i1 - 1)] & 0xFF) << i1 * 8);
      i1 += 1;
    }
    return l1;
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, java.util.ArrayList paramArrayList, Bitmap paramBitmap5)
  {
    // Byte code:
    //   0: sipush 540
    //   3: sipush 740
    //   6: getstatic 133	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 139	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: new 141	android/graphics/Canvas
    //   17: dup
    //   18: aload 15
    //   20: invokespecial 144	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   23: astore 16
    //   25: aload_1
    //   26: ifnull +556 -> 582
    //   29: new 146	android/graphics/Paint
    //   32: dup
    //   33: invokespecial 147	android/graphics/Paint:<init>	()V
    //   36: astore 17
    //   38: new 149	android/graphics/Rect
    //   41: dup
    //   42: iconst_0
    //   43: iconst_0
    //   44: sipush 540
    //   47: sipush 740
    //   50: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   53: astore 18
    //   55: aload 17
    //   57: iconst_1
    //   58: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   61: aload 16
    //   63: aload_1
    //   64: aconst_null
    //   65: aload 18
    //   67: aload 17
    //   69: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   72: aload_2
    //   73: ifnull +41 -> 114
    //   76: new 146	android/graphics/Paint
    //   79: dup
    //   80: invokespecial 147	android/graphics/Paint:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   89: aload 16
    //   91: aload_2
    //   92: aconst_null
    //   93: new 149	android/graphics/Rect
    //   96: dup
    //   97: bipush 20
    //   99: sipush 621
    //   102: bipush 120
    //   104: sipush 721
    //   107: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   110: aload_1
    //   111: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: iconst_0
    //   115: istore 13
    //   117: aload 12
    //   119: ifnull +52 -> 171
    //   122: iconst_1
    //   123: istore 13
    //   125: new 146	android/graphics/Paint
    //   128: dup
    //   129: invokespecial 147	android/graphics/Paint:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   138: aload_1
    //   139: iconst_1
    //   140: invokevirtual 163	android/graphics/Paint:setFilterBitmap	(Z)V
    //   143: aload 16
    //   145: aload 12
    //   147: aconst_null
    //   148: new 149	android/graphics/Rect
    //   151: dup
    //   152: sipush 140
    //   155: sipush 633
    //   158: sipush 176
    //   161: sipush 669
    //   164: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   167: aload_1
    //   168: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   171: new 146	android/graphics/Paint
    //   174: dup
    //   175: invokespecial 147	android/graphics/Paint:<init>	()V
    //   178: astore 17
    //   180: aload 17
    //   182: getstatic 169	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   185: invokevirtual 173	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   188: aload 17
    //   190: iconst_1
    //   191: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   194: aload 17
    //   196: iload_3
    //   197: invokevirtual 177	android/graphics/Paint:setColor	(I)V
    //   200: aload 17
    //   202: ldc 178
    //   204: invokevirtual 182	android/graphics/Paint:setTextSize	(F)V
    //   207: aload 17
    //   209: iconst_1
    //   210: invokevirtual 185	android/graphics/Paint:setFlags	(I)V
    //   213: aload 17
    //   215: getstatic 191	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   218: invokevirtual 195	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   221: pop
    //   222: iload 13
    //   224: ifeq +462 -> 686
    //   227: sipush 342
    //   230: istore_3
    //   231: aload 4
    //   233: astore 12
    //   235: aload 4
    //   237: ifnull +90 -> 327
    //   240: iconst_2
    //   241: aload 4
    //   243: invokevirtual 201	java/lang/String:length	()I
    //   246: invokestatic 207	java/lang/Math:max	(II)I
    //   249: istore 14
    //   251: aload 4
    //   253: astore 12
    //   255: aload 17
    //   257: aload 4
    //   259: invokevirtual 211	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   262: iload_3
    //   263: i2f
    //   264: fcmpl
    //   265: ifle +62 -> 327
    //   268: iload 14
    //   270: iconst_2
    //   271: isub
    //   272: istore 14
    //   274: new 213	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   281: aload 4
    //   283: iconst_0
    //   284: iload 14
    //   286: invokevirtual 218	java/lang/String:substring	(II)Ljava/lang/String;
    //   289: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: ldc 224
    //   294: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   300: astore_1
    //   301: aload_1
    //   302: astore 12
    //   304: iload 14
    //   306: ifle +21 -> 327
    //   309: aload_1
    //   310: astore 4
    //   312: aload 17
    //   314: aload_1
    //   315: invokevirtual 211	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   318: iload_3
    //   319: i2f
    //   320: fcmpl
    //   321: ifgt -53 -> 268
    //   324: aload_1
    //   325: astore 12
    //   327: iload 13
    //   329: ifeq +364 -> 693
    //   332: sipush 182
    //   335: istore_3
    //   336: aload 16
    //   338: aload 12
    //   340: iload_3
    //   341: i2f
    //   342: ldc 229
    //   344: aload 17
    //   346: invokevirtual 233	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   349: aload 5
    //   351: ifnull +27 -> 378
    //   354: aload 16
    //   356: aload 5
    //   358: aconst_null
    //   359: new 149	android/graphics/Rect
    //   362: dup
    //   363: iconst_0
    //   364: iconst_0
    //   365: sipush 540
    //   368: sipush 600
    //   371: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   374: aconst_null
    //   375: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   378: aload 10
    //   380: ifnull +320 -> 700
    //   383: aload 11
    //   385: ifnull +477 -> 862
    //   388: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +45 -> 436
    //   394: ldc 13
    //   396: iconst_2
    //   397: new 213	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   404: ldc 241
    //   406: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload 6
    //   411: invokevirtual 244	android/graphics/Bitmap:getWidth	()I
    //   414: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   417: ldc 249
    //   419: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 6
    //   424: invokevirtual 252	android/graphics/Bitmap:getHeight	()I
    //   427: invokevirtual 247	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   430: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 255	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload 6
    //   438: aload 10
    //   440: invokevirtual 258	android/graphics/Rect:width	()I
    //   443: aload 10
    //   445: invokevirtual 261	android/graphics/Rect:height	()I
    //   448: iconst_0
    //   449: invokestatic 265	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   452: astore_1
    //   453: new 141	android/graphics/Canvas
    //   456: dup
    //   457: aload_1
    //   458: invokespecial 144	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   461: astore 4
    //   463: new 146	android/graphics/Paint
    //   466: dup
    //   467: invokespecial 147	android/graphics/Paint:<init>	()V
    //   470: astore 5
    //   472: aload 5
    //   474: iconst_0
    //   475: invokevirtual 268	android/graphics/Paint:setAlpha	(I)V
    //   478: aload 5
    //   480: iconst_1
    //   481: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   484: aload 5
    //   486: new 270	android/graphics/PorterDuffXfermode
    //   489: dup
    //   490: getstatic 276	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   493: invokespecial 279	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   496: invokevirtual 283	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   499: pop
    //   500: iconst_0
    //   501: istore_3
    //   502: iload_3
    //   503: aload 11
    //   505: invokevirtual 288	java/util/ArrayList:size	()I
    //   508: if_icmpge +214 -> 722
    //   511: aload 4
    //   513: new 149	android/graphics/Rect
    //   516: dup
    //   517: aload 11
    //   519: iload_3
    //   520: invokevirtual 292	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   523: checkcast 149	android/graphics/Rect
    //   526: invokespecial 295	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   529: aload 5
    //   531: invokevirtual 299	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   534: iload_3
    //   535: iconst_1
    //   536: iadd
    //   537: istore_3
    //   538: goto -36 -> 502
    //   541: astore 15
    //   543: invokestatic 304	java/lang/System:gc	()V
    //   546: sipush 540
    //   549: sipush 740
    //   552: getstatic 133	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   555: invokestatic 139	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   558: astore 15
    //   560: goto -546 -> 14
    //   563: astore_0
    //   564: invokestatic 239	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +13 -> 580
    //   570: ldc 13
    //   572: iconst_2
    //   573: aload_0
    //   574: invokevirtual 307	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   577: invokestatic 255	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   580: aconst_null
    //   581: areturn
    //   582: new 146	android/graphics/Paint
    //   585: dup
    //   586: invokespecial 147	android/graphics/Paint:<init>	()V
    //   589: astore_1
    //   590: aload_1
    //   591: new 309	android/graphics/LinearGradient
    //   594: dup
    //   595: fconst_0
    //   596: fconst_0
    //   597: fconst_0
    //   598: ldc_w 310
    //   601: ldc_w 311
    //   604: ldc_w 312
    //   607: getstatic 318	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   610: invokespecial 321	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   613: invokevirtual 325	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   616: pop
    //   617: aload 16
    //   619: fconst_0
    //   620: fconst_0
    //   621: ldc_w 326
    //   624: ldc_w 310
    //   627: aload_1
    //   628: invokevirtual 329	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   631: aload_1
    //   632: aconst_null
    //   633: invokevirtual 325	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   636: pop
    //   637: aload_1
    //   638: ldc_w 330
    //   641: invokevirtual 177	android/graphics/Paint:setColor	(I)V
    //   644: aload 16
    //   646: fconst_0
    //   647: ldc_w 310
    //   650: ldc_w 326
    //   653: ldc_w 310
    //   656: aload_1
    //   657: invokevirtual 333	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   660: aload_1
    //   661: ldc_w 334
    //   664: invokevirtual 177	android/graphics/Paint:setColor	(I)V
    //   667: aload 16
    //   669: fconst_0
    //   670: ldc_w 335
    //   673: ldc_w 326
    //   676: ldc_w 336
    //   679: aload_1
    //   680: invokevirtual 329	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   683: goto -611 -> 72
    //   686: sipush 380
    //   689: istore_3
    //   690: goto -459 -> 231
    //   693: sipush 140
    //   696: istore_3
    //   697: goto -361 -> 336
    //   700: new 149	android/graphics/Rect
    //   703: dup
    //   704: bipush 70
    //   706: bipush 100
    //   708: sipush 470
    //   711: sipush 500
    //   714: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   717: astore 10
    //   719: goto -336 -> 383
    //   722: aload 16
    //   724: aload_1
    //   725: aconst_null
    //   726: aload 10
    //   728: aconst_null
    //   729: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   732: aload_1
    //   733: invokevirtual 339	android/graphics/Bitmap:recycle	()V
    //   736: iload 7
    //   738: iconst_1
    //   739: if_icmpne +137 -> 876
    //   742: new 146	android/graphics/Paint
    //   745: dup
    //   746: invokespecial 147	android/graphics/Paint:<init>	()V
    //   749: astore_1
    //   750: aload_1
    //   751: iconst_1
    //   752: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   755: new 149	android/graphics/Rect
    //   758: dup
    //   759: sipush 217
    //   762: sipush 247
    //   765: sipush 323
    //   768: sipush 353
    //   771: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   774: astore_2
    //   775: aload_0
    //   776: invokevirtual 345	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   779: ldc_w 346
    //   782: invokestatic 352	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   785: astore_0
    //   786: aload 16
    //   788: aload_0
    //   789: aconst_null
    //   790: aload_2
    //   791: aload_1
    //   792: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   795: aload_0
    //   796: invokevirtual 339	android/graphics/Bitmap:recycle	()V
    //   799: new 146	android/graphics/Paint
    //   802: dup
    //   803: invokespecial 147	android/graphics/Paint:<init>	()V
    //   806: astore_0
    //   807: aload_0
    //   808: getstatic 169	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   811: invokevirtual 173	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   814: aload_0
    //   815: iconst_1
    //   816: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   819: aload_0
    //   820: iload 8
    //   822: invokevirtual 177	android/graphics/Paint:setColor	(I)V
    //   825: aload_0
    //   826: ldc_w 353
    //   829: invokevirtual 182	android/graphics/Paint:setTextSize	(F)V
    //   832: aload_0
    //   833: aconst_null
    //   834: invokevirtual 195	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   837: pop
    //   838: aload 16
    //   840: aload 9
    //   842: ldc_w 354
    //   845: ldc_w 355
    //   848: aload_0
    //   849: invokevirtual 233	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   852: aload 15
    //   854: areturn
    //   855: astore_0
    //   856: aload_0
    //   857: invokevirtual 358	java/lang/OutOfMemoryError:printStackTrace	()V
    //   860: aconst_null
    //   861: areturn
    //   862: aload 16
    //   864: aload 6
    //   866: aconst_null
    //   867: aload 10
    //   869: aconst_null
    //   870: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   873: goto -137 -> 736
    //   876: iload 7
    //   878: iconst_2
    //   879: if_icmpne +57 -> 936
    //   882: aload_2
    //   883: ifnull +53 -> 936
    //   886: new 146	android/graphics/Paint
    //   889: dup
    //   890: invokespecial 147	android/graphics/Paint:<init>	()V
    //   893: astore_0
    //   894: aload_0
    //   895: iconst_1
    //   896: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   899: aload 16
    //   901: aload_2
    //   902: aconst_null
    //   903: new 149	android/graphics/Rect
    //   906: dup
    //   907: sipush 217
    //   910: sipush 247
    //   913: sipush 323
    //   916: sipush 353
    //   919: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   922: aload_0
    //   923: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   926: goto -127 -> 799
    //   929: astore_0
    //   930: aload_0
    //   931: invokevirtual 358	java/lang/OutOfMemoryError:printStackTrace	()V
    //   934: aconst_null
    //   935: areturn
    //   936: iload 7
    //   938: iconst_3
    //   939: if_icmpne +63 -> 1002
    //   942: new 146	android/graphics/Paint
    //   945: dup
    //   946: invokespecial 147	android/graphics/Paint:<init>	()V
    //   949: astore_1
    //   950: aload_1
    //   951: iconst_1
    //   952: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   955: new 149	android/graphics/Rect
    //   958: dup
    //   959: sipush 217
    //   962: sipush 247
    //   965: sipush 323
    //   968: sipush 353
    //   971: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   974: astore_2
    //   975: aload_0
    //   976: invokevirtual 345	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   979: ldc_w 346
    //   982: invokestatic 352	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   985: astore_0
    //   986: aload 16
    //   988: aload_0
    //   989: aconst_null
    //   990: aload_2
    //   991: aload_1
    //   992: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   995: aload_0
    //   996: invokevirtual 339	android/graphics/Bitmap:recycle	()V
    //   999: goto -200 -> 799
    //   1002: iload 7
    //   1004: iconst_4
    //   1005: if_icmpne -206 -> 799
    //   1008: new 146	android/graphics/Paint
    //   1011: dup
    //   1012: invokespecial 147	android/graphics/Paint:<init>	()V
    //   1015: astore_1
    //   1016: aload_1
    //   1017: iconst_1
    //   1018: invokevirtual 156	android/graphics/Paint:setAntiAlias	(Z)V
    //   1021: new 149	android/graphics/Rect
    //   1024: dup
    //   1025: sipush 217
    //   1028: sipush 247
    //   1031: sipush 323
    //   1034: sipush 353
    //   1037: invokespecial 152	android/graphics/Rect:<init>	(IIII)V
    //   1040: astore_2
    //   1041: aload_0
    //   1042: invokevirtual 345	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1045: ldc_w 346
    //   1048: invokestatic 352	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1051: astore_0
    //   1052: aload 16
    //   1054: aload_0
    //   1055: aconst_null
    //   1056: aload_2
    //   1057: aload_1
    //   1058: invokevirtual 160	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1061: aload_0
    //   1062: invokevirtual 339	android/graphics/Bitmap:recycle	()V
    //   1065: goto -266 -> 799
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1068	0	paramContext	Context
    //   0	1068	1	paramBitmap1	Bitmap
    //   0	1068	2	paramBitmap2	Bitmap
    //   0	1068	3	paramInt1	int
    //   0	1068	4	paramString1	String
    //   0	1068	5	paramBitmap3	Bitmap
    //   0	1068	6	paramBitmap4	Bitmap
    //   0	1068	7	paramInt2	int
    //   0	1068	8	paramInt3	int
    //   0	1068	9	paramString2	String
    //   0	1068	10	paramRect	Rect
    //   0	1068	11	paramArrayList	java.util.ArrayList
    //   0	1068	12	paramBitmap5	Bitmap
    //   115	213	13	i1	int
    //   249	56	14	i2	int
    //   12	7	15	localBitmap1	Bitmap
    //   541	1	15	localOutOfMemoryError	OutOfMemoryError
    //   558	295	15	localBitmap2	Bitmap
    //   23	1030	16	localCanvas	Canvas
    //   36	309	17	localPaint	Paint
    //   53	13	18	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	541	java/lang/OutOfMemoryError
    //   546	560	563	java/lang/OutOfMemoryError
    //   436	500	855	java/lang/OutOfMemoryError
    //   502	534	855	java/lang/OutOfMemoryError
    //   722	736	855	java/lang/OutOfMemoryError
    //   742	799	929	java/lang/OutOfMemoryError
    //   886	926	929	java/lang/OutOfMemoryError
    //   942	999	929	java/lang/OutOfMemoryError
    //   1008	1065	929	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("nameClr", -16777216);
    localBundle.putInt("tipsClr", -8947849);
    localBundle.putInt("B", -16777216);
    localBundle.putInt("W", 16777215);
    localBundle.putBoolean("head", true);
    Bitmap localBitmap1 = (Bitmap)localBundle.getParcelable("bkg");
    Bitmap localBitmap2 = (Bitmap)localBundle.getParcelable("qrbkg");
    int i4 = localBundle.getInt("B");
    int i5 = localBundle.getInt("W");
    Object localObject = a(paramString2, -1);
    int i6 = ((BitMatrix)localObject).a();
    paramString2 = new int[i6 * i6];
    int i1 = 0;
    while (i1 < i6)
    {
      int i2 = 0;
      if (i2 < i6)
      {
        if (((BitMatrix)localObject).a(i2, i1)) {}
        for (int i3 = i4;; i3 = i5)
        {
          paramString2[(i1 * i6 + i2)] = i3;
          i2 += 1;
          break;
        }
      }
      i1 += 1;
    }
    localObject = Bitmap.createBitmap(i6, i6, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).setPixels(paramString2, 0, i6, 0, 0, i6, i6);
    paramContext = a(paramContext, localBitmap1, paramBitmap, localBundle.getInt("nameClr"), paramString1, localBitmap2, (Bitmap)localObject, localBundle.getInt("head"), localBundle.getInt("tipsClr"), paramContext.getString(2131560512), null, null, null);
    ((Bitmap)localObject).recycle();
    return paramContext;
  }
  
  public static final Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, float paramFloat)
  {
    if ((paramBitmap == null) || (paramInt1 <= 0) || (paramInt2 <= 0)) {}
    do
    {
      return null;
      try
      {
        Bitmap localBitmap1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        if (localBitmap1 != null)
        {
          Canvas localCanvas = new Canvas(localBitmap1);
          Paint localPaint = new Paint();
          Rect localRect = new Rect(0, 0, paramInt1, paramInt2);
          RectF localRectF = new RectF(localRect);
          localPaint.setAntiAlias(true);
          localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, null, localRect, localPaint);
        }
        return localBitmap1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          System.gc();
          try
          {
            Bitmap localBitmap2 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
          }
          catch (OutOfMemoryError paramBitmap) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("QRUtils", 2, paramBitmap.getMessage());
    return null;
  }
  
  public static BitMatrix a(String paramString, int paramInt)
  {
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
    Object localObject = a(paramString);
    if (localObject != null) {
      localEnumMap.put(EncodeHintType.CHARACTER_SET, localObject);
    }
    if (paramInt != -1) {
      localEnumMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(a(paramInt)));
    }
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject = new QRCodeWriter();
    try
    {
      paramString = ((QRCodeWriter)localObject).a(paramString, BarcodeFormat.QR_CODE, 0, 0, localEnumMap);
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
    if (paramString.equals(w)) {
      return x;
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
    //   6: getstatic 513	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 8
    //   11: if_icmplt +122 -> 133
    //   14: aload_0
    //   15: invokevirtual 517	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   18: astore_3
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 520	android/content/Context:getCacheDir	()Ljava/io/File;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull -30 -> 4
    //   37: aload 4
    //   39: invokevirtual 525	java/io/File:canWrite	()Z
    //   42: ifeq -38 -> 4
    //   45: new 213	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 528	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 531	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_3
    //   74: new 522	java/io/File
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 534	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 537	java/io/File:exists	()Z
    //   87: ifeq +8 -> 95
    //   90: aload_0
    //   91: invokevirtual 540	java/io/File:delete	()Z
    //   94: pop
    //   95: new 542	java/io/FileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 545	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: getstatic 551	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload_1
    //   113: invokevirtual 555	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   116: pop
    //   117: aload_1
    //   118: astore_0
    //   119: aload_1
    //   120: invokevirtual 558	java/io/FileOutputStream:flush	()V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 561	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: new 522	java/io/File
    //   136: dup
    //   137: invokestatic 566	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   140: new 213	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 568
    //   150: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 571	android/content/Context:getPackageName	()Ljava/lang/String;
    //   157: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 573
    //   163: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 576	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 579	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: goto -159 -> 19
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   186: goto -55 -> 131
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_2
    //   195: invokevirtual 581	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload_1
    //   199: ifnull -195 -> 4
    //   202: aload_1
    //   203: invokevirtual 561	java/io/FileOutputStream:close	()V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: astore_0
    //   220: aload_2
    //   221: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   224: aload_1
    //   225: ifnull -221 -> 4
    //   228: aload_1
    //   229: invokevirtual 561	java/io/FileOutputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 561	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 580	java/io/IOException:printStackTrace	()V
    //   259: goto -7 -> 252
    //   262: astore_1
    //   263: goto -19 -> 244
    //   266: astore_2
    //   267: goto -49 -> 218
    //   270: astore_2
    //   271: goto -79 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	274	0	paramContext	Context
    //   0	274	1	paramString	String
    //   0	274	2	paramBitmap	Bitmap
    //   18	156	3	localObject1	Object
    //   20	33	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   127	131	181	java/io/IOException
    //   95	104	189	java/io/FileNotFoundException
    //   202	206	208	java/io/IOException
    //   95	104	215	java/io/IOException
    //   228	232	234	java/io/IOException
    //   95	104	241	finally
    //   248	252	254	java/io/IOException
    //   106	117	262	finally
    //   119	123	262	finally
    //   194	198	262	finally
    //   220	224	262	finally
    //   106	117	266	java/io/IOException
    //   119	123	266	java/io/IOException
    //   106	117	270	java/io/FileNotFoundException
    //   119	123	270	java/io/FileNotFoundException
  }
  
  protected static String a(CharSequence paramCharSequence)
  {
    int i1 = 0;
    while (i1 < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(i1) > 'ÿ') {
        return "UTF-8";
      }
      i1 += 1;
    }
    return null;
  }
  
  public static short a(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    Context localContext = BaseApplication.getContext();
    QQToast.a(localContext, paramInt1, paramInt2, 1).b(localContext.getResources().getDimensionPixelSize(2131427376));
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt, String paramString2, String paramString3, QRCodeEncodeCallback paramQRCodeEncodeCallback)
  {
    paramString1 = QRActionEntity.a(paramInt, paramString1).a();
    paramString2 = new btj(paramQRCodeEncodeCallback);
    paramContext = new NewIntent(paramContext, QRCodeServlet.class);
    paramContext.putExtra("skey", paramString3);
    paramContext.putExtra("d", paramString1);
    paramContext.putExtra("cmd", "QRCodeSvc.encode");
    paramContext.setObserver(paramString2);
    paramQQAppInterface.startServlet(paramContext);
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(t, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(B, paramString)) && (!Pattern.matches(C, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(C, paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(u, paramString);
  }
  
  public static boolean e(String paramString)
  {
    return (d(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean f(String paramString)
  {
    return Pattern.matches(v, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils
 * JD-Core Version:    0.7.0.1
 */