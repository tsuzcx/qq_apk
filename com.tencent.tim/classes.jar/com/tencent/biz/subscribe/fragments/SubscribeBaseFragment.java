package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import aeay;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aqmb;
import aqmr;
import aviz;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.HashMap;
import ryy;
import rze;
import san;
import sec;
import sed;
import see;
import sef;
import sge;
import sgk;
import siu;
import spp;
import sqn;

public abstract class SubscribeBaseFragment
  extends IphoneTitleBarFragment
  implements sgk
{
  public CertifiedAccountMeta.StFeed a;
  protected sge a;
  public siu a;
  public boolean aLb;
  protected aeay mColorNoteController;
  public ExtraTypeInfo mExtraTypeInfo;
  protected boolean mIsDestroyed;
  private Handler mMainHandler;
  
  private void a(int paramInt, ExtraTypeInfo paramExtraTypeInfo)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) && (!aqmr.isEmpty(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get()))) {
      sqn.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_share", "exp_" + siu.b(paramExtraTypeInfo), paramInt, 0, new String[0]);
    }
  }
  
  private void aYx()
  {
    if (this.mColorNoteController != null) {
      return;
    }
    this.mColorNoteController = new aeay(getActivity(), false, true);
    this.mColorNoteController.attachToActivity(getActivity());
    this.mColorNoteController.setServiceInfo(new sed(this));
    this.mColorNoteController.a(new see(this));
    this.mColorNoteController.setOnColorNoteCurdListener(new sef(this));
  }
  
  private void bxj()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void bxk()
  {
    long l;
    String str;
    if ((getActivity() != null) && (getActivity().getIntent() != null))
    {
      l = getActivity().getIntent().getLongExtra("PERF_OPEN_PAGE_TIME", 0L);
      if ((l != 0L) && (this.mExtraTypeInfo != null)) {
        switch (this.mExtraTypeInfo.pageType)
        {
        default: 
          str = "SubscribeBaseFragment";
        }
      }
    }
    for (;;)
    {
      sqn.n(str, sqn.i(0L, System.currentTimeMillis() - l));
      return;
      str = "subscribe_open_video_detail_page_time";
      continue;
      str = "subscribe_open_muti_pic_page_time";
      continue;
      str = "subscribe_open_personal_detail_page_time";
    }
  }
  
  private void byb()
  {
    File localFile = new File(rze.no());
    if ((localFile.exists()) || (aqmb.Cg() == null))
    {
      QLog.i("DownLoadZipFile", 1, "DownLoadZipFile Save file is exist");
      return;
    }
    rze.d(localFile, (String)spp.a().getValue("KEY_SUBSCRIBE_LOADING_VIEW_DOWNLOAD_URL", "https://down.qq.com/video_story/certified_account/certified_account_download_pics.zip"));
  }
  
  private void byc()
  {
    QLog.i("SubscribeBaseFragment", 1, "downloadAnimationPic");
    String[] arrayOfString = ryy.bK;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      File localFile;
      if (i < j)
      {
        str1 = arrayOfString[i];
        str2 = (String)ryy.eQ.get(str1);
        localFile = new File(str2);
        if ((localFile.exists()) && (localFile.isDirectory())) {
          QLog.i("DownLoadZipFile", 1, "DownLoadZipFile " + str2 + " Save file is exist");
        }
      }
      else
      {
        return;
      }
      String str2 = (String)ryy.eR.get(str1);
      String str1 = (String)ryy.eP.get(str1);
      rze.a(localFile, (String)spp.a().getValue(str2, str1), ryy.aDD);
      i += 1;
    }
  }
  
  protected abstract TextView D();
  
  public void a(san paramsan)
  {
    if (paramsan != null)
    {
      if ((paramsan.mFeed == null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null)) {
        paramsan.mFeed = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed;
      }
      if ((paramsan.mExtraTypeInfo == null) && (this.mExtraTypeInfo != null)) {
        paramsan.mExtraTypeInfo = this.mExtraTypeInfo;
      }
      if (this.jdField_a_of_type_Siu != null)
      {
        a(paramsan.shareFromType, this.mExtraTypeInfo);
        this.jdField_a_of_type_Siu.a(paramsan, this.mColorNoteController);
      }
      if ((isNeedMiniMsg()) && (D() != null) && (paramsan.shareFromType == 1) && (D().getVisibility() == 0) && (getMiniMsgUser() != null)) {
        getMiniMsgUser().onClick(aE());
      }
    }
  }
  
  public int[] a(int paramInt1, int paramInt2)
  {
    return new int[2];
  }
  
  protected abstract View aE();
  
  protected void bcD()
  {
    if (rze.Mp()) {
      bxj();
    }
    dC(this.mContentView);
  }
  
  protected abstract void dC(View paramView);
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    byb();
    byc();
    if (getActivity().getIntent() != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = new CertifiedAccountMeta.StFeed();
    }
    try
    {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = ((CertifiedAccountMeta.StFeed)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.mergeFrom(getActivity().getIntent().getByteArrayExtra("bundle_key_subscribe_feed_bytes_array")));
      this.mExtraTypeInfo = ((ExtraTypeInfo)getActivity().getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      if (this.mExtraTypeInfo == null) {
        this.mExtraTypeInfo = new ExtraTypeInfo();
      }
      this.jdField_a_of_type_Siu = new siu(getActivity(), new sec(this));
      if (getActivity().getIntent().hasExtra("bundle_key_parms_extra"))
      {
        paramLayoutInflater = getActivity().getIntent().getBundleExtra("bundle_key_parms_extra");
        if (sge.s(paramLayoutInflater))
        {
          this.jdField_a_of_type_Sge = new sge(paramLayoutInflater, this);
          if (this.jdField_a_of_type_Sge.e() != null)
          {
            paramLayoutInflater = new RelativeLayout.LayoutParams(-1, -1);
            paramLayoutInflater.addRule(3, 2131377361);
            this.titleRoot.addView(this.jdField_a_of_type_Sge.e(), paramLayoutInflater);
          }
        }
      }
      bcD();
      bxk();
      return;
    }
    catch (Exception paramLayoutInflater)
    {
      for (;;)
      {
        paramLayoutInflater.printStackTrace();
      }
    }
  }
  
  public Handler getMainHandler()
  {
    if (this.mMainHandler == null) {
      this.mMainHandler = new Handler(Looper.getMainLooper());
    }
    return this.mMainHandler;
  }
  
  public MiniMsgUserParam getMiniMsgUserParam()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 25;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.unreadView = D();
    return localMiniMsgUserParam;
  }
  
  public boolean isNeedMiniMsg()
  {
    return (aE() != null) && (D() != null);
  }
  
  public boolean isTransparent()
  {
    return true;
  }
  
  protected void n(CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void o(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null) {
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = paramStFeed;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SubscribeBaseFragment", 2, "SubscribeVideoDetailFragment onActivityResult,requestCode=" + paramInt1 + ",resultCode=" + paramInt2);
    }
    if (paramInt2 == -1) {}
    byte[] arrayOfByte;
    CertifiedAccountMeta.StFeed localStFeed;
    switch (paramInt1)
    {
    default: 
      if ((paramInt1 == 3) && (paramInt2 == -1))
      {
        arrayOfByte = paramIntent.getByteArrayExtra("feed");
        if (arrayOfByte != null) {
          localStFeed = new CertifiedAccountMeta.StFeed();
        }
      }
      break;
    }
    try
    {
      localStFeed.mergeFrom(arrayOfByte);
      this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed = localStFeed;
      n(localStFeed);
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      aviz.A(super.getActivity(), paramIntent);
      return;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;)
      {
        QLog.e("SubscribeBaseFragment", 4, "onActivityResult: prase stFeed error:" + localInvalidProtocolBufferMicroException.toString());
      }
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed != null) {
      sqn.b(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.poster.id.get(), "auth_" + siu.b(this.mExtraTypeInfo), "clk_return", 0, 0, new String[] { "", "" });
    }
    if ((getActivity() != null) && (getActivity().getIntent() != null) && (this.mExtraTypeInfo != null) && (this.mExtraTypeInfo.sourceType == 9001))
    {
      String str = QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4");
      MiniAppLauncher.startMiniApp(getActivity(), str, 2016, null, null);
    }
    return super.onBackEvent();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onDestroy();
    }
    this.mIsDestroyed = true;
    getMainHandler().removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_Siu != null) {
      this.jdField_a_of_type_Siu.onDestroy();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    aYx();
    if (this.mColorNoteController != null) {
      this.mColorNoteController.onResume();
    }
  }
  
  public int uj()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeBaseFragment
 * JD-Core Version:    0.7.0.1
 */