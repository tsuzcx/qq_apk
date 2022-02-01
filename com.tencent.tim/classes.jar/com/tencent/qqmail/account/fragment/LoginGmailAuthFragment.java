package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.moai.proxycat.ProxyVPNService;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.helper.GmailLoginHelper;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.watcher.GMailAuthWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import net.openid.appauth.AuthorizationException;
import net.openid.appauth.AuthorizationResponse;

public class LoginGmailAuthFragment
  extends LoginTaskFragment
{
  private static final int REQ_CER = 1;
  private static final int REQ_VPN = 0;
  private static final String TAG = "LoginGmailAuthFragment";
  private QMBaseView baseView;
  private GMailAuthWatcher gmailAuthWatcher = new LoginGmailAuthFragment.1(this);
  private String mGmailAccessToken;
  private String mGmailAddress;
  private long mGmailExpiresIn;
  private String mGmailIdToken;
  private String mGmailRefreshToken;
  private String mGmailTokenType;
  private QMTopBar topBar;
  
  public LoginGmailAuthFragment() {}
  
  public LoginGmailAuthFragment(String paramString)
  {
    this.userInputEmail = paramString;
  }
  
  private void doLogin(MailServiceProvider paramMailServiceProvider)
  {
    String str = getLoginEmail();
    this.userClickAbort = false;
    if (!this.isVerifyAccount) {}
    for (this.account = LoginManager.shareInstance().verifyMailAccount(this.currentLoginId, str, str, "", this.mGmailAddress, "", paramMailServiceProvider, false, this.mGmailAccessToken, this.mGmailRefreshToken, this.mGmailTokenType, this.mGmailExpiresIn, this.mGmailIdToken, true);; this.account = LoginManager.shareInstance().verifySettingMailAccount(this.currentLoginId, str, str, "", this.mGmailAddress, "", paramMailServiceProvider, true, this.mGmailAccessToken, this.mGmailRefreshToken, this.mGmailTokenType, this.mGmailExpiresIn, this.mGmailIdToken, true))
    {
      if (this.account == null)
      {
        showErrorTips("帐号已存在，无需重复登录");
        DataCollector.logException(7, 3, "Event_Error", "帐号已存在，无需重复登录", true);
        AddAccountLocalLogUtil.logAddAccountLocalFail(str, this.mAccountType, 4);
      }
      return;
    }
  }
  
  private String getLoginEmail()
  {
    String str2 = this.mGmailAddress.toLowerCase();
    String str1 = str2;
    if (!str2.contains("@")) {
      str1 = str2 + "@gmail.com";
    }
    return str1;
  }
  
  private void handleAuthResponse()
  {
    Object localObject = ProxyVPNService.createStopIntent(getActivity());
    getActivity().startService((Intent)localObject);
    localObject = GmailLoginHelper.getAuthorizationResponse();
    AuthorizationException localAuthorizationException = GmailLoginHelper.getAuthorizationException();
    GmailLoginHelper.setAuthorizationResponse(null);
    GmailLoginHelper.setAuthorizationException(null);
    if (localAuthorizationException != null)
    {
      QMLog.log(6, "LoginGmailAuthFragment", "handle auth response error", localAuthorizationException);
      refreshTopBar(false);
      showErrorTips("Gmail授权登录失败");
    }
    while (localObject == null) {
      return;
    }
    QMLog.log(4, "LoginGmailAuthFragment", "handle auth response success");
    refreshTopBar(true);
    runInBackground(new LoginGmailAuthFragment.9(this, (AuthorizationResponse)localObject), 500L);
  }
  
  private void initAuthBtn()
  {
    ((Button)this.baseView.findViewById(2131368071)).setOnClickListener(new LoginGmailAuthFragment.8(this));
  }
  
  private void initProxyData()
  {
    runInBackground(new LoginGmailAuthFragment.2(this));
  }
  
  private void initTopBar()
  {
    this.topBar = this.baseView.getTopBar();
    this.topBar.setTitle(AccountType.gmail.getResId());
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginGmailAuthFragment.5(this));
  }
  
  private void login()
  {
    this.currentLoginId = System.currentTimeMillis();
    MailServiceProvider localMailServiceProvider = MailServiceManager.getInstance().getDefaultProvider(AccountType.gmail.getDomain());
    localMailServiceProvider.setExchangeServer("m.google.com");
    doLogin(localMailServiceProvider);
  }
  
  private void showErrorTips(String paramString)
  {
    LoginUIHelper.processCustomError(getActivity(), paramString, true, null, new LoginGmailAuthFragment.7(this));
  }
  
  protected void handleLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Threads.runOnMainThread(new LoginGmailAuthFragment.4(this, paramQMNetworkError));
  }
  
  protected void handleLoginProcess(int paramInt, long paramLong) {}
  
  protected void handleLoginQQUseProtocol() {}
  
  protected void handleLoginSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    runOnMainThread(new LoginGmailAuthFragment.3(this));
  }
  
  protected void handleQueryProviderError(long paramLong, AccountType paramAccountType)
  {
    doLogin(MailServiceManager.getInstance().getDefaultProvider(AccountType.gmail.getDomain()));
  }
  
  protected void handleQueryProviderSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider)
  {
    if (this.currentLoginId == paramLong) {
      doLogin(paramMailServiceProvider);
    }
  }
  
  public void initDataSource()
  {
    this.mAccountType = AccountType.gmail;
    if (!this.isVerifyAccount) {
      DataCollector.logEvent("Event_Gmail_Oauth_Login");
    }
    LoginManager.shareInstance().initService(getActivity());
    initProxyData();
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initAuthBtn();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = View.inflate(getActivity(), 2131559505, null);
    localView.setLayoutParams(localLayoutParams);
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.baseView.addView(localView);
    return this.baseView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 0) {
      if (paramInt2 == -1)
      {
        paramIntent = ProxyVPNService.createStartIntent(getActivity());
        getActivity().startService(paramIntent);
        runOnMainThread(new LoginGmailAuthFragment.10(this), 500L);
      }
    }
    while (paramInt1 != 1)
    {
      return;
      QMLog.log(6, "LoginGmailAuthFragment", "config error");
      return;
    }
    if (paramInt2 == -1)
    {
      new Thread(new LoginGmailAuthFragment.11(this)).start();
      Toast.makeText(getActivity(), "certification installed", 1).show();
      return;
    }
    Toast.makeText(getActivity(), "certification not installed", 1).show();
  }
  
  public void onBackPressed()
  {
    Intent localIntent = ProxyVPNService.createStopIntent(getActivity());
    getActivity().startService(localIntent);
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.gmailAuthWatcher, paramBoolean);
  }
  
  public void onRelease()
  {
    LoginManager.shareInstance().disposeService();
  }
  
  protected void recoverFocus() {}
  
  public int refreshData()
  {
    handleAuthResponse();
    return 0;
  }
  
  protected void refreshTopBar(boolean paramBoolean)
  {
    Threads.runOnMainThread(new LoginGmailAuthFragment.6(this, paramBoolean));
  }
  
  public void render(int paramInt)
  {
    if ((this.needHandleLoginSuccess) && (this.account.isLogined()))
    {
      replaceFragment(this, new LoginInfoFragment(this.account, "", AccountType.gmail, false));
      this.needHandleLoginSuccess = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailAuthFragment
 * JD-Core Version:    0.7.0.1
 */