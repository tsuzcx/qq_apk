package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import atau.a;

public class VolumeChangeView
  extends View
{
  private int Zo;
  private int bQL;
  private int bQM;
  private int bQN;
  private int bQO;
  private int bQP;
  private int bQQ;
  private boolean bfu = true;
  public int[] hp;
  private int mColor;
  private int mCount;
  private Paint mPaint;
  
  public VolumeChangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.sQ);
    f(paramContext);
    paramContext.recycle();
  }
  
  private void f(TypedArray paramTypedArray)
  {
    boolean bool = false;
    if (paramTypedArray.getInt(2, 0) == 0) {
      bool = true;
    }
    this.bfu = bool;
    this.mCount = paramTypedArray.getInt(3, 5);
    this.bQL = ((int)paramTypedArray.getDimension(5, 8.0F));
    this.bQM = ((int)paramTypedArray.getDimension(4, 48.0F));
    this.mColor = getResources().getColor(2131167296);
    this.bQP = getResources().getColor(2131167295);
    this.bQQ = getResources().getDimensionPixelOffset(2131299742);
    this.hp = new int[this.mCount];
  }
  
  public void CB(int paramInt)
  {
    this.Zo = paramInt;
    if (this.Zo < 1) {
      this.Zo = 1;
    }
    if (this.Zo > 10) {
      this.Zo = 10;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = 0;
    if (i < this.mCount)
    {
      if (this.bfu)
      {
        if (i < this.Zo)
        {
          this.mPaint.setColor(this.bQP);
          label41:
          if (i != 0) {
            break label108;
          }
        }
        label108:
        for (f = 0.0F;; f = (this.bQQ + this.bQL) * i)
        {
          paramCanvas.drawRect(f, this.bQO - this.bQM / 2, f + this.bQL, this.bQO + this.bQM / 2, this.mPaint);
          i += 1;
          break;
          this.mPaint.setColor(this.mColor);
          break label41;
        }
      }
      if (i < this.Zo)
      {
        this.mPaint.setColor(this.bQP);
        label143:
        if (i != this.mCount - 1) {
          break label172;
        }
      }
      label172:
      for (float f = 0.0F;; f = (this.mCount - 1 - i) * (this.bQQ + this.bQL))
      {
        break;
        this.mPaint.setColor(this.mColor);
        break label143;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.mCount;
    paramInt2 = this.bQL;
    int i = this.bQQ;
    int j = this.bQM;
    setMeasuredDimension(paramInt1 * (paramInt2 + i) + getPaddingLeft() + getPaddingRight(), j + getPaddingTop() + getPaddingBottom());
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
  
  public void reset()
  {
    if (this.hp != null)
    {
      int i = 0;
      while (i < this.hp.length)
      {
        this.hp[i] = 0;
        i += 1;
      }
      this.bQN = 0;
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.bQP = paramInt;
    if (this.mPaint != null) {
      this.mPaint.setColor(this.bQP);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView
 * JD-Core Version:    0.7.0.1
 */