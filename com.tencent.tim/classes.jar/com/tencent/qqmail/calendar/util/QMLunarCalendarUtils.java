package com.tencent.qqmail.calendar.util;

import android.util.Log;
import com.tencent.qqmail.calendar.data.QMLunarCalendar;
import com.tencent.qqmail.calendar.data.QMSimpleDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;

public class QMLunarCalendarUtils
{
  private static final String TheWinterSolstice = "冬至";
  private static final long baseTime;
  public static final SimpleDateFormat chineseDateFormat;
  static final String[] chineseDays;
  static final String[] chineseMonths;
  private static final String chineseNewYearEve = "除夕";
  static final String[] chineseNumber = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二" };
  static final String[] chineseYears;
  private static final String fatherFestival = "父亲节";
  private static final String leapString = "闰";
  private static final HashMap<Integer, String> lunarHolidayHashMap = new QMLunarCalendarUtils.1();
  static final long[] lunarInfo;
  private static final int maxYearOfLunarCalendar = 2049;
  private static final int maxYearOfSolarCalendar = 2050;
  private static final int minYearOfLunarCalendar = 1898;
  private static final int minYearOfSolarCalendar = 1898;
  private static final String motherFestival = "母亲节";
  private static final String qingmingFestival = "清明节";
  private static final HashMap<Integer, String> solarHolidayHashMap = new QMLunarCalendarUtils.2();
  static final String[] solarTermStrings;
  static final int[] solarTerms;
  private static final int solorDaysOfLeapYear = 366;
  private static final int solorDaysOfNotLeapYear = 365;
  private static final String thanksgivingDay = "感恩节";
  static final int[] totalDaysOfMonth;
  
