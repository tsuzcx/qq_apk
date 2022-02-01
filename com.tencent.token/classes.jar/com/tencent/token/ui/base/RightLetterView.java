package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.token.global.d;

public class RightLetterView
  extends View
{
  a a;
  Paint b = new Paint();
  private int c = -1;
  private float d;
  private String[] e;
  private int f = -1;
  
  public RightLetterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RightLetterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext.getResources().getDimension(2131296400);
    this.e = d.a;
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    this.b.setAntiAlias(true);
    this.b.setTextSize(this.d);
    this.b.setColor(paramContext.getResources().getColor(2131493023));
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
    int k = (int)(f1 / getHeight() * this.e.length);
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      if ((j != k) && (paramMotionEvent != null) && (k >= 0) && (k < this.e.length))
      {
        paramMotionEvent.a(k);
        this.c = k;
        continue;
        if ((j != k) && (paramMotionEvent != null) && (k >= 0) && (k < this.e.length))
        {
          paramMotionEvent.a(k);
          this.c = k;
          continue;
          this.c = -1;
        }
      }
    }
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
    while (i < this.e.length)
    {
      float f1 = j / 2;
      float f2 = this.b.measureText(this.e[i]) / 2.0F;
      float f3 = this.f * i + this.f * 3 / 4;
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