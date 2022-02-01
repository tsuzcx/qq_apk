package com.tencent.gdtad.api.motivebrowsing;

import abdc;
import ajor;
import ajos;
import android.app.Activity;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelStoreOwner;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import aqha;
import aqju;
import aqzl;
import arcd;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.ark.API.ArkAppNotifyCenter;
import com.tencent.mobileqq.mvvm.LifeCycleFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;
import thx;
import thy;
import thz;
import tia;
import tic;
import tif;
import tir;
import wja;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingFragment;", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "()V", "countDownTime", "", "hasCountDownComplete", "", "lifeCycleFragment", "Lcom/tencent/mobileqq/mvvm/LifeCycleFragment;", "mModel", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "titleContainer", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingViewModel;", "doCreateLoopStep_Final", "extraData", "Landroid/os/Bundle;", "doOnBackEvent", "", "doOnCreate", "savedInstanceState", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/api/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initViewModel", "onDestroy", "onDialogCancelClick", "onDialogConfirmClick", "sendRewardedCallback", "shouldOverrideUrlLoading", "view", "Lcom/tencent/smtt/sdk/WebView;", "url", "", "watchTimeNotCompleteMention", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingFragment
  extends WebViewFragment
{
  public static final a a;
  private GdtMotiveBrowsingTitle jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
  private LifeCycleFragment jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
  private tic jdField_a_of_type_Tic;
  private tir jdField_a_of_type_Tir;
  private boolean aPf;
  private int bBv;
  private HashMap ee;
  private aqju m;
  
  static
  {
    jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingFragment$a = new a(null);
  }
  
  private final void a(tif paramtif)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "handleMotiveBrowsingData browsingData: " + paramtif);
    }
    int i = paramtif.component1();
    String str = paramtif.component2();
    int j = paramtif.component3();
    switch (i)
    {
    default: 
      return;
    case 0: 
      this.j.evaluateJavascript(str, (ValueCallback)thx.a);
      return;
    }
    if (j <= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.aPf = bool;
      paramtif = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
      if (paramtif == null) {
        Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
      }
      paramtif.zs(j);
      return;
    }
  }
  
  private final void bCY()
  {
    Object localObject = this.m;
    if (localObject != null) {
      ((aqju)localObject).dismiss();
    }
    this.m = aqha.a((Context)getActivity(), 0, null, (CharSequence)getResources().getString(2131694265), getResources().getString(2131694262), getResources().getString(2131694263), (DialogInterface.OnClickListener)new thy(this), (DialogInterface.OnClickListener)new thz(this));
    localObject = this.m;
    if (localObject != null)
    {
      ((aqju)localObject).show();
      localObject = ((aqju)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(7942);
        }
      }
      localObject = this.jdField_a_of_type_Tic;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((tic)localObject).aTH();
    }
    localObject = this.m;
    if (localObject != null) {
      ((aqju)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new tia(this));
    }
  }
  
  private final void bCZ()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick confirm");
    }
    aqju localaqju = this.m;
    if (localaqju != null) {
      localaqju.dismiss();
    }
    this.m = ((aqju)null);
  }
  
  private final void bDa()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "DialogInterface onClick onCancel");
    }
    bDb();
    super.biT();
  }
  
  private final void bDb()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "sendRewardedCallback");
    }
    Object localObject1 = this.jdField_a_of_type_Tir;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((tir)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if (((Collection)localObject2).isEmpty()) {
            break label164;
          }
        }
      }
    }
    label164:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject2 = new Intent((String)((List)localObject2).get(0));
        ((Intent)localObject2).putExtra("duration_time", this.bBv * 1000L);
        ((Intent)localObject2).putExtra("elapsed_time", this.bBv * 1000L);
        ((Intent)localObject2).putExtra("profitable_flag", this.aPf);
        ((Intent)localObject2).putExtra("KEY_MOTIVE_BROWSING", (String)localObject1);
        getActivity().sendBroadcast((Intent)localObject2);
      }
      return;
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
    localObject = ajos.a((ViewModelStoreOwner)localObject).get(tic.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ofViewModelProvider(life…ingViewModel::class.java)");
    this.jdField_a_of_type_Tic = ((tic)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
    }
    ArkAppNotifyCenter.setNotify("com.tencent.weather_v2", new WeakReference(new abdc((LifeCycleFragment)localObject)));
  }
  
  private final void initData()
  {
    Object localObject = this.intent.getSerializableExtra("data");
    if (!(localObject instanceof GdtMotiveVideoPageData))
    {
      getActivity().finish();
      return;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Tir = new tir((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
        localObject = this.jdField_a_of_type_Tir;
        if (localObject == null) {
          break label176;
        }
        localObject = ((tir)localObject).a();
        if (localObject == null) {
          break label176;
        }
        i = ((GdtMotiveVideoPageData)localObject).getVideoCountDown();
      }
      catch (Throwable localThrowable)
      {
        tic localtic;
        QLog.d("GdtMotiveBrowsingFragment", 1, localThrowable, new Object[0]);
        return;
      }
      this.bBv = j;
      localObject = this.jdField_a_of_type_Tic;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((tic)localObject).zt(this.bBv);
      localObject = this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleFragment;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("lifeCycleFragment");
      }
      localObject = (LifecycleOwner)localObject;
      localtic = this.jdField_a_of_type_Tic;
      if (localtic == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ajos.a((LifecycleOwner)localObject, (LiveData)localtic.t(), (Function1)new GdtMotiveBrowsingFragment.initData.1((GdtMotiveBrowsingFragment)this));
      return;
      label176:
      int i = 0;
      int j = i;
      if (i <= 0) {
        j = 15;
      }
    }
  }
  
  private final void initTitle()
  {
    Object localObject = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
    this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle = new GdtMotiveBrowsingTitle((Context)localObject);
    localObject = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingFragment.initTitle.1((GdtMotiveBrowsingFragment)this));
    localObject = (ViewGroup)this.jdField_a_of_type_Arcd.mRootView.findViewById(2131382187);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.jdField_a_of_type_ComTencentGdtadApiMotivebrowsingGdtMotiveBrowsingTitle;
    if (localGdtMotiveBrowsingTitle == null) {
      Intrinsics.throwUninitializedPropertyAccessException("titleContainer");
    }
    ((ViewGroup)localObject).addView((View)localGdtMotiveBrowsingTitle);
    int i = wja.dp2px(63.0F, getResources());
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = ImmersiveUtils.getStatusBarHeight((Context)getActivity()) + i;
    }
    for (;;)
    {
      this.j.setPadding(0, i, 0, 0);
      localObject = this.jdField_a_of_type_Aqzl.aK;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mSwiftTitleUI.titleContainer");
      ((ViewGroup)localObject).setVisibility(8);
      localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      ImmersiveUtils.clearCoverForStatus(((FragmentActivity)localObject).getWindow(), true);
      localObject = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
      ImmersiveUtils.setStatusTextColor(true, ((FragmentActivity)localObject).getWindow());
      return;
    }
  }
  
  public int a(@Nullable Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    initTitle();
    return i;
  }
  
  public void aQW()
  {
    if (this.ee != null) {
      this.ee.clear();
    }
  }
  
  public void biT()
  {
    if (!this.aPf)
    {
      bCY();
      return;
    }
    bDb();
    super.biT();
  }
  
  public boolean doOnCreate(@Nullable Bundle paramBundle)
  {
    boolean bool = super.doOnCreate(paramBundle);
    biN();
    initData();
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    aqju localaqju = this.m;
    if (localaqju != null) {
      localaqju.dismiss();
    }
    this.m = ((aqju)null);
  }
  
  public boolean shouldOverrideUrlLoading(@Nullable WebView paramWebView, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GdtMotiveBrowsingFragment", 2, "shouldOverrideUrlLoading " + paramString);
    }
    if ((this.isDestroyed) || (this.j == null)) {}
    while (paramString == null) {
      return true;
    }
    tic localtic = this.jdField_a_of_type_Tic;
    if (localtic == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    if (!localtic.a(paramString, this.jdField_a_of_type_Tir)) {
      return super.shouldOverrideUrlLoading(paramWebView, paramString);
    }
    return true;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/api/motivebrowsing/GdtMotiveBrowsingFragment$Companion;", "", "()V", "COUNT_DOWN_TOTAL_SECOND", "", "KEY_MOTIVE_BROWSING", "", "TAG", "startMotiveBrowsingActivity", "", "activity", "Landroid/app/Activity;", "data", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoPageData;", "intent", "Landroid/content/Intent;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
  public static final class a
  {
    public final void a(@NotNull Activity paramActivity, @NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData, @NotNull Intent paramIntent)
    {
      Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
      Intrinsics.checkParameterIsNotNull(paramGdtMotiveVideoPageData, "data");
      Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
      paramGdtMotiveVideoPageData = new tir(paramGdtMotiveVideoPageData);
      paramIntent.setClass((Context)paramActivity, QQBrowserActivity.class);
      paramIntent.putExtra("fragment_class", GdtMotiveBrowsingFragment.class.getCanonicalName());
      paramIntent.putExtra("url", paramGdtMotiveVideoPageData.b().dest_info.landing_page.get());
      paramIntent.putExtra("isTransparentTitle", true);
      GdtAd localGdtAd = paramGdtMotiveVideoPageData.a();
      Intrinsics.checkExpressionValueIsNotNull(localGdtAd, "modelData.gdtAd");
      paramIntent.putExtra("GdtWebReportQQ_TRACE_ID", localGdtAd.getTraceId());
      paramGdtMotiveVideoPageData = paramGdtMotiveVideoPageData.a();
      Intrinsics.checkExpressionValueIsNotNull(paramGdtMotiveVideoPageData, "modelData.gdtAd");
      paramIntent.putExtra("GdtWebReportQQ_ACTION_URL", paramGdtMotiveVideoPageData.getUrlForAction());
      paramActivity.startActivity(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment
 * JD-Core Version:    0.7.0.1
 */