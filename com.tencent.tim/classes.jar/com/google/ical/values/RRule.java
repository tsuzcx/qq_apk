package com.google.ical.values;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RRule
  extends AbstractIcalObject
{
  private static final int[] NO_INTS = new int[0];
  private List<WeekdayNum> byDay = new ArrayList();
  private int[] byHour = NO_INTS;
  private int[] byMinute = NO_INTS;
  private int[] byMonth = NO_INTS;
  private int[] byMonthDay = NO_INTS;
  private int[] bySecond = NO_INTS;
  private int[] bySetPos = NO_INTS;
  private int[] byWeekNo = NO_INTS;
  private int[] byYearDay = NO_INTS;
  private int count;
  private Frequency freq;
  private int interval;
  private DateValue until;
  private Weekday wkst;
  
  public RRule()
  {
    this.freq = Frequency.DAILY;
    setName("RRULE");
  }
  
  public RRule(String paramString)
    throws ParseException
  {
    parse(VcalRewriter.rewriteRule(paramString), RRuleSchema.instance());
  }
  
  private static void writeIntList(int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      if (i != 0) {
        paramStringBuilder.append(',');
      }
      paramStringBuilder.append(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  public int approximateIntervalInDays()
  {
    int i = 0;
    int m = 1;
    int j;
    switch (1.$SwitchMap$com$google$ical$values$Frequency[this.freq.ordinal()])
    {
    default: 
      j = 0;
      if (i == 0) {
        i = m;
      }
      break;
    }
    for (;;)
    {
      return j / i * this.interval;
      j = 1;
      break;
      int k = 7;
      j = k;
      if (this.byDay.isEmpty()) {
        break;
      }
      i = this.byDay.size();
      j = k;
      break;
      Iterator localIterator;
      if (!this.byDay.isEmpty())
      {
        localIterator = this.byDay.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (((WeekdayNum)localIterator.next()).num != 0) {}
          for (j = 1;; j = 4)
          {
            i = j + i;
            break;
          }
        }
        j = 30;
        break;
      }
      i = this.byMonthDay.length;
      j = 30;
      break;
      j = 12;
      if (this.byMonth.length != 0) {
        j = this.byMonth.length;
      }
      if (!this.byDay.isEmpty())
      {
        localIterator = this.byDay.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          if (((WeekdayNum)localIterator.next()).num != 0) {}
          for (k = 1;; k = 4)
          {
            i = k * j + i;
            break;
          }
        }
        j = 365;
        break;
      }
      if (this.byMonthDay.length != 0)
      {
        i = 0 + j * this.byMonthDay.length;
        j = 365;
        break;
      }
      i = 0 + this.byYearDay.length;
      j = 365;
      break;
    }
  }
  
  public List<WeekdayNum> getByDay()
  {
    return this.byDay;
  }
  
  public int[] getByHour()
  {
    return this.byHour;
  }
  
  public int[] getByMinute()
  {
    return this.byMinute;
  }
  
  public int[] getByMonth()
  {
    return this.byMonth;
  }
  
  public int[] getByMonthDay()
  {
    return this.byMonthDay;
  }
  
  public int[] getBySecond()
  {
    return this.bySecond;
  }
  
  public int[] getBySetPos()
  {
    return this.bySetPos;
  }
  
  public int[] getByWeekNo()
  {
    return this.byWeekNo;
  }
  
  public int[] getByYearDay()
  {
    return this.byYearDay;
  }
  
  public int getCount()
  {
    return this.count;
  }
  
  public Frequency getFreq()
  {
    return this.freq;
  }
  
  public int getInterval()
  {
    return this.interval;
  }
  
  public DateValue getUntil()
  {
    return this.until;
  }
  
  public Weekday getWkSt()
  {
    return this.wkst;
  }
  
  public void setByDay(List<WeekdayNum> paramList)
  {
    this.byDay = new ArrayList(paramList);
  }
  
  public void setByHour(int[] paramArrayOfInt)
  {
    this.byHour = ((int[])paramArrayOfInt.clone());
  }
  
  public void setByMinute(int[] paramArrayOfInt)
  {
    this.byMinute = ((int[])paramArrayOfInt.clone());
  }
  
  public void setByMonth(int[] paramArrayOfInt)
  {
    this.byMonth = ((int[])paramArrayOfInt.clone());
  }
  
  public void setByMonthDay(int[] paramArrayOfInt)
  {
    this.byMonthDay = ((int[])paramArrayOfInt.clone());
  }
  
  public void setBySecond(int[] paramArrayOfInt)
  {
    this.bySecond = ((int[])paramArrayOfInt.clone());
  }
  
  public void setBySetPos(int[] paramArrayOfInt)
  {
    this.bySetPos = ((int[])paramArrayOfInt.clone());
  }
  
  public void setByWeekNo(int[] paramArrayOfInt)
  {
    this.byWeekNo = ((int[])paramArrayOfInt.clone());
  }
  
  public void setByYearDay(int[] paramArrayOfInt)
  {
    this.byYearDay = ((int[])paramArrayOfInt.clone());
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setFreq(Frequency paramFrequency)
  {
    this.freq = paramFrequency;
  }
  
  public void setInterval(int paramInt)
  {
    this.interval = paramInt;
  }
  
  public void setUntil(DateValue paramDateValue)
  {
    this.until = paramDateValue;
  }
  
  public void setWkSt(Weekday paramWeekday)
  {
    this.wkst = paramWeekday;
  }
  
  public String toIcal()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    Object localObject1;
    Object localObject2;
    if (hasExtParams())
    {
      Iterator localIterator = getExtParams().entrySet().iterator();
      while (localIterator.hasNext())
      {
        localObject1 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject1).getKey();
        localObject2 = (String)((Map.Entry)localObject1).getValue();
        localObject1 = localObject2;
        if (ICAL_SPECIALS.matcher((CharSequence)localObject2).find()) {
          localObject1 = "\"" + (String)localObject2 + "\"";
        }
        localStringBuilder.append(';').append(str).append('=').append((String)localObject1);
      }
    }
    localStringBuilder.append(":FREQ=").append(this.freq);
    if (this.wkst != null) {
      localStringBuilder.append(";WKST=").append(this.wkst.toString());
    }
    if (this.until != null)
    {
      localStringBuilder.append(";UNTIL=").append(this.until);
      if ((this.until instanceof TimeValue)) {
        localStringBuilder.append('Z');
      }
    }
    if (this.count != 0) {
      localStringBuilder.append(";COUNT=").append(this.count);
    }
    if (this.interval != 0) {
      localStringBuilder.append(";INTERVAL=").append(this.interval);
    }
    if (this.byYearDay.length != 0)
    {
      localStringBuilder.append(";BYYEARDAY=");
      writeIntList(this.byYearDay, localStringBuilder);
    }
    if (this.byMonth.length != 0)
    {
      localStringBuilder.append(";BYMONTH=");
      writeIntList(this.byMonth, localStringBuilder);
    }
    if (this.byMonthDay.length != 0)
    {
      localStringBuilder.append(";BYMONTHDAY=");
      writeIntList(this.byMonthDay, localStringBuilder);
    }
    if (this.byWeekNo.length != 0)
    {
      localStringBuilder.append(";BYWEEKNO=");
      writeIntList(this.byWeekNo, localStringBuilder);
    }
    if (!this.byDay.isEmpty())
    {
      localStringBuilder.append(";BYDAY=");
      localObject1 = this.byDay.iterator();
      int i = 1;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeekdayNum)((Iterator)localObject1).next();
        if (i == 0) {
          localStringBuilder.append(',');
        }
        for (;;)
        {
          localStringBuilder.append(localObject2);
          break;
          i = 0;
        }
      }
    }
    if (this.byHour.length != 0)
    {
      localStringBuilder.append(";BYHOUR=");
      writeIntList(this.byHour, localStringBuilder);
    }
    if (this.byMinute.length != 0)
    {
      localStringBuilder.append(";BYMINUTE=");
      writeIntList(this.byMinute, localStringBuilder);
    }
    if (this.bySecond.length != 0)
    {
      localStringBuilder.append(";BYSECOND=");
      writeIntList(this.bySecond, localStringBuilder);
    }
    if (this.bySetPos.length != 0)
    {
      localStringBuilder.append(";BYSETPOS=");
      writeIntList(this.bySetPos, localStringBuilder);
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.values.RRule
 * JD-Core Version:    0.7.0.1
 */