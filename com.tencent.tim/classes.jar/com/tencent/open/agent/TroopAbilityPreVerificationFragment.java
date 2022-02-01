package com.tencent.open.agent;

import acfp;
import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import aqha;
import aqju;
import arhz;
import arsy;
import arsz;
import arta;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jnm;
import jqk;
import tencent.im.oidb.oidb_0xb60.ClientInfo;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeReq;
import tencent.im.oidb.oidb_0xb60.GetPrivilegeRsp;
import tencent.im.oidb.oidb_0xb60.ReqBody;
import tencent.im.oidb.oidb_0xb60.RspBody;

public abstract class TroopAbilityPreVerificationFragment
  extends PublicBaseFragment
{
  private static oidb_0xb60.RspBody a;
  private static long aww;
  private static long awx;
  protected String aKm = "";
  protected DialogInterface.OnClickListener ad;
  private jqk b = new arsz(this);
  public int bDo = 1;
  protected String cBA = "";
  protected String cCd = "";
  public FragmentActivity mActivity;
  protected QQAppInterface mApp;
  public String mAppId = "";
  public String mAppName = "";
  protected Handler mHandler = new Handler();
  public String mOpenId = "";
  public Bundle mParams;
  public String mPkgName = "";
  protected arhz mProgress;
  public aqju x;
  
  private boolean aGY()
  {
    this.mParams = this.mActivity.getIntent().getBundleExtra("key_params");
    if (this.mParams == null)
    {
      QLog.i("TroopAbility.PreVerification", 1, "doOnCreate params is null.");
      return false;
    }
    this.mAppId = this.mParams.getString("appid");
    this.mOpenId = this.mParams.getString("openid");
    this.mAppName = this.mParams.getString("app_name");
    this.cBA = this.mParams.getString("organization_id");
    this.mPkgName = this.mParams.getString("pkg_name");
    this.cCd = this.mParams.getString("pkg_sig");
    this.aKm = this.mParams.getString("sdk_version");
    if ((TextUtils.isEmpty(this.mAppId)) || (TextUtils.isEmpty(this.mOpenId)))
    {
      QLog.d("TroopAbility.PreVerification", 1, "appId: " + this.mAppId + ", openId: " + this.mOpenId + ", return.");
      return false;
    }
    try
    {
      Integer.valueOf(this.mAppId);
      Integer.valueOf(this.cBA);
      return true;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void bFE()
  {
    OpenID localOpenID = this.mApp.a().a(this.mAppId);
    this.mParams.putString("uin", this.mApp.getCurrentAccountUin());
    if ((localOpenID == null) || (TextUtils.isEmpty(localOpenID.openID)))
    {
      showProgress(acfp.m(2131715490));
      this.mApp.a().Eo(this.mAppId);
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, get openId from server.");
      return;
    }
    if (!this.mOpenId.equals(localOpenID.openID))
    {
      QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, !mOpenId.equals(openId.openID)");
      bFG();
      return;
    }
    elE();
    QLog.d("TroopAbility.PreVerification", 1, "-->checkAccountDiff, mOpenId.equals(openId.openID)");
  }
  
  private void bFG()
  {
    if ((this.x != null) && (!this.x.isShowing()))
    {
      this.x.show();
      return;
    }
    if (this.x == null)
    {
      this.x = aqha.a(getActivity(), 230);
      this.ad = new arsy(this);
    }
    this.x.setMessage(2131697425);
    this.x.setTitle(2131693317);
    this.x.setNegativeButton(acfp.m(2131715495), this.ad);
    this.x.setPositiveButton(acfp.m(2131715491), this.ad);
    this.x.show();
  }
  
  private void elF()
  {
    if ((NetConnInfoCenter.getServerTime() - aww < awx) && (a != null))
    {
      QLog.d("TroopAbility.PreVerification", 1, "use case receive api_groups:" + a.get_privilege_rsp.api_groups.get() + ", api_names:" + a.get_privilege_rsp.api_names.get());
      localObject1 = new HashSet();
      localObject2 = a.get_privilege_rsp.api_groups.get().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((Set)localObject1).add((Integer)((Iterator)localObject2).next());
      }
      boolean bool = a((Set)localObject1);
      QLog.i("TroopAbility.PreVerification", 1, "use cache check permission result:" + bool);
      Uf(bool);
      return;
    }
    QLog.i("TroopAbility.PreVerification", 1, "getThirdAppPermissions.");
    Object localObject1 = new oidb_0xb60.ReqBody();
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.setHasFlag(true);
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.appid.set(Integer.valueOf(this.mAppId).intValue());
    ((oidb_0xb60.ReqBody)localObject1).get_privilege_req.app_type.set(this.bDo);
    Object localObject2 = new oidb_0xb60.ClientInfo();
    ((oidb_0xb60.ClientInfo)localObject2).android_package_name.set(this.mPkgName);
    ((oidb_0xb60.ClientInfo)localObject2).android_signature.set(this.cCd);
    ((oidb_0xb60.ClientInfo)localObject2).sdk_version.set(this.aKm);
    ((oidb_0xb60.ClientInfo)localObject2).platform.set(1);
    QLog.i("TroopAbility.PreVerification", 1, "send type=" + this.bDo + ", appid=" + this.mAppId);
    jnm.a(this.mApp, new arta(this), ((oidb_0xb60.ReqBody)localObject1).toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
  }
  
  public abstract void Uf(boolean paramBoolean);
  
  public void WQ(String paramString)
  {
    QQToast.a(getActivity(), 1, paramString, 0).show(getActivity().getTitleBarHeight());
  }
  
  public void WY(String paramString)
  {
    hideProgress();
    WQ(paramString);
    this.mHandler.postDelayed(new TroopAbilityPreVerificationFragment.3(this), 2000L);
  }
  
  public abstract boolean a(Set<Integer> paramSet);
  
  protected void bpM()
  {
    this.mApp.addObserver(this.b);
  }
  
  protected void bpN()
  {
    this.mApp.removeObserver(this.b);
  }
  
  public void elE()
  {
    showProgress(acfp.m(2131715493));
    elF();
  }
  
  public void hideProgress()
  {
    if ((this.mProgress != null) && (this.mProgress.isShowing()) && (getActivity().isResume())) {
      this.mProgress.dismiss();
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mApp = getActivity().app;
    this.mActivity = getActivity();
    bpM();
    if (!aGY())
    {
      WQ(acfp.m(2131715485));
      return;
    }
    bFE();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    bpN();
  }
  
  public void onFinish()
  {
    super.onFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    localFragmentActivity.overridePendingTransition(0, 0);
  }
  
  protected void showProgress(String paramString)
  {
    if (this.mProgress == null) {
      this.mProgress = new arhz(getActivity(), getActivity().getTitleBarHeight());
    }
    hideProgress();
    this.mProgress.setMessage(paramString);
    if (getActivity().isResume()) {
      this.mProgress.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityPreVerificationFragment
 * JD-Core Version:    0.7.0.1
 */