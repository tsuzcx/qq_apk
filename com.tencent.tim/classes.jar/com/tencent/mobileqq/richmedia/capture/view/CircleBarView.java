package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.TextView;

public class CircleBarView
  extends View
{
  private a jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a;
  private b jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$b;
  private c jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$c;
  private int aKO;
  private int bgColor;
  private int cNa;
  private Paint ck;
  private Paint cl;
  private RectF rectF;
  private TextView textView;
  private float xI;
  private float zd;
  private float ze;
  private float zf;
  private float zg;
  private float zh;
  
  public CircleBarView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }
  
  private int aJ(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    if (j == 1073741824) {
      paramInt2 = i;
    }
    do
    {
      return paramInt2;
      paramInt2 = paramInt1;
    } while (j != -2147483648);
    return Math.min(paramInt1, i);
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.aKO = -16711936;
    this.bgColor = -7829368;
    this.xI = -90.0F;
    this.zf = 360.0F;
    this.zg = dip2px(paramContext, 4.0F);
    this.zd = 0.0F;
    this.ze = 100.0F;
    this.cNa = dip2px(paramContext, 100.0F);
    this.rectF = new RectF();
    this.cl = new Paint();
    this.cl.setStyle(Paint.Style.STROKE);
    this.cl.setColor(this.aKO);
    this.cl.setAntiAlias(true);
    this.cl.setStrokeWidth(this.zg);
    this.cl.setStrokeCap(Paint.Cap.ROUND);
    this.ck = new Paint();
    this.ck.setStyle(Paint.Style.STROKE);
    this.ck.setColor(this.bgColor);
    this.ck.setAntiAlias(true);
    this.ck.setStrokeWidth(this.zg);
    this.ck.setStrokeCap(Paint.Cap.ROUND);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$c = new c();
  }
  
  public void TW(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a = new a();
    this.zd = 100.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a.setDuration(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a.setRepeatCount(-1);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a.setInterpolator(new LinearInterpolator());
    startAnimation(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a);
  }
  
  public boolean kY(int paramInt)
  {
    if (this.ck.getColor() != paramInt)
    {
      this.ck.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  public boolean kZ(int paramInt)
  {
    if (this.cl.getColor() != paramInt)
    {
      this.cl.setColor(paramInt);
      invalidate();
      return true;
    }
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawArc(this.rectF, this.xI, this.zf, false, this.ck);
    paramCanvas.drawArc(this.rectF, this.xI, this.zh, false, this.cl);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt2 = aJ(this.cNa, paramInt2);
    paramInt1 = Math.min(aJ(this.cNa, paramInt1), paramInt2);
    setMeasuredDimension(paramInt1, paramInt1);
    if (paramInt1 >= this.zg * 2.0F) {
      this.rectF.set(this.zg / 2.0F, this.zg / 2.0F, paramInt1 - this.zg / 2.0F, paramInt1 - this.zg / 2.0F);
    }
  }
  
  public void setMaxNum(float paramFloat)
  {
    this.ze = paramFloat;
  }
  
  public void setOnAnimationListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$b = paramb;
  }
  
  public void setTextView(TextView paramTextView)
  {
    this.textView = paramTextView;
  }
  
  public void stopLoading()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a != null) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a.hasStarted())) {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCircleBarView$a.cancel();
    }
    clearAnimation();
  }
  
  public class a
    extends Animation
  {
    public a() {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      CircleBarView.a(CircleBarView.this, CircleBarView.a(CircleBarView.this) * paramFloat * CircleBarView.b(CircleBarView.this) / CircleBarView.c(CircleBarView.this));
      CircleBarView.b(CircleBarView.this, 30.0F);
      if (CircleBarView.a(CircleBarView.this) != null)
      {
        if (CircleBarView.a(CircleBarView.this) != null) {
          CircleBarView.a(CircleBarView.this).setText(CircleBarView.a(CircleBarView.this).a(paramFloat, CircleBarView.b(CircleBarView.this), CircleBarView.c(CircleBarView.this)));
        }
        CircleBarView.a(CircleBarView.this).a(CircleBarView.a(CircleBarView.this), paramFloat, CircleBarView.b(CircleBarView.this), CircleBarView.c(CircleBarView.this));
      }
      CircleBarView.this.postInvalidate();
    }
  }
  
  public static abstract interface b
  {
    public abstract String a(float paramFloat1, float paramFloat2, float paramFloat3);
    
    public abstract void a(Paint paramPaint, float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public class c
    extends Animation
  {
    public c() {}
    
    protected void applyTransformation(float paramFloat, Transformation paramTransformation)
    {
      super.applyTransformation(paramFloat, paramTransformation);
      CircleBarView.a(CircleBarView.this, CircleBarView.a(CircleBarView.this) * paramFloat * CircleBarView.b(CircleBarView.this) / CircleBarView.c(CircleBarView.this));
      CircleBarView.b(CircleBarView.this, 30.0F);
      if (CircleBarView.a(CircleBarView.this) != null)
      {
        if (CircleBarView.a(CircleBarView.this) != null) {
          CircleBarView.a(CircleBarView.this).setText(CircleBarView.a(CircleBarView.this).a(paramFloat, CircleBarView.b(CircleBarView.this), CircleBarView.c(CircleBarView.this)));
        }
        CircleBarView.a(CircleBarView.this).a(CircleBarView.a(CircleBarView.this), paramFloat, CircleBarView.b(CircleBarView.this), CircleBarView.c(CircleBarView.this));
      }
      CircleBarView.this.postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CircleBarView
 * JD-Core Version:    0.7.0.1
 */