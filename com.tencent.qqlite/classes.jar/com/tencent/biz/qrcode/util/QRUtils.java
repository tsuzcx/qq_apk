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
import qz;

public class QRUtils
{
  private static String A = "^https?://url\\.cn/.+#flyticket";
  public static final int a = 540;
  protected static final String a = "QRUtils";
  public static final int b = 740;
  public static final String b = "";
  public static final int c = 600;
  public static final String c = "addfriend_QR";
  public static final String d = "find_QR";
  public static final String e = "bigpicture_QR";
  public static final String f = "bulb_QR";
  public static final String g = "saveConsumerQRcard";
  public static final String h = "saveGroupQRcard";
  public static final String i = "ConsumerQRcard";
  public static final String j = "GroupQRcard";
  public static final String k = "PublicAccountQRcard";
  public static final String l = "ThirdpartyQRcard";
  public static final String m = "TPQRcardurl";
  public static final String n = "TPQRcardtext";
  public static final String o = "TPQRcardphone";
  public static final String p = "changeConsumerQRcard";
  public static final String q = "changeGroupQRcard";
  protected static String r = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  protected static String s = "^((?:(?i)https?://|www\\.)[a-zA-Z0-9\\-.]+(?::(\\d+))?(?:(?:/[a-zA-Z0-9\\-._?,'+\\\\&%$=~*!;#():@\\\\]*)+)?)$";
  protected static String t = ".*(\\+86|086)?\\d{5,12}.*";
  public static String u = "qm.qq.com";
  protected static String v = "183.61.32.185";
  protected static String w = "58.250.135.158";
  protected static String x = "120.198.189.104";
  protected static String y = "182.254.1.144";
  private static String z = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  
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
    //   6: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 133	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: new 135	android/graphics/Canvas
    //   17: dup
    //   18: aload 15
    //   20: invokespecial 138	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   23: astore 16
    //   25: aload_1
    //   26: ifnull +552 -> 578
    //   29: new 140	android/graphics/Paint
    //   32: dup
    //   33: invokespecial 141	android/graphics/Paint:<init>	()V
    //   36: astore 17
    //   38: new 143	android/graphics/Rect
    //   41: dup
    //   42: iconst_0
    //   43: iconst_0
    //   44: sipush 540
    //   47: sipush 740
    //   50: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   53: astore 18
    //   55: aload 17
    //   57: iconst_1
    //   58: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   61: aload 16
    //   63: aload_1
    //   64: aconst_null
    //   65: aload 18
    //   67: aload 17
    //   69: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   72: aload_2
    //   73: ifnull +41 -> 114
    //   76: new 140	android/graphics/Paint
    //   79: dup
    //   80: invokespecial 141	android/graphics/Paint:<init>	()V
    //   83: astore_1
    //   84: aload_1
    //   85: iconst_1
    //   86: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   89: aload 16
    //   91: aload_2
    //   92: aconst_null
    //   93: new 143	android/graphics/Rect
    //   96: dup
    //   97: bipush 20
    //   99: sipush 621
    //   102: bipush 120
    //   104: sipush 721
    //   107: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   110: aload_1
    //   111: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: iconst_0
    //   115: istore 13
    //   117: aload 12
    //   119: ifnull +52 -> 171
    //   122: iconst_1
    //   123: istore 13
    //   125: new 140	android/graphics/Paint
    //   128: dup
    //   129: invokespecial 141	android/graphics/Paint:<init>	()V
    //   132: astore_1
    //   133: aload_1
    //   134: iconst_1
    //   135: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   138: aload_1
    //   139: iconst_1
    //   140: invokevirtual 157	android/graphics/Paint:setFilterBitmap	(Z)V
    //   143: aload 16
    //   145: aload 12
    //   147: aconst_null
    //   148: new 143	android/graphics/Rect
    //   151: dup
    //   152: sipush 140
    //   155: sipush 633
    //   158: sipush 176
    //   161: sipush 669
    //   164: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   167: aload_1
    //   168: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   171: new 140	android/graphics/Paint
    //   174: dup
    //   175: invokespecial 141	android/graphics/Paint:<init>	()V
    //   178: astore 17
    //   180: aload 17
    //   182: getstatic 163	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   185: invokevirtual 167	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   188: aload 17
    //   190: iconst_1
    //   191: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   194: aload 17
    //   196: iload_3
    //   197: invokevirtual 171	android/graphics/Paint:setColor	(I)V
    //   200: aload 17
    //   202: ldc 172
    //   204: invokevirtual 176	android/graphics/Paint:setTextSize	(F)V
    //   207: aload 17
    //   209: iconst_1
    //   210: invokevirtual 179	android/graphics/Paint:setFlags	(I)V
    //   213: aload 17
    //   215: getstatic 185	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   218: invokevirtual 189	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   221: pop
    //   222: iload 13
    //   224: ifeq +458 -> 682
    //   227: sipush 342
    //   230: istore_3
    //   231: aload 4
    //   233: ifnull +112 -> 345
    //   236: iconst_2
    //   237: aload 4
    //   239: invokevirtual 195	java/lang/String:length	()I
    //   242: invokestatic 201	java/lang/Math:max	(II)I
    //   245: istore 14
    //   247: aload 4
    //   249: astore 12
    //   251: aload 17
    //   253: aload 4
    //   255: invokevirtual 205	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   258: iload_3
    //   259: i2f
    //   260: fcmpl
    //   261: ifle +62 -> 323
    //   264: iload 14
    //   266: iconst_2
    //   267: isub
    //   268: istore 14
    //   270: new 207	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   277: aload 4
    //   279: iconst_0
    //   280: iload 14
    //   282: invokevirtual 212	java/lang/String:substring	(II)Ljava/lang/String;
    //   285: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc 218
    //   290: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: astore_1
    //   297: aload_1
    //   298: astore 12
    //   300: iload 14
    //   302: ifle +21 -> 323
    //   305: aload_1
    //   306: astore 4
    //   308: aload 17
    //   310: aload_1
    //   311: invokevirtual 205	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   314: iload_3
    //   315: i2f
    //   316: fcmpl
    //   317: ifgt -53 -> 264
    //   320: aload_1
    //   321: astore 12
    //   323: iload 13
    //   325: ifeq +364 -> 689
    //   328: sipush 182
    //   331: istore_3
    //   332: aload 16
    //   334: aload 12
    //   336: iload_3
    //   337: i2f
    //   338: ldc 223
    //   340: aload 17
    //   342: invokevirtual 227	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   345: aload 5
    //   347: ifnull +27 -> 374
    //   350: aload 16
    //   352: aload 5
    //   354: aconst_null
    //   355: new 143	android/graphics/Rect
    //   358: dup
    //   359: iconst_0
    //   360: iconst_0
    //   361: sipush 540
    //   364: sipush 600
    //   367: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   370: aconst_null
    //   371: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   374: aload 10
    //   376: ifnull +320 -> 696
    //   379: aload 11
    //   381: ifnull +477 -> 858
    //   384: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +45 -> 432
    //   390: ldc 11
    //   392: iconst_2
    //   393: new 207	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   400: ldc 235
    //   402: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 6
    //   407: invokevirtual 238	android/graphics/Bitmap:getWidth	()I
    //   410: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc 243
    //   415: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 6
    //   420: invokevirtual 246	android/graphics/Bitmap:getHeight	()I
    //   423: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   426: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 249	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload 6
    //   434: aload 10
    //   436: invokevirtual 252	android/graphics/Rect:width	()I
    //   439: aload 10
    //   441: invokevirtual 255	android/graphics/Rect:height	()I
    //   444: iconst_0
    //   445: invokestatic 259	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   448: astore_1
    //   449: new 135	android/graphics/Canvas
    //   452: dup
    //   453: aload_1
    //   454: invokespecial 138	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   457: astore 4
    //   459: new 140	android/graphics/Paint
    //   462: dup
    //   463: invokespecial 141	android/graphics/Paint:<init>	()V
    //   466: astore 5
    //   468: aload 5
    //   470: iconst_0
    //   471: invokevirtual 262	android/graphics/Paint:setAlpha	(I)V
    //   474: aload 5
    //   476: iconst_1
    //   477: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   480: aload 5
    //   482: new 264	android/graphics/PorterDuffXfermode
    //   485: dup
    //   486: getstatic 270	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   489: invokespecial 273	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   492: invokevirtual 277	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   495: pop
    //   496: iconst_0
    //   497: istore_3
    //   498: iload_3
    //   499: aload 11
    //   501: invokevirtual 282	java/util/ArrayList:size	()I
    //   504: if_icmpge +214 -> 718
    //   507: aload 4
    //   509: new 143	android/graphics/Rect
    //   512: dup
    //   513: aload 11
    //   515: iload_3
    //   516: invokevirtual 286	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   519: checkcast 143	android/graphics/Rect
    //   522: invokespecial 289	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   525: aload 5
    //   527: invokevirtual 293	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   530: iload_3
    //   531: iconst_1
    //   532: iadd
    //   533: istore_3
    //   534: goto -36 -> 498
    //   537: astore 15
    //   539: invokestatic 298	java/lang/System:gc	()V
    //   542: sipush 540
    //   545: sipush 740
    //   548: getstatic 127	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   551: invokestatic 133	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   554: astore 15
    //   556: goto -542 -> 14
    //   559: astore_0
    //   560: invokestatic 233	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   563: ifeq +13 -> 576
    //   566: ldc 11
    //   568: iconst_2
    //   569: aload_0
    //   570: invokevirtual 301	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   573: invokestatic 249	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: aconst_null
    //   577: areturn
    //   578: new 140	android/graphics/Paint
    //   581: dup
    //   582: invokespecial 141	android/graphics/Paint:<init>	()V
    //   585: astore_1
    //   586: aload_1
    //   587: new 303	android/graphics/LinearGradient
    //   590: dup
    //   591: fconst_0
    //   592: fconst_0
    //   593: fconst_0
    //   594: ldc_w 304
    //   597: ldc_w 305
    //   600: ldc_w 306
    //   603: getstatic 312	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   606: invokespecial 315	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   609: invokevirtual 319	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   612: pop
    //   613: aload 16
    //   615: fconst_0
    //   616: fconst_0
    //   617: ldc_w 320
    //   620: ldc_w 304
    //   623: aload_1
    //   624: invokevirtual 323	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   627: aload_1
    //   628: aconst_null
    //   629: invokevirtual 319	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   632: pop
    //   633: aload_1
    //   634: ldc_w 324
    //   637: invokevirtual 171	android/graphics/Paint:setColor	(I)V
    //   640: aload 16
    //   642: fconst_0
    //   643: ldc_w 304
    //   646: ldc_w 320
    //   649: ldc_w 304
    //   652: aload_1
    //   653: invokevirtual 327	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   656: aload_1
    //   657: ldc_w 328
    //   660: invokevirtual 171	android/graphics/Paint:setColor	(I)V
    //   663: aload 16
    //   665: fconst_0
    //   666: ldc_w 329
    //   669: ldc_w 320
    //   672: ldc_w 330
    //   675: aload_1
    //   676: invokevirtual 323	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   679: goto -607 -> 72
    //   682: sipush 380
    //   685: istore_3
    //   686: goto -455 -> 231
    //   689: sipush 140
    //   692: istore_3
    //   693: goto -361 -> 332
    //   696: new 143	android/graphics/Rect
    //   699: dup
    //   700: bipush 70
    //   702: bipush 100
    //   704: sipush 470
    //   707: sipush 500
    //   710: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   713: astore 10
    //   715: goto -336 -> 379
    //   718: aload 16
    //   720: aload_1
    //   721: aconst_null
    //   722: aload 10
    //   724: aconst_null
    //   725: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   728: aload_1
    //   729: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   732: iload 7
    //   734: iconst_1
    //   735: if_icmpne +137 -> 872
    //   738: new 140	android/graphics/Paint
    //   741: dup
    //   742: invokespecial 141	android/graphics/Paint:<init>	()V
    //   745: astore_1
    //   746: aload_1
    //   747: iconst_1
    //   748: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   751: new 143	android/graphics/Rect
    //   754: dup
    //   755: sipush 217
    //   758: sipush 247
    //   761: sipush 323
    //   764: sipush 353
    //   767: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   770: astore_2
    //   771: aload_0
    //   772: invokevirtual 339	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   775: ldc_w 340
    //   778: invokestatic 346	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   781: astore_0
    //   782: aload 16
    //   784: aload_0
    //   785: aconst_null
    //   786: aload_2
    //   787: aload_1
    //   788: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   791: aload_0
    //   792: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   795: new 140	android/graphics/Paint
    //   798: dup
    //   799: invokespecial 141	android/graphics/Paint:<init>	()V
    //   802: astore_0
    //   803: aload_0
    //   804: getstatic 163	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   807: invokevirtual 167	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   810: aload_0
    //   811: iconst_1
    //   812: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   815: aload_0
    //   816: iload 8
    //   818: invokevirtual 171	android/graphics/Paint:setColor	(I)V
    //   821: aload_0
    //   822: ldc_w 347
    //   825: invokevirtual 176	android/graphics/Paint:setTextSize	(F)V
    //   828: aload_0
    //   829: aconst_null
    //   830: invokevirtual 189	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   833: pop
    //   834: aload 16
    //   836: aload 9
    //   838: ldc_w 348
    //   841: ldc_w 349
    //   844: aload_0
    //   845: invokevirtual 227	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   848: aload 15
    //   850: areturn
    //   851: astore_0
    //   852: aload_0
    //   853: invokevirtual 352	java/lang/OutOfMemoryError:printStackTrace	()V
    //   856: aconst_null
    //   857: areturn
    //   858: aload 16
    //   860: aload 6
    //   862: aconst_null
    //   863: aload 10
    //   865: aconst_null
    //   866: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   869: goto -137 -> 732
    //   872: iload 7
    //   874: iconst_2
    //   875: if_icmpne +57 -> 932
    //   878: aload_2
    //   879: ifnull +53 -> 932
    //   882: new 140	android/graphics/Paint
    //   885: dup
    //   886: invokespecial 141	android/graphics/Paint:<init>	()V
    //   889: astore_0
    //   890: aload_0
    //   891: iconst_1
    //   892: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   895: aload 16
    //   897: aload_2
    //   898: aconst_null
    //   899: new 143	android/graphics/Rect
    //   902: dup
    //   903: sipush 217
    //   906: sipush 247
    //   909: sipush 323
    //   912: sipush 353
    //   915: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   918: aload_0
    //   919: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   922: goto -127 -> 795
    //   925: astore_0
    //   926: aload_0
    //   927: invokevirtual 352	java/lang/OutOfMemoryError:printStackTrace	()V
    //   930: aconst_null
    //   931: areturn
    //   932: iload 7
    //   934: iconst_3
    //   935: if_icmpne +63 -> 998
    //   938: new 140	android/graphics/Paint
    //   941: dup
    //   942: invokespecial 141	android/graphics/Paint:<init>	()V
    //   945: astore_1
    //   946: aload_1
    //   947: iconst_1
    //   948: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   951: new 143	android/graphics/Rect
    //   954: dup
    //   955: sipush 217
    //   958: sipush 247
    //   961: sipush 323
    //   964: sipush 353
    //   967: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   970: astore_2
    //   971: aload_0
    //   972: invokevirtual 339	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   975: ldc_w 340
    //   978: invokestatic 346	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   981: astore_0
    //   982: aload 16
    //   984: aload_0
    //   985: aconst_null
    //   986: aload_2
    //   987: aload_1
    //   988: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   991: aload_0
    //   992: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   995: goto -200 -> 795
    //   998: iload 7
    //   1000: iconst_4
    //   1001: if_icmpne -206 -> 795
    //   1004: new 140	android/graphics/Paint
    //   1007: dup
    //   1008: invokespecial 141	android/graphics/Paint:<init>	()V
    //   1011: astore_1
    //   1012: aload_1
    //   1013: iconst_1
    //   1014: invokevirtual 150	android/graphics/Paint:setAntiAlias	(Z)V
    //   1017: new 143	android/graphics/Rect
    //   1020: dup
    //   1021: sipush 217
    //   1024: sipush 247
    //   1027: sipush 323
    //   1030: sipush 353
    //   1033: invokespecial 146	android/graphics/Rect:<init>	(IIII)V
    //   1036: astore_2
    //   1037: aload_0
    //   1038: invokevirtual 339	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1041: ldc_w 340
    //   1044: invokestatic 346	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1047: astore_0
    //   1048: aload 16
    //   1050: aload_0
    //   1051: aconst_null
    //   1052: aload_2
    //   1053: aload_1
    //   1054: invokevirtual 154	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1057: aload_0
    //   1058: invokevirtual 333	android/graphics/Bitmap:recycle	()V
    //   1061: goto -266 -> 795
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1064	0	paramContext	Context
    //   0	1064	1	paramBitmap1	Bitmap
    //   0	1064	2	paramBitmap2	Bitmap
    //   0	1064	3	paramInt1	int
    //   0	1064	4	paramString1	String
    //   0	1064	5	paramBitmap3	Bitmap
    //   0	1064	6	paramBitmap4	Bitmap
    //   0	1064	7	paramInt2	int
    //   0	1064	8	paramInt3	int
    //   0	1064	9	paramString2	String
    //   0	1064	10	paramRect	Rect
    //   0	1064	11	paramArrayList	java.util.ArrayList
    //   0	1064	12	paramBitmap5	Bitmap
    //   115	209	13	i1	int
    //   245	56	14	i2	int
    //   12	7	15	localBitmap1	Bitmap
    //   537	1	15	localOutOfMemoryError	OutOfMemoryError
    //   554	295	15	localBitmap2	Bitmap
    //   23	1026	16	localCanvas	Canvas
    //   36	305	17	localPaint	Paint
    //   53	13	18	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	537	java/lang/OutOfMemoryError
    //   542	556	559	java/lang/OutOfMemoryError
    //   432	496	851	java/lang/OutOfMemoryError
    //   498	530	851	java/lang/OutOfMemoryError
    //   718	732	851	java/lang/OutOfMemoryError
    //   738	795	925	java/lang/OutOfMemoryError
    //   882	922	925	java/lang/OutOfMemoryError
    //   938	995	925	java/lang/OutOfMemoryError
    //   1004	1061	925	java/lang/OutOfMemoryError
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
    paramContext = a(paramContext, localBitmap1, paramBitmap, localBundle.getInt("nameClr"), paramString1, localBitmap2, (Bitmap)localObject, localBundle.getInt("head"), localBundle.getInt("tipsClr"), paramContext.getString(2131362424), null, null, null);
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
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
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
      paramString = ((QRCodeWriter)localObject).a(paramString, 0, 0, localEnumMap);
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
    if (paramString.equals(u)) {
      return v;
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
    //   6: getstatic 502	android/os/Build$VERSION:SDK_INT	I
    //   9: bipush 8
    //   11: if_icmplt +122 -> 133
    //   14: aload_0
    //   15: invokevirtual 506	android/content/Context:getExternalCacheDir	()Ljava/io/File;
    //   18: astore_3
    //   19: aload_3
    //   20: astore 4
    //   22: aload_3
    //   23: ifnonnull +9 -> 32
    //   26: aload_0
    //   27: invokevirtual 509	android/content/Context:getCacheDir	()Ljava/io/File;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull -30 -> 4
    //   37: aload 4
    //   39: invokevirtual 514	java/io/File:canWrite	()Z
    //   42: ifeq -38 -> 4
    //   45: new 207	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   52: aload 4
    //   54: invokevirtual 517	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: getstatic 520	java/io/File:separator	Ljava/lang/String;
    //   63: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: astore_3
    //   74: new 511	java/io/File
    //   77: dup
    //   78: aload_3
    //   79: invokespecial 523	java/io/File:<init>	(Ljava/lang/String;)V
    //   82: astore_0
    //   83: aload_0
    //   84: invokevirtual 526	java/io/File:exists	()Z
    //   87: ifeq +8 -> 95
    //   90: aload_0
    //   91: invokevirtual 529	java/io/File:delete	()Z
    //   94: pop
    //   95: new 531	java/io/FileOutputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 534	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   103: astore_1
    //   104: aload_1
    //   105: astore_0
    //   106: aload_2
    //   107: getstatic 540	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload_1
    //   113: invokevirtual 544	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   116: pop
    //   117: aload_1
    //   118: astore_0
    //   119: aload_1
    //   120: invokevirtual 547	java/io/FileOutputStream:flush	()V
    //   123: aload_1
    //   124: ifnull +7 -> 131
    //   127: aload_1
    //   128: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   131: aload_3
    //   132: areturn
    //   133: new 511	java/io/File
    //   136: dup
    //   137: invokestatic 555	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   140: new 207	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 208	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 557
    //   150: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: aload_0
    //   154: invokevirtual 560	android/content/Context:getPackageName	()Ljava/lang/String;
    //   157: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 562
    //   163: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokespecial 565	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   172: astore_3
    //   173: aload_3
    //   174: invokevirtual 568	java/io/File:mkdirs	()Z
    //   177: pop
    //   178: goto -159 -> 19
    //   181: astore_0
    //   182: aload_0
    //   183: invokevirtual 569	java/io/IOException:printStackTrace	()V
    //   186: goto -55 -> 131
    //   189: astore_2
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore_0
    //   194: aload_2
    //   195: invokevirtual 570	java/io/FileNotFoundException:printStackTrace	()V
    //   198: aload_1
    //   199: ifnull -195 -> 4
    //   202: aload_1
    //   203: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 569	java/io/IOException:printStackTrace	()V
    //   213: aconst_null
    //   214: areturn
    //   215: astore_2
    //   216: aconst_null
    //   217: astore_1
    //   218: aload_1
    //   219: astore_0
    //   220: aload_2
    //   221: invokevirtual 569	java/io/IOException:printStackTrace	()V
    //   224: aload_1
    //   225: ifnull -221 -> 4
    //   228: aload_1
    //   229: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   232: aconst_null
    //   233: areturn
    //   234: astore_0
    //   235: aload_0
    //   236: invokevirtual 569	java/io/IOException:printStackTrace	()V
    //   239: aconst_null
    //   240: areturn
    //   241: astore_1
    //   242: aconst_null
    //   243: astore_0
    //   244: aload_0
    //   245: ifnull +7 -> 252
    //   248: aload_0
    //   249: invokevirtual 550	java/io/FileOutputStream:close	()V
    //   252: aload_1
    //   253: athrow
    //   254: astore_0
    //   255: aload_0
    //   256: invokevirtual 569	java/io/IOException:printStackTrace	()V
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
    QQToast.a(localContext, paramInt1, paramInt2, 1).b(localContext.getResources().getDimensionPixelSize(2131492887));
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
    paramString2 = new qz(paramQRCodeEncodeCallback);
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
    return Pattern.matches(r, paramString);
  }
  
  public static byte[] a(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(z, paramString)) && (!Pattern.matches(A, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean c(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(A, paramString);
  }
  
  public static boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(s, paramString);
  }
  
  public static boolean e(String paramString)
  {
    return (d(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean f(String paramString)
  {
    return Pattern.matches(t, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils
 * JD-Core Version:    0.7.0.1
 */