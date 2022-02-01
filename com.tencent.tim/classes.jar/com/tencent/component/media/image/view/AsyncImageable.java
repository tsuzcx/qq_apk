package com.tencent.component.media.image.view;

import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageLoader.StreamDownloadListener;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import java.lang.ref.WeakReference;

public abstract interface AsyncImageable
{
  public static final int GL_MAX_TEXTURE_SIZE = 2048;
  
  public abstract String getAsyncImage();
  
  public abstract AsyncOptions getAsyncOptions();
  
  public abstract void setAsyncImage(String paramString);
  
  public abstract void setAsyncImage(String paramString, String... paramVarArgs);
  
  public abstract void setAsyncImageListener(AsyncImageListener paramAsyncImageListener);
  
  public abstract void setInternalAsyncImageListener(AsyncImageListener paramAsyncImageListener);
  
  public static abstract interface AsyncImageListener
  {
    public abstract void onImageFailed(AsyncImageable paramAsyncImageable);
    
    public abstract void onImageLoaded(AsyncImageable paramAsyncImageable);
    
    public abstract void onImageProgress(AsyncImageable paramAsyncImageable, float paramFloat);
    
    public abstract void onImageStarted(AsyncImageable paramAsyncImageable);
  }
  
  public static class AsyncImageableImpl
    implements AsyncImageable
  {
    private static final String[] EMPTY_STR_ARRAY = new String[0];
    private int mAsyncImageId;
    private AsyncImageable.AsyncImageListener mAsyncListener;
    private final AsyncImageable mAsyncListenerCallback;
    private AsyncImageable.AsyncOptions mAsyncOptions = new AsyncImageable.AsyncImageableImpl.1(this);
    private final WeakImageLoadListener mImageLoadListener;
    private final ImageLoader mImageLoader;
    private final ImageView mImageView;
    private AsyncImageable.AsyncImageListener mInternalAsyncListener;
    private String mLatestUrl = null;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());
    private final Thread mMainThread = Looper.getMainLooper().getThread();
    private ImageLoader.Options mOptions = new ImageLoader.Options();
    private final WeakStreamLoadListener mStreamLoadListener;
    private String mUrl = null;
    
    public AsyncImageableImpl(ImageView paramImageView, AsyncImageable paramAsyncImageable)
    {
      this.mImageView = paramImageView;
      this.mImageLoader = ImageLoader.getInstance(paramImageView.getContext());
      this.mImageLoadListener = new WeakImageLoadListener(this);
      this.mStreamLoadListener = new WeakStreamLoadListener(this);
      this.mAsyncListenerCallback = paramAsyncImageable;
      this.mOptions.useMainThread = true;
    }
    
    private void applyAsyncImage(Drawable paramDrawable, boolean paramBoolean)
    {
      if (paramDrawable != null)
      {
        if (!paramBoolean) {
          this.mImageView.setImageDrawable(paramDrawable);
        }
        for (;;)
        {
          this.mAsyncImageId = paramDrawable.hashCode();
          return;
          Animation localAnimation1 = this.mAsyncOptions.inAnimation;
          Animation localAnimation2 = this.mAsyncOptions.outAnimation;
          if (localAnimation2 != null)
          {
            scheduleAnimation(this.mImageView, localAnimation2, new AsyncImageable.AsyncImageableImpl.3(this, paramDrawable, localAnimation1));
          }
          else if (localAnimation1 != null)
          {
            this.mImageView.setImageDrawable(paramDrawable);
            scheduleAnimation(this.mImageView, localAnimation1, null);
          }
          else
          {
            this.mImageView.setImageDrawable(paramDrawable);
          }
        }
      }
      this.mAsyncImageId = 0;
    }
    
    private void applyDefaultImage()
    {
      Drawable localDrawable = this.mAsyncOptions.defaultImage;
      int i = this.mAsyncOptions.defaultImageId;
      if (localDrawable != null) {
        this.mImageView.setImageDrawable(localDrawable);
      }
      while (i == 0) {
        return;
      }
      this.mImageView.setImageResource(i);
    }
    
