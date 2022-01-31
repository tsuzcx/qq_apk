package com.tencent.mobileqq.activity.recent;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.qphone.base.util.QLog;
import eoo;
import eop;

public class DrawerFrame
  extends FrameLayout
{
  public static final int a = 0;
  public static final String a = "DrawerFrame";
  public static final int b = 1;
  public static final int c = 2;
  public static int d = 0;
  public static final int e = 1;
  public static final int f = 2;
  public static final int g = 3;
  public static final int h = 4;
  private static final int i = 400;
  private static final int j = 1;
  private static final int k = 2;
  private static final int l = 3;
  private static final int m = 4;
  private static final int n = 0;
  private static final int o = 1;
  private static final int p = 2;
  private int A;
  private int B;
  private int C;
  private int D;
  private int E;
  private final float jdField_a_of_type_Float = 0.8F;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private Scroller jdField_a_of_type_AndroidWidgetScroller;
  private DrawerFrame.IDrawerCallbacks jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  private boolean jdField_a_of_type_Boolean = true;
  private final float jdField_b_of_type_Float = 0.7F;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = false;
  private final float jdField_c_of_type_Float = 0.4F;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = false;
  private ViewGroup jdField_d_of_type_AndroidViewViewGroup;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = true;
  private boolean f = false;
  private int q = 0;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y;
  private int z;
  
  static
  {
    jdField_d_of_type_Int = 0;
  }
  
  public DrawerFrame(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    super(paramContext);
    if (paramContext == null) {
      throw new NullPointerException("context is null");
    }
    Resources localResources = paramContext.getResources();
    DisplayMetrics localDisplayMetrics = localResources.getDisplayMetrics();
    this.w = localDisplayMetrics.widthPixels;
    this.x = localDisplayMetrics.heightPixels;
    this.E = 0;
    this.y = ((int)(localDisplayMetrics.density * 100.0F + 0.5D));
    this.A = localResources.getDimensionPixelSize(2131427591);
    this.r = (this.w - this.A);
    this.z = (this.r - this.A);
    this.z = 0;
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.e = true;
      this.B = ((int)(this.x * 0.8F));
      this.C = ((int)(this.x * 0.2F / 2.0F));
    }
    for (this.D = (this.C + (int)(this.A * 0.8F + 0.5D));; this.D = (this.C + (int)(this.A * 0.8F + 0.5D)))
    {
      this.jdField_a_of_type_AndroidOsHandler = new eop(this);
      this.jdField_a_of_type_AndroidWidgetScroller = new Scroller(paramContext, new DrawerFrame.SmoothInterpolator());
      a(paramViewGroup1, paramViewGroup2, paramViewGroup3);
      b(1);
      return;
      this.e = false;
      this.B = this.x;
      this.C = 0;
    }
  }
  
  public ViewGroup a()
  {
    return this.jdField_c_of_type_AndroidViewViewGroup;
  }
  
  public DrawerFrame.IDrawerCallbacks a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks;
  }
  
  public void a()
  {
    a(true);
  }
  
  @TargetApi(11)
  public void a(int paramInt)
  {
    float f1 = paramInt / this.r;
    b(2);
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (!this.f)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setPivotX(this.w / 2.0F);
        this.jdField_c_of_type_AndroidViewViewGroup.setPivotY(this.x / 2.0F);
        this.jdField_a_of_type_AndroidViewViewGroup.setPivotX(0.0F);
        this.jdField_a_of_type_AndroidViewViewGroup.setPivotY(this.x / 2.0F);
        this.f = true;
      }
      float f2 = 1.0F - 0.2F * f1;
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setScaleX(f2);
        this.jdField_a_of_type_AndroidViewViewGroup.setScaleY(f2);
      }
      f2 = 0.7F + 0.3F * f1;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.setScaleX(f2);
        this.jdField_c_of_type_AndroidViewViewGroup.setScaleY(f2);
      }
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        this.jdField_c_of_type_AndroidViewViewGroup.setAlpha(0.4F + 0.6F * f1);
      }
      f2 = this.y;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        this.jdField_c_of_type_AndroidViewViewGroup.setTranslationX(f2 * (f1 - 1.0F));
      }
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0) {
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - f1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a(f1);
      }
    }
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, ViewGroup paramViewGroup3)
  {
    if (paramViewGroup3 != this.jdField_d_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_d_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_d_of_type_AndroidViewViewGroup);
      }
      this.jdField_d_of_type_AndroidViewViewGroup = paramViewGroup3;
      if (this.jdField_d_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup3 = new FrameLayout.LayoutParams(-1, -1);
        addView(this.jdField_d_of_type_AndroidViewViewGroup, paramViewGroup3);
      }
    }
    if (paramViewGroup2 != this.jdField_c_of_type_AndroidViewViewGroup)
    {
      if (this.jdField_c_of_type_AndroidViewViewGroup != null) {
        removeView(this.jdField_c_of_type_AndroidViewViewGroup);
      }
      this.jdField_c_of_type_AndroidViewViewGroup = paramViewGroup2;
      if (this.jdField_c_of_type_AndroidViewViewGroup != null)
      {
        paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1, 21);
        addView(this.jdField_c_of_type_AndroidViewViewGroup, paramViewGroup2);
      }
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.e))
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = new View(getContext());
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130839062);
      }
      paramViewGroup2 = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewView, paramViewGroup2);
      if (paramViewGroup1 != this.jdField_a_of_type_AndroidViewViewGroup)
      {
        if (this.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          removeView(this.jdField_a_of_type_AndroidViewViewGroup);
          if (this.jdField_b_of_type_AndroidViewViewGroup != null)
          {
            this.jdField_b_of_type_AndroidViewViewGroup.removeView(this);
            this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup);
            this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(null);
            this.jdField_b_of_type_AndroidViewViewGroup = null;
          }
        }
        this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
        if (this.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          paramViewGroup1 = this.jdField_a_of_type_AndroidViewViewGroup.getParent();
          if (!(paramViewGroup1 instanceof ViewGroup)) {
            break label465;
          }
          this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup1);
          this.jdField_b_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
        }
      }
    }
    for (;;)
    {
      paramViewGroup1 = new FrameLayout.LayoutParams(-1, -1);
      addView(this.jdField_a_of_type_AndroidViewViewGroup, paramViewGroup1);
      if (this.jdField_b_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup.addView(this);
        this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(new eoo(this));
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_AndroidViewView == null))
      {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
        this.jdField_b_of_type_AndroidViewView.setFocusable(true);
        this.jdField_b_of_type_AndroidViewView.setFocusableInTouchMode(true);
        this.jdField_b_of_type_AndroidViewView.setClickable(true);
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        this.jdField_b_of_type_AndroidViewView.setBackgroundResource(17170445);
        this.jdField_b_of_type_AndroidViewView.setContentDescription("返回消息页面 双击返回");
        paramViewGroup1 = new FrameLayout.LayoutParams(this.r, this.B, 21);
        addView(this.jdField_b_of_type_AndroidViewView, paramViewGroup1);
      }
      this.f = false;
      return;
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break;
      }
      removeView(this.jdField_a_of_type_AndroidViewView);
      break;
      label465:
      this.jdField_b_of_type_AndroidViewViewGroup = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.E = 2;
    if (!this.jdField_b_of_type_Boolean)
    {
      b(paramBoolean);
      return;
    }
    c(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public ViewGroup b()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void b()
  {
    b(true);
  }
  
  public void b(int paramInt)
  {
    int i2 = 0;
    int i1;
    if (paramInt == 1)
    {
      i1 = 8;
      if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_d_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != i1)) {
        this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(i1);
      }
      if (paramInt != 2) {
        break label133;
      }
      i1 = 0;
      label69:
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != i1)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(i1);
      }
      if (paramInt != 0) {
        break label139;
      }
    }
    label133:
    label139:
    for (paramInt = i2;; paramInt = 8)
    {
      if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != paramInt)) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(paramInt);
      }
      return;
      i1 = 0;
      break;
      i1 = 8;
      break label69;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (!d()) {
      return;
    }
    Scroller localScroller;
    int i2;
    int i3;
    int i4;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a();
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.q;
      i3 = this.r;
      i4 = this.q;
      if (!paramBoolean) {
        break label139;
      }
    }
    label139:
    for (int i1 = 400;; i1 = 0)
    {
      localScroller.startScroll(i2, 0, i3 - i4, 0, i1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (!this.jdField_b_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void c()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("DrawerFrame", 4, "resetDrawer()");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
    this.jdField_c_of_type_Boolean = false;
    this.q = 0;
    if (this.jdField_a_of_type_AndroidViewViewGroup != null) {
      this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
    }
    a(this.q);
    postInvalidate();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
    }
    b(1);
    jdField_d_of_type_Int = 0;
  }
  
  public void c(boolean paramBoolean)
  {
    if (!d()) {
      return;
    }
    Scroller localScroller;
    int i2;
    int i3;
    if (this.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a();
      }
      localScroller = this.jdField_a_of_type_AndroidWidgetScroller;
      i2 = this.q;
      i3 = -this.q;
      if (!paramBoolean) {
        break label123;
      }
    }
    label123:
    for (int i1 = 400;; i1 = 0)
    {
      localScroller.startScroll(i2, 0, i3, 0, i1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
      if (this.jdField_b_of_type_Boolean) {
        break;
      }
      return;
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d()
  {
    c(true);
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2;
    if (!d()) {
      bool2 = bool1;
    }
    int i1;
    do
    {
      do
      {
        do
        {
          return bool2;
          i1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
          i2 = (int)(paramMotionEvent.getX() + 0.5F);
          i3 = (int)(paramMotionEvent.getY() + 0.5F);
          switch (paramMotionEvent.getAction())
          {
          default: 
            return false;
          case 0: 
            this.t = i2;
            this.s = i2;
            this.v = i3;
            this.u = i3;
            if ((!this.jdField_b_of_type_Boolean) || (this.s > this.z)) {
              this.jdField_d_of_type_Boolean = true;
            }
            bool2 = bool1;
          }
        } while (!this.jdField_c_of_type_Boolean);
        bool2 = bool1;
      } while (this.s <= this.q);
      this.jdField_d_of_type_Boolean = true;
      return true;
      bool2 = bool1;
    } while (!this.jdField_d_of_type_Boolean);
    if ((!this.jdField_b_of_type_Boolean) && ((i2 < this.t) || (i2 < this.s)))
    {
      this.jdField_d_of_type_Boolean = false;
      return false;
    }
    this.t = i2;
    this.v = i3;
    int i2 = Math.abs(this.t - this.s);
    int i3 = Math.abs(this.v - this.u);
    if (this.jdField_b_of_type_Boolean)
    {
      bool1 = bool3;
      if (i2 > i1) {
        bool1 = true;
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      bool2 = bool1;
      if (!this.jdField_c_of_type_Boolean) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      return bool1;
      bool1 = bool3;
      if (i2 > i1)
      {
        bool1 = bool3;
        if ((i3 + 0.0F) / i2 < 0.6F) {
          bool1 = true;
        }
      }
    }
    this.jdField_d_of_type_Boolean = false;
    if ((this.s > this.r) && (this.jdField_b_of_type_Boolean))
    {
      this.E = 3;
      if ((this.u >= this.C) && (this.u <= this.D)) {
        this.E = 4;
      }
      d();
      this.t = -1;
      this.s = -1;
      this.v = -1;
      this.u = -1;
      return true;
    }
    this.t = -1;
    this.s = -1;
    this.v = -1;
    this.u = -1;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_d_of_type_AndroidViewViewGroup != null) && (this.jdField_d_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_d_of_type_AndroidViewViewGroup.layout(this.jdField_d_of_type_AndroidViewViewGroup.getLeft(), this.jdField_d_of_type_AndroidViewViewGroup.getTop(), this.jdField_d_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_c_of_type_AndroidViewViewGroup != null) && (this.jdField_c_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_c_of_type_AndroidViewViewGroup.layout(this.jdField_c_of_type_AndroidViewViewGroup.getLeft(), this.jdField_c_of_type_AndroidViewViewGroup.getTop(), this.jdField_c_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewView.layout(this.jdField_a_of_type_AndroidViewView.getLeft(), this.jdField_a_of_type_AndroidViewView.getTop(), this.jdField_a_of_type_AndroidViewView.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() != 8)) {
      this.jdField_a_of_type_AndroidViewViewGroup.layout(this.jdField_a_of_type_AndroidViewViewGroup.getLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getLeft() + paramInt3, paramInt4);
    }
    if ((this.jdField_b_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidViewView.getVisibility() != 8)) {
      this.jdField_b_of_type_AndroidViewView.layout(this.r, this.C, this.r + this.B, this.C + this.B);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!d()) {
      return false;
    }
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    int i1 = (int)(paramMotionEvent.getX() + 0.5F);
    int i2 = (int)(paramMotionEvent.getY() + 0.5F);
    int i3 = i1 - this.t;
    int i4 = this.v;
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    this.t = i1;
    this.v = i2;
    switch (paramMotionEvent.getAction())
    {
    default: 
      return false;
    case 0: 
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(2);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(4);
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      }
    case 2: 
      this.jdField_c_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_c_of_type_Boolean = true;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks.a();
      }
      this.E = 1;
      if (this.q + i3 > this.r) {
        if (this.q != this.r)
        {
          this.jdField_b_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(this.r - this.q);
          this.q = this.r;
          a(this.q);
          invalidate();
        }
      }
      for (;;)
      {
        return true;
        if (this.q + i3 < 0)
        {
          if (this.q != 0)
          {
            this.jdField_b_of_type_Boolean = false;
            this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(0 - this.jdField_a_of_type_AndroidViewViewGroup.getLeft());
            this.q = 0;
            a(this.q);
            invalidate();
          }
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup.offsetLeftAndRight(i3);
          this.q += i3;
          a(this.q);
          invalidate();
        }
      }
    }
    this.jdField_d_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    if (Math.abs(this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity()) > localViewConfiguration.getScaledMinimumFlingVelocity()) {
      if (this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity() > 0.0F)
      {
        this.jdField_b_of_type_Boolean = false;
        b();
      }
    }
    for (;;)
    {
      return true;
      this.jdField_b_of_type_Boolean = true;
      d();
      continue;
      if (this.q > this.w / 2.0D)
      {
        this.jdField_b_of_type_Boolean = false;
        b();
      }
      else
      {
        this.jdField_b_of_type_Boolean = true;
        d();
      }
    }
  }
  
  public void setDrawerCallbacks(DrawerFrame.IDrawerCallbacks paramIDrawerCallbacks)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentDrawerFrame$IDrawerCallbacks = paramIDrawerCallbacks;
  }
  
  public void setDrawerEnabled(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.DrawerFrame
 * JD-Core Version:    0.7.0.1
 */