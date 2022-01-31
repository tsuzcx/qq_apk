package com.tencent.biz.pubaccount;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PointPageView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public PointPageView(Context paramContext)
  {
    super(paramContext, null);
    a();
  }
  
  public PointPageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.c = 3;
    this.e = this.c;
    this.d = (this.c * 3);
    this.f = 1;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
  }
  
  private void a(Canvas paramCanvas)
  {
    paramCanvas.save();
    int i1 = this.d;
    int m = super.getMeasuredWidth();
    int k = super.getMeasuredHeight();
    m = (m - (this.c + i1) * this.jdField_a_of_type_Int) / 2;
    int i2 = k / 2;
    k = 0;
    if (k < this.g)
    {
      if (k == this.h) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.j);
      }
      for (int n = this.e;; n = this.c)
      {
        paramCanvas.drawCircle(m, i2, n, this.jdField_a_of_type_AndroidGraphicsPaint);
        m = m + n + n + i1;
        k += 1;
        break;
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.i);
      }
    }
    paramCanvas.restore();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    a(paramCanvas);
  }
  
  public void setColor(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setPageIndex(int paramInt)
  {
    this.b = Math.min(Math.max(paramInt, 0), this.jdField_a_of_type_Int - 1);
    this.h = ((int)Math.floor(this.b / this.f));
    super.invalidate();
  }
  
  public void setPageSize(int paramInt)
  {
    this.jdField_a_of_type_Int = Math.max(paramInt, 0);
    this.g = ((int)Math.ceil(this.jdField_a_of_type_Int / this.f));
    super.invalidate();
  }
  
  public void setPointSize(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setPointSpan(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setSelectColor(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setSelectPointSize(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setStep(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PointPageView
 * JD-Core Version:    0.7.0.1
 */