package cooperation.liveroom;

import afjy;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import aqyc;
import aqyx;
import arcv;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.emosm.Client;
import com.tencent.mobileqq.vaswebviewplugin.VasCommonJsPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LiveRoomWebViewFragment
  extends ReportFragment
{
  private static final String TAG = "LiveRoomWebViewFragment";
  private long clickTime;
  private LiveRoomInterfaceProxy mApp;
  public View mExtendView;
  public ViewGroup mGiftView;
  protected Intent mIntent;
  private boolean mIsWebViewCache;
  private long mOnCreateMilliTimeStamp;
  private long mPluginFinishedTime;
  public ArrayList<WebViewPlugin> mPluginList;
  private FrameLayout mRootLayout;
  public LiveRoomWebViewBuilder mWebViewBuilder;
  private long onCreateTime;
  
  public static LiveRoomWebViewFragment newInstance(Intent paramIntent)
  {
    QLog.d("LiveRoomWebViewFragment", 1, "LiveRoomWebViewFragment get newInstance");
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    paramIntent = new LiveRoomWebViewFragment();
    paramIntent.setArguments(localBundle);
    return paramIntent;
  }
  
  protected boolean dispatchPluginEvent(long paramLong, Map<String, Object> paramMap)
  {
    if (this.mWebViewBuilder != null)
    {
      WebViewPluginEngine localWebViewPluginEngine = this.mWebViewBuilder.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        return localWebViewPluginEngine.handleEvent(this.mWebViewBuilder.mWebview.getUrl(), paramLong, paramMap);
      }
    }
    return false;
  }
  
  public CustomWebView getWebView()
  {
    if (this.mWebViewBuilder == null) {
      return null;
    }
    return this.mWebViewBuilder.mWebview;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mIntent = ((Intent)super.getArguments().getParcelable("intent"));
    if (this.mIntent == null)
    {
      QLog.e("LiveRoomWebViewFragment", 1, "the intent from outside is null");
      this.mIntent = new Intent();
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.mIntent = ((Intent)super.getArguments().getParcelable("intent"));
    if (this.mIntent == null)
    {
      QLog.e("LiveRoomWebViewFragment", 1, "the intent from outside is null");
      this.mIntent = new Intent();
    }
  }
  
  public boolean onBackEvent()
  {
    QLog.d("LiveRoomWebViewFragment", 1, "live room web view fragment on back event ");
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("target", Integer.valueOf(3));
    return dispatchPluginEvent(8589934601L, localHashMap);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    QLog.d("LiveRoomWebViewFragment", 1, "onCreateView");
    if (aqyc.cWW) {
      this.mIsWebViewCache = true;
    }
    this.mRootLayout = new FrameLayout(getActivity());
    this.mApp = LiveRoomHelper.getLiveRoomInterface();
    if (this.mApp == null) {
      QLog.e("LiveRoomWebViewFragment", 1, "getLiveRoomInterface return null");
    }
    for (paramLayoutInflater = this.mRootLayout;; paramLayoutInflater = this.mRootLayout)
    {
      FragmentCollector.onFragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      this.mApp.onCreate(paramBundle);
      this.clickTime = this.mIntent.getLongExtra("startOpenPageTime", -1L);
      this.mPluginFinishedTime = this.mIntent.getLongExtra("pluginFinished", -1L);
      this.mOnCreateMilliTimeStamp = System.currentTimeMillis();
      if (TextUtils.isEmpty(LiveRoomHelper.getPluginVersionInTool()))
      {
        paramLayoutInflater = this.mIntent.getStringExtra("version");
        if (!TextUtils.isEmpty(paramLayoutInflater))
        {
          if (QLog.isColorLevel()) {
            QLog.d("LiveRoomWebViewFragment", 2, "LiveRoomPlugin version=" + paramLayoutInflater);
          }
          LiveRoomHelper.setPluginVersionInTool(paramLayoutInflater);
        }
      }
      this.mIntent.putExtra("window_no_title", false);
      this.mIntent.putExtra("webview_hide_progress", true);
      this.mWebViewBuilder = new LiveRoomWebViewBuilder(getActivity(), getActivity(), this.mIntent, this.mApp);
      paramLayoutInflater = null;
      paramViewGroup = new aqyx(this.mWebViewBuilder);
      if (this.mPluginList != null)
      {
        paramLayoutInflater = new VasCommonJsPlugin();
        this.mPluginList.add(paramLayoutInflater);
        this.mWebViewBuilder.bindBussinessWebViewPlugin(this.mPluginList);
      }
      paramViewGroup.a(paramBundle, this.mApp, this.mIntent);
      if ((paramLayoutInflater != null) && (paramLayoutInflater.mRuntime != null)) {
        setVasUIInterface(paramLayoutInflater, paramViewGroup);
      }
      if (!afjy.a().ajq()) {
        afjy.a().a().doBindService(this.mApp.getApplication());
      }
      if (this.mWebViewBuilder.getContainer().getParent() != null) {
        QLog.d("LiveRoomWebViewFragment", 1, "ViewRoot 's parent " + this.mWebViewBuilder.getContainer().getParent().hashCode());
      }
      paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
      this.mRootLayout.addView(this.mWebViewBuilder.getContainer(), paramLayoutInflater);
      if (this.mExtendView != null)
      {
        this.mExtendView.setAlpha(0.75F);
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.mRootLayout.addView(this.mExtendView, paramLayoutInflater);
      }
      if (this.mGiftView != null)
      {
        paramLayoutInflater = new FrameLayout.LayoutParams(-1, -1);
        this.mRootLayout.addView(this.mGiftView, paramLayoutInflater);
      }
      this.onCreateTime = (System.currentTimeMillis() - this.mOnCreateMilliTimeStamp);
    }
  }
  
  public void onDestroyView()
  {
    QLog.d("LiveRoomWebViewFragment", 1, "onDestroyView");
    if (this.mWebViewBuilder != null)
    {
      if (this.mWebViewBuilder.mWebview != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LiveRoomWebViewFragment", 2, "Current Step: " + this.mWebViewBuilder.mStateReporter.mCurrentStep);
        }
        String str = this.mWebViewBuilder.mWebview.getUrl();
        this.mWebViewBuilder.mStateReporter.a(getActivity(), this.mApp.getLongAccountUin(), str, false);
      }
      this.mWebViewBuilder.onDestroy();
      this.mRootLayout = null;
      this.mWebViewBuilder = null;
    }
    super.onDestroyView();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (this.mWebViewBuilder == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mWebViewBuilder.onPause();
      return;
    }
    this.mWebViewBuilder.onResume();
  }
  
  public void onPause()
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    if ((!isHidden()) && (this.mWebViewBuilder != null)) {
      this.mWebViewBuilder.onResume();
    }
    super.onResume();
  }
  
  public void pauseWebView()
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onPause();
    }
  }
  
  public void resumeWebView()
  {
    if (this.mWebViewBuilder != null) {
      this.mWebViewBuilder.onResume();
    }
  }
  
  public void setVasUIInterface(VasCommonJsPlugin paramVasCommonJsPlugin, aqyx paramaqyx)
  {
    paramVasCommonJsPlugin.setUiInterface(new LiveRoomWebViewFragment.1(this, paramaqyx));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewFragment
 * JD-Core Version:    0.7.0.1
 */