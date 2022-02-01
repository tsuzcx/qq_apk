import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.AlbumThumbManager;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;

public class aokn
  extends aoiz
{
  protected BaseApplicationImpl b;
  
  public aokn(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.b = paramBaseApplicationImpl;
  }
  
  private RoundRectBitmap a(Bitmap paramBitmap)
  {
    for (;;)
    {
      float f3;
      int j;
      int n;
      int k;
      int i1;
      try
      {
        f3 = this.b.getResources().getDisplayMetrics().density;
        int m = this.b.getResources().getDisplayMetrics().densityDpi;
        j = ahbh.cZc;
        i = ahbh.maxSize;
        n = paramBitmap.getWidth();
        k = paramBitmap.getHeight();
        Paint localPaint = new Paint(1);
        localPaint.setColor(-16777216);
        i1 = ahbh.cZe;
        int i2 = ahbh.cZf;
        if ((n >= i2) && (k >= i2)) {
          break label339;
        }
        if (n < k)
        {
          k = (int)(j / n * k + 0.5F);
          if (k <= i) {
            break label310;
          }
          Bitmap localBitmap = Bitmap.createBitmap(j, i, aoop.f);
          localBitmap.setDensity(m);
          new Canvas(localBitmap).drawBitmap(paramBitmap, null, new Rect(0, 0, j, i), localPaint);
          return new RoundRectBitmap(localBitmap, 8.0F * f3);
        }
        k = (int)(j / k * n + 0.5F);
        if (k <= i) {
          break label332;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        float f1;
        float f2;
        return new RoundRectBitmap(paramBitmap, 8.0F);
      }
      if (n > k)
      {
        f1 = i / n;
        if (n > k)
        {
          f2 = j / k;
          f1 = Math.max(f1, f2);
          j = (int)(n * f1 + 0.5F);
          i = (int)(f1 * k + 0.5F);
        }
      }
      else
      {
        f1 = i / k;
        continue;
      }
      f2 = j / n;
      continue;
      label310:
      int i = k;
      continue;
      for (;;)
      {
        k = i;
        i = j;
        j = k;
        break;
        label332:
        i = k;
      }
      label339:
      if ((n < i1) && (k < i1))
      {
        j = (int)(n * f3 + 0.5F);
        i = (int)(k * f3 + 0.5F);
      }
    }
  }
  
  /* Error */
  private Object a(DownloadParams paramDownloadParams, aokn.a parama)
    throws Exception
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 7
    //   8: aload_2
    //   9: getfield 123	aokn$a:path	Ljava/lang/String;
    //   12: astore 10
    //   14: aload 10
    //   16: ifnonnull +8 -> 24
    //   19: aload 7
    //   21: astore_2
    //   22: aload_2
    //   23: areturn
    //   24: new 125	java/io/File
    //   27: dup
    //   28: aload 10
    //   30: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 11
    //   35: aload 11
    //   37: invokestatic 134	com/tencent/image/GifDrawable:isGifFile	(Ljava/io/File;)Z
    //   40: ifeq +63 -> 103
    //   43: aload_2
    //   44: getfield 138	aokn$a:cMs	Z
    //   47: ifeq +56 -> 103
    //   50: aload 7
    //   52: astore_2
    //   53: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq -34 -> 22
    //   59: ldc 146
    //   61: iconst_2
    //   62: new 148	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   69: ldc 151
    //   71: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: aload 11
    //   76: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 161
    //   84: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload 10
    //   89: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: aconst_null
    //   99: areturn
    //   100: astore_1
    //   101: aload_1
    //   102: athrow
    //   103: new 170	android/graphics/BitmapFactory$Options
    //   106: dup
    //   107: invokespecial 171	android/graphics/BitmapFactory$Options:<init>	()V
    //   110: astore 12
    //   112: aload 12
    //   114: getstatic 174	aoop:mConfig	Landroid/graphics/Bitmap$Config;
    //   117: putfield 177	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   120: aload 12
    //   122: sipush 160
    //   125: putfield 180	android/graphics/BitmapFactory$Options:inDensity	I
    //   128: aload 12
    //   130: sipush 160
    //   133: putfield 183	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   136: aload 12
    //   138: sipush 160
    //   141: putfield 186	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   144: aload_1
    //   145: aload 10
    //   147: invokestatic 192	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   150: putfield 197	com/tencent/image/DownloadParams:outOrientation	I
    //   153: aload 12
    //   155: iconst_1
    //   156: putfield 200	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   159: new 202	java/io/FileInputStream
    //   162: dup
    //   163: aload 11
    //   165: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   168: invokespecial 203	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   171: astore 7
    //   173: new 205	java/io/BufferedInputStream
    //   176: dup
    //   177: aload 7
    //   179: invokespecial 208	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   182: astore_2
    //   183: iconst_2
    //   184: newarray byte
    //   186: astore 9
    //   188: aload_2
    //   189: aload 9
    //   191: invokevirtual 212	java/io/BufferedInputStream:read	([B)I
    //   194: pop
    //   195: aload 9
    //   197: iconst_0
    //   198: baload
    //   199: bipush 66
    //   201: if_icmpeq +77 -> 278
    //   204: aload 9
    //   206: iconst_1
    //   207: baload
    //   208: istore 4
    //   210: iload 4
    //   212: bipush 77
    //   214: if_icmpeq +64 -> 278
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 215	java/io/BufferedInputStream:close	()V
    //   225: aload 7
    //   227: ifnull +8 -> 235
    //   230: aload 7
    //   232: invokevirtual 216	java/io/FileInputStream:close	()V
    //   235: aload 12
    //   237: iconst_1
    //   238: putfield 200	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   241: aload 11
    //   243: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   246: aload 12
    //   248: invokestatic 222	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   251: pop
    //   252: aload 12
    //   254: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
    //   257: ifeq +11 -> 268
    //   260: aload 12
    //   262: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   265: ifne +169 -> 434
    //   268: new 230	java/io/IOException
    //   271: dup
    //   272: ldc 232
    //   274: invokespecial 233	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   277: athrow
    //   278: aload_2
    //   279: iconst_4
    //   280: newarray byte
    //   282: invokevirtual 212	java/io/BufferedInputStream:read	([B)I
    //   285: pop
    //   286: aload_2
    //   287: ldc2_w 234
    //   290: invokevirtual 239	java/io/BufferedInputStream:skip	(J)J
    //   293: pop2
    //   294: iconst_4
    //   295: newarray byte
    //   297: astore 9
    //   299: aload_2
    //   300: aload 9
    //   302: invokevirtual 212	java/io/BufferedInputStream:read	([B)I
    //   305: pop
    //   306: aload_0
    //   307: aload 9
    //   309: invokevirtual 242	aokn:w	([B)I
    //   312: istore 4
    //   314: iconst_4
    //   315: newarray byte
    //   317: astore 9
    //   319: aload_2
    //   320: aload 9
    //   322: invokevirtual 212	java/io/BufferedInputStream:read	([B)I
    //   325: pop
    //   326: aload_0
    //   327: aload 9
    //   329: invokevirtual 242	aokn:w	([B)I
    //   332: invokestatic 246	java/lang/Math:abs	(I)I
    //   335: istore 5
    //   337: iload 4
    //   339: iflt +13 -> 352
    //   342: iload 4
    //   344: iload 5
    //   346: imul
    //   347: ldc 247
    //   349: if_icmple -132 -> 217
    //   352: invokestatic 251	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   355: invokevirtual 254	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   358: ldc 255
    //   360: invokevirtual 259	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   363: invokestatic 263	aokn:drawableToBitmap	(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    //   366: astore 9
    //   368: aload 9
    //   370: astore_1
    //   371: aload_2
    //   372: ifnull +7 -> 379
    //   375: aload_2
    //   376: invokevirtual 215	java/io/BufferedInputStream:close	()V
    //   379: aload_1
    //   380: astore_2
    //   381: aload 7
    //   383: ifnull -361 -> 22
    //   386: aload 7
    //   388: invokevirtual 216	java/io/FileInputStream:close	()V
    //   391: aload_1
    //   392: areturn
    //   393: aload_2
    //   394: ifnull +7 -> 401
    //   397: aload_2
    //   398: invokevirtual 215	java/io/BufferedInputStream:close	()V
    //   401: aload 7
    //   403: ifnull -168 -> 235
    //   406: aload 7
    //   408: invokevirtual 216	java/io/FileInputStream:close	()V
    //   411: goto -176 -> 235
    //   414: aload_2
    //   415: ifnull +7 -> 422
    //   418: aload_2
    //   419: invokevirtual 215	java/io/BufferedInputStream:close	()V
    //   422: aload 7
    //   424: ifnull +8 -> 432
    //   427: aload 7
    //   429: invokevirtual 216	java/io/FileInputStream:close	()V
    //   432: aload_1
    //   433: athrow
    //   434: aload 12
    //   436: aload 12
    //   438: aload_1
    //   439: getfield 266	com/tencent/image/DownloadParams:reqWidth	I
    //   442: aload_1
    //   443: getfield 269	com/tencent/image/DownloadParams:reqHeight	I
    //   446: invokestatic 275	aoja:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   449: putfield 278	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   452: aload 12
    //   454: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
    //   457: aload 12
    //   459: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   462: imul
    //   463: ldc_w 279
    //   466: if_icmple +55 -> 521
    //   469: ldc 146
    //   471: iconst_1
    //   472: new 148	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 281
    //   482: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload 12
    //   487: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
    //   490: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   493: ldc_w 286
    //   496: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload 12
    //   501: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   504: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: ldc_w 288
    //   510: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 291	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: aconst_null
    //   520: areturn
    //   521: aload 12
    //   523: getfield 228	android/graphics/BitmapFactory$Options:outWidth	I
    //   526: istore 4
    //   528: aload 12
    //   530: getfield 225	android/graphics/BitmapFactory$Options:outHeight	I
    //   533: istore 4
    //   535: aload 12
    //   537: iconst_0
    //   538: putfield 200	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   541: aconst_null
    //   542: astore_2
    //   543: aload 8
    //   545: astore_1
    //   546: iload_3
    //   547: iconst_3
    //   548: if_icmpgt +219 -> 767
    //   551: aload_2
    //   552: astore_1
    //   553: aload 11
    //   555: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   558: aload 12
    //   560: invokestatic 222	com/tencent/image/SafeBitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   563: astore_2
    //   564: aload_2
    //   565: ifnonnull +177 -> 742
    //   568: aload_2
    //   569: astore_1
    //   570: new 22	java/lang/OutOfMemoryError
    //   573: dup
    //   574: new 148	java/lang/StringBuilder
    //   577: dup
    //   578: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   581: ldc_w 293
    //   584: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: aload 10
    //   589: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: ldc_w 295
    //   595: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload_3
    //   599: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   602: ldc_w 297
    //   605: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 11
    //   610: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   613: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   619: invokespecial 298	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   622: athrow
    //   623: astore_2
    //   624: aload_1
    //   625: ifnull +7 -> 632
    //   628: aload_1
    //   629: invokevirtual 301	android/graphics/Bitmap:recycle	()V
    //   632: aload_2
    //   633: ifnull +151 -> 784
    //   636: aload_2
    //   637: invokevirtual 304	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   640: astore_2
    //   641: invokestatic 144	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +77 -> 721
    //   647: ldc 146
    //   649: iconst_2
    //   650: new 148	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   657: ldc_w 306
    //   660: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: iload_3
    //   664: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: ldc_w 308
    //   670: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload 12
    //   675: getfield 278	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   678: invokevirtual 284	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   681: ldc_w 310
    //   684: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload 11
    //   689: invokevirtual 159	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   692: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   695: ldc 161
    //   697: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 10
    //   702: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: ldc_w 312
    //   708: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: aload_2
    //   712: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   718: invokestatic 168	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   721: aload 12
    //   723: aload 12
    //   725: getfield 278	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   728: iconst_2
    //   729: imul
    //   730: putfield 278	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   733: iload_3
    //   734: iconst_1
    //   735: iadd
    //   736: istore_3
    //   737: aload_1
    //   738: astore_2
    //   739: goto -196 -> 543
    //   742: aload_2
    //   743: astore_1
    //   744: getstatic 317	android/os/Build$VERSION:SDK_INT	I
    //   747: bipush 11
    //   749: if_icmplt +16 -> 765
    //   752: aload_2
    //   753: astore_1
    //   754: aload_2
    //   755: invokestatic 323	com/tencent/image/SliceBitmap:needSlice	(Landroid/graphics/Bitmap;)Z
    //   758: istore 6
    //   760: iload 6
    //   762: ifeq +3 -> 765
    //   765: aload_2
    //   766: astore_1
    //   767: aload_1
    //   768: astore_2
    //   769: aload_1
    //   770: ifnonnull -748 -> 22
    //   773: new 230	java/io/IOException
    //   776: dup
    //   777: ldc_w 325
    //   780: invokespecial 233	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   783: athrow
    //   784: aconst_null
    //   785: astore_2
    //   786: goto -145 -> 641
    //   789: astore_1
    //   790: aconst_null
    //   791: astore_2
    //   792: goto -378 -> 414
    //   795: astore_1
    //   796: goto -382 -> 414
    //   799: astore_2
    //   800: aconst_null
    //   801: astore_2
    //   802: goto -409 -> 393
    //   805: astore 9
    //   807: goto -414 -> 393
    //   810: astore_2
    //   811: aconst_null
    //   812: astore_2
    //   813: aconst_null
    //   814: astore 7
    //   816: goto -423 -> 393
    //   819: astore_1
    //   820: aconst_null
    //   821: astore 7
    //   823: aconst_null
    //   824: astore_2
    //   825: goto -411 -> 414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	828	0	this	aokn
    //   0	828	1	paramDownloadParams	DownloadParams
    //   0	828	2	parama	aokn.a
    //   1	736	3	i	int
    //   208	326	4	j	int
    //   335	12	5	k	int
    //   758	3	6	bool	boolean
    //   6	816	7	localFileInputStream	java.io.FileInputStream
    //   3	541	8	localObject1	Object
    //   186	183	9	localObject2	Object
    //   805	1	9	localException	Exception
    //   12	689	10	str	String
    //   33	655	11	localFile	File
    //   110	614	12	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   35	50	100	java/lang/Exception
    //   53	98	100	java/lang/Exception
    //   103	159	100	java/lang/Exception
    //   221	225	100	java/lang/Exception
    //   230	235	100	java/lang/Exception
    //   235	268	100	java/lang/Exception
    //   268	278	100	java/lang/Exception
    //   375	379	100	java/lang/Exception
    //   386	391	100	java/lang/Exception
    //   397	401	100	java/lang/Exception
    //   406	411	100	java/lang/Exception
    //   418	422	100	java/lang/Exception
    //   427	432	100	java/lang/Exception
    //   432	434	100	java/lang/Exception
    //   434	519	100	java/lang/Exception
    //   521	541	100	java/lang/Exception
    //   553	564	100	java/lang/Exception
    //   570	623	100	java/lang/Exception
    //   628	632	100	java/lang/Exception
    //   636	641	100	java/lang/Exception
    //   641	721	100	java/lang/Exception
    //   721	733	100	java/lang/Exception
    //   744	752	100	java/lang/Exception
    //   754	760	100	java/lang/Exception
    //   773	784	100	java/lang/Exception
    //   553	564	623	java/lang/OutOfMemoryError
    //   570	623	623	java/lang/OutOfMemoryError
    //   744	752	623	java/lang/OutOfMemoryError
    //   754	760	623	java/lang/OutOfMemoryError
    //   173	183	789	finally
    //   183	195	795	finally
    //   278	337	795	finally
    //   352	368	795	finally
    //   173	183	799	java/lang/Exception
    //   183	195	805	java/lang/Exception
    //   278	337	805	java/lang/Exception
    //   352	368	805	java/lang/Exception
    //   159	173	810	java/lang/Exception
    //   159	173	819	finally
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_4444);
    Canvas localCanvas = new Canvas(localBitmap);
    paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
    paramDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  public aokn.a a(URL paramURL)
  {
    boolean bool2 = true;
    try
    {
      paramURL = paramURL.getFile().split("\\|");
      aokn.a locala = new aokn.a();
      locala.path = paramURL[0];
      locala.thumbWidth = Integer.parseInt(paramURL[1]);
      locala.thumbHeight = Integer.parseInt(paramURL[2]);
      locala.modifiedDate = Long.parseLong(paramURL[3]);
      if (paramURL.length > 4)
      {
        if (Integer.parseInt(paramURL[4]) == 1)
        {
          bool1 = true;
          locala.cMs = bool1;
        }
      }
      else
      {
        if (paramURL.length > 5)
        {
          if (Integer.parseInt(paramURL[5]) != 1) {
            break label172;
          }
          bool1 = true;
          label106:
          locala.isRound = bool1;
        }
        if (paramURL.length > 6)
        {
          if (Integer.parseInt(paramURL[6]) != 1) {
            break label177;
          }
          bool1 = true;
          label132:
          locala.cMt = bool1;
        }
        if (paramURL.length > 7) {
          if (Integer.parseInt(paramURL[7]) != 1) {
            break label182;
          }
        }
      }
      label172:
      label177:
      label182:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        locala.cMu = bool1;
        return locala;
        bool1 = false;
        break;
        bool1 = false;
        break label106;
        bool1 = false;
        break label132;
      }
      return null;
    }
    catch (Exception paramURL) {}
  }
  
  public File a(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramOutputStream = a(paramDownloadParams.url);
    if ((paramOutputStream == null) || (paramOutputStream.path == null)) {
      return new File(acbn.SDCARD_ROOT);
    }
    return new File(paramOutputStream.path);
  }
  
  public boolean azK()
  {
    return false;
  }
  
  public Object b(DownloadParams paramDownloadParams, aokn.a parama)
    throws Exception
  {
    paramDownloadParams = parama.path;
    if (paramDownloadParams == null) {
      paramDownloadParams = null;
    }
    for (;;)
    {
      return paramDownloadParams;
      File localFile = new File(paramDownloadParams);
      try
      {
        paramDownloadParams = new BitmapFactory.Options();
        paramDownloadParams.inPreferredConfig = aoop.f;
        paramDownloadParams.inDensity = 160;
        paramDownloadParams.inTargetDensity = 160;
        paramDownloadParams.inScreenDensity = 160;
        paramDownloadParams.inJustDecodeBounds = false;
        parama = SafeBitmapFactory.decodeFile(localFile.getAbsolutePath(), paramDownloadParams);
        paramDownloadParams = parama;
        if (parama == null) {
          continue;
        }
        paramDownloadParams = a(parama);
        if (!parama.equals(paramDownloadParams.mBitmap)) {
          parama.recycle();
        }
        parama = new RoundRectBitmap(new aooy(localFile.getAbsolutePath()).Q(paramDownloadParams.mBitmap), paramDownloadParams.mCornerRadius, paramDownloadParams.mBoardColor, paramDownloadParams.mBorderWidth);
        paramDownloadParams = parama;
        if (this.b == null) {
          continue;
        }
        parama.mDisplayWidth = this.b.getResources().getDisplayMetrics().widthPixels;
        parama.mDisplayHeight = this.b.getResources().getDisplayMetrics().heightPixels;
        return parama;
      }
      catch (Exception paramDownloadParams)
      {
        throw paramDownloadParams;
      }
    }
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    paramFile = AlbumThumbManager.getInstance(BaseApplicationImpl.getContext());
    paramURLDrawableHandler = a(paramDownloadParams.url);
    if (paramURLDrawableHandler == null) {
      paramFile = null;
    }
    label107:
    do
    {
      int i;
      do
      {
        return paramFile;
        if (ahav.getFileType(paramURLDrawableHandler.path) == 2) {}
        for (i = 1;; i = 0)
        {
          if ((!paramURLDrawableHandler.cMs) || (paramURLDrawableHandler.cMt) || (i != 0)) {
            break label107;
          }
          if (!paramURLDrawableHandler.cMu) {
            break;
          }
          return b(paramDownloadParams, paramURLDrawableHandler);
        }
        paramDownloadParams = (Bitmap)a(paramDownloadParams, paramURLDrawableHandler);
        paramFile = paramDownloadParams;
      } while (!paramURLDrawableHandler.isRound);
      return ahav.a(this.b, paramDownloadParams, 16);
      if (paramURLDrawableHandler.cMt)
      {
        paramFile = ahap.f(this.b, paramURLDrawableHandler.path);
        if (paramFile != null) {
          paramFile = drawableToBitmap(paramFile);
        }
      }
      for (;;)
      {
        paramDownloadParams = paramFile;
        if (paramFile == null)
        {
          paramFile = BaseApplicationImpl.getContext();
          i = ahav.getFileType(paramURLDrawableHandler.path);
          paramDownloadParams = drawableToBitmap(paramFile.getResources().getDrawable(ahav.hL(i)));
        }
        if (paramDownloadParams != null) {
          break;
        }
        return null;
        paramFile = drawableToBitmap(BaseApplicationImpl.getContext().getResources().getDrawable(2130845117));
        continue;
        paramFile = paramFile.getThumb(paramDownloadParams.url, new aokn.b());
      }
      paramFile = paramDownloadParams;
    } while (!paramURLDrawableHandler.isRound);
    return ahav.a(this.b, paramDownloadParams, 16);
  }
  
  int w(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[3] & 0xFF) << 24 | (paramArrayOfByte[2] & 0xFF) << 16 | (paramArrayOfByte[1] & 0xFF) << 8 | paramArrayOfByte[0] & 0xFF;
  }
  
  class a
  {
    public boolean cMs = false;
    public boolean cMt = false;
    public boolean cMu = false;
    public boolean isRound = false;
    public long modifiedDate;
    public String path;
    public int thumbHeight;
    public int thumbWidth;
    
    public a() {}
  }
  
  class b
    implements aoow
  {
    b() {}
    
    public Bitmap getBitmap(URL paramURL)
    {
      paramURL = aokn.this.a(paramURL);
      if (paramURL == null) {
        return null;
      }
      return ShortVideoUtils.getVideoThumbnail(null, paramURL.path);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aokn
 * JD-Core Version:    0.7.0.1
 */