package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;

public class SliceBitmapDrawable
  extends Drawable
{
  private static final int DEFAULT_PAINT_FLAGS = 6;
  private static final int SLICE_SIZE = 2048;
  private BitmapState mBitmapState;
  private int mHeight;
  private boolean mMutated;
  private int mTargetDensity;
  private int mWidth;
  
  public SliceBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(new BitmapState(paramBitmap), paramResources);
    this.mBitmapState.mTargetDensity = this.mTargetDensity;
  }
  
  public SliceBitmapDrawable(Resources paramResources, SliceBitmap paramSliceBitmap)
  {
    this(new BitmapState(paramSliceBitmap), paramResources);
    this.mBitmapState.mTargetDensity = this.mTargetDensity;
  }
  
  private SliceBitmapDrawable(BitmapState paramBitmapState, Resources paramResources)
  {
    this.mBitmapState = paramBitmapState;
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramBitmapState.mTargetDensity)
    {
      computeBitmapSize();
      return;
    }
  }
  
  private void computeBitmapSize()
  {
    this.mWidth = this.mBitmapState.mSliceBitmap.getScaledWidth(this.mTargetDensity);
    this.mHeight = this.mBitmapState.mSliceBitmap.getScaledHeight(this.mTargetDensity);
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    this.mBitmapState.mSliceBitmap.draw(paramCanvas, localRect, this.mBitmapState.mPaint);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    return this.mBitmapState.mSliceBitmap.getBitmap(paramInt);
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.mBitmapState.mChangingConfigurations;
  }
  
  public int getColumnCount()
  {
    return this.mBitmapState.mSliceBitmap.getColumnCount();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.mBitmapState.mChangingConfigurations = getChangingConfigurations();
    return this.mBitmapState;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mWidth;
  }
  
  public int getOpacity()
  {
    if ((this.mBitmapState.mSliceBitmap.hasAlpha) || (this.mBitmapState.mPaint.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.mBitmapState.mPaint;
  }
  
  public int getRowCount()
  {
    return this.mBitmapState.mSliceBitmap.getRowCount();
  }
  
  public Drawable mutate()
  {
    if ((!this.mMutated) && (super.mutate() == this))
    {
      this.mBitmapState = new BitmapState(this.mBitmapState);
      this.mMutated = true;
    }
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.mBitmapState.mPaint.getAlpha())
    {
      this.mBitmapState.mPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.mBitmapState.mPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mBitmapState.mPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mBitmapState.mPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mBitmapState.mPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.mTargetDensity != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeBitmapSize();
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
  
  static final class BitmapState
    extends Drawable.ConstantState
  {
    int mChangingConfigurations;
    Paint mPaint = new Paint(6);
    SliceBitmap mSliceBitmap;
    int mTargetDensity = 160;
    
    BitmapState(Bitmap paramBitmap)
    {
      this.mSliceBitmap = new SliceBitmap(paramBitmap);
    }
    
    BitmapState(SliceBitmap paramSliceBitmap)
    {
      this.mSliceBitmap = paramSliceBitmap;
    }
    
    BitmapState(BitmapState paramBitmapState)
    {
      this.mSliceBitmap = paramBitmapState.mSliceBitmap;
      this.mChangingConfigurations = paramBitmapState.mChangingConfigurations;
      this.mTargetDensity = paramBitmapState.mTargetDensity;
      this.mPaint = new Paint(paramBitmapState.mPaint);
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new SliceBitmapDrawable(this, null, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new SliceBitmapDrawable(this, paramResources, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.SliceBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */