package com.tencent.qqmail.launcher.base;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.compose.LocalDraftUtils;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.launcher.desktop.LauncherActivity;
import com.tencent.qqmail.model.uidomain.ComposeMailUI;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import org.apache.commons.lang3.StringUtils;

public class LauncherUtils
{
  public static int APP_LAUCHER_TYPE = 0;
  public static boolean IS_CLICK_SHORTCUT = false;
  public static int LAUCHER_FROM_CALENDAR = 0;
  public static int LAUCHER_FROM_LOGIN_INVALID = 5;
  public static int LAUCHER_FROM_MAIN = 1;
  public static int LAUCHER_FROM_NOTE = 2;
  public static int LAUCHER_FROM_PASSWARD_ERROR_PUSH = 0;
  private static final String TAG = "LauncherUtils";
  public static boolean wakeup = false;
  
  static
  {
    LAUCHER_FROM_CALENDAR = 3;
    LAUCHER_FROM_PASSWARD_ERROR_PUSH = 4;
  }
  
  public static boolean actionTypeIsViewOrEdit(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      paramIntent = paramIntent.getAction();
      if (!"android.intent.action.VIEW".equals(paramIntent))
      {
        bool1 = bool2;
        if (!"android.intent.action.EDIT".equals(paramIntent)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean goTo(BaseActivity paramBaseActivity, Class<?> paramClass)
  {
    try
    {
      if (ignoreShare(paramBaseActivity)) {
        return false;
      }
      Object localObject = ComposeNoteActivity.class.getName();
      String str1 = FtnListActivity.class.getName();
      String str2 = paramClass.getName();
      if (((StringUtils.equals((CharSequence)localObject, str2)) || (StringUtils.equals(str1, str2))) && (AccountManager.shareInstance().getAccountList().getDefaultNoteAccount() == null))
      {
        SharedPreferenceUtil.setShownWelcomePage(true);
        localObject = paramBaseActivity.getIntent();
        ((Intent)localObject).setClass(paramBaseActivity, paramClass);
        ((Intent)localObject).putExtra("fromController", "otherapp");
        paramBaseActivity.startActivity(LoginFragmentActivity.createIntentForIntent(AccountType.qqmail.name(), (Intent)localObject));
        Toast.makeText(QMApplicationContext.sharedInstance(), paramBaseActivity.getString(2131689810), 1).show();
        return true;
      }
      if (AccountManager.shareInstance().getAccountList().size() == 0)
      {
        SharedPreferenceUtil.setShownWelcomePage(true);
        localObject = paramBaseActivity.getIntent();
        ((Intent)localObject).setClass(paramBaseActivity, paramClass);
        ((Intent)localObject).putExtra("fromController", "otherapp");
        paramBaseActivity.startActivity(AccountTypeListActivity.createIntent((Intent)localObject));
        return true;
      }
      if (paramBaseActivity.canEnterComposeMailActivity())
      {
        if (paramClass == MailFragmentActivity.class) {
          if (AccountManager.shareInstance().getAccountList().size() > 1)
          {
            paramClass = MailFragmentActivity.createIntentToAccountList();
            paramClass.putExtras(paramBaseActivity.getIntent());
          }
        }
        for (;;)
        {
          paramClass.putExtra("fromController", "otherapp");
          paramBaseActivity.startActivity(paramClass);
          return true;
          paramClass = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
          break;
          localObject = paramBaseActivity.getIntent();
          ((Intent)localObject).setClass(paramBaseActivity, paramClass);
          paramClass = (Class<?>)localObject;
        }
      }
      return false;
    }
    catch (Exception paramBaseActivity)
    {
      QMLog.log(6, "LauncherUtils", paramBaseActivity.getMessage());
    }
  }
  
  public static void gotoMainPage(Context paramContext)
  {
    Intent localIntent;
    if (AccountManager.shareInstance().getAccountList().size() <= 0) {
      localIntent = AccountTypeListActivity.createIntent();
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      if (AccountManager.shareInstance().getAccountList().size() == 1) {
        localIntent = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      } else {
        localIntent = MailFragmentActivity.createIntentToAccountList();
      }
    }
  }
  
  public static void gotoQQMailMainPage(Context paramContext)
  {
    Intent localIntent;
    if (AccountManager.shareInstance().getAccountList().size() <= 0) {
      localIntent = LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name());
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      if (AccountManager.shareInstance().getAccountList().size() == 1) {
        localIntent = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      } else {
        localIntent = MailFragmentActivity.createIntentToAccountList();
      }
    }
  }
  
  public static boolean ignoreShare(BaseActivity paramBaseActivity)
  {
    ComposeMailUI localComposeMailUI = LocalDraftUtils.readLocalDraft();
    Intent localIntent = null;
    if (localComposeMailUI != null)
    {
      if (localComposeMailUI.getType() != ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_NOTE) {
        break label50;
      }
      localIntent = new Intent(paramBaseActivity, ComposeNoteActivity.class);
      QMActivityManager.shareInstance().finishTopActivityInclusive(ComposeNoteActivity.class);
    }
    while (localIntent != null)
    {
      paramBaseActivity.startActivity(localIntent);
      return true;
      label50:
      localIntent = new Intent(paramBaseActivity, ComposeMailActivity.class);
      QMActivityManager.shareInstance().finishTopActivityInclusive(ComposeMailActivity.class);
    }
    return false;
  }
  
  public static boolean isFromLauncher(Intent paramIntent)
  {
    return "android.intent.action.MAIN".equals(paramIntent.getAction());
  }
  
  public static boolean isFromQQ(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getData() == null)) {}
    do
    {
      return false;
      paramIntent = paramIntent.getData().getPath();
    } while ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("QQfile_recv")));
    return true;
  }
  
  public static boolean isFromWeChat(Intent paramIntent)
  {
    if ((paramIntent == null) || (paramIntent.getData() == null)) {}
    do
    {
      return false;
      paramIntent = paramIntent.getData().getPath();
    } while ((TextUtils.isEmpty(paramIntent)) || (!paramIntent.contains("MicroMsg")));
    return true;
  }
  
  public static void launcherAsPlugin(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, LauncherActivity.class);
    wakeup = true;
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.base.LauncherUtils
 * JD-Core Version:    0.7.0.1
 */