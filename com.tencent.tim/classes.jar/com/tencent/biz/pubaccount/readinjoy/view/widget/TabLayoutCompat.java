package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqcx;
import atau.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import nsc;
import nsd;
import nse;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final int[] ATTRS = { 16842901, 16842904 };
  private static final Pools.Pool<d> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private ValueAnimator I;
  private final SlidingTabStrip jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip;
  private TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b;
  private c jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c;
  private d jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d;
  private f jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$f;
  ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private boolean aun;
  private boolean auo;
  private final Pools.Pool<TabView> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private PagerAdapter jdField_b_of_type_AndroidSupportV4ViewPagerAdapter;
  private b jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b;
  int bbF;
  int bbG;
  int bbH;
  int bbI;
  int bbJ;
  int bbK;
  int bbL = 2147483647;
  private final int bbM;
  private final int bbN;
  private int bbO;
  private int bbP;
  private int bbQ;
  int bbR;
  ColorStateList c;
  private final ArrayList<b> lQ = new ArrayList();
  float lc;
  float ld;
  int mMode;
  private final ArrayList<d> mTabs = new ArrayList();
  
  public TabLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip = new SlidingTabStrip(paramContext);
    super.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.ua(aqcx.dip2px(paramContext, 2.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.tZ(-1);
    this.bbI = 0;
    this.bbH = 0;
    this.bbG = 0;
    this.bbF = 0;
    this.bbF = 0;
    this.bbG = 0;
    this.bbH = 0;
    this.bbI = 0;
    this.lc = aqcx.sp2px(paramContext, 12.0F);
    this.c = ColorStateList.valueOf(-1979711488);
    this.bbK = 0;
    this.bbP = 0;
    this.bbQ = 0;
    this.mMode = 1;
    this.bbR = 1;
    this.ld = aqcx.dip2px(paramContext, 12.0F);
    this.bbO = aqcx.dip2px(paramContext, 72.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, atau.a.ss);
    this.bbM = paramContext.getDimensionPixelSize(7, -1);
    this.bbN = paramContext.getDimensionPixelSize(6, -1);
    this.bbF = paramContext.getDimensionPixelSize(12, 0);
    this.bbH = paramContext.getDimensionPixelSize(11, 0);
    this.bbP = paramContext.getDimensionPixelSize(2, 0);
    this.bbQ = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    bay();
  }
  
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabView a(@NonNull d paramd)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool != null) {}
    for (TabView localTabView1 = (TabView)this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.acquire();; localTabView1 = null)
    {
      TabView localTabView2 = localTabView1;
      if (localTabView1 == null) {
        localTabView2 = new TabView(getContext());
      }
      localTabView2.j(paramd);
      localTabView2.setFocusable(true);
      localTabView2.setMinimumWidth(qR());
      return localTabView2;
    }
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.mMode == 1) && (this.bbR == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = qR();
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(d paramd, int paramInt)
  {
    paramd.setPosition(paramInt);
    this.mTabs.add(paramInt, paramd);
    int i = this.mTabs.size();
    paramInt += 1;
    while (paramInt < i)
    {
      ((d)this.mTabs.get(paramInt)).setPosition(paramInt);
      paramInt += 1;
    }
  }
  
  private void a(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.removeOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a);
      }
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b != null)
    {
      b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.reset();
      paramViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b = new e(paramViewPagerCompat);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b);
      PagerAdapter localPagerAdapter = paramViewPagerCompat.getAdapter();
      if (localPagerAdapter != null) {
        a(localPagerAdapter, paramBoolean1);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a = new a();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a.qb(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$a);
      setScrollPosition(paramViewPagerCompat.getCurrentItem(), 0.0F, true);
    }
    for (;;)
    {
      this.aun = paramBoolean2;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = null;
      a(null, false);
    }
  }
  
  private void animateToTab(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.FY()))
    {
      setScrollPosition(paramInt, 0.0F, true);
      return;
    }
    int i = getScrollX();
    int j = b(paramInt, 0.0F);
    if (i != j)
    {
      bax();
      this.I.setIntValues(new int[] { i, j });
      this.I.start();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.dq(paramInt, 300);
  }
  
  private int b(int paramInt, float paramFloat)
  {
    int i = 0;
    int j = 0;
    View localView2;
    View localView1;
    if (this.mMode == 0)
    {
      localView2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
      if (paramInt + 1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount()) {
        break label120;
      }
      localView1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt + 1);
      if (localView2 == null) {
        break label126;
      }
      paramInt = localView2.getWidth();
      label58:
      if (localView2 == null) {
        break label131;
      }
    }
    label131:
    for (i = localView2.getLeft();; i = 0)
    {
      if (localView1 != null) {
        j = localView1.getWidth();
      }
      i = i + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((j + paramInt) * 0.5F * paramFloat);
      if (ViewCompat.getLayoutDirection(this) != 0) {
        break label136;
      }
      i = paramInt + i;
      return i;
      label120:
      localView1 = null;
      break;
      label126:
      paramInt = 0;
      break label58;
    }
    label136:
    return i - paramInt;
  }
  
  private void baw()
  {
    Iterator localIterator = this.mTabs.iterator();
    while (localIterator.hasNext()) {
      ((d)localIterator.next()).updateView();
    }
  }
  
  private void bax()
  {
    if (this.I == null)
    {
      this.I = new ValueAnimator();
      this.I.setInterpolator(new FastOutSlowInInterpolator());
      this.I.setDuration(300L);
      this.I.addUpdateListener(new nsc(this));
    }
  }
  
  private void bay()
  {
    int j = this.bbP;
    int i = this.bbQ;
    if (this.mMode == 0)
    {
      j = Math.max(0, this.bbP - this.bbF);
      i = Math.max(0, this.bbQ - this.bbH);
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip, j, 0, i, 0);
    switch (this.mMode)
    {
    }
    for (;;)
    {
      qa(true);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.setGravity(1);
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.setGravity(8388611);
    }
  }
  
  private void e(d paramd)
  {
    TabView localTabView = paramd.a;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.addView(localTabView, paramd.getPosition(), a());
  }
  
  private void g(@NonNull d paramd)
  {
    int i = this.lQ.size() - 1;
    while (i >= 0)
    {
      ((b)this.lQ.get(i)).a(paramd);
      i -= 1;
    }
  }
  
  private int getDefaultHeight()
  {
    int j = this.mTabs.size();
    int i = 0;
    if (i < j)
    {
      d locald = (d)this.mTabs.get(i);
      if ((locald == null) || (locald.getIcon() == null) || (TextUtils.isEmpty(locald.getText()))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        return 72;
        i += 1;
        break;
      }
      return 48;
    }
  }
  
  private void h(@NonNull d paramd)
  {
    int i = this.lQ.size() - 1;
    while (i >= 0)
    {
      ((b)this.lQ.get(i)).b(paramd);
      i -= 1;
    }
  }
  
  private void i(@NonNull d paramd)
  {
    int i = this.lQ.size() - 1;
    while (i >= 0)
    {
      ((b)this.lQ.get(i)).c(paramd);
      i -= 1;
    }
  }
  
  private int qQ()
  {
    return Math.max(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private int qR()
  {
    if (this.bbM != -1) {
      return this.bbM;
    }
    if (this.mMode == 0) {
      return this.bbO;
    }
    return 0;
  }
  
  private void tX(int paramInt)
  {
    TabView localTabView = (TabView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.reset();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localTabView);
    }
    requestLayout();
  }
  
  private void tY(int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount();
    if (paramInt < j)
    {
      int i = 0;
      if (i < j)
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i);
        if (i == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i += 1;
          break;
        }
      }
    }
  }
  
  @NonNull
  public d a()
  {
    d locald2 = (d)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    d locald1 = locald2;
    if (locald2 == null) {
      locald1 = new d();
    }
    locald1.d = this;
    locald1.a = a(locald1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$f != null) {
      locald1.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$f.e(locald1.a));
    }
    return locald1;
  }
  
  @Nullable
  public d a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getTabCount())) {
      return null;
    }
    return (d)this.mTabs.get(paramInt);
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = Math.round(paramInt + paramFloat);
    if ((i < 0) || (i >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.j(paramInt, paramFloat);
      }
      if ((this.I != null) && (this.I.isRunning())) {
        this.I.cancel();
      }
      scrollTo(b(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    tY(i);
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c != null)) {
      this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c);
    }
    this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c = new c();
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c.qb(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$c);
    }
    bav();
  }
  
  public void a(@NonNull b paramb)
  {
    if (!this.lQ.contains(paramb)) {
      this.lQ.add(paramb);
    }
  }
  
  public void a(@NonNull d paramd, int paramInt, boolean paramBoolean)
  {
    if (paramd.d != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramd, paramInt);
    e(paramd);
    if (paramBoolean) {
      paramd.select();
    }
  }
  
  public void a(@NonNull d paramd, boolean paramBoolean)
  {
    a(paramd, this.mTabs.size(), paramBoolean);
  }
  
  public void addView(View paramView)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void b(@NonNull b paramb)
  {
    this.lQ.remove(paramb);
  }
  
  void b(d paramd, boolean paramBoolean)
  {
    d locald = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d;
    if (locald == paramd)
    {
      if (locald != null)
      {
        i(paramd);
        animateToTab(paramd.getPosition());
      }
      return;
    }
    int i;
    if (paramd != null)
    {
      i = paramd.getPosition();
      label40:
      if (paramBoolean)
      {
        if (((locald != null) && (locald.getPosition() != -1)) || (i == -1)) {
          break label111;
        }
        setScrollPosition(i, 0.0F, true);
      }
    }
    for (;;)
    {
      if (i != -1) {
        tY(i);
      }
      if (locald != null) {
        h(locald);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d = paramd;
      if (paramd == null) {
        break;
      }
      g(paramd);
      return;
      i = -1;
      break label40;
      label111:
      animateToTab(i);
    }
  }
  
  void bav()
  {
    removeAllTabs();
    if (this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      int j = this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      int i = 0;
      while (i < j)
      {
        a(a().a(this.jdField_b_of_type_AndroidSupportV4ViewPagerAdapter.getPageTitle(i)), false);
        i += 1;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) && (j > 0))
      {
        i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
        if ((i != qP()) && (i < getTabCount())) {
          f(a(i));
        }
      }
    }
  }
  
  void c(d paramd, boolean paramBoolean)
  {
    d locald = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d;
    if (locald == paramd)
    {
      if (locald != null) {
        animateToTab(paramd.getPosition());
      }
      return;
    }
    int i;
    if (paramd != null)
    {
      i = paramd.getPosition();
      if (paramBoolean)
      {
        if (((locald != null) && (locald.getPosition() != -1)) || (i == -1)) {
          break label86;
        }
        setScrollPosition(i, 0.0F, true);
      }
    }
    for (;;)
    {
      if (i != -1) {
        tY(i);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d = paramd;
      return;
      i = -1;
      break;
      label86:
      animateToTab(i);
    }
  }
  
  public void d(@NonNull d paramd)
  {
    a(paramd, this.mTabs.isEmpty());
  }
  
  int dpToPx(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  void f(d paramd)
  {
    b(paramd, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getTabCount()
  {
    return this.mTabs.size();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPagerCompat)) {
        a((ViewPagerCompat)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.aun)
    {
      setupWithViewPager(null);
      this.aun = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = dpToPx(getDefaultHeight()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.bbN > 0)
        {
          i = this.bbN;
          this.bbL = i;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == 1)
        {
          localView = getChildAt(0);
          switch (this.mMode)
          {
          default: 
            paramInt1 = 0;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      break;
      i -= dpToPx(56);
      break label76;
      if (localView.getMeasuredWidth() < getMeasuredWidth()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth()) {}
    for (paramInt1 = j;; paramInt1 = 0) {
      break;
    }
  }
  
  public int qP()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d.getPosition();
    }
    return -1;
  }
  
  int qS()
  {
    return this.bbL;
  }
  
  void qa(boolean paramBoolean)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i);
      localView.setMinimumWidth(qR());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i += 1;
    }
  }
  
  public void removeAllTabs()
  {
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount() - 1;
    while (i >= 0)
    {
      tX(i);
      i -= 1;
    }
    Iterator localIterator = this.mTabs.iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      localIterator.remove();
      locald.reset();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(locald);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$d = null;
  }
  
  public void setCutomViewBeRelated(boolean paramBoolean)
  {
    this.auo = paramBoolean;
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable b paramb)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b != null) {
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$b = paramb;
    if (paramb != null) {
      a(paramb);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollableTabMinWidth(int paramInt)
  {
    this.bbO = paramInt;
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.tZ(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.ua(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.ud(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.ub(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.uc(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.bbK != paramInt)
    {
      this.bbK = paramInt;
      Iterator localIterator = this.mTabs.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if (locald.a != null) {
          locald.a.setBackgroundResource(this.bbK);
        }
      }
    }
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.bbR != paramInt)
    {
      this.bbR = paramInt;
      bay();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.mMode)
    {
      this.mMode = paramInt;
      bay();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.c != paramColorStateList)
    {
      this.c = paramColorStateList;
      baw();
    }
  }
  
  public void setTabTextSize(int paramInt)
  {
    if (this.lc != paramInt)
    {
      this.lc = paramInt;
      Iterator localIterator = this.mTabs.iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        if ((locald.a != null) && (TabView.a(locald.a) != null)) {
          TabView.a(locald.a).setTextSize(this.lc);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(f paramf)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$f = paramf;
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat)
  {
    setupWithViewPager(paramViewPagerCompat, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean)
  {
    a(paramViewPagerCompat, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return qQ() > 0;
  }
  
  public class SlidingTabStrip
    extends LinearLayout
  {
    private ValueAnimator J;
    private final Paint aP;
    private int bbS;
    private int bbT = -1;
    private int bbU = -1;
    private int bbV;
    private int bbW;
    private int bbX;
    public float le;
    private int mLayoutDirection = -1;
    public int mSelectedPosition = -1;
    
    SlidingTabStrip(Context paramContext)
    {
      super();
      setWillNotDraw(false);
      this.aP = new Paint();
    }
    
    private void baA()
    {
      View localView = getChildAt(this.mSelectedPosition);
      int i;
      int j;
      if ((localView != null) && (localView.getWidth() > 0))
      {
        int m = localView.getLeft();
        int k = localView.getRight();
        i = k;
        j = m;
        if (this.le > 0.0F)
        {
          i = k;
          j = m;
          if (this.mSelectedPosition < getChildCount() - 1)
          {
            localView = getChildAt(this.mSelectedPosition + 1);
            float f1 = this.le;
            float f2 = localView.getLeft();
            float f3 = this.le;
            j = (int)(m * (1.0F - f3) + f1 * f2);
            f1 = this.le;
            f2 = localView.getRight();
            f3 = this.le;
            i = (int)(k * (1.0F - f3) + f2 * f1);
          }
        }
      }
      for (;;)
      {
        dp(j, i);
        return;
        i = -1;
        j = -1;
      }
    }
    
    boolean FY()
    {
      boolean bool2 = false;
      int j = getChildCount();
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < j)
        {
          if (getChildAt(i).getWidth() <= 0) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    
    public void dp(int paramInt1, int paramInt2)
    {
      if ((paramInt1 != this.bbT) || (paramInt2 != this.bbU))
      {
        this.bbT = paramInt1;
        this.bbU = paramInt2;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void dq(int paramInt1, int paramInt2)
    {
      if ((this.J != null) && (this.J.isRunning())) {
        this.J.cancel();
      }
      int i;
      Object localObject;
      if (ViewCompat.getLayoutDirection(this) == 1)
      {
        i = 1;
        localObject = getChildAt(paramInt1);
        if (localObject != null) {
          break label56;
        }
        baA();
      }
      for (;;)
      {
        return;
        i = 0;
        break;
        label56:
        int k = ((View)localObject).getLeft();
        int m = ((View)localObject).getRight();
        int j;
        if (Math.abs(paramInt1 - this.mSelectedPosition) <= 1)
        {
          i = this.bbT;
          j = this.bbU;
        }
        while ((i != k) || (j != m))
        {
          localObject = new ValueAnimator();
          this.J = ((ValueAnimator)localObject);
          ((ValueAnimator)localObject).setInterpolator(new FastOutSlowInInterpolator());
          ((ValueAnimator)localObject).setDuration(paramInt2);
          ((ValueAnimator)localObject).setFloatValues(new float[] { 0.0F, 1.0F });
          ((ValueAnimator)localObject).addUpdateListener(new nsd(this, i, k, j, m));
          ((ValueAnimator)localObject).addListener(new nse(this, paramInt1));
          ((ValueAnimator)localObject).start();
          return;
          j = TabLayoutCompat.this.dpToPx(24);
          if (paramInt1 < this.mSelectedPosition)
          {
            if (i != 0)
            {
              j = k - j;
              i = j;
            }
            else
            {
              j = m + j;
              i = j;
            }
          }
          else if (i != 0)
          {
            j = m + j;
            i = j;
          }
          else
          {
            j = k - j;
            i = j;
          }
        }
      }
    }
    
    public void draw(Canvas paramCanvas)
    {
      super.draw(paramCanvas);
      if ((this.bbT >= 0) && (this.bbU > this.bbT)) {
        paramCanvas.drawRect(this.bbT + this.bbV, getHeight() - this.bbS - this.bbX, this.bbU - this.bbW, getHeight() - this.bbX, this.aP);
      }
    }
    
    void j(int paramInt, float paramFloat)
    {
      if ((this.J != null) && (this.J.isRunning())) {
        this.J.cancel();
      }
      this.mSelectedPosition = paramInt;
      this.le = paramFloat;
      baA();
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((this.J != null) && (this.J.isRunning()))
      {
        this.J.cancel();
        long l = this.J.getDuration();
        paramInt1 = this.mSelectedPosition;
        float f = this.J.getAnimatedFraction();
        dq(paramInt1, Math.round((float)l * (1.0F - f)));
        return;
      }
      baA();
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      int m = 0;
      super.onMeasure(paramInt1, paramInt2);
      if (View.MeasureSpec.getMode(paramInt1) != 1073741824) {
        break label18;
      }
      label18:
      while ((TabLayoutCompat.this.mMode != 1) || (TabLayoutCompat.this.bbR != 1)) {
        return;
      }
      int n = getChildCount();
      int k = 0;
      int j = 0;
      label53:
      Object localObject;
      if (k < n)
      {
        localObject = getChildAt(k);
        if (((View)localObject).getVisibility() != 0) {
          break label238;
        }
      }
      label136:
      label223:
      label235:
      label238:
      for (int i = Math.max(j, ((View)localObject).getMeasuredWidth());; i = j)
      {
        k += 1;
        j = i;
        break label53;
        if (j <= 0) {
          break;
        }
        i = TabLayoutCompat.this.dpToPx(16);
        if (j * n <= getMeasuredWidth() - i * 2)
        {
          k = 0;
          i = m;
          m = i;
          if (k >= n) {
            break label223;
          }
          localObject = (LinearLayout.LayoutParams)getChildAt(k).getLayoutParams();
          if ((((LinearLayout.LayoutParams)localObject).width == j) && (((LinearLayout.LayoutParams)localObject).weight == 0.0F)) {
            break label235;
          }
          ((LinearLayout.LayoutParams)localObject).width = j;
          ((LinearLayout.LayoutParams)localObject).weight = 0.0F;
          i = 1;
        }
        for (;;)
        {
          k += 1;
          break label136;
          TabLayoutCompat.this.bbR = 0;
          TabLayoutCompat.this.qa(false);
          m = 1;
          if (m == 0) {
            break;
          }
          super.onMeasure(paramInt1, paramInt2);
          return;
        }
      }
    }
    
    public void onRtlPropertiesChanged(int paramInt)
    {
      super.onRtlPropertiesChanged(paramInt);
      if ((Build.VERSION.SDK_INT < 23) && (this.mLayoutDirection != paramInt))
      {
        requestLayout();
        this.mLayoutDirection = paramInt;
      }
    }
    
    void tZ(int paramInt)
    {
      if (this.aP.getColor() != paramInt)
      {
        this.aP.setColor(paramInt);
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void ua(int paramInt)
    {
      if (this.bbS != paramInt)
      {
        this.bbS = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    void ub(int paramInt)
    {
      if (this.bbV != paramInt)
      {
        this.bbV = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    public void uc(int paramInt)
    {
      if (this.bbW != paramInt)
      {
        this.bbW = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
    
    public void ud(int paramInt)
    {
      if (this.bbX != paramInt)
      {
        this.bbX = paramInt;
        ViewCompat.postInvalidateOnAnimation(this);
      }
    }
  }
  
  public static class TabLayoutOnPageChangeListener
    implements ViewPager.OnPageChangeListener
  {
    private int bcc;
    private final WeakReference<TabLayoutCompat> cz;
    private int mScrollState;
    
    public TabLayoutOnPageChangeListener(TabLayoutCompat paramTabLayoutCompat)
    {
      this.cz = new WeakReference(paramTabLayoutCompat);
    }
    
    public void onPageScrollStateChanged(int paramInt)
    {
      this.bcc = this.mScrollState;
      this.mScrollState = paramInt;
    }
    
    public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
    {
      boolean bool2 = false;
      TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.cz.get();
      if (localTabLayoutCompat != null) {
        if ((this.mScrollState == 2) && (this.bcc != 1)) {
          break label69;
        }
      }
      label69:
      for (boolean bool1 = true;; bool1 = false)
      {
        if ((this.mScrollState != 2) || (this.bcc != 0)) {
          bool2 = true;
        }
        localTabLayoutCompat.a(paramInt1, paramFloat, bool1, bool2);
        return;
      }
    }
    
    public void onPageSelected(int paramInt)
    {
      TabLayoutCompat localTabLayoutCompat = (TabLayoutCompat)this.cz.get();
      if ((localTabLayoutCompat != null) && (localTabLayoutCompat.qP() != paramInt) && (paramInt < localTabLayoutCompat.getTabCount())) {
        if ((this.mScrollState != 0) && ((this.mScrollState != 2) || (this.bcc != 0))) {
          break label105;
        }
      }
      label105:
      for (boolean bool = true;; bool = false)
      {
        TabLayoutCompat.d locald1 = TabLayoutCompat.a(localTabLayoutCompat);
        localTabLayoutCompat.b(localTabLayoutCompat.a(paramInt), bool);
        TabLayoutCompat.d locald2 = localTabLayoutCompat.a(paramInt);
        if ((TabLayoutCompat.a(localTabLayoutCompat) != null) && (locald2 != null)) {
          TabLayoutCompat.a(localTabLayoutCompat).a(locald2, locald1, 0);
        }
        return;
      }
    }
    
    void reset()
    {
      this.mScrollState = 0;
      this.bcc = 0;
    }
  }
  
  class TabView
    extends LinearLayout
  {
    private TabLayoutCompat.d b;
    private int bcd = 2;
    private ImageView kX;
    private View mCustomView;
    private ImageView mIconView;
    private TextView mTextView;
    private TextView tI;
    
    public TabView(Context paramContext)
    {
      super();
      if ((TabLayoutCompat.this.bbK != 0) && (paramContext != null)) {
        setBackgroundDrawable(paramContext.getResources().getDrawable(TabLayoutCompat.this.bbK));
      }
      ViewCompat.setPaddingRelative(this, TabLayoutCompat.this.bbF, TabLayoutCompat.this.bbG, TabLayoutCompat.this.bbH, TabLayoutCompat.this.bbI);
      setGravity(17);
      setOrientation(1);
      setClickable(true);
    }
    
    private float a(Layout paramLayout, int paramInt, float paramFloat)
    {
      return paramLayout.getLineWidth(paramInt) * (paramFloat / paramLayout.getPaint().getTextSize());
    }
    
    private void a(@Nullable TextView paramTextView, @Nullable ImageView paramImageView)
    {
      Drawable localDrawable;
      CharSequence localCharSequence1;
      label32:
      CharSequence localCharSequence2;
      if (this.b != null)
      {
        localDrawable = this.b.getIcon();
        if (this.b == null) {
          break label176;
        }
        localCharSequence1 = this.b.getText();
        if (this.b == null) {
          break label182;
        }
        localCharSequence2 = this.b.getContentDescription();
        label48:
        if (paramImageView != null)
        {
          if (localDrawable == null) {
            break label188;
          }
          paramImageView.setImageDrawable(localDrawable);
          paramImageView.setVisibility(0);
          setVisibility(0);
          label73:
          paramImageView.setContentDescription(localCharSequence2);
        }
        if (TextUtils.isEmpty(localCharSequence1)) {
          break label202;
        }
        i = 1;
        label89:
        if (paramTextView != null)
        {
          if (i == 0) {
            break label207;
          }
          paramTextView.setText(localCharSequence1);
          paramTextView.setVisibility(0);
          setVisibility(0);
          label113:
          paramTextView.setContentDescription(localCharSequence2);
        }
        if (paramImageView != null)
        {
          paramTextView = (ViewGroup.MarginLayoutParams)paramImageView.getLayoutParams();
          if ((i == 0) || (paramImageView.getVisibility() != 0)) {
            break label221;
          }
        }
      }
      label176:
      label182:
      label188:
      label202:
      label207:
      label221:
      for (int i = TabLayoutCompat.this.dpToPx(8);; i = 0)
      {
        if (i != paramTextView.bottomMargin)
        {
          paramTextView.bottomMargin = i;
          paramImageView.requestLayout();
        }
        return;
        localDrawable = null;
        break;
        localCharSequence1 = null;
        break label32;
        localCharSequence2 = null;
        break label48;
        paramImageView.setVisibility(8);
        paramImageView.setImageDrawable(null);
        break label73;
        i = 0;
        break label89;
        paramTextView.setVisibility(8);
        paramTextView.setText(null);
        break label113;
      }
    }
    
    void j(@Nullable TabLayoutCompat.d paramd)
    {
      if (paramd != this.b)
      {
        this.b = paramd;
        update();
      }
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    }
    
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    }
    
    public void onMeasure(int paramInt1, int paramInt2)
    {
      int k = 1;
      int j = View.MeasureSpec.getSize(paramInt1);
      int m = View.MeasureSpec.getMode(paramInt1);
      int n = TabLayoutCompat.this.qS();
      int i = paramInt1;
      if (n > 0) {
        if (m != 0)
        {
          i = paramInt1;
          if (j <= n) {}
        }
        else
        {
          i = View.MeasureSpec.makeMeasureSpec(TabLayoutCompat.this.bbL, -2147483648);
        }
      }
      super.onMeasure(i, paramInt2);
      float f2;
      float f1;
      if (this.mTextView != null)
      {
        getResources();
        f2 = TabLayoutCompat.this.lc;
        j = this.bcd;
        if ((this.mIconView == null) || (this.mIconView.getVisibility() != 0)) {
          break label284;
        }
        paramInt1 = 1;
        f1 = f2;
        f2 = this.mTextView.getTextSize();
        m = this.mTextView.getLineCount();
        if (Build.VERSION.SDK_INT < 16) {
          break label328;
        }
      }
      label284:
      label328:
      for (j = this.mTextView.getMaxLines();; j = -1)
      {
        if ((f1 != f2) || ((j >= 0) && (paramInt1 != j)))
        {
          j = k;
          if (TabLayoutCompat.this.mMode == 1)
          {
            j = k;
            if (f1 > f2)
            {
              j = k;
              if (m == 1)
              {
                Layout localLayout = this.mTextView.getLayout();
                if (localLayout != null)
                {
                  j = k;
                  if (a(localLayout, 0, f1) <= getMeasuredWidth() - getPaddingLeft() - getPaddingRight()) {}
                }
                else
                {
                  j = 0;
                }
              }
            }
          }
          if (j != 0)
          {
            this.mTextView.setTextSize(0, f1);
            this.mTextView.setMaxLines(paramInt1);
            super.onMeasure(i, paramInt2);
          }
        }
        return;
        paramInt1 = j;
        f1 = f2;
        if (this.mTextView == null) {
          break;
        }
        paramInt1 = j;
        f1 = f2;
        if (this.mTextView.getLineCount() <= 1) {
          break;
        }
        f1 = TabLayoutCompat.this.ld;
        paramInt1 = j;
        break;
      }
    }
    
    public boolean performClick()
    {
      int i = 0;
      boolean bool = super.performClick();
      if (this.b != null)
      {
        if (!bool) {
          playSoundEffect(0);
        }
        TabLayoutCompat.d locald = TabLayoutCompat.a(TabLayoutCompat.this);
        if (TabLayoutCompat.a(TabLayoutCompat.this) == this.b) {
          i = 1;
        }
        this.b.select();
        if ((TabLayoutCompat.a(TabLayoutCompat.this) != null) && (i == 0)) {
          TabLayoutCompat.a(TabLayoutCompat.this).a(this.b, locald, 1);
        }
        return true;
      }
      return bool;
    }
    
    void reset()
    {
      j(null);
      setSelected(false);
    }
    
    public void setSelected(boolean paramBoolean)
    {
      if (isSelected() != paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        super.setSelected(paramBoolean);
        if ((i != 0) && (paramBoolean) && (Build.VERSION.SDK_INT < 16)) {
          sendAccessibilityEvent(4);
        }
        if (this.mTextView != null) {
          this.mTextView.setSelected(paramBoolean);
        }
        if (this.mIconView != null) {
          this.mIconView.setSelected(paramBoolean);
        }
        if (this.mCustomView != null) {
          this.mCustomView.setSelected(paramBoolean);
        }
        return;
      }
    }
    
    final void update()
    {
      TabLayoutCompat.d locald = this.b;
      Object localObject;
      if (locald != null)
      {
        localObject = locald.getCustomView();
        if (localObject == null) {
          break label369;
        }
        ViewParent localViewParent = ((View)localObject).getParent();
        if (localViewParent != this)
        {
          if (localViewParent != null) {
            ((ViewGroup)localViewParent).removeView((View)localObject);
          }
          addView((View)localObject);
        }
        this.mCustomView = ((View)localObject);
        if (this.mTextView != null) {
          this.mTextView.setVisibility(8);
        }
        if (this.mIconView != null)
        {
          this.mIconView.setVisibility(8);
          this.mIconView.setImageDrawable(null);
        }
        this.tI = ((TextView)((View)localObject).findViewById(16908308));
        if (this.tI != null)
        {
          if (Build.VERSION.SDK_INT < 16) {
            break label361;
          }
          this.bcd = this.tI.getMaxLines();
        }
        label134:
        this.kX = ((ImageView)((View)localObject).findViewById(16908294));
        label148:
        if (this.mCustomView != null) {
          break label410;
        }
        if (this.mIconView == null)
        {
          localObject = new ImageView(getContext());
          ((ImageView)localObject).setLayoutParams(new ViewGroup.LayoutParams(48, 48));
          addView((View)localObject, 0);
          this.mIconView = ((ImageView)localObject);
        }
        if (this.mTextView == null)
        {
          localObject = new TextView(getContext());
          ((TextView)localObject).setMaxLines(2);
          ((TextView)localObject).setGravity(1);
          ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
          ((TextView)localObject).setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
          addView((View)localObject);
          this.mTextView = ((TextView)localObject);
          if (Build.VERSION.SDK_INT < 16) {
            break label402;
          }
          this.bcd = this.mTextView.getMaxLines();
        }
        label280:
        this.mTextView.setTextAppearance(this.mTextView.getContext(), TabLayoutCompat.this.bbJ);
        if (TabLayoutCompat.this.c != null) {
          this.mTextView.setTextColor(TabLayoutCompat.this.c);
        }
        a(this.mTextView, this.mIconView);
        label337:
        if ((locald == null) || (!locald.isSelected())) {
          break label501;
        }
      }
      label361:
      label369:
      label501:
      for (boolean bool = true;; bool = false)
      {
        setSelected(bool);
        return;
        localObject = null;
        break;
        this.bcd = -1;
        break label134;
        if (this.mCustomView != null)
        {
          removeView(this.mCustomView);
          this.mCustomView = null;
        }
        this.tI = null;
        this.kX = null;
        break label148;
        this.bcd = -1;
        break label280;
        if ((TabLayoutCompat.a(TabLayoutCompat.this)) && (TabLayoutCompat.this.c != null) && (this.tI != null))
        {
          this.tI.setTextAppearance(this.tI.getContext(), TabLayoutCompat.this.bbJ);
          this.tI.setTextColor(TabLayoutCompat.this.c);
        }
        if ((this.tI == null) && (this.kX == null)) {
          break label337;
        }
        a(this.tI, this.kX);
        break label337;
      }
    }
  }
  
  class a
    implements ViewPagerCompat.a
  {
    private boolean aup;
    
    a() {}
    
    public void a(ViewPager paramViewPager, PagerAdapter paramPagerAdapter1, PagerAdapter paramPagerAdapter2)
    {
      if (TabLayoutCompat.this.a == paramViewPager) {
        TabLayoutCompat.this.a(paramPagerAdapter2, this.aup);
      }
    }
    
    void qb(boolean paramBoolean)
    {
      this.aup = paramBoolean;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(TabLayoutCompat.d paramd);
    
    public abstract void b(TabLayoutCompat.d paramd);
    
    public abstract void c(TabLayoutCompat.d paramd);
  }
  
  class c
    extends DataSetObserver
  {
    private boolean aup;
    
    c() {}
    
    void baz()
    {
      if ((TabLayoutCompat.this.a != null) && (TabLayoutCompat.a(TabLayoutCompat.this) != null))
      {
        int i = TabLayoutCompat.this.a.getCurrentItem();
        if (TabLayoutCompat.this.qP() == i) {
          TabLayoutCompat.a(TabLayoutCompat.this).dq(i, 300);
        }
      }
      if (TabLayoutCompat.a(TabLayoutCompat.this) != null) {
        TabLayoutCompat.a(TabLayoutCompat.this).reset();
      }
    }
    
    public void onChanged()
    {
      if (this.aup)
      {
        TabLayoutCompat.this.bav();
        return;
      }
      baz();
    }
    
    public void onInvalidated()
    {
      if (this.aup)
      {
        TabLayoutCompat.this.bav();
        return;
      }
      baz();
    }
    
    void qb(boolean paramBoolean)
    {
      this.aup = paramBoolean;
    }
  }
  
  public static final class d
  {
    TabLayoutCompat.TabView a;
    TabLayoutCompat d;
    private CharSequence mContentDesc;
    private View mCustomView;
    private Drawable mIcon;
    private int mPosition = -1;
    private Object mTag;
    private CharSequence mText;
    
    @NonNull
    public d a(@Nullable View paramView)
    {
      this.mCustomView = paramView;
      updateView();
      return this;
    }
    
    @NonNull
    public d a(@Nullable CharSequence paramCharSequence)
    {
      this.mText = paramCharSequence;
      updateView();
      return this;
    }
    
    @NonNull
    public d a(@Nullable Object paramObject)
    {
      this.mTag = paramObject;
      return this;
    }
    
    @NonNull
    public d b(int paramInt)
    {
      return a(LayoutInflater.from(this.a.getContext()).inflate(paramInt, this.a, false));
    }
    
    public void baB()
    {
      if (this.d == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      this.d.c(this, true);
    }
    
    @Nullable
    public CharSequence getContentDescription()
    {
      return this.mContentDesc;
    }
    
    @Nullable
    public View getCustomView()
    {
      return this.mCustomView;
    }
    
    @Nullable
    public Drawable getIcon()
    {
      return this.mIcon;
    }
    
    public int getPosition()
    {
      return this.mPosition;
    }
    
    @Nullable
    public Object getTag()
    {
      return this.mTag;
    }
    
    @Nullable
    public CharSequence getText()
    {
      return this.mText;
    }
    
    public boolean isSelected()
    {
      if (this.d == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      return this.d.qP() == this.mPosition;
    }
    
    void reset()
    {
      this.d = null;
      this.a = null;
      this.mTag = null;
      this.mIcon = null;
      this.mText = null;
      this.mContentDesc = null;
      this.mPosition = -1;
      this.mCustomView = null;
    }
    
    public void select()
    {
      if (this.d == null) {
        throw new IllegalArgumentException("Tab not attached to a TabLayout");
      }
      this.d.f(this);
    }
    
    void setPosition(int paramInt)
    {
      this.mPosition = paramInt;
    }
    
    void updateView()
    {
      if (this.a != null) {
        this.a.update();
      }
    }
  }
  
  public static class e
    implements TabLayoutCompat.b
  {
    private final ViewPagerCompat a;
    
    public e(ViewPagerCompat paramViewPagerCompat)
    {
      this.a = paramViewPagerCompat;
    }
    
    public void a(TabLayoutCompat.d paramd)
    {
      this.a.setCurrentItem(paramd.getPosition());
    }
    
    public void b(TabLayoutCompat.d paramd) {}
    
    public void c(TabLayoutCompat.d paramd) {}
  }
  
  public static abstract interface f
  {
    public abstract void a(TabLayoutCompat.d paramd1, @Nullable TabLayoutCompat.d paramd2, int paramInt);
    
    public abstract View e(ViewGroup paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */