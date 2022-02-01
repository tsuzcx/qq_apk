package com.tencent.qqmail.account.fragment;

import alla;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.LoginManager;
import com.tencent.qqmail.account.MailServiceManager;
import com.tencent.qqmail.account.helper.GmailLoginHelper;
import com.tencent.qqmail.account.helper.Helper;
import com.tencent.qqmail.account.helper.HelperFocusChange;
import com.tencent.qqmail.account.helper.LoginUIHelper;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.account.view.LoginVerifyCodeView;
import com.tencent.qqmail.activity.setting.PasswordErrHandling;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.provider.MailServiceProvider;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.register.CheckPhoneWatcher;
import com.tencent.qqmail.register.RegisterWatcher;
import com.tencent.qqmail.register.util.RegisterUIHelper;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.qmnetwork.QMCGIError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkResponse;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.CharacterUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.utilities.validate.ValidateEmail.EmailException;
import com.tencent.qqmail.utilities.validate.ValidateHelper;
import com.tencent.qqmail.view.EmailEditText;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.wetest.WeTestConfig;
import java.util.Iterator;
import moai.core.watcher.Watchers;
import moai.fragment.app.FragmentActivity;
import moai.oss.KvHelper;
import moai.oss.OssHelper;
import mqq.app.AppRuntime;
import oicq.wlogin_sdk.request.WtloginListener;

