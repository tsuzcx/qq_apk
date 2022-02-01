package com.tencent.mobileqq.activity.qwallet.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import atau.a;

public class KSongVolumeView
  extends View
{
  private int bQL;
  private int bQN;
  private int bQO;
  private boolean bfu = true;
  private int cgC;
  public int[] hp;
  private int mColor;
  private int mCount;
  private int mDefaultHeight;
  private Paint mPaint;
  
  public KSongVolumeView(Context paramContext, AttributeSet paramAttributeSet)
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
      this.mCount = paramTypedArray.getInt(3, 5);
      this.bQL = ((int)paramTypedArray.getDimension(5, 8.0F));
      this.mColor = paramTypedArray.getColor(0, -16776961);
      this.hp = new int[this.mCount];
      this.cgC = ((int)paramTypedArray.getDimension(4, this.bQL));
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
    int i = this.bQN;
    int j = 0;
    i -= 1;
    if (j < this.mCount)
    {
      if (i >= 0) {
        break label184;
      }
      i = this.mCount - 1;
    }
    label184:
    for (;;)
    {
      float f2 = this.hp[i];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f2 = f2 / 2.0F * this.cgC + this.mDefaultHeight / 2;
      if (this.bfu) {}
      for (f1 = j * 2.0F * this.bQL;; f1 = (this.mCount - 1 - j) * 2.0F * this.bQL + this.bQL)
      {
        paramCanvas.drawRect(f1, this.bQO - f2, this.bQL + f1, this.bQO + f2, this.mPaint);
        j += 1;
        i -= 1;
        break;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mCount;
    paramInt2 = this.bQL;
    int i = this.cgC;
    int j = this.mDefaultHeight;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), i * 8 + j + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.bQO = (paramInt2 / 2);
    if (this.mPaint == null)
    {
      this.mPaint = new Paint();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView
 * JD-Core Version:    0.7.0.1
 */