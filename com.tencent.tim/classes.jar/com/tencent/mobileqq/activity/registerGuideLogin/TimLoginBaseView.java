package com.tencent.mobileqq.activity.registerGuideLogin;

import aant;
import aanu;
import aanv;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import anpc;
import aqiw;
import aqmj;
import aqnu;
import arhz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.tim.wxapi.WXApiHelper;
import com.tencent.tim.wxapi.WXApiHelper.a;
import mqq.app.WtloginPrivacyListenerImpl;
import mqq.observer.AccountObserver;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.tools.ErrMsg;
import vgy;

@SuppressLint({"ValidFragment"})
public class TimLoginBaseView
  extends GuideBaseFragment
{
  public aqnu a;
  private WXApiHelper.a jdField_a_of_type_ComTencentTimWxapiWXApiHelper$a = new aanu(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new aanv(this);
  private WtloginHelper b;
  protected vgy b;
  public arhz m;
  protected int mLoginType;
  
  public TimLoginBaseView() {}
  
  public TimLoginBaseView(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Vgy = new vgy();
  }
  
  public void AA(String paramString) {}
  
  public void Az(String paramString) {}
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, byte[] paramArrayOfByte, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte) {}
  
  protected boolean a(SimpleAccount paramSimpleAccount)
  {
    boolean bool = this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getBooleanExtra("logout_intent", false);
    StringBuilder localStringBuilder = new StringBuilder().append("isFromLogout ").append(bool);
    if (paramSimpleAccount == null) {}
    for (String str = " null";; str = paramSimpleAccount.toString())
    {
      QLog.i("TimLoginBaseView", 1, str);
      if ((paramSimpleAccount == null) || (!bool)) {
        break;
      }
      aqmj.i(BaseApplicationImpl.sApplication, paramSimpleAccount.getUin(), false);
      return true;
    }
    return false;
  }
  
  public void cvC()
  {
    anpc.report("tim_wechat_login");
    BaseActivity localBaseActivity = this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity;
    if (!aqiw.isNetSupport(localBaseActivity))
    {
      QQToast.a(localBaseActivity, getString(2131696270), 0).show(localBaseActivity.getTitleBarHeight());
      return;
    }
    this.mLoginType = 3;
    if (WXApiHelper.a().isWXinstalled())
    {
      this.jdField_m_of_type_Arhz.show();
      WXApiHelper.a().ewm();
      return;
    }
    QQToast.a(localBaseActivity, 1, 2131695574, 0).show(localBaseActivity.getTitleBarHeight());
  }
  
  public void d(String paramString1, String paramString2, byte[] paramArrayOfByte) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.mAppInterface != null) {
      this.mAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aqnu = new aqnu();
      this.jdField_b_of_type_OicqWlogin_sdkRequestWtloginHelper = new WtloginHelper(this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, WtloginPrivacyListenerImpl.getSingleton());
      WtloginHelper.setProductType(20);
      this.jdField_b_of_type_OicqWlogin_sdkRequestWtloginHelper.SetListener(new a(null));
      WXApiHelper.a().a(this.jdField_a_of_type_ComTencentTimWxapiWXApiHelper$a);
      this.jdField_m_of_type_Arhz = new arhz(getActivity(), getActivity().getTitleBarHeight());
      this.jdField_m_of_type_Arhz.setMessage("正在加载，请稍候...");
      if (this.jdField_b_of_type_Vgy != null)
      {
        paramBundle = new aant(this);
        this.jdField_b_of_type_Vgy.a(paramBundle);
      }
      return;
      paramBundle = this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime();
      if ((paramBundle != null) && ((paramBundle instanceof QQAppInterface))) {
        this.mAppInterface = ((QQAppInterface)paramBundle);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    V4FragmentCollector.onV4FragmentViewCreated(this, null);
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_b_of_type_OicqWlogin_sdkRequestWtloginHelper.SetListener(null);
    WXApiHelper.a().b(this.jdField_a_of_type_ComTencentTimWxapiWXApiHelper$a);
    if ((this.jdField_m_of_type_Arhz != null) && (this.jdField_m_of_type_Arhz.isShowing())) {
      this.jdField_m_of_type_Arhz.dismiss();
    }
  }
  
  class a
    extends WtloginListener
  {
    private a() {}
    
    public void OnException(ErrMsg paramErrMsg, int paramInt, WUserSigInfo paramWUserSigInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TimLoginBaseView", 2, "OnException errMsg " + paramErrMsg + " cmd " + paramInt);
      }
      if ((TimLoginBaseView.this.jdField_m_of_type_Arhz != null) && (TimLoginBaseView.this.jdField_m_of_type_Arhz.isShowing())) {
        TimLoginBaseView.this.jdField_m_of_type_Arhz.dismiss();
      }
      QQToast.a(TimLoginBaseView.this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 2131695507, 0).show();
    }
    
    public void onLoginByWeChat(long paramLong, byte[] paramArrayOfByte, WtloginHelper.QuickLoginParam paramQuickLoginParam, int paramInt1, int paramInt2, ErrMsg paramErrMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimLoginBaseView", 2, "onLoginByWeChat uin:" + paramLong + " ret:" + paramInt2 + " errMsg:" + paramErrMsg + " userFlag:" + paramInt1);
      }
      if (paramInt2 == 0)
      {
        paramQuickLoginParam = String.valueOf(paramLong);
        WXApiHelper.a().d(paramQuickLoginParam, paramArrayOfByte, paramInt1);
        if (!TextUtils.isEmpty(paramQuickLoginParam))
        {
          MsfSdkUtils.updateSimpleAccount(paramQuickLoginParam, true, true);
          paramArrayOfByte = TimLoginBaseView.this.getActivity().app;
          if (paramArrayOfByte != null)
          {
            paramArrayOfByte.loginByWx(paramQuickLoginParam, TimLoginBaseView.a(TimLoginBaseView.this), null);
            WXApiHelper.a().bm(paramArrayOfByte, paramArrayOfByte.getAccount());
          }
        }
        return;
      }
      if (paramInt2 == 230)
      {
        TimLoginBaseView.this.a.a(paramQuickLoginParam.userSigInfo);
        if ((TimLoginBaseView.this.jdField_m_of_type_Arhz != null) && (TimLoginBaseView.this.jdField_m_of_type_Arhz.isShowing())) {
          TimLoginBaseView.this.jdField_m_of_type_Arhz.dismiss();
        }
        if (!aqiw.isNetSupport(BaseApplicationImpl.sApplication))
        {
          QQToast.a(TimLoginBaseView.this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, 2131693404, 0).show();
          return;
        }
        paramArrayOfByte = new Intent(TimLoginBaseView.this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, RegisterPhoneNumActivity.class);
        paramArrayOfByte.putExtra("key_register_from", 3);
        paramArrayOfByte.putExtra("key_report_extra_from", 2);
        TimLoginBaseView.this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramArrayOfByte);
        return;
      }
      if ((TimLoginBaseView.this.jdField_m_of_type_Arhz != null) && (TimLoginBaseView.this.jdField_m_of_type_Arhz.isShowing())) {
        TimLoginBaseView.this.jdField_m_of_type_Arhz.dismiss();
      }
      paramQuickLoginParam = paramErrMsg.getMessage();
      paramArrayOfByte = paramQuickLoginParam;
      if (TextUtils.isEmpty(paramQuickLoginParam)) {
        paramArrayOfByte = TimLoginBaseView.this.getString(2131695507);
      }
      QQToast.a(TimLoginBaseView.this.jdField_m_of_type_ComTencentMobileqqAppBaseActivity, paramArrayOfByte, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.TimLoginBaseView
 * JD-Core Version:    0.7.0.1
 */