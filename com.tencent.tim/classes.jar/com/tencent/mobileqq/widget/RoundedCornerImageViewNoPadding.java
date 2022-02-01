package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.PressDarkImageView;

public class RoundedCornerImageViewNoPadding
  extends PressDarkImageView
{
  private int Dk;
  private boolean dbu;
  private int mColor = Color.parseColor("#FFD5D5D5");
  private Path mPath = new Path();
  
  public RoundedCornerImageViewNoPadding(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundedCornerImageViewNoPadding(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
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
    int i = getWidth();
    int j = getHeight();
    RectF localRectF = new RectF(0.0F, 0.0F, i, j);
    if (this.Dk > 0) {
      i = this.Dk;
    }
    for (;;)
    {
      if (!this.dbu)
      {
        this.mPath.reset();
        this.mPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
        this.mPath.setFillType(Path.FillType.EVEN_ODD);
        this.dbu = true;
      }
      paramCanvas.clipPath(this.mPath);
      super.draw(paramCanvas);
      return;
      i /= 30;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.dbu = false;
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("should not be less than 0");
    }
    this.Dk = paramInt;
    this.dbu = false;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding
 * JD-Core Version:    0.7.0.1
 */