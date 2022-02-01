package com.tencent.biz.qqstory.storyHome.discover;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundCornerImageView
  extends PressDarkImageView
{
  private int Dk;
  private boolean aFq;
  private int mBorderWidth;
  private int mColor = Color.parseColor("#FFD5D5D5");
  private Paint mPaint = new Paint();
  private Path mPath = new Path();
  
  public RoundCornerImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mPaint.setColor(this.mColor);
    this.mPaint.setStyle(Paint.Style.STROKE);
    this.mPaint.setAntiAlias(true);
    this.mPaint.setFilterBitmap(true);
    if (Build.VERSION.SDK_INT >= 16) {
      super.setLayerType(2, null);
    }
    while (Build.VERSION.SDK_INT < 14) {
      return;
    }
    super.setLayerType(1, null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mPath == null) {
      this.mPath = new Path();
    }
    this.mPath.reset();
    int i = getWidth() - getPaddingLeft() - getPaddingRight();
    int j = getHeight();
    int k = getPaddingTop();
    int m = getPaddingBottom();
    RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
    if (this.Dk > 0) {
      i = this.Dk;
    }
    for (;;)
    {
      this.mPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      if (this.aFq)
      {
        this.mPaint.setColor(this.mColor);
        if (this.mBorderWidth != 0) {
          this.mPaint.setStrokeWidth(this.mBorderWidth);
        }
        this.mPath.reset();
        this.mPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
        paramCanvas.drawRoundRect(localRectF, i, i, this.mPaint);
      }
      return;
      i /= 30;
    }
  }
  
  public void setBorder(boolean paramBoolean)
  {
    this.aFq = paramBoolean;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.mBorderWidth = paramInt;
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.Dk = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */