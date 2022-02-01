import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.JpegCompressor;
import com.tencent.mobileqq.pic.JpegDecompressor;
import com.tencent.mobileqq.pic.JpegOptions;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.pic.CompressInfo;>;

public class akyr
{
  public static Bitmap N(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return paramBitmap;
    }
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      localCanvas.drawColor(-1);
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
      localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
      localPaint.setXfermode(null);
      paramBitmap.recycle();
      paramBitmap = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
    akxe.a("compress.Utils", "compositingWhiteBg()", "compositingWhiteBg is success");
    return paramBitmap;
  }
  
  public static Bitmap a(Bitmap paramBitmap, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    int n = paramBitmap.getWidth();
    int i1 = paramBitmap.getHeight();
    int j;
    int i;
    if (n > i1 * 3.0F)
    {
      j = (int)(i1 * 3.0F);
      i = i1;
    }
    for (;;)
    {
      int k = paramThumbWidthHeightDP.mMinWidth;
      int m = paramThumbWidthHeightDP.mMinHeight;
      int i2 = paramThumbWidthHeightDP.mMaxWidth;
      int i3 = paramThumbWidthHeightDP.mMaxHeight;
      if (j < i)
      {
        if (j >= k) {
          break label444;
        }
        m = (int)(i * k * 1.0F / j);
      }
      for (;;)
      {
        if (i > i3)
        {
          m = (int)(j * i3 * 1.0F / i);
          k = i3;
        }
        for (;;)
        {
          float f = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
          m = (int)(m * f + 0.5F);
          k = (int)(k * f + 0.5F);
          try
          {
            paramThumbWidthHeightDP = Bitmap.createBitmap(m, k, paramBitmap.getConfig());
            paramThumbWidthHeightDP.setDensity(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().densityDpi);
            Paint localPaint = new Paint(1);
            localPaint.setColor(-16777216);
            QLog.d("compress.Utils", 1, "clip w=" + n + ", h=" + i1 + ", wClip=" + j + ", hClip=" + i + ", dstW=" + m + ", dstH=" + k);
            new Canvas(paramThumbWidthHeightDP).drawBitmap(paramBitmap, new Rect(0, 0, j, i), new Rect(0, 0, m, k), localPaint);
            return paramThumbWidthHeightDP;
          }
          catch (OutOfMemoryError paramThumbWidthHeightDP)
          {
            QLog.e("compress.Utils", 1, "OutOfMemoryError", paramThumbWidthHeightDP);
            return paramBitmap;
          }
          catch (Exception paramThumbWidthHeightDP)
          {
            QLog.e("compress.Utils", 1, "Exception", paramThumbWidthHeightDP);
            return paramBitmap;
          }
          if (i1 <= n * 3.0F) {
            break label454;
          }
          i = (int)(n * 3.0F);
          j = n;
          break;
          if (i < m)
          {
            i3 = (int)(j * m * 1.0F / i);
            k = m;
          }
          for (m = i3;; m = j)
          {
            if (j > i2)
            {
              k = (int)(i * i2 * 1.0F / j);
              m = i2;
              break;
            }
            break;
            k = i;
          }
          i2 = k;
          k = m;
          m = i2;
        }
        label444:
        m = i;
        k = j;
      }
      label454:
      i = i1;
      j = n;
    }
  }
  
  public static boolean a(Bitmap paramBitmap, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
  {
    boolean bool = false;
    int i;
    int j;
    if (paramThumbWidthHeightDP != null)
    {
      i = paramThumbWidthHeightDP.maxPx();
      if (paramThumbWidthHeightDP == null) {
        break label162;
      }
      j = paramThumbWidthHeightDP.minPx();
      label27:
      if (paramInt != 1) {
        break label171;
      }
      j = ahbh.maxSize;
      i = ahbh.cZc;
    }
    for (;;)
    {
      label43:
      if (paramBoolean) {}
      for (int k = aoop.eI(paramString1);; k = 0)
      {
        akxe.a("compress.Utils", paramString3, paramString4 + " ClipStrategy begin  thumbSizeMax：" + j + " thumbSizeMin:" + i + " degree:" + k);
        if (paramThumbWidthHeightDP != null)
        {
          paramBitmap = a(paramBitmap, paramThumbWidthHeightDP);
          label117:
          if (paramBitmap != null) {
            break label254;
          }
          akxe.a("compress.Utils", paramString3, paramString4 + " ClipStrategy fail");
          paramBoolean = bool;
        }
        label162:
        label171:
        label254:
        do
        {
          return paramBoolean;
          i = aoop.G(false);
          break;
          j = aoop.H(false);
          break label27;
          if (paramInt != 2) {
            break label381;
          }
          j = ahbh.cZb;
          i = ahbh.cZd;
          break label43;
          paramString1 = new akyi(j, i, k);
          paramBitmap = paramString1.K(paramBitmap);
          akxe.a("compress.Utils", paramString3, " needCut:" + paramString1.cvq + " needScale:" + paramString1.cvr);
          break label117;
          akxe.a("compress.Utils", paramString3, paramString4 + " ClipStrategy suc  destWidth：" + paramBitmap.getWidth() + " destHeight:" + paramBitmap.getHeight());
          paramBitmap = N(paramBitmap);
          if (paramInt == 3)
          {
            paramBoolean = f(paramBitmap);
            akxe.a("compress.Utils", paramString3, paramString4 + " isDrawGIFSucc：" + paramBoolean);
          }
          bool = a(paramString2, paramBitmap, 70, paramString4, null);
          paramBoolean = bool;
        } while (paramBitmap == null);
        paramBitmap.recycle();
        return bool;
      }
      label381:
      k = i;
      i = j;
      j = k;
    }
  }
  
  private static boolean a(BitmapFactory.Options paramOptions, int paramInt)
  {
    if (paramOptions == null)
    {
      akxe.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramOptions.outWidth;
    int n = paramOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      akxe.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramOptions.inSampleSize;; paramInt = 1)
    {
      paramOptions.inSampleSize = paramInt;
      akxe.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  public static boolean a(BitmapFactory.Options paramOptions, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramOptions == null) || (TextUtils.isEmpty(paramString)))
    {
      akxe.b("compress.Utils", "calculateInSampleSize()", "options == null || TextUtils.isEmpty(filepath)");
      return false;
    }
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 < paramInt2)) {
      throw new IllegalArgumentException("max < 0 || min < 0 || max < min");
    }
    if (paramInt2 > paramInt1 / 2) {
      throw new IllegalArgumentException("min > max / 2");
    }
    paramOptions.inJustDecodeBounds = true;
    aqhu.d(paramString, paramOptions);
    int i = paramOptions.outHeight;
    int j = paramOptions.outWidth;
    if (j > i)
    {
      i = j;
      if (i > paramInt1)
      {
        j = 1;
        int k;
        int m;
        do
        {
          do
          {
            k = i >> 1;
            m = j * 2;
            i = k;
            j = m;
          } while (k < paramInt2);
          i = k;
          j = m;
        } while (k > paramInt1);
        paramOptions.inSampleSize = m;
      }
      paramOptions.inJustDecodeBounds = false;
      if (paramOptions.inSampleSize < 1) {
        break label214;
      }
    }
    label214:
    for (paramInt1 = paramOptions.inSampleSize;; paramInt1 = 1)
    {
      paramOptions.inSampleSize = paramInt1;
      akxe.a("compress.Utils", "calculateInSampleSize()", "options.inSampleSize=" + paramOptions.inSampleSize);
      return true;
      break;
    }
  }
  
  private static boolean a(JpegOptions paramJpegOptions, int paramInt)
  {
    if (paramJpegOptions == null)
    {
      akxe.b("compress.Utils", "calculateInSampleSizeThumbnail()", "options is null");
      return false;
    }
    int m = paramJpegOptions.outWidth;
    int n = paramJpegOptions.outHeight;
    if ((m == 0) || (n == 0))
    {
      akxe.b("compress.Utils", "calculateInSampleSizeThumbnail()", "width == 0 || height ==0");
      return false;
    }
    int j = n;
    int k = m;
    int i = 1;
    k >>= 1;
    j >>= 1;
    if ((k < paramInt) || (j < paramInt))
    {
      paramJpegOptions.inSampleSize = i;
      paramJpegOptions.inJustDecodeBounds = false;
      if (paramJpegOptions.inSampleSize < 1) {
        break label172;
      }
    }
    label172:
    for (paramInt = paramJpegOptions.inSampleSize;; paramInt = 1)
    {
      paramJpegOptions.inSampleSize = paramInt;
      akxe.a("compress.Utils", "calculateInSampleSizeThumbnail()", "options.inSampleSize=" + paramJpegOptions.inSampleSize + " srcWidth:" + m + " srcHeight:" + n);
      return true;
      i *= 2;
      break;
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: aload_0
    //   4: invokestatic 304	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7: ifne +17 -> 24
    //   10: aload_1
    //   11: ifnull +13 -> 24
    //   14: iload_2
    //   15: bipush 100
    //   17: if_icmpgt +7 -> 24
    //   20: iload_2
    //   21: ifgt +37 -> 58
    //   24: ldc 66
    //   26: ldc_w 337
    //   29: new 140	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   36: aload_3
    //   37: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc_w 339
    //   43: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   52: iconst_0
    //   53: istore 5
    //   55: iload 5
    //   57: ireturn
    //   58: ldc 66
    //   60: ldc_w 337
    //   63: new 140	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   70: aload_3
    //   71: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 341
    //   77: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: iload_2
    //   81: invokevirtual 150	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 76	akxe:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   90: new 343	java/io/File
    //   93: dup
    //   94: aload_0
    //   95: invokespecial 344	java/io/File:<init>	(Ljava/lang/String;)V
    //   98: astore 6
    //   100: aload 6
    //   102: invokevirtual 348	java/io/File:exists	()Z
    //   105: ifeq +9 -> 114
    //   108: aload 6
    //   110: invokevirtual 351	java/io/File:delete	()Z
    //   113: pop
    //   114: aload_0
    //   115: invokestatic 357	aqhq:createFile	(Ljava/lang/String;)Ljava/io/File;
    //   118: pop
    //   119: new 359	java/io/FileOutputStream
    //   122: dup
    //   123: aload 6
    //   125: invokespecial 362	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   128: astore 8
    //   130: new 364	java/io/BufferedOutputStream
    //   133: dup
    //   134: aload 8
    //   136: invokespecial 367	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   139: astore 7
    //   141: aload 7
    //   143: astore 6
    //   145: aload_1
    //   146: getstatic 373	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   149: iload_2
    //   150: aload 7
    //   152: invokevirtual 377	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   155: pop
    //   156: aload 7
    //   158: astore 6
    //   160: aload 7
    //   162: invokevirtual 380	java/io/BufferedOutputStream:flush	()V
    //   165: aload 7
    //   167: astore 6
    //   169: aload 8
    //   171: invokevirtual 384	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   174: astore_1
    //   175: aload_1
    //   176: ifnull +22 -> 198
    //   179: aload 7
    //   181: astore 6
    //   183: aload_1
    //   184: invokevirtual 389	java/io/FileDescriptor:valid	()Z
    //   187: ifeq +11 -> 198
    //   190: aload 7
    //   192: astore 6
    //   194: aload_1
    //   195: invokevirtual 392	java/io/FileDescriptor:sync	()V
    //   198: aload 7
    //   200: ifnull +8 -> 208
    //   203: aload 7
    //   205: invokevirtual 395	java/io/BufferedOutputStream:close	()V
    //   208: aload_0
    //   209: invokestatic 399	aqhq:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   212: ifne -157 -> 55
    //   215: ldc 66
    //   217: ldc_w 337
    //   220: new 140	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   227: aload_3
    //   228: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: ldc_w 401
    //   234: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   243: iconst_0
    //   244: ireturn
    //   245: astore_1
    //   246: aload 4
    //   248: ifnull +13 -> 261
    //   251: aload 7
    //   253: astore 6
    //   255: aload 4
    //   257: iconst_1
    //   258: invokevirtual 407	com/tencent/mobileqq/pic/CompressInfo:Ns	(Z)V
    //   261: aload 7
    //   263: astore 6
    //   265: ldc 66
    //   267: ldc_w 337
    //   270: ldc_w 409
    //   273: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   276: goto -78 -> 198
    //   279: astore_0
    //   280: aload 7
    //   282: astore 6
    //   284: ldc 66
    //   286: ldc_w 337
    //   289: new 140	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   296: aload_3
    //   297: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: ldc_w 411
    //   303: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   312: aload 7
    //   314: astore 6
    //   316: aload_0
    //   317: invokevirtual 412	java/io/FileNotFoundException:printStackTrace	()V
    //   320: aload 7
    //   322: ifnull +8 -> 330
    //   325: aload 7
    //   327: invokevirtual 395	java/io/BufferedOutputStream:close	()V
    //   330: iconst_0
    //   331: ireturn
    //   332: astore_1
    //   333: aload 4
    //   335: ifnull +13 -> 348
    //   338: aload 7
    //   340: astore 6
    //   342: aload 4
    //   344: iconst_1
    //   345: invokevirtual 407	com/tencent/mobileqq/pic/CompressInfo:Ns	(Z)V
    //   348: aload 7
    //   350: astore 6
    //   352: ldc 66
    //   354: ldc_w 337
    //   357: ldc_w 414
    //   360: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -165 -> 198
    //   366: astore_0
    //   367: aload 7
    //   369: astore 6
    //   371: ldc 66
    //   373: ldc_w 337
    //   376: new 140	java/lang/StringBuilder
    //   379: dup
    //   380: invokespecial 141	java/lang/StringBuilder:<init>	()V
    //   383: aload_3
    //   384: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: ldc_w 416
    //   390: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 275	akxe:b	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    //   399: aload 7
    //   401: astore 6
    //   403: aload_0
    //   404: invokevirtual 417	java/lang/Exception:printStackTrace	()V
    //   407: aload 7
    //   409: ifnull +8 -> 417
    //   412: aload 7
    //   414: invokevirtual 395	java/io/BufferedOutputStream:close	()V
    //   417: iconst_0
    //   418: ireturn
    //   419: astore_1
    //   420: aload_1
    //   421: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   424: goto -216 -> 208
    //   427: astore_0
    //   428: aload_0
    //   429: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   432: goto -102 -> 330
    //   435: astore_0
    //   436: aload_0
    //   437: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   440: goto -23 -> 417
    //   443: astore_0
    //   444: aconst_null
    //   445: astore 6
    //   447: aload 6
    //   449: ifnull +8 -> 457
    //   452: aload 6
    //   454: invokevirtual 395	java/io/BufferedOutputStream:close	()V
    //   457: aload_0
    //   458: athrow
    //   459: astore_1
    //   460: aload_1
    //   461: invokevirtual 418	java/io/IOException:printStackTrace	()V
    //   464: goto -7 -> 457
    //   467: astore_0
    //   468: goto -21 -> 447
    //   471: astore_0
    //   472: aconst_null
    //   473: astore 7
    //   475: goto -108 -> 367
    //   478: astore_0
    //   479: aconst_null
    //   480: astore 7
    //   482: goto -202 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramString1	String
    //   0	485	1	paramBitmap	Bitmap
    //   0	485	2	paramInt	int
    //   0	485	3	paramString2	String
    //   0	485	4	paramCompressInfo	CompressInfo
    //   1	55	5	bool	boolean
    //   98	355	6	localObject	Object
    //   139	342	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   128	42	8	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   160	165	245	java/io/SyncFailedException
    //   169	175	245	java/io/SyncFailedException
    //   183	190	245	java/io/SyncFailedException
    //   194	198	245	java/io/SyncFailedException
    //   145	156	279	java/io/FileNotFoundException
    //   160	165	279	java/io/FileNotFoundException
    //   169	175	279	java/io/FileNotFoundException
    //   183	190	279	java/io/FileNotFoundException
    //   194	198	279	java/io/FileNotFoundException
    //   255	261	279	java/io/FileNotFoundException
    //   265	276	279	java/io/FileNotFoundException
    //   342	348	279	java/io/FileNotFoundException
    //   352	363	279	java/io/FileNotFoundException
    //   160	165	332	java/io/IOException
    //   169	175	332	java/io/IOException
    //   183	190	332	java/io/IOException
    //   194	198	332	java/io/IOException
    //   145	156	366	java/lang/Exception
    //   160	165	366	java/lang/Exception
    //   169	175	366	java/lang/Exception
    //   183	190	366	java/lang/Exception
    //   194	198	366	java/lang/Exception
    //   255	261	366	java/lang/Exception
    //   265	276	366	java/lang/Exception
    //   342	348	366	java/lang/Exception
    //   352	363	366	java/lang/Exception
    //   203	208	419	java/io/IOException
    //   325	330	427	java/io/IOException
    //   412	417	435	java/io/IOException
    //   114	141	443	finally
    //   452	457	459	java/io/IOException
    //   145	156	467	finally
    //   160	165	467	finally
    //   169	175	467	finally
    //   183	190	467	finally
    //   194	198	467	finally
    //   255	261	467	finally
    //   265	276	467	finally
    //   284	312	467	finally
    //   316	320	467	finally
    //   342	348	467	finally
    //   352	363	467	finally
    //   371	399	467	finally
    //   403	407	467	finally
    //   114	141	471	java/lang/Exception
    //   114	141	478	java/io/FileNotFoundException
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
    throws Exception
  {
    return a(paramString1, paramString2, paramBoolean, paramString3, paramInt, null);
  }
  
  public static boolean a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt, ThumbWidthHeightDP paramThumbWidthHeightDP)
    throws Exception
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!aqhq.fileExistsAndNotEmpty(paramString1)))
    {
      akxe.b("compress.Utils", "compressAIOThumbnail", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    akxe.a("compress.Utils", "compressAIOThumbnail", paramString3);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    aqhu.d(paramString1, localOptions);
    int i;
    label135:
    label146:
    int j;
    if (localOptions.outWidth > localOptions.outHeight)
    {
      i = localOptions.outWidth;
      i = localOptions.outHeight;
      if (paramThumbWidthHeightDP == null) {
        break label219;
      }
      i = paramThumbWidthHeightDP.maxPx();
      if (paramThumbWidthHeightDP == null) {
        break label228;
      }
      paramThumbWidthHeightDP.minPx();
      if (paramInt != 1) {
        break label236;
      }
      i = ahbh.maxSize;
      j = ahbh.cZc;
    }
    for (;;)
    {
      if (a(localOptions, i)) {
        break label255;
      }
      akxe.b("compress.Utils", "compressAIOThumbnail", paramString3 + " calculateInSampleSize fail");
      return false;
      i = localOptions.outHeight;
      i = localOptions.outWidth;
      break;
      label219:
      i = aoop.G(false);
      break label135;
      label228:
      aoop.H(false);
      break label146;
      label236:
      if (paramInt == 2)
      {
        i = ahbh.cZb;
        j = ahbh.cZd;
      }
    }
    try
    {
      label255:
      Bitmap localBitmap3 = SafeBitmapFactory.safeDecode(paramString1, localOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        akxe.b("compress.Utils", "compressAIOThumbnail", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      akxe.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError");
      localOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = aqhu.d(paramString1, localOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        akxe.a("compress.Utils", "compressAIOThumbnail", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, paramBoolean, paramString1, paramString2, "compressAIOThumbnail", paramString3, paramInt, paramThumbWidthHeightDP);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        akxe.b("compress.Utils", "compressAIOThumbnail", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localOptions.inSampleSize);
      }
    }
    return false;
  }
  
  public static String as(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aqhq.fileExists(paramString)) && (akyk.isLegal(paramInt)))
    {
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      Object localObject;
      String str;
      StringBuffer localStringBuffer;
      if ((j <= 0) || (j <= i))
      {
        localObject = paramString.substring(i + 1);
        long l = new File(paramString).lastModified();
        str = aoqr.oz(acbn.SDCARD_PATH + "photo/");
        localStringBuffer = new StringBuffer();
        localStringBuffer.append(str);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append((String)localObject);
        localStringBuffer.append("_").append(l);
        localObject = localStringBuffer.append("_");
        if (!isWifi()) {
          break label246;
        }
      }
      label246:
      for (paramString = "wifi";; paramString = "xg")
      {
        ((StringBuffer)localObject).append(paramString);
        localStringBuffer.append("_").append(paramInt);
        localStringBuffer.append(".jpg");
        paramString = new File(str);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        localObject = paramString.substring(i + 1, j);
        break;
      }
    }
    akxe.a("compress.Utils", "getSendPhotoPath()", "realpath is empty, or file does not exist, or picQuality Illegal realpath:" + paramString + " picQuality:" + paramInt);
    return "";
  }
  
  public static boolean asY()
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 2) {
      return false;
    }
    return localObject[1].equals("1");
  }
  
  public static boolean asZ()
  {
    Object localObject = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.pg_switch.name(), "1|1|1");
    if (QLog.isDevelopLevel()) {
      QLog.d("peak_pgjpeg", 4, "DeviceProfileManager.DpcNames.pg_switch value " + (String)localObject);
    }
    localObject = ((String)localObject).split("\\|");
    if (localObject.length < 1) {
      return false;
    }
    return localObject[0].equals("1");
  }
  
  public static boolean b(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if (asZ()) {
      return c(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
    }
    return a(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
  }
  
  public static boolean b(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
    throws Exception
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (!aqhq.fileExistsAndNotEmpty(paramString1)))
    {
      akxe.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " infilePath is empty, or outfilePath is empty, or file does not exist. infilePath:" + paramString1 + " outfilePath:" + paramString2);
      return false;
    }
    akxe.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3);
    JpegOptions localJpegOptions = new JpegOptions();
    localJpegOptions.inJustDecodeBounds = true;
    JpegDecompressor.decodeFile(paramString1, localJpegOptions);
    int i;
    int j;
    if (localJpegOptions.outWidth > localJpegOptions.outHeight)
    {
      i = localJpegOptions.outWidth;
      i = localJpegOptions.outHeight;
      i = aoop.G(false);
      aoop.H(false);
      if (paramInt != 1) {
        break label207;
      }
      i = ahbh.maxSize;
      j = ahbh.cZc;
    }
    for (;;)
    {
      if (a(localJpegOptions, i)) {
        break label226;
      }
      akxe.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " calculateInSampleSize fail");
      return false;
      i = localJpegOptions.outHeight;
      i = localJpegOptions.outWidth;
      break;
      label207:
      if (paramInt == 2)
      {
        i = ahbh.cZb;
        j = ahbh.cZd;
      }
    }
    try
    {
      label226:
      Bitmap localBitmap3 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
      Bitmap localBitmap1 = localBitmap3;
      if (localBitmap3 == null)
      {
        akxe.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " bm == null, maybe is broken");
        return false;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      akxe.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError");
      localJpegOptions.inSampleSize *= 2;
      try
      {
        Bitmap localBitmap2 = JpegDecompressor.decodeFile(paramString1, localJpegOptions);
        i = localBitmap2.getWidth();
        j = localBitmap2.getHeight();
        akxe.a("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " sample after W:" + i + " H:" + j);
        return a(localBitmap2, paramBoolean, paramString1, paramString2, "compressAIOThumbnailWithTrubo", paramString3, paramInt, null);
      }
      catch (OutOfMemoryError paramString1)
      {
        paramString1.printStackTrace();
        akxe.b("compress.Utils", "compressAIOThumbnailWithTrubo", paramString3 + " decodeFile OutOfMemoryError, op.inSampleSize:" + localJpegOptions.inSampleSize);
      }
    }
    return false;
  }
  
  private static boolean c(String paramString1, Bitmap paramBitmap, int paramInt, String paramString2, CompressInfo paramCompressInfo)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramBitmap == null) || (paramInt > 100) || (paramInt <= 0))
    {
      akxe.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " TextUtils.isEmpty(destPath) || bm == null || quality > 100 || quality <= 0");
      return false;
    }
    akxe.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    try
    {
      ((File)localObject).createNewFile();
      localObject = new JpegCompressor(new akys((File)localObject, paramCompressInfo));
      ((JpegCompressor)localObject).setParams(paramInt, true, true, false);
      try
      {
        aqip.beginPile();
        ((JpegCompressor)localObject).compress(paramBitmap);
        aqip.endPile("peak_pgjpeg", "pgjpeg " + paramBitmap.getWidth() + "x" + paramBitmap.getHeight() + " compress");
        akxe.a("compress.Utils", "compressQualityWithProgressive()", paramString2 + " quality:" + paramInt);
        return true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("peak_pgjpeg", 2, "JpegCompressor.compress() error", localException);
        }
        return a(paramString1, paramBitmap, paramInt, paramString2, paramCompressInfo);
      }
      return false;
    }
    catch (FileNotFoundException paramString1)
    {
      akxe.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " FileOutputStream FileNotFoundException");
      paramString1.printStackTrace();
      return false;
    }
    catch (IOException paramString1)
    {
      akxe.b("compress.Utils", "compressQualityWithProgressive()", paramString2 + " createNewFile IOException");
      paramString1.printStackTrace();
    }
  }
  
  public static void d(Context paramContext, List<CompressInfo> paramList)
  {
    int k = 1;
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    int j;
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    String str6;
    Object localObject1;
    Object localObject2;
    if (paramList.size() > 1)
    {
      j = 1;
      str1 = BaseApplication.getContext().getString(2131691941);
      str2 = BaseApplication.getContext().getString(2131691942);
      str3 = BaseApplication.getContext().getString(2131691937);
      str4 = BaseApplication.getContext().getString(2131691938);
      str5 = BaseApplication.getContext().getString(2131691939);
      str6 = BaseApplication.getContext().getString(2131691940);
      localObject1 = BaseApplication.getContext().getString(2131691944);
      localObject2 = BaseApplication.getContext().getString(2131691945);
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          CompressInfo localCompressInfo = (CompressInfo)localIterator.next();
          if ((localCompressInfo != null) && (localCompressInfo.cuO)) {
            if (j != 0) {
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label168:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localObject2 = (CompressInfo)paramList.next();
          if ((localObject2 != null) && (!((CompressInfo)localObject2).cuQ) && (((CompressInfo)localObject2).cuN)) {
            if (str3.equals(((CompressInfo)localObject2).bUC))
            {
              if (str3.equals(localObject1)) {
                break label388;
              }
              if (j != 0)
              {
                paramList = str4;
                i = k;
              }
            }
          }
        }
      }
      for (;;)
      {
        label255:
        if (i == 0) {
          break label412;
        }
        QQToast.a(paramContext, paramList, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        return;
        j = 0;
        break;
        break label168;
        paramList = str3;
        i = k;
        continue;
        if (str1.equals(((CompressInfo)localObject2).bUC)) {
          if (!str1.equals(localObject1))
          {
            if (j != 0)
            {
              paramList = str2;
              i = k;
              continue;
            }
            paramList = str1;
            i = k;
            continue;
            if ((localObject2 != null) && (((CompressInfo)localObject2).cuQ) && (((CompressInfo)localObject2).cuN))
            {
              if (j != 0)
              {
                paramList = str6;
                i = k;
                continue;
              }
              paramList = str5;
              i = k;
              continue;
            }
          }
        }
        for (;;)
        {
          break;
          paramList = (List<CompressInfo>)localObject1;
          i = k;
          break label255;
          i = 1;
        }
        paramList = (List<CompressInfo>)localObject1;
        continue;
        paramList = (List<CompressInfo>)localObject1;
      }
      break;
      localObject1 = "";
    }
  }
  
  public static boolean f(Bitmap paramBitmap)
  {
    try
    {
      Bitmap localBitmap = xkl.am();
      if (localBitmap == null) {
        return false;
      }
      int i = localBitmap.getWidth() / 2;
      int j = localBitmap.getHeight() / 2;
      int m = paramBitmap.getWidth();
      int k = paramBitmap.getHeight();
      m = m - i - 7;
      k = k - j - 7;
      if ((m > 0) && (k > 0))
      {
        paramBitmap = new Canvas(paramBitmap);
        Paint localPaint = new Paint(2);
        paramBitmap.drawBitmap(localBitmap, null, new Rect(m, k, i + m, j + k), localPaint);
      }
      return true;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
    return false;
  }
  
  public static long getFileSize(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!aqhq.fileExistsAndNotEmpty(paramString)))
    {
      akxe.b("compress.Utils", "getFileSize()", "path is empty, or file does not exist. path:" + paramString);
      return 0L;
    }
    return new File(paramString).length();
  }
  
  public static boolean isWifi()
  {
    return aqiw.getNetworkType(BaseApplication.getContext()) == 1;
  }
  
  public static boolean lP(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      boolean bool = GifDrawable.isGifFile(new File(paramString));
      if (QLog.isColorLevel()) {
        QLog.d("_photo", 2, "isGifFile result:" + bool);
      }
      return bool;
    }
    return false;
  }
  
  public static String mG(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (aqhq.fileExists(paramString)))
    {
      String str2 = aoqr.oz(acbn.SDCARD_PATH + "thumb/");
      if (paramString.startsWith(str2)) {
        return paramString;
      }
      int i = paramString.lastIndexOf("/");
      int j = paramString.lastIndexOf(".");
      String str1;
      if (j <= 0) {
        str1 = paramString.substring(i + 1);
      }
      for (;;)
      {
        long l = new File(paramString).lastModified();
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(str2);
        localStringBuffer.append("_").append(paramString.hashCode());
        localStringBuffer.append("_").append(str1);
        localStringBuffer.append("_").append(l);
        localStringBuffer.append(".jpg");
        paramString = new File(str2);
        if (!paramString.exists()) {
          paramString.mkdirs();
        }
        return localStringBuffer.toString();
        if (i < j + 1) {
          str1 = paramString.substring(i + 1, j);
        } else {
          str1 = paramString.substring(i + 1);
        }
      }
    }
    akxe.a("compress.Utils", "getThumbnailPath()", "realpath is empty, or file does not exist, realpath:" + paramString);
    return "";
  }
  
  public static boolean nT(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (aqhq.fileExistsAndNotEmpty(paramString))
    {
      bool1 = bool3;
      if (!aqhq.estimateFileType(paramString).equals("jpg")) {}
    }
    try
    {
      float f = JpegCompressor.getJpegQuality(paramString);
      long l = aqhq.getFileSizes(paramString);
      bool1 = bool2;
      if (f <= 80.0F)
      {
        bool1 = bool2;
        if (l < 307200L) {
          bool1 = true;
        }
      }
      akxe.a("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality = " + f + ",picSize = " + l + "result = " + bool1);
      return bool1;
    }
    catch (RuntimeException paramString)
    {
      akxe.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality RuntimeException error = " + paramString + ",return false!");
      return false;
    }
    catch (OutOfMemoryError paramString)
    {
      akxe.b("compress.Utils", "isMatchQualityAndSizeCondition()", "getJpegQuality OutOfMemoryError error = " + paramString + ",return false!");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akyr
 * JD-Core Version:    0.7.0.1
 */