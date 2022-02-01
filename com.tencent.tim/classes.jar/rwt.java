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
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.biz.qrcode.util.QRUtils.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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

public class rwt
{
  protected static String aCR = "^https?://qm\\.qq\\.com/cgi-bin/qm/qr\\?.+";
  private static String aCS = "^https?://qm\\.qq\\.com/cgi-bin/dc/ft\\?.+";
  private static String aCT = "^https?://url\\.cn/.+#flyticket";
  protected static String aCU = ".*(\\+86|086)?\\d{5,12}.*";
  public static String aCV = "qm.qq.com";
  protected static String aCW = "183.61.32.185";
  protected static String aCX = "58.250.135.158";
  protected static String aCY = "120.198.189.104";
  protected static String aCZ = "182.254.1.144";
  
  public static boolean Mc()
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
  
  public static aeng.a a(QQAppInterface paramQQAppInterface, aeng paramaeng, int paramInt)
  {
    if ((paramaeng == null) || (paramaeng.yX == null) || (paramaeng.yX.size() <= 0)) {
      return null;
    }
    int j = 0;
    for (int i = (int)(Math.random() * paramaeng.yX.size()); (paramInt != -1) && (i == paramInt) && (j < 50); i = (int)(Math.random() * paramaeng.yX.size())) {
      j += 1;
    }
    return (aeng.a)paramaeng.yX.get(i);
  }
  
