package android.support.v7.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window.Callback;
import android.widget.OverScroller;
import com.tencent.token.eq;
import com.tencent.token.es;
import com.tencent.token.ew;
import com.tencent.token.go.a;
import com.tencent.token.go.f;
import com.tencent.token.hs.a;
import com.tencent.token.io;
import com.tencent.token.ip;
import com.tencent.token.jk;

public class ActionBarOverlayLayout
  extends ViewGroup
  implements eq, io
{
  static final int[] f = { go.a.actionBarSize, 16842841 };
  private final Runnable A = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.a();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.d = localActionBarOverlayLayout.a.animate().translationY(0.0F).setListener(ActionBarOverlayLayout.this.e);
    }
  };
  private final Runnable B = new Runnable()
  {
    public final void run()
    {
      ActionBarOverlayLayout.this.a();
      ActionBarOverlayLayout localActionBarOverlayLayout = ActionBarOverlayLayout.this;
      localActionBarOverlayLayout.d = localActionBarOverlayLayout.a.animate().translationY(-ActionBarOverlayLayout.this.a.getHeight()).setListener(ActionBarOverlayLayout.this.e);
    }
  };
  private final es C;
  ActionBarContainer a;
  public boolean b;
  boolean c;
  ViewPropertyAnimator d;
  final AnimatorListenerAdapter e = new AnimatorListenerAdapter()
  {
    public final void onAnimationCancel(Animator paramAnonymousAnimator)
    {
      paramAnonymousAnimator = ActionBarOverlayLayout.this;
      paramAnonymousAnimator.d = null;
      paramAnonymousAnimator.c = false;
    }
    
    public final void onAnimationEnd(Animator paramAnonymousAnimator)
    {
      paramAnonymousAnimator = ActionBarOverlayLayout.this;
      paramAnonymousAnimator.d = null;
      paramAnonymousAnimator.c = false;
    }
  };
  private int g;
  private int h = 0;
  private ContentFrameLayout i;
  private ip j;
  private Drawable k;
  private boolean l;
  private boolean m;
  private boolean n;
  private int o;
  private int p;
  private final Rect q = new Rect();
  private final Rect r = new Rect();
  private final Rect s = new Rect();
  private final Rect t = new Rect();
  private final Rect u = new Rect();
  private final Rect v = new Rect();
  private final Rect w = new Rect();
  private a x;
  private final int y = 600;
  private OverScroller z;
  
  public ActionBarOverlayLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
    this.C = new es(this);
  }
  
  private static ip a(View paramView)
  {
    if ((paramView instanceof ip)) {
      return (ip)paramView;
    }
    if ((paramView instanceof Toolbar)) {
      return ((Toolbar)paramView).getWrapper();
    }
    StringBuilder localStringBuilder = new StringBuilder("Can't make a decor toolbar out of ");
    localStringBuilder.append(paramView.getClass().getSimpleName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void a(Context paramContext)
  {
    TypedArray localTypedArray = getContext().getTheme().obtainStyledAttributes(f);
    boolean bool2 = false;
    this.g = localTypedArray.getDimensionPixelSize(0, 0);
    this.k = localTypedArray.getDrawable(1);
    if (this.k == null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    setWillNotDraw(bool1);
    localTypedArray.recycle();
    boolean bool1 = bool2;
    if (paramContext.getApplicationInfo().targetSdkVersion < 19) {
      bool1 = true;
    }
    this.l = bool1;
    this.z = new OverScroller(paramContext);
  }
  
  private static boolean a(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramView = (LayoutParams)paramView.getLayoutParams();
    boolean bool1;
    if (paramView.leftMargin != paramRect.left)
    {
      paramView.leftMargin = paramRect.left;
      bool1 = true;
    }
    else
    {
      bool1 = false;
    }
    if (paramView.topMargin != paramRect.top)
    {
      paramView.topMargin = paramRect.top;
      bool1 = true;
    }
    if (paramView.rightMargin != paramRect.right)
    {
      paramView.rightMargin = paramRect.right;
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (paramBoolean)
    {
      bool2 = bool1;
      if (paramView.bottomMargin != paramRect.bottom)
      {
        paramView.bottomMargin = paramRect.bottom;
        bool2 = true;
      }
    }
    return bool2;
  }
  
  private void i()
  {
    if (this.i == null)
    {
      this.i = ((ContentFrameLayout)findViewById(go.f.action_bar_activity_content));
      this.a = ((ActionBarContainer)findViewById(go.f.action_bar_container));
      this.j = a(findViewById(go.f.action_bar));
    }
  }
  
  final void a()
  {
    removeCallbacks(this.A);
    removeCallbacks(this.B);
    ViewPropertyAnimator localViewPropertyAnimator = this.d;
    if (localViewPropertyAnimator != null) {
      localViewPropertyAnimator.cancel();
    }
  }
  
  public final void a(int paramInt)
  {
    i();
    if (paramInt != 2)
    {
      if (paramInt != 5)
      {
        if (paramInt != 109) {
          return;
        }
        setOverlayMode(true);
        return;
      }
      return;
    }
  }
  
  public final void a(Menu paramMenu, hs.a parama)
  {
    i();
    this.j.a(paramMenu, parama);
  }
  
  public final boolean b()
  {
    i();
    return this.j.f();
  }
  
  public final boolean c()
  {
    i();
    return this.j.g();
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof LayoutParams;
  }
  
  public final boolean d()
  {
    i();
    return this.j.h();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if ((this.k != null) && (!this.l))
    {
      int i1;
      if (this.a.getVisibility() == 0) {
        i1 = (int)(this.a.getBottom() + this.a.getTranslationY() + 0.5F);
      } else {
        i1 = 0;
      }
      this.k.setBounds(0, i1, getWidth(), this.k.getIntrinsicHeight() + i1);
      this.k.draw(paramCanvas);
    }
  }
  
  public final boolean e()
  {
    i();
    return this.j.i();
  }
  
  public final boolean f()
  {
    i();
    return this.j.j();
  }
  
  protected boolean fitSystemWindows(Rect paramRect)
  {
    i();
    ew.i(this);
    boolean bool = a(this.a, paramRect, false);
    this.t.set(paramRect);
    jk.a(this, this.t, this.q);
    if (!this.u.equals(this.t))
    {
      this.u.set(this.t);
      bool = true;
    }
    if (!this.r.equals(this.q))
    {
      this.r.set(this.q);
      bool = true;
    }
    if (bool) {
      requestLayout();
    }
    return true;
  }
  
  public final void g()
  {
    i();
    this.j.k();
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new LayoutParams(paramLayoutParams);
  }
  
  public int getActionBarHideOffset()
  {
    ActionBarContainer localActionBarContainer = this.a;
    if (localActionBarContainer != null) {
      return -(int)localActionBarContainer.getTranslationY();
    }
    return 0;
  }
  
  public int getNestedScrollAxes()
  {
    return this.C.a;
  }
  
  public CharSequence getTitle()
  {
    i();
    return this.j.e();
  }
  
  public final void h()
  {
    i();
    this.j.l();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a(getContext());
    ew.j(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    a();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt3 = getPaddingLeft();
    getPaddingRight();
    paramInt4 = getPaddingTop();
    getPaddingBottom();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView.getVisibility() != 8)
      {
        LayoutParams localLayoutParams = (LayoutParams)localView.getLayoutParams();
        int i1 = localView.getMeasuredWidth();
        int i2 = localView.getMeasuredHeight();
        int i3 = localLayoutParams.leftMargin + paramInt3;
        int i4 = localLayoutParams.topMargin + paramInt4;
        localView.layout(i3, i4, i1 + i3, i2 + i4);
      }
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    i();
    measureChildWithMargins(this.a, paramInt1, 0, paramInt2, 0);
    Object localObject = (LayoutParams)this.a.getLayoutParams();
    int i6 = Math.max(0, this.a.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i5 = Math.max(0, this.a.getMeasuredHeight() + ((LayoutParams)localObject).topMargin + ((LayoutParams)localObject).bottomMargin);
    int i4 = View.combineMeasuredStates(0, this.a.getMeasuredState());
    if ((ew.i(this) & 0x100) != 0) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    if (i2 != 0)
    {
      i3 = this.g;
      i1 = i3;
      if (this.m)
      {
        i1 = i3;
        if (this.a.getTabContainer() != null) {
          i1 = i3 + this.g;
        }
      }
    }
    else if (this.a.getVisibility() != 8)
    {
      i1 = this.a.getMeasuredHeight();
    }
    else
    {
      i1 = 0;
    }
    this.s.set(this.q);
    this.v.set(this.t);
    if ((!this.b) && (i2 == 0))
    {
      localObject = this.s;
      ((Rect)localObject).top += i1;
      localObject = this.s;
      ((Rect)localObject).bottom += 0;
    }
    else
    {
      localObject = this.v;
      ((Rect)localObject).top += i1;
      localObject = this.v;
      ((Rect)localObject).bottom += 0;
    }
    a(this.i, this.s, true);
    if (!this.w.equals(this.v))
    {
      this.w.set(this.v);
      this.i.a(this.v);
    }
    measureChildWithMargins(this.i, paramInt1, 0, paramInt2, 0);
    localObject = (LayoutParams)this.i.getLayoutParams();
    int i1 = Math.max(i6, this.i.getMeasuredWidth() + ((LayoutParams)localObject).leftMargin + ((LayoutParams)localObject).rightMargin);
    int i2 = Math.max(i5, this.i.getMeasuredHeight() + ((LayoutParams)localObject).topMargin + ((LayoutParams)localObject).bottomMargin);
    int i3 = View.combineMeasuredStates(i4, this.i.getMeasuredState());
    i4 = getPaddingLeft();
    i5 = getPaddingRight();
    i2 = Math.max(i2 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight());
    setMeasuredDimension(View.resolveSizeAndState(Math.max(i1 + (i4 + i5), getSuggestedMinimumWidth()), paramInt1, i3), View.resolveSizeAndState(i2, paramInt2, i3 << 16));
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    boolean bool = this.n;
    int i1 = 0;
    if (bool)
    {
      if (!paramBoolean) {
        return false;
      }
      this.z.fling(0, 0, 0, (int)paramFloat2, 0, 0, -2147483648, 2147483647);
      if (this.z.getFinalY() > this.a.getHeight()) {
        i1 = 1;
      }
      if (i1 != 0)
      {
        a();
        this.B.run();
      }
      else
      {
        a();
        this.A.run();
      }
      this.c = true;
      return true;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt) {}
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.o += paramInt2;
    setActionBarHideOffset(this.o);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    this.C.a = paramInt;
    this.o = getActionBarHideOffset();
    a();
    paramView1 = this.x;
    if (paramView1 != null) {
      paramView1.k();
    }
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    if (((paramInt & 0x2) != 0) && (this.a.getVisibility() == 0)) {
      return this.n;
    }
    return false;
  }
  
  public void onStopNestedScroll(View paramView)
  {
    if ((this.n) && (!this.c))
    {
      if (this.o <= this.a.getHeight())
      {
        a();
        postDelayed(this.A, 600L);
        return;
      }
      a();
      postDelayed(this.B, 600L);
    }
  }
  
  public void onWindowSystemUiVisibilityChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      super.onWindowSystemUiVisibilityChanged(paramInt);
    }
    i();
    int i3 = this.p;
    this.p = paramInt;
    int i2 = 0;
    int i1;
    if ((paramInt & 0x4) == 0) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((paramInt & 0x100) != 0) {
      i2 = 1;
    }
    a locala = this.x;
    if (locala != null)
    {
      locala.d(i2 ^ 0x1);
      if ((i1 == 0) && (i2 != 0)) {
        this.x.j();
      } else {
        this.x.i();
      }
    }
    if ((((i3 ^ paramInt) & 0x100) != 0) && (this.x != null)) {
      ew.j(this);
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    this.h = paramInt;
    a locala = this.x;
    if (locala != null) {
      locala.b(paramInt);
    }
  }
  
  public void setActionBarHideOffset(int paramInt)
  {
    a();
    paramInt = Math.max(0, Math.min(paramInt, this.a.getHeight()));
    this.a.setTranslationY(-paramInt);
  }
  
  public void setActionBarVisibilityCallback(a parama)
  {
    this.x = parama;
    if (getWindowToken() != null)
    {
      this.x.b(this.h);
      int i1 = this.p;
      if (i1 != 0)
      {
        onWindowSystemUiVisibilityChanged(i1);
        ew.j(this);
      }
    }
  }
  
  public void setHasNonEmbeddedTabs(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.n)
    {
      this.n = paramBoolean;
      if (!paramBoolean)
      {
        a();
        setActionBarHideOffset(0);
      }
    }
  }
  
  public void setIcon(int paramInt)
  {
    i();
    this.j.a(paramInt);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    i();
    this.j.a(paramDrawable);
  }
  
  public void setLogo(int paramInt)
  {
    i();
    this.j.b(paramInt);
  }
  
  public void setOverlayMode(boolean paramBoolean)
  {
    this.b = paramBoolean;
    if ((paramBoolean) && (getContext().getApplicationInfo().targetSdkVersion < 19)) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.l = paramBoolean;
  }
  
  public void setShowingForActionMode(boolean paramBoolean) {}
  
  public void setUiOptions(int paramInt) {}
  
  public void setWindowCallback(Window.Callback paramCallback)
  {
    i();
    this.j.a(paramCallback);
  }
  
  public void setWindowTitle(CharSequence paramCharSequence)
  {
    i();
    this.j.a(paramCharSequence);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public LayoutParams()
    {
      super(-1);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt);
    
    public abstract void d(boolean paramBoolean);
    
    public abstract void i();
    
    public abstract void j();
    
    public abstract void k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.ActionBarOverlayLayout
 * JD-Core Version:    0.7.0.1
 */