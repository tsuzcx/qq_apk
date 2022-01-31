package com.tencent.mobileqq.activity.aio.item;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class AIOSendMask
  extends Drawable
{
  private static final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private static final RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  
  public AIOSendMask(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(paramInt1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = getLevel();
    if (i == 0) {}
    Rect localRect1;
    Rect localRect2;
    int j;
    int k;
    int m;
    do
    {
      return;
      localRect1 = jdField_a_of_type_AndroidGraphicsRect;
      localRect2 = getBounds();
      j = localRect2.width();
      k = localRect2.height();
      k -= (10000 - i) * k / 10000;
      m = paramCanvas.getHeight();
      Gravity.apply(48, j, k, localRect2, localRect1);
    } while ((j <= 0) || (k <= 0));
    this.jdField_a_of_type_JavaLangString = (100 - i / 100 + "%");
    paramCanvas.save();
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_b_of_type_AndroidGraphicsRect);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (paramCanvas.getWidth() - this.jdField_b_of_type_AndroidGraphicsRect.width()) / 2, (this.jdField_b_of_type_AndroidGraphicsRect.height() + m) / 2, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.clipRect(localRect1);
    jdField_a_of_type_AndroidGraphicsRectF.set(localRect2);
    paramCanvas.drawRoundRect(jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_b_of_type_AndroidGraphicsRect);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, (paramCanvas.getWidth() - this.jdField_b_of_type_AndroidGraphicsRect.width()) / 2, (this.jdField_b_of_type_AndroidGraphicsRect.height() + m) / 2, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restore();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AIOSendMask
 * JD-Core Version:    0.7.0.1
 */