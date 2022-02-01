package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import jll;

public class RoundRelativeLayout
  extends RelativeLayout
{
  private Path M;
  private RectF rectF;
  private float xE = 16.0F;
  
  public RoundRelativeLayout(Context paramContext)
  {
    super(paramContext);
    init(paramContext, null);
  }
  
  public RoundRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private void dAv()
  {
    this.M.addRoundRect(this.rectF, this.xE, this.xE, Path.Direction.CW);
    QLog.i("RoundRelativeLayout", 2, "roundLayoutRadius " + this.xE);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.xE > 0.0F) && (this.M != null))
    {
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      paramCanvas.clipPath(this.M);
    }
    super.draw(paramCanvas);
  }
  
  public void init(int paramInt)
  {
    this.xE = jll.dp2px(getContext(), paramInt);
    setWillNotDraw(false);
    this.M = new Path();
    this.rectF = new RectF();
  }
  
  public void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.xE = jll.dp2px(getContext(), 16.0F);
    setWillNotDraw(false);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.tc);
      if (paramContext != null)
      {
        this.xE = paramContext.getDimensionPixelSize(0, 0);
        paramContext.recycle();
      }
    }
    this.M = new Path();
    this.rectF = new RectF();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.rectF == null) {
      return;
    }
    this.rectF.set(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
    dAv();
  }
  
  public void setRoundLayoutRadius(float paramFloat)
  {
    this.xE = paramFloat;
    dAv();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.widget.RoundRelativeLayout
 * JD-Core Version:    0.7.0.1
 */