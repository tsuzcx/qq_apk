package com.tencent.qqmail.calendar.sqlite;

import com.tencent.moai.database.sqlite.SQLiteDatabase.HookType;
import com.tencent.moai.database.sqlite.SQLiteDatabase.UpdateHook;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;

class QMCalendarSQLiteHelper$1
  implements SQLiteDatabase.UpdateHook
{
  long lastHookTime = 0L;
  
  QMCalendarSQLiteHelper$1(QMCalendarSQLiteHelper paramQMCalendarSQLiteHelper) {}
  
  public void callback(SQLiteDatabase.HookType paramHookType, String paramString1, String paramString2, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (l - this.lastHookTime < 1000L) {
      this.lastHookTime = l;
    }
    do
    {
      return;
      this.lastHookTime = l;
    } while ((!paramString2.equals("QM_SCHEDULE_INSTANCE")) || (!CalendarWidgetManager.getInstance().isHasInitDone()) || (!SharedPreferenceUtil.isExistedCalendarWidget()) || (!AccountManager.shareInstance().getAccountList().hasAccounts()));
    QMWatcherCenter.triggerCalendarScheduleTableHook(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper.1
 * JD-Core Version:    0.7.0.1
 */