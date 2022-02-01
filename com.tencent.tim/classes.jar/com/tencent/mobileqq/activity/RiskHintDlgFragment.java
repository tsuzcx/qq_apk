package com.tencent.mobileqq.activity;

import afsf;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import anot;
import aqha;
import aqiw;
import aqju;
import aqmj;
import aqyc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import org.json.JSONObject;
import vsl;
import vsm;
import vsn;
import vso;
import vsp;
import vsq;
import vsr;
import vss;

public class RiskHintDlgFragment
  extends PublicBaseFragment
{
  public String aPG;
  public String aPH;
  public String aPI;
  private boolean aRG = true;
  WtloginObserver b;
  public DevlockInfo b;
  
  public RiskHintDlgFragment()
  {
    this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    this.jdField_b_of_type_MqqObserverWtloginObserver = new vss(this);
  }
  
  private void bRh()
  {
    Intent localIntent = new Intent(getActivity(), AuthDevActivity.class);
    localIntent.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
    localIntent.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
    localIntent.putExtra("auth_dev_open", false);
    localIntent.putExtra("from_risk_hint", true);
    localIntent.putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
    localIntent.putExtra("auth_dev_gray_switch", this.aRG);
    startActivityForResult(localIntent, 0);
  }
  
  void bMU()
  {
    String str = getActivity().app.getCurrentAccountUin();
    int i = afsf.a().a(getActivity().app, str, this.jdField_b_of_type_MqqObserverWtloginObserver);
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RiskHintDlgFragment", 2, "startGetDevLockStatus CheckDevLockStatus failed. ret=" + i);
      }
      this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo = null;
    }
    str = aqmj.aa(getActivity(), getActivity().app.getCurrentAccountUin());
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      if (new JSONObject(str).optInt("securityType", 0) == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.aRG = bool;
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("RiskHintDlgFragment", 1, new Object[] { "parse dev gray switch error : ", localException.getMessage() });
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setFlags(1024, 1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  void k(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString1 = aqha.a(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, paramString5, new vso(this), new vsp(this), new vsq(this));
      paramString1.setOnDismissListener(new vsr(this));
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Bundle localBundle = getArguments();
    long l = localBundle.getLong("BusiType", 0L);
    String str1 = localBundle.getString("Title", "风险提示");
    String str2 = localBundle.getString("Message", "该帐号被安全扫描检测到存在密码外泄风险，为保障你的帐号财产与隐私安全，请尽快修改密码，并建议在\"设置\"-\"帐号安全\"-\"登录保护\"开启登录保护。");
    String str3 = localBundle.getString("btnText1", "");
    String str4 = localBundle.getString("btnText2", "");
    String str5 = localBundle.getString("btnText3", "");
    this.aPG = localBundle.getString("btnAction1", "");
    this.aPH = localBundle.getString("btnAction2", "");
    this.aPI = localBundle.getString("btnAction3", "");
    if (l == 1062L) {
      t(str1, str2, str3, str4);
    }
    for (;;)
    {
      bMU();
      aqyc.Yb(2);
      anot.a(getActivity().app, "dc00898", "", "", "0X800AAA3", "0X800AAA3", 0, 0, "", "", "", "");
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      if (l == 1063L)
      {
        k(str1, str2, str3, str4, str5);
      }
      else
      {
        QLog.e("RiskHintDlgFragment", 1, new Object[] { "error templateId:", Long.valueOf(l) });
        if (getActivity() != null) {
          getActivity().finish();
        }
      }
    }
  }
  
  void t(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      paramString1 = aqha.b(getActivity(), 0, paramString1, paramString2, paramString3, paramString4, new vsl(this), new vsm(this));
      paramString1.setOnDismissListener(new vsn(this));
      paramString1.show();
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("RiskHintDlgFragment", 1, paramString1, new Object[0]);
      getActivity().finish();
    }
  }
  
  public void wt(String paramString)
  {
    if ("1".equals(paramString)) {
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo == null)
      {
        if (aqiw.isNetSupport(getActivity())) {
          break label139;
        }
        QQToast.a(getActivity(), getString(2131693404), 0).show(getActivity().getTitleBarHeight());
      }
    }
    label139:
    do
    {
      return;
      if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.DevSetup == 1)
      {
        paramString = new Intent(getActivity(), AuthDevActivity.class);
        paramString.putExtra("phone_num", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile);
        paramString.putExtra("country_code", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.CountryCode);
        paramString.putExtra("auth_dev_open", true);
        paramString.putExtra("from_risk_hint", true);
        paramString.putExtra("auth_dev_gray_switch", this.aRG);
        startActivity(paramString);
      }
      for (;;)
      {
        anot.a(getActivity().app, "dc00898", "", "", "0X800AAA5", "0X800AAA5", 0, 0, "", "", "", "");
        bMU();
        if (getActivity() == null) {
          break;
        }
        getActivity().finish();
        return;
        if (TextUtils.isEmpty(this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.Mobile))
        {
          if (this.aRG)
          {
            bRh();
            return;
          }
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 0)
        {
          if (this.aRG)
          {
            bRh();
            return;
          }
          paramString = new Intent(getActivity(), AuthDevOpenUgActivity.class);
          paramString.putExtra("DevlockInfo", this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo);
          paramString.putExtra("from_risk_hint", true);
          startActivity(paramString);
        }
        else if (this.jdField_b_of_type_OicqWlogin_sdkDevicelockDevlockInfo.AllowSet == 1)
        {
          bRh();
        }
      }
      if ((!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https"))))
      {
        Intent localIntent = new Intent(getActivity(), QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("from_risk_hint", true);
        getActivity().startActivity(localIntent);
        anot.a(getActivity().app, "dc00898", "", "", "0X800AAA4", "0X800AAA4", 0, 0, "", "", "", "");
        return;
      }
      anot.a(getActivity().app, "dc00898", "", "", "0X800AAA6", "0X800AAA6", 0, 0, "", "", "", "");
    } while (getActivity() == null);
    getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RiskHintDlgFragment
 * JD-Core Version:    0.7.0.1
 */