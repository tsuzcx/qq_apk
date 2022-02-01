package com.tencent.mobileqq.activity;

import afsb;
import afsf;
import aivs;
import aivs.a;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anpc;
import aqgz;
import aqiw;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.GatewayVerifyFailedFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.AuthDevVerifyCodeActivity2;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import lfn;
import mqq.app.MobileQQ;
import mqq.manager.VerifyDevLockManager.NotifyType;
import mqq.manager.VerifyDevLockManager.VerifyDevLockObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.tools.ErrMsg;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqBodySelfPhone;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheck;
import tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrl;
import vie;
import wja;

public class NewAuthDevUgFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static final ArrayList<String> oR = new ArrayList(Arrays.asList(new String[] { "0X800AA33", "0X800AA34", "0X800AA35", "0X800AA36", "0X800AA37" }));
  private TextView Er;
  private TextView Es;
  private TextView Et;
  private TextView Eu;
  private TextView Ev;
  private long Fl;
  private long Fm;
  private String QW;
  private aivs jdField_a_of_type_Aivs;
  private a jdField_a_of_type_ComTencentMobileqqActivityNewAuthDevUgFragment$a;
  private VerifyDevLockManager.VerifyDevLockObserver jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver;
  private String aLa;
  private boolean aRL;
  private boolean aYK;
  private DevlockInfo b;
  private int bDZ;
  private int bIE;
  private RelativeLayout gS;
  private BaseActivity mActivity;
  private AppInterface mApp;
  private int mChannelId;
  private String mMsgId;
  private ProgressBar mProgressBar;
  private String mUin;
  private VerifyDevLockManager.VerifyDevLockObserver mVerifyObserver = new vie(this);
  private View tG;
  
  private void D(String paramString1, int paramInt, String paramString2)
  {
    Object localObject = this.mActivity.getAppInterface();
    if (localObject == null) {}
    for (localObject = "";; localObject = ((AppInterface)localObject).getAccount())
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("K_RESULT_TYPE", paramString1);
      localHashMap.put("K_RET", String.valueOf(paramInt));
      localHashMap.put("K_UIN", localObject);
      localHashMap.put("K_RESULT_MSG", paramString2);
      if ("V_RET_SUCCESS".equals(paramString1)) {
        localHashMap.put("K_REDIRECT_TIME", String.valueOf(this.bIE));
      }
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance((String)localObject, "TGatewayVerifyResult", "V_RET_SUCCESS".equals(paramString1), 0L, 0L, localHashMap, "");
      return;
    }
  }
  
  private void bGr()
  {
    boolean bool = true;
    if ((this.b == null) || (TextUtils.isEmpty(this.b.OtherDevLockVerifyUrl)))
    {
      QLog.e("NewAuthDevUgFragment", 1, "jumpToOtherVerify, mDevlockInfo or OtherDevLockVerifyUrl is null");
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
            break label529;
          }
          i = 1;
          label251:
          localObject2 = ((StringBuilder)localObject2).append(i).append("&isFromOpenSdk=");
          if (!"com.tencent.tim:openSdk".equals(this.mApp.getApplication().getQQProcessName())) {
            break label534;
          }
          i = 1;
          label286:
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
        break label550;
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NewAuthDevUgFragment", 2, "other_verify,  mMainAccount =" + this.aLa + " mUin =" + this.mUin + " isSubaccount=" + bool);
        }
        localIntent.putExtra("isSubaccount", bool);
        localIntent.putExtra("avoidLoginWeb", bool);
        bGs();
        try
        {
          VasWebviewUtil.openQQBrowserActivity(this.mActivity, "", 16384L, localIntent, false, -1);
          label466:
          bGt();
          if ((this.mApp instanceof QQAppInterface)) {}
          for (localObject1 = (QQAppInterface)this.mApp;; localObject1 = null)
          {
            anot.c((QQAppInterface)localObject1, "dc00898", "", "", "0X800A413", "0X800A413", 0, 0, "", "", "", "");
            return;
            ((StringBuilder)localObject1).append("?");
            break;
            label529:
            i = 0;
            break label251;
            label534:
            i = 0;
            break label286;
          }
        }
        catch (SecurityException localSecurityException)
        {
          break label466;
        }
      }
      label550:
      bool = false;
    }
  }
  
  private void bGu()
  {
    Object localObject = new GatewayVerify.ReqBody();
    GatewayVerify.ReqBodySelfPhone localReqBodySelfPhone = new GatewayVerify.ReqBodySelfPhone();
    GatewayVerify.ReqBodySelfPhoneGetUrl localReqBodySelfPhoneGetUrl = new GatewayVerify.ReqBodySelfPhoneGetUrl();
    localReqBodySelfPhoneGetUrl.uint32_get_upload_url.set(1);
    try
    {
      i = aqgz.aL(this.mActivity);
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "carrier ：", Integer.valueOf(i) });
      localReqBodySelfPhoneGetUrl.uint32_isp_type.set(i);
      String str = lfn.getLocalIp();
      if ((!aqiw.isWifiConnected(this.mActivity)) && (!"0.0.0.0".equals(str)))
      {
        localReqBodySelfPhoneGetUrl.str_cell_ip.set(str);
        localReqBodySelfPhone.msg_req_get_url.set(localReqBodySelfPhoneGetUrl);
        ((GatewayVerify.ReqBody)localObject).msg_req_self_phone.set(localReqBodySelfPhone);
        localObject = ((GatewayVerify.ReqBody)localObject).toByteArray();
        i = afsf.a().a(this.mActivity.getAppInterface(), (byte[])localObject, this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver);
        if (i != 0) {
          break label217;
        }
        this.Er.setText(2131701084);
        this.mProgressBar.setVisibility(0);
      }
    }
    catch (Exception localException)
    {
      int i;
      for (;;)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "getCarrier error : ", localException.getMessage() });
        i = 0;
        continue;
        QLog.d("NewAuthDevUgFragment", 1, "get ip error");
      }
      label217:
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "refreshDevLockSms error , ret : ", Integer.valueOf(i) });
    }
  }
  
  private void bRQ()
  {
    this.aYK = false;
    if ("com.tencent.tim:openSdk".equals(this.mApp.getApplication().getQQProcessName()))
    {
      localObject = new Intent(this.mActivity, AuthDevVerifyCodeActivity2.class);
      if (this.b != null)
      {
        ((Intent)localObject).putExtra("phone_num", this.b.Mobile);
        ((Intent)localObject).putExtra("country_code", this.b.CountryCode);
        ((Intent)localObject).putExtra("mobile_type", 0);
      }
      ((Intent)localObject).putExtra("from_login", this.aRL);
      ((Intent)localObject).putExtra("uin", this.mUin);
      ((Intent)localObject).putExtra("seq", this.bDZ);
      startActivityForResult((Intent)localObject, 1002);
      this.mActivity.finish();
      if (!(this.mApp instanceof QQAppInterface)) {
        break label202;
      }
    }
    label202:
    for (Object localObject = (QQAppInterface)this.mApp;; localObject = null)
    {
      anot.c((QQAppInterface)localObject, "dc00898", "", this.mUin, "0X800ADDE", "0X800ADDE", 0, 0, "", "", "", "");
      return;
      localObject = new Intent(this.mActivity, AuthDevVerifyCodeActivity.class);
      break;
    }
  }
  
  private void bRR()
  {
    this.aYK = false;
    Intent localIntent = new Intent();
    if (this.b != null)
    {
      localIntent.putExtra("phone_num", this.b.Mobile);
      localIntent.putExtra("country_code", this.b.CountryCode);
      localIntent.putExtra("mobile_type", 0);
      localIntent.putExtra("DevlockInfo", this.b);
    }
    localIntent.putExtra("from_login", this.aRL);
    localIntent.putExtra("uin", this.mUin);
    localIntent.putExtra("seq", this.bDZ);
    localIntent.putExtra("mainaccount", this.aLa);
    PublicFragmentActivity.startForResult(this, localIntent, GatewayVerifyFailedFragment.class, 1);
    this.mActivity.finish();
  }
  
  public boolean Qk()
  {
    return (this.mActivity == null) || (this.mActivity.isFinishing());
  }
  
  protected void bGs()
  {
    this.mActivity.finish();
    QLog.d("NewAuthDevUgFragment", 1, "beforeOpenBrowser do finish");
  }
  
  protected void bGt()
  {
    QLog.d("NewAuthDevUgFragment", 1, "afterOpenBrowser do nothing");
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1001) {
      if (paramInt2 == -1)
      {
        paramIntent = new Intent(this.mActivity, AuthDevActivity.class);
        if (this.b != null)
        {
          paramIntent.putExtra("phone_num", this.b.Mobile);
          paramIntent.putExtra("country_code", this.b.CountryCode);
        }
        paramIntent.putExtra("auth_dev_open", true);
        startActivity(paramIntent);
        paramIntent = new Intent();
        paramIntent.putExtra("auth_dev_open", true);
        paramIntent.putExtra("allow_set", true);
        if (this.b != null) {
          paramIntent.putExtra("phone_num", this.b.Mobile);
        }
        this.mActivity.setResult(-1, paramIntent);
        this.mActivity.finish();
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            boolean bool;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      return;
                      if (paramInt1 != 1002) {
                        break;
                      }
                    } while (paramInt2 != -1);
                    this.mActivity.setResult(paramInt2, paramIntent);
                    this.mActivity.finish();
                    return;
                  } while (paramInt1 != 1003);
                  localObject = this.mActivity;
                  if (paramInt2 != -1) {
                    break;
                  }
                } while ((paramIntent == null) || (paramIntent.getExtras() == null));
                paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
                if (QLog.isColorLevel()) {
                  QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_OK  resultState =" + paramInt1);
                }
              } while (paramInt1 != 2);
              localObject = paramIntent.getExtras().getString("resultMobileMask");
              bool = paramIntent.getExtras().getBoolean("resultSetMobile");
              if (QLog.isColorLevel()) {
                QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_OK  resultMobileMask =" + (String)localObject + " openSuccess=" + bool);
              }
              if (this.b != null)
              {
                this.b.Mobile = ((String)localObject);
                if (!TextUtils.isEmpty(this.b.Mobile))
                {
                  paramIntent = getString(2131693221) + ":" + this.b.Mobile;
                  this.Ev.setText(paramIntent);
                  this.Er.setText(getString(2131693169));
                  this.Et.setVisibility(8);
                }
              }
            } while (!bool);
            afsf.a().a(this.mApp, this.mActivity, this.mApp.getCurrentAccountUin(), true);
            paramIntent = new Intent(this.mActivity, AuthDevActivity.class);
            paramIntent.putExtra("phone_num", (String)localObject);
            if (this.b != null) {
              paramIntent.putExtra("country_code", this.b.CountryCode);
            }
            paramIntent.putExtra("auth_dev_open", true);
            startActivity(paramIntent);
            QQToast.a(this.mActivity, 2, getString(2131693163), 0).show();
            Object localObject = new Intent();
            ((Intent)localObject).putExtra("auth_dev_open", true);
            ((Intent)localObject).putExtra("allow_set", true);
            if (this.b != null) {
              ((Intent)localObject).putExtra("phone_num", this.b.Mobile);
            }
            this.mActivity.setResult(-1, paramIntent);
            this.mActivity.finish();
            return;
          } while ((paramInt2 != 0) || (paramIntent == null) || (paramIntent.getExtras() == null));
          paramInt1 = paramIntent.getExtras().getInt("resultState", 1);
          if (QLog.isColorLevel()) {
            QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_CANCELED resultState =" + paramInt1);
          }
        } while (paramInt1 != 2);
        paramIntent = paramIntent.getExtras().getString("resultMobileMask");
        if (QLog.isColorLevel()) {
          QLog.d("NewAuthDevUgFragment", 2, "onActivityResult.resultCode= RESULT_CANCELED resultMobileMask =" + paramIntent);
        }
        if (!TextUtils.isEmpty(paramIntent)) {
          afsf.a().a(this.mApp, this.mApp.getCurrentAccountUin(), null);
        }
      } while (this.b == null);
      this.b.Mobile = paramIntent;
    } while (TextUtils.isEmpty(this.b.Mobile));
    paramIntent = getString(2131693221) + ":" + this.b.Mobile;
    this.Ev.setText(paramIntent);
    this.Er.setText(getString(2131693169));
    this.Et.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    if ((this.Fl > 0L) && (System.currentTimeMillis() - this.Fl > 0L) && (System.currentTimeMillis() - this.Fl < 500L)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        this.Fl = System.currentTimeMillis();
        if ((this.mApp instanceof QQAppInterface)) {}
        for (localQQAppInterface = (QQAppInterface)this.mApp;; localQQAppInterface = null) {
          switch (paramView.getId())
          {
          default: 
            break;
          case 2131369673: 
            this.mActivity.finish();
            anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800ADDA", "0X800ADDA", 0, 0, "", "", "", "");
            break;
          }
        }
        anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800AA34", "0X800AA34", AuthDevUgActivity.vj(), 0, "", "", "", "");
        anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800ADDD", "0X800ADDD", 0, 0, "", "", "", "");
        this.mApp.sendWirelessMeibaoReq(1);
        if (BaseActivity.mAppForground)
        {
          if ((!TextUtils.isEmpty(this.QW)) && (this.QW.equals("subaccount")))
          {
            if (QLog.isColorLevel()) {
              QLog.d("NewAuthDevUgFragment", 2, "subaccount enter webview mUin=" + this.mUin + " mMainAccount=" + this.aLa);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            afsb.f(this.mActivity, this.aLa, this.mUin, afsb.cTH);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("NewAuthDevUgFragment", 2, "mainaccount enter webview mUin=" + this.mUin);
            }
            if ((TextUtils.isEmpty(this.mUin)) && (QLog.isColorLevel())) {
              QLog.d("NewAuthDevUgFragment", 2, "mUin is empty.");
            }
            afsb.f(this.mActivity, this.mApp.getCurrentAccountUin(), this.mUin, afsb.cTH);
          }
        }
        else
        {
          afsb.a(this.mActivity, this.mApp, afsb.cTH);
          continue;
          if ((this.Fm <= 0L) || (System.currentTimeMillis() - this.Fm <= 0L) || (System.currentTimeMillis() - this.Fm >= 3000L))
          {
            this.Fm = System.currentTimeMillis();
            anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800AA36", "0X800AA36", AuthDevUgActivity.vj(), 0, "", "", "", "");
            anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800ADDC", "0X800ADDC", 0, 0, "", "", "", "");
            bGr();
          }
        }
      }
    } while (this.aYK);
    boolean bool3 = this.aRL;
    boolean bool1;
    label590:
    boolean bool2;
    if (this.b == null)
    {
      bool1 = true;
      if ((this.b == null) || (!TextUtils.isEmpty(this.b.Mobile))) {
        break label762;
      }
      bool2 = true;
      label612:
      QLog.d("NewAuthDevUgFragment", 1, new Object[] { "onCLick Verify btn, from login: ", Boolean.valueOf(bool3), "mDev is null ? ", Boolean.valueOf(bool1), " , mobile is null ? ", Boolean.valueOf(bool2) });
      if ((this.b == null) || (!this.aRL)) {
        break label774;
      }
      anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800AA35", "0X800AA35", AuthDevUgActivity.vj(), 0, "", "", "", "");
      if (!TextUtils.isEmpty(this.b.Mobile)) {
        break label767;
      }
      bGr();
    }
    for (;;)
    {
      anot.c(localQQAppInterface, "dc00898", "", this.mUin, "0X800ADDB", "0X800ADDB", 0, 0, "", "", "", "");
      break;
      bool1 = false;
      break label590;
      label762:
      bool2 = false;
      break label612;
      label767:
      bGu();
      continue;
      label774:
      if ((this.b != null) && (!TextUtils.isEmpty(this.b.Mobile)))
      {
        anot.a(null, "CliOper", "", "", "My_eq_lock", "My_eq_lock_open", 0, 0, "1", "", "", "");
        Intent localIntent = new Intent(this.mActivity, AuthDevVerifyCodeActivity.class);
        localIntent.putExtra("phone_num", this.b.Mobile);
        localIntent.putExtra("country_code", this.b.CountryCode);
        startActivityForResult(localIntent, 1001);
      }
      else
      {
        afsb.a(this.mActivity, this.mApp, afsb.cTH, 1003, null);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mActivity = getActivity();
    this.mApp = this.mActivity.getAppInterface();
    if ((!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) && (!ThemeUtil.isGoldenTheme())) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ImmersiveUtils.setStatusTextColor(true, this.mActivity.getWindow());
      }
      paramViewGroup = paramLayoutInflater.inflate(2131561304, paramViewGroup, false);
      this.Er = ((TextView)paramViewGroup.findViewById(2131381021));
      this.Es = ((TextView)paramViewGroup.findViewById(2131380837));
      this.tG = paramViewGroup.findViewById(2131369673);
      this.Et = ((TextView)paramViewGroup.findViewById(2131380598));
      this.Eu = ((TextView)paramViewGroup.findViewById(2131380944));
      this.gS = ((RelativeLayout)paramViewGroup.findViewById(2131377520));
      this.mProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131373700));
      paramViewGroup.findViewById(2131369673).setOnClickListener(this);
      this.gS.setOnClickListener(this);
      this.Es.setOnClickListener(this);
      this.Et.setOnClickListener(this);
      paramLayoutInflater = getArguments();
      if (paramLayoutInflater != null) {
        break;
      }
      this.mActivity.finish();
      V4FragmentCollector.onV4FragmentViewCreated(this, paramViewGroup);
      return paramViewGroup;
    }
    paramBundle = (RelativeLayout.LayoutParams)this.tG.getLayoutParams();
    paramBundle.topMargin = (wja.dp2px(6.0F, this.mActivity.getResources()) + ImmersiveUtils.getStatusBarHeight(this.mActivity));
    this.tG.setLayoutParams(paramBundle);
    for (;;)
    {
      try
      {
        this.aRL = paramLayoutInflater.getBoolean("from_login");
        this.bDZ = paramLayoutInflater.getInt("seq");
        paramBundle = paramLayoutInflater.get("DevlockInfo");
        if ((paramBundle instanceof DevlockInfo)) {
          this.b = ((DevlockInfo)paramBundle);
        }
        this.mUin = paramLayoutInflater.getString("uin");
        this.QW = paramLayoutInflater.getString("from_where");
        this.aLa = paramLayoutInflater.getString("mainaccount");
        if ((this.b != null) && (this.b.Mobile != null))
        {
          this.Ev = ((TextView)paramViewGroup.findViewById(2131380840));
          this.Ev.setText(getString(2131701082, new Object[] { this.b.Mobile }));
          if (!TextUtils.isEmpty(this.b.VerifyReason)) {
            this.Eu.setText(this.b.VerifyReason);
          }
        }
        if (QLog.isColorLevel())
        {
          QLog.d("NewAuthDevUgFragment", 2, "onCreate mIsFromLogin = " + this.aRL + " mVerifySeq=" + this.bDZ + " mUin=" + this.mUin + " mFromWhere=" + this.QW + " mMainAccount=" + this.aLa);
          if (this.b != null)
          {
            QLog.d("NewAuthDevUgFragment", 2, "onCreate DevlockInfo devSetup:" + this.b.DevSetup + " countryCode:" + this.b.CountryCode + " mobile:" + this.b.Mobile + " MbItemSmsCodeStatus:" + this.b.MbItemSmsCodeStatus + " TimeLimit:" + this.b.TimeLimit + " AvailableMsgCount:" + this.b.AvailableMsgCount + " AllowSet:" + this.b.AllowSet);
            QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.ProtectIntro:" + this.b.ProtectIntro + "  info.MbGuideType:" + this.b.MbGuideType);
            QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideMsg:" + this.b.MbGuideMsg);
            QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideInfoType:" + this.b.MbGuideInfoType);
            QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.MbGuideInfo:" + this.b.MbGuideInfo);
            QLog.d("NewAuthDevUgFragment", 2, "DevlockInfo.OtherDevLockVerifyUrl" + this.b.OtherDevLockVerifyUrl);
          }
        }
        if (!(this.mApp instanceof QQAppInterface)) {
          break label1135;
        }
        paramLayoutInflater = (QQAppInterface)this.mApp;
        this.mActivity.getWindow().setFormat(-3);
        if (this.aRL) {
          this.mActivity.setTheme(2131756129);
        }
        if (this.aRL)
        {
          paramBundle = this.mApp.getHandler(LoginActivity.class);
          if (paramBundle != null) {
            paramBundle.sendEmptyMessage(20140107);
          }
          paramBundle = this.mApp.getHandler(SubLoginActivity.class);
          if (paramBundle != null) {
            paramBundle.sendEmptyMessage(20140107);
          }
          paramBundle = this.mApp.getHandler(AddAccountActivity.class);
          if (paramBundle != null) {
            paramBundle.sendEmptyMessage(20140107);
          }
        }
        this.jdField_a_of_type_Aivs = aivs.a();
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver = new b(this.mVerifyObserver);
        this.jdField_a_of_type_MqqManagerVerifyDevLockManager$VerifyDevLockObserver.setSeq(this.bDZ);
        this.jdField_a_of_type_ComTencentMobileqqActivityNewAuthDevUgFragment$a = new a(this);
        anot.c(paramLayoutInflater, "dc00898", "", this.mUin, "0X800AA33", "0X800AA33", AuthDevUgActivity.vj(), 0, "", "", "", "");
        anot.c(paramLayoutInflater, "dc00898", "", this.mUin, "0X800ADD9", "0X800ADD9", 0, 0, "", "", "", "");
        if (AuthDevUgActivity.vj() == 1) {
          anot.c(paramLayoutInflater, "dc00898", "", this.mUin, "0X800AC0B", "0X800AC0B", AuthDevUgActivity.vj(), 0, "", "", "", "");
        }
      }
      catch (Exception paramLayoutInflater)
      {
        QLog.e("NewAuthDevUgFragment", 1, new Object[] { "get devInfo error : ", paramLayoutInflater.getMessage() });
        this.mActivity.finish();
      }
      break;
      label1135:
      paramLayoutInflater = null;
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityNewAuthDevUgFragment$a != null) {
      a.a(this.jdField_a_of_type_ComTencentMobileqqActivityNewAuthDevUgFragment$a).clear();
    }
    this.jdField_a_of_type_Aivs.destroy();
  }
  
  public void onResume()
  {
    super.onResume();
    if (!this.aYK)
    {
      this.Er.setText(getString(2131701080));
      this.mProgressBar.setVisibility(8);
    }
  }
  
  public static class a
    implements aivs.a
  {
    private WeakReference<NewAuthDevUgFragment> aE;
    
    public a(NewAuthDevUgFragment paramNewAuthDevUgFragment)
    {
      this.aE = new WeakReference(paramNewAuthDevUgFragment);
    }
    
    public void a(int paramInt, Exception paramException)
    {
      NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.aE.get();
      if (localNewAuthDevUgFragment == null)
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onGetTokenError mFragmentRef.get() is null");
        return;
      }
      if (localNewAuthDevUgFragment.Qk())
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onGetTokenError getActivity is null or activity is finish");
        return;
      }
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onGetTokenError : ", paramException.getMessage() });
      NewAuthDevUgFragment.a(localNewAuthDevUgFragment, "V_GET_TOKEN_ERROR", paramInt, paramException.getMessage());
      NewAuthDevUgFragment.a(localNewAuthDevUgFragment);
    }
    
    public void c(Exception paramException)
    {
      NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.aE.get();
      if (localNewAuthDevUgFragment == null)
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onChangeNetworkError mFragmentRef.get() is null");
        return;
      }
      if (localNewAuthDevUgFragment.Qk())
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onChangeNetworkError getActivity is null or activity is finish");
        return;
      }
      QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onChangeNetworkError : ", paramException.getMessage() });
      NewAuthDevUgFragment.a(localNewAuthDevUgFragment, "V_CHANGE_NETWORK_TYPE_ERROR", -1, paramException.getMessage());
      NewAuthDevUgFragment.a(localNewAuthDevUgFragment);
    }
    
    public void jdMethod_do(String paramString1, String paramString2)
    {
      NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.aE.get();
      if (localNewAuthDevUgFragment == null) {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onResponse mFragmentRef.get() is null");
      }
      for (;;)
      {
        return;
        if (localNewAuthDevUgFragment.Qk())
        {
          QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onResponse getActivity is null or activity is finish");
          return;
        }
        if (NewAuthDevUgFragment.a(localNewAuthDevUgFragment) == null)
        {
          a(-1, new Exception("GatewayCallback onResponse, msgId is null"));
          return;
        }
        try
        {
          GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
          localReqBody.msg_req_self_phone.msg_req_check_phone.int32_channel_id.set(NewAuthDevUgFragment.a(localNewAuthDevUgFragment));
          localReqBody.msg_req_self_phone.msg_req_check_phone.str_msg_id.set(NewAuthDevUgFragment.a(localNewAuthDevUgFragment));
          localReqBody.msg_req_self_phone.msg_req_check_phone.str_token.set(paramString2);
          localReqBody.msg_req_self_phone.msg_req_check_phone.str_upurl.set(paramString1);
          paramString1 = lfn.getLocalIp();
          if ((!aqiw.isWifiConnected(localNewAuthDevUgFragment.getActivity())) && (paramString1 != null)) {
            localReqBody.msg_req_self_phone.msg_req_check_phone.str_cell_ip.set(paramString1);
          }
          localReqBody.msg_req_self_phone.msg_req_check_phone.setHasFlag(true);
          localReqBody.msg_req_self_phone.setHasFlag(true);
          localReqBody.setHasFlag(true);
          paramString1 = localReqBody.toByteArray();
          int i = afsf.a().a(NewAuthDevUgFragment.a(localNewAuthDevUgFragment).getAppInterface(), NewAuthDevUgFragment.a(localNewAuthDevUgFragment), paramString1);
          if (i != 0)
          {
            QLog.e("NewAuthDevUgFragment", 1, new Object[] { "EquipmentLockImpl.getInstance().submitSms error, ret : ", Integer.valueOf(i) });
            return;
          }
        }
        catch (Exception paramString1)
        {
          QLog.e("NewAuthDevUgFragment", 1, new Object[] { "GatewayCallback onResponse submitSms error : ", paramString1.getMessage() });
          a(-1, new Exception(paramString1.getMessage() + "  content : " + paramString2));
        }
      }
    }
    
    public void vP(String paramString)
    {
      NewAuthDevUgFragment localNewAuthDevUgFragment = (NewAuthDevUgFragment)this.aE.get();
      if (localNewAuthDevUgFragment == null)
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayVerifyWrapper onRedirect mFragmentRef.get() is null");
        return;
      }
      if (localNewAuthDevUgFragment.Qk())
      {
        QLog.e("NewAuthDevUgFragment", 1, "GatewayCallback onRedirect getActivity is null or activity is finish");
        return;
      }
      NewAuthDevUgFragment.b(localNewAuthDevUgFragment);
      if (NewAuthDevUgFragment.c(localNewAuthDevUgFragment) > 5)
      {
        a(-1, new Exception("onRedirect timeout"));
        return;
      }
      NewAuthDevUgFragment.a(localNewAuthDevUgFragment).a(paramString, this);
    }
  }
  
  static class b
    extends VerifyDevLockManager.VerifyDevLockObserver
  {
    private WeakReference<VerifyDevLockManager.VerifyDevLockObserver> dM;
    
    public b(VerifyDevLockManager.VerifyDevLockObserver paramVerifyDevLockObserver)
    {
      this.dM = new WeakReference(paramVerifyDevLockObserver);
    }
    
    public void onReceive(VerifyDevLockManager.NotifyType paramNotifyType, int paramInt, Object paramObject)
    {
      if (this.dM.get() == null)
      {
        QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onReceive mObserver.get() is null");
        return;
      }
      ((VerifyDevLockManager.VerifyDevLockObserver)this.dM.get()).onReceive(paramNotifyType, paramInt, paramObject);
    }
    
    public void onVerifyClose(int paramInt1, String paramString, int paramInt2, ErrMsg paramErrMsg)
    {
      if (this.dM.get() == null)
      {
        QLog.e("NewAuthDevUgFragment", 1, "VerifyObserverWrapper onVerifyClose mObserver.get() is null");
        return;
      }
      ((VerifyDevLockManager.VerifyDevLockObserver)this.dM.get()).onVerifyClose(paramInt1, paramString, paramInt2, paramErrMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NewAuthDevUgFragment
 * JD-Core Version:    0.7.0.1
 */