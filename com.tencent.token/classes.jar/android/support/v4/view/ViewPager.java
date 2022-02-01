package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.Scroller;
import com.tencent.token.cs;
import com.tencent.token.ei;
import com.tencent.token.eu;
import com.tencent.token.ev;
import com.tencent.token.ex;
import com.tencent.token.fe;
import com.tencent.token.ff;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager
  extends ViewGroup
{
  static final int[] a = { 16842931 };
  private static final h ai = new h();
  private static final Comparator<b> f = new Comparator() {};
  private static final Interpolator g = new Interpolator()
  {
    public final float getInterpolation(float paramAnonymousFloat)
    {
      paramAnonymousFloat -= 1.0F;
      return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
    }
  };
  private boolean A;
  private int B = 1;
  private boolean C;
  private boolean D;
  private int E;
  private int F;
  private int G;
  private float H;
  private float I;
  private float J;
  private float K;
  private int L = -1;
  private VelocityTracker M;
  private int N;
  private int O;
  private int P;
  private int Q;
  private boolean R;
  private EdgeEffect S;
  private EdgeEffect T;
  private boolean U = true;
  private boolean V = false;
  private boolean W;
  private int aa;
  private List<e> ab;
  private e ac;
  private e ad;
  private f ae;
  private int af;
  private int ag;
  private ArrayList<View> ah;
  private final Runnable aj = new Runnable()
  {
    public final void run()
    {
      ViewPager.this.setScrollState(0);
      ViewPager.this.b();
    }
  };
  private int ak = 0;
  ev b;
  int c;
  List<d> d;
  private int e;
  private final ArrayList<b> h = new ArrayList();
  private final b i = new b();
  private final Rect j = new Rect();
  private int k = -1;
  private Parcelable l = null;
  private ClassLoader m = null;
  private Scroller n;
  private boolean o;
  private g p;
  private int q;
  private Drawable r;
  private int s;
  private int t;
  private float u = -3.402824E+038F;
  private float v = 3.4028235E+38F;
  private int w;
  private int x;
  private boolean y;
  private boolean z;
  
  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    paramContext = getContext();
    this.n = new Scroller(paramContext, g);
    paramAttributeSet = ViewConfiguration.get(paramContext);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.G = paramAttributeSet.getScaledPagingTouchSlop();
    this.N = ((int)(400.0F * f1));
    this.O = paramAttributeSet.getScaledMaximumFlingVelocity();
    this.S = new EdgeEffect(paramContext);
    this.T = new EdgeEffect(paramContext);
    this.P = ((int)(25.0F * f1));
    this.Q = ((int)(2.0F * f1));
    this.E = ((int)(f1 * 16.0F));
    ex.a(this, new c());
    if (ex.b(this) == 0) {
      ex.a(this, 1);
    }
    ex.a(this, new eu()
    {
      private final Rect b = new Rect();
      
      public final fe a(View paramAnonymousView, fe paramAnonymousfe)
      {
        paramAnonymousView = ex.a(paramAnonymousView, paramAnonymousfe);
        if (paramAnonymousView.e()) {
          return paramAnonymousView;
        }
        paramAnonymousfe = this.b;
        paramAnonymousfe.left = paramAnonymousView.a();
        paramAnonymousfe.top = paramAnonymousView.b();
        paramAnonymousfe.right = paramAnonymousView.c();
        paramAnonymousfe.bottom = paramAnonymousView.d();
        int i = 0;
        int j = ViewPager.this.getChildCount();
        while (i < j)
        {
          fe localfe = ex.b(ViewPager.this.getChildAt(i), paramAnonymousView);
          paramAnonymousfe.left = Math.min(localfe.a(), paramAnonymousfe.left);
          paramAnonymousfe.top = Math.min(localfe.b(), paramAnonymousfe.top);
          paramAnonymousfe.right = Math.min(localfe.c(), paramAnonymousfe.right);
          paramAnonymousfe.bottom = Math.min(localfe.d(), paramAnonymousfe.bottom);
          i += 1;
        }
        return paramAnonymousView.a(paramAnonymousfe.left, paramAnonymousfe.top, paramAnonymousfe.right, paramAnonymousfe.bottom);
      }
    });
  }
  
  private static float a(float paramFloat)
  {
    return (float)Math.sin((paramFloat - 0.5F) * 0.4712389F);
  }
  
  private Rect a(Rect paramRect, View paramView)
  {
    Rect localRect = paramRect;
    if (paramRect == null) {
      localRect = new Rect();
    }
    if (paramView == null)
    {
      localRect.set(0, 0, 0, 0);
      return localRect;
    }
    localRect.left = paramView.getLeft();
    localRect.right = paramView.getRight();
    localRect.top = paramView.getTop();
    localRect.bottom = paramView.getBottom();
    for (paramRect = paramView.getParent(); ((paramRect instanceof ViewGroup)) && (paramRect != this); paramRect = paramRect.getParent())
    {
      paramRect = (ViewGroup)paramRect;
      localRect.left += paramRect.getLeft();
      localRect.right += paramRect.getRight();
      localRect.top += paramRect.getTop();
      localRect.bottom += paramRect.getBottom();
    }
    return localRect;
  }
  
  private static b a(int paramInt)
  {
    new b().a = paramInt;
    throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
  }
  
  private b a(View paramView)
  {
    for (;;)
    {
      paramView = paramView.getParent();
      if (paramView == this) {
        break label34;
      }
      if ((paramView == null) || (!(paramView instanceof View))) {
        break;
      }
      paramView = (View)paramView;
    }
    return null;
    label34:
    return d();
  }
  
  private void a(int paramInt, float paramFloat)
  {
    int i1 = this.aa;
    int i6 = 0;
    View localView;
    if (i1 > 0)
    {
      int i7 = getScrollX();
      i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i8 = getWidth();
      int i9 = getChildCount();
      int i4 = 0;
      while (i4 < i9)
      {
        localView = getChildAt(i4);
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i5 = i1;
        int i3 = i2;
        if (localLayoutParams.a)
        {
          i3 = localLayoutParams.b & 0x7;
          if (i3 != 1)
          {
            if (i3 != 3)
            {
              if (i3 != 5)
              {
                i5 = i1;
                i3 = i1;
                i1 = i5;
              }
              else
              {
                i3 = localView.getMeasuredWidth();
                i5 = i2 + localView.getMeasuredWidth();
                i3 = i8 - i2 - i3;
                i2 = i5;
              }
            }
            else
            {
              i5 = localView.getWidth() + i1;
              i3 = i1;
              i1 = i5;
            }
          }
          else {
            i3 = Math.max((i8 - localView.getMeasuredWidth()) / 2, i1);
          }
          i3 = i3 + i7 - localView.getLeft();
          if (i3 != 0) {
            localView.offsetLeftAndRight(i3);
          }
          i3 = i2;
          i5 = i1;
        }
        i4 += 1;
        i1 = i5;
        i2 = i3;
      }
    }
    b(paramInt, paramFloat);
    if (this.ae != null)
    {
      getScrollX();
      i1 = getChildCount();
      paramInt = i6;
      while (paramInt < i1)
      {
        localView = getChildAt(paramInt);
        if (!((LayoutParams)localView.getLayoutParams()).a)
        {
          localView.getLeft();
          getClientWidth();
        }
        paramInt += 1;
      }
    }
    this.W = true;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0)
    {
      setScrollingCacheEnabled(false);
      return;
    }
    Scroller localScroller = this.n;
    int i1;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      if (this.o) {
        i1 = this.n.getCurrX();
      } else {
        i1 = this.n.getStartX();
      }
      this.n.abortAnimation();
      setScrollingCacheEnabled(false);
    }
    else
    {
      i1 = getScrollX();
    }
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    int i4 = 0 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      a(false);
      b();
      setScrollState(0);
      return;
    }
    setScrollingCacheEnabled(true);
    setScrollState(2);
    paramInt1 = getClientWidth();
    int i5 = paramInt1 / 2;
    float f2 = Math.abs(i3);
    float f1 = paramInt1;
    float f3 = Math.min(1.0F, f2 * 1.0F / f1);
    f2 = i5;
    f3 = a(f3);
    paramInt1 = Math.abs(paramInt2);
    if (paramInt1 > 0) {
      paramInt1 = Math.round(Math.abs((f2 + f3 * f2) / paramInt1) * 1000.0F) * 4;
    } else {
      paramInt1 = (int)((Math.abs(i3) / (f1 * 1.0F + this.q) + 1.0F) * 100.0F);
    }
    paramInt1 = Math.min(paramInt1, 600);
    this.o = false;
    this.n.startScroll(i1, i2, i3, i4, paramInt1);
    ex.a(this);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.h.isEmpty()))
    {
      if (!this.n.isFinished())
      {
        this.n.setFinalX(getCurrentItem() * getClientWidth());
        return;
      }
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i3 = getPaddingLeft();
      int i4 = getPaddingRight();
      scrollTo((int)(getScrollX() / (paramInt2 - i3 - i4 + paramInt4) * (paramInt1 - i1 - i2 + paramInt3)), getScrollY());
      return;
    }
    b localb = c(this.c);
    float f1;
    if (localb != null) {
      f1 = Math.min(localb.d, this.v);
    } else {
      f1 = 0.0F;
    }
    paramInt1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
    if (paramInt1 != getScrollX())
    {
      a(false);
      scrollTo(paramInt1, getScrollY());
    }
  }
  
  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    b localb = c(paramInt1);
    if (localb != null) {
      paramInt1 = (int)(getClientWidth() * Math.max(this.u, Math.min(localb.d, this.v)));
    } else {
      paramInt1 = 0;
    }
    if (paramBoolean1)
    {
      a(paramInt1, paramInt2);
      if (paramBoolean2) {
        e();
      }
    }
    else
    {
      if (paramBoolean2) {
        e();
      }
      a(false);
      scrollTo(paramInt1, 0);
      d(paramInt1);
    }
  }
  
  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }
  
  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    ev localev = this.b;
    if ((localev != null) && (localev.a() > 0))
    {
      if ((!paramBoolean2) && (this.c == paramInt1) && (this.h.size() != 0))
      {
        setScrollingCacheEnabled(false);
        return;
      }
      paramBoolean2 = true;
      int i1;
      if (paramInt1 < 0)
      {
        i1 = 0;
      }
      else
      {
        i1 = paramInt1;
        if (paramInt1 >= this.b.a()) {
          i1 = this.b.a() - 1;
        }
      }
      paramInt1 = this.B;
      int i2 = this.c;
      if ((i1 > i2 + paramInt1) || (i1 < i2 - paramInt1))
      {
        paramInt1 = 0;
        while (paramInt1 < this.h.size())
        {
          ((b)this.h.get(paramInt1)).b = true;
          paramInt1 += 1;
        }
      }
      if (this.c == i1) {
        paramBoolean2 = false;
      }
      if (this.U)
      {
        this.c = i1;
        if (paramBoolean2) {
          e();
        }
        requestLayout();
        return;
      }
      b(i1);
      a(i1, paramBoolean1, paramInt2, paramBoolean2);
      return;
    }
    setScrollingCacheEnabled(false);
  }
  
  private void a(b paramb1, int paramInt, b paramb2)
  {
    int i4 = this.b.a();
    int i1 = getClientWidth();
    float f2;
    if (i1 > 0) {
      f2 = this.q / i1;
    } else {
      f2 = 0.0F;
    }
    if (paramb2 != null)
    {
      i1 = paramb2.a;
      if (i1 < paramb1.a)
      {
        f1 = paramb2.d + paramb2.c + f2;
        i1 += 1;
        i2 = 0;
        while ((i1 <= paramb1.a) && (i2 < this.h.size()))
        {
          for (paramb2 = (b)this.h.get(i2);; paramb2 = (b)this.h.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 <= paramb2.a) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 >= this.h.size() - 1) {
              break;
            }
            i2 += 1;
          }
          while (i3 < paramb2.a)
          {
            f3 += f2 + 1.0F;
            i3 += 1;
          }
          paramb2.d = f3;
          f1 = f3 + (paramb2.c + f2);
          i1 = i3 + 1;
        }
      }
      if (i1 > paramb1.a)
      {
        i2 = this.h.size() - 1;
        f1 = paramb2.d;
        i1 -= 1;
        while ((i1 >= paramb1.a) && (i2 >= 0))
        {
          for (paramb2 = (b)this.h.get(i2);; paramb2 = (b)this.h.get(i2))
          {
            i3 = i1;
            f3 = f1;
            if (i1 >= paramb2.a) {
              break;
            }
            i3 = i1;
            f3 = f1;
            if (i2 <= 0) {
              break;
            }
            i2 -= 1;
          }
          while (i3 > paramb2.a)
          {
            f3 -= f2 + 1.0F;
            i3 -= 1;
          }
          f1 = f3 - (paramb2.c + f2);
          paramb2.d = f1;
          i1 = i3 - 1;
        }
      }
    }
    int i3 = this.h.size();
    float f3 = paramb1.d;
    i1 = paramb1.a - 1;
    if (paramb1.a == 0) {
      f1 = paramb1.d;
    } else {
      f1 = -3.402824E+038F;
    }
    this.u = f1;
    int i2 = paramb1.a;
    i4 -= 1;
    if (i2 == i4) {
      f1 = paramb1.d + paramb1.c - 1.0F;
    } else {
      f1 = 3.4028235E+38F;
    }
    this.v = f1;
    i2 = paramInt - 1;
    float f1 = f3;
    while (i2 >= 0)
    {
      paramb2 = (b)this.h.get(i2);
      while (i1 > paramb2.a)
      {
        i1 -= 1;
        f1 -= f2 + 1.0F;
      }
      f1 -= paramb2.c + f2;
      paramb2.d = f1;
      if (paramb2.a == 0) {
        this.u = f1;
      }
      i2 -= 1;
      i1 -= 1;
    }
    f1 = paramb1.d + paramb1.c + f2;
    i2 = paramb1.a + 1;
    i1 = paramInt + 1;
    paramInt = i2;
    while (i1 < i3)
    {
      paramb1 = (b)this.h.get(i1);
      while (paramInt < paramb1.a)
      {
        paramInt += 1;
        f1 += f2 + 1.0F;
      }
      if (paramb1.a == i4) {
        this.v = (paramb1.c + f1 - 1.0F);
      }
      paramb1.d = f1;
      f1 += paramb1.c + f2;
      i1 += 1;
      paramInt += 1;
    }
    this.V = false;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.L)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.H = paramMotionEvent.getX(i1);
      this.L = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.M;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.ak == 2) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 != 0)
    {
      setScrollingCacheEnabled(false);
      if ((this.n.isFinished() ^ true))
      {
        this.n.abortAnimation();
        i2 = getScrollX();
        i3 = getScrollY();
        int i4 = this.n.getCurrX();
        int i5 = this.n.getCurrY();
        if ((i2 != i4) || (i3 != i5))
        {
          scrollTo(i4, i5);
          if (i4 != i2) {
            d(i4);
          }
        }
      }
    }
    this.A = false;
    int i3 = 0;
    int i2 = i1;
    int i1 = i3;
    while (i1 < this.h.size())
    {
      b localb = (b)this.h.get(i1);
      if (localb.b)
      {
        localb.b = false;
        i2 = 1;
      }
      i1 += 1;
    }
    if (i2 != 0)
    {
      if (paramBoolean)
      {
        ex.a(this, this.aj);
        return;
      }
      this.aj.run();
    }
  }
  
  private boolean a(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i2 = paramView.getScrollX();
      int i3 = paramView.getScrollY();
      int i1 = localViewGroup.getChildCount() - 1;
      while (i1 >= 0)
      {
        View localView = localViewGroup.getChildAt(i1);
        int i4 = paramInt2 + i2;
        if ((i4 >= localView.getLeft()) && (i4 < localView.getRight()))
        {
          int i5 = paramInt3 + i3;
          if ((i5 >= localView.getTop()) && (i5 < localView.getBottom()) && (a(localView, true, paramInt1, i4 - localView.getLeft(), i5 - localView.getTop()))) {
            return true;
          }
        }
        i1 -= 1;
      }
    }
    return (paramBoolean) && (paramView.canScrollHorizontally(-paramInt1));
  }
  
  private void b(int paramInt)
  {
    int i1 = this.c;
    if (i1 != paramInt)
    {
      localObject2 = c(i1);
      this.c = paramInt;
    }
    else
    {
      localObject2 = null;
    }
    if (this.b == null)
    {
      c();
      return;
    }
    if (this.A)
    {
      c();
      return;
    }
    if (getWindowToken() == null) {
      return;
    }
    paramInt = this.B;
    int i7 = Math.max(0, this.c - paramInt);
    int i5 = this.b.a();
    int i6 = Math.min(i5 - 1, this.c + paramInt);
    if (i5 == this.e)
    {
      paramInt = 0;
      while (paramInt < this.h.size())
      {
        localObject1 = (b)this.h.get(paramInt);
        if (((b)localObject1).a >= this.c)
        {
          if (((b)localObject1).a != this.c) {
            break;
          }
          break label176;
        }
        paramInt += 1;
      }
      localObject1 = null;
      label176:
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject3 = localObject1;
        if (i5 > 0) {
          localObject3 = a(this.c);
        }
      }
      if (localObject3 != null)
      {
        int i4 = paramInt - 1;
        if (i4 >= 0) {
          localObject1 = (b)this.h.get(i4);
        } else {
          localObject1 = null;
        }
        int i8 = getClientWidth();
        float f2;
        if (i8 <= 0) {
          f2 = 0.0F;
        } else {
          f2 = 2.0F - ((b)localObject3).c + getPaddingLeft() / i8;
        }
        int i3 = this.c - 1;
        float f3 = 0.0F;
        Object localObject4 = localObject1;
        int i2 = paramInt;
        float f1;
        while (i3 >= 0)
        {
          if ((f3 >= f2) && (i3 < i7))
          {
            if (localObject4 == null) {
              break;
            }
            f1 = f3;
            paramInt = i2;
            localObject1 = localObject4;
            i1 = i4;
            if (i3 == localObject4.a)
            {
              f1 = f3;
              paramInt = i2;
              localObject1 = localObject4;
              i1 = i4;
              if (!localObject4.b)
              {
                this.h.remove(i4);
                ev.b();
                i1 = i4 - 1;
                paramInt = i2 - 1;
                if (i1 >= 0) {
                  localObject1 = (b)this.h.get(i1);
                } else {
                  localObject1 = null;
                }
                f1 = f3;
              }
            }
          }
          else if ((localObject4 != null) && (i3 == localObject4.a))
          {
            f1 = f3 + localObject4.c;
            i1 = i4 - 1;
            if (i1 >= 0) {
              localObject1 = (b)this.h.get(i1);
            } else {
              localObject1 = null;
            }
            paramInt = i2;
          }
          else
          {
            f1 = f3 + a(i3).c;
            paramInt = i2 + 1;
            if (i4 >= 0) {
              localObject1 = (b)this.h.get(i4);
            } else {
              localObject1 = null;
            }
            i1 = i4;
          }
          i3 -= 1;
          f3 = f1;
          i2 = paramInt;
          localObject4 = localObject1;
          i4 = i1;
        }
        f3 = ((b)localObject3).c;
        i1 = i2 + 1;
        if (f3 < 2.0F)
        {
          if (i1 < this.h.size()) {
            localObject1 = (b)this.h.get(i1);
          } else {
            localObject1 = null;
          }
          if (i8 <= 0) {
            f2 = 0.0F;
          } else {
            f2 = getPaddingRight() / i8 + 2.0F;
          }
          paramInt = this.c;
          localObject4 = localObject1;
          for (;;)
          {
            i3 = paramInt + 1;
            if (i3 >= i5) {
              break;
            }
            if ((f3 >= f2) && (i3 > i6))
            {
              if (localObject4 == null) {
                break;
              }
              f1 = f3;
              paramInt = i1;
              localObject1 = localObject4;
              if (i3 == localObject4.a)
              {
                f1 = f3;
                paramInt = i1;
                localObject1 = localObject4;
                if (!localObject4.b)
                {
                  this.h.remove(i1);
                  ev.b();
                  if (i1 < this.h.size())
                  {
                    localObject1 = (b)this.h.get(i1);
                    f1 = f3;
                    paramInt = i1;
                  }
                  else
                  {
                    localObject1 = null;
                    f1 = f3;
                    paramInt = i1;
                  }
                }
              }
            }
            else if ((localObject4 != null) && (i3 == localObject4.a))
            {
              f1 = f3 + localObject4.c;
              paramInt = i1 + 1;
              if (paramInt < this.h.size()) {
                localObject1 = (b)this.h.get(paramInt);
              } else {
                localObject1 = null;
              }
            }
            else
            {
              localObject1 = a(i3);
              paramInt = i1 + 1;
              f1 = f3 + ((b)localObject1).c;
              if (paramInt < this.h.size()) {
                localObject1 = (b)this.h.get(paramInt);
              } else {
                localObject1 = null;
              }
            }
            f3 = f1;
            i1 = paramInt;
            localObject4 = localObject1;
            paramInt = i3;
          }
        }
        a((b)localObject3, i2, (b)localObject2);
      }
      i1 = getChildCount();
      paramInt = 0;
      while (paramInt < i1)
      {
        localObject1 = (LayoutParams)getChildAt(paramInt).getLayoutParams();
        ((LayoutParams)localObject1).f = paramInt;
        if ((!((LayoutParams)localObject1).a) && (((LayoutParams)localObject1).c == 0.0F))
        {
          localObject2 = d();
          if (localObject2 != null)
          {
            ((LayoutParams)localObject1).c = ((b)localObject2).c;
            ((LayoutParams)localObject1).e = ((b)localObject2).a;
          }
        }
        paramInt += 1;
      }
      c();
      if (hasFocus())
      {
        localObject1 = findFocus();
        if (localObject1 != null) {
          localObject1 = a((View)localObject1);
        } else {
          localObject1 = null;
        }
        if ((localObject1 == null) || (((b)localObject1).a != this.c))
        {
          paramInt = 0;
          while (paramInt < getChildCount())
          {
            localObject1 = getChildAt(paramInt);
            localObject2 = d();
            if ((localObject2 != null) && (((b)localObject2).a == this.c) && (((View)localObject1).requestFocus(2))) {
              break;
            }
            paramInt += 1;
          }
        }
      }
      return;
    }
    try
    {
      localObject1 = getResources().getResourceName(getId());
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      label1111:
      break label1111;
    }
    Object localObject1 = Integer.toHexString(getId());
    Object localObject2 = new StringBuilder("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ");
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append(", found: ");
    ((StringBuilder)localObject2).append(i5);
    ((StringBuilder)localObject2).append(" Pager id: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" Pager class: ");
    ((StringBuilder)localObject2).append(getClass());
    ((StringBuilder)localObject2).append(" Problematic adapter: ");
    ((StringBuilder)localObject2).append(this.b.getClass());
    throw new IllegalStateException(((StringBuilder)localObject2).toString());
  }
  
  private void b(int paramInt, float paramFloat)
  {
    Object localObject = this.ac;
    if (localObject != null) {
      ((e)localObject).a(paramInt, paramFloat);
    }
    localObject = this.ab;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (e)this.ab.get(i1);
        if (localObject != null) {
          ((e)localObject).a(paramInt, paramFloat);
        }
        i1 += 1;
      }
    }
    localObject = this.ad;
    if (localObject != null) {
      ((e)localObject).a(paramInt, paramFloat);
    }
  }
  
  private boolean b(float paramFloat)
  {
    float f1 = this.H;
    this.H = paramFloat;
    float f2 = getScrollX() + (f1 - paramFloat);
    float f3 = getClientWidth();
    paramFloat = this.u * f3;
    f1 = this.v * f3;
    Object localObject1 = this.h;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    localObject1 = (b)((ArrayList)localObject1).get(0);
    Object localObject2 = this.h;
    localObject2 = (b)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1);
    if (((b)localObject1).a != 0)
    {
      paramFloat = ((b)localObject1).d * f3;
      i1 = 0;
    }
    else
    {
      i1 = 1;
    }
    int i2;
    if (((b)localObject2).a != this.b.a() - 1)
    {
      f1 = ((b)localObject2).d * f3;
      i2 = 0;
    }
    else
    {
      i2 = 1;
    }
    if (f2 < paramFloat)
    {
      if (i1 != 0)
      {
        this.S.onPull(Math.abs(paramFloat - f2) / f3);
        bool1 = true;
      }
    }
    else
    {
      bool1 = bool3;
      paramFloat = f2;
      if (f2 > f1)
      {
        bool1 = bool2;
        if (i2 != 0)
        {
          this.T.onPull(Math.abs(f2 - f1) / f3);
          bool1 = true;
        }
        paramFloat = f1;
      }
    }
    f1 = this.H;
    int i1 = (int)paramFloat;
    this.H = (f1 + (paramFloat - i1));
    scrollTo(i1, getScrollY());
    d(i1);
    return bool1;
  }
  
  private b c(int paramInt)
  {
    int i1 = 0;
    while (i1 < this.h.size())
    {
      b localb = (b)this.h.get(i1);
      if (localb.a == paramInt) {
        return localb;
      }
      i1 += 1;
    }
    return null;
  }
  
  private void c()
  {
    if (this.ag != 0)
    {
      Object localObject = this.ah;
      if (localObject == null) {
        this.ah = new ArrayList();
      } else {
        ((ArrayList)localObject).clear();
      }
      int i2 = getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = getChildAt(i1);
        this.ah.add(localObject);
        i1 += 1;
      }
      Collections.sort(this.ah, ai);
    }
  }
  
  private b d()
  {
    int i1 = 0;
    while (i1 < this.h.size())
    {
      b localb = (b)this.h.get(i1);
      if (this.b.c()) {
        return localb;
      }
      i1 += 1;
    }
    return null;
  }
  
  private boolean d(int paramInt)
  {
    if (this.h.size() == 0)
    {
      if (this.U) {
        return false;
      }
      this.W = false;
      a(0, 0.0F);
      if (this.W) {
        return false;
      }
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    b localb = h();
    int i1 = getClientWidth();
    float f2 = this.q;
    float f1 = i1;
    f2 /= f1;
    i1 = localb.a;
    f1 = (paramInt / f1 - localb.d) / (localb.c + f2);
    this.W = false;
    a(i1, f1);
    if (this.W) {
      return true;
    }
    throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }
  
  private void e()
  {
    Object localObject = this.ac;
    if (localObject != null) {
      ((e)localObject).a();
    }
    localObject = this.ab;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (e)this.ab.get(i1);
        if (localObject != null) {
          ((e)localObject).a();
        }
        i1 += 1;
      }
    }
    localObject = this.ad;
    if (localObject != null) {
      ((e)localObject).a();
    }
  }
  
  private boolean e(int paramInt)
  {
    View localView2 = findFocus();
    boolean bool = false;
    View localView1 = null;
    Object localObject;
    int i1;
    if (localView2 == this)
    {
      localObject = localView1;
    }
    else
    {
      if (localView2 != null)
      {
        for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent()) {
          if (localObject == this)
          {
            i1 = 1;
            break label70;
          }
        }
        i1 = 0;
        label70:
        if (i1 == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localView2.getClass().getSimpleName());
          for (localObject = localView2.getParent(); (localObject instanceof ViewGroup); localObject = ((ViewParent)localObject).getParent())
          {
            localStringBuilder.append(" => ");
            localStringBuilder.append(localObject.getClass().getSimpleName());
          }
          new StringBuilder("arrowScroll tried to find focus based on non-child current focused view ").append(localStringBuilder.toString());
          localObject = localView1;
          break label177;
        }
      }
      localObject = localView2;
    }
    label177:
    localView1 = FocusFinder.getInstance().findNextFocus(this, (View)localObject, paramInt);
    if ((localView1 != null) && (localView1 != localObject))
    {
      if (paramInt == 17)
      {
        i1 = a(this.j, localView1).left;
        i2 = a(this.j, (View)localObject).left;
        if ((localObject != null) && (i1 >= i2))
        {
          bool = j();
          break label358;
        }
        bool = localView1.requestFocus();
        break label358;
      }
      if (paramInt != 66) {
        break label358;
      }
      i1 = a(this.j, localView1).left;
      int i2 = a(this.j, (View)localObject).left;
      if ((localObject == null) || (i1 > i2))
      {
        bool = localView1.requestFocus();
        break label358;
      }
    }
    else
    {
      if ((paramInt == 17) || (paramInt == 1)) {
        break label352;
      }
      if ((paramInt != 66) && (paramInt != 2)) {
        break label358;
      }
    }
    bool = k();
    break label358;
    label352:
    bool = j();
    label358:
    if (bool) {
      playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
    }
    return bool;
  }
  
  private boolean f()
  {
    this.L = -1;
    i();
    this.S.onRelease();
    this.T.onRelease();
    return (this.S.isFinished()) || (this.T.isFinished());
  }
  
  private void g()
  {
    ViewParent localViewParent = getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  private int getClientWidth()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }
  
  private b h()
  {
    int i1 = getClientWidth();
    float f1;
    if (i1 > 0) {
      f1 = getScrollX() / i1;
    } else {
      f1 = 0.0F;
    }
    float f2;
    if (i1 > 0) {
      f2 = this.q / i1;
    } else {
      f2 = 0.0F;
    }
    Object localObject = null;
    i1 = 0;
    int i2 = 1;
    int i3 = -1;
    float f3 = 0.0F;
    float f4 = 0.0F;
    while (i1 < this.h.size())
    {
      b localb2 = (b)this.h.get(i1);
      int i4 = i1;
      b localb1 = localb2;
      if (i2 == 0)
      {
        int i5 = localb2.a;
        i3 += 1;
        i4 = i1;
        localb1 = localb2;
        if (i5 != i3)
        {
          localb1 = this.i;
          localb1.d = (f3 + f4 + f2);
          localb1.a = i3;
          localb1.c = 1.0F;
          i4 = i1 - 1;
        }
      }
      f3 = localb1.d;
      f4 = localb1.c;
      if ((i2 == 0) && (f1 < f3)) {
        return localObject;
      }
      if (f1 >= f4 + f3 + f2)
      {
        if (i4 == this.h.size() - 1) {
          return localb1;
        }
        i3 = localb1.a;
        f4 = localb1.c;
        i1 = i4 + 1;
        i2 = 0;
        localObject = localb1;
      }
      else
      {
        return localb1;
      }
    }
    return localObject;
  }
  
  private void i()
  {
    this.C = false;
    this.D = false;
    VelocityTracker localVelocityTracker = this.M;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.M = null;
    }
  }
  
  private boolean j()
  {
    int i1 = this.c;
    if (i1 > 0)
    {
      setCurrentItem$2563266(i1 - 1);
      return true;
    }
    return false;
  }
  
  private boolean k()
  {
    ev localev = this.b;
    if ((localev != null) && (this.c < localev.a() - 1))
    {
      setCurrentItem$2563266(this.c + 1);
      return true;
    }
    return false;
  }
  
  private void setCurrentItem$2563266(int paramInt)
  {
    this.A = false;
    a(paramInt, true, false);
  }
  
  private void setScrollingCacheEnabled(boolean paramBoolean)
  {
    if (this.z != paramBoolean) {
      this.z = paramBoolean;
    }
  }
  
  final e a(e parame)
  {
    e locale = this.ad;
    this.ad = parame;
    return locale;
  }
  
  final void a()
  {
    int i1 = this.b.a();
    this.e = i1;
    if ((this.h.size() < this.B * 2 + 1) && (this.h.size() < i1)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i3 = this.c;
    int i2 = 0;
    while (i2 < this.h.size())
    {
      this.h.get(i2);
      i2 += 1;
    }
    Collections.sort(this.h, f);
    if (i1 != 0)
    {
      i2 = getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        LayoutParams localLayoutParams = (LayoutParams)getChildAt(i1).getLayoutParams();
        if (!localLayoutParams.a) {
          localLayoutParams.c = 0.0F;
        }
        i1 += 1;
      }
      a(i3, false, true);
      requestLayout();
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i2 = paramArrayList.size();
    int i3 = getDescendantFocusability();
    if (i3 != 393216)
    {
      int i1 = 0;
      while (i1 < getChildCount())
      {
        View localView = getChildAt(i1);
        if (localView.getVisibility() == 0)
        {
          b localb = d();
          if ((localb != null) && (localb.a == this.c)) {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          }
        }
        i1 += 1;
      }
    }
    if ((i3 != 262144) || (i2 == paramArrayList.size()))
    {
      if (!isFocusable()) {
        return;
      }
      if (((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) {
        return;
      }
      if (paramArrayList != null) {
        paramArrayList.add(this);
      }
    }
  }
  
  public void addTouchables(ArrayList<View> paramArrayList)
  {
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = d();
        if ((localb != null) && (localb.a == this.c)) {
          localView.addTouchables(paramArrayList);
        }
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    ViewGroup.LayoutParams localLayoutParams = paramLayoutParams;
    if (!checkLayoutParams(paramLayoutParams)) {
      localLayoutParams = generateLayoutParams(paramLayoutParams);
    }
    paramLayoutParams = (LayoutParams)localLayoutParams;
    boolean bool2 = paramLayoutParams.a;
    boolean bool1;
    if (paramView.getClass().getAnnotation(a.class) != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramLayoutParams.a = (bool2 | bool1);
    if (this.y)
    {
      if ((paramLayoutParams != null) && (paramLayoutParams.a)) {
        throw new IllegalStateException("Cannot add pager decor view during layout");
      }
      paramLayoutParams.d = true;
      addViewInLayout(paramView, paramInt, localLayoutParams);
      return;
    }
    super.addView(paramView, paramInt, localLayoutParams);
  }
  
  final void b()
  {
    b(this.c);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.b == null) {
      return false;
    }
    int i1 = getClientWidth();
    int i2 = getScrollX();
    if (paramInt < 0) {
      return i2 > (int)(i1 * this.u);
    }
    if (paramInt > 0) {
      return i2 < (int)(i1 * this.v);
    }
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    this.o = true;
    if ((!this.n.isFinished()) && (this.n.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.n.getCurrX();
      int i4 = this.n.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.n.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ex.a(this);
      return;
    }
    a(true);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if (!super.dispatchKeyEvent(paramKeyEvent))
    {
      if (paramKeyEvent.getAction() == 0)
      {
        int i1 = paramKeyEvent.getKeyCode();
        if (i1 != 61)
        {
          switch (i1)
          {
          default: 
            break;
          case 22: 
            if (paramKeyEvent.hasModifiers(2)) {
              bool = k();
            } else {
              bool = e(66);
            }
            break;
          case 21: 
            if (paramKeyEvent.hasModifiers(2)) {
              bool = j();
            } else {
              bool = e(17);
            }
            break;
          }
        }
        else
        {
          if (paramKeyEvent.hasNoModifiers())
          {
            bool = e(2);
            break label138;
          }
          if (paramKeyEvent.hasModifiers(1))
          {
            bool = e(1);
            break label138;
          }
        }
      }
      boolean bool = false;
      label138:
      return bool;
    }
    return true;
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if (paramAccessibilityEvent.getEventType() == 4096) {
      return super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = d();
        if ((localb != null) && (localb.a == this.c) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent))) {
          return true;
        }
      }
      i1 += 1;
    }
    return false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i4 = getOverScrollMode();
    int i3 = 0;
    int i1 = 0;
    if (i4 != 0) {
      if (i4 == 1)
      {
        ev localev = this.b;
        if ((localev != null) && (localev.a() > 1)) {}
      }
      else
      {
        this.S.finish();
        this.T.finish();
        break label256;
      }
    }
    int i2;
    if (!this.S.isFinished())
    {
      i3 = paramCanvas.save();
      i1 = getHeight() - getPaddingTop() - getPaddingBottom();
      i4 = getWidth();
      paramCanvas.rotate(270.0F);
      paramCanvas.translate(-i1 + getPaddingTop(), this.u * i4);
      this.S.setSize(i1, i4);
      i2 = false | this.S.draw(paramCanvas);
      paramCanvas.restoreToCount(i3);
    }
    i3 = i2;
    boolean bool;
    if (!this.T.isFinished())
    {
      i4 = paramCanvas.save();
      i3 = getWidth();
      int i5 = getHeight();
      int i6 = getPaddingTop();
      int i7 = getPaddingBottom();
      paramCanvas.rotate(90.0F);
      paramCanvas.translate(-getPaddingTop(), -(this.v + 1.0F) * i3);
      this.T.setSize(i5 - i6 - i7, i3);
      bool = i2 | this.T.draw(paramCanvas);
      paramCanvas.restoreToCount(i4);
    }
    label256:
    if (bool) {
      ex.a(this);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.r;
    if ((localDrawable != null) && (localDrawable.isStateful())) {
      localDrawable.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }
  
  public ev getAdapter()
  {
    return this.b;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = paramInt2;
    if (this.ag == 2) {
      i1 = paramInt1 - 1 - paramInt2;
    }
    return ((LayoutParams)((View)this.ah.get(i1)).getLayoutParams()).f;
  }
  
  public int getCurrentItem()
  {
    return this.c;
  }
  
  public int getOffscreenPageLimit()
  {
    return this.B;
  }
  
  public int getPageMargin()
  {
    return this.q;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.U = true;
  }
  
  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.aj);
    Scroller localScroller = this.n;
    if ((localScroller != null) && (!localScroller.isFinished())) {
      this.n.abortAnimation();
    }
    super.onDetachedFromWindow();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.q > 0) && (this.r != null) && (this.h.size() > 0) && (this.b != null))
    {
      int i3 = getScrollX();
      int i4 = getWidth();
      float f1 = this.q;
      float f5 = i4;
      float f2 = f1 / f5;
      Object localObject = this.h;
      int i2 = 0;
      localObject = (b)((ArrayList)localObject).get(0);
      f1 = ((b)localObject).d;
      int i5 = this.h.size();
      int i1 = ((b)localObject).a;
      int i6 = ((b)this.h.get(i5 - 1)).a;
      while (i1 < i6)
      {
        while ((i1 > ((b)localObject).a) && (i2 < i5))
        {
          localObject = this.h;
          i2 += 1;
          localObject = (b)((ArrayList)localObject).get(i2);
        }
        float f3;
        if (i1 == ((b)localObject).a)
        {
          f3 = (((b)localObject).d + ((b)localObject).c) * f5;
          f1 = ((b)localObject).d + ((b)localObject).c + f2;
        }
        else
        {
          f3 = f1 + (1.0F + f2);
          float f4 = (f1 + 1.0F) * f5;
          f1 = f3;
          f3 = f4;
        }
        if (this.q + f3 > i3)
        {
          this.r.setBounds(Math.round(f3), this.s, Math.round(this.q + f3), this.t);
          this.r.draw(paramCanvas);
        }
        if (f3 > i3 + i4) {
          break;
        }
        i1 += 1;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 3) && (i1 != 1))
    {
      if (i1 != 0)
      {
        if (this.C) {
          return true;
        }
        if (this.D) {
          return false;
        }
      }
      float f1;
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 == 6) {
            a(paramMotionEvent);
          }
        }
        else
        {
          i1 = this.L;
          if (i1 != -1)
          {
            i1 = paramMotionEvent.findPointerIndex(i1);
            float f2 = paramMotionEvent.getX(i1);
            f1 = f2 - this.H;
            float f4 = Math.abs(f1);
            float f3 = paramMotionEvent.getY(i1);
            float f5 = Math.abs(f3 - this.K);
            if (f1 != 0.0F)
            {
              float f6 = this.H;
              if (((f6 < this.F) && (f1 > 0.0F)) || ((f6 > getWidth() - this.F) && (f1 < 0.0F))) {
                i1 = 1;
              } else {
                i1 = 0;
              }
              if ((i1 == 0) && (a(this, false, (int)f1, (int)f2, (int)f3)))
              {
                this.H = f2;
                this.I = f3;
                this.D = true;
                return false;
              }
            }
            if ((f4 > this.G) && (f4 * 0.5F > f5))
            {
              this.C = true;
              g();
              setScrollState(1);
              if (f1 > 0.0F) {
                f1 = this.J + this.G;
              } else {
                f1 = this.J - this.G;
              }
              this.H = f1;
              this.I = f3;
              setScrollingCacheEnabled(true);
            }
            else if (f5 > this.G)
            {
              this.D = true;
            }
            if ((this.C) && (b(f2))) {
              ex.a(this);
            }
          }
        }
      }
      else
      {
        f1 = paramMotionEvent.getX();
        this.J = f1;
        this.H = f1;
        f1 = paramMotionEvent.getY();
        this.K = f1;
        this.I = f1;
        this.L = paramMotionEvent.getPointerId(0);
        this.D = false;
        this.o = true;
        this.n.computeScrollOffset();
        if ((this.ak == 2) && (Math.abs(this.n.getFinalX() - this.n.getCurrX()) > this.Q))
        {
          this.n.abortAnimation();
          this.A = false;
          b();
          this.C = true;
          g();
          setScrollState(1);
        }
        else
        {
          a(false);
          this.C = false;
        }
      }
      if (this.M == null) {
        this.M = VelocityTracker.obtain();
      }
      this.M.addMovement(paramMotionEvent);
      return this.C;
    }
    f();
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i8 = getChildCount();
    int i9 = paramInt3 - paramInt1;
    int i10 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt1 = getPaddingTop();
    int i2 = getPaddingRight();
    paramInt4 = getPaddingBottom();
    int i11 = getScrollX();
    int i3 = 0;
    int i4 = 0;
    View localView;
    int i1;
    LayoutParams localLayoutParams;
    while (i4 < i8)
    {
      localView = getChildAt(i4);
      i1 = paramInt2;
      int i7 = i2;
      int i6 = paramInt1;
      int i5 = paramInt4;
      paramInt3 = i3;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = paramInt2;
        i7 = i2;
        i6 = paramInt1;
        i5 = paramInt4;
        paramInt3 = i3;
        if (localLayoutParams.a)
        {
          paramInt3 = localLayoutParams.b & 0x7;
          i5 = localLayoutParams.b & 0x70;
          if (paramInt3 != 1)
          {
            if (paramInt3 != 3)
            {
              if (paramInt3 != 5)
              {
                paramInt3 = paramInt2;
                i1 = paramInt2;
              }
              else
              {
                paramInt3 = i9 - i2 - localView.getMeasuredWidth();
                i2 += localView.getMeasuredWidth();
                i1 = paramInt2;
              }
            }
            else
            {
              i1 = localView.getMeasuredWidth();
              paramInt3 = paramInt2;
              i1 += paramInt2;
            }
          }
          else
          {
            paramInt3 = Math.max((i9 - localView.getMeasuredWidth()) / 2, paramInt2);
            i1 = paramInt2;
          }
          if (i5 != 16)
          {
            if (i5 != 48)
            {
              if (i5 != 80)
              {
                paramInt2 = paramInt1;
              }
              else
              {
                paramInt2 = i10 - paramInt4 - localView.getMeasuredHeight();
                paramInt4 += localView.getMeasuredHeight();
              }
            }
            else
            {
              i5 = localView.getMeasuredHeight();
              paramInt2 = paramInt1;
              paramInt1 = i5 + paramInt1;
            }
          }
          else {
            paramInt2 = Math.max((i10 - localView.getMeasuredHeight()) / 2, paramInt1);
          }
          paramInt3 += i11;
          localView.layout(paramInt3, paramInt2, localView.getMeasuredWidth() + paramInt3, paramInt2 + localView.getMeasuredHeight());
          paramInt3 = i3 + 1;
          i5 = paramInt4;
          i6 = paramInt1;
          i7 = i2;
        }
      }
      i4 += 1;
      paramInt2 = i1;
      i2 = i7;
      paramInt1 = i6;
      paramInt4 = i5;
      i3 = paramInt3;
    }
    paramInt3 = 0;
    while (paramInt3 < i8)
    {
      localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (!localLayoutParams.a)
        {
          b localb = d();
          if (localb != null)
          {
            float f1 = i9 - paramInt2 - i2;
            i1 = (int)(localb.d * f1) + paramInt2;
            if (localLayoutParams.d)
            {
              localLayoutParams.d = false;
              localView.measure(View.MeasureSpec.makeMeasureSpec((int)(f1 * localLayoutParams.c), 1073741824), View.MeasureSpec.makeMeasureSpec(i10 - paramInt1 - paramInt4, 1073741824));
            }
            localView.layout(i1, paramInt1, localView.getMeasuredWidth() + i1, localView.getMeasuredHeight() + paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.s = paramInt1;
    this.t = (i10 - paramInt4);
    this.aa = i3;
    if (this.U) {
      a(this.c, false, 0, false);
    }
    this.U = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    paramInt1 = getMeasuredWidth();
    this.F = Math.min(paramInt1 / 10, this.E);
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    paramInt2 = getMeasuredHeight();
    int i3 = getPaddingTop();
    int i4 = getPaddingBottom();
    int i9 = getChildCount();
    paramInt2 = paramInt2 - i3 - i4;
    paramInt1 = paramInt1 - i1 - i2;
    i4 = 0;
    View localView;
    LayoutParams localLayoutParams;
    for (;;)
    {
      i3 = 1;
      int i8 = 1073741824;
      if (i4 >= i9) {
        break;
      }
      localView = getChildAt(i4);
      i1 = paramInt1;
      i2 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        i1 = paramInt1;
        i2 = paramInt2;
        if (localLayoutParams != null)
        {
          i1 = paramInt1;
          i2 = paramInt2;
          if (localLayoutParams.a)
          {
            i1 = localLayoutParams.b & 0x7;
            i2 = localLayoutParams.b & 0x70;
            int i6;
            if ((i2 != 48) && (i2 != 80)) {
              i6 = 0;
            } else {
              i6 = 1;
            }
            int i5 = i3;
            if (i1 != 3) {
              if (i1 == 5) {
                i5 = i3;
              } else {
                i5 = 0;
              }
            }
            i2 = -2147483648;
            if (i6 != 0)
            {
              i2 = 1073741824;
              i1 = -2147483648;
            }
            else if (i5 != 0)
            {
              i1 = 1073741824;
            }
            else
            {
              i1 = -2147483648;
            }
            if (localLayoutParams.width != -2)
            {
              if (localLayoutParams.width != -1)
              {
                i3 = localLayoutParams.width;
                i2 = 1073741824;
              }
              else
              {
                i3 = paramInt1;
                i2 = 1073741824;
              }
            }
            else {
              i3 = paramInt1;
            }
            if (localLayoutParams.height != -2)
            {
              if (localLayoutParams.height != -1) {
                i1 = localLayoutParams.height;
              } else {
                i1 = paramInt2;
              }
            }
            else
            {
              int i7 = paramInt2;
              i8 = i1;
              i1 = i7;
            }
            localView.measure(View.MeasureSpec.makeMeasureSpec(i3, i2), View.MeasureSpec.makeMeasureSpec(i1, i8));
            if (i6 != 0)
            {
              i2 = paramInt2 - localView.getMeasuredHeight();
              i1 = paramInt1;
            }
            else
            {
              i1 = paramInt1;
              i2 = paramInt2;
              if (i5 != 0)
              {
                i1 = paramInt1 - localView.getMeasuredWidth();
                i2 = paramInt2;
              }
            }
          }
        }
      }
      i4 += 1;
      paramInt1 = i1;
      paramInt2 = i2;
    }
    this.w = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
    this.x = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
    this.y = true;
    b();
    paramInt2 = 0;
    this.y = false;
    i1 = getChildCount();
    while (paramInt2 < i1)
    {
      localView = getChildAt(paramInt2);
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams == null) || (!localLayoutParams.a)) {
          localView.measure(View.MeasureSpec.makeMeasureSpec((int)(paramInt1 * localLayoutParams.c), 1073741824), this.x);
        }
      }
      paramInt2 += 1;
    }
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = getChildCount();
    int i3 = -1;
    int i2;
    if ((paramInt & 0x2) != 0)
    {
      i3 = i1;
      i1 = 0;
      i2 = 1;
    }
    else
    {
      i1 -= 1;
      i2 = -1;
    }
    while (i1 != i3)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        b localb = d();
        if ((localb != null) && (localb.a == this.c) && (localView.requestFocus(paramInt, paramRect))) {
          return true;
        }
      }
      i1 += i2;
    }
    return false;
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.c);
    if (this.b != null)
    {
      a(paramParcelable.a, false, true);
      return;
    }
    this.k = paramParcelable.a;
    this.l = paramParcelable.d;
    this.m = paramParcelable.e;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = this.c;
    if (this.b != null) {
      localSavedState.d = null;
    }
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
    {
      paramInt2 = this.q;
      a(paramInt1, paramInt3, paramInt2, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.R) {
      return true;
    }
    int i1 = paramMotionEvent.getAction();
    boolean bool = false;
    if ((i1 == 0) && (paramMotionEvent.getEdgeFlags() != 0)) {
      return false;
    }
    Object localObject = this.b;
    if (localObject != null)
    {
      if (((ev)localObject).a() == 0) {
        return false;
      }
      if (this.M == null) {
        this.M = VelocityTracker.obtain();
      }
      this.M.addMovement(paramMotionEvent);
      float f1;
      float f2;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 4: 
      default: 
        break;
      case 6: 
        a(paramMotionEvent);
        this.H = paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.L));
        break;
      case 5: 
        i1 = paramMotionEvent.getActionIndex();
        this.H = paramMotionEvent.getX(i1);
        this.L = paramMotionEvent.getPointerId(i1);
        break;
      case 3: 
        if (this.C)
        {
          a(this.c, true, 0, false);
          bool = f();
        }
        break;
      case 2: 
        if (!this.C)
        {
          i1 = paramMotionEvent.findPointerIndex(this.L);
          if (i1 == -1)
          {
            bool = f();
            break;
          }
          f1 = paramMotionEvent.getX(i1);
          float f3 = Math.abs(f1 - this.H);
          f2 = paramMotionEvent.getY(i1);
          float f4 = Math.abs(f2 - this.I);
          if ((f3 > this.G) && (f3 > f4))
          {
            this.C = true;
            g();
            f3 = this.J;
            if (f1 - f3 > 0.0F) {
              f1 = f3 + this.G;
            } else {
              f1 = f3 - this.G;
            }
            this.H = f1;
            this.I = f2;
            setScrollState(1);
            setScrollingCacheEnabled(true);
            localObject = getParent();
            if (localObject != null) {
              ((ViewParent)localObject).requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        if (this.C) {
          bool = false | b(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.L)));
        }
        break;
      case 1: 
        if (this.C)
        {
          localObject = this.M;
          ((VelocityTracker)localObject).computeCurrentVelocity(1000, this.O);
          int i3 = (int)((VelocityTracker)localObject).getXVelocity(this.L);
          this.A = true;
          i1 = getClientWidth();
          int i2 = getScrollX();
          localObject = h();
          f2 = this.q;
          f1 = i1;
          f2 /= f1;
          i1 = ((b)localObject).a;
          f2 = (i2 / f1 - ((b)localObject).d) / (((b)localObject).c + f2);
          if ((Math.abs((int)(paramMotionEvent.getX(paramMotionEvent.findPointerIndex(this.L)) - this.J)) > this.P) && (Math.abs(i3) > this.N))
          {
            if (i3 <= 0) {
              i1 += 1;
            }
          }
          else
          {
            if (i1 >= this.c) {
              f1 = 0.4F;
            } else {
              f1 = 0.6F;
            }
            i1 += (int)(f2 + f1);
          }
          i2 = i1;
          if (this.h.size() > 0)
          {
            paramMotionEvent = (b)this.h.get(0);
            localObject = this.h;
            localObject = (b)((ArrayList)localObject).get(((ArrayList)localObject).size() - 1);
            i2 = Math.max(paramMotionEvent.a, Math.min(i1, ((b)localObject).a));
          }
          a(i2, true, true, i3);
          bool = f();
        }
        break;
      case 0: 
        this.n.abortAnimation();
        this.A = false;
        b();
        f1 = paramMotionEvent.getX();
        this.J = f1;
        this.H = f1;
        f1 = paramMotionEvent.getY();
        this.K = f1;
        this.I = f1;
        this.L = paramMotionEvent.getPointerId(0);
      }
      if (bool) {
        ex.a(this);
      }
      return true;
    }
    return false;
  }
  
  public void removeView(View paramView)
  {
    if (this.y)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }
  
  public void setAdapter(ev paramev)
  {
    ev localev = this.b;
    int i3 = 0;
    int i1;
    int i2;
    if (localev != null)
    {
      localev.c(null);
      i1 = 0;
      while (i1 < this.h.size())
      {
        this.h.get(i1);
        ev.b();
        i1 += 1;
      }
      this.h.clear();
      for (i1 = 0; i1 < getChildCount(); i1 = i2 + 1)
      {
        i2 = i1;
        if (!((LayoutParams)getChildAt(i1).getLayoutParams()).a)
        {
          removeViewAt(i1);
          i2 = i1 - 1;
        }
      }
      this.c = 0;
      scrollTo(0, 0);
    }
    localev = this.b;
    this.b = paramev;
    this.e = 0;
    if (this.b != null)
    {
      if (this.p == null) {
        this.p = new g();
      }
      this.b.c(this.p);
      this.A = false;
      boolean bool = this.U;
      this.U = true;
      this.e = this.b.a();
      i1 = this.k;
      if (i1 >= 0)
      {
        a(i1, false, true);
        this.k = -1;
        this.l = null;
        this.m = null;
      }
      else if (!bool)
      {
        b();
      }
      else
      {
        requestLayout();
      }
    }
    List localList = this.d;
    if ((localList != null) && (!localList.isEmpty()))
    {
      i2 = this.d.size();
      i1 = i3;
      while (i1 < i2)
      {
        ((d)this.d.get(i1)).a(localev, paramev);
        i1 += 1;
      }
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.A = false;
    a(paramInt, this.U ^ true, false);
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt <= 0)
    {
      StringBuilder localStringBuilder = new StringBuilder("Requested offscreen page limit ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" too small; defaulting to 1");
      i1 = 1;
    }
    if (i1 != this.B)
    {
      this.B = i1;
      b();
    }
  }
  
  @Deprecated
  public void setOnPageChangeListener(e parame)
  {
    this.ac = parame;
  }
  
  public void setPageMargin(int paramInt)
  {
    int i1 = this.q;
    this.q = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }
  
  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(cs.a(getContext(), paramInt));
  }
  
  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.r = paramDrawable;
    if (paramDrawable != null) {
      refreshDrawableState();
    }
    boolean bool;
    if (paramDrawable == null) {
      bool = true;
    } else {
      bool = false;
    }
    setWillNotDraw(bool);
    invalidate();
  }
  
  void setScrollState(int paramInt)
  {
    if (this.ak == paramInt) {
      return;
    }
    this.ak = paramInt;
    Object localObject = this.ae;
    int i4 = 0;
    int i1;
    int i2;
    if (localObject != null)
    {
      if (paramInt != 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      int i5 = getChildCount();
      i2 = 0;
      while (i2 < i5)
      {
        int i3;
        if (i1 != 0) {
          i3 = this.af;
        } else {
          i3 = 0;
        }
        getChildAt(i2).setLayerType(i3, null);
        i2 += 1;
      }
    }
    localObject = this.ac;
    if (localObject != null) {
      ((e)localObject).a(paramInt);
    }
    localObject = this.ab;
    if (localObject != null)
    {
      i2 = ((List)localObject).size();
      i1 = i4;
      while (i1 < i2)
      {
        localObject = (e)this.ab.get(i1);
        if (localObject != null) {
          ((e)localObject).a(paramInt);
        }
        i1 += 1;
      }
    }
    localObject = this.ad;
    if (localObject != null) {
      ((e)localObject).a(paramInt);
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.r);
  }
  
  public static class LayoutParams
    extends ViewGroup.LayoutParams
  {
    public boolean a;
    public int b;
    float c = 0.0F;
    boolean d;
    int e;
    int f;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, ViewPager.a);
      this.b = paramContext.getInteger(0, 48);
      paramContext.recycle();
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int a;
    Parcelable d;
    ClassLoader e;
    
    SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      ClassLoader localClassLoader = paramClassLoader;
      if (paramClassLoader == null) {
        localClassLoader = getClass().getClassLoader();
      }
      this.a = paramParcel.readInt();
      this.d = paramParcel.readParcelable(localClassLoader);
      this.e = localClassLoader;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("FragmentPager.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" position=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeParcelable(this.d, paramInt);
    }
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface a {}
  
  static final class b
  {
    int a;
    boolean b;
    float c;
    float d;
  }
  
  final class c
    extends ei
  {
    c() {}
    
    private boolean a()
    {
      return (ViewPager.this.b != null) && (ViewPager.this.b.a() > 1);
    }
    
    public final void a(View paramView, ff paramff)
    {
      super.a(paramView, paramff);
      paramff.b(ViewPager.class.getName());
      paramff.i(a());
      if (ViewPager.this.canScrollHorizontally(1)) {
        paramff.a(4096);
      }
      if (ViewPager.this.canScrollHorizontally(-1)) {
        paramff.a(8192);
      }
    }
    
    public final boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.a(paramView, paramInt, paramBundle)) {
        return true;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192) {
          return false;
        }
        if (ViewPager.this.canScrollHorizontally(-1))
        {
          paramView = ViewPager.this;
          paramView.setCurrentItem(paramView.c - 1);
          return true;
        }
        return false;
      }
      if (ViewPager.this.canScrollHorizontally(1))
      {
        paramView = ViewPager.this;
        paramView.setCurrentItem(paramView.c + 1);
        return true;
      }
      return false;
    }
    
    public final void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.d(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(ViewPager.class.getName());
      paramAccessibilityEvent.setScrollable(a());
      if ((paramAccessibilityEvent.getEventType() == 4096) && (ViewPager.this.b != null))
      {
        paramAccessibilityEvent.setItemCount(ViewPager.this.b.a());
        paramAccessibilityEvent.setFromIndex(ViewPager.this.c);
        paramAccessibilityEvent.setToIndex(ViewPager.this.c);
      }
    }
  }
  
  public static abstract interface d
  {
    public abstract void a(ev paramev1, ev paramev2);
  }
  
  public static abstract interface e
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
    
    public abstract void a(int paramInt, float paramFloat);
  }
  
  public static abstract interface f {}
  
  final class g
    extends DataSetObserver
  {
    g() {}
    
    public final void onChanged()
    {
      ViewPager.this.a();
    }
    
    public final void onInvalidated()
    {
      ViewPager.this.a();
    }
  }
  
  static final class h
    implements Comparator<View>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.7.0.1
 */