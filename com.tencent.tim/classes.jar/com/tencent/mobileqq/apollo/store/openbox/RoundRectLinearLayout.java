package com.tencent.mobileqq.apollo.store.openbox;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.RectF;
import android.widget.LinearLayout;

public class RoundRectLinearLayout
  extends LinearLayout
{
  private Path E;
  private Path H;
  private int aXR;
  private boolean bFK;
  private Paint bw = new Paint();
  private int csT;
  private int csU;
  private int csV;
  private int csg;
  private int mHeight;
  private int mWidth;
  
  public RoundRectLinearLayout(Context paramContext)
  {
    super(paramContext);
    this.bw.setAntiAlias(true);
    this.bw.setColor(-1);
    this.bw.setStyle(Paint.Style.FILL);
  }
  
  private void cFz()
  {
    if (this.E == null) {
      this.E = new Path();
    }
    this.E.reset();
    if (this.bFK)
    {
      this.E.moveTo(0.0F, this.mHeight);
      this.E.lineTo(0.0F, 0.0F);
    }
    for (;;)
    {
      this.E.arcTo(new RectF(this.mWidth - this.aXR * 2 - 0, 0, this.mWidth - 0, this.aXR * 2 + 0), -90.0F, 90.0F);
      this.E.arcTo(new RectF(this.mWidth - this.aXR * 2 - 0, this.mHeight - this.aXR * 2 - 0, this.mWidth - 0, this.mHeight - 0), 0.0F, 90.0F);
      this.E.close();
      if (this.csU > 0)
      {
        this.H = new Path();
        this.H.reset();
        this.H.moveTo(this.csV + this.csU, this.mHeight - this.csV);
        this.H.arcTo(new RectF(this.csV, this.mHeight - this.csU * 2 - this.csV, this.csV + this.csU * 2, this.mHeight - this.csV), 90.0F, 90.0F);
        this.H.arcTo(new RectF(this.csV, this.csV, this.csV + this.csU * 2, this.csV + this.csU * 2), 180.0F, 90.0F);
        this.H.arcTo(new RectF(this.mWidth - this.csU * 2 - this.csV, this.csV, this.mWidth - this.csV, this.csV + this.csU * 2), -90.0F, 90.0F);
        this.H.arcTo(new RectF(this.mWidth - this.csU * 2 - this.csV, this.mHeight - this.csU * 2 - this.csV, this.mWidth - this.csV, this.mHeight - this.csV), 0.0F, 90.0F);
        this.H.close();
      }
      return;
      this.E.moveTo(this.aXR + 0, this.mHeight - 0);
      this.E.arcTo(new RectF(0, this.mHeight - this.aXR * 2 - 0, this.aXR * 2 + 0, this.mHeight - 0), 90.0F, 90.0F);
      this.E.arcTo(new RectF(0, 0, this.aXR * 2 + 0, this.aXR * 2 + 0), 180.0F, 90.0F);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.E != null)
    {
      this.bw.setColor(this.csg);
      this.bw.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.E, this.bw);
    }
    if ((this.csU > 0) && (this.H != null))
    {
      this.bw.setStyle(Paint.Style.STROKE);
      this.bw.setStrokeWidth(this.csU);
      this.bw.setColor(this.csT);
      paramCanvas.drawPath(this.H, this.bw);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if ((paramInt1 != this.mWidth) || (paramInt2 != this.mHeight))
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      cFz();
    }
  }
  
  public void setInnerRoundRect(int paramInt1, int paramInt2, int paramInt3)
  {
    this.csT = paramInt1;
    this.csU = paramInt2;
    this.csV = paramInt3;
  }
  
  public void setRoundRect(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.aXR != paramInt1)
    {
      this.aXR = paramInt1;
      cFz();
    }
    this.csg = paramInt2;
    this.bFK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.RoundRectLinearLayout
 * JD-Core Version:    0.7.0.1
 */