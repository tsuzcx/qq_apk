package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.token.ry.a;
import java.util.ArrayList;
import java.util.List;

public class MoveMaskView
  extends View
{
  private int A;
  private boolean B = false;
  private a C;
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
  private List<Integer> m = new ArrayList();
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
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, ry.a.moveMaskView, 0, 0);
    try
    {
      this.s = paramContext.getColor(3, 10526880);
      this.t = paramContext.getColor(4, 8026746);
      this.u = paramContext.getColor(5, -1);
      this.v = paramContext.getColor(1, 6381664);
      this.w = paramContext.getColor(0, 14211288);
      this.x = paramContext.getColor(2, 0);
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
  
  private static int a(int paramInt, List<Integer> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return -1;
      }
      int i1 = 0;
      while (i1 < paramList.size())
      {
        if (paramInt == ((Integer)paramList.get(i1)).intValue()) {
          return i1;
        }
        i1 += 1;
      }
      return -1;
    }
    return -1;
  }
  
  private int a(MotionEvent paramMotionEvent)
  {
    int i1 = (int)(paramMotionEvent.getX() / this.e);
    return (int)(paramMotionEvent.getY() / (this.h + this.i)) * this.p + i1;
  }
  
  private static int a(String paramString, Paint paramPaint)
  {
    Rect localRect = new Rect();
    paramPaint.getTextBounds(paramString, 0, paramString.length(), localRect);
    return localRect.height();
  }
  
  private static String a(int paramInt1, String paramString, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = 0;
    while (i1 < paramString.length())
    {
      if ((i1 >= paramInt1) && (i1 < paramInt1 + paramInt2)) {
        localStringBuilder.append("*");
      } else {
        localStringBuilder.append(paramString.charAt(i1));
      }
      i1 += 1;
    }
    return localStringBuilder.toString();
  }
  
  public a getListener()
  {
    return this.C;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int i2 = this.n;
    char[] arrayOfChar = this.l;
    int i3 = this.o;
    StringBuilder localStringBuilder = null;
    Object localObject = localStringBuilder;
    if (arrayOfChar != null) {
      if (arrayOfChar.length == 0)
      {
        localObject = localStringBuilder;
      }
      else
      {
        localObject = localStringBuilder;
        if (i2 >= 0) {
          if (i2 >= arrayOfChar.length)
          {
            localObject = localStringBuilder;
          }
          else
          {
            localObject = new ArrayList();
            i1 = 0;
            while (i1 < ((List)localObject).size())
            {
              localStringBuilder = new StringBuilder("maskIndexs:");
              localStringBuilder.append(i1);
              localStringBuilder.append("--");
              localStringBuilder.append(((List)localObject).get(i1));
              i1 += 1;
            }
            if ((i2 >= 0) && (i2 < arrayOfChar.length - (i3 - 1)))
            {
              i1 = i2;
              i2 = 0;
            }
            while (i2 < i3)
            {
              ((List)localObject).add(i2, Integer.valueOf(i1));
              i2 += 1;
              i1 += 1;
              continue;
              if ((i2 >= arrayOfChar.length - (i3 - 1)) && (i2 < arrayOfChar.length))
              {
                i1 = arrayOfChar.length - i3;
                i2 = arrayOfChar.length - 1;
                while (i2 >= arrayOfChar.length - i3)
                {
                  ((List)localObject).add(arrayOfChar.length - 1 - i2, Integer.valueOf(i1));
                  i2 -= 1;
                  i1 += 1;
                }
              }
            }
            this.q = ((Integer)((List)localObject).get(0)).intValue();
          }
        }
      }
    }
    this.m = ((List)localObject);
    if ((this.B) && (this.C != null))
    {
      a(this.n, String.valueOf(this.l), this.o);
      this.B = false;
    }
    int i1 = 0;
    while (i1 < this.l.length)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.l[i1]);
      localObject = ((StringBuilder)localObject).toString();
      float f2 = this.e / 2.0F - this.c.measureText((String)localObject) / 2.0F + i1 % this.p * this.e;
      i2 = a((String)localObject, this.c);
      float f1 = this.h;
      float f3 = f1 / 2.0F;
      float f4 = i2 / 2.0F;
      i2 = this.p;
      f3 = f3 + f4 + i1 / i2 * (f1 + this.i);
      if (i1 % i2 == 0) {
        f1 = i1 % i2 * this.e + this.k / 2.0F;
      } else {
        f1 = i1 % i2 * this.e;
      }
      i2 = this.p;
      float f6 = i1 / i2;
      f4 = this.h;
      float f5 = this.i;
      f6 = f6 * (f4 + f5) + this.r;
      float f7 = (i1 % i2 + 1) * this.e;
      f4 = i1 / i2 * (f5 + f4) + f4;
      this.c.setColor(this.u);
      paramCanvas.drawRect(f1, f6, f7, f4, this.c);
      i2 = this.q;
      if ((i2 <= i1) && (i1 < i2 + this.o))
      {
        this.c.setColor(this.v);
        paramCanvas.drawRect(f1, f6, f7, f4, this.c);
        this.c.setColor(this.x);
        this.y = "*";
        this.z = ((int)(this.e / 2.0F - this.c.measureText(this.y) / 2.0F + i1 % this.p * this.e));
        i2 = a(this.y, this.c);
        this.A = ((int)(f4 + this.i / 2.0F + i2));
        paramCanvas.drawText(this.y, this.z, this.A, this.c);
        if (i1 == this.q)
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          i2 = this.r;
          paramCanvas.drawLine(f1, f6 - i2, f1, f4 + i2, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        if ((this.q + this.o - 1 == i1) && ((i1 == this.l.length - 1) || ((i1 + 1) % this.p == 0)))
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          i2 = this.r;
          paramCanvas.drawLine(f7, f6 - i2, f7, f4 + i2, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        this.c.setColor(this.s);
        this.c.setStyle(Paint.Style.FILL);
        paramCanvas.drawText((String)localObject, f2, f3, this.c);
      }
      else
      {
        paramCanvas.drawLine(f1, f6, f7, f6, this.d);
        paramCanvas.drawLine(f1, f4, f7, f4, this.d);
        i2 = this.p;
        if ((i1 % i2 != 0) && (this.q + this.o == i1) && (i1 % i2 != 0))
        {
          this.d.setColor(this.v);
          this.d.setStrokeWidth(this.k);
          i2 = this.r;
          paramCanvas.drawLine(f1, f6 - i2, f1, f4 + i2, this.d);
          this.d.setColor(this.w);
          this.d.setStrokeWidth(1.0F);
        }
        else
        {
          paramCanvas.drawLine(f1, f6, f1, f4, this.d);
        }
        if ((i1 == this.l.length - 1) || ((i1 + 1) % this.p == 0)) {
          paramCanvas.drawLine(f7, f6, f7, f4, this.d);
        }
        this.c.setColor(this.t);
        this.c.setStyle(Paint.Style.FILL);
        paramCanvas.drawText((String)localObject, f2, f3, this.c);
      }
      i1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    float f1;
    if (i1 == 1073741824)
    {
      f1 = paramInt1;
    }
    else
    {
      arrayOfChar = this.l;
      int i2 = arrayOfChar.length;
      int i3 = this.p;
      if (i2 < i3) {
        f1 = this.g * arrayOfChar.length + this.k * 2.0F;
      } else {
        f1 = this.g * i3 + this.k * 2.0F;
      }
      if (i1 == -2147483648) {
        f1 = Math.min(f1, paramInt1);
      }
    }
    paramInt1 = (int)f1;
    i1 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (i1 == 1073741824)
    {
      f1 = paramInt2;
    }
    else
    {
      f1 = this.g * 1.5F * this.f;
      if (i1 == -2147483648) {
        f1 = Math.min(f1, paramInt2);
      }
    }
    setMeasuredDimension(paramInt1, (int)f1);
    char[] arrayOfChar = this.l;
    paramInt1 = arrayOfChar.length;
    paramInt2 = this.p;
    if (paramInt1 % paramInt2 == 0)
    {
      this.f = (arrayOfChar.length / paramInt2);
      return;
    }
    this.f = (arrayOfChar.length / paramInt2 + 1);
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
    int i1;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 2: 
      i1 = a(paramMotionEvent);
      if ((i1 >= 0) && (i1 < this.l.length))
      {
        paramMotionEvent = this.m;
        if ((paramMotionEvent != null) && (paramMotionEvent.size() != 0))
        {
          if ((i1 != this.a) && (a(i1, this.m) == -1))
          {
            if (a(this.a, this.m) != -1) {
              this.n += i1 - this.a;
            } else {
              this.n = i1;
            }
          }
          else
          {
            int i2 = this.a;
            this.n += i1 - i2;
            i2 = this.n;
            if (i2 < 0)
            {
              this.n = 0;
            }
            else
            {
              paramMotionEvent = this.l;
              int i3 = paramMotionEvent.length;
              int i4 = this.o;
              if (i2 >= i3 - i4) {
                this.n = (paramMotionEvent.length - i4);
              }
            }
          }
          this.a = i1;
        }
        else
        {
          this.n = i1;
          this.a = i1;
        }
      }
      break;
    case 1: 
      this.B = true;
      break;
    case 0: 
      this.B = false;
      i1 = a(paramMotionEvent);
      if ((i1 >= 0) && (i1 < this.l.length))
      {
        paramMotionEvent = this.m;
        if ((paramMotionEvent != null) && (paramMotionEvent.size() != 0))
        {
          if ((i1 != this.a) && (a(i1, this.m) == -1)) {
            this.n = i1;
          }
        }
        else {
          this.n = i1;
        }
        this.a = i1;
        new StringBuilder("onTouchEvent: ").append(this.l[i1]);
      }
      break;
    }
    postInvalidate();
    return true;
  }
  
  public void setMaskNum(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setOnTouchFinishedListener(a parama)
  {
    this.C = parama;
  }
  
  public void setText(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.l = paramString.toCharArray();
    requestLayout();
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.MoveMaskView
 * JD-Core Version:    0.7.0.1
 */