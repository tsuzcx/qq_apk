package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaCalendar
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_ALARM_T = "alarm_t";
  private static final String PARAM_ALL_DAY = "allDay";
  private static final String PARAM_CODE = "code";
  private static final String PARAM_E_T = "e_t";
  private static final String PARAM_LOCATION = "location";
  private static final String PARAM_NOTES = "notes";
  private static final String PARAM_RECUR_DESC = "recur_desc";
  private static final String PARAM_R_CALENDAR_TYPE = "r_calendarType";
  private static final String PARAM_R_DAY_OF_MONTH = "r_dayOfMonth";
  private static final String PARAM_R_DAY_OF_WEEK = "r_dayOfWeek";
  private static final String PARAM_R_MONTH_OF_YEAR = "r_monthOfYear";
  private static final String PARAM_R_WEEK_OF_MONTH = "r_weekOfMonth";
  private static final String PARAM_SUBJECT = "subject";
  private static final String PARAM_S_T = "s_t";
  private static final String TAG = "SchemaCalendar";
  private static final String VALUE_ACCEPT_SHARE = "accept_share";
  private static final String VALUE_ADD = "add";
  private static final String VALUE_LIST = "list";
  private String action = null;
  private String alarm_t = null;
  private String allDay = null;
  private String code = null;
  private String e_t = null;
  private String location = null;
  private String notes = null;
  private String r_calendarType = null;
  private String r_dayOfMonth = null;
  private String r_dayOfWeek = null;
  private String r_monthOfYear = null;
  private String r_weekOfMonth = null;
  private String recur_desc = null;
  private String s_t = null;
  private String subject = null;
  
  public SchemaCalendar(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private QMCalendarEvent parseCalendarEvent()
  {
    boolean bool2 = true;
    Object localObject2 = null;
    QMCalendarEvent localQMCalendarEvent = new QMCalendarEvent();
    label42:
    label70:
    int i;
    label109:
    label126:
    boolean bool1;
    if (this.notes == null)
    {
      localObject1 = null;
      localQMCalendarEvent.setBody((String)localObject1);
      if (this.s_t != null) {
        break label345;
      }
      localObject1 = "0";
      localQMCalendarEvent.setStartTime(Long.valueOf((String)localObject1).longValue() * 1000L);
      if (this.e_t != null) {
        break label354;
      }
      localObject1 = "0";
      localQMCalendarEvent.setEndTime(Long.valueOf((String)localObject1).longValue() * 1000L);
      if (this.alarm_t != null) {
        break label373;
      }
      if (!localQMCalendarEvent.isAllDay()) {
        break label363;
      }
      i = QMCalendarManager.getInstance().getDefaultAllDayReminderTime();
      localQMCalendarEvent.setReminder(i);
      if (this.recur_desc != null) {
        break label387;
      }
      localObject1 = "-1";
      localQMCalendarEvent.setRecurrenceType(Integer.valueOf((String)localObject1).intValue());
      if (this.subject != null) {
        break label396;
      }
      localObject1 = null;
      label149:
      localQMCalendarEvent.setSubject((String)localObject1);
      if (this.location != null) {
        break label411;
      }
      localObject1 = localObject2;
      label167:
      localQMCalendarEvent.setLocation((String)localObject1);
      if ((this.allDay == null) || (!this.allDay.equals("1"))) {
        break label426;
      }
      bool1 = true;
      label195:
      localQMCalendarEvent.setIsAllDay(bool1);
      if ((this.r_calendarType == null) || (!this.r_calendarType.equals(String.valueOf(15)))) {
        break label431;
      }
      bool1 = bool2;
      label225:
      localQMCalendarEvent.setIsLunarCalendar(bool1);
      if (this.r_dayOfWeek != null) {
        break label436;
      }
      localObject1 = "0";
      label242:
      localQMCalendarEvent.setDayOfWeek(Integer.valueOf((String)localObject1).intValue());
      if (this.r_dayOfMonth != null) {
        break label445;
      }
      localObject1 = "0";
      label266:
      localQMCalendarEvent.setDayOfMonth(Integer.valueOf((String)localObject1).intValue());
      if (this.r_monthOfYear != null) {
        break label454;
      }
      localObject1 = "0";
      label290:
      localQMCalendarEvent.setMonthOfYear(Integer.valueOf((String)localObject1).intValue());
      if (this.r_weekOfMonth != null) {
        break label463;
      }
    }
    label387:
    label396:
    label411:
    label426:
    label431:
    label436:
    label445:
    label454:
    label463:
    for (Object localObject1 = "0";; localObject1 = this.r_weekOfMonth)
    {
      localQMCalendarEvent.setWeekOfMonth(Integer.valueOf((String)localObject1).intValue());
      return localQMCalendarEvent;
      localObject1 = Html.fromHtml(this.notes).toString();
      break;
      label345:
      localObject1 = this.s_t;
      break label42;
      label354:
      localObject1 = this.e_t;
      break label70;
      label363:
      i = QMCalendarManager.getInstance().getDefaultReminderTime();
      break label109;
      label373:
      i = Integer.valueOf(this.alarm_t).intValue();
      break label109;
      localObject1 = this.recur_desc;
      break label126;
      localObject1 = Html.fromHtml(this.subject).toString();
      break label149;
      localObject1 = Html.fromHtml(this.location).toString();
      break label167;
      bool1 = false;
      break label195;
      bool1 = false;
      break label225;
      localObject1 = this.r_dayOfWeek;
      break label242;
      localObject1 = this.r_dayOfMonth;
      break label266;
      localObject1 = this.r_monthOfYear;
      break label290;
    }
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((!QMSettingManager.sharedInstance().getCalendarDisplay()) || (!QMCalendarUtil.hasCalendarFolder())) {
      if (AccountManager.shareInstance().getAccountList().size() == 0) {
        localObject1 = AccountTypeListActivity.createIntent("extra_from_schema");
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      ((Intent)localObject1).putExtra("from", "from_schema");
      this.context.startActivity((Intent)localObject1);
      return true;
      localObject1 = localObject2;
      if (this.action != null) {
        if (this.action.equals(Boolean.valueOf(this.action.equals("add"))))
        {
          localObject1 = SettingCalendarActivity.createIntentWithiTips(QMApplicationContext.sharedInstance().getString(2131691098));
        }
        else
        {
          localObject1 = localObject2;
          if (this.action.equals("accept_share"))
          {
            localObject1 = SettingCalendarActivity.createIntentWithiTips(QMApplicationContext.sharedInstance().getString(2131691099));
            continue;
            if (this.action != null)
            {
              if (this.action.equals("list"))
              {
                localObject1 = CalendarFragmentActivity.createIntent();
              }
              else if ((this.action.equals("add")) || ("".equals(this.action)))
              {
                localObject1 = CalendarFragmentActivity.createIntentToAddEvent(parseCalendarEvent());
              }
              else
              {
                localObject1 = localObject2;
                if (this.action.equals("accept_share"))
                {
                  localObject1 = AccountManager.shareInstance().getAccountList();
                  int i = ((AccountList)localObject1).getPureQQMailAccountNumber();
                  if (i == 0) {
                    localObject1 = LoginFragmentActivity.createIntentFromSchema("CALENDAR", "", String.valueOf(AccountType.qqmail));
                  } else if (i == 1) {
                    localObject1 = CalendarFragmentActivity.createIntentToCalendarListToShare(((AccountList)localObject1).getFirstQQMailAccount().getId(), this.code);
                  } else {
                    localObject1 = CalendarFragmentActivity.createIntentToCalendarChooseAccount(this.code);
                  }
                }
              }
            }
            else {
              localObject1 = CalendarFragmentActivity.createIntentToAddEvent(parseCalendarEvent());
            }
          }
        }
      }
    }
    return false;
  }
  
  public void parseParams()
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            localObject = arrayOfString[i].split("=");
            if (localObject.length != 2) {
              break label363;
            }
            str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("notes")) {
              this.notes = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaCalendar", localException.getMessage());
      }
      return;
      if (str.equals("s_t")) {
        this.s_t = ((String)localObject);
      } else if (str.equals("e_t")) {
        this.e_t = ((String)localObject);
      } else if (str.equals("alarm_t")) {
        this.alarm_t = ((String)localObject);
      } else if (str.equals("recur_desc")) {
        this.recur_desc = ((String)localObject);
      } else if (str.equals("subject")) {
        this.subject = ((String)localObject);
      } else if (str.equals("location")) {
        this.location = ((String)localObject);
      } else if (str.equals("allDay")) {
        this.allDay = ((String)localObject);
      } else if (str.equals("r_calendarType")) {
        this.r_calendarType = ((String)localObject);
      } else if (str.equals("r_dayOfWeek")) {
        this.r_dayOfWeek = ((String)localObject);
      } else if (str.equals("r_dayOfMonth")) {
        this.r_dayOfMonth = ((String)localObject);
      } else if (str.equals("r_monthOfYear")) {
        this.r_monthOfYear = ((String)localObject);
      } else if (str.equals("r_weekOfMonth")) {
        this.r_weekOfMonth = ((String)localObject);
      } else if (str.equals("code")) {
        this.code = ((String)localObject);
      }
      label363:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaCalendar
 * JD-Core Version:    0.7.0.1
 */