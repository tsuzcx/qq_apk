package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment.a;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import tip;
import tiq;
import tir;
import tje;
import tkw;
import tls;

public class GdtMotiveVideoFragment
  extends PublicBaseFragment
{
  private tir jdField_a_of_type_Tir;
  private tje jdField_a_of_type_Tje;
  private boolean aPg;
  
  public GdtMotiveVideoFragment()
  {
    tkw.d("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Bundle paramBundle, boolean paramBoolean)
  {
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (paramBundle == null))
    {
      tkw.i("GdtMotiveVideoFragment", "start error data:" + paramGdtMotiveVideoPageData);
      return;
    }
    paramBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    paramBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(paramBundle);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      tkw.e("GdtMotiveVideoFragment", "start gdt empty refId");
    }
    if (a(paramGdtMotiveVideoPageData))
    {
      GdtMotiveBrowsingFragment.a.a(paramActivity, paramGdtMotiveVideoPageData, localIntent);
      return;
    }
    if (paramGdtMotiveVideoPageData.containerType == 1)
    {
      paramActivity.runOnUiThread(new GdtMotiveVideoFragment.1(paramActivity, localIntent));
      return;
    }
    paramBundle = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    if (paramBoolean)
    {
      AdProcessManager.INSTANCE.getWebProcessName();
      if (!TextUtils.isEmpty(paramBundle)) {
        localIntent.putExtra("from_process_name", paramBundle);
      }
      if (!paramBoolean) {
        break label228;
      }
      if (paramGdtMotiveVideoPageData.screenOrientation != 0) {
        break label222;
      }
    }
    label222:
    for (paramClass = PublicFragmentActivityLandscapeForTool.class;; paramClass = PublicFragmentActivityForTool.class)
    {
      PublicFragmentActivity.b.startForResult(paramActivity, localIntent, paramClass, GdtMotiveVideoFragment.class, 101);
      return;
      AdProcessManager.INSTANCE.getMainProcessName();
      break;
    }
    label228:
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      PublicFragmentActivity.b.startForResult(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 101);
      return;
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("arg_callback", paramString);
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, localBundle, false);
  }
  
  private static boolean a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData != null) && (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  public static void b(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), false);
  }
  
  private void bDh()
  {
    if (this.jdField_a_of_type_Tje == null) {
      this.jdField_a_of_type_Tje = new tje(new tiq(this), this.jdField_a_of_type_Tir, false);
    }
  }
  
  private void bk(Activity paramActivity)
  {
    Object localObject = getArguments();
    if (localObject == null)
    {
      paramActivity.finish();
      return;
    }
    localObject = ((Bundle)localObject).getSerializable("data");
    if (!(localObject instanceof GdtMotiveVideoPageData))
    {
      paramActivity.finish();
      return;
    }
    this.jdField_a_of_type_Tir = new tir((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  public static void c(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), true);
  }
  
  public void beforeFinish()
  {
    if ((this.jdField_a_of_type_Tje != null) && (!this.aPg))
    {
      this.aPg = true;
      String str = "";
      if (getArguments() != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.jdField_a_of_type_Tje.ut(str);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    bk(paramActivity);
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Object localObject = paramActivity.getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    localObject = ((Window)localObject).getDecorView();
    ((View)localObject).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new tip(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_Tir.a().screenOrientation);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Tje != null) {
      return this.jdField_a_of_type_Tje.onBackEvent();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    tkw.i("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_Tir == null) {
      return;
    }
    bDh();
    this.jdField_a_of_type_Tje.onCreate();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((getArguments() != null) && (getArguments().containsKey("from_process_name"))) {
      getArguments().getString("from_process_name");
    }
    if (this.jdField_a_of_type_Tir == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_Tje.b(paramLayoutInflater, paramViewGroup))
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      bDh();
      if ((this.jdField_a_of_type_Tir.a().screenOrientation == 1) && (tls.p(getActivity()))) {
        tls.bl(getActivity());
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Tje != null) {
      this.jdField_a_of_type_Tje.onDestroy();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Tje != null) {
      this.jdField_a_of_type_Tje.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    tkw.i("GdtMotiveVideoFragment", "onResume: ");
    if (this.jdField_a_of_type_Tje != null) {
      this.jdField_a_of_type_Tje.onResume();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */