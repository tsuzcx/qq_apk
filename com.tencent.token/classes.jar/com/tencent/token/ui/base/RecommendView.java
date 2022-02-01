package com.tencent.token.ui.base;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.token.bs.a;
import com.tencent.token.global.g;

public class RecommendView
  extends View
{
  private float a = 120.0F;
  private float b;
  private float c;
  private float d;
  private Paint e = new Paint(1);
  private int f;
  private int g;
  private String h;
  private RectF i;
  private Rect j;
  private float k;
  private boolean l = false;
  private boolean m = false;
  private int n;
  private Runnable o = new Runnable()
  {
    public void run()
    {
      g.c("stopBlink");
      RecommendView.this.b();
    }
  };
  
  public RecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.e.setStyle(Paint.Style.FILL);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, bs.a.RecommendView, 0, 0);
    try
    {
      this.b = paramContext.getDimension(2, this.a);
      this.f = paramContext.getColor(1, 2303799);
      this.g = paramContext.getColor(4, 16764211);
      this.h = paramContext.getString(3);
      this.k = paramContext.getDimension(5, 20.0F);
      this.n = paramContext.getInt(0, 3000);
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
    }
    else
    {
      f1 = 3.7F * this.b;
      if (i1 == -2147483648) {
        f1 = Math.min(f1, paramInt);
      }
    }
    return (int)f1;
  }
  
  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    paramInt = View.MeasureSpec.getSize(paramInt);
    float f1;
    if (i1 == 1073741824)
    {
      f1 = paramInt;
    }
    else
    {
      f1 = this.b * 1.5F;
      if (i1 == -2147483648) {
        f1 = Math.min(f1, paramInt);
      }
    }
    return (int)f1;
  }
  
  public void a()
  {
    g.c("startBlink");
    this.l = true;
    if (this.l) {
      postDelayed(this.o, this.n);
    }
    postInvalidate();
  }
  
  public void b()
  {
    this.l = false;
    postInvalidate();
  }
  
  public float getViewHeight()
  {
    return this.c;
  }
  
  public float getViewWidth()
  {
    return this.d;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.e.setColor(this.f);
    this.e.setStyle(Paint.Style.FILL);
    float f1 = this.b;
    float f2 = this.c;
    paramCanvas.drawRect(f1, f2 - f1, this.d, f2, this.e);
    f1 = this.b;
    f2 = f1 / 2.0F;
    float f3 = this.c;
    this.i = new RectF(f2 + 3.0F, f3 - f1, f1 + f1 / 2.0F, f3);
    paramCanvas.drawArc(this.i, 90.0F, 180.0F, true, this.e);
    this.e.setColor(this.g);
    this.e.setTextSize(this.k);
    this.j = new Rect();
    Object localObject = this.e;
    String str = this.h;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.j);
    localObject = this.h;
    f1 = this.b;
    paramCanvas.drawText((String)localObject, f1, this.c - f1 + f1 / 2.0F + this.j.height() / 2, this.e);
    if (this.m)
    {
      this.e.setColor(this.f);
      if (this.l) {
        this.e.setAlpha((int)(Math.random() * 255.0D));
      }
      this.e.setStyle(Paint.Style.FILL);
      this.e.setTextSize(this.k * 1.0F);
      this.e.setStrokeWidth(2.0F);
      f1 = this.b;
      paramCanvas.drawText("+", f1 / 2.0F, this.c - f1 - f1 / 2.0F / 2.0F / 2.0F / 2.0F, this.e);
      this.e.setTextSize(this.k);
      if (this.l) {
        this.e.setAlpha((int)(Math.random() * 255.0D));
      }
      this.e.setStyle(Paint.Style.STROKE);
      this.e.setStrokeWidth(1.0F);
      f1 = this.b;
      paramCanvas.drawCircle(f1 / 2.0F / 2.0F / 2.0F, this.c - f1 + f1 / 2.0F / 2.0F / 2.0F, f1 * 6.0F / 50.0F, this.e);
      if (this.l) {
        this.e.setAlpha((int)(Math.random() * 255.0D));
      }
      this.e.setStyle(Paint.Style.FILL);
      f1 = this.b;
      paramCanvas.drawCircle(f1 / 2.0F / 2.0F, f1 / 2.0F / 2.0F / 2.0F / 2.0F + f1, f1 * 4.0F / 50.0F, this.e);
      if (this.l) {
        this.e.setAlpha((int)(Math.random() * 255.0D));
      }
      f1 = this.b;
      paramCanvas.drawCircle(f1 / 2.0F, f1 / 2.0F + f1 / 2.0F / 2.0F / 2.0F, f1 * 2.0F / 50.0F, this.e);
      this.e.setAlpha(255);
      if (this.l) {
        postInvalidateDelayed(100L);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1), b(paramInt2));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.c = getMeasuredHeight();
    this.d = getMeasuredWidth();
  }
  
  public void setShowBink(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RecommendView
 * JD-Core Version:    0.7.0.1
 */