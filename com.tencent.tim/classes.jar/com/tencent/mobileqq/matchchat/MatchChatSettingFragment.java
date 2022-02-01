package com.tencent.mobileqq.matchchat;

import afsg;
import afsr;
import afwh;
import aizz;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import anot;
import aqiw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MatchChatSettingFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener
{
  private FormSwitchItem br;
  private afsr c = new aizz(this);
  private Button gy;
  private QQAppInterface mApp;
  
  private void LK(boolean paramBoolean)
  {
    this.br.setOnCheckedChangeListener(null);
    this.br.setChecked(paramBoolean);
    this.br.setOnCheckedChangeListener(this);
  }
  
  private void cIj()
  {
    boolean bool = afwh.a(this.mApp).booleanValue();
    LK(bool);
    if (QLog.isColorLevel()) {
      QLog.i("MatchChatSettingFragment", 2, "initDefaultValue chatSwitchOpen:" + bool);
    }
    ((afsg)this.mApp.getBusinessHandler(127)).md(this.mApp.getCurrentUin());
  }
  
  private void initUI(View paramView)
  {
    if (paramView == null) {
      return;
    }
    this.br = ((FormSwitchItem)paramView.findViewById(2131374974));
    this.gy = ((Button)paramView.findViewById(2131374973));
    this.br.setOnCheckedChangeListener(this);
    this.gy.setOnClickListener(this);
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity().getAppRuntime() instanceof QQAppInterface))
    {
      this.mApp = ((QQAppInterface)getActivity().getAppRuntime());
      if (this.mApp != null)
      {
        this.mApp.addObserver(this.c);
        initUI(this.mContentView);
        cIj();
      }
    }
  }
  
  public int getContentLayoutId()
  {
    return 2131562973;
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = true;
    int i = 1;
    if (paramCompoundButton == this.br.a())
    {
      if (aqiw.isNetSupport(getActivity()))
      {
        ((afsg)this.mApp.getBusinessHandler(127)).B(this.mApp.getCurrentUin(), paramBoolean);
        if (paramBoolean) {
          i = 0;
        }
        anot.a(this.mApp, "dc00898", "", "", "0X800A690", "0X800A690", i, 0, "", "", "", "");
      }
    }
    else
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    if (!paramBoolean) {}
    for (;;)
    {
      LK(bool);
      QQToast.a(getActivity(), 2131696286, 0).show();
      break;
      bool = false;
    }
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
      ThreadManagerV2.excute(new MatchChatSettingFragment.2(this), 16, null, true);
    }
  }
  
  public View onCreateCenterView()
  {
    View localView = super.onCreateCenterView();
    setTitle(getActivity().getString(2131701318));
    return localView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mApp.removeObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.matchchat.MatchChatSettingFragment
 * JD-Core Version:    0.7.0.1
 */