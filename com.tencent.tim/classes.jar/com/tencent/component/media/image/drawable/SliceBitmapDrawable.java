package com.tencent.component.media.image.drawable;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
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
  
  public int getByteCount()
  {
    return this.mBitmapState.mSliceBitmap.getByteCount();
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
    SliceBitmapDrawable.SliceBitmap mSliceBitmap;
    int mTargetDensity = 160;
    
    BitmapState(Bitmap paramBitmap)
    {
      this.mSliceBitmap = new SliceBitmapDrawable.SliceBitmap(paramBitmap);
    }
    
    BitmapState(BitmapState paramBitmapState)
    {
      this.mSliceBitmap = paramBitmapState.mSliceBitmap;
      this.mChangingConfigurations = paramBitmapState.mChangingConfigurations;
      this.mTargetDensity = paramBitmapState.mTargetDensity;
      this.mPaint = new Paint(paramBitmapState.mPaint);
    }
    
    BitmapState(SliceBitmapDrawable.SliceBitmap paramSliceBitmap)
    {
      this.mSliceBitmap = paramSliceBitmap;
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
  
  public static class SliceBitmap
  {
    public static final int DENSITY_NONE = 0;
    public static final int SLICE_SIZE = 2048;
    boolean hasAlpha;
    Bitmap[] mBitmaps;
    int mChangingConfigurations;
    int mColumnCount;
    int mDensity;
    int mHeight;
    int mRowCount;
    int mWidth;
    
    public SliceBitmap(Bitmap paramBitmap)
    {
      if (needSlice(paramBitmap))
      {
        this.mWidth = paramBitmap.getWidth();
        this.mHeight = paramBitmap.getHeight();
        this.mDensity = paramBitmap.getDensity();
        this.hasAlpha = paramBitmap.hasAlpha();
        this.mRowCount = ((this.mWidth + 2048 - 1) / 2048);
        this.mColumnCount = ((this.mHeight + 2048 - 1) / 2048);
        Bitmap[] arrayOfBitmap = new Bitmap[this.mRowCount * this.mColumnCount];
        int i = 0;
        int j = 0;
        while (i < this.mRowCount)
        {
          int k = 0;
          if (k < this.mColumnCount)
          {
            int i1 = i * 2048;
            int i2 = k * 2048;
            int m;
            if (i1 + 2048 > this.mWidth)
            {
              m = this.mWidth - i1;
              label154:
              if (i2 + 2048 <= this.mHeight) {
                break label213;
              }
            }
            label213:
            for (int n = this.mHeight - i2;; n = 2048)
            {
              arrayOfBitmap[j] = Bitmap.createBitmap(paramBitmap, i1, i2, m, n);
              k += 1;
              j += 1;
              break;
              m = 2048;
              break label154;
            }
          }
          i += 1;
        }
        this.mBitmaps = arrayOfBitmap;
        return;
      }
      throw new IllegalArgumentException("the bitmap no need to Slice");
    }
    
    @SuppressLint({"NewApi"})
    public static int getBitmapSize(Bitmap paramBitmap)
    {
      if (paramBitmap == null) {
        return 0;
      }
      if (Build.VERSION.SDK_INT >= 12) {
        return paramBitmap.getByteCount();
      }
      return paramBitmap.getRowBytes() * paramBitmap.getHeight();
    }
    
    public static boolean needSlice(Bitmap paramBitmap)
    {
      return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
    }
    
    public static int scaleFromDensity(int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt2 == 0) || (paramInt2 == paramInt3)) {
        return paramInt1;
      }
      return (paramInt1 * paramInt3 + (paramInt2 >> 1)) / paramInt2;
    }
    
    @TargetApi(11)
    void draw(Canvas paramCanvas, Rect paramRect, Paint paramPaint)
    {
      int m = paramCanvas.save();
      boolean bool = paramCanvas.isHardwareAccelerated();
      int n = paramCanvas.getDensity();
      paramCanvas.translate(paramRect.left, paramRect.top);
      if ((paramRect.width() != this.mWidth) || (paramRect.height() != this.mHeight)) {
        paramCanvas.scale(paramRect.width() / this.mWidth, paramRect.height() / this.mHeight);
      }
      if (!bool) {
        paramCanvas.setDensity(this.mDensity);
      }
      int i = 0;
      int j = 0;
      while (i < this.mRowCount)
      {
        int k = 0;
        while (k < this.mColumnCount)
        {
          paramRect = this.mBitmaps[j];
          if (paramRect != null) {
            paramCanvas.drawBitmap(paramRect, i * 2048, k * 2048, paramPaint);
          }
          k += 1;
          j += 1;
        }
        i += 1;
      }
      if (!bool) {
        paramCanvas.setDensity(n);
      }
      paramCanvas.restoreToCount(m);
    }
    
    public Bitmap getBitmap(int paramInt)
    {
      if ((this.mBitmaps != null) && (this.mBitmaps.length > paramInt)) {
        return this.mBitmaps[paramInt];
      }
      return null;
    }
    
    public final int getByteCount()
    {
      int i = 0;
      Bitmap[] arrayOfBitmap = this.mBitmaps;
      int k = arrayOfBitmap.length;
      int j = 0;
      while (i < k)
      {
        j += getBitmapSize(arrayOfBitmap[i]);
        i += 1;
      }
      return j;
    }
    
    public int getColumnCount()
    {
      return this.mColumnCount;
    }
    
    public final int getHeight()
    {
      return this.mHeight;
    }
    
    public int getRowCount()
    {
      return this.mRowCount;
    }
    
    public int getScaledHeight(int paramInt)
    {
      return scaleFromDensity(getHeight(), this.mDensity, paramInt);
    }
    
    public int getScaledHeight(Canvas paramCanvas)
    {
      return scaleFromDensity(getHeight(), this.mDensity, paramCanvas.getDensity());
    }
    
    public int getScaledHeight(DisplayMetrics paramDisplayMetrics)
    {
      return scaleFromDensity(getHeight(), this.mDensity, paramDisplayMetrics.densityDpi);
    }
    
    public int getScaledWidth(int paramInt)
    {
      return scaleFromDensity(getWidth(), this.mDensity, paramInt);
    }
    
    public int getScaledWidth(Canvas paramCanvas)
    {
      return scaleFromDensity(getWidth(), this.mDensity, paramCanvas.getDensity());
    }
    
    public int getScaledWidth(DisplayMetrics paramDisplayMetrics)
    {
      return scaleFromDensity(getWidth(), this.mDensity, paramDisplayMetrics.densityDpi);
    }
    
    public final int getWidth()
    {
      return this.mWidth;
    }
    
    public final boolean hasAlpha()
    {
      return this.hasAlpha;
    }
    
    public void recyle()
    {
      Bitmap[] arrayOfBitmap = this.mBitmaps;
      int j = arrayOfBitmap.length;
      int i = 0;
      while (i < j)
      {
        Bitmap localBitmap = arrayOfBitmap[i];
        if (localBitmap != null) {
          localBitmap.recycle();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SliceBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */