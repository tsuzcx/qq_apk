package com.tencent.open.agent;

import aelj;
import aels;
import aels.a;
import aelt;
import ahlw;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import anpc;
import aqhs;
import arhz;
import aroe;
import aroj;
import arok;
import aron;
import arts;
import artw;
import artx;
import arxo;
import aryn;
import asav;
import asaw;
import asbf;
import asbh;
import asbp;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;

public class AgentActivity
  extends BaseActivity
{
  public OpenSDKAppInterface a;
  private Intent ar;
  private long awd;
  private BroadcastReceiver bJ;
  private BroadcastReceiver bK = new aron(this);
  protected boolean dcv;
  protected boolean dcw;
  private boolean dcx;
  protected String mAction;
  protected Handler mHandler = new Handler();
  protected arhz mProgress;
  
  private void Y(int paramInt, String paramString1, String paramString2)
  {
    if (isFinishing()) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", paramString1);
    localIntent.putExtra("key_error_detail", paramString2);
    localIntent.putExtra("key_response", "");
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, int paramInt)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "--> doRouterForNewAuth time = ", Long.valueOf(System.currentTimeMillis()) });
    String str3 = getCurrentUin();
    if (TextUtils.isEmpty(str3))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "--> doRouterForNewAuth currentUin is null,goto old auth");
      b(paramString1, paramBundle, paramString2, false);
      return;
    }
    long l = System.currentTimeMillis();
    new asav().uin = str3;
    ahlw.Kj("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
    String str2 = paramBundle.getString("key_proxy_appid");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = paramString2;
    }
    this.a.a().a(this.a, str3, str1, paramInt, new arok(this, paramString1, paramBundle, paramString2, l, paramInt));
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "registerExpiredReceiver");
    if (this.bJ != null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "null != mExpiredReceiver");
      return;
    }
    this.bJ = new aroj(this, paramString1, paramBundle, paramString2, paramBoolean);
    registerReceiver(this.bJ, new IntentFilter("mqq.intent.action.ACCOUNT_EXPIRED"));
  }
  
  private void a(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = System.currentTimeMillis();
    Intent localIntent;
    Object localObject1;
    boolean bool;
    if (paramBoolean1)
    {
      localIntent = new Intent();
      localIntent.putExtra("intent_router", 1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("key_action", paramString1);
      localObject1 = getPkgName();
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!aelj.ahf())) {
        break label602;
      }
      Object localObject2 = paramBundle.getString("ppsts");
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "ppsts=", localObject2 });
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = artx.i(paramBundle);
        localHashMap = new HashMap();
        localHashMap.put("appid", paramString2);
        localHashMap.put("ppsts", localObject2);
        localHashMap.put("sha", localObject1);
        localObject1 = artx.ch((String)localObject2, (String)localObject1);
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "can not get calling package name, use ppsts callFromPackageName=", localObject1 });
        localObject2 = anpc.a(BaseApplicationImpl.getApplication());
        localObject3 = getCurrentUin();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label596;
        }
        bool = true;
        label200:
        ((anpc)localObject2).collectPerformance((String)localObject3, "use_third_pkg_name", bool, 0L, 0L, localHashMap, "", false);
      }
      label218:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label645;
      }
      Object localObject3 = asbp.a(this, (String)localObject1);
      HashMap localHashMap = localObject3[0];
      localObject2 = localObject3[1];
      localObject3 = localObject3[2];
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate appid: ", paramString2, ", package: ", localObject1, ", getAuthorizeSign.sign: ", localHashMap });
      paramBundle.putString("packagename", (String)localObject1);
      paramBundle.putString("packagesign", localHashMap);
      paramBundle.putString("sign", (String)localObject2);
      paramBundle.putString("time", (String)localObject3);
      artw.a(0, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        localIntent.putExtra("key_params", paramBundle);
        if ((!paramBoolean2) && ((getAppInterface() == null) || (getAppInterface().isLogin()))) {
          break label720;
        }
        QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login isForce = " + paramBoolean2);
        if ((!"action_login".equals(paramString1)) && (!"action_quick_login".equals(paramString1)) && (!"action_ptlogin_login".equals(paramString1))) {
          break label720;
        }
        this.ar = localIntent;
        this.ar.putExtra("authority_start_qq_login", true);
        QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
        paramBundle = new Intent(this, LoginActivity.class);
        paramBundle.putExtra("authority_start_qq_login", true);
        if (!"action_ptlogin_login".equals(paramString1))
        {
          paramBundle.setFlags(268435456);
          paramBundle.addFlags(32768);
        }
        paramString1 = new IntentFilter("action_login_sucess");
        registerReceiver(this.bK, paramString1);
        startActivity(paramBundle);
      }
      return;
      if (!TextUtils.isEmpty(paramBundle.getString("key_proxy_appid")))
      {
        QLog.d("SDK_LOGIN.AgentActivity", 1, "routerToAuthActivity to old login, not support");
        Y(-10000, "error", "not support proxy login");
        return;
      }
      localIntent = new Intent(this, AuthorityActivity.class);
      break;
      label596:
      bool = false;
      break label200;
      label602:
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "isUseThirdTransformPkgName=", Boolean.valueOf(aelj.ahf()), ", ppsts=", paramBundle.getString("ppsts") });
      break label218;
      label645:
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->onCreate can not get calling package name!");
      localObject1 = new HashMap();
      ((HashMap)localObject1).put("appid", paramString2);
      anpc.a(BaseApplicationImpl.getApplication()).collectPerformance(getCurrentUin(), "login_pkg_name_empty", true, 0L, 0L, (HashMap)localObject1, "", false);
      artw.a(1, "LOGIN_CHECK_AGENT", null, paramString2, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity callFromPackageName is null");
    }
    label720:
    if (paramBoolean1) {}
    for (;;)
    {
      try
      {
        PublicFragmentActivity.b.startForResult(this, localIntent, PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " launch OpenAuthFragment use time = ", Long.valueOf(System.currentTimeMillis() - l) });
        QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " start Auth total time = ", Long.valueOf(System.currentTimeMillis() - this.awd) });
        return;
      }
      catch (ActivityNotFoundException paramString1)
      {
        QLog.e("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", "start Auth ActivityNotFoundException ", paramString1 });
        Zj(-6);
        super.finish();
        return;
      }
      super.startActivityForResult(localIntent, 0);
    }
  }
  
  private boolean aGX()
  {
    long l1 = System.currentTimeMillis();
    aels localaels = aelt.b(467);
    long l2 = System.currentTimeMillis();
    if (localaels == null) {}
    for (String str = "is null";; str = "enable: " + localaels.a().enable)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "start_auth_use_time", " load config use time: ", Long.valueOf(l2 - l1), " -->OpenSdkSwitchConfBean ", str });
      if ((localaels == null) || (!localaels.a().enable)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private void b(String paramString1, Bundle paramBundle, String paramString2, boolean paramBoolean)
  {
    a(paramString1, paramBundle, paramString2, paramBoolean, false);
  }
  
  private void ekG()
  {
    if (this.bJ != null)
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "unRegisterLoginReceiver");
      unregisterReceiver(this.bJ);
      this.bJ = null;
    }
  }
  
  private String getCurrentUin()
  {
    asaw.a().emz();
    Object localObject3 = aryn.eh();
    Object localObject2 = null;
    if (this.a.isLogin()) {
      localObject2 = this.a.getAccount();
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = (String)((ArrayList)localObject3).get(0);
      }
    }
    localObject3 = artw.a(getIntent(), "login_success_uin");
    localObject2 = localObject1;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject1;
      if (!((String)localObject3).equals(localObject1))
      {
        QLog.d("SDK_LOGIN.AgentActivity", 1, "--> doRouterForNewAuth set currentUin loginUin");
        localObject2 = localObject3;
      }
    }
    return localObject2;
  }
  
  private String getPkgName()
  {
    Object localObject = "";
    int i = 0;
    for (;;)
    {
      String str;
      if (i < 3)
      {
        str = super.getCallingPackage();
        localObject = str;
        if (TextUtils.isEmpty(str))
        {
          QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getCallingPackage returns null!");
          localObject = super.getCallingActivity();
          if (localObject == null) {
            break label76;
          }
          str = ((ComponentName)localObject).getPackageName();
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getPackageName from component returns null!");
          }
        }
      }
      for (localObject = str; !TextUtils.isEmpty((CharSequence)localObject); localObject = str)
      {
        return localObject;
        label76:
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getCallingActivity returns null!");
      }
      i += 1;
    }
  }
  
  public static String q(Context paramContext, String paramString1, String paramString2)
  {
    String str = "";
    Object localObject = str;
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString1, 64).signatures;
      localObject = str;
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localObject = str;
      localMessageDigest.update(paramContext[0].toByteArray());
      localObject = str;
      paramContext = aqhs.bytes2HexStr(localMessageDigest.digest());
      if (paramContext == null) {
        return "";
      }
      localObject = str;
      paramContext = paramContext.toLowerCase();
      localObject = str;
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->getAppSignatureMD5, sign: " + paramContext);
      localObject = str;
      localMessageDigest.reset();
      localObject = str;
      localMessageDigest.update((paramString1 + "_" + paramContext + "_" + paramString2 + "").getBytes());
      localObject = str;
      paramContext = aqhs.bytes2HexStr(localMessageDigest.digest());
      localObject = paramContext;
      localMessageDigest.reset();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "Exception", paramContext);
    }
    return localObject;
  }
  
  private void showLoading()
  {
    if (isFinishing()) {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->showLoading activity is finishing");
    }
    for (;;)
    {
      return;
      try
      {
        if (this.mProgress != null)
        {
          if (this.mProgress.isShowing()) {
            continue;
          }
          this.mProgress.show();
        }
      }
      catch (Exception localException)
      {
        QLog.i("SDK_LOGIN.AgentActivity", 1, "-->showLoading Exception:", localException);
        return;
      }
    }
    this.mProgress = new arhz(this, 0, 2131561629, 17);
    this.mProgress.setHeightParams(-1);
    this.mProgress.show();
  }
  
  protected void Zj(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_error_code", paramInt);
    localIntent.putExtra("key_error_msg", arxo.MSG_PARAM_ERROR);
    localIntent.putExtra("key_error_detail", "");
    localIntent.putExtra("key_response", "");
    super.setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    aroe.registerModule();
    ahlw.init();
    ahlw.Kj("KEY_LOGIN_STAGE_1_TOTAL");
    ahlw.Kj("KEY_AUTHORITY_TOTAL");
    showLoading();
    this.awd = System.currentTimeMillis();
    this.a = ((OpenSDKAppInterface)super.getAppRuntime());
    if ((super.getIntent() == null) || (paramBundle != null))
    {
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, intent: ", super.getIntent(), " | savedInstanceState: ", paramBundle });
      artw.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity getIntent is null");
    }
    Object localObject;
    for (;;)
    {
      return true;
      String str1 = artw.a(super.getIntent(), "key_action");
      this.mAction = str1;
      QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onCreate, action: ", str1 });
      try
      {
        localBundle = super.getIntent().getBundleExtra("key_params");
        if (localBundle == null)
        {
          Zj(-5);
          if (!"action_login".equals(str1)) {
            continue;
          }
          artw.a(1, "LOGIN_CHECK_AGENT", null, null, null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "AgentActivity bundle is null");
          return true;
        }
      }
      catch (Exception paramBundle)
      {
        Bundle localBundle;
        for (;;)
        {
          QLog.e("SDK_LOGIN.AgentActivity", 1, "-->onCreate Exception", paramBundle);
          localBundle = null;
        }
        String str2 = localBundle.getString("client_id");
        if ("action_login".equals(str1))
        {
          QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->loginAction, action: ", str1, ", appid=", str2, ", sdkv=", localBundle.getString("sdkv") });
          if (aGX()) {
            ThreadManager.executeOnNetWorkThread(new AgentActivity.1(this, str1, localBundle, str2));
          }
          for (;;)
          {
            arts.a().a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true, true);
            return true;
            b(str1, localBundle, str2, false);
          }
        }
        if ("action_pay".equals(str1))
        {
          localObject = new Intent(this, AuthorityActivity.class);
          ((Intent)localObject).putExtra("key_action", str1);
        }
        while (localObject != null)
        {
          ((Intent)localObject).putExtra("key_params", localBundle);
          if ((getAppInterface() == null) || (getAppInterface().isLogin())) {
            break label875;
          }
          QLog.d("SDK_LOGIN.AgentActivity", 1, " qq is not login");
          if ((!"action_login".equals(str1)) && (!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label875;
          }
          this.ar = ((Intent)localObject);
          this.ar.putExtra("authority_start_qq_login", true);
          QLog.d("SDK_LOGIN.AgentActivity", 1, "qq is not login, first login it");
          paramBundle = new Intent(this, LoginActivity.class);
          paramBundle.putExtra("authority_start_qq_login", true);
          if (!"action_ptlogin_login".equals(str1))
          {
            paramBundle.setFlags(268435456);
            paramBundle.addFlags(32768);
          }
          localObject = new IntentFilter("action_login_sucess");
          registerReceiver(this.bK, (IntentFilter)localObject);
          startActivity(paramBundle);
          artw.a(getAppInterface().getCurrentAccountUin(), "", str2, "1", "8", "0", true);
          return true;
          if ((!"action_quick_login".equals(str1)) && (!"action_ptlogin_login".equals(str1))) {
            break label683;
          }
          this.dcx = true;
          paramBundle = super.getCallingPackage();
          if (QLog.isColorLevel()) {
            QLog.d("SDK_LOGIN.AgentActivity", 2, "-->packagename: " + paramBundle);
          }
          localObject = new Intent(this, QuickLoginAuthorityActivity.class);
          ((Intent)localObject).putExtra("key_action", str1);
          localBundle.putString("packagename", paramBundle);
        }
        label683:
        if (("action_invite".equals(str1)) || ("action_gift".equals(str1)) || ("action_ask".equals(str1)) || ("action_reactive".equals(str1))) {
          paramBundle = new Intent(this, SocialFriendChooser.class);
        }
        for (;;)
        {
          localObject = paramBundle;
          if (paramBundle == null) {
            break;
          }
          paramBundle.putExtra("key_action", str1);
          localObject = localBundle.getString("hopenid");
          localBundle.putString("encrytoken", asbf.getGlobalPreference(this, "openid_encrytoken").getString((String)localObject, ""));
          localObject = paramBundle;
          break;
          if ("action_story".equals(str1))
          {
            paramBundle = new Intent(this, SendStoryActivity.class);
          }
          else if ("action_brag".equals(str1))
          {
            paramBundle = new Intent(this, BragActivity.class);
          }
          else
          {
            if (!"action_challenge".equals(str1)) {
              break label867;
            }
            paramBundle = new Intent(this, ChallengeActivity.class);
          }
        }
        label867:
        Zj(-5);
        return true;
      }
    }
    try
    {
      label875:
      super.startActivityForResult((Intent)localObject, 0);
      return true;
    }
    catch (ActivityNotFoundException paramBundle)
    {
      QLog.e("SDK_LOGIN.AgentActivity", 1, "ActivityNotFoundException", paramBundle);
      Zj(-6);
      super.finish();
    }
    return true;
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (getAppInterface() != null) {
      QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onResume, app.isLogin(): " + getAppInterface().isLogin());
    }
    if (this.dcw)
    {
      setResult(0);
      finish();
      this.dcv = true;
      return;
    }
    this.dcw = true;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return SharedPreferencesProxyManager.getInstance().getProxy(paramString, paramInt);
  }
  
  protected void jf()
  {
    if ((!super.isFinishing()) && (this.mProgress != null) && (this.mProgress.isShowing())) {}
    try
    {
      this.mProgress.dismiss();
      return;
    }
    catch (Exception localException)
    {
      QLog.i("SDK_LOGIN.AgentActivity", 1, "-->dismissDialogProgress Exception:", localException);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onActivityResult, action: " + this.mAction + " | requestCode: " + paramInt1 + " | resultCode: " + paramInt2 + " | data: " + paramIntent);
    super.setResult(paramInt2, paramIntent);
    super.finish();
    this.dcv = true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    jf();
    QLog.d("SDK_LOGIN.AgentActivity", 1, "-->onDestroy, action: " + this.mAction);
    aroe.unRegisterModule();
    ekG();
    if (this.dcv)
    {
      boolean bool = GesturePWDUtils.isAppOnForeground(this);
      if (!bool) {
        GesturePWDUtils.setAppForground(this, bool);
      }
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity
 * JD-Core Version:    0.7.0.1
 */