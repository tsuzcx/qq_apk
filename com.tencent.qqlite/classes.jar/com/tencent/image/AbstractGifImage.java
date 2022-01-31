package com.tencent.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class AbstractGifImage
{
  public static final int DENSITY_NONE = 0;
  private static final int PENDING_ACTION_CAPACITY = 100;
  protected static ArgumentsRunnable<WeakReference<AbstractGifImage>> sAccumulativeRunnable;
  protected static boolean sPaused = false;
  protected static final ArrayList<WeakReference<AbstractGifImage>> sPendingActions = new ArrayList(105)
  {
    private void ensureCapacity()
    {
      int i = size();
      if (i > 100) {
        removeRange(0, i - 100 - 1);
      }
    }
    
    public boolean add(WeakReference<AbstractGifImage> paramAnonymousWeakReference)
    {
      boolean bool = super.add(paramAnonymousWeakReference);
      ensureCapacity();
      return bool;
    }
  };
  protected static Handler sUIThreadHandler;
  public float mDefaultRoundCorner = 0.0F;
  protected int mDensity = 160;
  protected Vector<WeakReference<GifDrawable>> mDrawableList = new Vector();
  protected boolean mIsInPendingAction = false;
  
  public static final void pauseAll()
  {
    sPaused = true;
  }
  
  public static final void resumeAll()
  {
    sPaused = false;
    int i = sPendingActions.size() - 1;
    for (;;)
    {
      if (i < 0)
      {
        sPendingActions.clear();
        return;
      }
      AbstractGifImage localAbstractGifImage = (AbstractGifImage)((WeakReference)sPendingActions.get(i)).get();
      if (localAbstractGifImage != null) {
        localAbstractGifImage.reDraw();
      }
      i -= 1;
    }
  }
  
  private static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
      return paramInt1;
    }
    return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
  }
  
  protected abstract void applyNextFrame();
  
  public void attachDrawable(GifDrawable paramGifDrawable)
  {
    if (paramGifDrawable != null) {
      synchronized (this.mDrawableList)
      {
        if (!this.mDrawableList.contains(paramGifDrawable)) {
          this.mDrawableList.add(new WeakReference(paramGifDrawable));
        }
        return;
      }
    }
  }
  
  public void detachDrawable(GifDrawable paramGifDrawable)
  {
    Vector localVector;
    int i;
    if (paramGifDrawable != null)
    {
      localVector = this.mDrawableList;
      i = 0;
    }
    for (;;)
    {
      try
      {
        if (i >= this.mDrawableList.size()) {
          return;
        }
        localObject = (WeakReference)this.mDrawableList.get(i);
        if ((localObject == null) || (((WeakReference)localObject).get() == null))
        {
          localObject = this.mDrawableList;
          j = i - 1;
        }
      }
      finally
      {
        Object localObject;
        int j;
        continue;
        continue;
      }
      try
      {
        ((Vector)localObject).remove(i);
        i = j;
        i += 1;
      }
      finally {}
    }
    if (((WeakReference)localObject).get() == paramGifDrawable)
    {
      paramGifDrawable = this.mDrawableList;
      paramGifDrawable.remove(i);
      return;
      throw paramGifDrawable;
    }
  }
  
  protected void doApplyNextFrame()
  {
    applyNextFrame();
    if (!sPaused) {
      invalidateSelf();
    }
    while (this.mIsInPendingAction) {
      return;
    }
    sPendingActions.add(new WeakReference(this));
    this.mIsInPendingAction = true;
  }
  
  protected abstract void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint, boolean paramBoolean);
  
  protected abstract void executeNewTask();
  
  public abstract int getByteSize();
  
  public abstract int getHeight();
  
  public int getScaledHeight(int paramInt)
  {
    return scaleFromDensity(getHeight(), this.mDensity, paramInt);
  }
  
  public int getScaledWidth(int paramInt)
  {
    return scaleFromDensity(getWidth(), this.mDensity, paramInt);
  }
  
  public abstract int getWidth();
  
  protected final void initHandlerAndRunnable()
  {
    if (sUIThreadHandler == null)
    {
      sUIThreadHandler = new Handler();
      sAccumulativeRunnable = new DoAccumulativeRunnable();
    }
  }
  
  protected void invalidateSelf()
  {
    Vector localVector = this.mDrawableList;
    int i = 0;
    for (;;)
    {
      Object localObject1;
      int j;
      try
      {
        if (i >= this.mDrawableList.size()) {
          return;
        }
        localObject1 = (WeakReference)this.mDrawableList.get(i);
        if ((localObject1 == null) || (((WeakReference)localObject1).get() == null))
        {
          localObject1 = this.mDrawableList;
          j = i - 1;
        }
      }
      finally {}
      try
      {
        ((Vector)localObject1).remove(i);
        i = j;
        i += 1;
      }
      finally
      {
        break;
      }
      ((GifDrawable)((WeakReference)localObject1).get()).invalidateSelf();
    }
    throw localObject2;
  }
  
  protected void reDraw()
  {
    invalidateSelf();
    this.mIsInPendingAction = false;
  }
  
  public void reset() {}
  
  public void setDensity(int paramInt)
  {
    this.mDensity = paramInt;
  }
  
  public static class DoAccumulativeRunnable
    extends ArgumentsRunnable<WeakReference<AbstractGifImage>>
  {
    public static int DELAY = 100;
    private long lastRefreshTime = 0L;
    
    protected void run(List<WeakReference<AbstractGifImage>> paramList)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext())
        {
          this.lastRefreshTime = SystemClock.uptimeMillis();
          return;
        }
        Object localObject = (WeakReference)paramList.next();
        if (localObject != null)
        {
          localObject = (AbstractGifImage)((WeakReference)localObject).get();
          if (localObject != null) {
            ((AbstractGifImage)localObject).doApplyNextFrame();
          }
        }
      }
    }
    
    protected void submit()
    {
      long l = SystemClock.uptimeMillis();
      if ((this.lastRefreshTime == 0L) || (l - this.lastRefreshTime > DELAY))
      {
        run();
        this.lastRefreshTime = l;
        return;
      }
      AbstractGifImage.sUIThreadHandler.postDelayed(this, DELAY - (l - this.lastRefreshTime));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.AbstractGifImage
 * JD-Core Version:    0.7.0.1
 */