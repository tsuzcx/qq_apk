package com.tencent.mobileqq.startup.step;

import android.content.res.Resources.NotFoundException;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import mqq.app.AppActivity;

public class SetSplash
  extends Step
{
  private static int a(String paramString1, String paramString2)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("MM-dd");
    try
    {
      long l = (localSimpleDateFormat.parse(paramString2).getTime() - localSimpleDateFormat.parse(paramString1).getTime()) / 86400000L;
      return (int)l;
    }
    catch (ParseException paramString1)
    {
      paramString1.printStackTrace();
    }
    return -1;
  }
  
  private static String a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists()) || (!paramFile.isFile())) {
      return "";
    }
    byte[] arrayOfByte = new byte[1024];
    MessageDigest localMessageDigest;
    try
    {
      localMessageDigest = MessageDigest.getInstance("MD5");
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i = paramFile.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localMessageDigest.update(arrayOfByte, 0, i);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return "";
    }
    return new BigInteger(1, localMessageDigest.digest()).toString(16);
  }
  
  static boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l < paramLong1) || (l > paramLong2));
    return true;
  }
  
  /* Error */
  public static boolean a(android.app.Activity paramActivity)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: lconst_0
    //   7: lstore 8
    //   9: aload_0
    //   10: instanceof 100
    //   13: ifeq +369 -> 382
    //   16: aload_0
    //   17: checkcast 100	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   20: ldc 101
    //   22: invokevirtual 105	com/tencent/mobileqq/app/IphoneTitleBarActivity:f	(I)V
    //   25: aload_0
    //   26: ldc 106
    //   28: invokevirtual 112	android/app/Activity:findViewById	(I)Landroid/view/View;
    //   31: checkcast 114	android/widget/ImageView
    //   34: astore 14
    //   36: aconst_null
    //   37: astore 12
    //   39: aconst_null
    //   40: astore 13
    //   42: aload_0
    //   43: invokestatic 120	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   46: astore 15
    //   48: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +29 -> 80
    //   54: ldc 127
    //   56: iconst_2
    //   57: new 129	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   64: ldc 132
    //   66: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload 15
    //   71: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 143	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   80: aload 15
    //   82: ldc 49
    //   84: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   87: ifne +401 -> 488
    //   90: new 15	java/text/SimpleDateFormat
    //   93: dup
    //   94: ldc 17
    //   96: invokespecial 20	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   99: new 26	java/util/Date
    //   102: dup
    //   103: invokespecial 150	java/util/Date:<init>	()V
    //   106: invokevirtual 154	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   109: aload 15
    //   111: invokestatic 156	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   114: ifne +374 -> 488
    //   117: aload_0
    //   118: invokevirtual 160	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   121: ifnull +342 -> 463
    //   124: new 129	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   131: aload_0
    //   132: invokevirtual 160	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   135: invokevirtual 163	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   138: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: ldc 165
    //   143: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: invokestatic 167	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   150: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: ldc 165
    //   155: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 169
    //   160: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: astore 12
    //   168: new 40	java/io/File
    //   171: dup
    //   172: aload 12
    //   174: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   177: astore 13
    //   179: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +37 -> 219
    //   185: ldc 127
    //   187: iconst_2
    //   188: new 129	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   195: aload 12
    //   197: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: ldc 172
    //   202: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload 13
    //   207: invokevirtual 44	java/io/File:exists	()Z
    //   210: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   213: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload 13
    //   221: invokevirtual 44	java/io/File:exists	()Z
    //   224: ifeq +230 -> 454
    //   227: new 180	android/graphics/drawable/BitmapDrawable
    //   230: dup
    //   231: aload_0
    //   232: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   235: aload 12
    //   237: invokestatic 189	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   240: invokespecial 192	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   243: astore 12
    //   245: aload 12
    //   247: ifnull +177 -> 424
    //   250: new 180	android/graphics/drawable/BitmapDrawable
    //   253: dup
    //   254: aload_0
    //   255: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   258: aload_0
    //   259: invokevirtual 196	android/app/Activity:getAssets	()Landroid/content/res/AssetManager;
    //   262: ldc 198
    //   264: invokevirtual 204	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   267: invokespecial 207	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   270: astore 13
    //   272: aload 13
    //   274: astore 12
    //   276: aload 12
    //   278: ifnull +10 -> 288
    //   281: aload 14
    //   283: aload 12
    //   285: invokevirtual 211	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   288: aload 14
    //   290: invokevirtual 215	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   293: astore 12
    //   295: aload 12
    //   297: ifnull +82 -> 379
    //   300: aload 12
    //   302: instanceof 180
    //   305: ifne +11 -> 316
    //   308: aload 12
    //   310: instanceof 217
    //   313: ifeq +66 -> 379
    //   316: aload_0
    //   317: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   320: invokevirtual 223	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   323: getfield 229	android/util/DisplayMetrics:widthPixels	I
    //   326: istore_1
    //   327: aload_0
    //   328: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   331: invokevirtual 223	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   334: getfield 232	android/util/DisplayMetrics:heightPixels	I
    //   337: istore_2
    //   338: aload 12
    //   340: invokevirtual 238	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   343: iload_1
    //   344: imul
    //   345: aload 12
    //   347: invokevirtual 241	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   350: idiv
    //   351: istore_3
    //   352: aload 14
    //   354: new 243	android/widget/RelativeLayout$LayoutParams
    //   357: dup
    //   358: iload_1
    //   359: iload_3
    //   360: invokespecial 246	android/widget/RelativeLayout$LayoutParams:<init>	(II)V
    //   363: invokevirtual 250	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   366: iload_3
    //   367: iload_2
    //   368: if_icmpgt +401 -> 769
    //   371: aload 14
    //   373: getstatic 256	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   376: invokevirtual 260	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   379: iload 4
    //   381: ireturn
    //   382: aload_0
    //   383: ldc 101
    //   385: invokevirtual 263	android/app/Activity:setContentView	(I)V
    //   388: goto -363 -> 25
    //   391: astore 12
    //   393: aload 12
    //   395: invokestatic 269	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   398: astore 12
    //   400: ldc_w 271
    //   403: iconst_1
    //   404: aload 12
    //   406: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   409: aload_0
    //   410: ldc_w 273
    //   413: aload 12
    //   415: invokestatic 278	com/tencent/mobileqq/app/InjectUtils:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   418: aload_0
    //   419: invokevirtual 281	android/app/Activity:finish	()V
    //   422: iconst_0
    //   423: ireturn
    //   424: iconst_0
    //   425: istore 4
    //   427: goto -177 -> 250
    //   430: astore 12
    //   432: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +14 -> 449
    //   438: ldc 127
    //   440: iconst_2
    //   441: ldc_w 283
    //   444: aload 12
    //   446: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   449: aload 12
    //   451: invokevirtual 287	java/lang/Throwable:printStackTrace	()V
    //   454: aconst_null
    //   455: astore 12
    //   457: iconst_0
    //   458: istore 4
    //   460: goto -210 -> 250
    //   463: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   466: ifeq +12 -> 478
    //   469: ldc 127
    //   471: iconst_2
    //   472: ldc_w 289
    //   475: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   478: iconst_0
    //   479: istore 4
    //   481: aload 13
    //   483: astore 12
    //   485: goto -235 -> 250
    //   488: aload_0
    //   489: invokevirtual 293	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   492: invokestatic 296	com/tencent/mobileqq/utils/SharedPreUtils:d	(Landroid/content/Context;)Ljava/lang/String;
    //   495: astore 13
    //   497: aload 13
    //   499: ifnull +293 -> 792
    //   502: aload 13
    //   504: invokevirtual 299	java/lang/String:trim	()Ljava/lang/String;
    //   507: ldc 49
    //   509: invokevirtual 149	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   512: ifne +280 -> 792
    //   515: aload 13
    //   517: ldc_w 301
    //   520: invokevirtual 305	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   523: istore_1
    //   524: aload 13
    //   526: iconst_0
    //   527: iload_1
    //   528: invokevirtual 309	java/lang/String:substring	(II)Ljava/lang/String;
    //   531: invokestatic 315	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   534: lstore 6
    //   536: aload 13
    //   538: iload_1
    //   539: iconst_1
    //   540: iadd
    //   541: invokevirtual 317	java/lang/String:substring	(I)Ljava/lang/String;
    //   544: invokestatic 315	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   547: lstore 10
    //   549: lload 10
    //   551: lstore 8
    //   553: lload 6
    //   555: lload 8
    //   557: invokestatic 319	com/tencent/mobileqq/startup/step/SetSplash:a	(JJ)Z
    //   560: ifeq +175 -> 735
    //   563: aload_0
    //   564: invokevirtual 160	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   567: ifnull +174 -> 741
    //   570: new 129	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   577: aload_0
    //   578: invokevirtual 160	android/app/Activity:getFilesDir	()Ljava/io/File;
    //   581: invokevirtual 163	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   584: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: ldc 165
    //   589: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 321
    //   595: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: astore 13
    //   603: new 40	java/io/File
    //   606: dup
    //   607: aload 13
    //   609: invokespecial 170	java/io/File:<init>	(Ljava/lang/String;)V
    //   612: astore 15
    //   614: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   617: ifeq +38 -> 655
    //   620: ldc 127
    //   622: iconst_2
    //   623: new 129	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   630: aload 13
    //   632: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc_w 323
    //   638: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload 15
    //   643: invokevirtual 44	java/io/File:exists	()Z
    //   646: invokevirtual 175	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   649: invokevirtual 139	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   652: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   655: aload 15
    //   657: invokevirtual 44	java/io/File:exists	()Z
    //   660: ifeq +75 -> 735
    //   663: new 180	android/graphics/drawable/BitmapDrawable
    //   666: dup
    //   667: aload_0
    //   668: invokevirtual 184	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   671: aload 13
    //   673: invokestatic 189	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   676: invokespecial 192	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   679: astore 13
    //   681: aload 13
    //   683: ifnull +22 -> 705
    //   686: iload 5
    //   688: istore 4
    //   690: aload 13
    //   692: astore 12
    //   694: goto -444 -> 250
    //   697: astore 13
    //   699: lconst_0
    //   700: lstore 6
    //   702: goto -149 -> 553
    //   705: iconst_0
    //   706: istore 4
    //   708: goto -18 -> 690
    //   711: astore 13
    //   713: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +14 -> 730
    //   719: ldc 127
    //   721: iconst_2
    //   722: ldc_w 283
    //   725: aload 13
    //   727: invokestatic 286	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   730: aload 13
    //   732: invokevirtual 287	java/lang/Throwable:printStackTrace	()V
    //   735: iconst_0
    //   736: istore 4
    //   738: goto -488 -> 250
    //   741: invokestatic 125	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq -9 -> 735
    //   747: ldc 127
    //   749: iconst_2
    //   750: ldc_w 289
    //   753: invokestatic 178	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: goto -21 -> 735
    //   759: astore 13
    //   761: aload 13
    //   763: invokevirtual 287	java/lang/Throwable:printStackTrace	()V
    //   766: goto -490 -> 276
    //   769: iload_3
    //   770: iload_2
    //   771: if_icmple -392 -> 379
    //   774: aload 14
    //   776: getstatic 326	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   779: invokevirtual 260	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   782: goto -403 -> 379
    //   785: astore_0
    //   786: aload_0
    //   787: invokevirtual 287	java/lang/Throwable:printStackTrace	()V
    //   790: iconst_0
    //   791: ireturn
    //   792: lconst_0
    //   793: lstore 6
    //   795: goto -242 -> 553
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	798	0	paramActivity	android.app.Activity
    //   326	215	1	i	int
    //   337	435	2	j	int
    //   351	421	3	k	int
    //   4	733	4	bool1	boolean
    //   1	686	5	bool2	boolean
    //   534	260	6	l1	long
    //   7	549	8	l2	long
    //   547	3	10	l3	long
    //   37	309	12	localObject1	java.lang.Object
    //   391	3	12	localNotFoundException	Resources.NotFoundException
    //   398	16	12	str	String
    //   430	20	12	localThrowable1	java.lang.Throwable
    //   455	238	12	localObject2	java.lang.Object
    //   40	651	13	localObject3	java.lang.Object
    //   697	1	13	localException	Exception
    //   711	20	13	localThrowable2	java.lang.Throwable
    //   759	3	13	localThrowable3	java.lang.Throwable
    //   34	741	14	localImageView	android.widget.ImageView
    //   46	610	15	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   9	25	391	android/content/res/Resources$NotFoundException
    //   382	388	391	android/content/res/Resources$NotFoundException
    //   227	245	430	java/lang/Throwable
    //   515	549	697	java/lang/Exception
    //   663	681	711	java/lang/Throwable
    //   250	272	759	java/lang/Throwable
    //   288	295	785	java/lang/Throwable
    //   300	316	785	java/lang/Throwable
    //   316	366	785	java/lang/Throwable
    //   371	379	785	java/lang/Throwable
    //   774	782	785	java/lang/Throwable
  }
  
  protected boolean a()
  {
    AppActivity localAppActivity = this.a.a;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (bool) {
        return true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "doStep fail init activity preview:" + localNotFoundException.getMessage());
      }
      this.a.g = a(localAppActivity);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */