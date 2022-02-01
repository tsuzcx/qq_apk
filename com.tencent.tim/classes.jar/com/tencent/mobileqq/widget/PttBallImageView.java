package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.widget.ImageView;

public class PttBallImageView
  extends ImageView
{
  private int akn;
  private int ako;
  private Bitmap gM;
  private float height;
  private Matrix matrix = new Matrix();
  private float width;
  
  public PttBallImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public PttBallImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PttBallImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.gM != null)
    {
      this.matrix.setScale(this.width / this.gM.getWidth(), this.height / this.gM.getHeight());
      float f1 = this.akn;
      float f2 = this.width / 2.0F;
      float f3 = this.ako;
      float f4 = this.height / 2.0F;
      this.matrix.postTranslate(f1 - f2, f3 - f4);
      paramCanvas.drawBitmap(this.gM, this.matrix, null);
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.gM = paramBitmap;
  }
  
  public void setBitmapWH(int paramInt1, int paramInt2)
  {
    this.width = paramInt1;
    this.height = paramInt2;
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    this.akn = paramInt1;
    this.ako = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PttBallImageView
 * JD-Core Version:    0.7.0.1
 */