package com.tencent.component.media.utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.image.ImageManager;
import com.tencent.sharpP.SharpPUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

@Public
public final class BitmapUtils
{
  private static final int DEFAULT_QUALITY = 90;
  private static final String[] EXIF_TAGS = { "FNumber", "DateTime", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "ISOSpeedRatings", "Make", "Model", "Orientation", "WhiteBalance" };
  public static final String TAG = "BitmapUtils";
  private static BitmapFactory.Options options = null;
  
  @TargetApi(11)
  public static void addInBitmapOptions(BitmapFactory.Options paramOptions, Bitmap paramBitmap)
  {
    if (paramOptions == null) {}
    do
    {
      return;
      paramOptions.inMutable = true;
    } while ((paramBitmap == null) || (!canUseForInBitmap(paramBitmap, paramOptions)));
    paramOptions.inBitmap = paramBitmap;
  }
  
  private static boolean canUseForInBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if ((paramOptions == null) || (paramOptions.inSampleSize < 1) || (paramBitmap == null)) {}
    while (Build.VERSION.SDK_INT < 11) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (paramOptions.outWidth / paramOptions.inSampleSize * (paramOptions.outHeight / paramOptions.inSampleSize) * getBytesPerPixel(paramBitmap.getConfig()) <= paramBitmap.getAllocationByteCount()) {}
      for (;;)
      {
        return bool1;
        bool1 = false;
      }
    }
    if ((paramBitmap.getWidth() == paramOptions.outWidth) && (paramBitmap.getHeight() == paramOptions.outHeight) && (paramOptions.inSampleSize == 1)) {}
    for (bool1 = bool2;; bool1 = false) {
      return bool1;
    }
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap)
  {
    if (paramBitmap.hasAlpha()) {}
    for (Bitmap.CompressFormat localCompressFormat = Bitmap.CompressFormat.PNG;; localCompressFormat = Bitmap.CompressFormat.JPEG) {
      return compressToBytes(paramBitmap, 90, localCompressFormat);
    }
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap, int paramInt, Bitmap.CompressFormat paramCompressFormat)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(65536);
    paramBitmap.compress(paramCompressFormat, paramInt, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static byte[] compressToBytes(Bitmap paramBitmap, Bitmap.CompressFormat paramCompressFormat)
  {
    return compressToBytes(paramBitmap, 90, paramCompressFormat);
  }
  
  public static void copyExif(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { "copyExif: path is empty!" });
      return;
    }
    paramString1 = new File(paramString1);
    paramString2 = new File(paramString2);
    if ((!paramString1.exists()) || (!paramString2.exists()))
    {
      ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { "copyExif: file not exits!" });
      return;
    }
    if (SharpPUtils.isSharpP(paramString1))
    {
      ImageManagerEnv.getLogger().w("BitmapUtils", new Object[] { "sharpP image do not support copy exif" });
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString1 = new ExifInterface(paramString1.getAbsolutePath());
        paramString2 = new ExifInterface(paramString2.getAbsolutePath());
        String[] arrayOfString = EXIF_TAGS;
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str1 = arrayOfString[i];
          String str2 = paramString1.getAttribute(str1);
          if (str2 != null) {
            paramString2.setAttribute(str1, str2);
          }
        }
        else
        {
          paramString2.saveAttributes();
          return;
        }
      }
      catch (Throwable paramString1)
      {
        ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { "copyExif failed: " + paramString1.getMessage() });
        return;
      }
      i += 1;
    }
  }
  
  /* Error */
  public static BitmapReference drawableToBitmapByCanvas(android.graphics.drawable.Drawable paramDrawable)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 237	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   4: iconst_2
    //   5: invokestatic 243	java/lang/Math:max	(II)I
    //   8: istore_1
    //   9: aload_0
    //   10: invokevirtual 246	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   13: iconst_2
    //   14: invokestatic 243	java/lang/Math:max	(II)I
    //   17: istore_2
    //   18: invokestatic 252	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   21: iload_1
    //   22: iload_2
    //   23: getstatic 258	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: invokevirtual 262	com/tencent/component/media/image/ImageManager:getBitmap	(IILandroid/graphics/Bitmap$Config;)Lcom/tencent/component/media/image/BitmapReference;
    //   29: astore_3
    //   30: new 264	android/graphics/Canvas
    //   33: dup
    //   34: aload_3
    //   35: invokevirtual 269	com/tencent/component/media/image/BitmapReference:getBitmap	()Landroid/graphics/Bitmap;
    //   38: invokespecial 272	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   41: astore 4
    //   43: aload_0
    //   44: iconst_0
    //   45: iconst_0
    //   46: aload 4
    //   48: invokevirtual 273	android/graphics/Canvas:getWidth	()I
    //   51: aload 4
    //   53: invokevirtual 274	android/graphics/Canvas:getHeight	()I
    //   56: invokevirtual 278	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   59: aload_0
    //   60: aload 4
    //   62: invokevirtual 282	android/graphics/drawable/Drawable:draw	(Landroid/graphics/Canvas;)V
    //   65: aload_3
    //   66: areturn
    //   67: astore_0
    //   68: aconst_null
    //   69: astore_3
    //   70: aload_3
    //   71: ifnull +14 -> 85
    //   74: aload_3
    //   75: invokevirtual 285	com/tencent/component/media/image/BitmapReference:isRecycled	()Z
    //   78: ifne +7 -> 85
    //   81: aload_3
    //   82: invokevirtual 288	com/tencent/component/media/image/BitmapReference:release	()V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_0
    //   88: goto -3 -> 85
    //   91: astore_0
    //   92: goto -22 -> 70
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramDrawable	android.graphics.drawable.Drawable
    //   8	14	1	i	int
    //   17	6	2	j	int
    //   29	53	3	localBitmapReference	BitmapReference
    //   41	20	4	localCanvas	Canvas
    // Exception table:
    //   from	to	target	type
    //   18	30	67	java/lang/Throwable
    //   74	85	87	java/lang/Throwable
    //   30	65	91	java/lang/Throwable
  }
  
  public static int getBitmapAllocSize(Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      return 0;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return paramBitmap.getAllocationByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    ImageManagerEnv.getLogger().w("BitmapUtils", new Object[] { "getBytePerPixel config is error " + paramConfig });
    return 4;
  }
  
  public static BitmapFactory.Options getOptions()
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ((Build.VERSION.SDK_INT < 11) && (ImageManagerEnv.g().enableBitmapNativeAlloc())) {
      setBitmapOptionInNativeAlloc(localOptions);
    }
    return localOptions;
  }
  
  @SuppressLint({"InlinedApi"})
  @Public
  public static Bitmap processExif(Bitmap paramBitmap, String paramString)
  {
    if ((paramBitmap == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return paramBitmap;
      if (Build.VERSION.SDK_INT >= 5) {}
      try
      {
        boolean bool = new File(paramString).exists();
        if (!bool) {}
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { Log.getStackTraceString(localThrowable) });
        }
      }
    }
    return rotateBitmap(paramBitmap, ImageManagerEnv.g().getRotationDegree(paramString));
  }
  
  public static BitmapReference processExif(BitmapReference paramBitmapReference, String paramString)
  {
    return processExif(paramBitmapReference, paramString, "");
  }
  
  public static BitmapReference processExif(BitmapReference paramBitmapReference, String paramString1, String paramString2)
  {
    if ((paramBitmapReference == null) || (TextUtils.isEmpty(paramString1))) {}
    int i;
    for (;;)
    {
      return paramBitmapReference;
      if (Build.VERSION.SDK_INT >= 5)
      {
        Integer localInteger = DecodeImageTask.getImagePath2Rotation(paramString1);
        if (localInteger != null) {}
      }
      else
      {
        try
        {
          boolean bool = new File(paramString1).exists();
          if (!bool) {}
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            ImageManagerEnv.getLogger().e("BitmapUtils", new Object[] { Log.getStackTraceString(localThrowable) });
            continue;
            i = ImageManagerEnv.g().getRotationDegree(paramString1);
          }
        }
      }
    }
    if ((!TextUtils.isEmpty(paramString2)) && ("image/heif".equals(paramString2)))
    {
      i = readOrientation(paramString1);
      DecodeImageTask.putImagePath2Rotation(paramString1, i);
    }
    for (;;)
    {
      return rotateBitmap(paramBitmapReference, i);
      i = localThrowable.intValue();
    }
  }
  
  public static int readOrientation(String paramString)
  {
    try
    {
      paramString = new ExifInterface(paramString);
      if ((paramString != null) && (paramString != null)) {}
      switch (paramString.getAttributeInt("Orientation", 0))
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        ImageManagerLog.e("BitmapUtils", "readOrientation, IOException");
        paramString.printStackTrace();
        paramString = null;
      }
      return 90;
    }
    return 180;
    return 270;
  }
  
  public static void resize(LruCache paramLruCache, float paramFloat)
  {
    if (paramLruCache == null) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    int k = paramLruCache.maxSize();
    int j = (int)(k * paramFloat);
    int i = j;
    if (j <= 0) {
      i = 1;
    }
    ImageManagerLog.i("BitmapUtils", "resize  oldMaxSize=" + k + ",newMaxSize=" + i + ",ration=" + paramFloat);
    paramLruCache.resize(i);
  }
  
  public static void resize(LruCache paramLruCache, float paramFloat, int paramInt)
  {
    if (paramLruCache == null) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    int k = paramLruCache.maxSize();
    int j = (int)(k * paramFloat);
    int i = j;
    if (j < paramInt) {
      i = paramInt;
    }
    ImageManagerLog.i("BitmapUtils", "resize  oldMaxSize=" + k + ",newMaxSize=" + i + ",ration=" + paramFloat + ", minCacheSize = " + paramInt);
    paramLruCache.resize(i);
  }
  
  public static Bitmap rotateBitmap(Bitmap paramBitmap, int paramInt)
  {
    int j = paramInt % 360;
    if (j == 0) {}
    for (;;)
    {
      return paramBitmap;
      int i;
      if (((j > 45) && (j < 135)) || ((j > 225) && (j < 315)))
      {
        i = 1;
        label41:
        if (i != 0) {
          break label169;
        }
        paramInt = paramBitmap.getWidth();
        label50:
        if (i != 0) {
          break label177;
        }
        i = paramBitmap.getHeight();
      }
      try
      {
        for (;;)
        {
          Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, paramBitmap.getConfig());
          if ((localBitmap == null) || (localBitmap == paramBitmap)) {
            break;
          }
          Canvas localCanvas = new Canvas(localBitmap);
          paramInt = (paramInt - paramBitmap.getWidth()) / 2;
          i = (i - paramBitmap.getHeight()) / 2;
          if ((paramInt != 0) || (i != 0)) {
            localCanvas.translate(paramInt, i);
          }
          localCanvas.rotate(j, paramBitmap.getWidth() / 2, paramBitmap.getHeight() / 2);
          localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, null);
          paramBitmap.recycle();
          return localBitmap;
          i = 0;
          break label41;
          label169:
          paramInt = paramBitmap.getHeight();
          break label50;
          label177:
          i = paramBitmap.getWidth();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static BitmapReference rotateBitmap(BitmapReference paramBitmapReference, int paramInt)
  {
    int j = paramInt % 360;
    if (j == 0) {}
    for (;;)
    {
      return paramBitmapReference;
      int i;
      if (((j > 45) && (j < 135)) || ((j > 225) && (j < 315)))
      {
        i = 1;
        label41:
        if (i != 0) {
          break label178;
        }
        paramInt = paramBitmapReference.getWidth();
        label50:
        if (i != 0) {
          break label186;
        }
        i = paramBitmapReference.getHeight();
      }
      try
      {
        for (;;)
        {
          BitmapReference localBitmapReference = ImageManager.getInstance().getBitmap(paramInt, i, paramBitmapReference.getConfig());
          if ((localBitmapReference == null) || (localBitmapReference == paramBitmapReference)) {
            break;
          }
          Canvas localCanvas = new Canvas(localBitmapReference.getBitmap());
          paramInt = (paramInt - paramBitmapReference.getWidth()) / 2;
          i = (i - paramBitmapReference.getHeight()) / 2;
          if ((paramInt != 0) || (i != 0)) {
            localCanvas.translate(paramInt, i);
          }
          localCanvas.rotate(j, paramBitmapReference.getWidth() / 2, paramBitmapReference.getHeight() / 2);
          localCanvas.drawBitmap(paramBitmapReference.getBitmap(), 0.0F, 0.0F, null);
          paramBitmapReference.release();
          return localBitmapReference;
          i = 0;
          break label41;
          label178:
          paramInt = paramBitmapReference.getHeight();
          break label50;
          label186:
          i = paramBitmapReference.getWidth();
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  /* Error */
  public static void saveBitmapToFile(Bitmap paramBitmap, String paramString)
  {
    // Byte code:
    //   0: new 179	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: new 443	java/io/BufferedOutputStream
    //   12: dup
    //   13: new 445	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 448	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   21: invokespecial 451	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   24: astore_2
    //   25: aload_2
    //   26: astore_1
    //   27: aload_0
    //   28: getstatic 138	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   31: bipush 100
    //   33: aload_2
    //   34: invokevirtual 148	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   37: pop
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: invokevirtual 454	java/io/BufferedOutputStream:flush	()V
    //   44: aload_2
    //   45: ifnull +7 -> 52
    //   48: aload_2
    //   49: invokevirtual 457	java/io/BufferedOutputStream:close	()V
    //   52: return
    //   53: astore_0
    //   54: invokestatic 169	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   57: ldc 14
    //   59: iconst_1
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: new 217	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 459
    //   75: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: invokevirtual 460	java/io/IOException:getMessage	()Ljava/lang/String;
    //   82: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: aastore
    //   89: invokeinterface 177 3 0
    //   94: return
    //   95: astore_3
    //   96: aconst_null
    //   97: astore_0
    //   98: aload_0
    //   99: astore_1
    //   100: invokestatic 169	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   103: ldc 14
    //   105: iconst_1
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: new 217	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 459
    //   121: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_3
    //   125: invokevirtual 461	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: aastore
    //   135: invokeinterface 177 3 0
    //   140: aload_0
    //   141: ifnull -89 -> 52
    //   144: aload_0
    //   145: invokevirtual 457	java/io/BufferedOutputStream:close	()V
    //   148: return
    //   149: astore_0
    //   150: invokestatic 169	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   153: ldc 14
    //   155: iconst_1
    //   156: anewarray 4	java/lang/Object
    //   159: dup
    //   160: iconst_0
    //   161: new 217	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 459
    //   171: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_0
    //   175: invokevirtual 460	java/io/IOException:getMessage	()Ljava/lang/String;
    //   178: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: aastore
    //   185: invokeinterface 177 3 0
    //   190: return
    //   191: astore_0
    //   192: aconst_null
    //   193: astore_1
    //   194: aload_1
    //   195: ifnull +7 -> 202
    //   198: aload_1
    //   199: invokevirtual 457	java/io/BufferedOutputStream:close	()V
    //   202: aload_0
    //   203: athrow
    //   204: astore_1
    //   205: invokestatic 169	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   208: ldc 14
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: dup
    //   215: iconst_0
    //   216: new 217	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   223: ldc_w 459
    //   226: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: aload_1
    //   230: invokevirtual 460	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   239: aastore
    //   240: invokeinterface 177 3 0
    //   245: goto -43 -> 202
    //   248: astore_0
    //   249: goto -55 -> 194
    //   252: astore_3
    //   253: aload_2
    //   254: astore_0
    //   255: goto -157 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	258	0	paramBitmap	Bitmap
    //   0	258	1	paramString	String
    //   24	230	2	localBufferedOutputStream	java.io.BufferedOutputStream
    //   95	30	3	localException1	java.lang.Exception
    //   252	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   48	52	53	java/io/IOException
    //   9	25	95	java/lang/Exception
    //   144	148	149	java/io/IOException
    //   9	25	191	finally
    //   198	202	204	java/io/IOException
    //   27	38	248	finally
    //   40	44	248	finally
    //   100	140	248	finally
    //   27	38	252	java/lang/Exception
    //   40	44	252	java/lang/Exception
  }
  
  public static void setBitmapOptionInNativeAlloc(Object paramObject)
  {
    try
    {
      Field localField = paramObject.getClass().getDeclaredField("inNativeAlloc");
      localField.setAccessible(true);
      localField.setBoolean(paramObject, true);
      return;
    }
    catch (Throwable paramObject) {}
  }
  
  public static void trimToSize(LruCache paramLruCache, float paramFloat)
  {
    if (paramLruCache == null) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    int i = paramLruCache.size();
    int j = (int)(i * paramFloat);
    ImageManagerLog.i("BitmapUtils", "trimToSize  oldSize=" + i + ",newSize=" + j + ",ration=" + paramFloat);
    paramLruCache.trimToSize(j);
  }
  
  public static void trimToSize(LruCache paramLruCache, float paramFloat, int paramInt)
  {
    if (paramLruCache == null) {}
    while ((paramFloat > 1.0F) || (paramFloat < 0.0F)) {
      return;
    }
    int j = paramLruCache.size();
    int i = (int)(j * paramFloat);
    if (i < paramInt) {}
    for (;;)
    {
      ImageManagerLog.i("BitmapUtils", "trimToSize  oldSize=" + j + ",newSize=" + paramInt + ",ration=" + paramFloat);
      paramLruCache.trimToSize(paramInt);
      return;
      paramInt = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.utils.BitmapUtils
 * JD-Core Version:    0.7.0.1
 */