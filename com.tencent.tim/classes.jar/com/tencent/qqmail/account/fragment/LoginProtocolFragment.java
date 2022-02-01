package com.tencent.qqmail.account.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.moai.mailsdk.util.SPUtility;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.view.ProtocolSettingView;
import com.tencent.qqmail.account.view.ProtocolSettingView.ProtocolType;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMTips;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import moai.fragment.app.FragmentActivity;

public class LoginProtocolFragment
  extends LoginTaskFragment
{
  public static final int PAGE_TYPE_EXCHANGE = 6;
  public static final int PAGE_TYPE_IMAP = 4;
  public static final int PAGE_TYPE_ONLY_EXCHANGE = 3;
  public static final int PAGE_TYPE_ONLY_IMAP = 1;
  public static final int PAGE_TYPE_ONLY_POP = 2;
  public static final int PAGE_TYPE_POP = 5;
  private static final String TAG = "LoginProtocolFragment";
  private int accountId;
  private QMBaseView baseView;
  private ProtocolSettingView exchangeSettingView;
  private View focusView;
  private ProtocolSettingView imapSettingView;
  private int pageType;
  private ProtocolSettingView pop3SettingView;
  private Profile profile;
  private ProtocolSettingView smtpSettingView;
  private View.OnClickListener tabButtonClickListener = new LoginProtocolFragment.2(this);
  private Button tabExchange;
  private Button tabIMAP;
  private Button tabPOP3;
  private TextWatcher textWatcher = new LoginProtocolFragment.1(this);
  private QMTopBar topBar;
  private boolean update = false;
  private UserAccountInput userAccountInput = new UserAccountInput(null);
  
  public LoginProtocolFragment(int paramInt)
  {
    this.accountId = paramInt;
    this.account = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (this.account == null) {
      throw new IllegalStateException("accountId: " + paramInt);
    }
    this.mAccountType = AccountType.domainOf(this.account.getEmail());
    this.pageType = getProtocolType();
    this.profile = this.account.getProfile().deepCopy();
    UserAccountInput localUserAccountInput = this.userAccountInput;
    String str = this.account.getEmail();
    this.userInputEmail = str;
    localUserAccountInput.receiveUsername = str;
    localUserAccountInput = this.userAccountInput;
    str = Aes.decode(this.account.getPwd(), Aes.getPureDeviceToken());
    this.userInputPwd = str;
    localUserAccountInput.loginPassword = str;
    this.userAccountInput.sendUserName = this.profile.smtpName;
    this.userAccountInput.sendPassword = this.profile.smtpPassword;
    switch (this.profile.protocolType)
    {
    default: 
      return;
    case 0: 
      this.userAccountInput.loginPassword = this.profile.pop3Password;
      return;
    }
    this.userAccountInput.loginPassword = this.profile.imapPassword;
  }
  
  public LoginProtocolFragment(AccountType paramAccountType, String paramString1, String paramString2, int paramInt, MailServiceProvider paramMailServiceProvider)
  {
    this.mAccountType = paramAccountType;
    this.pageType = paramInt;
    paramAccountType = this.userAccountInput;
    this.userInputEmail = paramString1;
    paramAccountType.receiveUsername = paramString1;
    paramAccountType = this.userAccountInput;
    this.userInputPwd = paramString2;
    paramAccountType.loginPassword = paramString2;
    this.userProvider = paramMailServiceProvider;
  }
  
  private boolean doLogin()
  {
    this.focusView = getActivity().getCurrentFocus();
    int j;
    int i;
    if (!this.fromSettingAccount)
    {
      this.userProvider.addProviderCompanyEntry("0");
      j = 0;
      i = j;
      if (this.exchangeSettingView != null)
      {
        i = j;
        if (this.exchangeSettingView.getVisibility() == 0)
        {
          i = this.exchangeSettingView.setProvider(this.userProvider);
          this.userAccountInput.receiveUsername = this.exchangeSettingView.getUserName();
          this.userAccountInput.loginPassword = this.exchangeSettingView.getPwd();
        }
      }
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.imapSettingView != null)
        {
          j = i;
          if (this.imapSettingView.getVisibility() == 0)
          {
            j = this.imapSettingView.setProvider(this.userProvider);
            this.userAccountInput.receiveUsername = this.imapSettingView.getUserName();
            this.userAccountInput.loginPassword = this.imapSettingView.getPwd();
          }
        }
      }
      i = j;
      if (j == 0)
      {
        i = j;
        if (this.pop3SettingView != null)
        {
          i = j;
          if (this.pop3SettingView.getVisibility() == 0)
          {
            i = this.pop3SettingView.setProvider(this.userProvider);
            this.userAccountInput.receiveUsername = this.pop3SettingView.getUserName();
            this.userAccountInput.loginPassword = this.pop3SettingView.getPwd();
          }
        }
      }
      if (i != 0)
      {
        validInput(1, i);
        return false;
      }
      recoverProvider();
      j = i;
      if (i == 0)
      {
        j = i;
        if (this.smtpSettingView != null)
        {
          j = i;
          if (this.smtpSettingView.getVisibility() == 0)
          {
            j = this.smtpSettingView.setProvider(this.userProvider);
            this.userAccountInput.sendUserName = this.smtpSettingView.getUserName();
            this.userAccountInput.sendPassword = this.smtpSettingView.getPwd();
          }
        }
      }
      if (j != 0)
      {
        validInput(2, j);
        return false;
      }
      QMLog.log(4, "LoginProtocolFragment", "dologin userProviderImapServer:" + this.userProvider.getImapServer() + ", userProvider.getImapPort():" + this.userProvider.getImapPort() + ", userProvider.getImapSSLPort():" + this.userProvider.getImapSSLPort() + ", userProviderPop3Server:" + this.userProvider.getPop3Server() + ", userProvider.getPop3Port()" + this.userProvider.getPop3Port() + ", userProvider.getPop3SSLPort()" + this.userProvider.getPop3SSLPort() + ", userProviderSmtpServer:" + this.userProvider.getSmtpServer() + ", userProvider.getSmtpPort()" + this.userProvider.getSmtpPort() + ", userProvider.getSmtpSSLPort()" + this.userProvider.getSmtpSSLPort() + ", userProviderExchangeServer:" + this.userProvider.getExchangeServer() + ", userProvider.getDomain()" + this.userProvider.getExchangeDomain());
      if (3 != this.pageType)
      {
        if (StringExtention.isNullOrEmpty(this.userAccountInput.sendUserName)) {
          this.userAccountInput.sendUserName = this.userAccountInput.receiveUsername;
        }
        if (StringExtention.isNullOrEmpty(this.userAccountInput.sendPassword)) {
          this.userAccountInput.sendPassword = this.userAccountInput.loginPassword;
        }
      }
      this.userInputEmail = this.userAccountInput.receiveUsername;
      this.currentLoginId = System.currentTimeMillis();
      if (!this.isVerifyAccount)
      {
        this.account = LoginManager.shareInstance().verifyMailAccount(this.currentLoginId, this.userInputEmail, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword, this.userAccountInput.sendUserName, this.userAccountInput.sendPassword, this.userProvider, false, null, null, null, 0L, null, false);
        if (this.account == null)
        {
          Threads.runOnMainThread(new LoginProtocolFragment.8(this), 250L);
          return false;
        }
      }
      else
      {
        this.account = LoginManager.shareInstance().verifySettingMailAccount(this.currentLoginId, this.userInputEmail, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword, this.userAccountInput.sendUserName, this.userAccountInput.sendPassword, this.userProvider, false, null, null, null, 0L, null, false);
      }
      DataCollector.logPerformanceBegin("Performance_Login", 0L, "Performance_Login" + this.currentLoginId);
    }
    for (;;)
    {
      this.userClickAbort = false;
      refreshTopBar(true);
      return true;
      j = 0;
      i = j;
      if (this.smtpSettingView != null)
      {
        i = j;
        if (this.smtpSettingView.getVisibility() == 0) {
          i = this.smtpSettingView.setProfile(this.profile);
        }
      }
      if (i != 0)
      {
        validInput(2, i);
        return false;
      }
      j = i;
      if (this.exchangeSettingView != null)
      {
        j = i;
        if (this.exchangeSettingView.getVisibility() == 0) {
          j = this.exchangeSettingView.setProfile(this.profile);
        }
      }
      i = j;
      if (this.imapSettingView != null)
      {
        i = j;
        if (this.imapSettingView.getVisibility() == 0)
        {
          j = this.imapSettingView.setProfile(this.profile);
          if (StringExtention.isNullOrEmpty(this.profile.smtpName)) {
            this.profile.smtpName = this.profile.imapName;
          }
          i = j;
          if (StringExtention.isNullOrEmpty(this.profile.smtpPassword))
          {
            this.profile.smtpPassword = this.profile.imapPassword;
            i = j;
          }
        }
      }
      j = i;
      if (this.pop3SettingView != null)
      {
        j = i;
        if (this.pop3SettingView.getVisibility() == 0)
        {
          i = this.pop3SettingView.setProfile(this.profile);
          if (StringExtention.isNullOrEmpty(this.profile.smtpName)) {
            this.profile.smtpName = this.profile.pop3Name;
          }
          j = i;
          if (StringExtention.isNullOrEmpty(this.profile.smtpPassword))
          {
            this.profile.smtpPassword = this.profile.pop3Password;
            j = i;
          }
        }
      }
      if (j != 0)
      {
        validInput(1, j);
        return false;
      }
      this.currentLoginId = System.currentTimeMillis();
      this.account = LoginManager.shareInstance().verifySettingMailAccount(this.currentLoginId, this.profile.protocolType, this.profile, this.accountId, true, null, null, null, 0L, null, false);
      QMLog.log(4, "LoginProtocolFragment", "dologin with profile: imapServer:" + this.profile.imapServer + ", imapPort:" + this.profile.imapPort + ", imapSSLPort:" + this.profile.imapSSLPort + ", Pop3Server:" + this.profile.pop3Server + ", Pop3Port" + this.profile.pop3Port + ", Pop3SSLPort" + this.profile.pop3SSLPort + ", SmtpServer:" + this.profile.smtpServer + ", SmtpPort" + this.profile.smtpPort + ", SmtpSSLPort" + this.profile.smtpSSLPort + ", SmtpServer:" + this.profile.smtpServer + ", SmtpPort" + this.profile.smtpPort + ", SmtpSSLPort" + this.profile.smtpSSLPort);
    }
  }
  
  private void fillDefaultPort(MailServiceProvider paramMailServiceProvider)
  {
    if (paramMailServiceProvider.getImapPort() == 0) {
      paramMailServiceProvider.setImapPort(143);
    }
    if (paramMailServiceProvider.getImapSSLPort() == 0) {
      paramMailServiceProvider.setImapSSLPort(993);
    }
    if (paramMailServiceProvider.getPop3Port() == 0) {
      paramMailServiceProvider.setPop3Port(110);
    }
    if (paramMailServiceProvider.getPop3SSLPort() == 0) {
      paramMailServiceProvider.setPop3SSLPort(995);
    }
    if (paramMailServiceProvider.getSmtpPort() == 0) {
      paramMailServiceProvider.setSmtpPort(25);
    }
    if (paramMailServiceProvider.getSmtpSSLPort() == 0) {
      paramMailServiceProvider.setSmtpSSLPort(465);
    }
  }
  
  private MailServiceProvider fillDefaultProvider(MailServiceProvider paramMailServiceProvider, String paramString)
  {
    paramString = paramMailServiceProvider;
    if (paramMailServiceProvider == null)
    {
      QMLog.log(4, "LoginProtocolFragment", "updateServerSetting userProvider is null");
      paramString = new MailServiceProvider();
      paramString.setDefaultRecvProtocol("IMAP");
      paramString.setImapUsingSSL(true);
      paramString.setPop3UsingSSL(true);
      paramString.setSmtpUsingSSL(true);
      paramString.setActiveSyncUsingSSL(true);
      paramString.setExchangeUsingSSL(true);
    }
    return paramString;
  }
  
  private String getInputEmail()
  {
    if (this.imapSettingView.getVisibility() == 0) {
      return this.imapSettingView.getUserName();
    }
    if (this.pop3SettingView.getVisibility() == 0) {
      return this.pop3SettingView.getUserName();
    }
    if (this.exchangeSettingView.getVisibility() == 0) {
      return this.exchangeSettingView.getUserName();
    }
    return "";
  }
  
  private String getInputPwd()
  {
    if (this.imapSettingView.getVisibility() == 0) {
      return this.imapSettingView.getPwd();
    }
    if (this.pop3SettingView.getVisibility() == 0) {
      return this.pop3SettingView.getPwd();
    }
    if (this.exchangeSettingView.getVisibility() == 0) {
      return this.exchangeSettingView.getPwd();
    }
    return "";
  }
  
  private int getProtocolType()
  {
    int i = 1;
    if (this.account != null)
    {
      if (this.account.getProtocolType() == 0) {
        i = 2;
      }
      while (this.account.getProtocolType() == 1) {
        return i;
      }
      return 3;
    }
    return 4;
  }
  
  private void initSettingView()
  {
    int j = 8;
    boolean bool = false;
    ProtocolSettingView localProtocolSettingView;
    switch (this.pageType)
    {
    default: 
      this.imapSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.imap, this.userProvider, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword);
      this.pop3SettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.pop, this.userProvider, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword);
      this.smtpSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.smtp, this.userProvider, "", "");
      this.imapSettingView.setHidePassword(this.fromSettingAccount);
      this.pop3SettingView.setHidePassword(this.fromSettingAccount);
      this.smtpSettingView.setHidePassword(this.fromSettingAccount);
      this.imapSettingView.addTextChangeListener(this.textWatcher);
      this.pop3SettingView.addTextChangeListener(this.textWatcher);
      this.smtpSettingView.addTextChangeListener(this.textWatcher);
      this.exchangeSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.exchange, this.userProvider, this.userInputEmail, this.userInputPwd);
      this.exchangeSettingView.setHidePassword(this.fromSettingAccount);
      this.exchangeSettingView.addTextChangeListener(this.textWatcher);
      this.baseView.addContentView(this.imapSettingView);
      this.baseView.addContentView(this.pop3SettingView);
      this.baseView.addContentView(this.smtpSettingView);
      this.baseView.addContentView(this.exchangeSettingView);
      localProtocolSettingView = this.imapSettingView;
      if (4 == this.pageType)
      {
        i = 0;
        localProtocolSettingView.setVisibility(i);
        localProtocolSettingView = this.pop3SettingView;
        if (5 != this.pageType) {
          break label798;
        }
        i = 0;
        label336:
        localProtocolSettingView.setVisibility(i);
        localProtocolSettingView = this.smtpSettingView;
        if (6 != this.pageType) {
          break label804;
        }
      }
      break;
    }
    label798:
    label804:
    for (int i = 8;; i = 0)
    {
      localProtocolSettingView.setVisibility(i);
      localProtocolSettingView = this.exchangeSettingView;
      i = j;
      if (6 == this.pageType) {
        i = 0;
      }
      localProtocolSettingView.setVisibility(i);
      for (;;)
      {
        if (!this.fromSettingAccount) {
          bool = true;
        }
        setEnableUserName(bool);
        if ((this.smtpSettingView != null) && (this.smtpSettingView.getVisibility() == 0) && (this.fromSendMail))
        {
          if (!this.isSmtpServerError) {
            break;
          }
          this.smtpSettingView.setServerInputFocuse();
        }
        return;
        this.imapSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.imap, this.userProvider, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword);
        this.smtpSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.smtp, this.userProvider, this.userAccountInput.sendUserName, this.userAccountInput.sendPassword);
        this.imapSettingView.setHidePassword(this.fromSettingAccount);
        this.smtpSettingView.setHidePassword(this.fromSettingAccount);
        this.imapSettingView.addTextChangeListener(this.textWatcher);
        this.smtpSettingView.addTextChangeListener(this.textWatcher);
        this.baseView.addContentView(this.imapSettingView);
        this.baseView.addContentView(this.smtpSettingView);
        continue;
        this.pop3SettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.pop, this.userProvider, this.userAccountInput.receiveUsername, this.userAccountInput.loginPassword);
        this.smtpSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.smtp, this.userProvider, this.userAccountInput.sendUserName, this.userAccountInput.sendPassword);
        this.pop3SettingView.setHidePassword(this.fromSettingAccount);
        this.smtpSettingView.setHidePassword(this.fromSettingAccount);
        this.pop3SettingView.addTextChangeListener(this.textWatcher);
        this.smtpSettingView.addTextChangeListener(this.textWatcher);
        this.baseView.addContentView(this.pop3SettingView);
        this.baseView.addContentView(this.smtpSettingView);
        continue;
        this.exchangeSettingView = new ProtocolSettingView(getActivity(), ProtocolSettingView.ProtocolType.exchange, this.userProvider, this.userInputEmail, this.userInputPwd);
        this.exchangeSettingView.setHidePassword(this.fromSettingAccount);
        this.exchangeSettingView.addTextChangeListener(this.textWatcher);
        this.baseView.addContentView(this.exchangeSettingView);
      }
      i = 8;
      break;
      i = 8;
      break label336;
    }
    this.smtpSettingView.setNameFocuse();
  }
  
  private void initTabView()
  {
    boolean bool2 = true;
    LinearLayout localLinearLayout;
    Button localButton;
    if ((this.pageType == 4) || (this.pageType == 5) || (this.pageType == 6))
    {
      localLinearLayout = (LinearLayout)View.inflate(getActivity(), 2131559509, null);
      this.tabIMAP = ((Button)localLinearLayout.findViewById(2131368955));
      this.tabPOP3 = ((Button)localLinearLayout.findViewById(2131373502));
      this.tabExchange = ((Button)localLinearLayout.findViewById(2131366567));
      this.tabIMAP.setOnClickListener(this.tabButtonClickListener);
      this.tabPOP3.setOnClickListener(this.tabButtonClickListener);
      this.tabExchange.setOnClickListener(this.tabButtonClickListener);
      localButton = this.tabIMAP;
      if (4 != this.pageType) {
        break label193;
      }
      bool1 = true;
      localButton.setSelected(bool1);
      localButton = this.tabPOP3;
      if (5 != this.pageType) {
        break label198;
      }
      bool1 = true;
      label155:
      localButton.setSelected(bool1);
      localButton = this.tabExchange;
      if (6 != this.pageType) {
        break label203;
      }
    }
    label193:
    label198:
    label203:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localButton.setSelected(bool1);
      this.baseView.addContentView(localLinearLayout);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label155;
    }
  }
  
  private void initTopBar()
  {
    this.topBar = getTopBar();
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginProtocolFragment.6(this));
    this.topBar.setButtonRightBlue(2131693745);
    this.topBar.setButtonRightOnclickListener(new LoginProtocolFragment.7(this));
    refreshTopBar(false);
  }
  
  private boolean isSmtpLoginError()
  {
    return SPUtility.getSmtpLoginError().contains(this.profile.mailAddress);
  }
  
  private void recoverProvider()
  {
    if ("POP3".equals(this.userProvider.getDefaultRecvProtocol())) {
      if (((this.userProvider.getPop3Port() == 143) && (!this.userProvider.isPop3UsingSSL())) || ((this.userProvider.getPop3SSLPort() == 993) && (this.userProvider.isPop3UsingSSL())))
      {
        this.userProvider.setImapPort(this.userProvider.getPop3Port());
        this.userProvider.setImapSSLPort(this.userProvider.getPop3SSLPort());
        this.userProvider.setImapUsingSSL(this.userProvider.isPop3UsingSSL());
        this.userProvider.setImapServer(this.userProvider.getPop3Server());
        this.userProvider.setDefaultRecvProtocol("IMAP");
      }
    }
    while ((!"IMAP".equals(this.userProvider.getDefaultRecvProtocol())) || (((this.userProvider.getImapPort() != 110) || (this.userProvider.isImapUsingSSL())) && ((this.userProvider.getImapSSLPort() != 995) || (!this.userProvider.isImapUsingSSL())))) {
      return;
    }
    this.userProvider.setPop3Port(this.userProvider.getImapPort());
    this.userProvider.setPop3SSLPort(this.userProvider.getImapSSLPort());
    this.userProvider.setPop3UsingSSL(this.userProvider.isImapUsingSSL());
    this.userProvider.setPop3Server(this.userProvider.getImapServer());
    this.userProvider.setDefaultRecvProtocol("POP3");
  }
  
  private void setEnableUserName(ProtocolSettingView paramProtocolSettingView, boolean paramBoolean)
  {
    if (paramProtocolSettingView != null) {
      paramProtocolSettingView.setEnableUserName(paramBoolean);
    }
  }
  
  private void setEnableUserName(boolean paramBoolean)
  {
    setEnableUserName(this.pop3SettingView, paramBoolean);
    setEnableUserName(this.imapSettingView, paramBoolean);
    setEnableUserName(this.exchangeSettingView, paramBoolean);
  }
  
  private void setEnableView(ProtocolSettingView paramProtocolSettingView, boolean paramBoolean)
  {
    if (paramProtocolSettingView != null) {
      paramProtocolSettingView.setEnabled(paramBoolean);
    }
  }
  
  private void showNetworkErrorDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695566)).setMessage(2131721120).addAction(2131696547, new LoginProtocolFragment.9(this))).create().show();
    DataCollector.logException(7, 52, "Event_Error", getString(2131721120), true);
    DataCollector.logException(7, 5, "Event_Error", getString(2131696288), false);
    AddAccountLocalLogUtil.logAddAccountLocalFail(this.userInputEmail, this.mAccountType, 3);
  }
  
  private void validInput(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {}
    Object localObject1;
    for (Object localObject2 = getString(2131689745);; localObject2 = getString(2131689746))
    {
      localObject1 = localObject2;
      if (this.exchangeSettingView != null)
      {
        localObject1 = localObject2;
        if (this.exchangeSettingView.getVisibility() == 0) {
          localObject1 = "";
        }
      }
      if (paramInt2 != 2) {
        break;
      }
      localObject2 = localObject1;
      if (this.exchangeSettingView != null)
      {
        localObject2 = localObject1;
        if (this.exchangeSettingView.getVisibility() == 0) {
          localObject2 = getString(2131689739);
        }
      }
      getTips().showInfo(String.format(getString(2131719955), new Object[] { localObject2 }));
      return;
    }
    if ((paramInt2 == 3) || (paramInt2 == 1))
    {
      getTips().showInfo(String.format(getString(2131719957), new Object[] { localObject1 }));
      return;
    }
    if (paramInt2 == 4)
    {
      getTips().showInfo(2131689712);
      return;
    }
    if (paramInt2 == 6)
    {
      DataCollector.logException(7, 36, "Event_Error", getString(2131689728), true);
      AddAccountLocalLogUtil.logAddAccountLocalFail(this.userInputEmail, this.mAccountType, 1);
      LoginUIHelper.processCustomError(getActivity(), String.format(getString(2131695537), new Object[] { localObject1 }), true, null, null);
      return;
    }
    if (paramInt2 == 5)
    {
      getTips().showInfo(2131689711);
      return;
    }
    getTips().showInfo(2131719952);
  }
  
  protected void handleLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Threads.runOnMainThread(new LoginProtocolFragment.5(this, paramQMNetworkError.desp));
  }
  
  protected void handleLoginProcess(int paramInt, long paramLong) {}
  
  protected void handleLoginQQUseProtocol() {}
  
  protected void handleLoginSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    Threads.runOnMainThread(new LoginProtocolFragment.3(this));
    runOnMainThread(new LoginProtocolFragment.4(this), 500L);
  }
  
  protected void handleQueryProviderError(long paramLong, AccountType paramAccountType) {}
  
  protected void handleQueryProviderSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider) {}
  
  public void initDataSource()
  {
    if (this.profile != null) {}
    for (this.userProvider = MailServiceManager.getInstance().fillProviderWithProfile(this.profile);; this.userProvider = fillDefaultProvider(this.userProvider, AccountType.splitDomain(this.userInputEmail)))
    {
      fillDefaultPort(this.userProvider);
      return;
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initTabView();
    initSettingView();
    initTopBar();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    getActivity().getWindow().setSoftInputMode(16);
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    return this.baseView;
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  protected void reLogin()
  {
    doLogin();
  }
  
  protected void recoverFocus()
  {
    QMUIHelper.setFocusable(this.focusView, true, true, new View[0]);
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  protected void refreshTopBar(boolean paramBoolean)
  {
    boolean bool2 = false;
    this.isLogining = paramBoolean;
    if (!paramBoolean) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      setEnableView(bool1);
      this.topBar.showLoading(paramBoolean);
      View localView = this.topBar.getButtonRight();
      bool1 = bool2;
      if (!paramBoolean) {
        bool1 = true;
      }
      localView.setEnabled(bool1);
      if (!paramBoolean) {
        break;
      }
      this.topBar.setTitle(2131689708);
      return;
    }
    if (this.fromSettingAccount)
    {
      if (this.pageType == 1)
      {
        this.topBar.setTitle(2131719954);
        return;
      }
      if (this.pageType == 2)
      {
        this.topBar.setTitle(2131719956);
        return;
      }
      if (this.pageType == 3)
      {
        this.topBar.setTitle(2131719953);
        return;
      }
      this.topBar.setTitle(2131689747);
      return;
    }
    this.topBar.setTitle(2131689737);
  }
  
  public void render(int paramInt)
  {
    if ((!this.needHandleLoginSuccess) || (!this.account.isLogined())) {
      return;
    }
    replaceFragment(this, new LoginInfoFragment(this.account, this.account.getPwd(), this.mAccountType, false));
    this.needHandleLoginSuccess = false;
  }
  
  public void setEnableView(boolean paramBoolean)
  {
    setEnableView(this.pop3SettingView, paramBoolean);
    setEnableView(this.imapSettingView, paramBoolean);
    setEnableView(this.smtpSettingView, paramBoolean);
    setEnableView(this.exchangeSettingView, paramBoolean);
  }
  
  class UserAccountInput
  {
    public String loginPassword;
    public String receiveUsername;
    public String sendPassword;
    public String sendUserName;
    
    private UserAccountInput() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginProtocolFragment
 * JD-Core Version:    0.7.0.1
 */