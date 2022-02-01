package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class SpecifiedSizeCropByPivotProcessor
  extends CropByPivotProcessor
{
  private boolean hasPivot = false;
  private final int mHeight;
  private final int mWidth;
  
  public SpecifiedSizeCropByPivotProcessor(int paramInt1, int paramInt2)
  {
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
  }
  
  public SpecifiedSizeCropByPivotProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
      this.hasPivot = true;
    }
  }
  
  public int getHeight()
  {
    return this.mHeight;
  }
  
  public int getType()
  {
    return super.getType();
  }
  
  public int getWidth()
  {
    return this.mWidth;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if ((this.mWidth <= 0) || (this.mHeight <= 0)) {}
    int i;
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == this.mWidth) && (j == this.mHeight));
    if ((i >= j * 2) || (this.hasPivot)) {}
    for (paramDrawable = new ScaleDrawable(paramDrawable, 10);; paramDrawable = new ScaleDrawable(paramDrawable, 0))
    {
      paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
      return new SpecifiedDrawable(paramDrawable, this.mWidth, this.mHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor
 * JD-Core Version:    0.7.0.1
 */