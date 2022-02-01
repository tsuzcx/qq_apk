package com.tencent.mobileqq.activity.activateFriend;

import Wallet.AcsGetMsgRsp;
import acfp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.widget.ImmersionBar;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import cooperation.qwallet.plugin.FakeUrl;
import mqq.app.AppRuntime;
import whn;
import whr;
import whs;
import wht;
import wie;
import wih;
import wii;

public abstract class QQNotifySettingBaseFragment
  extends PublicBaseFragment
  implements View.OnClickListener, wie
{
  private static final String TAG = QQNotifySettingBaseFragment.class.getSimpleName();
  protected TextView Hy;
  protected TextView Hz;
  private whr jdField_a_of_type_Whr;
  private wii jdField_a_of_type_Wii;
  private String aSh;
  protected String aSi = "user cancel";
  protected int bNq = 9;
  protected boolean bcq;
  protected Button dN;
  private String domain;
  private FakeUrl mFakeUrl;
  private final Handler mainHandler = new Handler(Looper.getMainLooper());
  private String msgId;
  protected View root;
  
  private void bYg()
  {
    wih.b(this.msgId, this.domain, new whs(this));
  }
  
  private void bYh()
  {
    wih.a(this.msgId, this.domain, new wht(this));
  }
  
  private QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void a(AcsGetMsgRsp paramAcsGetMsgRsp)
  {
    long l;
    if (paramAcsGetMsgRsp != null)
    {
      if (paramAcsGetMsgRsp.ret_code != 0) {
        break label74;
      }
      this.Hy.setText(paramAcsGetMsgRsp.content);
      l = paramAcsGetMsgRsp.notice_time;
      if (l != 0L) {
        break label54;
      }
      this.Hz.setText(acfp.m(2131711983));
    }
    for (;;)
    {
      this.dN.setEnabled(true);
      return;
      label54:
      this.Hz.setText(whn.h(l * 1000L, "yyyy-MM-dd HH:mm:ss"));
    }
    label74:
    bYi();
    this.dN.setEnabled(false);
  }
  
  protected void bm(int paramInt, String paramString)
  {
    if (getActivity() != null)
    {
      bo(paramInt, paramString);
      getActivity().finish();
    }
  }
  
  public abstract View d(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup);
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      bm(this.bNq, this.aSi);
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.jdField_a_of_type_Whr = new whr(getActivity());
    this.jdField_a_of_type_Whr.show();
    this.mFakeUrl = new FakeUrl(getActivity());
    bYg();
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
      String str = (String)paramView.getTag();
      if ("0".equals(str))
      {
        bYh();
      }
      else if ("1".equals(str))
      {
        bm(this.bNq, this.aSi);
        continue;
        bm(this.bNq, this.aSi);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    wih.e(getApp());
    this.root = d(paramLayoutInflater, paramViewGroup);
    new ImmersionBar(getActivity(), 0, this.root.findViewById(2131378716));
    this.Hy = ((TextView)this.root.findViewById(2131380826));
    this.Hz = ((TextView)this.root.findViewById(2131380827));
    this.dN = ((Button)this.root.findViewById(2131363996));
    this.dN.setOnClickListener(this);
    this.msgId = getArguments().getString("key_msgid");
    this.aSh = getArguments().getString("key_busid");
    this.domain = getArguments().getString("key_domain");
    this.jdField_a_of_type_Wii = new wii(getApp());
    paramLayoutInflater = this.root;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((this.jdField_a_of_type_Whr != null) && (this.jdField_a_of_type_Whr.isShowing())) {
      this.jdField_a_of_type_Whr.dismiss();
    }
    if (this.mainHandler != null) {
      this.mainHandler.removeCallbacksAndMessages(null);
    }
    wih.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.QQNotifySettingBaseFragment
 * JD-Core Version:    0.7.0.1
 */