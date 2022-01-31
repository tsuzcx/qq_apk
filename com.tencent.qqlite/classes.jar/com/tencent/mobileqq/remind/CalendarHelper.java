package com.tencent.mobileqq.remind;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.format.Time;
import com.tencent.qphone.base.util.QLog;

public class CalendarHelper
{
  public static final int a = -1;
  public static final long a = 3600000L;
  private static String jdField_a_of_type_JavaLangString = "remind";
  public static final String[] a;
  private static String b = "content://calendar/calendars";
  private static String c = "content://calendar/events";
  private static String d = "content://calendar/reminders";
  private Context jdField_a_of_type_AndroidContentContext;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "com.android.calendar", "com.google.android.calendar" };
    b = "";
    c = "";
    d = "";
    if (Build.VERSION.SDK_INT >= 8)
    {
      b = "content://com.android.calendar/calendars";
      c = "content://com.android.calendar/events";
      d = "content://com.android.calendar/reminders";
      return;
    }
  }
  
  public CalendarHelper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public long a()
  {
    Cursor localCursor = this.jdField_a_of_type_AndroidContentContext.getContentResolver().query(Uri.parse(b), null, null, null, null);
    if ((localCursor != null) && (localCursor.getCount() > 0))
    {
      localCursor.moveToFirst();
      long l = localCursor.getInt(localCursor.getColumnIndex("_id"));
      localCursor.close();
      return l;
    }
    return -1L;
  }
  
  public boolean a(long paramLong)
  {
    boolean bool = true;
    try
    {
      Object localObject = new ContentValues();
      ((ContentValues)localObject).put("event_id", Long.valueOf(paramLong));
      ((ContentValues)localObject).put("method", Integer.valueOf(1));
      ((ContentValues)localObject).put("minutes", Integer.valueOf(0));
      localObject = this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(d), (ContentValues)localObject);
      if (localObject == null) {
        bool = false;
      }
      if (!QLog.isColorLevel()) {
        break label107;
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind success");
        }
        return bool;
      }
      catch (Exception localException2)
      {
        break label92;
      }
      localException1 = localException1;
      bool = false;
    }
    label92:
    QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Remind failed");
    label107:
    localException1.printStackTrace();
    return bool;
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2)
  {
    if ((paramString == null) || (paramString.equals("")) || (paramLong1 <= 0L) || (paramLong2 <= 0L)) {}
    long l;
    do
    {
      return false;
      l = a();
      if ((l == -1L) && (QLog.isColorLevel())) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "insert2Calendar step3 ,try insert Acount");
      }
    } while (l == -1L);
    return a(paramString, l, paramLong1, paramLong2);
  }
  
  public boolean a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("title", paramString);
      localContentValues.put("calendar_id", Long.valueOf(paramLong1));
      localContentValues.put("dtstart", Long.valueOf(paramLong2));
      localContentValues.put("dtend", Long.valueOf(paramLong3));
      localContentValues.put("hasAlarm", Integer.valueOf(1));
      localContentValues.put("eventTimezone", Time.getCurrentTimezone());
      localContentValues.put("eventStatus", Integer.valueOf(1));
      localContentValues.put("hasAttendeeData", Integer.valueOf(1));
      paramLong1 = Long.parseLong(this.jdField_a_of_type_AndroidContentContext.getContentResolver().insert(Uri.parse(c), localContentValues).getLastPathSegment());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event success");
      }
      boolean bool = a(paramLong1);
      if (bool) {
        return true;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "save2Event failed");
      }
      paramString.printStackTrace();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.CalendarHelper
 * JD-Core Version:    0.7.0.1
 */