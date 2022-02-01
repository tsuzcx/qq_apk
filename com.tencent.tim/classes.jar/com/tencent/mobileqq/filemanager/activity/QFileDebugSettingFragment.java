package com.tencent.mobileqq.filemanager.activity;

import aepp;
import aepr;
import agcq;
import agcr;
import agcs;
import agct;
import agcu;
import agcv;
import agcw;
import agcx;
import agcy;
import agiq;
import agke;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.widget.FormSwitchItem;

public class QFileDebugSettingFragment
  extends IphoneTitleBarFragment
{
  private agiq a;
  FormSwitchItem aX;
  FormSwitchItem aY;
  FormSwitchItem aZ;
  FormSwitchItem ba;
  FormSwitchItem bb;
  FormSwitchItem bc;
  RadioGroup j;
  
  private void dfu()
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131382414);
    localFormSwitchItem.setChecked(this.a.a().bVs);
    localFormSwitchItem.setOnCheckedChangeListener(new agcq(this));
    localFormSwitchItem = (FormSwitchItem)this.mContentView.findViewById(2131382415);
    localFormSwitchItem.setChecked(this.a.a().bVt);
    localFormSwitchItem.setOnCheckedChangeListener(new agcr(this));
  }
  
  private void dfv()
  {
    this.aX = ((FormSwitchItem)this.mContentView.findViewById(2131369375));
    this.aX.setChecked(agke.a().alu());
    this.aX.setOnCheckedChangeListener(new agcs(this));
    this.aY = ((FormSwitchItem)this.mContentView.findViewById(2131369371));
    this.aY.setChecked(agke.a().alv());
    this.aY.setOnCheckedChangeListener(new agct(this));
    this.aZ = ((FormSwitchItem)this.mContentView.findViewById(2131369374));
    this.aZ.setChecked(agke.a().alw());
    this.aZ.setOnCheckedChangeListener(new agcu(this));
    this.ba = ((FormSwitchItem)this.mContentView.findViewById(2131369373));
    this.ba.setChecked(agke.a().alx());
    this.ba.setOnCheckedChangeListener(new agcv(this));
    this.bb = ((FormSwitchItem)this.mContentView.findViewById(2131369372));
    this.bb.setChecked(agke.a().aly());
    this.bb.setOnCheckedChangeListener(new agcw(this));
    this.bc = ((FormSwitchItem)this.mContentView.findViewById(2131369370));
    this.bc.setChecked(agke.alt());
    this.bc.setOnCheckedChangeListener(new agcx(this));
    this.j = ((RadioGroup)this.mContentView.findViewById(2131378817));
    Object localObject;
    String str;
    TextView localTextView;
    switch (agke.a().En())
    {
    default: 
      this.j.setOnCheckedChangeListener(new agcy(this));
      localObject = (TextView)this.mContentView.findViewById(2131370899);
      str = "当前登录协议栈：IPv4";
      if (MsfServiceSdk.get().getConnectedIPFamily() == 2) {
        str = "当前登录协议栈：IPv6";
      }
      ((TextView)localObject).setText(str);
      localObject = (agiq)getActivity().app.getManager(317);
      localTextView = (TextView)this.mContentView.findViewById(2131365210);
      str = "c2c开关：关闭";
      if (((agiq)localObject).alk()) {
        str = "c2c开关：打开";
      }
      localTextView.setText(str);
      localTextView = (TextView)this.mContentView.findViewById(2131365213);
      str = "group开关：关闭";
      if (((agiq)localObject).all()) {
        str = "group开关：打开";
      }
      localTextView.setText(str);
      localTextView = (TextView)this.mContentView.findViewById(2131365212);
      str = "disc开关：关闭";
      if (((agiq)localObject).alm()) {
        str = "disc开关：打开";
      }
      localTextView.setText(str);
      localTextView = (TextView)this.mContentView.findViewById(2131365211);
      str = "数据线开关：关闭";
      if (((agiq)localObject).aln()) {
        str = "数据线开关：打开";
      }
      localTextView.setText(str);
      localTextView = (TextView)this.mContentView.findViewById(2131365218);
      if (((agiq)localObject).Eg() == 0) {
        str = "IPv6策略：v4优先";
      }
      break;
    }
    for (;;)
    {
      localTextView.setText(str);
      return;
      this.j.check(2131378814);
      break;
      this.j.check(2131378815);
      break;
      this.j.check(2131378816);
      break;
      if (((agiq)localObject).Eg() == 1) {
        str = "IPv6策略：v6优先";
      } else if (((agiq)localObject).Eg() == 2) {
        str = "IPv6策略：跟随登录";
      } else {
        str = "IPv6策略：unkonw";
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((agiq)getActivity().app.getManager(317));
    dfu();
    dfv();
  }
  
  public int getContentLayoutId()
  {
    return 2131561038;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.QFileDebugSettingFragment
 * JD-Core Version:    0.7.0.1
 */