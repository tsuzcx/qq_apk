package cooperation.qqreader.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import aqgz;
import aqgz.a;
import aqzl;
import auru;
import avna;
import avng;
import avnm;
import avoa;
import avob.a;
import avoc;
import avof;
import avog;
import avoh;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;
import cooperation.qqreader.host.ChannelIdHelper;
import cooperation.qqreader.view.ReaderTabBarView;
import org.json.JSONException;
import org.json.JSONObject;

public class ReaderHomeTabFragment
  extends ReaderBaseFragment
  implements Handler.Callback
{
  private View al;
  private long azN = -1L;
  private long azO = -1L;
  private BroadcastReceiver mBookUpdateReceiver;
  private Handler mHandler = new auru(Looper.getMainLooper(), this);
  
  private ReaderTabBarView a()
  {
    return (ReaderTabBarView)((QQBrowserActivity)getActivity()).aM();
  }
  
  private boolean aKR()
  {
    boolean bool = false;
    if (this.intent != null) {
      bool = this.intent.getBooleanExtra("extra_key_is_from_force_activity", false);
    }
    return bool;
  }
  
  public static WebViewFragment b(Intent paramIntent)
  {
    ReaderHomeTabFragment localReaderHomeTabFragment = new ReaderHomeTabFragment();
    Bundle localBundle = new Bundle();
    paramIntent.putExtra("titleBarStyle", 3);
    localBundle.putParcelable("intent", paramIntent);
    localReaderHomeTabFragment.setArguments(localBundle);
    return localReaderHomeTabFragment;
  }
  
  private void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.al == null)
      {
        this.al = new View(getActivity());
        this.al.setBackgroundColor(1996488704);
        this.al.setId(2131372394);
        paramViewGroup.addView(this.al, new ViewGroup.LayoutParams(-1, -1));
      }
    }
    while (this.al == null)
    {
      return;
      this.al.setVisibility(0);
      return;
    }
    this.al.setVisibility(8);
    paramViewGroup.removeView(this.al);
  }
  
  private void ci(JSONObject paramJSONObject)
  {
    try
    {
      int i = paramJSONObject.getInt("tab") - 1;
      int j = paramJSONObject.getInt("type");
      paramJSONObject = paramJSONObject.getString("content");
      Object localObject = a();
      ((ReaderTabBarView)localObject).setTextMsg(i, paramJSONObject, ((ReaderTabBarView)localObject).ln(i) + 1, true);
      localObject = getActivity();
      avof.c(aqgz.a((Context)localObject).networkType, avoh.j((Activity)localObject), "69", "335", "", "2", "", "", "");
      avog.A((Context)localObject, i, j);
      avog.O((Context)localObject, i, paramJSONObject);
      avog.h((Context)localObject, i, true);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReaderHomeTabFragment", 2, "-->json error:" + paramJSONObject.toString());
      return;
    }
    catch (Exception paramJSONObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("ReaderHomeTabFragment", 2, "-->error:" + paramJSONObject.toString());
    }
  }
  
  private void eBp()
  {
    avna localavna = ((ReaderBaseWebActivity)getActivity()).a(this.j);
    if (localavna != null) {
      localavna.callWebSearch();
    }
  }
  
  private void initBookUpdateReceiver()
  {
    this.mBookUpdateReceiver = new avoa(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction(avng.iU);
    getActivity().registerReceiver(this.mBookUpdateReceiver, localIntentFilter);
  }
  
  private boolean isFromKandian()
  {
    return ChannelIdHelper.isFromKandian();
  }
  
  private boolean isFromLeba()
  {
    return ChannelIdHelper.isFromLeba();
  }
  
  protected boolean WJ()
  {
    if (isFromKandian()) {
      return false;
    }
    return super.WJ();
  }
  
  public int b(Bundle paramBundle)
  {
    int i = super.b(paramBundle);
    paramBundle = (ReaderHomePageActivity)getActivity();
    ReaderTabBarView localReaderTabBarView = a();
    if (!paramBundle.aKQ())
    {
      if ((localReaderTabBarView != null) && (localReaderTabBarView.getParent() != null))
      {
        boolean bool = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
        c((ViewGroup)localReaderTabBarView.getParent(), bool);
        paramBundle.WG(true);
      }
    }
    else {
      return i;
    }
    avoc.e("ReaderHomeTabFragment", "tabBarView  is null or  tabBarView.getParent() is null");
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return handleMessageImp(paramMessage);
  }
  
  protected boolean handleMessageImp(Message paramMessage)
  {
    boolean bool = super.handleMessageImp(paramMessage);
    if (!bool) {}
    switch (paramMessage.what)
    {
    default: 
      return bool;
    }
    ci((JSONObject)paramMessage.obj);
    return true;
  }
  
  public void initWebView()
  {
    setHandler(this.mHandler);
    super.initWebView();
    this.j.setMask(false);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.a.rightViewImg) {
      eBp();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView == this.a.leftView)
      {
        Activity localActivity = getHostActivity();
        if (((localActivity instanceof ReaderHomePageActivity)) && (!((ReaderHomePageActivity)localActivity).aKP())) {
          super.onClick(paramView);
        }
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = this.intent.getParcelableExtra("defaultResultData");
    if ((paramBundle instanceof Intent)) {
      getActivity().setResult(0, (Intent)paramBundle);
    }
    initBookUpdateReceiver();
    this.azN = System.currentTimeMillis();
    avoc.d("ReaderHomeTabFragment", "onCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mHandler.removeCallbacksAndMessages(null);
    getActivity().unregisterReceiver(this.mBookUpdateReceiver);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    long l4 = System.currentTimeMillis();
    String str = aqgz.a(getActivity()).networkType;
    long l2 = 0L;
    paramString = "click_leba_start_time=" + getIntent().getLongExtra("key_click_leba_start_time", 0L) + ", enter_qr_bridge_activity_oncreate=" + getIntent().getLongExtra("key_enter_qr_bridge_activity_oncreate_time", 0L) + ", qr_bridge_activity_start_activity_time=" + getIntent().getLongExtra("key_qr_bridge_activity_start_activity_time", 0L) + ", enter_reader_homepage_activity_oncreate_time=" + getIntent().getLongExtra("key_enter_reader_homepage_activity_oncreate_time", 0L) + ", onPageStartedTime=" + this.azO + ", onPageFinishedTime=" + l4 + ", onPageStartToFinishTime=" + (l4 - this.azO);
    long l1 = l2;
    if (getActivity().getIntent().hasExtra("isHomePageFristLaunch"))
    {
      l1 = l2;
      if (this.azN > 0L)
      {
        l1 = l4 - this.azN;
        avof.a(str, "8", "", 0, 0.0F, 0, l1, paramString);
      }
    }
    long l3 = 0L;
    l2 = l3;
    paramWebView = paramString;
    if (isFromLeba())
    {
      l2 = l3;
      paramWebView = paramString;
      if (!aKR())
      {
        l2 = l3;
        paramWebView = paramString;
        if (!getActivity().getIntent().hasExtra("isHomePageFristLaunch"))
        {
          getActivity().getIntent().putExtra("isHomePageFristLaunch", false);
          long l5 = getActivity().getIntent().getLongExtra("key_click_leba_start_time", 0L);
          l2 = l3;
          paramWebView = paramString;
          if (l5 > 0L)
          {
            paramWebView = paramString + ",\\n clickDynamicStartTime=" + l5;
            l2 = l4 - l5;
            boolean bool = avob.a.cN(getActivity());
            avoc.d("ReaderHomeTabFragment", "isFristEnterHomePageFromLeba =" + bool);
            if (!bool) {
              break label450;
            }
            avob.a.T(getActivity(), false);
            avof.a(str, "7", "", 0, 0.0F, 0, l2, paramWebView);
          }
        }
      }
    }
    for (;;)
    {
      avoc.d("ReaderHomeTabFragment", "onPageFinished ,fristSwitchTabPageTime=" + l1 + ", homePageFristLaunchTime=" + l2 + ",repoertExtraInfo=" + paramWebView);
      return;
      label450:
      avof.a(str, "9", "", 0, 0.0F, 0, l2, paramWebView);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.azO = System.currentTimeMillis();
  }
  
  public void onResume()
  {
    super.onResume();
    ReaderTabBarView localReaderTabBarView = a();
    if ((localReaderTabBarView != null) && (localReaderTabBarView.aKT())) {
      avnm.a().handleEvent("EVENT_PRE_FETCH_GAME_AD_DATA_AND_GET_READ_RECORD", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderHomeTabFragment
 * JD-Core Version:    0.7.0.1
 */