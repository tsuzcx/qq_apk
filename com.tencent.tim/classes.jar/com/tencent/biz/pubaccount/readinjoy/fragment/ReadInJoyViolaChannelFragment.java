package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.d;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.liveroom.LiveRoomHelper;
import cooperation.liveroom.LiveRoomPluginInstaller;
import cooperation.liveroom.LiveRoomPluginLoader;
import java.util.ArrayList;
import kxm;
import lal;
import lcc;
import lfb;
import lfc;
import lfd;
import nui;
import nuk;
import nwl;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyViolaChannelFragment
  extends ReadInJoyBaseFragment
{
  private static a jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private nuk jdField_a_of_type_Nuk;
  private LinearLayout dH;
  protected int mChannelID = -1;
  protected String mChannelName = "viola";
  protected String mChannelVersion;
  protected ViewGroup mContentView;
  private Context mContext;
  private String mUrl;
  
  public static ReadInJoyViolaChannelFragment a(int paramInt, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("channel_id", paramInt);
    localBundle.putString("channel_name", paramString1);
    localBundle.putString("channel_version", paramString2);
    paramString1 = new ReadInJoyViolaChannelFragment();
    paramString1.setArguments(localBundle);
    return paramString1;
  }
  
  public static void at(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a = new a(null);
      }
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.channelId = paramInt;
      jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.url = new String(Base64.decode(paramString, 0));
    } while (!QLog.isColorLevel());
    QLog.d("ReadInJoyViolaChannelFragment", 2, "saveGuidingJumpPendingInfo, channelId: " + paramInt + ", url: " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.url);
  }
  
  private void hideLoadingView()
  {
    if (this.dH.getVisibility() == 0) {
      this.dH.setVisibility(8);
    }
  }
  
  private void initUI()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(getActivity());
    ((ViewGroup)this.mContentView.findViewById(2131381996)).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    if (this.jdField_a_of_type_Nuk.Gj()) {
      this.jdField_a_of_type_Nuk.bbC();
    }
    showLoadingView();
    this.jdField_a_of_type_Nuk.a(this.mContentView, new lfb(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(new lfc(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.mUrl, this, new ViolaBaseView.d(this.mUrl, new JSONObject(), nui.fe(this.mUrl), 1));
  }
  
  private void qR(int paramInt)
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a == null) {
      return;
    }
    if (paramInt == jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.channelId)
    {
      this.mUrl = jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.url;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyViolaChannelFragment", 2, "replaceViolaUrl, channelId: " + paramInt + ", url: " + jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.url);
      }
    }
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.channelId = -1;
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyViolaChannelFragment$a.url = null;
  }
  
  private void reloadPage()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "reload viola Page mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    showLoadingView();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.b(new lfd(this));
  }
  
  private void showLoadingView()
  {
    if (this.dH.getVisibility() == 8) {
      this.dH.setVisibility(0);
    }
  }
  
  protected boolean Br()
  {
    return false;
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyShowSelf mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm()) && (BR()) && (ReadinjoyTabFrame.Dx())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(true);
    }
    for (;;)
    {
      lcc.a().h(3, null);
      return;
      if (this.mContentView != null) {
        initUI();
      }
    }
  }
  
  public void aCc()
  {
    super.aCc();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyHideSelf mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.bbY();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm()) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(false);
      }
    }
  }
  
  public void aIp() {}
  
  public void aIq()
  {
    super.aIq();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyClickSelf mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    String str = "ViolaChanel_" + this.mUrl;
    ArrayList localArrayList;
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.isCreated())) {
      localArrayList = new ArrayList();
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("url", this.mUrl);
        if ((localArrayList.size() == 0) && (!TextUtils.isEmpty(this.mUrl)))
        {
          localObject = Uri.parse(this.mUrl);
          if (((Uri)localObject).isHierarchical()) {
            localArrayList.add(((Uri)localObject).getHost());
          }
        }
        Intent localIntent = new Intent("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        localIntent.putExtra("broadcast", true);
        localIntent.putExtra("unique", String.valueOf(System.currentTimeMillis()) + String.valueOf((int)(Math.random() * 1000000.0D)));
        localIntent.putExtra("event", str);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("eventName", "tabClick");
        if (localObject != null) {
          localIntent.putExtra("data", ((JSONObject)localObject).toString());
        }
        localIntent.putStringArrayListExtra("domains", localArrayList);
        localIntent.putExtra("source", localJSONObject.toString());
        if (QLog.isColorLevel())
        {
          if (localObject == null) {
            continue;
          }
          localObject = ((JSONObject)localObject).toString();
          QLog.d("ReadInJoyViolaChannelFragment", 2, String.format("send event broadcast, event: %s, data: %s, domains: %s, source: %s", new Object[] { str, localObject, TextUtils.join(",", localArrayList), localJSONObject }));
        }
        BaseApplicationImpl.getContext().sendBroadcast(localIntent, "com.tencent.tim.msg.permission.pushnotify");
        if (1 == 0) {}
      }
      catch (JSONException localJSONException)
      {
        Object localObject;
        continue;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.updateInstance(nwl.d(1).toString());
      return;
      localObject = "NULL";
    }
  }
  
  public void aKD()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "notifyTabDoubleClick mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    super.aKD();
  }
  
  public String jp()
  {
    return this.mChannelVersion;
  }
  
  public int nh()
  {
    return this.mChannelID;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    if (localBundle != null)
    {
      this.mChannelID = localBundle.getInt("channel_id");
      this.mChannelName = localBundle.getString("channel_name");
      this.mChannelVersion = localBundle.getString("channel_version");
      if ((this.mChannelID == 41660) || (this.mChannelID == 8))
      {
        if (!LiveRoomHelper.isPluginInstalledInQQ()) {
          break label81;
        }
        LiveRoomPluginLoader.preLoadPlugin();
      }
    }
    for (;;)
    {
      qR(this.mChannelID);
      super.onCreate(paramBundle);
      return;
      label81:
      LiveRoomPluginInstaller.getInstance().installFromQQ(null, "Readinjoy pre");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onCreateView mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    this.mInflater = LayoutInflater.from(getActivity());
    this.mContentView = ((ViewGroup)this.mInflater.inflate(2131558520, paramViewGroup, false));
    this.dH = ((LinearLayout)this.mContentView.findViewById(2131374329));
    this.dH.setOnClickListener(null);
    this.mContext = getActivity();
    this.jdField_a_of_type_Nuk = new nuk(this);
    if ((!getUserVisibleHint()) && (kxm.AR())) {}
    for (;;)
    {
      VideoReport.setPageId(this.mContentView, "8014");
      VideoReport.setPageParams(this.mContentView, new lal().a(this.mChannelID).a());
      paramLayoutInflater = this.mContentView;
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      initUI();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onDestroy mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
      this.mContentView.removeAllViews();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = null;
      return;
    }
    catch (Exception localException) {}
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onPause mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(false);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      if ((bool) && (ReadinjoyTabFrame.Dx()) && (BR())) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(true);
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onStart mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    VideoReport.addToDetectionWhitelist(getActivity());
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStart();
    }
    lcc.a().h(3, null);
  }
  
  public void onStop()
  {
    super.onStop();
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyViolaChannelFragment", 2, "onStop mChannelName :" + this.mChannelName + "; mChannelId :" + this.mChannelID);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.Gm();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityStop();
      if (bool) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.qg(false);
      }
    }
  }
  
  public void qc(int paramInt)
  {
    super.qc(paramInt);
    if ((paramInt == 5) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.isCreated())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.updateInstance(nwl.d(2).toString());
    }
  }
  
  public void setUrl(String paramString)
  {
    this.mUrl = paramString;
  }
  
  static class a
  {
    int channelId;
    String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment
 * JD-Core Version:    0.7.0.1
 */