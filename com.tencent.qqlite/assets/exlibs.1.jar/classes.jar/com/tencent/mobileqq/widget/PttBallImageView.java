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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  
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
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsMatrix.setScale(this.jdField_a_of_type_Float / this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_Float / this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
      float f1 = this.jdField_a_of_type_Int;
      float f2 = this.jdField_a_of_type_Float / 2.0F;
      float f3 = this.jdField_b_of_type_Int;
      float f4 = this.jdField_b_of_type_Float / 2.0F;
      this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(f1 - f2, f3 - f4);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, null);
    }
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void setBitmapWH(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
  }
  
  public void setPos(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PttBallImageView
 * JD-Core Version:    0.7.0.1
 */