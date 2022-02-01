package com.tencent.richmediabrowser.view.page;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.listener.IGalleryScaleListener;

public class ProGallery
  extends Gallery
{
  private IGalleryScaleListener mGalleryScaleListener;
  private int mLimitedCount = 1;
  private OnProGalleryListener mOnPreloadListener;
  private OnProGalleryGestureListener mOnProGalleryGestureListener;
  
  public ProGallery(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProGallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProGallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mOnPreloadListener = null;
    this.mOnProGalleryGestureListener = null;
    this.mGalleryScaleListener = null;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (this.mGalleryScaleListener != null) {
      this.mGalleryScaleListener.onDoubleTap(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if (this.mGalleryScaleListener != null) {
      this.mGalleryScaleListener.onScale(paramScaleGestureDetector);
    }
    return super.onScale(paramScaleGestureDetector);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    boolean bool = super.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    if (this.mOnProGalleryGestureListener != null) {
      this.mOnProGalleryGestureListener.onScroll(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    return bool;
  }
  
  protected void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    super.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    if (this.mOnPreloadListener != null) {
      this.mOnPreloadListener.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  protected void onSlotChanged(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mOnPreloadListener != null) {
      this.mOnPreloadListener.onSlot(paramInt, paramView, paramViewGroup);
    }
  }
  
  protected void onViewCreated(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    int k = 0;
    int n = this.mLimitedCount;
    if ((n == 0) || (this.mOnPreloadListener == null)) {}
    int m;
    label34:
    do
    {
      return;
      m = this.mItemCount;
      int i = 0;
      int j = paramInt;
      if (i < n)
      {
        j -= 1;
        if (j >= 0) {}
      }
      else
      {
        j = paramInt;
        i = k;
      }
      for (;;)
      {
        if (i < n)
        {
          j += 1;
          if (j < m) {}
        }
        else
        {
          if (!paramBoolean2) {
            break;
          }
          if (!paramBoolean1) {
            break label158;
          }
          paramInt = paramInt - n - 1;
          if (paramInt < 0) {
            break;
          }
          this.mOnPreloadListener.onDestroyView(paramInt, null, paramViewGroup);
          return;
          this.mOnPreloadListener.onCreateView(j, null, paramViewGroup);
          i += 1;
          break label34;
        }
        this.mOnPreloadListener.onCreateView(j, null, paramViewGroup);
        i += 1;
      }
      paramInt = paramInt + n + 1;
    } while (paramInt >= m);
    label158:
    this.mOnPreloadListener.onDestroyView(paramInt, null, paramViewGroup);
  }
  
  protected void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (this.mOnPreloadListener != null) {
      this.mOnPreloadListener.onViewDetached(paramInt, paramView, paramViewGroup, paramBoolean);
    }
  }
  
  protected void onZoomBegin(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mOnPreloadListener != null) {
      this.mOnPreloadListener.onscaleBegin(paramInt, paramView, paramViewGroup);
    }
  }
  
  public void setGalleryScaleListener(IGalleryScaleListener paramIGalleryScaleListener)
  {
    this.mGalleryScaleListener = paramIGalleryScaleListener;
  }
  
  public void setGestureListener(OnProGalleryGestureListener paramOnProGalleryGestureListener)
  {
    this.mOnProGalleryGestureListener = paramOnProGalleryGestureListener;
  }
  
  public void setOnNoBlankListener(OnProGalleryListener paramOnProGalleryListener)
  {
    if (paramOnProGalleryListener != this.mOnPreloadListener) {
      this.mOnPreloadListener = paramOnProGalleryListener;
    }
  }
  
  public void setSelection(int paramInt)
  {
    int m = 0;
    super.setSelection(paramInt);
    int n = this.mLimitedCount;
    if ((n == 0) || (this.mOnPreloadListener == null)) {}
    label193:
    for (;;)
    {
      return;
      int i1 = this.mItemCount;
      int i = this.mOldSelectedPosition;
      int j = i - n;
      int k = i + n;
      i = j;
      if (j < 0) {
        i = 0;
      }
      j = k;
      if (k >= i1) {
        j = i1 - 1;
      }
      k = paramInt - n;
      n += paramInt;
      paramInt = k;
      if (k < 0) {
        paramInt = 0;
      }
      k = n;
      if (n >= i1) {
        k = i1 - 1;
      }
      if ((paramInt > j) || (k < i))
      {
        paramInt = i;
        i = j;
      }
      for (;;)
      {
        if (paramInt >= i) {
          break label193;
        }
        while (paramInt <= i)
        {
          this.mOnPreloadListener.onDestroyView(paramInt, null, this);
          paramInt += 1;
        }
        break;
        if (paramInt > i)
        {
          j = paramInt - 1;
          paramInt = i;
          i = j;
        }
        else if (k < j)
        {
          paramInt = k + 1;
          i = j;
        }
        else
        {
          paramInt = 0;
          i = m;
        }
      }
    }
  }
  
  public static abstract interface OnProGalleryGestureListener
  {
    public abstract boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface OnProGalleryListener
  {
    public abstract View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData);
    
    public abstract void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup);
    
    public abstract void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean);
    
    public abstract void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.page.ProGallery
 * JD-Core Version:    0.7.0.1
 */