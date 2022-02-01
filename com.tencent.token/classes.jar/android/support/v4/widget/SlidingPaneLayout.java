package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.token.dj;
import com.tencent.token.ez;
import com.tencent.token.fo;
import com.tencent.token.fw;
import com.tencent.token.gs;
import com.tencent.token.gs.a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  static final e j = new f();
  int a = -858993460;
  View b;
  float c;
  int d;
  boolean e;
  int f;
  final gs g;
  boolean h;
  final ArrayList<b> i = new ArrayList();
  private int k;
  private Drawable l;
  private Drawable m;
  private final int n;
  private boolean o;
  private float p;
  private float q;
  private float r;
  private d s;
  private boolean t = true;
  private final Rect u = new Rect();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      j = new h();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      j = new g();
      return;
    }
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.n = ((int)(32.0F * f1 + 0.5F));
    setWillNotDraw(false);
    fo.a(this, new a());
    fo.a(this, 1);
    this.g = gs.a(this, 0.5F, new c());
    this.g.g = (f1 * 400.0F);
  }
  
  private boolean b(float paramFloat)
  {
    if (!this.o) {
      return false;
    }
    boolean bool = b();
    Object localObject = (LayoutParams)this.b.getLayoutParams();
    int i1;
    if (bool)
    {
      i1 = getPaddingRight();
      int i2 = ((LayoutParams)localObject).rightMargin;
      int i3 = this.b.getWidth();
      i1 = (int)(getWidth() - (i1 + i2 + paramFloat * this.d + i3));
    }
    else
    {
      i1 = (int)(getPaddingLeft() + ((LayoutParams)localObject).leftMargin + paramFloat * this.d);
    }
    localObject = this.g;
    View localView = this.b;
    if (((gs)localObject).a(localView, i1, localView.getTop()))
    {
      a();
      fo.a(this);
      return true;
    }
    return false;
  }
  
  private boolean c()
  {
    if ((!this.t) && (!b(0.0F))) {
      return false;
    }
    this.h = false;
    return true;
  }
  
  final void a()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i1 += 1;
    }
  }
  
  final void a(float paramFloat)
  {
    boolean bool1 = b();
    Object localObject = (LayoutParams)this.b.getLayoutParams();
    boolean bool2 = ((LayoutParams)localObject).c;
    int i2 = 0;
    if (bool2)
    {
      if (bool1) {
        i1 = ((LayoutParams)localObject).rightMargin;
      } else {
        i1 = ((LayoutParams)localObject).leftMargin;
      }
      if (i1 <= 0)
      {
        i1 = 1;
        break label64;
      }
    }
    int i1 = 0;
    label64:
    int i5 = getChildCount();
    while (i2 < i5)
    {
      localObject = getChildAt(i2);
      if (localObject != this.b)
      {
        float f1 = this.p;
        int i3 = this.f;
        int i4 = (int)((1.0F - f1) * i3);
        this.p = paramFloat;
        i4 -= (int)((1.0F - paramFloat) * i3);
        i3 = i4;
        if (bool1) {
          i3 = -i4;
        }
        ((View)localObject).offsetLeftAndRight(i3);
        if (i1 != 0)
        {
          if (bool1) {
            f1 = this.p - 1.0F;
          } else {
            f1 = 1.0F - this.p;
          }
          a((View)localObject, f1, this.k);
        }
      }
      i2 += 1;
    }
  }
  
  final void a(View paramView)
  {
    boolean bool1 = b();
    int i1;
    if (bool1) {
      i1 = getWidth() - getPaddingRight();
    } else {
      i1 = getPaddingLeft();
    }
    int i2;
    if (bool1) {
      i2 = getPaddingLeft();
    } else {
      i2 = getWidth() - getPaddingRight();
    }
    int i9 = getPaddingTop();
    int i10 = getHeight();
    int i11 = getPaddingBottom();
    Object localObject;
    if (paramView != null)
    {
      boolean bool2 = paramView.isOpaque();
      i3 = 1;
      if (!bool2)
      {
        if (Build.VERSION.SDK_INT < 18)
        {
          localObject = paramView.getBackground();
          if (localObject != null)
          {
            if (((Drawable)localObject).getOpacity() == -1) {
              break label131;
            }
            i3 = 0;
            break label131;
          }
        }
        i3 = 0;
      }
      label131:
      if (i3 != 0)
      {
        i3 = paramView.getLeft();
        i4 = paramView.getRight();
        i5 = paramView.getTop();
        i6 = paramView.getBottom();
        break label175;
      }
    }
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i6 = 0;
    label175:
    int i12 = getChildCount();
    int i7 = 0;
    while (i7 < i12)
    {
      localObject = getChildAt(i7);
      if (localObject == paramView) {
        break;
      }
      if (((View)localObject).getVisibility() != 8)
      {
        if (bool1) {
          i8 = i2;
        } else {
          i8 = i1;
        }
        int i13 = Math.max(i8, ((View)localObject).getLeft());
        int i14 = Math.max(i9, ((View)localObject).getTop());
        if (bool1) {
          i8 = i1;
        } else {
          i8 = i2;
        }
        int i8 = Math.min(i8, ((View)localObject).getRight());
        int i15 = Math.min(i10 - i11, ((View)localObject).getBottom());
        if ((i13 >= i3) && (i14 >= i5) && (i8 <= i4) && (i15 <= i6)) {
          i8 = 4;
        } else {
          i8 = 0;
        }
        ((View)localObject).setVisibility(i8);
      }
      i7 += 1;
    }
  }
  
  final void a(View paramView, float paramFloat, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      int i1 = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.d == null) {
        localLayoutParams.d = new Paint();
      }
      localLayoutParams.d.setColorFilter(new PorterDuffColorFilter(i1 << 24 | paramInt & 0xFFFFFF, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.d);
      }
      b(paramView);
      return;
    }
    if (paramView.getLayerType() != 0)
    {
      if (localLayoutParams.d != null) {
        localLayoutParams.d.setColorFilter(null);
      }
      paramView = new b(paramView);
      this.i.add(paramView);
      fo.a(this, paramView);
    }
  }
  
  final void b(View paramView)
  {
    j.a(this, paramView);
  }
  
  final boolean b()
  {
    return fo.c(this) == 1;
  }
  
  final boolean c(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (LayoutParams)paramView.getLayoutParams();
    return (this.o) && (paramView.c) && (this.c > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    if (this.g.c())
    {
      if (!this.o)
      {
        this.g.b();
        return;
      }
      fo.a(this);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (b()) {
      localDrawable = this.m;
    } else {
      localDrawable = this.l;
    }
    View localView;
    if (getChildCount() > 1) {
      localView = getChildAt(1);
    } else {
      localView = null;
    }
    if (localView != null)
    {
      if (localDrawable == null) {
        return;
      }
      int i4 = localView.getTop();
      int i5 = localView.getBottom();
      int i3 = localDrawable.getIntrinsicWidth();
      int i1;
      int i2;
      if (b())
      {
        i1 = localView.getRight();
        i2 = i3 + i1;
      }
      else
      {
        i2 = localView.getLeft();
        i1 = i2;
        i3 = i2 - i3;
        i2 = i1;
        i1 = i3;
      }
      localDrawable.setBounds(i1, i4, i2, i5);
      localDrawable.draw(paramCanvas);
      return;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Object localObject = (LayoutParams)paramView.getLayoutParams();
    int i1 = paramCanvas.save();
    if ((this.o) && (!((LayoutParams)localObject).b) && (this.b != null))
    {
      paramCanvas.getClipBounds(this.u);
      if (b())
      {
        localObject = this.u;
        ((Rect)localObject).left = Math.max(((Rect)localObject).left, this.b.getRight());
      }
      else
      {
        localObject = this.u;
        ((Rect)localObject).right = Math.min(((Rect)localObject).right, this.b.getLeft());
      }
      paramCanvas.clipRect(this.u);
    }
    boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i1);
    return bool;
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
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getCoveredFadeColor()
  {
    return this.k;
  }
  
  public int getParallaxDistance()
  {
    return this.f;
  }
  
  public int getSliderFadeColor()
  {
    return this.a;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.t = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.t = true;
    int i2 = this.i.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((b)this.i.get(i1)).run();
      i1 += 1;
    }
    this.i.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if ((!this.o) && (i1 == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        this.h = (gs.b(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()) ^ true);
      }
    }
    if ((this.o) && ((!this.e) || (i1 == 0)))
    {
      if ((i1 != 3) && (i1 != 1))
      {
        float f2;
        float f1;
        if (i1 != 0)
        {
          if (i1 == 2)
          {
            f2 = paramMotionEvent.getX();
            f1 = paramMotionEvent.getY();
            f2 = Math.abs(f2 - this.q);
            f1 = Math.abs(f1 - this.r);
            if ((f2 > this.g.b) && (f1 > f2))
            {
              this.g.a();
              this.e = true;
              return false;
            }
          }
        }
        else
        {
          this.e = false;
          f1 = paramMotionEvent.getX();
          f2 = paramMotionEvent.getY();
          this.q = f1;
          this.r = f2;
          if ((gs.b(this.b, (int)f1, (int)f2)) && (c(this.b)))
          {
            i1 = 1;
            break label232;
          }
        }
        i1 = 0;
        label232:
        if (!this.g.a(paramMotionEvent)) {
          return i1 != 0;
        }
        return true;
      }
      this.g.a();
      return false;
    }
    this.g.a();
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = b();
    if (bool) {
      this.g.i = 2;
    } else {
      this.g.i = 1;
    }
    int i3 = paramInt3 - paramInt1;
    if (bool) {
      paramInt1 = getPaddingRight();
    } else {
      paramInt1 = getPaddingLeft();
    }
    if (bool) {
      paramInt3 = getPaddingLeft();
    } else {
      paramInt3 = getPaddingRight();
    }
    int i5 = getPaddingTop();
    int i4 = getChildCount();
    if (this.t)
    {
      float f1;
      if ((this.o) && (this.h)) {
        f1 = 1.0F;
      } else {
        f1 = 0.0F;
      }
      this.c = f1;
    }
    paramInt2 = paramInt1;
    paramInt4 = 0;
    while (paramInt4 < i4)
    {
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i6 = localView.getMeasuredWidth();
        int i1;
        int i2;
        if (localLayoutParams.b)
        {
          i1 = localLayoutParams.leftMargin;
          int i7 = localLayoutParams.rightMargin;
          i2 = i3 - paramInt3;
          i7 = Math.min(paramInt1, i2 - this.n) - paramInt2 - (i1 + i7);
          this.d = i7;
          if (bool) {
            i1 = localLayoutParams.rightMargin;
          } else {
            i1 = localLayoutParams.leftMargin;
          }
          if (paramInt2 + i1 + i7 + i6 / 2 > i2) {
            paramBoolean = true;
          } else {
            paramBoolean = false;
          }
          localLayoutParams.c = paramBoolean;
          i2 = (int)(i7 * this.c);
          paramInt2 = i1 + i2 + paramInt2;
          this.c = (i2 / this.d);
          i2 = 0;
        }
        else
        {
          if (this.o)
          {
            paramInt2 = this.f;
            if (paramInt2 != 0)
            {
              paramInt2 = (int)((1.0F - this.c) * paramInt2);
              break label347;
            }
          }
          paramInt2 = 0;
          label347:
          i1 = paramInt1;
          i2 = paramInt2;
          paramInt2 = i1;
        }
        if (bool)
        {
          i2 = i3 - paramInt2 + i2;
          i1 = i2 - i6;
        }
        else
        {
          i1 = paramInt2 - i2;
          i2 = i1 + i6;
        }
        localView.layout(i1, i5, i2, localView.getMeasuredHeight() + i5);
        paramInt1 += localView.getWidth();
      }
      paramInt4 += 1;
    }
    if (this.t)
    {
      if (this.o)
      {
        if (this.f != 0) {
          a(this.c);
        }
        if (((LayoutParams)this.b.getLayoutParams()).c) {
          a(this.b, this.c, this.a);
        }
      }
      else
      {
        paramInt1 = 0;
        while (paramInt1 < i4)
        {
          a(getChildAt(paramInt1), 0.0F, this.a);
          paramInt1 += 1;
        }
      }
      a(this.b);
    }
    this.t = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i4 = View.MeasureSpec.getMode(paramInt1);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i3;
    int i5;
    if (i4 != 1073741824)
    {
      if (isInEditMode())
      {
        i3 = i1;
        i5 = i2;
        paramInt1 = paramInt2;
        if (i4 != -2147483648)
        {
          i3 = i1;
          i5 = i2;
          paramInt1 = paramInt2;
          if (i4 == 0)
          {
            i3 = 300;
            i5 = i2;
            paramInt1 = paramInt2;
          }
        }
      }
      else
      {
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
      }
    }
    else
    {
      i3 = i1;
      i5 = i2;
      paramInt1 = paramInt2;
      if (i2 == 0) {
        if (isInEditMode())
        {
          i3 = i1;
          i5 = i2;
          paramInt1 = paramInt2;
          if (i2 == 0)
          {
            i5 = -2147483648;
            paramInt1 = 300;
            i3 = i1;
          }
        }
        else
        {
          throw new IllegalStateException("Height must not be UNSPECIFIED");
        }
      }
    }
    if (i5 != -2147483648)
    {
      if (i5 != 1073741824)
      {
        paramInt1 = 0;
        paramInt2 = 0;
      }
      else
      {
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt2 = paramInt1;
      }
    }
    else
    {
      paramInt2 = paramInt1 - getPaddingTop() - getPaddingBottom();
      paramInt1 = 0;
    }
    int i7 = i3 - getPaddingLeft() - getPaddingRight();
    int i8 = getChildCount();
    this.b = null;
    i4 = i7;
    int i6 = 0;
    boolean bool1 = false;
    float f1 = 0.0F;
    i1 = paramInt1;
    View localView;
    LayoutParams localLayoutParams;
    int i9;
    while (i6 < i8)
    {
      localView = getChildAt(i6);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool2;
      if (localView.getVisibility() == 8)
      {
        localLayoutParams.c = false;
        bool2 = bool1;
        paramInt1 = i1;
        i2 = i4;
      }
      else
      {
        float f2 = f1;
        if (localLayoutParams.a > 0.0F)
        {
          f2 = f1 + localLayoutParams.a;
          bool2 = bool1;
          f1 = f2;
          paramInt1 = i1;
          i2 = i4;
          if (localLayoutParams.width == 0) {}
        }
        else
        {
          paramInt1 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
          if (localLayoutParams.width == -2) {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(i7 - paramInt1, -2147483648);
          } else if (localLayoutParams.width == -1) {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(i7 - paramInt1, 1073741824);
          } else {
            paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          }
          if (localLayoutParams.height == -2) {
            i2 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
          } else if (localLayoutParams.height == -1) {
            i2 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
          } else {
            i2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
          }
          localView.measure(paramInt1, i2);
          i2 = localView.getMeasuredWidth();
          i9 = localView.getMeasuredHeight();
          paramInt1 = i1;
          if (i5 == -2147483648)
          {
            paramInt1 = i1;
            if (i9 > i1) {
              paramInt1 = Math.min(i9, paramInt2);
            }
          }
          i2 = i4 - i2;
          if (i2 < 0) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          localLayoutParams.b = bool2;
          if (localLayoutParams.b) {
            this.b = localView;
          }
          bool2 |= bool1;
          f1 = f2;
        }
      }
      i6 += 1;
      bool1 = bool2;
      i1 = paramInt1;
      i4 = i2;
    }
    if ((bool1) || (f1 > 0.0F))
    {
      i2 = i7 - this.n;
      i5 = 0;
      while (i5 < i8)
      {
        localView = getChildAt(i5);
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() != 8)
          {
            if ((localLayoutParams.width == 0) && (localLayoutParams.a > 0.0F)) {
              paramInt1 = 1;
            } else {
              paramInt1 = 0;
            }
            if (paramInt1 != 0) {
              i6 = 0;
            } else {
              i6 = localView.getMeasuredWidth();
            }
            if ((bool1) && (localView != this.b))
            {
              if ((localLayoutParams.width < 0) && ((i6 > i2) || (localLayoutParams.a > 0.0F)))
              {
                if (paramInt1 != 0)
                {
                  if (localLayoutParams.height == -2) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                  } else if (localLayoutParams.height == -1) {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                  } else {
                    paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                  }
                }
                else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                }
                localView.measure(View.MeasureSpec.makeMeasureSpec(i2, 1073741824), paramInt1);
              }
            }
            else if (localLayoutParams.a > 0.0F)
            {
              if (localLayoutParams.width == 0)
              {
                if (localLayoutParams.height == -2) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, -2147483648);
                } else if (localLayoutParams.height == -1) {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824);
                } else {
                  paramInt1 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                }
              }
              else {
                paramInt1 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
              }
              if (bool1)
              {
                i9 = i7 - (localLayoutParams.leftMargin + localLayoutParams.rightMargin);
                int i10 = View.MeasureSpec.makeMeasureSpec(i9, 1073741824);
                if (i6 != i9) {
                  localView.measure(i10, paramInt1);
                }
              }
              else
              {
                i9 = Math.max(0, i4);
                localView.measure(View.MeasureSpec.makeMeasureSpec(i6 + (int)(localLayoutParams.a * i9 / f1), 1073741824), paramInt1);
              }
            }
          }
          else {}
        }
        i5 += 1;
      }
    }
    setMeasuredDimension(i3, i1 + getPaddingTop() + getPaddingBottom());
    this.o = bool1;
    if ((this.g.a != 0) && (!bool1)) {
      this.g.b();
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.c);
    if (paramParcelable.a)
    {
      if ((this.t) || (b(1.0F))) {
        this.h = true;
      }
    }
    else {
      c();
    }
    this.h = paramParcelable.a;
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    boolean bool = this.o;
    if (bool)
    {
      if ((bool) && (this.c != 1.0F)) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = this.h;
    }
    localSavedState.a = bool;
    return localSavedState;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.t = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.o) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.g.b(paramMotionEvent);
    float f1;
    float f2;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      break;
    case 1: 
      if (c(this.b))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.q;
        float f4 = f2 - this.r;
        int i1 = this.g.b;
        if ((f3 * f3 + f4 * f4 < i1 * i1) && (gs.b(this.b, (int)f1, (int)f2))) {
          c();
        }
      }
      break;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.q = f1;
      this.r = f2;
    }
    return true;
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.o))
    {
      boolean bool;
      if (paramView1 == this.b) {
        bool = true;
      } else {
        bool = false;
      }
      this.h = bool;
    }
  }
  
  public void setCoveredFadeColor(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void setPanelSlideListener(d paramd)
  {
    this.s = paramd;
  }
  
  public void setParallaxDistance(int paramInt)
  {
    this.f = paramInt;
    requestLayout();
  }
  
  @Deprecated
  public void setShadowDrawable(Drawable paramDrawable)
  {
    setShadowDrawableLeft(paramDrawable);
  }
  
  public void setShadowDrawableLeft(Drawable paramDrawable)
  {
    this.l = paramDrawable;
  }
  
  public void setShadowDrawableRight(Drawable paramDrawable)
  {
    this.m = paramDrawable;
  }
  
  @Deprecated
  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }
  
  public void setShadowResourceLeft(int paramInt)
  {
    setShadowDrawableLeft(dj.a(getContext(), paramInt));
  }
  
  public void setShadowResourceRight(int paramInt)
  {
    setShadowDrawableRight(dj.a(getContext(), paramInt));
  }
  
  public void setSliderFadeColor(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    private static final int[] e = { 16843137 };
    public float a = 0.0F;
    boolean b;
    boolean c;
    Paint d;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, e);
      this.a = paramContext.getFloat(0, 0.0F);
      paramContext.recycle();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    boolean a;
    
    SavedState(Parcel paramParcel)
    {
      super(null);
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.a = bool;
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  final class a
    extends ez
  {
    private final Rect c = new Rect();
    
    a() {}
    
    private boolean b(View paramView)
    {
      return SlidingPaneLayout.this.c(paramView);
    }
    
    public final void a(View paramView, fw paramfw)
    {
      fw localfw = fw.a(paramfw);
      super.a(paramView, localfw);
      Rect localRect = this.c;
      localfw.a(localRect);
      paramfw.b(localRect);
      localfw.c(localRect);
      paramfw.d(localRect);
      paramfw.c(localfw.a());
      paramfw.a(localfw.a.getPackageName());
      paramfw.b(localfw.a.getClassName());
      paramfw.c(localfw.a.getContentDescription());
      paramfw.h(localfw.a.isEnabled());
      paramfw.f(localfw.a.isClickable());
      paramfw.a(localfw.a.isFocusable());
      paramfw.b(localfw.a.isFocused());
      paramfw.d(localfw.b());
      paramfw.e(localfw.a.isSelected());
      paramfw.g(localfw.a.isLongClickable());
      paramfw.a(localfw.a.getActions());
      int i = Build.VERSION.SDK_INT;
      int j = 0;
      if (i >= 16) {
        i = localfw.a.getMovementGranularities();
      } else {
        i = 0;
      }
      if (Build.VERSION.SDK_INT >= 16) {
        paramfw.a.setMovementGranularities(i);
      }
      localfw.a.recycle();
      paramfw.b(SlidingPaneLayout.class.getName());
      paramfw.a(paramView);
      paramView = fo.d(paramView);
      if ((paramView instanceof View)) {
        paramfw.c((View)paramView);
      }
      int k = SlidingPaneLayout.this.getChildCount();
      i = j;
      while (i < k)
      {
        paramView = SlidingPaneLayout.this.getChildAt(i);
        if ((!b(paramView)) && (paramView.getVisibility() == 0))
        {
          fo.a(paramView, 1);
          paramfw.b(paramView);
        }
        i += 1;
      }
    }
    
    public final boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (!b(paramView)) {
        return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
      }
      return false;
    }
    
    public final void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.d(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(SlidingPaneLayout.class.getName());
    }
  }
  
  final class b
    implements Runnable
  {
    final View a;
    
    b(View paramView)
    {
      this.a = paramView;
    }
    
    public final void run()
    {
      if (this.a.getParent() == SlidingPaneLayout.this)
      {
        this.a.setLayerType(0, null);
        SlidingPaneLayout.this.b(this.a);
      }
      SlidingPaneLayout.this.i.remove(this);
    }
  }
  
  final class c
    extends gs.a
  {
    c() {}
    
    public final void a(int paramInt)
    {
      if (SlidingPaneLayout.this.g.a == 0)
      {
        if (SlidingPaneLayout.this.c == 0.0F)
        {
          SlidingPaneLayout localSlidingPaneLayout = SlidingPaneLayout.this;
          localSlidingPaneLayout.a(localSlidingPaneLayout.b);
          SlidingPaneLayout.this.sendAccessibilityEvent(32);
          SlidingPaneLayout.this.h = false;
          return;
        }
        SlidingPaneLayout.this.sendAccessibilityEvent(32);
        SlidingPaneLayout.this.h = true;
      }
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      SlidingPaneLayout.this.g.a(SlidingPaneLayout.this.b, paramInt2);
    }
    
    public final void a(View paramView, float paramFloat)
    {
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
      int j;
      int i;
      if (SlidingPaneLayout.this.b())
      {
        j = SlidingPaneLayout.this.getPaddingRight() + localLayoutParams.rightMargin;
        if (paramFloat >= 0.0F)
        {
          i = j;
          if (paramFloat == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.c <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.d;
        }
        j = SlidingPaneLayout.this.b.getWidth();
        i = SlidingPaneLayout.this.getWidth() - i - j;
      }
      else
      {
        i = SlidingPaneLayout.this.getPaddingLeft();
        j = localLayoutParams.leftMargin + i;
        if (paramFloat <= 0.0F)
        {
          i = j;
          if (paramFloat == 0.0F)
          {
            i = j;
            if (SlidingPaneLayout.this.c <= 0.5F) {}
          }
        }
        else
        {
          i = j + SlidingPaneLayout.this.d;
        }
      }
      SlidingPaneLayout.this.g.a(i, paramView.getTop());
      SlidingPaneLayout.this.invalidate();
    }
    
    public final void a(View paramView, int paramInt)
    {
      paramView = SlidingPaneLayout.this;
      if (paramView.b == null)
      {
        paramView.c = 0.0F;
      }
      else
      {
        boolean bool = paramView.b();
        SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.b.getLayoutParams();
        int j = paramView.b.getWidth();
        int i = paramInt;
        if (bool) {
          i = paramView.getWidth() - paramInt - j;
        }
        if (bool) {
          paramInt = paramView.getPaddingRight();
        } else {
          paramInt = paramView.getPaddingLeft();
        }
        if (bool) {
          j = localLayoutParams.rightMargin;
        } else {
          j = localLayoutParams.leftMargin;
        }
        paramView.c = ((i - (paramInt + j)) / paramView.d);
        if (paramView.f != 0) {
          paramView.a(paramView.c);
        }
        if (localLayoutParams.c) {
          paramView.a(paramView.b, paramView.c, paramView.a);
        }
      }
      SlidingPaneLayout.this.invalidate();
    }
    
    public final boolean a(View paramView)
    {
      if (SlidingPaneLayout.this.e) {
        return false;
      }
      return ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).b;
    }
    
    public final int b(View paramView, int paramInt)
    {
      paramView = (SlidingPaneLayout.LayoutParams)SlidingPaneLayout.this.b.getLayoutParams();
      if (SlidingPaneLayout.this.b())
      {
        i = SlidingPaneLayout.this.getWidth() - (SlidingPaneLayout.this.getPaddingRight() + paramView.rightMargin + SlidingPaneLayout.this.b.getWidth());
        j = SlidingPaneLayout.this.d;
        return Math.max(Math.min(paramInt, i), i - j);
      }
      int i = SlidingPaneLayout.this.getPaddingLeft() + paramView.leftMargin;
      int j = SlidingPaneLayout.this.d;
      return Math.min(Math.max(paramInt, i), j + i);
    }
    
    public final void b(View paramView)
    {
      SlidingPaneLayout.this.a();
    }
    
    public final int c(View paramView)
    {
      return SlidingPaneLayout.this.d;
    }
    
    public final int d(View paramView)
    {
      return paramView.getTop();
    }
  }
  
  public static abstract interface d {}
  
  static abstract interface e
  {
    public abstract void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView);
  }
  
  static class f
    implements SlidingPaneLayout.e
  {
    public void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      fo.a(paramSlidingPaneLayout, paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    }
  }
  
  static final class g
    extends SlidingPaneLayout.f
  {
    private Method a;
    private Field b;
    
    g()
    {
      try
      {
        this.a = View.class.getDeclaredMethod("getDisplayList", null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        for (;;)
        {
          try
          {
            this.b = View.class.getDeclaredField("mRecreateDisplayList");
            this.b.setAccessible(true);
            return;
          }
          catch (NoSuchFieldException localNoSuchFieldException) {}
          localNoSuchMethodException = localNoSuchMethodException;
        }
      }
    }
    
    public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      Field localField;
      if (this.a != null)
      {
        localField = this.b;
        if (localField == null) {}
      }
      try
      {
        localField.setBoolean(paramView, true);
        this.a.invoke(paramView, null);
        label32:
        super.a(paramSlidingPaneLayout, paramView);
        return;
        paramView.invalidate();
        return;
      }
      catch (Exception localException)
      {
        break label32;
      }
    }
  }
  
  static final class h
    extends SlidingPaneLayout.f
  {
    public final void a(SlidingPaneLayout paramSlidingPaneLayout, View paramView)
    {
      fo.a(paramView, ((SlidingPaneLayout.LayoutParams)paramView.getLayoutParams()).d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */