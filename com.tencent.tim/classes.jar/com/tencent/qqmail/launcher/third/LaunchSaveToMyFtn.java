package com.tencent.qqmail.launcher.third;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.Window;
import android.widget.Toast;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.FtnManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;

public class LaunchSaveToMyFtn
  extends ThirdLauncherActivity
{
  public static final String SAVETOMYFTNCODE = "savetomyftncode";
  public static final String SAVETOMYFTNKEY = "savetomyftnkey";
  public static final String TAG = "LaunchSaveToMyFtn";
  private final String SAVETOMYFTN = "com.tencent.androidqqmail.savetomyftn";
  
  private static void goFirstPage(String paramString1, String paramString2, Context paramContext)
  {
    int i = AccountManager.shareInstance().getAccountList().size();
    Intent localIntent;
    StringBuilder localStringBuilder;
    if (i == 1)
    {
      localIntent = MailFragmentActivity.createIntentToFolderList(AccountManager.shareInstance().getAccountList().get(0).getId());
      localStringBuilder = new StringBuilder().append("no visible activity exist. open ");
      if (i != 1) {
        break label110;
      }
    }
    label110:
    for (String str = "folderlist";; str = "accountlist")
    {
      QMLog.log(4, "LaunchSaveToMyFtn", str + " and save");
      localIntent.putExtra("savetomyftnkey", paramString1);
      localIntent.putExtra("savetomyftncode", paramString2);
      paramContext.startActivity(localIntent);
      return;
      localIntent = MailFragmentActivity.createIntentToAccountList();
      break;
    }
  }
  
  public static void handleSaveFtn(String paramString1, String paramString2)
  {
    QMLog.log(4, "LaunchSaveToMyFtn", "handleSaveFtn. k:" + paramString1 + ",c:" + paramString2);
    QMWatcherCenter.triggerWtchatFtnBegin();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((!StringExtention.isNullOrEmpty(paramString1)) && (!StringExtention.isNullOrEmpty(paramString2)))
    {
      localArrayList1.add(paramString1);
      localArrayList2.add(paramString2);
      paramString1 = new LaunchSaveToMyFtn.3();
      FtnManager.sharedInstance().saveFile(localArrayList1, localArrayList2, paramString1);
      return;
    }
    Threads.runInBackground(new LaunchSaveToMyFtn.2(), 500L);
  }
  
  public static void launchSaveToMyFtn(String paramString1, String paramString2, Context paramContext)
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null)
    {
      QMLog.log(4, "LaunchSaveToMyFtn", "visible activity:" + localActivity.getClass().getSimpleName());
      if (QMActivityManager.shareInstance().getActivitySize() <= 1)
      {
        goFirstPage(paramString1, paramString2, paramContext);
        return;
      }
      QMLog.log(4, "LaunchSaveToMyFtn", "direct save.");
      Threads.runInBackground(new LaunchSaveToMyFtn.1(paramString1, paramString2), 300L);
      return;
    }
    goFirstPage(paramString1, paramString2, paramContext);
  }
  
  protected void route()
  {
    super.initDataSource();
    getWindow().setWindowAnimations(0);
    Object localObject1 = new ColorDrawable(0);
    getWindow().setBackgroundDrawable((Drawable)localObject1);
    setContentView(2131559460);
    if (getIntent() != null)
    {
      QMLog.log(4, "LaunchSaveToMyFtn", "LaunchSaveToMyFtn. intent:null");
      finishWithNoCheck();
      return;
    }
    Uri localUri = getIntent().getData();
    Object localObject2 = null;
    localObject1 = localObject2;
    if (localUri != null)
    {
      localObject1 = localObject2;
      if ("com.tencent.androidqqmail.savetomyftn".equals(localUri.getScheme())) {
        localObject1 = localUri.getQueryParameter("k");
      }
    }
    if ((localObject1 == null) || (((String)localObject1).equals("")) || (!((String)localObject1).contains(",")))
    {
      QMLog.log(4, "LaunchSaveToMyFtn", "LaunchSaveToMyFtn. key:" + (String)localObject1);
      finishWithNoCheck();
      return;
    }
    QMLog.log(4, "LaunchSaveToMyFtn", "wtchat save ftn file k:" + (String)localObject1);
    localObject2 = ((String)localObject1).split(",");
    localObject1 = localObject2[0];
    localObject2 = localObject2[1];
    if (AccountManager.shareInstance().getAccountList().isLoginQQAccount()) {
      launchSaveToMyFtn((String)localObject1, (String)localObject2, this);
    }
    for (;;)
    {
      finishWithNoCheck();
      return;
      QMLog.log(4, "LaunchSaveToMyFtn", "no account exist.");
      SharedPreferenceUtil.setShownWelcomePage(true);
      startActivity(LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name()));
      Toast.makeText(QMApplicationContext.sharedInstance(), getString(2131689812), 1).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn
 * JD-Core Version:    0.7.0.1
 */