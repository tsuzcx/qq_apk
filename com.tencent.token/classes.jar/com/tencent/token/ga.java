package com.tencent.token;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class ga
{
  private static final Interpolator v = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  public int a;
  public int b;
  public float[] c;
  public float[] d;
  public float[] e;
  public float[] f;
  public float g;
  public int h;
  public int i;
  public View j;
  private int k = -1;
  private int[] l;
  private int[] m;
  private int[] n;
  private int o;
  private VelocityTracker p;
  private float q;
  private OverScroller r;
  private final a s;
  private boolean t;
  private final ViewGroup u;
  private final Runnable w = new Runnable()
  {
    public final void run()
    {
      ga.this.b(0);
    }
  };
  
  private ga(Context paramContext, ViewGroup paramViewGroup, a parama)
  {
    if (paramViewGroup != null)
    {
      if (parama != null)
      {
        this.u = paramViewGroup;
        this.s = parama;
        paramViewGroup = ViewConfiguration.get(paramContext);
        this.h = ((int)(paramContext.getResources().getDisplayMetrics().density * 20.0F + 0.5F));
        this.b = paramViewGroup.getScaledTouchSlop();
        this.q = paramViewGroup.getScaledMaximumFlingVelocity();
        this.g = paramViewGroup.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(paramContext, v);
        return;
      }
      throw new IllegalArgumentException("Callback may not be null");
    }
    throw new IllegalArgumentException("Parent view may not be null");
  }
  
  private static float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2) {
      return 0.0F;
    }
    if (f1 > paramFloat3)
    {
      if (paramFloat1 > 0.0F) {
        return paramFloat3;
      }
      return -paramFloat3;
    }
    return paramFloat1;
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0) {
      return 0;
    }
    int i1 = this.u.getWidth();
    int i2 = i1 / 2;
    float f2 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f1 = i2;
    f2 = a(f2);
    paramInt2 = Math.abs(paramInt2);
    if (paramInt2 > 0) {
      paramInt1 = Math.round(Math.abs((f1 + f2 * f1) / paramInt2) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(paramInt1) / paramInt3 + 1.0F) * 256.0F);
    }
    return Math.min(paramInt1, 600);
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt3 = b(paramInt3, (int)this.g, (int)this.q);
    paramInt4 = b(paramInt4, (int)this.g, (int)this.q);
    int i1 = Math.abs(paramInt1);
    int i2 = Math.abs(paramInt2);
    int i3 = Math.abs(paramInt3);
    int i4 = Math.abs(paramInt4);
    int i5 = i3 + i4;
    int i6 = i1 + i2;
    float f1;
    float f2;
    if (paramInt3 != 0)
    {
      f1 = i3;
      f2 = i5;
    }
    else
    {
      f1 = i1;
      f2 = i6;
    }
    float f3 = f1 / f2;
    if (paramInt4 != 0)
    {
      f1 = i4;
      f2 = i5;
    }
    else
    {
      f1 = i2;
      f2 = i6;
    }
    f1 /= f2;
    paramInt1 = a(paramInt1, paramInt3, this.s.c(paramView));
    paramInt2 = a(paramInt2, paramInt4, 0);
    return (int)(paramInt1 * f3 + paramInt2 * f1);
  }
  
  public static ga a(ViewGroup paramViewGroup, float paramFloat, a parama)
  {
    paramViewGroup = new ga(paramViewGroup.getContext(), paramViewGroup, parama);
    paramViewGroup.b = ((int)(paramViewGroup.b * (1.0F / paramFloat)));
    return paramViewGroup;
  }
  
  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject1 = this.c;
    int i2 = 0;
    if ((localObject1 == null) || (localObject1.length <= paramInt))
    {
      i1 = paramInt + 1;
      localObject1 = new float[i1];
      float[] arrayOfFloat1 = new float[i1];
      float[] arrayOfFloat2 = new float[i1];
      float[] arrayOfFloat3 = new float[i1];
      int[] arrayOfInt1 = new int[i1];
      int[] arrayOfInt2 = new int[i1];
      int[] arrayOfInt3 = new int[i1];
      Object localObject2 = this.c;
      if (localObject2 != null)
      {
        System.arraycopy(localObject2, 0, localObject1, 0, localObject2.length);
        localObject2 = this.d;
        System.arraycopy(localObject2, 0, arrayOfFloat1, 0, localObject2.length);
        localObject2 = this.e;
        System.arraycopy(localObject2, 0, arrayOfFloat2, 0, localObject2.length);
        localObject2 = this.f;
        System.arraycopy(localObject2, 0, arrayOfFloat3, 0, localObject2.length);
        localObject2 = this.l;
        System.arraycopy(localObject2, 0, arrayOfInt1, 0, localObject2.length);
        localObject2 = this.m;
        System.arraycopy(localObject2, 0, arrayOfInt2, 0, localObject2.length);
        localObject2 = this.n;
        System.arraycopy(localObject2, 0, arrayOfInt3, 0, localObject2.length);
      }
      this.c = ((float[])localObject1);
      this.d = arrayOfFloat1;
      this.e = arrayOfFloat2;
      this.f = arrayOfFloat3;
      this.l = arrayOfInt1;
      this.m = arrayOfInt2;
      this.n = arrayOfInt3;
    }
    localObject1 = this.c;
    this.e[paramInt] = paramFloat1;
    localObject1[paramInt] = paramFloat1;
    localObject1 = this.d;
    this.f[paramInt] = paramFloat2;
    localObject1[paramInt] = paramFloat2;
    localObject1 = this.l;
    int i4 = (int)paramFloat1;
    int i3 = (int)paramFloat2;
    if (i4 < this.u.getLeft() + this.h) {
      i2 = 1;
    }
    int i1 = i2;
    if (i3 < this.u.getTop() + this.h) {
      i1 = i2 | 0x4;
    }
    i2 = i1;
    if (i4 > this.u.getRight() - this.h) {
      i2 = i1 | 0x2;
    }
    i1 = i2;
    if (i3 > this.u.getBottom() - this.h) {
      i1 = i2 | 0x8;
    }
    localObject1[paramInt] = i1;
    this.o |= 1 << paramInt;
  }
  
  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    paramFloat1 = Math.abs(paramFloat1);
    paramFloat2 = Math.abs(paramFloat2);
    if (((this.l[paramInt1] & paramInt2) == paramInt2) && ((this.i & paramInt2) != 0) && ((this.n[paramInt1] & paramInt2) != paramInt2) && ((this.m[paramInt1] & paramInt2) != paramInt2))
    {
      int i1 = this.b;
      if ((paramFloat1 <= i1) && (paramFloat2 <= i1)) {
        return false;
      }
      return ((this.m[paramInt1] & paramInt2) == 0) && (paramFloat1 > this.b);
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.j.getLeft();
    int i2 = this.j.getTop();
    paramInt1 -= i1;
    paramInt2 -= i2;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.r.abortAnimation();
      b(0);
      return false;
    }
    paramInt3 = a(this.j, paramInt1, paramInt2, paramInt3, paramInt4);
    this.r.startScroll(i1, i2, paramInt1, paramInt2, paramInt3);
    b(2);
    return true;
  }
  
  private boolean a(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return false;
    }
    int i1;
    if (this.s.c(paramView) > 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0) {
      return Math.abs(paramFloat) > this.b;
    }
    return false;
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2) {
      return 0;
    }
    if (i1 > paramInt3)
    {
      if (paramInt1 > 0) {
        return paramInt3;
      }
      return -paramInt3;
    }
    return paramInt1;
  }
  
  private void b(float paramFloat)
  {
    this.t = true;
    this.s.a(this.j, paramFloat);
    this.t = false;
    if (this.a == 1) {
      b(0);
    }
  }
  
  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean b(View paramView, int paramInt)
  {
    if ((paramView == this.j) && (this.k == paramInt)) {
      return true;
    }
    if ((paramView != null) && (this.s.a(paramView)))
    {
      this.k = paramInt;
      a(paramView, paramInt);
      return true;
    }
    return false;
  }
  
  public static boolean b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return false;
    }
    return (paramInt1 >= paramView.getLeft()) && (paramInt1 < paramView.getRight()) && (paramInt2 >= paramView.getTop()) && (paramInt2 < paramView.getBottom());
  }
  
  private void c(int paramInt)
  {
    if (this.c != null)
    {
      if (!a(paramInt)) {
        return;
      }
      this.c[paramInt] = 0.0F;
      this.d[paramInt] = 0.0F;
      this.e[paramInt] = 0.0F;
      this.f[paramInt] = 0.0F;
      this.l[paramInt] = 0;
      this.m[paramInt] = 0;
      this.n[paramInt] = 0;
      this.o = ((1 << paramInt ^ 0xFFFFFFFF) & this.o);
      return;
    }
  }
  
  private void c(int paramInt1, int paramInt2, int paramInt3)
  {
    int i3 = this.j.getLeft();
    int i2 = this.j.getTop();
    int i1 = paramInt1;
    if (paramInt2 != 0)
    {
      i1 = this.s.b(this.j, paramInt1);
      ew.c(this.j, i1 - i3);
    }
    if (paramInt3 != 0)
    {
      paramInt1 = this.s.d(this.j);
      ew.b(this.j, paramInt1 - i2);
    }
    if ((paramInt2 != 0) || (paramInt3 != 0)) {
      this.s.a(this.j, i1);
    }
  }
  
  private void c(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getPointerCount();
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = paramMotionEvent.getPointerId(i1);
      if (d(i3))
      {
        float f1 = paramMotionEvent.getX(i1);
        float f2 = paramMotionEvent.getY(i1);
        this.e[i3] = f1;
        this.f[i3] = f2;
      }
      i1 += 1;
    }
  }
  
  private boolean c(int paramInt1, int paramInt2)
  {
    return b(this.j, paramInt1, paramInt2);
  }
  
  private void d()
  {
    float[] arrayOfFloat = this.c;
    if (arrayOfFloat == null) {
      return;
    }
    Arrays.fill(arrayOfFloat, 0.0F);
    Arrays.fill(this.d, 0.0F);
    Arrays.fill(this.e, 0.0F);
    Arrays.fill(this.f, 0.0F);
    Arrays.fill(this.l, 0);
    Arrays.fill(this.m, 0);
    Arrays.fill(this.n, 0);
    this.o = 0;
  }
  
  private boolean d(int paramInt)
  {
    if (!a(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder("Ignoring pointerId=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
      return false;
    }
    return true;
  }
  
  private void e()
  {
    this.p.computeCurrentVelocity(1000, this.q);
    float f1 = a(this.p.getXVelocity(this.k), this.g, this.q);
    a(this.p.getYVelocity(this.k), this.g, this.q);
    b(f1);
  }
  
  public final void a()
  {
    this.k = -1;
    d();
    VelocityTracker localVelocityTracker = this.p;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.p = null;
    }
  }
  
  public final void a(View paramView, int paramInt)
  {
    if (paramView.getParent() == this.u)
    {
      this.j = paramView;
      this.k = paramInt;
      this.s.b(paramView);
      b(1);
      return;
    }
    paramView = new StringBuilder("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (");
    paramView.append(this.u);
    paramView.append(")");
    throw new IllegalArgumentException(paramView.toString());
  }
  
  public final boolean a(int paramInt)
  {
    return (1 << paramInt & this.o) != 0;
  }
  
  public final boolean a(int paramInt1, int paramInt2)
  {
    if (this.t) {
      return a(paramInt1, paramInt2, (int)this.p.getXVelocity(this.k), (int)this.p.getYVelocity(this.k));
    }
    throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
  }
  
  public final boolean a(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getActionMasked();
    int i1 = paramMotionEvent.getActionIndex();
    if (i2 == 0) {
      a();
    }
    if (this.p == null) {
      this.p = VelocityTracker.obtain();
    }
    this.p.addMovement(paramMotionEvent);
    float f1;
    float f2;
    switch (i2)
    {
    case 4: 
    default: 
      break;
    case 6: 
      c(paramMotionEvent.getPointerId(i1));
      break;
    case 5: 
      i2 = paramMotionEvent.getPointerId(i1);
      f1 = paramMotionEvent.getX(i1);
      f2 = paramMotionEvent.getY(i1);
      a(f1, f2, i2);
      i1 = this.a;
      if (i1 == 0)
      {
        if ((this.l[i2] & this.i) != 0) {
          this.s.c();
        }
      }
      else if (i1 == 2)
      {
        paramMotionEvent = b((int)f1, (int)f2);
        if (paramMotionEvent == this.j) {
          b(paramMotionEvent, i2);
        }
      }
      break;
    case 2: 
      if ((this.c != null) && (this.d != null))
      {
        int i3 = paramMotionEvent.getPointerCount();
        i1 = 0;
        while (i1 < i3)
        {
          int i4 = paramMotionEvent.getPointerId(i1);
          if (d(i4))
          {
            f1 = paramMotionEvent.getX(i1);
            f2 = paramMotionEvent.getY(i1);
            float f3 = f1 - this.c[i4];
            float f4 = this.d[i4];
            View localView = b((int)f1, (int)f2);
            if ((localView != null) && (a(localView, f3))) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            if (i2 != 0)
            {
              int i5 = localView.getLeft();
              int i6 = (int)f3;
              i6 = this.s.b(localView, i6 + i5);
              localView.getTop();
              this.s.d(localView);
              int i7 = this.s.c(localView);
              if ((i7 == 0) || ((i7 > 0) && (i6 == i5))) {
                break;
              }
            }
            b(f3, f2 - f4, i4);
            if ((this.a == 1) || ((i2 != 0) && (b(localView, i4)))) {
              break;
            }
          }
          i1 += 1;
        }
        c(paramMotionEvent);
      }
      break;
    case 1: 
    case 3: 
      a();
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = paramMotionEvent.getPointerId(0);
      a(f1, f2, i1);
      paramMotionEvent = b((int)f1, (int)f2);
      if ((paramMotionEvent == this.j) && (this.a == 2)) {
        b(paramMotionEvent, i1);
      }
      if ((this.l[i1] & this.i) != 0) {
        this.s.c();
      }
      break;
    }
    return this.a == 1;
  }
  
  public final boolean a(View paramView, int paramInt1, int paramInt2)
  {
    this.j = paramView;
    this.k = -1;
    boolean bool = a(paramInt1, paramInt2, 0, 0);
    if ((!bool) && (this.a == 0) && (this.j != null)) {
      this.j = null;
    }
    return bool;
  }
  
  public final View b(int paramInt1, int paramInt2)
  {
    int i1 = this.u.getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = this.u.getChildAt(i1);
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom())) {
        return localView;
      }
      i1 -= 1;
    }
    return null;
  }
  
  public final void b()
  {
    a();
    if (this.a == 2)
    {
      this.r.getCurrX();
      this.r.getCurrY();
      this.r.abortAnimation();
      int i1 = this.r.getCurrX();
      this.r.getCurrY();
      this.s.a(this.j, i1);
    }
    b(0);
  }
  
  final void b(int paramInt)
  {
    this.u.removeCallbacks(this.w);
    if (this.a != paramInt)
    {
      this.a = paramInt;
      this.s.a(paramInt);
      if (this.a == 0) {
        this.j = null;
      }
    }
  }
  
  public final void b(MotionEvent paramMotionEvent)
  {
    int i4 = paramMotionEvent.getActionMasked();
    int i3 = paramMotionEvent.getActionIndex();
    if (i4 == 0) {
      a();
    }
    if (this.p == null) {
      this.p = VelocityTracker.obtain();
    }
    this.p.addMovement(paramMotionEvent);
    int i2 = 0;
    int i1 = 0;
    float f1;
    float f2;
    Object localObject;
    switch (i4)
    {
    case 4: 
    default: 
    case 6: 
      i2 = paramMotionEvent.getPointerId(i3);
      if ((this.a == 1) && (i2 == this.k))
      {
        i3 = paramMotionEvent.getPointerCount();
        while (i1 < i3)
        {
          i4 = paramMotionEvent.getPointerId(i1);
          if (i4 != this.k)
          {
            f1 = paramMotionEvent.getX(i1);
            f2 = paramMotionEvent.getY(i1);
            localObject = b((int)f1, (int)f2);
            View localView = this.j;
            if ((localObject == localView) && (b(localView, i4)))
            {
              i1 = this.k;
              break label217;
            }
          }
          i1 += 1;
        }
        i1 = -1;
        if (i1 == -1) {
          e();
        }
      }
      c(i2);
      return;
    case 5: 
      i1 = paramMotionEvent.getPointerId(i3);
      f1 = paramMotionEvent.getX(i3);
      f2 = paramMotionEvent.getY(i3);
      a(f1, f2, i1);
      if (this.a == 0)
      {
        b(b((int)f1, (int)f2), i1);
        if ((this.l[i1] & this.i) != 0) {
          this.s.c();
        }
        return;
      }
      if (c((int)f1, (int)f2))
      {
        b(this.j, i1);
        return;
      }
      break;
    case 3: 
      if (this.a == 1) {
        b(0.0F);
      }
      a();
      return;
    case 2: 
      if (this.a == 1)
      {
        if (d(this.k))
        {
          i1 = paramMotionEvent.findPointerIndex(this.k);
          f1 = paramMotionEvent.getX(i1);
          f2 = paramMotionEvent.getY(i1);
          localObject = this.e;
          i2 = this.k;
          i1 = (int)(f1 - localObject[i2]);
          i2 = (int)(f2 - this.f[i2]);
          i3 = this.j.getLeft();
          this.j.getTop();
          c(i3 + i1, i1, i2);
          c(paramMotionEvent);
        }
      }
      else
      {
        i3 = paramMotionEvent.getPointerCount();
        i1 = i2;
        while (i1 < i3)
        {
          i2 = paramMotionEvent.getPointerId(i1);
          if (d(i2))
          {
            f1 = paramMotionEvent.getX(i1);
            f2 = paramMotionEvent.getY(i1);
            float f3 = f1 - this.c[i2];
            b(f3, f2 - this.d[i2], i2);
            if (this.a == 1) {
              break;
            }
            localObject = b((int)f1, (int)f2);
            if ((a((View)localObject, f3)) && (b((View)localObject, i2))) {
              break;
            }
          }
          i1 += 1;
        }
        c(paramMotionEvent);
        return;
      }
      break;
    case 1: 
      if (this.a == 1) {
        e();
      }
      a();
      return;
    case 0: 
      label217:
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      i1 = paramMotionEvent.getPointerId(0);
      paramMotionEvent = b((int)f1, (int)f2);
      a(f1, f2, i1);
      b(paramMotionEvent, i1);
      if ((this.l[i1] & this.i) != 0)
      {
        this.s.c();
        return;
      }
      break;
    }
  }
  
  public final boolean c()
  {
    if (this.a == 2)
    {
      boolean bool2 = this.r.computeScrollOffset();
      int i1 = this.r.getCurrX();
      int i2 = this.r.getCurrY();
      int i3 = i1 - this.j.getLeft();
      int i4 = i2 - this.j.getTop();
      if (i3 != 0) {
        ew.c(this.j, i3);
      }
      if (i4 != 0) {
        ew.b(this.j, i4);
      }
      if ((i3 != 0) || (i4 != 0)) {
        this.s.a(this.j, i1);
      }
      boolean bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (i1 == this.r.getFinalX())
        {
          bool1 = bool2;
          if (i2 == this.r.getFinalY())
          {
            this.r.abortAnimation();
            bool1 = false;
          }
        }
      }
      if (!bool1) {
        this.u.post(this.w);
      }
    }
    return this.a == 2;
  }
  
  public static abstract class a
  {
    public void a(int paramInt) {}
    
    public void a(int paramInt1, int paramInt2) {}
    
    public void a(View paramView, float paramFloat) {}
    
    public void a(View paramView, int paramInt) {}
    
    public abstract boolean a(View paramView);
    
    public int b(View paramView, int paramInt)
    {
      return 0;
    }
    
    public void b(View paramView) {}
    
    public int c(View paramView)
    {
      return 0;
    }
    
    public void c() {}
    
    public int d(View paramView)
    {
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ga
 * JD-Core Version:    0.7.0.1
 */