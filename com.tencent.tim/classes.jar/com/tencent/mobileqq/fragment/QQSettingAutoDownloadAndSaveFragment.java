package com.tencent.mobileqq.fragment;

import accy;
import ahof;
import ahog;
import ahoh;
import ahoi;
import ahoj;
import akwz;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anot;
import auqv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.util.VersionUtils;
import mqq.app.AppRuntime;

public class QQSettingAutoDownloadAndSaveFragment
  extends IphoneTitleBarFragment
{
  FormSwitchItem bf;
  FormSwitchItem bg;
  FormSwitchItem bh;
  FormSwitchItem bi;
  FormSwitchItem bj;
  private BounceScrollView e;
  private QQAppInterface mApp;
  
  private void initUI()
  {
    this.e = ((BounceScrollView)this.mContentView.findViewById(2131377757));
    if (VersionUtils.isGingerBread()) {
      this.e.setOverScrollMode(0);
    }
    anot.a(null, "dc00898", "", BaseApplicationImpl.getApplication().getRuntime().getAccount(), "0X800ABAF", "0X800ABAF", 0, 1, "", "", "", "");
    this.bf = ((FormSwitchItem)this.mContentView.findViewById(2131363131));
    this.bg = ((FormSwitchItem)this.mContentView.findViewById(2131363130));
    this.bh = ((FormSwitchItem)this.mContentView.findViewById(2131381302));
    this.bi = ((FormSwitchItem)this.mContentView.findViewById(2131363132));
    this.bj = ((FormSwitchItem)this.mContentView.findViewById(2131363133));
    if (!akwz.cuM) {
      this.bf.setVisibility(0);
    }
    for (;;)
    {
      boolean bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131697129), "qqsetting_auto_receive_pic_key", true);
      this.bf.setChecked(bool);
      this.bf.setOnCheckedChangeListener(new ahof(this));
      bool = SettingCloneUtil.readValue(getActivity(), null, getString(2131697129), "qqsetting_auto_receive_magic_face_key", true);
      this.bg.setChecked(bool);
      this.bg.setOnCheckedChangeListener(new ahog(this));
      bool = accy.b(this.mApp, false);
      this.bh.setChecked(bool);
      this.bh.setOnCheckedChangeListener(new ahoh(this));
      bool = auqv.bI(true);
      this.bi.setChecked(bool);
      this.bi.setOnCheckedChangeListener(new ahoi(this));
      bool = auqv.bI(false);
      this.bj.setChecked(bool);
      this.bj.setOnCheckedChangeListener(new ahoj(this));
      if (VersionUtils.isGingerBread()) {
        this.e.setOverScrollMode(0);
      }
      if (AppSetting.enableTalkBack)
      {
        this.bf.setContentDescription(getString(2131719561));
        this.bg.setContentDescription(getString(2131719560));
        this.bh.setContentDescription(getString(2131721582));
        this.bi.setContentDescription(getString(2131719558));
        this.bj.setContentDescription(getString(2131719559));
      }
      return;
      this.bf.setVisibility(8);
    }
  }
  
  protected void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.mApp != null) {
        initUI();
      }
    }
  }
  
  protected int getContentLayoutId()
  {
    return 2131561663;
  }
  
  protected View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131719571));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.QQSettingAutoDownloadAndSaveFragment
 * JD-Core Version:    0.7.0.1
 */