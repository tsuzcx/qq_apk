package com.tencent.biz.pubaccount.readinjoy.viola;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Scroller;
import android.widget.TextView;
import ankt;
import aqnm;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.ui.dom.style.CornerViewOutlineProvider;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import kbp;
import nti;
import ntj;
import ntk;
import ntl;
import ntm;
import ntn;
import nto;
import org.json.JSONObject;

public class CommonSuspensionGestureLayout
  extends FrameLayout
  implements View.OnTouchListener
{
  public static int bcr;
  public static int bcs = 1;
  public static int bct = 2;
  public static int bcu = 3;
  public static int bcv = 4;
  public static int bcw = 5;
  public static int bcx = 500;
  public static int bcy = 300;
  private Bundle F;
  private Boolean I = Boolean.valueOf(false);
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  private a jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a;
  private b jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b;
  private ObjectAnimator aE;
  private FrameLayout at;
  private boolean auA = true;
  private boolean auB;
  private boolean auC = true;
  private boolean auD = true;
  private boolean auE;
  private boolean auF;
  private boolean auG;
  private boolean auH;
  private boolean auI;
  private boolean auJ = true;
  private boolean auz = true;
  private int bcA = -1;
  private int bcB;
  private int bcC;
  private int bcD;
  private int bcE = -1;
  private int bcF;
  private int bcz = 120;
  private ViewGroup ca;
  private ViewGroup cb;
  private LinearLayout es;
  private AnimationSet g;
  float lastX;
  float lastY;
  private float lr;
  float ls;
  float lt;
  private Activity mActivity;
  private int mBorderRadius = 10;
  private View mBottomView;
  private View mContainerView;
  private Context mContext;
  private int mCurrentState;
  Scroller mScroller;
  private VelocityTracker mVelocityTracker;
  private View mY;
  private View mZ;
  private View na;
  private TranslateAnimation x;
  private TranslateAnimation y;
  private long yh;
  
  public CommonSuspensionGestureLayout(Context paramContext, Bundle paramBundle)
  {
    super(paramContext, null, 0);
    this.F = paramBundle;
    if ((this.F != null) && (this.F.containsKey("float_layer_back_view"))) {
      this.auE = this.F.getBoolean("float_layer_back_view", false);
    }
    if ((this.F != null) && (this.F.containsKey("margin_top"))) {
      this.bcz = this.F.getInt("margin_top", 120);
    }
    if ((this.F != null) && (this.F.containsKey("scroll_to_top"))) {
      this.auA = this.F.getBoolean("scroll_to_top", true);
    }
    setOnTouchListener(this);
    this.mContext = paramContext;
    baZ();
    bba();
    bbb();
    setOnClickListener(new nti(this));
    this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new ntl(this);
    addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
  }
  
  private boolean Gb()
  {
    return (this.mCurrentState == bcv) || (this.mCurrentState == bcu);
  }
  
  private void aHb()
  {
    if (this.mContainerView == null) {
      return;
    }
    if (this.mCurrentState == bcw)
    {
      this.mCurrentState = bcr;
      return;
    }
    int i = this.mContainerView.getScrollY();
    float f = this.mVelocityTracker.getYVelocity(0);
    if (QLog.isColorLevel()) {
      QLog.d("CommonSuspensionGestureLayout", 2, "closeOrSpringBack judge deltaY:" + i + ",velocityY:" + f + ",mCanCloseFromBottom:" + this.I + " , mStateBottomTime " + (System.currentTimeMillis() - this.yh) + ", mInterceptDeltaY " + this.lr);
    }
    if (this.auA)
    {
      if (((i < -bcx) && (f > -100.0F)) || ((i < -50) && (f >= 2800.0F)))
      {
        if (this.auB)
        {
          f(0, -aqnm.dpToPx(this.bcz), 200, false);
          bbg();
          return;
        }
        dr(i, 1);
        return;
      }
      if (((i > bcy) || (f < -6500.0F)) && (this.I.booleanValue()) && (f < 100.0F) && (System.currentTimeMillis() - this.yh >= 200L) && (this.lr < 0.0F) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()))
      {
        ui(i);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) {
        if ((this.bcF < 0) && (this.bcF > -aqnm.dpToPx(this.bcz))) {
          if (this.bcF <= -aqnm.dpToPx(this.bcz)) {}
        }
      }
      for (;;)
      {
        this.mCurrentState = bcr;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.mT(this.mCurrentState);
        return;
        f(0, -aqnm.dpToPx(this.bcz), 200, false);
        bbg();
        continue;
        if ((this.bcF == 0) && (i < -aqnm.dpToPx(this.bcz)))
        {
          f(0, -aqnm.dpToPx(this.bcz), 200, false);
          bbg();
          continue;
          f(0, -aqnm.dpToPx(this.bcz), 200, true);
        }
      }
    }
    if (((i < -bcx) && (f > -100.0F)) || ((i < -50) && (f >= 2800.0F)))
    {
      dr(i, 1);
      return;
    }
    if (((i > bcy) || (f < -6500.0F)) && (this.I.booleanValue()) && (f < 100.0F) && (System.currentTimeMillis() - this.yh >= 200L) && (this.lr < 0.0F) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()))
    {
      ui(i);
      return;
    }
    f(0, -aqnm.dpToPx(this.bcz), 200, true);
    this.mCurrentState = bcr;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.mT(this.mCurrentState);
  }
  
  private void b(FrameLayout paramFrameLayout)
  {
    if (this.auC)
    {
      this.at = new FrameLayout(getContext());
      this.at.setLayoutParams(new FrameLayout.LayoutParams(-1, aqnm.dpToPx(20.0F)));
      this.at.setBackgroundColor(this.bcA);
      View localView = new View(getContext());
      int i = Color.parseColor("#FFB0B3BF");
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(aqnm.dpToPx(60.0F), aqnm.dpToPx(4.0F));
      localLayoutParams.gravity = 17;
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(66.0F);
      localGradientDrawable.setColor(i);
      localView.setBackgroundDrawable(localGradientDrawable);
      localView.setLayoutParams(localLayoutParams);
      this.at.addView(localView);
      dn(this.at);
      paramFrameLayout.addView(this.at);
    }
  }
  
  private void baZ()
  {
    this.mZ = new View(getContext());
    this.mZ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mZ.setBackgroundColor(Color.parseColor("#66000000"));
    addView(this.mZ);
  }
  
  private void bba()
  {
    if ((this.auE) && (this.es == null))
    {
      this.es = new LinearLayout(getContext());
      Object localObject1 = new FrameLayout.LayoutParams(-2, -2);
      ((FrameLayout.LayoutParams)localObject1).setMargins(0, aqnm.dpToPx(40.0F), 0, 0);
      this.es.setOrientation(0);
      this.es.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.es.setBackgroundResource(2130850358);
      localObject1 = new TextView(getContext());
      Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject2).setMargins(aqnm.dpToPx(12.0F), 0, 0, 0);
      ((LinearLayout.LayoutParams)localObject2).gravity = 16;
      ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ((TextView)localObject1).setTextSize(2, 14.0F);
      ((TextView)localObject1).setText("返回");
      localObject2 = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.setMargins(aqnm.dpToPx(6.0F), 0, 0, 0);
      localLayoutParams.gravity = 16;
      ((ImageView)localObject2).setLayoutParams(localLayoutParams);
      ((ImageView)localObject2).setBackgroundResource(2130850357);
      this.es.addView((View)localObject1);
      this.es.addView((View)localObject2);
      addView(this.es);
      this.es.setOnClickListener(new ntj(this));
    }
  }
  
  private void bbb()
  {
    if (this.g == null)
    {
      this.g = ((AnimationSet)AnimationUtils.loadAnimation(getContext(), 2130772128));
      this.g.setDuration(200L);
      this.g.setInterpolator(new AccelerateDecelerateInterpolator());
      this.g.setAnimationListener(new ntk(this));
    }
  }
  
  private void bbc()
  {
    this.ca.addView(this, this.bcB);
  }
  
  private void bbd()
  {
    this.mContainerView.startAnimation(this.g);
  }
  
  private void bbe()
  {
    qf(false);
  }
  
  private void bbf()
  {
    if ((this.na != null) && ((this.na.getAlpha() != 1.0F) || (this.na.getVisibility() != 0)))
    {
      this.auH = false;
      if ((this.aE != null) && (!this.aE.isRunning()))
      {
        baY();
        c(true, this.na);
      }
    }
  }
  
  private void bbg()
  {
    if ((this.at != null) && (this.at.getVisibility() != 0)) {
      this.at.setVisibility(0);
    }
    dn(this.mY);
    this.auB = false;
    this.auH = false;
    if ((this.na != null) && (this.na.getVisibility() != 8)) {
      this.na.setVisibility(8);
    }
  }
  
  private void bbi()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.F != null) && (this.F.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.F.get("floating_window_business"));
      }
      if ((this.F != null) && (this.F.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.F.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    kbp.a(null, null, "0X800A9B6", "0X800A9B6", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private void bbj()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.F != null) && (this.F.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.F.get("floating_window_business"));
      }
      if ((this.F != null) && (this.F.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.F.get("floating_window_scene"));
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    kbp.a(null, null, "0X800A9B7", "0X800A9B7", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  private void c(boolean paramBoolean, View paramView)
  {
    paramView.setVisibility(0);
    paramView.setLayerType(2, null);
    if (paramBoolean) {}
    for (this.aE = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 0.0F, 1.0F });; this.aE = ObjectAnimator.ofFloat(paramView, View.ALPHA, new float[] { 1.0F, 0.0F }))
    {
      this.aE.addListener(new nto(this, paramView));
      this.aE.setDuration(250L);
      this.aE.setInterpolator(new LinearInterpolator());
      this.aE.start();
      return;
    }
  }
  
  private void dn(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 21) && (this.mBorderRadius != 0))
    {
      paramView.setOutlineProvider(new CornerViewOutlineProvider(aqnm.dpToPx(this.mBorderRadius), FlexConvertUtils.getScreenHeight(getContext()) - aqnm.dpToPx(this.bcz), 1));
      paramView.setClipToOutline(true);
    }
  }
  
  private void ds(int paramInt1, int paramInt2)
  {
    c(true, this.mZ);
    bbc();
    if (paramInt1 != -1) {
      ug(paramInt1);
    }
    if (paramInt2 != -1) {
      uh(paramInt2);
    }
  }
  
  private void f(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(this.mContext);
    }
    if (this.mContainerView == null) {}
    while (this.mCurrentState == bcw) {
      return;
    }
    int i = this.mContainerView.getScrollX();
    int j = this.mContainerView.getScrollY();
    if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) && ((j > 0) || (j >= bcy)))
    {
      this.mCurrentState = bcw;
      this.mContainerView.scrollTo(0, 0);
      postInvalidate();
      return;
    }
    if ((j < 0) && (j > -bcx))
    {
      this.mCurrentState = bcs;
      if ((!Gb()) || (this.lr <= 0.0F) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) || (paramBoolean)) {
        break label264;
      }
      this.mCurrentState = bcw;
      this.mContainerView.scrollTo(0, -aqnm.dpToPx(this.bcz));
      bbg();
      postInvalidate();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.mT(this.mCurrentState);
      return;
      if (j <= -bcx)
      {
        this.mCurrentState = bct;
        break;
      }
      if ((j > 0) && (j < bcy))
      {
        this.mCurrentState = bcu;
        break;
      }
      if (j < bcy) {
        break;
      }
      this.mCurrentState = bcv;
      break;
      label264:
      this.mScroller.startScroll(i, j, paramInt1 - i, paramInt2 - j, paramInt3);
      invalidate();
    }
  }
  
  public static int getNavigationBarHeight(Activity paramActivity)
  {
    for (int i = 0;; i = 0) {
      try
      {
        if (ankt.bA(paramActivity.getApplicationContext()))
        {
          int j = ankt.getNavigationBarHeight(paramActivity.getApplicationContext());
          i = j;
          int k;
          label174:
          return i;
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          QLog.d("CommonSuspensionGestureLayout", 1, "getNavigationBarHeight " + i + ",isNavShow:" + isNavigationBarExist(paramActivity) + ",build name:" + Build.MANUFACTURER + "，build module:" + Build.MODEL + ",getContentHeight:" + n(paramActivity) + ",screenHeight:" + DisplayUtil.getScreenHeight(paramActivity));
          if (i == 0) {
            continue;
          }
          if (!isNavigationBarExist(paramActivity)) {
            return 0;
          }
          if ((!Build.MANUFACTURER.contains("OnePlus")) || (!Build.MODEL.contains("HD1900")) || (n(paramActivity) < DisplayUtil.getScreenHeight(paramActivity))) {
            continue;
          }
          j = n(paramActivity);
          k = DisplayUtil.getScreenHeight(paramActivity);
          return j - k;
        }
        catch (Exception paramActivity)
        {
          break label174;
        }
        paramActivity = paramActivity;
        QLog.e("CommonSuspensionGestureLayout", 1, "getNavigationBarHeight error:" + paramActivity.getMessage());
        paramActivity.printStackTrace();
        return i;
      }
    }
  }
  
  public static boolean isNavigationBarExist(Activity paramActivity)
  {
    boolean bool2 = false;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    boolean bool1 = bool2;
    int i;
    if (localViewGroup != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < localViewGroup.getChildCount())
      {
        localViewGroup.getChildAt(i).getContext().getPackageName();
        if ((localViewGroup.getChildAt(i).getId() != -1) && ("navigationBarBackground".equals(paramActivity.getResources().getResourceEntryName(localViewGroup.getChildAt(i).getId()))) && (localViewGroup.getChildAt(i).getHeight() != 0)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isXiaoMi()
  {
    return (Build.MANUFACTURER.contains("Xiaomi")) && ((Build.MODEL.contains("MIX 2S")) || (Build.MODEL.contains("MI 8")) || (Build.MODEL.contains("MI 9")) || (Build.MODEL.contains("MIX 2")) || (Build.MODEL.contains("MIX 3")));
  }
  
  public static int n(Activity paramActivity)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null) && (paramActivity.getWindow().getDecorView() != null))
    {
      Rect localRect = new Rect();
      paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
      return localRect.height();
    }
    return 0;
  }
  
  private void qe(boolean paramBoolean)
  {
    this.cb = ((ViewGroup)this.na.getParent());
    this.cb.removeView(this.na);
    FrameLayout.LayoutParams localLayoutParams;
    if (this.auA)
    {
      addView(this.na);
      localLayoutParams = (FrameLayout.LayoutParams)this.na.getLayoutParams();
      if (!this.auG) {
        break label130;
      }
      localLayoutParams.height = (this.bcC + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
      localLayoutParams.topMargin = 0;
      this.na.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
      this.na.setLayoutParams(localLayoutParams);
    }
    for (;;)
    {
      if (paramBoolean) {
        this.mContainerView.setPadding(0, this.bcC, 0, 0);
      }
      this.na.setVisibility(8);
      return;
      label130:
      localLayoutParams.topMargin = ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext());
      this.na.setLayoutParams(localLayoutParams);
    }
  }
  
  private void qf(boolean paramBoolean)
  {
    if (this.na == null)
    {
      if ((this.at != null) && (this.at.getVisibility() != 8)) {
        this.at.setVisibility(8);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.mY.setOutlineProvider(null);
        this.mY.setClipToOutline(false);
      }
    }
    this.auB = true;
    if ((this.na != null) && ((this.na.getAlpha() != 1.0F) || (this.na.getVisibility() != 0) || (paramBoolean)))
    {
      this.auH = false;
      if ((this.aE != null) && ((!this.aE.isRunning()) || (paramBoolean))) {
        c(true, this.na);
      }
    }
    bbj();
  }
  
  private void uj(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if ((this.F != null) && (this.F.containsKey("floating_window_business"))) {
        localJSONObject.put("Float_type", this.F.get("floating_window_business"));
      }
      if ((this.F != null) && (this.F.containsKey("floating_window_scene"))) {
        localJSONObject.put("source", this.F.get("floating_window_scene"));
      }
      localJSONObject.put("type", paramInt);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    kbp.a(null, null, "0X800A9B8", "0X800A9B8", 0, 0, "", "", "", localJSONObject.toString(), false);
  }
  
  public boolean Gc()
  {
    return this.mContainerView.getScrollY() >= 0;
  }
  
  public boolean Gd()
  {
    return this.auE;
  }
  
  public boolean Ge()
  {
    return this.auA;
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
  {
    a(paramBaseActivity, paramInt1, paramInt2, false);
  }
  
  public void a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.mActivity = paramBaseActivity;
    this.mContainerView = ((ViewGroup)paramBaseActivity.getWindow().getDecorView()).getChildAt(0);
    if ((this.mContainerView.getParent() instanceof ViewGroup))
    {
      this.ca = ((ViewGroup)this.mContainerView.getParent());
      this.bcB = this.ca.indexOfChild(this.mContainerView);
      paramBaseActivity = new FrameLayout(getContext());
      this.ca.removeView(this.mContainerView);
      paramBaseActivity.addView(this.mContainerView);
      paramBaseActivity.setBackgroundColor(0);
      this.mY = this.mContainerView;
      this.mContainerView = paramBaseActivity;
      b(paramBaseActivity);
      addView(paramBaseActivity);
      this.mContainerView.scrollTo(0, -aqnm.dpToPx(this.bcz));
      this.bcF = (-aqnm.dpToPx(this.bcz));
      this.mY.setBackgroundColor(this.bcA);
    }
    dn(this.mY);
    if ((this.auA) && (this.bcC != 0)) {
      this.mContainerView.setPadding(0, this.bcC, 0, 0);
    }
    if (this.auD)
    {
      if (paramBoolean)
      {
        ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.5(this, paramInt1, paramInt2), 150L);
        return;
      }
      ds(paramInt1, paramInt2);
      bbd();
      return;
    }
    ds(paramInt1, paramInt2);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.aZl();
    }
    bbi();
  }
  
  public boolean a(float paramFloat, MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSuspensionGestureLayout", 2, "test isAllowedInterceptTouchEvent,positionState:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.qI() + ",deltaY:" + paramFloat + ",event:" + paramMotionEvent.getAction());
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a != null) && (paramMotionEvent.getAction() != 0))
    {
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.qI();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.tM(i);
      if ((i == 1) && (paramFloat > 5.0F)) {
        this.yh = 0L;
      }
      do
      {
        return true;
        if ((i != 2) || (paramFloat >= 0.0F) || (!this.I.booleanValue())) {
          break;
        }
      } while (this.yh != 0L);
      this.yh = System.currentTimeMillis();
      return true;
      if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) && (paramFloat < -10.0F))
      {
        this.yh = 0L;
        return true;
      }
      this.yh = 0L;
      return false;
    }
    return false;
  }
  
  public void baY()
  {
    if ((this.auA) && (this.na != null) && (this.auG) && ((this.na.getLayoutParams() instanceof FrameLayout.LayoutParams)))
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.na.getLayoutParams();
      if (localLayoutParams.height != this.bcC + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()))
      {
        localLayoutParams.height = (this.bcC + ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()));
        localLayoutParams.topMargin = 0;
        this.na.setPadding(0, ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()), 0, 0);
        this.na.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void bbh()
  {
    f(0, 0, 100, true);
    bbe();
    bbf();
  }
  
  public void bbk()
  {
    if ((this.mY != null) && (this.mBottomView != null)) {
      if (this.mBottomView.getVisibility() != 8) {
        break label95;
      }
    }
    label95:
    for (int i = 0;; i = this.mBottomView.getHeight())
    {
      int j = i;
      if (!this.auA)
      {
        j = i;
        if (this.bcz > 0) {
          j = i + aqnm.dpToPx(this.bcz);
        }
      }
      this.mY.setPadding(0, 0, 0, j);
      QLog.d("CommonSuspensionGestureLayout", 1, "heightPadding " + j);
      return;
    }
  }
  
  public void bbl()
  {
    uj(4);
  }
  
  public void bbm()
  {
    this.auI = true;
    this.auJ = this.auA;
    this.auA = true;
    bbh();
  }
  
  public void bbn()
  {
    this.auI = false;
    this.auA = this.auJ;
    if (!this.auA)
    {
      f(0, -aqnm.dpToPx(this.bcz), 200, false);
      bbg();
    }
  }
  
  public void c(View paramView, float paramFloat)
  {
    this.na = paramView;
    if ((this.na != null) && ((this.na.getParent() instanceof ViewGroup)) && (this.bcE != paramView.hashCode()))
    {
      this.bcE = paramView.hashCode();
      this.na.setVisibility(4);
      if (this.bcC != 0) {
        qe(false);
      }
    }
    else
    {
      return;
    }
    this.bcC = ((int)paramFloat);
    if (this.bcC == 0)
    {
      this.na.post(new CommonSuspensionGestureLayout.3(this));
      return;
    }
    qe(true);
  }
  
  public void computeScroll()
  {
    if (this.mScroller == null) {
      this.mScroller = new Scroller(this.mContext);
    }
    if (this.mContainerView == null) {}
    do
    {
      return;
      if (this.mScroller.computeScrollOffset())
      {
        if (!this.auA) {
          if (Math.abs(this.mScroller.getCurrY()) >= aqnm.dpToPx(this.bcz)) {}
        }
        for (;;)
        {
          postInvalidate();
          return;
          this.mContainerView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
          continue;
          if ((this.mContainerView.getScrollY() <= 0) && (this.mScroller.getCurrY() > 0))
          {
            this.mContainerView.scrollTo(this.mScroller.getCurrX(), 0);
            bbe();
            bbf();
          }
          else
          {
            this.mContainerView.scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
          }
        }
      }
    } while ((this.mContainerView.getScrollY() != 0) || (this.mCurrentState == bcr));
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new CommonSuspensionGestureLayout.6(this), 32L);
  }
  
  public void destroy()
  {
    if (this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener != null) {
      removeOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if (paramMotionEvent.getAction() == 0) {
      this.bcF = this.mContainerView.getScrollY();
    }
    if (this.auI) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ())
    {
      if ((paramMotionEvent.getAction() != 0) && (paramMotionEvent.getAction() != 2))
      {
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f = this.mVelocityTracker.getYVelocity(0);
        if ((this.mContainerView.getScrollY() != -aqnm.dpToPx(this.bcz)) && (f < 0.0F)) {
          f(0, -aqnm.dpToPx(this.bcz), 200, false);
        }
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if ((this.auA) && (paramMotionEvent.getAction() != 0))
    {
      if (this.bcF >= 0) {
        break label416;
      }
      if (paramMotionEvent.getAction() != 2) {
        break label339;
      }
      if ((this.mContainerView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.mContainerView.getScrollY()))) {
        return super.dispatchTouchEvent(paramMotionEvent);
      }
      if (this.lt != 0.0F) {
        f = paramMotionEvent.getRawY() - this.lt;
      }
      this.ls = f;
      if (this.ls < -3.0F)
      {
        i = (int)(this.mContainerView.getScrollY() - this.ls);
        if (i >= 0) {
          break label328;
        }
        f(0, i, 0, true);
        if ((this.na != null) && (this.na.getVisibility() != 0) && (Math.abs(this.mContainerView.getScrollY()) <= this.bcC)) {
          bbf();
        }
      }
    }
    label328:
    label339:
    while ((!this.auB) || (this.auH) || (this.na == null)) {
      for (;;)
      {
        int i;
        this.lt = paramMotionEvent.getRawY();
        return super.dispatchTouchEvent(paramMotionEvent);
        f(0, 0, 0, true);
        continue;
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f = this.mVelocityTracker.getYVelocity(0);
        if (Math.abs(this.mContainerView.getScrollY()) <= this.bcC) {
          bbh();
        } else if ((f < 0.0F) && (Math.abs(f) >= 3500.0F) && (this.mCurrentState != bcw)) {
          bbh();
        }
      }
    }
    label416:
    if (this.lt != 0.0F) {}
    for (f = paramMotionEvent.getRawY() - this.lt;; f = 0.0F)
    {
      this.ls = f;
      if ((this.mContainerView.getScrollY() >= 0) || (this.ls <= 0.0F)) {
        break;
      }
      this.auH = true;
      c(false, this.na);
      break;
    }
  }
  
  public void dl(View paramView)
  {
    c(paramView, 0.0F);
  }
  
  public void dm(View paramView)
  {
    this.mBottomView = paramView;
    if ((this.mBottomView != null) && ((this.mBottomView.getParent() instanceof ViewGroup))) {
      this.mBottomView.post(new CommonSuspensionGestureLayout.4(this));
    }
  }
  
  public void dr(int paramInt1, int paramInt2)
  {
    if (!this.auz)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.W(true, paramInt1);
      return;
    }
    if (this.x == null) {
      this.x = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772013));
    }
    this.x.setAnimationListener(new ntm(this, paramInt1, paramInt2));
    this.x.setDuration(200L);
    this.x.setInterpolator(new AccelerateInterpolator());
    this.mContainerView.startAnimation(this.x);
    c(false, this.mZ);
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.mVelocityTracker != null) {
      this.mVelocityTracker.recycle();
    }
    destroy();
    super.onDetachedFromWindow();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f = 0.0F;
    if ((this.mContainerView == null) || (this.auI)) {
      return false;
    }
    if (this.lastY != 0.0F) {
      f = paramMotionEvent.getRawY() - this.lastY;
    }
    this.lr = f;
    this.lastX = paramMotionEvent.getRawX();
    this.lastY = paramMotionEvent.getRawY();
    return a(this.lr, paramMotionEvent);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.mContainerView == null) || (paramMotionEvent.getAction() == 0)) {
      return false;
    }
    if ((this.mContainerView.getScrollY() < 0) && (paramMotionEvent.getRawY() <= Math.abs(this.mContainerView.getScrollY())) && (this.mContainerView.getScrollY() >= -aqnm.dpToPx(this.bcz))) {
      return false;
    }
    if (this.mVelocityTracker == null) {
      this.mVelocityTracker = VelocityTracker.obtain();
    }
    this.mVelocityTracker.addMovement(paramMotionEvent);
    float f;
    if (this.lastY != 0.0F)
    {
      f = paramMotionEvent.getRawY() - this.lastY;
      this.lastX = paramMotionEvent.getRawX();
      this.lastY = paramMotionEvent.getRawY();
      switch (paramMotionEvent.getAction())
      {
      default: 
        this.mVelocityTracker.computeCurrentVelocity(1000);
        f = this.mVelocityTracker.getYVelocity(0);
        if ((!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) && (this.mContainerView.getScrollY() != -aqnm.dpToPx(this.bcz)) && (f < 0.0F)) {
          f(0, -aqnm.dpToPx(this.bcz), 200, false);
        }
        break;
      }
    }
    for (;;)
    {
      return true;
      f = 0.0F;
      break;
      int i = (int)(this.mContainerView.getScrollY() - f);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a.FJ()) {
        f(0, i, 0, false);
      }
      for (;;)
      {
        return true;
        if (i <= this.bcF) {
          f(0, i, 0, false);
        }
      }
      if (this.auA)
      {
        if (paramMotionEvent.getRawY() >= Math.abs(this.mContainerView.getScrollY()) + Math.abs(this.mContainerView.getPaddingTop())) {
          aHb();
        } else if (this.mContainerView.getScrollY() != 0) {
          dr(0, 2);
        }
      }
      else {
        aHb();
      }
    }
  }
  
  public int qX()
  {
    return this.bcC;
  }
  
  public void setBorderRadius(int paramInt)
  {
    this.mBorderRadius = paramInt;
  }
  
  public void setCanCloseFromBottom(boolean paramBoolean)
  {
    this.I = Boolean.valueOf(paramBoolean);
  }
  
  public void setContainerColor(int paramInt)
  {
    this.bcA = paramInt;
  }
  
  public void setContentMarginTop(int paramInt)
  {
    this.bcz = paramInt;
  }
  
  public void setContentScrollListener(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$a = parama;
  }
  
  public void setIsAutoSuctionTop(boolean paramBoolean)
  {
    this.auA = paramBoolean;
  }
  
  public void setIsNeedInterruptBack(boolean paramBoolean)
  {
    this.auF = paramBoolean;
  }
  
  public void setIsNeedPopAnim(boolean paramBoolean)
  {
    this.auD = paramBoolean;
  }
  
  public void setIsNeedShowBackView(boolean paramBoolean)
  {
    this.auE = paramBoolean;
    if (!this.auE)
    {
      if (this.es != null) {
        this.es.setVisibility(8);
      }
      return;
    }
    bba();
  }
  
  public void setIsShowGrayBar(boolean paramBoolean)
  {
    this.auC = paramBoolean;
  }
  
  public void setIsStatusImmersive(boolean paramBoolean)
  {
    this.auG = paramBoolean;
  }
  
  public void setIsUseDefaultAnim(boolean paramBoolean)
  {
    this.auz = paramBoolean;
  }
  
  public void setMaskBackGroundDrawable(Drawable paramDrawable)
  {
    if ((this.mActivity != null) && (this.mActivity.getWindow() != null)) {
      this.mActivity.getWindow().setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setTitleBarHeight(int paramInt)
  {
    this.bcC = aqnm.dpToPx(paramInt);
  }
  
  public void setViolaGestureListener(b paramb)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b = paramb;
  }
  
  public void ug(int paramInt)
  {
    this.na = this.mY.findViewById(paramInt);
    dl(this.na);
  }
  
  public void uh(int paramInt)
  {
    dm(this.mY.findViewById(paramInt));
  }
  
  public void ui(int paramInt)
  {
    if (!this.auz)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaCommonSuspensionGestureLayout$b.W(false, paramInt);
      return;
    }
    if (this.y == null) {
      this.y = ((TranslateAnimation)AnimationUtils.loadAnimation(getContext(), 2130772209));
    }
    this.y.setAnimationListener(new ntn(this, paramInt));
    this.y.setDuration(200L);
    this.y.setInterpolator(new AccelerateInterpolator());
    this.mContainerView.startAnimation(this.y);
    c(false, this.mZ);
  }
  
  public static abstract interface a
  {
    public abstract boolean FJ();
    
    public abstract int qI();
  }
  
  public static abstract interface b
  {
    public abstract void W(boolean paramBoolean, int paramInt);
    
    public abstract void aZl();
    
    public abstract void aZm();
    
    public abstract void aZn();
    
    public abstract void h(boolean paramBoolean, int paramInt1, int paramInt2);
    
    public abstract void mT(int paramInt);
    
    public abstract void tM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout
 * JD-Core Version:    0.7.0.1
 */