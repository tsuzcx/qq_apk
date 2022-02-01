package com.tencent.qqmail.account.helper;

import android.app.Activity;
import android.content.Intent;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.callback.WtLoginCallback;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.utilities.log.QMLog;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.request.WtloginHelper;
import oicq.wlogin_sdk.request.WtloginHelper.QuickLoginParam;
import oicq.wlogin_sdk.request.WtloginListener;
import oicq.wlogin_sdk.sharemem.WloginSimpleInfo;
import oicq.wlogin_sdk.tools.util;

public class QMWtLoginManager
{
  private static final int APPID = 756044602;
  public static int GET_TICKET_ERR_NEW_USER = 1;
  public static int GET_TICKET_ERR_PSW_WRONG = 4;
  public static int GET_TICKET_ERR_SVR_SETTING = 0;
  public static int GET_TICKET_ERR_UPGRADE_USER = 2;
  private static final int SIG_MAP = 4160;
  private static final int SMSAPPID = 10;
  private static final int SUBAPPID = 2;
  private static final String TAG = "QMWtLoginManager";
  private static volatile QMWtLoginManager instance;
  private static WtloginHelper.QuickLoginParam quickLoginParam;
  private byte[] lock = new byte[0];
  private final WtloginHelper wtLoginhelper;
  
  static
  {
    GET_TICKET_ERR_SVR_SETTING = 3;
  }
  
  private QMWtLoginManager()
  {
    if (QMApplicationContext.sharedInstance() == null) {
      throw new IllegalStateException("application null");
    }
    this.wtLoginhelper = new WtloginHelper(QMApplicationContext.sharedInstance());
  }
  
  private static WtloginHelper.QuickLoginParam buildQuickLoginParam(boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong)
  {
    if ((paramBoolean2) && ((paramString == null) || (paramString.length() == 0))) {
      throw new IllegalArgumentException("account null");
    }
    if ((!paramBoolean1) && (paramString != null)) {
      throw new IllegalArgumentException("QQ account is not null");
    }
    quickLoginParam = new WtloginHelper.QuickLoginParam();
    quickLoginParam.forceWebLogin = paramBoolean1;
    quickLoginParam.userAccount = paramString;
    quickLoginParam.isUserAccountLocked = paramBoolean2;
    quickLoginParam.titleBackgroundColor = "#ffffff";
    quickLoginParam.titleTextColor = "#000000";
    quickLoginParam.userSigInfo.userSeq = paramLong;
    QMLog.log(4, "QMWtLoginManager", "buildQuickLoginParam seq:" + paramLong);
    return quickLoginParam;
  }
  
  private static WtloginHelper.QuickLoginParam buildQuickLoginParam(boolean paramBoolean1, String paramString, boolean paramBoolean2, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramString = buildQuickLoginParam(paramBoolean1, paramString, paramBoolean2, paramLong);
    paramString.startAnimEnter = paramInt1;
    paramString.startAnimExit = paramInt2;
    paramString.finishAnimExit = paramInt4;
    paramString.finishAnimEnter = paramInt3;
    return paramString;
  }
  
