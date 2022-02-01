package com.tencent.mobileqq.profile.view;

import algf;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class CircularProgressBar
  extends View
{
  private RectF aL = new RectF();
  private RectF aM = new RectF();
  private int barLength = 60;
  private Paint cf = new Paint();
  private Paint cg = new Paint();
  private boolean cwD;
  private Handler dk = new algf(this);
  private int dsY = 5;
  private int dsZ = 5;
  private int dta = -1442840576;
  private int dtb = -1428300323;
  private int dtd = 2;
  private int dte;
  private int progress;
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void dFF()
  {
    this.cf.setColor(this.dta);
    this.cf.setAntiAlias(true);
    this.cf.setStyle(Paint.Style.STROKE);
    this.cf.setStrokeWidth(this.dsY);
    this.cg.setColor(this.dtb);
    this.cg.setAntiAlias(true);
    this.cg.setStyle(Paint.Style.STROKE);
    this.cg.setStrokeWidth(this.dsZ);
  }
  
  private void dFG()
  {
    this.aL = new RectF(0.0F, 0.0F, getLayoutParams().width, getLayoutParams().height);
    this.aM = new RectF(this.dsY, this.dsY, getLayoutParams().width - this.dsY, getLayoutParams().height - this.dsY);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.aM, 360.0F, 360.0F, false, this.cg);
    if (this.cwD)
    {
      paramCanvas.drawArc(this.aM, this.progress - 90, this.barLength, false, this.cf);
      return;
    }
    paramCanvas.drawArc(this.aM, -90.0F, this.progress, false, this.cf);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    dFG();
    dFF();
    invalidate();
  }
  
  public void setBarColor(int paramInt)
  {
    this.dta = paramInt;
  }
  
  public void setBarLength(int paramInt)
  {
    this.barLength = paramInt;
  }
  
  public void setBarWidth(int paramInt)
  {
    this.dsY = paramInt;
  }
  
  public void setDelayMillis(int paramInt)
  {
    this.dte = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.cwD = false;
    this.progress = paramInt;
    this.dk.sendEmptyMessage(0);
  }
  
  public void setRimColor(int paramInt)
  {
    this.dtb = paramInt;
  }
  
  public void setRimShader(Shader paramShader)
  {
    this.cg.setShader(paramShader);
  }
  
  public void setRimWidth(int paramInt)
  {
    this.dsZ = paramInt;
  }
  
  public void setSpinSpeed(int paramInt)
  {
    this.dtd = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.CircularProgressBar
 * JD-Core Version:    0.7.0.1
 */