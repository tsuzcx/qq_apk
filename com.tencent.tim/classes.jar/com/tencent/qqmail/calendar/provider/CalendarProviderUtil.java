package com.tencent.qqmail.calendar.provider;

import com.google.ical.values.Frequency;
import com.google.ical.values.RRule;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.RecurrenceInctor;
import com.tencent.qqmail.calendar.data.RecurringException;
import com.tencent.qqmail.calendar.model.QMScheduleManager.TLCalendar;
import com.tencent.qqmail.calendar.provider.model.CPEvent;
import com.tencent.qqmail.calendar.provider.model.CPReminder;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.log.QMLog;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalendarProviderUtil
{
  private static final String TAG = "CalendarProviderUtil";
  
  public static int getSupportReminder(boolean paramBoolean, ArrayList<CPReminder> paramArrayList)
  {
    int j = -1;
    if (paramBoolean) {}
    int i = j;
    if (paramArrayList != null)
    {
      i = j;
      if (!paramArrayList.isEmpty()) {
        i = ((CPReminder)paramArrayList.get(0)).getMinutes();
      }
    }
    return i;
  }
  
  public static long getTimeZone(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      QMLog.log(6, "CalendarProviderUtil", "timeZoneStr:" + paramString + " error :" + localException.getMessage());
    }
    return 0L;
  }
  
  public static ArrayList<Integer> parseCPEventDayOfMonth(boolean paramBoolean, long paramLong, String paramString)
  {
    ArrayList localArrayList = Lists.newArrayList();
    int i = parseCPEventRecurrenceType(paramString);
    if ((i == 2) || (i == 5))
    {
      paramString = Pattern.compile("BYMONTHDAY=([^;]*)").matcher(paramString);
      if (!paramString.find()) {
        break label123;
      }
      paramString = paramString.group(1);
      String[] arrayOfString = paramString.split(",");
      try
      {
        int j = arrayOfString.length;
        i = 0;
        while (i < j)
        {
          localArrayList.add(Integer.valueOf(arrayOfString[i]));
          i += 1;
        }
        return localArrayList;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QMLog.log(6, "CalendarProviderUtil", "parseCPEventDayOfMonth NumberFormatException: " + paramString);
      }
    }
    label123:
    paramString = new GregorianCalendar();
    long l = paramLong;
    if (paramBoolean) {
      l = paramLong - TimeZone.getDefault().getRawOffset();
    }
    paramString.setTimeInMillis(l);
    localArrayList.add(Integer.valueOf(paramString.get(5)));
    return localArrayList;
  }
  
  public static int parseCPEventDayOfWeek(String paramString, long paramLong)
  {
    int j = 0;
    int k = parseCPEventRecurrenceType(paramString);
    if (k == 7) {
      j = 62;
    }
    int i;
    if (k != 1)
    {
      i = j;
      if (k != 2) {}
    }
    else
    {
      paramString = Pattern.compile("BYDAY=([^;]*)").matcher(paramString);
      i = j;
      if (paramString.find())
      {
        paramString = paramString.group(1);
        i = j;
        if (paramString.contains("SU")) {
          i = j + 1;
        }
        j = i;
        if (paramString.contains("MO")) {
          j = i + 2;
        }
        i = j;
        if (paramString.contains("TU")) {
          i = j + 4;
        }
        j = i;
        if (paramString.contains("WE")) {
          j = i + 8;
        }
        i = j;
        if (paramString.contains("TH")) {
          i = j + 16;
        }
        j = i;
        if (paramString.contains("FR")) {
          j = i + 32;
        }
        i = j;
        if (paramString.contains("SA")) {
          i = j + 64;
        }
      }
    }
    j = i;
    if (i == 0)
    {
      j = i;
      if (k == 1)
      {
        paramString = Calendar.getInstance();
        paramString.setTimeInMillis(paramLong);
        j = QMCalendarUtil.getWeekProtocolValue(paramString.get(7));
      }
    }
    return j;
  }
  
  public static Long parseCPEventDuration(CPEvent paramCPEvent)
  {
    Object localObject2 = paramCPEvent.getDuration();
    Object localObject1 = Long.valueOf(0L);
    paramCPEvent = (CPEvent)localObject1;
    if (localObject2 != null)
    {
      if (!((String)localObject2).equals("")) {
        break label32;
      }
      paramCPEvent = (CPEvent)localObject1;
    }
    label32:
    do
    {
      do
      {
        do
        {
          return paramCPEvent;
          localObject2 = Pattern.compile("PT?((\\w*)W)?T?((\\w*)D)?T?((\\w*)H)?T?((\\w*)M)?T?((\\w*)S)?T?").matcher((CharSequence)localObject2);
          paramCPEvent = (CPEvent)localObject1;
        } while (!((Matcher)localObject2).find());
        paramCPEvent = (CPEvent)localObject1;
        if (((Matcher)localObject2).group(2) != null)
        {
          paramCPEvent = (CPEvent)localObject1;
          if (!((Matcher)localObject2).group(2).equals("")) {
            paramCPEvent = Long.valueOf(((Long)localObject1).longValue() + Long.parseLong(((Matcher)localObject2).group(2)) * 86400000L * 7L);
          }
        }
        localObject1 = paramCPEvent;
        if (((Matcher)localObject2).group(4) != null)
        {
          localObject1 = paramCPEvent;
          if (!((Matcher)localObject2).group(4).equals("")) {
            localObject1 = Long.valueOf(paramCPEvent.longValue() + Long.parseLong(((Matcher)localObject2).group(4)) * 86400000L);
          }
        }
        paramCPEvent = (CPEvent)localObject1;
        if (((Matcher)localObject2).group(6) != null)
        {
          paramCPEvent = (CPEvent)localObject1;
          if (!((Matcher)localObject2).group(6).equals("")) {
            paramCPEvent = Long.valueOf(((Long)localObject1).longValue() + Long.parseLong(((Matcher)localObject2).group(6)) * 60000L * 60L);
          }
        }
        localObject1 = paramCPEvent;
        if (((Matcher)localObject2).group(8) != null)
        {
          localObject1 = paramCPEvent;
          if (!((Matcher)localObject2).group(8).equals("")) {
            localObject1 = Long.valueOf(paramCPEvent.longValue() + Long.parseLong(((Matcher)localObject2).group(8)) * 60000L);
          }
        }
        paramCPEvent = (CPEvent)localObject1;
      } while (((Matcher)localObject2).group(10) == null);
      paramCPEvent = (CPEvent)localObject1;
    } while (((Matcher)localObject2).group(10).equals(""));
    long l = ((Long)localObject1).longValue();
    return Long.valueOf(Long.parseLong(((Matcher)localObject2).group(10)) * 1000L + l);
  }
  
  public static int parseCPEventInterval(CPEvent paramCPEvent)
  {
    int j = 0;
    Object localObject = paramCPEvent.getRrule();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((String)localObject).equals(""))
      {
        paramCPEvent = "";
        localObject = Pattern.compile("INTERVAL=(\\w*);?").matcher((CharSequence)localObject);
        if (((Matcher)localObject).find()) {
          paramCPEvent = ((Matcher)localObject).group(1);
        }
        if (paramCPEvent.equals("")) {
          break label66;
        }
        i = Integer.parseInt(paramCPEvent);
      }
    }
    return i;
    label66:
    return 1;
  }
  
  public static int parseCPEventRecurrenceType(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")))
    {
      String str1 = "";
      String str2 = "";
      Matcher localMatcher = Pattern.compile("FREQ=(\\w*);?").matcher(paramString);
      if (localMatcher.find()) {
        str1 = localMatcher.group(1);
      }
      localMatcher = Pattern.compile("BYDAY=([^;]*)").matcher(paramString);
      paramString = str2;
      if (localMatcher.find()) {
        paramString = localMatcher.group(1);
      }
      if (str1.equals("DAILY")) {
        return 0;
      }
      if (str1.equals("WEEKLY"))
      {
        if (paramString.equals("MO,TU,WE,TH,FR")) {
          return 7;
        }
        return 1;
      }
      if (str1.equals("MONTHLY")) {
        return 2;
      }
      if (str1.equals("YEARLY")) {
        return 5;
      }
    }
    return -1;
  }
  
  public static Long parseCPEventUntil(CPEvent paramCPEvent, QMCalendarEvent paramQMCalendarEvent)
  {
    int k = 0;
    Long localLong = Long.valueOf(0L);
    String str = paramCPEvent.getRrule();
    paramCPEvent = localLong;
    Object localObject;
    Matcher localMatcher;
    if (str != null)
    {
      paramCPEvent = localLong;
      if (!str.equals(""))
      {
        localObject = "";
        localMatcher = Pattern.compile("UNTIL=(\\w*)T(\\w*)Z?;?|UNTIL=(\\w*);?").matcher(str);
        if (!localMatcher.find()) {
          break label275;
        }
        paramCPEvent = (CPEvent)localObject;
        if (localMatcher.group(1) != null)
        {
          paramCPEvent = (CPEvent)localObject;
          if (!localMatcher.group(1).equals("")) {
            paramCPEvent = localMatcher.group(1);
          }
        }
        if ((localMatcher.group(2) == null) || (localMatcher.group(2).equals(""))) {
          break label379;
        }
      }
    }
    label275:
    label379:
    for (paramQMCalendarEvent = localMatcher.group(2);; paramQMCalendarEvent = "")
    {
      if ((localMatcher.group(3) != null) && (!localMatcher.group(3).equals(""))) {
        paramCPEvent = localMatcher.group(3);
      }
      for (;;)
      {
        localObject = Calendar.getInstance();
        int i;
        int j;
        if (!paramCPEvent.equals(""))
        {
          int m = Integer.parseInt(paramCPEvent.substring(0, 4));
          int n = Integer.parseInt(paramCPEvent.substring(4, 6));
          int i1 = Integer.parseInt(paramCPEvent.substring(6, 8));
          if (!paramQMCalendarEvent.equals(""))
          {
            i = Integer.parseInt(paramQMCalendarEvent.substring(0, 2));
            j = Integer.parseInt(paramQMCalendarEvent.substring(2, 4));
            k = Integer.parseInt(paramQMCalendarEvent.substring(4, 6));
            ((Calendar)localObject).set(m, n - 1, i1, i, j, k);
            paramCPEvent = Long.valueOf(((Calendar)localObject).getTimeInMillis());
          }
        }
        for (;;)
        {
          return paramCPEvent;
          localObject = Pattern.compile("COUNT=(\\w*);?").matcher(str);
          paramCPEvent = localLong;
          if (((Matcher)localObject).find())
          {
            i = Integer.valueOf(((Matcher)localObject).group(1)).intValue();
            paramCPEvent = localLong;
            if (i < 10000)
            {
              paramCPEvent = new QMScheduleManager.TLCalendar().get(TimeZone.getDefault());
              paramCPEvent.setTimeInMillis(paramQMCalendarEvent.getEndTime());
              RecurrenceInctor.createInstance(paramQMCalendarEvent).increment(paramCPEvent, i - 1);
              return Long.valueOf(paramCPEvent.getTimeInMillis());
              j = 0;
              i = 0;
              break;
              paramCPEvent = localLong;
            }
          }
        }
      }
    }
  }
  
  public static int parseCPEventWeekOfMonth(String paramString)
  {
    int j = 0;
    int i = j;
    String str;
    if (parseCPEventRecurrenceType(paramString) == 2)
    {
      paramString = Pattern.compile("BYDAY=([^;]*)").matcher(paramString);
      i = j;
      if (paramString.find())
      {
        paramString = paramString.group(1);
        i = j;
        if (!paramString.contains(","))
        {
          i = j;
          if (paramString.length() > 2) {
            str = paramString.substring(0, paramString.length() - 2);
          }
        }
      }
    }
    try
    {
      i = Integer.valueOf(str).intValue();
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QMLog.log(6, "CalendarProviderUtil", "parseCPEventWeekOfMonth error " + paramString);
    }
    return 0;
  }
  
  public static int parseMonthOfYear(boolean paramBoolean, long paramLong, String paramString)
  {
    int i = 0;
    if (parseCPEventRecurrenceType(paramString) == 5)
    {
      paramString = new GregorianCalendar();
      long l = paramLong;
      if (paramBoolean) {
        l = paramLong - TimeZone.getDefault().getRawOffset();
      }
      paramString.setTimeInMillis(l);
      i = paramString.get(2) + 1;
    }
    return i;
  }
  
  public static String parseQMEventToDuration(QMCalendarEvent paramQMCalendarEvent)
  {
    long l = paramQMCalendarEvent.getEndTime() - paramQMCalendarEvent.getStartTime();
    if (paramQMCalendarEvent.isAllDay()) {
      return String.format("P%sD", new Object[] { String.valueOf(l / 86400000L) });
    }
    return String.format("P%sS", new Object[] { String.valueOf(l / 1000L) });
  }
  
  public static String parseQMEventToExdate(QMCalendarEvent paramQMCalendarEvent)
  {
    if ((paramQMCalendarEvent == null) || (paramQMCalendarEvent.getExceptions() == null) || (paramQMCalendarEvent.getExceptions().size() <= 0)) {
      paramQMCalendarEvent = "";
    }
    String str;
    do
    {
      return paramQMCalendarEvent;
      int i = 0;
      str = "";
      if (i < paramQMCalendarEvent.getExceptions().size())
      {
        Object localObject1 = (RecurringException)paramQMCalendarEvent.getExceptions().get(i);
        if (paramQMCalendarEvent.isAllDay())
        {
          localObject1 = new Date(((RecurringException)localObject1).getExceptionStartTime() + getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
          localObject1 = new SimpleDateFormat("yyyyMMdd").format((Date)localObject1);
        }
        Object localObject2;
        for (str = str + (String)localObject1 + "T000000,";; str = str + (String)localObject2 + "T" + (String)localObject1 + "Z,")
        {
          i += 1;
          break;
          localObject1 = new Date(((RecurringException)localObject1).getExceptionStartTime() - getTimeZone(paramQMCalendarEvent.getTimezone()) * 1000L);
          localObject2 = new SimpleDateFormat("yyyyMMdd");
          SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HHmmss");
          localObject2 = ((SimpleDateFormat)localObject2).format((Date)localObject1);
          localObject1 = localSimpleDateFormat.format((Date)localObject1);
        }
      }
      paramQMCalendarEvent = str;
    } while (str.length() <= 0);
    return str.substring(0, str.length() - 1);
  }
  
  public static String parseQMEventToRRule(QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent.getRecurrenceType() != -1)
    {
      RRule localRRule = new RRule();
      Object localObject2;
      Object localObject1;
      switch (paramQMCalendarEvent.getRecurrenceType())
      {
      case 4: 
      default: 
        localRRule.setInterval(paramQMCalendarEvent.getInterval());
        localRRule.setWkSt(Weekday.SU);
        if (paramQMCalendarEvent.getUntil() != 0L)
        {
          paramQMCalendarEvent = new Date(paramQMCalendarEvent.getUntil());
          localObject2 = new SimpleDateFormat("yyyyMMdd");
          localObject1 = new SimpleDateFormat("HHmmss");
          localObject2 = ((SimpleDateFormat)localObject2).format(paramQMCalendarEvent);
          paramQMCalendarEvent = ((SimpleDateFormat)localObject1).format(paramQMCalendarEvent);
        }
        break;
      }
      for (paramQMCalendarEvent = "UNTIL=" + (String)localObject2 + "T" + paramQMCalendarEvent;; paramQMCalendarEvent = "")
      {
        return localRRule.toIcal().replace("RRULE:", "") + ";" + paramQMCalendarEvent;
        localRRule.setFreq(Frequency.DAILY);
        break;
        localRRule.setFreq(Frequency.MONTHLY);
        if ((paramQMCalendarEvent.getDayOfWeek() > 0) && (paramQMCalendarEvent.getWeekOfMonth() != 0))
        {
          localObject1 = parseWeekday(paramQMCalendarEvent.getDayOfWeek());
          localObject2 = new CalendarProviderUtil.1();
          if (((ArrayList)localObject1).contains(Integer.valueOf(1))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.SU));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(2))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.MO));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(4))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.TU));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(8))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.WE));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(16))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.TH));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(32))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.FR));
          }
          if (((ArrayList)localObject1).contains(Integer.valueOf(64))) {
            ((List)localObject2).add(new WeekdayNum(paramQMCalendarEvent.getWeekOfMonth(), Weekday.SA));
          }
          localRRule.setByDay((List)localObject2);
        }
        if (paramQMCalendarEvent.getDaysOfMonth() == null) {
          break;
        }
        localObject1 = new int[paramQMCalendarEvent.getDaysOfMonth().size()];
        int i = 0;
        while (i < paramQMCalendarEvent.getDaysOfMonth().size())
        {
          localObject1[i] = ((Integer)paramQMCalendarEvent.getDaysOfMonth().get(i)).intValue();
          i += 1;
        }
        localRRule.setByMonthDay((int[])localObject1);
        break;
        localRRule.setFreq(Frequency.WEEKLY);
        if (paramQMCalendarEvent.getDayOfWeek() <= 0) {
          break;
        }
        localObject1 = parseWeekday(paramQMCalendarEvent.getDayOfWeek());
        localObject2 = new CalendarProviderUtil.2();
        if (((ArrayList)localObject1).contains(Integer.valueOf(1))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.SU));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(2))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.MO));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(4))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.TU));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(8))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.WE));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(16))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.TH));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(32))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.FR));
        }
        if (((ArrayList)localObject1).contains(Integer.valueOf(64))) {
          ((List)localObject2).add(new WeekdayNum(0, Weekday.SA));
        }
        localRRule.setByDay((List)localObject2);
        break;
        localRRule.setFreq(Frequency.YEARLY);
        break;
        localRRule.setFreq(Frequency.WEEKLY);
        localObject1 = new CalendarProviderUtil.3();
        ((List)localObject1).add(new WeekdayNum(0, Weekday.MO));
        ((List)localObject1).add(new WeekdayNum(0, Weekday.TU));
        ((List)localObject1).add(new WeekdayNum(0, Weekday.WE));
        ((List)localObject1).add(new WeekdayNum(0, Weekday.TH));
        ((List)localObject1).add(new WeekdayNum(0, Weekday.FR));
        localRRule.setByDay((List)localObject1);
        break;
        localRRule.setFreq(Frequency.MONTHLY);
        break;
        localRRule.setFreq(Frequency.YEARLY);
        break;
      }
    }
    return "";
  }
  
  private static ArrayList<Integer> parseWeekday(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int j = 6;
    int i = paramInt;
    paramInt = j;
    while (paramInt >= 0)
    {
      j = i;
      if (Math.pow(2.0D, paramInt) <= i)
      {
        localArrayList.add(Integer.valueOf((int)Math.pow(2.0D, paramInt)));
        j = (int)(i - Math.pow(2.0D, paramInt));
      }
      paramInt -= 1;
      i = j;
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.provider.CalendarProviderUtil
 * JD-Core Version:    0.7.0.1
 */