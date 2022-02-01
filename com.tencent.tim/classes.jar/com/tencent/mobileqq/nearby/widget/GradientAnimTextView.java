package com.tencent.mobileqq.nearby.widget;

import akkj;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;
import atau.a;

public class GradientAnimTextView
  extends TextView
{
  private Matrix J;
  private int JO;
  private ValueAnimator az;
  private int dno;
  private int dnp = -1;
  private int dnq = -1;
  private LinearGradient f;
  private Paint mPaint;
  
  public GradientAnimTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GradientAnimTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.qL);
    this.dnp = paramContext.getColor(1, -1);
    this.dnq = paramContext.getColor(0, -1);
    paramContext.recycle();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.az != null) && (this.az.isRunning())) {
      this.az.cancel();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.az == null)
    {
      this.az = ValueAnimator.ofInt(new int[] { 0, this.JO * 2 });
      this.az.setDuration(1500L);
      this.az.setInterpolator(new LinearInterpolator());
      this.az.setRepeatCount(-1);
      this.az.addUpdateListener(new akkj(this));
      this.az.start();
    }
    if (this.J != null)
    {
      this.J.setTranslate(this.dno, 0.0F);
      this.f.setLocalMatrix(this.J);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.dnp == -1) || (this.dnq == -2)) {}
    do
    {
      do
      {
        return;
      } while (this.JO != 0);
      this.JO = getMeasuredWidth();
    } while (this.JO <= 0);
    this.mPaint = getPaint();
    float f1 = this.JO * -2;
    float f2 = this.JO;
    paramInt1 = this.dnp;
    paramInt2 = this.dnq;
    paramInt3 = this.dnp;
    paramInt4 = this.dnq;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.f = new LinearGradient(f1, 0.0F, f2, 0.0F, new int[] { paramInt1, paramInt2, paramInt3, paramInt4 }, null, localTileMode);
    this.mPaint.setShader(this.f);
    this.J = new Matrix();
  }
  
  public void setGradientAnimColor(int paramInt1, int paramInt2)
  {
    this.dnp = paramInt1;
    this.dnq = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.GradientAnimTextView
 * JD-Core Version:    0.7.0.1
 */