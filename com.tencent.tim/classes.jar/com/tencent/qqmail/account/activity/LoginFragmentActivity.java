package com.tencent.qqmail.account.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.fragment.LoginAccountFragment;
import com.tencent.qqmail.account.fragment.LoginProtocolFragment;
import com.tencent.qqmail.account.helper.GmailLoginHelper;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.StatusBarUtil;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class LoginFragmentActivity
  extends BaseFragmentActivity
{
  public static final String ARG_A2 = "arg_a2";
  public static final String ARG_ACCOUNT_ID = "arg_account_id";
  public static final String ARG_ACCOUNT_TYPE = "arg_account_type";
  public static final String ARG_EMAIL = "arg_email";
  public static final String ARG_FROM = "arg_from";
  public static final String ARG_GOTO_INTENT = "arg_goto_intent";
  private static final String ARG_PLACE = "arg_place";
  public static final String ARG_SKEY = "arg_skey";
  public static final String ARG_SMTP_SERVER_ERROR = "arg_smtp_server_error";
  public static final String FORCE_INPUT_PASSWORD = "force_input_password";
  public static final String FROM_3G_LOGIN_TOGGLE_WT = "from_3g_login_toggle_wt";
  public static final String FROM_DEV_LOCK = "from_dev_lock";
  public static final String FROM_GES_PWD_VERIFY = "from_ges_pwd_verify";
  public static final String FROM_GES_PWD_VERIFY_OVERTIMES = "from_ges_pwd_verify_overtimes";
  public static final String FROM_LAUNCH_COMPOSE = "from_launch_compose";
  public static final String FROM_MAIL_LIST = "from_mail_list";
  public static final String FROM_PSW_ERR_VERIFY = "from_psw_err_verify";
  public static final String FROM_REGISTER = "from_register";
  public static final String FROM_SCHEMA = "from_schema";
  public static final String FROM_SEND_MAIL = "from_send_mail";
  public static final String FROM_SETTING_ACCOUNT = "from_setting_account";
  public static final String FROM_SETTING_PLUGIN = "from_setting_verify";
  public static final String FROM_TIM_ENTER = "from_tim_enter";
  private static final int PLACE_ACCOUNT = 0;
  private static final int PLACE_GMAIL = 1;
  private static final int PLACE_PROTOCOL = 3;
  public static final String PLUG_IN_TYPE = "plug_in_type";
  public static final String SCHEMA_ACCOUNT = "schema_account";
  public static final String SCHEMA_TIPS = "schema_tips";
  public static final String TAG = "LoginFragmentActivity";
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), LoginFragmentActivity.class);
  }
  
  public static Intent createIntentFor3GLogin(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LoginFragmentActivity.class);
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("from_3g_login_toggle_wt", true);
    return localIntent;
  }
  
  public static Intent createIntentForA2AddAccount(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString1);
    localIntent.putExtra("arg_email", paramString2);
    localIntent.putExtra("from_tim_enter", true);
    localIntent.putExtra("arg_a2", paramString3);
    localIntent.putExtra("arg_skey", paramString4);
    return localIntent;
  }
  
  public static Intent createIntentForAccountSetting(int paramInt, String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("from_setting_account", true);
    return localIntent;
  }
  
  public static Intent createIntentForDeviceLock(int paramInt, String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("from_dev_lock", true);
    return localIntent;
  }
  
  public static Intent createIntentForGesVerify(int paramInt, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LoginFragmentActivity.class);
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("from_ges_pwd_verify", true);
    localIntent.putExtra("from_ges_pwd_verify_overtimes", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentForGmail()
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 1);
    return localIntent;
  }
  
  public static Intent createIntentForIntent(String paramString, Intent paramIntent)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString);
    localIntent.putExtra("arg_goto_intent", paramIntent);
    return localIntent;
  }
  
  public static Intent createIntentForMailList(String paramString1, String paramString2)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString1);
    localIntent.putExtra("arg_email", paramString2);
    localIntent.putExtra("from_mail_list", true);
    return localIntent;
  }
  
  public static Intent createIntentForSettingProtocol(int paramInt, boolean paramBoolean)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 3);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("from_setting_account", true);
    localIntent.putExtra("from_psw_err_verify", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentForSmtpError(int paramInt, boolean paramBoolean)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 3);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("from_setting_account", true);
    localIntent.putExtra("from_send_mail", true);
    localIntent.putExtra("arg_smtp_server_error", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentForVerifyPswError(int paramInt, String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_id", paramInt);
    localIntent.putExtra("arg_email", paramString);
    localIntent.putExtra("from_psw_err_verify", true);
    return localIntent;
  }
  
  public static Intent createIntentFromSchema(String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString3);
    localIntent.putExtra("from_schema", true);
    localIntent.putExtra("schema_tips", paramString1);
    localIntent.putExtra("schema_account", paramString2);
    return localIntent;
  }
  
  public static Intent createIntentToAddAccount(String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToAddAccount(String paramString1, String paramString2)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", paramString1);
    localIntent.putExtra("arg_email", paramString2);
    localIntent.putExtra("force_input_password", true);
    return localIntent;
  }
  
  public static Intent createIntentToAddPlugInAccount(String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_place", 0);
    localIntent.putExtra("arg_account_type", AccountType.qqmail.name());
    localIntent.putExtra("from_setting_verify", true);
    localIntent.putExtra("plug_in_type", paramString);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    int i = getIntent().getIntExtra("arg_place", 0);
    int j = getIntent().getIntExtra("arg_account_id", 0);
    Object localObject;
    switch (i)
    {
    case 2: 
    default: 
      localObject = new LoginAccountFragment();
    }
    for (;;)
    {
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
      localObject = new LoginAccountFragment();
      continue;
      localObject = GmailLoginHelper.select();
      continue;
      localObject = new LoginProtocolFragment(j);
    }
  }
  
  public int getContextViewId()
  {
    return 2131367566;
  }
  
  public int getHistorySize()
  {
    return QMActivityManager.shareInstance().getActivitySize();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    getSupportFragmentManager().findFragmentById(2131367566).onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    int i = getIntent().getIntExtra("animationType", 0);
    if (BrandUtil.isHuawei()) {
      if (i == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
    for (;;)
    {
      initializeFragment();
      StatusBarUtil.immerseWhite(this);
      return;
      overridePendingTransition(2130772401, 2130772430);
      continue;
      if (i == 1) {
        overridePendingTransition(2130772401, 2130772430);
      } else if (i == 2) {
        overridePendingTransition(2130772422, 2130772419);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.LoginFragmentActivity
 * JD-Core Version:    0.7.0.1
 */