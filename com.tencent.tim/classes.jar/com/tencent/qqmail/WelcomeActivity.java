package com.tencent.qqmail;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.webviewexplorer.PopularizeWebViewExplorer;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.launcher.base.WelcomeLoader;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.permission.RxPermissions;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.businessfilter.WelcomeFilter;
import com.tencent.qqmail.popularize.businessfilter.WelcomeSubItemFilter;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.popularize.model.PopularizeSubItem;
import com.tencent.qqmail.popularize.view.PopularizeUIHelper;
import com.tencent.qqmail.popularize.view.WelcomeSplashView;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.schema.SchemaUtil;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.log.QMLogStream;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.view.FullWindowHelper;
import com.tencent.qqmail.wetest.WeTestConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import moai.oss.KvHelper;
import rx.Observable;

public class WelcomeActivity
  extends Activity
{
  private static final String ARG_FROM_Permission = "arg_from_permission";
  private static final String ARG_FROM_WAKEPU = "arg_from_wakeup";
  private static final int DEFAULT_SPLASH_DURATION = 2000;
  private static final int PURE_WELCOME_DURATION = 1500;
  private static final String TAG = "WelcomeActivity";
  private static final int WELCOME_BEFORE_SPLASH = 1000;
  private volatile boolean finishedClock = false;
  private volatile boolean finishedPreload = false;
  private boolean isFromWakeup = false;
  private boolean isGoingIntoApp = false;
  private String oldVersion;
  private ViewGroup splashView;
  private long startTime = -1L;
  private Popularize welcomePopularize;
  
  private void animateToSplash()
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.3F, 1.0F);
    localAlphaAnimation.setDuration(400L);
    this.splashView.startAnimation(localAlphaAnimation);
    this.splashView.setVisibility(0);
    findViewById(2131370900).setVisibility(8);
    findViewById(2131362867).setVisibility(8);
  }
  
  private void checkBetaVersion()
  {
    if (AppConfig.isBeta())
    {
      String str = AppConfig.getSystemVersion();
      TextView localTextView = (TextView)findViewById(2131362867);
      localTextView.setText(String.format(getString(2131690424), new Object[] { str }));
      localTextView.setVisibility(0);
    }
    Threads.runInBackground(new WelcomeActivity.5(this));
  }
  
  public static Intent createIntent(boolean paramBoolean)
  {
    Log.i("WelcomeActivity", "createIntent");
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), WelcomeActivity.class);
    localIntent.putExtra("arg_from_wakeup", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentForRequiredPermission()
  {
    Log.i("WelcomeActivity", "createIntentForRequiredPermission");
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), WelcomeActivity.class);
    localIntent.putExtra("arg_from_permission", true);
    return localIntent;
  }
  
  private void finishPreload()
  {
    QMLog.log(4, "WelcomeActivity", "WelcomeLoader finish");
    this.finishedPreload = true;
    goingIntoApp();
  }
  
  private int getResIdForPopularizeSkipButton(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 2131378481;
    case 2: 
      return 2131378483;
    case 3: 
      return 2131378480;
    case 4: 
      return 2131378482;
    }
    return 2131378479;
  }
  
  @MainThread
  private void goingIntoApp()
  {
    if ((!this.finishedPreload) || (!this.finishedClock)) {
      QMLog.log(4, "WelcomeActivity", "It's not time to go into app finishedPreload[%s], finishedClock[%s]", new Object[] { Boolean.valueOf(this.finishedPreload), Boolean.valueOf(this.finishedClock) });
    }
    do
    {
      return;
      QMLog.log(4, "WelcomeActivity", "isGoingIntoApp = " + this.isGoingIntoApp + " isFromWakeup = " + this.isFromWakeup);
    } while (this.isGoingIntoApp);
    this.isGoingIntoApp = true;
    if (this.isFromWakeup)
    {
      finish();
      return;
    }
    Object localObject = CrashComposeCheck.checkCrashComposeMail(this);
    if (localObject != null)
    {
      startActivity((Intent)localObject);
      overridePendingTransition(2130772023, 2130772423);
      finish();
      return;
    }
    boolean bool = SharedPreferenceUtil.getShownWelcomePage();
    QMLog.log(4, "WelcomeActivity", "getShownWelcomePages:" + bool + ",oldVersion:" + this.oldVersion);
    if (!bool)
    {
      SharedPreferenceUtil.setShownWelcomePage(true);
      if (!ChannelDefine.isQQandWeixin())
      {
        startActivity(WelcomePagesActivity.createIntent(this.oldVersion));
        finish();
        return;
      }
    }
    localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0) {
      if (WeTestConfig.autoLoginQQ()) {
        startActivity(LoginFragmentActivity.createIntentToAddAccount(AccountType.qqmail.name()));
      }
    }
    for (;;)
    {
      QMLog.log(4, "WelcomeActivity", "end of method[goingIntoApp]");
      overridePendingTransition(2130772023, 2130772423);
      finish();
      return;
      if (WeTestConfig.autoLoginProtocol())
      {
        startActivity(LoginFragmentActivity.createIntentToAddAccount(AccountType.other.name()));
      }
      else
      {
        startActivity(AccountTypeListActivity.createIntent(true));
        continue;
        if (((AccountList)localObject).size() == 1) {
          startActivity(MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId()));
        } else if (((AccountList)localObject).size() > 1) {
          startActivity(MailFragmentActivity.createIntentToAccountList());
        }
      }
    }
  }
  
  private void handleSubItemAction(PopularizeSubItem paramPopularizeSubItem)
  {
    for (;;)
    {
      try
      {
        switch (paramPopularizeSubItem.getAction())
        {
        case 0: 
        case 2: 
        case 3: 
          PopularizeUIHelper.handleSubItemClick(paramPopularizeSubItem);
          return;
        }
      }
      catch (Exception paramPopularizeSubItem)
      {
        boolean bool;
        QMLog.log(6, "WelcomeActivity", Log.getStackTraceString(paramPopularizeSubItem));
        return;
      }
      int i = PopularizeUIHelper.getAnimationTypeByPopularize(this.welcomePopularize.getType());
      String str = paramPopularizeSubItem.getOpenUrl();
      if ((str != null) && (str.startsWith("qqmail://")))
      {
        bool = SchemaUtil.handleSchemaAction(this, str, i, 2);
        if (bool) {
          finish();
        }
        QMLog.log(4, "WelcomeActivity", "handleSubItemAction schema " + str + " isHandle " + bool);
      }
      else if ((str != null) && ((str.startsWith("http://")) || (str.startsWith("https://"))))
      {
        startActivity(PopularizeWebViewExplorer.createIntent(str, this.welcomePopularize.getId(), i));
        finish();
        QMLog.log(4, "WelcomeActivity", "handleSubItemAction url " + str);
      }
      else
      {
        QMLog.log(4, "WelcomeActivity", "handleSubItemAction error url " + str);
        continue;
        goingIntoApp();
      }
    }
  }
  
  private boolean loadSplashPopularizeFromDB()
  {
    ArrayList localArrayList = PopularizeManager.sharedInstance().getPopularize(new WelcomeFilter());
    if (localArrayList.size() > 0) {
      this.welcomePopularize = ((Popularize)localArrayList.get(0));
    }
    return this.welcomePopularize != null;
  }
  
  private void logAppVersion() {}
  
  private void reportSplashData()
  {
    if (this.welcomePopularize == null) {
      return;
    }
    DataCollector.logEvent("Event_Splash_popularize_Show");
    DataCollector.logDetailEvent("DetailEvent_Show_Holiday_Image", 0L, 0L, this.welcomePopularize.getImageUrl() + " " + this.welcomePopularize.getSubImageUrl() + " " + this.welcomePopularize.getOpenUrl());
    DataCollector.logDetailEvent("DetailEvent_Splash_Popularize_Show", 0L, 0L, this.welcomePopularize.getReportId() + "");
    DataCollector.logDetailEventWithDetailMessage("DetailEvent_Splash_Popularize_Show", this.welcomePopularize.getReportId() + "", 0L, 0L, this.welcomePopularize.getReportId() + "");
    QMLogStream.submitLog(false, true);
  }
  
  private void showSplash()
  {
    if (this.welcomePopularize != null)
    {
      animateToSplash();
      reportSplashData();
      Object localObject = (ImageView)findViewById(2131378650);
      ((ImageView)localObject).setImageBitmap(PopularizeThumbManager.sharedInstance().getPopularizeThumb(this.welcomePopularize.getImageUrl()));
      ((ImageView)localObject).setOnClickListener(new WelcomeActivity.3(this));
      localObject = (ArrayList)PopularizeManager.sharedInstance().getPopularizeSubItem(new WelcomeSubItemFilter(this.welcomePopularize)).get(this.welcomePopularize);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          PopularizeSubItem localPopularizeSubItem = (PopularizeSubItem)((Iterator)localObject).next();
          DataCollector.logDetailEvent("DetailEvent_Splash_Popularize_Subitem_Show", 0L, 0L, localPopularizeSubItem.getServerId() + "");
          DataCollector.logDetailEventWithDetailMessage("DetailEvent_Splash_Popularize_Subitem_Show", this.welcomePopularize.getReportId() + "_" + localPopularizeSubItem.getServerId(), 0L, 0L, localPopularizeSubItem.getServerId() + "");
          if (localPopularizeSubItem.getImageUrl() != null)
          {
            Bitmap localBitmap = PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularizeSubItem.getImageUrl());
            if (localBitmap != null)
            {
              ImageView localImageView = (ImageView)findViewById(getResIdForPopularizeSkipButton(localPopularizeSubItem.getPosition()));
              if (localImageView != null)
              {
                if (localPopularizeSubItem.getPosition() == 5) {
                  ((WelcomeSplashView)findViewById(2131378662)).setCenterViewBottomRatio(localImageView, localPopularizeSubItem.getBottomRatio());
                }
                localImageView.setVisibility(0);
                localImageView.setImageBitmap(localBitmap);
                localImageView.setOnClickListener(new WelcomeActivity.4(this, localPopularizeSubItem));
              }
            }
          }
        }
      }
      Log.i("WelcomeActivity", "check beta " + AppConfig.isBeta());
      if (AppConfig.isBeta()) {
        findViewById(2131363392).setVisibility(0);
      }
    }
    else
    {
      return;
    }
    findViewById(2131363392).setVisibility(8);
  }
  
  private boolean versionContrast(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      QMLog.log(4, "WelcomeActivity", "versionContrast:" + paramString1 + "," + paramString2);
      paramString2 = paramString2.split("\\.");
      paramString1 = paramString1.split("\\.");
      int j = Math.min(paramString2.length, paramString1.length);
      int i = 0;
      while (i < j)
      {
        int k = Integer.parseInt(paramString1[i]);
        int m = Integer.parseInt(paramString2[i]);
        if (m > k)
        {
          QMLog.log(4, "WelcomeActivity", m + "," + k);
          return true;
        }
        if (m < k)
        {
          QMLog.log(4, "WelcomeActivity", m + "," + k);
          return false;
        }
        i += 1;
      }
      if (paramString1.length > paramString2.length)
      {
        QMLog.log(4, "WelcomeActivity", "len:" + paramString1.length + ", " + paramString2.length);
        return false;
      }
      if (paramString1.length < paramString2.length)
      {
        QMLog.log(4, "WelcomeActivity", "len:" + paramString1.length + ", " + paramString2.length);
        return true;
      }
    }
    return false;
  }
  
  private void visible()
  {
    long l = SystemClock.uptimeMillis() - QMApplicationContext.sharedInstance().mOnCreateBegin;
    KvHelper.welcomeLauncherTime(new double[] { l });
    QMApplicationContext.sharedInstance().logVisibleWelcome(l);
  }
  
  public void directToNextPageInClock(long paramLong)
  {
    QMLog.log(4, "WelcomeActivity", "directToNextPageInClock directToNextPageInClock = " + paramLong);
    Threads.runOnMainThread(new WelcomeActivity.6(this), paramLong);
  }
  
  public void internalRequestRequiredPermission()
  {
    RxPermissions.getInstance(this).request(PermissionUtils.Required_Permission).subscribe(new WelcomeActivity.8(this), new WelcomeActivity.9(this), new WelcomeActivity.10(this));
  }
  
  public void onAcceptRequiredPermission()
  {
    Log.i("WelcomeActivity", "onAcceptRequiredPermission");
    directToNextPageInClock(1500L);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("WelcomeActivity", String.format("onActivityResult requestCode[%d] resultCode[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    if (!PermissionUtils.hasRequiredPermission(this))
    {
      requestRequiredPermission();
      return;
    }
    directToNextPageInClock(1500L);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(2130772023, 2130772025);
    FullWindowHelper.changeToFullScreen(getWindow(), this);
    this.isFromWakeup = getIntent().getBooleanExtra("arg_from_wakeup", false);
    boolean bool = getIntent().getBooleanExtra("arg_from_permission", false);
    setContentView(2131563346);
    if (WelcomeLoader.getInstance().isFinish()) {
      finishPreload();
    }
    while ((!PermissionUtils.hasRequiredPermission(this)) || (bool))
    {
      requestRequiredPermission();
      return;
      WelcomeLoader.getInstance().registerCallback(new WelcomeActivity.1(this));
    }
    this.splashView = ((ViewGroup)findViewById(2131378662));
    this.startTime = System.currentTimeMillis();
    Threads.runInBackground(new WelcomeActivity.2(this));
    checkBetaVersion();
  }
  
  public void onDenyRequiredPermission()
  {
    Log.i("WelcomeActivity", "onDenyRequiredPermission");
    PermissionUtils.permissionWarn(this, 2131718910, new WelcomeActivity.11(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    visible();
    if (StatusBarUtil.availableVersion()) {
      FullWindowHelper.changeToFullScreen(getWindow(), this);
    }
  }
  
  @TargetApi(23)
  public void requestRequiredPermission()
  {
    boolean bool = PermissionUtils.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE");
    if (!bool) {
      SharedPreferenceUtil.setRationalTimes(SharedPreferenceUtil.getRationalTimes() + 1);
    }
    int i = SharedPreferenceUtil.getRationalTimes();
    Log.i("WelcomeActivity", "lastRational = " + i);
    if ((i >= 2) && (!bool))
    {
      internalRequestRequiredPermission();
      return;
    }
    Object localObject = getString(2131718905);
    localObject = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131718911)).setMessage(Html.fromHtml((String)localObject)).addAction(0, 2131718908, 0, new WelcomeActivity.7(this))).create();
    ((QMUIDialog)localObject).setCancelable(false);
    ((QMUIDialog)localObject).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.WelcomeActivity
 * JD-Core Version:    0.7.0.1
 */