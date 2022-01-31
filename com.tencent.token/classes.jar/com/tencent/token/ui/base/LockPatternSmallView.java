package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.tencent.token.utils.x;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LockPatternSmallView
  extends View
  implements bu
{
  LockPatternView a;
  public int b = 1;
  private Paint c = new Paint();
  private boolean[][] d = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private LockPatternView.DisplayMode e = LockPatternView.DisplayMode.Correct;
  private float f;
  private float g;
  private Bitmap h;
  private Bitmap i;
  private Bitmap j;
  private Bitmap k;
  private int l;
  private int m;
  private ArrayList n;
  private Activity o;
  private int p;
  
  public LockPatternSmallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LockPatternSmallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.o = ((Activity)paramContext);
    setClickable(false);
    paramContext = new DisplayMetrics();
    this.o.getWindowManager().getDefaultDisplay().getMetrics(paramContext);
    this.p = paramContext.widthPixels;
    int i1 = this.p * 14 / 320;
    this.h = x.a(getResources(), 2130837990, i1);
    this.i = x.a(getResources(), 2130837989, i1);
    this.j = x.a(getResources(), 2130837991, i1);
    this.k = x.a(getResources(), 2130837992, i1);
    this.l = this.h.getWidth();
    this.m = this.h.getHeight();
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if (!paramBoolean) {
      localBitmap = this.h;
    }
    for (;;)
    {
      int i2 = this.l;
      int i1 = this.m;
      float f1 = this.f;
      float f2 = this.g;
      i2 = (int)((f1 - i2) / 2.0F);
      i1 = (int)((f2 - i1) / 2.0F);
      paramCanvas.drawBitmap(localBitmap, i2 + paramInt1, i1 + paramInt2, this.c);
      return;
      if (this.b != 3)
      {
        if (this.e == LockPatternView.DisplayMode.Wrong) {
          localBitmap = this.k;
        } else {
          localBitmap = this.i;
        }
      }
      else
      {
        if (this.b != 3) {
          break;
        }
        localBitmap = this.j;
      }
    }
    throw new IllegalStateException("unknown display mode " + this.e);
  }
  
  private void c()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.d[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a()
  {
    if (this.b != 1) {
      return;
    }
    c();
    this.n = this.a.getPattern();
    this.e = this.a.getDispalyMode();
    invalidate();
  }
  
  public void a(LockPatternView paramLockPatternView)
  {
    this.a = paramLockPatternView;
    paramLockPatternView.a(this);
  }
  
  public void a(List paramList)
  {
    if (this.b != 1) {
      return;
    }
    this.n = this.a.getPattern();
    this.e = this.a.getDispalyMode();
    invalidate();
  }
  
  public void b()
  {
    if (this.b != 1) {
      return;
    }
    this.n = this.a.getPattern();
    this.e = this.a.getDispalyMode();
    invalidate();
  }
  
  public void b(List paramList)
  {
    if (this.b == 2) {
      return;
    }
    this.n = this.a.getPattern();
    this.e = this.a.getDispalyMode();
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.n == null) {
      this.n = new ArrayList();
    }
    Object localObject = this.n;
    ((ArrayList)localObject).size();
    boolean[][] arrayOfBoolean = this.d;
    float f1 = this.f;
    float f2 = this.g;
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      bt localbt = (bt)((Iterator)localObject).next();
      this.d[localbt.a()][localbt.b()] = 1;
    }
    int i3 = getPaddingTop();
    int i4 = getPaddingLeft();
    int i1 = 0;
    while (i1 < 3)
    {
      float f3 = i3;
      float f4 = i1;
      int i2 = 0;
      while (i2 < 3)
      {
        a(paramCanvas, (int)(i4 + i2 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[i1][i2]);
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
    setMeasuredDimension(paramInt1, paramInt1);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.f = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.g = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public void setDisplayMode(LockPatternView.DisplayMode paramDisplayMode)
  {
    this.e = paramDisplayMode;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternSmallView
 * JD-Core Version:    0.7.0.1
 */