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
import com.tencent.token.utils.t;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
  private cb d;
  private cb e;
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
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.F = ((Activity)paramContext);
    if (!"square".equals("square")) {
      if ("lock_width".equals("square")) {
        this.E = 1;
      }
    }
    for (;;)
    {
      setClickable(true);
      paramContext = new DisplayMetrics();
      this.F.getWindowManager().getDefaultDisplay().getMetrics(paramContext);
      this.G = paramContext.widthPixels;
      int i1 = this.G * 60 / 320;
      this.u = t.a(getResources(), 2130837908, i1);
      this.s = t.a(getResources(), 2130837909, i1);
      this.t = t.a(getResources(), 2130837910, i1);
      this.v = t.a(getResources(), 2130837905, i1);
      this.y = t.a(getResources(), 2130837904, i1);
      this.w = t.a(getResources(), 2130837906, i1);
      this.x = t.a(getResources(), 2130837907, i1);
      this.z = t.a(getResources(), 2130837915);
      if ((this.u != null) && (this.s != null) && (this.t != null) && (this.v != null) && (this.y != null) && (this.w != null) && (this.x != null) && (this.z != null)) {
        break;
      }
      this.c = false;
      return;
      if ("lock_height".equals("square")) {
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
  
  private ca a(float paramFloat1, float paramFloat2)
  {
    int i4 = 0;
    int i3 = 1;
    Object localObject1 = null;
    Object localObject2 = null;
    float f1 = this.r;
    float f2 = f1 * this.p;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i1 = 0;
    int i2;
    label83:
    ca localca;
    if (i1 < 3)
    {
      float f5 = i1 * f1 + (f4 + f3);
      label212:
      if ((paramFloat2 >= f5) && (paramFloat2 <= f5 + f2))
      {
        i2 = i1;
        if (i2 >= 0) {
          break label327;
        }
        localca = null;
        label91:
        if (localca != null)
        {
          ArrayList localArrayList = this.f;
          localObject1 = localObject2;
          if (!localArrayList.isEmpty())
          {
            localObject1 = (ca)localArrayList.get(localArrayList.size() - 1);
            int i6 = localca.a - ((ca)localObject1).a;
            int i5 = localca.b - ((ca)localObject1).b;
            i4 = ((ca)localObject1).a;
            i2 = ((ca)localObject1).b;
            i1 = i4;
            if (Math.abs(i6) == 2)
            {
              i1 = i4;
              if (Math.abs(i5) != 1)
              {
                i4 = ((ca)localObject1).a;
                if (i6 <= 0) {
                  break label449;
                }
                i1 = 1;
                i1 += i4;
              }
            }
            if ((Math.abs(i5) != 2) || (Math.abs(i6) == 1)) {
              break label461;
            }
            i4 = ((ca)localObject1).b;
            if (i5 <= 0) {
              break label455;
            }
            i2 = i3;
            label253:
            i2 = i4 + i2;
          }
        }
      }
    }
    label327:
    label455:
    label461:
    for (;;)
    {
      localObject1 = ca.a(i1, i2);
      if ((localObject1 != null) && (this.g[localObject1.a][localObject1.b] == 0)) {
        a((ca)localObject1);
      }
      a(localca);
      localObject1 = localca;
      return localObject1;
      i1 += 1;
      break;
      i2 = -1;
      break label83;
      paramFloat2 = this.q;
      f1 = this.p * paramFloat2;
      f2 = getPaddingLeft();
      f3 = (paramFloat2 - f1) / 2.0F;
      i1 = i4;
      label357:
      if (i1 < 3)
      {
        f4 = i1 * paramFloat2 + (f2 + f3);
        if ((paramFloat1 < f4) || (paramFloat1 > f4 + f1)) {}
      }
      for (;;)
      {
        if (i1 >= 0) {
          break label418;
        }
        localca = null;
        break;
        i1 += 1;
        break label357;
        i1 = -1;
      }
      if (this.g[i2][i1] != 0)
      {
        localca = null;
        break label91;
      }
      localca = ca.a(i2, i1);
      break label91;
      i1 = -1;
      break label212;
      i2 = -1;
      break label253;
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
        localBitmap = t.a(getResources(), 2130837915, (int)paramFloat3, this.A);
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
          localBitmap = t.a(getResources(), 2130837917, (int)paramFloat3, this.A);
        } else if (this.j == LockPatternView.DisplayMode.Correct) {
          localBitmap = t.a(getResources(), 2130837916, (int)paramFloat3, this.A);
        } else {
          localBitmap = null;
        }
      }
    }
  }
  
  private void a(ca paramca)
  {
    this.g[paramca.a()][paramca.b()] = 1;
    this.f.add(paramca);
    if (this.e != null) {
      this.e.c();
    }
    if (this.d != null) {
      this.d.c();
    }
  }
  
  private void i()
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
  
  public final void a()
  {
    this.l = true;
  }
  
  public final void a(LockPatternSmallView paramLockPatternSmallView)
  {
    this.e = paramLockPatternSmallView;
  }
  
  public final void a(LockPatternView.DisplayMode paramDisplayMode)
  {
    this.j = paramDisplayMode;
    if (paramDisplayMode == LockPatternView.DisplayMode.Animate)
    {
      if (this.f.size() == 0) {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }
      paramDisplayMode = (ca)this.f.get(0);
      int i1 = paramDisplayMode.b();
      float f1 = getPaddingLeft();
      this.h = (i1 * this.q + f1 + this.q / 2.0F);
      i1 = paramDisplayMode.a();
      f1 = getPaddingTop();
      this.i = (i1 * this.r + f1 + this.r / 2.0F);
      i();
    }
    invalidate();
  }
  
  public final void a(cb paramcb)
  {
    this.d = paramcb;
  }
  
  public final ArrayList b()
  {
    return this.f;
  }
  
  public final LockPatternView.DisplayMode c()
  {
    return this.j;
  }
  
  public final void d()
  {
    this.f.clear();
    i();
    this.j = LockPatternView.DisplayMode.Correct;
    invalidate();
  }
  
  public final void e()
  {
    this.k = false;
  }
  
  public final void f()
  {
    this.k = true;
  }
  
  public final void g()
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
  
  public final String h()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return "";
    }
    int i2 = ((List)localObject).size();
    byte[] arrayOfByte = new byte[i2];
    int i1 = 0;
    while (i1 < i2)
    {
      ca localca = (ca)((List)localObject).get(i1);
      int i3 = localca.a();
      arrayOfByte[i1] = ((byte)(localca.b() + i3 * 3));
      i1 += 1;
    }
    localObject = new StringBuffer();
    i1 = 0;
    while (i1 < arrayOfByte.length)
    {
      ((StringBuffer)localObject).append(arrayOfByte[i1]);
      i1 += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    Object localObject1 = this.f;
    int i2 = ((ArrayList)localObject1).size();
    boolean[][] arrayOfBoolean = this.g;
    float f1 = this.q;
    float f2 = this.r;
    int i3 = getPaddingTop();
    int i4 = getPaddingLeft();
    if (!this.c) {}
    for (;;)
    {
      return;
      int i1 = 0;
      Object localObject2;
      int i5;
      float f3;
      float f4;
      float f5;
      float f6;
      float f7;
      while (i1 < i2 - 1)
      {
        localObject2 = (ca)((ArrayList)localObject1).get(i1);
        ca localca = (ca)((ArrayList)localObject1).get(i1 + 1);
        if (arrayOfBoolean[localca.a][localca.b] == 0) {
          break;
        }
        i5 = ((ca)localObject2).b;
        f3 = getPaddingLeft();
        f4 = i5;
        f5 = this.q;
        f6 = this.q / 2.0F;
        i5 = ((ca)localObject2).a;
        f7 = getPaddingTop();
        float f8 = i5;
        float f9 = this.r;
        float f10 = this.r / 2.0F;
        i5 = localca.b;
        float f11 = getPaddingLeft();
        float f12 = i5;
        float f13 = this.q;
        float f14 = this.q / 2.0F;
        i5 = localca.a;
        float f15 = getPaddingTop();
        a(paramCanvas, f4 * f5 + f3 + f6, f10 + (f8 * f9 + f7), f14 + (f12 * f13 + f11), i5 * this.r + f15 + this.r / 2.0F);
        i1 += 1;
      }
      if (this.n)
      {
        localObject1 = (ca)((ArrayList)localObject1).get(i1);
        i1 = ((ca)localObject1).b;
        f3 = getPaddingLeft();
        f4 = i1;
        f5 = this.q;
        f6 = this.q / 2.0F;
        i1 = ((ca)localObject1).a;
        f7 = getPaddingTop();
        a(paramCanvas, f6 + (f4 * f5 + f3), i1 * this.r + f7 + this.r / 2.0F, this.h, this.i);
      }
      i1 = 0;
      while (i1 < 3)
      {
        f3 = i3;
        f4 = i1;
        i2 = 0;
        if (i2 < 3)
        {
          i5 = (int)(i4 + i2 * f1);
          int i6 = (int)(f3 + f4 * f2);
          if ((arrayOfBoolean[i1][i2] == 0) || ((this.l) && (this.j != LockPatternView.DisplayMode.Wrong)))
          {
            localObject2 = this.v;
            localObject1 = null;
          }
          for (;;)
          {
            int i8 = this.C;
            int i7 = this.D;
            f5 = this.q;
            f6 = this.r;
            i8 = (int)((f5 - i8) / 2.0F);
            i7 = (int)((f6 - i7) / 2.0F);
            if (localObject2 != null) {
              paramCanvas.drawBitmap((Bitmap)localObject2, i5 + i8, i6 + i7, this.b);
            }
            if (localObject1 != null) {
              paramCanvas.drawBitmap((Bitmap)localObject1, i5 + i8, i6 + i7, this.b);
            }
            i2 += 1;
            break;
            if (this.n)
            {
              localObject2 = this.y;
              localObject1 = this.u;
            }
            else if (this.j == LockPatternView.DisplayMode.Wrong)
            {
              localObject2 = this.x;
              localObject1 = this.t;
            }
            else
            {
              if ((this.j != LockPatternView.DisplayMode.Correct) && (this.j != LockPatternView.DisplayMode.Animate)) {
                break label668;
              }
              localObject2 = this.w;
              localObject1 = this.s;
            }
          }
          label668:
          throw new IllegalStateException("unknown display mode " + this.j);
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
    int i1;
    float f1;
    float f2;
    float f3;
    float f5;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      this.f.clear();
      i();
      this.j = LockPatternView.DisplayMode.Correct;
      invalidate();
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
          i1 = paramMotionEvent.b;
          f1 = getPaddingLeft();
          f1 = i1 * this.q + f1 + this.q / 2.0F;
          i1 = paramMotionEvent.a;
          f2 = getPaddingTop();
          f2 = i1 * this.r + f2 + this.r / 2.0F;
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
          this.e.a(this.f);
        }
        this.d.a(this.f);
        invalidate();
      }
      return true;
    case 2: 
      i1 = this.f.size();
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
      float f8;
      float f9;
      if (Math.abs(f6 - this.h) + Math.abs(f4 - this.i) > this.q * 0.01F)
      {
        f5 = this.h;
        f3 = this.i;
        this.h = f6;
        this.i = f4;
        if ((!this.n) || (i2 <= 0)) {
          break label1049;
        }
        ArrayList localArrayList = this.f;
        float f10 = this.q * this.o * 0.5F;
        Object localObject = (ca)localArrayList.get(i2 - 1);
        int i3 = ((ca)localObject).b;
        f1 = getPaddingLeft();
        f2 = i3;
        f7 = this.q;
        f2 = this.q / 2.0F + (f2 * f7 + f1);
        i3 = ((ca)localObject).a;
        f1 = getPaddingTop();
        f7 = i3;
        f8 = this.r;
        f1 = this.r / 2.0F + (f7 * f8 + f1);
        localObject = this.B;
        if (f2 >= f6) {
          break label991;
        }
        f7 = f2;
        if (f1 >= f4) {
          break label1001;
        }
        f9 = f1;
        f8 = f4;
        label647:
        ((Rect)localObject).set((int)(f7 - f10), (int)(f9 - f10), (int)(f6 + f10), (int)(f8 + f10));
        if (f2 >= f5) {
          break label1011;
        }
        f4 = f2;
        f2 = f5;
        label689:
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
          i3 = paramMotionEvent.b;
          f1 = getPaddingLeft();
          f2 = i3;
          f3 = this.q;
          f1 = this.q / 2.0F + (f2 * f3 + f1);
          i3 = paramMotionEvent.a;
          f2 = getPaddingTop();
          f2 = i3 * this.r + f2 + this.r / 2.0F;
          if (i2 < 2) {
            break label1037;
          }
          paramMotionEvent = (ca)localArrayList.get(i2 - 1 - (i2 - i1));
          i1 = paramMotionEvent.b;
          f3 = getPaddingLeft();
          f4 = i1;
          f5 = this.q;
          f3 = this.q / 2.0F + (f4 * f5 + f3);
          i1 = paramMotionEvent.a;
          f4 = getPaddingTop();
          f5 = i1;
          f6 = this.r;
          f4 = this.r / 2.0F + (f5 * f6 + f4);
          if (f1 >= f3) {
            break label1018;
          }
          f5 = f3;
          f3 = f1;
          f1 = f5;
          label932:
          if (f2 >= f4) {
            break label1021;
          }
          f5 = f1;
          label942:
          f1 = this.q / 2.0F;
          f6 = this.r / 2.0F;
          ((Rect)localObject).set((int)(f3 - f1), (int)(f2 - f6), (int)(f5 + f1), (int)(f4 + f6));
        }
        invalidate((Rect)localObject);
      }
      for (;;)
      {
        return true;
        label991:
        f7 = f6;
        f6 = f2;
        break;
        label1001:
        f8 = f1;
        f9 = f4;
        break label647;
        label1011:
        f4 = f5;
        break label689;
        label1018:
        break label932;
        label1021:
        f6 = f4;
        f5 = f1;
        f4 = f2;
        f2 = f6;
        break label942;
        label1037:
        f5 = f1;
        f4 = f2;
        f3 = f1;
        break label942;
        label1049:
        invalidate();
      }
    }
    this.f.clear();
    i();
    this.j = LockPatternView.DisplayMode.Correct;
    invalidate();
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.LockPatternView
 * JD-Core Version:    0.7.0.1
 */