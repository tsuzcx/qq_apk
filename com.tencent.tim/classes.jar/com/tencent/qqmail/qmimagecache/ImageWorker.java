package com.tencent.qqmail.qmimagecache;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.qqmail.attachment.model.ImageData;
import java.lang.ref.WeakReference;
import moai.core.utilities.Utils;

public abstract class ImageWorker
{
  private static final int FADE_IN_TIME = 200;
  private static final int MESSAGE_CLEAR = 0;
  private static final int MESSAGE_CLOSE = 3;
  private static final int MESSAGE_FLUSH = 2;
  private static final int MESSAGE_INIT_DISK_CACHE = 1;
  private static final String TAG = "ImageWorker";
  private boolean mExitTasksEarly = false;
  private boolean mFadeInBitmap = true;
  private ImageDrawableCache mImageCache;
  private ImageDrawableCache.ImageCacheParams mImageCacheParams;
  private Bitmap mLoadingBitmap;
  protected boolean mPauseWork = false;
  private final Object mPauseWorkLock = new Object();
  protected Resources mResources;
  
  protected ImageWorker(Context paramContext)
  {
    this.mResources = paramContext.getResources();
  }
  
  public static boolean cancelPotentialWork(Object paramObject, ImageView paramImageView)
  {
    paramImageView = getBitmapWorkerTask(paramImageView);
    if (paramImageView != null)
    {
      Object localObject = paramImageView.data;
      if ((localObject == null) || (!localObject.equals(paramObject))) {
        paramImageView.cancel(true);
      }
    }
    else
    {
      return true;
    }
    return false;
  }
  
  public static void cancelWork(ImageView paramImageView)
  {
    paramImageView = getBitmapWorkerTask(paramImageView);
    if (paramImageView != null) {
      paramImageView.cancel(true);
    }
  }
  
  private static BitmapWorkerTask getBitmapWorkerTask(ImageView paramImageView)
  {
    if (paramImageView != null)
    {
      paramImageView = paramImageView.getDrawable();
      if ((paramImageView instanceof AsyncDrawable)) {
        return ((AsyncDrawable)paramImageView).getBitmapWorkerTask();
      }
    }
    return null;
  }
  
  private void setImageDrawable(ImageView paramImageView, Drawable paramDrawable)
  {
    Drawable localDrawable = paramImageView.getBackground();
    if ((localDrawable != null) && ((localDrawable instanceof BitmapDrawable))) {
      ((BitmapDrawable)localDrawable).getBitmap().recycle();
    }
    if (this.mFadeInBitmap)
    {
      paramDrawable = new TransitionDrawable(new Drawable[] { new ColorDrawable(17170445), paramDrawable });
      paramImageView.setBackgroundDrawable(new BitmapDrawable(this.mResources, this.mLoadingBitmap));
      paramImageView.setImageDrawable(paramDrawable);
      paramDrawable.startTransition(200);
      return;
    }
    paramImageView.setImageDrawable(paramDrawable);
  }
  
  public void addImageCache(FragmentActivity paramFragmentActivity, String paramString)
  {
    this.mImageCacheParams = new ImageDrawableCache.ImageCacheParams(paramFragmentActivity, paramString);
    this.mImageCache = ImageDrawableCache.getInstance(paramFragmentActivity.getSupportFragmentManager(), this.mImageCacheParams);
    new CacheAsyncTask().execute(new Object[] { Integer.valueOf(1) });
  }
  
  public void addImageCache(FragmentManager paramFragmentManager, ImageDrawableCache.ImageCacheParams paramImageCacheParams)
  {
    this.mImageCacheParams = paramImageCacheParams;
    this.mImageCache = ImageDrawableCache.getInstance(paramFragmentManager, this.mImageCacheParams);
    new CacheAsyncTask().execute(new Object[] { Integer.valueOf(1) });
  }
  
  public void clearCache()
  {
    new CacheAsyncTask().execute(new Object[] { Integer.valueOf(0) });
  }
  
