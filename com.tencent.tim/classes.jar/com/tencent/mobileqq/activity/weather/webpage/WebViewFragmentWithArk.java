package com.tencent.mobileqq.activity.weather.webpage;

import abcx;
import abdc;
import abdf;
import abdl;
import abdm;
import ajor;
import ajos;
import ajou;
import ajov;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqhu;
import aqzl;
import com.tencent.ark.open.ArkView;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.ui.TouchWebView.OnScrollChangedListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebViewFragmentWithArk;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "adCode", "", "appMeta", "appName", "appVersion", "appView", "arkLoadState", "", "arkViewWrapper", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherArkViewWrapper;", "curWebPageData", "Lcom/tencent/mobileqq/activity/weather/webpage/WebPageData;", "isPageLoadFinish", "", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "startLoadTime", "", "viewModel", "Lcom/tencent/mobileqq/activity/weather/webpage/WeatherWebArkViewModel;", "webViewWrapper", "Lcom/tencent/biz/ui/RefreshView;", "kotlin.jvm.PlatformType", "getWebViewWrapper", "()Lcom/tencent/biz/ui/RefreshView;", "webViewWrapper$delegate", "Lkotlin/Lazy;", "changeWhiteTitleStyle", "", "createBgImageIfNeed", "Landroid/widget/ImageView;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "initData", "initTitle", "initView", "initViewModel", "onArkLoadState", "state", "onArkViewTouchEvent", "event", "Landroid/view/MotionEvent;", "onCreate", "savedInstanceState", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onJsCall", "data", "onPageDataCall", "onPageFinished", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPause", "onRefreshViewOverScroll", "overScrollDistance", "onResume", "onWebBgChange", "bgUrl", "showActionSheet", "toWeatherOptionActivity", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class WebViewFragmentWithArk
  extends WebViewFragment
{
  public static final a a;
  private abdf jdField_a_of_type_Abdf;
  private abdl jdField_a_of_type_Abdl;
  private WeatherArkViewWrapper jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private String appName;
  private String appVersion;
  private String appView;
  private String avA;
  private boolean bBV;
  private String bfo;
  private int cnK;
  private HashMap ee;
  private final Lazy f = LazyKt.lazy((Function0)new WebViewFragmentWithArk.webViewWrapper.2(this));
  private long gY;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWebViewFragmentWithArk$a = new a(null);
  }
  
  private final void Bt(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onWebBgChange bgUrl: " + paramString);
    }
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      Object localObject1 = getResources();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "resources");
      Object localObject2 = ajou.g((Resources)localObject1, 2130839730);
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
      localObject2 = (ImageView)a().findViewById(2131382151);
      if (localObject2 != null) {
        ((ImageView)localObject2).setImageDrawable((Drawable)URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1));
      }
    }
  }
  
  private final void GV(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onArkLoadState state: " + paramInt);
    }
    this.cnK = paramInt;
    if (this.cnK == -1) {
      cBf();
    }
  }
  
  private final void GW(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onRefreshViewOverScroll  overScrollDistance: " + paramInt);
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localObject = ((WeatherArkViewWrapper)localObject).getLayoutParams();
    if ((localObject instanceof FrameLayout.LayoutParams))
    {
      ((FrameLayout.LayoutParams)localObject).topMargin = (-paramInt);
      WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (localWeatherArkViewWrapper == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      localWeatherArkViewWrapper.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private final void X(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onArkViewTouchEvent  event: " + paramMotionEvent);
    }
    a().dispatchTouchEvent(paramMotionEvent);
  }
  
  private final RefreshView a()
  {
    return (RefreshView)this.f.getValue();
  }
  
  private final void a(abdl paramabdl)
  {
    int i = paramabdl.component1();
    String str = paramabdl.component4();
    int j = paramabdl.component5();
    switch (i)
    {
    default: 
      return;
    case 0: 
      b(paramabdl);
      return;
    case 1: 
      Bt(str);
      return;
    }
    GV(j);
  }
  
  private final void b(abdl paramabdl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebViewFragmentWithArk", 2, "onJsCall data: " + paramabdl);
    }
    String str1 = paramabdl.component2();
    String str2 = paramabdl.component3();
    int i = paramabdl.component6();
    if ((!TextUtils.isEmpty((CharSequence)str1)) && (!TextUtils.isEmpty((CharSequence)str2)))
    {
      if (this.bBV)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebViewFragmentWithArk", 2, "onJsCall jsFunction: " + str1 + ", jsParam: " + str2);
        }
        this.j.callJs(str1, new String[] { str2 });
        paramabdl = null;
      }
      this.jdField_a_of_type_Abdl = paramabdl;
    }
    if (i > 0)
    {
      paramabdl = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramabdl == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramabdl.setArkHeight(wja.dp2px(i, getResources()));
    }
  }
  
  private final void biN()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment = ajor.a((FragmentActivity)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject = ajos.a((ViewModelStoreOwner)localObject).get(abdf.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ArkViewModel::class.java)");
    this.jdField_a_of_type_Abdf = ((abdf)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new abdc((LifeCycleFragment)localObject)));
  }
  
  private final void cBe()
  {
    abcx.a().E(null, "new_topbar_account_click");
    Intent localIntent = new Intent();
    localIntent.setClassName((Context)getActivity(), AccountDetailActivity.class.getName());
    localIntent.putExtra("uin", "2658655094");
    localIntent.putExtra("uinname", "QQ天气");
    localIntent.putExtra("uintype", 1008);
    localIntent.addFlags(67108864);
    getActivity().startActivity(localIntent);
    PublicAccountHandler.a(null, "2658655094", "Pb_account_lifeservice", "mp_msg_sys_2", "detail");
  }
  
  private final void cBf()
  {
    Object localObject1 = this.jdField_a_of_type_Aqzl;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((aqzl)localObject1).aK;
      if (localObject1 != null)
      {
        localObject1 = (ImageView)((ViewGroup)localObject1).findViewById(2131369600);
        if (localObject1 == null) {
          break label283;
        }
        localObject2 = ((ImageView)localObject1).getDrawable();
        label38:
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageResource(0);
        }
        if (localObject1 != null) {
          ((ImageView)localObject1).setImageDrawable(aqhu.d((Drawable)localObject2, -16777216));
        }
        localObject1 = this.jdField_a_of_type_Aqzl;
        if (localObject1 == null) {
          break label288;
        }
        localObject1 = ((aqzl)localObject1).rightViewImg;
        if (localObject1 == null) {
          break label288;
        }
      }
    }
    label283:
    label288:
    for (localObject1 = ((ImageView)localObject1).getDrawable();; localObject1 = null)
    {
      localObject2 = this.jdField_a_of_type_Aqzl;
      if (localObject2 != null)
      {
        localObject2 = ((aqzl)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setColorFilter(-16777216);
        }
      }
      localObject2 = this.jdField_a_of_type_Aqzl;
      if (localObject2 != null)
      {
        localObject2 = ((aqzl)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageResource(0);
        }
      }
      localObject2 = this.jdField_a_of_type_Aqzl;
      if (localObject2 != null)
      {
        localObject2 = ((aqzl)localObject2).rightViewImg;
        if (localObject2 != null) {
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_Aqzl.leftView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
      localObject1 = aqhu.d(((TextView)localObject1).getBackground(), -16777216);
      localObject2 = this.jdField_a_of_type_Aqzl;
      if (localObject2 != null)
      {
        localObject2 = ((aqzl)localObject2).leftView;
        if (localObject2 != null) {
          ajov.c((View)localObject2, (Drawable)localObject1);
        }
      }
      localObject1 = this.jdField_a_of_type_Aqzl;
      if (localObject1 != null)
      {
        localObject1 = ((aqzl)localObject1).centerView;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(-16777216);
        }
      }
      localObject1 = this.jdField_a_of_type_Aqzl;
      if (localObject1 != null)
      {
        localObject1 = ((aqzl)localObject1).aK;
        if (localObject1 != null) {
          ((ViewGroup)localObject1).setBackgroundColor(-1);
        }
      }
      localObject1 = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
      ImmersiveUtils.setStatusTextColor(true, ((FragmentActivity)localObject1).getWindow());
      return;
      localObject1 = null;
      break;
      localObject2 = null;
      break label38;
    }
  }
  
  private final void initData()
  {
    String str = getIntent().getStringExtra("appName");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_NAME)");
    this.appName = str;
    str = getIntent().getStringExtra("appVersion");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_VERSION)");
    this.appVersion = str;
    str = getIntent().getStringExtra("appMeta");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_META)");
    this.bfo = str;
    str = getIntent().getStringExtra("appView");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_APP_VIEW)");
    this.appView = str;
    str = getIntent().getStringExtra("adCode");
    Intrinsics.checkExpressionValueIsNotNull(str, "getIntent().getStringExtra(KEY_AD_CODE)");
    this.avA = str;
    long l1 = getIntent().getLongExtra("startClickTime", 0L);
    boolean bool = getIntent().getBooleanExtra("webProcessExist", false);
    long l2;
    if (l1 > 0L)
    {
      l2 = System.currentTimeMillis();
      if (!bool) {
        break label191;
      }
    }
    label191:
    for (str = "new_folder_prestart_open_times";; str = "new_folder_noprestart_open_times")
    {
      abcx.a().a(null, str, Long.valueOf(l2 - l1));
      return;
    }
  }
  
  private final void initTitle()
  {
    Object localObject1 = this.jdField_a_of_type_Aqzl.aK;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.titleContainer");
    localObject1 = ((ViewGroup)localObject1).getParent();
    if ((localObject1 instanceof ViewGroup))
    {
      ((ViewGroup)localObject1).removeView((View)this.jdField_a_of_type_Aqzl.aK);
      localObject1 = getView();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localObject1).addView((View)this.jdField_a_of_type_Aqzl.aK);
    }
    localObject1 = (ImageView)this.jdField_a_of_type_Aqzl.aK.findViewById(2131369600);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "secondImage");
    ajov.c((View)localObject1, null);
    ((ImageView)localObject1).setVisibility(0);
    ((ImageView)localObject1).setImageResource(2130851427);
    ajov.a((View)localObject1, (Function0)new WebViewFragmentWithArk.initTitle.1((WebViewFragmentWithArk)this));
    ((ImageView)localObject1).setContentDescription((CharSequence)getString(2131692146));
    Object localObject2 = ((ImageView)localObject1).getLayoutParams();
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject2 = (RelativeLayout.LayoutParams)localObject2;
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(11.0F, getResources());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(12.0F, getResources());
    ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localObject1 = this.jdField_a_of_type_Aqzl.leftView;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSwiftTitleUI.leftView");
    ((TextView)localObject1).setContentDescription((CharSequence)getString(2131691039));
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ImmersiveUtils.clearCoverForStatus(((FragmentActivity)localObject1).getWindow(), true);
    localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    ((FragmentActivity)localObject1).getIntent().removeExtra("isTransparentTitle");
  }
  
  private final void initView()
  {
    this.j.addScrollChangedListener((TouchWebView.OnScrollChangedListener)new abdm(this));
    this.j.setBackgroundColor(0);
    int j = (int)getResources().getDimension(2131299627);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + j;
    }
    Object localObject1 = this.j;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "webView");
    localObject1 = ((TouchWebView)localObject1).getLayoutParams();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
    }
    localObject1 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject1).topMargin = i;
    Object localObject2 = this.j;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "webView");
    ((TouchWebView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = t();
    localObject2 = getResources();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "resources");
    ((ImageView)localObject1).setImageDrawable(ajou.g((Resources)localObject2, 2130839730));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_Abdf;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    ajos.a((LifecycleOwner)localObject1, (LiveData)((abdf)localObject2).v(), (Function1)new WebViewFragmentWithArk.initView.2((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = a().z;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "webViewWrapper.onOverScrolledLiveData");
    ajos.a((LifecycleOwner)localObject1, (LiveData)localObject2, (Function1)new WebViewFragmentWithArk.initView.3((WebViewFragmentWithArk)this));
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    localObject1 = (LifecycleOwner)localObject1;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localObject2 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    ajos.a((LifecycleOwner)localObject1, (LiveData)((WeatherArkViewWrapper)localObject2).u(), (Function1)new WebViewFragmentWithArk.initView.4((WebViewFragmentWithArk)this));
  }
  
  private final ImageView t()
  {
    ImageView localImageView = (ImageView)a().findViewById(2131382151);
    if (localImageView != null)
    {
      if (!(localImageView.getParent() instanceof ViewGroup)) {
        break label119;
      }
      ViewParent localViewParent = localImageView.getParent();
      if (localViewParent == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
      }
      ((ViewGroup)localViewParent).removeView((View)localImageView);
    }
    label119:
    for (;;)
    {
      a().addView((View)localImageView, 0);
      return localImageView;
      localImageView = new ImageView((Context)getActivity());
      localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      localImageView.setId(2131382151);
      localImageView.setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, -1));
    }
  }
  
  public void Qq()
  {
    super.Qq();
    abcx.a().E(null, "new_topbar_share_click");
  }
  
  public int a(@Nullable Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    initTitle();
    initView();
    paramBundle = this.jdField_a_of_type_Abdf;
    if (paramBundle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    String str = this.avA;
    if (str == null) {
      Intrinsics.throwUninitializedPropertyAccessException("adCode");
    }
    paramBundle.Bo(str);
    return i;
  }
  
  public void aQW()
  {
    if (this.ee != null) {
      this.ee.clear();
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    biN();
    initData();
  }
  
  @NotNull
  public View onCreateView(@Nullable LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = new FrameLayout((Context)getActivity());
    paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    if ((WebAccelerateHelper.preloadBrowserView instanceof WebBrowserViewContainer))
    {
      paramViewGroup = WebAccelerateHelper.preloadBrowserView;
      if (paramViewGroup == null) {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.webview.swift.WebBrowserViewContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = ((WebBrowserViewContainer)paramViewGroup);
      WebAccelerateHelper.preloadBrowserView = (View)null;
      this.jdField_a_of_type_Arbz.cXZ = true;
    }
    for (;;)
    {
      paramViewGroup = new FrameLayout.LayoutParams(-1, -1);
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
      Intrinsics.checkExpressionValueIsNotNull(paramBundle, "contentView");
      paramBundle.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
      paramLayoutInflater.addView((View)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
      paramViewGroup = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "activity");
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper = new WeatherArkViewWrapper((Context)paramViewGroup);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramLayoutInflater.addView((View)paramViewGroup);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      paramViewGroup.a((ViewModelStoreOwner)paramBundle);
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
      }
      paramBundle = this.appName;
      if (paramBundle == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appName");
      }
      String str1 = this.appView;
      if (str1 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appView");
      }
      String str2 = this.appVersion;
      if (str2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appVersion");
      }
      String str3 = this.bfo;
      if (str3 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("appMeta");
      }
      paramViewGroup.y(paramBundle, str1, str2, str3);
      ix((View)paramLayoutInflater);
      paramLayoutInflater = (View)paramLayoutInflater;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer = new WebBrowserViewContainer((Context)super.getActivity());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", null);
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onDestroy();
  }
  
  public void onPageFinished(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.bBV = true;
    paramWebView = this.jdField_a_of_type_Abdl;
    if (paramWebView != null) {
      ((WebViewFragmentWithArk)this).b(paramWebView);
    }
    long l1 = System.currentTimeMillis();
    long l2 = this.gY;
    abcx.a().a(null, "new_webview_loading_times", Long.valueOf(l1 - l2));
  }
  
  public void onPageStarted(@Nullable WebView paramWebView, @Nullable String paramString, @Nullable Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.bBV = false;
    this.gY = System.currentTimeMillis();
  }
  
  public void onPause()
  {
    super.onPause();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    WeatherArkViewWrapper localWeatherArkViewWrapper = this.jdField_a_of_type_ComTencentMobileqqActivityWeatherWebpageWeatherArkViewWrapper;
    if (localWeatherArkViewWrapper == null) {
      Intrinsics.throwUninitializedPropertyAccessException("arkViewWrapper");
    }
    localWeatherArkViewWrapper.a().onResume();
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/activity/weather/webpage/WebViewFragmentWithArk$Companion;", "", "()V", "KEY_AD_CODE", "", "KEY_APP_META", "KEY_APP_NAME", "KEY_APP_VERSION", "KEY_APP_VIEW", "KEY_START_TIME", "KEY_WEB_PROCESS_EXIST", "TAG", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.webpage.WebViewFragmentWithArk
 * JD-Core Version:    0.7.0.1
 */