  static
  {
    chineseDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    baseTime = new GregorianCalendar(1900, 0, 31).getTime().getTime();
    chineseYears = new String[] { "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌", "乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛己", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰", "癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸丑", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌", "辛亥", "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥" };
    chineseMonths = new String[] { "正月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "冬月", "腊月" };
    chineseDays = new String[] { "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十", "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十" };
    totalDaysOfMonth = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };
    solarTerms = new int[] { 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 119, 137, 137, 137, 153, 136, 136, 102, 85, 119, 102, 119, 119, 137, 153, 153, 153, 136, 136, 118, 85, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 119, 102, 119, 119, 137, 153, 153, 153, 136, 136, 118, 85, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 119, 102, 119, 119, 137, 153, 153, 153, 136, 136, 118, 85, 102, 85, 102, 103, 120, 136, 136, 153, 135, 119, 101, 68, 102, 86, 103, 103, 136, 137, 136, 153, 136, 135, 102, 68, 102, 86, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 103, 102, 103, 119, 137, 137, 153, 153, 136, 136, 102, 85, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 86, 102, 103, 136, 137, 136, 153, 136, 135, 102, 68, 102, 86, 103, 103, 137, 137, 137, 153, 136, 135, 102, 85, 103, 102, 103, 119, 137, 137, 153, 153, 136, 136, 102, 85, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 136, 137, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 137, 137, 137, 153, 136, 135, 102, 85, 102, 102, 103, 119, 137, 137, 153, 153, 136, 136, 102, 85, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 136, 137, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 119, 137, 137, 153, 153, 136, 136, 102, 85, 102, 85, 102, 103, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 119, 137, 137, 137, 153, 136, 136, 102, 85, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 102, 102, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 102, 85, 86, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 86, 103, 103, 136, 137, 136, 153, 136, 135, 102, 68, 102, 86, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 86, 85, 86, 102, 120, 120, 136, 136, 119, 119, 85, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 136, 137, 136, 153, 136, 135, 102, 68, 102, 86, 103, 103, 137, 137, 137, 153, 136, 136, 102, 85, 86, 85, 86, 102, 120, 120, 136, 136, 119, 119, 85, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 136, 137, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 85, 85, 85, 86, 102, 120, 120, 136, 136, 119, 119, 85, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 85, 85, 86, 102, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 85, 85, 86, 102, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 137, 153, 136, 135, 102, 84, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 102, 86, 103, 103, 136, 137, 136, 153, 136, 135, 102, 84, 85, 69, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 137, 136, 119, 102, 68, 102, 86, 102, 103, 136, 137, 136, 153, 136, 135, 102, 84, 85, 69, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 136, 137, 136, 153, 136, 135, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 119, 85, 68, 86, 85, 86, 102, 120, 120, 136, 136, 119, 119, 85, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 120, 137, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 68, 85, 85, 86, 102, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 137, 135, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 102, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 153, 136, 119, 102, 68, 85, 69, 86, 86, 119, 120, 119, 136, 119, 118, 85, 67, 85, 69, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 137, 136, 119, 102, 68, 85, 69, 85, 86, 119, 120, 119, 136, 119, 118, 85, 67, 85, 69, 86, 86, 119, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 102, 85, 102, 103, 120, 136, 136, 137, 135, 119, 101, 68, 85, 68, 85, 86, 119, 120, 119, 136, 119, 118, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 119, 85, 68, 86, 85, 86, 102, 120, 120, 136, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 137, 135, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 118, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 68, 85, 85, 86, 102, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 137, 135, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 102, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 102, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 102, 102, 120, 136, 136, 136, 119, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 102, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 102, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 118, 85, 67, 85, 85, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 136, 119, 102, 85, 51, 85, 69, 85, 86, 119, 120, 119, 136, 119, 118, 85, 67, 85, 69, 86, 86, 120, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 85, 68, 85, 86, 103, 119, 119, 120, 119, 102, 85, 51, 85, 68, 85, 86, 119, 120, 119, 136, 119, 118, 85, 67, 85, 69, 86, 86, 119, 120, 120, 136, 119, 119, 85, 68, 102, 85, 86, 102, 120, 120, 136, 136, 119, 119, 101, 68, 85, 68, 85, 85, 103, 119, 119, 120, 118, 102, 84, 51, 85, 68, 85, 86, 103, 119, 119, 136, 119, 118, 85, 51, 85, 69, 86, 86, 119, 120, 120, 136, 119, 119 };
    solarTermStrings = new String[] { "小寒", "大寒", "立春", "雨水", "惊蛰", "春分", "清明", "谷雨", "立夏", "小满", "芒种", "夏至", "小暑", "大暑", "立秋", "处暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至" };
    lunarInfo = new long[] { 47779L, 43856L, 19416L, 19168L, 42352L, 21717L, 53856L, 55632L, 91476L, 22176L, 39632L, 21970L, 19168L, 42422L, 42192L, 53840L, 119381L, 46400L, 54944L, 44450L, 38320L, 84343L, 18800L, 42160L, 46261L, 27216L, 27968L, 109396L, 11104L, 38256L, 21234L, 18800L, 25958L, 54432L, 59984L, 28309L, 23248L, 11104L, 100067L, 37600L, 116951L, 51536L, 54432L, 120998L, 46416L, 22176L, 107956L, 9680L, 37584L, 53938L, 43344L, 46423L, 27808L, 46416L, 86869L, 19872L, 42448L, 83315L, 21200L, 43432L, 59728L, 27296L, 44710L, 43856L, 19296L, 43748L, 42352L, 21088L, 62051L, 55632L, 23383L, 22176L, 38608L, 19925L, 19152L, 42192L, 54484L, 53840L, 54616L, 46400L, 46496L, 103846L, 38320L, 18864L, 43380L, 42160L, 45690L, 27216L, 27968L, 44870L, 43872L, 38256L, 19189L, 18800L, 25776L, 29859L, 59984L, 27480L, 21952L, 43872L, 38613L, 37600L, 51552L, 55636L, 54432L, 55888L, 30034L, 22176L, 43959L, 9680L, 37584L, 51893L, 43344L, 46240L, 47780L, 44368L, 21977L, 19360L, 42416L, 86390L, 21168L, 43312L, 31060L, 27296L, 44368L, 23378L, 19296L, 42726L, 42208L, 53856L, 60005L, 54576L, 23200L, 30371L, 38608L, 19415L, 19152L, 42192L, 118966L, 53840L, 54560L, 56645L, 46496L, 22224L, 21938L, 18864L, 42359L, 42160L, 43600L, 111189L, 27936L, 44448L, 84835L };
  }
  
  private static final String animalsYear(int paramInt)
  {
    return new String[] { "鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪" }[((paramInt - 4) % 12)];
  }
  
  public static final void correctTheDate(QMSimpleDate paramQMSimpleDate, boolean paramBoolean)
  {
    int k = 12;
    int j = 1899;
    int i;
    int i1;
    int n;
    int m;
    if (paramBoolean)
    {
      i = 2050;
      i1 = paramQMSimpleDate.getYear();
      n = paramQMSimpleDate.getMonth();
      m = paramQMSimpleDate.getDay();
      if (i1 >= 1899) {
        break label90;
      }
    }
    for (;;)
    {
      label42:
      if (n > 12) {}
      for (;;)
      {
        label49:
        if (paramBoolean)
        {
          i = solarMonthDays(j, k);
          label60:
          if (m <= i) {
            break label149;
          }
        }
        for (;;)
        {
          paramQMSimpleDate.setYear(j);
          paramQMSimpleDate.setMonth(k);
          paramQMSimpleDate.setDay(i);
          return;
          i = 2049;
          break;
          label90:
          if (i1 <= i) {
            break label172;
          }
          j = i;
          break label42;
          if (n >= 1) {
            break label165;
          }
          k = 1;
          break label49;
          if ((leapMonth(j) == k) && (leapMonthDays(j) == m))
          {
            i = leapMonthDays(j);
            break label60;
          }
          i = monthDays(j, k);
          break label60;
          label149:
          if (m == 0) {
            i = 1;
          } else {
            i = m;
          }
        }
        label165:
        k = n;
      }
      label172:
      j = i1;
    }
  }
  
  public static final String cyclical(int paramInt)
  {
    return cyclicalm(paramInt - 1898 + 36);
  }
  
  private static final String cyclicalm(int paramInt)
  {
    return new String[] { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" }[(paramInt % 10)] + new String[] { "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" }[(paramInt % 12)];
  }
  
  public static final String getChinaDayString(int paramInt)
  {
    if (paramInt % 10 == 0) {}
    for (int i = 9; paramInt > 30; i = paramInt % 10 - 1) {
      return "";
    }
    if (paramInt == 10) {
      return "初十";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramInt /= 10;
    return new String[] { "初", "十", "廿", "卅" }[paramInt] + chineseNumber[i];
  }
  
  public static String getHoliday(Calendar paramCalendar)
  {
    String str2 = getLunarHoliday(paramCalendar);
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.isEmpty()) {}
    }
    else
    {
      str1 = getSolarHoliday(paramCalendar);
    }
    return str1;
  }
  
  public static QMLunarCalendar getLunarCalendar(int paramInt1, int paramInt2, int paramInt3)
  {
    QMLunarCalendar localQMLunarCalendar = new QMLunarCalendar();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramInt1).append("年").append(paramInt2).append("月").append(paramInt3).append("日");
    Object localObject1 = null;
    try
    {
      localObject2 = chineseDateFormat.parse(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
    }
    catch (ParseException localParseException)
    {
      for (;;)
      {
        localParseException.printStackTrace();
      }
      j = paramInt2;
      paramInt1 = paramInt3;
      if (paramInt3 >= 0) {
        break label147;
      }
      paramInt1 = paramInt3 + i;
      j = paramInt2 - 1;
      int m = leapMonth(j);
      k = 0;
      paramInt3 = 0;
      i = 1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if ((paramInt1 >= 13) || (paramInt2 <= 0)) {
        break label264;
      }
      if ((m <= 0) || (paramInt1 != m + 1) || (paramInt3 != 0)) {
        break label249;
      }
      i = leapDays(j);
      k = paramInt1 - 1;
      paramInt3 = 1;
      for (paramInt1 = i;; paramInt1 = i)
      {
        i = paramInt3;
        if (paramInt3 != 0)
        {
          i = paramInt3;
          if (k == m + 1) {
            i = 0;
          }
        }
        paramInt3 = paramInt1;
        k += 1;
        paramInt2 -= paramInt1;
        paramInt1 = k;
        k = paramInt3;
        paramInt3 = i;
        break;
        i = monthDays(j, paramInt1);
        k = paramInt1;
      }
      i = paramInt1;
      if (paramInt2 != 0) {
        break label293;
      }
      i = paramInt1;
      if (m <= 0) {
        break label293;
      }
      i = paramInt1;
      if (paramInt1 != m + 1) {
        break label293;
      }
      if (paramInt3 == 0) {
        break label330;
      }
      i = paramInt1;
    }
    paramInt3 = (int)((localObject1.getTime() - baseTime) / 86400000L);
    paramInt2 = 1900;
    int i = 0;
    while ((paramInt2 < 10000) && (paramInt3 > 0))
    {
      i = yearDays(paramInt2);
      paramInt3 -= i;
      paramInt2 += 1;
    }
    int j;
    label147:
    int k;
    label249:
    if (paramInt2 < 0)
    {
      paramInt1 = paramInt2 + k;
      i -= 1;
    }
    for (;;)
    {
      label264:
      label293:
      localQMLunarCalendar.setYear(j);
      localQMLunarCalendar.setMonth(i);
      localQMLunarCalendar.setDay(paramInt1 + 1);
      return localQMLunarCalendar;
      label330:
      i = paramInt1 - 1;
      break;
      paramInt1 = paramInt2;
    }
  }
  
  public static QMLunarCalendar getLunarCalendarDate(int paramInt1, int paramInt2, int paramInt3)
  {
    int[] arrayOfInt = new int[7];
    Object localObject = new QMSimpleDate(paramInt1, paramInt2, paramInt3);
    correctTheDate((QMSimpleDate)localObject, true);
    int i = ((QMSimpleDate)localObject).getYear();
    int j = ((QMSimpleDate)localObject).getMonth();
    paramInt3 = ((QMSimpleDate)localObject).getDay();
    paramInt2 = DayOffsetUtil.getSolarDayOffsetOfYear(i - 1) + totalDaysOfMonth[(j - 1)];
    paramInt1 = paramInt2;
    if (j > 2)
    {
      paramInt1 = paramInt2;
      if (isSolarLeapYear(i)) {
        paramInt1 = paramInt2 + 1;
      }
    }
    paramInt2 = paramInt1 - 21 + (paramInt3 - 1);
    arrayOfInt[5] = (paramInt2 + 21);
    arrayOfInt[4] = 14;
    paramInt1 = DayOffsetUtil.getLunarYearByOffsetDays(paramInt2);
    arrayOfInt[4] = ((paramInt1 - 1898) * 12 + 14);
    paramInt2 -= DayOffsetUtil.getLunarDayOffsetOfYear(paramInt1 - 1);
    arrayOfInt[0] = paramInt1;
    arrayOfInt[3] = (paramInt1 - 1864);
    j = leapMonth(paramInt1);
    arrayOfInt[6] = 0;
    i = 0;
    paramInt1 = 1;
    if ((paramInt1 < 13) && (paramInt2 > 0))
    {
      if ((j > 0) && (paramInt1 == j + 1) && (arrayOfInt[6] == 0))
      {
        paramInt1 -= 1;
        arrayOfInt[6] = 1;
      }
      for (paramInt3 = leapDays(arrayOfInt[0]);; paramInt3 = monthDays(arrayOfInt[0], paramInt1))
      {
        if ((arrayOfInt[6] == 1) && (paramInt1 == j + 1)) {
          arrayOfInt[6] = 0;
        }
        paramInt2 -= paramInt3;
        if (arrayOfInt[6] == 0) {
          arrayOfInt[4] += 1;
        }
        paramInt1 += 1;
        i = paramInt3;
        break;
      }
    }
    paramInt3 = paramInt1;
    if (paramInt2 == 0)
    {
      paramInt3 = paramInt1;
      if (j > 0)
      {
        paramInt3 = paramInt1;
        if (paramInt1 == j + 1)
        {
          if (arrayOfInt[6] != 1) {
            break label409;
          }
          arrayOfInt[6] = 0;
          paramInt3 = paramInt1;
        }
      }
    }
    if (paramInt2 < 0)
    {
      paramInt1 = i + paramInt2;
      paramInt3 -= 1;
      arrayOfInt[4] -= 1;
    }
    for (;;)
    {
      arrayOfInt[1] = paramInt3;
      arrayOfInt[2] = (paramInt1 + 1);
      localObject = new QMLunarCalendar();
      ((QMLunarCalendar)localObject).setYear(arrayOfInt[0]);
      ((QMLunarCalendar)localObject).setMonth(arrayOfInt[1]);
      ((QMLunarCalendar)localObject).setDay(arrayOfInt[2]);
      if (arrayOfInt[6] == 1) {}
      for (boolean bool = true;; bool = false)
      {
        ((QMLunarCalendar)localObject).setIsLeapMonth(bool);
        return localObject;
        label409:
        arrayOfInt[6] = 1;
        paramInt3 = paramInt1 - 1;
        arrayOfInt[4] -= 1;
        break;
      }
      paramInt1 = paramInt2;
    }
  }
  
  public static String getLunarDate(long paramLong, boolean paramBoolean)
  {
    Object localObject = new GregorianCalendar();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    QMLunarCalendar localQMLunarCalendar = getLunarCalendarDate(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean) {
      localStringBuilder.append(chineseYears[((localQMLunarCalendar.getYear() - 1898 + 34) % 60)]).append("年");
    }
    if (localQMLunarCalendar.isLeapMonth()) {}
    for (localObject = "闰";; localObject = "")
    {
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(chineseMonths[(localQMLunarCalendar.getMonth() - 1)]);
      localStringBuilder.append(chineseDays[(localQMLunarCalendar.getDay() - 1)]);
      return localStringBuilder.toString();
    }
  }
  
  public static String getLunarDateForMonthView(long paramLong)
  {
    Object localObject1 = new GregorianCalendar();
    ((Calendar)localObject1).setTimeInMillis(paramLong);
    localObject1 = getLunarCalendarDate(((Calendar)localObject1).get(1), ((Calendar)localObject1).get(2) + 1, ((Calendar)localObject1).get(5));
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = new GregorianCalendar();
    ((GregorianCalendar)localObject2).setTimeInMillis(paramLong);
    localObject2 = getHoliday((Calendar)localObject2);
    if (!StringUtils.isEmpty((CharSequence)localObject2)) {
      localStringBuilder.append((String)localObject2);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      if (((QMLunarCalendar)localObject1).getDay() - 1 == 0) {
        localStringBuilder.append(chineseMonths[(localObject1.getMonth() - 1)]);
      } else {
        localStringBuilder.append(chineseDays[(localObject1.getDay() - 1)]);
      }
    }
  }
  
