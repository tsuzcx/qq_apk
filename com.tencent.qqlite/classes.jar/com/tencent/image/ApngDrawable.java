package com.tencent.image;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import android.view.Gravity;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ApngDrawable
  extends Drawable
  implements AnimationCallback
{
  private static final byte[] SIGNATURE = { -119, 80, 78, 71, 13, 10, 26, 10 };
  private int mApngHeight;
  private ApngState mApngState;
  private int mApngWidth;
  private boolean mApplyGravity;
  private final Rect mDstRect = new Rect();
  private int mTargetDensity = 160;
  boolean mUseAnimation = true;
  
  public ApngDrawable(ApngState paramApngState, Resources paramResources)
  {
    this.mApngState = paramApngState;
    paramApngState.mApng.addCallBack(this);
    if (paramResources != null) {}
    for (this.mTargetDensity = paramResources.getDisplayMetrics().densityDpi;; this.mTargetDensity = paramApngState.mTargetDensity)
    {
      computeImageSize();
      return;
    }
  }
  
  public ApngDrawable(ApngImage paramApngImage)
  {
    this(paramApngImage, null);
  }
  
  public ApngDrawable(ApngImage paramApngImage, Resources paramResources)
  {
    this(new ApngState(paramApngImage), paramResources);
    this.mApngState.mTargetDensity = this.mTargetDensity;
  }
  
  public ApngDrawable(File paramFile, Resources paramResources)
    throws IOException
  {
    this(paramFile, paramResources, false);
  }
  
  public ApngDrawable(File paramFile, Resources paramResources, boolean paramBoolean)
    throws IOException
  {
    this(new ApngImage(paramFile, paramBoolean), paramResources);
  }
  
  private void computeImageSize()
  {
    this.mApngWidth = this.mApngState.mApng.getScaledWidth(this.mTargetDensity);
    this.mApngHeight = this.mApngState.mApng.getScaledHeight(this.mTargetDensity);
  }
  
  public static boolean isApngFile(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "r");
    byte[] arrayOfByte = new byte[SIGNATURE.length];
    paramFile.read(arrayOfByte);
    paramFile.close();
    int i = 0;
    for (;;)
    {
      if (i >= SIGNATURE.length) {
        return true;
      }
      if (arrayOfByte[i] != SIGNATURE[i]) {
        return false;
      }
      i += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mApplyGravity)
    {
      Gravity.apply(this.mApngState.mGravity, this.mApngWidth, this.mApngHeight, getBounds(), this.mDstRect);
      this.mApplyGravity = false;
    }
    this.mApngState.mApng.draw(paramCanvas, this.mDstRect, this.mApngState.mPaint, this.mUseAnimation);
  }
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
    this.mApngState.mApng.removeCallBack(this);
  }
  
  public Drawable.ConstantState getConstantState()
  {
    return this.mApngState;
  }
  
  public int getGravity()
  {
    return this.mApngState.mGravity;
  }
  
  public ApngImage getImage()
  {
    return this.mApngState.mApng;
  }
  
  public int getIntrinsicHeight()
  {
    return this.mApngHeight;
  }
  
  public int getIntrinsicWidth()
  {
    return this.mApngWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void invalidateSelf()
  {
    super.invalidateSelf();
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mApplyGravity = true;
  }
  
  public void setAlpha(int paramInt)
  {
    this.mApngState.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mApngState.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.mApngState.mPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.mApngState.mPaint.setFilterBitmap(paramBoolean);
  }
  
  public void setGravity(int paramInt)
  {
    this.mApngState.mGravity = paramInt;
    this.mApplyGravity = true;
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (paramInt != this.mTargetDensity)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.mTargetDensity = i;
      computeImageSize();
      invalidateSelf();
    }
  }
  
  static final class ApngState
    extends Drawable.ConstantState
  {
    ApngImage mApng;
    int mChangingConfigurations;
    int mGravity = 119;
    Paint mPaint = new Paint(6);
    int mTargetDensity = 160;
    
    public ApngState(ApngImage paramApngImage)
    {
      this.mApng = paramApngImage;
    }
    
    public int getChangingConfigurations()
    {
      return this.mChangingConfigurations;
    }
    
    public Drawable newDrawable()
    {
      return new ApngDrawable(this, null);
    }
    
    public Drawable newDrawable(Resources paramResources)
    {
      return new ApngDrawable(this, paramResources);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.image.ApngDrawable
 * JD-Core Version:    0.7.0.1
 */