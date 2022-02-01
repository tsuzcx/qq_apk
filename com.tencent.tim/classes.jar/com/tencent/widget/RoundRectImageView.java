package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class RoundRectImageView
  extends ImageView
{
  private int mLastRadius;
  private int mLastRoundMode;
  private int mRadius;
  private int mRoundMode = 0;
  private Path mRoundPath = new Path();
  
  public RoundRectImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public RoundRectImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mRoundPath.setFillType(Path.FillType.EVEN_ODD);
  }
  
  private void checkPathChanged()
  {
    if ((this.mLastRadius == this.mRadius) && (this.mLastRoundMode == this.mRoundMode)) {
      return;
    }
    int i = getWidth();
    int j = getHeight();
    this.mLastRadius = this.mRadius;
    this.mRoundPath.reset();
    switch (this.mRoundMode)
    {
    default: 
      return;
    case 1: 
      this.mRoundPath.addRoundRect(new RectF(0.0F, 0.0F, i, j), this.mRadius, this.mRadius, Path.Direction.CW);
      return;
    case 2: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, 0.0F, 0.0F, 0.0F, 0.0F, f3, f4 }, localDirection);
      return;
    case 3: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      return;
    case 4: 
      localPath = this.mRoundPath;
      localRectF = new RectF(0.0F, 0.0F, i, j);
      f1 = this.mRadius;
      f2 = this.mRadius;
      f3 = this.mRadius;
      f4 = this.mRadius;
      localDirection = Path.Direction.CW;
      localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, f1, f2, f3, f4, 0.0F, 0.0F }, localDirection);
      return;
    }
    Path localPath = this.mRoundPath;
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    float f1 = this.mRadius;
    float f2 = this.mRadius;
    float f3 = this.mRadius;
    float f4 = this.mRadius;
    Path.Direction localDirection = Path.Direction.CW;
    localPath.addRoundRect(localRectF, new float[] { 0.0F, 0.0F, 0.0F, 0.0F, f1, f2, f3, f4 }, localDirection);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRoundMode != 0)
    {
      int i = paramCanvas.save();
      checkPathChanged();
      paramCanvas.clipPath(this.mRoundPath);
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void setCornerRadiusAndMode(int paramInt1, int paramInt2)
  {
    this.mRadius = paramInt1;
    this.mRoundMode = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.RoundRectImageView
 * JD-Core Version:    0.7.0.1
 */