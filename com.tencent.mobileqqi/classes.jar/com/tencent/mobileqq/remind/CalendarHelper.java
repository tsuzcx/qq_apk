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
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: new 111	android/content/ContentValues
    //   5: dup
    //   6: invokespecial 112	android/content/ContentValues:<init>	()V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc 114
    //   15: lload_1
    //   16: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   19: invokevirtual 124	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   22: aload 4
    //   24: ldc 126
    //   26: iconst_1
    //   27: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   30: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   33: aload 4
    //   35: ldc 136
    //   37: iconst_0
    //   38: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   44: aload_0
    //   45: getfield 62	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   48: invokevirtual 69	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   51: getstatic 38	com/tencent/mobileqq/remind/CalendarHelper:d	Ljava/lang/String;
    //   54: invokestatic 75	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   57: aload 4
    //   59: invokevirtual 140	android/content/ContentResolver:insert	(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    //   62: pop
    //   63: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +12 -> 78
    //   69: getstatic 22	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   72: iconst_2
    //   73: ldc 147
    //   75: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: iconst_1
    //   79: ireturn
    //   80: astore 4
    //   82: iconst_0
    //   83: istore_3
    //   84: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: getstatic 22	com/tencent/mobileqq/remind/CalendarHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   93: iconst_2
    //   94: ldc 152
    //   96: invokestatic 150	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 4
    //   101: invokevirtual 155	java/lang/Exception:printStackTrace	()V
    //   104: iload_3
    //   105: ireturn
    //   106: astore 4
    //   108: goto -24 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	CalendarHelper
    //   0	111	1	paramLong	long
    //   1	104	3	bool	boolean
    //   9	49	4	localContentValues	ContentValues
    //   80	20	4	localException1	Exception
    //   106	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   2	63	80	java/lang/Exception
    //   63	78	106	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.remind.CalendarHelper
 * JD-Core Version:    0.7.0.1
 */