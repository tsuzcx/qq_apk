package com.tencent.component.media.image;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.animwebp.AnimWebPHelper;
import com.tencent.component.media.animwebp.AnimWebpImage;
import com.tencent.component.media.image.drawable.BitmapImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.image.BitmapImage;
import com.tencent.component.media.image.image.FeedsBitmapImage;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.image.image.NewGifImage;
import com.tencent.component.media.image.processor.NewGifDrawableSpecifiedRegionProcessor;
import com.tencent.component.media.image.processor.ScaleProcessor;
import com.tencent.component.media.image.region.RegionDrawable;
import com.tencent.component.media.image.region.RegionImageUtil;
import com.tencent.component.media.photogif.PhotoGifDrawable;
import com.tencent.component.media.photogif.PhotoGifImage;
import com.tencent.component.media.utils.BaseHandler;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPDecoderHelper;
import com.tencent.sharpP.SharpPDecoderWrapper.SharpPFeatureWrapper;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class DecodeImageTask
  extends ImageTask
{
  private static final int MAX_CROP_PIC_WIDTH = 500;
  private static final int MAX_CROP_TRY_TIME = 3;
  private static final long MIN_LOG_DECODE_COST;
  private static String TAG = "DecodeImageTask";
  private static ConcurrentHashMap<Integer, Integer> mImageKey2SampleSizeMap;
  private static ConcurrentHashMap<String, ImageAttri> mImagePath2AttriMap;
  private static ConcurrentHashMap<String, Integer> mImagePath2RotationMap;
  private static BaseHandler mMainHandler;
  private static int mObjectPoolSize = 0;
  private static DecodeImageTask sPool;
  private static final Object sPoolSync;
  private DecodeImageTask next = null;
  
  static
  {
    MIN_LOG_DECODE_COST = TimeUnit.SECONDS.toNanos(2L);
    mImagePath2AttriMap = new ConcurrentHashMap();
    mImagePath2RotationMap = new ConcurrentHashMap();
    mImageKey2SampleSizeMap = new ConcurrentHashMap();
    mMainHandler = new BaseHandler(Looper.getMainLooper());
    sPool = null;
    sPoolSync = new Object();
  }
  
  protected DecodeImageTask(ImageKey paramImageKey)
  {
    super(paramImageKey);
  }
  
  protected DecodeImageTask(ImageTask paramImageTask)
  {
    super(paramImageTask);
  }
  
  public static void clearImageKey2SampleSizeMap()
  {
    mImageKey2SampleSizeMap.clear();
  }
  
  public static void clearImagePath2AttriMap()
  {
    mImagePath2AttriMap.clear();
  }
  
  public static void clearImagePath2RotationMap()
  {
    mImagePath2RotationMap.clear();
  }
  
  private boolean decodeAnimateWebp(ImageKey paramImageKey)
  {
    if ((paramImageKey == null) || (!AnimWebPHelper.isAnimWebpUrl(paramImageKey.url)) || (!AnimWebPHelper.isReady())) {
      return false;
    }
    Object localObject = AnimWebPHelper.bytesFromFile(paramImageKey.filePath);
    if ((localObject == null) || (!AnimWebPHelper.isAnimWebP((byte[])localObject))) {
      return false;
    }
    localObject = new AnimWebpImage((byte[])localObject);
    Drawable localDrawable = ((AnimWebpImage)localObject).getDrawable();
    if (localDrawable == null)
    {
      ImageManagerLog.e(TAG, "decodeWebp fail");
      if (paramImageKey.options != null) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 113);
      }
      setResult(9, new Object[0]);
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
    }
    for (;;)
    {
      return true;
      int i = paramImageKey.hashCodeEx();
      ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, (Image)localObject, localDrawable, paramImageKey.options);
      setResult(8, new Object[] { localDrawable, null, paramImageKey.urlKey, Integer.valueOf(i), localObject, localDrawable });
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      ImageTracer.endDecode(paramImageKey.url);
    }
  }
  
  private void decodeBounds(ImageKey paramImageKey, InputStream paramInputStream, ImageAttri paramImageAttri, BitmapFactory.Options paramOptions)
  {
    paramOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeStream(paramInputStream, null, paramOptions);
    if (paramOptions.outMimeType != null) {}
    for (paramInputStream = paramOptions.outMimeType;; paramInputStream = "unknown")
    {
      paramImageAttri.mimeType = paramInputStream;
      paramImageAttri.srcHeight = paramOptions.outHeight;
      paramImageAttri.srcWidth = paramOptions.outWidth;
      mImagePath2AttriMap.put(paramImageKey.filePath, paramImageAttri);
      return;
    }
  }
  
  private boolean decodeGif(ImageKey paramImageKey, ImageAttri paramImageAttri)
  {
    boolean bool1;
    if (ImageManagerEnv.g().isForceShutdownGif())
    {
      ImageManagerLog.w(TAG, "[decodeGif] force shutdown gif decode");
      bool1 = false;
      return bool1;
    }
    int i;
    NewGifImage localNewGifImage;
    if ((isGif(paramImageAttri.mimeType)) && (paramImageKey.options != null) && (paramImageKey.options.needShowGifAnimation))
    {
      int j = paramImageKey.options.clipWidth;
      int k = paramImageKey.options.clipHeight;
      if (j > 0)
      {
        i = k;
        if (k > 0) {}
      }
      else
      {
        j = ImageManagerEnv.g().getScreenWidth();
        i = ImageManagerEnv.g().getScreenHeight();
      }
      localNewGifImage = new NewGifImage(paramImageKey, j, i);
      if (localNewGifImage == null) {
        break label383;
      }
    }
    label380:
    label383:
    for (paramImageAttri = localNewGifImage.getDrawable();; paramImageAttri = null)
    {
      ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "normal/gif");
      if (paramImageAttri != null)
      {
        if ((paramImageKey.options == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
          break label380;
        }
        paramImageAttri = paramImageKey.options.extraProcessor.doProcess(paramImageAttri);
      }
      for (;;)
      {
        i = paramImageKey.hashCodeEx();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, localNewGifImage, paramImageAttri, paramImageKey.options);
        setResult(8, new Object[] { paramImageAttri, null, paramImageKey.urlKey, Integer.valueOf(i), localNewGifImage, paramImageAttri });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        for (;;)
        {
          return true;
          if ((!TextUtils.isEmpty(paramImageKey.filePath)) && (SharpPUtils.isSharpP(new File(paramImageKey.filePath))))
          {
            ImageManagerLog.e(TAG, "decodeGif url----" + paramImageKey.url + "   is not normal gif picture,try sharpP decode");
            boolean bool2 = handlerSharpPDecodeMessage(paramImageKey);
            bool1 = bool2;
            if (bool2) {
              break;
            }
            setResult(9, new Object[0]);
            return bool2;
          }
          if (paramImageKey.options != null) {
            paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 107);
          }
          setResult(9, new Object[0]);
          ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        }
        return false;
      }
    }
  }
  
  private boolean decodeImageFrame(ImageKey paramImageKey)
  {
    if (PhotoGifDrawable.isPhotoGif(paramImageKey))
    {
      int i = paramImageKey.hashCodeEx();
      Object localObject = new PhotoGifImage(paramImageKey);
      Drawable localDrawable = ((PhotoGifImage)localObject).getDrawable();
      if (localDrawable != null)
      {
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, i, (Image)localObject, localDrawable, paramImageKey.options);
        setResult(8, new Object[] { localDrawable, null, paramImageKey.urlKey, Integer.valueOf(i), localObject, localDrawable });
      }
      for (;;)
      {
        return true;
        if ((paramImageKey != null) && (paramImageKey.options != null)) {
          paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 106);
        }
        setResult(9, new Object[0]);
        localObject = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("image/photogif", paramImageKey.url, ((File)localObject).length(), 51000, "decode gif failed, gif drawable is null", System.currentTimeMillis());
      }
    }
    return false;
  }
  
  private BitmapReference decodeImageStream(IDecoder paramIDecoder, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions, boolean paramBoolean)
  {
    if (paramFileInputStream == null) {
      return null;
    }
    if (paramIDecoder != null) {
      return paramIDecoder.decodeImage(paramFileInputStream, paramOptions);
    }
    ImageManagerLog.e(TAG, "decodeImageStream wtf decoder==null");
    return null;
  }
  
  private boolean decodeNormalImage(ImageKey paramImageKey, ImageAttri paramImageAttri, FileInputStream paramFileInputStream, BitmapFactory.Options paramOptions)
  {
    long l = System.nanoTime();
    int j = paramImageKey.hashCodeEx();
    if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
    {
      paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
      ImageManagerLog.i(TAG, "decodeNormalImage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + paramImageKey.options.isNeedPieceLoad);
    }
    Object localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
    int i;
    label168:
    label315:
    Object localObject2;
    StringBuilder localStringBuilder;
    if (localObject1 == null)
    {
      i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, paramImageAttri.srcWidth, paramImageAttri.srcHeight);
      mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
      if ((paramImageKey.options == null) || (paramImageKey.options.imageConfig == null)) {
        break label638;
      }
      paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      if ((i == 1) && (paramOptions.inPreferredConfig == Bitmap.Config.ARGB_8888))
      {
        float f = paramImageAttri.srcHeight / paramImageAttri.srcWidth;
        if (((f > 2.0F) || (f < 0.5F)) && (paramImageAttri.srcHeight * paramImageAttri.srcWidth > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth())) {
          paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        }
      }
      if (paramOptions.inPreferredConfig == Bitmap.Config.RGB_565) {
        paramOptions.inDither = true;
      }
      if ((paramImageKey.options != null) && ((paramImageKey.options.mImageType == 3) || (paramImageKey.options.mImageType == 4)))
      {
        if (paramImageKey.options.imageConfig == null) {
          break label670;
        }
        paramOptions.inPreferredConfig = paramImageKey.options.imageConfig;
      }
      if (paramImageKey != null)
      {
        paramImageKey.inSampleSize = i;
        paramImageKey.orgWidth = paramImageAttri.srcWidth;
        paramImageKey.orgHeight = paramImageAttri.srcHeight;
      }
      paramOptions.outWidth = paramImageAttri.srcWidth;
      paramOptions.outHeight = paramImageAttri.srcHeight;
      paramOptions.inPurgeable = true;
      paramOptions.inInputShareable = true;
      paramOptions.inSampleSize = i;
      paramOptions.outMimeType = paramImageAttri.mimeType;
      localObject2 = null;
      localObject1 = localObject2;
      if (paramImageKey.options != null)
      {
        localObject1 = localObject2;
        if (paramImageKey.options.cropHead) {
          localObject1 = decodePicCropHead(paramFileInputStream, paramImageKey.options.cropHwRation);
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = TAG;
        localStringBuilder = new StringBuilder().append("decodeNormalImage: other mode ");
        if (paramImageKey.options != null) {
          break label721;
        }
      }
    }
    label670:
    label721:
    for (localObject1 = "null";; localObject1 = paramImageKey.options.cropHead + " " + paramImageKey.options.cropHwRation)
    {
      ImageManagerLog.i((String)localObject2, (String)localObject1);
      localObject2 = decodeImageStream(ImageManager.getInstance().getDecoder(), paramFileInputStream, paramOptions, false);
      if ((localObject2 != null) || (TextUtils.isEmpty(paramImageKey.filePath)) || (!SharpPUtils.isSharpP(new File(paramImageKey.filePath)))) {
        break label762;
      }
      ImageManagerLog.e(TAG, "decodeNormalImage --url=" + paramImageKey.url + "  is not normal picture,try sharpP decode");
      boolean bool = handlerSharpPDecodeMessage(paramImageKey);
      if (!bool)
      {
        setResult(9, new Object[0]);
        ImageManagerLog.e(TAG, "decodeNormalImage -- url=" + paramImageKey.url + "  is not normal picture,try sharpP decode failed");
      }
      return bool;
      i = ((Integer)localObject1).intValue();
      break;
      label638:
      if (isPng(paramImageAttri.mimeType))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
        break label168;
      }
      paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
      break label168;
      if ((paramImageAttri.srcWidth != 0) && (paramImageAttri.srcHeight != 0) && (paramImageAttri.srcWidth / paramImageAttri.srcHeight == 2.0F))
      {
        paramOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        break label315;
      }
      paramOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
      break label315;
    }
    label762:
    if (System.nanoTime() - l > MIN_LOG_DECODE_COST) {
      ImageManagerLog.w(TAG, "decodeNormalImage: decode " + paramImageKey.filePath + " " + paramImageKey.url + " cost too much time");
    }
    processBitmap((BitmapReference)localObject2, paramImageKey, j, true, paramImageAttri.mimeType);
    return localObject2 != null;
  }
  
  private BitmapReference decodePicCropHead(InputStream paramInputStream, float paramFloat)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder().append("decodePicCropHead: ").append(paramFloat).append(" ");
    if (paramInputStream == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i((String)localObject1, bool);
      if ((paramInputStream != null) && (paramFloat > 0.0F)) {
        break;
      }
      return null;
    }
    int i = 0;
    label73:
    if (i < 3) {}
    for (;;)
    {
      try
      {
        localObject1 = BitmapRegionDecoder.newInstance(paramInputStream, false);
        paramInputStream = (InputStream)localObject1;
        if (paramInputStream != null) {
          break label175;
        }
        return null;
      }
      catch (IOException localIOException)
      {
        Log.w(TAG, "decodePicCropHead: failed to get decoder " + i, localIOException);
        ImageManagerEnv.getLogger().w(TAG, new Object[] { "decodePicCropHead: failed to get decoder " + i, localIOException });
        i += 1;
      }
      break label73;
      label175:
      i = paramInputStream.getWidth();
      int j = paramInputStream.getHeight();
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = (i / 500 + 1);
      if (i * paramFloat > j) {
        return null;
      }
      localObject2 = new Rect(0, 0, i, (int)(i * paramFloat));
      i = 0;
      while (i < 3)
      {
        if (i == 1) {
          localOptions.inSampleSize *= 2;
        }
        try
        {
          BitmapReference localBitmapReference = BitmapReference.getBitmapReference(paramInputStream.decodeRegion((Rect)localObject2, localOptions));
          return localBitmapReference;
        }
        catch (Throwable localThrowable)
        {
          Log.w(TAG, "decodePicCropHead: failed to decode bitmap " + i, localThrowable);
          ImageManagerEnv.getLogger().w(TAG, new Object[] { "decodePicCropHead: failed to decode bitmap " + i, localThrowable });
          i += 1;
        }
      }
      break;
      paramInputStream = null;
    }
  }
  
  private boolean decodeSharpP(ImageKey paramImageKey)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SharpPUtils.isSharpP(paramImageKey.url))
    {
      bool1 = bool2;
      if (paramImageKey.filePath != null)
      {
        ImageManagerLog.d(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --is SharpP");
        bool1 = handlerSharpPDecodeMessage(paramImageKey);
        if ((!bool1) && (!SharpPUtils.isSharpP(new File(paramImageKey.filePath)))) {
          break label206;
        }
        if (!bool1)
        {
          ImageManager.getInstance().checkBitmapDecodeFailCount(paramImageKey);
          setResult(9, new Object[0]);
          ImageManagerLog.e(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --  decode sharpp failed.");
          ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          ImageTracer.decodeFail(paramImageKey.url);
          File localFile = new File(paramImageKey.filePath);
          ImageManagerEnv.g().reportImageDecodingTask("image/sharpp", paramImageKey.url, localFile.length(), 51000, "decode sharpP image failed", System.currentTimeMillis());
        }
        bool1 = true;
      }
    }
    return bool1;
    label206:
    ImageManagerLog.w(TAG, "decodeSharpP -- url: " + paramImageKey.url + " --is not really SharpP,so try normal decode");
    return false;
  }
  
  private boolean decodeVideoThumb(ImageKey paramImageKey)
  {
    boolean bool = false;
    if (VideoThumbnail.isVideo(paramImageKey.filePath))
    {
      int i = paramImageKey.hashCodeEx();
      processBitmap(VideoThumbnail.getThumb(ImageManagerEnv.getAppContext(), paramImageKey.filePath), paramImageKey, i, false, "");
      bool = true;
    }
    return bool;
  }
  
  public static Integer getImagePath2Rotation(String paramString)
  {
    if (paramString != null) {
      return (Integer)mImagePath2RotationMap.get(paramString);
    }
    return null;
  }
  
  /* Error */
  private void handlerImageDecodeMessage(ImageKey paramImageKey)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   5: invokevirtual 612	com/tencent/component/media/ImageManagerEnv:getCurrentLoadingImgStatus	()Z
    //   8: ifne +112 -> 120
    //   11: ldc_w 614
    //   14: new 335	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   21: ldc_w 616
    //   24: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_1
    //   28: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   31: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 618
    //   37: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_1
    //   41: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   44: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 347	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 573	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload_1
    //   54: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   57: invokestatic 621	com/tencent/component/media/image/ImageTracer:startDecode	(Ljava/lang/String;)V
    //   60: iconst_3
    //   61: aload_1
    //   62: getfield 209	com/tencent/component/media/image/ImageKey:urlKey	Ljava/lang/String;
    //   65: invokestatic 627	com/tencent/component/media/image/ProgressTracer:print	(ILjava/lang/String;)V
    //   68: invokestatic 202	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   71: aload_1
    //   72: invokevirtual 630	com/tencent/component/media/image/ImageManager:imageKeyFilePathCheck	(Lcom/tencent/component/media/image/ImageKey;)V
    //   75: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   78: lstore 5
    //   80: new 325	java/io/File
    //   83: dup
    //   84: aload_1
    //   85: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   88: invokespecial 327	java/io/File:<init>	(Ljava/lang/String;)V
    //   91: astore 10
    //   93: lconst_0
    //   94: lstore_3
    //   95: aload_1
    //   96: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   99: invokestatic 323	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   102: ifne +9 -> 111
    //   105: aload 10
    //   107: invokevirtual 366	java/io/File:length	()J
    //   110: lstore_3
    //   111: aload_0
    //   112: aload_1
    //   113: invokespecial 632	com/tencent/component/media/image/DecodeImageTask:decodeVideoThumb	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   116: ifeq +49 -> 165
    //   119: return
    //   120: ldc_w 634
    //   123: new 335	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 336	java/lang/StringBuilder:<init>	()V
    //   130: ldc_w 636
    //   133: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_1
    //   137: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   140: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: ldc_w 618
    //   146: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload_1
    //   150: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   153: invokevirtual 342	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: invokevirtual 347	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 573	com/tencent/component/media/utils/ImageManagerLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   162: goto -109 -> 53
    //   165: aload_0
    //   166: aload_1
    //   167: invokespecial 638	com/tencent/component/media/image/DecodeImageTask:decodeSharpP	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   170: ifeq +30 -> 200
    //   173: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   176: lstore 7
    //   178: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   181: ldc_w 583
    //   184: aload_1
    //   185: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   188: lload_3
    //   189: iconst_1
    //   190: lload 7
    //   192: lload 5
    //   194: lsub
    //   195: iconst_0
    //   196: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   199: return
    //   200: aload_0
    //   201: aload_1
    //   202: invokespecial 644	com/tencent/component/media/image/DecodeImageTask:decodeImageFrame	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   205: ifeq +30 -> 235
    //   208: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   211: lstore 7
    //   213: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   216: ldc_w 362
    //   219: aload_1
    //   220: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   223: lload_3
    //   224: iconst_1
    //   225: lload 7
    //   227: lload 5
    //   229: lsub
    //   230: iconst_0
    //   231: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   234: return
    //   235: aload_0
    //   236: aload_1
    //   237: invokespecial 646	com/tencent/component/media/image/DecodeImageTask:decodeAnimateWebp	(Lcom/tencent/component/media/image/ImageKey;)Z
    //   240: ifne -121 -> 119
    //   243: getstatic 61	com/tencent/component/media/image/DecodeImageTask:mImagePath2AttriMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   246: aload_1
    //   247: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   250: invokevirtual 413	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   253: checkcast 9	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   256: astore 15
    //   258: invokestatic 652	com/tencent/component/media/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   261: astore 16
    //   263: aload 15
    //   265: ifnonnull +802 -> 1067
    //   268: new 9	com/tencent/component/media/image/DecodeImageTask$ImageAttri
    //   271: dup
    //   272: invokespecial 653	com/tencent/component/media/image/DecodeImageTask$ImageAttri:<init>	()V
    //   275: astore 15
    //   277: new 655	java/io/FileInputStream
    //   280: dup
    //   281: aload_1
    //   282: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   285: invokespecial 656	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   288: astore 10
    //   290: aload 10
    //   292: astore 11
    //   294: aload 10
    //   296: astore 12
    //   298: aload 10
    //   300: astore 13
    //   302: aload 10
    //   304: astore 14
    //   306: aload_0
    //   307: aload_1
    //   308: new 658	java/io/BufferedInputStream
    //   311: dup
    //   312: aload 10
    //   314: invokespecial 661	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   317: aload 15
    //   319: aload 16
    //   321: invokespecial 663	com/tencent/component/media/image/DecodeImageTask:decodeBounds	(Lcom/tencent/component/media/image/ImageKey;Ljava/io/InputStream;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Landroid/graphics/BitmapFactory$Options;)V
    //   324: aload 10
    //   326: astore 11
    //   328: aload 10
    //   330: astore 12
    //   332: aload 10
    //   334: astore 13
    //   336: aload 10
    //   338: astore 14
    //   340: aload_0
    //   341: aload_1
    //   342: aload 15
    //   344: invokespecial 665	com/tencent/component/media/image/DecodeImageTask:decodeGif	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;)Z
    //   347: ifne +302 -> 649
    //   350: aload 10
    //   352: ifnonnull +146 -> 498
    //   355: aload 10
    //   357: astore 11
    //   359: aload 10
    //   361: astore 12
    //   363: aload 10
    //   365: astore 13
    //   367: aload 10
    //   369: astore 14
    //   371: new 655	java/io/FileInputStream
    //   374: dup
    //   375: aload_1
    //   376: getfield 141	com/tencent/component/media/image/ImageKey:filePath	Ljava/lang/String;
    //   379: invokespecial 656	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   382: astore 10
    //   384: aload 16
    //   386: iconst_0
    //   387: putfield 229	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   390: aload_0
    //   391: aload_1
    //   392: aload 15
    //   394: aload 10
    //   396: aload 16
    //   398: invokespecial 667	com/tencent/component/media/image/DecodeImageTask:decodeNormalImage	(Lcom/tencent/component/media/image/ImageKey;Lcom/tencent/component/media/image/DecodeImageTask$ImageAttri;Ljava/io/FileInputStream;Landroid/graphics/BitmapFactory$Options;)Z
    //   401: istore 9
    //   403: aload 10
    //   405: astore 11
    //   407: aload 15
    //   409: getfield 241	com/tencent/component/media/image/DecodeImageTask$ImageAttri:mimeType	Ljava/lang/String;
    //   412: astore 13
    //   414: aload 10
    //   416: astore 11
    //   418: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   421: lstore 7
    //   423: aload 10
    //   425: astore 11
    //   427: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   430: astore 12
    //   432: aload 10
    //   434: astore 11
    //   436: aload_1
    //   437: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   440: astore 14
    //   442: iload 9
    //   444: ifeq +211 -> 655
    //   447: aload 10
    //   449: astore 11
    //   451: aload 12
    //   453: aload 13
    //   455: aload 14
    //   457: lload_3
    //   458: iload 9
    //   460: lload 7
    //   462: lload 5
    //   464: lsub
    //   465: iload_2
    //   466: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   469: iload 9
    //   471: ifne +14 -> 485
    //   474: aload 10
    //   476: astore 11
    //   478: invokestatic 202	com/tencent/component/media/image/ImageManager:getInstance	()Lcom/tencent/component/media/image/ImageManager;
    //   481: aload_1
    //   482: invokevirtual 576	com/tencent/component/media/image/ImageManager:checkBitmapDecodeFailCount	(Lcom/tencent/component/media/image/ImageKey;)V
    //   485: aload 10
    //   487: ifnull -368 -> 119
    //   490: aload 10
    //   492: invokevirtual 670	java/io/FileInputStream:close	()V
    //   495: return
    //   496: astore_1
    //   497: return
    //   498: aload 10
    //   500: astore 11
    //   502: aload 10
    //   504: astore 12
    //   506: aload 10
    //   508: astore 13
    //   510: aload 10
    //   512: astore 14
    //   514: aload_0
    //   515: aload 10
    //   517: invokespecial 674	com/tencent/component/media/image/DecodeImageTask:reset	(Ljava/io/FileInputStream;)V
    //   520: goto -136 -> 384
    //   523: astore 12
    //   525: aload 11
    //   527: astore 10
    //   529: ldc_w 259
    //   532: astore 13
    //   534: aload 10
    //   536: astore 11
    //   538: aload_1
    //   539: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   542: ifnull +20 -> 562
    //   545: aload 10
    //   547: astore 11
    //   549: aload_1
    //   550: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   553: aload_1
    //   554: bipush 110
    //   556: invokestatic 176	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   559: putfield 181	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   562: aload 10
    //   564: astore 11
    //   566: getstatic 40	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   569: aload 12
    //   571: invokestatic 678	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   574: invokestatic 166	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   577: aload 10
    //   579: astore 11
    //   581: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   584: lstore 7
    //   586: aload 10
    //   588: astore 11
    //   590: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   593: aload 13
    //   595: aload_1
    //   596: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   599: lload_3
    //   600: iconst_0
    //   601: lload 7
    //   603: lload 5
    //   605: lsub
    //   606: iconst_3
    //   607: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   610: aload 10
    //   612: astore 11
    //   614: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   617: aload 13
    //   619: aload_1
    //   620: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   623: lload_3
    //   624: ldc_w 367
    //   627: ldc_w 680
    //   630: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   633: invokevirtual 378	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   636: aload 10
    //   638: ifnull -519 -> 119
    //   641: aload 10
    //   643: invokevirtual 670	java/io/FileInputStream:close	()V
    //   646: return
    //   647: astore_1
    //   648: return
    //   649: iconst_1
    //   650: istore 9
    //   652: goto -249 -> 403
    //   655: iconst_1
    //   656: istore_2
    //   657: goto -210 -> 447
    //   660: astore 12
    //   662: aconst_null
    //   663: astore 10
    //   665: ldc_w 259
    //   668: astore 13
    //   670: aload 10
    //   672: astore 11
    //   674: aload_1
    //   675: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   678: ifnull +20 -> 698
    //   681: aload 10
    //   683: astore 11
    //   685: aload_1
    //   686: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   689: aload_1
    //   690: bipush 111
    //   692: invokestatic 176	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   695: putfield 181	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   698: aload 10
    //   700: astore 11
    //   702: getstatic 40	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   705: aload 12
    //   707: invokestatic 678	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   710: invokestatic 166	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: aload 10
    //   715: astore 11
    //   717: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   720: lstore 7
    //   722: aload 10
    //   724: astore 11
    //   726: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   729: aload 13
    //   731: aload_1
    //   732: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   735: lload_3
    //   736: iconst_0
    //   737: lload 7
    //   739: lload 5
    //   741: lsub
    //   742: iconst_2
    //   743: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   746: aload 10
    //   748: astore 11
    //   750: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   753: aload 13
    //   755: aload_1
    //   756: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   759: lload_3
    //   760: ldc_w 367
    //   763: ldc_w 682
    //   766: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   769: invokevirtual 378	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   772: aload 10
    //   774: ifnull -655 -> 119
    //   777: aload 10
    //   779: invokevirtual 670	java/io/FileInputStream:close	()V
    //   782: return
    //   783: astore_1
    //   784: return
    //   785: astore 12
    //   787: aconst_null
    //   788: astore 10
    //   790: ldc_w 259
    //   793: astore 13
    //   795: aload 10
    //   797: astore 11
    //   799: aload_1
    //   800: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   803: ifnull +20 -> 823
    //   806: aload 10
    //   808: astore 11
    //   810: aload_1
    //   811: getfield 170	com/tencent/component/media/image/ImageKey:options	Lcom/tencent/component/media/image/ImageLoader$Options;
    //   814: aload_1
    //   815: bipush 112
    //   817: invokestatic 176	com/tencent/component/media/image/ImageManager:getErrorString	(Lcom/tencent/component/media/image/ImageKey;I)Ljava/lang/String;
    //   820: putfield 181	com/tencent/component/media/image/ImageLoader$Options:errCode	Ljava/lang/String;
    //   823: aload 10
    //   825: astore 11
    //   827: getstatic 40	com/tencent/component/media/image/DecodeImageTask:TAG	Ljava/lang/String;
    //   830: aload 12
    //   832: invokestatic 678	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   835: invokestatic 166	com/tencent/component/media/utils/ImageManagerLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   838: aload 10
    //   840: astore 11
    //   842: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   845: lstore 7
    //   847: aload 10
    //   849: astore 11
    //   851: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   854: aload 13
    //   856: aload_1
    //   857: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   860: lload_3
    //   861: iconst_0
    //   862: lload 7
    //   864: lload 5
    //   866: lsub
    //   867: iconst_4
    //   868: invokevirtual 642	com/tencent/component/media/ImageManagerEnv:reportImageDecodingRes	(Ljava/lang/String;Ljava/lang/String;JZJI)V
    //   871: aload 10
    //   873: astore 11
    //   875: invokestatic 267	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   878: aload 13
    //   880: aload_1
    //   881: getfield 128	com/tencent/component/media/image/ImageKey:url	Ljava/lang/String;
    //   884: lload_3
    //   885: ldc_w 367
    //   888: ldc_w 684
    //   891: invokestatic 374	java/lang/System:currentTimeMillis	()J
    //   894: invokevirtual 378	com/tencent/component/media/ImageManagerEnv:reportImageDecodingTask	(Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;J)V
    //   897: aload 10
    //   899: ifnull -780 -> 119
    //   902: aload 10
    //   904: invokevirtual 670	java/io/FileInputStream:close	()V
    //   907: return
    //   908: astore_1
    //   909: return
    //   910: astore_1
    //   911: aconst_null
    //   912: astore 11
    //   914: aload 11
    //   916: ifnull +8 -> 924
    //   919: aload 11
    //   921: invokevirtual 670	java/io/FileInputStream:close	()V
    //   924: aload_1
    //   925: athrow
    //   926: astore 10
    //   928: goto -4 -> 924
    //   931: astore_1
    //   932: aload 12
    //   934: astore 11
    //   936: goto -22 -> 914
    //   939: astore_1
    //   940: aload 10
    //   942: astore 11
    //   944: goto -30 -> 914
    //   947: astore_1
    //   948: goto -34 -> 914
    //   951: astore 12
    //   953: aload 13
    //   955: astore 10
    //   957: ldc_w 259
    //   960: astore 13
    //   962: goto -167 -> 795
    //   965: astore 12
    //   967: ldc_w 259
    //   970: astore 13
    //   972: goto -177 -> 795
    //   975: astore 12
    //   977: ldc_w 259
    //   980: astore 13
    //   982: goto -187 -> 795
    //   985: astore 12
    //   987: goto -192 -> 795
    //   990: astore 12
    //   992: aload 14
    //   994: astore 10
    //   996: ldc_w 259
    //   999: astore 13
    //   1001: goto -331 -> 670
    //   1004: astore 12
    //   1006: ldc_w 259
    //   1009: astore 13
    //   1011: goto -341 -> 670
    //   1014: astore 12
    //   1016: ldc_w 259
    //   1019: astore 13
    //   1021: goto -351 -> 670
    //   1024: astore 12
    //   1026: goto -356 -> 670
    //   1029: astore 12
    //   1031: aconst_null
    //   1032: astore 10
    //   1034: ldc_w 259
    //   1037: astore 13
    //   1039: goto -505 -> 534
    //   1042: astore 12
    //   1044: ldc_w 259
    //   1047: astore 13
    //   1049: goto -515 -> 534
    //   1052: astore 12
    //   1054: ldc_w 259
    //   1057: astore 13
    //   1059: goto -525 -> 534
    //   1062: astore 12
    //   1064: goto -530 -> 534
    //   1067: aconst_null
    //   1068: astore 10
    //   1070: goto -746 -> 324
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1073	0	this	DecodeImageTask
    //   0	1073	1	paramImageKey	ImageKey
    //   1	656	2	i	int
    //   94	791	3	l1	long
    //   78	787	5	l2	long
    //   176	687	7	l3	long
    //   401	250	9	bool	boolean
    //   91	812	10	localObject1	Object
    //   926	15	10	localIOException	IOException
    //   955	114	10	localObject2	Object
    //   292	651	11	localObject3	Object
    //   296	209	12	localObject4	Object
    //   523	47	12	localException1	java.lang.Exception
    //   660	46	12	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   785	148	12	localThrowable1	Throwable
    //   951	1	12	localThrowable2	Throwable
    //   965	1	12	localThrowable3	Throwable
    //   975	1	12	localThrowable4	Throwable
    //   985	1	12	localThrowable5	Throwable
    //   990	1	12	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1004	1	12	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   1014	1	12	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   1024	1	12	localOutOfMemoryError5	java.lang.OutOfMemoryError
    //   1029	1	12	localException2	java.lang.Exception
    //   1042	1	12	localException3	java.lang.Exception
    //   1052	1	12	localException4	java.lang.Exception
    //   1062	1	12	localException5	java.lang.Exception
    //   300	758	13	localObject5	Object
    //   304	689	14	localObject6	Object
    //   256	152	15	localImageAttri	ImageAttri
    //   261	136	16	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   490	495	496	java/io/IOException
    //   306	324	523	java/lang/Exception
    //   340	350	523	java/lang/Exception
    //   371	384	523	java/lang/Exception
    //   514	520	523	java/lang/Exception
    //   641	646	647	java/io/IOException
    //   258	263	660	java/lang/OutOfMemoryError
    //   268	290	660	java/lang/OutOfMemoryError
    //   777	782	783	java/io/IOException
    //   258	263	785	java/lang/Throwable
    //   268	290	785	java/lang/Throwable
    //   902	907	908	java/io/IOException
    //   258	263	910	finally
    //   268	290	910	finally
    //   919	924	926	java/io/IOException
    //   306	324	931	finally
    //   340	350	931	finally
    //   371	384	931	finally
    //   514	520	931	finally
    //   384	403	939	finally
    //   407	414	947	finally
    //   418	423	947	finally
    //   427	432	947	finally
    //   436	442	947	finally
    //   451	469	947	finally
    //   478	485	947	finally
    //   538	545	947	finally
    //   549	562	947	finally
    //   566	577	947	finally
    //   581	586	947	finally
    //   590	610	947	finally
    //   614	636	947	finally
    //   674	681	947	finally
    //   685	698	947	finally
    //   702	713	947	finally
    //   717	722	947	finally
    //   726	746	947	finally
    //   750	772	947	finally
    //   799	806	947	finally
    //   810	823	947	finally
    //   827	838	947	finally
    //   842	847	947	finally
    //   851	871	947	finally
    //   875	897	947	finally
    //   306	324	951	java/lang/Throwable
    //   340	350	951	java/lang/Throwable
    //   371	384	951	java/lang/Throwable
    //   514	520	951	java/lang/Throwable
    //   384	403	965	java/lang/Throwable
    //   407	414	975	java/lang/Throwable
    //   418	423	985	java/lang/Throwable
    //   427	432	985	java/lang/Throwable
    //   436	442	985	java/lang/Throwable
    //   451	469	985	java/lang/Throwable
    //   478	485	985	java/lang/Throwable
    //   306	324	990	java/lang/OutOfMemoryError
    //   340	350	990	java/lang/OutOfMemoryError
    //   371	384	990	java/lang/OutOfMemoryError
    //   514	520	990	java/lang/OutOfMemoryError
    //   384	403	1004	java/lang/OutOfMemoryError
    //   407	414	1014	java/lang/OutOfMemoryError
    //   418	423	1024	java/lang/OutOfMemoryError
    //   427	432	1024	java/lang/OutOfMemoryError
    //   436	442	1024	java/lang/OutOfMemoryError
    //   451	469	1024	java/lang/OutOfMemoryError
    //   478	485	1024	java/lang/OutOfMemoryError
    //   258	263	1029	java/lang/Exception
    //   268	290	1029	java/lang/Exception
    //   384	403	1042	java/lang/Exception
    //   407	414	1052	java/lang/Exception
    //   418	423	1062	java/lang/Exception
    //   427	432	1062	java/lang/Exception
    //   436	442	1062	java/lang/Exception
    //   451	469	1062	java/lang/Exception
    //   478	485	1062	java/lang/Exception
  }
  
  private boolean handlerSharpPDecodeMessage(ImageKey paramImageKey)
  {
    int j = paramImageKey.hashCodeEx();
    SharpPDecoderHelper localSharpPDecoderHelper = new SharpPDecoderHelper(paramImageKey.filePath);
    int i = localSharpPDecoderHelper.parseHeader();
    if (i != 0)
    {
      ImageManagerLog.w(TAG, "parseHeader error,status=" + i + "," + paramImageKey.url + ",hashCode=" + paramImageKey.hashCodeEx() + ",filePath=" + paramImageKey.filePath + ", try again");
      return false;
    }
    ImageAttri localImageAttri = (ImageAttri)mImagePath2AttriMap.get(paramImageKey.filePath);
    Object localObject2 = localSharpPDecoderHelper.getFeatureInfo();
    Object localObject1;
    if ((localImageAttri == null) || (localImageAttri.mimeType.equals("unknown")))
    {
      localImageAttri = new ImageAttri();
      localImageAttri.srcHeight = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getHeight();
      localImageAttri.srcWidth = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getWidth();
      localObject1 = localSharpPDecoderHelper.getMimeType();
      if (localObject1 != null)
      {
        localImageAttri.mimeType = ((String)localObject1);
        mImagePath2AttriMap.put(paramImageKey.filePath, localImageAttri);
      }
    }
    for (;;)
    {
      localObject1 = (Integer)mImageKey2SampleSizeMap.get(Integer.valueOf(j));
      int k = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getWidth();
      int m = ((SharpPDecoderWrapper.SharpPFeatureWrapper)localObject2).getHeight();
      if ((paramImageKey.options != null) && (!TextUtils.isEmpty(paramImageKey.filePath)) && (paramImageKey.options.isNeedPieceLoad))
      {
        paramImageKey.options.isNeedPieceLoad = RegionImageUtil.isValidRegionImageFormat(paramImageKey.filePath);
        ImageManagerLog.i(TAG, "handlerSharpPDecodeMessage Region decode file isValidRegionImageFormat with isNeedPieceLoad = " + paramImageKey.options.isNeedPieceLoad);
      }
      if (localObject1 == null)
      {
        i = ImageOptionSampleSize.computeSampleSize(paramImageKey.options, k, m);
        mImageKey2SampleSizeMap.put(Integer.valueOf(j), Integer.valueOf(i));
        label340:
        if ((!isGif(localImageAttri.mimeType)) || (paramImageKey.options == null) || (!paramImageKey.options.needShowGifAnimation)) {
          break label617;
        }
        ImageManagerLog.d(TAG, "handlerSharpPDecodeMessage -- url: " + paramImageKey.url + " --is sharp gif：" + localImageAttri.mimeType);
        localObject2 = new NewGifImage(paramImageKey.filePath, k, m, i, paramImageKey.url);
        if (localObject2 == null) {
          break label969;
        }
      }
      label781:
      label929:
      label946:
      label966:
      label969:
      for (localObject1 = ((NewGifImage)localObject2).getDrawable();; localObject1 = null)
      {
        ImageManagerEnv.g().reportImageDecodingResMTA("gif_collect", "sharp/gif");
        if (localObject1 != null)
        {
          if ((paramImageKey.options.extraProcessor == null) || (!(paramImageKey.options.extraProcessor instanceof NewGifDrawableSpecifiedRegionProcessor))) {
            break label966;
          }
          localObject1 = paramImageKey.options.extraProcessor.doProcess((Drawable)localObject1);
        }
        for (;;)
        {
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, j, (Image)localObject2, (Drawable)localObject1, paramImageKey.options);
          setResult(8, new Object[] { localObject1, null, paramImageKey.urlKey, Integer.valueOf(j), localObject2, localObject1 });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          ImageTracer.endDecode(paramImageKey.url);
          return true;
          localObject1 = "unknown";
          break;
          i = ((Integer)localObject1).intValue();
          break label340;
          if (paramImageKey.options != null) {
            paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 103);
          }
          return false;
          label617:
          localObject1 = Bitmap.Config.ARGB_8888;
          int n;
          int i1;
          if ((paramImageKey.options != null) && (paramImageKey.options.imageConfig != null))
          {
            localObject1 = paramImageKey.options.imageConfig;
            localObject2 = localObject1;
            if (i == 1)
            {
              localObject2 = localObject1;
              if (localObject1 == Bitmap.Config.ARGB_8888)
              {
                float f = m / k;
                if (f <= 2.0F)
                {
                  localObject2 = localObject1;
                  if (f >= 0.5F) {}
                }
                else
                {
                  localObject2 = localObject1;
                  if (m * k > ImageManagerEnv.g().getScreenHeight() * ImageManagerEnv.g().getScreenWidth()) {
                    localObject2 = Bitmap.Config.RGB_565;
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (paramImageKey.options != null) {
              if (paramImageKey.options.mImageType != 3)
              {
                localObject1 = localObject2;
                if (paramImageKey.options.mImageType != 4) {}
              }
              else
              {
                if (paramImageKey.options.imageConfig == null) {
                  break label892;
                }
                localObject1 = paramImageKey.options.imageConfig;
              }
            }
            n = k / i;
            i1 = m / i;
            if (paramImageKey != null)
            {
              paramImageKey.inSampleSize = i;
              paramImageKey.orgWidth = k;
              paramImageKey.orgHeight = m;
            }
            if (!SharpPUtils.isJpg(localImageAttri.mimeType)) {
              break label929;
            }
          }
          for (localObject1 = localSharpPDecoderHelper.decodeSharpP2JPG(n, i1, (Bitmap.Config)localObject1);; localObject1 = localSharpPDecoderHelper.decodeSharpP2PNG(n, i1, Bitmap.Config.ARGB_8888))
          {
            if (localObject1 != null) {
              break label946;
            }
            if (paramImageKey.options != null) {
              paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 104);
            }
            return false;
            if (SharpPUtils.isJpg(localImageAttri.mimeType))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break;
            label892:
            if ((k != 0) && (m != 0) && (k / m == 2.0F))
            {
              localObject1 = Bitmap.Config.RGB_565;
              break label781;
            }
            localObject1 = Bitmap.Config.ARGB_8888;
            break label781;
          }
          processBitmap(BitmapReference.getBitmapReference((Bitmap)localObject1), paramImageKey, j, true, localImageAttri.mimeType);
          return true;
        }
      }
    }
  }
  
  private static boolean isAvatarUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.startsWith("avatar://");
  }
  
  private static boolean isGif(String paramString)
  {
    return "image/gif".equalsIgnoreCase(paramString);
  }
  
  private static boolean isPng(String paramString)
  {
    return "image/png".equalsIgnoreCase(paramString);
  }
  
  private static boolean needTryScaleDrawable(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    int k = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int m = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    ImageManagerLog.w(TAG, "super resolution. needTryScaleDrawable: width=" + i + " screenWidth=" + k + " height=" + j + " screenHeight=" + m);
    return (i > k) || (j > m);
  }
  
  public static DecodeImageTask obtain(ImageKey paramImageKey)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DecodeImageTask localDecodeImageTask = sPool;
        sPool = sPool.next;
        localDecodeImageTask.next = null;
        mObjectPoolSize -= 1;
        localDecodeImageTask.setImageKey(paramImageKey);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramImageKey);
    }
  }
  
  public static DecodeImageTask obtain(ImageTask paramImageTask)
  {
    if (needRecycle) {}
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        DecodeImageTask localDecodeImageTask = sPool;
        sPool = sPool.next;
        localDecodeImageTask.next = null;
        mObjectPoolSize -= 1;
        localDecodeImageTask.setImageTask(paramImageTask);
        return localDecodeImageTask;
      }
      return new DecodeImageTask(paramImageTask);
    }
  }
  
  private void processBitmap(BitmapReference paramBitmapReference, ImageKey paramImageKey, int paramInt, boolean paramBoolean, String paramString)
  {
    long l;
    Object localObject;
    int j;
    int k;
    int i;
    if (paramBitmapReference != null)
    {
      l = System.nanoTime();
      ImageManager.getInstance().updateLruFile(paramImageKey);
      localObject = paramBitmapReference;
      if (paramBoolean) {
        localObject = BitmapUtils.processExif(paramBitmapReference, paramImageKey.filePath, paramString);
      }
      localObject = processImage((BitmapReference)localObject, paramImageKey.options);
      j = -1;
      k = -1;
      if (paramImageKey.options != null)
      {
        j = paramImageKey.options.clipWidth;
        k = paramImageKey.options.clipHeight;
      }
      if ((!paramImageKey.needSuperResolution) || (!ImageManagerEnv.g().enableSuperResolution()) || (paramImageKey.url == null) || (!paramImageKey.url.contains("sce="))) {
        break label1004;
      }
      if ((ImageManagerEnv.g().checkShouldRunSuperResolutionBenchmark()) && (ImageManagerEnv.g().needRerunSuperResolutionBenchmark(paramImageKey.url))) {
        ImageManagerEnv.g().clearSuperResolutionBenchmark();
      }
      if (!ImageManagerEnv.g().isSuperResolutionEnvReady())
      {
        ImageManagerEnv.g().prepareSuperResolutionEnv();
        i = 0;
      }
    }
    for (;;)
    {
      if ((paramImageKey.options != null) && (paramImageKey.options.extraProcessor != null))
      {
        paramString = new BitmapImageDrawable((BitmapImage)localObject, j, k);
        paramBitmapReference = paramString;
        if (ImageManagerEnv.g().isHighScaleUrl(paramImageKey.url))
        {
          ImageManagerLog.w(TAG, "super resolution. check high scale not process. url=" + paramImageKey.url);
          paramBitmapReference = paramString;
          if (needTryScaleDrawable(paramString)) {
            paramBitmapReference = scaleLargeDrawable(paramString);
          }
        }
        paramImageKey.options.extraProcessor.setImageKey(paramImageKey);
        paramBitmapReference = paramImageKey.options.extraProcessor.doProcess(paramBitmapReference);
        if ((paramBitmapReference instanceof SpecifiedBitmapDrawable))
        {
          paramString = ((SpecifiedBitmapDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, new FeedsBitmapImage(paramString), paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), new FeedsBitmapImage(paramString), paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          label372:
          ImageTracer.endDecode(paramImageKey.url);
        }
      }
      for (;;)
      {
        if ((i == 0) && (ImageManagerEnv.g().enableReportNoneSuperResolutionTime()) && (ImageManagerEnv.g().isBigUrl(paramImageKey.url)))
        {
          ImageTracer.reportDecodeTime(paramImageKey.url, false);
          ImageTracer.reportDownloadTime(paramImageKey.url, false);
        }
        if (System.nanoTime() - l > MIN_LOG_DECODE_COST) {
          ImageManagerLog.w(TAG, "processBitmap: " + paramImageKey.url + " cost too much time");
        }
        return;
        if (!ImageManagerEnv.g().needSuperResolution(paramImageKey.url)) {
          break label1004;
        }
        i = ((BitmapImage)localObject).getBitmap().getWidth();
        int m = ((BitmapImage)localObject).getBitmap().getHeight();
        ImageManagerLog.d(TAG, "super resolution. width=" + i + " height=" + m + " url=" + paramImageKey.url);
        if (!ImageManagerEnv.g().canDoSuperResolution(i, m)) {
          break label1004;
        }
        paramBitmapReference = ((BitmapImage)localObject).getBitmap().getBitmap();
        ImageTracer.requestSuperResolution(paramImageKey.url);
        ProgressTracer.print(7, paramImageKey.urlKey);
        ImageManager.getSuperResolutionHandler().postAtFrontOfQueue(new DecodeImageTask.1(this, paramImageKey, paramBitmapReference, j, k, paramInt));
        i = 1;
        break;
        if ((paramBitmapReference instanceof RegionDrawable))
        {
          paramString = ((RegionDrawable)paramBitmapReference).getBitmapRef();
          ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
          setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
          break label372;
        }
        paramString = ((BitmapImage)localObject).getBitmap();
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, paramString, paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
        break label372;
        paramBitmapReference = new SpecifiedBitmapDrawable(((BitmapImage)localObject).getBitmap());
        ImageTracer.endDecode(paramImageKey.url);
        ImageManager.getInstance().putDrawableInMemoryCache(paramImageKey, paramInt, (Image)localObject, paramBitmapReference, paramImageKey.options);
        setResult(8, new Object[] { paramBitmapReference, ((BitmapImage)localObject).getBitmap(), paramImageKey.urlKey, Integer.valueOf(paramInt), localObject, paramBitmapReference });
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      }
      if ((paramImageKey != null) && (paramImageKey.options != null)) {
        paramImageKey.options.errCode = ImageManager.getErrorString(paramImageKey, 105);
      }
      setResult(9, new Object[0]);
      if (paramImageKey != null)
      {
        paramBitmapReference = new File(paramImageKey.filePath);
        ImageManagerEnv.g().reportImageDecodingTask("unknown", paramImageKey.url, paramBitmapReference.length(), 51000, "processBitmap, bm is null", System.currentTimeMillis());
        ImageManagerLog.w(TAG, "processBitmap, bm is null, url=" + paramImageKey.url + ", file length=" + paramBitmapReference.length());
      }
      ImageTaskTracer.addImageDecodeFailedRecord(paramImageKey.hashCodeEx());
      ImageTaskTracer.removeImageDecodeThreadDecodingRecord(paramImageKey.hashCodeEx());
      return;
      label1004:
      i = 0;
    }
  }
  
  private static BitmapImage processImage(BitmapReference paramBitmapReference, ImageLoader.Options paramOptions)
  {
    if (paramBitmapReference == null) {
      return null;
    }
    if ((paramOptions != null) && (paramOptions.processor != null))
    {
      int i = paramBitmapReference.getWidth();
      int j = paramBitmapReference.getHeight();
      try
      {
        paramOptions = paramOptions.processor.doProcess(paramBitmapReference, true);
        if ((paramOptions != null) && (paramOptions != paramBitmapReference))
        {
          paramBitmapReference = new BitmapImage(paramOptions);
          paramBitmapReference.getMetaInfo().width = i;
          paramBitmapReference.getMetaInfo().height = j;
          return paramBitmapReference;
        }
      }
      catch (Throwable paramOptions)
      {
        for (;;)
        {
          paramOptions.printStackTrace();
          paramOptions = null;
        }
      }
    }
    return new BitmapImage(paramBitmapReference);
  }
  
  public static void putImagePath2Rotation(String paramString, int paramInt)
  {
    mImagePath2RotationMap.put(paramString, Integer.valueOf(paramInt));
  }
  
  private void reset(FileInputStream paramFileInputStream)
    throws IOException
  {
    paramFileInputStream = paramFileInputStream.getChannel();
    paramFileInputStream.position();
    paramFileInputStream.position(0L);
  }
  
  private static Drawable scaleLargeDrawable(Drawable paramDrawable)
  {
    int k = paramDrawable.getIntrinsicWidth();
    int m = paramDrawable.getIntrinsicHeight();
    int j = ImageManagerEnv.g().getScreenWidth() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    int i = ImageManagerEnv.g().getScreenHeight() - (int)(ImageManagerEnv.g().getDesity() * 4.0F);
    Drawable localDrawable;
    double d;
    if (k <= j)
    {
      localDrawable = paramDrawable;
      if (m <= i) {}
    }
    else
    {
      if (k / m <= j / i) {
        break label129;
      }
      d = j;
      i = (int)(m / k * d);
    }
    for (;;)
    {
      localDrawable = new ScaleProcessor(j, i, true).process(paramDrawable);
      localDrawable.setBounds(0, 0, j, i);
      return localDrawable;
      label129:
      d = i;
      j = (int)(k / m * d);
    }
  }
  
  public void excuteTask()
  {
    Object localObject = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
    if (localObject != null)
    {
      setResult(11, new Object[] { localObject });
      return;
    }
    ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
    localObject = new File(this.mImageKey.filePath);
    SharpPUtils.deleteSharppCacheFileIfNessary((File)localObject, this.mImageKey.url);
    SharpPUtils.checkNotSharppCacheFileIfNessary((File)localObject, this.mImageKey.url);
    if (((File)localObject).exists())
    {
      ImageManager.getInstance().traceImageFile(true);
      if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
      {
        ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
        return;
      }
      startDecodeTask();
      return;
    }
    ImageManager.getInstance().traceImageFile(false);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.mImageType == 2))
    {
      ImageTaskBuilder.stampMap.put(this.mImageKey.url, Long.valueOf(System.currentTimeMillis()));
      ImageManagerLog.w(TAG, "no file hashCodeEx:" + this.mImageKey.hashCodeEx() + " isGifPlayWhileDownloading:" + this.mImageKey.options.isGifPlayWhileDownloading);
    }
    if (this.mNextTask != null)
    {
      this.mNextTask.excuteTask();
      return;
    }
    if (this.mImageKey.options != null) {
      this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 100);
    }
    setResult(9, new Object[0]);
  }
  
  protected void onResult(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      setResult(paramInt, paramVarArgs);
    }
    do
    {
      return;
      setResult(9, new Object[0]);
      return;
      setResult(9, new Object[0]);
      return;
      ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
      if ((isAvatarUrl(this.mImageKey.url)) && (paramVarArgs[1] != null)) {
        this.mImageKey.filePath = paramVarArgs[1].toString();
      }
      paramVarArgs = new File(this.mImageKey.filePath);
      if (paramVarArgs.exists())
      {
        if (!ImageManagerEnv.g().getCurrentLoadingImgStatus())
        {
          ImageTaskManager.getInstance().addWaitToDecodeImageTask(this);
          return;
        }
        startDecodeTask();
        return;
      }
      if (this.mImageKey.options != null) {
        this.mImageKey.options.errCode = ImageManager.getErrorString(this.mImageKey, 102);
      }
      setResult(9, new Object[0]);
    } while (this.mImageKey == null);
    ImageManagerEnv.g().reportImageDecodingTask("unknown", this.mImageKey.url, paramVarArgs.length(), 51000, "download success, file does not exist", System.currentTimeMillis());
    ImageManagerLog.w(TAG, "onResult, download success, file does not exist!, url=" + this.mImageKey.url + ", file length=" + paramVarArgs.length());
  }
  
  public void recycle()
  {
    if (!needRecycle) {
      return;
    }
    reset();
    synchronized (sPoolSync)
    {
      if (mObjectPoolSize < 50)
      {
        this.next = sPool;
        sPool = this;
        mObjectPoolSize += 1;
      }
      return;
    }
  }
  
  public void startDecodeTask()
  {
    if (this.mImageKey != null) {
      ImageTaskTracer.addImageDecodeThreadPendingRecord(this.mImageKey.hashCodeEx());
    }
    DecodeTask localDecodeTask = new DecodeTask(this.mImageKey);
    if ((this.mImageKey != null) && (this.mImageKey.options != null) && (this.mImageKey.options.priority)) {}
    for (boolean bool = true;; bool = false)
    {
      ImageManager.post(localDecodeTask, bool);
      return;
    }
  }
  
  class DecodeTask
    implements Comparable<DecodeTask>, Runnable
  {
    private ImageKey key = null;
    
    public DecodeTask(ImageKey paramImageKey)
    {
      this.key = paramImageKey;
    }
    
    public int compareTo(DecodeTask paramDecodeTask)
    {
      if ((DecodeImageTask.this.mImageKey != null) && (DecodeImageTask.this.mImageKey.options != null) && (DecodeImageTask.this.mImageKey.options.priority)) {
        return 1;
      }
      return 0;
    }
    
    public void run()
    {
      System.currentTimeMillis();
      if (DecodeImageTask.this.mImageKey != null)
      {
        ImageTaskTracer.removeImageDecodeThreadPendingRecord(DecodeImageTask.this.mImageKey.hashCodeEx());
        ImageTaskTracer.addImageDecodeThreadDecodingRecord(DecodeImageTask.this.mImageKey.hashCodeEx());
      }
      for (;;)
      {
        try
        {
          Drawable localDrawable = ImageManager.getInstance().getDrawbleFromCache(DecodeImageTask.this.mImageKey);
          if (localDrawable == null) {
            continue;
          }
          DecodeImageTask.this.setResult(11, new Object[] { localDrawable });
        }
        catch (Throwable localThrowable)
        {
          ImageManagerLog.e(DecodeImageTask.TAG, Log.getStackTraceString(localThrowable));
          if ((DecodeImageTask.this.mImageKey == null) || (DecodeImageTask.this.mImageKey.options == null)) {
            continue;
          }
          DecodeImageTask.this.mImageKey.options.errCode = ImageManager.getErrorString(DecodeImageTask.this.mImageKey, 101);
          DecodeImageTask.this.setResult(9, new Object[0]);
          if (this.key == null) {
            continue;
          }
          ImageTaskTracer.addImageDecodeFailedRecord(this.key.hashCodeEx());
          ImageTaskTracer.removeImageDecodeThreadDecodingRecord(this.key.hashCodeEx());
          continue;
        }
        System.currentTimeMillis();
        ImageManager.getInstance().nocachedDeleteLocalFile(this.key);
        this.key = null;
        return;
        DecodeImageTask.this.handlerImageDecodeMessage(this.key);
      }
    }
  }
  
  static class ImageAttri
  {
    public String mimeType = "";
    public int srcHeight = 0;
    public int srcWidth = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask
 * JD-Core Version:    0.7.0.1
 */