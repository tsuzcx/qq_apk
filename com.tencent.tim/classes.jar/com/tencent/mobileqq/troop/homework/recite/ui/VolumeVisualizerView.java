package com.tencent.mobileqq.troop.homework.recite.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import atau.a;

public class VolumeVisualizerView
  extends View
{
  private static final int dUE = Color.parseColor("#508DFF");
  private static final int dUF = Color.parseColor("#37BBFE");
  private int bQL;
  private int bQN;
  private int bQO;
  private boolean bfu = true;
  public int[] hp;
  private int mColor;
  private int mCount;
  private Paint mPaint;
  
  public VolumeVisualizerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sQ);
    f(paramContext);
    paramContext.recycle();
  }
  
  private void f(TypedArray paramTypedArray)
  {
    if (paramTypedArray.getInt(2, 0) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bfu = bool;
      this.mCount = paramTypedArray.getInt(3, 30);
      this.bQL = ((int)paramTypedArray.getDimension(5, 15.0F));
      this.mColor = paramTypedArray.getColor(0, -16776961);
      this.hp = new int[this.mCount];
      return;
    }
  }
  
  public void CB(int paramInt)
  {
    this.hp[this.bQN] = paramInt;
    this.bQN += 1;
    if (this.bQN >= this.mCount) {
      this.bQN = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.bQN - 1;
    int j = 0;
    if (j < this.mCount)
    {
      int k = i;
      if (i < 0) {
        k = this.mCount - 1;
      }
      float f2 = this.hp[k];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f1 = f2 / 2.0F;
      f2 = this.bQL * f1;
      if (this.bfu) {}
      for (f1 = j * 2.0F * this.bQL;; f1 = (this.mCount - 1 - j) * 2.0F * this.bQL + this.bQL)
      {
        paramCanvas.drawRoundRect(new RectF(f1, this.bQO - f2, this.bQL + f1, f2 + this.bQO), 6.0F, 6.0F, this.mPaint);
        i = k - 1;
        j += 1;
        break;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mCount;
    paramInt2 = this.bQL;
    int i = this.bQL;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), i * 10 + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bQO = (paramInt2 / 2);
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
      LinearGradient localLinearGradient = new LinearGradient(0.0F, 0.0F, getWidth(), getHeight(), dUE, dUF, Shader.TileMode.CLAMP);
      this.mPaint.setShader(localLinearGradient);
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(this.mColor);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.mColor = paramInt;
    if (this.mPaint != null) {
      this.mPaint.setColor(this.mColor);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.mCount = paramInt;
    this.hp = new int[this.mCount];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.bQL = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.VolumeVisualizerView
 * JD-Core Version:    0.7.0.1
 */