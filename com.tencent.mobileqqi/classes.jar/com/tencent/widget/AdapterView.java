package com.tencent.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewDebug.CapturedViewProperty;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Adapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import hvo;
import java.lang.reflect.Field;

public abstract class AdapterView
  extends ViewGroup
{
  public static final int aD = -1;
  public static final int an = -1;
  public static final int ao = -2;
  static final int av = 0;
  static final int aw = 1;
  static final int ax = 2;
  static final int ay = 100;
  public static final String b = "XListView";
  public static final long e = -9223372036854775808L;
  public static final boolean m = false;
  private float jdField_a_of_type_Float;
  long jdField_a_of_type_Long = -9223372036854775808L;
  private View jdField_a_of_type_AndroidViewView;
  AdapterView.OnItemLongClickListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener;
  AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  private hvo jdField_a_of_type_Hvo;
  private boolean jdField_a_of_type_Boolean;
  @ViewDebug.ExportedProperty(category="list")
  public int aA = -1;
  @ViewDebug.ExportedProperty(category="list")
  public int aB;
  int aC;
  public int aE = -1;
  @ViewDebug.ExportedProperty(category="scrolling")
  public int ap = 0;
  int aq;
  int ar;
  int as;
  int at;
  int au;
  @ViewDebug.ExportedProperty(category="list")
  int az = -1;
  long jdField_b_of_type_Long;
  AdapterView.OnItemClickListener jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  private boolean jdField_b_of_type_Boolean;
  long c = -9223372036854775808L;
  public long d = -9223372036854775808L;
  long f = -9223372036854775808L;
  public boolean n = false;
  boolean o = false;
  public boolean p;
  boolean q = false;
  
  public AdapterView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AdapterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void A() {}
  
  protected static int a(String paramString)
  {
    try
    {
      int i = Class.forName("com.android.internal.R$styleable").getField(paramString).getInt(null);
      return i;
    }
    catch (Exception paramString) {}
    return -1;
  }
  
  public static void a(String paramString)
  {
    TraceUtils.a(paramString);
  }
  
  private void a(boolean paramBoolean)
  {
    if (a()) {
      paramBoolean = false;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        setVisibility(8);
      }
      for (;;)
      {
        if (this.p) {
          onLayout(false, this.mLeft, this.mTop, this.mRight, this.mBottom);
        }
        return;
        setVisibility(0);
      }
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
    setVisibility(0);
  }
  
  protected static int[] a(String paramString)
  {
    try
    {
      paramString = (int[])Class.forName("com.android.internal.R$styleable").getField(paramString).get(null);
      return paramString;
    }
    catch (Exception paramString) {}
    return new int[0];
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener == null) {
      return;
    }
    int i = p();
    if (i >= 0)
    {
      View localView = a();
      this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener.a_(this, localView, i, a().getItemId(i));
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener.a(this);
  }
  
  private boolean b()
  {
    boolean bool2 = false;
    Adapter localAdapter = a();
    boolean bool1 = bool2;
    if (localAdapter != null)
    {
      int i = localAdapter.getCount();
      bool1 = bool2;
      if (i > 0) {
        if (q() <= 0)
        {
          bool1 = bool2;
          if (r() >= i - 1) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void B_()
  {
    if (this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener != null)
    {
      if ((!this.o) && (!this.q)) {
        break label78;
      }
      if (this.jdField_a_of_type_Hvo == null) {
        this.jdField_a_of_type_Hvo = new hvo(this, null);
      }
      post(this.jdField_a_of_type_Hvo);
    }
    for (;;)
    {
      if ((this.aA != -1) && (isShown()) && (!isInTouchMode())) {
        sendAccessibilityEvent(4);
      }
      return;
      label78:
      b();
    }
  }
  
  protected float a()
  {
    if (this.jdField_a_of_type_Float == 0.0F)
    {
      TypedValue localTypedValue = new TypedValue();
      if (!getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
      }
      this.jdField_a_of_type_Float = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
    }
    return this.jdField_a_of_type_Float;
  }
  
  @ViewDebug.CapturedViewProperty
  public int a()
  {
    return this.aB;
  }
  
  int a(int paramInt, boolean paramBoolean)
  {
    return paramInt;
  }
  
  @ViewDebug.CapturedViewProperty
  public long a()
  {
    return this.c;
  }
  
  public long a(int paramInt)
  {
    Adapter localAdapter = a();
    if ((localAdapter == null) || (paramInt < 0)) {
      return -9223372036854775808L;
    }
    return localAdapter.getItemId(paramInt);
  }
  
  public abstract View a();
  
  public abstract Adapter a();
  
  public final AdapterView.OnItemClickListener a()
  {
    return this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener;
  }
  
  public final AdapterView.OnItemLongClickListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener;
  }
  
  public final AdapterView.OnItemSelectedListener a()
  {
    return this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener;
  }
  
  public Object a()
  {
    Adapter localAdapter = a();
    int i = p();
    if ((localAdapter != null) && (localAdapter.getCount() > 0) && (i >= 0)) {
      return localAdapter.getItem(i);
    }
    return null;
  }
  
  public Object a(int paramInt)
  {
    Adapter localAdapter = a();
    if ((localAdapter == null) || (paramInt < 0)) {
      return null;
    }
    return localAdapter.getItem(paramInt);
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(View paramView, int paramInt, long paramLong)
  {
    boolean bool = false;
    if (this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener != null)
    {
      playSoundEffect(0);
      if (paramView != null) {
        paramView.sendAccessibilityEvent(1);
      }
      this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener.a(this, paramView, paramInt, paramLong);
      bool = true;
    }
    return bool;
  }
  
  public void addView(View paramView)
  {
    throw new UnsupportedOperationException("addView(View) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt)
  {
    throw new UnsupportedOperationException("addView(View, int) is not supported in AdapterView");
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, int, LayoutParams) is not supported in AdapterView");
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    throw new UnsupportedOperationException("addView(View, LayoutParams) is not supported in AdapterView");
  }
  
  public View b()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public int c(View paramView)
  {
    try
    {
      for (;;)
      {
        View localView = (View)paramView.getParent();
        boolean bool = localView.equals(this);
        if (bool) {
          break;
        }
        paramView = localView;
      }
      j = getChildCount();
    }
    catch (ClassCastException paramView)
    {
      return -1;
    }
    int j;
    int i = 0;
    while (i < j)
    {
      if (getChildAt(i).equals(paramView)) {
        return i + this.ap;
      }
      i += 1;
    }
    return -1;
  }
  
  protected boolean canAnimate()
  {
    return (super.canAnimate()) && (this.aB > 0);
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    View localView = a();
    return (localView != null) && (localView.getVisibility() == 0) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent));
  }
  
  protected void dispatchRestoreInstanceState(SparseArray paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void e(int paramInt)
  {
    this.aA = paramInt;
    this.d = a(paramInt);
  }
  
  public void f(int paramInt)
  {
    this.az = paramInt;
    this.c = a(paramInt);
    if ((this.n) && (this.at == 0) && (paramInt >= 0))
    {
      this.as = paramInt;
      this.jdField_a_of_type_Long = this.c;
    }
  }
  
  @TargetApi(14)
  public boolean n()
  {
    if (VersionUtils.d()) {
      for (ViewParent localViewParent = getParent(); (localViewParent != null) && ((localViewParent instanceof ViewGroup)); localViewParent = localViewParent.getParent()) {
        if (((ViewGroup)localViewParent).shouldDelayChildPressedState()) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    removeCallbacks(this.jdField_a_of_type_Hvo);
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setScrollable(b());
    View localView = a();
    if (localView != null) {
      paramAccessibilityEvent.setEnabled(localView.isEnabled());
    }
    paramAccessibilityEvent.setCurrentItemIndex(p());
    paramAccessibilityEvent.setFromIndex(q());
    paramAccessibilityEvent.setToIndex(r());
    paramAccessibilityEvent.setItemCount(a());
  }
  
  @SuppressLint({"NewApi"})
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setScrollable(b());
    View localView = a();
    if (localView != null) {
      paramAccessibilityNodeInfo.setEnabled(localView.isEnabled());
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.au = getHeight();
  }
  
  @SuppressLint({"NewApi"})
  public boolean onRequestSendAccessibilityEvent(View paramView, AccessibilityEvent paramAccessibilityEvent)
  {
    if (super.onRequestSendAccessibilityEvent(paramView, paramAccessibilityEvent))
    {
      AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
      onInitializeAccessibilityEvent(localAccessibilityEvent);
      paramView.dispatchPopulateAccessibilityEvent(localAccessibilityEvent);
      paramAccessibilityEvent.appendRecord(localAccessibilityEvent);
      return true;
    }
    return false;
  }
  
  @ViewDebug.CapturedViewProperty
  public int p()
  {
    return this.az;
  }
  
  void p()
  {
    int i1 = this.aB;
    int i;
    if (i1 > 0) {
      if (this.n)
      {
        this.n = false;
        i = s();
        if ((i >= 0) && (a(i, true) == i))
        {
          f(i);
          i = 1;
          if (i == 0)
          {
            int k = p();
            int j = k;
            if (k >= i1) {
              j = i1 - 1;
            }
            k = j;
            if (j < 0) {
              k = 0;
            }
            j = a(k, true);
            if (j >= 0) {
              break label153;
            }
            j = a(k, false);
            label97:
            if (j >= 0)
            {
              f(j);
              x();
              i = 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        this.aA = -1;
        this.d = -9223372036854775808L;
        this.az = -1;
        this.c = -9223372036854775808L;
        this.n = false;
        x();
      }
      return;
      continue;
      label153:
      break label97;
      i = 0;
      break;
      i = 0;
    }
  }
  
  public int q()
  {
    return this.ap;
  }
  
  void q()
  {
    if (getChildCount() > 0)
    {
      this.n = true;
      this.jdField_b_of_type_Long = this.au;
      if (this.aA >= 0)
      {
        localView = getChildAt(this.aA - this.ap);
        this.jdField_a_of_type_Long = this.c;
        this.as = this.az;
        if (localView != null) {
          this.aq = localView.getTop();
        }
        this.at = 0;
      }
    }
    else
    {
      return;
    }
    View localView = getChildAt(0);
    Adapter localAdapter = a();
    if ((this.ap >= 0) && (this.ap < localAdapter.getCount())) {}
    for (this.jdField_a_of_type_Long = localAdapter.getItemId(this.ap);; this.jdField_a_of_type_Long = -1L)
    {
      this.as = this.ap;
      if (localView != null) {
        this.aq = localView.getTop();
      }
      this.at = 1;
      return;
    }
  }
  
  public int r()
  {
    return this.ap + getChildCount() - 1;
  }
  
  public void removeAllViews()
  {
    throw new UnsupportedOperationException("removeAllViews() is not supported in AdapterView");
  }
  
  public void removeView(View paramView)
  {
    throw new UnsupportedOperationException("removeView(View) is not supported in AdapterView");
  }
  
  public void removeViewAt(int paramInt)
  {
    throw new UnsupportedOperationException("removeViewAt(int) is not supported in AdapterView");
  }
  
  int s()
  {
    int i4 = this.aB;
    int i2;
    if (i4 == 0)
    {
      i2 = -1;
      return i2;
    }
    long l1 = this.jdField_a_of_type_Long;
    int i = this.as;
    if (l1 == -9223372036854775808L) {
      return -1;
    }
    i = Math.min(i4 - 1, Math.max(0, i));
    long l2 = SystemClock.uptimeMillis();
    Adapter localAdapter = a();
    label70:
    int i3;
    int j;
    int k;
    if (localAdapter == null)
    {
      return -1;
      if ((i3 != 0) || ((j != 0) && (i2 == 0)))
      {
        i = k + 1;
        k = i;
        j = 0;
      }
    }
    for (;;)
    {
      int i1;
      if (SystemClock.uptimeMillis() <= l2 + 100L)
      {
        i2 = i;
        if (localAdapter.getItemId(i) == l1) {
          break;
        }
        if (k != i4 - 1) {
          break label153;
        }
        i2 = 1;
        if (i1 != 0) {
          break label159;
        }
      }
      label153:
      label159:
      for (i3 = 1;; i3 = 0)
      {
        if ((i2 == 0) || (i3 == 0)) {
          break label163;
        }
        return -1;
        i2 = 0;
        break;
      }
      label163:
      break label70;
      if ((i2 != 0) || ((j == 0) && (i3 == 0)))
      {
        i = i1 - 1;
        i1 = i;
        j = 1;
        continue;
        k = i;
        i1 = i;
        j = 0;
      }
    }
  }
  
  public abstract void setAdapter(Adapter paramAdapter);
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    paramView = a();
    if ((paramView == null) || (paramView.isEmpty())) {}
    for (boolean bool = true;; bool = false)
    {
      a(bool);
      return;
    }
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (!paramBoolean) {
        this.jdField_b_of_type_Boolean = false;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!a()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusable(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    boolean bool = true;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        this.jdField_a_of_type_Boolean = true;
      }
      if (!paramBoolean) {
        break label69;
      }
      paramBoolean = bool;
      if (i != 0) {
        if (!a()) {
          break label69;
        }
      }
    }
    label69:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      super.setFocusableInTouchMode(paramBoolean);
      return;
      i = 0;
      break;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    throw new RuntimeException("Don't call setOnClickListener for an AdapterView. You probably want setOnItemClickListener instead");
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_b_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    if (!isLongClickable()) {
      setLongClickable(true);
    }
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemLongClickListener = paramOnItemLongClickListener;
  }
  
  public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener paramOnItemSelectedListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = paramOnItemSelectedListener;
  }
  
  public abstract void setSelection(int paramInt);
  
  void w()
  {
    boolean bool2 = false;
    Adapter localAdapter = a();
    int i;
    if ((localAdapter == null) || (localAdapter.getCount() == 0))
    {
      i = 1;
      if ((i != 0) && (!a())) {
        break label111;
      }
      i = 1;
      label38:
      if ((i == 0) || (!this.jdField_b_of_type_Boolean)) {
        break label116;
      }
      bool1 = true;
      label51:
      super.setFocusableInTouchMode(bool1);
      if ((i == 0) || (!this.jdField_a_of_type_Boolean)) {
        break label121;
      }
    }
    label111:
    label116:
    label121:
    for (boolean bool1 = true;; bool1 = false)
    {
      super.setFocusable(bool1);
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (localAdapter != null)
        {
          bool1 = bool2;
          if (!localAdapter.isEmpty()) {}
        }
        else
        {
          bool1 = true;
        }
        a(bool1);
      }
      return;
      i = 0;
      break;
      i = 0;
      break label38;
      bool1 = false;
      break label51;
    }
  }
  
  void x()
  {
    if ((this.aA != this.aE) || (this.d != this.f))
    {
      B_();
      this.aE = this.aA;
      this.f = this.d;
    }
  }
  
  @TargetApi(11)
  protected void y()
  {
    if ((VersionUtils.e()) && (isHardwareAccelerated()) && ((getParent() instanceof View))) {
      ((View)getParent()).invalidate();
    }
  }
  
  protected void z()
  {
    if ((getParent() instanceof View)) {}
    try
    {
      Field localField = View.class.getDeclaredField("mPrivateFlags");
      localField.setAccessible(true);
      int i = localField.getInt(getParent());
      localField.set(getParent(), Integer.valueOf(i | 0x80000000));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("XListView", 2, localException.getMessage(), localException);
      }
      ((View)getParent()).invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.AdapterView
 * JD-Core Version:    0.7.0.1
 */