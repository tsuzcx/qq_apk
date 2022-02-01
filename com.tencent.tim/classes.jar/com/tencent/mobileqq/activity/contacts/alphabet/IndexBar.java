package com.tencent.mobileqq.activity.contacts.alphabet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import atau.a;

public class IndexBar
  extends View
{
  private boolean Fr;
  private a a;
  private Paint bo;
  private String[] cU;
  private int cbN = -1;
  private int cbO;
  private int mHeight;
  private Paint mPaint;
  private int mTextColor;
  private float mTextSize;
  private int mWidth;
  private float padding;
  private float qS;
  private float qT;
  
  public IndexBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }
  
  private void aL(Canvas paramCanvas)
  {
    if (this.cU == null) {}
    int j;
    do
    {
      return;
      j = this.cU.length;
    } while (j <= 0);
    int k = this.mHeight / j;
    int i = 0;
    label32:
    if (i < j) {
      if (i != this.cbN) {
        break label114;
      }
    }
    label114:
    for (Paint localPaint = this.bo;; localPaint = this.mPaint)
    {
      float f1 = this.mWidth / 2;
      float f2 = (i + 1) * k;
      float f3 = localPaint.measureText(this.cU[i]) / 2.0F;
      paramCanvas.drawText(this.cU[i], f1, f2 - f3, localPaint);
      i += 1;
      break label32;
      break;
    }
  }
  
  private int aj(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != -2147483648);
    return Math.min(paramInt2, i);
  }
  
  private void cnb()
  {
    this.mPaint = new Paint();
    this.mPaint.setTextSize(this.mTextSize);
    this.mPaint.setColor(this.mTextColor);
    this.mPaint.setTypeface(Typeface.DEFAULT);
    this.mPaint.setTextAlign(Paint.Align.CENTER);
    this.mPaint.setAntiAlias(true);
    this.bo = new Paint();
    this.bo.setTextSize(this.mTextSize);
    this.bo.setTypeface(Typeface.DEFAULT);
    this.bo.setTextAlign(Paint.Align.CENTER);
    this.bo.setColor(this.cbO);
    this.bo.setAntiAlias(true);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.mTextColor = paramContext.getResources().getColor(17170444);
    this.cbO = paramContext.getResources().getColor(17170444);
    this.mTextSize = paramContext.getResources().getDimensionPixelSize(2131297473);
    this.qS = paramContext.getResources().getDimensionPixelSize(2131297474);
    this.qT = paramContext.getResources().getDimension(2131297470);
    this.padding = paramContext.getResources().getDimension(2131297472);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, atau.a.qS);
      this.mTextColor = paramContext.getColor(2, this.mTextColor);
      this.cbO = paramContext.getColor(3, this.cbO);
      this.mTextSize = paramContext.getDimension(5, this.mTextSize);
      this.qS = paramContext.getDimension(6, this.qS);
      this.qT = paramContext.getDimension(1, this.qT);
      this.padding = paramContext.getDimension(4, this.padding);
      paramContext.recycle();
    }
    cnb();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    aL(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.mWidth = getWidth();
    this.mHeight = getHeight();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onMeasure(paramInt1, paramInt2);
    Rect localRect = new Rect();
    this.mPaint.getTextBounds("W", 0, 1, localRect);
    int j = localRect.width();
    int k = (int)this.padding;
    int i1 = localRect.height();
    int i2 = (int)this.padding;
    int m = getPaddingLeft();
    int n = getPaddingRight();
    if (this.cU == null) {}
    for (;;)
    {
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      setMeasuredDimension(aj(paramInt1, j + k + m + n), aj(paramInt2, i + i1 + i2));
      return;
      i = this.cU.length * (i1 + i2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int k = this.cbN;
    int i = -1;
    if (this.cU != null) {
      i = (int)(f1 / this.mHeight * this.cU.length);
    }
    switch (j)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      this.Fr = false;
      if (this.a != null) {
        this.a.Bf(false);
      }
      invalidate();
      return true;
      if (k != i)
      {
        if ((this.cU != null) && (i >= 0) && (i < this.cU.length))
        {
          this.cbN = i;
          if (this.a != null)
          {
            Rect localRect = new Rect();
            this.mPaint.getTextBounds(this.cU[this.cbN], 0, this.cU[this.cbN].length(), localRect);
            k = this.cU.length;
            f1 = this.mHeight / k * (this.cbN + 1);
            float f2 = this.mPaint.measureText(this.cU[this.cbN]) / 2.0F;
            this.a.b(this.cU[i], j, f1 - f2);
          }
        }
        invalidate();
      }
    } while (paramMotionEvent.getAction() != 0);
    this.Fr = true;
    if (this.a != null) {
      this.a.Bf(true);
    }
    invalidate();
    return true;
  }
  
  public void setChooseIndex(int paramInt)
  {
    this.cbN = paramInt;
    invalidate();
  }
  
  public void setLetters(String[] paramArrayOfString)
  {
    this.cU = paramArrayOfString;
    requestLayout();
    invalidate();
  }
  
  public void setOnIndexBarTouchListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void Bf(boolean paramBoolean);
    
    public abstract void b(String paramString, int paramInt, float paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.IndexBar
 * JD-Core Version:    0.7.0.1
 */