  /* Error */
  public static final Bitmap a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt1, String paramString1, Bitmap paramBitmap3, Bitmap paramBitmap4, int paramInt2, int paramInt3, String paramString2, Rect paramRect, ArrayList<Rect> paramArrayList, int paramInt4)
  {
    // Byte code:
    //   0: sipush 540
    //   3: sipush 740
    //   6: getstatic 155	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   9: invokestatic 161	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   12: astore 15
    //   14: iload 12
    //   16: ifeq +1245 -> 1261
    //   19: aload_0
    //   20: invokevirtual 167	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   23: iload 12
    //   25: invokestatic 173	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   28: astore 14
    //   30: aload 15
    //   32: ifnonnull +24 -> 56
    //   35: aconst_null
    //   36: areturn
    //   37: astore_0
    //   38: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   41: ifeq +13 -> 54
    //   44: ldc 93
    //   46: iconst_2
    //   47: aload_0
    //   48: invokevirtual 176	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   51: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aconst_null
    //   55: areturn
    //   56: new 181	android/graphics/Canvas
    //   59: dup
    //   60: aload 15
    //   62: invokespecial 184	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   65: astore 16
    //   67: aload_1
    //   68: ifnull +670 -> 738
    //   71: new 186	android/graphics/Paint
    //   74: dup
    //   75: invokespecial 187	android/graphics/Paint:<init>	()V
    //   78: astore 17
    //   80: new 189	android/graphics/Rect
    //   83: dup
    //   84: iconst_0
    //   85: iconst_0
    //   86: sipush 540
    //   89: sipush 740
    //   92: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   95: astore 18
    //   97: aload 17
    //   99: iconst_1
    //   100: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   103: aload 16
    //   105: aload_1
    //   106: aconst_null
    //   107: aload 18
    //   109: aload 17
    //   111: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   114: aload_2
    //   115: ifnull +41 -> 156
    //   118: new 186	android/graphics/Paint
    //   121: dup
    //   122: invokespecial 187	android/graphics/Paint:<init>	()V
    //   125: astore_1
    //   126: aload_1
    //   127: iconst_1
    //   128: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   131: aload 16
    //   133: aload_2
    //   134: aconst_null
    //   135: new 189	android/graphics/Rect
    //   138: dup
    //   139: bipush 20
    //   141: sipush 621
    //   144: bipush 120
    //   146: sipush 721
    //   149: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   152: aload_1
    //   153: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   156: iconst_0
    //   157: istore 12
    //   159: aload 14
    //   161: ifnull +52 -> 213
    //   164: iconst_1
    //   165: istore 12
    //   167: new 186	android/graphics/Paint
    //   170: dup
    //   171: invokespecial 187	android/graphics/Paint:<init>	()V
    //   174: astore_1
    //   175: aload_1
    //   176: iconst_1
    //   177: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   180: aload_1
    //   181: iconst_1
    //   182: invokevirtual 203	android/graphics/Paint:setFilterBitmap	(Z)V
    //   185: aload 16
    //   187: aload 14
    //   189: aconst_null
    //   190: new 189	android/graphics/Rect
    //   193: dup
    //   194: sipush 140
    //   197: sipush 633
    //   200: sipush 176
    //   203: sipush 669
    //   206: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   209: aload_1
    //   210: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   213: new 186	android/graphics/Paint
    //   216: dup
    //   217: invokespecial 187	android/graphics/Paint:<init>	()V
    //   220: astore 17
    //   222: aload 17
    //   224: getstatic 209	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   227: invokevirtual 213	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   230: aload 17
    //   232: iconst_1
    //   233: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   236: aload 17
    //   238: iload_3
    //   239: invokevirtual 217	android/graphics/Paint:setColor	(I)V
    //   242: aload 17
    //   244: ldc 218
    //   246: invokevirtual 222	android/graphics/Paint:setTextSize	(F)V
    //   249: aload 17
    //   251: iconst_1
    //   252: invokevirtual 225	android/graphics/Paint:setFlags	(I)V
    //   255: aload 17
    //   257: getstatic 231	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   260: invokevirtual 235	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   263: pop
    //   264: iload 12
    //   266: ifeq +576 -> 842
    //   269: sipush 342
    //   272: istore_3
    //   273: aload 4
    //   275: ifnull +112 -> 387
    //   278: iconst_2
    //   279: aload 4
    //   281: invokevirtual 238	java/lang/String:length	()I
    //   284: invokestatic 242	java/lang/Math:max	(II)I
    //   287: istore 13
    //   289: aload 4
    //   291: astore 14
    //   293: aload 17
    //   295: aload 4
    //   297: invokevirtual 246	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   300: iload_3
    //   301: i2f
    //   302: fcmpl
    //   303: ifle +62 -> 365
    //   306: iload 13
    //   308: iconst_2
    //   309: isub
    //   310: istore 13
    //   312: new 95	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   319: aload 4
    //   321: iconst_0
    //   322: iload 13
    //   324: invokevirtual 250	java/lang/String:substring	(II)Ljava/lang/String;
    //   327: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: ldc 252
    //   332: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: astore_1
    //   339: aload_1
    //   340: astore 14
    //   342: iload 13
    //   344: ifle +21 -> 365
    //   347: aload_1
    //   348: astore 4
    //   350: aload 17
    //   352: aload_1
    //   353: invokevirtual 246	android/graphics/Paint:measureText	(Ljava/lang/String;)F
    //   356: iload_3
    //   357: i2f
    //   358: fcmpl
    //   359: ifgt -53 -> 306
    //   362: aload_1
    //   363: astore 14
    //   365: iload 12
    //   367: ifeq +482 -> 849
    //   370: sipush 182
    //   373: istore_3
    //   374: aload 16
    //   376: aload 14
    //   378: iload_3
    //   379: i2f
    //   380: ldc 253
    //   382: aload 17
    //   384: invokevirtual 257	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   387: aload 5
    //   389: ifnull +27 -> 416
    //   392: aload 16
    //   394: aload 5
    //   396: aconst_null
    //   397: new 189	android/graphics/Rect
    //   400: dup
    //   401: iconst_0
    //   402: iconst_0
    //   403: sipush 540
    //   406: sipush 600
    //   409: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   412: aconst_null
    //   413: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   416: aload 10
    //   418: ifnull +438 -> 856
    //   421: aload 6
    //   423: astore_1
    //   424: invokestatic 259	rwt:Mc	()Z
    //   427: ifeq +150 -> 577
    //   430: aload 6
    //   432: astore_1
    //   433: aload 10
    //   435: invokevirtual 262	android/graphics/Rect:width	()I
    //   438: sipush 350
    //   441: if_icmple +136 -> 577
    //   444: aload 6
    //   446: astore_1
    //   447: aload 10
    //   449: invokevirtual 265	android/graphics/Rect:height	()I
    //   452: sipush 350
    //   455: if_icmple +122 -> 577
    //   458: aload 6
    //   460: astore_1
    //   461: aload 6
    //   463: ifnull +114 -> 577
    //   466: aload 6
    //   468: aload 10
    //   470: invokevirtual 262	android/graphics/Rect:width	()I
    //   473: iconst_2
    //   474: idiv
    //   475: aload 10
    //   477: invokevirtual 265	android/graphics/Rect:height	()I
    //   480: iconst_2
    //   481: idiv
    //   482: iconst_0
    //   483: invokestatic 269	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   486: astore 4
    //   488: aload 6
    //   490: astore_1
    //   491: aload 4
    //   493: ifnull +84 -> 577
    //   496: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +75 -> 574
    //   502: ldc 93
    //   504: iconst_2
    //   505: new 95	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 271
    //   515: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 4
    //   520: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   523: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   526: ldc_w 279
    //   529: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload 4
    //   534: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   537: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   540: ldc_w 284
    //   543: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: aload 6
    //   548: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   551: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: ldc_w 286
    //   557: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: aload 6
    //   562: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   565: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: aload 4
    //   576: astore_1
    //   577: aload 11
    //   579: ifnull +477 -> 1056
    //   582: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   585: ifeq +49 -> 634
    //   588: aload_1
    //   589: ifnull +45 -> 634
    //   592: ldc 93
    //   594: iconst_2
    //   595: new 95	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 288
    //   605: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload_1
    //   609: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   612: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   615: ldc_w 279
    //   618: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: aload_1
    //   622: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   625: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   631: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   634: aload_1
    //   635: aload 10
    //   637: invokevirtual 262	android/graphics/Rect:width	()I
    //   640: aload 10
    //   642: invokevirtual 265	android/graphics/Rect:height	()I
    //   645: iconst_0
    //   646: invokestatic 269	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   649: astore_1
    //   650: new 181	android/graphics/Canvas
    //   653: dup
    //   654: aload_1
    //   655: invokespecial 184	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   658: astore 4
    //   660: new 186	android/graphics/Paint
    //   663: dup
    //   664: invokespecial 187	android/graphics/Paint:<init>	()V
    //   667: astore 5
    //   669: aload 5
    //   671: iconst_0
    //   672: invokevirtual 291	android/graphics/Paint:setAlpha	(I)V
    //   675: aload 5
    //   677: iconst_1
    //   678: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   681: aload 5
    //   683: new 293	android/graphics/PorterDuffXfermode
    //   686: dup
    //   687: getstatic 299	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   690: invokespecial 302	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   693: invokevirtual 306	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   696: pop
    //   697: iconst_0
    //   698: istore_3
    //   699: iload_3
    //   700: aload 11
    //   702: invokevirtual 309	java/util/ArrayList:size	()I
    //   705: if_icmpge +209 -> 914
    //   708: aload 4
    //   710: new 189	android/graphics/Rect
    //   713: dup
    //   714: aload 11
    //   716: iload_3
    //   717: invokevirtual 310	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   720: checkcast 189	android/graphics/Rect
    //   723: invokespecial 313	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   726: aload 5
    //   728: invokevirtual 317	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   731: iload_3
    //   732: iconst_1
    //   733: iadd
    //   734: istore_3
    //   735: goto -36 -> 699
    //   738: new 186	android/graphics/Paint
    //   741: dup
    //   742: invokespecial 187	android/graphics/Paint:<init>	()V
    //   745: astore_1
    //   746: aload_1
    //   747: new 319	android/graphics/LinearGradient
    //   750: dup
    //   751: fconst_0
    //   752: fconst_0
    //   753: fconst_0
    //   754: ldc_w 320
    //   757: ldc_w 321
    //   760: ldc_w 322
    //   763: getstatic 328	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   766: invokespecial 331	android/graphics/LinearGradient:<init>	(FFFFIILandroid/graphics/Shader$TileMode;)V
    //   769: invokevirtual 335	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   772: pop
    //   773: aload 16
    //   775: fconst_0
    //   776: fconst_0
    //   777: ldc_w 336
    //   780: ldc_w 320
    //   783: aload_1
    //   784: invokevirtual 339	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   787: aload_1
    //   788: aconst_null
    //   789: invokevirtual 335	android/graphics/Paint:setShader	(Landroid/graphics/Shader;)Landroid/graphics/Shader;
    //   792: pop
    //   793: aload_1
    //   794: ldc_w 340
    //   797: invokevirtual 217	android/graphics/Paint:setColor	(I)V
    //   800: aload 16
    //   802: fconst_0
    //   803: ldc_w 320
    //   806: ldc_w 336
    //   809: ldc_w 320
    //   812: aload_1
    //   813: invokevirtual 343	android/graphics/Canvas:drawLine	(FFFFLandroid/graphics/Paint;)V
    //   816: aload_1
    //   817: ldc_w 344
    //   820: invokevirtual 217	android/graphics/Paint:setColor	(I)V
    //   823: aload 16
    //   825: fconst_0
    //   826: ldc_w 345
    //   829: ldc_w 336
    //   832: ldc_w 346
    //   835: aload_1
    //   836: invokevirtual 339	android/graphics/Canvas:drawRect	(FFFFLandroid/graphics/Paint;)V
    //   839: goto -725 -> 114
    //   842: sipush 380
    //   845: istore_3
    //   846: goto -573 -> 273
    //   849: sipush 140
    //   852: istore_3
    //   853: goto -479 -> 374
    //   856: new 189	android/graphics/Rect
    //   859: dup
    //   860: bipush 70
    //   862: bipush 100
    //   864: sipush 470
    //   867: sipush 500
    //   870: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   873: astore 10
    //   875: goto -454 -> 421
    //   878: astore_1
    //   879: ldc 93
    //   881: iconst_2
    //   882: new 95	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   889: ldc_w 348
    //   892: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload_1
    //   896: invokevirtual 349	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   899: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   908: aload 6
    //   910: astore_1
    //   911: goto -334 -> 577
    //   914: aload 16
    //   916: aload_1
    //   917: aconst_null
    //   918: aload 10
    //   920: aconst_null
    //   921: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   924: aload_1
    //   925: invokevirtual 352	android/graphics/Bitmap:recycle	()V
    //   928: iload 7
    //   930: iconst_1
    //   931: if_icmpne +138 -> 1069
    //   934: new 186	android/graphics/Paint
    //   937: dup
    //   938: invokespecial 187	android/graphics/Paint:<init>	()V
    //   941: astore_1
    //   942: aload_1
    //   943: iconst_1
    //   944: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   947: new 189	android/graphics/Rect
    //   950: dup
    //   951: sipush 217
    //   954: sipush 247
    //   957: sipush 323
    //   960: sipush 353
    //   963: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   966: astore_2
    //   967: aload_0
    //   968: invokevirtual 167	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   971: ldc_w 353
    //   974: invokestatic 173	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   977: astore_0
    //   978: aload 16
    //   980: aload_0
    //   981: aconst_null
    //   982: aload_2
    //   983: aload_1
    //   984: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   987: aload_0
    //   988: invokevirtual 352	android/graphics/Bitmap:recycle	()V
    //   991: new 186	android/graphics/Paint
    //   994: dup
    //   995: invokespecial 187	android/graphics/Paint:<init>	()V
    //   998: astore_0
    //   999: aload_0
    //   1000: getstatic 209	android/graphics/Paint$Align:LEFT	Landroid/graphics/Paint$Align;
    //   1003: invokevirtual 213	android/graphics/Paint:setTextAlign	(Landroid/graphics/Paint$Align;)V
    //   1006: aload_0
    //   1007: iconst_1
    //   1008: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   1011: aload_0
    //   1012: iload 8
    //   1014: invokevirtual 217	android/graphics/Paint:setColor	(I)V
    //   1017: aload_0
    //   1018: ldc_w 354
    //   1021: invokevirtual 222	android/graphics/Paint:setTextSize	(F)V
    //   1024: aload_0
    //   1025: getstatic 231	android/graphics/Typeface:SANS_SERIF	Landroid/graphics/Typeface;
    //   1028: invokevirtual 235	android/graphics/Paint:setTypeface	(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;
    //   1031: pop
    //   1032: aload 16
    //   1034: aload 9
    //   1036: ldc_w 355
    //   1039: ldc_w 356
    //   1042: aload_0
    //   1043: invokevirtual 257	android/graphics/Canvas:drawText	(Ljava/lang/String;FFLandroid/graphics/Paint;)V
    //   1046: aload 15
    //   1048: areturn
    //   1049: astore_0
    //   1050: aload_0
    //   1051: invokevirtual 359	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1054: aconst_null
    //   1055: areturn
    //   1056: aload 16
    //   1058: aload_1
    //   1059: aconst_null
    //   1060: aload 10
    //   1062: aconst_null
    //   1063: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1066: goto -138 -> 928
    //   1069: iload 7
    //   1071: iconst_2
    //   1072: if_icmpne +57 -> 1129
    //   1075: aload_2
    //   1076: ifnull +53 -> 1129
    //   1079: new 186	android/graphics/Paint
    //   1082: dup
    //   1083: invokespecial 187	android/graphics/Paint:<init>	()V
    //   1086: astore_0
    //   1087: aload_0
    //   1088: iconst_1
    //   1089: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   1092: aload 16
    //   1094: aload_2
    //   1095: aconst_null
    //   1096: new 189	android/graphics/Rect
    //   1099: dup
    //   1100: sipush 217
    //   1103: sipush 247
    //   1106: sipush 323
    //   1109: sipush 353
    //   1112: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   1115: aload_0
    //   1116: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1119: goto -128 -> 991
    //   1122: astore_0
    //   1123: aload_0
    //   1124: invokevirtual 359	java/lang/OutOfMemoryError:printStackTrace	()V
    //   1127: aconst_null
    //   1128: areturn
    //   1129: iload 7
    //   1131: iconst_3
    //   1132: if_icmpne +63 -> 1195
    //   1135: new 186	android/graphics/Paint
    //   1138: dup
    //   1139: invokespecial 187	android/graphics/Paint:<init>	()V
    //   1142: astore_1
    //   1143: aload_1
    //   1144: iconst_1
    //   1145: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   1148: new 189	android/graphics/Rect
    //   1151: dup
    //   1152: sipush 217
    //   1155: sipush 247
    //   1158: sipush 323
    //   1161: sipush 353
    //   1164: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   1167: astore_2
    //   1168: aload_0
    //   1169: invokevirtual 167	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1172: ldc_w 353
    //   1175: invokestatic 173	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1178: astore_0
    //   1179: aload 16
    //   1181: aload_0
    //   1182: aconst_null
    //   1183: aload_2
    //   1184: aload_1
    //   1185: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1188: aload_0
    //   1189: invokevirtual 352	android/graphics/Bitmap:recycle	()V
    //   1192: goto -201 -> 991
    //   1195: iload 7
    //   1197: iconst_4
    //   1198: if_icmpne -207 -> 991
    //   1201: new 186	android/graphics/Paint
    //   1204: dup
    //   1205: invokespecial 187	android/graphics/Paint:<init>	()V
    //   1208: astore_1
    //   1209: aload_1
    //   1210: iconst_1
    //   1211: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   1214: new 189	android/graphics/Rect
    //   1217: dup
    //   1218: sipush 217
    //   1221: sipush 247
    //   1224: sipush 323
    //   1227: sipush 353
    //   1230: invokespecial 192	android/graphics/Rect:<init>	(IIII)V
    //   1233: astore_2
    //   1234: aload_0
    //   1235: invokevirtual 167	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1238: ldc_w 353
    //   1241: invokestatic 173	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   1244: astore_0
    //   1245: aload 16
    //   1247: aload_0
    //   1248: aconst_null
    //   1249: aload_2
    //   1250: aload_1
    //   1251: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   1254: aload_0
    //   1255: invokevirtual 352	android/graphics/Bitmap:recycle	()V
    //   1258: goto -267 -> 991
    //   1261: aconst_null
    //   1262: astore 14
    //   1264: goto -1234 -> 30
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1267	0	paramContext	Context
    //   0	1267	1	paramBitmap1	Bitmap
    //   0	1267	2	paramBitmap2	Bitmap
    //   0	1267	3	paramInt1	int
    //   0	1267	4	paramString1	String
    //   0	1267	5	paramBitmap3	Bitmap
    //   0	1267	6	paramBitmap4	Bitmap
    //   0	1267	7	paramInt2	int
    //   0	1267	8	paramInt3	int
    //   0	1267	9	paramString2	String
    //   0	1267	10	paramRect	Rect
    //   0	1267	11	paramArrayList	ArrayList<Rect>
    //   0	1267	12	paramInt4	int
    //   287	56	13	i	int
    //   28	1235	14	localObject	Object
    //   12	1035	15	localBitmap	Bitmap
    //   65	1181	16	localCanvas	Canvas
    //   78	305	17	localPaint	Paint
    //   95	13	18	localRect	Rect
    // Exception table:
    //   from	to	target	type
    //   0	14	37	java/lang/OutOfMemoryError
    //   19	30	37	java/lang/OutOfMemoryError
    //   466	488	878	java/lang/Throwable
    //   496	574	878	java/lang/Throwable
    //   634	697	1049	java/lang/OutOfMemoryError
    //   699	731	1049	java/lang/OutOfMemoryError
    //   914	928	1049	java/lang/OutOfMemoryError
    //   934	991	1122	java/lang/OutOfMemoryError
    //   1079	1119	1122	java/lang/OutOfMemoryError
    //   1135	1192	1122	java/lang/OutOfMemoryError
    //   1201	1258	1122	java/lang/OutOfMemoryError
  }
  
  public static Bitmap a(Resources paramResources, int paramInt, Integer paramInteger1, Integer paramInteger2)
  {
    Drawable localDrawable = paramResources.getDrawable(paramInt);
    if ((localDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)localDrawable).getBitmap();
    }
    if ((localDrawable instanceof GradientDrawable))
    {
      paramResources = (GradientDrawable)localDrawable;
      if (localDrawable.getIntrinsicWidth() > 0)
      {
        paramInt = localDrawable.getIntrinsicWidth();
        if (localDrawable.getIntrinsicHeight() <= 0) {
          break label123;
        }
      }
      label123:
      for (int i = localDrawable.getIntrinsicHeight();; i = paramInteger2.intValue())
      {
        paramInteger1 = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
        paramInteger2 = new Canvas(paramInteger1);
        paramResources.setBounds(0, 0, paramInt, i);
        paramResources.setStroke(1, -16777216);
        paramResources.setFilterBitmap(true);
        paramResources.draw(paramInteger2);
        return paramInteger1;
        paramInt = paramInteger1.intValue();
        break;
      }
    }
    return BitmapFactory.decodeResource(paramResources, paramInt).copy(Bitmap.Config.ARGB_8888, true);
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
    //   6: new 416	java/io/File
    //   9: dup
    //   10: ldc_w 418
    //   13: invokestatic 424	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 427	java/io/File:<init>	(Ljava/lang/String;)V
    //   19: astore 4
    //   21: aload 4
    //   23: invokevirtual 430	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnonnull +8 -> 40
    //   35: aload_0
    //   36: invokevirtual 434	android/content/Context:getCacheDir	()Ljava/io/File;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull -37 -> 4
    //   44: aload_3
    //   45: invokevirtual 437	java/io/File:canWrite	()Z
    //   48: ifeq -44 -> 4
    //   51: new 416	java/io/File
    //   54: dup
    //   55: aload_3
    //   56: invokevirtual 440	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   59: aload_1
    //   60: invokespecial 443	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: astore_0
    //   64: aload_0
    //   65: invokevirtual 440	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   68: astore 5
    //   70: aload_0
    //   71: invokevirtual 446	java/io/File:exists	()Z
    //   74: ifeq +8 -> 82
    //   77: aload_0
    //   78: invokevirtual 449	java/io/File:delete	()Z
    //   81: pop
    //   82: new 451	java/io/FileOutputStream
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 454	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: astore_0
    //   91: new 456	java/io/BufferedOutputStream
    //   94: dup
    //   95: aload_0
    //   96: invokespecial 459	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   99: astore 4
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: astore_1
    //   106: aload_2
    //   107: getstatic 465	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   110: bipush 100
    //   112: aload 4
    //   114: invokevirtual 469	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   117: pop
    //   118: aload 4
    //   120: astore_3
    //   121: aload_0
    //   122: astore_1
    //   123: aload 4
    //   125: invokevirtual 472	java/io/BufferedOutputStream:flush	()V
    //   128: aload 4
    //   130: ifnull +8 -> 138
    //   133: aload 4
    //   135: invokevirtual 475	java/io/BufferedOutputStream:close	()V
    //   138: aload_0
    //   139: ifnull +7 -> 146
    //   142: aload_0
    //   143: invokevirtual 476	java/io/FileOutputStream:close	()V
    //   146: aload 5
    //   148: areturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 477	java/io/IOException:printStackTrace	()V
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
    //   169: invokevirtual 478	java/io/FileNotFoundException:printStackTrace	()V
    //   172: aload_2
    //   173: ifnull +7 -> 180
    //   176: aload_2
    //   177: invokevirtual 475	java/io/BufferedOutputStream:close	()V
    //   180: aload_0
    //   181: ifnull -177 -> 4
    //   184: aload_0
    //   185: invokevirtual 476	java/io/FileOutputStream:close	()V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_0
    //   191: aload_0
    //   192: invokevirtual 477	java/io/IOException:printStackTrace	()V
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
    //   209: invokevirtual 477	java/io/IOException:printStackTrace	()V
    //   212: aload_2
    //   213: ifnull +7 -> 220
    //   216: aload_2
    //   217: invokevirtual 475	java/io/BufferedOutputStream:close	()V
    //   220: aload_0
    //   221: ifnull -217 -> 4
    //   224: aload_0
    //   225: invokevirtual 476	java/io/FileOutputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: aload_0
    //   232: invokevirtual 477	java/io/IOException:printStackTrace	()V
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
    //   247: invokevirtual 475	java/io/BufferedOutputStream:close	()V
    //   250: aload_0
    //   251: ifnull +7 -> 258
    //   254: aload_0
    //   255: invokevirtual 476	java/io/FileOutputStream:close	()V
    //   258: aload_2
    //   259: athrow
    //   260: astore_0
    //   261: aload_0
    //   262: invokevirtual 477	java/io/IOException:printStackTrace	()V
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
  
  public static lk a(String paramString, int paramInt)
  {
    EnumMap localEnumMap = new EnumMap(EncodeHintType.class);
    localEnumMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    Object localObject = e(paramString);
    if (localObject != null) {
      localEnumMap.put(EncodeHintType.CHARACTER_SET, localObject);
    }
    if (paramInt != -1) {
      localEnumMap.put(EncodeHintType.QRCODE_VERSION, Integer.valueOf(eo(paramInt)));
    }
    localEnumMap.put(EncodeHintType.MARGIN, Integer.valueOf(0));
    localObject = new lo();
    try
    {
      paramString = ((lo)localObject).b(paramString, 0, 0, localEnumMap);
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
      QLog.e("QRUtils", 1, "encode error:" + paramString.getMessage());
    }
    return null;
  }
  
  private static void a(int paramInt1, Canvas paramCanvas, int paramInt2)
  {
    Bitmap localBitmap = BitmapFactory.decodeResource(BaseApplicationImpl.getApplication().getResources(), 2130844063);
    Paint localPaint = new Paint();
    paramInt1 = paramInt1 / 2 - 80;
    RectF localRectF = new RectF(paramInt1, paramInt2 - 76, paramInt1 + 160, paramInt2 - 70 + 70);
    localPaint.setAntiAlias(true);
    paramCanvas.drawBitmap(localBitmap, null, localRectF, localPaint);
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
      int i = (int)localPaint.measureText(paramString);
      paramInt1 = paramInt2 / 2;
      paramInt2 = i / 2;
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
  
  private static void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Canvas paramCanvas, int paramInt3)
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = paramInt1 / 2 - 68;
    paramInt2 = paramInt3 + 74;
    paramInt1 = paramInt2;
    if (paramInt2 < 0) {
      paramInt1 = 0;
    }
    Rect localRect = new Rect(i, paramInt1, i + 136, paramInt1 + 67);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      localPaint.setColorFilter(new PorterDuffColorFilter(Color.parseColor(paramString), PorterDuff.Mode.SRC_ATOP));
      paramCanvas.drawBitmap(BitmapFactory.decodeResource(paramContext.getResources(), 2130847819), null, localRect, localPaint);
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
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, rtu paramrtu)
  {
    paramString1 = rtt.a(paramInt1, paramString1);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("QRUtils", 2, "entity is null in getCardQRCode, type=" + paramInt1);
      }
      return;
    }
    paramString1 = paramString1.ng();
    paramString2 = new rwu(paramrtu);
    paramContext = new NewIntent(paramContext, rtv.class);
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
  
  /* Error */
  private static boolean a(Bitmap paramBitmap, ArrayList<Rect> paramArrayList, Canvas paramCanvas, Rect paramRect)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 5
    //   3: invokestatic 259	rwt:Mc	()Z
    //   6: ifeq +143 -> 149
    //   9: aload_0
    //   10: astore 5
    //   12: aload_3
    //   13: invokevirtual 262	android/graphics/Rect:width	()I
    //   16: sipush 350
    //   19: if_icmple +130 -> 149
    //   22: aload_0
    //   23: astore 5
    //   25: aload_3
    //   26: invokevirtual 265	android/graphics/Rect:height	()I
    //   29: sipush 350
    //   32: if_icmple +117 -> 149
    //   35: aload_0
    //   36: astore 5
    //   38: aload_0
    //   39: ifnull +110 -> 149
    //   42: aload_0
    //   43: aload_3
    //   44: invokevirtual 262	android/graphics/Rect:width	()I
    //   47: iconst_2
    //   48: idiv
    //   49: aload_3
    //   50: invokevirtual 265	android/graphics/Rect:height	()I
    //   53: iconst_2
    //   54: idiv
    //   55: iconst_0
    //   56: invokestatic 269	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   59: astore 6
    //   61: aload_0
    //   62: astore 5
    //   64: aload 6
    //   66: ifnull +83 -> 149
    //   69: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +73 -> 145
    //   75: ldc 93
    //   77: iconst_2
    //   78: new 95	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   85: ldc_w 271
    //   88: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload 6
    //   93: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   96: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: ldc_w 279
    //   102: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload 6
    //   107: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   110: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc_w 284
    //   116: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_0
    //   120: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   123: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: ldc_w 286
    //   129: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   136: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: aload 6
    //   147: astore 5
    //   149: aload_1
    //   150: ifnull +223 -> 373
    //   153: invokestatic 91	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +52 -> 208
    //   159: aload 5
    //   161: ifnull +47 -> 208
    //   164: ldc 93
    //   166: iconst_2
    //   167: new 95	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 288
    //   177: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 274	android/graphics/Bitmap:getWidth	()I
    //   185: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: ldc_w 279
    //   191: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 282	android/graphics/Bitmap:getHeight	()I
    //   199: invokevirtual 277	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 179	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   208: aload 5
    //   210: aload_3
    //   211: invokevirtual 262	android/graphics/Rect:width	()I
    //   214: aload_3
    //   215: invokevirtual 265	android/graphics/Rect:height	()I
    //   218: iconst_0
    //   219: invokestatic 269	android/graphics/Bitmap:createScaledBitmap	(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;
    //   222: astore_0
    //   223: new 181	android/graphics/Canvas
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 184	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   231: astore 5
    //   233: new 186	android/graphics/Paint
    //   236: dup
    //   237: invokespecial 187	android/graphics/Paint:<init>	()V
    //   240: astore 6
    //   242: aload 6
    //   244: iconst_0
    //   245: invokevirtual 291	android/graphics/Paint:setAlpha	(I)V
    //   248: aload 6
    //   250: iconst_1
    //   251: invokevirtual 196	android/graphics/Paint:setAntiAlias	(Z)V
    //   254: aload 6
    //   256: new 293	android/graphics/PorterDuffXfermode
    //   259: dup
    //   260: getstatic 299	android/graphics/PorterDuff$Mode:DST_IN	Landroid/graphics/PorterDuff$Mode;
    //   263: invokespecial 302	android/graphics/PorterDuffXfermode:<init>	(Landroid/graphics/PorterDuff$Mode;)V
    //   266: invokevirtual 306	android/graphics/Paint:setXfermode	(Landroid/graphics/Xfermode;)Landroid/graphics/Xfermode;
    //   269: pop
    //   270: iconst_0
    //   271: istore 4
    //   273: iload 4
    //   275: aload_1
    //   276: invokevirtual 309	java/util/ArrayList:size	()I
    //   279: if_icmpge +73 -> 352
    //   282: aload 5
    //   284: new 189	android/graphics/Rect
    //   287: dup
    //   288: aload_1
    //   289: iload 4
    //   291: invokevirtual 310	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   294: checkcast 189	android/graphics/Rect
    //   297: invokespecial 313	android/graphics/Rect:<init>	(Landroid/graphics/Rect;)V
    //   300: aload 6
    //   302: invokevirtual 317	android/graphics/Canvas:drawRect	(Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   305: iload 4
    //   307: iconst_1
    //   308: iadd
    //   309: istore 4
    //   311: goto -38 -> 273
    //   314: astore 5
    //   316: ldc 93
    //   318: iconst_1
    //   319: new 95	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   326: ldc_w 348
    //   329: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload 5
    //   334: invokevirtual 349	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 118	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload_0
    //   347: astore 5
    //   349: goto -200 -> 149
    //   352: aload_2
    //   353: aload_0
    //   354: aconst_null
    //   355: aload_3
    //   356: aconst_null
    //   357: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   360: aload_0
    //   361: invokevirtual 352	android/graphics/Bitmap:recycle	()V
    //   364: iconst_0
    //   365: ireturn
    //   366: astore_0
    //   367: aload_0
    //   368: invokevirtual 359	java/lang/OutOfMemoryError:printStackTrace	()V
    //   371: iconst_1
    //   372: ireturn
    //   373: aload_2
    //   374: aload 5
    //   376: aconst_null
    //   377: aload_3
    //   378: aconst_null
    //   379: invokevirtual 200	android/graphics/Canvas:drawBitmap	(Landroid/graphics/Bitmap;Landroid/graphics/Rect;Landroid/graphics/Rect;Landroid/graphics/Paint;)V
    //   382: goto -18 -> 364
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	paramBitmap	Bitmap
    //   0	385	1	paramArrayList	ArrayList<Rect>
    //   0	385	2	paramCanvas	Canvas
    //   0	385	3	paramRect	Rect
    //   271	39	4	i	int
    //   1	282	5	localObject1	Object
    //   314	19	5	localThrowable	Throwable
    //   347	28	5	localBitmap	Bitmap
    //   59	242	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   42	61	314	java/lang/Throwable
    //   69	145	314	java/lang/Throwable
    //   208	270	366	java/lang/OutOfMemoryError
    //   273	305	366	java/lang/OutOfMemoryError
    //   352	364	366	java/lang/OutOfMemoryError
  }
  
  public static final Bitmap[] a(Context paramContext, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, ArrayList<Rect> paramArrayList, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    Bitmap[] arrayOfBitmap = new Bitmap[2];
    int m = Math.min(750, ankt.aE(paramContext));
    int n = Math.min(1344, ankt.getRealHeight(paramContext));
    if (QLog.isColorLevel()) {
      QLog.w("QRUtils", 2, "getMyQRCard() shareWidth=" + m + ",shareHeight=" + n);
    }
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    try
    {
      localBitmap1 = Bitmap.createBitmap(440, 440, Bitmap.Config.ARGB_8888);
      localBitmap2 = Bitmap.createBitmap(m, n, Bitmap.Config.ARGB_8888);
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
      QLog.d("QRUtils", 2, " shareWidth = " + m + " shareHeight = " + n);
    }
    a(paramBitmap1, m, n, paramBitmap3);
    paramBitmap1 = new Paint();
    int i1 = (m - 550) / 2;
    int i = (n - 982) / 2;
    int j;
    if (i > 0)
    {
      i += 78;
      int k = i + 772;
      j = k;
      if (paramBoolean2) {
        j = k - 42;
      }
      paramArrayList = new RectF(i1, i, i1 + 550, j);
      paramBitmap1.setAntiAlias(true);
      paramBitmap1.setColor(Color.parseColor("#E6FFFFFF"));
      paramBitmap3.drawRoundRect(paramArrayList, 12.0F, 12.0F, paramBitmap1);
      a(m, paramBitmap3, i);
      b(paramBitmap2, m, paramBitmap3, i);
      a(paramInt1, paramString1, paramString2, m, paramBitmap3, i);
      if (paramBoolean2) {
        break label457;
      }
      a(localBitmap1, m, paramBitmap3, i - 42);
      a(paramInt1, paramString3, m, paramBitmap3, i - 42, j);
    }
    for (;;)
    {
      if (paramBoolean1) {
        a(paramContext, paramString4, m, n, paramBitmap3, j);
      }
      arrayOfBitmap[1] = localBitmap2;
      return arrayOfBitmap;
      i = 78;
      break;
      label457:
      a(paramString2, paramInt2, m, paramBitmap3, i);
      a(localBitmap1, m, paramBitmap3, i);
      a(paramInt1, paramString3, m, paramBitmap3, i, j);
    }
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
  
  public static void be(Context paramContext, String paramString)
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
  
  public static long bytesToLong(byte[] paramArrayOfByte)
  {
    long l = 0L;
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      l += ((paramArrayOfByte[(j - i - 1)] & 0xFF) << i * 8);
      i += 1;
    }
    return l;
  }
  
  public static short bytesToShort(byte[] paramArrayOfByte)
  {
    return (short)(((paramArrayOfByte[0] & 0xFF) << 8) + (paramArrayOfByte[1] & 0xFF));
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("my_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveMyQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putInt("troop_qr_code_cfg_sp_index", paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "saveTroopQrBgIndex2Sp().index:" + paramInt);
    }
    return paramQQAppInterface.commit();
  }
  
  protected static String e(CharSequence paramCharSequence)
  {
    int i = 0;
    while (i < paramCharSequence.length())
    {
      if (paramCharSequence.charAt(i) > 'ÿ') {
        return "UTF-8";
      }
      i += 1;
    }
    return null;
  }
  
  public static void eA(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QRUtils.2(paramInt1, paramInt2));
  }
  
  protected static int eo(int paramInt)
  {
    if (paramInt < 21) {
      return 1;
    }
    if (paramInt > 177) {
      return 39;
    }
    return (paramInt - 21) / 4 + 1;
  }
  
  public static void ez(int paramInt1, int paramInt2)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    QQToast.a(localBaseApplication, paramInt1, paramInt2, 1).show(localBaseApplication.getResources().getDimensionPixelSize(2131299627));
  }
  
  public static boolean fI(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(aCR, paramString);
  }
  
  public static boolean fJ(String paramString)
  {
    if (paramString == null) {}
    while ((!Pattern.matches(aCS, paramString)) && (!Pattern.matches(aCT, paramString))) {
      return false;
    }
    return true;
  }
  
  public static boolean fK(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return Pattern.matches(aCT, paramString);
  }
  
  public static boolean fL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://vac.qq.com/wallet/qrcode.htm")) && (!paramString.startsWith("https://i.qianbao.qq.com/wallet/sqrcode.htm"))) {
      return false;
    }
    return true;
  }
  
  public static boolean fM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://qpay.qq.com/qr/")) && (!paramString.startsWith("https://qpay.qq.com/qr/"))) {
      return false;
    }
    return true;
  }
  
  public static boolean fN(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((!paramString.startsWith("http://mqq.tenpay.com/qrhb")) && (!paramString.startsWith("https://mqq.tenpay.com/qrhb"))) {
      return false;
    }
    return true;
  }
  
  public static boolean fO(String paramString)
  {
    return (isUrl(paramString)) && ((paramString.startsWith("http:")) || (paramString.startsWith("https:")) || (paramString.startsWith("www.")));
  }
  
  public static boolean fP(String paramString)
  {
    return Pattern.matches(aCU, paramString);
  }
  
  public static boolean isUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return URLUtil.isValidUrl(paramString);
  }
  
  public static int l(QQAppInterface paramQQAppInterface)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("my_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getMyQrBgIndexFromSp().settingValue:" + i);
    }
    return i;
  }
  
  public static byte[] longToBytes(long paramLong)
  {
    return new byte[] { (byte)(int)(paramLong >>> 56), (byte)(int)(paramLong >>> 48), (byte)(int)(paramLong >>> 40), (byte)(int)(paramLong >>> 32), (byte)(int)(paramLong >>> 24), (byte)(int)(paramLong >>> 16), (byte)(int)(paramLong >>> 8), (byte)(int)paramLong };
  }
  
  public static int m(QQAppInterface paramQQAppInterface)
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("troop_qr_code_cfg_sp_index", -1);
    if (QLog.isColorLevel()) {
      QLog.i("QRUtils", 2, "getTroopQrBgIndexFromSp().settingValue:" + i);
    }
    return i;
  }
  
  public static String s(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("host", 0).getString(paramString, null);
    if (paramContext != null) {
      return paramContext;
    }
    if (paramString.equals(aCV)) {
      return aCW;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     rwt
 * JD-Core Version:    0.7.0.1
 */