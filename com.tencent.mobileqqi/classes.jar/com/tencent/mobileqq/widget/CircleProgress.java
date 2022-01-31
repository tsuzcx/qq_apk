package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CircleProgress
  extends ImageView
{
  public static final float a = 0.08536585F;
  public static final int a = -90;
  public static final float b = 0.01298701F;
  public static final int b = -9518544;
  public static final int c = 1;
  public static final int d = 2;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Paint b;
  private int e;
  private int f = 2;
  
  public CircleProgress(Context paramContext)
  {
    super(paramContext);
  }
  
  public CircleProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CircleProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-9518544);
    }
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      int i = (int)(getWidth() * 0.01298701F + 0.5F);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(i, i, getWidth() - i, getHeight() - i);
      return;
    }
    float f1 = getWidth() * 0.08536585F;
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(440418368);
    this.b.setStrokeWidth(f1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f1);
    f1 /= 2.0F;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(1 + f1, 1 + f1, getWidth() - f1 - 1, getHeight() - f1 - 1);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a();
    switch (this.f)
    {
    default: 
      return;
    case 2: 
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.e, true, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, 0.0F, 360.0F, false, this.b);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.e, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setSweepAngle(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleProgress
 * JD-Core Version:    0.7.0.1
 */