package com.tencent.mobileqq.profile.view;

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
import get;

public class CircularProgressBar
  extends View
{
  private int jdField_a_of_type_Int = 60;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Handler jdField_a_of_type_AndroidOsHandler = new get(this);
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = 5;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int c = 5;
  private int d = -1442840576;
  private int e = -1428300323;
  private int f = 2;
  private int g = 0;
  private int h = 0;
  
  public CircularProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.e);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.c);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, getLayoutParams().width, getLayoutParams().height);
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, getLayoutParams().width - this.jdField_b_of_type_Int, getLayoutParams().height - this.jdField_b_of_type_Int);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Shader a()
  {
    return this.jdField_b_of_type_AndroidGraphicsPaint.getShader();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 360.0F, 360.0F, false, this.jdField_b_of_type_AndroidGraphicsPaint);
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, this.h - 90, this.jdField_a_of_type_Int, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, -90.0F, this.h, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b();
    a();
    invalidate();
  }
  
  public void setBarColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBarLength(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setBarWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setDelayMillis(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    this.h = paramInt;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public void setRimColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setRimShader(Shader paramShader)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setShader(paramShader);
  }
  
  public void setRimWidth(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setSpinSpeed(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.CircularProgressBar
 * JD-Core Version:    0.7.0.1
 */