  public static String getLunarHoliday(Calendar paramCalendar)
  {
    Object localObject = getLunarCalendarDate(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
    int i = ((QMLunarCalendar)localObject).getMonth();
    int j = ((QMLunarCalendar)localObject).getDay();
    localObject = (String)lunarHolidayHashMap.get(Integer.valueOf(j + i * 100));
    if (localObject != null) {
      return localObject;
    }
    paramCalendar = getSolarTerm(paramCalendar.get(1), paramCalendar.get(2) + 1, paramCalendar.get(5));
    if (paramCalendar != null)
    {
      if ("冬至".equals(paramCalendar)) {
        return "冬至";
      }
      if ("清明节".contains(paramCalendar)) {
        return "清明节";
      }
    }
    return "";
  }
  
  public static QMLunarCalendar getLunarInfo(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    QMLunarCalendar localQMLunarCalendar = getLunarCalendarDate(paramInt1, paramInt2, paramInt3);
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).set(paramInt1, paramInt2, paramInt3);
    int i = ((Calendar)localObject).get(8);
    int j = localQMLunarCalendar.getYear();
    int k = localQMLunarCalendar.getMonth();
    int m = localQMLunarCalendar.getDay();
    if (StringUtils.isBlank(localQMLunarCalendar.getLunarString()))
    {
      localObject = (String)solarHolidayHashMap.get(Integer.valueOf(paramInt2 * 100 + paramInt3));
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        localQMLunarCalendar.setLunarString((String)localObject);
      }
    }
    else
    {
      if ((StringUtils.isBlank(localQMLunarCalendar.getLunarString())) && (!localQMLunarCalendar.isLeapMonth()))
      {
        localObject = (String)lunarHolidayHashMap.get(Integer.valueOf(k * 100 + m));
        if (StringUtils.isBlank((CharSequence)localObject)) {
          break label342;
        }
        localQMLunarCalendar.setLunarString((String)localObject);
      }
      label158:
      localObject = getSolarTerm(paramInt1, paramInt2, paramInt3);
      if ((StringUtils.isBlank(localQMLunarCalendar.getLunarString())) && (localObject != null))
      {
        if (!((String)localObject).equals("冬至")) {
          break label378;
        }
        localQMLunarCalendar.setLunarString((String)localObject);
      }
    }
    for (;;)
    {
      if (StringUtils.isBlank(localQMLunarCalendar.getLunarString()))
      {
        if (m != 1) {
          break label398;
        }
        localObject = new StringBuilder();
        if (localQMLunarCalendar.isLeapMonth()) {
          ((StringBuilder)localObject).append("闰");
        }
        ((StringBuilder)localObject).append(chineseMonths[(k - 1)]);
        localQMLunarCalendar.setLunarString(((StringBuilder)localObject).toString());
      }
      return localQMLunarCalendar;
      if (paramInt4 == 0)
      {
        if ((paramInt2 == 5) && (i == 2))
        {
          localQMLunarCalendar.setLunarString("母亲节");
          break;
        }
        if ((paramInt2 != 6) || (i != 3)) {
          break;
        }
        localQMLunarCalendar.setLunarString("父亲节");
        break;
      }
      if ((paramInt4 != 4) || (paramInt2 != 11) || (i != 4)) {
        break;
      }
      localQMLunarCalendar.setLunarString("感恩节");
      break;
      label342:
      if ((k != 12) || (m != 29) || (monthDays(j, k) != 29)) {
        break label158;
      }
      localQMLunarCalendar.setLunarString("除夕");
      break label158;
      label378:
      if ("清明节".contains((CharSequence)localObject)) {
        localQMLunarCalendar.setLunarString("清明节");
      }
    }
    label398:
    localQMLunarCalendar.setLunarString(chineseDays[(m - 1)]);
    return localQMLunarCalendar;
  }
  
  public static String getSolarHoliday(Calendar paramCalendar)
  {
    int i = paramCalendar.get(7);
    int j = paramCalendar.get(2) + 1;
    int k = paramCalendar.get(5);
    int m = paramCalendar.get(4);
    Log.i("getSolarHoliday", "dayOfWeek = " + i);
    if (i == 1)
    {
      if ((j == 5) && (m == 2))
      {
        Log.i("getSolarHoliday", "motherFestival");
        return "母亲节";
      }
      if ((j == 6) && (m == 3))
      {
        Log.i("getSolarHoliday", "fatherFestival");
        return "父亲节";
      }
    }
    else if ((i == 5) && (j == 11) && (k / 7 + 1 == 4))
    {
      return "感恩节";
    }
    i = j * 100 + k;
    if (solarHolidayHashMap.get(Integer.valueOf(i)) == null) {
      return "";
    }
    return (String)solarHolidayHashMap.get(Integer.valueOf(i));
  }
  
  public static final String getSolarTerm(int paramInt1, int paramInt2, int paramInt3)
  {
    int k = 0;
    Object localObject2 = null;
    int i;
    int j;
    label25:
    Object localObject1;
    if (paramInt1 >= 1901)
    {
      i = 1;
      if (paramInt1 > 2050) {
        break label94;
      }
      j = 1;
      localObject1 = localObject2;
      if ((j & i) != 0)
      {
        paramInt1 = solarTerms[((paramInt1 - 1901) * 12 + (paramInt2 - 1))];
        if (paramInt1 / 16 != paramInt3) {
          break label100;
        }
        paramInt1 = k;
      }
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramInt1 > -1) {
        localObject1 = solarTermStrings[(paramInt1 + (paramInt2 - 1) * 2)];
      }
      return localObject1;
      i = 0;
      break;
      label94:
      j = 0;
      break label25;
      label100:
      if (paramInt1 % 16 + 15 == paramInt3) {
        paramInt1 = 1;
      } else {
        paramInt1 = -1;
      }
    }
  }
  
  private static final boolean isLeapMonth(int paramInt1, int paramInt2)
  {
    return leapMonth(paramInt1) == paramInt2;
  }
  
  public static final boolean isSolarLeapYear(int paramInt)
  {
    return ((paramInt % 4 == 0) && (paramInt % 100 != 0)) || (paramInt % 400 == 0);
  }
  
  private static final int leapDays(int paramInt)
  {
    if (leapMonth(paramInt) != 0)
    {
      if ((lunarInfo[(paramInt - 1898)] & 0x10000) != 0L) {
        return 30;
      }
      return 29;
    }
    return 0;
  }
  
  public static final int leapMonth(int paramInt)
  {
    return (int)(lunarInfo[(paramInt - 1898)] & 0xF);
  }
  
  public static final int leapMonthDays(int paramInt)
  {
    if ((paramInt > 2049) || (paramInt < 1898)) {}
    while (leapMonth(paramInt) == 0) {
      return 0;
    }
    if ((lunarInfo[(paramInt - 1898)] & 0x10000) == 0L) {
      return 29;
    }
    return 30;
  }
  
  public static QMSimpleDate lunarToSolar(QMLunarCalendar paramQMLunarCalendar)
  {
    int j = 21;
    boolean bool = paramQMLunarCalendar.isLeapMonth();
    paramQMLunarCalendar = new QMSimpleDate(paramQMLunarCalendar.getYear(), paramQMLunarCalendar.getMonth(), paramQMLunarCalendar.getDay());
    correctTheDate(paramQMLunarCalendar, false);
    int i3 = paramQMLunarCalendar.getYear();
    int n = paramQMLunarCalendar.getMonth();
    int i1 = paramQMLunarCalendar.getDay();
    int m = leapMonth(i3);
    if (m != n) {
      bool = false;
    }
    int k = 1898;
    while (k < i3)
    {
      j += yearDays(k);
      k += 1;
    }
    int i = j;
    if (m > 0)
    {
      i = j;
      if (m < n) {
        i = j + leapMonthDays(i3);
      }
    }
    m = n;
    if (bool) {
      m = n + 1;
    }
    n = 1;
    int i2 = 32768;
    j = i;
    i = i2;
    while (n < m)
    {
      j += monthDays(i3, n);
      n += 1;
      i >>= 1;
    }
    if (bool)
    {
      i = leapMonthDays(i3);
      if (i1 <= i) {
        break label419;
      }
    }
    for (;;)
    {
      m = j + i;
      j = 0;
      i = 1898;
      label203:
      k = j;
      if (i <= i3)
      {
        if (isSolarLeapYear(i))
        {
          k = 366;
          label222:
          k += j;
          if (m - k >= 0) {
            break label397;
          }
          if (!isSolarLeapYear(i)) {
            break label390;
          }
          j = 366;
          label244:
          k -= j;
        }
      }
      else
      {
        k = m - k;
        j = 1;
        label255:
        if ((j < 13) && (k - totalDaysOfMonth[j] >= 0)) {
          break label406;
        }
        m = k - totalDaysOfMonth[(j - 1)];
        k = m;
        if (j > 2)
        {
          k = m;
          if (isSolarLeapYear(i)) {
            k = m - 1;
          }
        }
        if (k != 0) {
          break label413;
        }
        m = j - 1;
        j = m;
        k = i;
        if (m == 0)
        {
          j = 12;
          k = i - 1;
        }
        i = solarMonthDays(k, j);
        m = k;
        k = i;
      }
      for (;;)
      {
        return new QMSimpleDate(m, j, k);
        if ((lunarInfo[(k - 1898)] & i) != 0L)
        {
          i = 30;
          break;
        }
        i = 29;
        break;
        k = 365;
        break label222;
        label390:
        j = 365;
        break label244;
        label397:
        i += 1;
        j = k;
        break label203;
        label406:
        j += 1;
        break label255;
        label413:
        m = i;
      }
      label419:
      i = i1;
    }
  }
  
  public static final int monthDays(int paramInt1, int paramInt2)
  {
    if ((lunarInfo[(paramInt1 - 1898)] & 65536 >> paramInt2) == 0L) {
      return 29;
    }
    return 30;
  }
  
  private static final int solarMonthDays(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return 0;
    case 2: 
      if ((paramInt2 == 2) && (isSolarLeapYear(paramInt1))) {
        return 29;
      }
      return 28;
    case 4: 
    case 6: 
    case 9: 
    case 11: 
      return 30;
    }
    return 31;
  }
  
  private static final int yearDays(int paramInt)
  {
    int j = 348;
    int i = 32768;
    while (i > 8)
    {
      int k = j;
      if ((lunarInfo[(paramInt - 1898)] & i) != 0L) {
        k = j + 1;
      }
      i >>= 1;
      j = k;
    }
    return j + leapDays(paramInt);
  }
  
  static class DayOffsetUtil
  {
    private static ArrayList<Integer> sDayOffsetOfYearLunar = new ArrayList(sEndYear - sStartYear + 1);
    private static ArrayList<Integer> sDayOffsetOfYearSolar;
    private static int sEndYear;
    private static int sStartYear = 1898;
    
    static
    {
      sEndYear = 2050;
      sDayOffsetOfYearSolar = new ArrayList(sEndYear - sStartYear + 1);
    }
    
    public static int getLunarDayOffsetOfYear(int paramInt)
    {
      if ((paramInt < sStartYear) || (paramInt > sEndYear)) {
        return 0;
      }
      if (sDayOffsetOfYearLunar.size() <= paramInt - sStartYear) {
        prepareDayOffsetOfYear();
      }
      return ((Integer)sDayOffsetOfYearLunar.get(paramInt - sStartYear)).intValue();
    }
    
    public static int getLunarYearByOffsetDays(int paramInt)
    {
      if (sDayOffsetOfYearLunar.size() <= 0) {
        prepareDayOffsetOfYear();
      }
      paramInt = Collections.binarySearch(sDayOffsetOfYearLunar, Integer.valueOf(paramInt));
      if (paramInt >= 0) {
        return paramInt + sStartYear + 1;
      }
      return sStartYear - paramInt - 1;
    }
    
    public static int getSolarDayOffsetOfYear(int paramInt)
    {
      if ((paramInt < sStartYear) || (paramInt > sEndYear)) {
        return 0;
      }
      if (sDayOffsetOfYearSolar.size() <= paramInt - sStartYear) {
        prepareDayOffsetOfYear();
      }
      return ((Integer)sDayOffsetOfYearSolar.get(paramInt - sStartYear)).intValue();
    }
    
    private static void prepareDayOffsetOfYear()
    {
      int j = 0;
      int i = sStartYear;
      int k = 0;
      if (i <= sEndYear)
      {
        if (QMLunarCalendarUtils.isSolarLeapYear(i)) {}
        for (int m = 366;; m = 365)
        {
          k += m;
          sDayOffsetOfYearSolar.add(Integer.valueOf(k));
          j += QMLunarCalendarUtils.yearDays(i);
          sDayOffsetOfYearLunar.add(Integer.valueOf(j));
          i += 1;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.util.QMLunarCalendarUtils
 * JD-Core Version:    0.7.0.1
 */