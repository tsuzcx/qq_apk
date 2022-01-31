package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressCircle
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private int b;
  private int c;
  
  public ProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.b = 2;
    this.c = 18;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if (i != j) {
      if (i < j) {
        j = i;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      paramCanvas.drawColor(0);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = (this.b / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.top = (this.b / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i - this.b / 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - this.b / 2);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427488));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(getResources().getColor(2131427488));
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b * 2);
      this.jdField_a_of_type_AndroidGraphicsRectF.left = this.b;
      this.jdField_a_of_type_AndroidGraphicsRectF.top = this.b;
      this.jdField_a_of_type_AndroidGraphicsRectF.right = (i - this.b);
      this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (j - this.b);
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, 360.0F * (this.jdField_a_of_type_Int / 100.0F), false, this.jdField_a_of_type_AndroidGraphicsPaint);
      i /= 2;
      j /= 2;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
      paramCanvas.drawRect(new RectF(i - this.c / 2, j - this.c / 2, i + this.c / 2, j + this.c / 2), this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
      i = j;
      break;
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressCircle
 * JD-Core Version:    0.7.0.1
 */