  protected void clearCacheInternal()
  {
    if (this.mImageCache != null) {
      this.mImageCache.clearCache();
    }
  }
  
  public void closeCache()
  {
    new CacheAsyncTask().execute(new Object[] { Integer.valueOf(3) });
  }
  
  protected void closeCacheInternal()
  {
    if (this.mImageCache != null)
    {
      this.mImageCache.close();
      this.mImageCache = null;
    }
  }
  
  public void flushCache()
  {
    new CacheAsyncTask().execute(new Object[] { Integer.valueOf(2) });
  }
  
  protected void flushCacheInternal()
  {
    if (this.mImageCache != null) {
      this.mImageCache.flush();
    }
  }
  
  protected ImageDrawableCache getImageCache()
  {
    return this.mImageCache;
  }
  
  protected void initDiskCacheInternal()
  {
    if (this.mImageCache != null) {
      this.mImageCache.initDiskCache();
    }
  }
  
  public void loadImage(Object paramObject, ImageView paramImageView, View paramView)
  {
    if (paramObject == null) {
      return;
    }
    if (this.mImageCache != null) {}
    for (BitmapDrawable localBitmapDrawable = this.mImageCache.getBitmapFromMemCache("");; localBitmapDrawable = null)
    {
      Drawable localDrawable = paramImageView.getBackground();
      if ((localDrawable != null) && ((localDrawable instanceof BitmapDrawable))) {
        ((BitmapDrawable)localDrawable).getBitmap().recycle();
      }
      if (localBitmapDrawable != null)
      {
        if (paramView.getVisibility() == 0) {
          paramView.setVisibility(8);
        }
        paramImageView.setImageDrawable(localBitmapDrawable);
        return;
      }
      if (!cancelPotentialWork(paramObject, paramImageView)) {
        break;
      }
      paramView = new BitmapWorkerTask(paramImageView, paramView);
      paramImageView.setImageDrawable(new AsyncDrawable(this.mResources, this.mLoadingBitmap, paramView));
      paramView.executeOnExecutor(AsyncTask.DUAL_THREAD_EXECUTOR, new Object[] { paramObject });
      return;
    }
  }
  
  protected abstract Bitmap processBitmap(Object paramObject);
  
  public void setExitTasksEarly(boolean paramBoolean)
  {
    this.mExitTasksEarly = paramBoolean;
    setPauseWork(false);
  }
  
  public void setImageFadeIn(boolean paramBoolean)
  {
    this.mFadeInBitmap = paramBoolean;
  }
  
  public void setLoadingImage(int paramInt)
  {
    if (this.mLoadingBitmap != null) {
      this.mLoadingBitmap.recycle();
    }
    this.mLoadingBitmap = BitmapFactory.decodeResource(this.mResources, paramInt);
  }
  
  public void setLoadingImage(Bitmap paramBitmap)
  {
    if (this.mLoadingBitmap != null) {
      this.mLoadingBitmap.recycle();
    }
    this.mLoadingBitmap = paramBitmap;
  }
  
  public void setPauseWork(boolean paramBoolean)
  {
    synchronized (this.mPauseWorkLock)
    {
      this.mPauseWork = paramBoolean;
      if (!this.mPauseWork) {
        this.mPauseWorkLock.notifyAll();
      }
      return;
    }
  }
  
  static class AsyncDrawable
    extends BitmapDrawable
  {
    private final WeakReference<ImageWorker.BitmapWorkerTask> bitmapWorkerTaskReference;
    
    public AsyncDrawable(Resources paramResources, Bitmap paramBitmap, ImageWorker.BitmapWorkerTask paramBitmapWorkerTask)
    {
      super(paramBitmap);
      this.bitmapWorkerTaskReference = new WeakReference(paramBitmapWorkerTask);
    }
    
    public ImageWorker.BitmapWorkerTask getBitmapWorkerTask()
    {
      return (ImageWorker.BitmapWorkerTask)this.bitmapWorkerTaskReference.get();
    }
  }
  
