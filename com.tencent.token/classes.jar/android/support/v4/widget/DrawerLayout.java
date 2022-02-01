package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.view.AbsSavedState;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.token.cr;
import com.tencent.token.dg;
import com.tencent.token.eh;
import com.tencent.token.ej;
import com.tencent.token.ew;
import com.tencent.token.fe;
import com.tencent.token.fe.a;
import com.tencent.token.ga;
import com.tencent.token.ga.a;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  static final int[] a;
  static final boolean b;
  private static final int[] l;
  private static final boolean m;
  private int A = 3;
  private boolean B;
  private c C;
  private float D;
  private float E;
  private Drawable F;
  private Drawable G;
  private Drawable H;
  private Drawable I = null;
  private Drawable J = null;
  private Drawable K = null;
  private Drawable L = null;
  private final ArrayList<View> M;
  final ga c;
  final ga d;
  int e;
  boolean f;
  List<c> g;
  CharSequence h;
  CharSequence i;
  Object j;
  boolean k;
  private final b n = new b();
  private float o;
  private int p;
  private int q = -1728053248;
  private float r;
  private Paint s = new Paint();
  private final d t;
  private final d u;
  private boolean v;
  private boolean w = true;
  private int x = 3;
  private int y = 3;
  private int z = 3;
  
  static
  {
    boolean bool2 = true;
    l = new int[] { 16843828 };
    a = new int[] { 16842931 };
    boolean bool1;
    if (Build.VERSION.SDK_INT >= 19) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    b = bool1;
    if (Build.VERSION.SDK_INT >= 21) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    m = bool1;
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.p = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.t = new d(3);
    this.u = new d(5);
    this.c = ga.a(this, 1.0F, this.t);
    paramAttributeSet = this.c;
    paramAttributeSet.i = 1;
    paramAttributeSet.g = f2;
    this.t.b = paramAttributeSet;
    this.d = ga.a(this, 1.0F, this.u);
    paramAttributeSet = this.d;
    paramAttributeSet.i = 2;
    paramAttributeSet.g = f2;
    this.u.b = paramAttributeSet;
    setFocusableInTouchMode(true);
    ew.a(this, 1);
    ew.a(this, new a());
    setMotionEventSplittingEnabled(false);
    if (ew.k(this))
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
        {
          @TargetApi(21)
          public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
          {
            paramAnonymousView = (DrawerLayout)paramAnonymousView;
            int i = paramAnonymousWindowInsets.getSystemWindowInsetTop();
            boolean bool2 = true;
            boolean bool1;
            if (i > 0) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            paramAnonymousView.j = paramAnonymousWindowInsets;
            paramAnonymousView.k = bool1;
            if ((!bool1) && (paramAnonymousView.getBackground() == null)) {
              bool1 = bool2;
            } else {
              bool1 = false;
            }
            paramAnonymousView.setWillNotDraw(bool1);
            paramAnonymousView.requestLayout();
            return paramAnonymousWindowInsets.consumeSystemWindowInsets();
          }
        });
        setSystemUiVisibility(1280);
        paramContext = paramContext.obtainStyledAttributes(l);
      }
      try
      {
        this.F = paramContext.getDrawable(0);
        paramContext.recycle();
      }
      finally
      {
        paramContext.recycle();
      }
    }
    this.o = (f1 * 10.0F);
    this.M = new ArrayList();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    int i1 = ej.a(paramInt2, ew.c(this));
    if (paramInt2 != 3)
    {
      if (paramInt2 != 5)
      {
        if (paramInt2 != 8388611)
        {
          if (paramInt2 == 8388613) {
            this.A = paramInt1;
          }
        }
        else {
          this.z = paramInt1;
        }
      }
      else {
        this.y = paramInt1;
      }
    }
    else {
      this.x = paramInt1;
    }
    Object localObject;
    if (paramInt1 != 0)
    {
      if (i1 == 3) {
        localObject = this.c;
      } else {
        localObject = this.d;
      }
      ((ga)localObject).a();
    }
    switch (paramInt1)
    {
    default: 
    case 2: 
      localObject = a(i1);
      if (localObject != null)
      {
        h((View)localObject);
        return;
      }
      break;
    case 1: 
      localObject = a(i1);
      if (localObject != null) {
        e((View)localObject);
      }
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    int i4 = getChildCount();
    int i2 = 0;
    int i3;
    for (int i1 = 0; i2 < i4; i1 = i3)
    {
      View localView = getChildAt(i2);
      LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
      boolean bool = i1;
      if (d(localView)) {
        if (paramBoolean)
        {
          bool = i1;
          if (!localLayoutParams.c) {}
        }
        else
        {
          i3 = localView.getWidth();
          if (a(localView, 3)) {
            i1 |= this.c.a(localView, -i3, localView.getTop());
          } else {
            i1 |= this.d.a(localView, getWidth(), localView.getTop());
          }
          localLayoutParams.c = false;
          i3 = i1;
        }
      }
      i2 += 1;
    }
    this.t.a();
    this.u.a();
    if (i1 != 0) {
      invalidate();
    }
  }
  
  private static boolean a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (dg.a(paramDrawable)))
    {
      dg.b(paramDrawable, paramInt);
      return true;
    }
    return false;
  }
  
  static float b(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).b;
  }
  
  private View b()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if ((((LayoutParams)localView.getLayoutParams()).d & 0x1) == 1) {
        return localView;
      }
      i1 += 1;
    }
    return null;
  }
  
  static boolean d(View paramView)
  {
    int i1 = ej.a(((LayoutParams)paramView.getLayoutParams()).a, ew.c(paramView));
    if ((i1 & 0x3) != 0) {
      return true;
    }
    return (i1 & 0x5) != 0;
  }
  
  static boolean f(View paramView)
  {
    return (ew.b(paramView) != 4) && (ew.b(paramView) != 2);
  }
  
  private static boolean g(View paramView)
  {
    return ((LayoutParams)paramView.getLayoutParams()).a == 0;
  }
  
  private void h(View paramView)
  {
    if (d(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.w)
      {
        ((LayoutParams)localObject).b = 1.0F;
        ((LayoutParams)localObject).d = 1;
        a(paramView, true);
      }
      else
      {
        ((LayoutParams)localObject).d |= 0x2;
        if (a(paramView, 3)) {
          this.c.a(paramView, 0, paramView.getTop());
        } else {
          this.d.a(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
        }
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public final int a(View paramView)
  {
    if (d(paramView))
    {
      int i2 = ((LayoutParams)paramView.getLayoutParams()).a;
      int i1 = ew.c(this);
      if (i2 != 3)
      {
        if (i2 != 5)
        {
          if (i2 != 8388611)
          {
            if (i2 == 8388613)
            {
              i2 = this.A;
              if (i2 != 3) {
                return i2;
              }
              if (i1 == 0) {
                i1 = this.y;
              } else {
                i1 = this.x;
              }
              if (i1 != 3) {
                return i1;
              }
            }
          }
          else
          {
            i2 = this.z;
            if (i2 != 3) {
              return i2;
            }
            if (i1 == 0) {
              i1 = this.x;
            } else {
              i1 = this.y;
            }
            if (i1 != 3) {
              return i1;
            }
          }
        }
        else
        {
          i2 = this.y;
          if (i2 != 3) {
            return i2;
          }
          if (i1 == 0) {
            i1 = this.A;
          } else {
            i1 = this.z;
          }
          if (i1 != 3) {
            return i1;
          }
        }
      }
      else
      {
        i2 = this.x;
        if (i2 != 3) {
          return i2;
        }
        if (i1 == 0) {
          i1 = this.z;
        } else {
          i1 = this.A;
        }
        if (i1 != 3) {
          return i1;
        }
      }
      return 0;
    }
    StringBuilder localStringBuilder = new StringBuilder("View ");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" is not a drawer");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  final View a()
  {
    int i3 = getChildCount();
    int i1 = 0;
    while (i1 < i3)
    {
      View localView = getChildAt(i1);
      if (d(localView)) {
        if (d(localView))
        {
          int i2;
          if (((LayoutParams)localView.getLayoutParams()).b > 0.0F) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 != 0) {
            return localView;
          }
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder("View ");
          localStringBuilder.append(localView);
          localStringBuilder.append(" is not a drawer");
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      i1 += 1;
    }
    return null;
  }
  
  final View a(int paramInt)
  {
    int i1 = ej.a(paramInt, ew.c(this));
    int i2 = getChildCount();
    paramInt = 0;
    while (paramInt < i2)
    {
      View localView = getChildAt(paramInt);
      if ((c(localView) & 0x7) == (i1 & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  final void a(View paramView, float paramFloat)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.b) {
      return;
    }
    paramView.b = paramFloat;
    paramView = this.g;
    if (paramView != null)
    {
      int i1 = paramView.size() - 1;
      while (i1 >= 0)
      {
        ((c)this.g.get(i1)).a(paramFloat);
        i1 -= 1;
      }
    }
  }
  
  final void a(View paramView, boolean paramBoolean)
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      View localView = getChildAt(i1);
      if (((!paramBoolean) && (!d(localView))) || ((paramBoolean) && (localView == paramView))) {
        ew.a(localView, 1);
      } else {
        ew.a(localView, 4);
      }
      i1 += 1;
    }
  }
  
  final boolean a(View paramView, int paramInt)
  {
    return (c(paramView) & paramInt) == paramInt;
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int i5 = getChildCount();
    int i4 = 0;
    int i1 = 0;
    int i2 = 0;
    View localView;
    while (i1 < i5)
    {
      localView = getChildAt(i1);
      if (d(localView))
      {
        if (d(localView))
        {
          int i3;
          if ((((LayoutParams)localView.getLayoutParams()).d & 0x1) == 1) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          if (i3 != 0)
          {
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
            i2 = 1;
          }
        }
        else
        {
          paramArrayList = new StringBuilder("View ");
          paramArrayList.append(localView);
          paramArrayList.append(" is not a drawer");
          throw new IllegalArgumentException(paramArrayList.toString());
        }
      }
      else {
        this.M.add(localView);
      }
      i1 += 1;
    }
    if (i2 == 0)
    {
      i2 = this.M.size();
      i1 = i4;
      while (i1 < i2)
      {
        localView = (View)this.M.get(i1);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i1 += 1;
      }
    }
    this.M.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((b() == null) && (!d(paramView))) {
      ew.a(paramView, 1);
    } else {
      ew.a(paramView, 4);
    }
    if (!b) {
      ew.a(paramView, this.n);
    }
  }
  
  final int c(View paramView)
  {
    return ej.a(((LayoutParams)paramView.getLayoutParams()).a, ew.c(this));
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  public void computeScroll()
  {
    int i2 = getChildCount();
    float f1 = 0.0F;
    int i1 = 0;
    while (i1 < i2)
    {
      f1 = Math.max(f1, ((LayoutParams)getChildAt(i1).getLayoutParams()).b);
      i1 += 1;
    }
    this.r = f1;
    boolean bool1 = this.c.c();
    boolean bool2 = this.d.c();
    if ((bool1) || (bool2)) {
      ew.a(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i8 = getHeight();
    boolean bool1 = g(paramView);
    int i1 = getWidth();
    int i7 = paramCanvas.save();
    int i2 = 0;
    int i4;
    int i3;
    if (bool1)
    {
      int i9 = getChildCount();
      i4 = 0;
      i2 = 0;
      while (i4 < i9)
      {
        View localView = getChildAt(i4);
        int i5 = i2;
        int i6 = i1;
        if (localView != paramView)
        {
          i5 = i2;
          i6 = i1;
          if (localView.getVisibility() == 0)
          {
            Drawable localDrawable = localView.getBackground();
            if (localDrawable != null)
            {
              if (localDrawable.getOpacity() == -1) {
                i3 = 1;
              } else {
                i3 = 0;
              }
            }
            else {
              i3 = 0;
            }
            i5 = i2;
            i6 = i1;
            if (i3 != 0)
            {
              i5 = i2;
              i6 = i1;
              if (d(localView))
              {
                i5 = i2;
                i6 = i1;
                if (localView.getHeight() >= i8) {
                  if (a(localView, 3))
                  {
                    i3 = localView.getRight();
                    i5 = i2;
                    i6 = i1;
                    if (i3 > i2)
                    {
                      i5 = i3;
                      i6 = i1;
                    }
                  }
                  else
                  {
                    i3 = localView.getLeft();
                    i5 = i2;
                    i6 = i1;
                    if (i3 < i1)
                    {
                      i6 = i3;
                      i5 = i2;
                    }
                  }
                }
              }
            }
          }
        }
        i4 += 1;
        i2 = i5;
        i1 = i6;
      }
      paramCanvas.clipRect(i2, 0, i1, getHeight());
    }
    boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
    paramCanvas.restoreToCount(i7);
    float f1 = this.r;
    if ((f1 > 0.0F) && (bool1))
    {
      i3 = this.q;
      i4 = (int)(((0xFF000000 & i3) >>> 24) * f1);
      this.s.setColor(i3 & 0xFFFFFF | i4 << 24);
      paramCanvas.drawRect(i2, 0.0F, i1, getHeight(), this.s);
      return bool2;
    }
    if ((this.G != null) && (a(paramView, 3)))
    {
      i1 = this.G.getIntrinsicWidth();
      i2 = paramView.getRight();
      i3 = this.c.h;
      f1 = Math.max(0.0F, Math.min(i2 / i3, 1.0F));
      this.G.setBounds(i2, paramView.getTop(), i1 + i2, paramView.getBottom());
      this.G.setAlpha((int)(f1 * 255.0F));
      this.G.draw(paramCanvas);
      return bool2;
    }
    if ((this.H != null) && (a(paramView, 5)))
    {
      i1 = this.H.getIntrinsicWidth();
      i2 = paramView.getLeft();
      i3 = getWidth();
      i4 = this.d.h;
      f1 = Math.max(0.0F, Math.min((i3 - i2) / i4, 1.0F));
      this.H.setBounds(i2 - i1, paramView.getTop(), i2, paramView.getBottom());
      this.H.setAlpha((int)(f1 * 255.0F));
      this.H.draw(paramCanvas);
    }
    return bool2;
  }
  
  public final void e(View paramView)
  {
    if (d(paramView))
    {
      localObject = (LayoutParams)paramView.getLayoutParams();
      if (this.w)
      {
        ((LayoutParams)localObject).b = 0.0F;
        ((LayoutParams)localObject).d = 0;
      }
      else
      {
        ((LayoutParams)localObject).d |= 0x4;
        if (a(paramView, 3)) {
          this.c.a(paramView, -paramView.getWidth(), paramView.getTop());
        } else {
          this.d.a(paramView, getWidth(), paramView.getTop());
        }
      }
      invalidate();
      return;
    }
    Object localObject = new StringBuilder("View ");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" is not a sliding drawer");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
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
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  public float getDrawerElevation()
  {
    if (m) {
      return this.o;
    }
    return 0.0F;
  }
  
  public Drawable getStatusBarBackgroundDrawable()
  {
    return this.F;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.w = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.w = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.k) && (this.F != null))
    {
      int i1;
      if (Build.VERSION.SDK_INT >= 21)
      {
        Object localObject = this.j;
        if (localObject != null) {
          i1 = ((WindowInsets)localObject).getSystemWindowInsetTop();
        } else {
          i1 = 0;
        }
      }
      else
      {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.F.setBounds(0, 0, getWidth(), i1);
        this.F.draw(paramCanvas);
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    boolean bool1 = this.c.a(paramMotionEvent);
    boolean bool2 = this.d.a(paramMotionEvent);
    int i2;
    float f1;
    float f2;
    switch (i1)
    {
    default: 
      break;
    case 2: 
      paramMotionEvent = this.c;
      int i3 = paramMotionEvent.c.length;
      i2 = 0;
      while (i2 < i3)
      {
        if (paramMotionEvent.a(i2))
        {
          f1 = paramMotionEvent.e[i2] - paramMotionEvent.c[i2];
          f2 = paramMotionEvent.f[i2] - paramMotionEvent.d[i2];
          if (f1 * f1 + f2 * f2 > paramMotionEvent.b * paramMotionEvent.b) {
            i1 = 1;
          } else {
            i1 = 0;
          }
        }
        else
        {
          i1 = 0;
        }
        if (i1 != 0)
        {
          i1 = 1;
          break label185;
        }
        i2 += 1;
      }
      i1 = 0;
      if (i1 != 0)
      {
        this.t.a();
        this.u.a();
      }
      break;
    case 1: 
    case 3: 
      a(true);
      this.B = false;
      this.f = false;
      break;
    case 0: 
      label185:
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.D = f1;
      this.E = f2;
      if (this.r > 0.0F)
      {
        paramMotionEvent = this.c.b((int)f1, (int)f2);
        if ((paramMotionEvent != null) && (g(paramMotionEvent)))
        {
          i1 = 1;
          break label286;
        }
      }
      i1 = 0;
      label286:
      this.B = false;
      this.f = false;
      break;
    }
    i1 = 0;
    if ((!(bool1 | bool2)) && (i1 == 0))
    {
      i2 = getChildCount();
      i1 = 0;
      while (i1 < i2)
      {
        if (((LayoutParams)getChildAt(i1).getLayoutParams()).c)
        {
          i1 = 1;
          break label367;
        }
        i1 += 1;
      }
      i1 = 0;
      label367:
      if (i1 == 0) {
        return this.f;
      }
    }
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      int i1;
      if (a() != null) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        paramKeyEvent.startTracking();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      paramKeyEvent = a();
      if ((paramKeyEvent != null) && (a(paramKeyEvent) == 0)) {
        a(false);
      }
      return paramKeyEvent != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.v = true;
    int i4 = paramInt3 - paramInt1;
    int i5 = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < i5)
    {
      View localView = getChildAt(paramInt3);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if (g(localView))
        {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
        else
        {
          int i6 = localView.getMeasuredWidth();
          int i7 = localView.getMeasuredHeight();
          float f1;
          int i1;
          if (a(localView, 3))
          {
            paramInt1 = -i6;
            f1 = i6;
            i1 = paramInt1 + (int)(localLayoutParams.b * f1);
            f1 = (i6 + i1) / f1;
          }
          else
          {
            f1 = i6;
            i1 = i4 - (int)(localLayoutParams.b * f1);
            f1 = (i4 - i1) / f1;
          }
          int i2;
          if (f1 != localLayoutParams.b) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          paramInt1 = localLayoutParams.a & 0x70;
          if (paramInt1 != 16)
          {
            if (paramInt1 != 80)
            {
              localView.layout(i1, localLayoutParams.topMargin, i6 + i1, localLayoutParams.topMargin + i7);
            }
            else
            {
              paramInt1 = paramInt4 - paramInt2;
              localView.layout(i1, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i6 + i1, paramInt1 - localLayoutParams.bottomMargin);
            }
          }
          else
          {
            int i8 = paramInt4 - paramInt2;
            int i3 = (i8 - i7) / 2;
            if (i3 < localLayoutParams.topMargin)
            {
              paramInt1 = localLayoutParams.topMargin;
            }
            else
            {
              paramInt1 = i3;
              if (i3 + i7 > i8 - localLayoutParams.bottomMargin) {
                paramInt1 = i8 - localLayoutParams.bottomMargin - i7;
              }
            }
            localView.layout(i1, paramInt1, i6 + i1, i7 + paramInt1);
          }
          if (i2 != 0) {
            a(localView, f1);
          }
          if (localLayoutParams.b > 0.0F) {
            paramInt1 = 0;
          } else {
            paramInt1 = 4;
          }
          if (localView.getVisibility() != paramInt1) {
            localView.setVisibility(paramInt1);
          }
        }
      }
      paramInt3 += 1;
    }
    this.v = false;
    this.w = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt2);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    int i3;
    int i4;
    if (i7 == 1073741824)
    {
      i3 = i2;
      i4 = i5;
      if (i6 == 1073741824) {}
    }
    else
    {
      if (!isInEditMode()) {
        break label805;
      }
      i1 = i2;
      if (i7 != -2147483648)
      {
        i1 = i2;
        if (i7 == 0) {
          i1 = 300;
        }
      }
      i3 = i1;
      i4 = i5;
      if (i6 != -2147483648)
      {
        i3 = i1;
        i4 = i5;
        if (i6 == 0)
        {
          i4 = 300;
          i3 = i1;
        }
      }
    }
    setMeasuredDimension(i3, i4);
    if ((this.j != null) && (ew.k(this))) {
      i5 = 1;
    } else {
      i5 = 0;
    }
    int i8 = ew.c(this);
    int i9 = getChildCount();
    i6 = 0;
    i2 = 0;
    int i1 = 0;
    while (i6 < i9)
    {
      View localView = getChildAt(i6);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        Object localObject2;
        Object localObject1;
        if (i5 != 0)
        {
          i7 = ej.a(localLayoutParams.a, i8);
          if (ew.k(localView))
          {
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.j;
              if (i7 == 3)
              {
                localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              }
              else
              {
                localObject1 = localObject2;
                if (i7 == 5) {
                  localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
                }
              }
              localView.dispatchApplyWindowInsets((WindowInsets)localObject1);
            }
          }
          else if (Build.VERSION.SDK_INT >= 21)
          {
            localObject2 = (WindowInsets)this.j;
            if (i7 == 3)
            {
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
            }
            else
            {
              localObject1 = localObject2;
              if (i7 == 5) {
                localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              }
            }
            localLayoutParams.leftMargin = ((WindowInsets)localObject1).getSystemWindowInsetLeft();
            localLayoutParams.topMargin = ((WindowInsets)localObject1).getSystemWindowInsetTop();
            localLayoutParams.rightMargin = ((WindowInsets)localObject1).getSystemWindowInsetRight();
            localLayoutParams.bottomMargin = ((WindowInsets)localObject1).getSystemWindowInsetBottom();
          }
        }
        if (g(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(i3 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i4 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
        else if (d(localView))
        {
          if (m)
          {
            float f1 = ew.g(localView);
            float f2 = this.o;
            if (f1 != f2) {
              ew.a(localView, f2);
            }
          }
          int i10 = c(localView) & 0x7;
          if (i10 == 3) {
            i7 = 1;
          } else {
            i7 = 0;
          }
          if (((i7 != 0) && (i2 != 0)) || ((i7 == 0) && (i1 != 0)))
          {
            localObject2 = new StringBuilder("Child drawer has absolute gravity ");
            if ((i10 & 0x3) != 3)
            {
              if ((i10 & 0x5) == 5) {
                localObject1 = "RIGHT";
              } else {
                localObject1 = Integer.toHexString(i10);
              }
            }
            else {
              localObject1 = "LEFT";
            }
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" but this DrawerLayout already has a drawer view along that edge");
            throw new IllegalStateException(((StringBuilder)localObject2).toString());
          }
          if (i7 != 0) {
            i2 = 1;
          } else {
            i1 = 1;
          }
          localView.measure(getChildMeasureSpec(paramInt1, this.p + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        }
        else
        {
          localObject1 = new StringBuilder("Child ");
          ((StringBuilder)localObject1).append(localView);
          ((StringBuilder)localObject1).append(" at index ");
          ((StringBuilder)localObject1).append(i6);
          ((StringBuilder)localObject1).append(" does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
          throw new IllegalStateException(((StringBuilder)localObject1).toString());
        }
      }
      i6 += 1;
    }
    return;
    label805:
    throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
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
    if (paramParcelable.a != 0)
    {
      View localView = a(paramParcelable.a);
      if (localView != null) {
        h(localView);
      }
    }
    if (paramParcelable.d != 3) {
      a(paramParcelable.d, 3);
    }
    if (paramParcelable.e != 3) {
      a(paramParcelable.e, 5);
    }
    if (paramParcelable.f != 3) {
      a(paramParcelable.f, 8388611);
    }
    if (paramParcelable.g != 3) {
      a(paramParcelable.g, 8388613);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    if (!m)
    {
      paramInt = ew.c(this);
      if (paramInt == 0)
      {
        localDrawable = this.I;
        if (localDrawable != null)
        {
          a(localDrawable, paramInt);
          localDrawable = this.I;
          break label66;
        }
      }
      else
      {
        localDrawable = this.J;
        if (localDrawable != null)
        {
          a(localDrawable, paramInt);
          localDrawable = this.J;
          break label66;
        }
      }
      Drawable localDrawable = this.K;
      label66:
      this.G = localDrawable;
      paramInt = ew.c(this);
      if (paramInt == 0)
      {
        localDrawable = this.J;
        if (localDrawable != null)
        {
          a(localDrawable, paramInt);
          localDrawable = this.J;
          break label131;
        }
      }
      else
      {
        localDrawable = this.I;
        if (localDrawable != null)
        {
          a(localDrawable, paramInt);
          localDrawable = this.I;
          break label131;
        }
      }
      localDrawable = this.L;
      label131:
      this.H = localDrawable;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    int i4 = getChildCount();
    int i1 = 0;
    while (i1 < i4)
    {
      LayoutParams localLayoutParams = (LayoutParams)getChildAt(i1).getLayoutParams();
      int i2 = localLayoutParams.d;
      int i3 = 1;
      if (i2 == 1) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      if (localLayoutParams.d != 2) {
        i3 = 0;
      }
      if ((i2 == 0) && (i3 == 0)) {
        i1 += 1;
      } else {
        localSavedState.a = localLayoutParams.a;
      }
    }
    localSavedState.d = this.x;
    localSavedState.e = this.y;
    localSavedState.f = this.z;
    localSavedState.g = this.A;
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.c.b(paramMotionEvent);
    this.d.b(paramMotionEvent);
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 3)
    {
      switch (i1)
      {
      default: 
        return true;
      case 1: 
        f2 = paramMotionEvent.getX();
        f1 = paramMotionEvent.getY();
        paramMotionEvent = this.c.b((int)f2, (int)f1);
        if ((paramMotionEvent != null) && (g(paramMotionEvent)))
        {
          f2 -= this.D;
          f1 -= this.E;
          i1 = this.c.b;
          if (f2 * f2 + f1 * f1 < i1 * i1)
          {
            paramMotionEvent = b();
            if (paramMotionEvent != null)
            {
              if (a(paramMotionEvent) == 2)
              {
                bool = true;
                break label164;
              }
              bool = false;
              break label164;
            }
          }
        }
        boolean bool = true;
        label164:
        a(bool);
        this.B = false;
        return true;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.D = f1;
      this.E = f2;
      this.B = false;
      this.f = false;
      return true;
    }
    a(true);
    this.B = false;
    this.f = false;
    return true;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.B = paramBoolean;
    if (paramBoolean) {
      a(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.v) {
      super.requestLayout();
    }
  }
  
  public void setDrawerElevation(float paramFloat)
  {
    this.o = paramFloat;
    int i1 = 0;
    while (i1 < getChildCount())
    {
      View localView = getChildAt(i1);
      if (d(localView)) {
        ew.a(localView, this.o);
      }
      i1 += 1;
    }
  }
  
  @Deprecated
  public void setDrawerListener(c paramc)
  {
    c localc = this.C;
    if ((localc != null) && (localc != null))
    {
      List localList = this.g;
      if (localList != null) {
        localList.remove(localc);
      }
    }
    if ((paramc != null) && (paramc != null))
    {
      if (this.g == null) {
        this.g = new ArrayList();
      }
      this.g.add(paramc);
    }
    this.C = paramc;
  }
  
  public void setDrawerLockMode(int paramInt)
  {
    a(paramInt, 3);
    a(paramInt, 5);
  }
  
  public void setScrimColor(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }
  
  public void setStatusBarBackground(int paramInt)
  {
    Drawable localDrawable;
    if (paramInt != 0) {
      localDrawable = cr.a(getContext(), paramInt);
    } else {
      localDrawable = null;
    }
    this.F = localDrawable;
    invalidate();
  }
  
  public void setStatusBarBackground(Drawable paramDrawable)
  {
    this.F = paramDrawable;
    invalidate();
  }
  
  public void setStatusBarBackgroundColor(int paramInt)
  {
    this.F = new ColorDrawable(paramInt);
    invalidate();
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int a = 0;
    float b;
    boolean c;
    int d;
    
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, DrawerLayout.a);
      this.a = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.a = paramLayoutParams.a;
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
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int a = 0;
    int d;
    int e;
    int f;
    int g;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.a = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.g = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a);
      paramParcel.writeInt(this.d);
      paramParcel.writeInt(this.e);
      paramParcel.writeInt(this.f);
      paramParcel.writeInt(this.g);
    }
  }
  
  final class a
    extends eh
  {
    private final Rect c = new Rect();
    
    a() {}
    
    public final void a(View paramView, fe paramfe)
    {
      if (DrawerLayout.b)
      {
        super.a(paramView, paramfe);
      }
      else
      {
        Object localObject1 = fe.a(paramfe);
        super.a(paramView, (fe)localObject1);
        paramfe.a(paramView);
        Object localObject2 = ew.d(paramView);
        if ((localObject2 instanceof View)) {
          paramfe.c((View)localObject2);
        }
        localObject2 = this.c;
        ((fe)localObject1).a((Rect)localObject2);
        paramfe.b((Rect)localObject2);
        ((fe)localObject1).c((Rect)localObject2);
        paramfe.d((Rect)localObject2);
        paramfe.c(((fe)localObject1).a());
        paramfe.a(((fe)localObject1).a.getPackageName());
        paramfe.b(((fe)localObject1).a.getClassName());
        paramfe.c(((fe)localObject1).a.getContentDescription());
        paramfe.h(((fe)localObject1).a.isEnabled());
        paramfe.f(((fe)localObject1).a.isClickable());
        paramfe.a(((fe)localObject1).a.isFocusable());
        paramfe.b(((fe)localObject1).a.isFocused());
        paramfe.d(((fe)localObject1).b());
        paramfe.e(((fe)localObject1).a.isSelected());
        paramfe.g(((fe)localObject1).a.isLongClickable());
        paramfe.a(((fe)localObject1).a.getActions());
        ((fe)localObject1).a.recycle();
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          localObject1 = paramView.getChildAt(i);
          if (DrawerLayout.f((View)localObject1)) {
            paramfe.b((View)localObject1);
          }
          i += 1;
        }
      }
      paramfe.b(DrawerLayout.class.getName());
      paramfe.a(false);
      paramfe.b(false);
      paramfe.a(fe.a.a);
      paramfe.a(fe.a.b);
    }
    
    public final boolean a(ViewGroup paramViewGroup, View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if ((!DrawerLayout.b) && (!DrawerLayout.f(paramView))) {
        return false;
      }
      return super.a(paramViewGroup, paramView, paramAccessibilityEvent);
    }
    
    public final boolean b(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      if (paramAccessibilityEvent.getEventType() == 32)
      {
        paramAccessibilityEvent = paramAccessibilityEvent.getText();
        paramView = DrawerLayout.this.a();
        if (paramView != null)
        {
          int i = DrawerLayout.this.c(paramView);
          paramView = DrawerLayout.this;
          i = ej.a(i, ew.c(paramView));
          if (i == 3) {
            paramView = paramView.h;
          } else if (i == 5) {
            paramView = paramView.i;
          } else {
            paramView = null;
          }
          if (paramView != null) {
            paramAccessibilityEvent.add(paramView);
          }
        }
        return true;
      }
      return super.b(paramView, paramAccessibilityEvent);
    }
    
    public final void d(View paramView, AccessibilityEvent paramAccessibilityEvent)
    {
      super.d(paramView, paramAccessibilityEvent);
      paramAccessibilityEvent.setClassName(DrawerLayout.class.getName());
    }
  }
  
  static final class b
    extends eh
  {
    public final void a(View paramView, fe paramfe)
    {
      super.a(paramView, paramfe);
      if (!DrawerLayout.f(paramView)) {
        paramfe.c(null);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(float paramFloat);
    
    public abstract void b();
  }
  
  final class d
    extends ga.a
  {
    final int a;
    ga b;
    private final Runnable d = new Runnable()
    {
      public final void run()
      {
        Object localObject2 = DrawerLayout.d.this;
        int m = ((DrawerLayout.d)localObject2).b.h;
        int i = ((DrawerLayout.d)localObject2).a;
        int k = 0;
        if (i == 3) {
          i = 1;
        } else {
          i = 0;
        }
        Object localObject1;
        int j;
        if (i != 0)
        {
          localObject1 = ((DrawerLayout.d)localObject2).c.a(3);
          if (localObject1 != null) {
            j = -((View)localObject1).getWidth();
          } else {
            j = 0;
          }
          j += m;
        }
        else
        {
          localObject1 = ((DrawerLayout.d)localObject2).c.a(5);
          j = ((DrawerLayout.d)localObject2).c.getWidth() - m;
        }
        if ((localObject1 != null) && (((i != 0) && (((View)localObject1).getLeft() < j)) || ((i == 0) && (((View)localObject1).getLeft() > j) && (((DrawerLayout.d)localObject2).c.a((View)localObject1) == 0))))
        {
          DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)((View)localObject1).getLayoutParams();
          ((DrawerLayout.d)localObject2).b.a((View)localObject1, j, ((View)localObject1).getTop());
          localLayoutParams.c = true;
          ((DrawerLayout.d)localObject2).c.invalidate();
          ((DrawerLayout.d)localObject2).b();
          localObject1 = ((DrawerLayout.d)localObject2).c;
          if (!((DrawerLayout)localObject1).f)
          {
            long l = SystemClock.uptimeMillis();
            localObject2 = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
            j = ((DrawerLayout)localObject1).getChildCount();
            i = k;
            while (i < j)
            {
              ((DrawerLayout)localObject1).getChildAt(i).dispatchTouchEvent((MotionEvent)localObject2);
              i += 1;
            }
            ((MotionEvent)localObject2).recycle();
            ((DrawerLayout)localObject1).f = true;
          }
        }
      }
    };
    
    d(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a()
    {
      DrawerLayout.this.removeCallbacks(this.d);
    }
    
    public final void a(int paramInt)
    {
      DrawerLayout localDrawerLayout = DrawerLayout.this;
      View localView = this.b.j;
      int k = localDrawerLayout.c.a;
      int m = localDrawerLayout.d.a;
      int j = 2;
      int i;
      if ((k != 1) && (m != 1))
      {
        i = j;
        if (k != 2) {
          if (m == 2) {
            i = j;
          } else {
            i = 0;
          }
        }
      }
      else
      {
        i = 1;
      }
      if ((localView != null) && (paramInt == 0))
      {
        DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (localLayoutParams.b == 0.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.d & 0x1) == 1)
          {
            localLayoutParams.d = 0;
            if (localDrawerLayout.g != null)
            {
              paramInt = localDrawerLayout.g.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.g.get(paramInt)).b();
                paramInt -= 1;
              }
            }
            localDrawerLayout.a(localView, false);
            if (localDrawerLayout.hasWindowFocus())
            {
              localView = localDrawerLayout.getRootView();
              if (localView != null) {
                localView.sendAccessibilityEvent(32);
              }
            }
          }
        }
        else if (localLayoutParams.b == 1.0F)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if ((localLayoutParams.d & 0x1) == 0)
          {
            localLayoutParams.d = 1;
            if (localDrawerLayout.g != null)
            {
              paramInt = localDrawerLayout.g.size() - 1;
              while (paramInt >= 0)
              {
                ((DrawerLayout.c)localDrawerLayout.g.get(paramInt)).a();
                paramInt -= 1;
              }
            }
            localDrawerLayout.a(localView, true);
            if (localDrawerLayout.hasWindowFocus()) {
              localDrawerLayout.sendAccessibilityEvent(32);
            }
          }
        }
      }
      if (i != localDrawerLayout.e)
      {
        localDrawerLayout.e = i;
        if (localDrawerLayout.g != null)
        {
          paramInt = localDrawerLayout.g.size() - 1;
          while (paramInt >= 0)
          {
            localDrawerLayout.g.get(paramInt);
            paramInt -= 1;
          }
        }
      }
    }
    
    public final void a(int paramInt1, int paramInt2)
    {
      View localView;
      if ((paramInt1 & 0x1) == 1) {
        localView = DrawerLayout.this.a(3);
      } else {
        localView = DrawerLayout.this.a(5);
      }
      if ((localView != null) && (DrawerLayout.this.a(localView) == 0)) {
        this.b.a(localView, paramInt2);
      }
    }
    
    public final void a(View paramView, float paramFloat)
    {
      float f = DrawerLayout.b(paramView);
      int k = paramView.getWidth();
      int i;
      if (DrawerLayout.this.a(paramView, 3))
      {
        if ((paramFloat <= 0.0F) && ((paramFloat != 0.0F) || (f <= 0.5F))) {
          i = -k;
        } else {
          i = 0;
        }
      }
      else
      {
        int j = DrawerLayout.this.getWidth();
        if (paramFloat >= 0.0F)
        {
          i = j;
          if (paramFloat == 0.0F)
          {
            i = j;
            if (f <= 0.5F) {}
          }
        }
        else
        {
          i = j - k;
        }
      }
      this.b.a(i, paramView.getTop());
      DrawerLayout.this.invalidate();
    }
    
    public final void a(View paramView, int paramInt)
    {
      int i = paramView.getWidth();
      float f;
      if (DrawerLayout.this.a(paramView, 3)) {
        f = (paramInt + i) / i;
      } else {
        f = (DrawerLayout.this.getWidth() - paramInt) / i;
      }
      DrawerLayout.this.a(paramView, f);
      if (f == 0.0F) {
        paramInt = 4;
      } else {
        paramInt = 0;
      }
      paramView.setVisibility(paramInt);
      DrawerLayout.this.invalidate();
    }
    
    public final boolean a(View paramView)
    {
      return (DrawerLayout.d(paramView)) && (DrawerLayout.this.a(paramView, this.a)) && (DrawerLayout.this.a(paramView) == 0);
    }
    
    public final int b(View paramView, int paramInt)
    {
      if (DrawerLayout.this.a(paramView, 3)) {
        return Math.max(-paramView.getWidth(), Math.min(paramInt, 0));
      }
      int i = DrawerLayout.this.getWidth();
      return Math.max(i - paramView.getWidth(), Math.min(paramInt, i));
    }
    
    final void b()
    {
      int j = this.a;
      int i = 3;
      if (j == 3) {
        i = 5;
      }
      View localView = DrawerLayout.this.a(i);
      if (localView != null) {
        DrawerLayout.this.e(localView);
      }
    }
    
    public final void b(View paramView)
    {
      ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).c = false;
      b();
    }
    
    public final int c(View paramView)
    {
      if (DrawerLayout.d(paramView)) {
        return paramView.getWidth();
      }
      return 0;
    }
    
    public final void c()
    {
      DrawerLayout.this.postDelayed(this.d, 160L);
    }
    
    public final int d(View paramView)
    {
      return paramView.getTop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */