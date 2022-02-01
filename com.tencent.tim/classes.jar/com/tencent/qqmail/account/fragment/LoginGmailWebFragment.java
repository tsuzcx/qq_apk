package com.tencent.qqmail.account.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.watcher.GMailAuthWatcher;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.GmailAuthWebView;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;

public class LoginGmailWebFragment
  extends LoginTaskFragment
{
  private static final String TAG = "LoginGmailFragment";
  private QMBaseView baseView;
  private GMailAuthWatcher gmailAuthWatcher = new LoginGmailWebFragment.1(this);
  private String mGmailAccessToken;
  private String mGmailAddress;
  private GmailAuthWebView mGmailAuthWebView;
  private long mGmailExpiresIn;
  private String mGmailIdToken;
  private String mGmailRefreshToken;
  private String mGmailTokenType;
  private boolean retryGetToken = true;
  private QMTopBar topBar;
  
  public LoginGmailWebFragment() {}
  
  public LoginGmailWebFragment(String paramString)
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
  
  private void initGmailAuthWebView()
  {
    this.mGmailAuthWebView = ((GmailAuthWebView)this.baseView.findViewById(2131382171));
    this.mGmailAuthWebView.setTopBar(this.topBar);
    this.mGmailAuthWebView.setBackgroundViewImage((ImageView)this.baseView.findViewById(2131363236));
    this.mGmailAuthWebView.setLoadingView((ImageView)this.baseView.findViewById(2131370787));
    this.mGmailAuthWebView.setProgressBar((ProgressBar)this.baseView.findViewById(2131373700));
    GmailAuthWebView localGmailAuthWebView = this.mGmailAuthWebView;
    if (this.userInputEmail == null) {}
    for (String str = "";; str = this.userInputEmail)
    {
      localGmailAuthWebView.setEmail(str);
      this.mGmailAuthWebView.init();
      this.mGmailAuthWebView.loadGoolgeAuthUrl();
      return;
    }
  }
  
  private void initTopBar()
  {
    this.topBar = this.baseView.getTopBar();
    this.topBar.setTitle(AccountType.gmail.getResId());
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginGmailWebFragment.4(this));
    if (this.fromGesPwdVerifyOvertimes) {
      this.topBar.getButtonLeft().setVisibility(8);
    }
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
    LoginUIHelper.processCustomError(getActivity(), paramString, true, null, new LoginGmailWebFragment.6(this));
  }
  
  protected void handleLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Threads.runOnMainThread(new LoginGmailWebFragment.3(this, paramQMNetworkError));
  }
  
  protected void handleLoginProcess(int paramInt, long paramLong) {}
  
  protected void handleLoginQQUseProtocol() {}
  
  protected void handleLoginSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    if (this.mGmailAuthWebView != null) {
      this.mGmailAuthWebView.release();
    }
    runOnMainThread(new LoginGmailWebFragment.2(this));
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
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTopBar();
    initGmailAuthWebView();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 48);
    localLayoutParams.setMargins(0, getResources().getDimensionPixelSize(2131299664), 0, 0);
    View localView = View.inflate(getActivity(), 2131559504, null);
    localView.setLayoutParams(localLayoutParams);
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.baseView.addView(localView);
    return this.baseView;
  }
  
  public void onBackPressed()
  {
    if (this.mGmailAuthWebView != null) {
      this.mGmailAuthWebView.release();
    }
    if (this.fromGesPwdVerifyOvertimes)
    {
      getActivity().moveTaskToBack(true);
      return;
    }
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.gmailAuthWatcher, paramBoolean);
  }
  
  public void onRelease()
  {
    if (this.mGmailAuthWebView != null) {
      this.mGmailAuthWebView.release();
    }
  }
  
  protected void recoverFocus() {}
  
  public int refreshData()
  {
    return 0;
  }
  
  protected void refreshTopBar(boolean paramBoolean)
  {
    Threads.runOnMainThread(new LoginGmailWebFragment.5(this, paramBoolean));
  }
  
  public void render(int paramInt)
  {
    if ((!this.needHandleLoginSuccess) || (!this.account.isLogined())) {
      return;
    }
    replaceFragment(this, new LoginInfoFragment(this.account, "", AccountType.gmail, false));
    this.needHandleLoginSuccess = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginGmailWebFragment
 * JD-Core Version:    0.7.0.1
 */