    private void applyFailImage()
    {
      Drawable localDrawable = this.mAsyncOptions.failImage;
      int i = this.mAsyncOptions.failImageId;
      if (localDrawable != null) {
        this.mImageView.setImageDrawable(localDrawable);
      }
      while (i == 0) {
        return;
      }
      this.mImageView.setImageResource(i);
    }
    
    private boolean checkAsyncChanged(String paramString)
    {
      return !equalsString(this.mUrl, paramString);
    }
    
    private void ensureDrawable()
    {
      int i = this.mAsyncImageId;
      if (i != 0)
      {
        Drawable localDrawable = this.mImageView.getDrawable();
        if ((localDrawable == null) || (localDrawable.hashCode() != i)) {
          resetAsyncImage();
        }
      }
    }
    
    private void ensureThread(String paramString)
    {
      if (Thread.currentThread() != this.mMainThread) {
        throw new RuntimeException(paramString + " can ONLY be called within main thread!");
      }
    }
    
    private static boolean equalsString(String paramString1, String paramString2)
    {
      boolean bool = true;
      if ((paramString1 == null) || (paramString2 == null)) {
        bool = false;
      }
      while (paramString1.equals(paramString2)) {
        return bool;
      }
      if (paramString1 != null) {
        return ImageKey.getUrlKey(paramString1, true).equals(ImageKey.getUrlKey(paramString2, true));
      }
      return false;
    }
    
