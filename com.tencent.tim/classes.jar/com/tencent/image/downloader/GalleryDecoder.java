package com.tencent.image.downloader;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.image.DownloadParams;
import com.tencent.image.JpegExifReader;
import com.tencent.image.LocaleFileDownloader;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.image.SliceBitmap;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.VideoDrawable;
import com.tencent.image.utils.PicFormatUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class GalleryDecoder
  extends LocaleFileDownloader
{
  public static final int DECODE_TYPE_GALLERY = 1;
  public static final int DECODE_TYPE_NORMAL = 0;
  public static final int DECODE_TYPE_NOSAMPLE = 2;
  public static final int DECODE_TYPE_VIDEO = 3;
  private static final int FILE_LENGTH_LIMIT = 5242880;
  private static final float HEIGHER_IMGE_FACTOR = 1.5F;
  private static final String TAG = "GalleryDecoder";
  private float density;
  private Context mContext;
  
  public GalleryDecoder(Context paramContext)
  {
    this.mContext = paramContext;
    this.density = paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int calculateSampleSize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (((paramInt6 == 2) || (paramInt3 == 2147483647) || (paramInt4 == 2147483647)) && (paramInt1 * paramInt2 <= this.mContext.getResources().getDisplayMetrics().widthPixels * this.mContext.getResources().getDisplayMetrics().heightPixels * 4))
    {
      paramInt2 = 1;
      return paramInt2;
    }
    float f;
    if (paramInt6 == 1) {
      switch (paramInt5)
      {
      default: 
        paramInt5 = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = paramInt5;
        paramInt6 = paramInt1;
        paramInt5 = paramInt2;
        if (paramInt2 > paramInt3 * 2)
        {
          paramInt6 = paramInt1;
          paramInt5 = paramInt2;
          if (paramInt1 > paramInt4)
          {
            paramInt5 = (int)(paramInt2 * this.density + 0.5D);
            paramInt6 = (int)(paramInt1 * this.density + 0.5D);
          }
        }
        paramInt1 = paramInt6 * paramInt3 / paramInt5;
        if (paramInt5 >= paramInt3) {
          if (paramInt4 >= paramInt1) {
            f = paramInt3 / paramInt5;
          }
        }
        break;
      }
    }
    for (;;)
    {
      label187:
      if (this.density > 2.0F) {}
      for (paramInt1 = (int)(1.0F / f * 3.0F / 4.0F);; paramInt1 = (int)(1.0F / f))
      {
        if (paramInt1 > 1) {
          break label355;
        }
        return 1;
        break;
        if (paramInt4 * 1.5F >= paramInt1)
        {
          f = paramInt4 / paramInt6;
          break label187;
        }
        f = paramInt3 / paramInt5;
        break label187;
        if (paramInt6 < paramInt4)
        {
          if (paramInt4 >= paramInt1)
          {
            if (paramInt5 * 1.5F < paramInt3) {
              break label519;
            }
            f = paramInt3 / paramInt5;
            break label187;
          }
          if (paramInt6 * 1.5F < paramInt4) {
            break label519;
          }
          f = paramInt4 / paramInt6;
          break label187;
        }
        if ((paramInt6 <= paramInt4) || (paramInt6 >= paramInt4 * 1.5F)) {
          break label519;
        }
        f = paramInt4 / paramInt6;
        break label187;
      }
      label355:
      if (paramInt1 > 64)
      {
        if (QLog.isColorLevel()) {
          QLog.d(getLogTag(), 2, "the pic it fxxking large.....");
        }
        return 64;
      }
      paramInt3 = 64;
      for (;;)
      {
        if (paramInt3 == 0) {
          break label407;
        }
        paramInt4 = paramInt1 & paramInt3;
        paramInt2 = paramInt4;
        if (paramInt4 != 0) {
          break;
        }
        paramInt3 >>= 1;
      }
      label407:
      return 1;
      if ((paramInt3 == 0) || (paramInt4 == 0) || (paramInt3 == -1) || (paramInt4 == -1)) {
        return 1;
      }
      int i = 1;
      paramInt5 = paramInt2;
      paramInt6 = paramInt1;
      paramInt1 = i;
      label443:
      if (paramInt5 <= paramInt4)
      {
        paramInt2 = paramInt1;
        if (paramInt6 <= paramInt3) {
          break;
        }
      }
      i = Math.round(paramInt5 / paramInt4);
      paramInt2 = Math.round(paramInt6 / paramInt3);
      if (i > paramInt2) {}
      for (;;)
      {
        paramInt2 = paramInt1;
        if (i < 2) {
          break;
        }
        paramInt6 /= 2;
        paramInt5 /= 2;
        paramInt1 *= 2;
        break label443;
        i = paramInt2;
      }
      label519:
      f = 1.0F;
    }
  }
  
  private Object decodeFileNormal(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
    throws Exception
  {
    paramURLDrawableHandler = new FileInputStream(paramFile);
    Object localObject2 = null;
    try
    {
      localObject1 = new byte[2];
      paramURLDrawableHandler.read((byte[])localObject1);
      k = localObject1[0];
      m = localObject1[1];
      paramURLDrawableHandler.close();
      localObject1 = new FileInputStream(paramFile);
    }
    finally
    {
      for (;;)
      {
        int k;
        int m;
        label132:
        BitmapFactory.Options localOptions;
        paramDownloadParams = paramURLDrawableHandler;
        paramInt = 0;
      }
    }
    try
    {
      paramURLDrawableHandler = Bitmap.Config.ARGB_8888;
      i = 0;
      j = 0;
      switch (k << 8 & 0xFF00 | m & 0xFF)
      {
      }
    }
    finally
    {
      paramInt = 0;
      paramDownloadParams = (DownloadParams)localObject1;
      break label731;
      paramURLDrawableHandler = null;
      break label377;
      i = j;
      break label132;
    }
    localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inPreferredConfig = paramURLDrawableHandler;
    localOptions.inDensity = 160;
    localOptions.inTargetDensity = 160;
    localOptions.inScreenDensity = 160;
    SafeBitmapFactory.decodeStream((InputStream)localObject1, null, localOptions);
    j = localOptions.outWidth;
    k = localOptions.outHeight;
    ((InputStream)localObject1).close();
    if (i != 0) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap;
        for (;;)
        {
          paramDownloadParams.outOrientation = JpegExifReader.readOrientation(paramFile.getAbsolutePath());
          localOptions.inJustDecodeBounds = false;
          paramInt = calculateSampleSize(j, k, paramDownloadParams.reqWidth, paramDownloadParams.reqHeight, paramDownloadParams.outOrientation, paramInt);
          i = 1;
          paramURLDrawableHandler = localObject2;
          if (i <= 3) {}
          try
          {
            localOptions.inSampleSize = paramInt;
            paramURLDrawableHandler = new SafeBitmapFactory.SafeDecodeOption();
            paramURLDrawableHandler.inOptions = localOptions;
            paramURLDrawableHandler.inNeedFlashBackTest = URLDrawable.isPublicVersion;
            localBitmap = SafeBitmapFactory.safeDecode(paramFile.getAbsolutePath(), paramURLDrawableHandler);
            if (QLog.isColorLevel()) {
              QLog.d(getLogTag(), 2, "GalleryDecoder regionDecodeInfo:" + paramURLDrawableHandler.toString());
            }
            reportSafeDecode(paramURLDrawableHandler);
            localBitmap.setDensity(160);
            boolean bool = SliceBitmap.needSliceBitmap(localBitmap);
            if (bool)
            {
              try
              {
                paramURLDrawableHandler = new SliceBitmap(localBitmap);
                localBitmap.recycle();
                label377:
                if (localOptions.inSampleSize > 1)
                {
                  if (!paramDownloadParams.mAutoScaleByDensity) {
                    break label748;
                  }
                  paramDownloadParams.outWidth = ((int)Math.ceil(j * this.density));
                  paramDownloadParams.outHeight = ((int)Math.ceil(k * this.density));
                }
                if (QLog.isColorLevel()) {
                  QLog.d(getLogTag(), 2, "image file size:" + paramFile.length() + " , bound:" + localOptions.outWidth + "x" + localOptions.outHeight + " , sampleSize: " + localOptions.inSampleSize);
                }
                return paramURLDrawableHandler;
              }
              catch (Exception paramURLDrawableHandler)
              {
                if (localBitmap == null) {
                  break label533;
                }
                localBitmap.recycle();
                throw new OutOfMemoryError("slice failed.");
              }
              i = 1;
              paramURLDrawableHandler = Bitmap.Config.RGB_565;
              break;
              ((InputStream)localObject1).close();
              return null;
            }
          }
          catch (OutOfMemoryError paramURLDrawableHandler)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(getLogTag(), 2, "DecodeFile ERROR,oom retryCount=" + i + ",options.inSampleSize=" + localOptions.inSampleSize + ",url=" + paramDownloadParams.urlStr + ",oom.msg:" + paramURLDrawableHandler.getMessage());
              }
              System.gc();
              Thread.yield();
              System.gc();
              i += 1;
              paramInt *= 2;
              break;
              if ((paramDownloadParams.mExtraInfo == null) || (!DownloadParamsExtraInfo.class.isInstance(paramDownloadParams.mExtraInfo))) {
                break label742;
              }
              paramURLDrawableHandler = (DownloadParamsExtraInfo)paramDownloadParams.mExtraInfo;
              if (paramURLDrawableHandler.mCornerRadius <= 0) {
                break label796;
              }
              RoundRectBitmap localRoundRectBitmap = resizeAndClipBitmap(localBitmap, paramURLDrawableHandler.mCornerRadius);
              paramURLDrawableHandler = localRoundRectBitmap;
              if (!localRoundRectBitmap.mBitmap.equals(localBitmap))
              {
                localBitmap.recycle();
                paramURLDrawableHandler = localRoundRectBitmap;
              }
            }
          }
          catch (NullPointerException paramFile)
          {
            label533:
            paramFile.printStackTrace();
            return null;
          }
        }
        label731:
        paramURLDrawableHandler = localBitmap;
      }
      finally
      {
        paramInt = 1;
        paramDownloadParams = (DownloadParams)localObject1;
        if (paramInt == 0) {
          paramDownloadParams.close();
        }
      }
      label742:
      continue;
      label748:
      double d = j;
      paramDownloadParams.outWidth = ((int)Math.ceil(d));
      paramDownloadParams.outHeight = ((int)Math.ceil(k));
    }
  }
  
  /* Error */
  private Object decodeFileNormalWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: new 98	java/io/FileInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   11: astore 13
    //   13: iconst_2
    //   14: newarray byte
    //   16: astore 12
    //   18: aload 13
    //   20: aload 12
    //   22: invokevirtual 107	java/io/InputStream:read	([B)I
    //   25: pop
    //   26: aload 12
    //   28: iconst_0
    //   29: baload
    //   30: istore 9
    //   32: aload 12
    //   34: iconst_1
    //   35: baload
    //   36: istore 10
    //   38: getstatic 116	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   41: astore 12
    //   43: iconst_0
    //   44: istore 7
    //   46: iconst_0
    //   47: istore 8
    //   49: iload 9
    //   51: bipush 8
    //   53: ishl
    //   54: ldc 117
    //   56: iand
    //   57: iload 10
    //   59: sipush 255
    //   62: iand
    //   63: ior
    //   64: lookupswitch	default:+741->805, 8273:+205->269, 16973:+205->269, 18249:+213->277, 18761:+202->266, 19789:+202->266, 65496:+202->266
    //   125: aconst_null
    //   126: fstore_2
    //   127: dup
    //   128: invokespecial 326	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   131: astore 16
    //   133: aload 16
    //   135: iconst_1
    //   136: putfield 327	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   139: aload 16
    //   141: aload 12
    //   143: putfield 328	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   146: aload_1
    //   147: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   150: aload 16
    //   152: invokestatic 334	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   155: pop
    //   156: aload 16
    //   158: getfield 335	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   161: istore 9
    //   163: aload 16
    //   165: getfield 336	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   168: istore 10
    //   170: iload 7
    //   172: ifeq +14 -> 186
    //   175: aload_2
    //   176: aload_1
    //   177: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   180: invokestatic 159	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   183: putfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   186: aload 16
    //   188: iconst_0
    //   189: putfield 327	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   192: aload_0
    //   193: iload 9
    //   195: iload 10
    //   197: aload_2
    //   198: getfield 167	com/tencent/image/DownloadParams:reqWidth	I
    //   201: aload_2
    //   202: getfield 170	com/tencent/image/DownloadParams:reqHeight	I
    //   205: aload_2
    //   206: getfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   209: iload 4
    //   211: invokespecial 172	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   214: istore 7
    //   216: iconst_1
    //   217: istore 8
    //   219: iload 8
    //   221: iconst_3
    //   222: if_icmpgt +577 -> 799
    //   225: aload 16
    //   227: iload 7
    //   229: putfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   232: aload_1
    //   233: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   236: aload 16
    //   238: invokestatic 334	com/tencent/mobileqq/pic/JpegDecompressor:decodeFile	(Ljava/lang/String;Lcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   241: astore 14
    //   243: aload 14
    //   245: ifnonnull +46 -> 291
    //   248: aconst_null
    //   249: astore_2
    //   250: aload_2
    //   251: astore_1
    //   252: aload 13
    //   254: ifnull +10 -> 264
    //   257: aload 13
    //   259: invokevirtual 110	java/io/InputStream:close	()V
    //   262: aload_2
    //   263: astore_1
    //   264: aload_1
    //   265: areturn
    //   266: iconst_1
    //   267: istore 7
    //   269: getstatic 259	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   272: astore 12
    //   274: goto -150 -> 124
    //   277: aconst_null
    //   278: astore_1
    //   279: aload 13
    //   281: ifnull -17 -> 264
    //   284: aload 13
    //   286: invokevirtual 110	java/io/InputStream:close	()V
    //   289: aconst_null
    //   290: areturn
    //   291: aload 14
    //   293: sipush 160
    //   296: invokevirtual 217	android/graphics/Bitmap:setDensity	(I)V
    //   299: aload 14
    //   301: invokestatic 223	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   304: istore 11
    //   306: iload 11
    //   308: ifeq +286 -> 594
    //   311: new 219	com/tencent/image/SliceBitmap
    //   314: dup
    //   315: aload 14
    //   317: invokespecial 226	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   320: astore 12
    //   322: aload 14
    //   324: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   327: aload 16
    //   329: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   332: iconst_1
    //   333: if_icmple +44 -> 377
    //   336: aload_2
    //   337: getfield 232	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   340: ifeq +392 -> 732
    //   343: aload_2
    //   344: iload 9
    //   346: i2f
    //   347: aload_0
    //   348: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   351: fmul
    //   352: f2d
    //   353: invokestatic 236	java/lang/Math:ceil	(D)D
    //   356: d2i
    //   357: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   360: aload_2
    //   361: iload 10
    //   363: i2f
    //   364: aload_0
    //   365: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   368: fmul
    //   369: f2d
    //   370: invokestatic 236	java/lang/Math:ceil	(D)D
    //   373: d2i
    //   374: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   377: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +73 -> 453
    //   383: aload_0
    //   384: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   387: iconst_2
    //   388: new 196	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   395: ldc 240
    //   397: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 244	java/io/File:length	()J
    //   404: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   407: ldc 249
    //   409: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: aload 16
    //   414: getfield 335	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   417: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   420: ldc 254
    //   422: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: aload 16
    //   427: getfield 336	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   430: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   433: ldc_w 256
    //   436: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 16
    //   441: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   444: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload 12
    //   455: astore_1
    //   456: aload 13
    //   458: ifnull -194 -> 264
    //   461: aload 13
    //   463: invokevirtual 110	java/io/InputStream:close	()V
    //   466: aload 12
    //   468: areturn
    //   469: astore 12
    //   471: aload 14
    //   473: ifnull +8 -> 481
    //   476: aload 14
    //   478: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   481: new 94	java/lang/OutOfMemoryError
    //   484: dup
    //   485: ldc_w 261
    //   488: invokespecial 264	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   491: athrow
    //   492: astore 12
    //   494: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +73 -> 570
    //   500: aload_0
    //   501: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   504: iconst_2
    //   505: new 196	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 266
    //   515: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: iload 8
    //   520: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   523: ldc_w 268
    //   526: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: aload 16
    //   531: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   534: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   537: ldc_w 270
    //   540: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload_2
    //   544: getfield 273	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   547: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 275
    //   553: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 12
    //   558: invokevirtual 278	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   561: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   567: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   570: invokestatic 283	java/lang/System:gc	()V
    //   573: invokestatic 288	java/lang/Thread:yield	()V
    //   576: invokestatic 283	java/lang/System:gc	()V
    //   579: iload 8
    //   581: iconst_1
    //   582: iadd
    //   583: istore 8
    //   585: iload 7
    //   587: iconst_2
    //   588: imul
    //   589: istore 7
    //   591: goto -372 -> 219
    //   594: aload_2
    //   595: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   598: ifnull +127 -> 725
    //   601: ldc 6
    //   603: aload_2
    //   604: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   607: invokevirtual 298	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   610: ifeq +115 -> 725
    //   613: aload_2
    //   614: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   617: checkcast 6	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   620: astore 12
    //   622: aload 12
    //   624: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   627: ifle +166 -> 793
    //   630: aload_0
    //   631: aload 14
    //   633: aload 12
    //   635: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   638: invokevirtual 305	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   641: astore 15
    //   643: aload 15
    //   645: astore 12
    //   647: aload 15
    //   649: getfield 311	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   652: aload 14
    //   654: invokevirtual 316	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   657: ifne -330 -> 327
    //   660: aload 14
    //   662: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   665: aload 15
    //   667: astore 12
    //   669: goto -342 -> 327
    //   672: astore 14
    //   674: aload 13
    //   676: astore 12
    //   678: aload 14
    //   680: astore 13
    //   682: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq +16 -> 701
    //   688: aload_0
    //   689: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   692: iconst_2
    //   693: ldc_w 339
    //   696: aload 13
    //   698: invokestatic 343	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   701: aload_0
    //   702: aload_1
    //   703: aload_2
    //   704: aload_3
    //   705: iload 4
    //   707: invokespecial 345	com/tencent/image/downloader/GalleryDecoder:decodeFileNormal	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   710: astore_2
    //   711: aload_2
    //   712: astore_1
    //   713: aload 12
    //   715: ifnull -451 -> 264
    //   718: aload 12
    //   720: invokevirtual 110	java/io/InputStream:close	()V
    //   723: aload_2
    //   724: areturn
    //   725: aload 14
    //   727: astore 12
    //   729: goto -402 -> 327
    //   732: iload 9
    //   734: i2d
    //   735: dstore 5
    //   737: aload_2
    //   738: dload 5
    //   740: invokestatic 236	java/lang/Math:ceil	(D)D
    //   743: d2i
    //   744: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   747: aload_2
    //   748: iload 10
    //   750: i2d
    //   751: invokestatic 236	java/lang/Math:ceil	(D)D
    //   754: d2i
    //   755: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   758: goto -381 -> 377
    //   761: astore_1
    //   762: aload 13
    //   764: astore_2
    //   765: aload_2
    //   766: ifnull +7 -> 773
    //   769: aload_2
    //   770: invokevirtual 110	java/io/InputStream:close	()V
    //   773: aload_1
    //   774: athrow
    //   775: astore_1
    //   776: aconst_null
    //   777: astore_2
    //   778: goto -13 -> 765
    //   781: astore_1
    //   782: aload 12
    //   784: astore_2
    //   785: goto -20 -> 765
    //   788: astore 13
    //   790: goto -108 -> 682
    //   793: aconst_null
    //   794: astore 12
    //   796: goto -469 -> 327
    //   799: aconst_null
    //   800: astore 12
    //   802: goto -475 -> 327
    //   805: iload 8
    //   807: istore 7
    //   809: goto -685 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	GalleryDecoder
    //   0	812	1	paramFile	File
    //   0	812	2	paramDownloadParams	DownloadParams
    //   0	812	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	812	4	paramInt	int
    //   735	4	5	d	double
    //   44	764	7	i	int
    //   47	759	8	j	int
    //   30	703	9	k	int
    //   36	713	10	m	int
    //   304	3	11	bool	boolean
    //   1	466	12	localObject1	Object
    //   469	1	12	localException	Exception
    //   492	65	12	localOutOfMemoryError	OutOfMemoryError
    //   620	181	12	localObject2	Object
    //   11	752	13	localObject3	Object
    //   788	1	13	localRuntimeException1	java.lang.RuntimeException
    //   241	420	14	localBitmap	Bitmap
    //   672	54	14	localRuntimeException2	java.lang.RuntimeException
    //   641	25	15	localRoundRectBitmap	RoundRectBitmap
    //   131	399	16	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    // Exception table:
    //   from	to	target	type
    //   311	327	469	java/lang/Exception
    //   225	243	492	java/lang/OutOfMemoryError
    //   291	306	492	java/lang/OutOfMemoryError
    //   311	327	492	java/lang/OutOfMemoryError
    //   476	481	492	java/lang/OutOfMemoryError
    //   481	492	492	java/lang/OutOfMemoryError
    //   594	643	492	java/lang/OutOfMemoryError
    //   647	665	492	java/lang/OutOfMemoryError
    //   13	26	672	java/lang/RuntimeException
    //   38	43	672	java/lang/RuntimeException
    //   124	170	672	java/lang/RuntimeException
    //   175	186	672	java/lang/RuntimeException
    //   186	216	672	java/lang/RuntimeException
    //   225	243	672	java/lang/RuntimeException
    //   269	274	672	java/lang/RuntimeException
    //   291	306	672	java/lang/RuntimeException
    //   311	327	672	java/lang/RuntimeException
    //   327	377	672	java/lang/RuntimeException
    //   377	453	672	java/lang/RuntimeException
    //   476	481	672	java/lang/RuntimeException
    //   481	492	672	java/lang/RuntimeException
    //   494	570	672	java/lang/RuntimeException
    //   570	579	672	java/lang/RuntimeException
    //   594	643	672	java/lang/RuntimeException
    //   647	665	672	java/lang/RuntimeException
    //   737	758	672	java/lang/RuntimeException
    //   13	26	761	finally
    //   38	43	761	finally
    //   124	170	761	finally
    //   175	186	761	finally
    //   186	216	761	finally
    //   225	243	761	finally
    //   269	274	761	finally
    //   291	306	761	finally
    //   311	327	761	finally
    //   327	377	761	finally
    //   377	453	761	finally
    //   476	481	761	finally
    //   481	492	761	finally
    //   494	570	761	finally
    //   570	579	761	finally
    //   594	643	761	finally
    //   647	665	761	finally
    //   737	758	761	finally
    //   3	13	775	finally
    //   682	701	781	finally
    //   701	711	781	finally
    //   3	13	788	java/lang/RuntimeException
  }
  
  /* Error */
  private Object decodeFileWidthByteArray(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: new 98	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 18
    //   10: aconst_null
    //   11: astore 15
    //   13: iconst_0
    //   14: istore 6
    //   16: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   19: lstore 10
    //   21: iconst_2
    //   22: newarray byte
    //   24: astore 16
    //   26: aload 18
    //   28: aload 16
    //   30: invokevirtual 352	java/io/FileInputStream:read	([B)I
    //   33: pop
    //   34: aload 16
    //   36: iconst_0
    //   37: baload
    //   38: istore 8
    //   40: aload 16
    //   42: iconst_1
    //   43: baload
    //   44: istore 9
    //   46: getstatic 116	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   49: astore_3
    //   50: iconst_0
    //   51: istore 5
    //   53: iconst_0
    //   54: istore 7
    //   56: iload 8
    //   58: bipush 8
    //   60: ishl
    //   61: ldc 117
    //   63: iand
    //   64: iload 9
    //   66: sipush 255
    //   69: iand
    //   70: ior
    //   71: lookupswitch	default:+786->857, 8273:+499->570, 16973:+499->570, 18249:+506->577, 18761:+496->567, 19789:+496->567, 65496:+496->567
    //   129: invokevirtual 244	java/io/File:length	()J
    //   132: l2i
    //   133: newarray byte
    //   135: astore 20
    //   137: aload 16
    //   139: iconst_0
    //   140: aload 20
    //   142: iconst_0
    //   143: aload 16
    //   145: arraylength
    //   146: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   149: aload 18
    //   151: aload 20
    //   153: aload 16
    //   155: arraylength
    //   156: aload 18
    //   158: invokevirtual 360	java/io/FileInputStream:available	()I
    //   161: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   164: pop
    //   165: aload 18
    //   167: invokevirtual 364	java/io/FileInputStream:close	()V
    //   170: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   173: ifeq +40 -> 213
    //   176: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   179: lstore 12
    //   181: aload_0
    //   182: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   185: iconst_2
    //   186: new 196	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   193: ldc_w 366
    //   196: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: lload 12
    //   201: lload 10
    //   203: lsub
    //   204: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   207: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   216: lstore 10
    //   218: new 119	android/graphics/BitmapFactory$Options
    //   221: dup
    //   222: invokespecial 120	android/graphics/BitmapFactory$Options:<init>	()V
    //   225: astore 19
    //   227: aload 19
    //   229: iconst_1
    //   230: putfield 124	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   233: aload 19
    //   235: aload_3
    //   236: putfield 127	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   239: aload 19
    //   241: sipush 160
    //   244: putfield 130	android/graphics/BitmapFactory$Options:inDensity	I
    //   247: aload 19
    //   249: sipush 160
    //   252: putfield 133	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   255: aload 19
    //   257: sipush 160
    //   260: putfield 136	android/graphics/BitmapFactory$Options:inScreenDensity	I
    //   263: aload 19
    //   265: iconst_1
    //   266: putfield 369	android/graphics/BitmapFactory$Options:inPurgeable	Z
    //   269: aload 19
    //   271: iconst_1
    //   272: putfield 372	android/graphics/BitmapFactory$Options:inInputShareable	Z
    //   275: aload 20
    //   277: iconst_0
    //   278: aload 20
    //   280: arraylength
    //   281: aload 19
    //   283: invokestatic 376	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   286: pop
    //   287: aload 19
    //   289: getfield 145	android/graphics/BitmapFactory$Options:outWidth	I
    //   292: istore 6
    //   294: aload 19
    //   296: getfield 148	android/graphics/BitmapFactory$Options:outHeight	I
    //   299: istore 7
    //   301: iload 5
    //   303: ifeq +281 -> 584
    //   306: aload_2
    //   307: aload_1
    //   308: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: invokestatic 159	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   314: putfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   317: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +40 -> 360
    //   323: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   326: lstore 12
    //   328: aload_0
    //   329: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   332: iconst_2
    //   333: new 196	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 378
    //   343: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: lload 12
    //   348: lload 10
    //   350: lsub
    //   351: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 19
    //   362: iconst_0
    //   363: putfield 124	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   366: aload_0
    //   367: iload 6
    //   369: iload 7
    //   371: aload_2
    //   372: getfield 167	com/tencent/image/DownloadParams:reqWidth	I
    //   375: aload_2
    //   376: getfield 170	com/tencent/image/DownloadParams:reqHeight	I
    //   379: aload_2
    //   380: getfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   383: iload 4
    //   385: invokespecial 172	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   388: istore 4
    //   390: aload 19
    //   392: iload 4
    //   394: putfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   397: aload 20
    //   399: iconst_0
    //   400: aload 20
    //   402: arraylength
    //   403: aload 19
    //   405: invokestatic 376	com/tencent/image/SafeBitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   408: astore 16
    //   410: aload 16
    //   412: sipush 160
    //   415: invokevirtual 217	android/graphics/Bitmap:setDensity	(I)V
    //   418: aload 16
    //   420: invokestatic 223	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   423: istore 14
    //   425: iload 14
    //   427: ifeq +312 -> 739
    //   430: new 219	com/tencent/image/SliceBitmap
    //   433: dup
    //   434: aload 16
    //   436: invokespecial 226	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   439: astore_3
    //   440: aload 16
    //   442: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   445: aload 19
    //   447: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   450: iconst_1
    //   451: if_icmple +44 -> 495
    //   454: aload_2
    //   455: getfield 232	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   458: ifeq +361 -> 819
    //   461: aload_2
    //   462: iload 6
    //   464: i2f
    //   465: aload_0
    //   466: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   469: fmul
    //   470: f2d
    //   471: invokestatic 236	java/lang/Math:ceil	(D)D
    //   474: d2i
    //   475: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   478: aload_2
    //   479: iload 7
    //   481: i2f
    //   482: aload_0
    //   483: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   486: fmul
    //   487: f2d
    //   488: invokestatic 236	java/lang/Math:ceil	(D)D
    //   491: d2i
    //   492: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   495: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq +67 -> 565
    //   501: aload_0
    //   502: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   505: iconst_2
    //   506: new 196	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   513: ldc 240
    //   515: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_1
    //   519: invokevirtual 244	java/io/File:length	()J
    //   522: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: ldc 249
    //   527: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 6
    //   532: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   535: ldc 254
    //   537: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: iload 7
    //   542: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: ldc_w 256
    //   548: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 19
    //   553: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   556: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   559: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   562: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   565: aload_3
    //   566: areturn
    //   567: iconst_1
    //   568: istore 5
    //   570: getstatic 259	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   573: astore_3
    //   574: goto -446 -> 128
    //   577: aload 18
    //   579: invokevirtual 364	java/io/FileInputStream:close	()V
    //   582: aconst_null
    //   583: areturn
    //   584: aload_2
    //   585: aload_1
    //   586: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   589: invokestatic 383	com/tencent/image/Utils:getHeifOrientation	(Ljava/lang/String;)I
    //   592: putfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   595: goto -278 -> 317
    //   598: astore_1
    //   599: iconst_1
    //   600: istore 4
    //   602: iload 4
    //   604: ifne +8 -> 612
    //   607: aload 18
    //   609: invokevirtual 364	java/io/FileInputStream:close	()V
    //   612: aload_1
    //   613: athrow
    //   614: astore_3
    //   615: aload 16
    //   617: ifnull +8 -> 625
    //   620: aload 16
    //   622: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   625: new 94	java/lang/OutOfMemoryError
    //   628: dup
    //   629: ldc_w 261
    //   632: invokespecial 264	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   635: athrow
    //   636: astore_3
    //   637: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   640: ifeq +71 -> 711
    //   643: aload_0
    //   644: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   647: iconst_2
    //   648: new 196	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   655: ldc_w 266
    //   658: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: iconst_1
    //   662: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   665: ldc_w 268
    //   668: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload 19
    //   673: getfield 175	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   676: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   679: ldc_w 270
    //   682: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: aload_2
    //   686: getfield 273	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   689: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: ldc_w 275
    //   695: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload_3
    //   699: invokevirtual 278	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   702: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: iload 4
    //   713: iconst_2
    //   714: imul
    //   715: istore 4
    //   717: invokestatic 283	java/lang/System:gc	()V
    //   720: invokestatic 288	java/lang/Thread:yield	()V
    //   723: invokestatic 283	java/lang/System:gc	()V
    //   726: aload 15
    //   728: astore_3
    //   729: iload 4
    //   731: bipush 8
    //   733: if_icmple -288 -> 445
    //   736: goto -346 -> 390
    //   739: aload_2
    //   740: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   743: ifnull +121 -> 864
    //   746: ldc 6
    //   748: aload_2
    //   749: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   752: invokevirtual 298	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   755: ifeq +109 -> 864
    //   758: aload_2
    //   759: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   762: checkcast 6	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   765: astore_3
    //   766: aload_3
    //   767: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   770: ifle +82 -> 852
    //   773: aload_0
    //   774: aload 16
    //   776: aload_3
    //   777: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   780: invokevirtual 305	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   783: astore 17
    //   785: aload 17
    //   787: astore_3
    //   788: aload 17
    //   790: getfield 311	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   793: aload 16
    //   795: invokevirtual 316	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   798: ifne -353 -> 445
    //   801: aload 16
    //   803: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   806: aload 17
    //   808: astore_3
    //   809: goto -364 -> 445
    //   812: astore_1
    //   813: aload_1
    //   814: invokevirtual 319	java/lang/NullPointerException:printStackTrace	()V
    //   817: aconst_null
    //   818: areturn
    //   819: aload_2
    //   820: iload 6
    //   822: i2d
    //   823: invokestatic 236	java/lang/Math:ceil	(D)D
    //   826: d2i
    //   827: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   830: aload_2
    //   831: iload 7
    //   833: i2d
    //   834: invokestatic 236	java/lang/Math:ceil	(D)D
    //   837: d2i
    //   838: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   841: goto -346 -> 495
    //   844: astore_1
    //   845: iload 6
    //   847: istore 4
    //   849: goto -247 -> 602
    //   852: aconst_null
    //   853: astore_3
    //   854: goto -409 -> 445
    //   857: iload 7
    //   859: istore 5
    //   861: goto -733 -> 128
    //   864: aload 16
    //   866: astore_3
    //   867: goto -422 -> 445
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	870	0	this	GalleryDecoder
    //   0	870	1	paramFile	File
    //   0	870	2	paramDownloadParams	DownloadParams
    //   0	870	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	870	4	paramInt	int
    //   51	809	5	i	int
    //   14	832	6	j	int
    //   54	804	7	k	int
    //   38	23	8	m	int
    //   44	26	9	n	int
    //   19	330	10	l1	long
    //   179	168	12	l2	long
    //   423	3	14	bool	boolean
    //   11	716	15	localObject1	Object
    //   24	841	16	localObject2	Object
    //   783	24	17	localRoundRectBitmap	RoundRectBitmap
    //   8	600	18	localFileInputStream	FileInputStream
    //   225	447	19	localOptions	BitmapFactory.Options
    //   135	266	20	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   170	213	598	finally
    //   213	301	598	finally
    //   306	317	598	finally
    //   317	360	598	finally
    //   360	390	598	finally
    //   390	425	598	finally
    //   430	445	598	finally
    //   445	495	598	finally
    //   495	565	598	finally
    //   584	595	598	finally
    //   620	625	598	finally
    //   625	636	598	finally
    //   637	711	598	finally
    //   717	726	598	finally
    //   739	785	598	finally
    //   788	806	598	finally
    //   813	817	598	finally
    //   819	841	598	finally
    //   430	445	614	java/lang/Exception
    //   390	425	636	java/lang/OutOfMemoryError
    //   430	445	636	java/lang/OutOfMemoryError
    //   620	625	636	java/lang/OutOfMemoryError
    //   625	636	636	java/lang/OutOfMemoryError
    //   739	785	636	java/lang/OutOfMemoryError
    //   788	806	636	java/lang/OutOfMemoryError
    //   390	425	812	java/lang/NullPointerException
    //   430	445	812	java/lang/NullPointerException
    //   620	625	812	java/lang/NullPointerException
    //   625	636	812	java/lang/NullPointerException
    //   739	785	812	java/lang/NullPointerException
    //   788	806	812	java/lang/NullPointerException
    //   16	34	844	finally
    //   46	50	844	finally
    //   128	170	844	finally
    //   570	574	844	finally
  }
  
  /* Error */
  private Object decodeFileWidthByteArrayWithTrubo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler, int paramInt)
    throws Exception
  {
    // Byte code:
    //   0: new 98	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore 19
    //   10: iconst_0
    //   11: istore 8
    //   13: iconst_0
    //   14: istore 7
    //   16: iload 8
    //   18: istore 5
    //   20: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   23: lstore 11
    //   25: iload 8
    //   27: istore 5
    //   29: iconst_2
    //   30: newarray byte
    //   32: astore 17
    //   34: iload 8
    //   36: istore 5
    //   38: aload 19
    //   40: aload 17
    //   42: invokevirtual 352	java/io/FileInputStream:read	([B)I
    //   45: pop
    //   46: aload 17
    //   48: iconst_0
    //   49: baload
    //   50: istore 9
    //   52: aload 17
    //   54: iconst_1
    //   55: baload
    //   56: istore 10
    //   58: iload 8
    //   60: istore 5
    //   62: getstatic 116	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   65: astore 16
    //   67: iconst_0
    //   68: istore 6
    //   70: iconst_0
    //   71: istore 5
    //   73: iload 9
    //   75: bipush 8
    //   77: ishl
    //   78: ldc 117
    //   80: iand
    //   81: iload 10
    //   83: sipush 255
    //   86: iand
    //   87: ior
    //   88: lookupswitch	default:+855->943, 8273:+329->417, 16973:+329->417, 18249:+341->429, 18761:+326->414, 19789:+326->414, 65496:+326->414
    //   149: iconst_5
    //   150: istore 5
    //   152: aload_1
    //   153: invokevirtual 244	java/io/File:length	()J
    //   156: l2i
    //   157: newarray byte
    //   159: astore 21
    //   161: iload 8
    //   163: istore 5
    //   165: aload 17
    //   167: iconst_0
    //   168: aload 21
    //   170: iconst_0
    //   171: aload 17
    //   173: arraylength
    //   174: invokestatic 356	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   177: iload 8
    //   179: istore 5
    //   181: aload 19
    //   183: aload 21
    //   185: aload 17
    //   187: arraylength
    //   188: aload 19
    //   190: invokevirtual 360	java/io/FileInputStream:available	()I
    //   193: invokevirtual 363	java/io/FileInputStream:read	([BII)I
    //   196: pop
    //   197: iload 8
    //   199: istore 5
    //   201: aload 19
    //   203: invokevirtual 364	java/io/FileInputStream:close	()V
    //   206: iconst_1
    //   207: istore 7
    //   209: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +40 -> 252
    //   215: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   218: lstore 13
    //   220: aload_0
    //   221: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   224: iconst_2
    //   225: new 196	java/lang/StringBuilder
    //   228: dup
    //   229: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   232: ldc_w 366
    //   235: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: lload 13
    //   240: lload 11
    //   242: lsub
    //   243: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   246: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   255: lstore 11
    //   257: new 325	com/tencent/mobileqq/pic/JpegOptions
    //   260: dup
    //   261: invokespecial 326	com/tencent/mobileqq/pic/JpegOptions:<init>	()V
    //   264: astore 20
    //   266: aload 20
    //   268: iconst_1
    //   269: putfield 327	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   272: aload 20
    //   274: aload 16
    //   276: putfield 328	com/tencent/mobileqq/pic/JpegOptions:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   279: aload 21
    //   281: aload 20
    //   283: invokestatic 387	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   286: pop
    //   287: aload 20
    //   289: getfield 335	com/tencent/mobileqq/pic/JpegOptions:outWidth	I
    //   292: istore 8
    //   294: aload 20
    //   296: getfield 336	com/tencent/mobileqq/pic/JpegOptions:outHeight	I
    //   299: istore 9
    //   301: iload 6
    //   303: ifeq +14 -> 317
    //   306: aload_2
    //   307: aload_1
    //   308: invokevirtual 153	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   311: invokestatic 159	com/tencent/image/JpegExifReader:readOrientation	(Ljava/lang/String;)I
    //   314: putfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   317: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +40 -> 360
    //   323: invokestatic 351	android/os/SystemClock:uptimeMillis	()J
    //   326: lstore 13
    //   328: aload_0
    //   329: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   332: iconst_2
    //   333: new 196	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   340: ldc_w 378
    //   343: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: lload 13
    //   348: lload 11
    //   350: lsub
    //   351: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: aload 20
    //   362: iconst_0
    //   363: putfield 327	com/tencent/mobileqq/pic/JpegOptions:inJustDecodeBounds	Z
    //   366: aload_0
    //   367: iload 8
    //   369: iload 9
    //   371: aload_2
    //   372: getfield 167	com/tencent/image/DownloadParams:reqWidth	I
    //   375: aload_2
    //   376: getfield 170	com/tencent/image/DownloadParams:reqHeight	I
    //   379: aload_2
    //   380: getfield 164	com/tencent/image/DownloadParams:outOrientation	I
    //   383: iload 4
    //   385: invokespecial 172	com/tencent/image/downloader/GalleryDecoder:calculateSampleSize	(IIIIII)I
    //   388: istore 5
    //   390: aload 20
    //   392: iload 5
    //   394: putfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   397: aload 21
    //   399: aload 20
    //   401: invokestatic 387	com/tencent/mobileqq/pic/JpegDecompressor:decodeByteArray	([BLcom/tencent/mobileqq/pic/JpegOptions;)Landroid/graphics/Bitmap;
    //   404: astore 17
    //   406: aload 17
    //   408: ifnonnull +28 -> 436
    //   411: aload 17
    //   413: areturn
    //   414: iconst_1
    //   415: istore 6
    //   417: iload 8
    //   419: istore 5
    //   421: getstatic 259	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   424: astore 16
    //   426: goto -278 -> 148
    //   429: aload 19
    //   431: invokevirtual 364	java/io/FileInputStream:close	()V
    //   434: aconst_null
    //   435: areturn
    //   436: aload 17
    //   438: sipush 160
    //   441: invokevirtual 217	android/graphics/Bitmap:setDensity	(I)V
    //   444: aload 17
    //   446: invokestatic 223	com/tencent/image/SliceBitmap:needSliceBitmap	(Landroid/graphics/Bitmap;)Z
    //   449: istore 15
    //   451: iload 15
    //   453: ifeq +335 -> 788
    //   456: new 219	com/tencent/image/SliceBitmap
    //   459: dup
    //   460: aload 17
    //   462: invokespecial 226	com/tencent/image/SliceBitmap:<init>	(Landroid/graphics/Bitmap;)V
    //   465: astore 16
    //   467: aload 17
    //   469: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   472: aload 20
    //   474: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   477: iconst_1
    //   478: if_icmple +44 -> 522
    //   481: aload_2
    //   482: getfield 232	com/tencent/image/DownloadParams:mAutoScaleByDensity	Z
    //   485: ifeq +390 -> 875
    //   488: aload_2
    //   489: iload 8
    //   491: i2f
    //   492: aload_0
    //   493: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   496: fmul
    //   497: f2d
    //   498: invokestatic 236	java/lang/Math:ceil	(D)D
    //   501: d2i
    //   502: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   505: aload_2
    //   506: iload 9
    //   508: i2f
    //   509: aload_0
    //   510: getfield 52	com/tencent/image/downloader/GalleryDecoder:density	F
    //   513: fmul
    //   514: f2d
    //   515: invokestatic 236	java/lang/Math:ceil	(D)D
    //   518: d2i
    //   519: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   522: aload 16
    //   524: astore 17
    //   526: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq -118 -> 411
    //   532: aload_0
    //   533: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   536: iconst_2
    //   537: new 196	java/lang/StringBuilder
    //   540: dup
    //   541: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   544: ldc 240
    //   546: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: aload_1
    //   550: invokevirtual 244	java/io/File:length	()J
    //   553: invokevirtual 247	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   556: ldc 249
    //   558: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload 8
    //   563: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc 254
    //   568: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: iload 9
    //   573: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   576: ldc_w 256
    //   579: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload 20
    //   584: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   587: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   590: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   593: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   596: aload 16
    //   598: areturn
    //   599: astore 16
    //   601: iconst_1
    //   602: istore 6
    //   604: iload 6
    //   606: istore 5
    //   608: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +20 -> 631
    //   614: iload 6
    //   616: istore 5
    //   618: aload_0
    //   619: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   622: iconst_2
    //   623: ldc_w 389
    //   626: aload 16
    //   628: invokestatic 343	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   631: iload 6
    //   633: istore 5
    //   635: aload_0
    //   636: aload_1
    //   637: aload_2
    //   638: aload_3
    //   639: iload 4
    //   641: invokespecial 391	com/tencent/image/downloader/GalleryDecoder:decodeFileWidthByteArray	(Ljava/io/File;Lcom/tencent/image/DownloadParams;Lcom/tencent/image/URLDrawableHandler;I)Ljava/lang/Object;
    //   644: astore_1
    //   645: aload_1
    //   646: astore 17
    //   648: iload 6
    //   650: ifne -239 -> 411
    //   653: aload 19
    //   655: invokevirtual 364	java/io/FileInputStream:close	()V
    //   658: aload_1
    //   659: areturn
    //   660: astore 16
    //   662: aload 17
    //   664: ifnull +8 -> 672
    //   667: aload 17
    //   669: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   672: new 94	java/lang/OutOfMemoryError
    //   675: dup
    //   676: ldc_w 261
    //   679: invokespecial 264	java/lang/OutOfMemoryError:<init>	(Ljava/lang/String;)V
    //   682: athrow
    //   683: astore 16
    //   685: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   688: ifeq +72 -> 760
    //   691: aload_0
    //   692: invokevirtual 76	com/tencent/image/downloader/GalleryDecoder:getLogTag	()Ljava/lang/String;
    //   695: iconst_2
    //   696: new 196	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 266
    //   706: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iconst_1
    //   710: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   713: ldc_w 268
    //   716: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: aload 20
    //   721: getfield 337	com/tencent/mobileqq/pic/JpegOptions:inSampleSize	I
    //   724: invokevirtual 252	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   727: ldc_w 270
    //   730: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload_2
    //   734: getfield 273	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   737: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   740: ldc_w 275
    //   743: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: aload 16
    //   748: invokevirtual 278	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   751: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: invokevirtual 207	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iload 5
    //   762: iconst_2
    //   763: imul
    //   764: istore 5
    //   766: invokestatic 283	java/lang/System:gc	()V
    //   769: invokestatic 288	java/lang/Thread:yield	()V
    //   772: invokestatic 283	java/lang/System:gc	()V
    //   775: iload 5
    //   777: bipush 8
    //   779: if_icmplt +155 -> 934
    //   782: aconst_null
    //   783: astore 16
    //   785: goto -313 -> 472
    //   788: aload_2
    //   789: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   792: ifnull +158 -> 950
    //   795: ldc 6
    //   797: aload_2
    //   798: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   801: invokevirtual 298	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   804: ifeq +146 -> 950
    //   807: aload_2
    //   808: getfield 292	com/tencent/image/DownloadParams:mExtraInfo	Ljava/lang/Object;
    //   811: checkcast 6	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo
    //   814: astore 16
    //   816: aload 16
    //   818: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   821: ifle +116 -> 937
    //   824: aload_0
    //   825: aload 17
    //   827: aload 16
    //   829: getfield 301	com/tencent/image/downloader/GalleryDecoder$DownloadParamsExtraInfo:mCornerRadius	I
    //   832: invokevirtual 305	com/tencent/image/downloader/GalleryDecoder:resizeAndClipBitmap	(Landroid/graphics/Bitmap;I)Lcom/tencent/image/RoundRectBitmap;
    //   835: astore 18
    //   837: aload 18
    //   839: astore 16
    //   841: aload 18
    //   843: getfield 311	com/tencent/image/RoundRectBitmap:mBitmap	Landroid/graphics/Bitmap;
    //   846: aload 17
    //   848: invokevirtual 316	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   851: ifne -379 -> 472
    //   854: aload 17
    //   856: invokevirtual 229	android/graphics/Bitmap:recycle	()V
    //   859: aload 18
    //   861: astore 16
    //   863: goto -391 -> 472
    //   866: astore 16
    //   868: aload 16
    //   870: invokevirtual 319	java/lang/NullPointerException:printStackTrace	()V
    //   873: aconst_null
    //   874: areturn
    //   875: aload_2
    //   876: iload 8
    //   878: i2d
    //   879: invokestatic 236	java/lang/Math:ceil	(D)D
    //   882: d2i
    //   883: putfield 237	com/tencent/image/DownloadParams:outWidth	I
    //   886: aload_2
    //   887: iload 9
    //   889: i2d
    //   890: invokestatic 236	java/lang/Math:ceil	(D)D
    //   893: d2i
    //   894: putfield 238	com/tencent/image/DownloadParams:outHeight	I
    //   897: goto -375 -> 522
    //   900: astore_1
    //   901: iload 7
    //   903: istore 4
    //   905: iload 4
    //   907: ifne +8 -> 915
    //   910: aload 19
    //   912: invokevirtual 364	java/io/FileInputStream:close	()V
    //   915: aload_1
    //   916: athrow
    //   917: astore_1
    //   918: iload 5
    //   920: istore 4
    //   922: goto -17 -> 905
    //   925: astore 16
    //   927: iload 7
    //   929: istore 6
    //   931: goto -327 -> 604
    //   934: goto -544 -> 390
    //   937: aconst_null
    //   938: astore 16
    //   940: goto -468 -> 472
    //   943: iload 5
    //   945: istore 6
    //   947: goto -799 -> 148
    //   950: aload 17
    //   952: astore 16
    //   954: goto -482 -> 472
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	957	0	this	GalleryDecoder
    //   0	957	1	paramFile	File
    //   0	957	2	paramDownloadParams	DownloadParams
    //   0	957	3	paramURLDrawableHandler	URLDrawableHandler
    //   0	957	4	paramInt	int
    //   18	926	5	i	int
    //   68	878	6	j	int
    //   14	914	7	k	int
    //   11	866	8	m	int
    //   50	838	9	n	int
    //   56	31	10	i1	int
    //   23	326	11	l1	long
    //   218	129	13	l2	long
    //   449	3	15	bool	boolean
    //   65	532	16	localObject1	Object
    //   599	28	16	localRuntimeException1	java.lang.RuntimeException
    //   660	1	16	localException	Exception
    //   683	64	16	localOutOfMemoryError	OutOfMemoryError
    //   783	79	16	localObject2	Object
    //   866	3	16	localNullPointerException	NullPointerException
    //   925	1	16	localRuntimeException2	java.lang.RuntimeException
    //   938	15	16	localObject3	Object
    //   32	919	17	localObject4	Object
    //   835	25	18	localRoundRectBitmap	RoundRectBitmap
    //   8	903	19	localFileInputStream	FileInputStream
    //   264	456	20	localJpegOptions	com.tencent.mobileqq.pic.JpegOptions
    //   159	239	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   209	252	599	java/lang/RuntimeException
    //   252	301	599	java/lang/RuntimeException
    //   306	317	599	java/lang/RuntimeException
    //   317	360	599	java/lang/RuntimeException
    //   360	390	599	java/lang/RuntimeException
    //   390	406	599	java/lang/RuntimeException
    //   436	451	599	java/lang/RuntimeException
    //   456	472	599	java/lang/RuntimeException
    //   472	522	599	java/lang/RuntimeException
    //   526	596	599	java/lang/RuntimeException
    //   667	672	599	java/lang/RuntimeException
    //   672	683	599	java/lang/RuntimeException
    //   685	760	599	java/lang/RuntimeException
    //   766	775	599	java/lang/RuntimeException
    //   788	837	599	java/lang/RuntimeException
    //   841	859	599	java/lang/RuntimeException
    //   868	873	599	java/lang/RuntimeException
    //   875	897	599	java/lang/RuntimeException
    //   456	472	660	java/lang/Exception
    //   390	406	683	java/lang/OutOfMemoryError
    //   436	451	683	java/lang/OutOfMemoryError
    //   456	472	683	java/lang/OutOfMemoryError
    //   667	672	683	java/lang/OutOfMemoryError
    //   672	683	683	java/lang/OutOfMemoryError
    //   788	837	683	java/lang/OutOfMemoryError
    //   841	859	683	java/lang/OutOfMemoryError
    //   390	406	866	java/lang/NullPointerException
    //   436	451	866	java/lang/NullPointerException
    //   456	472	866	java/lang/NullPointerException
    //   667	672	866	java/lang/NullPointerException
    //   672	683	866	java/lang/NullPointerException
    //   788	837	866	java/lang/NullPointerException
    //   841	859	866	java/lang/NullPointerException
    //   209	252	900	finally
    //   252	301	900	finally
    //   306	317	900	finally
    //   317	360	900	finally
    //   360	390	900	finally
    //   390	406	900	finally
    //   436	451	900	finally
    //   456	472	900	finally
    //   472	522	900	finally
    //   526	596	900	finally
    //   667	672	900	finally
    //   672	683	900	finally
    //   685	760	900	finally
    //   766	775	900	finally
    //   788	837	900	finally
    //   841	859	900	finally
    //   868	873	900	finally
    //   875	897	900	finally
    //   20	25	917	finally
    //   29	34	917	finally
    //   38	46	917	finally
    //   62	67	917	finally
    //   152	161	917	finally
    //   165	177	917	finally
    //   181	197	917	finally
    //   201	206	917	finally
    //   421	426	917	finally
    //   608	614	917	finally
    //   618	631	917	finally
    //   635	645	917	finally
    //   20	25	925	java/lang/RuntimeException
    //   29	34	925	java/lang/RuntimeException
    //   38	46	925	java/lang/RuntimeException
    //   62	67	925	java/lang/RuntimeException
    //   152	161	925	java/lang/RuntimeException
    //   165	177	925	java/lang/RuntimeException
    //   181	197	925	java/lang/RuntimeException
    //   201	206	925	java/lang/RuntimeException
    //   421	426	925	java/lang/RuntimeException
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
    throws Exception
  {
    long l1 = SystemClock.uptimeMillis();
    try
    {
      if (VideoDrawable.isVideo(paramFile))
      {
        paramURLDrawableHandler = decodeVideo(paramFile, paramDownloadParams, paramURLDrawableHandler);
        paramDownloadParams = paramURLDrawableHandler;
        if (QLog.isColorLevel())
        {
          l2 = SystemClock.uptimeMillis();
          QLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
          paramDownloadParams = paramURLDrawableHandler;
        }
        return paramDownloadParams;
      }
      l2 = paramFile.length();
      int i = 0;
      if (paramDownloadParams.tag != null) {
        i = ((Integer)paramDownloadParams.tag).intValue();
      }
      if ((useJpegTurbo()) && (PicFormatUtils.isJPEGImage(paramFile.getAbsolutePath())))
      {
        if (l2 < 5242880L)
        {
          paramURLDrawableHandler = decodeFileWidthByteArrayWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
          paramDownloadParams = paramURLDrawableHandler;
          return paramURLDrawableHandler;
        }
        paramURLDrawableHandler = decodeFileNormalWithTrubo(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      if (l2 < 5242880L)
      {
        paramURLDrawableHandler = decodeFileWidthByteArray(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
        paramDownloadParams = paramURLDrawableHandler;
        return paramURLDrawableHandler;
      }
      paramURLDrawableHandler = decodeFileNormal(paramFile, paramDownloadParams, paramURLDrawableHandler, i);
      paramDownloadParams = paramURLDrawableHandler;
      return paramURLDrawableHandler;
    }
    finally
    {
      long l2;
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.uptimeMillis();
        QLog.d(getLogTag(), 2, "decode file:" + paramFile.getAbsolutePath() + " cost: " + (l2 - l1));
      }
    }
  }
  
  protected Object decodeVideo(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    return null;
  }
  
  protected String getLogTag()
  {
    return "GalleryDecoder";
  }
  
  protected void reportSafeDecode(SafeBitmapFactory.SafeDecodeOption paramSafeDecodeOption) {}
  
  protected RoundRectBitmap resizeAndClipBitmap(Bitmap paramBitmap, int paramInt)
  {
    return new RoundRectBitmap(paramBitmap, paramInt);
  }
  
  protected boolean useJpegTurbo()
  {
    return true;
  }
  
  public static class DownloadParamsExtraInfo
  {
    public int mCornerRadius;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.image.downloader.GalleryDecoder
 * JD-Core Version:    0.7.0.1
 */