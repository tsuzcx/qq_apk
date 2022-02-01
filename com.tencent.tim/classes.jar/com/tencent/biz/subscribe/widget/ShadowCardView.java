package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import atau.a;
import ram;

public class ShadowCardView
  extends FrameLayout
{
  private int bxb;
  private int bxc;
  private int bxd;
  private int bxe;
  private int bxf;
  private int bxg;
  private int bxh;
  private int bxi;
  private int bxj;
  private int shadowColor;
  
  public ShadowCardView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ShadowCardView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ShadowCardView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext, paramAttributeSet);
  }
  
  private void b(Context paramContext, AttributeSet paramAttributeSet)
  {
    try
    {
      int i = getResources().getColor(2131167654);
      int j = getResources().getColor(2131167264);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.te);
      this.bxb = paramContext.getDimensionPixelSize(8, 0);
      this.shadowColor = paramContext.getColor(5, j);
      this.bxc = paramContext.getColor(2, i);
      this.bxg = paramContext.getDimensionPixelSize(9, 5);
      this.bxi = paramContext.getDimensionPixelSize(7, 5);
      this.bxh = paramContext.getDimensionPixelSize(6, 5);
      this.bxj = paramContext.getDimensionPixelSize(1, 5);
      this.bxe = paramContext.getDimensionPixelSize(4, 0);
      this.bxf = paramContext.getDimensionPixelSize(3, 0);
      this.bxd = paramContext.getDimensionPixelSize(0, 10);
      paramContext.recycle();
      setPadding(this.bxh, this.bxg, this.bxi, this.bxj);
      setWillNotDraw(false);
      setLayerType(1, null);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        ram.e("ShadowCardView", "init ShadowCardView catch exception");
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i = getPaddingLeft();
    int j = getPaddingTop();
    int k = getWidth();
    int m = getPaddingRight();
    int n = getHeight();
    int i1 = getPaddingBottom();
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.FILL);
    localPaint.setAntiAlias(true);
    localPaint.setColor(this.bxc);
    localPaint.setShadowLayer(this.bxd, this.bxf, this.bxe, this.shadowColor);
    paramCanvas.drawRoundRect(new RectF(i, j, k - m, n - i1), this.bxb, this.bxb, localPaint);
    super.onDraw(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.ShadowCardView
 * JD-Core Version:    0.7.0.1
 */