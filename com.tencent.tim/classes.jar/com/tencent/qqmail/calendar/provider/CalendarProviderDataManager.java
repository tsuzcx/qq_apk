package com.tencent.qqmail.calendar.provider;

import alld;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.provider.model.CPAttendee;
import com.tencent.qqmail.calendar.provider.model.CPCalendar;
import com.tencent.qqmail.calendar.provider.model.CPEvent;
import com.tencent.qqmail.calendar.provider.model.CPInstance;
import com.tencent.qqmail.calendar.provider.model.CPReminder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;

public class CalendarProviderDataManager
{
  private static final String ACCOUNT_TYPE_LOCAL = "LOCAL";
  private static final Uri ATTENDEES_URI = Uri.parse("content://com.android.calendar/attendees");
  public static final String ATTENDEE_EMAIL = "attendeeEmail";
  public static final String ATTENDEE_EVENT_ID = "event_id";
  public static final String ATTENDEE_ID = "_id";
  public static final String ATTENDEE_IDENTITY = "attendeeIdentity";
  public static final String ATTENDEE_ID_NAMESPACE = "attendeeIdNamespace";
  public static final String ATTENDEE_NAME = "attendeeName";
  public static final String ATTENDEE_RELATIONSHIP = "attendeeRelationship";
  public static final String ATTENDEE_STATUS = "attendeeStatus";
  public static final String ATTENDEE_TYPE = "attendeeType";
  private static final String AUTHORITY = "com.android.calendar";
  private static final Uri CALENDARS_URI = Uri.parse("content://com.android.calendar/calendars");
  public static final String CALENDAR_ACCESS_LEVEL = "calendar_access_level";
  private static final String CALENDAR_ACCOUNT_NAME = "account_name";
  private static final String CALENDAR_ACCOUNT_TYPE = "account_type";
  public static final String CALENDAR_ALLOWED_ATTENDEE_TYPES = "allowedAttendeeTypes";
  public static final String CALENDAR_ALLOWED_AVAILABILITY = "allowedAvailability";
  public static final String CALENDAR_ALLOWED_REMINDERS = "allowedReminders";
  public static final String CALENDAR_CAN_MODIFY_TIME_ZONE = "canModifyTimeZone";
  public static final String CALENDAR_CAN_ORGANIZER_RESPOND = "canOrganizerRespond";
  public static final String CALENDAR_CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";
  public static final String CALENDAR_COLOR = "calendar_color";
  public static final String CALENDAR_COLOR_KEY = "calendar_color_index";
  public static final String CALENDAR_DELETED = "deleted";
  public static final String CALENDAR_DIRTY = "dirty";
  public static final String CALENDAR_DISPLAY_NAME = "calendar_displayName";
  public static final String CALENDAR_ID = "_id";
  public static final String CALENDAR_IS_PRIMARY = "isPrimary";
  public static final String CALENDAR_LOCATION = "calendar_location";
  public static final String CALENDAR_MAX_REMINDERS = "maxReminders";
  public static final String CALENDAR_NAME = "name";
  public static final String CALENDAR_OWNER_ACCOUNT = "ownerAccount";
  public static final String CALENDAR_SYNC_EVENTS = "sync_events";
  public static final String CALENDAR_SYNC_ID = "_sync_id";
  public static final String CALENDAR_TIME_ZONE = "calendar_timezone";
  public static final String CALENDAR_VISIBLE = "visible";
  private static final String CALLER_IS_SYNCADAPTER = "caller_is_syncadapter";
  public static final String CAL_SYNC1 = "cal_sync1";
  public static final String CAL_SYNC10 = "cal_sync10";
  public static final String CAL_SYNC2 = "cal_sync2";
  public static final String CAL_SYNC3 = "cal_sync3";
  public static final String CAL_SYNC4 = "cal_sync4";
  public static final String CAL_SYNC5 = "cal_sync5";
  public static final String CAL_SYNC6 = "cal_sync6";
  public static final String CAL_SYNC7 = "cal_sync7";
  public static final String CAL_SYNC8 = "cal_sync8";
  public static final String CAL_SYNC9 = "cal_sync9";
  private static final Uri EVENTS_EXCEPTION_URI;
  private static final Uri EVENTS_URI = Uri.parse("content://com.android.calendar/events");
  public static final String EVENT_ACCESS_LEVEL = "accessLevel";
  private static final String EVENT_ACCOUNT_NAME = "account_name";
  private static final String EVENT_ACCOUNT_TYPE = "account_type";
  public static final String EVENT_ALL_DAY = "allDay";
  public static final String EVENT_AVAILABILITY = "availability";
  public static final String EVENT_CALENDAR_ID = "calendar_id";
  public static final String EVENT_CAN_INVITE_OTHERS = "canInviteOthers";
  public static final String EVENT_CAN_PARTIALLY_UPDATE = "canPartiallyUpdate";
  public static final String EVENT_COLOR = "eventColor";
  public static final String EVENT_COLOR_KEY = "eventColor_index";
  public static final String EVENT_CUSTOM_APP_PACKAGE = "customAppPackage";
  public static final String EVENT_CUSTOM_APP_URI = "customAppUri";
  public static final String EVENT_DELETED = "deleted";
  public static final String EVENT_DESCRIPTION = "description";
  public static final String EVENT_DIRTY = "dirty";
  public static final String EVENT_DISPLAY_COLOR = "displayColor";
  public static final String EVENT_DTEND = "dtend";
  public static final String EVENT_DTSTART = "dtstart";
  public static final String EVENT_DURATION = "duration";
  public static final String EVENT_END_TIMEZONE = "eventEndTimezone";
  public static final String EVENT_EXDATE = "exdate";
  public static final String EVENT_EXRULE = "exrule";
  public static final String EVENT_GUESTS_CAN_INVITE_OTHERS = "guestsCanInviteOthers";
  public static final String EVENT_GUESTS_CAN_MODIFY = "guestsCanModify";
  public static final String EVENT_GUESTS_CAN_SEE_GUESTS = "guestsCanSeeGuests";
  public static final String EVENT_HAS_ALARM = "hasAlarm";
  public static final String EVENT_HAS_ATTENDEE_DATA = "hasAttendeeData";
  public static final String EVENT_HAS_EXTENDED_PROPERTIES = "hasExtendedProperties";
  public static final String EVENT_ID = "_id";
  public static final String EVENT_IS_ORGANIZER = "isOrganizer";
  public static final String EVENT_LAST_DATE = "lastDate";
  public static final String EVENT_LAST_SYNCED = "lastSynced";
  public static final String EVENT_LOCATION = "eventLocation";
  public static final String EVENT_MUTATORS = "mutators";
  public static final String EVENT_ORGANIZER = "organizer";
  public static final String EVENT_ORIGINAL_ALL_DAY = "originalAllDay";
  public static final String EVENT_ORIGINAL_ID = "original_id";
  public static final String EVENT_ORIGINAL_INSTANCE_TIME = "originalInstanceTime";
  public static final String EVENT_ORIGINAL_SYNC_ID = "original_sync_id";
  public static final String EVENT_RDATE = "rdate";
  public static final String EVENT_RRULE = "rrule";
  public static final String EVENT_SELF_ATTENDEE_STATUS = "selfAttendeeStatus";
  public static final String EVENT_STATUS = "eventStatus";
  public static final String EVENT_SYNC_ID = "_sync_id";
  public static final String EVENT_TIMEZONE = "eventTimezone";
  public static final String EVENT_TITLE = "title";
  public static final String EVENT_UID_2445 = "uid2445";
  public static final String INSTANCE_BEGIN = "begin";
  public static final String INSTANCE_END = "end";
  public static final String INSTANCE_END_DAY = "endDay";
  public static final String INSTANCE_END_MINUTE = "endMinute";
  public static final String INSTANCE_EVENT_ID = "event_id";
  public static final String INSTANCE_ID = "_id";
  public static final String INSTANCE_START_DAY = "startDay";
  public static final String INSTANCE_START_MINUTE = "startMinute";
  private static final Uri REMINDERS_URI = Uri.parse("content://com.android.calendar/reminders");
  public static final String REMINDER_EVENT_ID = "event_id";
  public static final String REMINDER_ID = "_id";
  public static final String REMINDER_METHOD = "method";
  public static final String REMINDER_MINUTES = "minutes";
  public static final String SYNC_DATA1 = "sync_data1";
  public static final String SYNC_DATA10 = "sync_data10";
  public static final String SYNC_DATA2 = "sync_data2";
  public static final String SYNC_DATA3 = "sync_data3";
  public static final String SYNC_DATA4 = "sync_data4";
  public static final String SYNC_DATA5 = "sync_data5";
  public static final String SYNC_DATA6 = "sync_data6";
  public static final String SYNC_DATA7 = "sync_data7";
  public static final String SYNC_DATA8 = "sync_data8";
  public static final String SYNC_DATA9 = "sync_data9";
  private static final String TAG = "CalendarProviderDataManager";
  private static CalendarProviderDataManager instance;
  protected String[] ATTENDEE_PROJECTION = { "_id", "event_id", "attendeeName", "attendeeEmail", "attendeeType", "attendeeStatus" };
  protected String[] CALENDAR_PROJECTION = { "_id", "name", "calendar_color", "calendar_displayName", "calendar_access_level", "visible", "ownerAccount", "account_name", "account_type" };
  protected String[] EVENT_PROJECTION = { "_id", "calendar_id", "title", "description", "eventLocation", "eventStatus", "dtstart", "dtend", "duration", "eventTimezone", "eventEndTimezone", "allDay", "rrule", "rdate", "exrule", "exdate", "original_id", "original_sync_id", "originalInstanceTime", "originalAllDay", "hasAttendeeData", "guestsCanModify", "guestsCanInviteOthers", "guestsCanSeeGuests", "organizer", "account_name", "account_type", "_sync_id" };
  protected String[] INSTANCE_PROJECTION = { "_id", "begin", "end", "event_id", "startDay", "endDay", "startMinute", "endMinute" };
  protected String[] REMINDER_PROJECTION = { "_id", "event_id", "method", "minutes" };
  private ConcurrentHashMap<String, Integer> mAttendeeColumnMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mCalendarColumnMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mEventColumnMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, Integer> mReminderColumnMap = new ConcurrentHashMap();
  private ContentResolver resolver = QMApplicationContext.sharedInstance().getContentResolver();
  
