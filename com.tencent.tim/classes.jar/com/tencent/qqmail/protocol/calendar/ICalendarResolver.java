package com.tencent.qqmail.protocol.calendar;

import android.text.TextUtils;
import com.tencent.qqmail.calendar.model.CAttendee;
import com.tencent.qqmail.calendar.model.CCalendar;
import com.tencent.qqmail.calendar.model.CException;
import com.tencent.qqmail.calendar.model.CRecurrence;
import com.tencent.qqmail.calendar.provider.CalendarProviderUtil;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ICalendarResolver
{
  private static final String TAG = "ICalendarResolver";
  
  private static String formatTZID(String paramString)
  {
    String str;
    if (paramString.equals("China Standard Time")) {
      str = "Asia/Shanghai";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.equals("+8"));
    return "Asia/Shanghai";
  }
  
  private static Map<String, String> getRecurrenceRule(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    HashMap localHashMap;
    String[] arrayOfString;
    int j;
    int i;
    do
    {
      return paramString;
      localHashMap = new HashMap();
      arrayOfString = paramString.split(";");
      j = arrayOfString.length;
      i = 0;
      paramString = localHashMap;
    } while (i >= j);
    paramString = arrayOfString[i].split("=");
    if (paramString.length != 2) {}
    for (;;)
    {
      i += 1;
      break;
      localHashMap.put(paramString[0], paramString[1]);
    }
  }
  
  private static String joinStringVector(List<String> paramList, String paramString)
  {
    String str1 = "";
    int i = 0;
    while (i < paramList.size())
    {
      String str2 = str1;
      if (i != 0) {
        str2 = str1 + paramString;
      }
      str1 = str2 + (String)paramList.get(i);
      i += 1;
    }
    return str1;
  }
  
  public static String parseCCalendar(CCalendar paramCCalendar)
  {
    if (paramCCalendar == null) {
      return "";
    }
    Object localObject1 = "BEGIN:VCALENDAR\r\n" + "VERSION:2.0\r\n";
    Object localObject2 = (String)localObject1 + "PRODID:-//Tencent Inc//MailApp Client//CN\r\n";
    localObject1 = localObject2;
    int i;
    if (!StringExtention.isNullOrEmpty(paramCCalendar.time_zone_))
    {
      localObject1 = (String)localObject2 + "BEGIN:VTIMEZONE\r\n";
      localObject1 = (String)localObject1 + "TZID:Asia/Chongqing\r\n";
      localObject1 = (String)localObject1 + "BEGIN:STANDARD\r\n";
      i = (int)(Long.parseLong(paramCCalendar.time_zone_) / 60L + 60L);
      int j = (int)(Long.parseLong(paramCCalendar.time_zone_) / 60L);
      localObject1 = (String)localObject1 + "TZOFFSETTO:" + parseMinutesToTImeOffsetStr(j) + "\r\n";
      localObject1 = (String)localObject1 + "TZOFFSETFROM:" + parseMinutesToTImeOffsetStr(i) + "\r\n";
      localObject1 = (String)localObject1 + "TZNAME:EST\r\n";
      localObject1 = (String)localObject1 + "END:STANDARD\r\n";
      localObject1 = (String)localObject1 + "END:VTIMEZONE\r\n";
    }
    localObject2 = (String)localObject1 + "BEGIN:VEVENT\r\n";
    localObject1 = localObject2;
    if (!StringExtention.isNullOrEmpty(paramCCalendar.uid)) {
      localObject1 = (String)localObject2 + "UID:" + paramCCalendar.uid + "\r\n";
    }
    localObject1 = (String)localObject1 + "DTSTAMP:" + CalendarActiveSyncService.getTimeInFormat(paramCCalendar.dt_stamp) + "\r\n";
    label475:
    Object localObject3;
    if (paramCCalendar.allday_event)
    {
      localObject1 = (String)localObject1 + "DTSTART;VALUE=DATE:" + CalendarActiveSyncService.getLocalTimeInFormat(paramCCalendar.start_time).substring(0, 8) + "\r\n";
      if (!paramCCalendar.allday_event) {
        break label1162;
      }
      localObject1 = (String)localObject1 + "DTEND;VALUE=DATE:" + CalendarActiveSyncService.getLocalTimeInFormat(paramCCalendar.end_time).substring(0, 8) + "\r\n";
      localObject2 = (String)localObject1 + "CREATED:" + CalendarActiveSyncService.getTimeInFormat(paramCCalendar.create_time) + "\r\n";
      localObject1 = localObject2;
      if (!StringExtention.isNullOrEmpty(paramCCalendar.location)) {
        localObject1 = (String)localObject2 + "LOCATION:" + paramCCalendar.location + "\r\n";
      }
      localObject3 = paramCCalendar.body;
      localObject2 = localObject1;
      if (!StringExtention.isNullOrEmpty((String)localObject3))
      {
        localObject2 = ((String)localObject3).replace("\n", "\\n");
        localObject2 = (String)localObject1 + "DESCRIPTION:" + (String)localObject2 + "\r\n";
      }
      localObject1 = localObject2;
      if (paramCCalendar.sensitivity != 0) {
        localObject1 = (String)localObject2 + "CLASS:" + sensitivityToString(paramCCalendar.sensitivity) + "\r\n";
      }
      localObject2 = localObject1;
      if (paramCCalendar.categories != null)
      {
        localObject2 = localObject1;
        if (paramCCalendar.categories.size() > 0) {
          localObject2 = (String)localObject1 + "CATEGORIES:" + joinStringVector(paramCCalendar.categories, ",") + "\r\n";
        }
      }
      localObject1 = localObject2;
      if (paramCCalendar.recurrence == null) {
        break label1289;
      }
      localObject3 = "FREQ=" + QMCalendarUtil.recurrenceTypeToString(paramCCalendar.recurrence.type);
      localObject1 = localObject3;
      if (paramCCalendar.recurrence.until != 0L) {
        if (!paramCCalendar.allday_event) {
          break label1201;
        }
      }
    }
    Object localObject5;
    Object localObject4;
    label1162:
    label1201:
    for (localObject1 = (String)localObject3 + ";UNTIL=" + CalendarActiveSyncService.getLocalTimeInFormat(paramCCalendar.recurrence.until).substring(0, 8);; localObject1 = (String)localObject3 + ";UNTIL=" + CalendarActiveSyncService.getTimeInFormat(paramCCalendar.recurrence.until))
    {
      localObject3 = localObject1;
      if (paramCCalendar.recurrence.interval > 1L) {
        localObject3 = (String)localObject1 + ";INTERVAL=" + paramCCalendar.recurrence.interval;
      }
      localObject1 = localObject3;
      if (paramCCalendar.recurrence.month_of_year != 0L) {
        localObject1 = (String)localObject3 + ";BYMONTH=" + paramCCalendar.recurrence.month_of_year;
      }
      localObject3 = localObject1;
      if (paramCCalendar.recurrence.day_of_month != 0L) {
        localObject3 = (String)localObject1 + ";BYMONTHDAY=" + paramCCalendar.recurrence.day_of_month;
      }
      localObject5 = (String)localObject3 + ";WKST=" + QMCalendarUtil.dayOfWeekToString(paramCCalendar.recurrence.first_day_of_week);
      if (paramCCalendar.recurrence.day_of_week == 0L) {
        break label2983;
      }
      localObject1 = ";BYDAY=";
      localObject3 = Boolean.valueOf(true);
      i = 0;
      while (i < 7)
      {
        if ((paramCCalendar.recurrence.day_of_week & 1 << i) == 0L) {
          break label2970;
        }
        localObject4 = localObject1;
        if (!((Boolean)localObject3).booleanValue()) {
          localObject4 = (String)localObject1 + ",";
        }
        localObject3 = (String)localObject4 + QMCalendarUtil.dayOfWeekToString(i);
        localObject1 = Boolean.valueOf(false);
        i += 1;
        localObject4 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      localObject1 = (String)localObject1 + "DTSTART:" + CalendarActiveSyncService.getTimeInFormat(paramCCalendar.start_time) + "\r\n";
      break;
      localObject1 = (String)localObject1 + "DTEND:" + CalendarActiveSyncService.getTimeInFormat(paramCCalendar.end_time) + "\r\n";
      break label475;
    }
    label1289:
    label1445:
    label1701:
    label2983:
    for (localObject1 = (String)localObject5 + (String)localObject1;; localObject1 = localObject5)
    {
      localObject1 = (String)localObject2 + "RRULE:" + (String)localObject1 + "\r\n";
      localObject5 = paramCCalendar.exceptions;
      localObject4 = "";
      localObject2 = localObject1;
      localObject3 = localObject4;
      CException localCException;
      if (localObject5 != null)
      {
        localObject2 = localObject1;
        localObject3 = localObject4;
        if (((LinkedList)localObject5).size() > 0)
        {
          localObject3 = "";
          localObject5 = ((LinkedList)localObject5).iterator();
          localObject2 = localObject4;
          if (((Iterator)localObject5).hasNext())
          {
            localCException = (CException)((Iterator)localObject5).next();
            if (localCException.deleted)
            {
              if (localCException.exception_start_time <= 0L) {
                break label2957;
              }
              if (paramCCalendar.allday_event)
              {
                localObject3 = (String)localObject3 + "EXDATE;VALUE=DATE:";
                localObject3 = (String)localObject3 + CalendarActiveSyncService.getLocalTimeInFormat(localCException.exception_start_time).substring(0, 8);
                localObject4 = (String)localObject3 + "\r\n";
                localObject3 = localObject1;
                localObject1 = localObject4;
              }
            }
          }
        }
      }
      for (;;)
      {
        localObject4 = localObject3;
        localObject3 = localObject1;
        localObject1 = localObject4;
        break;
        localObject3 = (String)localObject3 + "EXDATE:";
        localObject3 = (String)localObject3 + CalendarActiveSyncService.getTimeInFormat(localCException.exception_start_time);
        break label1445;
        localObject4 = (String)localObject2 + "BEGIN:VEVENT\n";
        localObject2 = localObject4;
        if (!StringExtention.isNullOrEmpty(paramCCalendar.uid)) {
          localObject2 = (String)localObject4 + "UID:" + paramCCalendar.uid + "\r\n";
        }
        localObject2 = (String)localObject2 + "DTSTAMP:" + CalendarActiveSyncService.getTimeInFormat(localCException.dt_stamp) + "\r\n";
        if (localCException.allday_event)
        {
          localObject2 = (String)localObject2 + "DTSTART;VALUE=DATE:" + CalendarActiveSyncService.getLocalTimeInFormat(localCException.start_time).substring(0, 8) + "\r\n";
          if (!localCException.allday_event) {
            break label2287;
          }
          localObject4 = (String)localObject2 + "DTEND;VALUE=DATE:" + CalendarActiveSyncService.getLocalTimeInFormat(localCException.end_time).substring(0, 8) + "\r\n";
          label1753:
          localObject2 = localObject4;
          if (!StringExtention.isNullOrEmpty(localCException.location)) {
            localObject2 = (String)localObject4 + "LOCATION:" + localCException.location + "\r\n";
          }
          localObject4 = localObject2;
          if (!StringExtention.isNullOrEmpty(localCException.body)) {
            localObject4 = (String)localObject2 + "DESCRIPTION:" + localCException.body + "\r\n";
          }
          if (localCException.sensitivity == 0) {
            break label2950;
          }
        }
        for (localObject2 = (String)localObject4 + "CLASS:" + sensitivityToString(localCException.sensitivity) + "\r\n";; localObject2 = localObject4)
        {
          if ((localCException.categories != null) && (localCException.categories.size() > 0)) {}
          for (localObject4 = (String)localObject1 + "CATEGORIES:" + joinStringVector(localCException.categories, ",") + "\r\n";; localObject4 = localObject1)
          {
            localObject2 = (String)localObject2 + "SUMMARY:" + localCException.subject + "\r\n";
            localObject1 = localObject2;
            if (localCException.reminder != -1)
            {
              localObject1 = (String)localObject2 + "BEGIN:VALARM\r\n";
              localObject2 = new StringBuilder().append((String)localObject1).append("TRIGGER:");
              if (localCException.reminder > 0)
              {
                localObject1 = "-";
                localObject1 = (String)localObject1 + "PT" + localCException.reminder + "M\r\n";
                localObject1 = (String)localObject1 + "ACTION:DISPLAY\r\n";
                localObject1 = (String)localObject1 + "DESCRIPTION:" + localCException.body + "\r\n";
                localObject1 = (String)localObject1 + "END:VALARM\r\n";
              }
            }
            else
            {
              if (!paramCCalendar.allday_event) {
                break label2335;
              }
            }
            for (localObject1 = (String)localObject1 + "RECURRENCE-ID;VALUE=DATE:" + CalendarActiveSyncService.getLocalTimeInFormat(localCException.exception_start_time).substring(0, 8) + "\r\n";; localObject1 = (String)localObject1 + "RECURRENCE-ID:" + CalendarActiveSyncService.getTimeInFormat(localCException.exception_start_time) + "\r\n")
            {
              localObject2 = (String)localObject1 + "END:VEVENT\r\n";
              localObject1 = localObject3;
              localObject3 = localObject4;
              break;
              localObject2 = (String)localObject2 + "DTSTART:" + CalendarActiveSyncService.getTimeInFormat(localCException.start_time) + "\r\n";
              break label1701;
              label2287:
              localObject4 = (String)localObject2 + "DTEND:" + CalendarActiveSyncService.getTimeInFormat(localCException.end_time) + "\r\n";
              break label1753;
              localObject1 = "";
              break label2058;
            }
            localObject1 = (String)localObject1 + (String)localObject3;
            localObject3 = localObject2;
            localObject2 = localObject1;
            localObject1 = localObject2;
            if (!StringExtention.isNullOrEmpty(paramCCalendar.organizer_name))
            {
              localObject1 = localObject2;
              if (!StringExtention.isNullOrEmpty(paramCCalendar.organizer_email)) {
                localObject1 = (String)localObject2 + "ORGANIZER;CN=\"" + paramCCalendar.organizer_name + "\";EMAIL=\"" + paramCCalendar.organizer_email + "\":mailto:" + paramCCalendar.organizer_email + "\r\n";
              }
            }
            localObject2 = localObject1;
            if (paramCCalendar.attendees != null)
            {
              localObject2 = localObject1;
              if (paramCCalendar.attendees.size() > 0)
              {
                localObject2 = paramCCalendar.attendees.iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject4 = (CAttendee)((Iterator)localObject2).next();
                  localObject1 = (String)localObject1 + "ATTENDEE;CN=\"" + ((CAttendee)localObject4).name + "\";CUTYPE=INDIVIDUAL;EMAIL=\"" + ((CAttendee)localObject4).email + "\";PARTSTAT=" + QMCalendarUtil.convertAttendeeStatusToString(((CAttendee)localObject4).status) + ";ROLE=REQ-PARTICIPANT:mailto:" + ((CAttendee)localObject4).email + "\r\n";
                }
                localObject2 = localObject1;
              }
            }
            localObject2 = (String)localObject2 + "SUMMARY:" + paramCCalendar.subject + "\r\n";
            localObject1 = localObject2;
            if (paramCCalendar.reminder != -1L)
            {
              localObject1 = (String)localObject2 + "BEGIN:VALARM\r\n";
              localObject2 = new StringBuilder().append((String)localObject1).append("TRIGGER:");
              if (paramCCalendar.reminder <= 0L) {
                break label2938;
              }
            }
            label2938:
            for (localObject1 = "-";; localObject1 = "")
            {
              localObject1 = (String)localObject1 + "PT" + paramCCalendar.reminder + "M\r\n";
              localObject1 = (String)localObject1 + "ACTION:DISPLAY\r\n";
              localObject1 = (String)localObject1 + "DESCRIPTION:" + paramCCalendar.body + "\r\n";
              paramCCalendar = (String)localObject1 + "X-WR-ALARMUID:" + paramCCalendar.uid + "\r\n";
              localObject1 = paramCCalendar + "END:VALARM\r\n";
              localObject1 = (String)localObject1 + "END:VEVENT\r\n";
              paramCCalendar = (CCalendar)localObject1;
              if (!StringExtention.isNullOrEmpty((String)localObject3)) {
                paramCCalendar = (String)localObject1 + (String)localObject3;
              }
              return paramCCalendar + "END:VCALENDAR\r\n";
            }
          }
        }
        localObject4 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject4;
      }
      localObject4 = localObject1;
      localObject1 = localObject3;
      localObject3 = localObject4;
      break;
    }
  }
  
  public static CCalendar parseICS(String paramString)
  {
    int k = 1;
    QMLog.log(4, "ICalendarResolver", "parseICS: " + paramString);
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramString = paramString.replace("\r\n", "\n").replace("\r", "\n");
      try
      {
        paramString = ICalendar.parseCalendar(paramString);
        if (paramString == null) {
          continue;
        }
        localObject1 = paramString.getFirstComponent("VTIMEZONE");
        QMLog.log(3, "ICalendarResolver", "===== VTIMEZONE =====\n" + localObject1);
        if (localObject1 != null)
        {
          localObject2 = ((ICalendar.Component)localObject1).getFirstProperty("TZID");
          if (localObject2 != null)
          {
            j = TimeZone.getTimeZone(formatTZID(((ICalendar.Property)localObject2).getValue())).getRawOffset() / 1000;
            localObject2 = ((ICalendar.Component)localObject1).getFirstComponent("STANDARD");
            i = j;
            if (localObject2 != null)
            {
              i = j;
              if (j == 0)
              {
                localObject2 = ((ICalendar.Component)localObject2).getFirstProperty("TZOFFSETFROM");
                if (localObject2 == null) {
                  break label634;
                }
                i = parseTimeZoneInSeconds(((ICalendar.Property)localObject2).getValue());
              }
            }
            localObject3 = paramString.getFirstComponent("VEVENT");
            QMLog.log(3, "ICalendarResolver", "===== VEVENT =====\n" + localObject1);
            if (localObject3 != null)
            {
              localObject1 = new CCalendar();
              paramString = ((ICalendar.Component)localObject3).getFirstProperty("DTSTART");
              ((CCalendar)localObject1).start_time = parseTimeInSeconds(paramString, i);
              ((CCalendar)localObject1).end_time = parseTimeInSeconds(((ICalendar.Component)localObject3).getFirstProperty("DTEND"), i);
              l1 = parseTimeInSeconds(((ICalendar.Component)localObject3).getFirstProperty("DTSTAMP"), i);
              ((CCalendar)localObject1).dt_stamp = l1;
              ((CCalendar)localObject1).create_time = l1;
              ((CCalendar)localObject1).modified_time = l1;
              if (("TRUE".equals(((ICalendar.Component)localObject3).getFirstPropertyValue("X-MICROSOFT-CDO-ALLDAYEVENT"))) || ((paramString != null) && (paramString.toString().contains("VALUE=DATE"))))
              {
                bool = true;
                ((CCalendar)localObject1).allday_event = bool;
                ((CCalendar)localObject1).location = ((ICalendar.Component)localObject3).getFirstPropertyValue("LOCATION");
                ((CCalendar)localObject1).subject = ((ICalendar.Component)localObject3).getFirstPropertyValue("SUMMARY");
                ((CCalendar)localObject1).body = ((ICalendar.Component)localObject3).getFirstPropertyValue("DESCRIPTION");
                if (((CCalendar)localObject1).body != null) {
                  ((CCalendar)localObject1).body = ((CCalendar)localObject1).body.replace("\\n", "\n");
                }
                ((CCalendar)localObject1).uid = ((ICalendar.Component)localObject3).getFirstPropertyValue("UID");
                localObject2 = ((ICalendar.Component)localObject3).getFirstPropertyValue("ORGANIZER");
                paramString = (String)localObject2;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  paramString = (String)localObject2;
                  if (((String)localObject2).substring(0, 7).equalsIgnoreCase("mailto:")) {
                    paramString = ((String)localObject2).substring(7);
                  }
                }
                ((CCalendar)localObject1).organizer_email = paramString;
                ((CCalendar)localObject1).organizer_name = paramString;
                paramString = ((ICalendar.Component)localObject3).getProperties("ATTENDEE");
                if ((paramString == null) || (paramString.size() <= 0)) {
                  break label654;
                }
                Iterator localIterator = paramString.iterator();
                while (localIterator.hasNext())
                {
                  localObject2 = ((ICalendar.Property)localIterator.next()).getValue();
                  paramString = (String)localObject2;
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    paramString = (String)localObject2;
                    if (((String)localObject2).substring(0, 7).equalsIgnoreCase("mailto:")) {
                      paramString = ((String)localObject2).substring(7);
                    }
                  }
                  localObject2 = new CAttendee();
                  ((CAttendee)localObject2).name = paramString;
                  ((CAttendee)localObject2).email = paramString;
                  ((CCalendar)localObject1).attendees.add(localObject2);
                }
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject1;
          Object localObject2;
          Object localObject3;
          long l1;
          QMLog.log(5, "ICalendarResolver", "parse ICalendar error", paramString);
          paramString = null;
          continue;
          label634:
          int i = TimeZone.getDefault().getRawOffset() / 1000;
          continue;
          boolean bool = false;
          continue;
          label654:
          ((CCalendar)localObject1).recurrence = parseRecurrenceRule(((CCalendar)localObject1).allday_event, ((CCalendar)localObject1).start_time * 1000L, ((ICalendar.Component)localObject3).getFirstPropertyValue("RRULE"));
          paramString = ((ICalendar.Component)localObject3).getFirstComponent("VALARM");
          QMLog.log(3, "ICalendarResolver", "===== VALARM =====\n" + paramString);
          if (paramString != null)
          {
            localObject2 = paramString.getFirstProperty("TRIGGER");
            if (localObject2 != null)
            {
              localObject3 = ((ICalendar.Property)localObject2).getFirstParameter("RELATED");
              paramString = ((ICalendar.Property)localObject2).getFirstParameter("VALUE");
              localObject2 = ((ICalendar.Property)localObject2).getValue();
              if ((paramString != null) && ("DATE-TIME".equals(paramString.value))) {
                paramString = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
              }
            }
          }
          try
          {
            long l2 = (paramString.parse((String)localObject2).getTime() - ((CCalendar)localObject1).start_time) / 1000L / 60L;
            l1 = l2;
            if (l2 < 0L) {
              l1 = 0L;
            }
            ((CCalendar)localObject1).reminder = l1;
          }
          catch (Exception paramString)
          {
            label840:
            label1115:
            break label840;
          }
          paramString = (String)localObject1;
          for (;;)
          {
            return paramString;
            paramString = "";
            if ((localObject3 != null) && ("START".equals(((ICalendar.Parameter)localObject3).value)))
            {
              paramString = ((String)localObject2).substring(1);
              i = k;
            }
            char c;
            for (;;)
            {
              k = 0;
              l1 = 0L;
              j = 0;
              for (;;)
              {
                if (k >= paramString.length()) {
                  break label1115;
                }
                c = paramString.charAt(k);
                if (!Character.isDigit(c)) {
                  break;
                }
                j = j * 10 + (c - '0');
                k += 1;
              }
              if ((localObject3 != null) && ("END".equals(((ICalendar.Parameter)localObject3).value)))
              {
                paramString = ((String)localObject2).substring(1);
                i = 0;
              }
              else if (((String)localObject2).startsWith("-P"))
              {
                paramString = ((String)localObject2).substring(2);
                i = k;
              }
              else
              {
                i = k;
                if (((String)localObject2).startsWith("P"))
                {
                  paramString = ((String)localObject2).substring(1);
                  i = 0;
                }
              }
            }
            switch (c)
            {
            }
            for (;;)
            {
              j = 0;
              break;
              l1 += j;
              continue;
              l1 += j * 60;
              continue;
              l1 += j * 24 * 60;
              continue;
              l1 += j * 7 * 24 * 60;
            }
            if (i != 0) {}
            for (;;)
            {
              ((CCalendar)localObject1).reminder = l1;
              paramString = (String)localObject1;
              break;
              l1 = -l1;
            }
            paramString = null;
          }
          int j = 0;
          continue;
          i = 0;
        }
      }
    }
  }
  
  private static String parseMinutesToTImeOffsetStr(int paramInt)
  {
    int j = Math.abs(paramInt);
    int i = j / 60;
    j %= 60;
    Object localObject1 = new StringBuilder();
    Object localObject2;
    label68:
    StringBuilder localStringBuilder;
    if (i < 10)
    {
      str = "0";
      localObject1 = str + i;
      localObject2 = new StringBuilder();
      if (j >= 10) {
        break label126;
      }
      str = "0";
      localObject2 = str + j;
      localStringBuilder = new StringBuilder();
      if (paramInt <= 0) {
        break label132;
      }
    }
    label132:
    for (String str = "+";; str = "-")
    {
      return str + (String)localObject1 + (String)localObject2;
      str = "";
      break;
      label126:
      str = "";
      break label68;
    }
  }
  
  private static CRecurrence parseRecurrenceRule(boolean paramBoolean, long paramLong, String paramString)
  {
    Map localMap = getRecurrenceRule(paramString);
    if ((localMap == null) || (localMap.size() == 0)) {
      return null;
    }
    CRecurrence localCRecurrence = new CRecurrence();
    Object localObject1 = (String)localMap.get("FREQ");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    int i;
    label107:
    String str;
    label140:
    Object localObject2;
    switch (((String)localObject1).hashCode())
    {
    default: 
      i = -1;
      switch (i)
      {
      default: 
        str = (String)localMap.get("UNTIL");
        if (!TextUtils.isEmpty(str))
        {
          Matcher localMatcher = Pattern.compile("UNTIL=(\\w*)T(\\w*)Z?;?|UNTIL=(\\w*);?").matcher(paramString);
          if (localMatcher.find())
          {
            localObject1 = "";
            localObject2 = "";
            paramString = (String)localObject1;
            if (localMatcher.group(1) != null)
            {
              paramString = (String)localObject1;
              if (!localMatcher.group(1).equals("")) {
                paramString = localMatcher.group(1);
              }
            }
            localObject1 = localObject2;
            if (localMatcher.group(2) != null)
            {
              localObject1 = localObject2;
              if (!localMatcher.group(2).equals("")) {
                localObject1 = localMatcher.group(2);
              }
            }
            if ((localMatcher.group(3) == null) || (localMatcher.group(3).equals(""))) {
              break label692;
            }
            paramString = localMatcher.group(3);
          }
        }
        break;
      }
      break;
    }
    label692:
    for (;;)
    {
      for (;;)
      {
        localObject2 = Calendar.getInstance();
        if (str.contains("Z")) {
          ((Calendar)localObject2).setTimeZone(TimeZone.getTimeZone("GMT"));
        }
        if (!paramString.equals(""))
        {
          int m = Integer.parseInt(paramString.substring(0, 4));
          int n = Integer.parseInt(paramString.substring(4, 6));
          int i1 = Integer.parseInt(paramString.substring(6, 8));
          i = 0;
          int j = 0;
          int k = 0;
          if (!((String)localObject1).equals(""))
          {
            i = Integer.parseInt(((String)localObject1).substring(0, 2));
            j = Integer.parseInt(((String)localObject1).substring(2, 4));
            k = Integer.parseInt(((String)localObject1).substring(4, 6));
          }
          ((Calendar)localObject2).set(m, n - 1, i1, i, j, k);
          localCRecurrence.until = (((Calendar)localObject2).getTimeInMillis() / 1000L);
        }
        try
        {
          for (;;)
          {
            localCRecurrence.occurrences = Long.parseLong((String)localMap.get("COUNT"));
            try
            {
              label478:
              localCRecurrence.interval = Long.parseLong((String)localMap.get("INTERVAL"));
              label499:
              return localCRecurrence;
              if (!((String)localObject1).equals("DAILY")) {
                break;
              }
              i = 0;
              break label107;
              if (!((String)localObject1).equals("WEEKLY")) {
                break;
              }
              i = 1;
              break label107;
              if (!((String)localObject1).equals("MONTHLY")) {
                break;
              }
              i = 2;
              break label107;
              if (!((String)localObject1).equals("YEARLY")) {
                break;
              }
              i = 3;
              break label107;
              localCRecurrence.type = 0;
              break label140;
              localCRecurrence.type = 1;
              localCRecurrence.day_of_week = CalendarProviderUtil.parseCPEventDayOfWeek(paramString, paramLong);
              break label140;
              localCRecurrence.type = 2;
              localObject1 = CalendarProviderUtil.parseCPEventDayOfMonth(paramBoolean, paramLong, paramString);
              if (((ArrayList)localObject1).size() > 0) {
                localCRecurrence.day_of_month = ((Integer)((ArrayList)localObject1).get(0)).intValue();
              }
              localCRecurrence.day_of_week = CalendarProviderUtil.parseCPEventDayOfWeek(paramString, paramLong);
              localCRecurrence.week_of_month = CalendarProviderUtil.parseCPEventWeekOfMonth(paramString);
              break label140;
              localCRecurrence.type = 5;
              localCRecurrence.day_of_month = CalendarProviderUtil.parseMonthOfYear(paramBoolean, paramLong, paramString);
            }
            catch (Exception paramString)
            {
              break label499;
            }
          }
        }
        catch (Exception paramString)
        {
          break label478;
        }
      }
    }
  }
  
  private static long parseTimeInSeconds(ICalendar.Property paramProperty, int paramInt)
  {
    if (paramProperty == null) {
      return 0L;
    }
    String str = paramProperty.getValue();
    long l;
    if (paramProperty.toString().contains("VALUE=DATE"))
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
      try
      {
        l = localSimpleDateFormat.parse(str).getTime() / 1000L;
        return l;
      }
      catch (ParseException localParseException)
      {
        QMLog.log(5, "ICalendarResolver", "parseTimeInSeconds, property: " + paramProperty, localParseException);
        return 0L;
      }
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.getDefault());
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    for (;;)
    {
      try
      {
        ICalendar.Parameter localParameter = paramProperty.getFirstParameter("TZID");
        if (localParameter != null)
        {
          TimeZone localTimeZone = TimeZone.getTimeZone(formatTZID(localParameter.value));
          if ((localTimeZone != null) && (localTimeZone.getID().equals(formatTZID(localParameter.value))))
          {
            paramInt = localTimeZone.getRawOffset() / 1000;
            if (localParseException.contains("Z")) {
              paramInt = 0;
            }
            l = localSimpleDateFormat.parse(localParseException).getTime() / 1000L;
            return l - paramInt;
          }
        }
      }
      catch (Exception localException)
      {
        QMLog.log(5, "ICalendarResolver", "parseTimeInSeconds, property: " + paramProperty, localException);
        return 0L;
      }
    }
  }
  
  private static int parseTimeZoneInSeconds(String paramString)
  {
    int i;
    if ((TextUtils.isEmpty(paramString)) || (paramString.length() < 5)) {
      i = 0;
    }
    for (;;)
    {
      return i;
      String str1 = paramString.substring(0, 1);
      String str2 = paramString.substring(1, 3);
      String str3 = paramString.substring(3, 5);
      try
      {
        int j = Integer.parseInt(str2) * 60 * 60 + Integer.parseInt(str3) * 60;
        boolean bool = "-".equals(str1);
        i = j;
        if (bool) {
          return -j;
        }
      }
      catch (Exception localException)
      {
        QMLog.log(5, "ICalendarResolver", "parseTimeZone error: " + paramString, localException);
      }
    }
    return 0;
  }
  
  private static String sensitivityToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "PUBLIC";
    case 0: 
      return "PUBLIC";
    case 2: 
      return "PRIVATE";
    case 1: 
      return "PERSONAL";
    }
    return "CONFIDENTIAL";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.calendar.ICalendarResolver
 * JD-Core Version:    0.7.0.1
 */