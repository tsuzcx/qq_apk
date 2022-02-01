package com.tencent.component.media.photogif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageProcessor;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QzoneAnimationDrawable
  extends Drawable
  implements Animatable
{
  public static int LOOP_INFINITE = 0;
  private static final String TAG = "QzoneAnimationDrawable";
  private AnimationListener mAnimationListener;
  private volatile Drawable mCurrentFrame;
  private Drawable mDefaultFrame;
  private final Rect mDstRect = new Rect();
  private ScheduledThreadPoolExecutor mExecutor;
  private ImageLoader.Options mFrameOptions;
  private FrameSwitcher mFrameSwitcher;
  private ImageKey mImageKey;
  private InvalidationHandler mInvalidationHandler;
  private volatile boolean mIsRunning = false;
  private volatile Drawable mNextFrame;
  private volatile int mNextFrameIndex = 0;
  private final Paint mPaint = new Paint();
  private PhotoLoadListener mPhotoLoadListener;
  private int mPlayCount;
  private int mRepeatCount;
  private ScheduledFuture<?> mScheduledFuture;
  private volatile boolean mSwitchFrameWhenLoaded = true;
  
  public QzoneAnimationDrawable(ImageKey paramImageKey)
  {
    this.mImageKey = ImageKey.copy(paramImageKey);
    init();
  }
  
  public QzoneAnimationDrawable(ImageLoader.Options paramOptions)
  {
    this.mImageKey = ImageKey.obtain();
    this.mImageKey.options = ImageLoader.Options.copy(paramOptions);
    init();
  }
  
  private void doBeforeDraw()
  {
    if ((this.mNextFrameIndex - 1 == 0) && (this.mAnimationListener != null)) {
      this.mAnimationListener.onAnimationStart(this);
    }
    if (this.mAnimationListener != null) {
      this.mAnimationListener.onAnimationPlay(this, this.mNextFrameIndex - 1);
    }
  }
  
  private void init()
  {
    this.mFrameOptions = ImageLoader.Options.copy(this.mImageKey.options);
    this.mFrameOptions.needShowPhotoGifAnimation = false;
    this.mFrameOptions.photoList = null;
    this.mExecutor = GifRenderingExecutor.getInstance();
    this.mInvalidationHandler = new InvalidationHandler(this);
    this.mPhotoLoadListener = new PhotoLoadListener(null);
    this.mFrameSwitcher = new FrameSwitcher(null);
    this.mPaint.setARGB(255, 240, 240, 240);
  }
  
  private void loadNextFrame()
  {
    if (this.mNextFrameIndex < this.mImageKey.options.photoList.size())
    {
      String str = (String)this.mImageKey.options.photoList.get(this.mNextFrameIndex);
      ImageLoader.getInstance().loadImageAsync(str, this.mPhotoLoadListener, this.mFrameOptions);
      ImageManagerEnv.getLogger().d("QzoneAnimationDrawable", new Object[] { "loadNextFrame:" + str + ",frameIndex:" + this.mNextFrameIndex });
      if (this.mNextFrameIndex == getFrameCounts() - 1) {
        this.mPlayCount += 1;
      }
      this.mNextFrameIndex = ((this.mNextFrameIndex + 1) % this.mImageKey.options.photoList.size());
      return;
    }
    ImageManagerEnv.getLogger().e("QzoneAnimationDrawable", new Object[] { "loadNextFrame: out of index,mNextFrameIndex:" + this.mNextFrameIndex + ",photosize:" + this.mImageKey.options.photoList.size() });
  }
  
  private void reset()
  {
    if ((this.mScheduledFuture != null) && (!this.mScheduledFuture.isDone())) {
      this.mScheduledFuture.cancel(true);
    }
    this.mIsRunning = true;
    this.mNextFrameIndex = 0;
    this.mCurrentFrame = null;
    this.mNextFrame = null;
    this.mSwitchFrameWhenLoaded = true;
    this.mPlayCount = 0;
    loadNextFrame();
  }
  
  private boolean switchFrame()
  {
    if (!this.mIsRunning) {
      return false;
    }
    if (this.mNextFrame != null) {
      if (canAnimate())
      {
        this.mCurrentFrame = this.mNextFrame;
        this.mNextFrame = null;
        doBeforeDraw();
        if (!this.mInvalidationHandler.hasMessages(0)) {
          this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        loadNextFrame();
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((this.mScheduledFuture != null) && (!this.mScheduledFuture.isDone())) {
        this.mScheduledFuture.cancel(true);
      }
      if ((this.mRepeatCount == LOOP_INFINITE) || (this.mPlayCount < this.mRepeatCount))
      {
        this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
        ImageManagerEnv.getLogger().d("QzoneAnimationDrawable", new Object[] { "------next index:" + this.mNextFrameIndex });
      }
      for (;;)
      {
        return bool;
        if (this.mCurrentFrame != null) {
          break;
        }
        this.mCurrentFrame = this.mNextFrame;
        doBeforeDraw();
        if (this.mInvalidationHandler.hasMessages(0)) {
          break;
        }
        this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        break;
        stop();
        if (this.mAnimationListener != null) {
          this.mAnimationListener.onAnimationEnd(this);
        }
      }
    }
  }
  
  public boolean canAnimate()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mCurrentFrame != null)
    {
      this.mCurrentFrame.setBounds(getBounds());
      this.mCurrentFrame.draw(paramCanvas);
      return;
    }
    if (this.mDefaultFrame != null)
    {
      this.mDefaultFrame.setBounds(getBounds());
      this.mDefaultFrame.draw(paramCanvas);
      return;
    }
    paramCanvas.drawRect(this.mDstRect, this.mPaint);
  }
  
  public int getFrameCounts()
  {
    return this.mImageKey.options.photoList.size();
  }
  
  public long getFrameDuration()
  {
    return this.mImageKey.options.photoDelayTimeInMs;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getIntrinsicHeight();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getIntrinsicHeight();
    }
    return this.mFrameOptions.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getIntrinsicWidth();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getIntrinsicWidth();
    }
    return this.mFrameOptions.clipWidth;
  }
  
  public int getMinimumHeight()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getMinimumHeight();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getMinimumHeight();
    }
    return this.mFrameOptions.clipHeight;
  }
  
  public int getMinimumWidth()
  {
    if (this.mCurrentFrame != null) {
      return this.mCurrentFrame.getMinimumWidth();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getMinimumWidth();
    }
    return this.mFrameOptions.clipWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.mIsRunning;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDstRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationListener(AnimationListener paramAnimationListener)
  {
    this.mAnimationListener = paramAnimationListener;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDrawableForDefaultFrame(Drawable paramDrawable)
  {
    this.mDefaultFrame = paramDrawable;
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.mRepeatCount = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      if (paramBoolean2) {
        reset();
      }
    }
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (this.mIsRunning) {
      return;
    }
    this.mIsRunning = true;
    this.mSwitchFrameWhenLoaded = false;
    if (this.mNextFrame == null) {
      loadNextFrame();
    }
    if ((this.mScheduledFuture != null) && (!this.mScheduledFuture.isDone())) {
      this.mScheduledFuture.cancel(true);
    }
    this.mScheduledFuture = this.mExecutor.schedule(this.mFrameSwitcher, this.mImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
  }
  
  public void stop()
  {
    this.mIsRunning = false;
  }
  
  public static abstract interface AnimationListener
  {
    public abstract void onAnimationEnd(Animatable paramAnimatable);
    
    public abstract void onAnimationPlay(Animatable paramAnimatable, int paramInt);
    
    public abstract void onAnimationStart(Animatable paramAnimatable);
  }
  
  public static class Builder
  {
    long delayTimeInMs;
    ArrayList<String> photos;
    ImageProcessor processor;
    int repeatCount;
    int reqHeight;
    int reqWidth;
    
    public static Builder create()
    {
      return new Builder();
    }
    
    public QzoneAnimationDrawable build()
    {
      Object localObject = ImageLoader.Options.obtain();
      if (this.delayTimeInMs > 0L) {
        ((ImageLoader.Options)localObject).photoDelayTimeInMs = this.delayTimeInMs;
      }
      if (this.reqWidth > 0) {
        ((ImageLoader.Options)localObject).clipWidth = this.reqWidth;
      }
      if (this.reqHeight > 0) {
        ((ImageLoader.Options)localObject).clipHeight = this.reqHeight;
      }
      if (this.photos != null) {}
      for (((ImageLoader.Options)localObject).photoList = this.photos;; ((ImageLoader.Options)localObject).photoList = new ArrayList())
      {
        ((ImageLoader.Options)localObject).extraProcessor = this.processor;
        localObject = new QzoneAnimationDrawable((ImageLoader.Options)localObject);
        if (this.repeatCount > 0) {
          ((QzoneAnimationDrawable)localObject).setRepeatCount(this.repeatCount);
        }
        return localObject;
      }
    }
    
    public Builder setDelayTime(long paramLong)
    {
      this.delayTimeInMs = paramLong;
      return this;
    }
    
    public Builder setPhotos(ArrayList<String> paramArrayList)
    {
      this.photos = paramArrayList;
      return this;
    }
    
    public Builder setProcessor(ImageProcessor paramImageProcessor)
    {
      this.processor = paramImageProcessor;
      return this;
    }
    
    public Builder setRepeatCount(int paramInt)
    {
      this.repeatCount = paramInt;
      return this;
    }
    
    public Builder setReqHeight(int paramInt)
    {
      this.reqHeight = paramInt;
      return this;
    }
    
    public Builder setReqWidth(int paramInt)
    {
      this.reqWidth = paramInt;
      return this;
    }
  }
  
  class FrameSwitcher
    implements Runnable
  {
    private FrameSwitcher() {}
    
    public void run()
    {
      if (!QzoneAnimationDrawable.this.switchFrame()) {
        QzoneAnimationDrawable.access$402(QzoneAnimationDrawable.this, true);
      }
    }
  }
  
  class PhotoLoadListener
    implements ImageLoader.ImageLoadListener
  {
    private PhotoLoadListener() {}
    
    public void onImageCanceled(String paramString, ImageLoader.Options paramOptions)
    {
      QzoneAnimationDrawable.this.loadNextFrame();
    }
    
    public void onImageFailed(String paramString, ImageLoader.Options paramOptions)
    {
      QzoneAnimationDrawable.this.loadNextFrame();
    }
    
    public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
    {
      QzoneAnimationDrawable.access$302(QzoneAnimationDrawable.this, paramDrawable);
      if (QzoneAnimationDrawable.this.mSwitchFrameWhenLoaded)
      {
        QzoneAnimationDrawable.access$402(QzoneAnimationDrawable.this, false);
        QzoneAnimationDrawable.this.switchFrame();
      }
    }
    
    public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */