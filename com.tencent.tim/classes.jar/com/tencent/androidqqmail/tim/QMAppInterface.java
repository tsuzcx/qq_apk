package com.tencent.androidqqmail.tim;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QMAppInterface
  extends AppRuntime
{
  private static final String TAG = "QMAppInterface";
  private static QMAppInterface _instance = null;
  private int nt_icon_id = 0;
  private final QMApplicationContext qmApplicationContext;
  private BroadcastReceiver qqExitBroadcastReceiver = new QMAppInterface.2(this);
  private String uin;
  
  public QMAppInterface(BaseApplication paramBaseApplication, Bundle paramBundle)
  {
    this.uin = paramBundle.getString("uin");
    this.nt_icon_id = paramBundle.getInt("notification_icon");
    Log.i("QMAppInterface", "QMAppInterface  uin = " + this.uin);
    _instance = this;
    this.qmApplicationContext = new QMApplicationContext(paramBaseApplication);
    this.qmApplicationContext.onCreate();
    if (VersionUtils.hasKitKat()) {
      WebView.setWebContentsDebuggingEnabled(true);
    }
    Threads.runInBackground(new QMAppInterface.1(this), 1000L);
    paramBundle = new IntentFilter();
    paramBundle.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    paramBundle.addAction("mqq.intent.action.LOGOUT");
    paramBaseApplication.registerReceiver(this.qqExitBroadcastReceiver, paramBundle);
  }
  
  public static AppRuntime getRuntime()
  {
    return MobileQQ.getMobileQQ().waitAppRuntime(null);
  }
  
  private void preGetA2(AccountList paramAccountList, int paramInt)
  {
    String str;
    if (paramAccountList.size() > paramInt)
    {
      Object localObject = paramAccountList.get(paramInt);
      if (!((Account)localObject).isQQMail()) {
        break label124;
      }
      localObject = (QQMailAccount)localObject;
      str = ((QQMailAccount)localObject).getUin();
      if (str == null) {
        throw new IllegalStateException("uin null:" + localObject);
      }
      if (QMWtLoginManager.getInstance().getA2(str) != null) {
        preGetA2(paramAccountList, paramInt + 1);
      }
    }
    else
    {
      return;
    }
    if (str.equals(getRuntime().getAccount()))
    {
      TimMailLoginManager.requestA2AndSkey(str, null, new QMAppInterface.3(this, paramAccountList, paramInt));
      return;
    }
    preGetA2(paramAccountList, paramInt + 1);
    return;
    label124:
    preGetA2(paramAccountList, paramInt + 1);
  }
  
  public static QMAppInterface sharedInstance()
  {
    if (_instance == null) {
      throw new IllegalStateException("not init");
    }
    return _instance;
  }
  
  public String getAccount()
  {
    return this.uin;
  }
  
  public int getNtId()
  {
    return this.nt_icon_id;
  }
  
  public QMApplicationContext getQmApplicationContext()
  {
    return this.qmApplicationContext;
  }
  
  public String getUin()
  {
    return this.uin;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.qmApplicationContext.unregisterReceiver(this.qqExitBroadcastReceiver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.androidqqmail.tim.QMAppInterface
 * JD-Core Version:    0.7.0.1
 */