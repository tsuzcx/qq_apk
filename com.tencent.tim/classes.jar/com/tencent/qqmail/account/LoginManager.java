package com.tencent.qqmail.account;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.SparseArray;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsIntent.Builder;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.account.activity.LoginGmailResultActivity;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.MailAccount;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.callback.RefreshTokenCallback;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.QMSyncErrorManager;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkConfig;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkRequest.QMHttpMethod;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMProtocolError;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import moai.oss.KvHelper;
import net.openid.appauth.AppAuthConfiguration.Builder;
import net.openid.appauth.AuthorizationRequest.Builder;
import net.openid.appauth.AuthorizationResponse;
import net.openid.appauth.AuthorizationService;
import net.openid.appauth.AuthorizationServiceConfiguration;
import net.openid.appauth.TokenRequest;
import org.apache.http.cookie.Cookie;

public class LoginManager
{
  private static final String TAG = "LoginManager";
  private AuthorizationService authService;
  private CopyOnWriteArrayList<AccountLoginWatcher> loginWatchers = new CopyOnWriteArrayList();
  private final SparseArray<Set<RefreshTokenCallback>> mRefreshTokenCallbacks = new SparseArray();
  
  private QQMailAccount loginWithUTC(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, String paramString5)
  {
    QQMailAccount localQQMailAccount = new QQMailAccount();
    Object localObject2 = new StringBuilder();
    if (QMSettingManager.sharedInstance().isEnableHttpsDomain()) {}
    for (Object localObject1 = QMNetworkConfig.getCgiRequestHostHttps(localQQMailAccount.getId());; localObject1 = QMNetworkConfig.getCgiRequestHost(localQQMailAccount.getId()))
    {
      localObject1 = new QMNetworkRequest((String)localObject1 + "/cgi-bin/loginpage?utctime=true&f=xhtml", QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
      localObject2 = new QMCallback();
      ((QMCallback)localObject2).setOnError(new LoginManager.12(this, localQQMailAccount, paramLong, paramString1, paramString2, paramString3, paramString4, paramBoolean1, paramBoolean2, paramString5));
      ((QMCallback)localObject2).setOnSuccess(new LoginManager.13(this, localQQMailAccount, paramLong, paramString1, paramString2, paramString3, paramString4, paramBoolean1, paramBoolean2, paramString5));
      ((QMNetworkRequest)localObject1).setRequestCallback((QMCallback)localObject2);
      QMHttpUtil.asyncSend((QMNetworkRequest)localObject1);
      return localQQMailAccount;
    }
  }
  
  private void refreshGMailAccessToken(String paramString, QMCallback paramQMCallback)
  {
    paramString = "client_id=146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg.apps.googleusercontent.com&client_secret=&refresh_token=" + paramString + "&grant_type=refresh_token";
    QMNetworkRequest localQMNetworkRequest = new QMNetworkRequest("https://accounts.google.com/o/oauth2/token", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    localQMNetworkRequest.setRequestParams(paramString);
    localQMNetworkRequest.setProxy(QMProxyUtil.getGmailHttpProxy());
    localQMNetworkRequest.setRequestCallback(paramQMCallback);
    QMHttpUtil.asyncSend(localQMNetworkRequest);
  }
  
  public static LoginManager shareInstance()
  {
    return SingleTon._instance;
  }
  
  public void bindLoginListener(AccountLoginWatcher paramAccountLoginWatcher, boolean paramBoolean)
  {
    if (paramBoolean) {
      if (!this.loginWatchers.contains(paramAccountLoginWatcher)) {
        this.loginWatchers.add(paramAccountLoginWatcher);
      }
    }
    while (!this.loginWatchers.contains(paramAccountLoginWatcher)) {
      return;
    }
    this.loginWatchers.remove(paramAccountLoginWatcher);
  }
  
  public Boolean canAutoLogin()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    if (localAccountList != null)
    {
      int i = 0;
      while (i < localAccountList.size())
      {
        Account localAccount = localAccountList.get(i);
        if ((SharedPreferenceUtil.isWtlogin()) && (!localAccount.isBizMail())) {
          return Boolean.valueOf(true);
        }
        if (localAccount.getPwd() != null) {
          return Boolean.valueOf(true);
        }
        i += 1;
      }
    }
    return Boolean.valueOf(false);
  }
  
  public boolean canRefreshAccessTokenExpire(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    return (localAccount != null) && (System.currentTimeMillis() - localAccount.getLastTokenTime() > 60000L);
  }
  
  public void disposeService()
  {
    this.authService.dispose();
  }
  
  public void fetchAuthCode(Context paramContext, String paramString)
  {
    Object localObject = Uri.parse("https://accounts.google.com/o/oauth2/auth");
    Uri localUri1 = Uri.parse("https://accounts.google.com/o/oauth2/token");
    Uri localUri2 = Uri.parse("com.tencent.androidqqmail:/oauth2redirect");
    paramString = new AuthorizationRequest.Builder(new AuthorizationServiceConfiguration((Uri)localObject, localUri1, null), "146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg.apps.googleusercontent.com", "code", localUri2).setScope("email profile https://mail.google.com https://www.google.com/m8/feeds https://www.googleapis.com/auth/calendar").setLoginHint(paramString).build();
    paramContext = PendingIntent.getActivities(paramContext, paramString.hashCode(), new Intent[] { LoginGmailResultActivity.createIntent() }, 0);
    localObject = this.authService.createCustomTabsIntentBuilder().build();
    this.authService.performAuthorizationRequest(paramString, paramContext, (CustomTabsIntent)localObject);
  }
  
  public void fetchToken(AuthorizationResponse paramAuthorizationResponse)
  {
    TokenRequest localTokenRequest = paramAuthorizationResponse.createTokenExchangeRequest();
    paramAuthorizationResponse = new LoginManager.11(this, paramAuthorizationResponse);
    this.authService.performTokenRequest(localTokenRequest, paramAuthorizationResponse);
  }
  
  public void getGMailAccessToken(String paramString)
  {
    String str = "code=" + paramString + "&client_id=" + "146110540336-48ild167qte7b4rf3dlhq90jrj5ajujg.apps.googleusercontent.com" + "&redirect_uri=" + "urn:ietf:wg:oauth:2.0:oob" + "&grant_type=authorization_code";
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new LoginManager.2(this, paramString));
    localQMCallback.setOnError(new LoginManager.3(this, paramString));
    localQMCallback.setOnComplete(new LoginManager.4(this));
    paramString = new QMNetworkRequest("https://accounts.google.com/o/oauth2/token", QMNetworkRequest.QMHttpMethod.QMHttpMethod_POST);
    paramString.setRequestParams(str);
    paramString.setProxy(QMProxyUtil.getGmailHttpProxy());
    paramString.setRequestCallback(localQMCallback);
    QMHttpUtil.asyncSend(paramString);
  }
  
  public void getGMailUserInfo(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://www.googleapis.com/oauth2/v1/userinfo?");
    localStringBuilder.append("access_token=" + paramString);
    QMCallback localQMCallback = new QMCallback();
    localQMCallback.setOnSuccess(new LoginManager.8(this, paramString));
    localQMCallback.setOnError(new LoginManager.9(this, paramString));
    paramString = new QMNetworkRequest(localStringBuilder.toString(), QMNetworkRequest.QMHttpMethod.QMHttpMethod_GET);
    paramString.setProxy(QMProxyUtil.getGmailHttpProxy());
    paramString.setRequestCallback(localQMCallback);
    QMHttpUtil.asyncSend(paramString);
  }
  
  public boolean handleAuthSuccess(Account paramAccount, AccountType paramAccountType, boolean paramBoolean)
  {
    if (paramAccount.isBizMail()) {
      paramAccount.setId(Account.generateId(paramAccount.getUin()));
    }
    long l;
    if (paramAccount.isBizMail())
    {
      paramAccountType = AccountManager.shareInstance().getAccountList().getAccountByEmail(paramAccount.getEmail());
      if (paramAccountType == null) {
        break label223;
      }
      l = paramAccountType.getSequence();
      QMLog.log(4, "LoginManager", "del localbizmail:" + paramAccountType.getEmail());
      AccountManager.shareInstance().deleteAccount(paramAccountType.getId(), true);
    }
    for (;;)
    {
      AccountManager.shareInstance().saveAccount(paramAccount, l);
      AccountManager.shareInstance().reloadAccounts();
      paramAccount.reAuthSuccess();
      QMSyncErrorManager.sharedInstance().removeUnAuthError(paramAccount.getId());
      if ((paramAccount.isQQMail()) && (!paramAccount.isBizMail()) && (paramBoolean)) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramAccount.setQuickLogin(paramBoolean);
        QMLog.log(4, "LoginManager", "handleAuthSuccess. go modaccount:" + paramAccount.getEmail());
        QMPrivateProtocolManager.sharedInstance().modAccount(paramAccount);
        if (l == 0L) {
          break label221;
        }
        return true;
        paramAccountType = AccountManager.shareInstance().getAccountList().getAccountByEmail(paramAccount.getEmail());
        if (paramAccountType == null) {
          break label223;
        }
        l = paramAccountType.getSequence();
        break;
      }
      label221:
      return false;
      label223:
      l = 0L;
    }
  }
  
  public void initNewAccount(Account paramAccount, int paramInt, String paramString, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramAccount.save();
    String str2 = paramAccount.getEmail().split("@")[1];
    Profile localProfile = paramAccount.getProfile();
    int i = paramAccount.getId();
    label80:
    StringBuilder localStringBuilder;
    if (((paramAccount.isQQMail()) && (!paramAccount.isBizMail())) || (paramAccount.isTencentDotCom()))
    {
      QMSettingManager.sharedInstance().setCalendarDisplay(true);
      if ((!paramAccount.isQQMail()) || (paramAccount.isBizMail()) || (!paramBoolean1)) {
        break label346;
      }
      paramBoolean1 = true;
      paramAccount.setQuickLogin(paramBoolean1);
      if (!paramAccount.isQQMail()) {
        break label377;
      }
      str1 = paramAccount.getPwd();
      if ((!SharedPreferenceUtil.isWtlogin()) || (paramAccount.isBizMail())) {
        break label361;
      }
      localStringBuilder = new StringBuilder().append(QMWtLoginManager.getInstance().getA2(paramAccount.getUin())).append("\t");
      if (paramAccount.getSecondPassword() != null) {
        break label352;
      }
      str1 = "";
    }
    label152:
    label346:
    label352:
    label361:
    for (String str1 = Aes.encode(str1, Aes.getServerKey());; str1 = StringExtention.encodeURI(Aes.encode(str1, Aes.getServerKey())))
    {
      QMPrivateProtocolManager.sharedInstance().addAccount(localProfile, str2, paramAccount.getEmail(), str1, i, paramString, paramBitmap, false, paramAccount.isBizMail());
      QMSettingManager.sharedInstance().setQQAccountPswLength(i, paramInt);
      if ((AccountManager.shareInstance().getAccountList().size() == 1) || ((paramAccount.isQQMail()) && (AccountManager.shareInstance().getAccountList().getQQMailAccountNumber() == 1)))
      {
        QMSettingManager.sharedInstance().setNoteDisplay(paramAccount.isQQMail());
        QMSettingManager.sharedInstance().setFtnDisplay(paramAccount.isQQMail());
      }
      QMSettingManager.sharedInstance().setNotifyAccountMail(i, true);
      QMMailManager.sharedInstance().initSync(paramAccount);
      QMMailManager.sharedInstance().loadComposeData(paramAccount.getId());
      if ((paramAccount.isQQMail()) || (paramAccount.isTencentDotCom())) {
        QMCalendarManager.getInstance().login(paramAccount, null, null);
      }
      return;
      if (paramBoolean2)
      {
        QMSettingManager.sharedInstance().setCalendarDisplay(true);
        break;
      }
      if (AccountManager.shareInstance().getAccountList().size() != 1) {
        break;
      }
      QMSettingManager.sharedInstance().setCalendarDisplay(false);
      break;
      paramBoolean1 = false;
      break label80;
      str1 = paramAccount.getSecondPassword();
      break label152;
    }
    label377:
    QMPrivateProtocolManager.sharedInstance().addAccount(localProfile, str2, paramAccount.getEmail(), "", i, paramString, paramBitmap, false, false);
    QMSettingManager.sharedInstance().setAccountNick(i, paramString);
    paramString = QMSettingManager.sharedInstance();
    paramInt = paramAccount.getId();
    if ((paramAccount.isGMail()) || (paramAccount.getEmail().toLowerCase().endsWith("@tencent.com"))) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramString.setAggregateSubject(paramInt, paramBoolean1);
      QMSharedPreferenceManager.getInstance().setHasForeignAccount(true);
      break;
    }
  }
  
  public void initNewAccount(Account paramAccount, int paramInt, boolean paramBoolean)
  {
    initNewAccount(paramAccount, paramInt, null, null, paramBoolean, false);
  }
  
  public void initService(Context paramContext)
  {
    LoginManager.10 local10 = new LoginManager.10(this);
    this.authService = new AuthorizationService(paramContext, new AppAuthConfiguration.Builder().setConnectionBuilder(local10).build());
  }
  
  public boolean isGMailAccessTokenExpire(int paramInt)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    return (localAccount != null) && (System.currentTimeMillis() - localAccount.getLastTokenTime() > localAccount.getExpireIn() * 1000L);
  }
  
  public void reSaveAccountAfterVerifyGes(Account paramAccount, boolean paramBoolean)
  {
    if ((paramAccount.isQQMail()) && (!paramAccount.isBizMail()) && (paramBoolean)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramAccount.setQuickLogin(paramBoolean);
      if (paramAccount.isGMail())
      {
        AccountManager.shareInstance().saveAccount(paramAccount, 0L);
        AccountManager.shareInstance().reloadAccounts();
      }
      QMSettingManager.sharedInstance().saveTryGestureTimes(0);
      SharedPreferenceUtil.removeGesturePwd();
      GesturePasswordManager.getInstance().setGesturePwdPassed(true);
      return;
    }
  }
  
  public void refreshGmailAccessToken(int paramInt, String paramString, RefreshTokenCallback paramRefreshTokenCallback)
  {
    boolean bool = false;
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if ((localObject != null) && (StringExtention.isNullOrEmpty(((Account)localObject).getAccessToken())))
    {
      KvHelper.gmailAccessTokenNull(new double[0]);
      QMLog.log(6, "LoginManager", "accountId " + paramInt + " access token null");
    }
    if (StringExtention.isNullOrEmpty(paramString))
    {
      KvHelper.gmailRefreshTokenNull(new double[0]);
      paramRefreshTokenCallback.onError(paramInt, new QMProtocolError(4, "refresh token null:" + paramInt));
      PasswordErrHandler.saveStateAndShowErr(paramInt, -1);
      QMLog.log(6, "LoginManager", "accountId " + paramInt + " refresh token null");
    }
    do
    {
      return;
      if (canRefreshAccessTokenExpire(paramInt)) {
        break;
      }
    } while ((localObject == null) || (paramRefreshTokenCallback == null));
    paramRefreshTokenCallback.onSuccess(paramInt, ((Account)localObject).getAccessToken(), ((Account)localObject).getRefreshToken(), (int)((Account)localObject).getExpireIn(), ((Account)localObject).getIdToken());
    return;
    label465:
    label468:
    for (;;)
    {
      int j;
      synchronized (this.mRefreshTokenCallbacks)
      {
        localObject = (Set)this.mRefreshTokenCallbacks.get(paramInt);
        if (localObject != null) {
          break label468;
        }
        localObject = new HashSet();
        this.mRefreshTokenCallbacks.put(paramInt, localObject);
        if (((Set)localObject).size() > 0) {
          bool = true;
        }
        if (paramRefreshTokenCallback != null) {
          break label465;
        }
        paramRefreshTokenCallback = new LoginManager.5(this);
        ((Set)localObject).add(paramRefreshTokenCallback);
        j = ((Set)localObject).size();
        if ((!bool) && (!canRefreshAccessTokenExpire(paramInt)))
        {
          paramString = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
          if (paramString == null) {
            break;
          }
          paramRefreshTokenCallback.onSuccess(paramInt, paramString.getAccessToken(), paramString.getRefreshToken(), (int)paramString.getExpireIn(), paramString.getIdToken());
          return;
        }
      }
      if (bool) {}
      for (int i = 5;; i = 4)
      {
        QMLog.log(i, "LoginManager", "refreshGmailAccessToken, accountId: " + paramInt + ", refreshing: " + bool + ", running: " + j);
        if (bool) {
          break;
        }
        paramRefreshTokenCallback = new QMCallback();
        paramRefreshTokenCallback.setOnError(new LoginManager.6(this, paramInt));
        paramRefreshTokenCallback.setOnSuccess(new LoginManager.7(this, paramInt, paramString));
        refreshGMailAccessToken(paramString, paramRefreshTokenCallback);
        return;
      }
    }
  }
  
  public void saveAccountLogined(int paramInt, QMNetworkRequest paramQMNetworkRequest, QMNetworkResponse paramQMNetworkResponse)
  {
    boolean bool2 = true;
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null) {
      QMLog.log(5, "LoginManager", "saveAccountLogined. account is null.");
    }
    String str;
    do
    {
      do
      {
        do
        {
          return;
        } while (!((Account)localObject).isQQMail());
        localObject = (QQMailAccount)localObject;
      } while ((!(paramQMNetworkRequest instanceof CGIRequest)) || (paramQMNetworkResponse.getResponseHeaders() == null));
      str = ((QQMailAccount)localObject).getSid();
      paramQMNetworkResponse = ((QQMailAccount)localObject).getCookies();
      paramQMNetworkRequest = ((QQMailAccount)localObject).getAesKey();
      if ((str != null) && (str.length() > 0) && (paramQMNetworkResponse != null))
      {
        ((QQMailAccount)localObject).setSidAndCookies(str, paramQMNetworkResponse);
        ((QQMailAccount)localObject).saveToLocalStorage();
        ((QQMailAccount)localObject).updateSaveSidTime();
      }
      if ((paramQMNetworkRequest != null) && (paramQMNetworkRequest.length() > 0))
      {
        ((QQMailAccount)localObject).setAesKeyCache(paramQMNetworkRequest);
        ((QQMailAccount)localObject).saveAesKeyToLocalStorage();
      }
    } while ((str != null) && (!str.equals("")) && (paramQMNetworkResponse != null) && (paramQMNetworkRequest != null));
    localObject = new StringBuilder().append("AccountManager setSidAndCookies err :");
    if (str == null)
    {
      bool1 = true;
      localObject = ((StringBuilder)localObject).append(bool1).append(",");
      if (paramQMNetworkResponse != null) {
        break label249;
      }
      bool1 = true;
      label204:
      paramQMNetworkResponse = ((StringBuilder)localObject).append(bool1).append(",");
      if (paramQMNetworkRequest != null) {
        break label255;
      }
    }
    label249:
    label255:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      QMLog.log(6, "LoginManager", bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label204;
    }
  }
  
  public void saveAccountLogined(int paramInt, String paramString, ArrayList<Cookie> paramArrayList)
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localObject == null) {
      QMLog.log(5, "LoginManager", "saveAccountLogined. account is null.");
    }
    do
    {
      do
      {
        return;
      } while (!((Account)localObject).isQQMail());
      localObject = (QQMailAccount)localObject;
    } while ((paramString == null) || (paramString.length() <= 0) || (paramArrayList == null));
    ((QQMailAccount)localObject).setSidAndCookies(paramString, paramArrayList);
    ((QQMailAccount)localObject).saveToLocalStorage();
    ((QQMailAccount)localObject).updateSaveSidTime();
  }
  
  public void triggerLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if (Threads.isOnMainThread()) {
      Threads.runInBackground(new LoginManager.1(this, paramInt1, paramLong, paramQMNetworkError, paramString, paramBoolean1, paramBoolean2, paramInt2));
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.loginWatchers.iterator();
      while (localIterator.hasNext()) {
        ((AccountLoginWatcher)localIterator.next()).onError(paramInt1, paramLong, paramQMNetworkError, paramString, paramBoolean1, paramBoolean2, paramInt2);
      }
    }
  }
  
  public void triggerLoginProcess(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.loginWatchers.iterator();
    while (localIterator.hasNext()) {
      ((AccountLoginWatcher)localIterator.next()).onProcess(paramInt1, paramInt2);
    }
  }
  
  public void triggerLoginSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = this.loginWatchers.iterator();
    while (localIterator.hasNext()) {
      ((AccountLoginWatcher)localIterator.next()).onSuccess(paramInt, paramLong, paramBoolean);
    }
  }
  
  public MailAccount verifyMailAccount(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MailServiceProvider paramMailServiceProvider, boolean paramBoolean1, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, boolean paramBoolean2)
  {
    MailAccount localMailAccount = new MailAccount();
    localMailAccount.login(paramLong1, paramString1, paramString2, paramString3, paramString4, paramString5, paramMailServiceProvider, paramBoolean1, paramString6, paramString7, paramString8, paramLong2, paramString9, paramBoolean2);
    return localMailAccount;
  }
  
  public QQMailAccount verifyQQMailAccount(long paramLong, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QQMailAccount localQQMailAccount = new QQMailAccount();
    localQQMailAccount.login(paramLong, paramString1, paramString2, paramBoolean1);
    return localQQMailAccount;
  }
  
  public QQMailAccount verifyQQMailAccountWtlogin(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    return verifyQQMailAccountWtlogin(paramLong, paramString1, paramString2, paramString3, paramString4, paramBoolean1, paramBoolean2, false, null);
  }
  
  public QQMailAccount verifyQQMailAccountWtlogin(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString5)
  {
    QMLog.log(4, "LoginManager", "verifyQQMailAccountWtlogin. username:" + paramString1 + ",biz:" + paramBoolean1 + ",uin:" + paramString4 + ",verify exist:" + paramBoolean2 + ",isBindPhone:" + paramBoolean3 + ",phoneNum:" + paramString5);
    if ((paramBoolean2) && (AccountManager.shareInstance().getAccountList().isExistEmail(paramString1)))
    {
      QMLog.log(4, "LoginManager", "verifyQQMailAccountWtlogin. email exist:" + paramString1);
      KvHelper.wtLoginAccountExist(new double[0]);
    }
    return loginWithUTC(paramLong, paramString1, paramString2, paramString3, paramString4, paramBoolean1, paramBoolean3, paramString5);
  }
  
  public Account verifySettingMailAccount(long paramLong1, int paramInt1, Profile paramProfile, int paramInt2, boolean paramBoolean1, String paramString1, String paramString2, String paramString3, long paramLong2, String paramString4, boolean paramBoolean2)
  {
    MailAccount localMailAccount = new MailAccount();
    localMailAccount.login(paramLong1, paramInt1, paramProfile, paramInt2, paramBoolean1, paramString1, paramString2, paramString3, paramLong2, paramString4, paramBoolean2);
    return localMailAccount;
  }
  
  public MailAccount verifySettingMailAccount(long paramLong1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, MailServiceProvider paramMailServiceProvider, boolean paramBoolean1, String paramString6, String paramString7, String paramString8, long paramLong2, String paramString9, boolean paramBoolean2)
  {
    MailAccount localMailAccount = new MailAccount();
    localMailAccount.login(paramLong1, paramString1, paramString2, paramString3, paramString4, paramString5, paramMailServiceProvider, paramBoolean1, paramString6, paramString7, paramString8, paramLong2, paramString9, paramBoolean2);
    return localMailAccount;
  }
  
  static class SingleTon
  {
    private static LoginManager _instance = new LoginManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.LoginManager
 * JD-Core Version:    0.7.0.1
 */