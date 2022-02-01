package com.tencent.widget;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import auta;
import com.tencent.image.ProxyDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;
import java.lang.ref.WeakReference;

public class BubblePopupWindow
  implements View.OnClickListener
{
  private static final int[] tp = { 16842922 };
  private View.OnTouchListener E;
  private ImageView Hg;
  private ImageView Hh;
  private View Lf;
  private ViewTreeObserver.OnScrollChangedListener jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener = new auta(this);
  private a jdField_a_of_type_ComTencentWidgetBubblePopupWindow$a;
  private c jdField_a_of_type_ComTencentWidgetBubblePopupWindow$c;
  private a jdField_b_of_type_ComTencentWidgetBubblePopupWindow$a;
  private d jdField_b_of_type_ComTencentWidgetBubblePopupWindow$d;
  private a jdField_c_of_type_ComTencentWidgetBubblePopupWindow$a;
  private b jdField_c_of_type_ComTencentWidgetBubblePopupWindow$b;
  private FrameLayout ct;
  private boolean djV;
  private boolean djW;
  private boolean djX = true;
  private boolean djY;
  private boolean djZ = true;
  private boolean dka = true;
  private boolean dkb;
  private boolean dkc;
  private boolean dkd;
  private boolean dke;
  private boolean dkf;
  private boolean dkg = true;
  private int esA;
  private int esB;
  private int esC = 1000;
  private int esD = -1;
  private int esE;
  private int esF;
  private int esv = 0;
  private int esw = 1;
  private int esx = -1;
  private int esy;
  private int esz;
  private WeakReference<View> iX;
  private int mAnchorOffset;
  private Drawable mBackground;
  private View mContentView;
  private Context mContext;
  private boolean mFocusable;
  private int mHeight;
  private boolean mIsShowing;
  private int mLastHeight;
  private int mLastWidth;
  private Rect mTempRect = new Rect();
  private boolean mTouchable = true;
  private int mWidth;
  private WindowManager mWindowManager;
  private int[] tn = new int[2];
  private int[] to = new int[2];
  
  public BubblePopupWindow()
  {
    this(null, 0, 0);
  }
  
  public BubblePopupWindow(int paramInt1, int paramInt2)
  {
    this(null, paramInt1, paramInt2);
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
    this.mContext = paramContext;
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2)
  {
    this(paramView, paramInt1, paramInt2, false);
  }
  
  public BubblePopupWindow(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramView != null)
    {
      this.mContext = paramView.getContext();
      this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
    }
    setContentView(paramView);
    setWidth(paramInt1);
    setHeight(paramInt2);
    setFocusable(paramBoolean);
  }
  
  private void G(View paramView, int paramInt1, int paramInt2)
  {
    ewI();
    this.iX = new WeakReference(paramView);
    paramView = paramView.getViewTreeObserver();
    if (paramView != null) {
      paramView.addOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
    }
    this.esE = paramInt1;
    this.esF = paramInt2;
  }
  
  private int OM()
  {
    if (this.esD == -1)
    {
      if (this.djV)
      {
        if (this.dke) {
          return 2131755371;
        }
        return 2131755370;
      }
      return 0;
    }
    return this.esD;
  }
  
  private WindowManager.LayoutParams a(IBinder paramIBinder)
  {
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    localLayoutParams.gravity = 51;
    int i = this.mWidth;
    this.mLastWidth = i;
    localLayoutParams.width = i;
    i = this.mHeight;
    this.mLastHeight = i;
    localLayoutParams.height = i;
    if (this.mBackground != null) {}
    for (localLayoutParams.format = this.mBackground.getOpacity();; localLayoutParams.format = -3)
    {
      localLayoutParams.flags = ld(localLayoutParams.flags);
      localLayoutParams.type = this.esC;
      localLayoutParams.token = paramIBinder;
      localLayoutParams.softInputMode = this.esw;
      localLayoutParams.setTitle("PopupWindow:" + Integer.toHexString(hashCode()));
      return localLayoutParams;
    }
  }
  
  private void a(WindowManager.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    if ((this.mContentView == null) || (this.mContext == null) || (this.mWindowManager == null)) {
      throw new IllegalStateException("You must specify a valid content view by calling setContentView() before attempting to show the popup.");
    }
    PopupViewContainer localPopupViewContainer = new PopupViewContainer(this.mContext);
    Object localObject = new FrameLayout(this.mContext);
    if (paramBoolean) {
      ((FrameLayout)localObject).setOnClickListener(this);
    }
    int j;
    int i;
    if (paramBoolean)
    {
      j = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
      i = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
    }
    for (;;)
    {
      ((FrameLayout)localObject).setPadding(j, Math.round(TypedValue.applyDimension(1, 8.0F, this.mContext.getResources().getDisplayMetrics())), i, Math.round(TypedValue.applyDimension(1, 8.0F, this.mContext.getResources().getDisplayMetrics())));
      localPopupViewContainer.addView((View)localObject, -1, -1);
      this.ct = new FrameLayout(this.mContext);
      ((FrameLayout)localObject).addView(this.ct, -1, -1);
      localObject = this.mContext.getResources().getDrawable(2130839070);
      this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$a = new a(this.mContext.getResources().getDrawable(2130839071));
      localObject = new LayerDrawable(new Drawable[] { localObject, this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow$a });
      this.ct.setBackgroundDrawable((Drawable)localObject);
      localObject = new FrameLayout.LayoutParams(-1, -1, 17);
      this.ct.addView(this.mContentView, (ViewGroup.LayoutParams)localObject);
      this.Hh = new ImageView(this.mContext);
      localObject = new FrameLayout.LayoutParams(-2, -2, 51);
      this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$a = new a(this.mContext.getResources().getDrawable(2130839069));
      LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { this.mContext.getResources().getDrawable(2130839068), this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$a });
      this.Hh.setBackgroundDrawable(localLayerDrawable);
      localPopupViewContainer.addView(this.Hh, (ViewGroup.LayoutParams)localObject);
      this.Hg = new ImageView(this.mContext);
      localObject = new FrameLayout.LayoutParams(-2, -2, 83);
      this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow$a = new a(this.mContext.getResources().getDrawable(2130839067));
      localLayerDrawable = new LayerDrawable(new Drawable[] { this.mContext.getResources().getDrawable(2130839066), this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow$a });
      this.Hg.setBackgroundDrawable(localLayerDrawable);
      localPopupViewContainer.addView(this.Hg, (ViewGroup.LayoutParams)localObject);
      this.Lf = localPopupViewContainer;
      this.esA = paramLayoutParams.width;
      this.esB = paramLayoutParams.height;
      return;
      i = 0;
      j = 0;
    }
  }
  
  private boolean a(View paramView, WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2)
  {
    paramView.getLocationInWindow(this.tn);
    View localView = paramView.getRootView();
    paramLayoutParams.x = (this.tn[0] + paramInt1);
    paramLayoutParams.y = (this.tn[1] + paramInt2);
    paramLayoutParams.gravity = 83;
    paramView.getLocationOnScreen(this.to);
    Rect localRect1 = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect1);
    Rect localRect2 = new Rect();
    paramView.getGlobalVisibleRect(localRect2);
    int i = this.esA;
    int k = this.esB;
    int j;
    if (this.esA != -2)
    {
      j = i;
      if (this.esB != -2) {}
    }
    else
    {
      this.Lf.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.esA == -2) {
        i = this.Lf.getMeasuredWidth();
      }
      j = i;
      if (this.esB == -2)
      {
        k = this.Lf.getMeasuredHeight();
        j = i;
      }
    }
    for (i = k;; i = k)
    {
      if (j > 0) {
        paramLayoutParams.x = (this.to[0] + paramView.getWidth() / 2 - j / 2 + paramInt1);
      }
      boolean bool;
      if ((this.to[1] + paramInt2 - i < localRect1.top) || (paramLayoutParams.x + j - localView.getWidth() > 0)) {
        if (this.dka)
        {
          k = paramView.getScrollX();
          int m = paramView.getScrollY();
          paramView.requestRectangleOnScreen(new Rect(k, m, k + j + paramInt1, m + i + paramView.getHeight() + paramInt2), true);
          paramView.getLocationInWindow(this.tn);
          if (j > 0)
          {
            paramLayoutParams.x = (this.tn[0] + paramView.getWidth() / 2 - j / 2 + paramInt1);
            paramLayoutParams.y = (this.tn[1] + paramInt2);
            paramView.getLocationOnScreen(this.to);
          }
        }
        else
        {
          if (this.to[1] + paramInt2 - i >= localRect1.top) {
            break label716;
          }
          if (i + localRect2.bottom + paramInt2 <= localRect1.bottom) {
            break label683;
          }
          paramLayoutParams.y = (localRect2.top + localRect2.height() / 2 + paramInt2);
          i = 1;
          bool = true;
          label427:
          if (this.djZ)
          {
            k = localRect1.right - localRect1.left;
            j += paramLayoutParams.x;
            if (j > k) {
              paramLayoutParams.x -= j - k;
            }
            if (paramLayoutParams.x < localRect1.left)
            {
              paramLayoutParams.x = localRect1.left;
              paramLayoutParams.width = Math.min(paramLayoutParams.width, k);
            }
            if ((!bool) || (i != 0)) {
              break label738;
            }
            paramInt2 = this.to[1] + paramInt2 - this.esB;
            if (paramInt2 < 0) {
              paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);
            }
            paramLayoutParams.gravity |= 0x10000000;
          }
          label553:
          if ((bool) && (i == 0)) {
            paramLayoutParams.y = (localView.getHeight() - paramLayoutParams.y);
          }
          paramInt2 = this.to[0];
          i = paramView.getWidth() / 2;
          j = paramLayoutParams.x;
          if (!bool) {
            break label757;
          }
          k = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
        }
      }
      for (paramLayoutParams.y -= k;; paramLayoutParams.y -= k)
      {
        bZ(bool, paramInt2 + i + paramInt1 - j);
        return bool;
        paramLayoutParams.x = (this.tn[0] + paramInt1);
        break;
        label683:
        paramLayoutParams.y = (this.tn[1] + paramView.getHeight() + paramInt2);
        paramLayoutParams.gravity = 51;
        bool = false;
        i = 0;
        break label427;
        label716:
        paramLayoutParams.y = (this.tn[1] + paramInt2);
        i = 0;
        bool = true;
        break label427;
        label738:
        paramLayoutParams.y = Math.max(paramLayoutParams.y, localRect1.top);
        break label553;
        label757:
        k = Math.round(TypedValue.applyDimension(1, 3.0F, this.mContext.getResources().getDisplayMetrics()));
      }
    }
  }
  
  private boolean a(WindowManager.LayoutParams paramLayoutParams, int paramInt1, int paramInt2, View paramView)
  {
    Object localObject = paramView.getRootView();
    paramLayoutParams.x = paramInt1;
    paramLayoutParams.y = paramInt2;
    boolean bool;
    Rect localRect;
    int i;
    int k;
    if (this.dkc)
    {
      bool = false;
      paramLayoutParams.gravity = 51;
      localRect = new Rect();
      paramView.getWindowVisibleDisplayFrame(localRect);
      i = this.esA;
      k = this.esB;
      if (this.esA != -2)
      {
        j = i;
        if (this.esB != -2) {
          break label515;
        }
      }
      this.Lf.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.esA == -2) {
        i = this.Lf.getMeasuredWidth();
      }
      j = i;
      if (this.esB != -2) {
        break label515;
      }
    }
    for (int j = this.Lf.getMeasuredHeight();; j = k)
    {
      if (i > 0) {
        paramLayoutParams.x = (paramInt1 - i / 2);
      }
      k = localRect.top;
      if (this.mAnchorOffset > 0) {
        k = 0;
      }
      if ((!this.dkc) && ((paramInt2 - j < k) || (paramInt1 + i - ((View)localObject).getWidth() > 0)) && (paramInt2 - j < k))
      {
        paramLayoutParams.gravity = 51;
        bool = false;
      }
      for (;;)
      {
        if (this.djZ)
        {
          j = localRect.right - localRect.left;
          i = paramLayoutParams.x + i;
          if (i > j) {
            paramLayoutParams.x -= i - j;
          }
          if (paramLayoutParams.x < localRect.left)
          {
            paramLayoutParams.x = localRect.left;
            paramLayoutParams.width = Math.min(paramLayoutParams.width, j);
          }
          if (!bool) {
            break label488;
          }
          paramInt2 -= this.esB;
          if (paramInt2 >= 0) {}
        }
        label488:
        for (paramLayoutParams.y = (paramInt2 + paramLayoutParams.y);; paramLayoutParams.y = Math.max(paramLayoutParams.y + this.mAnchorOffset, localRect.top))
        {
          paramLayoutParams.gravity |= 0x10000000;
          if (bool) {
            paramLayoutParams.y = (((View)localObject).getHeight() - paramLayoutParams.y);
          }
          bZ(bool, paramInt1 - paramLayoutParams.x);
          if ((Build.VERSION.SDK_INT >= 24) && ((paramView.getContext() instanceof Activity)) && (((Activity)paramView.getContext()).isInMultiWindowMode()))
          {
            localObject = new int[2];
            ((Activity)paramView.getContext()).getWindow().getDecorView().getLocationOnScreen((int[])localObject);
            if (localObject[1] > 10) {
              paramLayoutParams.y += localObject[1];
            }
            if (localObject[0] > 10) {
              paramLayoutParams.x -= localObject[0];
            }
          }
          return bool;
          bool = true;
          paramLayoutParams.gravity = 83;
          break;
        }
      }
      label515:
      i = j;
    }
  }
  
  private void bZ(boolean paramBoolean, int paramInt)
  {
    this.dke = paramBoolean;
    Object localObject;
    ImageView localImageView;
    if (!paramBoolean)
    {
      localObject = this.Hh;
      if (paramBoolean) {
        break label86;
      }
      localImageView = this.Hg;
      label25:
      int i = ((View)localObject).getMeasuredWidth();
      ((View)localObject).setVisibility(0);
      localObject = (ViewGroup.MarginLayoutParams)((View)localObject).getLayoutParams();
      ((ViewGroup.MarginLayoutParams)localObject).leftMargin = (paramInt - i / 2);
      if (!this.dke) {
        break label95;
      }
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = 1;
    }
    for (;;)
    {
      localImageView.setVisibility(4);
      return;
      localObject = this.Hg;
      break;
      label86:
      localImageView = this.Hh;
      break label25;
      label95:
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = 1;
    }
  }
  
  private void d(WindowManager.LayoutParams paramLayoutParams)
  {
    a(paramLayoutParams, false);
  }
  
  @TargetApi(14)
  private void e(WindowManager.LayoutParams paramLayoutParams)
  {
    if (this.mContext != null) {
      paramLayoutParams.packageName = this.mContext.getPackageName();
    }
    if (VersionUtils.isIceScreamSandwich()) {
      this.Lf.setFitsSystemWindows(this.dkb);
    }
    if (this.Lf.getParent() == null) {
      this.mWindowManager.addView(this.Lf, paramLayoutParams);
    }
  }
  
  private void ewI()
  {
    Object localObject = this.iX;
    if (localObject != null) {}
    for (localObject = (View)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null) {
        ((View)localObject).getViewTreeObserver().removeOnScrollChangedListener(this.jdField_a_of_type_AndroidViewViewTreeObserver$OnScrollChangedListener);
      }
      this.iX = null;
      return;
    }
  }
  
  private int ld(int paramInt)
  {
    paramInt = 0xFF797DE7 & paramInt;
    int i = paramInt;
    if (this.dkf) {
      i = paramInt | 0x8000;
    }
    if (!this.mFocusable)
    {
      i |= 0x8;
      paramInt = i;
      if (this.esv == 1) {
        paramInt = i | 0x20000;
      }
    }
    for (;;)
    {
      i = paramInt;
      if (!this.mTouchable) {
        i = paramInt | 0x10;
      }
      paramInt = i;
      if (this.djW) {
        paramInt = i | 0x40000;
      }
      i = paramInt;
      if (!this.djX) {
        i = paramInt | 0x200;
      }
      paramInt = i;
      if (isSplitTouchEnabled()) {
        paramInt = i | 0x800000;
      }
      i = paramInt;
      if (this.djY) {
        i = paramInt | 0x100;
      }
      paramInt = i;
      if (this.dkb) {
        paramInt = i | 0x10000;
      }
      i = paramInt;
      if (this.dkd) {
        i = paramInt | 0x20;
      }
      return i;
      paramInt = i;
      if (this.esv == 2) {
        paramInt = i | 0x20000;
      }
    }
  }
  
  public void We(boolean paramBoolean)
  {
    this.dkc = paramBoolean;
  }
  
  public void a(b paramb)
  {
    this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow$b = paramb;
  }
  
  public void a(d paramd)
  {
    this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$d = paramd;
  }
  
  public void abd(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ct.getLayoutParams();
    int[] arrayOfInt = new int[2];
    this.ct.getLocationOnScreen(arrayOfInt);
    int j = arrayOfInt[0];
    int i;
    int k;
    int m;
    int n;
    if (this.dke)
    {
      this.Hg.getLocationOnScreen(arrayOfInt);
      i = this.Hg.getMeasuredWidth();
      k = arrayOfInt[0];
      m = Math.round(TypedValue.applyDimension(1, 5.0F, this.mContext.getResources().getDisplayMetrics()));
      n = this.mContext.getResources().getDisplayMetrics().widthPixels;
      if (paramInt / 2 + k + i / 2 >= n - m) {
        break label169;
      }
    }
    label169:
    for (paramInt = i / 2 + k - paramInt / 2 - j;; paramInt = n - m - paramInt - j)
    {
      if (paramInt >= 0) {
        localLayoutParams.leftMargin = paramInt;
      }
      this.ct.setLayoutParams(localLayoutParams);
      return;
      this.Hh.getLocationOnScreen(arrayOfInt);
      i = this.Hh.getMeasuredWidth();
      break;
    }
  }
  
  public void abe(int paramInt)
  {
    this.mAnchorOffset = paramInt;
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, "showAtLocation() called with: parent = [" + paramView + "], x = [" + paramInt1 + "], y = [" + paramInt2 + "], isNoIcon = [" + paramBoolean + "]");
    }
    if ((isShowing()) || (this.mContentView == null)) {
      return;
    }
    ewI();
    this.mIsShowing = true;
    this.djV = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    a(localLayoutParams, paramBoolean);
    a(localLayoutParams, paramInt1, paramInt2, paramView);
    if (this.esz < 0)
    {
      paramInt1 = this.esz;
      this.mLastHeight = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.esy < 0)
    {
      paramInt1 = this.esy;
      this.mLastWidth = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = OM();
    e(localLayoutParams);
  }
  
  public void d(View paramView, int paramInt1, int paramInt2)
  {
    b(paramView, paramInt1, paramInt2, false);
  }
  
  public void dismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubblePopupWindow", 2, "dismiss() called \n" + QLog.getStackTraceString(new RuntimeException()));
    }
    if ((isShowing()) && (this.Lf != null))
    {
      this.mIsShowing = false;
      ewI();
    }
    try
    {
      if (this.Lf.getParent() != null) {
        this.mWindowManager.removeViewImmediate(this.Lf);
      }
      return;
    }
    finally
    {
      if ((this.Lf != this.mContentView) && ((this.Lf instanceof ViewGroup))) {
        ((ViewGroup)this.Lf).removeView(this.mContentView);
      }
      this.Lf = null;
      if (this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow$b != null) {
        this.jdField_c_of_type_ComTencentWidgetBubblePopupWindow$b.onDismiss();
      }
    }
  }
  
  public void ewH()
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ct.getLayoutParams();
    localLayoutParams.leftMargin = 0;
    this.ct.setLayoutParams(localLayoutParams);
  }
  
  public View getContentView()
  {
    return this.mContentView;
  }
  
  public boolean isShowing()
  {
    return this.mIsShowing;
  }
  
  public boolean isSplitTouchEnabled()
  {
    if ((this.esx < 0) && (this.mContext != null)) {
      if (this.mContext.getApplicationInfo().targetSdkVersion < 11) {}
    }
    while (this.esx == 1)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    dismiss();
    if (this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$d != null) {
      this.jdField_b_of_type_ComTencentWidgetBubblePopupWindow$d.eeC();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setAnimationStyle(int paramInt)
  {
    this.esD = paramInt;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.mBackground = paramDrawable;
  }
  
  public void setContentView(View paramView)
  {
    if (isShowing()) {}
    do
    {
      return;
      this.mContentView = paramView;
      if ((this.mContext == null) && (this.mContentView != null)) {
        this.mContext = this.mContentView.getContext();
      }
    } while ((this.mWindowManager != null) || (this.mContentView == null));
    this.mWindowManager = ((WindowManager)this.mContext.getSystemService("window"));
  }
  
  public void setFocusable(boolean paramBoolean)
  {
    this.mFocusable = paramBoolean;
  }
  
  public void setHeight(int paramInt)
  {
    this.mHeight = paramInt;
  }
  
  public void setInputMethodMode(int paramInt)
  {
    this.esv = paramInt;
  }
  
  public void setOutsideTouchable(boolean paramBoolean)
  {
    this.djW = paramBoolean;
  }
  
  public void setSoftInputMode(int paramInt)
  {
    this.esw = paramInt;
  }
  
  public void setTouchModal(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.dkd = paramBoolean;
      return;
    }
  }
  
  public void setTouchable(boolean paramBoolean)
  {
    this.mTouchable = paramBoolean;
  }
  
  public void setWidth(int paramInt)
  {
    this.mWidth = paramInt;
  }
  
  public void showAsDropDown(View paramView)
  {
    showAsDropDown(paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    if ((isShowing()) || (this.mContentView == null)) {
      return;
    }
    G(paramView, paramInt1, paramInt2);
    this.mIsShowing = true;
    this.djV = true;
    WindowManager.LayoutParams localLayoutParams = a(paramView.getWindowToken());
    d(localLayoutParams);
    a(paramView, localLayoutParams, paramInt1, paramInt2);
    if (this.esz < 0)
    {
      paramInt1 = this.esz;
      this.mLastHeight = paramInt1;
      localLayoutParams.height = paramInt1;
    }
    if (this.esy < 0)
    {
      paramInt1 = this.esy;
      this.mLastWidth = paramInt1;
      localLayoutParams.width = paramInt1;
    }
    localLayoutParams.windowAnimations = OM();
    e(localLayoutParams);
  }
  
  public void update()
  {
    int j = 1;
    if ((!isShowing()) || (this.mContentView == null)) {}
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.Lf.getLayoutParams();
      int i = 0;
      int k = OM();
      if (k != localLayoutParams.windowAnimations)
      {
        localLayoutParams.windowAnimations = k;
        i = 1;
      }
      k = ld(localLayoutParams.flags);
      if (k != localLayoutParams.flags)
      {
        localLayoutParams.flags = k;
        i = j;
      }
      while (i != 0)
      {
        this.mWindowManager.updateViewLayout(this.Lf, localLayoutParams);
        return;
      }
    }
  }
  
  public void update(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    boolean bool2 = true;
    if (paramInt3 != -1)
    {
      this.mLastWidth = paramInt3;
      setWidth(paramInt3);
    }
    if (paramInt4 != -1)
    {
      this.mLastHeight = paramInt4;
      setHeight(paramInt4);
    }
    if ((!isShowing()) || (this.mContentView == null)) {}
    label282:
    label290:
    label291:
    for (;;)
    {
      return;
      WindowManager.LayoutParams localLayoutParams = (WindowManager.LayoutParams)this.Lf.getLayoutParams();
      int i;
      if (this.esy < 0)
      {
        i = this.esy;
        boolean bool1 = paramBoolean;
        if (paramInt3 != -1)
        {
          bool1 = paramBoolean;
          if (localLayoutParams.width != i)
          {
            this.mLastWidth = i;
            localLayoutParams.width = i;
            bool1 = true;
          }
        }
        if (this.esz >= 0) {
          break label282;
        }
        paramInt3 = this.esz;
        label127:
        paramBoolean = bool1;
        if (paramInt4 != -1)
        {
          paramBoolean = bool1;
          if (localLayoutParams.height != paramInt3)
          {
            this.mLastHeight = paramInt3;
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
        paramInt1 = OM();
        if (paramInt1 != localLayoutParams.windowAnimations)
        {
          localLayoutParams.windowAnimations = paramInt1;
          paramBoolean = true;
        }
        paramInt1 = ld(localLayoutParams.flags);
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
        this.mWindowManager.updateViewLayout(this.Lf, localLayoutParams);
        return;
        i = this.mLastWidth;
        break;
        paramInt3 = this.mLastHeight;
        break label127;
      }
    }
  }
  
  class PopupViewContainer
    extends FrameLayout
  {
    View Lg = null;
    
    public PopupViewContainer(Context paramContext)
    {
      super();
    }
    
    private void a(View paramView1, View paramView2, Rect paramRect)
    {
      if (paramView1 == paramView2) {
        return;
      }
      paramRect.top += paramView1.getTop();
      paramRect.bottom += paramView1.getTop();
      paramRect.left += paramView1.getLeft();
      paramRect.right += paramView1.getLeft();
      a((View)paramView1.getParent(), paramView2, paramRect);
    }
    
    private View m(View paramView)
    {
      if (paramView.isPressed()) {
        return paramView;
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          View localView = m(paramView.getChildAt(i));
          if (localView != null) {
            return localView;
          }
          i += 1;
        }
      }
      return null;
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      boolean bool = true;
      if (paramKeyEvent.getKeyCode() == 4)
      {
        if (getKeyDispatcherState() == null) {
          bool = super.dispatchKeyEvent(paramKeyEvent);
        }
        KeyEvent.DispatcherState localDispatcherState;
        do
        {
          return bool;
          if ((paramKeyEvent.getAction() != 0) || (paramKeyEvent.getRepeatCount() != 0)) {
            break;
          }
          localDispatcherState = getKeyDispatcherState();
        } while (localDispatcherState == null);
        localDispatcherState.startTracking(paramKeyEvent, this);
        return true;
        if (paramKeyEvent.getAction() == 1)
        {
          localDispatcherState = getKeyDispatcherState();
          if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
          {
            if (BubblePopupWindow.a(BubblePopupWindow.this) != null) {
              BubblePopupWindow.a(BubblePopupWindow.this).ewJ();
            }
            BubblePopupWindow.this.dismiss();
            return true;
          }
        }
        return super.dispatchKeyEvent(paramKeyEvent);
      }
      return super.dispatchKeyEvent(paramKeyEvent);
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if ((BubblePopupWindow.a(BubblePopupWindow.this) != null) && (BubblePopupWindow.a(BubblePopupWindow.this).onTouch(this, paramMotionEvent))) {
        return true;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      if (BubblePopupWindow.a(BubblePopupWindow.this) == null) {
        return bool;
      }
      View localView = m(BubblePopupWindow.b(BubblePopupWindow.this));
      int i;
      if ((this.Lg == null) && (localView == null))
      {
        i = 0;
        if ((i == 0) && ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)))
        {
          BubblePopupWindow.a(BubblePopupWindow.this).kX(0, 0);
          BubblePopupWindow.b(BubblePopupWindow.this).kX(0, 0);
          BubblePopupWindow.c(BubblePopupWindow.this).kX(0, 0);
          BubblePopupWindow.a(BubblePopupWindow.this).invalidate();
        }
        return bool;
      }
      this.Lg = localView;
      if (this.Lg != null)
      {
        this.Lg.scrollTo(0, 0);
        this.Lg.getDrawingRect(BubblePopupWindow.a(BubblePopupWindow.this));
        a(this.Lg, BubblePopupWindow.b(BubblePopupWindow.this), BubblePopupWindow.a(BubblePopupWindow.this));
        if (BubblePopupWindow.a(BubblePopupWindow.this).left != 0) {
          break label488;
        }
      }
      label315:
      label488:
      for (int j = 1;; j = 0)
      {
        if (BubblePopupWindow.a(BubblePopupWindow.this).right == BubblePopupWindow.b(BubblePopupWindow.this).getWidth()) {
          i = BubblePopupWindow.a(BubblePopupWindow.this).getWidth();
        }
        for (int k = 1;; k = 0)
        {
          if ((j == 0) || (k == 0))
          {
            this.Lg.getDrawingRect(BubblePopupWindow.a(BubblePopupWindow.this));
            a(this.Lg, BubblePopupWindow.a(BubblePopupWindow.this), BubblePopupWindow.a(BubblePopupWindow.this));
            if (j == 0)
            {
              j = BubblePopupWindow.a(BubblePopupWindow.this).left;
              if (k == 0) {
                i = BubblePopupWindow.a(BubblePopupWindow.this).right;
              }
            }
          }
          for (;;)
          {
            BubblePopupWindow.a(BubblePopupWindow.this).kX(j, i);
            BubblePopupWindow.b(BubblePopupWindow.this).kX(j - BubblePopupWindow.a(BubblePopupWindow.this).getLeft(), i - BubblePopupWindow.a(BubblePopupWindow.this).getLeft());
            BubblePopupWindow.c(BubblePopupWindow.this).kX(j - BubblePopupWindow.b(BubblePopupWindow.this).getLeft(), i - BubblePopupWindow.b(BubblePopupWindow.this).getLeft());
            for (i = 0;; i = 1)
            {
              BubblePopupWindow.a(BubblePopupWindow.this).invalidate();
              break;
              BubblePopupWindow.a(BubblePopupWindow.this).kX(0, 0);
              BubblePopupWindow.b(BubblePopupWindow.this).kX(0, 0);
              BubblePopupWindow.c(BubblePopupWindow.this).kX(0, 0);
            }
            continue;
            j = 0;
            break label315;
            j = 0;
          }
          i = 0;
        }
      }
    }
    
    @TargetApi(8)
    protected void onConfigurationChanged(Configuration paramConfiguration)
    {
      super.onConfigurationChanged(paramConfiguration);
      BubblePopupWindow.this.dismiss();
    }
    
    protected int[] onCreateDrawableState(int paramInt)
    {
      if (BubblePopupWindow.a(BubblePopupWindow.this))
      {
        int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
        View.mergeDrawableStates(arrayOfInt, BubblePopupWindow.tp);
        return arrayOfInt;
      }
      return super.onCreateDrawableState(paramInt);
    }
    
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= getWidth()) || (j < 0) || (j >= getHeight())))
      {
        BubblePopupWindow.this.dismiss();
        return true;
      }
      if (paramMotionEvent.getAction() == 4)
      {
        BubblePopupWindow.this.dismiss();
        return true;
      }
      return super.onTouchEvent(paramMotionEvent);
    }
    
    public void sendAccessibilityEvent(int paramInt)
    {
      if (BubblePopupWindow.b(BubblePopupWindow.this) != null)
      {
        BubblePopupWindow.b(BubblePopupWindow.this).sendAccessibilityEvent(paramInt);
        return;
      }
      super.sendAccessibilityEvent(paramInt);
    }
  }
  
  class a
    extends ProxyDrawable
  {
    int esG;
    int esH;
    
    public a(Drawable paramDrawable)
    {
      super();
    }
    
    public void draw(Canvas paramCanvas)
    {
      Rect localRect = getBounds();
      if (this.esH > this.esG)
      {
        int i = paramCanvas.save();
        paramCanvas.clipRect(this.esG, 0, this.esH, localRect.height());
        this.mCurrDrawable.draw(paramCanvas);
        paramCanvas.restoreToCount(i);
      }
    }
    
    public void kX(int paramInt1, int paramInt2)
    {
      this.esG = paramInt1;
      this.esH = paramInt2;
      invalidateSelf();
    }
  }
  
  public static abstract interface b
  {
    public abstract void onDismiss();
  }
  
  public static abstract interface c
  {
    public abstract void ewJ();
  }
  
  public static abstract interface d
  {
    public abstract void eeC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.BubblePopupWindow
 * JD-Core Version:    0.7.0.1
 */