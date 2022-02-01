package com.tencent.qqmail.account.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.view.QMTopBar;

public class AccountTypeListActivity
  extends BaseActivity
{
  private static final String ARG_FROM = "arg_from";
  private static final String ARG_GOTO_INTENT = "arg_goto_intent";
  private static final String ARG_NO_ACCOUNT_EXIST = "arg_no_account_exist";
  public static final String EXTRA_FROM_MAIL = "extra_from_mail";
  public static final String EXTRA_FROM_NOTE_SHORTCUT = "extra_from_note_shortcut";
  public static final String EXTRA_FROM_SCHEMA = "extra_from_schema";
  public static final String EXTRA_FROM_SETTING = "extra_from_setting";
  public static final String EXTRA_FROM_SYSTEM_ADD_ACCOUNT = "extra_from_system_add_account";
  public static final String TAG = "AccountTypeListActivity";
  private int animationType;
  private String mFrom;
  private QMTopBar topBar;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), AccountTypeListActivity.class);
  }
  
  public static Intent createIntent(Intent paramIntent)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_goto_intent", paramIntent);
    return localIntent;
  }
  
  public static Intent createIntent(String paramString)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_from", paramString);
    return localIntent;
  }
  
  public static Intent createIntent(boolean paramBoolean)
  {
    Intent localIntent = createIntent();
    localIntent.putExtra("arg_no_account_exist", paramBoolean);
    return localIntent;
  }
  
  private void gotoAddMailInfo(String paramString)
  {
    if (paramString.equals(AccountType.gmail.name())) {}
    for (paramString = LoginFragmentActivity.createIntentForGmail();; paramString = LoginFragmentActivity.createIntentToAddAccount(paramString))
    {
      if (getIntent().getParcelableExtra("arg_goto_intent") != null) {
        paramString.putExtra("arg_goto_intent", getIntent().getParcelableExtra("arg_goto_intent"));
      }
      startActivity(paramString);
      return;
    }
  }
  
  public void finish()
  {
    super.finish();
    Log.i("AccountTypeListActivity", "finish getActivitySize = " + QMActivityManager.shareInstance().getActivitySize());
    int i;
    if ((this.mFrom != null) && (this.mFrom.equals("extra_from_schema")) && (QMActivityManager.shareInstance().getActivitySize() <= 1))
    {
      i = AccountManager.shareInstance().getAccountList().size();
      if (i > 1)
      {
        startActivity(MailFragmentActivity.createIntentToAccountList());
        overridePendingTransition(0, 0);
      }
    }
    for (;;)
    {
      if ((this.mFrom != null) && (this.mFrom.equals("extra_from_system_add_account"))) {
        overridePendingTransition(0, 0);
      }
      return;
      if (i == 1)
      {
        startActivity(MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId()));
        break;
      }
      QMWatcherCenter.triggerAppGotoBackground();
      break;
      QMWatcherCenter.triggerAppGotoBackground();
    }
  }
  
  protected void initDom()
  {
    Log.i("AccountTypeListActivity", "initDom");
    this.animationType = getIntent().getIntExtra("animationType", 0);
    if (this.animationType == 1)
    {
      overridePendingTransition(2130772401, 2130772430);
      setContentView(2131558469);
      AccountTypeListActivity.1 local1 = new AccountTypeListActivity.1(this);
      findViewById(2131362187).setOnClickListener(local1);
      findViewById(2131362181).setOnClickListener(local1);
      findViewById(2131362178).setOnClickListener(local1);
      findViewById(2131362179).setOnClickListener(local1);
      findViewById(2131362180).setOnClickListener(local1);
      findViewById(2131362182).setOnClickListener(local1);
      findViewById(2131362185).setOnClickListener(local1);
      findViewById(2131362184).setOnClickListener(local1);
      if (!QMSettingManager.sharedInstance().isShowGmailBackground()) {
        break label345;
      }
      findViewById(2131370885).setVisibility(0);
      QMLog.log(2, "AccountTypeListActivity", "Account type list show gmail background");
      label160:
      this.topBar = ((QMTopBar)findViewById(2131374722));
      this.topBar.setTitle(2131689749);
      this.mFrom = getIntent().getStringExtra("arg_from");
      if (this.mFrom == null) {
        break label418;
      }
      if (("extra_from_system_add_account".equals(this.mFrom)) && (!this.mFrom.equals("extra_from_schema"))) {
        break label389;
      }
      if (AccountManager.shareInstance().getAccountList().size() <= 0) {
        break label368;
      }
      this.topBar.setButtonLeftIcon(2130841088);
      this.topBar.setButtonLeftOnclickListener(new AccountTypeListActivity.2(this));
      label265:
      if (this.mFrom.equals("extra_from_note_shortcut")) {
        Toast.makeText(getApplicationContext(), getString(2131689760), 0).show();
      }
    }
    for (;;)
    {
      DataCollector.logDetailEvent("DetailEvent_User_Behavior", 0L, 0L, "chooseentrance");
      QMLogStream.logWithoutUmaNow(-40025, "chooseentrance", "Event_Error");
      QMLogStream.submitLog(false, true);
      return;
      if (this.animationType != 2) {
        break;
      }
      overridePendingTransition(2130772422, 2130772419);
      break;
      label345:
      findViewById(2131370885).setVisibility(8);
      QMLog.log(2, "AccountTypeListActivity", "Account type list hide gmail background");
      break label160;
      label368:
      Toast.makeText(getApplicationContext(), getString(2131719210), 0).show();
      break label265;
      label389:
      this.topBar.setButtonLeftBack();
      this.topBar.getButtonLeft().setOnClickListener(new AccountTypeListActivity.3(this));
      break label265;
      label418:
      this.topBar.setButtonLeftBack();
      this.topBar.getButtonLeft().setOnClickListener(new AccountTypeListActivity.4(this));
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initDom();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.activity.AccountTypeListActivity
 * JD-Core Version:    0.7.0.1
 */