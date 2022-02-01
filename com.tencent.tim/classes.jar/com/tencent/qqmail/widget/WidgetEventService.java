package com.tencent.qqmail.widget;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.qqmail.GesturePasswordManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.activity.setting.SettingNoteActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.widget.calendar.CalendarWidgetManager;
import com.tencent.qqmail.widget.calendar.MonthWidgetManager;
import com.tencent.qqmail.widget.inbox.InboxWidgetManager;
import com.tencent.qqmail.widget.notelist.NoteWidgetManager;
import java.util.Calendar;
import moai.oss.KvHelper;

public class WidgetEventService
  extends IntentService
{
  private static final String TAG = "WidgetEventService";
  
  public WidgetEventService()
  {
    super("WidgetEventService");
  }
  
  public WidgetEventService(String paramString)
  {
    super(paramString);
  }
  
  private void handle(Bundle paramBundle, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      handleInbox(paramBundle);
      return;
    case 1: 
      handleNote(paramBundle);
      return;
    case 2: 
      handleCalendar(paramBundle);
      return;
    }
    handleMonth(paramBundle);
  }
  
  private void handleInbox(Bundle paramBundle)
  {
    int i = paramBundle.getInt("EVENT_TYPE");
    Log.i("WidgetEventService", "handleInbox bundle.EVENT_TYPE " + i);
    switch (i)
    {
    }
    for (;;)
    {
      logWidgetEvent("Event_widget_inbox_into_app");
      logWidgetEvent("Event_widget_into_app");
      return;
      logWidgetEvent("Event_widget_inbox_into_by_add");
      if (!checkWidgetEnabled(0))
      {
        handleInboxInnormalState();
      }
      else
      {
        paramBundle = ComposeMailActivity.createIntentWithFolder(InboxWidgetManager.getInstance().getAccount(), InboxWidgetManager.getInstance().getFolder());
        paramBundle.setFlags(268468224);
        startActivity(paramBundle);
        continue;
        login();
        continue;
        unlock(0);
        continue;
        InboxWidgetManager.getInstance().loadMore();
        continue;
        logWidgetEvent("Event_widget_inbox_into_by_certain_item");
        long l1 = paramBundle.getLong("MAIL_ID");
        i = paramBundle.getInt("FOLDER_ID");
        String str1 = paramBundle.getString("SUBJECT");
        String str2 = paramBundle.getString("RENDERNICK");
        String str3 = paramBundle.getString("SENDEREMAIL");
        int j = paramBundle.getInt("ACCOUNTID");
        paramBundle.getLongArray("ITEMSID");
        long l2 = paramBundle.getLong("AGGRTYPE");
        if (paramBundle.getInt("MAIL_TYPE") == 1)
        {
          paramBundle = MailFragmentActivity.createIntentToConv(paramBundle);
          paramBundle.setFlags(268468224);
          startActivity(paramBundle);
        }
        else if (paramBundle.getInt("MAIL_TYPE") == 3)
        {
          paramBundle = MailFragmentActivity.createIntentAdvertise(j, l2);
          paramBundle.setFlags(268468224);
          startActivity(paramBundle);
        }
        else if (paramBundle.getInt("MAIL_TYPE") == 4)
        {
          paramBundle = MailFragmentActivity.createIntentSubscribe(j, l2);
          paramBundle.setFlags(268468224);
          startActivity(paramBundle);
        }
        else
        {
          paramBundle = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
          if (paramBundle == null) {
            throw new IllegalStateException();
          }
          paramBundle = MailFragmentActivity.createIntentToReadmail(paramBundle.getId(), i, l1, str1, str2, str3, false);
          paramBundle.setFlags(268468224);
          startActivity(paramBundle);
        }
      }
    }
  }
  
  public boolean checkWidgetEnabled(int paramInt)
  {
    if (paramInt == 2) {
      if (CalendarWidgetManager.getInstance().getWidgetState() != QMWidgetDataManager.WidgetState.AVAILABLE) {}
    }
    do
    {
      do
      {
        do
        {
          return true;
          return false;
          if (paramInt != 1) {
            break;
          }
        } while (NoteWidgetManager.getInstance().getWidgetState() == QMWidgetDataManager.WidgetState.AVAILABLE);
        return false;
        if (paramInt != 0) {
          break;
        }
      } while (InboxWidgetManager.getInstance().getWidgetState() == QMWidgetDataManager.WidgetState.AVAILABLE);
      return false;
    } while (MonthWidgetManager.getInstance().getWidgetState() == QMWidgetDataManager.WidgetState.AVAILABLE);
    return false;
  }
  
  public void handleCalendar(Bundle paramBundle)
  {
    int i = paramBundle.getInt("EVENT_TYPE");
    QMLog.log(4, "WidgetEventService", "handleCalendar bundle.EVENT_TYPE " + i);
    switch (i)
    {
    }
    for (;;)
    {
      logWidgetEvent("Event_widget_calendar_into_app");
      logWidgetEvent("Event_widget_into_app");
      return;
      logWidgetEvent("Event_widget_calendar_into_by_add");
      if (!checkWidgetEnabled(2))
      {
        handleCalendarInnormalState();
        logWidgetEvent("Event_widget_calendar_into_by_certain_item");
        if (!checkWidgetEnabled(2))
        {
          handleCalendarInnormalState();
          if (CalendarWidgetManager.getInstance().hasAccount()) {
            continue;
          }
          login();
        }
      }
      else
      {
        paramBundle = CalendarFragmentActivity.createIntentForWidgetToSchedule();
        paramBundle.setFlags(268468224);
        startActivity(paramBundle);
        continue;
      }
      paramBundle = CalendarFragmentActivity.createIntent();
      paramBundle.setFlags(268468224);
      startActivity(paramBundle);
      continue;
      unlock(2);
      continue;
      openCalendarApplication();
      continue;
      logWidgetEvent("Event_widget_calendar_into_by_certain_item");
      paramBundle = CalendarFragmentActivity.createIntentForWidgetToSchedule();
      paramBundle.setFlags(268468224);
      startActivity(paramBundle);
      continue;
      logWidgetEvent("Event_widget_calendar_into_by_certain_item");
      paramBundle = LaunchWebPush.createIntentToCertainCalendarSchedule(paramBundle.getInt("EXTRA_CALENDAR_ID"));
      paramBundle.setFlags(268468224);
      startActivity(paramBundle);
    }
  }
  
  public void handleCalendarInnormalState()
  {
    QMWidgetDataManager.WidgetState localWidgetState = CalendarWidgetManager.getInstance().getWidgetState();
    switch (WidgetEventService.2.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[localWidgetState.ordinal()])
    {
    default: 
      return;
    case 1: 
      login();
      return;
    case 2: 
      openCalendarApplication();
      return;
    }
    unlock(2);
  }
  
  public void handleInboxInnormalState()
  {
    QMWidgetDataManager.WidgetState localWidgetState = InboxWidgetManager.getInstance().getWidgetState();
    switch (WidgetEventService.2.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[localWidgetState.ordinal()])
    {
    case 2: 
    default: 
      return;
    case 1: 
      login();
      return;
    }
    unlock(0);
  }
  
  public void handleMonth(Bundle paramBundle)
  {
    int i = paramBundle.getInt("EVENT_TYPE");
    QMLog.log(4, "WidgetEventService", "handleMonth bundle.EVENT_TYPE " + i);
    switch (i)
    {
    }
    for (;;)
    {
      logWidgetEvent("Event_widget_month_into_app");
      logWidgetEvent("Event_widget_into_app");
      paramBundle = new Intent();
      paramBundle.setAction("com.tencent.qqmail.widget.month.refresh.ui");
      QMApplicationContext.sharedInstance().sendBroadcast(paramBundle);
      return;
      if (!checkWidgetEnabled(3))
      {
        handleMonthInnormalState();
      }
      else
      {
        paramBundle = Calendar.getInstance();
        i = SharedPreferenceUtil.getCalendarWidgetMonth();
        int j = SharedPreferenceUtil.getCalendarWidgetYear();
        paramBundle.set(5, 1);
        paramBundle.set(2, i);
        paramBundle.set(1, j);
        paramBundle.add(2, 1);
        SharedPreferenceUtil.setCalendarWidgetMonth(paramBundle.get(2));
        SharedPreferenceUtil.setCalendarWidgetYear(paramBundle.get(1));
        logWidgetEvent("Event_widget_month_click_next");
        continue;
        if (!checkWidgetEnabled(3))
        {
          handleMonthInnormalState();
        }
        else
        {
          paramBundle = Calendar.getInstance();
          i = SharedPreferenceUtil.getCalendarWidgetMonth();
          j = SharedPreferenceUtil.getCalendarWidgetYear();
          paramBundle.set(5, 1);
          paramBundle.set(2, i);
          paramBundle.set(1, j);
          paramBundle.add(2, -1);
          SharedPreferenceUtil.setCalendarWidgetMonth(paramBundle.get(2));
          SharedPreferenceUtil.setCalendarWidgetYear(paramBundle.get(1));
          logWidgetEvent("Event_widget_month_click_prew");
          continue;
          if (checkWidgetEnabled(3))
          {
            paramBundle = Calendar.getInstance();
            SharedPreferenceUtil.setCalendarWidgetMonth(paramBundle.get(2));
            SharedPreferenceUtil.setCalendarWidgetYear(paramBundle.get(1));
            logWidgetEvent("Event_widget_month_click_curr");
            continue;
            logWidgetEvent("Event_widget_month_certain_day_into_app");
            Intent localIntent = CalendarFragmentActivity.createIntent();
            localIntent.setFlags(268468224);
            localIntent.putExtras(paramBundle);
            long l = localIntent.getExtras().getLong("CALENDAR_SELECT_DAY");
            paramBundle = Calendar.getInstance();
            paramBundle.setTimeInMillis(l);
            Log.i("WidgetEventService", " MONTH = " + paramBundle.get(2) + " DAY = " + paramBundle.get(5));
            startActivity(localIntent);
            continue;
            login();
            continue;
            unlock(3);
            continue;
            openCalendarApplication();
          }
        }
      }
    }
  }
  
  public void handleMonthInnormalState()
  {
    QMWidgetDataManager.WidgetState localWidgetState = MonthWidgetManager.getInstance().getWidgetState();
    switch (WidgetEventService.2.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[localWidgetState.ordinal()])
    {
    default: 
      return;
    case 1: 
      login();
      return;
    case 2: 
      openCalendarApplication();
      return;
    }
    unlock(3);
  }
  
  public void handleNote(Bundle paramBundle)
  {
    int i = paramBundle.getInt("EVENT_TYPE");
    QMLog.log(4, "WidgetEventService", "handleNote bundle.EVENT_TYPE " + i);
    switch (i)
    {
    }
    for (;;)
    {
      logWidgetEvent("Event_widget_note_into_app");
      logWidgetEvent("Event_widget_into_app");
      return;
      login();
      continue;
      openNoteAppliction();
      continue;
      unlock(1);
      continue;
      logWidgetEvent("Event_widget_note_into_by_certain_item");
      Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), ReadNoteActivity.class);
      localIntent.putExtras(paramBundle);
      localIntent.setFlags(268468224);
      startActivity(localIntent);
      continue;
      paramBundle = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
      paramBundle.putExtra("noteCatId", "all");
      paramBundle.setFlags(268468224);
      startActivity(paramBundle);
      continue;
      logWidgetEvent("Event_widget_note_into_by_add");
      if (!checkWidgetEnabled(1))
      {
        handleNoteInnormalState();
      }
      else
      {
        paramBundle = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
        paramBundle.putExtra("noteCatId", "all");
        paramBundle.setFlags(268468224);
        startActivity(paramBundle);
        continue;
        logWidgetEvent("Event_widget_note_into_by_camera");
        if (!checkWidgetEnabled(1))
        {
          handleNoteInnormalState();
        }
        else
        {
          paramBundle = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
          paramBundle.putExtra("EXTRA_NAME_NOTE_REQ", "EXTRA_NOTE_REQ_CAMEAR");
          paramBundle.setFlags(268468224);
          startActivity(paramBundle);
          continue;
          logWidgetEvent("Event_widget_note_into_by_photos");
          if (!checkWidgetEnabled(1))
          {
            handleNoteInnormalState();
          }
          else
          {
            paramBundle = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
            paramBundle.putExtra("EXTRA_NAME_NOTE_REQ", "EXTRA_NOTE_REQ_PICUTRE");
            paramBundle.setFlags(268468224);
            startActivity(paramBundle);
            continue;
            logWidgetEvent("Event_widget_note_into_by_voice");
            if (!checkWidgetEnabled(1))
            {
              handleNoteInnormalState();
            }
            else
            {
              paramBundle = new Intent(QMApplicationContext.sharedInstance(), ComposeNoteActivity.class);
              paramBundle.putExtra("EXTRA_NAME_NOTE_REQ", "EXTRA_NOTE_REQ_VOICE");
              paramBundle.setFlags(268468224);
              startActivity(paramBundle);
            }
          }
        }
      }
    }
  }
  
  public void handleNoteInnormalState()
  {
    QMWidgetDataManager.WidgetState localWidgetState = NoteWidgetManager.getInstance().getWidgetState();
    switch (WidgetEventService.2.$SwitchMap$com$tencent$qqmail$widget$QMWidgetDataManager$WidgetState[localWidgetState.ordinal()])
    {
    default: 
      return;
    case 1: 
      login();
      return;
    case 2: 
      openNoteAppliction();
      return;
    }
    unlock(1);
  }
  
  public void logWidgetEvent(String paramString)
  {
    DataCollector.logEvent(paramString);
  }
  
  public void login()
  {
    Intent localIntent = AccountTypeListActivity.createIntent(true);
    if (NoteWidgetManager.getInstance().hasAccount()) {
      localIntent.setFlags(268435456);
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent.setFlags(268468224);
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    KvHelper.eventWidgetClick(new double[0]);
    paramIntent = paramIntent.getExtras();
    int i = paramIntent.getInt("WIDGET_TYPE");
    QMLog.log(4, "WidgetEventService", "onHandleIntent bundle.WIDGET_TYPE " + i);
    Threads.runOnMainThread(new WidgetEventService.1(this, paramIntent, i));
  }
  
  public void openCalendarApplication()
  {
    Intent localIntent = SettingCalendarActivity.createIntent();
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }
  
  public void openNoteAppliction()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingNoteActivity.class);
    localIntent.setFlags(268468224);
    startActivity(localIntent);
  }
  
  public void unlock(int paramInt)
  {
    if (paramInt == 0) {
      startActivity(WidgetGesturePswActivity.createInboxGesturePswIntent(this));
    }
    do
    {
      return;
      if (paramInt == 2)
      {
        startActivity(WidgetGesturePswActivity.createCalendarWidgetGesturePswIntent(this));
        return;
      }
      if (paramInt == 1)
      {
        if (NoteWidgetManager.getInstance().getWidgetState() == QMWidgetDataManager.WidgetState.FOLDERLOCK) {
          GesturePasswordManager.getInstance().setGesturePwdPassed(true);
        }
        startActivity(WidgetGesturePswActivity.createNoteListGesturePswIntent(this));
        return;
      }
    } while (paramInt != 3);
    startActivity(WidgetGesturePswActivity.createMonthGesturePswIntent(this));
  }
  
  public static abstract interface WidgetEventFrom
  {
    public static final int CALENDAR = 2;
    public static final int INBOX = 0;
    public static final int MONTH = 3;
    public static final int NOTE = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.WidgetEventService
 * JD-Core Version:    0.7.0.1
 */