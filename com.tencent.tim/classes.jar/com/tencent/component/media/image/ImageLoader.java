package com.tencent.component.media.image;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.utils.BaseHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

public class ImageLoader
{
  public static final String AVATAR_URL_PREFIX = "avatar://";
  private static ImageLoader sInstance;
  private BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
  
  public ImageLoader()
  {
    ImageManager.getInstance();
  }
  
  @Public
  public static ImageLoader getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ImageLoader();
      }
      return sInstance;
    }
    finally {}
  }
  
  @Public
  public static ImageLoader getInstance(Context paramContext)
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new ImageLoader();
      }
      return sInstance;
    }
    finally {}
  }
  
  public static void onListViewIdle()
  {
    ImageManager.getInstance().onListViewIdle();
  }
  
  public void cancel() {}
  
  public void cancel(String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    ImageManager.getInstance().cancel(paramString, paramImageLoadListener, paramOptions);
  }
  
  public void clear(String paramString)
  {
    ImageManager.getInstance().clear(paramString);
  }
  
  @Public
  public void clear(String paramString, Options paramOptions)
  {
    ImageManager.getInstance().clear(paramString, paramOptions);
  }
  
  public void clear(boolean paramBoolean)
  {
    ImageManager.getInstance().clear(paramBoolean);
  }
  
  public void downloadImage(ImageUrl paramImageUrl, String paramString, ImageDownloadListener paramImageDownloadListener, Options paramOptions)
  {
    if (paramImageUrl != null)
    {
      ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)2, paramImageDownloadListener);
      return;
    }
    downloadImage(paramString, paramImageDownloadListener, paramOptions);
  }
  
  public void downloadImage(String paramString, ImageDownloadListener paramImageDownloadListener, Options paramOptions)
  {
    ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)2, paramImageDownloadListener);
  }
  
  public Drawable downloadImageOnly(ImageUrl paramImageUrl, String paramString, ImageDownloadListener paramImageDownloadListener, Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)3, paramImageDownloadListener);
    }
    return downloadImageOnly(paramString, paramImageDownloadListener, paramOptions);
  }
  
  public Drawable downloadImageOnly(String paramString, ImageDownloadListener paramImageDownloadListener, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)3, paramImageDownloadListener);
  }
  
  public Drawable downloadImageOnly(String paramString, ImageLoadListener paramImageLoadListener, ImageDownloadListener paramImageDownloadListener, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)3, paramImageDownloadListener);
  }
  
  public void downloadImageOnly(ImageUrl paramImageUrl, String paramString, ImageDownloadListener paramImageDownloadListener)
  {
    if (paramImageUrl != null)
    {
      ImageManager.getInstance().getImage(paramImageUrl, null, null, (byte)3, paramImageDownloadListener);
      return;
    }
    downloadImageOnly(paramString, paramImageDownloadListener);
  }
  
  public void downloadImageOnly(String paramString, ImageDownloadListener paramImageDownloadListener)
  {
    ImageManager.getInstance().getImage(paramString, null, null, (byte)3, paramImageDownloadListener);
  }
  
  @Public
  public File getImageFile(String paramString)
  {
    return getImageFile(paramString, null);
  }
  
  @Public
  public File getImageFile(String paramString, Options paramOptions)
  {
    return ImageManager.getInstance().getImageFile(paramString, paramOptions);
  }
  
  @Public
  public File getImageFileForSuperResolution(String paramString)
  {
    return ImageManager.getInstance().getImageFileForSuperResolution(paramString);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(ImageUrl paramImageUrl, String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)2, null);
    }
    return loadImage(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImage(ImageUrl paramImageUrl, String paramString, Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)0, null);
    }
    return loadImage(paramString, paramOptions);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(String paramString, ImageLoadListener paramImageLoadListener)
  {
    return loadImage(paramString, paramImageLoadListener, null);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)2, null);
  }
  
  @Public
  public Drawable loadImage(String paramString, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)0, null);
  }
  
  public void loadImageAsync(ImageUrl paramImageUrl, String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    if ((paramImageUrl != null) && (!TextUtils.isEmpty(paramImageUrl.url))) {}
    for (Drawable localDrawable = ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)2, null);; localDrawable = ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)2, null))
    {
      if ((localDrawable != null) && (paramImageLoadListener != null))
      {
        if ((paramOptions == null) || (!paramOptions.useMainThread)) {
          break;
        }
        this.mMainHandler.post(new ImageLoader.1(this, paramImageUrl, paramImageLoadListener, localDrawable, paramOptions, paramString));
      }
      return;
    }
    if (paramImageUrl != null)
    {
      paramImageLoadListener.onImageLoaded(paramImageUrl.url, localDrawable, paramOptions);
      return;
    }
    paramImageLoadListener.onImageLoaded(paramString, localDrawable, paramOptions);
  }
  
  @Public
  public void loadImageAsync(String paramString, ImageLoadListener paramImageLoadListener)
  {
    loadImageAsync(paramString, paramImageLoadListener, null);
  }
  
  @Public
  public void loadImageAsync(String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    loadImageAsync(null, paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageDownloadOnly(ImageUrl paramImageUrl, String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)3, null);
    }
    return loadImageDownloadOnly(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageDownloadOnly(String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)3, null);
  }
  
  public Drawable loadImageSync(ImageUrl paramImageUrl, String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)1, null);
    }
    return loadImageSync(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageSync(String paramString)
  {
    return loadImageSync(paramString, null);
  }
  
  public Drawable loadImageSync(String paramString, ImageLoadListener paramImageLoadListener, Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)1, null);
  }
  
  public Drawable loadImageSync(String paramString, Options paramOptions)
  {
    return loadImageSync(paramString, null, paramOptions);
  }
  
  public void removeImageFile(String paramString)
  {
    removeImageFile(paramString, null);
  }
  
  public void removeImageFile(String paramString, Options paramOptions)
  {
    ImageManager.getInstance().removeImageFile(paramString, paramOptions);
  }
  
  public static abstract interface ImageDownloadListener
  {
    public abstract void onDownloadCanceled(String paramString);
    
    public abstract void onDownloadFailed(String paramString);
    
    public abstract void onDownloadProgress(String paramString, long paramLong, float paramFloat);
    
    public abstract void onDownloadSucceed(String paramString);
  }
  
  public static abstract interface ImageLoadListener
  {
    @Public
    public abstract void onImageCanceled(String paramString, ImageLoader.Options paramOptions);
    
    @Public
    public abstract void onImageFailed(String paramString, ImageLoader.Options paramOptions);
    
    @Public
    public abstract void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions);
    
    @Public
    public abstract void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions);
  }
  
  @Public
  public static class ImageOptions
    implements Cloneable
  {
    public static final int DEFAULT_CLIP_HEIGHT = -1;
    public static final int DEFAULT_CLIP_WIDTH = -1;
    public static final Bitmap.Config DEFAULT_IMAGE_CONFIG = Bitmap.Config.RGB_565;
    public static final boolean DEFAULT_JUST_COVER = true;
    public static final boolean DEFAULT_PREFER_QUALITY = false;
    public static final boolean DEFAULT_PRIORITY = true;
    public static final SecondImageProcessor DEFAULT_PROCESSOR = null;
    public static final boolean DEFAULT_TRY_STREAM = false;
    public int clipHeight = -1;
    public int clipWidth = -1;
    public Bitmap.Config imageConfig = DEFAULT_IMAGE_CONFIG;
    public boolean isNeedPieceLoad = false;
    public boolean justCover = true;
    public boolean needCache = true;
    public boolean needShowGifAnimation = false;
    public boolean preferQuality = false;
    public boolean priority = true;
    public SecondImageProcessor processor = DEFAULT_PROCESSOR;
    
    public final ImageOptions copy()
    {
      try
      {
        ImageOptions localImageOptions = (ImageOptions)clone();
        return localImageOptions;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        localCloneNotSupportedException.printStackTrace();
      }
      return null;
    }
    
    public final boolean equals(Object paramObject)
    {
      return super.equals(paramObject);
    }
    
    public final int hashCode()
    {
      return super.hashCode();
    }
  }
  
  @Public
  public static class Options
    extends ImageLoader.ImageOptions
  {
    public static final int DEFAULT_GIF_TYPE = 2;
    public static final int DEFAULT_IMAGE_TYPE = 1;
    public static final int DEFAULT_PANORAMA_ORIG_TYPE = 4;
    public static final int DEFAULT_PANORAMA_THUMB_TYPE = 3;
    private static final long DEFAULT_PHOTO_DELAY_TIME_IN_MS = 200L;
    public static final int DEFAULT_TYPE = 0;
    public static final boolean DEFAULT_USE_MAIN_THREAD = false;
    private static LinkedList<Options> mObjectCache = new LinkedList();
    public int arg1;
    public int arg2;
    public boolean cropHead = false;
    public float cropHwRation = 1.0F;
    public boolean disableHitRateReport = false;
    @Public
    public String errCode;
    public ImageProcessor extraProcessor;
    public String fileRootPath = null;
    public boolean isGifPlayWhileDownloading = false;
    public boolean isPreDecode = false;
    public int mImageType = 0;
    public boolean needCallBackProcessPercent = false;
    public boolean needRecycle = false;
    public boolean needShowPhotoGifAnimation = false;
    public Object obj;
    public long photoDelayTimeInMs = 200L;
    public ArrayList<String> photoList;
    public long totalSize;
    public String type;
    public boolean useArgb8888 = false;
    @Public
    public boolean useMainThread = false;
    public WeakReference<Drawable> watermarkDrawableRef;
    
    static
    {
      localLinkedList = mObjectCache;
      int i = 0;
      for (;;)
      {
        if (i < 50) {}
        try
        {
          mObjectCache.add(new Options());
          i += 1;
        }
        finally {}
      }
    }
    
    public static Options copy(Options paramOptions)
    {
      if (paramOptions == null) {
        return null;
      }
      Options localOptions = obtain();
      localOptions.needRecycle = paramOptions.needRecycle;
      localOptions.useMainThread = paramOptions.useMainThread;
      localOptions.extraProcessor = paramOptions.extraProcessor;
      localOptions.obj = paramOptions.obj;
      localOptions.arg1 = paramOptions.arg1;
      localOptions.arg2 = paramOptions.arg2;
      localOptions.totalSize = paramOptions.totalSize;
      localOptions.clipWidth = paramOptions.clipWidth;
      localOptions.clipHeight = paramOptions.clipHeight;
      localOptions.preferQuality = paramOptions.preferQuality;
      localOptions.priority = paramOptions.priority;
      localOptions.justCover = paramOptions.justCover;
      localOptions.needCallBackProcessPercent = paramOptions.needCallBackProcessPercent;
      localOptions.needShowGifAnimation = paramOptions.needShowGifAnimation;
      localOptions.imageConfig = paramOptions.imageConfig;
      localOptions.processor = paramOptions.processor;
      localOptions.fileRootPath = paramOptions.fileRootPath;
      localOptions.isPreDecode = paramOptions.isPreDecode;
      localOptions.type = paramOptions.type;
      localOptions.needShowPhotoGifAnimation = paramOptions.needShowPhotoGifAnimation;
      localOptions.photoDelayTimeInMs = paramOptions.photoDelayTimeInMs;
      localOptions.photoList = paramOptions.photoList;
      localOptions.isGifPlayWhileDownloading = paramOptions.isGifPlayWhileDownloading;
      localOptions.mImageType = paramOptions.mImageType;
      localOptions.errCode = paramOptions.errCode;
      localOptions.watermarkDrawableRef = paramOptions.watermarkDrawableRef;
      localOptions.needCache = paramOptions.needCache;
      localOptions.isNeedPieceLoad = paramOptions.isNeedPieceLoad;
      localOptions.useArgb8888 = paramOptions.useArgb8888;
      localOptions.cropHead = paramOptions.cropHead;
      localOptions.cropHwRation = paramOptions.cropHwRation;
      return localOptions;
    }
    
    public static Options obtain()
    {
      synchronized (mObjectCache)
      {
        Options localOptions = (Options)mObjectCache.poll();
        ??? = localOptions;
        if (localOptions == null) {
          ??? = new Options();
        }
        ((Options)???).needRecycle = true;
        return ???;
      }
    }
    
    public void recycle()
    {
      if (this.needRecycle)
      {
        this.useMainThread = false;
        this.extraProcessor = null;
        this.obj = null;
        this.arg1 = 0;
        this.arg2 = 0;
        this.totalSize = 0L;
        this.clipWidth = -1;
        this.clipHeight = -1;
        this.preferQuality = false;
        this.priority = true;
        this.justCover = true;
        this.needCallBackProcessPercent = false;
        this.needShowGifAnimation = false;
        this.imageConfig = DEFAULT_IMAGE_CONFIG;
        this.processor = DEFAULT_PROCESSOR;
        this.fileRootPath = null;
        this.type = null;
        this.needShowPhotoGifAnimation = false;
        this.photoDelayTimeInMs = 200L;
        this.photoList = null;
        this.isGifPlayWhileDownloading = false;
        this.mImageType = 0;
        this.isPreDecode = false;
        this.errCode = null;
        this.watermarkDrawableRef = null;
        this.needCache = true;
        this.useArgb8888 = false;
        this.cropHead = false;
        this.cropHwRation = 1.0F;
        synchronized (mObjectCache)
        {
          mObjectCache.add(this);
          return;
        }
      }
    }
  }
  
  public static abstract interface StreamDownloadListener
  {
    public abstract void onApplyToImage(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions);
    
    public abstract void onDownloadCanceled(String paramString1, String paramString2, String paramString3);
    
    public abstract void onDownloadFailed(String paramString1, String paramString2, String paramString3);
    
    public abstract void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt);
    
    public abstract void onDownloadSucceed(String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader
 * JD-Core Version:    0.7.0.1
 */