    private static boolean equalsStringArray(String[] paramArrayOfString1, String[] paramArrayOfString2)
    {
      boolean bool2 = false;
      boolean bool1;
      if (paramArrayOfString1 == paramArrayOfString2) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramArrayOfString1 == null);
          bool1 = bool2;
        } while (paramArrayOfString2 == null);
        bool1 = bool2;
      } while (paramArrayOfString1.length != paramArrayOfString2.length);
      int i = 0;
      for (;;)
      {
        if (i >= paramArrayOfString1.length) {
          break label66;
        }
        bool1 = bool2;
        if (!equalsString(paramArrayOfString1[i], paramArrayOfString2[i])) {
          break;
        }
        i += 1;
      }
      label66:
      return true;
    }
    
    private void notifyAsyncImageFailed()
    {
      AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
      Object localObject1 = this.mAsyncListenerCallback;
      Object localObject2;
      if (localAsyncImageListener != null)
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          localAsyncImageListener.onImageFailed((AsyncImageable)localObject2);
        }
      }
      else
      {
        localObject2 = this.mInternalAsyncListener;
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label53;
          }
        }
      }
      for (;;)
      {
        ((AsyncImageable.AsyncImageListener)localObject2).onImageFailed((AsyncImageable)localObject1);
        return;
        localObject2 = this;
        break;
        label53:
        localObject1 = this;
      }
    }
    
    private void notifyAsyncImageLoaded()
    {
      AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
      Object localObject1 = this.mAsyncListenerCallback;
      Object localObject2;
      if (localAsyncImageListener != null)
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          localAsyncImageListener.onImageLoaded((AsyncImageable)localObject2);
        }
      }
      else
      {
        localObject2 = this.mInternalAsyncListener;
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label53;
          }
        }
      }
      for (;;)
      {
        ((AsyncImageable.AsyncImageListener)localObject2).onImageLoaded((AsyncImageable)localObject1);
        return;
        localObject2 = this;
        break;
        label53:
        localObject1 = this;
      }
    }
    
    private void notifyAsyncImageProgress(float paramFloat)
    {
      AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
      Object localObject1 = this.mAsyncListenerCallback;
      Object localObject2;
      if (localAsyncImageListener != null)
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          localAsyncImageListener.onImageProgress((AsyncImageable)localObject2, paramFloat);
        }
      }
      else
      {
        localObject2 = this.mInternalAsyncListener;
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label58;
          }
        }
      }
      for (;;)
      {
        ((AsyncImageable.AsyncImageListener)localObject2).onImageProgress((AsyncImageable)localObject1, paramFloat);
        return;
        localObject2 = this;
        break;
        label58:
        localObject1 = this;
      }
    }
    
    private void notifyAsyncImageStart()
    {
      AsyncImageable.AsyncImageListener localAsyncImageListener = this.mAsyncListener;
      Object localObject1 = this.mAsyncListenerCallback;
      Object localObject2;
      if (localAsyncImageListener != null)
      {
        if (localObject1 != null)
        {
          localObject2 = localObject1;
          localAsyncImageListener.onImageStarted((AsyncImageable)localObject2);
        }
      }
      else
      {
        localObject2 = this.mInternalAsyncListener;
        if (localObject2 != null) {
          if (localObject1 == null) {
            break label53;
          }
        }
      }
      for (;;)
      {
        ((AsyncImageable.AsyncImageListener)localObject2).onImageStarted((AsyncImageable)localObject1);
        return;
        localObject2 = this;
        break;
        label53:
        localObject1 = this;
      }
    }
    
    private void resetAsyncImage()
    {
      this.mUrl = null;
    }
    
    private static void scheduleAnimation(View paramView, Animation paramAnimation, Runnable paramRunnable)
    {
      if ((paramView == null) || (paramAnimation == null))
      {
        if (paramRunnable != null) {
          paramRunnable.run();
        }
        return;
      }
      paramView.clearAnimation();
      paramAnimation.setAnimationListener(new AsyncImageable.AsyncImageableImpl.4(paramRunnable));
      paramView.startAnimation(paramAnimation);
    }
    
    private void setAsyncImageInternal(String paramString, String... paramVarArgs)
    {
      if ((this.mUrl == null) && (paramString == null))
      {
        applyDefaultImage();
        return;
      }
      paramVarArgs = this.mUrl;
      ImageLoader.Options localOptions = this.mOptions;
      if ((paramString == null) && (paramVarArgs != null))
      {
        this.mUrl = null;
        this.mImageLoader.cancel(paramVarArgs, this.mImageLoadListener, localOptions);
        applyDefaultImage();
        return;
      }
      ensureThread("setAsyncImage");
      this.mUrl = paramString;
      this.mLatestUrl = paramString;
      paramVarArgs = this.mOptions;
      this.mOptions = ImageLoader.Options.copy(this.mOptions);
      this.mAsyncOptions.fillOptions(this.mOptions);
      this.mOptions.needCallBackProcessPercent = true;
      this.mOptions.useMainThread = true;
      paramVarArgs = this.mImageView.getLayoutParams();
      if ((paramVarArgs != null) && (paramVarArgs.width > 0) && (paramVarArgs.height > 0))
      {
        this.mOptions.clipWidth = paramVarArgs.width;
        this.mOptions.clipHeight = paramVarArgs.height;
      }
      notifyAsyncImageStart();
      if (this.mAsyncOptions.justMemoryCache) {}
      for (paramString = this.mImageLoader.loadImageSync(paramString, this.mOptions); paramString != null; paramString = this.mImageLoader.loadImage(paramString, this.mImageLoadListener, this.mOptions))
      {
        applyAsyncImage(paramString, false);
        notifyAsyncImageLoaded();
        return;
      }
      applyDefaultImage();
    }
    
    public void finalize()
      throws Throwable
    {
      try
      {
        this.mImageLoader.cancel(this.mUrl, this.mImageLoadListener, this.mOptions);
        return;
      }
      finally
      {
        super.finalize();
      }
    }
    
    public String getAsyncImage()
    {
      return this.mLatestUrl;
    }
    
    public AsyncImageable.AsyncOptions getAsyncOptions()
    {
      return this.mAsyncOptions;
    }
    
    public void setAsyncImage(String paramString)
    {
      setAsyncImage(paramString, EMPTY_STR_ARRAY);
    }
    
    public void setAsyncImage(String paramString, String... paramVarArgs)
    {
      if (Thread.currentThread() != this.mMainThread)
      {
        this.mMainHandler.post(new AsyncImageable.AsyncImageableImpl.2(this, paramString, paramVarArgs));
        return;
      }
      setAsyncImageInternal(paramString, paramVarArgs);
    }
    
    public void setAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
    {
      this.mAsyncListener = paramAsyncImageListener;
    }
    
    public void setInternalAsyncImageListener(AsyncImageable.AsyncImageListener paramAsyncImageListener)
    {
      this.mInternalAsyncListener = paramAsyncImageListener;
    }
    
    static class WeakImageLoadListener
      implements ImageLoader.ImageLoadListener
    {
      private WeakReference<AsyncImageable.AsyncImageableImpl> mAsyncImageableRef;
      
      public WeakImageLoadListener(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
      {
        this.mAsyncImageableRef = new WeakReference(paramAsyncImageableImpl);
      }
      
      private AsyncImageable.AsyncImageableImpl getAsyncImageable()
      {
        return (AsyncImageable.AsyncImageableImpl)this.mAsyncImageableRef.get();
      }
      
      public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
      
      public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
      {
        paramOptions = getAsyncImageable();
        if (paramOptions == null) {}
        while (paramOptions.checkAsyncChanged(paramString)) {
          return;
        }
        paramOptions.applyFailImage();
        paramOptions.resetAsyncImage();
        paramOptions.notifyAsyncImageFailed();
      }
      
      public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
      {
        paramOptions = getAsyncImageable();
        if (paramOptions == null) {}
        while (paramOptions.checkAsyncChanged(paramString)) {
          return;
        }
        paramOptions.applyAsyncImage(paramDrawable, true);
        paramOptions.notifyAsyncImageLoaded();
      }
      
      public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions)
      {
        paramOptions = getAsyncImageable();
        if (paramOptions == null) {}
        while (paramOptions.checkAsyncChanged(paramString)) {
          return;
        }
        paramOptions.notifyAsyncImageProgress(paramFloat);
      }
    }
    
    static class WeakStreamLoadListener
      implements ImageLoader.StreamDownloadListener
    {
      private WeakReference<AsyncImageable.AsyncImageableImpl> mAsyncImageableRef;
      
      public WeakStreamLoadListener(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl)
      {
        this.mAsyncImageableRef = new WeakReference(paramAsyncImageableImpl);
      }
      
      private AsyncImageable.AsyncImageableImpl getAsyncImageable()
      {
        return (AsyncImageable.AsyncImageableImpl)this.mAsyncImageableRef.get();
      }
      
      public void onApplyToImage(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
      {
        paramOptions = getAsyncImageable();
        if (paramOptions == null) {}
        while (paramOptions.checkAsyncChanged(paramString)) {
          return;
        }
        paramOptions.applyAsyncImage(paramDrawable, true);
      }
      
      public void onDownloadCanceled(String paramString1, String paramString2, String paramString3) {}
      
      public void onDownloadFailed(String paramString1, String paramString2, String paramString3) {}
      
      public void onDownloadProgress(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, int paramInt) {}
      
      public void onDownloadSucceed(String paramString1, String paramString2, String paramString3) {}
    }
  }
  
  public static class AsyncOptions
  {
    boolean alwaysLoad = false;
    int clipHeight = -1;
    int clipWidth = -1;
    Drawable defaultImage = null;
    int defaultImageId = 0;
    Drawable failImage = null;
    int failImageId = 0;
    String fileRootPath = null;
    Bitmap.Config imageConfig = ImageLoader.Options.DEFAULT_IMAGE_CONFIG;
    ImageProcessor imageProcessor = null;
    Animation inAnimation = null;
    boolean justCover = true;
    boolean justMemoryCache = false;
    boolean needShowGifAnimation = false;
    Animation outAnimation = null;
    boolean preferQuality = false;
    boolean priority = true;
    RawImageProcessor rawImageProcessor = null;
    boolean tryStream = false;
    
    public final void fillOptions(ImageLoader.Options paramOptions)
    {
      paramOptions.clipWidth = this.clipWidth;
      paramOptions.clipHeight = this.clipHeight;
      paramOptions.preferQuality = this.preferQuality;
      paramOptions.justCover = this.justCover;
      paramOptions.needShowGifAnimation = this.needShowGifAnimation;
      paramOptions.imageConfig = this.imageConfig;
      paramOptions.extraProcessor = this.imageProcessor;
      paramOptions.processor = this.rawImageProcessor;
      paramOptions.priority = this.priority;
      paramOptions.fileRootPath = this.fileRootPath;
    }
    
    protected void onClipSizeChanged(int paramInt1, int paramInt2) {}
    
    public void setAlwaysLoad(boolean paramBoolean)
    {
      if (this.alwaysLoad != paramBoolean) {
        this.alwaysLoad = paramBoolean;
      }
    }
    
    public void setAnimation(Animation paramAnimation1, Animation paramAnimation2)
    {
      if ((this.inAnimation != paramAnimation1) || (this.outAnimation != paramAnimation2))
      {
        this.inAnimation = paramAnimation1;
        this.outAnimation = paramAnimation2;
      }
    }
    
    public void setClipSize(int paramInt1, int paramInt2)
    {
      if ((this.clipWidth != paramInt1) || (this.clipHeight != paramInt2))
      {
        this.clipWidth = paramInt1;
        this.clipHeight = paramInt2;
        onClipSizeChanged(paramInt1, paramInt2);
      }
    }
    
    public void setDefaultImage(int paramInt)
    {
      this.defaultImageId = paramInt;
      this.defaultImage = null;
    }
    
    public void setDefaultImage(Drawable paramDrawable)
    {
      this.defaultImageId = 0;
      this.defaultImage = paramDrawable;
    }
    
    public void setFailImage(int paramInt)
    {
      this.failImageId = paramInt;
      this.failImage = null;
    }
    
    public void setFailImage(Drawable paramDrawable)
    {
      this.failImageId = 0;
      this.failImage = paramDrawable;
    }
    
    public void setFileRootPath(String paramString)
    {
      if ((paramString != null) && (!paramString.equals(this.fileRootPath))) {
        this.fileRootPath = paramString;
      }
      while (paramString != null) {
        return;
      }
      this.fileRootPath = null;
    }
    
    public void setImageConfig(Bitmap.Config paramConfig)
    {
      if (this.imageConfig != paramConfig) {
        this.imageConfig = paramConfig;
      }
    }
    
    public void setImageProcessor(ImageProcessor paramImageProcessor)
    {
      if (this.imageProcessor != paramImageProcessor) {
        this.imageProcessor = paramImageProcessor;
      }
    }
    
    public void setJustCover(boolean paramBoolean)
    {
      if (this.justCover != paramBoolean) {
        this.justCover = paramBoolean;
      }
    }
    
    public void setJustMemoryCache(boolean paramBoolean)
    {
      if (this.justMemoryCache != paramBoolean) {
        this.justMemoryCache = paramBoolean;
      }
    }
    
    public void setNeedShowGifAnimation(boolean paramBoolean)
    {
      if (this.needShowGifAnimation != paramBoolean) {
        this.needShowGifAnimation = paramBoolean;
      }
    }
    
    public void setPreferQuality(boolean paramBoolean)
    {
      if (this.preferQuality != paramBoolean) {
        this.preferQuality = paramBoolean;
      }
    }
    
    public void setPriority(boolean paramBoolean)
    {
      if (this.priority != paramBoolean) {
        this.priority = paramBoolean;
      }
    }
    
    public void setRawImageProcessor(RawImageProcessor paramRawImageProcessor)
    {
      if (this.rawImageProcessor != paramRawImageProcessor) {
        this.rawImageProcessor = paramRawImageProcessor;
      }
    }
    
    public void setTryStream(boolean paramBoolean)
    {
      if (this.tryStream != paramBoolean) {
        this.tryStream = paramBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable
 * JD-Core Version:    0.7.0.1
 */