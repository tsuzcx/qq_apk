package com.tencent.qqmail.calendar.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.tencent.moai.database.sqlite.SQLiteDatabase;
import com.tencent.moai.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.qqmail.QMBaseSQLiteOpenHelper;
import com.tencent.qqmail.calendar.data.Attendee;
import com.tencent.qqmail.calendar.data.CalendarDefaultSettingData;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.calendar.data.QMCalendarReminder;
import com.tencent.qqmail.calendar.data.QMCalendarShare;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.model.CalendarAccountConfig;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.calendar.util.CalendarUtils;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.widget.model.CalendarWidgetItemInfo;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.qqmail.calendar.data.QMCalendarEvent;>;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class QMCalendarSQLiteHelper
  extends QMBaseSQLiteOpenHelper
{
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_ACCOUNT_PWD = "pwd";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_ATTRIBUTES = "attributes";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_ID = "id";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_PROFILE = "profile";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_PROTOCOL = "protocol";
  protected static final String FIELD_CAL_ACCOUNT_CONFIG_REFRESH_TIME = "refreshTime";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_ID = "id";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_MEETING_STATUS = "meetingStatus";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_ORGANIZER_EMAIL = "organizerEmail";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_ORGANIZER_NAME = "organizerName";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_RESPONSE_TYPE = "responseType";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_TYPE = "type";
  protected static final String FIELD_CAL_APPOINTMENT_EVENT_UID = "uid";
  protected static final String FIELD_CAL_ATTENDEE_EMAIL = "email";
  protected static final String FIELD_CAL_ATTENDEE_EVENT_ID = "eventId";
  protected static final String FIELD_CAL_ATTENDEE_ID = "id";
  protected static final String FIELD_CAL_ATTENDEE_NAME = "name";
  protected static final String FIELD_CAL_ATTENDEE_STATUS = "status";
  protected static final String FIELD_CAL_ATTENDEE_TYPE = "type";
  protected static final String FIELD_CAL_DEFAULT_ACCOUNT_ID = "defaultAccountId";
  protected static final String FIELD_CAL_DEFAULT_ALLDAY_REMINDER_TIME = "defaultReminderForAllDay";
  protected static final String FIELD_CAL_DEFAULT_EVENT_DURATION = "defaultDuration";
  protected static final String FIELD_CAL_DEFAULT_FOLDER_ID = "defaultFolderId";
  protected static final String FIELD_CAL_DEFAULT_NOTALLDAY_REMINDER_TIME = "defaultReminder";
  protected static final String FIELD_CAL_DEFAULT_REFRESH_LOCAL_TIME = "refreshLocalTime";
  protected static final String FIELD_CAL_DEFAULT_REFRESH_LOG_TIME = "refreshLogTime";
  protected static final String FIELD_CAL_DEFAULT_REFRESH_TIME = "refreshTime";
  protected static final String FIELD_CAL_DEFAULT_REMINDER_CACHEEND = "reminderCacheEnd";
  protected static final String FIELD_CAL_DEFAULT_SCHEDULE_CACHEEND = "scheduleCacheEnd";
  protected static final String FIELD_CAL_DEFAULT_SCHEDULE_CACHESTART = "scheduleCacheStart";
  protected static final String FIELD_CAL_DEFAULT_SHOW_LUNAR_CALENDAR = "showLunarCalendar";
  protected static final String FIELD_CAL_DEFAULT_SHOW_SYSTEM_CALENDAR = "showSystemCalendar";
  protected static final String FIELD_CAL_DEFAULT_START_DAY_OF_WEEK = "defaultStartDayOfWeek";
  protected static final String FIELD_CAL_DEFAULT_SYNC_TIME = "syncTime";
  protected static final String FIELD_CAL_DEFAULT_SYSTEM_CALENDAR_VISIBILITY = "systemCalendarVisible";
  protected static final String FIELD_CAL_EVENT_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CAL_EVENT_ACCOUNT_NAME = "accountName";
  protected static final String FIELD_CAL_EVENT_ACCOUNT_TYPE = "accountType";
  protected static final String FIELD_CAL_EVENT_ALLDAY = "allday";
  protected static final String FIELD_CAL_EVENT_ATTRIBUTES = "attributes";
  protected static final String FIELD_CAL_EVENT_BODY = "body";
  protected static final String FIELD_CAL_EVENT_BODY_TYPE = "bodyType";
  protected static final String FIELD_CAL_EVENT_CATEGORY = "category";
  protected static final String FIELD_CAL_EVENT_CREATE_TIME = "createTime";
  protected static final String FIELD_CAL_EVENT_DAYS_OF_MONTH = "daysOfMonth";
  protected static final String FIELD_CAL_EVENT_DAY_OF_MONTH = "dayOfMonth";
  protected static final String FIELD_CAL_EVENT_DAY_OF_WEEK = "dayOfWeek";
  protected static final String FIELD_CAL_EVENT_END_TIME = "endTime";
  protected static final String FIELD_CAL_EVENT_ETAG = "etag";
  protected static final String FIELD_CAL_EVENT_FIRST_DAY_OF_WEEK = "firstDayOfWeek";
  protected static final String FIELD_CAL_EVENT_FOLDER_ID = "folderId";
  protected static final String FIELD_CAL_EVENT_FOLDER_TYPE = "folderType";
  protected static final String FIELD_CAL_EVENT_ID = "id";
  protected static final String FIELD_CAL_EVENT_IS_LEAP_MONTH = "isLeapMonth";
  protected static final String FIELD_CAL_EVENT_LOCATION = "location";
  protected static final String FIELD_CAL_EVENT_MODIFY_TIME = "modifyTime";
  protected static final String FIELD_CAL_EVENT_MONTH_OF_YEAR = "monthOfYear";
  protected static final String FIELD_CAL_EVENT_OFFLINE_OPT_TYPE = "offLineOptType";
  protected static final String FIELD_CAL_EVENT_PATH = "path";
  protected static final String FIELD_CAL_EVENT_RECURRENCE_CALENDAR_TYPE = "calendarType";
  protected static final String FIELD_CAL_EVENT_RECURRENCE_INTERVAL = "interval";
  protected static final String FIELD_CAL_EVENT_RECURRENCE_TYPE = "recurrenceType";
  protected static final String FIELD_CAL_EVENT_RECURRENCE_UNTIL = "until";
  protected static final String FIELD_CAL_EVENT_REMINDER = "reminder";
  protected static final String FIELD_CAL_EVENT_SENSITIVITY = "sensitivity";
  protected static final String FIELD_CAL_EVENT_SERVER_ID = "serverId";
  protected static final String FIELD_CAL_EVENT_START_TIME = "startTime";
  protected static final String FIELD_CAL_EVENT_SUBJECT = "subject";
  protected static final String FIELD_CAL_EVENT_TIMEZONE = "timezone";
  protected static final String FIELD_CAL_EVENT_UID = "uid";
  protected static final String FIELD_CAL_EVENT_WEEK_OF_MONTH = "weekOfMonth";
  protected static final String FIELD_CAL_FR_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CAL_FR_ACCOUNT_NAME = "accountName";
  protected static final String FIELD_CAL_FR_ACCOUNT_TYPE = "accountType";
  protected static final String FIELD_CAL_FR_CATEGORY = "category";
  protected static final String FIELD_CAL_FR_COLLECTION_ID = "collectionId";
  protected static final String FIELD_CAL_FR_COLOR = "color";
  protected static final String FIELD_CAL_FR_CREATE_TIME = "createTime";
  protected static final String FIELD_CAL_FR_CTAG = "ctag";
  protected static final String FIELD_CAL_FR_ID = "id";
  protected static final String FIELD_CAL_FR_IS_EDITABLE = "isEditable";
  protected static final String FIELD_CAL_FR_IS_SHOW = "isShow";
  protected static final String FIELD_CAL_FR_NAME = "name";
  protected static final String FIELD_CAL_FR_OFFLINE_OPT_TYPE = "offLineOptType";
  protected static final String FIELD_CAL_FR_OWNER_ACCOUNT = "ownerAccount";
  protected static final String FIELD_CAL_FR_PARENT_ID = "parentId";
  protected static final String FIELD_CAL_FR_PATH = "path";
  protected static final String FIELD_CAL_FR_SHARE_OWNER = "shareOwner";
  protected static final String FIELD_CAL_FR_SYNC_KEY = "syncKey";
  protected static final String FIELD_CAL_FR_SYNC_TOKEN = "syncToken";
  protected static final String FIELD_CAL_FR_TYPE = "type";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_BODY = "body";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_END_TIME = "endTime";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_EVENT_ID = "eid";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_EXCEPTION_START_TIME = "exceptionStartTime";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_ID = "id";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_IS_ALL_DAY = "isAllDay";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_IS_DELETE = "isDelete";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_LOCATION = "location";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_REMINDER = "reminder";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_START_TIME = "startTime";
  protected static final String FIELD_CAL_RECURRENCE_EXCEPTION_SUBJECT = "subject";
  protected static final String FIELD_CAL_RELATE_ACCOUNT_ID = "relateAccountId";
  protected static final String FIELD_CAL_RELATE_CONTACT_EVENT_ID = "eid";
  protected static final String FIELD_CAL_RELATE_CONTACT_ID = "cid";
  protected static final String FIELD_CAL_RELATE_EVENT_ID = "eid";
  protected static final String FIELD_CAL_RELATE_ID = "relateId";
  protected static final String FIELD_CAL_RELATE_TYPE = "relateType";
  protected static final String FIELD_CAL_REMINDER_ACCOUNT_ID = "accountId";
  protected static final String FIELD_CAL_REMINDER_DATE = "date";
  protected static final String FIELD_CAL_REMINDER_EVENT_ID = "eventId";
  protected static final String FIELD_CAL_REMINDER_EVENT_START_TIME = "eventStartTime";
  protected static final String FIELD_CAL_REMINDER_FOLDER_ID = "folderId";
  protected static final String FIELD_CAL_REMINDER_ID = "id";
  protected static final String FIELD_CAL_REMINDER_START_TIME = "startTime";
  protected static final String FIELD_CAL_REMINDER_SUBJECT = "subject";
  protected static final String FIELD_CAL_SHARE_EMAIL = "email";
  protected static final String FIELD_CAL_SHARE_FOLDER_ID = "folderId";
  protected static final String FIELD_CAL_SHARE_ID = "id";
  protected static final String FIELD_CAL_SHARE_NAME = "name";
  protected static final String FIELD_CAL_SHARE_STATE = "state";
  protected static final String FIELD_SCHEDULE_INSTANCE_CATEGORY = "category";
  protected static final String FIELD_SCHEDULE_INSTANCE_COLOR = "colorId";
  protected static final String FIELD_SCHEDULE_INSTANCE_DATE = "scheduleDate";
  protected static final String FIELD_SCHEDULE_INSTANCE_END_TIME = "endTime";
  protected static final String FIELD_SCHEDULE_INSTANCE_EVENT_END_TIME = "eventEndTime";
  protected static final String FIELD_SCHEDULE_INSTANCE_EVENT_ID = "eid";
  protected static final String FIELD_SCHEDULE_INSTANCE_EVENT_START_TIME = "eventStartTime";
  protected static final String FIELD_SCHEDULE_INSTANCE_ID = "id";
  protected static final String FIELD_SCHEDULE_INSTANCE_IS_ALLDAY = "isAllDay";
  protected static final String FIELD_SCHEDULE_INSTANCE_LOCATION = "location";
  protected static final String FIELD_SCHEDULE_INSTANCE_RECURRENCE_EXCEPTION_ID = "exceptionId";
  protected static final String FIELD_SCHEDULE_INSTANCE_RELATE_TYPE = "relateType";
  protected static final String FIELD_SCHEDULE_INSTANCE_START_TIME = "startTime";
  protected static final String FIELD_SCHEDULE_INSTANCE_SUBJECT = "subject";
  protected static final String FILENAME = "QMCalendarDB";
  protected static final String INDEX_SCHEDULE_INSTANCE = "QM_SCHEDULE_INSTANCE_INDEX";
  protected static final String TABLE_CALENDAR_ACCOUNT_CONFIG = "QM_CALENDAR_ACCOUNT_CONFIG";
  protected static final String TABLE_CALENDAR_APPOINTMENT_EVENT = "QM_CALENDAR_APPOINTMENT_EVENT";
  protected static final String TABLE_CALENDAR_ATTENDEE = "QM_CALENDAR_ATTENDEE";
  protected static final String TABLE_CALENDAR_EVENT = "QM_CALENDAR_EVENT";
  protected static final String TABLE_CALENDAR_FOLDER = "QM_CALENDAR_FOLDER";
  protected static final String TABLE_CALENDAR_RECURRENCE_EXCEPTION = "QM_CALENDAR_RECURRENCE_EXCEPTION";
  protected static final String TABLE_CALENDAR_RELATE_CONTACT = "TABLE_CALENDAR_RELATE_CONTACT";
  protected static final String TABLE_CALENDAR_RELATE_EVENT = "QM_CALENDAR_RELATE_EVENT";
  protected static final String TABLE_CALENDAR_REMINDER = "QM_CALENDAR_REMINDER";
  protected static final String TABLE_CALENDAR_SETTING = "QM_CALENDAR_SETTING";
  protected static final String TABLE_CALENDAR_SHARE = "QM_CALENDAR_SHARE";
  protected static final String TABLE_SCHEDULE_INSTANCE = "QM_SCHEDULE_INSTANCE";
  protected static final String TAG = QMMailSQLiteHelper.class.getSimpleName();
  protected static final SQLiteDatabase.CursorFactory cursorFactory = null;
  private static final String sqlCreateCalendarAccountConfig = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_ACCOUNT_CONFIG(id integer primary key, accountId integer, pwd varchar, profile varchar, protocol integer, attributes varchar, refreshTime integer ) ";
  private static final String sqlCreateCalendarAppointmentEvent = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_APPOINTMENT_EVENT(id integer primary key, uid varchar, accountId integer, type integer,organizerEmail varchar, organizerName varchar, responseType integer,meetingStatus integer ) ";
  private static final String sqlCreateCalendarAttendee = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_ATTENDEE(id integer primary key, email varchar, name varchar, status integer, type integer, eventId integer) ";
  private static final String sqlCreateCalendarEvent = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_EVENT(id integer primary key, accountId integer, accountName varchar, accountType varchar, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, attributes integer, category integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, daysOfMonth varchar, isLeapMonth integer, firstDayOfWeek integer, offLineOptType integer ) ";
  private static final String sqlCreateCalendarFolder = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_FOLDER(id integer primary key, accountId integer, accountName varchar, accountType varchar, name varchar, path varchar, ctag varchar, syncToken varchar, syncKey varchar, shareOwner varchar, ownerAccount varchar, collectionId varchar, parentId varchar, color integer, isShow integer, isEditable integer, type integer, category integer ,offLineOptType integer, createTime integer ) ";
  private static final String sqlCreateCalendarRecurrenceException = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_RECURRENCE_EXCEPTION(id varchar primary key, eid integer, exceptionStartTime integer, startTime integer, endTime integer, isDelete integer, isAllDay integer, reminder integer, subject varchar, body varchar, location varchar ) ";
  private static final String sqlCreateCalendarRelateContact = "CREATE TABLE IF NOT EXISTS TABLE_CALENDAR_RELATE_CONTACT(eid integer, cid integer,  primary key (eid,cid))";
  private static final String sqlCreateCalendarRelatedEvent = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_RELATE_EVENT(eid integer primary key, relateId varchar, relateType integer, relateAccountId integer) ";
  private static final String sqlCreateCalendarReminder = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_REMINDER(id integer primary key, accountId integer, eventId integer, folderId integer, date integer, startTime integer, eventStartTime integer, subject varchar) ";
  private static final String sqlCreateCalendarSetting = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_SETTING(defaultAccountId integer, defaultFolderId integer, defaultReminder integer, defaultReminderForAllDay integer, defaultDuration integer, refreshTime integer, refreshLocalTime integer, refreshLogTime integer,reminderCacheEnd integer, scheduleCacheStart integer, scheduleCacheEnd integer, syncTime integer, showLunarCalendar integer, showSystemCalendar integer,systemCalendarVisible varchar, defaultStartDayOfWeek integer)";
  private static final String sqlCreateCalendarShare = "CREATE TABLE IF NOT EXISTS QM_CALENDAR_SHARE(id integer primary key, folderId integer, email varchar, name varchar, state integer ) ";
  private static final String sqlCreateScheduleInstance = "CREATE TABLE IF NOT EXISTS QM_SCHEDULE_INSTANCE(id integer primary key, eid integer, exceptionId varchar, startTime integer, endTime integer, eventStartTime integer, eventEndTime integer, scheduleDate integer, isAllDay integer, relateType integer, colorId integer, subject varchar, location varchar, category integer) ";
  private static final String sqlCreateScheduleInstanceIndex = "CREATE INDEX IF NOT EXISTS QM_SCHEDULE_INSTANCE_INDEX ON QM_SCHEDULE_INSTANCE(startTime ASC)";
  private static final String sqlDeleteAppointmentEventByAccountId = "DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteAppointmentEventByEventId = "DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id = ?";
  private static final String sqlDeleteAppointmentEventByEventIds = "DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id IN($eventIds$)";
  private static final String sqlDeleteAttendeeByAccountId = "DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteAttendeeByEventId = "DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId = ?";
  private static final String sqlDeleteAttendeeByEventIds = "DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId IN($eventIds$)";
  private static final String sqlDeleteCalendarAccountConfigByAccountId = "DELETE FROM QM_CALENDAR_ACCOUNT_CONFIG WHERE accountId = ?";
  private static final String sqlDeleteCalendarFolderByAccountId = "DELETE FROM QM_CALENDAR_FOLDER WHERE accountId = ?";
  private static final String sqlDeleteCalendarFolderByIds = "DELETE FROM QM_CALENDAR_FOLDER WHERE id IN ($folderIds$)";
  private static final String sqlDeleteEventByAccountId = "DELETE FROM QM_CALENDAR_EVENT WHERE accountId = ?";
  private static final String sqlDeleteEventById = "DELETE FROM QM_CALENDAR_EVENT WHERE id = ?";
  private static final String sqlDeleteEventByIds = "DELETE FROM QM_CALENDAR_EVENT WHERE id IN($eventIds$)";
  private static final String sqlDeleteExceptionByAccountId = "DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteExceptionById = "DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE id = ?";
  private static final String sqlDeleteExceptionForEvent = "DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ? AND exceptionStartTime >= ?";
  private static final String sqlDeleteExceptionsByEventId = "DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ?";
  private static final String sqlDeleteExceptionsByEventIds = "DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN($eventIds$)";
  private static final String sqlDeleteRelateContactByAccountId = "DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteRelateContactByEventId = "DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid = ?";
  private static final String sqlDeleteRelateContactByEventIds = "DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid IN($eventIds$)";
  private static final String sqlDeleteRelateEventByAccountId = "DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteRelateEventByEventId = "DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid = ?";
  private static final String sqlDeleteRelateEventByEventIds = "DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid IN($eventIds$)";
  private static final String sqlDeleteReminders = "DELETE FROM QM_CALENDAR_REMINDER";
  private static final String sqlDeleteRemindersAfterTime = "DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ? AND eventStartTime >= ?";
  private static final String sqlDeleteRemindersBeforeTime = "DELETE FROM QM_CALENDAR_REMINDER WHERE date < ?";
  private static final String sqlDeleteRemindersByAccountId = "DELETE FROM QM_CALENDAR_REMINDER WHERE accountId = ?";
  private static final String sqlDeleteRemindersByEventId = "DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ?";
  private static final String sqlDeleteRemindersByEventIds = "DELETE FROM QM_CALENDAR_REMINDER WHERE eventId IN($eventIds$)";
  private static final String sqlDeleteRemindersByTime = "DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ? AND eventStartTime = ?";
  private static final String sqlDeleteSchedule = "DELETE FROM QM_SCHEDULE_INSTANCE";
  private static final String sqlDeleteScheduleAfterTime = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime >= ? AND eid = ?";
  private static final String sqlDeleteScheduleByStartTime = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime = ? AND eid = ? ";
  private static final String sqlDeleteScheduleForTime = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime = ? AND eid = ? AND eventEndTime = ?";
  private static final String sqlDeleteSchedulesByAccountId = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)";
  private static final String sqlDeleteSchedulesByEventId = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid = ?";
  private static final String sqlDeleteSchedulesByEventIds = "DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid IN($eventIds$)";
  private static final String sqlDeleteShareByAccountId = "DELETE FROM QM_CALENDAR_SHARE WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE accountId = ? ) ";
  private static final String sqlDeleteShareByFolderId = "DELETE FROM QM_CALENDAR_SHARE WHERE folderId IN ($folderIds$) ";
  private static final String sqlDeleteShareById = "DELETE FROM QM_CALENDAR_SHARE WHERE id = ? ";
  private static final String sqlDropCalendarAccountConfig = "DROP TABLE IF EXISTS QM_CALENDAR_ACCOUNT_CONFIG";
  private static final String sqlDropCalendarAppointmentEvent = "DROP TABLE IF EXISTS QM_CALENDAR_APPOINTMENT_EVENT";
  private static final String sqlDropCalendarAttendee = "DROP TABLE IF EXISTS QM_CALENDAR_ATTENDEE";
  private static final String sqlDropCalendarEvent = "DROP TABLE IF EXISTS QM_CALENDAR_EVENT";
  private static final String sqlDropCalendarFolder = "DROP TABLE IF EXISTS QM_CALENDAR_FOLDER";
  private static final String sqlDropCalendarRecurrenceException = "DROP TABLE IF EXISTS QM_CALENDAR_RECURRENCE_EXCEPTION";
  private static final String sqlDropCalendarRelateContact = "DROP TABLE IF EXISTS TABLE_CALENDAR_RELATE_CONTACT";
  private static final String sqlDropCalendarRelatedEvent = "DROP TABLE IF EXISTS QM_CALENDAR_RELATE_EVENT";
  private static final String sqlDropCalendarReminder = "DROP TABLE IF EXISTS QM_CALENDAR_REMINDER";
  private static final String sqlDropCalendarSetting = "DROP TABLE IF EXISTS QM_CALENDAR_SETTING";
  private static final String sqlDropCalendarShare = "DROP TABLE IF EXISTS QM_CALENDAR_SHARE";
  private static final String sqlDropScheduleInstance = "DROP TABLE IF EXISTS QM_SCHEDULE_INSTANCE";
  private static final String sqlDropScheduleInstanceIndex = "DROP INDEX IF EXISTS QM_SCHEDULE_INSTANCE_INDEX";
  private static final String sqlInsertCalendarAccountConfig = "REPLACE INTO QM_CALENDAR_ACCOUNT_CONFIG ( id,accountId,pwd,profile,protocol,attributes,refreshTime) VALUES (?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarAppointmentEvent = "REPLACE INTO QM_CALENDAR_APPOINTMENT_EVENT ( id , uid , accountId , type , organizerEmail , organizerName , responseType , meetingStatus ) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarAttendee = " REPLACE INTO QM_CALENDAR_ATTENDEE ( id , email , name , status , type , eventId ) VALUES (?,?,?,?,?,?)";
  private static final String sqlInsertCalendarEvent = "REPLACE INTO QM_CALENDAR_EVENT ( id,accountId,accountName,accountType,folderId,uid,reminder,subject,location,body,bodyType,allday,sensitivity,timezone,startTime,endTime,createTime,modifyTime,path,etag,serverId,folderType,attributes,category,recurrenceType,calendarType,interval,until,weekOfMonth,dayOfWeek,monthOfYear,dayOfMonth,daysOfMonth,isLeapMonth,firstDayOfWeek,offLineOptType ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarFolder = "REPLACE INTO QM_CALENDAR_FOLDER ( id,accountId,accountName,accountType,name,path,ctag,syncToken,syncKey,shareOwner,ownerAccount,collectionId,parentId,color,isShow,isEditable,type,category,offLineOptType,createTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarRecurrenceException = "REPLACE INTO QM_CALENDAR_RECURRENCE_EXCEPTION ( id,eid,exceptionStartTime,startTime,endTime,isDelete,isAllDay,reminder,subject,body,location) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarRelateContact = "REPLACE INTO TABLE_CALENDAR_RELATE_CONTACT(eid ,cid) VALUES (?,?)";
  private static final String sqlInsertCalendarRelateEvent = "REPLACE INTO QM_CALENDAR_RELATE_EVENT ( eid,relateId,relateType,relateAccountId ) VALUES (?,?,?,?)";
  private static final String sqlInsertCalendarReminder = "REPLACE INTO QM_CALENDAR_REMINDER ( id,accountId,eventId,folderId,date,startTime,eventStartTime,subject) VALUES (?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarSetting = "REPLACE INTO QM_CALENDAR_SETTING ( defaultAccountId,defaultFolderId,defaultReminder,defaultReminderForAllDay,defaultDuration,refreshTime,refreshLocalTime,refreshLogTime,reminderCacheEnd,scheduleCacheStart,scheduleCacheEnd,syncTime,showLunarCalendar,showSystemCalendar,systemCalendarVisible,defaultStartDayOfWeek) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlInsertCalendarShare = "REPLACE INTO QM_CALENDAR_SHARE(id , folderId , email , name , state) VALUES (?,?,?,?,?)";
  private static final String sqlInsertScheduleInstance = "REPLACE INTO QM_SCHEDULE_INSTANCE ( id,eid,exceptionId,startTime,endTime,eventStartTime,eventEndTime,scheduleDate,isAllDay,relateType,colorId,subject,location,category) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  private static final String sqlQueryLatestReminder = "SELECT id,date,subject FROM QM_CALENDAR_REMINDER WHERE date IN (SELECT date FROM QM_CALENDAR_REMINDER WHERE date BETWEEN ? AND ? ORDER BY date ASC LIMIT 1)";
  private static final String sqlQueryLatestReminderDateBetween = "SELECT date FROM QM_CALENDAR_REMINDER WHERE date BETWEEN ? AND ? ORDER BY date ASC LIMIT 1";
  private static final String sqlSelectAllEventIdByAccount = "SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?";
  private static final String sqlSelectAllOffLineOptEvents = "SELECT * FROM QM_CALENDAR_EVENT WHERE offLineOptType>0 AND category != 1";
  private static final String sqlSelectAllRecurrenceExceptionByEventId = "SELECT * FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ?";
  private static final String sqlSelectAppointEventById = "SELECT * FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id = ? ";
  private static final String sqlSelectAttendeeByEventId = "SELECT * FROM QM_CALENDAR_ATTENDEE WHERE eventId = ? ";
  private static final String sqlSelectCalendarAccountConfig = "SELECT * FROM QM_CALENDAR_ACCOUNT_CONFIG";
  private static final String sqlSelectCalendarFolder = "SELECT * FROM QM_CALENDAR_FOLDER WHERE offLineOptType<4";
  private static final String sqlSelectCalendarFolderByAccountId = " SELECT id FROM QM_CALENDAR_FOLDER WHERE accountId = ? ";
  private static final String sqlSelectCalendarSetting = "SELECT * FROM QM_CALENDAR_SETTING";
  private static final String sqlSelectEventByCid = "SELECT E.* FROM QM_CALENDAR_EVENT AS E JOIN TABLE_CALENDAR_RELATE_CONTACT AS CRC WHERE E.id = CRC.eid AND CRC.cid =?";
  private static final String sqlSelectEventById = "SELECT * FROM QM_CALENDAR_EVENT WHERE id = ?";
  private static final String sqlSelectEventByUid = "SELECT * FROM QM_CALENDAR_EVENT WHERE uid = ? AND accountId=?";
  private static final String sqlSelectEventIds = "SELECT id FROM QM_CALENDAR_EVENT";
  private static final String sqlSelectEventIdsByFolderIds = "SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN($folderIds$) ";
  private static final String sqlSelectEventIdsBySvrIdAndAccId = "SELECT id FROM QM_CALENDAR_EVENT WHERE serverId=? AND accountId=?";
  private static final String sqlSelectEventPath = "SELECT path, etag FROM QM_CALENDAR_EVENT WHERE folderId = ? ";
  private static final String sqlSelectEvents = "SELECT * FROM QM_CALENDAR_EVENT";
  private static final String sqlSelectEventsInTime = "SELECT * FROM QM_CALENDAR_EVENT WHERE offLineOptType<4 AND (( recurrenceType = -1 AND startTime >= ? AND startTime <= ? )  OR ( recurrenceType = -1 AND startTime <= ? AND endTime >= ? )  OR ( recurrenceType >= 0 AND startTime <= ?)) ";
  private static final String sqlSelectHolidayEventInTime = "SELECT subject, startTime FROM QM_CALENDAR_EVENT WHERE folderId in (select id from QM_CALENDAR_FOLDER where collectionId='10001002#H#1025' AND isShow = 1) AND (subject='补班' OR subject like '%第%') AND startTime >= ? AND startTime <= ?";
  private static final String sqlSelectOfflineCalendarFolder = "SELECT * FROM QM_CALENDAR_FOLDER WHERE offLineOptType<>0 AND category != 1";
  private static final String sqlSelectPublicEventId = " SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId='10001002#H#1025')  GROUP BY startTime, subject";
  private static final String sqlSelectRecurrenceException = "SELECT * FROM QM_CALENDAR_RECURRENCE_EXCEPTION";
  private static final String sqlSelectRecurrenceExceptionByEventIds = "SELECT * FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN $events$ GROUP BY eid";
  private static final String sqlSelectRelateById = "SELECT * FROM QM_CALENDAR_RELATE_EVENT WHERE eid = ? ";
  private static final String sqlSelectRelateContactByEid = "SELECT * FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid = ?";
  private static final String sqlSelectReminderCacheEnd = "SELECT reminderCacheEnd FROM QM_CALENDAR_SETTING";
  private static final String sqlSelectRemoteSvrIds = "SELECT serverId FROM QM_CALENDAR_EVENT WHERE category != 1";
  private static final String sqlSelectSchedule = "SELECT * FROM QM_SCHEDULE_INSTANCE";
  private static final String sqlSelectScheduleByCid = "SELECT S.* FROM QM_SCHEDULE_INSTANCE AS S JOIN TABLE_CALENDAR_RELATE_CONTACT AS CRC WHERE CRC. eid = S.eid AND cid = ?";
  private static final String sqlSelectScheduleById = "SELECT * FROM QM_SCHEDULE_INSTANCE WHERE id = ?";
  private static final String sqlSelectScheduleByReminderId = "SELECT * FROM QM_SCHEDULE_INSTANCE AS S INNER JOIN QM_CALENDAR_REMINDER AS R ON S.eid = R.eventId AND S.startTime = R.startTime AND S.eventStartTime = R.eventStartTime WHERE R.id = ?";
  private static final String sqlSelectScheduleCache = "SELECT scheduleCacheStart,scheduleCacheEnd FROM QM_CALENDAR_SETTING";
  private static final String sqlSelectScheduleInTime = "SELECT * FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ? AND (eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId!='10001002#H#1025')) OR eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId='10001002#H#1025')  GROUP BY startTime, subject)) ORDER BY (CASE WHEN startTime != eventStartTime AND endTime = eventEndTime THEN eventEndTime ELSE startTime END), colorId";
  private static final String sqlSelectScheduleInTimeDistinct = "SELECT DISTINCT scheduleDate FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ?  AND eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 ) ) ";
  private static final String sqlSelectScheduleInfoInTime = "SELECT id, colorId, startTime, subject, isAllDay FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ? AND eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 ) )  ORDER BY (CASE WHEN startTime != eventStartTime AND endTime = eventEndTime THEN eventEndTime ELSE startTime END), colorId";
  private static final String sqlSelectShareByEmail = "SELECT * FROM QM_CALENDAR_SHARE WHERE folderId = ? AND email = ? ";
  private static final String sqlSelectShareByFolderId = "SELECT * FROM QM_CALENDAR_SHARE WHERE folderId = ? ";
  private static final String sqlSelectShareById = "SELECT * FROM QM_CALENDAR_SHARE WHERE id = ? ";
  private static final String sqlSelectShownCalendarFolderIDs = " SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 ";
  private static final String sqlSelectShownEventIds = " SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 )";
  private static final String sqlSelectShownEventIdsNotInPublic = " SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId!='10001002#H#1025')";
  private static final String sqlUpdateAppointmentType = "UPDATE QM_CALENDAR_APPOINTMENT_EVENT SET type = ? WHERE id = ?";
  private static final String sqlUpdateCalendarAccountConfigProfile = "UPDATE QM_CALENDAR_ACCOUNT_CONFIG SET profile = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarAccountConfigRefreshTime = "UPDATE QM_CALENDAR_ACCOUNT_CONFIG SET refreshTime = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderCategory = "UPDATE QM_CALENDAR_FOLDER SET category = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderColor = "UPDATE QM_CALENDAR_FOLDER SET color = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderIsShow = "UPDATE QM_CALENDAR_FOLDER SET isShow = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderName = "UPDATE QM_CALENDAR_FOLDER SET name = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderOfflineOptType = "UPDATE QM_CALENDAR_FOLDER SET offLineOptType = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderShareOwner = "UPDATE QM_CALENDAR_FOLDER SET shareOwner = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderSyncKey = "UPDATE QM_CALENDAR_FOLDER SET syncKey = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarFolderSyncToken = "UPDATE QM_CALENDAR_FOLDER SET syncToken = ?  WHERE id = ?";
  private static final String sqlUpdateCalendarSetting = "UPDATE QM_CALENDAR_SETTING SET defaultAccountId = ?,defaultFolderId = ?,defaultReminder = ?,defaultReminderForAllDay = ?,defaultDuration = ?,refreshTime = ?,refreshLocalTime = ?,refreshLogTime = ?,syncTime = ?,showLunarCalendar = ?,showSystemCalendar = ?,systemCalendarVisible = ?,defaultStartDayOfWeek = ?";
  private static final String sqlUpdateEvent = "UPDATE QM_CALENDAR_EVENT SET folderId = ?,reminder = ?,subject = ?,location = ?,body = ?,allday = ?,startTime = ?,endTime = ?,createTime = ?,modifyTime = ? WHERE id = ?";
  private static final String sqlUpdateEventAfterCreate = "UPDATE QM_CALENDAR_EVENT SET uid = ?,path = ?,etag = ?,id = ?  WHERE id = ?";
  private static final String sqlUpdateEventOffLineOptType = "UPDATE QM_CALENDAR_EVENT SET offLineOptType = ?  WHERE id = ?";
  private static final String sqlUpdateEventSvrId = "UPDATE QM_CALENDAR_EVENT SET serverId = ?,id = ?  WHERE id = ?";
  private static final String sqlUpdateEventUntilTime = "UPDATE QM_CALENDAR_EVENT SET until = ?  WHERE id = ?";
  private static final String sqlUpdateException = "UPDATE QM_CALENDAR_RECURRENCE_EXCEPTION SET exceptionStartTime = ?,startTime = ?,endTime = ?,isDelete = ?,isAllDay = ?,reminder = ?,subject = ?,body = ?,location = ? WHERE id = ?";
  private static final String sqlUpdateExceptionForNewEvent = "UPDATE QM_CALENDAR_RECURRENCE_EXCEPTION SET id = ?||'_'||exceptionStartTime, eid = ? WHERE exceptionStartTime >= ? AND eid = ?";
  private static final String sqlUpdateRelateContactByOldCid = "UPDATE TABLE_CALENDAR_RELATE_CONTACT SET cid = ? WHERE cid = ?";
  private static final String sqlUpdateReminderCacheEnd = "UPDATE QM_CALENDAR_SETTING SET reminderCacheEnd = ?";
  private static final String sqlUpdateScheduleCache = "UPDATE QM_CALENDAR_SETTING SET scheduleCacheStart = ?,scheduleCacheEnd = ?";
  private static final String sqlUpdateSchedulersColorByEventId = " UPDATE QM_SCHEDULE_INSTANCE SET colorId = ?  WHERE eid = ?";
  private static final String sqlUpdateShare = "UPDATE QM_CALENDAR_SHARE SET folderId = ?,email = ?,name = ?,state = ? WHERE id = ?";
  static final QMCalendarSQLiteDatabaseUpgradeManager upgradeManager = new QMCalendarSQLiteDatabaseUpgradeManager();
  private HashMap<String, Integer> eventColumnIndexCache = new HashMap();
  private HashMap<String, Integer> exceptionColumnIndexCache = new HashMap();
  private HashMap<String, Integer> folderColumnIndexCache = new HashMap();
  private HashMap<String, Integer> scheduleColumnIndexCache = new HashMap();
  
  public QMCalendarSQLiteHelper(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, "QMCalendarDB", cursorFactory, upgradeManager.getVersion());
  }
  
  private void deleteAttendeeByEventId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void doInsertCalendarEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    int j = 1;
    String str1 = "";
    String str2 = str1;
    if (paramQMCalendarEvent.getDaysOfMonth() != null)
    {
      str2 = str1;
      if (paramQMCalendarEvent.getDaysOfMonth().size() > 0)
      {
        str1 = "" + paramQMCalendarEvent.getDaysOfMonth().get(0);
        i = 1;
        for (;;)
        {
          str2 = str1;
          if (i >= paramQMCalendarEvent.getDaysOfMonth().size()) {
            break;
          }
          str1 = str1 + "," + paramQMCalendarEvent.getDaysOfMonth().get(i);
          i += 1;
        }
      }
    }
    long l = paramQMCalendarEvent.getId();
    int k = paramQMCalendarEvent.getAccountId();
    str1 = paramQMCalendarEvent.getAccountName();
    String str3 = paramQMCalendarEvent.getAccountType();
    int m = paramQMCalendarEvent.getCalderFolderId();
    String str4 = paramQMCalendarEvent.getUid();
    int n = paramQMCalendarEvent.getReminder();
    String str5 = paramQMCalendarEvent.getSubject();
    String str6 = paramQMCalendarEvent.getLocation();
    String str7 = paramQMCalendarEvent.getBody();
    if (paramQMCalendarEvent.isAllDay()) {}
    for (int i = j;; i = 0)
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_EVENT ( id,accountId,accountName,accountType,folderId,uid,reminder,subject,location,body,bodyType,allday,sensitivity,timezone,startTime,endTime,createTime,modifyTime,path,etag,serverId,folderType,attributes,category,recurrenceType,calendarType,interval,until,weekOfMonth,dayOfWeek,monthOfYear,dayOfMonth,daysOfMonth,isLeapMonth,firstDayOfWeek,offLineOptType ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(l), Integer.valueOf(k), str1, str3, Integer.valueOf(m), str4, Integer.valueOf(n), str5, str6, str7, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(paramQMCalendarEvent.getSensivity()), paramQMCalendarEvent.getTimezone(), Long.valueOf(paramQMCalendarEvent.getStartTime()), Long.valueOf(paramQMCalendarEvent.getEndTime()), Long.valueOf(paramQMCalendarEvent.getCreateTime()), Long.valueOf(paramQMCalendarEvent.getModifyTime()), paramQMCalendarEvent.getPath(), paramQMCalendarEvent.geteTag(), paramQMCalendarEvent.getSvrId(), Integer.valueOf(0), Integer.valueOf(paramQMCalendarEvent.getAttribute()), Integer.valueOf(paramQMCalendarEvent.getCategory()), Integer.valueOf(paramQMCalendarEvent.getRecurrenceType()), Integer.valueOf(0), Integer.valueOf(paramQMCalendarEvent.getInterval()), Long.valueOf(paramQMCalendarEvent.getUntil()), Integer.valueOf(paramQMCalendarEvent.getWeekOfMonth()), Integer.valueOf(paramQMCalendarEvent.getDayOfWeek()), Integer.valueOf(paramQMCalendarEvent.getMonthOfYear()), Integer.valueOf(paramQMCalendarEvent.getDayOfMonth()), str2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(paramQMCalendarEvent.getOffLineOptType()) });
      insertRelateEvent(paramSQLiteDatabase, paramQMCalendarEvent);
      insertAppointmentEvent(paramSQLiteDatabase, paramQMCalendarEvent);
      insertAttendee(paramSQLiteDatabase, paramQMCalendarEvent.getAttendees(), paramQMCalendarEvent.getId());
      insertRecurrentExceptionsFromEvent(paramSQLiteDatabase, paramQMCalendarEvent);
      insertCalendarRelateContact(paramSQLiteDatabase, paramQMCalendarEvent);
      return;
    }
  }
  
  private void fillAllRecurrenceExceptionForEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent.getRecurrenceType() != -1) {}
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ?", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
      if (paramSQLiteDatabase != null)
      {
        ArrayList localArrayList = new ArrayList();
        HashMap localHashMap = new HashMap();
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        if (paramSQLiteDatabase.moveToFirst())
        {
          do
          {
            RecurringException localRecurringException = getRecurringExceptionFromCursor(paramSQLiteDatabase);
            if (localRecurringException.getEventId() != 0L)
            {
              localArrayList.add(localRecurringException);
              localGregorianCalendar.setTimeInMillis(localRecurringException.getExceptionStartTime());
              localHashMap.put(Integer.valueOf(CalendarUtils.computeDate(localGregorianCalendar)), localRecurringException);
            }
          } while (paramSQLiteDatabase.moveToNext());
          paramQMCalendarEvent.setExceptions(localArrayList);
          paramQMCalendarEvent.setExceptionHashMap(localHashMap);
        }
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void fillAppointmentData(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id = ? ", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst())
        {
          paramQMCalendarEvent.setAppointmentType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("type")));
          paramQMCalendarEvent.setOrganizerEmail(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("organizerEmail")));
          paramQMCalendarEvent.setOrganizerName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("organizerName")));
          paramQMCalendarEvent.setResponseType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("responseType")));
          paramQMCalendarEvent.setMeetingStatus(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("meetingStatus")));
        }
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void fillAttendeeData(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_ATTENDEE WHERE eventId = ? ", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst())
        {
          ArrayList localArrayList = new ArrayList();
          do
          {
            Attendee localAttendee = new Attendee();
            localAttendee.setEmail(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("email")));
            localAttendee.setName(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("name")));
            localAttendee.setStatus(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("status")));
            localAttendee.setType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("type")));
            localArrayList.add(localAttendee);
          } while (paramSQLiteDatabase.moveToNext());
          paramQMCalendarEvent.setAttendees(localArrayList);
        }
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void fillRecurrenceExceptionForEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent.getRecurrenceType() != -1)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramQMCalendarEvent);
      fillRecurrenceExceptionForEvents(paramSQLiteDatabase, localArrayList);
    }
  }
  
  private void fillRecurrenceExceptionForEvents(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCalendarEvent> paramArrayList)
  {
    for (;;)
    {
      Object localObject1;
      Object localObject2;
      long l2;
      try
      {
        if (paramArrayList.size() == 0) {
          return;
        }
        localObject1 = new long[paramArrayList.size()];
        HashMap localHashMap = new HashMap();
        paramArrayList = paramArrayList.iterator();
        int i = 0;
        if (paramArrayList.hasNext())
        {
          localObject2 = (QMCalendarEvent)paramArrayList.next();
          localObject1[i] = ((QMCalendarEvent)localObject2).getId();
          localHashMap.put(Long.valueOf(((QMCalendarEvent)localObject2).getId()), localObject2);
          i += 1;
          continue;
        }
        Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN $events$ GROUP BY eid".replace("$events$", getInClause((long[])localObject1)), null);
        if (localCursor == null) {
          break;
        }
        l1 = 0L;
        paramSQLiteDatabase = new ArrayList();
        paramArrayList = new HashMap();
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        if (localCursor.moveToFirst())
        {
          RecurringException localRecurringException = getRecurringExceptionFromCursor(localCursor);
          QMCalendarEvent localQMCalendarEvent = (QMCalendarEvent)localHashMap.get(Long.valueOf(localRecurringException.getEventId()));
          localObject1 = paramArrayList;
          localObject2 = paramSQLiteDatabase;
          l2 = l1;
          if (localRecurringException.getEventId() != 0L)
          {
            localObject1 = paramArrayList;
            localObject2 = paramSQLiteDatabase;
            l2 = l1;
            if (localQMCalendarEvent != null)
            {
              if (l1 != localRecurringException.getEventId())
              {
                paramSQLiteDatabase = new ArrayList();
                paramArrayList = new HashMap();
              }
              paramSQLiteDatabase.add(localRecurringException);
              localGregorianCalendar.setTimeInMillis(localRecurringException.getExceptionStartTime());
              paramArrayList.put(Integer.valueOf(CalendarUtils.computeDate(localGregorianCalendar)), localRecurringException);
              l2 = localRecurringException.getEventId();
              localQMCalendarEvent.setExceptions(paramSQLiteDatabase);
              localQMCalendarEvent.setExceptionHashMap(paramArrayList);
              localObject2 = paramSQLiteDatabase;
              localObject1 = paramArrayList;
            }
          }
          if (localCursor.moveToNext()) {}
        }
        else
        {
          localCursor.close();
          return;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
        return;
      }
      long l1 = l2;
      paramSQLiteDatabase = (SQLiteDatabase)localObject2;
      paramArrayList = (ArrayList<QMCalendarEvent>)localObject1;
    }
  }
  
  private void fillRelateCid(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid = ?", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToNext()) {
          paramQMCalendarEvent.setCid(paramSQLiteDatabase.getLong(getColumnIndex(this.eventColumnIndexCache, paramSQLiteDatabase, "cid")));
        }
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private void fillRelateData(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_RELATE_EVENT WHERE eid = ? ", new String[] { String.valueOf(paramQMCalendarEvent.getId()) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst())
        {
          paramQMCalendarEvent.setRelateType(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("relateType")));
          paramQMCalendarEvent.setRelatedId(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("relateId")));
          paramQMCalendarEvent.setRelateAccountId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("relateAccountId")));
        }
        paramSQLiteDatabase.close();
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  private QMCalendarEvent getCalendarEventFromCursor(Cursor paramCursor, SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    try
    {
      localQMCalendarEvent = new QMCalendarEvent();
    }
    catch (Exception paramSQLiteDatabase)
    {
      label242:
      int i;
      ArrayList localArrayList;
      int j;
      paramCursor = null;
      label781:
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
      return paramCursor;
    }
    try
    {
      localQMCalendarEvent.setId(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "id")));
      localQMCalendarEvent.setUid(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "uid")));
      localQMCalendarEvent.setAccountId(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "accountId")));
      localQMCalendarEvent.setAccountName(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "accountName")));
      localQMCalendarEvent.setAccountType(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "accountType")));
      localQMCalendarEvent.setCalderFolderId(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "folderId")));
      localQMCalendarEvent.setReminder(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "reminder")));
      localQMCalendarEvent.setSubject(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "subject")));
      localQMCalendarEvent.setBody(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "body")));
      localQMCalendarEvent.setLocation(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "location")));
      if (paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "allday")) != 1) {
        break label802;
      }
      bool = true;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramCursor = localQMCalendarEvent;
      break label781;
      bool = false;
      break label242;
    }
    localQMCalendarEvent.setIsAllDay(bool);
    localQMCalendarEvent.setSensivity(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "sensitivity")));
    localQMCalendarEvent.setTimezone(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "timezone")));
    localQMCalendarEvent.setStartTime(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "startTime")));
    localQMCalendarEvent.setEndTime(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "endTime")));
    localQMCalendarEvent.setCreateTime(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "createTime")));
    localQMCalendarEvent.setModifyTime(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "modifyTime")));
    localQMCalendarEvent.setPath(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "path")));
    localQMCalendarEvent.seteTag(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "etag")));
    localQMCalendarEvent.setSvrId(paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "serverId")));
    localQMCalendarEvent.setAttribute(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "attributes")));
    localQMCalendarEvent.setCategory(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "category")));
    localQMCalendarEvent.setOffLineOptType(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "offLineOptType")));
    i = paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "recurrenceType"));
    localQMCalendarEvent.setRecurrenceType(i);
    if (i != -1)
    {
      localQMCalendarEvent.setInterval(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "interval")));
      localQMCalendarEvent.setUntil(paramCursor.getLong(getColumnIndex(this.eventColumnIndexCache, paramCursor, "until")));
      localQMCalendarEvent.setWeekOfMonth(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "weekOfMonth")));
      localQMCalendarEvent.setDayOfWeek(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "dayOfWeek")));
      localQMCalendarEvent.setMonthOfYear(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "monthOfYear")));
      localQMCalendarEvent.setDayOfMonth(paramCursor.getInt(getColumnIndex(this.eventColumnIndexCache, paramCursor, "dayOfMonth")));
      paramCursor = paramCursor.getString(getColumnIndex(this.eventColumnIndexCache, paramCursor, "daysOfMonth"));
      if (StringUtils.isNotEmpty(paramCursor))
      {
        paramCursor = paramCursor.split(",");
        if (paramCursor.length > 0)
        {
          localArrayList = Lists.newArrayList();
          j = paramCursor.length;
          i = 0;
          while (i < j)
          {
            localArrayList.add(Integer.valueOf(paramCursor[i]));
            i += 1;
          }
          localQMCalendarEvent.setDaysOfMonth(localArrayList);
        }
      }
    }
    if (paramBoolean)
    {
      fillRelateData(paramSQLiteDatabase, localQMCalendarEvent);
      fillAppointmentData(paramSQLiteDatabase, localQMCalendarEvent);
      fillAttendeeData(paramSQLiteDatabase, localQMCalendarEvent);
      fillRelateCid(paramSQLiteDatabase, localQMCalendarEvent);
    }
    return localQMCalendarEvent;
  }
  
  private QMCalendarFolder getCalendarFolderFromCursor(Cursor paramCursor)
  {
    boolean bool2 = true;
    QMCalendarFolder localQMCalendarFolder = new QMCalendarFolder();
    localQMCalendarFolder.setId(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "id")));
    localQMCalendarFolder.setAccountId(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "accountId")));
    localQMCalendarFolder.setAccountName(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "accountName")));
    localQMCalendarFolder.setAccountType(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "accountType")));
    localQMCalendarFolder.setCollectionId(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "collectionId")));
    localQMCalendarFolder.setParentId(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "parentId")));
    localQMCalendarFolder.setSyncKey(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "syncKey")));
    localQMCalendarFolder.setSyncToken(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "syncToken")));
    localQMCalendarFolder.setShareOwner(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "shareOwner")));
    localQMCalendarFolder.setOwnerAccount(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "ownerAccount")));
    localQMCalendarFolder.setName(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "name")));
    localQMCalendarFolder.setPath(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "path")));
    localQMCalendarFolder.setcTag(paramCursor.getString(getColumnIndex(this.folderColumnIndexCache, paramCursor, "ctag")));
    localQMCalendarFolder.setColor(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "color")));
    if (paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "isShow")) == 1)
    {
      bool1 = true;
      localQMCalendarFolder.setIsShow(bool1);
      if (paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "isEditable")) != 1) {
        break label453;
      }
    }
    label453:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localQMCalendarFolder.setIsEditable(bool1);
      localQMCalendarFolder.setType(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "type")));
      localQMCalendarFolder.setCategory(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "category")));
      localQMCalendarFolder.setOffLineOptType(paramCursor.getInt(getColumnIndex(this.folderColumnIndexCache, paramCursor, "offLineOptType")));
      localQMCalendarFolder.setCreateTime(paramCursor.getLong(getColumnIndex(this.folderColumnIndexCache, paramCursor, "createTime")));
      return localQMCalendarFolder;
      bool1 = false;
      break;
    }
  }
  
  protected static int getColumnIndex(HashMap<String, Integer> paramHashMap, Cursor paramCursor, String paramString)
  {
    if (paramHashMap == null) {
      return paramCursor.getColumnIndex(paramString);
    }
    Integer localInteger2 = (Integer)paramHashMap.get(paramString);
    Integer localInteger1 = localInteger2;
    if (localInteger2 == null)
    {
      localInteger1 = Integer.valueOf(paramCursor.getColumnIndex(paramString));
      paramHashMap.put(paramString, localInteger1);
    }
    return localInteger1.intValue();
  }
  
  protected static String getInClause(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfInt[i]);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static int getInt(Cursor paramCursor, String paramString)
  {
    return paramCursor.getInt(paramCursor.getColumnIndex(paramString));
  }
  
  /* Error */
  private RecurringException getRecurringExceptionFromCursor(Cursor paramCursor)
  {
    // Byte code:
    //   0: new 1052	com/tencent/qqmail/calendar/data/RecurringException
    //   3: dup
    //   4: invokespecial 1378	com/tencent/qqmail/calendar/data/RecurringException:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   14: aload_1
    //   15: ldc 17
    //   17: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   20: invokeinterface 1109 2 0
    //   25: invokevirtual 1380	com/tencent/qqmail/calendar/data/RecurringException:setId	(Ljava/lang/String;)V
    //   28: aload_3
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   34: aload_1
    //   35: ldc 251
    //   37: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   40: invokeinterface 1182 2 0
    //   45: invokevirtual 1383	com/tencent/qqmail/calendar/data/RecurringException:setEventId	(J)V
    //   48: aload_3
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   54: aload_1
    //   55: ldc 254
    //   57: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   60: invokeinterface 1182 2 0
    //   65: invokevirtual 1386	com/tencent/qqmail/calendar/data/RecurringException:setExceptionStartTime	(J)V
    //   68: aload_3
    //   69: aload_1
    //   70: aload_0
    //   71: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   74: aload_1
    //   75: ldc 196
    //   77: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   80: invokeinterface 1182 2 0
    //   85: invokevirtual 1387	com/tencent/qqmail/calendar/data/RecurringException:setStartTime	(J)V
    //   88: aload_3
    //   89: aload_1
    //   90: aload_0
    //   91: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   94: aload_1
    //   95: ldc 141
    //   97: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   100: invokeinterface 1182 2 0
    //   105: invokevirtual 1388	com/tencent/qqmail/calendar/data/RecurringException:setEndTime	(J)V
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   113: aload_1
    //   114: ldc_w 258
    //   117: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   120: invokeinterface 1101 2 0
    //   125: iconst_1
    //   126: if_icmpne +120 -> 246
    //   129: iconst_1
    //   130: istore_2
    //   131: aload_3
    //   132: iload_2
    //   133: invokevirtual 1389	com/tencent/qqmail/calendar/data/RecurringException:setIsAllDay	(Z)V
    //   136: aload_3
    //   137: aload_1
    //   138: aload_0
    //   139: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   142: aload_1
    //   143: ldc 187
    //   145: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   148: invokeinterface 1101 2 0
    //   153: invokevirtual 1390	com/tencent/qqmail/calendar/data/RecurringException:setReminder	(I)V
    //   156: aload_1
    //   157: aload_0
    //   158: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   161: aload_1
    //   162: ldc_w 261
    //   165: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   168: invokeinterface 1101 2 0
    //   173: iconst_1
    //   174: if_icmpne +77 -> 251
    //   177: iconst_1
    //   178: istore_2
    //   179: aload_3
    //   180: iload_2
    //   181: invokevirtual 1393	com/tencent/qqmail/calendar/data/RecurringException:setIsDelete	(Z)V
    //   184: aload_3
    //   185: aload_1
    //   186: aload_0
    //   187: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   190: aload_1
    //   191: ldc 199
    //   193: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   196: invokeinterface 1109 2 0
    //   201: invokevirtual 1394	com/tencent/qqmail/calendar/data/RecurringException:setSubject	(Ljava/lang/String;)V
    //   204: aload_3
    //   205: aload_1
    //   206: aload_0
    //   207: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   210: aload_1
    //   211: ldc 120
    //   213: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   216: invokeinterface 1109 2 0
    //   221: invokevirtual 1395	com/tencent/qqmail/calendar/data/RecurringException:setBody	(Ljava/lang/String;)V
    //   224: aload_3
    //   225: aload_1
    //   226: aload_0
    //   227: getfield 846	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:exceptionColumnIndexCache	Ljava/util/HashMap;
    //   230: aload_1
    //   231: ldc 160
    //   233: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   236: invokeinterface 1109 2 0
    //   241: invokevirtual 1396	com/tencent/qqmail/calendar/data/RecurringException:setLocation	(Ljava/lang/String;)V
    //   244: aload_3
    //   245: areturn
    //   246: iconst_0
    //   247: istore_2
    //   248: goto -117 -> 131
    //   251: iconst_0
    //   252: istore_2
    //   253: goto -74 -> 179
    //   256: astore_3
    //   257: aconst_null
    //   258: astore_1
    //   259: bipush 6
    //   261: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   264: aload_3
    //   265: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   268: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   271: aload_1
    //   272: areturn
    //   273: astore 4
    //   275: aload_3
    //   276: astore_1
    //   277: aload 4
    //   279: astore_3
    //   280: goto -21 -> 259
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	QMCalendarSQLiteHelper
    //   0	283	1	paramCursor	Cursor
    //   130	123	2	bool	boolean
    //   7	238	3	localRecurringException	RecurringException
    //   256	20	3	localException1	Exception
    //   279	1	3	localObject	Object
    //   273	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	256	java/lang/Exception
    //   8	129	273	java/lang/Exception
    //   131	177	273	java/lang/Exception
    //   179	244	273	java/lang/Exception
  }
  
  private QMCalendarShare getShareFromCursor(Cursor paramCursor)
  {
    QMCalendarShare localQMCalendarShare = new QMCalendarShare();
    localQMCalendarShare.setId(paramCursor.getLong(paramCursor.getColumnIndex("id")));
    localQMCalendarShare.setCalendarFolderId(paramCursor.getInt(paramCursor.getColumnIndex("folderId")));
    localQMCalendarShare.setEmail(paramCursor.getString(paramCursor.getColumnIndex("email")));
    localQMCalendarShare.setName(paramCursor.getString(paramCursor.getColumnIndex("name")));
    localQMCalendarShare.setState(paramCursor.getInt(paramCursor.getColumnIndex("state")));
    return localQMCalendarShare;
  }
  
  public static String getString(Cursor paramCursor, String paramString)
  {
    return paramCursor.getString(paramCursor.getColumnIndex(paramString));
  }
  
  private void insertCalendarRelateContact(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      if (paramQMCalendarEvent.getCid() != 0L) {
        paramSQLiteDatabase.execSQL("REPLACE INTO TABLE_CALENDAR_RELATE_CONTACT(eid ,cid) VALUES (?,?)", new String[] { String.valueOf(paramQMCalendarEvent.getId()), String.valueOf(paramQMCalendarEvent.getCid()) });
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void changeExceptionsForNewEvent(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      String str = String.valueOf(paramLong2);
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_RECURRENCE_EXCEPTION SET id = ?||'_'||exceptionStartTime, eid = ? WHERE exceptionStartTime >= ? AND eid = ?", new String[] { str, str, String.valueOf(paramLong3), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void createTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_ACCOUNT_CONFIG(id integer primary key, accountId integer, pwd varchar, profile varchar, protocol integer, attributes varchar, refreshTime integer ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_FOLDER(id integer primary key, accountId integer, accountName varchar, accountType varchar, name varchar, path varchar, ctag varchar, syncToken varchar, syncKey varchar, shareOwner varchar, ownerAccount varchar, collectionId varchar, parentId varchar, color integer, isShow integer, isEditable integer, type integer, category integer ,offLineOptType integer, createTime integer ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_EVENT(id integer primary key, accountId integer, accountName varchar, accountType varchar, folderId integer, uid varchar, reminder integer, subject varchar, location varchar, body varchar, bodyType integer, allday integer, sensitivity integer, timezone varchar, startTime integer, endTime integer, createTime integer, modifyTime integer, path varchar, etag varchar, serverId varchar, folderType integer, attributes integer, category integer, recurrenceType integer, calendarType integer, interval integer, until integer, weekOfMonth integer, dayOfWeek integer, monthOfYear integer, dayOfMonth integer, daysOfMonth varchar, isLeapMonth integer, firstDayOfWeek integer, offLineOptType integer ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_APPOINTMENT_EVENT(id integer primary key, uid varchar, accountId integer, type integer,organizerEmail varchar, organizerName varchar, responseType integer,meetingStatus integer ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_RECURRENCE_EXCEPTION(id varchar primary key, eid integer, exceptionStartTime integer, startTime integer, endTime integer, isDelete integer, isAllDay integer, reminder integer, subject varchar, body varchar, location varchar ) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_REMINDER(id integer primary key, accountId integer, eventId integer, folderId integer, date integer, startTime integer, eventStartTime integer, subject varchar) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_SETTING(defaultAccountId integer, defaultFolderId integer, defaultReminder integer, defaultReminderForAllDay integer, defaultDuration integer, refreshTime integer, refreshLocalTime integer, refreshLogTime integer,reminderCacheEnd integer, scheduleCacheStart integer, scheduleCacheEnd integer, syncTime integer, showLunarCalendar integer, showSystemCalendar integer,systemCalendarVisible varchar, defaultStartDayOfWeek integer)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_SCHEDULE_INSTANCE(id integer primary key, eid integer, exceptionId varchar, startTime integer, endTime integer, eventStartTime integer, eventEndTime integer, scheduleDate integer, isAllDay integer, relateType integer, colorId integer, subject varchar, location varchar, category integer) ");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS QM_SCHEDULE_INSTANCE_INDEX ON QM_SCHEDULE_INSTANCE(startTime ASC)");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_ATTENDEE(id integer primary key, email varchar, name varchar, status integer, type integer, eventId integer) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_RELATE_EVENT(eid integer primary key, relateId varchar, relateType integer, relateAccountId integer) ");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TABLE_CALENDAR_RELATE_CONTACT(eid integer, cid integer,  primary key (eid,cid))");
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_SHARE(id integer primary key, folderId integer, email varchar, name varchar, state integer ) ");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      insertCalendarDefaultSettingData(paramSQLiteDatabase, new CalendarDefaultSettingData());
    }
  }
  
  public void deleteAllSchedule(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteCalendarAccountConfigByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ACCOUNT_CONFIG WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteCalendarEventByFolderId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    deleteCalendarEventByFolderId(paramSQLiteDatabase, localArrayList);
  }
  
  public void deleteCalendarEventByFolderId(SQLiteDatabase paramSQLiteDatabase, List<Integer> paramList)
  {
    paramList = getEventIdsByFolders(paramSQLiteDatabase, paramList);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = StringUtils.join(paramList, ",");
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_EVENT WHERE id IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE eventId IN($eventIds$)".replace("$eventIds$", paramList));
      paramSQLiteDatabase.execSQL("DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid IN($eventIds$)".replace("$eventIds$", paramList));
    }
  }
  
  public void deleteCalendarFolder(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    deleteCalendarFolders(paramSQLiteDatabase, localArrayList);
  }
  
  public void deleteCalendarFolderByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid IN (SELECT id FROM QM_CALENDAR_EVENT WHERE accountId = ?)", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_EVENT WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_SHARE WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE accountId = ? ) ", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_FOLDER WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteCalendarFolders(SQLiteDatabase paramSQLiteDatabase, List<Integer> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    try
    {
      deleteCalendarEventByFolderId(paramSQLiteDatabase, paramList);
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_SHARE WHERE folderId IN ($folderIds$) ".replace("$folderIds$", StringUtils.join(paramList, ",")));
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_FOLDER WHERE id IN ($folderIds$)".replace("$folderIds$", StringUtils.join(paramList, ",")));
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteCalendarRelateContact(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteEvent(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RELATE_EVENT WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM TABLE_CALENDAR_RELATE_CONTACT WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_EVENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteEventReminderAfterTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ? AND eventStartTime >= ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteEventReminderByTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ? AND eventStartTime = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteEventsByUidAndAccount(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCalendarEvent> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    int k = paramArrayList.size();
    int j = 0;
    int i;
    if (j < k)
    {
      if (j + 300 > k) {}
      for (i = k;; i = j + 300)
      {
        localArrayList.addAll(getEventIdByUidAndAccount(paramSQLiteDatabase, localStringBuilder, paramArrayList, j, i));
        j = i;
        break;
      }
    }
    if (localArrayList.size() > 0)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        deleteEvent(paramSQLiteDatabase, ((Long)localArrayList.get(i)).longValue());
        i += 1;
      }
    }
  }
  
  public void deleteException(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE id = ?", new String[] { paramString });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteExceptionsForEvent(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ? AND exceptionStartTime >= ?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteRemindersBeforeTime(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE date < ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteRemindersByAccountId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE accountId = ?", new String[] { String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteRemindersByEventId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_REMINDER WHERE eventId = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteScheduleAfterTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime >= ? AND eid = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteScheduleByStartTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime = ? AND eid = ? ", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteScheduleForTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eventStartTime = ? AND eid = ? AND eventEndTime = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1), String.valueOf(paramLong3) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteSchedulesByEventId(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_SCHEDULE_INSTANCE WHERE eid = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void deleteShare(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_SHARE WHERE id = ? ", new Object[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void dropTable(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_ACCOUNT_CONFIG");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_FOLDER");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_EVENT");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_APPOINTMENT_EVENT");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_RECURRENCE_EXCEPTION");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_REMINDER");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_SETTING");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_SCHEDULE_INSTANCE");
      paramSQLiteDatabase.execSQL("DROP INDEX IF EXISTS QM_SCHEDULE_INSTANCE_INDEX");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_ATTENDEE");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_RELATE_EVENT");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS TABLE_CALENDAR_RELATE_CONTACT");
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS QM_CALENDAR_SHARE");
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public ArrayList<QMCalendarEvent> getAllOffLineOptEvents(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE offLineOptType>0 AND category != 1", null);
      if (localCursor != null)
      {
        if (localCursor.moveToFirst()) {
          do
          {
            QMCalendarEvent localQMCalendarEvent = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
            if (localQMCalendarEvent != null) {
              localArrayList.add(localQMCalendarEvent);
            }
          } while (localCursor.moveToNext());
        }
        localCursor.close();
      }
      fillRecurrenceExceptionForEvents(paramSQLiteDatabase, localArrayList);
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  /* Error */
  public ArrayList<QMCalendarEvent> getCalDavEvent(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    // Byte code:
    //   0: new 888	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 1038	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_1
    //   10: ldc_w 652
    //   13: iconst_1
    //   14: anewarray 854	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: iload_2
    //   20: invokestatic 1444	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   23: aastore
    //   24: invokevirtual 1037	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   27: astore 5
    //   29: aload 5
    //   31: ifnull +130 -> 161
    //   34: new 888	java/util/ArrayList
    //   37: dup
    //   38: invokespecial 1038	java/util/ArrayList:<init>	()V
    //   41: astore_1
    //   42: aload 5
    //   44: invokeinterface 1510 1 0
    //   49: istore_3
    //   50: iconst_0
    //   51: istore_2
    //   52: iload_2
    //   53: iload_3
    //   54: if_icmpge +69 -> 123
    //   57: aload 5
    //   59: iload_2
    //   60: invokeinterface 1514 2 0
    //   65: pop
    //   66: aload 5
    //   68: iconst_0
    //   69: invokeinterface 1109 2 0
    //   74: astore 4
    //   76: aload 5
    //   78: iconst_1
    //   79: invokeinterface 1109 2 0
    //   84: astore 6
    //   86: new 882	com/tencent/qqmail/calendar/data/QMCalendarEvent
    //   89: dup
    //   90: invokespecial 1198	com/tencent/qqmail/calendar/data/QMCalendarEvent:<init>	()V
    //   93: astore 7
    //   95: aload 7
    //   97: aload 4
    //   99: invokevirtual 1253	com/tencent/qqmail/calendar/data/QMCalendarEvent:setPath	(Ljava/lang/String;)V
    //   102: aload 7
    //   104: aload 6
    //   106: invokevirtual 1256	com/tencent/qqmail/calendar/data/QMCalendarEvent:seteTag	(Ljava/lang/String;)V
    //   109: aload_1
    //   110: aload 7
    //   112: invokevirtual 1059	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   115: pop
    //   116: iload_2
    //   117: iconst_1
    //   118: iadd
    //   119: istore_2
    //   120: goto -68 -> 52
    //   123: aload 5
    //   125: invokeinterface 1092 1 0
    //   130: aload_1
    //   131: areturn
    //   132: astore 5
    //   134: aload 4
    //   136: astore_1
    //   137: aload 5
    //   139: astore 4
    //   141: bipush 6
    //   143: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   146: aload 4
    //   148: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   151: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   154: aload_1
    //   155: areturn
    //   156: astore 4
    //   158: goto -17 -> 141
    //   161: aload 4
    //   163: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	QMCalendarSQLiteHelper
    //   0	164	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	164	2	paramInt	int
    //   49	6	3	i	int
    //   7	140	4	localObject	Object
    //   156	6	4	localException1	Exception
    //   27	97	5	localCursor	Cursor
    //   132	6	5	localException2	Exception
    //   84	21	6	str	String
    //   93	18	7	localQMCalendarEvent	QMCalendarEvent
    // Exception table:
    //   from	to	target	type
    //   9	29	132	java/lang/Exception
    //   34	42	132	java/lang/Exception
    //   42	50	156	java/lang/Exception
    //   57	116	156	java/lang/Exception
    //   123	130	156	java/lang/Exception
  }
  
  public ArrayList<CalendarAccountConfig> getCalendarAccountConfigs(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_ACCOUNT_CONFIG", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            CalendarAccountConfig localCalendarAccountConfig = new CalendarAccountConfig();
            localCalendarAccountConfig.setId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("id")));
            localCalendarAccountConfig.setAccountId(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("accountId")));
            localCalendarAccountConfig.setPwd(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("pwd")));
            localCalendarAccountConfig.setProtocol(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("protocol")));
            localCalendarAccountConfig.initFromProfileString(paramSQLiteDatabase.getString(paramSQLiteDatabase.getColumnIndex("profile")));
            localArrayList.add(localCalendarAccountConfig);
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  /* Error */
  public CalendarDefaultSettingData getCalendarDefaultSettingData(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 4
    //   11: astore_3
    //   12: aload_1
    //   13: ldc_w 631
    //   16: aconst_null
    //   17: invokevirtual 1037	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   20: astore 7
    //   22: aload 6
    //   24: astore_1
    //   25: aload 7
    //   27: ifnull +373 -> 400
    //   30: aload 5
    //   32: astore_1
    //   33: aload 4
    //   35: astore_3
    //   36: aload 7
    //   38: invokeinterface 1046 1 0
    //   43: ifeq +348 -> 391
    //   46: aload 4
    //   48: astore_3
    //   49: new 1431	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData
    //   52: dup
    //   53: invokespecial 1432	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:<init>	()V
    //   56: astore_1
    //   57: aload_1
    //   58: aload 7
    //   60: aload 7
    //   62: ldc 63
    //   64: invokeinterface 1097 2 0
    //   69: invokeinterface 1101 2 0
    //   74: invokevirtual 1536	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultAccountId	(I)V
    //   77: aload_1
    //   78: aload 7
    //   80: aload 7
    //   82: ldc 72
    //   84: invokeinterface 1097 2 0
    //   89: invokeinterface 1101 2 0
    //   94: invokevirtual 1539	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultFolderId	(I)V
    //   97: aload_1
    //   98: aload 7
    //   100: aload 7
    //   102: ldc 75
    //   104: invokeinterface 1097 2 0
    //   109: invokeinterface 1101 2 0
    //   114: invokevirtual 1542	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultReminderTime	(I)V
    //   117: aload_1
    //   118: aload 7
    //   120: aload 7
    //   122: ldc 66
    //   124: invokeinterface 1097 2 0
    //   129: invokeinterface 1101 2 0
    //   134: invokevirtual 1545	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultAllDayReminderTime	(I)V
    //   137: aload_1
    //   138: aload 7
    //   140: aload 7
    //   142: ldc 69
    //   144: invokeinterface 1097 2 0
    //   149: invokeinterface 1101 2 0
    //   154: invokevirtual 1548	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultEventDuration	(I)V
    //   157: aload_1
    //   158: aload 7
    //   160: aload 7
    //   162: ldc 26
    //   164: invokeinterface 1097 2 0
    //   169: invokeinterface 1182 2 0
    //   174: invokevirtual 1551	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setRefreshTime	(J)V
    //   177: aload_1
    //   178: aload 7
    //   180: aload 7
    //   182: ldc 78
    //   184: invokeinterface 1097 2 0
    //   189: invokeinterface 1182 2 0
    //   194: invokevirtual 1554	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setRefreshLocalTime	(J)V
    //   197: aload_1
    //   198: aload 7
    //   200: aload 7
    //   202: ldc 81
    //   204: invokeinterface 1097 2 0
    //   209: invokeinterface 1182 2 0
    //   214: invokevirtual 1557	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setRefreshLogTime	(J)V
    //   217: aload_1
    //   218: aload 7
    //   220: aload 7
    //   222: ldc 85
    //   224: invokeinterface 1097 2 0
    //   229: invokeinterface 1182 2 0
    //   234: invokevirtual 1560	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setReminderCacheEnd	(J)V
    //   237: aload_1
    //   238: aload 7
    //   240: aload 7
    //   242: ldc 91
    //   244: invokeinterface 1097 2 0
    //   249: invokeinterface 1182 2 0
    //   254: invokevirtual 1563	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setScheduleCacheStart	(J)V
    //   257: aload_1
    //   258: aload 7
    //   260: aload 7
    //   262: ldc 88
    //   264: invokeinterface 1097 2 0
    //   269: invokeinterface 1182 2 0
    //   274: invokevirtual 1566	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setScheduleCacheEnd	(J)V
    //   277: aload_1
    //   278: aload 7
    //   280: aload 7
    //   282: ldc 103
    //   284: invokeinterface 1097 2 0
    //   289: invokeinterface 1101 2 0
    //   294: invokevirtual 1569	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultSyncTime	(I)V
    //   297: aload 7
    //   299: aload 7
    //   301: ldc 94
    //   303: invokeinterface 1097 2 0
    //   308: invokeinterface 1101 2 0
    //   313: iconst_1
    //   314: if_icmpne +88 -> 402
    //   317: iconst_1
    //   318: istore_2
    //   319: aload_1
    //   320: iload_2
    //   321: invokevirtual 1572	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultShowLunarCalendar	(Z)V
    //   324: aload 7
    //   326: aload 7
    //   328: ldc 97
    //   330: invokeinterface 1097 2 0
    //   335: invokeinterface 1101 2 0
    //   340: iconst_1
    //   341: if_icmpne +66 -> 407
    //   344: iconst_1
    //   345: istore_2
    //   346: aload_1
    //   347: iload_2
    //   348: invokevirtual 1575	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultShowSystemCalendar	(Z)V
    //   351: aload_1
    //   352: aload 7
    //   354: aload 7
    //   356: ldc 106
    //   358: invokeinterface 1097 2 0
    //   363: invokeinterface 1109 2 0
    //   368: invokevirtual 1578	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setSystemCalendarVisibleStr	(Ljava/lang/String;)V
    //   371: aload_1
    //   372: aload 7
    //   374: aload 7
    //   376: ldc 100
    //   378: invokeinterface 1097 2 0
    //   383: invokeinterface 1101 2 0
    //   388: invokevirtual 1581	com/tencent/qqmail/calendar/data/CalendarDefaultSettingData:setDefaultStartDayOfWeek	(I)V
    //   391: aload_1
    //   392: astore_3
    //   393: aload 7
    //   395: invokeinterface 1092 1 0
    //   400: aload_1
    //   401: areturn
    //   402: iconst_0
    //   403: istore_2
    //   404: goto -85 -> 319
    //   407: iconst_0
    //   408: istore_2
    //   409: goto -63 -> 346
    //   412: astore_1
    //   413: bipush 6
    //   415: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   418: aload_1
    //   419: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   422: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   425: aload_3
    //   426: areturn
    //   427: astore 4
    //   429: aload_1
    //   430: astore_3
    //   431: aload 4
    //   433: astore_1
    //   434: goto -21 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	QMCalendarSQLiteHelper
    //   0	437	1	paramSQLiteDatabase	SQLiteDatabase
    //   318	91	2	bool	boolean
    //   11	420	3	localObject1	Object
    //   4	43	4	localObject2	Object
    //   427	5	4	localException	Exception
    //   7	24	5	localObject3	Object
    //   1	22	6	localObject4	Object
    //   20	374	7	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   12	22	412	java/lang/Exception
    //   36	46	412	java/lang/Exception
    //   49	57	412	java/lang/Exception
    //   393	400	412	java/lang/Exception
    //   57	317	427	java/lang/Exception
    //   319	344	427	java/lang/Exception
    //   346	391	427	java/lang/Exception
  }
  
  public QMCalendarEvent getCalendarEvent(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    localObject2 = localObject3;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
      if (localCursor != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localCursor.moveToFirst())
        {
          localObject2 = localObject3;
          localObject1 = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
        }
      }
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    catch (Exception paramSQLiteDatabase)
    {
      try
      {
        fillRecurrenceExceptionForEvent(paramSQLiteDatabase, (QMCalendarEvent)localObject1);
        localObject2 = localObject1;
        localCursor.close();
        return localObject1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          localObject2 = localObject1;
        }
      }
      paramSQLiteDatabase = paramSQLiteDatabase;
    }
    return localObject2;
  }
  
  public QMCalendarEvent getCalendarEventByCid(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    localObject2 = localObject3;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT E.* FROM QM_CALENDAR_EVENT AS E JOIN TABLE_CALENDAR_RELATE_CONTACT AS CRC WHERE E.id = CRC.eid AND CRC.cid =?", new String[] { String.valueOf(paramLong) });
      if (localCursor != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localCursor.moveToFirst())
        {
          localObject2 = localObject3;
          localObject1 = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
        }
      }
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    catch (Exception paramSQLiteDatabase)
    {
      try
      {
        fillRecurrenceExceptionForEvent(paramSQLiteDatabase, (QMCalendarEvent)localObject1);
        localObject2 = localObject1;
        localCursor.close();
        return localObject1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          localObject2 = localObject1;
        }
      }
      paramSQLiteDatabase = paramSQLiteDatabase;
    }
    return localObject2;
  }
  
  public QMCalendarEvent getCalendarEventByUid(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE uid = ? AND accountId=?", new String[] { paramString, String.valueOf(paramInt) });
      paramString = localObject4;
      if (localCursor != null)
      {
        paramString = localObject3;
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = localObject2;
          paramString = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
        }
        localObject1 = paramString;
        localCursor.close();
      }
      return paramString;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localObject1;
  }
  
  public QMCalendarEvent getCalendarEventWithAllException(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    localObject1 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    localObject2 = localObject3;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE id = ?", new String[] { String.valueOf(paramLong) });
      if (localCursor != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localCursor.moveToFirst())
        {
          localObject2 = localObject3;
          localObject1 = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
        }
      }
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    catch (Exception paramSQLiteDatabase)
    {
      try
      {
        fillAllRecurrenceExceptionForEvent(paramSQLiteDatabase, (QMCalendarEvent)localObject1);
        localObject2 = localObject1;
        localCursor.close();
        return localObject1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          localObject2 = localObject1;
        }
      }
      paramSQLiteDatabase = paramSQLiteDatabase;
    }
    return localObject2;
  }
  
  public ArrayList<QMCalendarEvent> getCalendarEvents(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Object localObject1 = String.valueOf(paramLong1);
      Object localObject2 = String.valueOf(paramLong2);
      localObject1 = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE offLineOptType<4 AND (( recurrenceType = -1 AND startTime >= ? AND startTime <= ? )  OR ( recurrenceType = -1 AND startTime <= ? AND endTime >= ? )  OR ( recurrenceType >= 0 AND startTime <= ?)) ", new String[] { localObject1, localObject2, localObject1, localObject1, localObject2 });
      if (localObject1 != null)
      {
        if (((Cursor)localObject1).moveToFirst()) {
          do
          {
            localObject2 = getCalendarEventFromCursor((Cursor)localObject1, paramSQLiteDatabase, false);
            if (localObject2 != null) {
              localArrayList.add(localObject2);
            }
          } while (((Cursor)localObject1).moveToNext());
        }
        ((Cursor)localObject1).close();
      }
      fillRecurrenceExceptionForEvents(paramSQLiteDatabase, localArrayList);
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public ArrayList<QMCalendarFolder> getCalendarFolders(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_FOLDER WHERE offLineOptType<4", null);
      if (localCursor != null)
      {
        if (localCursor.moveToFirst()) {
          do
          {
            QMCalendarFolder localQMCalendarFolder = getCalendarFolderFromCursor(localCursor);
            localQMCalendarFolder.setShareList(getShareList(paramSQLiteDatabase, localQMCalendarFolder.getId()));
            localArrayList.add(localQMCalendarFolder);
          } while (localCursor.moveToNext());
        }
        localCursor.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public QMCalendarEvent getDetailCalendarEventFromSchedule(SQLiteDatabase paramSQLiteDatabase, QMSchedule paramQMSchedule)
  {
    Object localObject5 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    localObject1 = localObject5;
    if (paramQMSchedule != null) {
      localObject2 = localObject3;
    }
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_EVENT WHERE id = ?", new String[] { String.valueOf(paramQMSchedule.getEid()) });
      localObject1 = localObject5;
      if (localCursor != null)
      {
        localObject1 = localObject4;
        localObject2 = localObject3;
        if (localCursor.moveToFirst())
        {
          localObject2 = localObject3;
          localObject1 = getCalendarEventFromCursor(localCursor, paramSQLiteDatabase, true);
        }
      }
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    catch (Exception paramSQLiteDatabase)
    {
      try
      {
        fillRecurrenceExceptionForEvent(paramSQLiteDatabase, (QMCalendarEvent)localObject1);
        if (!StringUtils.isBlank(paramQMSchedule.getExceptionId()))
        {
          paramSQLiteDatabase = QMCalendarManager.getExceptionFromEvent((QMCalendarEvent)localObject1, RecurringException.getExceptionStartTimeFromId(paramQMSchedule.getExceptionId()));
          if (paramSQLiteDatabase != null)
          {
            paramQMSchedule = new ArrayList();
            paramQMSchedule.add(paramSQLiteDatabase);
            ((QMCalendarEvent)localObject1).setExceptions(paramQMSchedule);
            QMCalendarManager.fillEventWithSpecificException((QMCalendarEvent)localObject1, paramSQLiteDatabase);
          }
        }
        localObject2 = localObject1;
        localCursor.close();
        return localObject1;
      }
      catch (Exception paramSQLiteDatabase)
      {
        for (;;)
        {
          localObject2 = localObject1;
        }
      }
      paramSQLiteDatabase = paramSQLiteDatabase;
    }
    return localObject2;
  }
  
  public long getEventIdBySvrIdAndAccountId(SQLiteDatabase paramSQLiteDatabase, String paramString, int paramInt)
  {
    long l2 = 0L;
    long l3 = l2;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_CALENDAR_EVENT WHERE serverId=? AND accountId=?", new String[] { paramString, String.valueOf(paramInt) });
      long l1 = l2;
      if (paramSQLiteDatabase != null)
      {
        l1 = l2;
        l3 = l2;
        if (paramSQLiteDatabase.moveToFirst())
        {
          l3 = l2;
          l1 = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("id"));
        }
        l3 = l1;
        paramSQLiteDatabase.close();
      }
      return l1;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return l3;
  }
  
  public ArrayList<Long> getEventIdByUidAndAccount(SQLiteDatabase paramSQLiteDatabase, StringBuilder paramStringBuilder, ArrayList<QMCalendarEvent> paramArrayList, int paramInt1, int paramInt2)
  {
    paramStringBuilder.setLength(0);
    paramStringBuilder.append("SELECT id FROM QM_CALENDAR_EVENT").append(" WHERE ");
    while (paramInt1 < paramInt2)
    {
      paramStringBuilder.append("(").append("uid").append(" = \"").append(((QMCalendarEvent)paramArrayList.get(paramInt1)).getUid()).append("\"").append(" AND ").append("accountId").append(" = ").append(((QMCalendarEvent)paramArrayList.get(paramInt1)).getAccountId()).append(")");
      if (paramInt1 != paramInt2 - 1) {
        paramStringBuilder.append(" OR ");
      }
      paramInt1 += 1;
    }
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(paramStringBuilder.toString(), null);
    paramStringBuilder = new ArrayList();
    if (paramSQLiteDatabase != null)
    {
      if (paramSQLiteDatabase.moveToFirst()) {
        do
        {
          paramStringBuilder.add(Long.valueOf(paramSQLiteDatabase.getLong(0)));
        } while (paramSQLiteDatabase.moveToNext());
      }
      paramSQLiteDatabase.close();
    }
    return paramStringBuilder;
  }
  
  public ArrayList<Long> getEventIdsByFolders(SQLiteDatabase paramSQLiteDatabase, List<Integer> paramList)
  {
    ArrayList localArrayList2 = null;
    ArrayList localArrayList1 = localArrayList2;
    if (paramList != null)
    {
      if (paramList.size() > 0) {
        break label24;
      }
      localArrayList1 = localArrayList2;
    }
    for (;;)
    {
      return localArrayList1;
      label24:
      localArrayList2 = new ArrayList();
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN($folderIds$) ".replace("$folderIds$", StringUtils.join(paramList, ",")), null);
        localArrayList1 = localArrayList2;
        if (paramSQLiteDatabase != null)
        {
          if (paramSQLiteDatabase.moveToFirst()) {
            do
            {
              localArrayList2.add(Long.valueOf(paramSQLiteDatabase.getLong(0)));
            } while (paramSQLiteDatabase.moveToNext());
          }
          paramSQLiteDatabase.close();
          return localArrayList2;
        }
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
    return localArrayList2;
  }
  
  public ArrayList<Long> getEventIdsByPath(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SELECT id FROM QM_CALENDAR_EVENT").append(" WHERE ").append("path").append(" = \"").append(paramString).append("\"");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(0)));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public ArrayList<Long> getEventIdsBySvrId(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SELECT id FROM QM_CALENDAR_EVENT").append(" WHERE ").append("serverId").append(" = \"").append(paramString).append("\"");
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(Long.valueOf(paramSQLiteDatabase.getLong(0)));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public HashMap<Long, Integer> getHolidayScheduleDates(long paramLong1, long paramLong2)
  {
    Object localObject = getReadableDatabase();
    localHashMap = new HashMap();
    try
    {
      localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT subject, startTime FROM QM_CALENDAR_EVENT WHERE folderId in (select id from QM_CALENDAR_FOLDER where collectionId='10001002#H#1025' AND isShow = 1) AND (subject='补班' OR subject like '%第%') AND startTime >= ? AND startTime <= ?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
      if (localObject != null) {
        if (((Cursor)localObject).moveToFirst())
        {
          String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("subject"));
          paramLong1 = ((Cursor)localObject).getLong(((Cursor)localObject).getColumnIndex("startTime"));
          if (!"补班".equals(str)) {
            break label142;
          }
        }
      }
      label142:
      for (int i = 0;; i = 1)
      {
        localHashMap.put(Long.valueOf(paramLong1), Integer.valueOf(i));
        if (((Cursor)localObject).moveToNext()) {
          break;
        }
        ((Cursor)localObject).close();
        return localHashMap;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(localException));
    }
  }
  
  protected String getInClause(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramInt)
    {
      if (i != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append("?");
      i += 1;
    }
    return "(" + localStringBuilder.toString() + ")";
  }
  
  protected String getInClause(ArrayList<Integer> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayList.get(i));
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected String getInClause(long[] paramArrayOfLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(paramArrayOfLong[i]);
      if (i != j - 1) {
        localStringBuilder.append(",");
      }
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  protected String getInClause(String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    int j = paramArrayOfString.length;
    int i = 0;
    if (i < j)
    {
      String str = paramArrayOfString[i];
      if ((str == null) || (str.equals(""))) {}
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append("'" + str + "'");
        if (i != j - 1) {
          localStringBuilder.append(",");
        }
      }
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public ArrayList<QMCalendarFolder> getOffLineCalendarFolders(SQLiteDatabase paramSQLiteDatabase)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_FOLDER WHERE offLineOptType<>0 AND category != 1", null);
      if (localCursor != null)
      {
        if (localCursor.moveToFirst()) {
          do
          {
            QMCalendarFolder localQMCalendarFolder = getCalendarFolderFromCursor(localCursor);
            localQMCalendarFolder.setShareList(getShareList(paramSQLiteDatabase, localQMCalendarFolder.getId()));
            localArrayList.add(localQMCalendarFolder);
          } while (localCursor.moveToNext());
        }
        localCursor.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    return super.getReadableDatabase();
  }
  
  public long getReminderCacheEnd(SQLiteDatabase paramSQLiteDatabase)
  {
    long l2 = 0L;
    long l3 = l2;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT reminderCacheEnd FROM QM_CALENDAR_SETTING", null);
      long l1 = l2;
      if (paramSQLiteDatabase != null)
      {
        l1 = l2;
        l3 = l2;
        if (paramSQLiteDatabase.moveToFirst())
        {
          l3 = l2;
          l1 = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("reminderCacheEnd"));
        }
        l3 = l1;
        paramSQLiteDatabase.close();
      }
      return l1;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return l3;
  }
  
  public ArrayList<QMCalendarReminder> getReminders(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id,date,subject FROM QM_CALENDAR_REMINDER WHERE date IN (SELECT date FROM QM_CALENDAR_REMINDER WHERE date BETWEEN ? AND ? ORDER BY date ASC LIMIT 1)", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            QMCalendarReminder localQMCalendarReminder = new QMCalendarReminder();
            localQMCalendarReminder.setId(paramSQLiteDatabase.getInt(0));
            localQMCalendarReminder.setRemindTime(paramSQLiteDatabase.getLong(1));
            localQMCalendarReminder.setSubject(paramSQLiteDatabase.getString(2));
            localArrayList.add(localQMCalendarReminder);
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public HashMap<String, Boolean> getRemoteSvrIds(SQLiteDatabase paramSQLiteDatabase)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT serverId FROM QM_CALENDAR_EVENT WHERE category != 1", null);
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            String str = paramSQLiteDatabase.getString(0);
            if (StringExtention.isNullOrEmpty(str)) {
              localHashMap.put(str, Boolean.valueOf(true));
            }
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localHashMap;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localHashMap;
  }
  
  public QMSchedule getScheduleByCid(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT S.* FROM QM_SCHEDULE_INSTANCE AS S JOIN TABLE_CALENDAR_RELATE_CONTACT AS CRC WHERE CRC. eid = S.eid AND cid = ?", new String[] { String.valueOf(paramLong) });
      paramSQLiteDatabase = localObject4;
      if (localCursor != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = getScheduleFromCursor(localCursor);
        }
        localObject1 = paramSQLiteDatabase;
        localCursor.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localObject1;
  }
  
  public QMSchedule getScheduleById(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_SCHEDULE_INSTANCE WHERE id = ?", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase = localObject4;
      if (localCursor != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = getScheduleFromCursor(localCursor);
        }
        localObject1 = paramSQLiteDatabase;
        localCursor.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localObject1;
  }
  
  public QMSchedule getScheduleByReminderId(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localObject2;
    try
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_SCHEDULE_INSTANCE AS S INNER JOIN QM_CALENDAR_REMINDER AS R ON S.eid = R.eventId AND S.startTime = R.startTime AND S.eventStartTime = R.eventStartTime WHERE R.id = ?", new String[] { String.valueOf(paramInt) });
      paramSQLiteDatabase = localObject4;
      if (localCursor != null)
      {
        paramSQLiteDatabase = localObject3;
        localObject1 = localObject2;
        if (localCursor.moveToFirst())
        {
          localObject1 = localObject2;
          paramSQLiteDatabase = getScheduleFromCursorWithoutCache(localCursor);
        }
        localObject1 = paramSQLiteDatabase;
        localCursor.close();
      }
      return paramSQLiteDatabase;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localObject1;
  }
  
  public long[] getScheduleCache(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      long[] arrayOfLong = new long[2];
      QMLog.log(6, TAG, Log.getStackTraceString(localException1));
    }
    catch (Exception localException1)
    {
      try
      {
        paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT scheduleCacheStart,scheduleCacheEnd FROM QM_CALENDAR_SETTING", null);
        if (paramSQLiteDatabase != null)
        {
          if (paramSQLiteDatabase.moveToFirst())
          {
            arrayOfLong[0] = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("scheduleCacheStart"));
            arrayOfLong[1] = paramSQLiteDatabase.getLong(paramSQLiteDatabase.getColumnIndex("scheduleCacheEnd"));
          }
          paramSQLiteDatabase.close();
        }
        return arrayOfLong;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramSQLiteDatabase = localException1;
          Object localObject = localException2;
        }
      }
      localException1 = localException1;
      paramSQLiteDatabase = null;
    }
    return paramSQLiteDatabase;
  }
  
  public ArrayList<Integer> getScheduleDates(long paramLong1, long paramLong2)
  {
    Object localObject = getReadableDatabase();
    ArrayList localArrayList = Lists.newArrayList();
    try
    {
      localObject = ((SQLiteDatabase)localObject).rawQuery("SELECT DISTINCT scheduleDate FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ?  AND eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 ) ) ", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
      if (localObject != null)
      {
        if (((Cursor)localObject).moveToFirst()) {
          do
          {
            localArrayList.add(Integer.valueOf(((Cursor)localObject).getInt(((Cursor)localObject).getColumnIndex("scheduleDate"))));
          } while (((Cursor)localObject).moveToNext());
        }
        ((Cursor)localObject).close();
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(localException));
    }
    return localArrayList;
  }
  
  /* Error */
  public QMSchedule getScheduleFromCursor(Cursor paramCursor)
  {
    // Byte code:
    //   0: new 1610	com/tencent/qqmail/calendar/data/QMSchedule
    //   3: dup
    //   4: invokespecial 1724	com/tencent/qqmail/calendar/data/QMSchedule:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: aload_0
    //   11: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   14: aload_1
    //   15: ldc 17
    //   17: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   20: invokeinterface 1101 2 0
    //   25: invokevirtual 1725	com/tencent/qqmail/calendar/data/QMSchedule:setId	(I)V
    //   28: aload_3
    //   29: aload_1
    //   30: aload_0
    //   31: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   34: aload_1
    //   35: ldc 251
    //   37: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   40: invokeinterface 1182 2 0
    //   45: invokevirtual 1728	com/tencent/qqmail/calendar/data/QMSchedule:setEid	(J)V
    //   48: aload_3
    //   49: aload_1
    //   50: aload_0
    //   51: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   54: aload_1
    //   55: ldc_w 317
    //   58: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   61: invokeinterface 1109 2 0
    //   66: invokevirtual 1731	com/tencent/qqmail/calendar/data/QMSchedule:setExceptionId	(Ljava/lang/String;)V
    //   69: aload_3
    //   70: aload_1
    //   71: aload_0
    //   72: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   75: aload_1
    //   76: ldc 196
    //   78: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   81: invokeinterface 1182 2 0
    //   86: invokevirtual 1732	com/tencent/qqmail/calendar/data/QMSchedule:setStartTime	(J)V
    //   89: aload_3
    //   90: aload_1
    //   91: aload_0
    //   92: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   95: aload_1
    //   96: ldc 141
    //   98: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   101: invokeinterface 1182 2 0
    //   106: invokevirtual 1733	com/tencent/qqmail/calendar/data/QMSchedule:setEndTime	(J)V
    //   109: aload_3
    //   110: aload_1
    //   111: aload_0
    //   112: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   115: aload_1
    //   116: ldc_w 287
    //   119: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   122: invokeinterface 1182 2 0
    //   127: invokevirtual 1736	com/tencent/qqmail/calendar/data/QMSchedule:setEventStartTime	(J)V
    //   130: aload_3
    //   131: aload_1
    //   132: aload_0
    //   133: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   136: aload_1
    //   137: ldc_w 309
    //   140: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   143: invokeinterface 1182 2 0
    //   148: invokevirtual 1739	com/tencent/qqmail/calendar/data/QMSchedule:setEventEndTime	(J)V
    //   151: aload_3
    //   152: aload_1
    //   153: aload_0
    //   154: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   157: aload_1
    //   158: ldc_w 305
    //   161: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   164: invokeinterface 1101 2 0
    //   169: invokevirtual 1742	com/tencent/qqmail/calendar/data/QMSchedule:setScheduleDate	(I)V
    //   172: aload_1
    //   173: aload_0
    //   174: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   177: aload_1
    //   178: ldc_w 258
    //   181: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   184: invokeinterface 1101 2 0
    //   189: iconst_1
    //   190: if_icmpne +114 -> 304
    //   193: iconst_1
    //   194: istore_2
    //   195: aload_3
    //   196: iload_2
    //   197: invokevirtual 1743	com/tencent/qqmail/calendar/data/QMSchedule:setIsAllDay	(Z)V
    //   200: aload_3
    //   201: aload_1
    //   202: aload_0
    //   203: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   206: aload_1
    //   207: ldc_w 279
    //   210: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   213: invokeinterface 1101 2 0
    //   218: invokevirtual 1746	com/tencent/qqmail/calendar/data/QMSchedule:setRelatedType	(I)V
    //   221: aload_3
    //   222: aload_1
    //   223: aload_0
    //   224: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   227: aload_1
    //   228: ldc_w 302
    //   231: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   234: invokeinterface 1101 2 0
    //   239: invokevirtual 1747	com/tencent/qqmail/calendar/data/QMSchedule:setColor	(I)V
    //   242: aload_3
    //   243: aload_1
    //   244: aload_0
    //   245: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   248: aload_1
    //   249: ldc 199
    //   251: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   254: invokeinterface 1109 2 0
    //   259: invokevirtual 1748	com/tencent/qqmail/calendar/data/QMSchedule:setSubject	(Ljava/lang/String;)V
    //   262: aload_3
    //   263: aload_1
    //   264: aload_0
    //   265: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   268: aload_1
    //   269: ldc 160
    //   271: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   274: invokeinterface 1109 2 0
    //   279: invokevirtual 1749	com/tencent/qqmail/calendar/data/QMSchedule:setLocation	(Ljava/lang/String;)V
    //   282: aload_3
    //   283: aload_1
    //   284: aload_0
    //   285: getfield 848	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:scheduleColumnIndexCache	Ljava/util/HashMap;
    //   288: aload_1
    //   289: ldc 126
    //   291: invokestatic 1178	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getColumnIndex	(Ljava/util/HashMap;Landroid/database/Cursor;Ljava/lang/String;)I
    //   294: invokeinterface 1101 2 0
    //   299: invokevirtual 1750	com/tencent/qqmail/calendar/data/QMSchedule:setCategory	(I)V
    //   302: aload_3
    //   303: areturn
    //   304: iconst_0
    //   305: istore_2
    //   306: goto -111 -> 195
    //   309: astore_3
    //   310: aconst_null
    //   311: astore_1
    //   312: bipush 6
    //   314: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   317: aload_3
    //   318: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   321: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   324: aload_1
    //   325: areturn
    //   326: astore 4
    //   328: aload_3
    //   329: astore_1
    //   330: aload 4
    //   332: astore_3
    //   333: goto -21 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	QMCalendarSQLiteHelper
    //   0	336	1	paramCursor	Cursor
    //   194	112	2	bool	boolean
    //   7	296	3	localQMSchedule	QMSchedule
    //   309	20	3	localException1	Exception
    //   332	1	3	localObject	Object
    //   326	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	309	java/lang/Exception
    //   8	193	326	java/lang/Exception
    //   195	302	326	java/lang/Exception
  }
  
  /* Error */
  public QMSchedule getScheduleFromCursorWithoutCache(Cursor paramCursor)
  {
    // Byte code:
    //   0: new 1610	com/tencent/qqmail/calendar/data/QMSchedule
    //   3: dup
    //   4: invokespecial 1724	com/tencent/qqmail/calendar/data/QMSchedule:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: aload_1
    //   11: ldc 17
    //   13: invokeinterface 1097 2 0
    //   18: invokeinterface 1101 2 0
    //   23: invokevirtual 1725	com/tencent/qqmail/calendar/data/QMSchedule:setId	(I)V
    //   26: aload_3
    //   27: aload_1
    //   28: aload_1
    //   29: ldc 251
    //   31: invokeinterface 1097 2 0
    //   36: invokeinterface 1182 2 0
    //   41: invokevirtual 1728	com/tencent/qqmail/calendar/data/QMSchedule:setEid	(J)V
    //   44: aload_3
    //   45: aload_1
    //   46: aload_1
    //   47: ldc_w 317
    //   50: invokeinterface 1097 2 0
    //   55: invokeinterface 1109 2 0
    //   60: invokevirtual 1731	com/tencent/qqmail/calendar/data/QMSchedule:setExceptionId	(Ljava/lang/String;)V
    //   63: aload_3
    //   64: aload_1
    //   65: aload_1
    //   66: ldc 196
    //   68: invokeinterface 1097 2 0
    //   73: invokeinterface 1182 2 0
    //   78: invokevirtual 1732	com/tencent/qqmail/calendar/data/QMSchedule:setStartTime	(J)V
    //   81: aload_3
    //   82: aload_1
    //   83: aload_1
    //   84: ldc 141
    //   86: invokeinterface 1097 2 0
    //   91: invokeinterface 1182 2 0
    //   96: invokevirtual 1733	com/tencent/qqmail/calendar/data/QMSchedule:setEndTime	(J)V
    //   99: aload_3
    //   100: aload_1
    //   101: aload_1
    //   102: ldc_w 287
    //   105: invokeinterface 1097 2 0
    //   110: invokeinterface 1182 2 0
    //   115: invokevirtual 1736	com/tencent/qqmail/calendar/data/QMSchedule:setEventStartTime	(J)V
    //   118: aload_3
    //   119: aload_1
    //   120: aload_1
    //   121: ldc_w 309
    //   124: invokeinterface 1097 2 0
    //   129: invokeinterface 1182 2 0
    //   134: invokevirtual 1739	com/tencent/qqmail/calendar/data/QMSchedule:setEventEndTime	(J)V
    //   137: aload_3
    //   138: aload_1
    //   139: aload_1
    //   140: ldc_w 305
    //   143: invokeinterface 1097 2 0
    //   148: invokeinterface 1101 2 0
    //   153: invokevirtual 1742	com/tencent/qqmail/calendar/data/QMSchedule:setScheduleDate	(I)V
    //   156: aload_1
    //   157: aload_1
    //   158: ldc_w 258
    //   161: invokeinterface 1097 2 0
    //   166: invokeinterface 1101 2 0
    //   171: iconst_1
    //   172: if_icmpne +104 -> 276
    //   175: iconst_1
    //   176: istore_2
    //   177: aload_3
    //   178: iload_2
    //   179: invokevirtual 1743	com/tencent/qqmail/calendar/data/QMSchedule:setIsAllDay	(Z)V
    //   182: aload_3
    //   183: aload_1
    //   184: aload_1
    //   185: ldc_w 279
    //   188: invokeinterface 1097 2 0
    //   193: invokeinterface 1101 2 0
    //   198: invokevirtual 1746	com/tencent/qqmail/calendar/data/QMSchedule:setRelatedType	(I)V
    //   201: aload_3
    //   202: aload_1
    //   203: aload_1
    //   204: ldc_w 302
    //   207: invokeinterface 1097 2 0
    //   212: invokeinterface 1101 2 0
    //   217: invokevirtual 1747	com/tencent/qqmail/calendar/data/QMSchedule:setColor	(I)V
    //   220: aload_3
    //   221: aload_1
    //   222: aload_1
    //   223: ldc 199
    //   225: invokeinterface 1097 2 0
    //   230: invokeinterface 1109 2 0
    //   235: invokevirtual 1748	com/tencent/qqmail/calendar/data/QMSchedule:setSubject	(Ljava/lang/String;)V
    //   238: aload_3
    //   239: aload_1
    //   240: aload_1
    //   241: ldc 160
    //   243: invokeinterface 1097 2 0
    //   248: invokeinterface 1109 2 0
    //   253: invokevirtual 1749	com/tencent/qqmail/calendar/data/QMSchedule:setLocation	(Ljava/lang/String;)V
    //   256: aload_3
    //   257: aload_1
    //   258: aload_1
    //   259: ldc 126
    //   261: invokeinterface 1097 2 0
    //   266: invokeinterface 1101 2 0
    //   271: invokevirtual 1750	com/tencent/qqmail/calendar/data/QMSchedule:setCategory	(I)V
    //   274: aload_3
    //   275: areturn
    //   276: iconst_0
    //   277: istore_2
    //   278: goto -101 -> 177
    //   281: astore_3
    //   282: aconst_null
    //   283: astore_1
    //   284: bipush 6
    //   286: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   289: aload_3
    //   290: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   293: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   296: aload_1
    //   297: areturn
    //   298: astore 4
    //   300: aload_3
    //   301: astore_1
    //   302: aload 4
    //   304: astore_3
    //   305: goto -21 -> 284
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	QMCalendarSQLiteHelper
    //   0	308	1	paramCursor	Cursor
    //   176	102	2	bool	boolean
    //   7	268	3	localQMSchedule	QMSchedule
    //   281	20	3	localException1	Exception
    //   304	1	3	localObject	Object
    //   298	5	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	8	281	java/lang/Exception
    //   8	175	298	java/lang/Exception
    //   177	274	298	java/lang/Exception
  }
  
  public Cursor getScheduleListCursor(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    return paramSQLiteDatabase.rawQuery("SELECT * FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ? AND (eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId!='10001002#H#1025')) OR eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1  AND collectionId='10001002#H#1025')  GROUP BY startTime, subject)) ORDER BY (CASE WHEN startTime != eventStartTime AND endTime = eventEndTime THEN eventEndTime ELSE startTime END), colorId", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
  }
  
  public ArrayList<CalendarWidgetItemInfo> getScheduleListForTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT id, colorId, startTime, subject, isAllDay FROM QM_SCHEDULE_INSTANCE WHERE startTime BETWEEN ? AND ? AND eid IN (  SELECT id FROM QM_CALENDAR_EVENT WHERE folderId IN ( SELECT id FROM QM_CALENDAR_FOLDER WHERE isShow = 1 ) )  ORDER BY (CASE WHEN startTime != eventStartTime AND endTime = eventEndTime THEN eventEndTime ELSE startTime END), colorId", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
    GregorianCalendar localGregorianCalendar = new GregorianCalendar();
    ArrayList localArrayList = new ArrayList();
    if ((paramSQLiteDatabase == null) || (paramSQLiteDatabase.moveToFirst())) {}
    for (;;)
    {
      try
      {
        CalendarWidgetItemInfo localCalendarWidgetItemInfo = new CalendarWidgetItemInfo();
        localCalendarWidgetItemInfo.setId(paramSQLiteDatabase.getInt(getColumnIndex(null, paramSQLiteDatabase, "id")));
        paramLong1 = paramSQLiteDatabase.getLong(getColumnIndex(null, paramSQLiteDatabase, "startTime"));
        localGregorianCalendar.setTimeInMillis(paramLong1);
        localCalendarWidgetItemInfo.setHappenTime(paramLong1);
        localCalendarWidgetItemInfo.setMonthDayString(QMCalendarUtil.getMonthDayString(localGregorianCalendar));
        localCalendarWidgetItemInfo.setHourMinuteString(QMCalendarUtil.getTimeString(localGregorianCalendar));
        localCalendarWidgetItemInfo.setWeekString(QMCalendarUtil.getWeekString(localGregorianCalendar));
        localCalendarWidgetItemInfo.setSchedule(paramSQLiteDatabase.getString(getColumnIndex(null, paramSQLiteDatabase, "subject")));
        if (paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("isAllDay")) != 1) {
          continue;
        }
        bool = true;
        localCalendarWidgetItemInfo.setIsAllDay(bool);
        localCalendarWidgetItemInfo.setColor(paramSQLiteDatabase.getInt(paramSQLiteDatabase.getColumnIndex("colorId")));
        localArrayList.add(localCalendarWidgetItemInfo);
      }
      catch (Exception localException)
      {
        boolean bool;
        QMLog.log(6, TAG, Log.getStackTraceString(localException));
        continue;
      }
      if (!paramSQLiteDatabase.moveToNext())
      {
        paramSQLiteDatabase.close();
        return localArrayList;
        bool = false;
      }
    }
  }
  
  public ArrayList<QMCalendarShare> getShareList(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_SHARE WHERE folderId = ? ", new String[] { String.valueOf(paramInt) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(getShareFromCursor(paramSQLiteDatabase));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public ArrayList<QMCalendarShare> getShareListByEmails(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_SHARE WHERE folderId = ? AND email = ? ", new String[] { String.valueOf(paramInt), String.valueOf(paramString) });
      if (paramSQLiteDatabase != null)
      {
        if (paramSQLiteDatabase.moveToFirst()) {
          do
          {
            localArrayList.add(getShareFromCursor(paramSQLiteDatabase));
          } while (paramSQLiteDatabase.moveToNext());
        }
        paramSQLiteDatabase.close();
      }
      return localArrayList;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return localArrayList;
  }
  
  public void insertAppointmentEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      if ((paramQMCalendarEvent.getOrganizerEmail() != null) && (paramQMCalendarEvent.getOrganizerName() != null)) {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_APPOINTMENT_EVENT ( id , uid , accountId , type , organizerEmail , organizerName , responseType , meetingStatus ) VALUES (?,?,?,?,?,?,?,?)", new Object[] { Long.valueOf(paramQMCalendarEvent.getId()), paramQMCalendarEvent.getUid(), Integer.valueOf(paramQMCalendarEvent.getAccountId()), Integer.valueOf(paramQMCalendarEvent.getAppointmentType()), paramQMCalendarEvent.getOrganizerEmail(), paramQMCalendarEvent.getOrganizerName(), Integer.valueOf(paramQMCalendarEvent.getResponseType()), Integer.valueOf(paramQMCalendarEvent.getMeetingStatus()) });
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertAttendee(SQLiteDatabase paramSQLiteDatabase, Attendee paramAttendee, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL(" REPLACE INTO QM_CALENDAR_ATTENDEE ( id , email , name , status , type , eventId ) VALUES (?,?,?,?,?,?)", new Object[] { Long.valueOf(Attendee.generateId(paramAttendee, paramLong)), paramAttendee.getEmail(), paramAttendee.getName(), Integer.valueOf(paramAttendee.getStatus()), Integer.valueOf(paramAttendee.getType()), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  /* Error */
  public void insertAttendee(SQLiteDatabase paramSQLiteDatabase, ArrayList<Attendee> paramArrayList, long paramLong)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +127 -> 128
    //   4: aload_2
    //   5: invokevirtual 891	java/util/ArrayList:size	()I
    //   8: ifle +120 -> 128
    //   11: aload_1
    //   12: invokevirtual 1421	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   15: aload_2
    //   16: invokevirtual 1150	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 1155 1 0
    //   26: ifeq +103 -> 129
    //   29: aload_2
    //   30: invokeinterface 1159 1 0
    //   35: checkcast 1125	com/tencent/qqmail/calendar/data/Attendee
    //   38: astore 5
    //   40: aload_1
    //   41: ldc_w 571
    //   44: bipush 6
    //   46: anewarray 946	java/lang/Object
    //   49: dup
    //   50: iconst_0
    //   51: aload 5
    //   53: lload_3
    //   54: invokestatic 1816	com/tencent/qqmail/calendar/data/Attendee:generateId	(Lcom/tencent/qqmail/calendar/data/Attendee;J)J
    //   57: invokestatic 951	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: aload 5
    //   65: invokevirtual 1819	com/tencent/qqmail/calendar/data/Attendee:getEmail	()Ljava/lang/String;
    //   68: aastore
    //   69: dup
    //   70: iconst_2
    //   71: aload 5
    //   73: invokevirtual 1822	com/tencent/qqmail/calendar/data/Attendee:getName	()Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_3
    //   79: aload 5
    //   81: invokevirtual 1825	com/tencent/qqmail/calendar/data/Attendee:getStatus	()I
    //   84: invokestatic 956	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: dup
    //   89: iconst_4
    //   90: aload 5
    //   92: invokevirtual 1828	com/tencent/qqmail/calendar/data/Attendee:getType	()I
    //   95: invokestatic 956	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: dup
    //   100: iconst_5
    //   101: lload_3
    //   102: invokestatic 858	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   105: aastore
    //   106: invokevirtual 864	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: goto -89 -> 20
    //   112: astore_2
    //   113: bipush 6
    //   115: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   118: ldc_w 1830
    //   121: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   124: aload_1
    //   125: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   128: return
    //   129: aload_1
    //   130: invokevirtual 1426	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   133: aload_1
    //   134: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   137: return
    //   138: astore_1
    //   139: bipush 6
    //   141: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   144: aload_1
    //   145: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   148: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   151: return
    //   152: astore_2
    //   153: aload_1
    //   154: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   157: aload_2
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	QMCalendarSQLiteHelper
    //   0	159	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	159	2	paramArrayList	ArrayList<Attendee>
    //   0	159	3	paramLong	long
    //   38	53	5	localAttendee	Attendee
    // Exception table:
    //   from	to	target	type
    //   15	20	112	java/lang/Exception
    //   20	109	112	java/lang/Exception
    //   129	133	112	java/lang/Exception
    //   4	15	138	java/lang/Exception
    //   124	128	138	java/lang/Exception
    //   133	137	138	java/lang/Exception
    //   153	159	138	java/lang/Exception
    //   15	20	152	finally
    //   20	109	152	finally
    //   113	124	152	finally
    //   129	133	152	finally
  }
  
  public void insertCalendarAccountConfig(SQLiteDatabase paramSQLiteDatabase, CalendarAccountConfig paramCalendarAccountConfig)
  {
    if (paramCalendarAccountConfig != null) {}
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_ACCOUNT_CONFIG ( id,accountId,pwd,profile,protocol,attributes,refreshTime) VALUES (?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(paramCalendarAccountConfig.getId()), Integer.valueOf(paramCalendarAccountConfig.getAccountId()), paramCalendarAccountConfig.getPwd(), paramCalendarAccountConfig.getProfileString(), Integer.valueOf(paramCalendarAccountConfig.getProtocol()), "", Long.valueOf(paramCalendarAccountConfig.getRefreshTime()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertCalendarDefaultSettingData(SQLiteDatabase paramSQLiteDatabase, CalendarDefaultSettingData paramCalendarDefaultSettingData)
  {
    int j = 1;
    if (paramCalendarDefaultSettingData != null) {}
    try
    {
      int k = paramCalendarDefaultSettingData.getDefaultAccountId();
      int m = paramCalendarDefaultSettingData.getDefaultFolderId();
      int n = paramCalendarDefaultSettingData.getDefaultReminderTime();
      int i1 = paramCalendarDefaultSettingData.getDefaultAllDayReminderTime();
      int i2 = paramCalendarDefaultSettingData.getDefaultEventDuration();
      long l1 = paramCalendarDefaultSettingData.getRefreshTime();
      long l2 = paramCalendarDefaultSettingData.getRefreshLocalTime();
      long l3 = paramCalendarDefaultSettingData.getRefreshLogTime();
      long l4 = paramCalendarDefaultSettingData.getReminderCacheEnd();
      long l5 = paramCalendarDefaultSettingData.getScheduleCacheStart();
      long l6 = paramCalendarDefaultSettingData.getScheduleCacheEnd();
      int i3 = paramCalendarDefaultSettingData.getDefaultSyncTime();
      int i;
      if (paramCalendarDefaultSettingData.isDefaultShowLunarCalendar())
      {
        i = 1;
        if (!paramCalendarDefaultSettingData.isDefaultShowSystemCalendar()) {
          break label251;
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_SETTING ( defaultAccountId,defaultFolderId,defaultReminder,defaultReminderForAllDay,defaultDuration,refreshTime,refreshLocalTime,refreshLogTime,reminderCacheEnd,scheduleCacheStart,scheduleCacheEnd,syncTime,showLunarCalendar,showSystemCalendar,systemCalendarVisible,defaultStartDayOfWeek) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(i2), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(l6), Integer.valueOf(i3), Integer.valueOf(i), Integer.valueOf(j), paramCalendarDefaultSettingData.getSystemCalendarVisibleStr(), Integer.valueOf(paramCalendarDefaultSettingData.getDefaultStartDayOfWeek()) });
        return;
        i = 0;
        break;
        label251:
        j = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertCalendarEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent != null) {
      paramSQLiteDatabase.beginTransactionNonExclusive();
    }
    try
    {
      doInsertCalendarEvent(paramSQLiteDatabase, paramQMCalendarEvent);
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramQMCalendarEvent)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramQMCalendarEvent));
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  public void insertCalendarEvents(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCalendarEvent> paramArrayList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +62 -> 63
    //   4: aload_2
    //   5: invokevirtual 891	java/util/ArrayList:size	()I
    //   8: ifle +55 -> 63
    //   11: aload_1
    //   12: invokevirtual 1421	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   15: aload_2
    //   16: invokevirtual 1150	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   19: astore_2
    //   20: aload_2
    //   21: invokeinterface 1155 1 0
    //   26: ifeq +38 -> 64
    //   29: aload_0
    //   30: aload_1
    //   31: aload_2
    //   32: invokeinterface 1159 1 0
    //   37: checkcast 882	com/tencent/qqmail/calendar/data/QMCalendarEvent
    //   40: invokespecial 1895	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:doInsertCalendarEvent	(Lcom/tencent/moai/database/sqlite/SQLiteDatabase;Lcom/tencent/qqmail/calendar/data/QMCalendarEvent;)V
    //   43: goto -23 -> 20
    //   46: astore_2
    //   47: bipush 6
    //   49: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   52: aload_2
    //   53: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   56: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   59: aload_1
    //   60: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   63: return
    //   64: aload_1
    //   65: invokevirtual 1426	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   68: aload_1
    //   69: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   72: return
    //   73: astore_2
    //   74: aload_1
    //   75: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	QMCalendarSQLiteHelper
    //   0	80	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	80	2	paramArrayList	ArrayList<QMCalendarEvent>
    // Exception table:
    //   from	to	target	type
    //   15	20	46	java/lang/Exception
    //   20	43	46	java/lang/Exception
    //   64	68	46	java/lang/Exception
    //   15	20	73	finally
    //   20	43	73	finally
    //   47	59	73	finally
    //   64	68	73	finally
  }
  
  public void insertCalendarFolder(SQLiteDatabase paramSQLiteDatabase, QMCalendarFolder paramQMCalendarFolder)
  {
    int j = 1;
    if (paramQMCalendarFolder != null) {}
    try
    {
      int k = paramQMCalendarFolder.getId();
      int m = paramQMCalendarFolder.getAccountId();
      String str1 = paramQMCalendarFolder.getAccountName();
      String str2 = paramQMCalendarFolder.getAccountType();
      String str3 = paramQMCalendarFolder.getName();
      String str4 = paramQMCalendarFolder.getPath();
      String str5 = paramQMCalendarFolder.getcTag();
      String str6 = paramQMCalendarFolder.getSyncToken();
      String str7 = paramQMCalendarFolder.getSyncKey();
      String str8 = paramQMCalendarFolder.getShareOwner();
      String str9 = paramQMCalendarFolder.getOwnerAccount();
      String str10 = paramQMCalendarFolder.getCollectionId();
      String str11 = paramQMCalendarFolder.getParentId();
      int n = paramQMCalendarFolder.getColor();
      int i;
      if (paramQMCalendarFolder.isShow())
      {
        i = 1;
        if (!paramQMCalendarFolder.isEditable()) {
          break label273;
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_FOLDER ( id,accountId,accountName,accountType,name,path,ctag,syncToken,syncKey,shareOwner,ownerAccount,collectionId,parentId,color,isShow,isEditable,type,category,offLineOptType,createTime) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(k), Integer.valueOf(m), str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramQMCalendarFolder.getType()), Integer.valueOf(paramQMCalendarFolder.getCategory()), Integer.valueOf(paramQMCalendarFolder.getOffLineOptType()), Long.valueOf(paramQMCalendarFolder.getCreateTime()) });
        return;
        i = 0;
        break;
        label273:
        j = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertException(SQLiteDatabase paramSQLiteDatabase, RecurringException paramRecurringException)
  {
    int j = 1;
    if (paramRecurringException != null) {}
    try
    {
      String str = paramRecurringException.getId();
      long l1 = paramRecurringException.getEventId();
      long l2 = paramRecurringException.getExceptionStartTime();
      long l3 = paramRecurringException.getStartTime();
      long l4 = paramRecurringException.getEndTime();
      int i;
      if (paramRecurringException.isDelete())
      {
        i = 1;
        if (!paramRecurringException.isAllDay()) {
          break label159;
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_RECURRENCE_EXCEPTION ( id,eid,exceptionStartTime,startTime,endTime,isDelete,isAllDay,reminder,subject,body,location) VALUES (?,?,?,?,?,?,?,?,?,?,?)", new Object[] { str, Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramRecurringException.getReminder()), paramRecurringException.getSubject(), paramRecurringException.getBody(), paramRecurringException.getLocation() });
        return;
        i = 0;
        break;
        label159:
        j = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertRecurrentExceptionsFromEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    ArrayList localArrayList = paramQMCalendarEvent.getExceptions();
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        Object localObject = new GregorianCalendar();
        ((Calendar)localObject).setTimeInMillis(((RecurringException)localArrayList.get(i)).getExceptionStartTime());
        int j = CalendarUtils.computeDate((Calendar)localObject);
        HashMap localHashMap = paramQMCalendarEvent.getExceptionHashMap();
        localObject = localHashMap;
        if (localHashMap == null)
        {
          localObject = new HashMap();
          paramQMCalendarEvent.setExceptionHashMap((HashMap)localObject);
        }
        ((HashMap)localObject).remove(Integer.valueOf(j));
        ((HashMap)localObject).put(Integer.valueOf(j), localArrayList.get(i));
        insertException(paramSQLiteDatabase, (RecurringException)localArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public void insertRelateEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      if (paramQMCalendarEvent.getRelateType() != 0) {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_RELATE_EVENT ( eid,relateId,relateType,relateAccountId ) VALUES (?,?,?,?)", new Object[] { Long.valueOf(paramQMCalendarEvent.getId()), paramQMCalendarEvent.getRelatedId(), Integer.valueOf(paramQMCalendarEvent.getRelateType()), Integer.valueOf(paramQMCalendarEvent.getRelateAccountId()) });
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertReminders(SQLiteDatabase paramSQLiteDatabase, ArrayList<QMCalendarReminder> paramArrayList)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    int i = 0;
    try
    {
      while (i < paramArrayList.size())
      {
        QMCalendarReminder localQMCalendarReminder = (QMCalendarReminder)paramArrayList.get(i);
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_REMINDER ( id,accountId,eventId,folderId,date,startTime,eventStartTime,subject) VALUES (?,?,?,?,?,?,?,?)", new String[] { String.valueOf(localQMCalendarReminder.getId()), String.valueOf(localQMCalendarReminder.getAccountId()), String.valueOf(localQMCalendarReminder.getEventId()), String.valueOf(localQMCalendarReminder.getFolderId()), String.valueOf(localQMCalendarReminder.getRemindTime()), String.valueOf(localQMCalendarReminder.getStartTime()), String.valueOf(localQMCalendarReminder.getEventStartTime()), localQMCalendarReminder.getSubject() });
        i += 1;
      }
      paramSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    catch (Exception paramArrayList)
    {
      QMLog.log(6, TAG, "insertReminders : " + Log.getStackTraceString(paramArrayList));
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void insertSchedule(SQLiteDatabase paramSQLiteDatabase, QMSchedule paramQMSchedule)
  {
    int i = 1;
    if (paramQMSchedule != null) {}
    try
    {
      int j = paramQMSchedule.getId();
      long l1 = paramQMSchedule.getEid();
      String str = paramQMSchedule.getExceptionId();
      long l2 = paramQMSchedule.getStartTime();
      long l3 = paramQMSchedule.getEndTime();
      long l4 = paramQMSchedule.getEventStartTime();
      long l5 = paramQMSchedule.getEventEndTime();
      int k = paramQMSchedule.getScheduleDate();
      if (paramQMSchedule.isAllDay()) {}
      for (;;)
      {
        paramSQLiteDatabase.execSQL("REPLACE INTO QM_SCHEDULE_INSTANCE ( id,eid,exceptionId,startTime,endTime,eventStartTime,eventEndTime,scheduleDate,isAllDay,relateType,colorId,subject,location,category) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)", new Object[] { Integer.valueOf(j), Long.valueOf(l1), str, Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(paramQMSchedule.getRelatedType()), Integer.valueOf(paramQMSchedule.getColor()), paramQMSchedule.getSubject(), paramQMSchedule.getLocation(), Integer.valueOf(paramQMSchedule.getCategory()) });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void insertShare(SQLiteDatabase paramSQLiteDatabase, QMCalendarShare paramQMCalendarShare)
  {
    try
    {
      paramSQLiteDatabase.execSQL("REPLACE INTO QM_CALENDAR_SHARE(id , folderId , email , name , state) VALUES (?,?,?,?,?)", new Object[] { String.valueOf(paramQMCalendarShare.getId()), String.valueOf(paramQMCalendarShare.getCalendarFolderId()), String.valueOf(paramQMCalendarShare.getEmail()), String.valueOf(paramQMCalendarShare.getName()), String.valueOf(paramQMCalendarShare.getState()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public boolean isExistShare(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    boolean bool1 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool2 = bool3;
    try
    {
      paramSQLiteDatabase = paramSQLiteDatabase.rawQuery("SELECT * FROM QM_CALENDAR_SHARE WHERE id = ? ", new String[] { String.valueOf(paramLong) });
      if (paramSQLiteDatabase != null)
      {
        bool1 = bool4;
        bool2 = bool3;
        if (paramSQLiteDatabase.moveToFirst()) {
          bool1 = true;
        }
        bool2 = bool1;
        paramSQLiteDatabase.close();
      }
      return bool1;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
    return bool2;
  }
  
  public void modifyEvent(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    int i = 1;
    try
    {
      int j = paramQMCalendarEvent.getCalderFolderId();
      int k = paramQMCalendarEvent.getReminder();
      String str1 = paramQMCalendarEvent.getSubject();
      String str2 = paramQMCalendarEvent.getLocation();
      String str3 = paramQMCalendarEvent.getBody();
      if (paramQMCalendarEvent.isAllDay()) {}
      for (;;)
      {
        paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET folderId = ?,reminder = ?,subject = ?,location = ?,body = ?,allday = ?,startTime = ?,endTime = ?,createTime = ?,modifyTime = ? WHERE id = ?", new String[] { String.valueOf(j), String.valueOf(k), str1, str2, str3, String.valueOf(i), String.valueOf(paramQMCalendarEvent.getStartTime()), String.valueOf(paramQMCalendarEvent.getEndTime()), String.valueOf(paramQMCalendarEvent.getCreateTime()), String.valueOf(paramQMCalendarEvent.getModifyTime()), String.valueOf(paramQMCalendarEvent.getId()) });
        return;
        i = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void onConfigure(SQLiteDatabase paramSQLiteDatabase)
  {
    super.onConfigure(paramSQLiteDatabase);
    QMMailSQLiteHelper.addCustomFunction(paramSQLiteDatabase);
    paramSQLiteDatabase.addUpdateHook(new QMCalendarSQLiteHelper.1(this));
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    createTable(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    QMLog.log(4, "SQLiteDatbase", "Try Upgrade: from " + paramInt1 + " to " + paramInt2 + ", minVer:" + upgradeManager.getMinSupportVersion());
    if (paramInt1 < upgradeManager.getMinSupportVersion())
    {
      dropTable(paramSQLiteDatabase);
      createTable(paramSQLiteDatabase);
      return;
    }
    if (upgradeManager.upgrade(this, paramSQLiteDatabase, paramInt1))
    {
      QMLog.log(4, "SQLiteDatabase", "Upgraded from " + paramInt1 + " to " + paramInt2);
      return;
    }
    QMLog.log(4, "SQLiteDatabase", "No need upgrade from " + paramInt1 + " to " + paramInt2);
  }
  
  public void resetEventOffLineOptType(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET offLineOptType = ?  WHERE id = ?", new String[] { "0", String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void setEventOffLineOptType(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET offLineOptType = ?  WHERE id = ?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateAppointmentType(SQLiteDatabase paramSQLiteDatabase, int paramInt, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_APPOINTMENT_EVENT SET type = ? WHERE id = ?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateAttendeeStatus(SQLiteDatabase paramSQLiteDatabase, ArrayList<Attendee> paramArrayList, long paramLong)
  {
    deleteAttendeeByEventId(paramSQLiteDatabase, paramLong);
    insertAttendee(paramSQLiteDatabase, paramArrayList, paramLong);
  }
  
  public void updateCalDavEventAfterCreate(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      String str = String.valueOf(paramQMCalendarEvent.getId());
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET uid = ?,path = ?,etag = ?,id = ?  WHERE id = ?", new String[] { paramQMCalendarEvent.getUid(), paramQMCalendarEvent.getPath(), paramQMCalendarEvent.geteTag(), str, str });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarDefaultSettingData(SQLiteDatabase paramSQLiteDatabase, CalendarDefaultSettingData paramCalendarDefaultSettingData)
  {
    int j = 1;
    try
    {
      int k = paramCalendarDefaultSettingData.getDefaultAccountId();
      int m = paramCalendarDefaultSettingData.getDefaultFolderId();
      int n = paramCalendarDefaultSettingData.getDefaultReminderTime();
      int i1 = paramCalendarDefaultSettingData.getDefaultAllDayReminderTime();
      int i2 = paramCalendarDefaultSettingData.getDefaultEventDuration();
      long l1 = paramCalendarDefaultSettingData.getRefreshTime();
      long l2 = paramCalendarDefaultSettingData.getRefreshLocalTime();
      long l3 = paramCalendarDefaultSettingData.getRefreshLogTime();
      int i3 = paramCalendarDefaultSettingData.getDefaultSyncTime();
      int i;
      if (paramCalendarDefaultSettingData.isDefaultShowLunarCalendar())
      {
        i = 1;
        if (!paramCalendarDefaultSettingData.isDefaultShowSystemCalendar()) {
          break label202;
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_SETTING SET defaultAccountId = ?,defaultFolderId = ?,defaultReminder = ?,defaultReminderForAllDay = ?,defaultDuration = ?,refreshTime = ?,refreshLocalTime = ?,refreshLogTime = ?,syncTime = ?,showLunarCalendar = ?,showSystemCalendar = ?,systemCalendarVisible = ?,defaultStartDayOfWeek = ?", new String[] { String.valueOf(k), String.valueOf(m), String.valueOf(n), String.valueOf(i1), String.valueOf(i2), String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(i3), String.valueOf(i), String.valueOf(j), paramCalendarDefaultSettingData.getSystemCalendarVisibleStr(), String.valueOf(paramCalendarDefaultSettingData.getDefaultStartDayOfWeek()) });
        return;
        i = 0;
        break;
        label202:
        j = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderCategory(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET category = ?  WHERE id = ?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderColor(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET color = ?  WHERE id = ?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderIsShow(SQLiteDatabase paramSQLiteDatabase, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = "1";; str = "0") {
      try
      {
        paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET isShow = ?  WHERE id = ?", new String[] { str, String.valueOf(paramInt) });
        return;
      }
      catch (Exception paramSQLiteDatabase)
      {
        QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
      }
    }
  }
  
  public void updateCalendarFolderName(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET name = ?  WHERE id = ?", new String[] { paramString, String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderOfflineOptType(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET offLineOptType = ?  WHERE id = ?", new String[] { String.valueOf(paramInt2), String.valueOf(paramInt1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderShareOwner(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET shareOwner = ?  WHERE id = ?", new String[] { paramString, String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderSyncKey(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET syncKey = ?  WHERE id = ?", new String[] { paramString, String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateCalendarFolderSyncToken(SQLiteDatabase paramSQLiteDatabase, int paramInt, String paramString)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_FOLDER SET syncToken = ?  WHERE id = ?", new String[] { paramString, String.valueOf(paramInt) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateConfigProfile(SQLiteDatabase paramSQLiteDatabase, CalendarAccountConfig paramCalendarAccountConfig)
  {
    if (paramCalendarAccountConfig != null) {}
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_ACCOUNT_CONFIG SET profile = ?  WHERE id = ?", new Object[] { paramCalendarAccountConfig.getProfileString(), Integer.valueOf(paramCalendarAccountConfig.getId()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateConfigRefreshTime(SQLiteDatabase paramSQLiteDatabase, CalendarAccountConfig paramCalendarAccountConfig)
  {
    if (paramCalendarAccountConfig != null) {}
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_ACCOUNT_CONFIG SET refreshTime = ?  WHERE id = ?", new Object[] { Long.valueOf(paramCalendarAccountConfig.getRefreshTime()), Integer.valueOf(paramCalendarAccountConfig.getId()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateEventAfterSync(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      long l = paramQMCalendarEvent.getId();
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_EVENT WHERE id = ?", new String[] { String.valueOf(l) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_RECURRENCE_EXCEPTION WHERE eid = ?", new String[] { String.valueOf(l) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_ATTENDEE WHERE eventId = ?", new String[] { String.valueOf(l) });
      paramSQLiteDatabase.execSQL("DELETE FROM QM_CALENDAR_APPOINTMENT_EVENT WHERE id = ?", new String[] { String.valueOf(l) });
      deleteSchedulesByEventId(paramSQLiteDatabase, l);
      deleteRemindersByEventId(paramSQLiteDatabase, l);
      insertCalendarEvent(paramSQLiteDatabase, paramQMCalendarEvent);
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateEventByCid(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    if (paramLong1 != 0L) {}
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE TABLE_CALENDAR_RELATE_CONTACT SET cid = ? WHERE cid = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateEventSvrId(SQLiteDatabase paramSQLiteDatabase, QMCalendarEvent paramQMCalendarEvent)
  {
    try
    {
      String str = String.valueOf(paramQMCalendarEvent.getId());
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET serverId = ?,id = ?  WHERE id = ?", new String[] { paramQMCalendarEvent.getSvrId(), str, str });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateEventUntilTime(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET until = ?  WHERE id = ?", new String[] { String.valueOf(paramLong2), String.valueOf(paramLong1) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateException(SQLiteDatabase paramSQLiteDatabase, RecurringException paramRecurringException)
  {
    int j = 1;
    try
    {
      long l1 = paramRecurringException.getExceptionStartTime();
      long l2 = paramRecurringException.getStartTime();
      long l3 = paramRecurringException.getEndTime();
      int i;
      if (paramRecurringException.isDelete())
      {
        i = 1;
        if (!paramRecurringException.isAllDay()) {
          break label136;
        }
      }
      for (;;)
      {
        paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_RECURRENCE_EXCEPTION SET exceptionStartTime = ?,startTime = ?,endTime = ?,isDelete = ?,isAllDay = ?,reminder = ?,subject = ?,body = ?,location = ? WHERE id = ?", new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(i), String.valueOf(j), String.valueOf(paramRecurringException.getReminder()), paramRecurringException.getSubject(), paramRecurringException.getBody(), paramRecurringException.getLocation(), paramRecurringException.getId() });
        return;
        i = 0;
        break;
        label136:
        j = 0;
      }
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateReminderCacheEnd(SQLiteDatabase paramSQLiteDatabase, long paramLong)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_SETTING SET reminderCacheEnd = ?", new String[] { String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateScheduleCache(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_SETTING SET scheduleCacheStart = ?,scheduleCacheEnd = ?", new String[] { String.valueOf(paramLong1), String.valueOf(paramLong2) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateSchedulesColorByEvent(SQLiteDatabase paramSQLiteDatabase, long paramLong, int paramInt)
  {
    try
    {
      paramSQLiteDatabase.execSQL(" UPDATE QM_SCHEDULE_INSTANCE SET colorId = ?  WHERE eid = ?", new String[] { String.valueOf(paramInt), String.valueOf(paramLong) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void updateShare(SQLiteDatabase paramSQLiteDatabase, QMCalendarShare paramQMCalendarShare)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_SHARE SET folderId = ?,email = ?,name = ?,state = ? WHERE id = ?", new Object[] { String.valueOf(paramQMCalendarShare.getCalendarFolderId()), String.valueOf(paramQMCalendarShare.getEmail()), String.valueOf(paramQMCalendarShare.getName()), String.valueOf(paramQMCalendarShare.getState()), String.valueOf(paramQMCalendarShare.getId()) });
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  public void upgradeTableFor5000(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS TABLE_CALENDAR_RELATE_CONTACT(eid integer, cid integer,  primary key (eid,cid))");
  }
  
  public void upgradeTableFor5200(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN accountName VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN accountType VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN parentId VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN category INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN shareOwner VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN ownerAccount VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN offLineOptType INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_FOLDER ADD COLUMN createTime INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_EVENT ADD COLUMN accountName VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_EVENT ADD COLUMN accountType VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_EVENT ADD COLUMN category INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_SETTING ADD COLUMN refreshLocalTime INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_SETTING ADD COLUMN refreshLogTime INTEGER DEFAULT 0");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_SETTING ADD COLUMN systemCalendarVisible VARCHAR");
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_EVENT ADD COLUMN daysOfMonth VARCHAR");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS QM_CALENDAR_SHARE(id integer primary key, folderId integer, email varchar, name varchar, state integer ) ");
  }
  
  public void upgradeTableFor5201(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_SETTING ADD COLUMN showSystemCalendar INTEGER DEFAULT 0");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(paramSQLiteDatabase));
    }
  }
  
  /* Error */
  public void upgradeTableFor5202(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 1421	com/tencent/moai/database/sqlite/SQLiteDatabase:beginTransactionNonExclusive	()V
    //   4: aload_1
    //   5: ldc_w 2143
    //   8: invokevirtual 1423	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: ldc_w 2145
    //   15: invokevirtual 1423	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   18: invokestatic 2151	com/tencent/qqmail/account/AccountManager:shareInstance	()Lcom/tencent/qqmail/account/AccountManager;
    //   21: invokevirtual 2155	com/tencent/qqmail/account/AccountManager:getAccountList	()Lcom/tencent/qqmail/account/AccountList;
    //   24: astore_3
    //   25: new 888	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 1038	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_3
    //   34: invokevirtual 2158	com/tencent/qqmail/account/AccountList:iterator	()Ljava/util/Iterator;
    //   37: astore_3
    //   38: aload_3
    //   39: invokeinterface 1155 1 0
    //   44: ifeq +64 -> 108
    //   47: aload_3
    //   48: invokeinterface 1159 1 0
    //   53: checkcast 2160	com/tencent/qqmail/account/model/Account
    //   56: astore 4
    //   58: aload 4
    //   60: invokevirtual 2163	com/tencent/qqmail/account/model/Account:isQQMail	()Z
    //   63: ifeq -25 -> 38
    //   66: aload 4
    //   68: invokevirtual 2166	com/tencent/qqmail/account/model/Account:isBizMail	()Z
    //   71: ifne -33 -> 38
    //   74: aload_2
    //   75: aload 4
    //   77: invokevirtual 2167	com/tencent/qqmail/account/model/Account:getId	()I
    //   80: invokestatic 956	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokevirtual 1059	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   86: pop
    //   87: goto -49 -> 38
    //   90: astore_2
    //   91: bipush 6
    //   93: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   96: aload_2
    //   97: invokestatic 870	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   100: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   103: aload_1
    //   104: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   107: return
    //   108: aload_2
    //   109: invokevirtual 891	java/util/ArrayList:size	()I
    //   112: ifle +130 -> 242
    //   115: aload_1
    //   116: ldc_w 2169
    //   119: ldc_w 2171
    //   122: aload_0
    //   123: aload_2
    //   124: invokevirtual 2173	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:getInClause	(Ljava/util/ArrayList;)Ljava/lang/String;
    //   127: invokevirtual 1169	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   130: aconst_null
    //   131: invokevirtual 1037	com/tencent/moai/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   134: astore_2
    //   135: aload_2
    //   136: ifnull +106 -> 242
    //   139: aload_2
    //   140: invokeinterface 1046 1 0
    //   145: ifeq +91 -> 236
    //   148: new 1518	com/tencent/qqmail/calendar/model/CalendarAccountConfig
    //   151: dup
    //   152: invokespecial 1519	com/tencent/qqmail/calendar/model/CalendarAccountConfig:<init>	()V
    //   155: astore_3
    //   156: aload_3
    //   157: aload_2
    //   158: aload_2
    //   159: ldc 20
    //   161: invokeinterface 1097 2 0
    //   166: invokeinterface 1109 2 0
    //   171: invokevirtual 1530	com/tencent/qqmail/calendar/model/CalendarAccountConfig:initFromProfileString	(Ljava/lang/String;)V
    //   174: aload_3
    //   175: aload_2
    //   176: aload_2
    //   177: ldc 17
    //   179: invokeinterface 1097 2 0
    //   184: invokeinterface 1101 2 0
    //   189: invokevirtual 1520	com/tencent/qqmail/calendar/model/CalendarAccountConfig:setId	(I)V
    //   192: aload_3
    //   193: ldc_w 2067
    //   196: invokevirtual 2176	com/tencent/qqmail/calendar/model/CalendarAccountConfig:setActiveSyncKey	(Ljava/lang/String;)V
    //   199: aload_1
    //   200: ldc_w 733
    //   203: iconst_2
    //   204: anewarray 854	java/lang/String
    //   207: dup
    //   208: iconst_0
    //   209: aload_3
    //   210: invokevirtual 1841	com/tencent/qqmail/calendar/model/CalendarAccountConfig:getProfileString	()Ljava/lang/String;
    //   213: aastore
    //   214: dup
    //   215: iconst_1
    //   216: aload_3
    //   217: invokevirtual 1834	com/tencent/qqmail/calendar/model/CalendarAccountConfig:getId	()I
    //   220: invokestatic 1444	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   223: aastore
    //   224: invokevirtual 864	com/tencent/moai/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload_2
    //   228: invokeinterface 1081 1 0
    //   233: ifne -77 -> 156
    //   236: aload_2
    //   237: invokeinterface 1092 1 0
    //   242: aload_1
    //   243: invokevirtual 1426	com/tencent/moai/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   246: iconst_4
    //   247: getstatic 819	com/tencent/qqmail/calendar/sqlite/QMCalendarSQLiteHelper:TAG	Ljava/lang/String;
    //   250: ldc_w 2178
    //   253: invokestatic 876	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   256: aload_1
    //   257: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   260: return
    //   261: astore_2
    //   262: aload_1
    //   263: invokevirtual 1429	com/tencent/moai/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   266: aload_2
    //   267: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	QMCalendarSQLiteHelper
    //   0	268	1	paramSQLiteDatabase	SQLiteDatabase
    //   32	43	2	localArrayList	ArrayList
    //   90	34	2	localException	Exception
    //   134	103	2	localCursor	Cursor
    //   261	6	2	localObject1	Object
    //   24	193	3	localObject2	Object
    //   56	20	4	localAccount	com.tencent.qqmail.account.model.Account
    // Exception table:
    //   from	to	target	type
    //   4	38	90	java/lang/Exception
    //   38	87	90	java/lang/Exception
    //   108	135	90	java/lang/Exception
    //   139	156	90	java/lang/Exception
    //   156	236	90	java/lang/Exception
    //   236	242	90	java/lang/Exception
    //   242	256	90	java/lang/Exception
    //   4	38	261	finally
    //   38	87	261	finally
    //   91	103	261	finally
    //   108	135	261	finally
    //   139	156	261	finally
    //   156	236	261	finally
    //   236	242	261	finally
    //   242	256	261	finally
  }
  
  public void upgradeTableFor5203(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE QM_SCHEDULE_INSTANCE ADD COLUMN category INTEGER DEFAULT 0");
      paramSQLiteDatabase.execSQL("UPDATE QM_CALENDAR_EVENT SET category=(SELECT category FROM QM_CALENDAR_FOLDER WHERE id = QM_CALENDAR_EVENT.folderId)");
      paramSQLiteDatabase.execSQL("UPDATE QM_SCHEDULE_INSTANCE SET category=(SELECT category FROM QM_CALENDAR_EVENT WHERE id = QM_SCHEDULE_INSTANCE.eid)");
      paramSQLiteDatabase.setTransactionSuccessful();
      QMLog.log(4, TAG, "upgradeTableFor5203 success");
      return;
    }
    catch (Exception localException)
    {
      QMLog.log(6, TAG, Log.getStackTraceString(localException));
      return;
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
    }
  }
  
  public void upgradeTableFor5210(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("ALTER TABLE QM_CALENDAR_SETTING ADD COLUMN defaultStartDayOfWeek INTEGER DEFAULT 1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.sqlite.QMCalendarSQLiteHelper
 * JD-Core Version:    0.7.0.1
 */