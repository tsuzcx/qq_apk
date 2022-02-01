package com.tencent.mobileqq.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import anot;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.devicelock.DevlockInfo;

public class GatewayVerifyFailedFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  private String QT;
  private String aLa;
  private boolean aRL;
  private DevlockInfo b;
  private int bDZ;
  private int bEc;
  private String bwI;
  private Activity mActivity;
  private String mUin;
  
  private void bGr()
  {
    if ((this.b == null) || (TextUtils.isEmpty(this.b.OtherDevLockVerifyUrl)))
    {
      QLog.e("GatewayVerifyFailedFragment", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
      return;
    }
    Intent localIntent = new Intent(this.mActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    Object localObject1 = this.b.OtherDevLockVerifyUrl;
    int i;
    if (!TextUtils.isEmpty(this.b.Mobile))
    {
      localObject1 = new StringBuilder(this.b.OtherDevLockVerifyUrl);
      if (this.b.OtherDevLockVerifyUrl.contains("?"))
      {
        ((StringBuilder)localObject1).append("&");
        Object localObject2 = this.b.Mobile.split("\\*+");
        if (localObject2.length > 1)
        {
          i = this.b.Mobile.length();
          int j = localObject2[0].length();
          int k = localObject2[1].length();
          localObject2 = ((StringBuilder)localObject1).append("pp=").append(localObject2[0]).append("&tp=").append(localObject2[1]).append("&ccode=").append(this.b.CountryCode).append("&vseq=").append(this.bDZ).append("&starnum=").append(i - j - k).append("&isFromLogin=");
          if (!this.aRL) {
            break label563;
          }
          i = 1;
          label244:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.tim:openSdk".equals(getActivity().getAppInterface().getApplication().getQQProcessName())) {
            break label568;
          }
          i = 1;
          label280:
          ((StringBuilder)localObject2).append(i);
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    else
    {
      localIntent.putExtra("url", (String)localObject1);
      localIntent.putExtra("subAccountUin", this.mUin);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("hide_more_button", true);
      if ((this.aLa == null) || (this.aLa.equals(this.mUin))) {
        break label590;
      }
    }
    label444:
    label579:
    label590:
    for (boolean bool = true;; bool = false) {
      for (;;)
      {
        QLog.d("GatewayVerifyFailedFragment", 1, "other_verify,  mMainAccount =" + this.aLa + " mUin =" + this.mUin + " isSubaccount=" + bool);
        localIntent.putExtra("isSubaccount", bool);
        localIntent.putExtra("avoidLoginWeb", bool);
        try
        {
          VasWebviewUtil.openQQBrowserActivity(this.mActivity, "", 16384L, localIntent, false, -1);
          this.mActivity.finish();
          if ((getActivity().getAppInterface() instanceof QQAppInterface))
          {
            localObject1 = (QQAppInterface)getActivity().getAppInterface();
            label476:
            anot.c((QQAppInterface)localObject1, "dc00898", "", "", "0X800ADE0", "0X800ADE0", 0, 0, "", "", "", "");
            if (!(getActivity().getAppInterface() instanceof QQAppInterface)) {
              break label579;
            }
          }
          for (localObject1 = (QQAppInterface)getActivity().getAppInterface();; localObject1 = null)
          {
            anot.c((QQAppInterface)localObject1, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
            return;
            ((StringBuilder)localObject1).append("?");
            break;
            i = 0;
            break label244;
            i = 0;
            break label280;
            localObject1 = null;
            break label476;
          }
        }
        catch (SecurityException localSecurityException)
        {
          break label444;
        }
      }
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mActivity = paramActivity;
    paramActivity = getArguments();
    this.QT = paramActivity.getString("phone_num");
    this.bwI = paramActivity.getString("country_code");
    this.bEc = paramActivity.getInt("mobile_type");
    this.aRL = paramActivity.getBoolean("from_login");
    this.mUin = paramActivity.getString("uin");
    this.bDZ = paramActivity.getInt("seq");
    this.b = ((DevlockInfo)paramActivity.getParcelable("DevlockInfo"));
    this.aLa = paramActivity.getString("mainaccount");
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
      this.mActivity.finish();
      continue;
      bGr();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131561306, paramViewGroup, false);
    ((TextView)paramViewGroup.findViewById(2131380837)).setOnClickListener(this);
    ((TextView)paramViewGroup.findViewById(2131369627)).setText(getString(2131693216));
    paramLayoutInflater = paramViewGroup.findViewById(2131377498);
    paramBundle = (LinearLayout.LayoutParams)paramLayoutInflater.getLayoutParams();
    paramBundle.topMargin = ImmersiveUtils.getStatusBarHeight(getActivity());
    paramLayoutInflater.setLayoutParams(paramBundle);
    paramViewGroup.findViewById(2131369579).setOnClickListener(this);
    if ((getActivity().getAppInterface() instanceof QQAppInterface)) {}
    for (paramLayoutInflater = (QQAppInterface)getActivity().getAppInterface();; paramLayoutInflater = null)
    {
      anot.c(paramLayoutInflater, "dc00898", "", "", "0X800ADDF", "0X800ADDF", 0, 0, "", "", "", "");
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment
 * JD-Core Version:    0.7.0.1
 */