  static
  {
    EVENTS_EXCEPTION_URI = Uri.parse("content://com.android.calendar/exception");
  }
  
  private static Uri asCalendarSyncAdapter(Uri paramUri, String paramString1, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramString1).appendQueryParameter("account_type", paramString2).build();
  }
  
  private static Uri asEventSyncAdapter(Uri paramUri, String paramString1, String paramString2)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", paramString1).appendQueryParameter("account_type", paramString2).build();
  }
  
  private int getColumnIndex(Cursor paramCursor, ConcurrentHashMap<String, Integer> paramConcurrentHashMap, String paramString)
  {
    if (!paramConcurrentHashMap.containsKey(paramString)) {
      paramConcurrentHashMap.put(paramString, Integer.valueOf(paramCursor.getColumnIndex(paramString)));
    }
    return ((Integer)paramConcurrentHashMap.get(paramString)).intValue();
  }
  
  public static CalendarProviderDataManager sharedInstance()
  {
    if (instance == null) {
      instance = new CalendarProviderDataManager();
    }
    return instance;
  }
  
  public void deleteAttendee(ArrayList<CPAttendee> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPAttendee localCPAttendee = (CPAttendee)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newDelete(getAttendeeUri(paramString1, paramString2)).withSelection("_id=?", new String[] { String.valueOf(localCPAttendee.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "delete attendee error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "delete event: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "delete attendee none");
  }
  
  public void deleteCalendar(CPCalendar paramCPCalendar)
  {
    try
    {
      int i = getContentResolver().delete(getCalendarUri(paramCPCalendar.getAccountName(), paramCPCalendar.getAccountType()), "_id=?", new String[] { String.valueOf(paramCPCalendar.getId()) });
      QMLog.log(4, "CalendarProviderDataManager", "delete calendar id:" + paramCPCalendar.getId() + " delete result " + i);
      return;
    }
    catch (Exception paramCPCalendar)
    {
      QMLog.log(6, "CalendarProviderDataManager", "delete calendar error :" + Log.getStackTraceString(paramCPCalendar));
    }
  }
  
  public void deleteCalendar(ArrayList<CPCalendar> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPCalendar localCPCalendar = (CPCalendar)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newDelete(getCalendarUri(localCPCalendar.getAccountName(), localCPCalendar.getAccountType())).withSelection("_id=?", new String[] { String.valueOf(localCPCalendar.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "delete calendar error :" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "delete calendar: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "delete calendar none");
  }
  
  /* Error */
  public int deleteEvent(CPEvent paramCPEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 555	com/tencent/qqmail/calendar/provider/CalendarProviderDataManager:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 607	com/tencent/qqmail/calendar/provider/model/CPEvent:getAccountName	()Ljava/lang/String;
    //   9: aload_1
    //   10: invokevirtual 608	com/tencent/qqmail/calendar/provider/model/CPEvent:getAccountType	()Ljava/lang/String;
    //   13: invokevirtual 611	com/tencent/qqmail/calendar/provider/CalendarProviderDataManager:getEventUri	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   16: ldc_w 507
    //   19: iconst_1
    //   20: anewarray 396	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: aload_1
    //   26: invokevirtual 612	com/tencent/qqmail/calendar/provider/model/CPEvent:getId	()J
    //   29: invokestatic 514	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: aastore
    //   33: invokevirtual 587	android/content/ContentResolver:delete	(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: istore_2
    //   37: iconst_4
    //   38: ldc_w 335
    //   41: new 528	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 614
    //   51: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_1
    //   55: invokevirtual 612	com/tencent/qqmail/calendar/provider/model/CPEvent:getId	()J
    //   58: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 545	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 551	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   67: iload_2
    //   68: ireturn
    //   69: astore_1
    //   70: iconst_m1
    //   71: istore_2
    //   72: bipush 6
    //   74: ldc_w 335
    //   77: new 528	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 616
    //   87: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_1
    //   91: invokestatic 541	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   94: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 545	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 551	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   103: iload_2
    //   104: ireturn
    //   105: astore_1
    //   106: goto -34 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	CalendarProviderDataManager
    //   0	109	1	paramCPEvent	CPEvent
    //   36	68	2	i	int
    // Exception table:
    //   from	to	target	type
    //   0	37	69	java/lang/Exception
    //   37	67	105	java/lang/Exception
  }
  
  public void deleteEvent(ArrayList<CPEvent> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPEvent localCPEvent = (CPEvent)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newDelete(getEventUri(localCPEvent.getAccountName(), localCPEvent.getAccountType())).withSelection("_id=?", new String[] { String.valueOf(localCPEvent.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "delete event error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "delete event: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "delete event none");
  }
  
  public void deleteReminder(ArrayList<CPReminder> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPReminder localCPReminder = (CPReminder)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newDelete(getReminderUri(paramString1, paramString2)).withSelection("_id=?", new String[] { String.valueOf(localCPReminder.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "delete reminder error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "delete reminder: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "delete reminder none");
  }
  
  protected CPAttendee fillAttendee(Cursor paramCursor)
  {
    CPAttendee localCPAttendee = new CPAttendee();
    localCPAttendee.setId(paramCursor.getLong(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "_id")));
    localCPAttendee.setEventId(paramCursor.getLong(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "event_id")));
    localCPAttendee.setAttendeeName(paramCursor.getString(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "attendeeName")));
    localCPAttendee.setAttendeeEmail(paramCursor.getString(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "attendeeEmail")));
    localCPAttendee.setAttendeeType(paramCursor.getInt(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "attendeeType")));
    localCPAttendee.setAttendeeStatus(paramCursor.getInt(getColumnIndex(paramCursor, this.mAttendeeColumnMap, "attendeeStatus")));
    return localCPAttendee;
  }
  
  protected CPCalendar fillCalendar(Cursor paramCursor)
  {
    CPCalendar localCPCalendar = new CPCalendar();
    localCPCalendar.setId(paramCursor.getLong(getColumnIndex(paramCursor, this.mCalendarColumnMap, "_id")));
    localCPCalendar.setName(paramCursor.getString(getColumnIndex(paramCursor, this.mCalendarColumnMap, "name")));
    localCPCalendar.setCalendarColor(paramCursor.getInt(paramCursor.getColumnIndex("calendar_color")));
    localCPCalendar.setCalendarDisplayName(paramCursor.getString(getColumnIndex(paramCursor, this.mCalendarColumnMap, "calendar_displayName")));
    localCPCalendar.setCalendarAccessLevel(paramCursor.getInt(getColumnIndex(paramCursor, this.mCalendarColumnMap, "calendar_access_level")));
    localCPCalendar.setVisible(paramCursor.getInt(getColumnIndex(paramCursor, this.mCalendarColumnMap, "visible")));
    localCPCalendar.setOwnerAccount(paramCursor.getString(getColumnIndex(paramCursor, this.mCalendarColumnMap, "ownerAccount")));
    localCPCalendar.setAccountName(paramCursor.getString(getColumnIndex(paramCursor, this.mCalendarColumnMap, "account_name")));
    localCPCalendar.setAccountType(paramCursor.getString(getColumnIndex(paramCursor, this.mCalendarColumnMap, "account_type")));
    return localCPCalendar;
  }
  
  protected CPEvent fillEvent(Cursor paramCursor)
  {
    CPEvent localCPEvent = new CPEvent();
    localCPEvent.setId(paramCursor.getLong(getColumnIndex(paramCursor, this.mEventColumnMap, "_id")));
    localCPEvent.setCalendarId(paramCursor.getLong(getColumnIndex(paramCursor, this.mEventColumnMap, "calendar_id")));
    localCPEvent.setTitle(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "title")));
    localCPEvent.setDescription(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "description")));
    localCPEvent.setEventLocation(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "eventLocation")));
    localCPEvent.setStatus(paramCursor.getInt(getColumnIndex(paramCursor, this.mEventColumnMap, "eventStatus")));
    localCPEvent.setDtStart(paramCursor.getLong(getColumnIndex(paramCursor, this.mEventColumnMap, "dtstart")));
    localCPEvent.setDtEnd(paramCursor.getLong(getColumnIndex(paramCursor, this.mEventColumnMap, "dtend")));
    localCPEvent.setDuration(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "duration")));
    localCPEvent.setEventTimezone(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "eventTimezone")));
    localCPEvent.setEventEndTimezone(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "eventEndTimezone")));
    localCPEvent.setAllDay(paramCursor.getInt(getColumnIndex(paramCursor, this.mEventColumnMap, "allDay")));
    localCPEvent.setRrule(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "rrule")));
    localCPEvent.setRdate(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "rdate")));
    localCPEvent.setExrule(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "exrule")));
    localCPEvent.setExdate(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "exdate")));
    localCPEvent.setOriginalId(paramCursor.getLong(getColumnIndex(paramCursor, this.mEventColumnMap, "original_id")));
    localCPEvent.setOriginalSyncId(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "original_sync_id")));
    localCPEvent.setOriginalInstanceTime(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "originalInstanceTime")));
    localCPEvent.setOriginalAllDay(paramCursor.getInt(getColumnIndex(paramCursor, this.mEventColumnMap, "originalAllDay")));
    localCPEvent.setHasAttendeeData(paramCursor.getInt(getColumnIndex(paramCursor, this.mEventColumnMap, "hasAttendeeData")));
    localCPEvent.setOrganizer(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "organizer")));
    localCPEvent.setAccountName(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "account_name")));
    localCPEvent.setAccountType(paramCursor.getString(getColumnIndex(paramCursor, this.mEventColumnMap, "account_type")));
    localCPEvent.setSyncId(paramCursor.getString(paramCursor.getColumnIndex("_sync_id")));
    return localCPEvent;
  }
  
  protected CPInstance fillInstance(Cursor paramCursor)
  {
    CPInstance localCPInstance = new CPInstance();
    localCPInstance.setId(paramCursor.getLong(paramCursor.getColumnIndex("_id")));
    localCPInstance.setBegin(paramCursor.getLong(paramCursor.getColumnIndex("begin")));
    localCPInstance.setEnd(paramCursor.getLong(paramCursor.getColumnIndex("end")));
    localCPInstance.setEventId(paramCursor.getLong(paramCursor.getColumnIndex("event_id")));
    localCPInstance.setStartDay(paramCursor.getInt(paramCursor.getColumnIndex("startDay")));
    localCPInstance.setEndDay(paramCursor.getInt(paramCursor.getColumnIndex("endDay")));
    localCPInstance.setStartMinute(paramCursor.getInt(paramCursor.getColumnIndex("startMinute")));
    localCPInstance.setEndMinute(paramCursor.getInt(paramCursor.getColumnIndex("endMinute")));
    return localCPInstance;
  }
  
  protected CPReminder fillReminder(Cursor paramCursor)
  {
    CPReminder localCPReminder = new CPReminder();
    localCPReminder.setId(paramCursor.getLong(getColumnIndex(paramCursor, this.mReminderColumnMap, "_id")));
    localCPReminder.setEventId(paramCursor.getLong(getColumnIndex(paramCursor, this.mReminderColumnMap, "event_id")));
    localCPReminder.setMethod(paramCursor.getInt(getColumnIndex(paramCursor, this.mReminderColumnMap, "method")));
    localCPReminder.setMinutes(paramCursor.getInt(getColumnIndex(paramCursor, this.mReminderColumnMap, "minutes")));
    return localCPReminder;
  }
  
  protected ContentValues getAttendeeContentValues(CPAttendee paramCPAttendee)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_id", Long.valueOf(paramCPAttendee.getEventId()));
    localContentValues.put("attendeeName", paramCPAttendee.getAttendeeName());
    localContentValues.put("attendeeEmail", paramCPAttendee.getAttendeeEmail());
    localContentValues.put("attendeeType", Integer.valueOf(paramCPAttendee.getAttendeeType()));
    localContentValues.put("attendeeStatus", Integer.valueOf(paramCPAttendee.getAttendeeStatus()));
    return localContentValues;
  }
  
  public Uri getAttendeeUri()
  {
    return ATTENDEES_URI;
  }
  
  public Uri getAttendeeUri(String paramString1, String paramString2)
  {
    return asEventSyncAdapter(ATTENDEES_URI, paramString1, paramString2);
  }
  
  protected ContentValues getCalendarContentValues(CPCalendar paramCPCalendar)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("name", paramCPCalendar.getName());
    localContentValues.put("calendar_color", Integer.valueOf(paramCPCalendar.getCalendarColor()));
    localContentValues.put("calendar_displayName", paramCPCalendar.getCalendarDisplayName());
    localContentValues.put("ownerAccount", paramCPCalendar.getOwnerAccount());
    localContentValues.put("account_name", paramCPCalendar.getAccountName());
    localContentValues.put("account_type", paramCPCalendar.getAccountType());
    return localContentValues;
  }
  
  public Uri getCalendarUri()
  {
    return CALENDARS_URI;
  }
  
  public Uri getCalendarUri(String paramString1, String paramString2)
  {
    return asCalendarSyncAdapter(CALENDARS_URI, paramString1, paramString2);
  }
  
  public ContentResolver getContentResolver()
  {
    return this.resolver;
  }
  
  protected ContentValues getEventContentValues(CPEvent paramCPEvent)
  {
    Object localObject2 = null;
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("calendar_id", Long.valueOf(paramCPEvent.getCalendarId()));
    localContentValues.put("title", paramCPEvent.getTitle());
    localContentValues.put("description", paramCPEvent.getDescription());
    localContentValues.put("eventLocation", paramCPEvent.getEventLocation());
    localContentValues.put("eventStatus", Integer.valueOf(paramCPEvent.getStatus()));
    localContentValues.put("dtstart", Long.valueOf(paramCPEvent.getDtStart()));
    if ((StringUtils.isNotBlank(paramCPEvent.getRrule())) || (StringUtils.isNotBlank(paramCPEvent.getRdate())))
    {
      localContentValues.put("duration", paramCPEvent.getDuration());
      localContentValues.put("eventTimezone", paramCPEvent.getEventTimezone());
      localContentValues.put("eventEndTimezone", paramCPEvent.getEventEndTimezone());
      localContentValues.put("allDay", Integer.valueOf(paramCPEvent.getAllDay()));
      if (!StringUtils.isBlank(paramCPEvent.getRrule())) {
        break label293;
      }
      localObject1 = null;
      label168:
      localContentValues.put("rrule", (String)localObject1);
      if (!StringUtils.isBlank(paramCPEvent.getRdate())) {
        break label301;
      }
      localObject1 = null;
      label189:
      localContentValues.put("rdate", (String)localObject1);
      if (!StringUtils.isBlank(paramCPEvent.getExrule())) {
        break label309;
      }
      localObject1 = null;
      label209:
      localContentValues.put("exrule", (String)localObject1);
      if (!StringUtils.isBlank(paramCPEvent.getExdate())) {
        break label317;
      }
    }
    label293:
    label301:
    label309:
    label317:
    for (Object localObject1 = localObject2;; localObject1 = paramCPEvent.getExdate())
    {
      localContentValues.put("exdate", (String)localObject1);
      localContentValues.put("originalAllDay", Integer.valueOf(paramCPEvent.getOriginalAllDay()));
      localContentValues.put("hasAttendeeData", Integer.valueOf(1));
      localContentValues.put("organizer", paramCPEvent.getOrganizer());
      return localContentValues;
      localContentValues.put("dtend", Long.valueOf(paramCPEvent.getDtEnd()));
      break;
      localObject1 = paramCPEvent.getRrule();
      break label168;
      localObject1 = paramCPEvent.getRdate();
      break label189;
      localObject1 = paramCPEvent.getExrule();
      break label209;
    }
  }
  
  public Uri getEventUri()
  {
    return EVENTS_URI;
  }
  
  public Uri getEventUri(String paramString1, String paramString2)
  {
    return asEventSyncAdapter(EVENTS_URI, paramString1, paramString2);
  }
  
  protected ContentValues getExceptionContentValues(CPEvent paramCPEvent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("title", paramCPEvent.getTitle());
    localContentValues.put("description", paramCPEvent.getDescription());
    localContentValues.put("eventLocation", paramCPEvent.getEventLocation());
    localContentValues.put("eventStatus", Integer.valueOf(paramCPEvent.getStatus()));
    localContentValues.put("dtstart", Long.valueOf(paramCPEvent.getDtStart()));
    localContentValues.put("duration", paramCPEvent.getDuration());
    localContentValues.put("allDay", Integer.valueOf(paramCPEvent.getAllDay()));
    localContentValues.put("originalInstanceTime", paramCPEvent.getOriginalInstanceTime());
    return localContentValues;
  }
  
  protected ContentValues getExceptionUpdateContentValues(CPEvent paramCPEvent)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("title", paramCPEvent.getTitle());
    localContentValues.put("description", paramCPEvent.getDescription());
    localContentValues.put("eventLocation", paramCPEvent.getEventLocation());
    localContentValues.put("eventStatus", Integer.valueOf(paramCPEvent.getStatus()));
    localContentValues.put("dtstart", Long.valueOf(paramCPEvent.getDtStart()));
    localContentValues.put("duration", paramCPEvent.getDuration());
    localContentValues.put("allDay", Integer.valueOf(paramCPEvent.getAllDay()));
    return localContentValues;
  }
  
  public Uri getExceptionUri(String paramString1, String paramString2, long paramLong)
  {
    return asCalendarSyncAdapter(Uri.withAppendedPath(EVENTS_EXCEPTION_URI, String.valueOf(paramLong)), paramString1, paramString2);
  }
  
  protected ContentValues getInstanceContentValue(CPInstance paramCPInstance)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", Long.valueOf(paramCPInstance.getId()));
    localContentValues.put("begin", Long.valueOf(paramCPInstance.getBegin()));
    localContentValues.put("end", Long.valueOf(paramCPInstance.getEnd()));
    localContentValues.put("event_id", Long.valueOf(paramCPInstance.getEventId()));
    localContentValues.put("startDay", Integer.valueOf(paramCPInstance.getStartDay()));
    localContentValues.put("endDay", Integer.valueOf(paramCPInstance.getEndDay()));
    localContentValues.put("startMinute", Integer.valueOf(paramCPInstance.getStartMinute()));
    localContentValues.put("endMinute", Integer.valueOf(paramCPInstance.getEndMinute()));
    return localContentValues;
  }
  
  protected ContentValues getReminderContentValues(CPReminder paramCPReminder)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("event_id", Long.valueOf(paramCPReminder.getEventId()));
    localContentValues.put("method", Integer.valueOf(paramCPReminder.getMethod()));
    localContentValues.put("minutes", Integer.valueOf(paramCPReminder.getMinutes()));
    return localContentValues;
  }
  
  public Uri getReminderUri()
  {
    return REMINDERS_URI;
  }
  
  public Uri getReminderUri(String paramString1, String paramString2)
  {
    return asEventSyncAdapter(REMINDERS_URI, paramString1, paramString2);
  }
  
  public void insertAttendee(ArrayList<CPAttendee> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPAttendee localCPAttendee = (CPAttendee)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newInsert(getAttendeeUri(paramString1, paramString2)).withValues(getAttendeeContentValues(localCPAttendee)).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "add attendee error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "add attendee: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "add attendee none");
  }
  
  public long insertCalendar(CPCalendar paramCPCalendar)
  {
    try
    {
      Uri localUri = getContentResolver().insert(getCalendarUri(paramCPCalendar.getAccountName(), paramCPCalendar.getAccountType()), getCalendarContentValues(paramCPCalendar));
      l = ContentUris.parseId(localUri);
      QMLog.log(6, "CalendarProviderDataManager", "add calendar error:" + Log.getStackTraceString(paramCPCalendar));
    }
    catch (Exception paramCPCalendar)
    {
      try
      {
        QMLog.log(4, "CalendarProviderDataManager", "add calendar id: " + paramCPCalendar.getId() + " uriId: " + localUri);
        return l;
      }
      catch (Exception paramCPCalendar)
      {
        long l;
        break label80;
      }
      paramCPCalendar = paramCPCalendar;
      l = -1L;
    }
    label80:
    return l;
  }
  
  public void insertCalendar(ArrayList<CPCalendar> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPCalendar localCPCalendar = (CPCalendar)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newInsert(getCalendarUri(localCPCalendar.getAccountName(), localCPCalendar.getAccountType())).withValues(getCalendarContentValues(localCPCalendar)).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "add calendar error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "add calendar: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "add calendar none");
  }
  
  public long insertEvent(CPEvent paramCPEvent)
  {
    try
    {
      l = ContentUris.parseId(getContentResolver().insert(getEventUri(paramCPEvent.getAccountName(), paramCPEvent.getAccountType()), getEventContentValues(paramCPEvent)));
      QMLog.log(6, "CalendarProviderDataManager", "add event error:" + Log.getStackTraceString(paramCPEvent));
    }
    catch (Exception paramCPEvent)
    {
      try
      {
        QMLog.log(4, "CalendarProviderDataManager", "add event id:" + paramCPEvent.getId() + " uriId " + l);
        return l;
      }
      catch (Exception paramCPEvent)
      {
        long l;
        break label75;
      }
      paramCPEvent = paramCPEvent;
      l = -1L;
    }
    label75:
    return l;
  }
  
  public void insertEvent(ArrayList<CPEvent> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPEvent localCPEvent = (CPEvent)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newInsert(getEventUri(localCPEvent.getAccountName(), localCPEvent.getAccountType())).withValues(getEventContentValues(localCPEvent)).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "add event error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "add event: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "add event none");
  }
  
  public long insertException(CPEvent paramCPEvent)
  {
    try
    {
      l = ContentUris.parseId(getContentResolver().insert(getExceptionUri(paramCPEvent.getAccountName(), paramCPEvent.getAccountType(), paramCPEvent.getOriginalId()), getExceptionContentValues(paramCPEvent)));
      QMLog.log(6, "CalendarProviderDataManager", "add exception error:" + Log.getStackTraceString(paramCPEvent));
    }
    catch (Exception paramCPEvent)
    {
      try
      {
        QMLog.log(4, "CalendarProviderDataManager", "add exception id:" + paramCPEvent.getId() + " uriId " + l);
        return l;
      }
      catch (Exception paramCPEvent)
      {
        long l;
        break label79;
      }
      paramCPEvent = paramCPEvent;
      l = -1L;
    }
    label79:
    return l;
  }
  
  public void insertException(ArrayList<CPEvent> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPEvent localCPEvent = (CPEvent)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newInsert(getExceptionUri(localCPEvent.getAccountName(), localCPEvent.getAccountType(), localCPEvent.getId())).withValues(getExceptionContentValues(localCPEvent)).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "insert exception exception error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "add event exception: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "add event exception none");
  }
  
  public void insertReminder(ArrayList<CPReminder> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPReminder localCPReminder = (CPReminder)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newInsert(getReminderUri(paramString1, paramString2)).withValues(getReminderContentValues(localCPReminder)).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "add reminder error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "add reminder: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "add reminder none");
  }
  
  public ArrayList<CPAttendee> queryAllAttendee()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getAttendeeUri(), this.ATTENDEE_PROJECTION, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillAttendee(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<CPCalendar> queryAllCalendar()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getCalendarUri(), this.CALENDAR_PROJECTION, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillCalendar(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<CPEvent> queryAllEvent()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getEventUri(), this.EVENT_PROJECTION, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillEvent(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<CPEvent> queryAllEvent(long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getEventUri(), this.EVENT_PROJECTION, "dtstart >= ? AND dtend <= ?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillEvent(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public HashMap<Long, ArrayList<CPReminder>> queryAllReminder()
  {
    HashMap localHashMap = new HashMap();
    Cursor localCursor = alld.query(getContentResolver(), getReminderUri(), this.REMINDER_PROJECTION, null, null, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        CPReminder localCPReminder = fillReminder(localCursor);
        if (localHashMap.containsKey(Long.valueOf(localCPReminder.getEventId())))
        {
          ((ArrayList)localHashMap.get(Long.valueOf(localCPReminder.getEventId()))).add(localCPReminder);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localCPReminder);
          localHashMap.put(Long.valueOf(localCPReminder.getEventId()), localArrayList);
        }
      }
      localCursor.close();
    }
    return localHashMap;
  }
  
  public ArrayList<CPAttendee> queryAttendeeByEventId(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getAttendeeUri(), this.ATTENDEE_PROJECTION, "event_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillAttendee(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public CPCalendar queryCalendarById(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = alld.query(getContentResolver(), getCalendarUri(), this.CALENDAR_PROJECTION, "_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToNext()) {
        localObject1 = fillCalendar(localCursor);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public ArrayList<CPCalendar> queryCalendarLocal()
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getCalendarUri(), this.CALENDAR_PROJECTION, "account_type=?", new String[] { "LOCAL" }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillCalendar(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public CPEvent queryEventById(long paramLong)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Cursor localCursor = alld.query(getContentResolver(), getEventUri(), this.EVENT_PROJECTION, "_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null)
    {
      localObject1 = localObject2;
      if (localCursor.moveToNext()) {
        localObject1 = fillEvent(localCursor);
      }
      localCursor.close();
    }
    return localObject1;
  }
  
  public ArrayList<CPEvent> queryEventLocal(long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getEventUri(), this.EVENT_PROJECTION, "account_type=? AND dtstart >= ? AND dtend <= ?", new String[] { "LOCAL", String.valueOf(paramLong1), String.valueOf(paramLong2) }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillEvent(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<CPEvent> queryExceptionEventByOriginalId(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getEventUri(), this.EVENT_PROJECTION, "original_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillEvent(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public ArrayList<CPReminder> queryReminderByEventId(long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    Cursor localCursor = alld.query(getContentResolver(), getReminderUri(), this.REMINDER_PROJECTION, "event_id=?", new String[] { String.valueOf(paramLong) }, null);
    if (localCursor != null)
    {
      while (localCursor.moveToNext()) {
        localArrayList.add(fillReminder(localCursor));
      }
      localCursor.close();
    }
    return localArrayList;
  }
  
  public void updateAttendee(ArrayList<CPAttendee> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPAttendee localCPAttendee = (CPAttendee)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newUpdate(getAttendeeUri(paramString1, paramString2)).withValues(getAttendeeContentValues(localCPAttendee)).withSelection("_id=?", new String[] { String.valueOf(localCPAttendee.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "update attendee error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "update event: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "update attendee none");
  }
  
  public void updateCalendar(CPCalendar paramCPCalendar)
  {
    try
    {
      getContentResolver().update(getCalendarUri(paramCPCalendar.getAccountName(), paramCPCalendar.getAccountType()), getCalendarContentValues(paramCPCalendar), "_id=?", new String[] { String.valueOf(paramCPCalendar.getId()) });
      QMLog.log(4, "CalendarProviderDataManager", "update calendar id:" + paramCPCalendar.getId());
      return;
    }
    catch (Exception paramCPCalendar)
    {
      QMLog.log(6, "CalendarProviderDataManager", "update calendar error:" + Log.getStackTraceString(paramCPCalendar));
    }
  }
  
  public void updateCalendar(ArrayList<CPCalendar> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPCalendar localCPCalendar = (CPCalendar)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newUpdate(getCalendarUri(localCPCalendar.getAccountName(), localCPCalendar.getAccountType())).withValues(getCalendarContentValues(localCPCalendar)).withSelection("_id=?", new String[] { String.valueOf(localCPCalendar.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "update calendar error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "update calendar: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "update calendar none");
  }
  
  public void updateEvent(CPEvent paramCPEvent)
  {
    try
    {
      getContentResolver().update(getEventUri(paramCPEvent.getAccountName(), paramCPEvent.getAccountType()), getEventContentValues(paramCPEvent), "_id=?", new String[] { String.valueOf(paramCPEvent.getId()) });
      QMLog.log(4, "CalendarProviderDataManager", "update event id:" + paramCPEvent.getId());
      return;
    }
    catch (Exception paramCPEvent)
    {
      QMLog.log(6, "CalendarProviderDataManager", "update event error:" + Log.getStackTraceString(paramCPEvent));
    }
  }
  
  public void updateEvent(ArrayList<CPEvent> paramArrayList)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPEvent localCPEvent = (CPEvent)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newUpdate(getEventUri(localCPEvent.getAccountName(), localCPEvent.getAccountType())).withValues(getEventContentValues(localCPEvent)).withSelection("_id=?", new String[] { String.valueOf(localCPEvent.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "update event error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "update event: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "update event none");
  }
  
  /* Error */
  public long updateException(CPEvent paramCPEvent)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 555	com/tencent/qqmail/calendar/provider/CalendarProviderDataManager:getContentResolver	()Landroid/content/ContentResolver;
    //   4: aload_0
    //   5: aload_1
    //   6: invokevirtual 607	com/tencent/qqmail/calendar/provider/model/CPEvent:getAccountName	()Ljava/lang/String;
    //   9: aload_1
    //   10: invokevirtual 608	com/tencent/qqmail/calendar/provider/model/CPEvent:getAccountType	()Ljava/lang/String;
    //   13: invokevirtual 611	com/tencent/qqmail/calendar/provider/CalendarProviderDataManager:getEventUri	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   16: aload_0
    //   17: aload_1
    //   18: invokevirtual 1152	com/tencent/qqmail/calendar/provider/CalendarProviderDataManager:getExceptionUpdateContentValues	(Lcom/tencent/qqmail/calendar/provider/model/CPEvent;)Landroid/content/ContentValues;
    //   21: ldc_w 507
    //   24: iconst_1
    //   25: anewarray 396	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_1
    //   31: invokevirtual 612	com/tencent/qqmail/calendar/provider/model/CPEvent:getId	()J
    //   34: invokestatic 514	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   37: aastore
    //   38: invokevirtual 1133	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   41: istore_2
    //   42: iload_2
    //   43: i2l
    //   44: lstore_3
    //   45: iconst_4
    //   46: ldc_w 335
    //   49: new 528	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   56: ldc_w 1154
    //   59: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_1
    //   63: invokevirtual 612	com/tencent/qqmail/calendar/provider/model/CPEvent:getId	()J
    //   66: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   69: ldc_w 1156
    //   72: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: lload_3
    //   76: invokevirtual 592	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   79: invokevirtual 545	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 551	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   85: lload_3
    //   86: lreturn
    //   87: astore_1
    //   88: ldc2_w 1001
    //   91: lstore_3
    //   92: bipush 6
    //   94: ldc_w 335
    //   97: new 528	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 529	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 1158
    //   107: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload_1
    //   111: invokestatic 541	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   114: invokevirtual 535	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 545	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 551	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   123: lload_3
    //   124: lreturn
    //   125: astore_1
    //   126: goto -34 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	129	0	this	CalendarProviderDataManager
    //   0	129	1	paramCPEvent	CPEvent
    //   41	2	2	i	int
    //   44	80	3	l	long
    // Exception table:
    //   from	to	target	type
    //   0	42	87	java/lang/Exception
    //   45	85	125	java/lang/Exception
  }
  
  public void updateReminder(ArrayList<CPReminder> paramArrayList, String paramString1, String paramString2)
  {
    for (;;)
    {
      ArrayList localArrayList;
      try
      {
        localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (paramArrayList.hasNext())
        {
          CPReminder localCPReminder = (CPReminder)paramArrayList.next();
          localArrayList.add(ContentProviderOperation.newUpdate(getReminderUri(paramString1, paramString2)).withValues(getReminderContentValues(localCPReminder)).withSelection("_id=?", new String[] { String.valueOf(localCPReminder.getId()) }).build());
          continue;
        }
        if (localArrayList.size() <= 0) {
          break;
        }
      }
      catch (Exception paramArrayList)
      {
        QMLog.log(6, "CalendarProviderDataManager", "update reminder error:" + Log.getStackTraceString(paramArrayList));
        return;
      }
      paramArrayList = getContentResolver().applyBatch("com.android.calendar", localArrayList);
      if (paramArrayList != null)
      {
        QMLog.log(4, "CalendarProviderDataManager", "update reminder: " + paramArrayList.length);
        return;
      }
    }
    QMLog.log(4, "CalendarProviderDataManager", "update reminder none");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.CalendarProviderDataManager
 * JD-Core Version:    0.7.0.1
 */