package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundAngleFrameLayout
  extends FrameLayout
{
  private float kY;
  private float kZ;
  private float la;
  private float lb;
  private Paint x = new Paint();
  private Paint y;
  
  public RoundAngleFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.x.setColor(-1);
    this.x.setAntiAlias(true);
    this.x.setStyle(Paint.Style.FILL);
    this.x.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.y = new Paint();
    this.y.setXfermode(null);
  }
  
  private void j(Canvas paramCanvas)
  {
    if (this.kY > 0.0F)
    {
      Path localPath = new Path();
      localPath.moveTo(0.0F, this.kY);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(this.kY, 0.0F);
      localPath.arcTo(new RectF(0.0F, 0.0F, this.kY * 2.0F, this.kY * 2.0F), -90.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.x);
    }
  }
  
  private void k(Canvas paramCanvas)
  {
    if (this.kZ > 0.0F)
    {
      int i = getWidth();
      Path localPath = new Path();
      localPath.moveTo(i - this.kZ, 0.0F);
      localPath.lineTo(i, 0.0F);
      localPath.lineTo(i, this.kZ);
      localPath.arcTo(new RectF(i - this.kZ * 2.0F, 0.0F, i, this.kZ * 2.0F), 0.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.x);
    }
  }
  
  private void l(Canvas paramCanvas)
  {
    if (this.la > 0.0F)
    {
      int i = getHeight();
      Path localPath = new Path();
      localPath.moveTo(0.0F, i - this.la);
      localPath.lineTo(0.0F, i);
      localPath.lineTo(this.la, i);
      localPath.arcTo(new RectF(0.0F, i - this.la * 2.0F, this.la * 2.0F, i), 90.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.x);
    }
  }
  
  private void m(Canvas paramCanvas)
  {
    if (this.lb > 0.0F)
    {
      int i = getHeight();
      int j = getWidth();
      Path localPath = new Path();
      localPath.moveTo(j - this.lb, i);
      localPath.lineTo(j, i);
      localPath.lineTo(j, i - this.lb);
      localPath.arcTo(new RectF(j - this.lb * 2.0F, i - this.lb * 2.0F, j, i), 0.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.x);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.y, 31);
    super.dispatchDraw(paramCanvas);
    j(paramCanvas);
    k(paramCanvas);
    l(paramCanvas);
    m(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setRaduis(int paramInt)
  {
    this.kY = paramInt;
    this.kZ = paramInt;
    this.la = paramInt;
    this.lb = paramInt;
  }
  
  public void setRaduis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.kY = paramInt1;
    this.kZ = paramInt2;
    this.la = paramInt3;
    this.lb = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout
 * JD-Core Version:    0.7.0.1
 */