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
import com.tencent.token.ry.a;
import com.tencent.token.xj;

public class RecommendView
  extends View
{
  public boolean a = false;
  public int b;
  public Runnable c = new Runnable()
  {
    public final void run()
    {
      xj.c("stopBlink");
      RecommendView localRecommendView = RecommendView.this;
      localRecommendView.a = false;
      localRecommendView.postInvalidate();
    }
  };
  private float d = 120.0F;
  private float e;
  private float f;
  private float g;
  private Paint h = new Paint(1);
  private int i;
  private int j;
  private String k;
  private RectF l;
  private Rect m;
  private float n;
  private boolean o = false;
  
  public RecommendView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RecommendView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.h.setStyle(Paint.Style.FILL);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, ry.a.RecommendView, 0, 0);
    try
    {
      this.e = paramContext.getDimension(2, this.d);
      this.i = paramContext.getColor(1, 2303799);
      this.j = paramContext.getColor(4, 16764211);
      this.k = paramContext.getString(3);
      this.n = paramContext.getDimension(5, 20.0F);
      this.b = paramContext.getInt(0, 3000);
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  public float getViewHeight()
  {
    return this.f;
  }
  
  public float getViewWidth()
  {
    return this.g;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.h.setColor(this.i);
    this.h.setStyle(Paint.Style.FILL);
    float f1 = this.e;
    float f2 = this.f;
    paramCanvas.drawRect(f1, f2 - f1, this.g, f2, this.h);
    f1 = this.e;
    f2 = f1 / 2.0F;
    float f3 = this.f;
    this.l = new RectF(f2 + 3.0F, f3 - f1, f1 + f1 / 2.0F, f3);
    paramCanvas.drawArc(this.l, 90.0F, 180.0F, true, this.h);
    this.h.setColor(this.j);
    this.h.setTextSize(this.n);
    this.m = new Rect();
    Object localObject = this.h;
    String str = this.k;
    ((Paint)localObject).getTextBounds(str, 0, str.length(), this.m);
    localObject = this.k;
    f1 = this.e;
    paramCanvas.drawText((String)localObject, f1, this.f - f1 + f1 / 2.0F + this.m.height() / 2, this.h);
    if (this.o)
    {
      this.h.setColor(this.i);
      if (this.a) {
        this.h.setAlpha((int)(Math.random() * 255.0D));
      }
      this.h.setStyle(Paint.Style.FILL);
      this.h.setTextSize(this.n * 1.0F);
      this.h.setStrokeWidth(2.0F);
      f1 = this.e;
      paramCanvas.drawText("+", f1 / 2.0F, this.f - f1 - f1 / 2.0F / 2.0F / 2.0F / 2.0F, this.h);
      this.h.setTextSize(this.n);
      if (this.a) {
        this.h.setAlpha((int)(Math.random() * 255.0D));
      }
      this.h.setStyle(Paint.Style.STROKE);
      this.h.setStrokeWidth(1.0F);
      f1 = this.e;
      paramCanvas.drawCircle(f1 / 2.0F / 2.0F / 2.0F, this.f - f1 + f1 / 2.0F / 2.0F / 2.0F, f1 * 6.0F / 50.0F, this.h);
      if (this.a) {
        this.h.setAlpha((int)(Math.random() * 255.0D));
      }
      this.h.setStyle(Paint.Style.FILL);
      f1 = this.e;
      paramCanvas.drawCircle(f1 / 2.0F / 2.0F, f1 / 2.0F / 2.0F / 2.0F / 2.0F + f1, f1 * 4.0F / 50.0F, this.h);
      if (this.a) {
        this.h.setAlpha((int)(Math.random() * 255.0D));
      }
      f1 = this.e;
      paramCanvas.drawCircle(f1 / 2.0F, f1 / 2.0F + f1 / 2.0F / 2.0F / 2.0F, f1 * 2.0F / 50.0F, this.h);
      this.h.setAlpha(255);
      if (this.a) {
        postInvalidateDelayed(100L);
      }
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
      f1 = 3.7F * this.e;
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
      f1 = this.e * 1.5F;
      if (i1 == -2147483648) {
        f1 = Math.min(f1, paramInt2);
      }
    }
    setMeasuredDimension(paramInt1, (int)f1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = getMeasuredHeight();
    this.g = getMeasuredWidth();
  }
  
  public void setShowBink(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.RecommendView
 * JD-Core Version:    0.7.0.1
 */