  public static QMWtLoginManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QMWtLoginManager();
      }
      return instance;
    }
    finally {}
  }
  
  public static void getNewWtLoginTicket(String paramString, WtLoginCallback paramWtLoginCallback)
  {
    QMLog.log(4, "QMWtLoginManager", "getNewTicketAndRetryAutoLogin email:" + paramString);
    String str = QMAppInterface.getRuntime().getAccount();
    if (paramString.equals(str)) {
      TimMailLoginManager.requestA2AndSkey(str, null, new QMWtLoginManager.2(paramWtLoginCallback));
    }
    do
    {
      return;
      QMLog.log(6, "QMWtLoginManager", String.format("getNewWtLoginTicket: uin[%s], account[%s] diff", new Object[] { paramString, str }));
    } while (paramWtLoginCallback == null);
    paramWtLoginCallback.onError(-1000, "", paramString);
  }
  
  private static WtloginHelper.QuickLoginParam getQuickLoginParam()
  {
    if (quickLoginParam == null) {
      quickLoginParam = new WtloginHelper.QuickLoginParam();
    }
    quickLoginParam.appid = 756044602L;
    quickLoginParam.subAppid = 2L;
    quickLoginParam.sigMap = 4160;
    return quickLoginParam;
  }
  
  public static void getStWithPasswdMd5(String paramString1, String paramString2, WtloginListener paramWtloginListener)
  {
    QMLog.log(4, "QMWtLoginManager", "getStWithPasswdMd5 uin:" + paramString1);
    WUserSigInfo localWUserSigInfo = new WUserSigInfo();
    WtloginHelper localWtloginHelper = new WtloginHelper(QMApplicationContext.sharedInstance());
    localWtloginHelper.SetListener(paramWtloginListener);
    localWtloginHelper.GetStWithPasswdMd5(paramString1, 756044602L, 2L, 4160, paramString2, localWUserSigInfo);
  }
  
  private void loginByWebview(Activity paramActivity, long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = buildQuickLoginParam(true, null, false, paramLong, paramInt1, paramInt2, paramInt3, paramInt4);
    this.wtLoginhelper.quickLogin(paramActivity, 756044602L, 2L, AppConfig.getCodeVersionName(), localQuickLoginParam);
  }
  
  public boolean canQuickLogin()
  {
    return false;
  }
  
  public void checkPictureAndGetSt(String paramString1, String paramString2)
  {
    this.wtLoginhelper.CheckPictureAndGetSt(paramString1, paramString2.getBytes(), new WUserSigInfo());
  }
  
  public void checkSMSAndGetSt(String paramString1, String paramString2)
  {
    this.wtLoginhelper.CheckSMSAndGetSt(paramString1, paramString2.getBytes(), new WUserSigInfo());
  }
  
  public boolean clearUserLoginData(String paramString)
  {
    return this.wtLoginhelper.ClearUserLoginData(paramString, 756044602L).booleanValue();
  }
  
  public String debugTicketSig(String paramString)
  {
    return debugTicketSig(this.wtLoginhelper.GetLocalSig(paramString, 756044602L));
  }
  
  public String debugTicketSig(WUserSigInfo paramWUserSigInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramWUserSigInfo == null) {
      localStringBuilder.append("sig null");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      byte[] arrayOfByte = WtloginHelper.GetTicketSig(paramWUserSigInfo, 64);
      if (arrayOfByte != null) {
        localStringBuilder.append(", A2[").append(util.buf_to_string(arrayOfByte)).append("]");
      }
      paramWUserSigInfo = WtloginHelper.GetTicketSig(paramWUserSigInfo, 4096);
      if (paramWUserSigInfo != null) {
        localStringBuilder.append(", SKey[").append(util.buf_to_string(paramWUserSigInfo)).append("]");
      }
    }
  }
  
  public String getA2(String paramString)
  {
    return TimMailLoginManager.getA2(paramString);
  }
  
  public WloginSimpleInfo getBasicUserInfo(String paramString)
  {
    WloginSimpleInfo localWloginSimpleInfo = new WloginSimpleInfo();
    if (this.wtLoginhelper.GetBasicUserInfo(paramString, localWloginSimpleInfo).booleanValue()) {
      return localWloginSimpleInfo;
    }
    return null;
  }
  
  public DevlockInfo getDevLockInfo(String paramString)
  {
    return this.wtLoginhelper.GetDevLockInfo(paramString);
  }
  
  public String getSkey(String paramString)
  {
    return TimMailLoginManager.getSkey(paramString);
  }
  
  public String getUserInputFromQuickLoginResultData(Intent paramIntent)
  {
    return this.wtLoginhelper.getUserInputFromQuickLoginResultData(paramIntent);
  }
  
  public void loginByMobileQQ(Activity paramActivity, long paramLong)
  {
    WtloginHelper.QuickLoginParam localQuickLoginParam = buildQuickLoginParam(false, null, false, paramLong);
    this.wtLoginhelper.quickLogin(paramActivity, 756044602L, 2L, AppConfig.getCodeVersionName(), localQuickLoginParam);
  }
  
  public void loginByWebviewWithAccount(Activity paramActivity, String paramString, long paramLong)
  {
    paramString = buildQuickLoginParam(true, paramString, false, paramLong, 2130772401, 2130772423, 2130772423, 2130772402);
    this.wtLoginhelper.quickLogin(paramActivity, 756044602L, 2L, AppConfig.getCodeVersionName(), paramString);
  }
  
  public void loginByWebviewWithLockedAccount(Activity paramActivity, String paramString, long paramLong)
  {
    paramString = buildQuickLoginParam(true, paramString, true, paramLong, 2130772401, 2130772423, 2130772423, 2130772402);
    this.wtLoginhelper.quickLogin(paramActivity, 756044602L, 2L, AppConfig.getCodeVersionName(), paramString);
  }
  
  public void loginByWebviewWithScaleEnter(Activity paramActivity, long paramLong)
  {
    loginByWebview(paramActivity, paramLong, 2130772401, 2130772423, 2130772423, 2130772402);
  }
  
  public void loginByWebviewWithSlideEnter(Activity paramActivity, long paramLong)
  {
    loginByWebview(paramActivity, paramLong, 2130772422, 2130772419, 2130772421, 2130772420);
  }
  
  public int onQuickLoginActivityResultData(Intent paramIntent)
  {
    return this.wtLoginhelper.onQuickLoginActivityResultData(getQuickLoginParam(), paramIntent);
  }
  
  public void refreshPictureData(String paramString)
  {
    this.wtLoginhelper.RefreshPictureData(paramString, new WUserSigInfo());
  }
  
  public void setListener(WtloginListener paramWtloginListener)
  {
    this.wtLoginhelper.SetListener(paramWtloginListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.QMWtLoginManager
 * JD-Core Version:    0.7.0.1
 */