public class LoginAccountFragment
  extends LoginTaskFragment
{
  private static final String TAG = "LoginAccountFragment";
  private int accountId;
  private ImageView accountRightView;
  private TextView addPopAccountTipsView;
  private QMBaseView baseView;
  private CheckPhoneWatcher checkPhoneWatcher = new LoginAccountFragment.59(this);
  private Button clearAccount;
  private LinearLayout containerView;
  private EmailEditText editTextAccountInput;
  private EditText editTextPasswordInput;
  private TextView generalLoginBtn;
  private int gesPwdSelectRow;
  private Button gmailVerifyBtn;
  private View gmailVerifyWrap;
  private boolean isBizMailQueryProviderErr;
  private boolean isForceInputPassword;
  private boolean isFromMailList;
  private boolean isFromTim;
  private boolean isPhoneNumberLogin;
  private boolean isQQGotoOtherLoginType;
  private View loginAccountWrap;
  private QMNetworkError loginError;
  private View loginPasswordWrap;
  private String loginQQUseProtocolA2;
  private int loginQQUseProtocolTryCount;
  private String loginQQUseProtocolUin;
  private final BroadcastReceiver mDevLockBroadcastReceiver = new LoginAccountFragment.61(this);
  private ImageView passwordRightView;
  private ImageButton passwordView;
  private String phoneNumber;
  private String phoneNumberBindUin;
  private Button quickLoginBtn;
  private View quickLoginWrap;
  private RegisterWatcher registerWatcher = new LoginAccountFragment.58(this);
  private String secondPassword;
  private TextView textViewAccountSelect;
  private QMTopBar topBar;
  private String userInputAccountFromSDK;
  private LoginVerifyCodeView verifyCodeView;
  private String[] wrong126Email = { "@126com", "@126con", "@126com", "126cm", "126cn", "126" };
  private String[] wrong163Email = { "@163com", "@163con", "@163com", "163cm", "163cn", "163" };
  private String[] wrongFormatEmail = { "qq@com", "qq@con", "outlool@com", "126@com", "163@com", "sina@com", "sohu@com" };
  private String[] wrongQQEmail = { "@qqcom", "@qqcon", "@qcom", "qqcm", "qqcn", "qq" };
  private WtloginListener wtLoginListener = new LoginAccountFragment.60(this);
  private QMWtLoginManager wtLoginManager = QMWtLoginManager.getInstance();
  
  @NonNull
  private String autoCorrectEmail(String paramString)
  {
    Object localObject;
    if (StringExtention.isNullOrEmpty(paramString)) {
      localObject = "";
    }
    String str1;
    do
    {
      return localObject;
      str1 = removeInvalidDomFromEmail(paramString).replace(" ", "");
      localObject = str1.replace(".", "").replace("。", "").toLowerCase();
      String[] arrayOfString = this.wrongQQEmail;
      int j = arrayOfString.length;
      int i = 0;
      int k;
      while (i < j)
      {
        if (((String)localObject).endsWith(arrayOfString[i]))
        {
          k = str1.lastIndexOf("@");
          if (k != -1) {
            try
            {
              String str2 = removeInvalidDomFromEmail(AccountType.looseFormatEmail(str1.substring(0, k) + "@qq.com", AccountType.qqmail));
              return str2;
            }
            catch (Exception localException1) {}
          }
        }
        i += 1;
      }
      arrayOfString = this.wrong163Email;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (((String)localObject).endsWith(arrayOfString[i]))
        {
          k = str1.lastIndexOf("@");
          if (k != -1) {
            try
            {
              String str3 = removeInvalidDomFromEmail(AccountType.looseFormatEmail(str1.substring(0, k) + "@163.com", AccountType.mail163));
              return str3;
            }
            catch (Exception localException2) {}
          }
        }
        i += 1;
      }
      arrayOfString = this.wrong126Email;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        if (((String)localObject).endsWith(arrayOfString[i]))
        {
          k = str1.lastIndexOf("@");
          if (k != -1) {
            try
            {
              String str4 = removeInvalidDomFromEmail(AccountType.looseFormatEmail(str1.substring(0, k) + "@126.com", AccountType.mail126));
              return str4;
            }
            catch (Exception localException3) {}
          }
        }
        i += 1;
      }
      arrayOfString = this.wrongFormatEmail;
      j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        String str5 = arrayOfString[i];
        if (((String)localObject).endsWith(str5))
        {
          k = str1.lastIndexOf(str5);
          if (k != -1) {
            try
            {
              str5 = "@" + str5.substring(0, str5.indexOf("@")) + ".com";
              str5 = removeInvalidDomFromEmail(AccountType.looseFormatEmail(str1.substring(0, k) + str5, AccountType.domainOf(str5)));
              return str5;
            }
            catch (Exception localException4) {}
          }
        }
        i += 1;
      }
      localObject = str1;
    } while (paramString.equals(str1));
    OssHelper.autoCorrectEmail(new Object[] { paramString, str1 });
    return str1;
  }
  
  private void btnRightClick()
  {
    if (this.verifyCodeView != null)
    {
      loginVerify();
      return;
    }
    if (this.isLogining)
    {
      abortLogin();
      freeFocus(true, false, false, false);
      if (QMSettingManager.sharedInstance().isEnableSettingDomainConfig()) {
        goToLoginProtocolPage();
      }
      QMLog.log(4, "LoginAccountFragment", "rightClick login for:" + this.userInputEmail);
      return;
    }
    if ((this.fromSettingAccount) && (this.account != null) && (this.account.getAccountState() == 0))
    {
      getActivity().finish();
      return;
    }
    if ((this.fromGesPwdVerify) && (this.account != null) && (!this.account.isQQMail()))
    {
      String str = Aes.decode(this.account.getPwd(), Aes.getPureDeviceToken());
      this.userInputPwd = Helper.trimString(this.editTextPasswordInput);
      if (this.userInputPwd.equals(str))
      {
        LoginManager.shareInstance().triggerLoginSuccess(this.account.getId(), this.currentLoginId, false);
        return;
      }
    }
    if (!QMNetworkUtils.isNetworkConnected())
    {
      showNetworkErrorDialog();
      return;
    }
    freeFocus(false, false, false, false);
    hideKeyBoard();
    this.userInputEmail = this.editTextAccountInput.getText().toString();
    this.userInputPwd = this.editTextPasswordInput.getText().toString();
    if (this.userInputEmail.indexOf("@") < 0)
    {
      this.editTextAccountInput.setText(this.userInputEmail + "@qq.com");
      this.userInputEmail = this.editTextAccountInput.getText().toString();
    }
    if ((this.userInputEmail.endsWith("@qq.com")) || (this.userInputEmail.endsWith("@vip.qq.com")) || (this.userInputEmail.endsWith("@foxmail.com"))) {
      TimMailLoginManager.requestA2AndSkey(this.userInputEmail, this.userInputPwd, new LoginAccountFragment.43(this));
    }
    for (;;)
    {
      Helper.logClickToLogin(this.userInputEmail);
      break;
      login();
    }
  }
  
  private boolean canQuickLogin()
  {
    if (WeTestConfig.autoLoginQQ()) {}
    do
    {
      do
      {
        return false;
      } while (this.fromSchema);
      if ((!this.isVerifyAccount) && (this.wtLoginManager.canQuickLogin()) && (this.mAccountType == AccountType.qqmail)) {
        return true;
      }
    } while (!isShowQuickLogin());
    return true;
  }
  
  private void changeCheckCodePicture()
  {
    if (this.verifyCodeView == null) {
      createVerifyView();
    }
    this.verifyCodeView.setVerifyLoading();
    if ((SharedPreferenceUtil.isWtlogin()) && (this.mAccountType != AccountType.exmail)) {
      this.wtLoginManager.refreshPictureData(this.userInputEmail);
    }
    for (;;)
    {
      this.verifyCodeView.getEditTextVerifyCodeInput().setText("");
      return;
      this.verifyCodeView.getVerifyCode(this.account);
    }
  }
  
  private void confirmExitVerify()
  {
    QMUIDialog localQMUIDialog = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(getString(2131719826))).setMessage(getString(2131719979)).addAction(2131691246, new LoginAccountFragment.47(this))).addAction(2131692813, new LoginAccountFragment.46(this))).create();
    localQMUIDialog.setCancelable(false);
    localQMUIDialog.show();
  }
  
  private String createFakePassword()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = QMSettingManager.sharedInstance().getQQAccountPswLength(this.account.getId());
    if (j != -1)
    {
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append("\\");
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private void createVerifyView()
  {
    this.verifyCodeView = new LoginVerifyCodeView(getActivity());
    this.verifyCodeView.setChangeVerifyImgListener(new LoginAccountFragment.56(this));
    this.baseView.getScrollBodyView().removeView(this.containerView);
    this.baseView.addContentView(this.verifyCodeView);
  }
  
  private void doLogin(MailServiceProvider paramMailServiceProvider)
  {
    if ((paramMailServiceProvider != null) && (!StringExtention.isNullOrEmpty(paramMailServiceProvider.getDefaultRecvProtocol())))
    {
      doLogin(this.userInputEmail, paramMailServiceProvider);
      return;
    }
    QMLog.log(4, "LoginAccountFragment", "go query config:" + this.userInputEmail + "," + AccountType.splitDomain(this.userInputEmail));
    this.currentLoginId = System.currentTimeMillis();
    MailServiceManager.getInstance().getProviderFromWeb(this.currentLoginId, this.userInputEmail, AccountType.splitDomain(this.userInputEmail), this.mAccountType);
  }
  
  private void doLogin(String paramString, MailServiceProvider paramMailServiceProvider)
  {
    String str;
    long l;
    boolean bool2;
    if (paramMailServiceProvider != null)
    {
      QMLog.log(4, "LoginAccountFragment", "dologin userProviderImapServer:" + paramMailServiceProvider.getImapServer() + ", userProvider.getImapPort():" + paramMailServiceProvider.getImapPort() + ", userProvider.getImapSSLPort():" + paramMailServiceProvider.getImapSSLPort() + ", userProviderPop3Server:" + paramMailServiceProvider.getPop3Server() + ", userProvider.getPop3Port()" + paramMailServiceProvider.getPop3Port() + ", userProvider.getPop3SSLPort()" + paramMailServiceProvider.getPop3SSLPort() + ", userProviderSmtpServer:" + paramMailServiceProvider.getSmtpServer() + ", userProvider.getSmtpPort()" + paramMailServiceProvider.getSmtpPort() + ", userProvider.getSmtpSSLPort()" + paramMailServiceProvider.getSmtpSSLPort());
      if ((this.isVerifyAccount) || (this.isBizMailQueryProviderErr) || (this.mAccountType == null) || (Helper.ignoreQueryDomain(this.mAccountType, paramString))) {}
    }
    else
    {
      AccountType localAccountType;
      for (;;)
      {
        try
        {
          str = AccountType.looseFormatEmail(paramString.toLowerCase(), this.mAccountType);
          localAccountType = Helper.checkAccountType(paramMailServiceProvider, this.mAccountType, str);
          QMLog.log(4, "LoginAccountFragment", "loginAccount:" + str + ",loginAccountType:" + localAccountType);
          if (localAccountType != AccountType.qqmail) {
            break label400;
          }
          if (this.userInputPwd.length() != 48) {
            break label396;
          }
          SharedPreferenceUtil.setWtlogin(false);
          paramString = LoginManager.shareInstance();
          l = this.currentLoginId;
          paramMailServiceProvider = this.userInputPwd;
          if (this.mAccountType != AccountType.exmail) {
            break label384;
          }
          bool1 = true;
          if (this.isVerifyAccount) {
            break label390;
          }
          bool2 = true;
          this.account = paramString.verifyQQMailAccount(l, str, paramMailServiceProvider, bool1, bool2);
          return;
        }
        catch (ValidateEmail.EmailException paramString)
        {
          QMLog.log(6, "LoginAccountFragment", "validate email err : " + paramString.toString());
          return;
        }
        QMLog.log(5, "LoginAccountFragment", "dologin userProvider is null: " + paramString + " isVerifyAccount " + this.isVerifyAccount);
        break;
        label384:
        bool1 = false;
        continue;
        label390:
        bool2 = false;
      }
      label396:
      SharedPreferenceUtil.setWtlogin(true);
      label400:
      if ((localAccountType == AccountType.qqmail) && (this.mAccountType != AccountType.qqmail)) {
        this.isQQGotoOtherLoginType = true;
      }
      if ((!WeTestConfig.autoLoginProtocol()) && ((localAccountType == AccountType.qqmail) || (localAccountType == AccountType.exmail)) && (this.mAccountType != AccountType.qqmail) && (this.mAccountType != AccountType.exmail))
      {
        refreshTopBar(false);
        gotoOtherLoginType(String.format(getString(2131689731), new Object[] { getString(localAccountType.getResId()) }), localAccountType);
        QMLog.log(4, "LoginAccountFragment", "qq. gotoOtherLoginType");
        return;
      }
      if ((this.mAccountType != AccountType.exchange) && (this.mAccountType != AccountType.other))
      {
        paramString = MailServiceManager.getInstance().getProviderByDomain(this.mAccountType.getDomain());
        if ((this.mAccountType != AccountType.qqmail) && (this.mAccountType != AccountType.exmail) && (paramMailServiceProvider != null) && (MailServiceManager.getInstance().isQQCompany(paramMailServiceProvider)))
        {
          refreshTopBar(false);
          gotoOtherLoginType(String.format(getString(2131689752), new Object[] { getString(this.mAccountType.getResId()) }), localAccountType);
          QMLog.log(4, "LoginAccountFragment", "not ex and other is qq. gotoOtherLoginType:" + this.mAccountType);
          return;
        }
        if ((paramMailServiceProvider != null) && (paramString != null) && (paramMailServiceProvider.getProviderCompanyEntrys() != null) && (paramString.getProviderCompanyEntrys() != null) && (!MailServiceManager.getInstance().isSameCompany(paramString, paramMailServiceProvider)))
        {
          refreshTopBar(false);
          paramString = localAccountType;
          if (this.mAccountType == AccountType.exmail)
          {
            paramString = localAccountType;
            if (localAccountType == AccountType.exmail) {
              paramString = AccountType.other;
            }
          }
          gotoOtherLoginType(String.format(getString(2131689752), new Object[] { getString(this.mAccountType.getResId()) }), paramString);
          QMLog.log(4, "LoginAccountFragment", "not ex and other. gotoOtherLoginType:" + this.mAccountType);
          return;
        }
        if (localAccountType != AccountType.other) {
          this.mAccountType = localAccountType;
        }
      }
      if ((this.mAccountType == AccountType.exchange) && (paramMailServiceProvider != null)) {
        paramMailServiceProvider.setDefaultRecvProtocol("ActiveSync");
      }
      if ((localAccountType != AccountType.gmail) || (localAccountType == this.mAccountType))
      {
        paramString = str;
        if (paramMailServiceProvider != null)
        {
          paramString = str;
          if (!"google.com".equals(paramMailServiceProvider.getProviderName())) {}
        }
      }
      else
      {
        goGmailLoginType();
        return;
      }
    }
    boolean bool1 = AccountManager.shareInstance().getAccountList().isSyncVirtualAccount(paramString);
    Log.i("LoginAccountFragment", paramString + " is SyncVirtual " + bool1);
    if ((!bool1) && (!this.isVerifyAccount) && (AccountManager.shareInstance().getAccountList().isExistEmail(paramString)))
    {
      AddAccountLocalLogUtil.logAddAccountLocalFail(this.userInputEmail, this.mAccountType, 4);
      DataCollector.logException(7, 3, "Event_Error", "帐号已存在，无需重复登录", true);
      showErrorInfo("帐号已存在，无需重复登录");
      refreshTopBar(false);
      QMLog.log(6, "LoginAccountFragment", "exist account:" + paramString);
      return;
    }
    if ((this.mAccountType == AccountType.qqmail) || (this.mAccountType == AccountType.exmail))
    {
      this.currentLoginId = System.currentTimeMillis();
      if (SharedPreferenceUtil.isWtlogin())
      {
        paramMailServiceProvider = LoginManager.shareInstance();
        l = this.currentLoginId;
        str = this.userInputPwd;
        if (this.mAccountType != AccountType.exmail) {
          break label1109;
        }
        bool1 = true;
        if (this.isVerifyAccount) {
          break label1115;
        }
      }
      label1109:
      label1115:
      for (bool2 = true;; bool2 = false)
      {
        this.account = paramMailServiceProvider.verifyQQMailAccount(l, paramString, str, bool1, bool2);
        DataCollector.logPerformanceBegin("Performance_Login", 0L, "Performance_Login" + this.currentLoginId);
        return;
        bool1 = false;
        break;
      }
    }
    this.currentLoginId = System.currentTimeMillis();
    this.account = LoginManager.shareInstance().verifyMailAccount(this.currentLoginId, paramString, paramString, this.userInputPwd, paramString, this.userInputPwd, paramMailServiceProvider, false, null, null, null, 0L, null, false);
    DataCollector.logPerformanceBegin("Performance_Login", 0L, "Performance_Login" + this.currentLoginId);
  }
  
  private void freeFocus(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    Object localObject2 = null;
    if (!paramBoolean1) {
      localObject2 = getActivity().getCurrentFocus();
    }
    Object localObject1 = localObject2;
    if (paramBoolean1)
    {
      localObject1 = localObject2;
      if (paramBoolean4) {
        localObject1 = this.editTextPasswordInput;
      }
    }
    localObject2 = localObject1;
    if (paramBoolean1)
    {
      localObject2 = localObject1;
      if (paramBoolean3) {
        localObject2 = this.editTextAccountInput;
      }
    }
    QMUIHelper.setFocusable((View)localObject2, paramBoolean1, paramBoolean2, new View[] { this.editTextAccountInput, this.editTextPasswordInput });
  }
  
  private int getTopBarTitleResId(boolean paramBoolean)
  {
    int i = this.mAccountType.getResId();
    if (paramBoolean) {
      i = 2131689708;
    }
    do
    {
      return i;
      if ((this.fromSettingAccount) || (this.fromPwdErrVerify) || (this.fromDeviceLock) || (this.from3GLoginToggleWT)) {
        return 2131689747;
      }
    } while (!this.fromGesPwdVerify);
    return 2131719647;
  }
  
  private void goGmailLoginType()
  {
    replaceFragment(this, GmailLoginHelper.select(this.userInputEmail));
  }
  
  private void goToInfoPage()
  {
    if (!this.account.isLogined()) {
      return;
    }
    QMMailManager.sharedInstance().checkUpdateConfig(true);
    if (this.account.isQQMail())
    {
      Intent localIntent = (Intent)getActivity().getIntent().getParcelableExtra("arg_goto_intent");
      if (localIntent != null)
      {
        Object localObject = LoginManager.shareInstance();
        Account localAccount = this.account;
        int i;
        if (this.userInputPwd == null)
        {
          i = 0;
          ((LoginManager)localObject).initNewAccount(localAccount, i, false);
          localObject = localIntent;
          if (localIntent.getComponent().getClassName().equals(MailFragmentActivity.class.getName())) {
            if (AccountManager.shareInstance().getAccountList().size() <= 1) {
              break label158;
            }
          }
        }
        label158:
        for (localObject = MailFragmentActivity.createIntentToAccountList();; localObject = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId()))
        {
          ((Intent)localObject).putExtra("fromController", "otherapp");
          QMActivityManager.shareInstance().finishAllActivity();
          startActivity((Intent)localObject);
          overridePendingTransition(2130772401, 2130772423);
          return;
          i = this.userInputPwd.length();
          break;
        }
      }
    }
    replaceFragment(this, new LoginInfoFragment(this.account, "", this.mAccountType, this.isMobileQQuickLogin));
    this.needHandleLoginSuccess = false;
  }
  
  private void gotoOtherLoginType(String paramString, AccountType paramAccountType)
  {
    runOnMainThread(new LoginAccountFragment.45(this, paramString, paramAccountType));
  }
  
  private void handleOtherLoginError(QMNetworkError paramQMNetworkError)
  {
    if (paramQMNetworkError != null)
    {
      if (((paramQMNetworkError instanceof QMLoginError)) && (((QMLoginError)paramQMNetworkError).loginErrorType == 5003)) {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695520)).setMessage(paramQMNetworkError.desp).addAction(2131696547, new LoginAccountFragment.15(this))).create().show();
      }
    }
    else {
      return;
    }
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695566)).setMessage(paramQMNetworkError.desp).addAction(2131696547, new LoginAccountFragment.17(this))).addAction(2131689737, new LoginAccountFragment.16(this))).create().show();
  }
  
  private void handleQQBindPhoneError(String paramString)
  {
    QMLog.log(4, "LoginAccountFragment", "handleQQBindPhoneError:" + paramString);
    String str = getString(2131696424);
    DataCollector.logEvent("Event_Register_Mobile_Mail_Bind_Uin_And_Uin_Bind_Another_Mobile");
    LoginAccountFragment.30 local30 = new LoginAccountFragment.30(this);
    LoginAccountFragment.31 local31 = new LoginAccountFragment.31(this);
    RegisterUIHelper.createMessageDialog(getActivity(), str, paramString, getString(2131721544), getString(2131691246), local30, null, local31);
    this.isPhoneNumberLogin = false;
  }
  
  private void handleQQMailLoginError(QMNetworkError paramQMNetworkError)
  {
    if ((paramQMNetworkError instanceof QMLoginError))
    {
      paramQMNetworkError = (QMLoginError)paramQMNetworkError;
      handlerQQLoginError(paramQMNetworkError.loginErrorType, paramQMNetworkError.loginErrorMsg);
      return;
    }
    JSONObject localJSONObject;
    Object localObject;
    if ((paramQMNetworkError instanceof QMCGIError))
    {
      localJSONObject = (JSONObject)JSONReader.parse(((QMCGIError)paramQMNetworkError).response.getResponseString());
      if (localJSONObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append("login cgi err, errorCode:");
        if (localJSONObject.get("app_code") == null)
        {
          localObject = "";
          QMLog.log(6, "LoginAccountFragment", localObject);
          if ((!localJSONObject.containsKey("app_code")) || (!localJSONObject.get("app_code").equals("-500"))) {
            break label173;
          }
          paramQMNetworkError = getString(2131695951);
          if (!localJSONObject.containsKey("errmsg")) {
            break label240;
          }
          paramQMNetworkError = ((String)localJSONObject.get("errmsg")).trim();
        }
      }
    }
    label173:
    label240:
    for (;;)
    {
      handleQQBindPhoneError(paramQMNetworkError);
      return;
      localObject = localJSONObject.get("app_code");
      break;
      LoginUIHelper.processCGIError(null, (QMCGIError)paramQMNetworkError, getActivity(), null, new LoginAccountFragment.18(this));
      return;
      if (paramQMNetworkError != null)
      {
        LoginUIHelper.processNetworkError(getActivity(), null, new LoginAccountFragment.19(this));
        return;
      }
      LoginUIHelper.processUnknownError(getActivity(), getString(2131695520), null, new LoginAccountFragment.20(this));
      return;
    }
  }
  
  private void handlerQQLoginError(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      FragmentActivity localFragmentActivity = getActivity();
      String str = paramString;
      if (StringExtention.isNullOrEmpty(paramString)) {
        str = getString(2131695520);
      }
      LoginUIHelper.processUnknownError(localFragmentActivity, str, null, new LoginAccountFragment.29(this));
      return;
    case -1001: 
    case 8: 
    case 10: 
    case 100: 
    case 10001: 
      LoginUIHelper.processNormalError(paramInt, getActivity(), paramString, null, null, new LoginAccountFragment.21(this));
      return;
    case 1: 
    case 7: 
      if (this.isBizMailQueryProviderErr)
      {
        this.isBizMailQueryProviderErr = false;
        LoginUIHelper.processCustomError(getActivity(), getString(2131695521), false, null, new LoginAccountFragment.22(this));
        return;
      }
      LoginUIHelper.processNormalError(paramInt, getActivity(), paramString, null, null, new LoginAccountFragment.23(this));
      return;
    case 2: 
      toastVerifyErrorAndVerifyInputEmpty();
      changeCheckCodePicture();
      return;
    case 4: 
    case 6: 
      LoginUIHelper.processNormalError(paramInt, getActivity(), paramString, new LoginAccountFragment.24(this), new LoginAccountFragment.25(this), new LoginAccountFragment.26(this));
      return;
    case 3: 
      freeFocus(false, false, false, false);
      showVerifyView();
      return;
    case 11: 
      LoginUIHelper.processCustomError(getActivity(), "帐号已存在，无需重复登录", true, null, new LoginAccountFragment.27(this));
      return;
    }
    LoginUIHelper.processNetworkError(getActivity(), null, new LoginAccountFragment.28(this));
  }
  
  private void initAccountLoginUI()
  {
    if (this.mAccountType != null)
    {
      this.editTextAccountInput.setHint(AccountType.getInputEmailHint(this.mAccountType));
      this.editTextPasswordInput.setHint(AccountType.getInputPasswordHint(this.mAccountType));
    }
    Object localObject = new LoginAccountFragment.32(this);
    LoginAccountFragment.33 local33 = new LoginAccountFragment.33(this);
    Helper.initEditTextAndClearButton(this.editTextAccountInput, this.clearAccount, (HelperFocusChange)localObject, local33);
    if ((this.fromDeviceLock) || (this.fromSettingAccount))
    {
      this.passwordView.setImageResource(2130841401);
      Helper.initEditTextAndClearButton(this.editTextPasswordInput, this.passwordView, null, null);
      if ((this.schemaAccount == null) || (this.schemaAccount.equals(""))) {
        break label300;
      }
      this.editTextAccountInput.setText(this.schemaAccount);
      this.editTextAccountInput.setSelection(this.schemaAccount.length());
    }
    for (;;)
    {
      if (this.fromSettingAccount)
      {
        localObject = createFakePassword();
        this.editTextPasswordInput.setText((CharSequence)localObject);
        this.editTextPasswordInput.setSelection(((String)localObject).length());
      }
      localObject = new LoginAccountFragment.34(this);
      this.editTextAccountInput.addTextChangedListener((TextWatcher)localObject);
      this.editTextPasswordInput.addTextChangedListener((TextWatcher)localObject);
      this.editTextPasswordInput.setOnKeyListener(new LoginAccountFragment.35(this));
      this.textViewAccountSelect = ((TextView)this.containerView.findViewById(2131361937));
      this.textViewAccountSelect.setOnClickListener(new LoginAccountFragment.36(this));
      if (!this.isMobileQQuickLogin)
      {
        if (this.userInputEmail == null) {
          break label314;
        }
        KeyBoardHelper.showSoftInputDelay(this.editTextPasswordInput, 300L);
      }
      return;
      this.passwordView.setImageResource(2130841042);
      Helper.initEditTextAndPasswordStateButton(this.editTextPasswordInput, this.passwordView);
      break;
      label300:
      this.editTextAccountInput.setText(this.userInputEmail);
    }
    label314:
    KeyBoardHelper.showSoftInputDelay(this.editTextAccountInput, 300L);
  }
  
  private void initAddPopAccountView()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
    this.addPopAccountTipsView = new TextView(getActivity());
    this.addPopAccountTipsView.setLayoutParams(localLayoutParams);
    this.addPopAccountTipsView.setPadding(getResources().getDimensionPixelSize(2131299395), getResources().getDimensionPixelSize(2131299394), getResources().getDimensionPixelSize(2131299395), 0);
    this.addPopAccountTipsView.setTextColor(getResources().getColor(2131165860));
    this.addPopAccountTipsView.setText(String.format(getString(2131689716), new Object[] { this.userInputEmail }));
    this.baseView.addContentView(this.addPopAccountTipsView);
  }
  
  private void initGmailVerifyUI()
  {
    this.gmailVerifyBtn.setOnClickListener(new LoginAccountFragment.39(this));
  }
  
  private void initLogic()
  {
    boolean bool2 = false;
    if ((this.mAccountType == AccountType.gmail) && (!this.fromSettingAccount))
    {
      goGmailLoginType();
      return;
    }
    initTopBar();
    initAccountLoginUI();
    initQuickLoginUI();
    initGmailVerifyUI();
    if (this.isFromMailList) {
      initAddPopAccountView();
    }
    label189:
    LoginManager localLoginManager;
    long l;
    String str1;
    String str2;
    String str3;
    if (this.isVerifyAccount)
    {
      if (this.fromGesPwdVerify) {
        toggleGesPwdVerifyView();
      }
    }
    else
    {
      toggleAccountWrap(isShowAccountWrap());
      togglePasswordWrap(isShowPasswordWrap());
      toggleQuickLogin(isShowQuickLogin());
      toggleGmailVerify(isShowGmailVerify());
      if (this.mAccountType == AccountType.qqmail)
      {
        QMLog.log(4, "LoginAccountFragment", "initLogic:" + System.currentTimeMillis() + " seq " + wtloginSeq);
        if (!this.isMobileQQuickLogin) {
          break label319;
        }
        if (this.fromGesPwdVerify)
        {
          wtloginSeq = System.currentTimeMillis();
          this.wtLoginManager.loginByWebviewWithLockedAccount(getActivity(), this.userInputEmail, wtloginSeq);
        }
      }
      if (this.isFromTim)
      {
        this.loginQQUseProtocolA2 = getActivity().getIntent().getStringExtra("arg_a2");
        this.loginQQUseProtocolUin = this.userInputEmail;
        toggleCannotQuickLoginAccountView(this.userInputEmail);
        localLoginManager = LoginManager.shareInstance();
        l = this.currentLoginId;
        str1 = this.loginQQUseProtocolUin;
        str2 = this.loginQQUseProtocolA2;
        str3 = this.loginQQUseProtocolUin;
        if (this.mAccountType != AccountType.exmail) {
          break label458;
        }
      }
    }
    label319:
    label458:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!this.isVerifyAccount) {
        bool2 = true;
      }
      this.account = localLoginManager.verifyQQMailAccountWtlogin(l, str1, str2, "", str3, bool1, bool2);
      getActivity().getWindow().setSoftInputMode(32);
      return;
      toogleVerifyAccountView();
      break;
      if (this.fromGesPwdVerify)
      {
        wtloginSeq = System.currentTimeMillis();
        this.wtLoginManager.loginByWebviewWithLockedAccount(getActivity(), this.userInputEmail, wtloginSeq);
        break label189;
      }
      if (this.isVerifyAccount)
      {
        if (isVerifyQuickLogin()) {
          break label189;
        }
        wtloginSeq = System.currentTimeMillis();
        this.wtLoginManager.loginByWebviewWithLockedAccount(getActivity(), this.userInputEmail, wtloginSeq);
        break label189;
      }
      if (this.fromSchema)
      {
        wtloginSeq = System.currentTimeMillis();
        this.wtLoginManager.loginByWebviewWithAccount(getActivity(), this.schemaAccount, wtloginSeq);
        break label189;
      }
      if (canQuickLogin()) {
        break label189;
      }
      wtloginSeq = System.currentTimeMillis();
      this.wtLoginManager.loginByWebviewWithScaleEnter(getActivity(), wtloginSeq);
      break label189;
    }
  }
  
  private void initQuickLoginUI()
  {
    this.quickLoginBtn.setText(getString(2131721077));
    this.quickLoginBtn.setOnClickListener(new LoginAccountFragment.37(this));
    this.generalLoginBtn.setOnClickListener(new LoginAccountFragment.38(this));
  }
  
  private void initTopBar()
  {
    this.topBar = this.baseView.getTopBar();
    this.topBar.setTitle(2131689705);
    this.topBar.setButtonLeftNormal(2131691246);
    this.topBar.setButtonLeftOnclickListener(new LoginAccountFragment.40(this));
    this.topBar.setButtonRightBlue(2131695506);
    this.topBar.setOnlyButtonRightOnClickListener(new LoginAccountFragment.41(this));
    refreshTopBar(false);
  }
  
  private boolean isShowAccountWrap()
  {
    return !isShowQuickLogin();
  }
  
  private boolean isShowGmailVerify()
  {
    if (this.fromGesPwdVerify) {}
    while (!isVerifyGmail()) {
      return false;
    }
    return true;
  }
  
  private boolean isShowPasswordWrap()
  {
    if (isShowQuickLogin()) {}
    while (isVerifyGmail()) {
      return false;
    }
    return true;
  }
  
  private boolean isShowQuickLogin()
  {
    if (this.isFromTim) {
      return false;
    }
    String str = QMAppInterface.getRuntime().getAccount();
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (((localAccount instanceof QQMailAccount)) && (str.equals(((QQMailAccount)localAccount).getUin()))) {
        return false;
      }
    }
    return !this.isForceInputPassword;
  }
  
  private boolean isVerifyGmail()
  {
    return (this.account != null) && (this.account.isGMail()) && (this.isVerifyAccount);
  }
  
  private boolean isVerifyQuickLogin()
  {
    return (this.account != null) && (this.account.isQuickLogin()) && (this.isVerifyAccount) && (DeviceUtil.isQQInstalled());
  }
  
  private void login()
  {
    if (!validInput())
    {
      refreshTopBar(false);
      freeFocus(true, false, false, false);
      return;
    }
    this.userClickAbort = false;
    Object localObject1 = Helper.trimString(this.editTextAccountInput);
    QMLog.log(4, "LoginAccountFragment", "login() editTextAccountInput:" + this.editTextAccountInput.getText().toString() + ",loginAccount:" + (String)localObject1 + ",bytes().length:" + ((String)localObject1).getBytes().length + ",loginAccount length:" + ((String)localObject1).length());
    Object localObject2 = autoCorrectEmail((String)localObject1);
    if (!((String)localObject2).equals(localObject1))
    {
      QMLog.log(4, "LoginAccountFragment", "autoCorrectEmail " + (String)localObject1 + " to " + (String)localObject2);
      this.editTextAccountInput.setText((CharSequence)localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (((String)localObject1).contains("@"))
      {
        localObject2 = localObject1;
        if (!((String)localObject1).endsWith("@")) {}
      }
      else
      {
        if ((this.mAccountType == AccountType.exchange) || (this.mAccountType == AccountType.other))
        {
          showErrorInputEmailFormatTips((String)localObject1, 4);
          return;
        }
        localObject2 = AccountType.autoFillUserInput(this.mAccountType, (String)localObject1);
      }
      if (!StringExtention.isEmailPattern((String)localObject2))
      {
        QMLog.log(6, "LoginAccountFragment", "error email:" + (String)localObject2);
        if (this.editTextAccountInput != null) {
          this.editTextAccountInput.setTextColor(getResources().getColor(2131167539));
        }
        showErrorInputEmailFormatTips((String)localObject2, 4);
        return;
      }
      this.userInputEmail = ((String)localObject2).toLowerCase();
      if (this.userInputEmail.indexOf("@") < 0)
      {
        this.editTextAccountInput.setText(this.userInputEmail + "@qq.com");
        this.userInputEmail = this.editTextAccountInput.getText().toString();
      }
      this.userInputPwd = Helper.trimString(this.editTextPasswordInput);
      if (this.userInputPwd.getBytes().length > this.userInputPwd.length())
      {
        localObject1 = this.userInputEmail + "-" + ".inputmethod settings:" + alla.getString(getActivity().getContentResolver(), "default_input_method");
        QMLogStream.logWithoutUmaNow(-40032, (String)localObject1, "Event_Error");
        QMLog.log(4, "LoginAccountFragment", "contains fullwidth characters:" + (String)localObject1);
        this.userInputPwd = CharacterUtil.toBJ(this.userInputPwd);
      }
      refreshTopBar(true);
      if ((Helper.ignoreQueryDomain(this.mAccountType, (String)localObject2)) || (this.userInputEmail.endsWith("@qq.com")) || (this.userInputEmail.endsWith("@vip.qq.com")) || (this.userInputEmail.endsWith("@foxmail.com")))
      {
        if (WeTestConfig.autoLoginProtocol())
        {
          doLogin(WeTestConfig.getQQMailServiceProvider());
          return;
        }
        doLogin(this.userInputEmail, null);
        return;
      }
      if (this.isVerifyAccount)
      {
        this.userProvider = MailServiceManager.getInstance().fillProviderWithProfile(this.account.getProfile());
        doLogin(this.userProvider);
        return;
      }
      doLogin(null);
      return;
    }
  }
  
  private void loginNormal()
  {
    toggleQuickLogin(false);
    toggleAccountWrap(true);
    togglePasswordWrap(true);
    this.topBar.getButtonRight().setVisibility(0);
  }
  
  private void loginSecondPasswordInDialog(String paramString)
  {
    ValidateHelper.notNull(this.account);
    this.secondPassword = paramString;
    if (paramString.length() == 0) {
      handlerQQLoginError(4, "");
    }
    do
    {
      return;
      refreshTopBar(true);
    } while (!(this.account instanceof QQMailAccount));
    this.currentLoginId = System.currentTimeMillis();
    ((QQMailAccount)this.account).loginWithSecondPassword(this.currentLoginId, paramString);
  }
  
  private void loginVerify()
  {
    if (Helper.checkEditTextEmpty(this.verifyCodeView.getEditTextVerifyCodeInput(), 0)) {
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131695570), 0).show();
    }
    String str;
    do
    {
      return;
      refreshTopBar(true);
      if ((SharedPreferenceUtil.isWtlogin()) && (this.mAccountType != AccountType.exmail))
      {
        str = Helper.trimString(this.verifyCodeView.getEditTextVerifyCodeInput());
        QMLog.log(4, "LoginAccountFragment", this.userInputEmail + ", verifyCode:" + str + ",isPhoneNumberLogin:" + this.isPhoneNumberLogin + ", isMobileQQuickLogin:" + this.isMobileQQuickLogin);
        this.wtLoginManager.checkPictureAndGetSt(this.userInputEmail, str);
        return;
      }
      ValidateHelper.notNull(this.account);
      str = Helper.trimString(this.verifyCodeView.getEditTextVerifyCodeInput());
    } while (!(this.account instanceof QQMailAccount));
    this.currentLoginId = System.currentTimeMillis();
    ((QQMailAccount)this.account).loginWithVerify(this.currentLoginId, str);
  }
  
  @NonNull
  private String removeInvalidDom(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("...", ".").replace("..", ".");
    int i = 0;
    int k = paramString.length() - 1;
    int j;
    for (;;)
    {
      j = k;
      if (i > k) {
        break;
      }
      if (paramString.charAt(i) != '.')
      {
        j = k;
        if (paramString.charAt(i) != '。') {
          break;
        }
      }
      i += 1;
    }
    while ((j >= i) && ((paramString.charAt(j) == '.') || (paramString.charAt(j) == '。'))) {
      j -= 1;
    }
    if (j >= i) {
      return paramString.substring(i, j + 1);
    }
    return "";
  }
  
  @NonNull
  private String removeInvalidDomFromEmail(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf("@");
    if ((i != -1) && (i != paramString.length() - 1)) {
      return removeInvalidDom(paramString.substring(0, i)) + "@" + removeInvalidDom(paramString.substring(i + 1));
    }
    return removeInvalidDom(paramString);
  }
  
  private void showDiffUinVerify(String paramString)
  {
    QMLog.log(6, "LoginAccountFragment", "usr verify difference uin, email is:" + paramString);
    String str = getString(2131695569);
    if (paramString != null) {}
    for (;;)
    {
      paramString = str.replace("$email$", paramString);
      LoginUIHelper.processCustomError(getActivity(), paramString, true, null, new LoginAccountFragment.49(this));
      return;
      paramString = "";
    }
  }
  
  private void showErrorInfo(String paramString)
  {
    LoginUIHelper.processCustomError(getActivity(), paramString, true, null, new LoginAccountFragment.50(this));
  }
  
  private void showErrorInputEmailFormatTips(String paramString, int paramInt)
  {
    DataCollector.logException(7, 36, "Event_Error", getString(2131689728), true);
    AddAccountLocalLogUtil.logAddAccountLocalFail(paramString, this.mAccountType, 1);
    switch (paramInt)
    {
    }
    for (;;)
    {
      freeFocus(false, false, false, false);
      return;
      LoginUIHelper.processCustomError(getActivity(), getString(2131695536), true, null, new LoginAccountFragment.48(this));
    }
  }
  
  private void showExistAliasAccountError(int paramInt, String paramString)
  {
    QMLog.log(4, "LoginAccountFragment", "showExistAliasAccountError existEmail:" + paramString + ",userInputAccountFromSDK:" + this.userInputAccountFromSDK);
    refreshTopBar(false);
    LoginAccountFragment.53 local53 = new LoginAccountFragment.53(this);
    LoginAccountFragment.54 local54 = new LoginAccountFragment.54(this, paramInt);
    paramString = String.format("当前帐号与%s是相同邮箱帐号，无需重复登录", new Object[] { paramString });
    LoginUIHelper.processQQAccountAliasExitError(getActivity(), paramString, local54, null, local53);
  }
  
  private void showNetworkErrorDialog()
  {
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(getActivity()).setTitle(2131695566)).setMessage(2131721120).addAction(2131696547, new LoginAccountFragment.44(this))).create().show();
    DataCollector.logException(7, 52, "Event_Error", getString(2131721120), true);
    DataCollector.logException(7, 5, "Event_Error", getString(2131696288), false);
    AddAccountLocalLogUtil.logAddAccountLocalFail(this.userInputEmail, this.mAccountType, 3);
  }
  
  private void showVerifyView()
  {
    if (this.verifyCodeView == null) {
      createVerifyView();
    }
    changeCheckCodePicture();
    KeyBoardHelper.showSoftInputDelay(this.verifyCodeView.getEditTextVerifyCodeInput(), 800L);
    this.verifyCodeView.getEditTextVerifyCodeInput().setOnKeyListener(new LoginAccountFragment.57(this));
  }
  
  private void showWtLoginErrorWithURL(String paramString1, String paramString2, String paramString3)
  {
    LoginUIHelper.processWtLoginError(getActivity(), paramString1, paramString2, new LoginAccountFragment.51(this, paramString3), null, new LoginAccountFragment.52(this));
  }
  
  private void toastVerifyErrorAndVerifyInputEmpty()
  {
    if (this.verifyCodeView == null) {
      createVerifyView();
    }
    Threads.runOnMainThread(new LoginAccountFragment.55(this));
  }
  
  private void toggleAccountWrap(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.loginAccountWrap.setVisibility(0);
      return;
    }
    this.loginAccountWrap.setVisibility(8);
  }
  
  private void toggleCannotQuickLoginAccountView(String paramString)
  {
    this.editTextAccountInput.setText(paramString);
    this.editTextAccountInput.setEnabled(false);
    this.editTextAccountInput.setFocusable(false);
    this.editTextAccountInput.setTextColor(getResources().getColor(2131167531));
  }
  
  private void toggleGesPwdVerifyView()
  {
    if (this.fromGesPwdVerifyOvertimes) {
      this.topBar.getButtonLeft().setVisibility(8);
    }
    this.editTextAccountInput.setEnabled(false);
    this.editTextAccountInput.setTextColor(getResources().getColor(2131167531));
    this.editTextPasswordInput.setText("");
    KeyBoardHelper.showSoftInputDelay(this.editTextPasswordInput, 200L);
  }
  
  private void toggleGmailVerify(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.loginAccountWrap.getVisibility() == 0)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.gmailVerifyWrap.getLayoutParams();
        localLayoutParams.setMargins(localLayoutParams.leftMargin, QMUIKit.dpToPx(20), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
        this.gmailVerifyWrap.setLayoutParams(localLayoutParams);
      }
      this.gmailVerifyWrap.setVisibility(0);
      return;
    }
    this.gmailVerifyWrap.setVisibility(8);
  }
  
  private void togglePasswordWrap(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.loginPasswordWrap.setVisibility(0);
      return;
    }
    this.loginPasswordWrap.setVisibility(8);
  }
  
  private void toggleQuickLogin(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      DataCollector.logEvent("Event_Show_Quick_Login");
      this.quickLoginWrap.setVisibility(0);
      if (this.loginAccountWrap.getVisibility() == 0)
      {
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.quickLoginWrap.getLayoutParams();
        localLayoutParams.setMargins(localLayoutParams.leftMargin, QMUIKit.dpToPx(20), localLayoutParams.rightMargin, localLayoutParams.bottomMargin);
        this.quickLoginWrap.setLayoutParams(localLayoutParams);
        if (!isVerifyQuickLogin()) {
          break label105;
        }
        this.quickLoginBtn.setVisibility(0);
        this.generalLoginBtn.setVisibility(8);
      }
      for (;;)
      {
        this.topBar.getButtonRight().setVisibility(8);
        return;
        label105:
        this.quickLoginBtn.setVisibility(0);
        this.generalLoginBtn.setVisibility(0);
      }
    }
    this.quickLoginWrap.setVisibility(8);
  }
  
  private void toogleVerifyAccountView()
  {
    this.editTextAccountInput.setEnabled(false);
    this.editTextAccountInput.setTextColor(getResources().getColor(2131167531));
  }
  
  private boolean validInput()
  {
    if (!Helper.warn(this.editTextAccountInput, getString(2131689710))) {}
    for (int i = 1;; i = 0)
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (!Helper.warn(this.editTextPasswordInput, getString(2131689710))) {
          j = 1;
        }
      }
      if (j != 0)
      {
        DataCollector.logException(7, 35, "Event_Error", getString(2131689710), true);
        AddAccountLocalLogUtil.logAddAccountLocalFail(Helper.trimString(this.editTextAccountInput), this.mAccountType, 2);
        return false;
      }
      return true;
    }
  }
  
  protected void goToLoginProtocolPage()
  {
    int j = 4;
    int i = j;
    if (this.userProvider != null)
    {
      i = j;
      if (!StringExtention.isNullOrEmpty(this.userProvider.getDefaultRecvProtocol()))
      {
        i = j;
        if ("POP3".equals(this.userProvider.getDefaultRecvProtocol())) {
          i = 5;
        }
        if ("ActiveSync".equals(this.userProvider.getDefaultRecvProtocol())) {
          i = 6;
        }
      }
    }
    for (;;)
    {
      replaceFragment(this, new LoginProtocolFragment(this.mAccountType, this.userInputEmail, this.userInputPwd, i, this.userProvider));
      this.needHandleLoginError = false;
      return;
    }
  }
  
  protected void handleLoginError(int paramInt1, long paramLong, QMNetworkError paramQMNetworkError, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.loginQQUseProtocolTryCount = 0;
    QMLog.log(6, "LoginAccountFragment", "login err code:" + paramQMNetworkError.code + ",desp:" + paramQMNetworkError.desp + ",email:" + paramString + ",isQQmailLogin:" + paramBoolean1 + ",isLoginedAccount:" + paramBoolean2 + ",outerProtocol:" + paramInt2 + ",mAccountType:" + this.mAccountType);
    this.loginError = paramQMNetworkError;
    if ((paramQMNetworkError instanceof QMLoginError))
    {
      paramString = (QMLoginError)paramQMNetworkError;
      if ((this.mAccountType != AccountType.qqmail) && (this.mAccountType != AccountType.exmail) && (paramString.loginErrorType != 4) && (paramString.loginErrorType != 5002) && (paramString.loginErrorType != 5001) && (QMNetworkUtils.isNetworkAvailable()))
      {
        QMMailManager localQMMailManager;
        MailServiceProvider localMailServiceProvider;
        String str;
        if (this.userProvider == null)
        {
          paramString = null;
          localQMMailManager = QMMailManager.sharedInstance();
          localMailServiceProvider = this.userProvider;
          str = AccountType.splitDomain(this.userInputEmail);
          if (this.mAccountType != AccountType.exchange) {
            break label313;
          }
        }
        label313:
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          this.userProvider = localQMMailManager.autoFillMailProvider(localMailServiceProvider, str, paramBoolean1);
          if ((!MailServiceManager.getInstance().isEmptyReceive(this.userProvider)) || (paramString == null) || (MailServiceManager.getInstance().isSameMailServiceProvider(paramString, this.userProvider)) || (StringExtention.isNullOrEmpty(this.userProvider.getDefaultRecvProtocol()))) {
            break label319;
          }
          Threads.runOnMainThread(new LoginAccountFragment.11(this));
          return;
          paramString = this.userProvider.deepCopy();
          break;
        }
        label319:
        this.needHandleLoginError = true;
        runOnMainThread(new LoginAccountFragment.12(this, paramQMNetworkError));
        return;
      }
    }
    this.needHandleLoginError = true;
    runOnMainThread(new LoginAccountFragment.13(this, paramQMNetworkError));
  }
  
  protected void handleLoginProcess(int paramInt, long paramLong) {}
  
  protected void handleLoginQQUseProtocol()
  {
    boolean bool2 = false;
    QMLog.log(4, "LoginAccountFragment", "handleLoginQQUseProtocol:" + this.loginQQUseProtocolUin + ",loginQQUseProtocolTryCount:" + this.loginQQUseProtocolTryCount);
    if ((this.loginQQUseProtocolTryCount < 1) && (SharedPreferenceUtil.isWtlogin()))
    {
      KvHelper.eventLoginQqUseProtocolAccount(new double[0]);
      LoginManager localLoginManager = LoginManager.shareInstance();
      long l = this.currentLoginId;
      String str1 = this.loginQQUseProtocolUin + "@qq.com";
      String str2 = this.loginQQUseProtocolA2;
      String str3 = this.loginQQUseProtocolUin;
      if (this.mAccountType == AccountType.exmail) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        if (!this.isVerifyAccount) {
          bool2 = true;
        }
        this.account = localLoginManager.verifyQQMailAccountWtlogin(l, str1, str2, "", str3, bool1, bool2);
        this.loginQQUseProtocolTryCount += 1;
        return;
      }
    }
    LoginUIHelper.processUnknownError(getActivity(), getString(2131695520), null, new LoginAccountFragment.14(this));
  }
  
  protected void handleLoginSuccess(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.loginQQUseProtocolTryCount = 0;
    if (this.account == null)
    {
      QMLog.log(6, "LoginAccountBaseFragment", "AccountServerSetting. login watcher success. acc is null.");
      return;
    }
    QMLog.log(4, "LoginAccountFragment", "currentloginid and return id :" + this.currentLoginId + ", " + paramLong + ",isQQmailLogin:" + paramBoolean);
    if ((!this.isVerifyAccount) && (AccountManager.shareInstance().getAccountList().isExistQQAccount(this.account.getUin())))
    {
      AddAccountLocalLogUtil.logAddAccountLocalFail(this.userInputEmail, this.mAccountType, 5);
      showExistAliasAccountError(this.account.getId(), this.account.getEmail());
      QMLog.log(6, "LoginAccountFragment", "exist account uin:" + this.account.getUin());
      return;
    }
    if (this.isPhoneNumberLogin) {
      DataCollector.logEvent("Event_Login_By_Mobile_And_Bind_Success");
    }
    PasswordErrHandling.setHandling(false);
    Threads.runOnMainThread(new LoginAccountFragment.9(this));
    Threads.runOnMainThread(new LoginAccountFragment.10(this), 300L);
  }
  
  protected void handleQueryProviderError(long paramLong, AccountType paramAccountType)
  {
    QMLog.log(6, "LoginAccountFragment", "query provider error type:" + paramAccountType + ",isLogining:" + this.isLogining);
    if (this.isLogining)
    {
      if (QMNetworkUtils.isNetworkAvailable()) {
        break label69;
      }
      abortLogin();
      Threads.runOnMainThread(new LoginAccountFragment.1(this));
    }
    label69:
    do
    {
      return;
      this.userProvider = MailServiceManager.getInstance().getDefaultProvider(AccountType.splitDomain(this.userInputEmail));
      if (this.userProvider != null)
      {
        Threads.runOnMainThread(new LoginAccountFragment.2(this));
        return;
      }
      if (paramAccountType == AccountType.exchange)
      {
        if (QMNetworkUtils.isNetworkAvailable())
        {
          this.userProvider = QMMailManager.sharedInstance().autoFillMailProvider(this.userProvider, AccountType.splitDomain(this.userInputEmail), true);
          if (MailServiceManager.getInstance().isEmptyReceive(this.userProvider))
          {
            Threads.runOnMainThread(new LoginAccountFragment.3(this));
            return;
          }
        }
        if ((this.userProvider != null) && (this.userProvider.getDefaultRecvProtocol() == null)) {
          this.userProvider.setDefaultRecvProtocol("ActiveSync");
        }
        this.needHandleLoginError = true;
        runOnMainThread(new LoginAccountFragment.4(this));
        return;
      }
      if (paramAccountType == AccountType.other)
      {
        if (QMNetworkUtils.isNetworkAvailable())
        {
          this.userProvider = QMMailManager.sharedInstance().autoFillMailProvider(this.userProvider, AccountType.splitDomain(this.userInputEmail), false);
          if (MailServiceManager.getInstance().isEmptyReceive(this.userProvider))
          {
            Threads.runOnMainThread(new LoginAccountFragment.5(this));
            return;
          }
        }
        this.needHandleLoginError = true;
        runOnMainThread(new LoginAccountFragment.6(this));
        return;
      }
      if ((paramAccountType == AccountType.qqmail) || (paramAccountType == AccountType.mail163) || (paramAccountType == AccountType.mail126) || (paramAccountType == AccountType.gmail) || (paramAccountType == AccountType.outlook))
      {
        runOnMainThread(new LoginAccountFragment.7(this, paramAccountType));
        return;
      }
    } while (paramAccountType != AccountType.exmail);
    this.isBizMailQueryProviderErr = true;
    Threads.runOnMainThread(new LoginAccountFragment.8(this));
  }
  
  protected void handleQueryProviderSuccess(long paramLong, String paramString, MailServiceProvider paramMailServiceProvider)
  {
    QMLog.log(4, "LoginAccountFragment", "query provider success");
    this.isBizMailQueryProviderErr = false;
    if (this.isLogining)
    {
      this.userProvider = paramMailServiceProvider;
      doLogin(paramString, paramMailServiceProvider);
    }
  }
  
  public void initDataSource()
  {
    if ((this.schemaTips != null) && (!this.schemaTips.equals("")))
    {
      if (this.schemaTips.equals("NOTE")) {
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131719214, 0).show();
      }
    }
    else
    {
      this.isForceInputPassword = getActivity().getIntent().getBooleanExtra("force_input_password", false);
      this.isFromTim = getActivity().getIntent().getBooleanExtra("from_tim_enter", false);
      this.isFromMailList = getActivity().getIntent().getBooleanExtra("from_mail_list", false);
      this.userInputEmail = getActivity().getIntent().getStringExtra("arg_email");
      this.accountId = getActivity().getIntent().getIntExtra("arg_account_id", 0);
      this.account = AccountManager.shareInstance().getAccountList().getAccountById(this.accountId);
      if ((this.userInputEmail == null) || (this.userInputEmail.equals(""))) {
        break label310;
      }
    }
    label310:
    for (this.mAccountType = AccountType.domainOf(this.account, this.userInputEmail);; this.mAccountType = AccountType.valueOf(getActivity().getIntent().getStringExtra("arg_account_type")))
    {
      QMLog.log(4, "LoginAccountFragment", "initDataSource mAccountType:" + this.mAccountType);
      this.isMobileQQuickLogin = canQuickLogin();
      this.wtLoginManager.setListener(this.wtLoginListener);
      return;
      if (this.schemaTips.equals("FTN"))
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131719213, 0).show();
        break;
      }
      if (this.schemaTips.equals("BOTTLE"))
      {
        Toast.makeText(QMApplicationContext.sharedInstance(), 2131719212, 0).show();
        break;
      }
      Toast.makeText(QMApplicationContext.sharedInstance(), 2131719211, 0).show();
      break;
    }
  }
  
  public void initDom(View paramView, QMBaseFragment.ViewHolder paramViewHolder, Bundle paramBundle)
  {
    initLogic();
  }
  
  protected QMBaseView initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.baseView = super.initUI(paramViewHolder);
    this.baseView.initScrollView();
    this.baseView.setBackgroundColor(getResources().getColor(2131167681));
    this.containerView = ((LinearLayout)View.inflate(getActivity(), 2131559501, null));
    this.loginAccountWrap = this.containerView.findViewById(2131370890);
    this.editTextAccountInput = ((EmailEditText)this.loginAccountWrap.findViewById(2131361914));
    this.accountRightView = ((ImageView)this.loginAccountWrap.findViewById(2131361936));
    this.clearAccount = ((Button)this.loginAccountWrap.findViewById(2131364639));
    this.loginPasswordWrap = this.containerView.findViewById(2131370892);
    this.editTextPasswordInput = ((EditText)this.loginPasswordWrap.findViewById(2131372891));
    this.passwordRightView = ((ImageView)this.loginPasswordWrap.findViewById(2131372895));
    this.passwordView = ((ImageButton)this.loginPasswordWrap.findViewById(2131372897));
    this.quickLoginWrap = this.containerView.findViewById(2131370893);
    this.quickLoginBtn = ((Button)this.quickLoginWrap.findViewById(2131375392));
    this.generalLoginBtn = ((TextView)this.quickLoginWrap.findViewById(2131367948));
    this.gmailVerifyWrap = this.containerView.findViewById(2131370891);
    this.gmailVerifyBtn = ((Button)this.gmailVerifyWrap.findViewById(2131368072));
    this.baseView.addContentView(this.containerView);
    return this.baseView;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    QMLog.log(4, "LoginAccountFragment", "onActivityResult requestCode:" + paramInt1 + ",resultCode:" + paramInt2 + ",time:" + System.currentTimeMillis() + ",isVerifyAccount:" + this.isVerifyAccount + ",isQQGotoOtherLoginType:" + this.isQQGotoOtherLoginType);
    if ((paramInt1 == 1201) || (paramInt1 == 1202))
    {
      if (-1 != paramInt2) {
        break label261;
      }
      refreshTopBar(true);
      this.userInputAccountFromSDK = this.wtLoginManager.getUserInputFromQuickLoginResultData(paramIntent);
      this.phoneNumber = "";
      this.phoneNumberBindUin = "";
      if (!canQuickLogin()) {
        toggleCannotQuickLoginAccountView(this.userInputAccountFromSDK);
      }
      paramInt1 = this.wtLoginManager.onQuickLoginActivityResultData(paramIntent);
      QMLog.log(4, "LoginAccountFragment", "onQuickLoginActivityResultData ret:" + paramInt1 + ",userInputAccountFromSDK:" + this.userInputAccountFromSDK + ",length:" + this.userInputAccountFromSDK.length());
      KvHelper.detaileventNewWtLoginQqBackResult(paramInt1 + "_end", new double[0]);
      if (-1001 != paramInt1)
      {
        showErrorInfo(getString(2131695511));
        KvHelper.eventNewWtLoginQqBackFail(new double[0]);
      }
    }
    else
    {
      return;
    }
    KvHelper.eventNewWtLoginQqBackSuccess(new double[0]);
    return;
    label261:
    refreshTopBar(false);
    if (this.isQQGotoOtherLoginType) {
      onBackPressed();
    }
    for (;;)
    {
      this.quickLoginBtn.setEnabled(true);
      this.generalLoginBtn.setEnabled(true);
      return;
      if (this.isVerifyAccount)
      {
        if ((this.fromGesPwdVerify) || (!isVerifyQuickLogin())) {
          onBackPressed();
        }
      }
      else if (!canQuickLogin()) {
        onBackPressed();
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.fromGesPwdVerifyOvertimes) {
      getActivity().moveTaskToBack(true);
    }
    if ((this.fromDeviceLock) || (this.fromPwdErrVerify)) {
      PasswordErrHandling.setHandling(false);
    }
    if ((this.fromPwdErrVerify) && (!this.verifySuccess))
    {
      confirmExitVerify();
      return;
    }
    abortLogin();
    super.onBackPressed();
  }
  
  public void onBindEvent(boolean paramBoolean)
  {
    Watchers.bind(this.registerWatcher, paramBoolean);
    Watchers.bind(this.checkPhoneWatcher, paramBoolean);
    registerDevLockReceiver(getActivity(), paramBoolean);
  }
  
  public void onRelease() {}
  
  protected void reLogin()
  {
    if ((this.userInputEmail.endsWith("@qq.com")) || (this.userInputEmail.endsWith("@vip.qq.com")) || (this.userInputEmail.endsWith("@foxmail.com")))
    {
      wtloginSeq = System.currentTimeMillis();
      this.wtLoginManager.loginByWebviewWithLockedAccount(getActivity(), this.userInputEmail, wtloginSeq);
      return;
    }
    doLogin(this.userProvider);
  }
  
  protected void recoverFocus()
  {
    freeFocus(true, true, false, true);
  }
  
  public int refreshData()
  {
    return 0;
  }
  
  protected void refreshTopBar(boolean paramBoolean)
  {
    Threads.runOnMainThread(new LoginAccountFragment.42(this, paramBoolean));
  }
  
  public void registerDevLockReceiver(Context paramContext, boolean paramBoolean)
  {
    IntentFilter localIntentFilter = new IntentFilter("com.tencent.androidqqmail.tim.devlock");
    if (paramBoolean)
    {
      paramContext.registerReceiver(this.mDevLockBroadcastReceiver, localIntentFilter);
      return;
    }
    paramContext.unregisterReceiver(this.mDevLockBroadcastReceiver);
  }
  
  public void render(int paramInt)
  {
    if (WeTestConfig.autoLoginProtocol())
    {
      this.editTextAccountInput.setText(WeTestConfig.getInputEmail());
      this.editTextPasswordInput.setText(WeTestConfig.getInputPwd());
      login();
    }
    if (this.needHandleLoginSuccess) {
      goToInfoPage();
    }
    while ((!this.needHandleLoginError) || ((this.mAccountType != AccountType.other) && (this.mAccountType != AccountType.exchange))) {
      return;
    }
    handleOtherLoginError(this.loginError);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.fragment.LoginAccountFragment
 * JD-Core Version:    0.7.0.1
 */