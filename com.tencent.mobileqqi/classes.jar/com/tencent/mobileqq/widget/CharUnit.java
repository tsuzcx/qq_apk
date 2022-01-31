package com.tencent.mobileqq.widget;

import android.graphics.Canvas;
import android.graphics.Paint;

public class CharUnit
{
  public static final float a = 0.7F;
  public static final int a = 255;
  public static final float b = 0.7F;
  public static final float c = 0.85F;
  public Paint a;
  public String a;
  private int b;
  public float d;
  public float e;
  public float f;
  public float g;
  public float h;
  public float i = -1.0F;
  private float j;
  private float k;
  private float l;
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    long l3 = System.currentTimeMillis();
    long l2 = paramInt * paramLong2 + paramLong1;
    long l4 = (paramInt + 1) * paramLong2 + paramLong1;
    long l1 = l2;
    paramLong1 = paramLong2;
    if (paramInt != 0)
    {
      paramLong1 = ((float)paramLong2 * 0.85F);
      l1 = l2 - paramLong1;
      paramLong1 = paramLong2 + paramLong1;
    }
    if (l3 < l1)
    {
      this.i = -1.0F;
      if (this.i < 0.0F) {
        break label244;
      }
      this.b = ((int)(255.0F * this.i));
      this.k = (this.e + (1.0F - this.i) * this.h);
      if (this.i > 0.7F) {
        break label211;
      }
      this.l = (this.f - this.f * 0.3F * (this.i / 0.7F));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.b);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.l);
      this.j = this.d;
      return;
      if (l3 < l4)
      {
        this.i = ((float)(paramLong1 + l3 - l4) * 1.0F / (float)paramLong1);
        break;
      }
      this.i = 1.0F;
      break;
      label211:
      this.l = (this.f * 0.7F + this.f * 0.3F * (this.i - 0.7F) / 0.3F);
      continue;
      label244:
      this.b = 0;
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.i >= 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(this.b);
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.j, this.k, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CharUnit
 * JD-Core Version:    0.7.0.1
 */