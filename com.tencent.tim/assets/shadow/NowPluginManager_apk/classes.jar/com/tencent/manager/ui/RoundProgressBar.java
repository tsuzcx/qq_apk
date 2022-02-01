package com.tencent.manager.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

public class RoundProgressBar
  extends View
{
  Runnable a = new Runnable()
  {
    public void run()
    {
      if (RoundProgressBar.a(RoundProgressBar.this) < RoundProgressBar.b(RoundProgressBar.this))
      {
        RoundProgressBar.a(RoundProgressBar.this, RoundProgressBar.a(RoundProgressBar.this) + 1);
        RoundProgressBar.this.invalidate();
        RoundProgressBar.c(RoundProgressBar.this).postDelayed(this, 30L);
      }
      while (RoundProgressBar.a(RoundProgressBar.this) <= RoundProgressBar.b(RoundProgressBar.this)) {
        return;
      }
      RoundProgressBar.a(RoundProgressBar.this, RoundProgressBar.a(RoundProgressBar.this) - 1);
      RoundProgressBar.this.invalidate();
      RoundProgressBar.c(RoundProgressBar.this).postDelayed(this, 30L);
    }
  };
  private Paint b = new Paint();
  private int c = -252645121;
  private int d = -1529614848;
  private int e = -16777216;
  private float f = 20.0F;
  private float g = 18.0F;
  private float h = 5.0F;
  private int i = 100;
  private int j = 0;
  private int k;
  private RectF l = new RectF();
  private boolean m = true;
  private Handler n = new Handler(Looper.getMainLooper());
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.k = paramInt;
    this.n.postDelayed(this.a, 30L);
  }
  
  public int getCircleColor()
  {
    return this.c;
  }
  
  public int getCircleProgressColor()
  {
    return this.d;
  }
  
  public int getMax()
  {
    try
    {
      int i1 = this.i;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getProgress()
  {
    try
    {
      int i1 = this.j;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public float getRoundWidth()
  {
    return this.h;
  }
  
  public int getTextColor()
  {
    return this.e;
  }
  
  public float getTextSize()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i1 = getWidth() / 2;
    int i2 = (int)(i1 - this.h / 2.0F);
    this.b.setColor(this.c);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setStrokeWidth(this.h);
    this.b.setAntiAlias(true);
    paramCanvas.drawCircle(i1, i1, i2, this.b);
    this.b.setStrokeWidth(this.h);
    this.b.setColor(this.d);
    this.l.set(i1 - i2, i1 - i2, i1 + i2, i2 + i1);
    this.b.setStyle(Paint.Style.STROKE);
    paramCanvas.drawArc(this.l, -90.0F, this.j * 360 / this.i, false, this.b);
    this.b.setStrokeWidth(0.0F);
    this.b.setColor(this.e);
    this.b.setTextSize(this.f);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setTypeface(Typeface.DEFAULT_BOLD);
    i2 = this.j * 100 / this.i;
    float f1 = this.b.measureText(i2 + "");
    this.b.setTextSize(this.g);
    float f2 = this.b.measureText("%");
    if ((i2 != 0) && (this.m))
    {
      this.b.setTextSize(this.f);
      paramCanvas.drawText(i2 + "", i1 - (f1 + f2) / 2.0F, i1 + this.f / 2.0F, this.b);
      this.b.setTextSize(this.g);
      paramCanvas.drawText("%", f1 + (i1 - (f2 + f1) / 2.0F), i1 + this.f / 2.0F, this.b);
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("max not less than 0");
      }
      finally {}
    }
    this.i = paramInt;
  }
  
  public void setNeedShowProgreeText(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setPercentMarkTextSize(float paramFloat)
  {
    this.g = paramFloat;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("progress not less than 0");
      }
      finally {}
    }
    int i1 = paramInt;
    if (paramInt > this.i) {
      i1 = this.i;
    }
    if ((i1 <= this.i) && (this.j != i1))
    {
      if (this.j != 0) {
        break label67;
      }
      this.j = i1;
    }
    for (;;)
    {
      return;
      label67:
      a(i1);
    }
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.h = paramFloat;
  }
  
  public void setTextColor(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.f = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\assets\shadow\NowPluginManager_apk\classes.jar
 * Qualified Name:     com.tencent.manager.ui.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */