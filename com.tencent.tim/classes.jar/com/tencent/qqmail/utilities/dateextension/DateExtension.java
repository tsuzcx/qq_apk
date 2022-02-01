package com.tencent.qqmail.utilities.dateextension;

import android.util.Log;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateExtension
{
  private static final long INTERVAL_DAY = 86400000L;
  private static final long INTERVAL_HOUR = 3600000L;
  private static final long INTERVAL_MINUTE = 60000L;
  private static final Calendar mCalendarCache1 = Calendar.getInstance();
  private static final Calendar mCalendarCache2 = Calendar.getInstance();
  public static final SimpleDateFormat mmm_d_yyy_h_m_s;
  private static final SimpleDateFormat sf_hm;
  private static final SimpleDateFormat sf_md;
  private static final SimpleDateFormat sf_qhm;
  private static final SimpleDateFormat sf_y_m_d;
  public static final SimpleDateFormat sf_y_m_d_e_h_m;
  private static final SimpleDateFormat sf_y_m_d_h_m;
  private static final SimpleDateFormat sf_y_m_d_h_m_1;
  public static final SimpleDateFormat sf_y_m_d_h_m_chn;
  public static final SimpleDateFormat sf_y_m_d_h_m_eng;
  private static final SimpleDateFormat sf_y_m_d_h_m_s_chn;
  private static final SimpleDateFormat sf_y_m_d_h_m_s_eng;
  private static final SimpleDateFormat sf_ymd;
  private static final SimpleDateFormat sf_yy_mm_dd = new SimpleDateFormat("yyyy年M月d日");
  private static final SimpleDateFormat sf_zhm;
  public static final String[] weekDay = { "周日", "周一", "周二", "周三", "周四", "周五", "周六" };
  
  static
  {
    sf_ymd = new SimpleDateFormat("yyyyMd");
    sf_hm = new SimpleDateFormat("HH:mm");
    sf_zhm = new SimpleDateFormat("昨天 HH:mm");
    sf_qhm = new SimpleDateFormat("前天 HH:mm");
    sf_md = new SimpleDateFormat("M月d日");
    sf_y_m_d = new SimpleDateFormat("yyyy/M/d");
    sf_y_m_d_h_m = new SimpleDateFormat("yyyy年M月d日 HH:mm");
    sf_y_m_d_h_m_s_chn = new SimpleDateFormat("yyyy年M月d日 HH:mm:ss");
    sf_y_m_d_h_m_s_eng = new SimpleDateFormat("yyyy/M/d HH:mm:ss");
    sf_y_m_d_h_m_chn = new SimpleDateFormat("yyyy年M月d日 HH:mm");
    sf_y_m_d_h_m_eng = new SimpleDateFormat("yyyy/M/d HH:mm");
    sf_y_m_d_e_h_m = new SimpleDateFormat("yyyy年M月d日  EE HH:mm");
    sf_y_m_d_h_m_1 = new SimpleDateFormat("yyyy-M-d HH:mm");
    mmm_d_yyy_h_m_s = new SimpleDateFormat("MMM d, yyyy hH:mm", Locale.ENGLISH);
  }
  
  public static String currentTimeString_MMdd()
  {
    Date localDate = new Date();
    return new SimpleDateFormat("MMdd").format(localDate);
  }
  
  private static String fillZero(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInt < 10) {}
    for (String str = "0";; str = "") {
      return str + paramInt;
    }
  }
  
  public static String fullDataName_y_m_dHHMM(Date paramDate)
  {
    if (paramDate != null) {
      return sf_y_m_d_h_m_1.format(paramDate);
    }
    return "";
  }
  
  public static String fullDateName_yyyyMMddEEhhmm(Date paramDate)
  {
    if (paramDate == null) {
      return "";
    }
    return sf_y_m_d_e_h_m.format(paramDate);
  }
  
  public static String fullDateName_yyyyMMddHHmm(long paramLong)
  {
    return sf_y_m_d_h_m.format(Long.valueOf(paramLong));
  }
  
  public static String fullDateName_yyyyMMddHHmm(Date paramDate)
  {
    if (paramDate == null) {
      paramDate = "";
    }
    Object localObject;
    do
    {
      return paramDate;
      localObject = sf_y_m_d_h_m.format(paramDate);
      paramDate = (Date)localObject;
      if (((String)localObject).contains("4000")) {
        paramDate = "无限期";
      }
      localObject = paramDate;
      if (paramDate.contains("4001")) {
        localObject = "无限期";
      }
      if (((String)localObject).contains("1969")) {
        break;
      }
      paramDate = (Date)localObject;
    } while (!((String)localObject).contains("1970"));
    return "无限期";
  }
  
  public static String fullDateName_yyyyMMddHHmmss(Date paramDate, int paramInt)
  {
    if (paramDate != null)
    {
      if (paramInt == 0) {
        return sf_y_m_d_h_m_s_chn.format(paramDate);
      }
      return sf_y_m_d_h_m_s_eng.format(paramDate);
    }
    return "";
  }
  
  public static long getCurrentTimeMilliSecondsFrom_1970_1_1()
  {
    return new Date().getTime();
  }
  
  public static long getCurrentTimeSecondsFrom_1970_1_1()
  {
    return getCurrentTimeMilliSecondsFrom_1970_1_1() / 1000L;
  }
  
  public static String getDateString(long paramLong)
  {
    Calendar localCalendar = mCalendarCache1;
    Date localDate1 = new Date(System.currentTimeMillis());
    Date localDate2 = new Date(paramLong);
    localCalendar.setTime(localDate1);
    int i = localCalendar.get(13);
    int j = localCalendar.get(12);
    int k = localCalendar.get(11);
    localCalendar = mCalendarCache2;
    localCalendar.setTime(localDate2);
    int m = localCalendar.get(13);
    int n = localCalendar.get(12);
    int i1 = localCalendar.get(11);
    paramLong = localDate1.getTime() - localDate2.getTime();
    long l = paramLong / 1000L - ((k * 60 + j) * 60 + i - ((i1 * 60 + n) * 60 + m));
    if (paramLong < 0L) {
      return fullDataName_y_m_dHHMM(localDate2);
    }
    if (l < 1L) {
      return "今天";
    }
    if (l < 86401L) {
      return "昨天";
    }
    if (l < 172801L) {
      return "前天";
    }
    if (l < 259201L) {
      return "3天前";
    }
    if (l < 604801L) {
      return "7天前";
    }
    if (l < 864001L) {
      return "10天前";
    }
    if (l < 5184001L) {
      return "1个月前";
    }
    if (l < 7776001L) {
      return "2个月前";
    }
    if (l < 10368001L) {
      return "3个月前";
    }
    if (l < 31104000L) {
      return "半年前";
    }
    return "1年前";
  }
  
  public static String getDayOfWeek(Date paramDate)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    int j = localCalendar.get(7) - 1;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    return weekDay[i];
  }
  
  public static String getHHMMSS(long paramLong)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    long l = paramLong / 1000L;
    paramLong = l;
    if (l > 3600L)
    {
      localStringBuffer.append(l / 3600L).append("时");
      paramLong = l % 3600L;
    }
    if (paramLong > 60L) {
      localStringBuffer.append(paramLong / 60L).append("分");
    }
    localStringBuffer.append(paramLong % 60L).append("秒");
    return localStringBuffer.toString();
  }
  
  public static String getIcsDateFormat(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Date localDate1 = new Date(paramLong1);
    Date localDate2 = new Date(paramLong2);
    Date localDate3 = new Date();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime(localDate2);
    Calendar localCalendar3 = Calendar.getInstance();
    localCalendar3.setTime(localDate3);
    if ((localCalendar1.get(1) != localCalendar3.get(1)) || (localCalendar2.get(1) != localCalendar3.get(1))) {}
    for (int i = 1;; i = 0)
    {
      if (paramBoolean) {
        localCalendar2.add(13, -1);
      }
      int j;
      if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(2) == localCalendar2.get(2)) && (localCalendar1.get(5) == localCalendar2.get(5)))
      {
        j = 1;
        if (i == 0) {
          break label251;
        }
        localStringBuilder.append(sf_yy_mm_dd.format(localDate1));
      }
      for (;;)
      {
        localStringBuilder.append(" ").append(getDayOfWeek(localDate1));
        if (!paramBoolean) {
          localStringBuilder.append(" ").append(sf_hm.format(localDate1));
        }
        if ((j == 0) || (!paramBoolean)) {
          break label268;
        }
        return localStringBuilder.toString();
        j = 0;
        break;
        label251:
        localStringBuilder.append(sf_md.format(localDate1));
      }
      label268:
      localStringBuilder.append(" -");
      if (j == 0)
      {
        if (i == 0) {
          break label355;
        }
        localStringBuilder.append(" ").append(sf_yy_mm_dd.format(localDate2));
      }
      for (;;)
      {
        localStringBuilder.append(" ").append(getDayOfWeek(localDate2));
        if (!paramBoolean) {
          localStringBuilder.append(" ").append(sf_hm.format(localDate2));
        }
        return localStringBuilder.toString();
        label355:
        localStringBuilder.append(" ").append(sf_md.format(localDate2));
      }
    }
  }
  
  public static String getIcsHMFormat(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return sf_hm.format(localDate);
  }
  
  public static String getIcsMDEFormat(long paramLong)
  {
    Object localObject = new Date(paramLong);
    String str = sf_md.format((Date)localObject);
    localObject = getDayOfWeek((Date)localObject);
    return str + " " + (String)localObject;
  }
  
  public static String getIcsYMDEFormat(long paramLong)
  {
    Object localObject = new Date(paramLong);
    String str = sf_yy_mm_dd.format((Date)localObject);
    localObject = getDayOfWeek((Date)localObject);
    return str + " " + (String)localObject;
  }
  
  public static String getIcsYMDFormat(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return sf_md.format(localDate);
  }
  
  public static long getSecsOfDays(int paramInt)
  {
    return 86400 * paramInt;
  }
  
  public static String getTimeMinuteSecondString(int paramInt)
  {
    paramInt /= 1000;
    int i = paramInt / 60;
    String str = String.format(Locale.getDefault(), "%02d:%02d", new Object[] { Integer.valueOf(i % 60), Integer.valueOf(paramInt % 60) });
    Log.d("mason", "time is " + str);
    return str;
  }
  
  public static String getTimeStringFromDate(String paramString, SimpleDateFormat paramSimpleDateFormat)
  {
    String str = "";
    try
    {
      paramSimpleDateFormat = String.valueOf(paramSimpleDateFormat.parse(paramString).getTime());
      paramString = str;
      if (paramSimpleDateFormat != null)
      {
        paramString = str;
        if (!paramSimpleDateFormat.equals(""))
        {
          paramString = str;
          if (paramSimpleDateFormat.length() > 10) {
            paramString = paramSimpleDateFormat.substring(0, 10);
          }
        }
      }
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String shortDateName(Date paramDate)
  {
    Date localDate2 = new Date();
    Date localDate1 = paramDate;
    if (paramDate == null) {
      localDate1 = localDate2;
    }
    paramDate = mCalendarCache1;
    paramDate.setTime(localDate2);
    int i = paramDate.get(13);
    int j = paramDate.get(12);
    int k = paramDate.get(11);
    paramDate.get(5);
    paramDate.get(2);
    int m = paramDate.get(1);
    paramDate = mCalendarCache2;
    paramDate.setTime(localDate1);
    int n = paramDate.get(13);
    int i1 = paramDate.get(12);
    int i2 = paramDate.get(11);
    int i3 = paramDate.get(5);
    int i4 = paramDate.get(2) + 1;
    int i5 = paramDate.get(1);
    long l1 = localDate2.getTime() - localDate1.getTime();
    if (l1 < 0L)
    {
      if (-l1 < 60000L) {
        return -l1 / 1000L + "秒后";
      }
      if (-l1 < 3600000L) {
        return -l1 / 60000L + "分钟后";
      }
    }
    else
    {
      if (l1 < 60000L) {
        return "刚刚";
      }
      if (l1 < 3600000L) {
        return l1 / 60000L + "分钟前";
      }
    }
    long l2 = l1 / 1000L - ((k * 60 + j) * 60 + i - ((i2 * 60 + i1) * 60 + n));
    if (l1 >= 0L)
    {
      if (l2 < 1L) {
        return fillZero(i2) + ":" + fillZero(i1);
      }
      if (l2 < 86401L) {
        return "昨天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (l2 < 172801L) {
        return "前天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 == m) {
        return i4 + "月" + i3 + "日";
      }
    }
    else
    {
      if (-l2 < 1L) {
        return fillZero(i2) + ":" + fillZero(i1);
      }
      if (-l2 < 86401L) {
        return "明天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (-l2 < 172801L) {
        return "后天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 == m) {
        return i4 + "月" + i3 + "日";
      }
    }
    return i5 + "/" + i4 + "/" + i3;
  }
  
  public static String shortDateNameWithExactTime(Date paramDate)
  {
    Date localDate2 = new Date();
    Date localDate1 = paramDate;
    if (paramDate == null) {
      localDate1 = localDate2;
    }
    paramDate = mCalendarCache1;
    paramDate.setTime(localDate2);
    int i = paramDate.get(13);
    int j = paramDate.get(12);
    int k = paramDate.get(11);
    paramDate.get(5);
    paramDate.get(2);
    int m = paramDate.get(1);
    paramDate = mCalendarCache2;
    paramDate.setTime(localDate1);
    int n = paramDate.get(13);
    int i1 = paramDate.get(12);
    int i2 = paramDate.get(11);
    int i3 = paramDate.get(5);
    int i4 = paramDate.get(2) + 1;
    int i5 = paramDate.get(1);
    long l1 = localDate2.getTime() - localDate1.getTime();
    long l2 = l1 / 1000L - ((k * 60 + j) * 60 + i - ((i2 * 60 + i1) * 60 + n));
    if (l1 >= 0L)
    {
      if (l2 < 1L) {
        return fillZero(i2) + ":" + fillZero(i1);
      }
      if (l2 < 86401L) {
        return "昨天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (l2 < 172801L) {
        return "前天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 == m) {
        return i4 + "月" + i3 + "日";
      }
    }
    else
    {
      if (-l2 < 1L) {
        return fillZero(i2) + ":" + fillZero(i1);
      }
      if (-l2 < 86401L) {
        return "明天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (-l2 < 172801L) {
        return "后天 " + fillZero(i2) + ":" + fillZero(i1);
      }
      if (i5 == m) {
        return i4 + "月" + i3 + "日";
      }
    }
    return i5 + "/" + i4 + "/" + i3;
  }
  
  public boolean isNowNight()
  {
    int i = Calendar.getInstance().get(11);
    return (i >= 22) || (i <= 7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.dateextension.DateExtension
 * JD-Core Version:    0.7.0.1
 */