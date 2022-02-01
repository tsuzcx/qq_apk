package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.token.xg;

public class RightLetterView
  extends View
{
  a a;
  Paint b = new Paint();
  private int c = -1;
  private float d;
  private String[] e;
  private int f = -1;
  
  public RightLetterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.getResources().getDimension(2131034251);
    this.e = xg.a;
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    this.b.setAntiAlias(true);
    this.b.setTextSize(this.d);
    this.b.setColor(paramContext.getResources().getColor(2130968757));
  }
  
  public RightLetterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int j = this.c;
    paramMotionEvent = this.a;
    f1 /= getHeight();
    String[] arrayOfString = this.e;
    int k = (int)(f1 * arrayOfString.length);
    switch (i)
    {
    default: 
      break;
    case 2: 
      if ((j != k) && (paramMotionEvent != null) && (k >= 0) && (k < arrayOfString.length))
      {
        paramMotionEvent.a(k);
        this.c = k;
      }
      break;
    case 1: 
      this.c = -1;
      break;
    case 0: 
      if ((j != k) && (paramMotionEvent != null) && (k >= 0) && (k < arrayOfString.length))
      {
        paramMotionEvent.a(k);
        this.c = k;
      }
      break;
    }
    return true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = getWidth();
    if (this.f == -1) {
      this.f = (i / this.e.length);
    }
    i = 0;
    for (;;)
    {
      String[] arrayOfString = this.e;
      if (i >= arrayOfString.length) {
        break;
      }
      float f1 = j / 2;
      float f2 = this.b.measureText(arrayOfString[i]) / 2.0F;
      int k = this.f;
      float f3 = k * i + k * 3 / 4;
      paramCanvas.drawText(this.e[i], f1 - f2, f3, this.b);
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnTouchingLetterChangedListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RightLetterView
 * JD-Core Version:    0.7.0.1
 */