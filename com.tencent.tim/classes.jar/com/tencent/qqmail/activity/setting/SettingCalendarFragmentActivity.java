package com.tencent.qqmail.activity.setting;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.StatusBarUtil;
import moai.fragment.app.Fragment;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;

public class SettingCalendarFragmentActivity
  extends BaseFragmentActivity
{
  public static int DEFAULT_CALENDAR = 2;
  public static int EVENT_DURATION;
  public static int REMIND_TIME = 3;
  public static int SERVER_SETTING = 0;
  public static int SYNC_TIME;
  public static int flag;
  public static Account settingAccount;
  
  static
  {
    EVENT_DURATION = 4;
    SYNC_TIME = 5;
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), SettingCalendarFragmentActivity.class);
  }
  
  private void initializeFragment()
  {
    Object localObject;
    if (flag == DEFAULT_CALENDAR) {
      localObject = new SettingCalendarDefaultFragment();
    }
    for (;;)
    {
      getSupportFragmentManager().beginTransaction().add(2131367566, (Fragment)localObject, localObject.getClass().getSimpleName()).commit();
      return;
      if (flag == REMIND_TIME)
      {
        localObject = new SettingCalendarDefaultRemindTimeFragment();
      }
      else if (flag == EVENT_DURATION)
      {
        localObject = new SettingCalendarDefaultDurationFragment();
      }
      else if (flag == SYNC_TIME)
      {
        localObject = new SettingCalendarDefaultSyncTimeFragment();
      }
      else if (flag == SERVER_SETTING)
      {
        localObject = new SettingCalendarServerFragment(settingAccount);
        settingAccount = null;
      }
      else
      {
        localObject = null;
      }
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    initializeFragment();
    StatusBarUtil.immerseWhite(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.SettingCalendarFragmentActivity
 * JD-Core Version:    0.7.0.1
 */