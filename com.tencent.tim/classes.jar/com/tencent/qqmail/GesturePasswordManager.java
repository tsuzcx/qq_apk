package com.tencent.qqmail;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.setting.GesturePwdActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;

public class GesturePasswordManager
{
  public static final int GESTURE_PSW_TRY_TIMES = 5;
  private static GesturePasswordManager gesturePwdMgr = new GesturePasswordManager();
  private String TAG = "GesturePasswordManager";
  private boolean isGesturePwdPassed = true;
  
  private boolean canShowGesturePage()
  {
    boolean bool2 = getInstance().isGesturePwdPassed();
    if ((SharedPreferenceUtil.isGesturePswEnabled()) && (!bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      QMLog.log(4, this.TAG, "isGesturePwdEnable : " + SharedPreferenceUtil.isGesturePswEnabled() + " isGesturePwdPassed : " + bool2 + ", canShow : " + bool1);
      return bool1;
    }
  }
  
  public static GesturePasswordManager getInstance()
  {
    return gesturePwdMgr;
  }
  
  private boolean gotoGesturePage(Activity paramActivity)
  {
    int i = QMSettingManager.sharedInstance().getTryGestureTimes();
    if (i <= 5)
    {
      localObject = QMActivityManager.shareInstance().getVisibleActivity();
      if (localObject == null)
      {
        QMLog.log(5, this.TAG, "gotoGesturePage. activity is null. return");
        return false;
      }
      Intent localIntent = new Intent(paramActivity, GesturePwdActivity.class);
      localIntent.putExtra("arg_page_state", 2);
      localIntent.putExtra("arg_hide_top_bar", true);
      paramActivity.startActivity(localIntent);
      paramActivity.overridePendingTransition(2130772023, 2130772423);
      QMLog.log(4, this.TAG, "gotoGesturePage for less than 5 times:" + i + ", activity:" + localObject.getClass().getSimpleName() + ",context:" + paramActivity.getClass().getSimpleName());
      return true;
    }
    QMLog.log(4, this.TAG, "go ges psw verify acc.");
    paramActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (paramActivity == null)
    {
      QMLog.log(5, this.TAG, "gotoGesturePage. activity is null. return 2");
      return false;
    }
    if ((paramActivity instanceof LoginFragmentActivity))
    {
      QMLog.log(4, this.TAG, "ges pwd LoginFragmentActivity is alive");
      return false;
    }
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if (localObject != null)
    {
      localObject = LoginFragmentActivity.createIntentForGesVerify(((Account)localObject).getId(), ((Account)localObject).getEmail(), true);
      ((Intent)localObject).setFlags(67108864);
      paramActivity.startActivity((Intent)localObject);
      QMLog.log(4, this.TAG, "gotoGesturePage. for more than 5 times:" + i);
    }
    for (;;)
    {
      return true;
      QMLog.log(5, this.TAG, "gotoGesturePage no account exist");
    }
  }
  
  public boolean gesturePwdCheck(Activity paramActivity)
  {
    if (canShowGesturePage())
    {
      boolean bool = gotoGesturePage(paramActivity);
      QMLog.log(4, this.TAG, "gesturePwdCheck return gotoGesture:" + bool);
      return true;
    }
    QMLog.log(4, this.TAG, "gesturePwdCheck return false");
    return false;
  }
  
  public boolean isGesturePwdPassed()
  {
    return this.isGesturePwdPassed;
  }
  
  public void onActivityStarted(Activity paramActivity, boolean paramBoolean)
  {
    Log.d("mason", "checkGesturePwd:" + paramBoolean + ", activity:" + paramActivity.getClass().getSimpleName());
    if (!paramBoolean) {}
    while (this.isGesturePwdPassed) {
      return;
    }
    gesturePwdCheck(paramActivity);
  }
  
  public void setGesturePwdPassed(boolean paramBoolean)
  {
    this.isGesturePwdPassed = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.GesturePasswordManager
 * JD-Core Version:    0.7.0.1
 */