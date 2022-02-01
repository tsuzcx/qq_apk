package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqiw;
import aryx;
import aryy;
import ausj;
import auss;
import com.tencent.biz.pubaccount.Advertisement.view.AdProgressButton;
import com.tencent.biz.pubaccount.NativeAd.adapter.AdModuleAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ResizeURLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jyt;
import jyu;
import jyv;
import jyw;
import jyx;
import jyy;
import jzf;
import jzk;
import mqq.os.MqqHandler;
import noy;
import org.json.JSONArray;
import org.json.JSONObject;
import oud;

public class ReadInJoyNativeAdFragment
  extends PublicBaseFragment
  implements View.OnClickListener, aryx, INetInfoHandler
{
  private String Uv;
  private AdModuleAdapter jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter;
  private jyt jdField_a_of_type_Jyt;
  private oud jdField_a_of_type_Oud;
  private int aED;
  private int aEE;
  private int aEF = 1;
  private int aEv;
  private boolean acX;
  private AdProgressButton jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton;
  private ResizeURLImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView;
  private LinearLayout dr;
  private ViewPager e;
  private RelativeLayout eB;
  private ArrayList<jyy> jF;
  private String mChannelId;
  private String mInfo;
  private TextView nN;
  private ausj w;
  
  private boolean a(DownloadInfo paramDownloadInfo)
  {
    if ((paramDownloadInfo == null) || (this.jdField_a_of_type_Jyt == null) || (TextUtils.isEmpty(paramDownloadInfo.packageName)) || (TextUtils.isEmpty(paramDownloadInfo.appId)) || (TextUtils.isEmpty(this.jdField_a_of_type_Jyt.mPackageName)) || (TextUtils.isEmpty(this.jdField_a_of_type_Jyt.mAppid))) {}
    while ((!paramDownloadInfo.packageName.equals(this.jdField_a_of_type_Jyt.mPackageName)) || (!paramDownloadInfo.appId.equals(this.jdField_a_of_type_Jyt.mAppid))) {
      return false;
    }
    return true;
  }
  
  private void aBh()
  {
    int i = 0;
    Object localObject = getArguments().getString("param_ad_json");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "checkData->" + (String)localObject);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      getActivity().finish();
      return;
    }
    for (;;)
    {
      try
      {
        localObject = new JSONObject((String)localObject);
        this.Uv = ((JSONObject)localObject).optString("adId");
        this.mChannelId = ((JSONObject)localObject).optString("channelId");
        this.mInfo = ((JSONObject)localObject).optString("info");
        this.aEv = ((JSONObject)localObject).optInt("upslideType");
        this.jdField_a_of_type_Jyt = jyt.a(((JSONObject)localObject).optString("bannerInfo"));
        this.jF = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("pageInfoList");
        if (i < ((JSONArray)localObject).length())
        {
          jyy localjyy = jyy.a(getActivity().app, ((JSONArray)localObject).getJSONObject(i));
          if (localjyy != null) {
            this.jF.add(localjyy);
          }
        }
        else
        {
          if (this.jF.size() <= 0) {
            getActivity().finish();
          }
          jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 1, 1, 0);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getActivity().finish();
        return;
      }
      i += 1;
    }
  }
  
  private void aBi()
  {
    Object localObject1;
    if ((this.jdField_a_of_type_Jyt != null) && (this.jdField_a_of_type_Jyt.MS == 1))
    {
      if ((this.jF.size() > 1) && ((this.aEv == 1) || (this.aEv == 2)))
      {
        this.dr.setVisibility(0);
        if (this.aEv == 1) {
          this.dr.findViewById(2131379730).setVisibility(8);
        }
        Object localObject2 = this.dr.findViewById(2131381397);
        localObject1 = this.dr.findViewById(2131381398);
        ((View)localObject2).setAlpha(0.0F);
        ((View)localObject2).setVisibility(0);
        ((View)localObject1).setAlpha(0.0F);
        ((View)localObject1).setVisibility(0);
        localObject1 = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
        localObject2 = ObjectAnimator.ofFloat(localObject2, "alpha", new float[] { 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F });
        ((ObjectAnimator)localObject1).setDuration(1800L);
        ((ObjectAnimator)localObject1).setRepeatCount(-1);
        ((ObjectAnimator)localObject1).setRepeatMode(1);
        ((ObjectAnimator)localObject1).setStartDelay(100L);
        ((ObjectAnimator)localObject2).setDuration(1800L);
        ((ObjectAnimator)localObject2).setRepeatCount(-1);
        ((ObjectAnimator)localObject2).setRepeatMode(1);
        ((ObjectAnimator)localObject2).setStartDelay(240L);
        AnimatorSet localAnimatorSet = new AnimatorSet();
        localAnimatorSet.playTogether(new Animator[] { localObject1, localObject2 });
        localAnimatorSet.start();
      }
      if (this.jdField_a_of_type_Jyt.yP()) {
        this.eB.setVisibility(0);
      }
    }
    try
    {
      localObject1 = new URL(this.jdField_a_of_type_Jyt.mIconUrl);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage((URL)localObject1);
      if (noy.a().a((URL)localObject1)) {
        this.aEE = 2;
      }
      for (;;)
      {
        this.nN.setText(this.jdField_a_of_type_Jyt.Vf);
        this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setOnClickListener(this);
        AppNetConnInfo.registerConnectionChangeReceiver(getActivity(), this);
        return;
        this.aEE = 1;
        this.jdField_a_of_type_Oud = new jyv(this);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setPublicAccountImageDownListener(this.jdField_a_of_type_Oud);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void aBj()
  {
    if ((this.aEE == 3) && (this.jdField_a_of_type_Jyt != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Jyt.mIconUrl))) {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdFragment", 2, "retry download icon");
      }
    }
    try
    {
      URL localURL = new URL(this.jdField_a_of_type_Jyt.mIconUrl);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView.setImage(localURL);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void aBk()
  {
    if (this.w == null)
    {
      this.w = ((ausj)auss.a(getActivity(), null));
      this.w.addCancelButton(2131721058);
      this.w.a(new jyw(this));
      this.w.a(new jyx(this));
    }
    if (!this.w.isShowing())
    {
      this.acX = false;
      this.w.show();
    }
  }
  
  private void aBl()
  {
    if (!aqiw.isNetworkAvailable(getActivity())) {
      return;
    }
    if (aqiw.isWifiConnected(getActivity()))
    {
      aBm();
      return;
    }
    aBn();
  }
  
  private void aBm()
  {
    jzk.a(getActivity(), this.jdField_a_of_type_Jyt, this);
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setTextColor(-16777216);
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setBackgroundResource(2130839559);
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgress(0);
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setClickable(false);
    this.aED = 3;
    jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 3, 2, 0);
  }
  
  private void aBn() {}
  
  private void aBo() {}
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(2130772004, 0);
  }
  
  public void installSucceed(String paramString1, String paramString2) {}
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      getActivity().doOnBackPressed();
      continue;
      aBk();
      continue;
      if (this.jdField_a_of_type_Jyt != null) {
        if (this.jdField_a_of_type_Jyt.mJumpType == 2)
        {
          Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
          localIntent.putExtra("url", this.jdField_a_of_type_Jyt.hL);
          startActivity(localIntent);
          jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 3, 3, 0);
        }
        else if (this.jdField_a_of_type_Jyt.mJumpType == 1)
        {
          switch (this.aED)
          {
          case 3: 
          default: 
            break;
          case 0: 
            aBl();
            break;
          case 1: 
            jzk.launchApp(getActivity(), this.jdField_a_of_type_Jyt.mPackageName);
            jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 3, 1, 0);
            break;
          case 2: 
            jzk.a(this.jdField_a_of_type_Jyt);
            jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 3, 4, 0);
          }
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aBh();
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560425, paramViewGroup, false);
    paramViewGroup = LayoutInflater.from(getActivity()).inflate(2131560424, null);
    paramBundle = new RelativeLayout.LayoutParams(-1, -2);
    paramBundle.addRule(12, -1);
    ((ViewGroup)paramLayoutInflater).addView(paramViewGroup, paramBundle);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (getActivity().app != null)
    {
      jzf localjzf = (jzf)getActivity().app.getManager(248);
      if (localjzf != null) {
        localjzf.aBr();
      }
    }
    if ((this.jdField_a_of_type_Jyt != null) && (this.jdField_a_of_type_Jyt.mJumpType == 1))
    {
      if (this.jdField_a_of_type_Jyt.MS != 1) {
        break label131;
      }
      aryy.a().b(this);
      AppNetConnInfo.unregisterNetInfoHandler(this);
      if (this.aED == 3) {
        aryy.a().fw(this.jdField_a_of_type_Jyt.mAppid);
      }
    }
    for (;;)
    {
      jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 4, 1, this.aEF);
      return;
      label131:
      if (this.jdField_a_of_type_Jyt.MS == 2)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter.aBg();
        if (jzk.a(getActivity(), this.jdField_a_of_type_Jyt) >= 0) {
          aryy.a().fw(this.jdField_a_of_type_Jyt.mAppid);
        }
      }
    }
  }
  
  public void onDownloadCancel(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.6(this));
    }
  }
  
  public void onDownloadError(DownloadInfo paramDownloadInfo, int paramInt1, String paramString, int paramInt2)
  {
    if (a(paramDownloadInfo)) {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.8(this));
    }
  }
  
  public void onDownloadFinish(DownloadInfo paramDownloadInfo)
  {
    if (a(paramDownloadInfo))
    {
      ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.5(this));
      jzk.a(getActivity().app, this.Uv, this.mChannelId, this.mInfo, 3, 4, 0);
    }
  }
  
  public void onDownloadPause(DownloadInfo paramDownloadInfo) {}
  
  public void onDownloadUpdate(List<DownloadInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DownloadInfo localDownloadInfo = (DownloadInfo)paramList.next();
      if (a(localDownloadInfo)) {
        ThreadManager.getUIHandler().post(new ReadInJoyNativeAdFragment.7(this, localDownloadInfo));
      }
    }
  }
  
  public void onDownloadWait(DownloadInfo paramDownloadInfo) {}
  
  public void onFinish()
  {
    getActivity().overridePendingTransition(0, 2130772001);
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2None");
    }
    aBo();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Mobile");
    }
    aBo();
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2Mobile");
    }
    aBo();
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdFragment", 2, "onNetWifi2None");
    }
    aBo();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.jdField_a_of_type_Jyt == null) || (this.jdField_a_of_type_Jyt.MS != 1) || (this.jdField_a_of_type_Jyt.mJumpType == 2)) {}
    for (;;)
    {
      if (this.e != null) {}
      try
      {
        int i = this.e.getCurrentItem();
        ((jyy)this.jF.get(i)).onResume();
        if (i + 1 < this.jF.size()) {
          ((jyy)this.jF.get(i + 1)).aBp();
        }
        return;
      }
      catch (Exception localException) {}
      if (this.jdField_a_of_type_Jyt.mJumpType == 1) {
        if (jzk.C(getActivity(), this.jdField_a_of_type_Jyt.mPackageName)) {
          this.aED = 1;
        } else if (jzk.a(getActivity(), this.jdField_a_of_type_Jyt)) {
          this.aED = 2;
        } else if (this.aED != 3) {
          this.aED = 0;
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    ViewGroup localViewGroup = (ViewGroup)paramView;
    this.e = ((ViewPager)localViewGroup.findViewById(2131371881));
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter = new AdModuleAdapter(getActivity(), this.Uv, this.mChannelId, this.mInfo, this.aEv, this.jdField_a_of_type_Jyt, this.jF);
    this.e.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountNativeAdAdapterAdModuleAdapter);
    this.e.setOnPageChangeListener(new jyu(this));
    localViewGroup.findViewById(2131364679).setOnClickListener(this);
    localViewGroup.findViewById(2131366980).setOnClickListener(this);
    this.dr = ((LinearLayout)localViewGroup.findViewById(2131379726));
    this.eB = ((RelativeLayout)localViewGroup.findViewById(2131366063));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewResizeURLImageView = ((ResizeURLImageView)localViewGroup.findViewById(2131366080));
    this.nN = ((TextView)localViewGroup.findViewById(2131366074));
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton = ((AdProgressButton)localViewGroup.findViewById(2131373673));
    this.jdField_b_of_type_ComTencentBizPubaccountAdvertisementViewAdProgressButton.setProgressColor(getResources().getColor(2131165409));
    aBi();
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void packageReplaced(String paramString1, String paramString2) {}
  
  public void uninstallSucceed(String paramString1, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment
 * JD-Core Version:    0.7.0.1
 */