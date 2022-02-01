package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.util.VersionUtils;
import hvo;
import hvp;
import hvq;
import java.lang.ref.WeakReference;

public class BubblePopupWindow
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private static final int[] jdField_c_of_type_ArrayOfInt = { 16842922 };
  private Context jdField_a_of_type_AndroidContentContext;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View.OnTouchListener jdField_a_of_type_AndroidViewView$OnTouchListener;
  private View jdField_a_of_type_AndroidViewView;
  private ViewTreeObserver.OnScrollChangedListener jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener = new hvo(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private BubblePopupWindow.OnDismissListener jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener;
  private hvp jdField_a_of_type_Hvp;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private hvp jdField_b_of_type_Hvp;
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private hvp jdField_c_of_type_Hvp;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = true;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean = false;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean = true;
  private int o = 1000;
  private int p = -1;
  private int q;
  private int r;
  
  public BubblePopupWindow()
  {
    this(null, 0, 0);
  }
  
  public BubblePopupWindow(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
  }
  
  public BubblePopupWindow(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842870);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }
  
  public BubblePopupWindow(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public BubblePopupWindow(View paramView)
  {
    this(paramView, 0, 0);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    this(paramView, paramInt1, paramInt2, false);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
    }
    a(paramView);
    f(paramInt1);
    e(paramInt2);
    a(paramBoolean);
  }
  
  private int a(int paramInt)
  {
    paramInt = 0xFF797DE7 & paramInt;
    int i1 = paramInt;
    if (this.jdField_m_of_type_Boolean) {
      i1 = paramInt | 0x8000;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      i1 |= 0x8;
      paramInt = i1;
      if (this.jdField_d_of_type_Int == 1) {
        paramInt = i1 | 0x20000;
      }
    }
    for (;;)
    {
      i1 = paramInt;
      if (!this.jdField_d_of_type_Boolean) {
        i1 = paramInt | 0x10;
      }
      paramInt = i1;
      if (this.jdField_e_of_type_Boolean) {
        paramInt = i1 | 0x40000;
      }
      i1 = paramInt;
      if (!this.jdField_f_of_type_Boolean) {
        i1 = paramInt | 0x200;
      }
      paramInt = i1;
      if (e()) {
        paramInt = i1 | 0x800000;
      }
      i1 = paramInt;
      if (this.jdField_g_of_type_Boolean) {
        i1 = paramInt | 0x100;
      }
      paramInt = i1;
      if (this.jdField_j_of_type_Boolean) {
        paramInt = i1 | 0x10000;
      }
      i1 = paramInt;
      if (this.jdField_k_of_type_Boolean) {
        i1 = paramInt | 0x20;
      }
      return i1;
      paramInt = i1;
      if (this.jdField_d_of_type_Int == 2) {
        paramInt = i1 | 0x20000;
      }
    }
  }
  
  private WindowManager.LayoutParams a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 51;
    int i1 = this.jdField_h_of_type_Int;
    this.jdField_i_of_type_Int = i1;
    localLayoutParams.width = i1;
    i1 = this.jdField_k_of_type_Int;
    this.jdField_l_of_type_Int = i1;
    localLayoutParams.height = i1;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {}
    for (localLayoutParams.format = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getOpacity();; localLayoutParams.format = -3)
    {
      localLayoutParams.flags = a(localLayoutParams.flags);
      localLayoutParams.type = this.o;
      localLayoutParams.token = paramIBinder;
      localLayoutParams.softInputMode = this.jdField_e_of_type_Int;
      localLayoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
      return localLayoutParams;
    }
  }
  
  private void a(View paramView, boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, int paramInt3, int paramInt4)
  {
    if ((!g()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    WeakReference localWeakReference;
    View localView;
    do
    {
      return;
      localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
      localView = paramView;
      if (paramView == null) {
        localView = (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      }
    } while (localView == null);
    int i1;
    if ((paramBoolean1) && ((this.q != paramInt1) || (this.r != paramInt2)))
    {
      i1 = 1;
      if ((localWeakReference != null) && (localWeakReference.get() == localView) && ((i1 == 0) || (this.jdField_b_of_type_Boolean))) {
        break label222;
      }
      d(localView, paramInt1, paramInt2);
      label105:
      paramView = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      if (!paramBoolean2) {
        break label291;
      }
      if (paramInt3 != -1) {
        break label241;
      }
      i1 = this.jdField_m_of_type_Int;
      label133:
      if (paramInt4 != -1) {
        break label254;
      }
      paramInt3 = this.jdField_n_of_type_Int;
    }
    for (;;)
    {
      label145:
      paramInt4 = paramView.x;
      int i2 = paramView.y;
      if (paramBoolean1)
      {
        a(localView, paramView, paramInt1, paramInt2);
        label172:
        paramInt1 = paramView.x;
        paramInt2 = paramView.y;
        if ((paramInt4 == paramView.x) && (i2 == paramView.y)) {
          break label286;
        }
      }
      label286:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        a(paramInt1, paramInt2, i1, paramInt3, paramBoolean1);
        return;
        i1 = 0;
        break;
        label222:
        if (i1 == 0) {
          break label105;
        }
        this.q = paramInt1;
        this.r = paramInt2;
        break label105;
        label241:
        this.jdField_m_of_type_Int = paramInt3;
        i1 = paramInt3;
        break label133;
        label254:
        this.jdField_n_of_type_Int = paramInt4;
        paramInt3 = paramInt4;
        break label145;
        a(localView, paramView, this.q, this.r);
        break label172;
      }
      label291:
      i1 = paramInt3;
      paramInt3 = paramInt4;
    }
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (this.jdField_a_of_type_AndroidViewWindowManager == null)) {
      throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }
    hvq localhvq = new hvq(this, this.jdField_a_of_type_AndroidContentContext);
    Object localObject = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    ((FrameLayout)localObject).setPadding(0, Math.round(TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())), 0, Math.round(TypedValue.applyDimension(1, 13.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics())));
    localhvq.addView((View)localObject, -1, -1);
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(this.jdField_a_of_type_AndroidContentContext);
    ((FrameLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, -1, -1);
    localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837740);
    this.jdField_a_of_type_Hvp = new hvp(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837741));
    localObject = new LayerDrawable(new Drawable[] { localObject, this.jdField_a_of_type_Hvp });
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundDrawable((Drawable)localObject);
    localObject = new FrameLayout.LayoutParams(-1, -1, 17);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new FrameLayout.LayoutParams(-2, -2, 51);
    this.jdField_b_of_type_Hvp = new hvp(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837739));
    LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837738), this.jdField_b_of_type_Hvp });
    this.jdField_b_of_type_AndroidWidgetImageView.setBackgroundDrawable(localLayerDrawable);
    localhvq.addView(this.jdField_b_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    localObject = new FrameLayout.LayoutParams(-2, -2, 83);
    this.jdField_c_of_type_Hvp = new hvp(this, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837737));
    localLayerDrawable = new LayerDrawable(new Drawable[] { this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837736), this.jdField_c_of_type_Hvp });
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(localLayerDrawable);
    localhvq.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject);
    this.jdField_b_of_type_AndroidViewView = localhvq;
    this.jdField_m_of_type_Int = paramLayoutParams.width;
    this.jdField_n_of_type_Int = paramLayoutParams.height;
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    this.jdField_l_of_type_Boolean = paramBoolean;
    ImageView localImageView1;
    if (!paramBoolean)
    {
      localImageView1 = this.jdField_b_of_type_AndroidWidgetImageView;
      if (paramBoolean) {
        break label69;
      }
    }
    label69:
    for (ImageView localImageView2 = this.jdField_a_of_type_AndroidWidgetImageView;; localImageView2 = this.jdField_b_of_type_AndroidWidgetImageView)
    {
      int i1 = localImageView1.getMeasuredWidth();
      localImageView1.setVisibility(0);
      ((ViewGroup.MarginLayoutParams)localImageView1.getLayoutParams()).leftMargin = (paramInt - i1 / 2);
      localImageView2.setVisibility(4);
      return;
      localImageView1 = this.jdField_a_of_type_AndroidWidgetImageView;
      break;
    }
  }
  
  private boolean a(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    View localView = paramView.getRootView();
    paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramInt1);
    paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
    paramLayoutParams.gravity = 83;
    paramView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
    Rect localRect1 = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect2);
    int i1 = this.jdField_m_of_type_Int;
    int i3 = this.jdField_n_of_type_Int;
    int i2;
    if (this.jdField_m_of_type_Int != -2)
    {
      i2 = i1;
      if (this.jdField_n_of_type_Int != -2) {}
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.jdField_m_of_type_Int == -2) {
        i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      }
      i2 = i1;
      if (this.jdField_n_of_type_Int == -2)
      {
        i3 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();
        i2 = i1;
      }
    }
    for (i1 = i3;; i1 = i3)
    {
      if (i2 > 0) {
        paramLayoutParams.x = (this.jdField_b_of_type_ArrayOfInt[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
      }
      boolean bool;
      if ((this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - i1 < localRect1.top) || (paramLayoutParams.x + i2 - localView.getWidth() > 0)) {
        if (this.jdField_i_of_type_Boolean)
        {
          i3 = paramView.getScrollX();
          int i4 = paramView.getScrollY();
          paramView.requestRectangleOnScreen(new Rect(i3, i4, i3 + i2 + paramInt1, i4 + i1 + paramView.getHeight() + paramInt2), true);
          paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
          if (i2 > 0)
          {
            paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramView.getWidth() / 2 - i2 / 2 + paramInt1);
            paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
            paramView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
          }
        }
        else
        {
          if (this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - i1 >= localRect1.top) {
            break label716;
          }
          if (i1 + localRect2.bottom + paramInt2 <= localRect1.bottom) {
            break label683;
          }
          paramLayoutParams.y = (localRect2.top + localRect2.height() / 2 + paramInt2);
          i1 = 1;
          bool = true;
          label427:
          if (this.jdField_h_of_type_Boolean)
          {
            i3 = localRect1.right - localRect1.left;
            i2 += paramLayoutParams.x;
            if (i2 > i3) {
              paramLayoutParams.x -= i2 - i3;
            }
            if (paramLayoutParams.x < localRect1.left)
            {
              paramLayoutParams.x = localRect1.left;
              paramLayoutParams.width = Math.min(paramLayoutParams.width, i3);
            }
            if ((!bool) || (i1 != 0)) {
              break label738;
            }
            paramInt2 = this.jdField_b_of_type_ArrayOfInt[1] + paramInt2 - this.jdField_n_of_type_Int;
            if (paramInt2 < 0) {
              paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);
            }
            paramLayoutParams.gravity |= 0x10000000;
          }
          label553:
          if ((bool) && (i1 == 0)) {
            paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
          }
          paramInt2 = this.jdField_b_of_type_ArrayOfInt[0];
          i1 = paramView.getWidth() / 2;
          i2 = paramLayoutParams.x;
          if (!bool) {
            break label757;
          }
          i3 = Math.round(TypedValue.applyDimension(1, 5.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
        }
      }
      for (paramLayoutParams.y -= i3;; paramLayoutParams.y -= i3)
      {
        a(bool, paramInt2 + i1 + paramInt1 - i2);
        return bool;
        paramLayoutParams.x = (this.jdField_a_of_type_ArrayOfInt[0] + paramInt1);
        break;
        label683:
        paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramView.getHeight() + paramInt2);
        paramLayoutParams.gravity = 51;
        bool = false;
        i1 = 0;
        break label427;
        label716:
        paramLayoutParams.y = (this.jdField_a_of_type_ArrayOfInt[1] + paramInt2);
        i1 = 0;
        bool = true;
        break label427;
        label738:
        paramLayoutParams.y = Math.max(paramLayoutParams.y, localRect1.top);
        break label553;
        label757:
        i3 = Math.round(TypedValue.applyDimension(1, 3.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics()));
      }
    }
  }
  
  private boolean a(WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, View paramView)
  {
    View localView = paramView.getRootView();
    paramLayoutParams.x = paramInt1;
    paramLayoutParams.y = paramInt2;
    paramLayoutParams.gravity = 83;
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int i1 = this.jdField_m_of_type_Int;
    int i3 = this.jdField_n_of_type_Int;
    if (this.jdField_m_of_type_Int != -2)
    {
      i2 = i1;
      if (this.jdField_n_of_type_Int != -2) {}
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.jdField_m_of_type_Int == -2) {
        i1 = this.jdField_b_of_type_AndroidViewView.getMeasuredWidth();
      }
      i2 = i1;
      if (this.jdField_n_of_type_Int != -2) {}
    }
    for (int i2 = this.jdField_b_of_type_AndroidViewView.getMeasuredHeight();; i2 = i3)
    {
      if (i1 > 0) {
        paramLayoutParams.x = (paramInt1 - i1 / 2);
      }
      if (((paramInt2 - i2 < localRect.top) || (paramInt1 + i1 - localView.getWidth() > 0)) && (paramInt2 - i2 < localRect.top)) {
        paramLayoutParams.gravity = 51;
      }
      for (boolean bool = false;; bool = true)
      {
        if (this.jdField_h_of_type_Boolean)
        {
          i2 = localRect.right - localRect.left;
          i1 = paramLayoutParams.x + i1;
          if (i1 > i2) {
            paramLayoutParams.x -= i1 - i2;
          }
          if (paramLayoutParams.x < localRect.left)
          {
            paramLayoutParams.x = localRect.left;
            paramLayoutParams.width = Math.min(paramLayoutParams.width, i2);
          }
          if (!bool) {
            break label347;
          }
          paramInt2 -= this.jdField_n_of_type_Int;
          if (paramInt2 >= 0) {}
        }
        label347:
        for (paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);; paramLayoutParams.y = Math.max(paramLayoutParams.y, localRect.top))
        {
          paramLayoutParams.gravity |= 0x10000000;
          if (bool) {
            paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
          }
          a(bool, paramInt1 - paramLayoutParams.x);
          return bool;
        }
      }
      i1 = i2;
    }
  }
  
  @TargetApi(14)
  private void b(WindowManager.LayoutParams paramLayoutParams)
  {
    if (this.jdField_a_of_type_AndroidContentContext != null) {
      paramLayoutParams.packageName = this.jdField_a_of_type_AndroidContentContext.getPackageName();
    }
    if (VersionUtils.d()) {
      this.jdField_b_of_type_AndroidViewView.setFitsSystemWindows(this.jdField_j_of_type_Boolean);
    }
    this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_b_of_type_AndroidViewView, paramLayoutParams);
  }
  
  private void d()
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
  }
  
  private void d(View paramView, int paramInt1, int paramInt2)
  {
    d();
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
    paramView = paramView.getViewTreeObserver();
    if (paramView != null) {
      paramView.addOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
    }
    this.q = paramInt1;
    this.r = paramInt2;
  }
  
  private int g()
  {
    if (this.p == -1)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_l_of_type_Boolean) {
          return 2131624457;
        }
        return 2131624458;
      }
      return 0;
    }
    return this.p;
  }
  
  public int a()
  {
    return this.p;
  }
  
  public int a(View paramView)
  {
    return a(paramView, 0);
  }
  
  public int a(View paramView, int paramInt)
  {
    return a(paramView, paramInt, false);
  }
  
  public int a(View paramView, int paramInt, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    paramView.getLocationOnScreen(arrayOfInt);
    int i1 = localRect.bottom;
    if (paramBoolean) {
      i1 = paramView.getContext().getResources().getDisplayMetrics().heightPixels;
    }
    i1 = Math.max(i1 - (arrayOfInt[1] + paramView.getHeight()) - paramInt, arrayOfInt[1] - localRect.top + paramInt);
    paramInt = i1;
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getPadding(this.jdField_a_of_type_AndroidGraphicsRect);
      paramInt = i1 - (this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    }
    return paramInt;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.jdField_m_of_type_Boolean = true;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_g_of_type_Int = paramInt1;
    this.jdField_j_of_type_Int = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramInt1, paramInt2, paramInt3, paramInt4, false);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramInt3 != -1)
    {
      this.jdField_i_of_type_Int = paramInt3;
      f(paramInt3);
    }
    if (paramInt4 != -1)
    {
      this.jdField_l_of_type_Int = paramInt4;
      e(paramInt4);
    }
    if ((!g()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    label282:
    label290:
    label291:
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i1;
      if (this.jdField_g_of_type_Int < 0)
      {
        i1 = this.jdField_g_of_type_Int;
        boolean bool1 = paramBoolean;
        if (paramInt3 != -1)
        {
          bool1 = paramBoolean;
          if (localLayoutParams.width != i1)
          {
            this.jdField_i_of_type_Int = i1;
            localLayoutParams.width = i1;
            bool1 = true;
          }
        }
        if (this.jdField_j_of_type_Int >= 0) {
          break label282;
        }
        paramInt3 = this.jdField_j_of_type_Int;
        label127:
        paramBoolean = bool1;
        if (paramInt4 != -1)
        {
          paramBoolean = bool1;
          if (localLayoutParams.height != paramInt3)
          {
            this.jdField_l_of_type_Int = paramInt3;
            localLayoutParams.height = paramInt3;
            paramBoolean = true;
          }
        }
        if (localLayoutParams.x != paramInt1)
        {
          localLayoutParams.x = paramInt1;
          paramBoolean = true;
        }
        if (localLayoutParams.y != paramInt2)
        {
          localLayoutParams.y = paramInt2;
          paramBoolean = true;
        }
        paramInt1 = g();
        if (paramInt1 != localLayoutParams.windowAnimations)
        {
          localLayoutParams.windowAnimations = paramInt1;
          paramBoolean = true;
        }
        paramInt1 = a(localLayoutParams.flags);
        if (paramInt1 == localLayoutParams.flags) {
          break label290;
        }
        localLayoutParams.flags = paramInt1;
        paramBoolean = bool2;
      }
      for (;;)
      {
        if (!paramBoolean) {
          break label291;
        }
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
        return;
        i1 = this.jdField_i_of_type_Int;
        break;
        paramInt3 = this.jdField_l_of_type_Int;
        break label127;
      }
    }
  }
  
  public void a(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void a(View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void a(View paramView)
  {
    if (g()) {}
    do
    {
      return;
      this.jdField_a_of_type_AndroidViewView = paramView;
      if ((this.jdField_a_of_type_AndroidContentContext == null) && (this.jdField_a_of_type_AndroidViewView != null)) {
        this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidViewView.getContext();
      }
    } while ((this.jdField_a_of_type_AndroidViewWindowManager != null) || (this.jdField_a_of_type_AndroidViewView == null));
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("window"));
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    if ((g()) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    d(paramView, paramInt1, paramInt2);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    a(localLayoutParams);
    a(paramView, localLayoutParams, paramInt1, paramInt2);
    if (this.jdField_j_of_type_Int < 0)
    {
      paramInt1 = this.jdField_j_of_type_Int;
      this.jdField_l_of_type_Int = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.jdField_g_of_type_Int < 0)
    {
      paramInt1 = this.jdField_g_of_type_Int;
      this.jdField_i_of_type_Int = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = g();
    b(localLayoutParams);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramView, true, paramInt1, paramInt2, true, paramInt3, paramInt4);
  }
  
  public void a(BubblePopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public void b()
  {
    if ((g()) && (this.jdField_b_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_Boolean = false;
      d();
    }
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_b_of_type_AndroidViewView);
      return;
    }
    finally
    {
      if ((this.jdField_b_of_type_AndroidViewView != this.jdField_a_of_type_AndroidViewView) && ((this.jdField_b_of_type_AndroidViewView instanceof ViewGroup))) {
        ((ViewGroup)this.jdField_b_of_type_AndroidViewView).removeView(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_b_of_type_AndroidViewView = null;
      if (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener != null) {
        this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$OnDismissListener.a();
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
    a(localLayoutParams.x, localLayoutParams.y, paramInt1, paramInt2, false);
  }
  
  public void b(View paramView)
  {
    a(paramView, 0, 0);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2)
  {
    if ((g()) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    d();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    a(localLayoutParams);
    a(localLayoutParams, paramInt1, paramInt2, paramView);
    if (this.jdField_j_of_type_Int < 0)
    {
      paramInt1 = this.jdField_j_of_type_Int;
      this.jdField_l_of_type_Int = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.jdField_g_of_type_Int < 0)
    {
      paramInt1 = this.jdField_g_of_type_Int;
      this.jdField_i_of_type_Int = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = g();
    b(localLayoutParams);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void c()
  {
    int i2 = 1;
    if ((!g()) || (this.jdField_a_of_type_AndroidViewView == null)) {}
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
      int i1 = 0;
      int i3 = g();
      if (i3 != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = i3;
        i1 = 1;
      }
      i3 = a(localLayoutParams.flags);
      if (i3 != localLayoutParams.flags)
      {
        localLayoutParams.flags = i3;
        i1 = i2;
      }
      while (i1 != 0)
      {
        this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_b_of_type_AndroidViewView, localLayoutParams);
        return;
      }
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void c(View paramView, int paramInt1, int paramInt2)
  {
    a(paramView, false, 0, 0, true, paramInt1, paramInt2);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int d()
  {
    return this.o;
  }
  
  public void d(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public void e(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      d(paramBoolean);
      return;
    }
  }
  
  public boolean e()
  {
    if ((this.jdField_f_of_type_Int < 0) && (this.jdField_a_of_type_AndroidContentContext != null)) {
      if (this.jdField_a_of_type_AndroidContentContext.getApplicationInfo().targetSdkVersion < 11) {}
    }
    while (this.jdField_f_of_type_Int == 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public int f()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public void f(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
  }
  
  public boolean f()
  {
    return this.jdField_g_of_type_Boolean;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i1 = 1;; i1 = 0)
    {
      this.jdField_f_of_type_Int = i1;
      return;
    }
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void h(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public boolean h()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public void i(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void j(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_k_of_type_Boolean = paramBoolean;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */