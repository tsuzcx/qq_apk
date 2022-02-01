package com.tencent.qqmail.account.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.EmailDomainDefine.DomainType;
import com.tencent.qqmail.account.watcher.AccountLoginWatcher;
import com.tencent.qqmail.account.watcher.QueryProviderWatcher;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.register.util.RegisterUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public abstract class LoginTaskFragment
  extends LoginBaseFragment
{
  private static final String TAG = "LoginAccountBaseFragment";
  private static ArrayList<String> autoCorrectEmails = new ArrayList();
  protected static long wtloginSeq;
  protected Account account;
  protected long currentLoginId = 0L;
  protected boolean from3GLoginToggleWT;
  protected boolean fromDeviceLock;
  protected boolean fromGesPwdVerify;
  protected boolean fromGesPwdVerifyOvertimes;
  protected boolean fromPwdErrVerify;
  protected boolean fromSchema;
  protected boolean fromSendMail;
  protected boolean fromSettingAccount;
  protected boolean fromSettingPlugin;
  protected boolean isLogining;
  protected boolean isMobileQQuickLogin;
  protected boolean isSmtpServerError = false;
  protected boolean isVerifyAccount;
  private AccountLoginWatcher loginWatcher = new LoginTaskFragment.2(this);
  protected AccountType mAccountType;
  protected boolean needHandleLoginError = false;
  protected boolean needHandleLoginSuccess = false;
  private QueryProviderWatcher queryProviderWatcher = new LoginTaskFragment.1(this);
  protected String schemaAccount;
  protected String schemaTips;
  protected boolean userClickAbort;
  protected String userInputEmail;
  protected String userInputPwd;
  protected MailServiceProvider userProvider;
  protected boolean verifySuccess = true;
  
  private void handleSettingAccountVerifyOk()
  {
    this.verifySuccess = true;
    boolean bool = LoginManager.shareInstance().handleAuthSuccess(this.account, this.mAccountType, this.isMobileQQuickLogin);
    if (bool) {
      QMMailManager.sharedInstance().sync(this.account.getId());
    }
    runOnMainThread(new LoginTaskFragment.5(this, bool), 500L);
  }
  
  private void handleSettingGestureVerifyOK()
  {
    Threads.runOnMainThread(new LoginTaskFragment.6(this));
  }
  
  private void handleStopTopBar()
  {
    Threads.runOnMainThread(new LoginTaskFragment.4(this));
  }
  
  private void handlerDigitalAccountError(String paramString)
  {
    KvHelper.digitalLoginErrorShow(new double[0]);
    handleStopTopBar();
    runOnMainThread(new LoginTaskFragment.3(this, paramString, paramString.split("@")[0] + "@qq.com"));
  }
  
  private void handlerImapError(QMLoginError paramQMLoginError, EmailDomainDefine.DomainType paramDomainType)
  {
    if ((paramQMLoginError.loginErrorType == 5003) && (paramDomainType.getAuthHelpUrl() != null))
    {
      LoginUIHelper.processImapError(getActivity(), getString(2131695516), getString(paramDomainType.getAuthTipsResId()), getString(paramDomainType.getAuthHelpResId()), new LoginTaskFragment.7(this, paramDomainType), new LoginTaskFragment.8(this), null);
      return;
    }
    if (paramQMLoginError.loginErrorType == 1)
    {
      if (this.userProvider != null) {}
      for (paramQMLoginError = this.userProvider.getDefaultRecvProtocol();; paramQMLoginError = "IMAP")
      {
        LoginUIHelper.processImapError(getActivity(), getString(2131695520), String.format(getString(2131695552), new Object[] { paramQMLoginError }), getString(2131689499), new LoginTaskFragment.9(this, paramDomainType), new LoginTaskFragment.10(this), null);
        return;
      }
    }
    if ((paramQMLoginError.loginErrorType == 5002) && (paramDomainType.getDenyHelpUrl() != null))
    {
      LoginUIHelper.processImapError(getActivity(), getString(2131695520), paramQMLoginError.desp, getString(2131689495), new LoginTaskFragment.11(this, paramDomainType), new LoginTaskFragment.12(this), null);
      return;
    }
    if ((paramQMLoginError.loginErrorType == 5002) && (paramDomainType.getAuthHelpUrl() != null))
    {
      LoginUIHelper.processImapError(getActivity(), getString(2131695520), paramQMLoginError.desp, getString(2131689495), new LoginTaskFragment.13(this, paramDomainType), new LoginTaskFragment.14(this), null);
      return;
    }
    runOnMainThread(new LoginTaskFragment.15(this, paramQMLoginError));
  }
  
  private void initData()
  {
    boolean bool = false;
    if (getActivity().getIntent() == null) {
      return;
    }
    Intent localIntent = getActivity().getIntent();
    this.fromSchema = localIntent.getBooleanExtra("from_schema", false);
    this.schemaAccount = localIntent.getStringExtra("schema_account");
    this.schemaTips = localIntent.getStringExtra("schema_tips");
    this.fromDeviceLock = localIntent.getBooleanExtra("from_dev_lock", false);
    this.fromPwdErrVerify = localIntent.getBooleanExtra("from_psw_err_verify", false);
    this.fromSettingPlugin = localIntent.getBooleanExtra("from_setting_verify", false);
    this.fromSettingAccount = localIntent.getBooleanExtra("from_setting_account", false);
    this.fromGesPwdVerify = localIntent.getBooleanExtra("from_ges_pwd_verify", false);
    this.fromGesPwdVerifyOvertimes = localIntent.getBooleanExtra("from_ges_pwd_verify_overtimes", false);
    this.from3GLoginToggleWT = localIntent.getBooleanExtra("from_3g_login_toggle_wt", false);
    this.fromSendMail = localIntent.getBooleanExtra("from_send_mail", false);
    this.isSmtpServerError = localIntent.getBooleanExtra("arg_smtp_server_error", false);
    if ((this.fromDeviceLock) || (this.fromPwdErrVerify) || (this.fromSettingAccount) || (this.fromGesPwdVerify) || (this.from3GLoginToggleWT)) {
      bool = true;
    }
    this.isVerifyAccount = bool;
  }
  
  private boolean isAutoCorrect(String paramString)
  {
    if (paramString.contains("@"))
    {
      String str1 = paramString.split("@")[0];
      String str2 = paramString.split("@")[1];
      localObject = str1;
      if (!"126.com".equalsIgnoreCase(str2))
      {
        localObject = str1;
        if (!"163.com".equalsIgnoreCase(str2)) {
          return false;
        }
      }
    }
    else
    {
      localObject = paramString;
    }
    QMLog.log(4, "LoginAccountBaseFragment", "autoCorrect " + paramString);
    if (RegisterUtil.isMobiPhoneNum((String)localObject)) {
      return false;
    }
    Object localObject = Pattern.compile("^\\d{3,}$", 2).matcher((CharSequence)localObject);
    QMLog.log(4, "LoginAccountBaseFragment", "autoCorrect " + paramString + " " + ((Matcher)localObject).matches());
    return ((Matcher)localObject).matches();
  }
  
  private boolean isAutoCorrected(String paramString)
  {
    Iterator localIterator = autoCorrectEmails.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equalsIgnoreCase(paramString)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean isUsingDetectProvider(String paramString)
  {
    if (this.userProvider == null) {}
    do
    {
      return false;
      paramString = MailServiceManager.getInstance().getAutoFillMailProvider(paramString);
    } while ((paramString == null) || (this.userProvider == null) || (!MailServiceManager.getInstance().isSameMailServiceProvider(paramString, this.userProvider)));
    return true;
  }
  
  private void registerNotificationInCreateAndDestroy(boolean paramBoolean)
  {
    LoginManager.shareInstance().bindLoginListener(this.loginWatcher, paramBoolean);
    MailServiceManager.getInstance().bindQueryProviderListener(this.queryProviderWatcher, paramBoolean);
  }
  
  protected void abortLogin()
  {
    long l;
    if (this.isLogining)
    {
      this.userClickAbort = true;
      this.isLogining = false;
      if (this.currentLoginId != 0L)
      {
        l = System.currentTimeMillis() - this.currentLoginId;
        if (l > 5000L) {
          if (this.userInputEmail == null) {
            break label88;
          }
        }
      }
    }
    label88:
    for (String str = AccountType.splitDomain(this.userInputEmail);; str = this.mAccountType.getDomain())
    {
      OssHelper.mailLogin(new Object[] { str, "ABORT", Long.valueOf(l) });
      refreshTopBar(false);
      return;
    }
  }
  
  protected void goToLoginProtocolPage() {}
  
  protected abstract void handleLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2);
  
  protected abstract void handleLoginProcess(int paramInt, long paramLong);
  
  protected abstract void handleLoginQQUseProtocol();
  
  protected abstract void handleLoginSuccess(int paramInt, long paramLong, boolean paramBoolean);
  
  protected abstract void handleQueryProviderError(long paramLong, AccountType paramAccountType);
  
  protected abstract void handleQueryProviderSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider);
  
  public void onCreate(Bundle paramBundle)
  {
    initData();
    super.onCreate(paramBundle);
    registerNotificationInCreateAndDestroy(true);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    registerNotificationInCreateAndDestroy(false);
  }
  
  protected void reLogin() {}
  
  protected abstract void recoverFocus();
  
  protected abstract void refreshTopBar(boolean paramBoolean);
  
  public static abstract interface LoginInterface
  {
    public abstract void login(MailServiceProvider paramMailServiceProvider);
  }
  
  public class LoginTask
    extends AsyncTask<Void, Void, MailServiceProvider>
  {
    private String domain;
    private LoginTaskFragment.LoginInterface loginInterface;
    
    public LoginTask(String paramString, LoginTaskFragment.LoginInterface paramLoginInterface)
    {
      this.domain = paramString;
      this.loginInterface = paramLoginInterface;
    }
    
    protected MailServiceProvider doInBackground(Void... paramVarArgs)
    {
      return MailServiceManager.getInstance().getProviderByDomain(this.domain);
    }
    
    protected void onPostExecute(MailServiceProvider paramMailServiceProvider)
    {
      this.loginInterface.login(paramMailServiceProvider);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginTaskFragment
 * JD-Core Version:    0.7.0.1
 */