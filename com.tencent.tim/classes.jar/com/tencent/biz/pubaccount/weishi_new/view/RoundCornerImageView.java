package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class RoundCornerImageView
  extends KandianUrlImageView
{
  private int Dk;
  private int mMode = 0;
  private Path mPath = new Path();
  private RectF mRectF = new RectF();
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i;
    if (this.Dk > 0)
    {
      this.mPath.reset();
      i = getWidth() - getPaddingLeft() - getPaddingRight();
      int j = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      this.mRectF.left = getPaddingLeft();
      this.mRectF.top = getPaddingTop();
      this.mRectF.right = (getPaddingLeft() + i);
      this.mRectF.bottom = (j - k - m + getPaddingTop());
      if (this.Dk <= 0) {
        break label173;
      }
      i = this.Dk;
      if (this.mMode != 0) {
        break label183;
      }
      this.mPath.addRoundRect(this.mRectF, i, i, Path.Direction.CCW);
    }
    for (;;)
    {
      this.mPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.mPath);
      super.onDraw(paramCanvas);
      return;
      label173:
      i /= 30;
      break;
      label183:
      if (this.mMode == 1)
      {
        float f1 = i;
        float f2 = i;
        float f3 = i;
        float f4 = i;
        Path localPath = this.mPath;
        RectF localRectF = this.mRectF;
        Path.Direction localDirection = Path.Direction.CCW;
        localPath.addRoundRect(localRectF, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F }, localDirection);
      }
    }
  }
  
  public void setCorner(int paramInt)
  {
    setCorner(paramInt, 0);
  }
  
  public void setCorner(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return;
    }
    this.mMode = paramInt2;
    this.Dk = paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */