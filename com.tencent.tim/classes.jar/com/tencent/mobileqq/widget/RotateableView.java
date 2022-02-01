package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import arim;

public class RotateableView
  extends View
{
  private float BW;
  private int bwA;
  Handler dO = new arim(this);
  private int ehZ;
  private int eia;
  private Bitmap gO;
  private boolean isRotate;
  private Context mContext;
  
  public RotateableView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RotateableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void eiM()
  {
    this.isRotate = true;
    invalidate();
  }
  
  public void eiN()
  {
    this.isRotate = false;
    this.BW = 0.0F;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.rotate(this.BW, this.eia / 2.0F, this.bwA / 2.0F);
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    if (this.gO != null) {
      paramCanvas.drawBitmap(this.gO, 0.0F, 0.0F, localPaint);
    }
    if (this.isRotate)
    {
      this.BW += 8.0F;
      if (this.BW >= 360.0F) {
        this.BW -= 360.0F;
      }
      invalidate();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.gO != null)
    {
      this.bwA = this.gO.getHeight();
      this.eia = this.gO.getWidth();
    }
    setMeasuredDimension(this.eia, this.bwA);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    this.ehZ = paramInt;
    this.gO = BitmapFactory.decodeResource(this.mContext.getResources(), this.ehZ);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RotateableView
 * JD-Core Version:    0.7.0.1
 */