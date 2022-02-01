package com.tencent.qqmail.launcher.third;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.CrashComposeCheck;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.setting.SettingActivity;
import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.activity.setting.SettingNoteActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

public class LaunchShortCutActivity
  extends ThirdLauncherActivity
{
  private static final boolean CLEAR_TASK = false;
  private static final String SHORTCUT_TYPE = "SHORTCUT_TYPE";
  private static final int SHORTCUT_TYPE_COMPOSE_MAIL = 100;
  private static final int SHORTCUT_TYPE_COMPOSE_NOTE = 101;
  private static final int SHORTCUT_TYPE_ENTER_CALENDAR = 103;
  private static final int SHORTCUT_TYPE_SCAN = 102;
  private static final int SHORTCUT_TYPE_SETTING = 104;
  public static final String TAG = "ShortCutRouteActivity";
  
  private boolean composing()
  {
    return (QMActivityManager.shareInstance().existPage(ComposeMailActivity.class)) || (QMActivityManager.shareInstance().existPage(ComposeNoteActivity.class));
  }
  
  private boolean crashed()
  {
    Intent localIntent = CrashComposeCheck.checkCrashComposeMail(this);
    if (localIntent == null) {
      return false;
    }
    startActivity(localIntent);
    return true;
  }
  
  public static Intent createIntentForCalendar(Context paramContext)
  {
    paramContext = new Intent(paramContext, LaunchShortCutActivity.class);
    paramContext.putExtra("SHORTCUT_TYPE", 103);
    paramContext.setFlags(intentFlag());
    return paramContext;
  }
  
  public static Intent createIntentForComposeMail(Context paramContext)
  {
    paramContext = new Intent(paramContext, LaunchShortCutActivity.class);
    paramContext.putExtra("SHORTCUT_TYPE", 100);
    paramContext.setFlags(intentFlag());
    return paramContext;
  }
  
  public static Intent createIntentForComposeNote(Context paramContext)
  {
    paramContext = new Intent(paramContext, LaunchShortCutActivity.class);
    paramContext.putExtra("SHORTCUT_TYPE", 101);
    paramContext.setFlags(intentFlag());
    return paramContext;
  }
  
  public static Intent createIntentForScan(Context paramContext)
  {
    paramContext = new Intent(paramContext, LaunchShortCutActivity.class);
    paramContext.putExtra("SHORTCUT_TYPE", 102);
    paramContext.setFlags(intentFlag());
    return paramContext;
  }
  
  public static Intent createIntentForSetting(Context paramContext)
  {
    paramContext = new Intent(paramContext, LaunchShortCutActivity.class);
    paramContext.putExtra("SHORTCUT_TYPE", 104);
    paramContext.setFlags(intentFlag());
    return paramContext;
  }
  
  private boolean hasAccount()
  {
    return AccountManager.shareInstance().getAccountList().hasAccounts();
  }
  
  private boolean hasQQAccount()
  {
    return AccountManager.shareInstance().getAccountList().hasQQMailAccounts();
  }
  
  private static int intentFlag()
  {
    return 268435456;
  }
  
  private boolean isEnableCalendar()
  {
    return QMSettingManager.sharedInstance().getCalendarDisplay();
  }
  
  private boolean isEnableNote()
  {
    return QMSettingManager.sharedInstance().getNoteDisplay();
  }
  
  private void routeToCalendar()
  {
    startActivity(CalendarFragmentActivity.createIntent());
  }
  
  private void routeToCalendarSetting()
  {
    startActivity(new Intent(this, SettingCalendarActivity.class));
  }
  
  private void routeToComposeMail()
  {
    startActivity(new Intent(this, ComposeMailActivity.class));
  }
  
  private void routeToComposeNote()
  {
    startActivity(new Intent(this, ComposeNoteActivity.class));
  }
  
  private void routeToLogin(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Intent localIntent = LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name());; localIntent = AccountTypeListActivity.createIntent(true))
    {
      startActivity(localIntent);
      return;
    }
  }
  
  private void routeToMaillist()
  {
    Intent localIntent = new Intent(this, MailFragmentActivity.class);
    localIntent.setData(getIntent().getData());
    startActivity(localIntent);
  }
  
  private void routeToNoteSetting()
  {
    startActivity(new Intent(this, SettingNoteActivity.class));
  }
  
  private void routeToScan() {}
  
  private void routeToSearch()
  {
    Intent localIntent = new Intent(this, MailFragmentActivity.class);
    localIntent.setData(getIntent().getData());
    startActivity(localIntent);
  }
  
  private void routeToSetting()
  {
    Intent localIntent = new Intent(this, SettingActivity.class);
    if (QMActivityManager.shareInstance().existPage(SettingActivity.class)) {
      localIntent.addFlags(67108864);
    }
    startActivity(localIntent);
  }
  
  protected void route()
  {
    int i = -1;
    QMLog.log(4, "ShortCutRouteActivity", "onCreate");
    if (composing())
    {
      QMLog.log(4, "ShortCutRouteActivity", "Composing");
      finish();
      return;
    }
    if (crashed())
    {
      QMLog.log(4, "ShortCutRouteActivity", "You have crash-event");
      finish();
      return;
    }
    Object localObject = getIntent().getData();
    if (localObject != null)
    {
      String str = ((Uri)localObject).getScheme();
      localObject = ((Uri)localObject).getPath();
      QMLog.log(4, "ShortCutRouteActivity", "scheme = " + str + "path = " + (String)localObject);
      if ("qqmail_3dtouch".equals(str))
      {
        if ("/compose_note".equals(localObject))
        {
          if (!hasQQAccount())
          {
            routeToLogin(true);
            finish();
          }
        }
        else if (!hasAccount())
        {
          routeToLogin(false);
          finish();
          return;
        }
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          }
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        i = getIntent().getIntExtra("SHORTCUT_TYPE", -1);
        if (hasAccount()) {
          break label368;
        }
        routeToLogin(false);
        finish();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "ShortCutRouteActivity", "getIntExtra fail");
        finish();
        return;
      }
      if (!((String)localObject).equals("/open_search")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject).equals("/open_inbox")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject).equals("/compose_note")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject).equals("/compose_mail")) {
        break;
      }
      i = 3;
      break;
      routeToSearch();
      continue;
      routeToMaillist();
      continue;
      routeToComposeNote();
      continue;
      routeToComposeMail();
    }
    label368:
    if (i == 101)
    {
      if (!hasQQAccount())
      {
        routeToLogin(true);
        finish();
        return;
      }
      if (!isEnableNote())
      {
        routeToNoteSetting();
        finish();
      }
    }
    else if ((i == 103) && (!isEnableCalendar()))
    {
      routeToCalendarSetting();
      finish();
      return;
    }
    finish();
    switch (i)
    {
    default: 
      return;
    case 100: 
      routeToComposeMail();
      return;
    case 101: 
      routeToComposeNote();
      return;
    case 103: 
      routeToCalendar();
      return;
    case 102: 
      routeToScan();
      return;
    }
    routeToSetting();
  }
  
  public void startActivity(Intent paramIntent)
  {
    super.startActivity(paramIntent);
    overridePendingTransition(0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchShortCutActivity
 * JD-Core Version:    0.7.0.1
 */