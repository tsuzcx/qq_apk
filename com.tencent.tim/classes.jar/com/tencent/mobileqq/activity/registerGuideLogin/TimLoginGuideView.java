package com.tencent.mobileqq.activity.registerGuideLogin;

import aamp;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import aqiw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.List;

public class TimLoginGuideView
  extends TimLoginBaseView
  implements View.OnClickListener
{
  public TimLoginGuideView() {}
  
  @SuppressLint({"ValidFragment"})
  public TimLoginGuideView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void cvD()
  {
    Object localObject = this.m;
    if (!aqiw.isNetSupport((Context)localObject)) {
      QQToast.a((Context)localObject, getString(2131696270), 0).show(((BaseActivity)localObject).getTitleBarHeight());
    }
    do
    {
      return;
      this.mLoginType = 2;
      localObject = this.m.getIntent();
      ((Intent)localObject).putExtra("from_register_guide", true);
      ((Intent)localObject).putExtra("is_need_show_logo_animation", true);
      localObject = aamp.a(this.m, this.mAppInterface);
    } while (this.a == null);
    this.a.a((GuideBaseFragment)localObject);
  }
  
  private void initData()
  {
    List localList = BaseApplicationImpl.sApplication.getAllAccounts();
    StringBuilder localStringBuilder = new StringBuilder().append("initData ");
    if (localList == null) {}
    for (String str = " null";; str = localList.toString())
    {
      QLog.i("TimLoginGuideView", 1, str);
      if ((localList != null) && (localList.size() > 0)) {
        a((SimpleAccount)localList.get(0));
      }
      return;
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
      cvD();
      continue;
      cvC();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131563193, paramViewGroup, false);
    initData();
    paramLayoutInflater.findViewById(2131370887).setOnClickListener(this);
    paramLayoutInflater.findViewById(2131370894).setOnClickListener(this);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginGuideView
 * JD-Core Version:    0.7.0.1
 */