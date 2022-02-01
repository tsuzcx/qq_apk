package com.tencent.biz.tribe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class VideoLayout
  extends FrameLayout
{
  private Path mPath;
  private int mRoundCorner;
  
  public VideoLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.mPath = new Path();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.mRoundCorner > 0)
    {
      if (this.mPath == null) {
        this.mPath = new Path();
      }
      this.mPath.reset();
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), i - j - k + getPaddingLeft(), m - n - i1 + getPaddingTop());
      this.mPath.addRoundRect(localRectF, this.mRoundCorner, this.mRoundCorner, Path.Direction.CCW);
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
    }
    super.draw(paramCanvas);
  }
  
  public void setRoundCorner(int paramInt)
  {
    this.mRoundCorner = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.tribe.VideoLayout
 * JD-Core Version:    0.7.0.1
 */