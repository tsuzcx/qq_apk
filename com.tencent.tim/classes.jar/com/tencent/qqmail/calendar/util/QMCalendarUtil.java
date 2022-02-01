package com.tencent.qqmail.calendar.util;

import android.util.SparseArray;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.QMCalendarEvent;
import com.tencent.qqmail.calendar.data.QMSchedule;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.trd.guava.Lists;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;

public class QMCalendarUtil
{
  private static final String LAST_NTH_WEEK_NTH_WEEKDAY_IN_MONTH = "最后$nthWeek$周$weekday$";
  public static final long MILI_SECOND_PER_DAY = 86400000L;
  public static final long MILI_SECOND_PER_MINUTE = 60000L;
  public static final long MILI_SECOND_PER_SECOND = 1000L;
  private static final String NTH_DAY_IN_MONTH = "第$dayOfMonth$天";
  private static final String NTH_WEEK_NTH_WEEKDAY_IN_MONTH = "第$nthWeek$周$weekday$";
  public static final long SECONDS_PER_DAY = 86400L;
  private static final QMApplicationContext context = ;
  private static final int minutesPerDay = 1440;
  public static final int minutesPerHour = 60;
  private static final int[] remindStyleStr = { 2131691138, 2131691135, 2131691137, 2131691136, 2131691141, 2131691139 };
  private static SparseArray<String> sDayOfWeekStrMap;
  private static SparseArray<String> sEveryStrMap;
  private static SparseArray<String> sMonthOfYearStrMap;
  private static SparseArray<String> sWeekOfMonthStrMap;
  private static final int[] weekStr = { 2131691156, 2131691152, 2131691160, 2131691162, 2131691158, 2131691150, 2131691154 };
  private static final int[] weekStrForShort = { 2131691157, 2131691153, 2131691161, 2131691163, 2131691159, 2131691151, 2131691155 };
  
  static
  {
    sEveryStrMap = new SparseArray();
    sMonthOfYearStrMap = new SparseArray();
    sWeekOfMonthStrMap = new SparseArray();
    sDayOfWeekStrMap = new SparseArray();
    sEveryStrMap.append(5, "每$interval$年");
    sEveryStrMap.append(6, "每$interval$年");
    sEveryStrMap.append(2, "每$interval$月");
    sEveryStrMap.append(3, "每$interval$月");
    sEveryStrMap.append(1, "每$interval$周");
    sEveryStrMap.append(0, "每$interval$周工作日");
    sEveryStrMap.append(0, "每$interval$天");
    sMonthOfYearStrMap.append(0, "一月");
    sMonthOfYearStrMap.append(1, "二月");
    sMonthOfYearStrMap.append(2, "三月");
    sMonthOfYearStrMap.append(3, "四月");
    sMonthOfYearStrMap.append(4, "五月");
    sMonthOfYearStrMap.append(6, "六月");
    sMonthOfYearStrMap.append(5, "七月");
    sMonthOfYearStrMap.append(7, "八月");
    sMonthOfYearStrMap.append(8, "九月");
    sMonthOfYearStrMap.append(9, "十月");
    sMonthOfYearStrMap.append(10, "十一月");
    sMonthOfYearStrMap.append(11, "十二月");
    sWeekOfMonthStrMap.append(1, "第一个");
    sWeekOfMonthStrMap.append(2, "第二个");
    sWeekOfMonthStrMap.append(3, "第三个");
    sWeekOfMonthStrMap.append(4, "第四个");
    sWeekOfMonthStrMap.append(5, "最后一个");
    sDayOfWeekStrMap.append(1, "星期日");
    sDayOfWeekStrMap.append(2, "星期一");
    sDayOfWeekStrMap.append(3, "星期二");
    sDayOfWeekStrMap.append(4, "星期三");
    sDayOfWeekStrMap.append(5, "星期四");
    sDayOfWeekStrMap.append(6, "星期五");
    sDayOfWeekStrMap.append(7, "星期六");
    sDayOfWeekStrMap.append(62, "工作日");
    sDayOfWeekStrMap.append(65, "周末");
  }
  
  public static int compareMiliInMinute(long paramLong1, long paramLong2)
  {
    paramLong1 /= 60000L;
    paramLong2 /= 60000L;
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public static int compareTime(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean) {
      return getDiffDays(paramLong1, paramLong2);
    }
    if (paramLong1 > paramLong2) {
      return 1;
    }
    if (paramLong1 < paramLong2) {
      return -1;
    }
    return 0;
  }
  
  public static long computeUntilTime(QMCalendarEvent paramQMCalendarEvent, QMSchedule paramQMSchedule)
  {
    if (!paramQMSchedule.isAllDay()) {
      return paramQMSchedule.getEventStartTime() - 86400000L + 1000L;
    }
    long l1 = paramQMCalendarEvent.getEndTime();
    paramQMCalendarEvent = Calendar.getInstance();
    paramQMCalendarEvent.setTimeInMillis(l1);
    paramQMCalendarEvent.set(paramQMCalendarEvent.get(1), paramQMCalendarEvent.get(2), paramQMCalendarEvent.get(5), 0, 0, 0);
    long l2 = paramQMCalendarEvent.getTimeInMillis();
    return paramQMSchedule.getEventStartTime() - (l2 - l1) - 86400000L;
  }
  
  public static String convertAttendeeStatusToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "NEEDS-ACTION";
    case 2: 
      return "TENTATIVE";
    case 3: 
      return "ACCEPTED";
    }
    return "DECLINED";
  }
  
  public static long correctTimeToSecond(long paramLong)
  {
    return paramLong / 1000L * 1000L;
  }
  
  private static String createAllDayReminderString(int paramInt, long paramLong)
  {
    Object localObject = new GregorianCalendar();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    ((Calendar)localObject).set(((Calendar)localObject).get(1), ((Calendar)localObject).get(2), ((Calendar)localObject).get(5), 0, 0, 0);
    long l1 = ((Calendar)localObject).getTimeInMillis();
    long l2 = l1 - paramInt * 60000L;
    ((Calendar)localObject).setTimeInMillis(l2);
    if ((l2 >= l1) && (l2 - paramLong < 86400000L)) {
      return getTimeString((Calendar)localObject);
    }
    paramLong = l1 - l2;
    String str;
    int i;
    if (paramLong > 0L)
    {
      str = "前";
      i = (int)(Math.abs(paramLong) / 86400000L);
      if (paramLong <= 0L) {
        break label175;
      }
    }
    label175:
    for (paramInt = 1;; paramInt = 0)
    {
      paramInt += i;
      localObject = getTimeString((Calendar)localObject);
      if (paramInt != 7) {
        break label180;
      }
      return String.format(context.getString(2131691142), new Object[] { localObject, str });
      str = "后";
      break;
    }
    label180:
    return String.format(context.getString(2131691134), new Object[] { Integer.valueOf(paramInt), localObject, str });
  }
  
  public static String createReadableStringOfRecurrence(QMCalendarEvent paramQMCalendarEvent)
  {
    if (isRecurrenceSupported(paramQMCalendarEvent)) {
      return getStringByRecurringType(paramQMCalendarEvent.getRecurrenceType());
    }
    int j = paramQMCalendarEvent.getRecurrenceType();
    StringBuilder localStringBuilder = new StringBuilder();
    String str2 = (String)sEveryStrMap.get(j);
    String str1;
    if (str2 != null)
    {
      if (paramQMCalendarEvent.getInterval() > 1)
      {
        str1 = String.valueOf(paramQMCalendarEvent.getInterval());
        localStringBuilder.append(str2.replace("$interval$", str1));
      }
    }
    else
    {
      if ((j == 5) || (j == 6)) {
        localStringBuilder.append((String)sMonthOfYearStrMap.get(paramQMCalendarEvent.getMonthOfYear() - 1));
      }
      if ((j == 5) || (j == 2))
      {
        if ((j != 2) || (((paramQMCalendarEvent.getWeekOfMonth() == 0) || (paramQMCalendarEvent.getDayOfWeek() == 0)) && (paramQMCalendarEvent.getDaysOfMonth() == null))) {
          break label471;
        }
        str2 = "";
        if ((paramQMCalendarEvent.getWeekOfMonth() == 0) || (paramQMCalendarEvent.getDayOfWeek() == 0)) {
          break label341;
        }
        str1 = (String)sDayOfWeekStrMap.get(getDayOfWeekByProtocolValue(paramQMCalendarEvent.getDayOfWeek()));
        if (paramQMCalendarEvent.getWeekOfMonth() <= 0) {
          break label312;
        }
        str1 = "第$nthWeek$周$weekday$".replace("$nthWeek$", String.valueOf(paramQMCalendarEvent.getWeekOfMonth())).replace("$weekday$", str1);
      }
    }
    for (;;)
    {
      label216:
      localStringBuilder.append(str1);
      label224:
      if ((j == 3) || (j == 3)) {
        localStringBuilder.append((String)sWeekOfMonthStrMap.get(paramQMCalendarEvent.getWeekOfMonth()));
      }
      int n;
      if ((j == 3) || (j == 3) || (j == 1))
      {
        n = paramQMCalendarEvent.getDayOfWeek();
        if (n != 62) {
          break label495;
        }
        localStringBuilder.append((String)sDayOfWeekStrMap.get(n));
      }
      for (;;)
      {
        return localStringBuilder.toString();
        str1 = "";
        break;
        label312:
        str1 = "最后$nthWeek$周$weekday$".replace("$nthWeek$", String.valueOf(-paramQMCalendarEvent.getWeekOfMonth())).replace("$weekday$", str1);
        break label216;
        label341:
        str1 = str2;
        if (paramQMCalendarEvent.getDaysOfMonth() == null) {
          break label216;
        }
        str1 = str2;
        if (paramQMCalendarEvent.getDaysOfMonth().size() <= 0) {
          break label216;
        }
        str1 = "" + "第$dayOfMonth$天".replace("$dayOfMonth$", String.valueOf(paramQMCalendarEvent.getDaysOfMonth().get(0)));
        int i = 1;
        while (i < paramQMCalendarEvent.getDaysOfMonth().size())
        {
          str1 = str1 + ", " + "第$dayOfMonth$天".replace("$dayOfMonth$", String.valueOf(paramQMCalendarEvent.getDaysOfMonth().get(i)));
          i += 1;
        }
        label471:
        localStringBuilder.append("第$dayOfMonth$天".replace("$dayOfMonth$", String.valueOf(paramQMCalendarEvent.getDayOfMonth())));
        break label224;
        label495:
        if (n == 65)
        {
          localStringBuilder.append((String)sDayOfWeekStrMap.get(n));
        }
        else
        {
          j = 1;
          int k = 0;
          i = 1;
          while (i <= 7)
          {
            int m = k;
            if ((j & n) != 0)
            {
              if (k != 0) {
                localStringBuilder.append("、");
              }
              localStringBuilder.append((String)sDayOfWeekStrMap.get(i));
              m = 1;
            }
            j <<= 1;
            i += 1;
            k = m;
          }
        }
      }
    }
  }
  
  public static String dayOfWeekToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 0: 
      return "SU";
    case 1: 
      return "MO";
    case 2: 
      return "TU";
    case 3: 
      return "WE";
    case 4: 
      return "TH";
    case 5: 
      return "FR";
    }
    return "SA";
  }
  
  public static int getDayOfWeekByProtocolValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 4: 
      return 3;
    case 8: 
      return 4;
    case 16: 
      return 5;
    case 32: 
      return 6;
    }
    return 7;
  }
  
  public static String getDayString(Calendar paramCalendar)
  {
    return String.format(context.getString(2131691103), new Object[] { Integer.valueOf(paramCalendar.get(1)), Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) });
  }
  
  public static int getDaysByRecurringType(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 3: 
    case 4: 
    case 6: 
    default: 
      return 0;
    case 0: 
      return 1;
    case 7: 
      return 7;
    case 1: 
      return 7;
    case 2: 
      return 30;
    }
    return 365;
  }
  
  public static int getDiffDays(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return getDiffDays(localCalendar1, localCalendar2);
  }
  
  public static int getDiffDays(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    paramCalendar1.set(11, 0);
    paramCalendar1.set(12, 0);
    paramCalendar1.set(13, 0);
    paramCalendar1.set(14, 0);
    paramCalendar2.set(11, 0);
    paramCalendar2.set(12, 0);
    paramCalendar2.set(13, 0);
    paramCalendar2.set(14, 0);
    return (int)((paramCalendar1.getTimeInMillis() - paramCalendar2.getTimeInMillis()) / 86400000L);
  }
  
  public static int getDiffMonths(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(1) - paramCalendar2.get(1)) * 12 + (paramCalendar1.get(2) - paramCalendar2.get(2));
  }
  
  public static long[] getFilterTime(int paramInt)
  {
    if (paramInt == 4) {
      return new long[] { -1L, -1L };
    }
    Calendar localCalendar = Calendar.getInstance();
    switch (paramInt)
    {
    }
    for (;;)
    {
      long l = localCalendar.getTimeInMillis() / 1000L;
      localCalendar.add(1, 10);
      return new long[] { l, localCalendar.getTimeInMillis() / 1000L };
      localCalendar.add(4, -2);
      continue;
      localCalendar.add(2, -1);
      continue;
      localCalendar.add(2, -3);
      continue;
      localCalendar.add(2, -6);
    }
  }
  
  public static int getFilterType(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 4;
    case 1: 
      return 5;
    case 2: 
      return 6;
    }
    return 7;
  }
  
  public static String getMonthDayString(Calendar paramCalendar)
  {
    return String.format(context.getString(2131691125), new Object[] { Integer.valueOf(paramCalendar.get(2) + 1), Integer.valueOf(paramCalendar.get(5)) });
  }
  
  public static String getStringByAllDayReminder(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      return createAllDayReminderString(paramInt, paramLong);
    case -1: 
      return context.getString(2131691138);
    case 0: 
      return context.getString(2131691144);
    case 900: 
      return context.getString(2131691140);
    case 2340: 
      return context.getString(2131691145);
    }
    return context.getString(2131691143);
  }
  
  public static String getStringByRecurringType(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 6: 
    default: 
      return "";
    case -1: 
      return context.getString(2131691115);
    case 0: 
      return context.getString(2131691113);
    case 7: 
      return context.getString(2131691117);
    case 1: 
      return context.getString(2131691116);
    case 2: 
      return context.getString(2131691114);
    }
    return context.getString(2131691118);
  }
  
  public static String getStringByReminder(int paramInt, long paramLong)
  {
    Object localObject2 = "";
    switch (paramInt)
    {
    default: 
      if (paramInt <= 0) {
        break;
      }
    }
    for (String str = "前";; str = "后")
    {
      int j = Math.abs(paramInt);
      paramInt = j / 1440;
      int i = j % 1440 / 60;
      j = j % 1440 % 60;
      if (paramInt > 0) {
        localObject2 = "" + String.valueOf(paramInt) + "天";
      }
      Object localObject1 = localObject2;
      if (i > 0) {
        localObject1 = (String)localObject2 + String.valueOf(i) + "小时";
      }
      localObject2 = localObject1;
      if (j > 0) {
        localObject2 = (String)localObject1 + String.valueOf(j) + "分钟";
      }
      localObject1 = localObject2;
      if (!StringUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = (String)localObject2 + str;
      }
      return localObject1;
      return context.getString(2131691138);
      return context.getString(2131691135);
      return context.getString(2131691137);
      return context.getString(2131691136);
      return context.getString(2131691141);
      return context.getString(2131691139);
    }
  }
  
  public static double getTimeDuration(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Calendar localCalendar1 = Calendar.getInstance();
      localCalendar1.setTimeInMillis(paramLong1);
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(paramLong2);
      localCalendar2.add(5, 1);
      return getDiffDays(localCalendar1, localCalendar2);
    }
    return (paramLong1 - paramLong2) / 86400000.0D;
  }
  
  public static String getTimeString(int paramInt1, int paramInt2)
  {
    return String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public static String getTimeString(Calendar paramCalendar)
  {
    return getTimeString(paramCalendar.get(11), paramCalendar.get(12));
  }
  
  public static String getValidateBodyText(String paramString)
  {
    if (paramString == null) {
      return paramString;
    }
    String str2 = new String(paramString);
    Matcher localMatcher = Pattern.compile("(\\*~)+\\*\\s*").matcher(paramString);
    String str1 = str2;
    if (localMatcher.find())
    {
      int i = localMatcher.end();
      str1 = str2;
      if (i != -1) {
        str1 = paramString.substring(i);
      }
    }
    return str1;
  }
  
  public static int getWeekProtocolValue(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    case 3: 
      return 4;
    case 4: 
      return 8;
    case 5: 
      return 16;
    case 6: 
      return 32;
    }
    return 64;
  }
  
  public static String getWeekString(int paramInt)
  {
    return context.getString(weekStr[(paramInt - 1)]);
  }
  
  public static String getWeekString(Calendar paramCalendar)
  {
    return context.getString(weekStr[(paramCalendar.get(7) - 1)]);
  }
  
  public static String getWeekStringForShort(int paramInt)
  {
    return context.getString(weekStrForShort[(paramInt - 1)]);
  }
  
  public static boolean hasCalendarFolder()
  {
    return QMCalendarManager.getInstance().getCountOfAccountEnabled() > 0;
  }
  
  public static boolean isFirstScheduleInstance(QMCalendarEvent paramQMCalendarEvent, QMSchedule paramQMSchedule)
  {
    boolean bool = false;
    long l = paramQMCalendarEvent.getStartTime();
    if (paramQMCalendarEvent.isAllDay())
    {
      paramQMCalendarEvent = Calendar.getInstance();
      paramQMCalendarEvent.setTimeInMillis(l);
      paramQMCalendarEvent.set(paramQMCalendarEvent.get(1), paramQMCalendarEvent.get(2), paramQMCalendarEvent.get(5), 0, 0, 0);
      l = paramQMCalendarEvent.getTimeInMillis();
    }
    for (;;)
    {
      if (l == paramQMSchedule.getEventStartTime()) {
        bool = true;
      }
      return bool;
    }
  }
  
  public static final boolean isLeapYear(int paramInt)
  {
    return ((paramInt % 4 == 0) && (paramInt % 100 != 0)) || (paramInt % 400 == 0);
  }
  
  public static boolean isRecurrenceSupported(QMCalendarEvent paramQMCalendarEvent)
  {
    if (paramQMCalendarEvent.getInterval() > 1) {}
    int i;
    do
    {
      do
      {
        return false;
        i = paramQMCalendarEvent.getRecurrenceType();
      } while ((i == 3) || (i == 6) || ((i == 2) && (((paramQMCalendarEvent.getWeekOfMonth() != 0) && (paramQMCalendarEvent.getDayOfWeek() != 0)) || ((paramQMCalendarEvent.getDaysOfMonth() != null) && (paramQMCalendarEvent.getDaysOfMonth().size() != 1)))));
      if (i != 1) {
        break;
      }
      i = paramQMCalendarEvent.getDayOfWeek();
    } while (((i > 64) && (i <= 0)) || ((i & i - 1) > 0));
    return true;
  }
  
  public static boolean isSameDate(Calendar paramCalendar1, Calendar paramCalendar2)
  {
    return (paramCalendar1.get(5) == paramCalendar2.get(5)) && (paramCalendar1.get(2) == paramCalendar2.get(2)) && (paramCalendar1.get(1) == paramCalendar2.get(1));
  }
  
  public static boolean isWeekendDay(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 7);
  }
  
  public static String[] recognizeUrl(String paramString)
  {
    String[] arrayOfString1 = new String[2];
    if ((paramString.startsWith("http://mail.qq.com/cgi-bin/calendar")) || (paramString.startsWith("https://mail.qq.com/cgi-bin/calendar")))
    {
      paramString = paramString.split("\\?");
      if ((paramString != null) && (paramString.length == 2))
      {
        paramString = paramString[1].split("&");
        if ((paramString != null) && (paramString.length > 0))
        {
          int i = 0;
          if (i < paramString.length)
          {
            String[] arrayOfString2 = paramString[i].split("=");
            if ((arrayOfString2 != null) && (arrayOfString2.length == 2))
            {
              if (!"code".equals(arrayOfString2[0])) {
                break label115;
              }
              arrayOfString1[0] = arrayOfString2[1];
            }
            for (;;)
            {
              i += 1;
              break;
              label115:
              if ("email".equals(arrayOfString2[0])) {
                arrayOfString1[1] = arrayOfString2[1];
              }
            }
          }
        }
      }
    }
    if ((StringUtils.isEmpty(arrayOfString1[0])) || (StringUtils.isEmpty(arrayOfString1[1]))) {
      return null;
    }
    return arrayOfString1;
  }
  
  public static String recurrenceTypeToString(int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    default: 
      return "";
    case 0: 
      return "DAILY";
    case 1: 
      return "WEEKLY";
    case 2: 
      return "MONTHLY";
    }
    return "YEARLY";
  }
  
  public static void setRecurrenceElementForEvent(QMCalendarEvent paramQMCalendarEvent)
  {
    int j = paramQMCalendarEvent.getRecurrenceType();
    paramQMCalendarEvent.resetRecurrenceEelement();
    if (j == -1) {}
    do
    {
      return;
      paramQMCalendarEvent.setRecurrenceType(j);
      if (paramQMCalendarEvent.getCategory() == 1) {}
      for (int i = paramQMCalendarEvent.getInterval();; i = 1)
      {
        paramQMCalendarEvent.setInterval(i);
        GregorianCalendar localGregorianCalendar = new GregorianCalendar();
        localGregorianCalendar.setTimeInMillis(paramQMCalendarEvent.getStartTime());
        if (j == 5) {
          paramQMCalendarEvent.setMonthOfYear(localGregorianCalendar.get(2) + 1);
        }
        if ((j == 2) || (paramQMCalendarEvent.getRecurrenceType() == 5))
        {
          paramQMCalendarEvent.setDayOfMonth(localGregorianCalendar.get(5));
          if (paramQMCalendarEvent.getDaysOfMonth() != null)
          {
            ArrayList localArrayList = Lists.newArrayList();
            localArrayList.addAll(paramQMCalendarEvent.getDaysOfMonth());
            paramQMCalendarEvent.setDaysOfMonth(localArrayList);
          }
        }
        if (j != 1) {
          break;
        }
        paramQMCalendarEvent.setDayOfWeek(getWeekProtocolValue(localGregorianCalendar.get(7)));
        return;
      }
    } while (j != 7);
    paramQMCalendarEvent.setDayOfWeek(62);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.util.QMCalendarUtil
 * JD-Core Version:    0.7.0.1
 */