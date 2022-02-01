package com.tencent.qqmail.calendar.fragment;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.calendar.data.CreditCardBill;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.provider.CalendarProviderManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.fragment.base.QMBaseFragment;
import com.tencent.qqmail.notificationshortcut.ShortcutGuidance;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.Calendar;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;
import moai.oss.KvHelper;

public class CalendarFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_CALENDAR_LSIT_FROM = "arg_calendar_list_from";
  private static final String ARG_CODE = "arg_code";
  private static final String ARG_CREDIT_CARD = "org_creditcardbill";
  private static final String ARG_FOLLOW_ACCOUNT_ID = "arg_follow_account_id";
  private static final String ARG_GO_TO_PLACE = "arg_basefragment_goto";
  private static final String ARG_IS_FULL_DAY = "arg_is_full_day";
  private static final String ARG_IS_READ_SCHEDULE_BY_SCHEDULE_ID = "arg_is_read_schedule_by_schedule_id";
  private static final String ARG_NEW_EVENT = "arg_new_event";
  private static final String ARG_RELATED_ACCOUNT_ID = "arg_related_account_id";
  private static final String ARG_RELATED_ID = "arg_related_id";
  private static final String ARG_RELATED_SUBJECT = "arg_related_subject";
  private static final String ARG_RELATED_TYPE = "arg_related_type";
  private static final String ARG_REMINDER_ID = "arg_reminder_id";
  private static final String ARG_SCHEDULE_ID = "arg_schedule_id";
  private static final String ARG_TIMEMILLIS = "arg_timemillis";
  private static final int PLACE_CALENDAR_LIST = 8;
  private static final int PLACE_CHECK_SCHEDULE = 5;
  private static final int PLACE_CHOOSE_ACCOUNT = 9;
  private static final int PLACE_CREATE_SCHEDULE = 6;
  private static final int PLACE_CREDIT_CARD_BILL_REMINDER = 10;
  private static final int PLACE_MAIL_CONTENT_AWARE = 3;
  private static final int PLACE_MAIN = 1;
  private static final int PLACE_MODIFY_SCHEDULE = 2;
  private static final int PLACE_NO_FOLDER = 7;
  private static final int PLACE_READ_SCHEDULE = 4;
  protected static final String TAG = CalendarFragmentActivity.class.getSimpleName();
  private int animationType;
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
  }
  
  public static Intent createIntentForCreditCardBill(CreditCardBill paramCreditCardBill)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 10);
    localIntent.putExtra("org_creditcardbill", paramCreditCardBill);
    return localIntent;
  }
  
  public static Intent createIntentForWidgetToSchedule()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 2);
    return localIntent;
  }
  
  public static Intent createIntentToAddEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 6);
    localIntent.putExtra("arg_new_event", paramQMCalendarEvent);
    return localIntent;
  }
  
  public static Intent createIntentToCalendarChooseAccount(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 9);
    localIntent.putExtra("arg_code", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToCalendarList()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 8);
    localIntent.putExtra("arg_calendar_list_from", 0);
    return localIntent;
  }
  
  public static Intent createIntentToCalendarListAfterShare()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 8);
    localIntent.putExtra("arg_calendar_list_from", 2);
    return localIntent;
  }
  
  public static Intent createIntentToCalendarListFromSetting()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 8);
    localIntent.putExtra("arg_calendar_list_from", 1);
    return localIntent;
  }
  
  public static Intent createIntentToCalendarListToShare(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 8);
    localIntent.putExtra("arg_calendar_list_from", 2);
    localIntent.putExtra("arg_follow_account_id", paramInt);
    localIntent.putExtra("arg_code", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToCheckSchedule(long paramLong)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 5);
    localIntent.putExtra("arg_timemillis", paramLong);
    return localIntent;
  }
  
  public static Intent createIntentToModifySchedule(int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 2);
    localIntent.putExtra("arg_related_type", paramInt1);
    localIntent.putExtra("arg_related_id", paramString1);
    localIntent.putExtra("arg_related_account_id", paramInt2);
    localIntent.putExtra("arg_related_subject", paramString2);
    return localIntent;
  }
  
  public static Intent createIntentToModifySchedule(long paramLong, String paramString, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 3);
    localIntent.putExtra("arg_timemillis", paramLong);
    localIntent.putExtra("arg_related_subject", paramString);
    localIntent.putExtra("arg_is_full_day", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentToReadSchedule(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 4);
    localIntent.putExtra("arg_reminder_id", paramInt);
    return localIntent;
  }
  
  public static Intent createIntentToReadScheduleByScheduleId(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), CalendarFragmentActivity.class);
    localIntent.putExtra("arg_is_read_schedule_by_schedule_id", true);
    localIntent.putExtra("arg_basefragment_goto", 4);
    localIntent.putExtra("arg_schedule_id", paramInt);
    return localIntent;
  }
  
  public static QMBaseFragment getReadScheduleFragmentByReminderId(int paramInt)
  {
    Object localObject = new CalendarMainFragment();
    QMSchedule localQMSchedule = QMCalendarManager.getInstance().getScheduleByReminderId(paramInt);
    if (localQMSchedule != null)
    {
      localObject = new ReadScheduleFragment();
      ((ReadScheduleFragment)localObject).prepareEvent(localQMSchedule);
    }
    return localObject;
  }
  
  private void initializeFragment()
  {
    Object localObject1;
    try
    {
      i = getIntent().getIntExtra("arg_basefragment_goto", 0);
      if (!QMCalendarUtil.hasCalendarFolder()) {
        i = 7;
      }
      switch (i)
      {
      default: 
        if ((getIntent().getExtras() == null) || (!getIntent().getExtras().containsKey("CALENDAR_SELECT_DAY"))) {
          break label690;
        }
        CalendarMainFragment localCalendarMainFragment1 = new CalendarMainFragment(getIntent().getExtras().getLong("CALENDAR_SELECT_DAY"));
        getSupportFragmentManager().beginTransaction().add(2131367566, localCalendarMainFragment1, localCalendarMainFragment1.getClass().getSimpleName()).commit();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(6, TAG, localException.getMessage());
        i = 1;
        continue;
        if ((getIntent().getExtras() != null) && (getIntent().getExtras().containsKey("CALENDAR_SELECT_DAY")))
        {
          localObject1 = new CalendarMainFragment(getIntent().getExtras().getLong("CALENDAR_SELECT_DAY"));
        }
        else
        {
          localObject1 = new CalendarMainFragment();
          continue;
          localObject1 = new ModifyScheduleFragment(Calendar.getInstance(), getIntent().getIntExtra("arg_related_type", 0), getIntent().getStringExtra("arg_related_id"), getIntent().getIntExtra("arg_related_account_id", 0), getIntent().getStringExtra("arg_related_subject"));
          continue;
          localObject1 = new ModifyScheduleFragment(getIntent().getLongExtra("arg_timemillis", 0L), getIntent().getStringExtra("arg_related_subject"), getIntent().getBooleanExtra("arg_is_full_day", true));
        }
      }
      if (!getIntent().getBooleanExtra("arg_is_read_schedule_by_schedule_id", false)) {
        break label409;
      }
    }
    int i = getIntent().getIntExtra("arg_schedule_id", 0);
    Object localObject2 = QMCalendarManager.getInstance().getScheduleById(i);
    if (localObject2 == null)
    {
      QMLog.log(3, TAG, "can not find schedule by scheduleId : " + i);
      localObject1 = new CalendarMainFragment();
    }
    while (localObject2 != null)
    {
      localObject1 = new ReadScheduleFragment();
      ((ReadScheduleFragment)localObject1).prepareEvent((QMSchedule)localObject2);
      break;
      label409:
      i = getIntent().getIntExtra("arg_reminder_id", 0);
      localObject1 = QMCalendarManager.getInstance().getScheduleByReminderId(i);
      if (localObject1 == null)
      {
        QMLog.log(3, TAG, "can not find schedule by reminderId : " + i);
        localCalendarMainFragment2 = new CalendarMainFragment();
        localObject2 = localObject1;
        localObject1 = localCalendarMainFragment2;
        continue;
        localObject1 = new CalendarMainFragment(getIntent().getLongExtra("arg_timemillis", 0L));
        break;
        localObject1 = new CalendarNoneFragment();
        break;
        localObject1 = getIntent().getSerializableExtra("arg_new_event");
        if ((localObject1 != null) && ((localObject1 instanceof QMCalendarEvent)))
        {
          localObject1 = (QMCalendarEvent)localObject1;
          createEvent((QMCalendarEvent)localObject1);
          localObject1 = new CalendarMainFragment(((QMCalendarEvent)localObject1).getStartTime());
          break;
        }
        localObject1 = new CalendarMainFragment();
        break;
        if ((getIntent().getStringExtra("arg_code") != null) && (getIntent().getIntExtra("arg_follow_account_id", 0) != 0))
        {
          localObject1 = new CalendarListFragment(getIntent().getStringExtra("arg_code"), getIntent().getIntExtra("arg_follow_account_id", 0));
          break;
        }
        localObject1 = new CalendarListFragment(getIntent().getIntExtra("arg_calendar_list_from", 0));
        break;
        localObject1 = new CalendarChooseAccountFragment(getIntent().getStringExtra("arg_code"));
        break;
        localObject1 = new ReadScheduleFragment((CreditCardBill)getIntent().getParcelableExtra("org_creditcardbill"));
        KvHelper.creditCardBillRemingdPushClick(new double[0]);
        break;
        label690:
        localObject1 = new CalendarMainFragment();
        break;
      }
      CalendarMainFragment localCalendarMainFragment2 = null;
      localObject2 = localObject1;
      localObject1 = localCalendarMainFragment2;
      continue;
      localObject1 = null;
    }
  }
  
  public void createEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    paramQMCalendarEvent.setSvrId("");
    paramQMCalendarEvent.setPath("");
    paramQMCalendarEvent.setSensivity(0);
    paramQMCalendarEvent.setTimezone(String.valueOf(QMCalendarManager.timeZone));
    paramQMCalendarEvent.setCreateTime(QMCalendarUtil.correctTimeToSecond(System.currentTimeMillis()));
    paramQMCalendarEvent.setAccountId(QMCalendarManager.getInstance().getDefaultAccountId());
    paramQMCalendarEvent.setCalderFolderId(QMCalendarManager.getInstance().getDefaultFolderId());
    if (QMCalendarManager.getInstance().getDefaultAccountId() == 0) {
      paramQMCalendarEvent.setCategory(1);
    }
    paramQMCalendarEvent.setUid(QMCalendarEvent.generateUid(paramQMCalendarEvent));
    paramQMCalendarEvent.setId(QMCalendarEvent.generateId(paramQMCalendarEvent));
    if (paramQMCalendarEvent.isLunarCalendar())
    {
      QMCalendarFolder localQMCalendarFolder = QMCalendarManager.getInstance().getCalendarFolder(paramQMCalendarEvent.getAccountId(), paramQMCalendarEvent.getCalderFolderId());
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramQMCalendarEvent.getAccountId());
      if (((localQMCalendarFolder == null) && (localAccount == null)) || (!localAccount.isQQMail()))
      {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(this).setTitle(2131691228)).setMessage(2131691227).addAction(2131696547, new CalendarFragmentActivity.1(this))).create().show();
        return;
      }
    }
    if (paramQMCalendarEvent.getCategory() == 1)
    {
      CalendarProviderManager.sharedInstance().createLocalEvent(paramQMCalendarEvent);
      return;
    }
    QMCalendarManager.getInstance().createEvent(paramQMCalendarEvent);
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
    try
    {
      this.animationType = getIntent().getIntExtra("animationType", 0);
      if (this.animationType == 1)
      {
        overridePendingTransition(2130772401, 2130772430);
        initializeFragment();
        StatusBarUtil.immerseWhite(this);
        ShortcutGuidance.addUsedTimes("FEATURE_CALENDAR");
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QMLog.log(6, TAG, paramBundle.getMessage());
        continue;
        if (this.animationType == 2) {
          overridePendingTransition(2130772422, 2130772419);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.animationType == 1) {
      overridePendingTransition(0, 2130772402);
    }
    while (this.animationType != 2) {
      return;
    }
    overridePendingTransition(2130772421, 2130772420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity
 * JD-Core Version:    0.7.0.1
 */