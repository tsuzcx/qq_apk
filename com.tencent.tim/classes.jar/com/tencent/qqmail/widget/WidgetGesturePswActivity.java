package com.tencent.qqmail.widget;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMUnlockFolderPwdWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.observer.QMNotification;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.view.FolderLockDialog;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import com.tencent.qqmail.widget.calendar.MonthWidgetManager;
import com.tencent.qqmail.widget.inbox.InboxWidgetManager;
import com.tencent.qqmail.widget.notelist.NoteWidgetManager;

public class WidgetGesturePswActivity
  extends BaseActivityEx
{
  public static final String ARG_FROM = "from";
  public static final String ARG_TO = "to";
  public static final String FORM_CALENDAR_WIDGET_PROVIDER = "from_calendar_widget_provider";
  public static final String FORM_INBOX_WIDGET_PROVIDER = "from_inbox_widget_provider";
  public static final String FORM_MONTH_WIDGET_PROVIDER = "from_month_widget_provider";
  public static final String FORM_NOTE_LIST_WIDGET_PROVIDER = "from_note_list_widget_provider";
  public static final String ITEM_ID = "ITEM_ID";
  public static final String TAG = "WidgetGesturePswActivity";
  public static final String TO_CERTAIN_ITEM = "TO_CERTAIN_ITEM";
  public static final String TO_UNLOCK = "TO_UNLOCK";
  private FolderLockDialog lockDialog;
  private String mFrom;
  protected QMUnlockFolderPwdWatcher mUnlockFolderPwd = new WidgetGesturePswActivity.1(this);
  
  public static Intent createCalendarWidgetGesturePswIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, WidgetGesturePswActivity.class);
    paramContext.addFlags(268468224);
    paramContext.putExtra("from", "from_calendar_widget_provider");
    paramContext.putExtra("to", "TO_UNLOCK");
    return paramContext;
  }
  
  public static Intent createInboxGesturePswIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, WidgetGesturePswActivity.class);
    paramContext.addFlags(268468224);
    paramContext.putExtra("from", "from_inbox_widget_provider");
    return paramContext;
  }
  
  public static Intent createIntentForCalendarTemplate(Context paramContext)
  {
    paramContext = new Intent(paramContext, WidgetGesturePswActivity.class);
    paramContext.putExtra("from", "from_calendar_widget_provider");
    paramContext.addFlags(268435456);
    return paramContext;
  }
  
  public static Intent createIntentForCertainCalendar(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("to", "TO_CERTAIN_ITEM");
    localIntent.putExtra("ITEM_ID", paramInt);
    return localIntent;
  }
  
  public static Intent createIntentToUnlock()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("to", "TO_UNLOCK");
    return localIntent;
  }
  
  public static Intent createMonthGesturePswIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, WidgetGesturePswActivity.class);
    paramContext.addFlags(268468224);
    paramContext.putExtra("from", "from_month_widget_provider");
    return paramContext;
  }
  
  public static Intent createNoteListGesturePswIntent(Context paramContext)
  {
    paramContext = new Intent(paramContext, WidgetGesturePswActivity.class);
    paramContext.addFlags(268468224);
    paramContext.putExtra("from", "from_note_list_widget_provider");
    return paramContext;
  }
  
  public void initDataSource() {}
  
  public void initDom()
  {
    this.mFrom = getIntent().getStringExtra("from");
  }
  
  public void initUI() {}
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData()
  {
    boolean bool = GesturePasswordManager.getInstance().isGesturePwdPassed();
    if (QMSettingManager.sharedInstance().getTryGestureTimes() > 5) {
      finish();
    }
    QQMailAccount localQQMailAccount;
    do
    {
      do
      {
        return;
        if ((!this.mFrom.equals("from_note_list_widget_provider")) || (!NoteWidgetManager.getInstance().hasUnlock()) || (!FolderLockDialog.isFolderLock(-4))) {
          break;
        }
        if (this.lockDialog != null) {
          this.lockDialog.dismissTips();
        }
        localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
      } while (localQQMailAccount == null);
      this.lockDialog = new FolderLockDialog(this, -4, localQQMailAccount.getId(), this.mUnlockFolderPwd);
      this.lockDialog.createDialog(1);
      this.lockDialog.setDialogCancelable(false);
      this.lockDialog.showDialog();
      QMLog.log(4, "WidgetGesturePswActivity", "note-widget popup file locker");
      return;
    } while ((!SharedPreferenceUtil.isGesturePswEnabled()) || (!bool));
    GesturePasswordManager.getInstance().setGesturePwdPassed(false);
    if (this.mFrom.equals("from_note_list_widget_provider"))
    {
      NoteWidgetManager.getInstance().setUnlock(true);
      if (FolderLockDialog.isFolderLock(-4))
      {
        if (this.lockDialog != null) {
          this.lockDialog.dismissTips();
        }
        localQQMailAccount = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
        if (localQQMailAccount != null)
        {
          this.lockDialog = new FolderLockDialog(this, -4, localQQMailAccount.getId(), this.mUnlockFolderPwd);
          this.lockDialog.createDialog(1);
          this.lockDialog.setDialogCancelable(false);
          this.lockDialog.showDialog();
        }
      }
    }
    for (;;)
    {
      QMNotification.postNotification("BROADCAST_WIDGET_ACCOUNT_CHANGE", null);
      return;
      finish();
      continue;
      if (this.mFrom.equals("from_calendar_widget_provider"))
      {
        CalendarWidgetManager.getInstance().setUnlock(true);
        finish();
      }
      else if (this.mFrom.equals("from_inbox_widget_provider"))
      {
        InboxWidgetManager.getInstance().setUnlock(true);
        finish();
      }
      else if (this.mFrom.equals("from_month_widget_provider"))
      {
        MonthWidgetManager.getInstance().setUnlock(true);
        finish();
      }
    }
  }
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetGesturePswActivity
 * JD-Core Version:    0.7.0.1
 */