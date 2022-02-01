package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityRecord;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.OverScroller;
import android.widget.ScrollView;
import com.tencent.token.el;
import com.tencent.token.es;
import com.tencent.token.et;
import com.tencent.token.eu;
import com.tencent.token.ew;
import com.tencent.token.fa;
import com.tencent.token.fi;
import com.tencent.token.fw;
import java.util.ArrayList;
import java.util.List;

public class NestedScrollView
  extends FrameLayout
  implements es, eu
{
  private static final a w = new a();
  private static final int[] x = { 16843130 };
  private float A;
  private b B;
  private long a;
  private final Rect b = new Rect();
  private OverScroller c = new OverScroller(getContext());
  private EdgeEffect d;
  private EdgeEffect e;
  private int f;
  private boolean g = true;
  private boolean h = false;
  private View i = null;
  private boolean j = false;
  private VelocityTracker k;
  private boolean l;
  private boolean m = true;
  private int n;
  private int o;
  private int p;
  private int q = -1;
  private final int[] r = new int[2];
  private final int[] s = new int[2];
  private int t;
  private int u;
  private SavedState v;
  private final ew y;
  private final et z;
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NestedScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFocusable(true);
    setDescendantFocusability(262144);
    setWillNotDraw(false);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    this.n = localViewConfiguration.getScaledTouchSlop();
    this.o = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.p = localViewConfiguration.getScaledMaximumFlingVelocity();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, x, paramInt, 0);
    setFillViewport(paramContext.getBoolean(0, false));
    paramContext.recycle();
    this.y = new ew(this);
    this.z = new et(this);
    setNestedScrollingEnabled(true);
    fa.a(this, w);
  }
  
  private int a(Rect paramRect)
  {
    int i1 = getChildCount();
    int i4 = 0;
    if (i1 == 0) {
      return 0;
    }
    int i5 = getHeight();
    i1 = getScrollY();
    int i3 = i1 + i5;
    int i6 = getVerticalFadingEdgeLength();
    int i2 = i1;
    if (paramRect.top > 0) {
      i2 = i1 + i6;
    }
    i1 = i3;
    if (paramRect.bottom < getChildAt(0).getHeight()) {
      i1 = i3 - i6;
    }
    if ((paramRect.bottom > i1) && (paramRect.top > i2))
    {
      if (paramRect.height() > i5) {
        i2 = paramRect.top - i2 + 0;
      } else {
        i2 = paramRect.bottom - i1 + 0;
      }
      return Math.min(i2, getChildAt(0).getBottom() - i1);
    }
    i3 = i4;
    if (paramRect.top < i2)
    {
      i3 = i4;
      if (paramRect.bottom < i1)
      {
        if (paramRect.height() > i5) {
          i1 = 0 - (i1 - paramRect.bottom);
        } else {
          i1 = 0 - (i2 - paramRect.top);
        }
        i3 = Math.max(i1, -getScrollY());
      }
    }
    return i3;
  }
  
  private View a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = getFocusables(2);
    int i6 = localArrayList.size();
    Object localObject2 = null;
    int i3 = 0;
    int i2;
    for (int i4 = 0; i3 < i6; i4 = i2)
    {
      View localView = (View)localArrayList.get(i3);
      int i5 = localView.getTop();
      int i7 = localView.getBottom();
      Object localObject1 = localObject2;
      i2 = i4;
      if (paramInt1 < i7)
      {
        localObject1 = localObject2;
        i2 = i4;
        if (i5 < paramInt2)
        {
          int i1;
          if ((paramInt1 < i5) && (i7 < paramInt2)) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          if (localObject2 == null)
          {
            localObject1 = localView;
            i2 = i1;
          }
          else
          {
            if (((paramBoolean) && (i5 < localObject2.getTop())) || ((!paramBoolean) && (i7 > localObject2.getBottom()))) {
              i5 = 1;
            } else {
              i5 = 0;
            }
            if (i4 != 0)
            {
              localObject1 = localObject2;
              i2 = i4;
              if (i1 == 0) {
                break label232;
              }
              localObject1 = localObject2;
              i2 = i4;
              if (i5 == 0) {
                break label232;
              }
            }
            else
            {
              if (i1 != 0)
              {
                localObject1 = localView;
                i2 = 1;
                break label232;
              }
              localObject1 = localObject2;
              i2 = i4;
              if (i5 == 0) {
                break label232;
              }
            }
            localObject1 = localView;
            i2 = i4;
          }
        }
      }
      label232:
      i3 += 1;
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (getChildCount() == 0) {
      return;
    }
    if (AnimationUtils.currentAnimationTimeMillis() - this.a > 250L)
    {
      paramInt1 = getHeight();
      int i1 = getPaddingBottom();
      int i2 = getPaddingTop();
      i1 = Math.max(0, getChildAt(0).getHeight() - (paramInt1 - i1 - i2));
      paramInt1 = getScrollY();
      paramInt2 = Math.max(0, Math.min(paramInt2 + paramInt1, i1));
      this.c.startScroll(getScrollX(), paramInt1, 0, paramInt2 - paramInt1);
      fa.a(this);
    }
    else
    {
      if (!this.c.isFinished()) {
        this.c.abortAnimation();
      }
      scrollBy(paramInt1, paramInt2);
    }
    this.a = AnimationUtils.currentAnimationTimeMillis();
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionIndex();
    if (paramMotionEvent.getPointerId(i1) == this.q)
    {
      if (i1 == 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      this.f = ((int)paramMotionEvent.getY(i1));
      this.q = paramMotionEvent.getPointerId(i1);
      paramMotionEvent = this.k;
      if (paramMotionEvent != null) {
        paramMotionEvent.clear();
      }
    }
  }
  
  private boolean a()
  {
    boolean bool = false;
    View localView = getChildAt(0);
    if (localView != null)
    {
      int i1 = localView.getHeight();
      if (getHeight() < i1 + getPaddingTop() + getPaddingBottom()) {
        bool = true;
      }
      return bool;
    }
    return false;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i2 = getHeight();
    int i1 = getScrollY();
    i2 += i1;
    boolean bool2 = false;
    boolean bool1;
    if (paramInt1 == 33) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    View localView = a(bool1, paramInt2, paramInt3);
    Object localObject = localView;
    if (localView == null) {
      localObject = this;
    }
    if ((paramInt2 >= i1) && (paramInt3 <= i2))
    {
      bool1 = bool2;
    }
    else
    {
      if (bool1) {
        paramInt2 -= i1;
      } else {
        paramInt2 = paramInt3 - i2;
      }
      h(paramInt2);
      bool1 = true;
    }
    if (localObject != findFocus()) {
      ((View)localObject).requestFocus(paramInt1);
    }
    return bool1;
  }
  
  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    getOverScrollMode();
    computeHorizontalScrollRange();
    computeHorizontalScrollExtent();
    computeVerticalScrollRange();
    computeVerticalScrollExtent();
    int i1 = paramInt2 + 0;
    paramInt2 = paramInt1 + paramInt3;
    paramInt3 = paramInt4 + 0;
    boolean bool1;
    if (i1 > 0)
    {
      paramInt1 = 0;
      bool1 = true;
    }
    else if (i1 < 0)
    {
      paramInt1 = 0;
      bool1 = true;
    }
    else
    {
      bool1 = false;
      paramInt1 = i1;
    }
    boolean bool2;
    if (paramInt2 > paramInt3)
    {
      bool2 = true;
      paramInt2 = paramInt3;
    }
    else if (paramInt2 < 0)
    {
      bool2 = true;
      paramInt2 = 0;
    }
    else
    {
      bool2 = false;
    }
    if ((bool2) && (!d(1))) {
      this.c.springBack(paramInt1, paramInt2, 0, 0, 0, getScrollRange());
    }
    onOverScrolled(paramInt1, paramInt2, bool1, bool2);
    if (!bool1) {
      return bool2;
    }
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    return this.z.a(0, paramInt1, 0, paramInt2, paramArrayOfInt, paramInt3);
  }
  
  private boolean a(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    return this.z.a(0, paramInt1, paramArrayOfInt1, paramArrayOfInt2, paramInt2);
  }
  
  private boolean a(View paramView)
  {
    return !a(paramView, 0, getHeight());
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    return (this.b.bottom + paramInt1 >= getScrollY()) && (this.b.top - paramInt1 <= getScrollY() + paramInt2);
  }
  
  private static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 == paramView2) {
      return true;
    }
    paramView1 = paramView1.getParent();
    return ((paramView1 instanceof ViewGroup)) && (a((View)paramView1, paramView2));
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt2 < paramInt3) && (paramInt1 >= 0))
    {
      if (paramInt2 + paramInt1 > paramInt3) {
        return paramInt3 - paramInt2;
      }
      return paramInt1;
    }
    return 0;
  }
  
  private void b()
  {
    if (this.k == null) {
      this.k = VelocityTracker.obtain();
    }
  }
  
  private void b(View paramView)
  {
    paramView.getDrawingRect(this.b);
    offsetDescendantRectToMyCoords(paramView, this.b);
    int i1 = a(this.b);
    if (i1 != 0) {
      scrollBy(0, i1);
    }
  }
  
  private boolean b(int paramInt)
  {
    return this.z.a(2, paramInt);
  }
  
  private void c()
  {
    VelocityTracker localVelocityTracker = this.k;
    if (localVelocityTracker != null)
    {
      localVelocityTracker.recycle();
      this.k = null;
    }
  }
  
  private void c(int paramInt)
  {
    this.z.b(paramInt);
  }
  
  private void d()
  {
    this.j = false;
    c();
    c(0);
    EdgeEffect localEdgeEffect = this.d;
    if (localEdgeEffect != null)
    {
      localEdgeEffect.onRelease();
      this.e.onRelease();
    }
  }
  
  private boolean d(int paramInt)
  {
    return this.z.a(paramInt);
  }
  
  private void e()
  {
    if (getOverScrollMode() != 2)
    {
      if (this.d == null)
      {
        Context localContext = getContext();
        this.d = new EdgeEffect(localContext);
        this.e = new EdgeEffect(localContext);
      }
    }
    else
    {
      this.d = null;
      this.e = null;
    }
  }
  
  private boolean e(int paramInt)
  {
    int i1;
    if (paramInt == 130) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = getHeight();
    if (i1 != 0)
    {
      this.b.top = (getScrollY() + i2);
      i1 = getChildCount();
      if (i1 > 0)
      {
        localObject = getChildAt(i1 - 1);
        if (this.b.top + i2 > ((View)localObject).getBottom()) {
          this.b.top = (((View)localObject).getBottom() - i2);
        }
      }
    }
    else
    {
      this.b.top = (getScrollY() - i2);
      if (this.b.top < 0) {
        this.b.top = 0;
      }
    }
    Object localObject = this.b;
    ((Rect)localObject).bottom = (((Rect)localObject).top + i2);
    return a(paramInt, this.b.top, this.b.bottom);
  }
  
  private boolean f(int paramInt)
  {
    int i1;
    if (paramInt == 130) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2 = getHeight();
    Object localObject = this.b;
    ((Rect)localObject).top = 0;
    ((Rect)localObject).bottom = i2;
    if (i1 != 0)
    {
      i1 = getChildCount();
      if (i1 > 0)
      {
        localObject = getChildAt(i1 - 1);
        this.b.bottom = (((View)localObject).getBottom() + getPaddingBottom());
        localObject = this.b;
        ((Rect)localObject).top = (((Rect)localObject).bottom - i2);
      }
    }
    return a(paramInt, this.b.top, this.b.bottom);
  }
  
  private boolean g(int paramInt)
  {
    View localView2 = findFocus();
    View localView1 = localView2;
    if (localView2 == this) {
      localView1 = null;
    }
    localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    int i2 = getMaxScrollAmount();
    if ((localView2 != null) && (a(localView2, i2, getHeight())))
    {
      localView2.getDrawingRect(this.b);
      offsetDescendantRectToMyCoords(localView2, this.b);
      h(a(this.b));
      localView2.requestFocus(paramInt);
    }
    else
    {
      int i1;
      if ((paramInt == 33) && (getScrollY() < i2))
      {
        i1 = getScrollY();
      }
      else
      {
        i1 = i2;
        if (paramInt == 130)
        {
          i1 = i2;
          if (getChildCount() > 0)
          {
            int i3 = getChildAt(0).getBottom() - (getScrollY() + getHeight() - getPaddingBottom());
            i1 = i2;
            if (i3 < i2) {
              i1 = i3;
            }
          }
        }
      }
      if (i1 == 0) {
        return false;
      }
      if (paramInt != 130) {
        i1 = -i1;
      }
      h(i1);
    }
    if ((localView1 != null) && (localView1.isFocused()) && (a(localView1)))
    {
      paramInt = getDescendantFocusability();
      setDescendantFocusability(131072);
      requestFocus();
      setDescendantFocusability(paramInt);
    }
    return true;
  }
  
  private float getVerticalScrollFactorCompat()
  {
    if (this.A == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      Context localContext = getContext();
      if (localContext.getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        this.A = localTypedValue.getDimension(localContext.getResources().getDisplayMetrics());
      } else {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
    }
    return this.A;
  }
  
  private void h(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.m)
      {
        a(0, paramInt);
        return;
      }
      scrollBy(0, paramInt);
    }
  }
  
  private void i(int paramInt)
  {
    if (getChildCount() > 0)
    {
      b(1);
      this.c.fling(getScrollX(), getScrollY(), 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      this.u = getScrollY();
      fa.a(this);
    }
  }
  
  private void j(int paramInt)
  {
    int i1 = getScrollY();
    boolean bool;
    if (((i1 <= 0) && (paramInt <= 0)) || ((i1 >= getScrollRange()) && (paramInt >= 0))) {
      bool = false;
    } else {
      bool = true;
    }
    float f1 = paramInt;
    if (!dispatchNestedPreFling(0.0F, f1))
    {
      dispatchNestedFling(0.0F, f1, bool);
      i(paramInt);
    }
  }
  
  public final void a(int paramInt)
  {
    a(0 - getScrollX(), paramInt - getScrollY());
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    this.b.setEmpty();
    boolean bool = a();
    int i1 = 130;
    if (!bool)
    {
      if ((isFocused()) && (paramKeyEvent.getKeyCode() != 4))
      {
        View localView = findFocus();
        paramKeyEvent = localView;
        if (localView == this) {
          paramKeyEvent = null;
        }
        paramKeyEvent = FocusFinder.getInstance().findNextFocus(this, paramKeyEvent, 130);
        return (paramKeyEvent != null) && (paramKeyEvent != this) && (paramKeyEvent.requestFocus(130));
      }
      return false;
    }
    if (paramKeyEvent.getAction() == 0)
    {
      int i2 = paramKeyEvent.getKeyCode();
      if (i2 != 62)
      {
        switch (i2)
        {
        default: 
          return false;
        case 20: 
          if (!paramKeyEvent.isAltPressed()) {
            return g(130);
          }
          return f(130);
        }
        if (!paramKeyEvent.isAltPressed()) {
          return g(33);
        }
        return f(33);
      }
      if (paramKeyEvent.isShiftPressed()) {
        i1 = 33;
      }
      e(i1);
    }
    return false;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() <= 0)
    {
      super.addView(paramView, paramLayoutParams);
      return;
    }
    throw new IllegalStateException("ScrollView can host only one direct child");
  }
  
  public int computeHorizontalScrollExtent()
  {
    return super.computeHorizontalScrollExtent();
  }
  
  public int computeHorizontalScrollOffset()
  {
    return super.computeHorizontalScrollOffset();
  }
  
  public int computeHorizontalScrollRange()
  {
    return super.computeHorizontalScrollRange();
  }
  
  public void computeScroll()
  {
    boolean bool = this.c.computeScrollOffset();
    int i2 = 0;
    if (bool)
    {
      this.c.getCurrX();
      int i4 = this.c.getCurrY();
      int i3 = i4 - this.u;
      int i1 = i3;
      if (a(i3, this.s, null, 1)) {
        i1 = i3 - this.s[1];
      }
      if (i1 != 0)
      {
        i3 = getScrollRange();
        int i5 = getScrollY();
        a(i1, getScrollX(), i5, i3);
        int i6 = getScrollY() - i5;
        if (!a(i6, i1 - i6, null, 1))
        {
          i6 = getOverScrollMode();
          if (i6 != 0)
          {
            i1 = i2;
            if (i6 == 1)
            {
              i1 = i2;
              if (i3 <= 0) {}
            }
          }
          else
          {
            i1 = 1;
          }
          if (i1 != 0)
          {
            e();
            if ((i4 <= 0) && (i5 > 0)) {
              this.d.onAbsorb((int)this.c.getCurrVelocity());
            } else if ((i4 >= i3) && (i5 < i3)) {
              this.e.onAbsorb((int)this.c.getCurrVelocity());
            }
          }
        }
      }
      this.u = i4;
      fa.a(this);
      return;
    }
    if (d(1)) {
      c(1);
    }
    this.u = 0;
  }
  
  public int computeVerticalScrollExtent()
  {
    return super.computeVerticalScrollExtent();
  }
  
  public int computeVerticalScrollOffset()
  {
    return Math.max(0, super.computeVerticalScrollOffset());
  }
  
  public int computeVerticalScrollRange()
  {
    int i2 = getChildCount();
    int i1 = getHeight() - getPaddingBottom() - getPaddingTop();
    if (i2 == 0) {
      return i1;
    }
    i2 = getChildAt(0).getBottom();
    int i3 = getScrollY();
    int i4 = Math.max(0, i2 - i1);
    if (i3 < 0) {
      return i2 - i3;
    }
    i1 = i2;
    if (i3 > i4) {
      i1 = i2 + (i3 - i4);
    }
    return i1;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (a(paramKeyEvent));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return this.z.a(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return this.z.a(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return this.z.a(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return this.z.a(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.d != null)
    {
      int i8 = getScrollY();
      boolean bool = this.d.isFinished();
      int i5 = 0;
      int i9;
      int i1;
      int i7;
      int i6;
      int i2;
      int i4;
      int i3;
      if (!bool)
      {
        i9 = paramCanvas.save();
        i1 = getWidth();
        i7 = getHeight();
        i6 = Math.min(0, i8);
        if ((Build.VERSION.SDK_INT >= 21) && (!getClipToPadding()))
        {
          i2 = 0;
        }
        else
        {
          i1 -= getPaddingLeft() + getPaddingRight();
          i2 = getPaddingLeft() + 0;
        }
        i4 = i7;
        i3 = i6;
        if (Build.VERSION.SDK_INT >= 21)
        {
          i4 = i7;
          i3 = i6;
          if (getClipToPadding())
          {
            i4 = i7 - (getPaddingTop() + getPaddingBottom());
            i3 = i6 + getPaddingTop();
          }
        }
        paramCanvas.translate(i2, i3);
        this.d.setSize(i1, i4);
        if (this.d.draw(paramCanvas)) {
          fa.a(this);
        }
        paramCanvas.restoreToCount(i9);
      }
      if (!this.e.isFinished())
      {
        i9 = paramCanvas.save();
        i3 = getWidth();
        i6 = getHeight();
        i7 = Math.max(getScrollRange(), i8) + i6;
        if (Build.VERSION.SDK_INT >= 21)
        {
          i2 = i5;
          i1 = i3;
          if (!getClipToPadding()) {}
        }
        else
        {
          i1 = i3 - (getPaddingLeft() + getPaddingRight());
          i2 = 0 + getPaddingLeft();
        }
        i4 = i7;
        i3 = i6;
        if (Build.VERSION.SDK_INT >= 21)
        {
          i4 = i7;
          i3 = i6;
          if (getClipToPadding())
          {
            i3 = i6 - (getPaddingTop() + getPaddingBottom());
            i4 = i7 - getPaddingBottom();
          }
        }
        paramCanvas.translate(i2 - i1, i4);
        paramCanvas.rotate(180.0F, i1, 0.0F);
        this.e.setSize(i1, i3);
        if (this.e.draw(paramCanvas)) {
          fa.a(this);
        }
        paramCanvas.restoreToCount(i9);
      }
    }
  }
  
  protected float getBottomFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getHeight();
    int i3 = getPaddingBottom();
    i2 = getChildAt(0).getBottom() - getScrollY() - (i2 - i3);
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public int getMaxScrollAmount()
  {
    return (int)(getHeight() * 0.5F);
  }
  
  public int getNestedScrollAxes()
  {
    return this.y.a;
  }
  
  int getScrollRange()
  {
    int i2 = getChildCount();
    int i1 = 0;
    if (i2 > 0) {
      i1 = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    }
    return i1;
  }
  
  protected float getTopFadingEdgeStrength()
  {
    if (getChildCount() == 0) {
      return 0.0F;
    }
    int i1 = getVerticalFadingEdgeLength();
    int i2 = getScrollY();
    if (i2 < i1) {
      return i2 / i1;
    }
    return 1.0F;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return this.z.a(0);
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return this.z.a;
  }
  
  protected void measureChild(View paramView, int paramInt1, int paramInt2)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(0, 0));
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin, 0));
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.h = false;
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getSource() & 0x2) != 0)
    {
      if (paramMotionEvent.getAction() != 8) {
        return false;
      }
      if (!this.j)
      {
        float f1 = paramMotionEvent.getAxisValue(9);
        if (f1 != 0.0F)
        {
          int i1 = (int)(f1 * getVerticalScrollFactorCompat());
          int i2 = getScrollRange();
          int i4 = getScrollY();
          int i3 = i4 - i1;
          if (i3 < 0)
          {
            i1 = 0;
          }
          else
          {
            i1 = i3;
            if (i3 > i2) {
              i1 = i2;
            }
          }
          if (i1 != i4)
          {
            super.scrollTo(getScrollX(), i1);
            return true;
          }
        }
      }
    }
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 2) && (this.j)) {
      return true;
    }
    i1 &= 0xFF;
    if (i1 != 6)
    {
      int i2;
      switch (i1)
      {
      default: 
        break;
      case 2: 
        i1 = this.q;
        if (i1 == -1) {
          break;
        }
        i2 = paramMotionEvent.findPointerIndex(i1);
        if (i2 == -1)
        {
          paramMotionEvent = new StringBuilder("Invalid pointerId=");
          paramMotionEvent.append(i1);
          paramMotionEvent.append(" in onInterceptTouchEvent");
        }
        else
        {
          i1 = (int)paramMotionEvent.getY(i2);
          if ((Math.abs(i1 - this.f) > this.n) && ((0x2 & getNestedScrollAxes()) == 0))
          {
            this.j = true;
            this.f = i1;
            b();
            this.k.addMovement(paramMotionEvent);
            this.t = 0;
            paramMotionEvent = getParent();
            if (paramMotionEvent != null) {
              paramMotionEvent.requestDisallowInterceptTouchEvent(true);
            }
          }
        }
        break;
      case 1: 
      case 3: 
        this.j = false;
        this.q = -1;
        c();
        if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
          fa.a(this);
        }
        c(0);
        break;
      case 0: 
        i2 = (int)paramMotionEvent.getY();
        i1 = (int)paramMotionEvent.getX();
        Object localObject;
        if (getChildCount() > 0)
        {
          int i3 = getScrollY();
          localObject = getChildAt(0);
          if ((i2 >= ((View)localObject).getTop() - i3) && (i2 < ((View)localObject).getBottom() - i3) && (i1 >= ((View)localObject).getLeft()) && (i1 < ((View)localObject).getRight())) {
            i1 = 1;
          } else {
            i1 = 0;
          }
        }
        else
        {
          i1 = 0;
        }
        if (i1 == 0)
        {
          this.j = false;
          c();
        }
        else
        {
          this.f = i2;
          this.q = paramMotionEvent.getPointerId(0);
          localObject = this.k;
          if (localObject == null) {
            this.k = VelocityTracker.obtain();
          } else {
            ((VelocityTracker)localObject).clear();
          }
          this.k.addMovement(paramMotionEvent);
          this.c.computeScrollOffset();
          this.j = (this.c.isFinished() ^ true);
          b(0);
        }
        break;
      }
    }
    else
    {
      a(paramMotionEvent);
    }
    return this.j;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.g = false;
    View localView = this.i;
    if ((localView != null) && (a(localView, this))) {
      b(this.i);
    }
    this.i = null;
    if (!this.h)
    {
      if (this.v != null)
      {
        scrollTo(getScrollX(), this.v.a);
        this.v = null;
      }
      if (getChildCount() > 0) {
        paramInt1 = getChildAt(0).getMeasuredHeight();
      } else {
        paramInt1 = 0;
      }
      paramInt1 = Math.max(0, paramInt1 - (paramInt4 - paramInt2 - getPaddingBottom() - getPaddingTop()));
      if (getScrollY() > paramInt1) {
        scrollTo(getScrollX(), paramInt1);
      } else if (getScrollY() < 0) {
        scrollTo(getScrollX(), 0);
      }
    }
    scrollTo(getScrollX(), getScrollY());
    this.h = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (!this.l) {
      return;
    }
    if (View.MeasureSpec.getMode(paramInt2) == 0) {
      return;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt2 = getMeasuredHeight();
      if (localView.getMeasuredHeight() < paramInt2)
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localView.getLayoutParams();
        localView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight(), localLayoutParams.width), View.MeasureSpec.makeMeasureSpec(paramInt2 - getPaddingTop() - getPaddingBottom(), 1073741824));
      }
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      j((int)paramFloat2);
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt, null);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = getScrollY();
    scrollBy(0, paramInt4);
    paramInt1 = getScrollY() - paramInt1;
    dispatchNestedScroll(0, paramInt1, 0, paramInt4 - paramInt1, null);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.y.a = paramInt;
    startNestedScroll(2);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    super.scrollTo(paramInt1, paramInt2);
  }
  
  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1;
    if (paramInt == 2)
    {
      i1 = 130;
    }
    else
    {
      i1 = paramInt;
      if (paramInt == 1) {
        i1 = 33;
      }
    }
    View localView;
    if (paramRect == null) {
      localView = FocusFinder.getInstance().findNextFocus(this, null, i1);
    } else {
      localView = FocusFinder.getInstance().findNextFocusFromRect(this, paramRect, i1);
    }
    if (localView == null) {
      return false;
    }
    if (a(localView)) {
      return false;
    }
    return localView.requestFocus(i1, paramRect);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    this.v = paramParcelable;
    requestLayout();
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.a = getScrollY();
    return localSavedState;
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    b localb = this.B;
    if (localb != null) {
      localb.a(this);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    View localView = findFocus();
    if (localView != null)
    {
      if (this == localView) {
        return;
      }
      if (a(localView, 0, paramInt4))
      {
        localView.getDrawingRect(this.b);
        offsetDescendantRectToMyCoords(localView, this.b);
        h(a(this.b));
      }
      return;
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return (paramInt & 0x2) != 0;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    this.y.a = 0;
    stopNestedScroll();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    b();
    MotionEvent localMotionEvent = MotionEvent.obtain(paramMotionEvent);
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.t = 0;
    }
    localMotionEvent.offsetLocation(0.0F, this.t);
    ViewParent localViewParent;
    switch (i1)
    {
    case 4: 
    default: 
      break;
    case 6: 
      a(paramMotionEvent);
      this.f = ((int)paramMotionEvent.getY(paramMotionEvent.findPointerIndex(this.q)));
      break;
    case 5: 
      i1 = paramMotionEvent.getActionIndex();
      this.f = ((int)paramMotionEvent.getY(i1));
      this.q = paramMotionEvent.getPointerId(i1);
      break;
    case 3: 
      if ((this.j) && (getChildCount() > 0) && (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange()))) {
        fa.a(this);
      }
      this.q = -1;
      d();
      break;
    case 2: 
      int i3 = paramMotionEvent.findPointerIndex(this.q);
      if (i3 == -1)
      {
        paramMotionEvent = new StringBuilder("Invalid pointerId=");
        paramMotionEvent.append(this.q);
        paramMotionEvent.append(" in onTouchEvent");
      }
      else
      {
        int i4 = (int)paramMotionEvent.getY(i3);
        i1 = this.f - i4;
        int i2 = i1;
        if (a(i1, this.s, this.r, 0))
        {
          i2 = i1 - this.s[1];
          localMotionEvent.offsetLocation(0.0F, this.r[1]);
          this.t += this.r[1];
        }
        i1 = i2;
        if (!this.j)
        {
          i1 = i2;
          if (Math.abs(i2) > this.n)
          {
            localViewParent = getParent();
            if (localViewParent != null) {
              localViewParent.requestDisallowInterceptTouchEvent(true);
            }
            this.j = true;
            if (i2 > 0) {
              i1 = i2 - this.n;
            } else {
              i1 = i2 + this.n;
            }
          }
        }
        if (this.j)
        {
          this.f = (i4 - this.r[1]);
          int i5 = getScrollY();
          i4 = getScrollRange();
          i2 = getOverScrollMode();
          if ((i2 != 0) && ((i2 != 1) || (i4 <= 0))) {
            i2 = 0;
          } else {
            i2 = 1;
          }
          if ((a(i1, 0, getScrollY(), i4)) && (!d(0))) {
            this.k.clear();
          }
          int i6 = getScrollY() - i5;
          if (a(i6, i1 - i6, this.r, 0))
          {
            i1 = this.f;
            paramMotionEvent = this.r;
            this.f = (i1 - paramMotionEvent[1]);
            localMotionEvent.offsetLocation(0.0F, paramMotionEvent[1]);
            this.t += this.r[1];
          }
          else if (i2 != 0)
          {
            e();
            i2 = i5 + i1;
            if (i2 < 0)
            {
              fw.a(this.d, i1 / getHeight(), paramMotionEvent.getX(i3) / getWidth());
              if (!this.e.isFinished()) {
                this.e.onRelease();
              }
            }
            else if (i2 > i4)
            {
              fw.a(this.e, i1 / getHeight(), 1.0F - paramMotionEvent.getX(i3) / getWidth());
              if (!this.d.isFinished()) {
                this.d.onRelease();
              }
            }
            paramMotionEvent = this.d;
            if ((paramMotionEvent != null) && ((!paramMotionEvent.isFinished()) || (!this.e.isFinished()))) {
              fa.a(this);
            }
          }
        }
      }
      break;
    case 1: 
      paramMotionEvent = this.k;
      paramMotionEvent.computeCurrentVelocity(1000, this.p);
      i1 = (int)paramMotionEvent.getYVelocity(this.q);
      if (Math.abs(i1) > this.o) {
        j(-i1);
      } else if (this.c.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
        fa.a(this);
      }
      this.q = -1;
      d();
      break;
    case 0: 
      if (getChildCount() == 0) {
        return false;
      }
      boolean bool = this.c.isFinished() ^ true;
      this.j = bool;
      if (bool)
      {
        localViewParent = getParent();
        if (localViewParent != null) {
          localViewParent.requestDisallowInterceptTouchEvent(true);
        }
      }
      if (!this.c.isFinished()) {
        this.c.abortAnimation();
      }
      this.f = ((int)paramMotionEvent.getY());
      this.q = paramMotionEvent.getPointerId(0);
      b(0);
    }
    paramMotionEvent = this.k;
    if (paramMotionEvent != null) {
      paramMotionEvent.addMovement(localMotionEvent);
    }
    localMotionEvent.recycle();
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    if (!this.g) {
      b(paramView2);
    } else {
      this.i = paramView2;
    }
    super.requestChildFocus(paramView1, paramView2);
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramRect.offset(paramView.getLeft() - paramView.getScrollX(), paramView.getTop() - paramView.getScrollY());
    int i1 = a(paramRect);
    boolean bool;
    if (i1 != 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      if (paramBoolean)
      {
        scrollBy(0, i1);
        return bool;
      }
      a(0, i1);
    }
    return bool;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    this.g = true;
    super.requestLayout();
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      paramInt1 = b(paramInt1, getWidth() - getPaddingRight() - getPaddingLeft(), localView.getWidth());
      paramInt2 = b(paramInt2, getHeight() - getPaddingBottom() - getPaddingTop(), localView.getHeight());
      if ((paramInt1 != getScrollX()) || (paramInt2 != getScrollY())) {
        super.scrollTo(paramInt1, paramInt2);
      }
    }
  }
  
  public void setFillViewport(boolean paramBoolean)
  {
    if (paramBoolean != this.l)
    {
      this.l = paramBoolean;
      requestLayout();
    }
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    this.z.a(paramBoolean);
  }
  
  public void setOnScrollChangeListener(b paramb)
  {
    this.B = paramb;
  }
  
  public void setSmoothScrollingEnabled(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return true;
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return this.z.a(paramInt, 0);
  }
  
  public void stopNestedScroll()
  {
    this.z.b(0);
  }
  
  static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    public int a;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.a = paramParcel.readInt();
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("HorizontalScrollView.SavedState{");
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append(" scrollPosition=");
      localStringBuilder.append(this.a);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
    }
  }
  
  static final class a
    extends el
  {
    public final void a(View paramView, fi paramfi)
    {
      super.a(paramView, paramfi);
      paramView = (NestedScrollView)paramView;
      paramfi.b(ScrollView.class.getName());
      if (paramView.isEnabled())
      {
        int i = paramView.getScrollRange();
        if (i > 0)
        {
          paramfi.i(true);
          if (paramView.getScrollY() > 0) {
            paramfi.a(8192);
          }
          if (paramView.getScrollY() < i) {
            paramfi.a(4096);
          }
        }
      }
    }
    
    public final boolean a(View paramView, int paramInt, Bundle paramBundle)
    {
      if (super.a(paramView, paramInt, paramBundle)) {
        return true;
      }
      paramView = (NestedScrollView)paramView;
      if (!paramView.isEnabled()) {
        return false;
      }
      if (paramInt != 4096)
      {
        if (paramInt != 8192) {
          return false;
        }
        paramInt = paramView.getHeight();
        i = paramView.getPaddingBottom();
        j = paramView.getPaddingTop();
        paramInt = Math.max(paramView.getScrollY() - (paramInt - i - j), 0);
        if (paramInt != paramView.getScrollY())
        {
          paramView.a(paramInt);
          return true;
        }
        return false;
      }
      paramInt = paramView.getHeight();
      int i = paramView.getPaddingBottom();
      int j = paramView.getPaddingTop();
      paramInt = Math.min(paramView.getScrollY() + (paramInt - i - j), paramView.getScrollRange());
      if (paramInt != paramView.getScrollY())
      {
        paramView.a(paramInt);
        return true;
      }
      return false;
    }
    
    public final void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.d(paramView, paramAccessibilityEvent);
      paramView = (NestedScrollView)paramView;
      paramAccessibilityEvent.setClassName(ScrollView.class.getName());
      boolean bool;
      if (paramView.getScrollRange() > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramAccessibilityEvent.setScrollable(bool);
      paramAccessibilityEvent.setScrollX(paramView.getScrollX());
      paramAccessibilityEvent.setScrollY(paramView.getScrollY());
      int i = paramView.getScrollX();
      if (Build.VERSION.SDK_INT >= 15) {
        paramAccessibilityEvent.setMaxScrollX(i);
      }
      i = paramView.getScrollRange();
      if (Build.VERSION.SDK_INT >= 15) {
        paramAccessibilityEvent.setMaxScrollY(i);
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(NestedScrollView paramNestedScrollView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.NestedScrollView
 * JD-Core Version:    0.7.0.1
 */