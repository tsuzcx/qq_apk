package com.tencent.open.agent;

import acfp;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import anot;
import aqha;
import aqju;
import arpg;
import arph;
import arpi;
import asat;
import asau;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AuthorityControlAppDetailsFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private asat jdField_a_of_type_Asat;
  private asau jdField_a_of_type_Asau;
  private AppInfo jdField_a_of_type_ComTencentOpenModelAppInfo;
  private QQAppInterface app;
  private Activity mActivity;
  
  public static void a(Activity paramActivity, AppInfo paramAppInfo)
  {
    Intent localIntent = new Intent(paramActivity, AuthorityControlAppDetailsFragment.class);
    localIntent.putExtra("KEY_APP_INFO", paramAppInfo);
    PublicFragmentActivity.startForResult(paramActivity, localIntent, AuthorityControlAppDetailsFragment.class, 996);
  }
  
  private void bpM()
  {
    this.jdField_a_of_type_Asau = new arpg(this);
    this.app.addObserver(this.jdField_a_of_type_Asau);
  }
  
  private void iL(View paramView)
  {
    paramView = new arph(this);
    arpi localarpi = new arpi(this);
    String str = acfp.m(2131702935) + this.jdField_a_of_type_ComTencentOpenModelAppInfo.getName() + acfp.m(2131702926);
    paramView = aqha.a(this.mActivity, 230, str, this.mActivity.getResources().getString(2131718780), 2131721058, 2131721079, paramView, localarpi);
    try
    {
      paramView.show();
      label89:
      anot.a(this.app, "dc00898", "", "", "0X8009DC5", "0X8009DC5", 0, 0, "", "", String.valueOf(this.jdField_a_of_type_ComTencentOpenModelAppInfo.getId()), "");
      return;
    }
    catch (Throwable paramView)
    {
      break label89;
    }
  }
  
  private void initViews()
  {
    this.mContentView.findViewById(2131377120).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentOpenModelAppInfo = ((AppInfo)getActivity().getIntent().getParcelableExtra("KEY_APP_INFO"));
    setTitle(this.jdField_a_of_type_ComTencentOpenModelAppInfo.getName());
    this.jdField_a_of_type_Asat = ((asat)this.app.getBusinessHandler(151));
  }
  
  public int getContentLayoutId()
  {
    return 2131558478;
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
      iL(paramView);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Asau);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.app = getActivity().app;
    this.mActivity = getActivity();
    bpM();
    initViews();
    anot.a(this.app, "dc00898", "", "", "0X8009DC4", "0X8009DC4", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityControlAppDetailsFragment
 * JD-Core Version:    0.7.0.1
 */