package com.tencent.token.ui.base;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import com.tencent.token.utils.n;
import com.tencent.token.utils.x;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class LockPatternView
  extends View
{
  private int A;
  private final Rect B = new Rect();
  private int C;
  private int D;
  private int E;
  private Activity F;
  private int G;
  private boolean a = false;
  private Paint b = new Paint();
  private boolean c = false;
  private bu d;
  private bu e;
  private ArrayList f = new ArrayList(9);
  private boolean[][] g = (boolean[][])Array.newInstance(Boolean.TYPE, new int[] { 3, 3 });
  private float h = -1.0F;
  private float i = -1.0F;
  private LockPatternView.DisplayMode j = LockPatternView.DisplayMode.Correct;
  private boolean k = true;
  private boolean l = false;
  private boolean m = true;
  private boolean n = false;
  private float o = 0.5F;
  private float p = 0.6F;
  private float q;
  private float r;
  private Bitmap s;
  private Bitmap t;
  private Bitmap u;
  private Bitmap v;
  private Bitmap w;
  private Bitmap x;
  private Bitmap y;
  private Bitmap z;
  
  public LockPatternView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.F = ((Activity)paramContext);
    if ("square".equals("square")) {
      this.E = 0;
    }
    for (;;)
    {
      setClickable(true);
      paramContext = new DisplayMetrics();
      this.F.getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      this.G = paramContext.widthPixels;
      int i1 = this.G * 60 / 320;
      this.u = x.a(getResources(), 2130837970, i1);
      this.s = x.a(getResources(), 2130837971, i1);
      this.t = x.a(getResources(), 2130837972, i1);
      this.v = x.a(getResources(), 2130837967, i1);
      this.y = x.a(getResources(), 2130837966, i1);
      this.w = x.a(getResources(), 2130837968, i1);
      this.x = x.a(getResources(), 2130837969, i1);
      this.z = x.a(getResources(), 2130837977);
      if ((this.u != null) && (this.s != null) && (this.t != null) && (this.v != null) && (this.y != null) && (this.w != null) && (this.x != null) && (this.z != null)) {
        break;
      }
      this.c = false;
      return;
      if ("lock_width".equals("square")) {
        this.E = 1;
      } else if ("lock_height".equals("square")) {
        this.E = 2;
      } else {
        this.E = 0;
      }
    }
    this.c = true;
    this.A = this.z.getHeight();
    this.C = this.v.getWidth();
    this.D = this.v.getHeight();
  }
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet);
  }
  
  private float a(int paramInt)
  {
    return getPaddingLeft() + paramInt * this.q + this.q / 2.0F;
  }
  
  private int a(float paramFloat)
  {
    float f1 = this.r;
    float f2 = f1 * this.p;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private bt a(float paramFloat1, float paramFloat2)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int i2 = 1;
    bt localbt = b(paramFloat1, paramFloat2);
    int i3;
    int i1;
    if (localbt != null)
    {
      ArrayList localArrayList = this.f;
      localObject1 = localObject2;
      if (!localArrayList.isEmpty())
      {
        localObject1 = (bt)localArrayList.get(localArrayList.size() - 1);
        int i6 = localbt.a - ((bt)localObject1).a;
        int i5 = localbt.b - ((bt)localObject1).b;
        int i4 = ((bt)localObject1).a;
        i3 = ((bt)localObject1).b;
        i1 = i4;
        if (Math.abs(i6) == 2)
        {
          i1 = i4;
          if (Math.abs(i5) != 1)
          {
            i4 = ((bt)localObject1).a;
            if (i6 <= 0) {
              break label228;
            }
            i1 = 1;
            i1 += i4;
          }
        }
        if ((Math.abs(i5) != 2) || (Math.abs(i6) == 1)) {
          break label239;
        }
        i3 = ((bt)localObject1).b;
        if (i5 <= 0) {
          break label233;
        }
      }
    }
    label170:
    label228:
    label233:
    label239:
    for (i2 = i3 + i2;; i2 = i3)
    {
      localObject1 = bt.a(i1, i2);
      if ((localObject1 != null) && (this.g[localObject1.a][localObject1.b] == 0)) {
        a((bt)localObject1);
      }
      a(localbt);
      localObject1 = localbt;
      return localObject1;
      i1 = -1;
      break;
      i2 = -1;
      break label170;
    }
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if ((this.l) && (this.j != LockPatternView.DisplayMode.Wrong)) {}
    label183:
    label251:
    for (;;)
    {
      return;
      float f1 = paramFloat3 - paramFloat1;
      paramFloat4 -= paramFloat2;
      Bitmap localBitmap;
      if (f1 == 0.0F)
      {
        paramFloat3 = Math.abs(paramFloat4);
        if (!this.n) {
          break label183;
        }
        localBitmap = x.a(getResources(), 2130837977, (int)paramFloat3, this.A);
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label251;
        }
        paramFloat3 = (float)Math.toDegrees((float)Math.atan2(paramFloat4, f1));
        Matrix localMatrix = paramCanvas.getMatrix();
        localMatrix.setRotate(paramFloat3);
        localMatrix.preTranslate(0.0F, -this.A / 2.0F);
        localMatrix.postTranslate(paramFloat1, paramFloat2);
        paramCanvas.drawBitmap(localBitmap, localMatrix, this.b);
        localBitmap.recycle();
        return;
        if (paramFloat4 == 0.0F)
        {
          paramFloat3 = Math.abs(f1);
          break;
        }
        paramFloat3 = (float)Math.sqrt(f1 * f1 + paramFloat4 * paramFloat4);
        break;
        if (this.j == LockPatternView.DisplayMode.Wrong) {
          localBitmap = x.a(getResources(), 2130837979, (int)paramFloat3, this.A);
        } else if (this.j == LockPatternView.DisplayMode.Correct) {
          localBitmap = x.a(getResources(), 2130837978, (int)paramFloat3, this.A);
        } else {
          localBitmap = null;
        }
      }
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Bitmap localBitmap2;
    Bitmap localBitmap1;
    if ((!paramBoolean) || ((this.l) && (this.j != LockPatternView.DisplayMode.Wrong)))
    {
      localBitmap2 = this.v;
      localBitmap1 = null;
    }
    for (;;)
    {
      int i2 = this.C;
      int i1 = this.D;
      float f1 = this.q;
      float f2 = this.r;
      i2 = (int)((f1 - i2) / 2.0F);
      i1 = (int)((f2 - i1) / 2.0F);
      if (localBitmap2 != null) {
        paramCanvas.drawBitmap(localBitmap2, paramInt1 + i2, paramInt2 + i1, this.b);
      }
      if (localBitmap1 != null) {
        paramCanvas.drawBitmap(localBitmap1, paramInt1 + i2, paramInt2 + i1, this.b);
      }
      return;
      if (this.n)
      {
        localBitmap2 = this.y;
        localBitmap1 = this.u;
      }
      else if (this.j == LockPatternView.DisplayMode.Wrong)
      {
        localBitmap2 = this.x;
        localBitmap1 = this.t;
      }
      else
      {
        if ((this.j != LockPatternView.DisplayMode.Correct) && (this.j != LockPatternView.DisplayMode.Animate)) {
          break;
        }
        localBitmap2 = this.w;
        localBitmap1 = this.s;
      }
    }
    throw new IllegalStateException("unknown display mode " + this.j);
  }
  
  private void a(bt parambt)
  {
    this.g[parambt.a()][parambt.b()] = 1;
    this.f.add(parambt);
    if (this.e != null) {
      this.e.a(this.f);
    }
    if (this.d != null) {
      this.d.a(this.f);
    }
  }
  
  private float b(int paramInt)
  {
    return getPaddingTop() + paramInt * this.r + this.r / 2.0F;
  }
  
  private int b(float paramFloat)
  {
    float f1 = this.q;
    float f2 = f1 * this.p;
    float f3 = getPaddingLeft();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    while (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      if ((paramFloat >= f5) && (paramFloat <= f5 + f2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private bt b(float paramFloat1, float paramFloat2)
  {
    int i1 = a(paramFloat2);
    if (i1 < 0) {}
    int i2;
    do
    {
      return null;
      i2 = b(paramFloat1);
    } while ((i2 < 0) || (this.g[i1][i2] != 0));
    return bt.a(i1, i2);
  }
  
  private void e()
  {
    this.f.clear();
    f();
    this.j = LockPatternView.DisplayMode.Correct;
    invalidate();
  }
  
  private void f()
  {
    int i1 = 0;
    while (i1 < 3)
    {
      int i2 = 0;
      while (i2 < 3)
      {
        this.g[i1][i2] = 0;
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public void a()
  {
    e();
  }
  
  public void a(LockPatternSmallView paramLockPatternSmallView)
  {
    this.e = paramLockPatternSmallView;
  }
  
  public void b()
  {
    this.k = false;
  }
  
  public void c()
  {
    this.k = true;
  }
  
  public void d()
  {
    if (this.c)
    {
      this.u.recycle();
      this.s.recycle();
      this.t.recycle();
      this.v.recycle();
      this.y.recycle();
      this.w.recycle();
      this.x.recycle();
      this.z.recycle();
    }
  }
  
  public LockPatternView.DisplayMode getDispalyMode()
  {
    return this.j;
  }
  
  public ArrayList getPattern()
  {
    return this.f;
  }
  
  public String getPatternString()
  {
    return n.a(this.f);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject = this.f;
    int i2 = ((ArrayList)localObject).size();
    boolean[][] arrayOfBoolean = this.g;
    float f1 = this.q;
    float f2 = this.r;
    int i3 = getPaddingTop();
    int i4 = getPaddingLeft();
    if (!this.c) {}
    label279:
    for (;;)
    {
      return;
      int i1 = 0;
      bt localbt1;
      bt localbt2;
      if (i1 < i2 - 1)
      {
        localbt1 = (bt)((ArrayList)localObject).get(i1);
        localbt2 = (bt)((ArrayList)localObject).get(i1 + 1);
        if (arrayOfBoolean[localbt2.a][localbt2.b] != 0) {}
      }
      else
      {
        if (this.n)
        {
          localObject = (bt)((ArrayList)localObject).get(i1);
          a(paramCanvas, a(((bt)localObject).b), b(((bt)localObject).a), this.h, this.i);
        }
        i1 = 0;
      }
      for (;;)
      {
        if (i1 >= 3) {
          break label279;
        }
        float f3 = i3;
        float f4 = i1;
        i2 = 0;
        for (;;)
        {
          if (i2 < 3)
          {
            a(paramCanvas, (int)(i4 + i2 * f1), (int)(f4 * f2 + f3), arrayOfBoolean[i1][i2]);
            i2 += 1;
            continue;
            a(paramCanvas, a(localbt1.b), b(localbt1.a), a(localbt2.b), b(localbt2.a));
            i1 += 1;
            break;
          }
        }
        i1 += 1;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt2);
    switch (this.E)
    {
    default: 
      paramInt2 = i1;
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = paramInt1;
      continue;
      paramInt1 = Math.min(i1, paramInt1);
      paramInt2 = i1;
      continue;
      paramInt2 = Math.min(i1, paramInt1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.q = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F);
    this.r = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.k) || (!isEnabled())) {
      return false;
    }
    float f6 = paramMotionEvent.getX();
    float f4 = paramMotionEvent.getY();
    float f1;
    float f2;
    float f3;
    float f5;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      e();
      paramMotionEvent = a(f6, f4);
      if ((paramMotionEvent != null) && (this.d != null))
      {
        this.n = true;
        this.j = LockPatternView.DisplayMode.Correct;
        if (this.e != null) {
          this.e.a();
        }
        this.d.a();
      }
      for (;;)
      {
        if (paramMotionEvent != null)
        {
          f1 = a(paramMotionEvent.b);
          f2 = b(paramMotionEvent.a);
          f3 = this.q / 2.0F;
          f5 = this.r / 2.0F;
          invalidate((int)(f1 - f3), (int)(f2 - f5), (int)(f1 + f3), (int)(f2 + f5));
        }
        this.h = f6;
        this.i = f4;
        return true;
        if (this.d != null)
        {
          this.n = false;
          if (this.e != null) {
            this.e.b();
          }
          this.d.b();
        }
      }
    case 1: 
      if ((!this.f.isEmpty()) && (this.d != null))
      {
        this.n = false;
        if (this.e != null) {
          this.e.b(this.f);
        }
        this.d.b(this.f);
        invalidate();
      }
      return true;
    case 2: 
      int i1 = this.f.size();
      paramMotionEvent = a(f6, f4);
      int i2 = this.f.size();
      if ((paramMotionEvent != null) && (this.d != null) && (i2 == 1))
      {
        this.n = true;
        if (this.e != null) {
          this.e.a();
        }
        this.d.a();
      }
      float f7;
      float f9;
      float f8;
      if (Math.abs(f6 - this.h) + Math.abs(f4 - this.i) > this.q * 0.01F)
      {
        f5 = this.h;
        f3 = this.i;
        this.h = f6;
        this.i = f4;
        if ((!this.n) || (i2 <= 0)) {
          break label833;
        }
        ArrayList localArrayList = this.f;
        float f10 = this.q * this.o * 0.5F;
        Object localObject = (bt)localArrayList.get(i2 - 1);
        f2 = a(((bt)localObject).b);
        f1 = b(((bt)localObject).a);
        localObject = this.B;
        if (f2 >= f6) {
          break label777;
        }
        f7 = f2;
        if (f1 >= f4) {
          break label787;
        }
        f9 = f1;
        f8 = f4;
        label531:
        ((Rect)localObject).set((int)(f7 - f10), (int)(f9 - f10), (int)(f6 + f10), (int)(f8 + f10));
        if (f2 >= f5) {
          break label797;
        }
        f4 = f2;
        f2 = f5;
        label573:
        f6 = f1;
        f5 = f3;
        if (f1 < f3)
        {
          f5 = f1;
          f6 = f3;
        }
        ((Rect)localObject).union((int)(f4 - f10), (int)(f5 - f10), (int)(f2 + f10), (int)(f6 + f10));
        if (paramMotionEvent != null)
        {
          f2 = a(paramMotionEvent.b);
          f1 = b(paramMotionEvent.a);
          if (i2 < 2) {
            break label814;
          }
          paramMotionEvent = (bt)localArrayList.get(i2 - 1 - (i2 - i1));
          f6 = a(paramMotionEvent.b);
          f5 = b(paramMotionEvent.a);
          f3 = f2;
          f4 = f6;
          if (f2 < f6)
          {
            f3 = f6;
            f4 = f2;
          }
          if (f1 >= f5) {
            break label804;
          }
          f2 = f3;
          f3 = f1;
          f1 = f5;
          label726:
          f5 = this.q / 2.0F;
          f6 = this.r / 2.0F;
          ((Rect)localObject).set((int)(f4 - f5), (int)(f3 - f6), (int)(f2 + f5), (int)(f1 + f6));
        }
        invalidate((Rect)localObject);
      }
      for (;;)
      {
        return true;
        label777:
        f7 = f6;
        f6 = f2;
        break;
        label787:
        f8 = f1;
        f9 = f4;
        break label531;
        label797:
        f4 = f5;
        break label573;
        label804:
        f2 = f3;
        f3 = f5;
        break label726;
        label814:
        f3 = f1;
        f4 = f2;
        f5 = f1;
        f1 = f3;
        f3 = f5;
        break label726;
        label833:
        invalidate();
      }
    }
    e();
    if (this.d != null)
    {
      this.n = false;
      if (this.e != null) {
        this.e.b();
      }
      this.d.b();
    }
    return true;
  }
  
  public void setDisplayMode(LockPatternView.DisplayMode paramDisplayMode)
  {
    this.j = paramDisplayMode;
    if (paramDisplayMode == LockPatternView.DisplayMode.Animate)
    {
      if (this.f.size() == 0) {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }
      paramDisplayMode = (bt)this.f.get(0);
      this.h = a(paramDisplayMode.b());
      this.i = b(paramDisplayMode.a());
      f();
    }
    invalidate();
  }
  
  public void setInStealthMode(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setOnPatternListener(bu parambu)
  {
    this.d = parambu;
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternView
 * JD-Core Version:    0.7.0.1
 */