  class BitmapWorkerTask
    extends AsyncTask<Object, Void, BitmapDrawable>
  {
    private final WeakReference<View> backViewReference;
    private Object data;
    private final WeakReference<ImageView> imageViewReference;
    
    public BitmapWorkerTask(ImageView paramImageView, View paramView)
    {
      this.imageViewReference = new WeakReference(paramImageView);
      this.backViewReference = new WeakReference(paramView);
    }
    
    private View getAttachedBackView()
    {
      return (View)this.backViewReference.get();
    }
    
    private ImageView getAttachedImageView()
    {
      ImageView localImageView = (ImageView)this.imageViewReference.get();
      if (this == ImageWorker.getBitmapWorkerTask(localImageView)) {
        return localImageView;
      }
      return null;
    }
    
    protected BitmapDrawable doInBackground(Object... paramVarArgs)
    {
      ??? = (ImageData)paramVarArgs[0];
      if ((paramVarArgs[0] instanceof ImageData)) {}
      for (;;)
      {
        synchronized (ImageWorker.this.mPauseWorkLock)
        {
          if (ImageWorker.this.mPauseWork)
          {
            boolean bool = isCancelled();
            if (!bool)
            {
              try
              {
                ImageWorker.this.mPauseWorkLock.wait();
              }
              catch (InterruptedException localInterruptedException) {}
              continue;
            }
          }
          if ((ImageWorker.this.mImageCache == null) || (isCancelled()) || (getAttachedImageView() == null) || (ImageWorker.this.mExitTasksEarly)) {
            break label233;
          }
          ??? = ImageWorker.this.mImageCache.getBitmapFromDiskCache("");
          if ((??? != null) || (isCancelled()) || (getAttachedImageView() == null) || (ImageWorker.this.mExitTasksEarly)) {
            break label228;
          }
          paramVarArgs = ImageWorker.this.processBitmap(paramVarArgs[0]);
          if (paramVarArgs == null) {
            break label226;
          }
          if (Utils.hasHoneycomb())
          {
            paramVarArgs = new BitmapDrawable(ImageWorker.this.mResources, paramVarArgs);
            if (ImageWorker.this.mImageCache != null) {
              ImageWorker.this.mImageCache.addBitmapToCache("", paramVarArgs);
            }
            return paramVarArgs;
          }
        }
        paramVarArgs = new RecyclingBitmapDrawable(ImageWorker.this.mResources, paramVarArgs);
        continue;
        label226:
        return null;
        label228:
        paramVarArgs = (Object[])???;
        continue;
        label233:
        ??? = null;
      }
    }
    
    protected void onCancelled(BitmapDrawable arg1)
    {
      super.onCancelled(???);
      synchronized (ImageWorker.this.mPauseWorkLock)
      {
        ImageWorker.this.mPauseWorkLock.notifyAll();
        return;
      }
    }
    
    protected void onPostExecute(BitmapDrawable paramBitmapDrawable)
    {
      if ((isCancelled()) || (ImageWorker.this.mExitTasksEarly)) {
        paramBitmapDrawable = null;
      }
      ImageView localImageView = getAttachedImageView();
      View localView = getAttachedBackView();
      if ((paramBitmapDrawable != null) && (localImageView != null))
      {
        ImageWorker.this.setImageDrawable(localImageView, paramBitmapDrawable);
        localView.setVisibility(8);
      }
    }
  }
  
  public class CacheAsyncTask
    extends AsyncTask<Object, Void, Void>
  {
    protected CacheAsyncTask() {}
    
    protected Void doInBackground(Object... paramVarArgs)
    {
      switch (((Integer)paramVarArgs[0]).intValue())
      {
      }
      for (;;)
      {
        return null;
        ImageWorker.this.clearCacheInternal();
        continue;
        ImageWorker.this.initDiskCacheInternal();
        continue;
        ImageWorker.this.flushCacheInternal();
        continue;
        ImageWorker.this.closeCacheInternal();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.ImageWorker
 * JD-Core Version:    0.7.0.1
 */