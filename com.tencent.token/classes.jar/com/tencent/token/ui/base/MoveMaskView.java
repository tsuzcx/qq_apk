package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.token.ce;
import java.util.ArrayList;
import java.util.List;

public class MoveMaskView
  extends View
{
  private int A;
  private boolean B = false;
  private bx C;
  int a = -1;
  private Context b;
  private Paint c;
  private Paint d;
  private float e;
  private int f = 1;
  private float g = 120.0F;
  private float h;
  private float i;
  private float j = 60.0F;
  private float k = 20.0F;
  private char[] l = { 65, 66, 67, 68, 69, 70, 66, 67, 68, 69, 71, 72 };
  private List m = new ArrayList();
  private int n = -1;
  private int o = 4;
  private int p = 8;
  private int q = -100;
  private int r = 10;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private String y;
  private int z;
  
  public MoveMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MoveMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, ce.moveMaskView, 0, 0);
    try
    {
      this.s = paramContext.getColor(0, 10526880);
      this.t = paramContext.getColor(1, 8026746);
      this.u = paramContext.getColor(2, -1);
      this.v = paramContext.getColor(3, 6381664);
      this.w = paramContext.getColor(4, 14211288);
      this.x = paramContext.getColor(5, 0);
      paramContext.recycle();
      this.c = new Paint(1);
      this.c.setColor(this.t);
      this.c.setStyle(Paint.Style.FILL);
      this.c.setTextSize(this.j);
      this.d = new Paint(1);
      this.d.setColor(this.w);
      this.d.setStyle(Paint.Style.STROKE);
      this.d.setStrokeWidth(1.0F);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    float f1;
    if (i1 == 1073741824)
    {
      f1 = paramInt;
      return (int)f1;
    }
    if (this.l.length < this.p) {}
    for (float f2 = this.g * this.l.length + this.k * 2.0F;; f2 = this.g * this.p + this.k * 2.0F)
    {
      f1 = f2;
      if (i1 != -2147483648) {
        break;
      }
      f1 = Math.min(f2, paramInt);
      break;
    }
  }
  
  private int a(int paramInt, List paramList)
  {
    int i2;
    if ((paramList == null) || (paramList.size() == 0))
    {
      i2 = -1;
      return i2;
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 >= paramList.size()) {
        break label58;
      }
      i2 = i1;
      if (paramInt == ((Integer)paramList.get(i1)).intValue()) {
        break;
      }
      i1 += 1;
    }
    label58:
    return -1;
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    return (int)(paramMotionEvent.getX() / this.e) + (int)(paramMotionEvent.getY() / (this.h + this.i)) * this.p;
  }
  
  private String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    if (i1 < paramString.length())
    {
      if ((i1 >= paramInt1) && (i1 < paramInt1 + paramInt2)) {
        localStringBuilder.append("*");
      }
      for (;;)
      {
        i1 += 1;
        break;
        localStringBuilder.append(paramString.charAt(i1));
      }
    }
    return localStringBuilder.toString();
  }
  
  private List a(int paramInt1, char[] paramArrayOfChar, int paramInt2)
  {
    if ((paramArrayOfChar == null) || (paramArrayOfChar.length == 0)) {}
    while ((paramInt1 < 0) || (paramInt1 >= paramArrayOfChar.length)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Log.e("MoveMaskView", "--------------------------:");
    int i1 = 0;
    while (i1 < localArrayList.size())
    {
      Log.e("MoveMaskView", "maskIndexs:" + i1 + "--" + localArrayList.get(i1));
      i1 += 1;
    }
    Log.e("MoveMaskView", "--------------------------:");
    if ((paramInt1 >= 0) && (paramInt1 < paramArrayOfChar.length - (paramInt2 - 1))) {
      i1 = 0;
    }
    while (i1 < paramInt2)
    {
      localArrayList.add(i1, Integer.valueOf(paramInt1));
      i1 += 1;
      paramInt1 += 1;
      continue;
      if ((paramInt1 >= paramArrayOfChar.length - (paramInt2 - 1)) && (paramInt1 < paramArrayOfChar.length))
      {
        paramInt1 = paramArrayOfChar.length - paramInt2;
        i1 = paramArrayOfChar.length - 1;
        while (i1 >= paramArrayOfChar.length - paramInt2)
        {
          localArrayList.add(paramArrayOfChar.length - 1 - i1, Integer.valueOf(paramInt1));
          i1 -= 1;
          paramInt1 += 1;
        }
      }
    }
    this.q = ((Integer)localArrayList.get(0)).intValue();
    return localArrayList;
  }
  
  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    float f1;
    if (i1 == 1073741824) {
      f1 = paramInt;
    }
    for (;;)
    {
      return (int)f1;
      float f2 = this.g * 1.5F * this.f;
      f1 = f2;
      if (i1 == -2147483648) {
        f1 = Math.min(f2, paramInt);
      }
    }
  }
  
  public int a(String paramString, Paint paramPaint)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  public bx getListener()
  {
    return this.C;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.m = a(this.n, this.l, this.o);
    if ((this.B) && (this.C != null))
    {
      this.C.a(this.m, a(this.n, String.valueOf(this.l), this.o));
      this.B = false;
    }
    int i1 = 0;
    if (i1 < this.l.length)
    {
      String str = this.l[i1] + "";
      float f2 = this.e / 2.0F - this.c.measureText(str) / 2.0F + i1 % this.p * this.e;
      int i2 = a(str, this.c);
      float f1 = this.h / 2.0F;
      float f3 = i2 / 2.0F + f1 + i1 / this.p * (this.h + this.i);
      float f4;
      if (i1 % this.p == 0)
      {
        f1 = i1 % this.p;
        f4 = this.e;
      }
      float f5;
      float f6;
      for (f1 = this.k / 2.0F + f1 * f4;; f1 = this.e * f1)
      {
        f4 = i1 / this.p;
        f5 = this.h;
        f6 = this.i;
        f4 = this.r + f4 * (f5 + f6);
        f5 = i1 % this.p + 1;
        f5 = this.e * f5;
        f6 = i1 / this.p;
        float f7 = this.h;
        float f8 = this.i;
        f6 = this.h + f6 * (f7 + f8);
        this.c.setColor(this.u);
        paramCanvas.drawRect(f1, f4, f5, f6, this.c);
        if ((this.q > i1) || (i1 >= this.q + this.o)) {
          break label761;
        }
        this.c.setColor(this.v);
        paramCanvas.drawRect(f1, f4, f5, f6, this.c);
        this.c.setColor(this.x);
        this.y = "*";
        this.z = ((int)(this.e / 2.0F - this.c.measureText(this.y) / 2.0F + i1 % this.p * this.e));
        i2 = a(this.y, this.c);
        f7 = this.i / 2.0F;
        this.A = ((int)(i2 + (f7 + f6)));
        paramCanvas.drawText(this.y, this.z, this.A, this.c);
        if (i1 == this.q)
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          paramCanvas.drawLine(f1, f4 - this.r, f1, f6 + this.r, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        if ((this.q + this.o - 1 == i1) && ((i1 == this.l.length - 1) || ((i1 + 1) % this.p == 0)))
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          paramCanvas.drawLine(f5, f4 - this.r, f5, f6 + this.r, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        this.c.setColor(this.s);
        this.c.setStyle(Paint.Style.FILL);
        paramCanvas.drawText(str, f2, f3, this.c);
        i1 += 1;
        break;
        f1 = i1 % this.p;
      }
      label761:
      paramCanvas.drawLine(f1, f4, f5, f4, this.d);
      paramCanvas.drawLine(f1, f6, f5, f6, this.d);
      if (i1 % this.p == 0) {
        paramCanvas.drawLine(f1, f4, f1, f6, this.d);
      }
      for (;;)
      {
        if ((i1 == this.l.length - 1) || ((i1 + 1) % this.p == 0)) {
          paramCanvas.drawLine(f5, f4, f5, f6, this.d);
        }
        this.c.setColor(this.t);
        this.c.setStyle(Paint.Style.FILL);
        paramCanvas.drawText(str, f2, f3, this.c);
        break;
        if ((this.q + this.o == i1) && (i1 % this.p != 0))
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          paramCanvas.drawLine(f1, f4 - this.r, f1, f6 + this.r, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        else
        {
          paramCanvas.drawLine(f1, f4, f1, f6, this.d);
        }
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
    if (this.l.length % this.p == 0)
    {
      this.f = (this.l.length / this.p);
      return;
    }
    this.f = (this.l.length / this.p + 1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = this.g;
    this.e = this.h;
    this.i = (getMeasuredHeight() / this.f - this.h);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (MotionEventCompat.getActionMasked(paramMotionEvent))
    {
    }
    for (;;)
    {
      postInvalidate();
      return true;
      this.B = false;
      int i1 = a(paramMotionEvent);
      if ((i1 >= 0) && (i1 < this.l.length))
      {
        if ((this.m == null) || (this.m.size() == 0)) {
          this.n = i1;
        }
        for (this.a = i1;; this.a = i1)
        {
          Log.d("MoveMaskView", "onTouchEvent: " + this.l[i1]);
          break;
          if ((i1 != this.a) && (a(i1, this.m) == -1)) {
            this.n = i1;
          }
        }
        i1 = a(paramMotionEvent);
        if ((i1 >= 0) && (i1 < this.l.length)) {
          if ((this.m == null) || (this.m.size() == 0))
          {
            this.n = i1;
            this.a = i1;
          }
          else
          {
            if ((i1 != this.a) && (a(i1, this.m) == -1)) {
              if (a(this.a, this.m) != -1) {
                this.n += i1 - this.a;
              }
            }
            for (;;)
            {
              this.a = i1;
              break;
              this.n = i1;
              continue;
              this.n = (i1 - this.a + this.n);
              if (this.n < 0) {
                this.n = 0;
              } else if (this.n >= this.l.length - this.o) {
                this.n = (this.l.length - this.o);
              }
            }
            this.B = true;
          }
        }
      }
    }
  }
  
  public void setMaskNum(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setOnTouchFinishedListener(bx parambx)
  {
    this.C = parambx;
  }
  
  public void setText(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.l = paramString.toCharArray();
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.MoveMaskView
 * JD-Core Version:    0.7.0.1
 */