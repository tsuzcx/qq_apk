package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import arbs;
import arcd;
import arcd.a;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import jqo;
import qnx;
import ram;

public class StoryPlayerWebFragment
  extends WebViewFragment
{
  public a a;
  public BroadcastReceiver an = new qnx(this);
  
  public static StoryPlayerWebFragment a(Intent paramIntent)
  {
    StoryPlayerWebFragment localStoryPlayerWebFragment = new StoryPlayerWebFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localStoryPlayerWebFragment.setArguments(localBundle);
    return localStoryPlayerWebFragment;
  }
  
  public static Intent c(Activity paramActivity, String paramString)
  {
    paramActivity = new Intent(paramActivity, StoryPlayerWebToolFragment.class);
    paramActivity.putExtra("url", paramString);
    paramActivity.putExtra("isFullScreen", true);
    return paramActivity;
  }
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerwidgetStoryPlayerWebFragment$a = parama;
  }
  
  public void initWebView()
  {
    super.initWebView();
    this.jdField_a_of_type_Arbs.dp("web_view_long_click", false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramViewGroup = new IntentFilter();
    paramViewGroup.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    getActivity().registerReceiver(this.an, paramViewGroup, "com.tencent.tim.msg.permission.pushnotify", null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ram.d("StoryPlayerWebFragment", "onDestroy()");
    getActivity().unregisterReceiver(this.an);
  }
  
  public void onPause()
  {
    super.onPause();
    ram.d("StoryPlayerWebFragment", "onPause()");
  }
  
  public void onResume()
  {
    super.onResume();
    ram.d("StoryPlayerWebFragment", "onResume()");
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
  
  public boolean showPreview()
  {
    ram.d("StoryPlayerWebFragment", "showPreview()");
    jqo.le("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Arcd.dU(this.intent);
    this.jdField_a_of_type_Arcd$a.Dr = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.init(this.jdField_a_of_type_Arcd.jdField_a_of_type_Arcd$a.cYM);
    this.mNeedStatusTrans = true;
    this.mActNeedImmersive = false;
    setImmersiveStatus();
    ram.d("StoryPlayerWebFragment", "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    this.jdField_a_of_type_Arcd.cYj = true;
    this.jdField_a_of_type_Arcd.ar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.aq;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.ce.setVisibility(8);
    this.jdField_a_of_type_Arcd.rS(this.mUrl);
    this.jdField_a_of_type_Arcd.zP = false;
    jqo.lf("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void bpu();
    
    public abstract void bpv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.StoryPlayerWebFragment
 * JD-Core Version:    0.7.0.1
 */