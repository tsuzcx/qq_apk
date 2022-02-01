package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.v4.view.AbsSavedState;
import android.support.v7.app.ActionBar.LayoutParams;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.fb;
import com.tencent.token.fd;
import com.tencent.token.fo;
import com.tencent.token.hg.a;
import com.tencent.token.hg.j;
import com.tencent.token.hi;
import com.tencent.token.hp;
import com.tencent.token.ht;
import com.tencent.token.id;
import com.tencent.token.id.a;
import com.tencent.token.if;
import com.tencent.token.ik;
import com.tencent.token.ik.a;
import com.tencent.token.iq;
import com.tencent.token.jh;
import com.tencent.token.jp;
import com.tencent.token.jw;
import com.tencent.token.jx;
import com.tencent.token.kc;
import java.util.ArrayList;
import java.util.List;

public class Toolbar
  extends ViewGroup
{
  private int A;
  private int B;
  private int C = 8388627;
  private CharSequence D;
  private CharSequence E;
  private int F;
  private int G;
  private boolean H;
  private boolean I;
  private final ArrayList<View> J = new ArrayList();
  private final int[] K = new int[2];
  private final ActionMenuView.d L = new ActionMenuView.d()
  {
    public final boolean a(MenuItem paramAnonymousMenuItem)
    {
      if (Toolbar.this.o != null) {
        return Toolbar.this.o.a(paramAnonymousMenuItem);
      }
      return false;
    }
  };
  private jx M;
  private boolean N;
  private final Runnable O = new Runnable()
  {
    public final void run()
    {
      Toolbar.this.b();
    }
  };
  public ActionMenuView a;
  public TextView b;
  public TextView c;
  Drawable d;
  CharSequence e;
  ImageButton f;
  View g;
  public Context h;
  public int i;
  public int j;
  public int k;
  int l;
  public jp m;
  final ArrayList<View> n = new ArrayList();
  b o;
  public ActionMenuPresenter p;
  public a q;
  public ik.a r;
  public id.a s;
  private ImageButton t;
  private ImageView u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, hg.a.toolbarStyle);
  }
  
  public Toolbar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = jw.a(getContext(), paramAttributeSet, hg.j.Toolbar, paramInt, 0);
    this.j = paramContext.g(hg.j.Toolbar_titleTextAppearance, 0);
    this.k = paramContext.g(hg.j.Toolbar_subtitleTextAppearance, 0);
    this.C = paramContext.c(hg.j.Toolbar_android_gravity, this.C);
    this.l = paramContext.c(hg.j.Toolbar_buttonGravity, 48);
    int i1 = paramContext.d(hg.j.Toolbar_titleMargin, 0);
    paramInt = i1;
    if (paramContext.f(hg.j.Toolbar_titleMargins)) {
      paramInt = paramContext.d(hg.j.Toolbar_titleMargins, i1);
    }
    this.z = paramInt;
    this.y = paramInt;
    this.x = paramInt;
    this.w = paramInt;
    paramInt = paramContext.d(hg.j.Toolbar_titleMarginStart, -1);
    if (paramInt >= 0) {
      this.w = paramInt;
    }
    paramInt = paramContext.d(hg.j.Toolbar_titleMarginEnd, -1);
    if (paramInt >= 0) {
      this.x = paramInt;
    }
    paramInt = paramContext.d(hg.j.Toolbar_titleMarginTop, -1);
    if (paramInt >= 0) {
      this.y = paramInt;
    }
    paramInt = paramContext.d(hg.j.Toolbar_titleMarginBottom, -1);
    if (paramInt >= 0) {
      this.z = paramInt;
    }
    this.v = paramContext.e(hg.j.Toolbar_maxButtonHeight, -1);
    paramInt = paramContext.d(hg.j.Toolbar_contentInsetStart, -2147483648);
    i1 = paramContext.d(hg.j.Toolbar_contentInsetEnd, -2147483648);
    int i2 = paramContext.e(hg.j.Toolbar_contentInsetLeft, 0);
    int i3 = paramContext.e(hg.j.Toolbar_contentInsetRight, 0);
    g();
    paramAttributeSet = this.m;
    paramAttributeSet.h = false;
    if (i2 != -2147483648)
    {
      paramAttributeSet.e = i2;
      paramAttributeSet.a = i2;
    }
    if (i3 != -2147483648)
    {
      paramAttributeSet.f = i3;
      paramAttributeSet.b = i3;
    }
    if ((paramInt != -2147483648) || (i1 != -2147483648)) {
      this.m.a(paramInt, i1);
    }
    this.A = paramContext.d(hg.j.Toolbar_contentInsetStartWithNavigation, -2147483648);
    this.B = paramContext.d(hg.j.Toolbar_contentInsetEndWithActions, -2147483648);
    this.d = paramContext.a(hg.j.Toolbar_collapseIcon);
    this.e = paramContext.c(hg.j.Toolbar_collapseContentDescription);
    paramAttributeSet = paramContext.c(hg.j.Toolbar_title);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setTitle(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(hg.j.Toolbar_subtitle);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setSubtitle(paramAttributeSet);
    }
    this.h = getContext();
    setPopupTheme(paramContext.g(hg.j.Toolbar_popupTheme, 0));
    paramAttributeSet = paramContext.a(hg.j.Toolbar_navigationIcon);
    if (paramAttributeSet != null) {
      setNavigationIcon(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(hg.j.Toolbar_navigationContentDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setNavigationContentDescription(paramAttributeSet);
    }
    paramAttributeSet = paramContext.a(hg.j.Toolbar_logo);
    if (paramAttributeSet != null) {
      setLogo(paramAttributeSet);
    }
    paramAttributeSet = paramContext.c(hg.j.Toolbar_logoDescription);
    if (!TextUtils.isEmpty(paramAttributeSet)) {
      setLogoDescription(paramAttributeSet);
    }
    if (paramContext.f(hg.j.Toolbar_titleTextColor)) {
      setTitleTextColor(paramContext.b(hg.j.Toolbar_titleTextColor, -1));
    }
    if (paramContext.f(hg.j.Toolbar_subtitleTextColor)) {
      setSubtitleTextColor(paramContext.b(hg.j.Toolbar_subtitleTextColor, -1));
    }
    paramContext.a.recycle();
  }
  
  private int a(int paramInt)
  {
    paramInt &= 0x70;
    if ((paramInt != 16) && (paramInt != 48) && (paramInt != 80)) {
      return this.C & 0x70;
    }
    return paramInt;
  }
  
  private int a(View paramView, int paramInt)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i2 = paramView.getMeasuredHeight();
    if (paramInt > 0) {
      paramInt = (i2 - paramInt) / 2;
    } else {
      paramInt = 0;
    }
    int i1 = a(localLayoutParams.a);
    if (i1 != 48)
    {
      if (i1 != 80)
      {
        int i3 = getPaddingTop();
        paramInt = getPaddingBottom();
        int i4 = getHeight();
        i1 = (i4 - i3 - paramInt - i2) / 2;
        if (i1 < localLayoutParams.topMargin)
        {
          paramInt = localLayoutParams.topMargin;
        }
        else
        {
          i2 = i4 - paramInt - i2 - i1 - i3;
          paramInt = i1;
          if (i2 < localLayoutParams.bottomMargin) {
            paramInt = Math.max(0, i1 - (localLayoutParams.bottomMargin - i2));
          }
        }
        return i3 + paramInt;
      }
      return getHeight() - getPaddingBottom() - i2 - localLayoutParams.bottomMargin - paramInt;
    }
    return getPaddingTop() - paramInt;
  }
  
  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = localMarginLayoutParams.leftMargin - paramArrayOfInt[0];
    int i2 = localMarginLayoutParams.rightMargin - paramArrayOfInt[1];
    int i3 = Math.max(0, i1) + Math.max(0, i2);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramArrayOfInt[1] = Math.max(0, -i2);
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + i3 + paramInt2, localMarginLayoutParams.width), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + paramInt4, localMarginLayoutParams.height));
    return paramView.getMeasuredWidth() + i3;
  }
  
  private int a(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.leftMargin - paramArrayOfInt[0];
    paramInt1 += Math.max(0, i1);
    paramArrayOfInt[0] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1, paramInt2, paramInt1 + i1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 + (i1 + localLayoutParams.rightMargin);
  }
  
  private static LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof LayoutParams)) {
      return new LayoutParams((LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ActionBar.LayoutParams)) {
      return new LayoutParams((ActionBar.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new LayoutParams(paramLayoutParams);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    int i1 = getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt2, localMarginLayoutParams.width);
    paramInt2 = getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + localMarginLayoutParams.topMargin + localMarginLayoutParams.bottomMargin + 0, localMarginLayoutParams.height);
    paramInt3 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = paramInt2;
    if (paramInt3 != 1073741824)
    {
      paramInt1 = paramInt2;
      if (paramInt4 >= 0)
      {
        paramInt1 = paramInt4;
        if (paramInt3 != 0) {
          paramInt1 = Math.min(View.MeasureSpec.getSize(paramInt2), paramInt4);
        }
        paramInt1 = View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824);
      }
    }
    paramView.measure(i1, paramInt1);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    Object localObject = paramView.getLayoutParams();
    if (localObject == null) {
      localObject = new LayoutParams();
    } else if (!checkLayoutParams((ViewGroup.LayoutParams)localObject)) {
      localObject = a((ViewGroup.LayoutParams)localObject);
    } else {
      localObject = (LayoutParams)localObject;
    }
    ((LayoutParams)localObject).b = 1;
    if ((paramBoolean) && (this.g != null))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.n.add(paramView);
      return;
    }
    addView(paramView, (ViewGroup.LayoutParams)localObject);
  }
  
  private void a(List<View> paramList, int paramInt)
  {
    int i1 = fo.c(this);
    int i2 = 0;
    if (i1 == 1) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4 = getChildCount();
    int i3 = fb.a(paramInt, fo.c(this));
    paramList.clear();
    paramInt = i2;
    View localView;
    LayoutParams localLayoutParams;
    if (i1 != 0)
    {
      paramInt = i4 - 1;
      while (paramInt >= 0)
      {
        localView = getChildAt(paramInt);
        localLayoutParams = (LayoutParams)localView.getLayoutParams();
        if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
          paramList.add(localView);
        }
        paramInt -= 1;
      }
      return;
    }
    while (paramInt < i4)
    {
      localView = getChildAt(paramInt);
      localLayoutParams = (LayoutParams)localView.getLayoutParams();
      if ((localLayoutParams.b == 0) && (a(localView)) && (b(localLayoutParams.a) == i3)) {
        paramList.add(localView);
      }
      paramInt += 1;
    }
  }
  
  private boolean a(View paramView)
  {
    return (paramView != null) && (paramView.getParent() == this) && (paramView.getVisibility() != 8);
  }
  
  private int b(int paramInt)
  {
    int i1 = fo.c(this);
    paramInt = fb.a(paramInt, i1) & 0x7;
    if ((paramInt != 1) && (paramInt != 3) && (paramInt != 5))
    {
      if (i1 == 1) {
        return 5;
      }
      return 3;
    }
    return paramInt;
  }
  
  private static int b(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return fd.a(paramView) + fd.b(paramView);
  }
  
  private int b(View paramView, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    int i1 = localLayoutParams.rightMargin - paramArrayOfInt[1];
    paramInt1 -= Math.max(0, i1);
    paramArrayOfInt[1] = Math.max(0, -i1);
    paramInt2 = a(paramView, paramInt2);
    i1 = paramView.getMeasuredWidth();
    paramView.layout(paramInt1 - i1, paramInt2, paramInt1, paramView.getMeasuredHeight() + paramInt2);
    return paramInt1 - (i1 + localLayoutParams.leftMargin);
  }
  
  private static int c(View paramView)
  {
    paramView = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    return paramView.topMargin + paramView.bottomMargin;
  }
  
  private boolean d(View paramView)
  {
    return (paramView.getParent() == this) || (this.n.contains(paramView));
  }
  
  protected static LayoutParams e()
  {
    return new LayoutParams();
  }
  
  private MenuInflater getMenuInflater()
  {
    return new ht(getContext());
  }
  
  private void h()
  {
    if (this.u == null) {
      this.u = new AppCompatImageView(getContext());
    }
  }
  
  private void i()
  {
    d();
    if (this.a.a == null)
    {
      id localid = (id)this.a.getMenu();
      if (this.q == null) {
        this.q = new a();
      }
      this.a.setExpandedActionViewsExclusive(true);
      localid.a(this.q, this.h);
    }
  }
  
  private void j()
  {
    if (this.t == null)
    {
      this.t = new AppCompatImageButton(getContext(), null, hg.a.toolbarNavigationButtonStyle);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.a = (0x800003 | this.l & 0x70);
      this.t.setLayoutParams(localLayoutParams);
    }
  }
  
  public final boolean a()
  {
    ActionMenuView localActionMenuView = this.a;
    if (localActionMenuView != null)
    {
      int i1;
      if ((localActionMenuView.c != null) && (localActionMenuView.c.h())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final boolean b()
  {
    ActionMenuView localActionMenuView = this.a;
    if (localActionMenuView != null)
    {
      int i1;
      if ((localActionMenuView.c != null) && (localActionMenuView.c.d())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0) {
        return true;
      }
    }
    return false;
  }
  
  public final void c()
  {
    Object localObject = this.q;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((a)localObject).b;
    }
    if (localObject != null) {
      ((if)localObject).collapseActionView();
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return (super.checkLayoutParams(paramLayoutParams)) && ((paramLayoutParams instanceof LayoutParams));
  }
  
  public final void d()
  {
    if (this.a == null)
    {
      this.a = new ActionMenuView(getContext());
      this.a.setPopupTheme(this.i);
      this.a.setOnMenuItemClickListener(this.L);
      this.a.a(this.r, this.s);
      LayoutParams localLayoutParams = new LayoutParams();
      localLayoutParams.a = (0x800005 | this.l & 0x70);
      this.a.setLayoutParams(localLayoutParams);
      a(this.a, false);
    }
  }
  
  final void f()
  {
    int i1 = this.n.size() - 1;
    while (i1 >= 0)
    {
      addView((View)this.n.get(i1));
      i1 -= 1;
    }
    this.n.clear();
  }
  
  public final void g()
  {
    if (this.m == null) {
      this.m = new jp();
    }
  }
  
  public int getContentInsetEnd()
  {
    jp localjp = this.m;
    if (localjp != null)
    {
      if (localjp.g) {
        return localjp.a;
      }
      return localjp.b;
    }
    return 0;
  }
  
  public int getContentInsetEndWithActions()
  {
    int i1 = this.B;
    if (i1 != -2147483648) {
      return i1;
    }
    return getContentInsetEnd();
  }
  
  public int getContentInsetLeft()
  {
    jp localjp = this.m;
    if (localjp != null) {
      return localjp.a;
    }
    return 0;
  }
  
  public int getContentInsetRight()
  {
    jp localjp = this.m;
    if (localjp != null) {
      return localjp.b;
    }
    return 0;
  }
  
  public int getContentInsetStart()
  {
    jp localjp = this.m;
    if (localjp != null)
    {
      if (localjp.g) {
        return localjp.b;
      }
      return localjp.a;
    }
    return 0;
  }
  
  public int getContentInsetStartWithNavigation()
  {
    int i1 = this.A;
    if (i1 != -2147483648) {
      return i1;
    }
    return getContentInsetStart();
  }
  
  public int getCurrentContentInsetEnd()
  {
    Object localObject = this.a;
    int i1;
    if (localObject != null)
    {
      localObject = ((ActionMenuView)localObject).a;
      if ((localObject != null) && (((id)localObject).hasVisibleItems())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
    }
    else
    {
      i1 = 0;
    }
    if (i1 != 0) {
      return Math.max(getContentInsetEnd(), Math.max(this.B, 0));
    }
    return getContentInsetEnd();
  }
  
  public int getCurrentContentInsetLeft()
  {
    if (fo.c(this) == 1) {
      return getCurrentContentInsetEnd();
    }
    return getCurrentContentInsetStart();
  }
  
  public int getCurrentContentInsetRight()
  {
    if (fo.c(this) == 1) {
      return getCurrentContentInsetStart();
    }
    return getCurrentContentInsetEnd();
  }
  
  public int getCurrentContentInsetStart()
  {
    if (getNavigationIcon() != null) {
      return Math.max(getContentInsetStart(), Math.max(this.A, 0));
    }
    return getContentInsetStart();
  }
  
  public Drawable getLogo()
  {
    ImageView localImageView = this.u;
    if (localImageView != null) {
      return localImageView.getDrawable();
    }
    return null;
  }
  
  public CharSequence getLogoDescription()
  {
    ImageView localImageView = this.u;
    if (localImageView != null) {
      return localImageView.getContentDescription();
    }
    return null;
  }
  
  public Menu getMenu()
  {
    i();
    return this.a.getMenu();
  }
  
  public CharSequence getNavigationContentDescription()
  {
    ImageButton localImageButton = this.t;
    if (localImageButton != null) {
      return localImageButton.getContentDescription();
    }
    return null;
  }
  
  public Drawable getNavigationIcon()
  {
    ImageButton localImageButton = this.t;
    if (localImageButton != null) {
      return localImageButton.getDrawable();
    }
    return null;
  }
  
  ActionMenuPresenter getOuterActionMenuPresenter()
  {
    return this.p;
  }
  
  public Drawable getOverflowIcon()
  {
    i();
    return this.a.getOverflowIcon();
  }
  
  Context getPopupContext()
  {
    return this.h;
  }
  
  public int getPopupTheme()
  {
    return this.i;
  }
  
  public CharSequence getSubtitle()
  {
    return this.E;
  }
  
  public CharSequence getTitle()
  {
    return this.D;
  }
  
  public int getTitleMarginBottom()
  {
    return this.z;
  }
  
  public int getTitleMarginEnd()
  {
    return this.x;
  }
  
  public int getTitleMarginStart()
  {
    return this.w;
  }
  
  public int getTitleMarginTop()
  {
    return this.y;
  }
  
  public jh getWrapper()
  {
    if (this.M == null) {
      this.M = new jx(this, true);
    }
    return this.M;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.O);
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 9) {
      this.I = false;
    }
    if (!this.I)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      if ((i1 == 9) && (!bool)) {
        this.I = true;
      }
    }
    if ((i1 == 10) || (i1 == 3)) {
      this.I = false;
    }
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (fo.c(this) == 1) {
      i3 = 1;
    } else {
      i3 = 0;
    }
    int i5 = getWidth();
    int i8 = getHeight();
    paramInt3 = getPaddingLeft();
    int i6 = getPaddingRight();
    int i7 = getPaddingTop();
    int i9 = getPaddingBottom();
    int i4 = i5 - i6;
    int[] arrayOfInt = this.K;
    arrayOfInt[1] = 0;
    arrayOfInt[0] = 0;
    paramInt1 = fo.e(this);
    if (paramInt1 >= 0) {
      paramInt4 = Math.min(paramInt1, paramInt4 - paramInt2);
    } else {
      paramInt4 = 0;
    }
    if (a(this.t))
    {
      if (i3 != 0)
      {
        paramInt2 = b(this.t, i4, arrayOfInt, paramInt4);
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = a(this.t, paramInt3, arrayOfInt, paramInt4);
        paramInt2 = i4;
      }
    }
    else
    {
      paramInt1 = paramInt3;
      paramInt2 = i4;
    }
    int i1 = paramInt1;
    int i2 = paramInt2;
    if (a(this.f)) {
      if (i3 != 0)
      {
        i2 = b(this.f, paramInt2, arrayOfInt, paramInt4);
        i1 = paramInt1;
      }
      else
      {
        i1 = a(this.f, paramInt1, arrayOfInt, paramInt4);
        i2 = paramInt2;
      }
    }
    paramInt2 = i1;
    paramInt1 = i2;
    if (a(this.a)) {
      if (i3 != 0)
      {
        paramInt2 = a(this.a, i1, arrayOfInt, paramInt4);
        paramInt1 = i2;
      }
      else
      {
        paramInt1 = b(this.a, i2, arrayOfInt, paramInt4);
        paramInt2 = i1;
      }
    }
    i2 = getCurrentContentInsetLeft();
    i1 = getCurrentContentInsetRight();
    arrayOfInt[0] = Math.max(0, i2 - paramInt2);
    arrayOfInt[1] = Math.max(0, i1 - (i4 - paramInt1));
    paramInt2 = Math.max(paramInt2, i2);
    i1 = Math.min(paramInt1, i4 - i1);
    paramInt1 = paramInt2;
    i2 = i1;
    if (a(this.g)) {
      if (i3 != 0)
      {
        i2 = b(this.g, i1, arrayOfInt, paramInt4);
        paramInt1 = paramInt2;
      }
      else
      {
        paramInt1 = a(this.g, paramInt2, arrayOfInt, paramInt4);
        i2 = i1;
      }
    }
    paramInt2 = paramInt1;
    i1 = i2;
    if (a(this.u)) {
      if (i3 != 0)
      {
        i1 = b(this.u, i2, arrayOfInt, paramInt4);
        paramInt2 = paramInt1;
      }
      else
      {
        paramInt2 = a(this.u, paramInt1, arrayOfInt, paramInt4);
        i1 = i2;
      }
    }
    paramBoolean = a(this.b);
    boolean bool = a(this.c);
    if (paramBoolean)
    {
      localObject1 = (LayoutParams)this.b.getLayoutParams();
      paramInt1 = ((LayoutParams)localObject1).topMargin + this.b.getMeasuredHeight() + ((LayoutParams)localObject1).bottomMargin + 0;
    }
    else
    {
      paramInt1 = 0;
    }
    if (bool)
    {
      localObject1 = (LayoutParams)this.c.getLayoutParams();
      paramInt1 += ((LayoutParams)localObject1).topMargin + this.c.getMeasuredHeight() + ((LayoutParams)localObject1).bottomMargin;
    }
    Object localObject2;
    if ((!paramBoolean) && (!bool))
    {
      paramInt1 = paramInt2;
      paramInt2 = i1;
    }
    else
    {
      if (paramBoolean) {
        localObject1 = this.b;
      } else {
        localObject1 = this.c;
      }
      if (bool) {
        localObject2 = this.c;
      } else {
        localObject2 = this.b;
      }
      localObject1 = (LayoutParams)((View)localObject1).getLayoutParams();
      localObject2 = (LayoutParams)((View)localObject2).getLayoutParams();
      if (((paramBoolean) && (this.b.getMeasuredWidth() > 0)) || ((bool) && (this.c.getMeasuredWidth() > 0))) {
        i2 = 1;
      } else {
        i2 = 0;
      }
      i4 = this.C & 0x70;
      if (i4 != 48)
      {
        if (i4 != 80)
        {
          i4 = (i8 - i7 - i9 - paramInt1) / 2;
          if (i4 < ((LayoutParams)localObject1).topMargin + this.y)
          {
            paramInt1 = ((LayoutParams)localObject1).topMargin + this.y;
          }
          else
          {
            i8 = i8 - i9 - paramInt1 - i4 - i7;
            paramInt1 = i4;
            if (i8 < ((LayoutParams)localObject1).bottomMargin + this.z) {
              paramInt1 = Math.max(0, i4 - (((LayoutParams)localObject2).bottomMargin + this.z - i8));
            }
          }
          paramInt1 = i7 + paramInt1;
        }
        else
        {
          paramInt1 = i8 - i9 - ((LayoutParams)localObject2).bottomMargin - this.z - paramInt1;
        }
      }
      else {
        paramInt1 = getPaddingTop() + ((LayoutParams)localObject1).topMargin + this.y;
      }
      i4 = paramInt2;
      if (i3 != 0)
      {
        if (i2 != 0) {
          paramInt2 = this.w;
        } else {
          paramInt2 = 0;
        }
        i3 = paramInt2 - arrayOfInt[1];
        paramInt2 = i1 - Math.max(0, i3);
        arrayOfInt[1] = Math.max(0, -i3);
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.b.getLayoutParams();
          i3 = paramInt2 - this.b.getMeasuredWidth();
          i1 = this.b.getMeasuredHeight() + paramInt1;
          this.b.layout(i3, paramInt1, paramInt2, i1);
          paramInt1 = i3 - this.x;
          i3 = i1 + ((LayoutParams)localObject1).bottomMargin;
        }
        else
        {
          i1 = paramInt2;
          i3 = paramInt1;
          paramInt1 = i1;
        }
        if (bool)
        {
          localObject1 = (LayoutParams)this.c.getLayoutParams();
          i1 = i3 + ((LayoutParams)localObject1).topMargin;
          i3 = this.c.getMeasuredWidth();
          i7 = this.c.getMeasuredHeight();
          this.c.layout(paramInt2 - i3, i1, paramInt2, i7 + i1);
          i1 = paramInt2 - this.x;
          i3 = ((LayoutParams)localObject1).bottomMargin;
        }
        else
        {
          i1 = paramInt2;
        }
        if (i2 != 0) {
          paramInt2 = Math.min(paramInt1, i1);
        }
        paramInt1 = i4;
      }
      else
      {
        if (i2 != 0) {
          paramInt2 = this.w;
        } else {
          paramInt2 = 0;
        }
        i3 = paramInt2 - arrayOfInt[0];
        paramInt2 = i4 + Math.max(0, i3);
        arrayOfInt[0] = Math.max(0, -i3);
        if (paramBoolean)
        {
          localObject1 = (LayoutParams)this.b.getLayoutParams();
          i3 = this.b.getMeasuredWidth() + paramInt2;
          i4 = this.b.getMeasuredHeight() + paramInt1;
          this.b.layout(paramInt2, paramInt1, i3, i4);
          i3 += this.x;
          paramInt1 = i4 + ((LayoutParams)localObject1).bottomMargin;
        }
        else
        {
          i3 = paramInt2;
        }
        if (bool)
        {
          localObject1 = (LayoutParams)this.c.getLayoutParams();
          paramInt1 += ((LayoutParams)localObject1).topMargin;
          i4 = this.c.getMeasuredWidth() + paramInt2;
          i7 = this.c.getMeasuredHeight();
          this.c.layout(paramInt2, paramInt1, i4, i7 + paramInt1);
          i4 += this.x;
          paramInt1 = ((LayoutParams)localObject1).bottomMargin;
        }
        else
        {
          i4 = paramInt2;
        }
        paramInt1 = paramInt2;
        paramInt2 = i1;
        if (i2 != 0)
        {
          paramInt1 = Math.max(i3, i4);
          paramInt2 = i1;
        }
      }
    }
    int i3 = paramInt4;
    i4 = paramInt3;
    a(this.J, 3);
    paramInt4 = this.J.size();
    paramInt3 = 0;
    while (paramInt3 < paramInt4)
    {
      paramInt1 = a((View)this.J.get(paramInt3), paramInt1, arrayOfInt, i3);
      paramInt3 += 1;
    }
    a(this.J, 5);
    paramInt4 = this.J.size();
    paramInt3 = 0;
    while (paramInt3 < paramInt4)
    {
      paramInt2 = b((View)this.J.get(paramInt3), paramInt2, arrayOfInt, i3);
      paramInt3 += 1;
    }
    a(this.J, 1);
    Object localObject1 = this.J;
    i2 = arrayOfInt[0];
    i1 = arrayOfInt[1];
    i7 = ((List)localObject1).size();
    paramInt4 = 0;
    paramInt3 = 0;
    while (paramInt4 < i7)
    {
      localObject2 = (View)((List)localObject1).get(paramInt4);
      LayoutParams localLayoutParams = (LayoutParams)((View)localObject2).getLayoutParams();
      i2 = localLayoutParams.leftMargin - i2;
      i1 = localLayoutParams.rightMargin - i1;
      i8 = Math.max(0, i2);
      i9 = Math.max(0, i1);
      i2 = Math.max(0, -i2);
      i1 = Math.max(0, -i1);
      paramInt3 += i8 + ((View)localObject2).getMeasuredWidth() + i9;
      paramInt4 += 1;
    }
    paramInt4 = 0;
    i1 = i4 + (i5 - i4 - i6) / 2 - paramInt3 / 2;
    paramInt3 += i1;
    if (i1 >= paramInt1) {
      if (paramInt3 > paramInt2) {
        paramInt1 = i1 - (paramInt3 - paramInt2);
      } else {
        paramInt1 = i1;
      }
    }
    paramInt3 = this.J.size();
    paramInt2 = paramInt4;
    while (paramInt2 < paramInt3)
    {
      paramInt1 = a((View)this.J.get(paramInt2), paramInt1, arrayOfInt, i3);
      paramInt2 += 1;
    }
    this.J.clear();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject = this.K;
    boolean bool = kc.a(this);
    int i8 = 1;
    if (bool)
    {
      i6 = 1;
      i5 = 0;
    }
    else
    {
      i6 = 0;
      i5 = 1;
    }
    if (a(this.t))
    {
      a(this.t, paramInt1, 0, paramInt2, this.v);
      i1 = this.t.getMeasuredWidth() + b(this.t);
      i4 = Math.max(0, this.t.getMeasuredHeight() + c(this.t));
      i3 = View.combineMeasuredStates(0, this.t.getMeasuredState());
    }
    else
    {
      i1 = 0;
      i4 = 0;
      i3 = 0;
    }
    int i7 = i1;
    int i2 = i4;
    int i1 = i3;
    if (a(this.f))
    {
      a(this.f, paramInt1, 0, paramInt2, this.v);
      i7 = this.f.getMeasuredWidth() + b(this.f);
      i2 = Math.max(i4, this.f.getMeasuredHeight() + c(this.f));
      i1 = View.combineMeasuredStates(i3, this.f.getMeasuredState());
    }
    int i3 = getCurrentContentInsetStart();
    int i4 = Math.max(i3, i7) + 0;
    localObject[i6] = Math.max(0, i3 - i7);
    if (a(this.a))
    {
      a(this.a, paramInt1, i4, paramInt2, this.v);
      i3 = this.a.getMeasuredWidth() + b(this.a);
      i2 = Math.max(i2, this.a.getMeasuredHeight() + c(this.a));
      i1 = View.combineMeasuredStates(i1, this.a.getMeasuredState());
    }
    else
    {
      i3 = 0;
    }
    i7 = getCurrentContentInsetEnd();
    int i6 = i4 + Math.max(i7, i3);
    localObject[i5] = Math.max(0, i7 - i3);
    int i5 = i2;
    i3 = i1;
    i4 = i6;
    if (a(this.g))
    {
      i4 = i6 + a(this.g, paramInt1, i6, paramInt2, 0, (int[])localObject);
      i5 = Math.max(i2, this.g.getMeasuredHeight() + c(this.g));
      i3 = View.combineMeasuredStates(i1, this.g.getMeasuredState());
    }
    i6 = i5;
    i1 = i3;
    i2 = i4;
    if (a(this.u))
    {
      i2 = i4 + a(this.u, paramInt1, i4, paramInt2, 0, (int[])localObject);
      i6 = Math.max(i5, this.u.getMeasuredHeight() + c(this.u));
      i1 = View.combineMeasuredStates(i3, this.u.getMeasuredState());
    }
    int i9 = getChildCount();
    i5 = i6;
    i3 = 0;
    i4 = i2;
    i2 = i3;
    while (i2 < i9)
    {
      View localView = getChildAt(i2);
      i7 = i1;
      i6 = i4;
      i3 = i5;
      if (((LayoutParams)localView.getLayoutParams()).b == 0)
      {
        i7 = i1;
        i6 = i4;
        i3 = i5;
        if (a(localView))
        {
          i6 = i4 + a(localView, paramInt1, i4, paramInt2, 0, (int[])localObject);
          i3 = Math.max(i5, localView.getMeasuredHeight() + c(localView));
          i7 = View.combineMeasuredStates(i1, localView.getMeasuredState());
        }
      }
      i2 += 1;
      i1 = i7;
      i4 = i6;
      i5 = i3;
    }
    i6 = this.y + this.z;
    i7 = this.w + this.x;
    if (a(this.b))
    {
      a(this.b, paramInt1, i4 + i7, paramInt2, i6, (int[])localObject);
      i3 = this.b.getMeasuredWidth();
      i9 = b(this.b);
      i2 = this.b.getMeasuredHeight();
      int i10 = c(this.b);
      i1 = View.combineMeasuredStates(i1, this.b.getMeasuredState());
      i2 += i10;
      i3 += i9;
    }
    else
    {
      i3 = 0;
      i2 = 0;
    }
    if (a(this.c))
    {
      i3 = Math.max(i3, a(this.c, paramInt1, i4 + i7, paramInt2, i2 + i6, (int[])localObject));
      i6 = this.c.getMeasuredHeight();
      i7 = c(this.c);
      i1 = View.combineMeasuredStates(i1, this.c.getMeasuredState());
      i2 += i6 + i7;
    }
    i5 = Math.max(i5, i2);
    i2 = getPaddingLeft();
    i9 = getPaddingRight();
    i6 = getPaddingTop();
    i7 = getPaddingBottom();
    i2 = View.resolveSizeAndState(Math.max(i4 + i3 + (i2 + i9), getSuggestedMinimumWidth()), paramInt1, 0xFF000000 & i1);
    i1 = View.resolveSizeAndState(Math.max(i5 + (i6 + i7), getSuggestedMinimumHeight()), paramInt2, i1 << 16);
    if (!this.N)
    {
      paramInt1 = 0;
    }
    else
    {
      i3 = getChildCount();
      paramInt2 = 0;
      for (;;)
      {
        paramInt1 = i8;
        if (paramInt2 >= i3) {
          break;
        }
        localObject = getChildAt(paramInt2);
        if ((a((View)localObject)) && (((View)localObject).getMeasuredWidth() > 0) && (((View)localObject).getMeasuredHeight() > 0))
        {
          paramInt1 = 0;
          break;
        }
        paramInt2 += 1;
      }
    }
    paramInt2 = i1;
    if (paramInt1 != 0) {
      paramInt2 = 0;
    }
    setMeasuredDimension(i2, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.c);
    paramParcelable = this.a;
    if (paramParcelable != null) {
      paramParcelable = paramParcelable.a;
    } else {
      paramParcelable = null;
    }
    if ((localSavedState.a != 0) && (this.q != null) && (paramParcelable != null))
    {
      paramParcelable = paramParcelable.findItem(localSavedState.a);
      if (paramParcelable != null) {
        paramParcelable.expandActionView();
      }
    }
    if (localSavedState.d)
    {
      removeCallbacks(this.O);
      post(this.O);
    }
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17) {
      super.onRtlPropertiesChanged(paramInt);
    }
    g();
    jp localjp = this.m;
    boolean bool = true;
    if (paramInt != 1) {
      bool = false;
    }
    if (bool != localjp.g)
    {
      localjp.g = bool;
      if (localjp.h)
      {
        if (bool)
        {
          if (localjp.d != -2147483648) {
            paramInt = localjp.d;
          } else {
            paramInt = localjp.e;
          }
          localjp.a = paramInt;
          if (localjp.c != -2147483648) {
            paramInt = localjp.c;
          } else {
            paramInt = localjp.f;
          }
          localjp.b = paramInt;
          return;
        }
        if (localjp.c != -2147483648) {
          paramInt = localjp.c;
        } else {
          paramInt = localjp.e;
        }
        localjp.a = paramInt;
        if (localjp.d != -2147483648) {
          paramInt = localjp.d;
        } else {
          paramInt = localjp.f;
        }
        localjp.b = paramInt;
        return;
      }
      localjp.a = localjp.e;
      localjp.b = localjp.f;
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    a locala = this.q;
    if ((locala != null) && (locala.b != null)) {
      localSavedState.a = this.q.b.getItemId();
    }
    localSavedState.d = a();
    return localSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getActionMasked();
    if (i1 == 0) {
      this.H = false;
    }
    if (!this.H)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      if ((i1 == 0) && (!bool)) {
        this.H = true;
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.H = false;
    }
    return true;
  }
  
  public void setCollapsible(boolean paramBoolean)
  {
    this.N = paramBoolean;
    requestLayout();
  }
  
  public void setContentInsetEndWithActions(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -2147483648;
    }
    if (i1 != this.B)
    {
      this.B = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setContentInsetStartWithNavigation(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 0) {
      i1 = -2147483648;
    }
    if (i1 != this.A)
    {
      this.A = i1;
      if (getNavigationIcon() != null) {
        requestLayout();
      }
    }
  }
  
  public void setLogo(int paramInt)
  {
    setLogo(hi.b(getContext(), paramInt));
  }
  
  public void setLogo(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      h();
      if (!d(this.u)) {
        a(this.u, true);
      }
    }
    else
    {
      localImageView = this.u;
      if ((localImageView != null) && (d(localImageView)))
      {
        removeView(this.u);
        this.n.remove(this.u);
      }
    }
    ImageView localImageView = this.u;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setLogoDescription(int paramInt)
  {
    setLogoDescription(getContext().getText(paramInt));
  }
  
  public void setLogoDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      h();
    }
    ImageView localImageView = this.u;
    if (localImageView != null) {
      localImageView.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationContentDescription(int paramInt)
  {
    CharSequence localCharSequence;
    if (paramInt != 0) {
      localCharSequence = getContext().getText(paramInt);
    } else {
      localCharSequence = null;
    }
    setNavigationContentDescription(localCharSequence);
  }
  
  public void setNavigationContentDescription(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence)) {
      j();
    }
    ImageButton localImageButton = this.t;
    if (localImageButton != null) {
      localImageButton.setContentDescription(paramCharSequence);
    }
  }
  
  public void setNavigationIcon(int paramInt)
  {
    setNavigationIcon(hi.b(getContext(), paramInt));
  }
  
  public void setNavigationIcon(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      j();
      if (!d(this.t)) {
        a(this.t, true);
      }
    }
    else
    {
      localImageButton = this.t;
      if ((localImageButton != null) && (d(localImageButton)))
      {
        removeView(this.t);
        this.n.remove(this.t);
      }
    }
    ImageButton localImageButton = this.t;
    if (localImageButton != null) {
      localImageButton.setImageDrawable(paramDrawable);
    }
  }
  
  public void setNavigationOnClickListener(View.OnClickListener paramOnClickListener)
  {
    j();
    this.t.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnMenuItemClickListener(b paramb)
  {
    this.o = paramb;
  }
  
  public void setOverflowIcon(Drawable paramDrawable)
  {
    i();
    this.a.setOverflowIcon(paramDrawable);
  }
  
  public void setPopupTheme(int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      if (paramInt == 0)
      {
        this.h = getContext();
        return;
      }
      this.h = new ContextThemeWrapper(getContext(), paramInt);
    }
  }
  
  public void setSubtitle(int paramInt)
  {
    setSubtitle(getContext().getText(paramInt));
  }
  
  public void setSubtitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.c == null)
      {
        localObject = getContext();
        this.c = new AppCompatTextView((Context)localObject);
        this.c.setSingleLine();
        this.c.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.k;
        if (i1 != 0) {
          this.c.setTextAppearance((Context)localObject, i1);
        }
        i1 = this.G;
        if (i1 != 0) {
          this.c.setTextColor(i1);
        }
      }
      if (!d(this.c)) {
        a(this.c, true);
      }
    }
    else
    {
      localObject = this.c;
      if ((localObject != null) && (d((View)localObject)))
      {
        removeView(this.c);
        this.n.remove(this.c);
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.E = paramCharSequence;
  }
  
  public void setSubtitleTextColor(int paramInt)
  {
    this.G = paramInt;
    TextView localTextView = this.c;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public void setTitle(int paramInt)
  {
    setTitle(getContext().getText(paramInt));
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      if (this.b == null)
      {
        localObject = getContext();
        this.b = new AppCompatTextView((Context)localObject);
        this.b.setSingleLine();
        this.b.setEllipsize(TextUtils.TruncateAt.END);
        int i1 = this.j;
        if (i1 != 0) {
          this.b.setTextAppearance((Context)localObject, i1);
        }
        i1 = this.F;
        if (i1 != 0) {
          this.b.setTextColor(i1);
        }
      }
      if (!d(this.b)) {
        a(this.b, true);
      }
    }
    else
    {
      localObject = this.b;
      if ((localObject != null) && (d((View)localObject)))
      {
        removeView(this.b);
        this.n.remove(this.b);
      }
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((TextView)localObject).setText(paramCharSequence);
    }
    this.D = paramCharSequence;
  }
  
  public void setTitleMarginBottom(int paramInt)
  {
    this.z = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginEnd(int paramInt)
  {
    this.x = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginStart(int paramInt)
  {
    this.w = paramInt;
    requestLayout();
  }
  
  public void setTitleMarginTop(int paramInt)
  {
    this.y = paramInt;
    requestLayout();
  }
  
  public void setTitleTextColor(int paramInt)
  {
    this.F = paramInt;
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextColor(paramInt);
    }
  }
  
  public static class LayoutParams
    extends ActionBar.LayoutParams
  {
    int b = 0;
    
    public LayoutParams()
    {
      this.a = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(ActionBar.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.b = paramLayoutParams.b;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
      this.leftMargin = paramMarginLayoutParams.leftMargin;
      this.topMargin = paramMarginLayoutParams.topMargin;
      this.rightMargin = paramMarginLayoutParams.rightMargin;
      this.bottomMargin = paramMarginLayoutParams.bottomMargin;
    }
  }
  
  public static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int a;
    boolean d;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.a = paramParcel.readInt();
      boolean bool;
      if (paramParcel.readInt() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.d = bool;
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
  }
  
  public final class a
    implements ik
  {
    id a;
    public if b;
    
    public a() {}
    
    public final void a(Context paramContext, id paramid)
    {
      paramContext = this.a;
      if (paramContext != null)
      {
        if localif = this.b;
        if (localif != null) {
          paramContext.b(localif);
        }
      }
      this.a = paramid;
    }
    
    public final void a(id paramid, boolean paramBoolean) {}
    
    public final void a(ik.a parama) {}
    
    public final boolean a()
    {
      return false;
    }
    
    public final boolean a(iq paramiq)
    {
      return false;
    }
    
    public final void b(boolean paramBoolean)
    {
      if (this.b != null)
      {
        id localid = this.a;
        int k = 0;
        int j = k;
        if (localid != null)
        {
          int m = localid.size();
          int i = 0;
          for (;;)
          {
            j = k;
            if (i >= m) {
              break;
            }
            if (this.a.getItem(i) == this.b)
            {
              j = 1;
              break;
            }
            i += 1;
          }
        }
        if (j == 0) {
          c(this.b);
        }
      }
    }
    
    public final boolean b(if paramif)
    {
      Object localObject1 = Toolbar.this;
      if (((Toolbar)localObject1).f == null)
      {
        ((Toolbar)localObject1).f = new AppCompatImageButton(((Toolbar)localObject1).getContext(), null, hg.a.toolbarNavigationButtonStyle);
        ((Toolbar)localObject1).f.setImageDrawable(((Toolbar)localObject1).d);
        ((Toolbar)localObject1).f.setContentDescription(((Toolbar)localObject1).e);
        localObject2 = new Toolbar.LayoutParams();
        ((Toolbar.LayoutParams)localObject2).a = (((Toolbar)localObject1).l & 0x70 | 0x800003);
        ((Toolbar.LayoutParams)localObject2).b = 2;
        ((Toolbar)localObject1).f.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((Toolbar)localObject1).f.setOnClickListener(new Toolbar.3((Toolbar)localObject1));
      }
      localObject1 = Toolbar.this.f.getParent();
      Object localObject2 = Toolbar.this;
      if (localObject1 != localObject2)
      {
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(((Toolbar)localObject2).f);
        }
        localObject1 = Toolbar.this;
        ((Toolbar)localObject1).addView(((Toolbar)localObject1).f);
      }
      Toolbar.this.g = paramif.getActionView();
      this.b = paramif;
      localObject1 = Toolbar.this.g.getParent();
      localObject2 = Toolbar.this;
      if (localObject1 != localObject2)
      {
        if ((localObject1 instanceof ViewGroup)) {
          ((ViewGroup)localObject1).removeView(((Toolbar)localObject2).g);
        }
        localObject1 = Toolbar.e();
        ((Toolbar.LayoutParams)localObject1).a = (Toolbar.this.l & 0x70 | 0x800003);
        ((Toolbar.LayoutParams)localObject1).b = 2;
        Toolbar.this.g.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject1 = Toolbar.this;
        ((Toolbar)localObject1).addView(((Toolbar)localObject1).g);
      }
      localObject1 = Toolbar.this;
      int i = ((Toolbar)localObject1).getChildCount() - 1;
      while (i >= 0)
      {
        localObject2 = ((Toolbar)localObject1).getChildAt(i);
        if ((((Toolbar.LayoutParams)((View)localObject2).getLayoutParams()).b != 2) && (localObject2 != ((Toolbar)localObject1).a))
        {
          ((Toolbar)localObject1).removeViewAt(i);
          ((Toolbar)localObject1).n.add(localObject2);
        }
        i -= 1;
      }
      Toolbar.this.requestLayout();
      paramif.d(true);
      if ((Toolbar.this.g instanceof hp)) {
        ((hp)Toolbar.this.g).a();
      }
      return true;
    }
    
    public final boolean c(if paramif)
    {
      if ((Toolbar.this.g instanceof hp)) {
        ((hp)Toolbar.this.g).b();
      }
      Toolbar localToolbar = Toolbar.this;
      localToolbar.removeView(localToolbar.g);
      localToolbar = Toolbar.this;
      localToolbar.removeView(localToolbar.f);
      localToolbar = Toolbar.this;
      localToolbar.g = null;
      localToolbar.f();
      this.b = null;
      Toolbar.this.requestLayout();
      paramif.d(false);
      return true;
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a(MenuItem paramMenuItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v7.widget.Toolbar
 * JD-Core Version:    0.7.0.1
 */