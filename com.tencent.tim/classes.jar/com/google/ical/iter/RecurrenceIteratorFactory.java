package com.google.ical.iter;

import com.google.ical.util.Predicate;
import com.google.ical.util.Predicates;
import com.google.ical.util.TimeUtils;
import com.google.ical.values.DateTimeValueImpl;
import com.google.ical.values.DateValue;
import com.google.ical.values.Frequency;
import com.google.ical.values.IcalObject;
import com.google.ical.values.RDateList;
import com.google.ical.values.RRule;
import com.google.ical.values.TimeValue;
import com.google.ical.values.Weekday;
import com.google.ical.values.WeekdayNum;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RecurrenceIteratorFactory
{
  private static final Pattern DATE;
  private static final Pattern FOLD;
  private static final Logger LOGGER;
  private static final Pattern NEWLINE;
  private static final Pattern RULE;
  
  static
  {
    if (!RecurrenceIteratorFactory.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      LOGGER = Logger.getLogger(RecurrenceIteratorFactory.class.getName());
      FOLD = Pattern.compile("(?:\\r\\n?|\\n)[ \t]");
      NEWLINE = Pattern.compile("[\\r\\n]+");
      RULE = Pattern.compile("^(?:R|EX)RULE[:;]", 2);
      DATE = Pattern.compile("^(?:R|EX)DATE[:;]", 2);
      return;
    }
  }
  
  public static RecurrenceIterable createRecurrenceIterable(String paramString, DateValue paramDateValue, TimeZone paramTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return new RecurrenceIteratorFactory.1(paramDateValue, paramTimeZone, parseContentLines(paramString, paramTimeZone, paramBoolean), paramBoolean);
  }
  
  public static RecurrenceIterator createRecurrenceIterator(RDateList paramRDateList)
  {
    paramRDateList = paramRDateList.getDatesUtc();
    Arrays.sort(paramRDateList);
    int i = 1;
    int k;
    for (int j = 0; i < paramRDateList.length; j = k)
    {
      k = j;
      if (!paramRDateList[i].equals(paramRDateList[j]))
      {
        k = j + 1;
        paramRDateList[k] = paramRDateList[i];
      }
      i += 1;
    }
    i = j + 1;
    if (i < paramRDateList.length)
    {
      DateValue[] arrayOfDateValue = new DateValue[i];
      System.arraycopy(paramRDateList, 0, arrayOfDateValue, 0, i);
      paramRDateList = arrayOfDateValue;
    }
    for (;;)
    {
      return new RDateIteratorImpl(paramRDateList);
    }
  }
  
  public static RecurrenceIterator createRecurrenceIterator(RRule paramRRule, DateValue paramDateValue, TimeZone paramTimeZone)
  {
    assert (paramTimeZone != null);
    assert (paramDateValue != null);
    Frequency localFrequency = paramRRule.getFreq();
    Object localObject4 = paramRRule.getWkSt();
    Object localObject2 = paramRRule.getUntil();
    int n = paramRRule.getCount();
    int m = paramRRule.getInterval();
    WeekdayNum[] arrayOfWeekdayNum = (WeekdayNum[])paramRRule.getByDay().toArray(new WeekdayNum[0]);
    int[] arrayOfInt2 = paramRRule.getByMonth();
    Object localObject6 = paramRRule.getByMonthDay();
    Object localObject1 = paramRRule.getByWeekNo();
    int[] arrayOfInt3 = paramRRule.getByYearDay();
    int[] arrayOfInt1 = paramRRule.getBySetPos();
    Object localObject3 = paramRRule.getByHour();
    Object localObject7 = paramRRule.getByMinute();
    Object localObject8 = paramRRule.getBySecond();
    paramRRule = null;
    Object localObject5 = paramRRule;
    label179:
    int j;
    label192:
    int k;
    if (1 == (localObject3.length | localObject7.length | localObject8.length))
    {
      localObject5 = paramRRule;
      if ((paramDateValue instanceof TimeValue))
      {
        paramRRule = (TimeValue)paramDateValue;
        if (1 != localObject3.length) {
          break label318;
        }
        i = localObject3[0];
        if (1 != localObject7.length) {
          break label328;
        }
        j = localObject7[0];
        if (1 != localObject8.length) {
          break label339;
        }
        k = localObject8[0];
        label205:
        localObject5 = new DateTimeValueImpl(0, 0, 0, i, j, k);
      }
    }
    if (m <= 0) {}
    for (int i = 1;; i = m)
    {
      if (localObject4 == null) {
        localObject4 = Weekday.MO;
      }
      for (;;)
      {
        if (localFrequency == Frequency.YEARLY) {}
        for (j = i;; j = 1)
        {
          localObject7 = Generators.serialYearGenerator(j, paramDateValue);
          localObject3 = null;
          localObject8 = new ArrayList();
          switch (2.$SwitchMap$com$google$ical$values$Frequency[localFrequency.ordinal()])
          {
          default: 
            throw new IllegalArgumentException("Can't iterate more frequently than daily");
            label318:
            i = paramRRule.hour();
            break label179;
            label328:
            j = paramRRule.minute();
            break label192;
            label339:
            k = paramRRule.second();
            break label205;
          }
        }
        if (localObject6.length == 0)
        {
          localObject1 = Generators.serialDayGenerator(i, paramDateValue);
          label369:
          paramRRule = (RRule)localObject1;
          if (arrayOfWeekdayNum.length == 0) {
            break label1110;
          }
          ((List)localObject8).add(Filters.byDayFilter(arrayOfWeekdayNum, true, (Weekday)localObject4));
          paramRRule = (RRule)localObject1;
          localObject1 = localObject3;
        }
        for (;;)
        {
          if (arrayOfInt2.length != 0)
          {
            localObject1 = Generators.byMonthGenerator(arrayOfInt2, paramDateValue);
            label415:
            boolean bool = true;
            if (n == 0) {
              break label980;
            }
            localObject2 = Conditions.countCondition(n);
            bool = false;
            switch (((List)localObject8).size())
            {
            default: 
              localObject3 = Predicates.and((Predicate[])((List)localObject8).toArray(new Predicate[0]));
              label483:
              if (arrayOfInt1.length != 0) {
                switch (2.$SwitchMap$com$google$ical$values$Frequency[localFrequency.ordinal()])
                {
                default: 
                  localObject4 = InstanceGenerators.serialInstanceGenerator((Predicate)localObject3, (Generator)localObject7, (Generator)localObject1, paramRRule);
                  return new RRuleIteratorImpl(paramDateValue, paramTimeZone, (Predicate)localObject2, (Predicate)localObject3, (Generator)localObject4, (ThrottledGenerator)localObject7, (Generator)localObject1, paramRRule, bool, (TimeValue)localObject5);
                  localObject1 = Generators.byMonthDayGenerator((int[])localObject6, paramDateValue);
                  break label369;
                  if (arrayOfWeekdayNum.length != 0)
                  {
                    paramRRule = Generators.byDayGenerator(arrayOfWeekdayNum, false, paramDateValue);
                    localObject1 = paramRRule;
                    if (i > 1) {
                      ((List)localObject8).add(Filters.weekIntervalFilter(i, (Weekday)localObject4, paramDateValue));
                    }
                  }
                  for (localObject1 = paramRRule;; localObject1 = Generators.serialDayGenerator(i * 7, paramDateValue))
                  {
                    paramRRule = (RRule)localObject1;
                    if (localObject6.length == 0) {
                      break label1110;
                    }
                    ((List)localObject8).add(Filters.byMonthDayFilter((int[])localObject6));
                    paramRRule = (RRule)localObject1;
                    localObject1 = localObject3;
                    break;
                  }
                  if (arrayOfInt3.length != 0)
                  {
                    localObject1 = Generators.byYearDayGenerator(arrayOfInt3, paramDateValue);
                    if (arrayOfWeekdayNum.length != 0) {
                      ((List)localObject8).add(Filters.byDayFilter(arrayOfWeekdayNum, true, (Weekday)localObject4));
                    }
                    paramRRule = (RRule)localObject1;
                    if (localObject6.length == 0) {
                      break label1110;
                    }
                    ((List)localObject8).add(Filters.byMonthDayFilter((int[])localObject6));
                    paramRRule = (RRule)localObject1;
                    localObject1 = localObject3;
                    continue;
                  }
                  if (localObject6.length != 0)
                  {
                    localObject6 = Generators.byMonthDayGenerator((int[])localObject6, paramDateValue);
                    localObject1 = localObject3;
                    paramRRule = (RRule)localObject6;
                    if (arrayOfWeekdayNum.length == 0) {
                      continue;
                    }
                    if (Frequency.YEARLY == localFrequency) {}
                    for (bool = true;; bool = false)
                    {
                      ((List)localObject8).add(Filters.byDayFilter(arrayOfWeekdayNum, bool, (Weekday)localObject4));
                      localObject1 = localObject3;
                      paramRRule = (RRule)localObject6;
                      break;
                    }
                  }
                  if ((localObject1.length != 0) && (Frequency.YEARLY == localFrequency))
                  {
                    localObject1 = Generators.byWeekNoGenerator((int[])localObject1, (Weekday)localObject4, paramDateValue);
                    paramRRule = (RRule)localObject1;
                    if (arrayOfWeekdayNum.length == 0) {
                      break label1110;
                    }
                    ((List)localObject8).add(Filters.byDayFilter(arrayOfWeekdayNum, true, (Weekday)localObject4));
                    paramRRule = (RRule)localObject1;
                    localObject1 = localObject3;
                    continue;
                  }
                  if (arrayOfWeekdayNum.length != 0)
                  {
                    if ((Frequency.YEARLY == localFrequency) && (arrayOfInt2.length == 0)) {}
                    for (bool = true;; bool = false)
                    {
                      paramRRule = Generators.byDayGenerator(arrayOfWeekdayNum, bool, paramDateValue);
                      localObject1 = localObject3;
                      break;
                    }
                  }
                  if (Frequency.YEARLY != localFrequency) {}
                  break;
                }
              }
              label536:
              break;
            }
          }
          for (paramRRule = Generators.byMonthGenerator(new int[] { paramDateValue.month() }, paramDateValue);; paramRRule = null)
          {
            localObject3 = Generators.byMonthDayGenerator(new int[] { paramDateValue.day() }, paramDateValue);
            localObject1 = paramRRule;
            paramRRule = (RRule)localObject3;
            break;
            if (localObject1 == null)
            {
              if (localFrequency == Frequency.MONTHLY) {}
              for (;;)
              {
                localObject1 = Generators.serialMonthGenerator(i, paramDateValue);
                break;
                i = 1;
              }
              label980:
              if (localObject2 != null)
              {
                if (localObject2 instanceof TimeValue == paramDateValue instanceof TimeValue) {
                  break label1099;
                }
                if ((paramDateValue instanceof TimeValue)) {
                  localObject2 = TimeUtils.dayStart((DateValue)localObject2);
                }
              }
              label1099:
              for (;;)
              {
                localObject2 = Conditions.untilCondition((DateValue)localObject2);
                break;
                localObject2 = TimeUtils.toDateValue((DateValue)localObject2);
                continue;
                localObject2 = Predicates.alwaysTrue();
                break;
                localObject3 = Predicates.alwaysTrue();
                break label483;
                localObject3 = (Predicate)((List)localObject8).get(0);
                break label483;
                localObject4 = InstanceGenerators.bySetPosInstanceGenerator(arrayOfInt1, localFrequency, (Weekday)localObject4, (Predicate)localObject3, (Generator)localObject7, (Generator)localObject1, paramRRule);
                break label536;
                localObject4 = InstanceGenerators.serialInstanceGenerator((Predicate)localObject3, (Generator)localObject7, (Generator)localObject1, paramRRule);
                break label536;
              }
            }
            break label415;
          }
          label1110:
          localObject1 = localObject3;
        }
      }
    }
  }
  
  public static RecurrenceIterator createRecurrenceIterator(String paramString, DateValue paramDateValue, TimeZone paramTimeZone)
    throws ParseException
  {
    return createRecurrenceIterator(paramString, paramDateValue, paramTimeZone, true);
  }
  
  public static RecurrenceIterator createRecurrenceIterator(String paramString, DateValue paramDateValue, TimeZone paramTimeZone, boolean paramBoolean)
    throws ParseException
  {
    return createRecurrenceIterable(paramString, paramDateValue, paramTimeZone, paramBoolean).iterator();
  }
  
  public static RecurrenceIterator except(RecurrenceIterator paramRecurrenceIterator1, RecurrenceIterator paramRecurrenceIterator2)
  {
    return new CompoundIteratorImpl(Collections.singleton(paramRecurrenceIterator1), Collections.singleton(paramRecurrenceIterator2));
  }
  
  public static RecurrenceIterator join(RecurrenceIterator paramRecurrenceIterator, RecurrenceIterator... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramRecurrenceIterator);
    localArrayList.addAll(Arrays.asList(paramVarArgs));
    return new CompoundIteratorImpl(localArrayList, Collections.emptyList());
  }
  
  private static IcalObject[] parseContentLines(String paramString, TimeZone paramTimeZone, boolean paramBoolean)
    throws ParseException
  {
    int k = 0;
    paramString = FOLD.matcher(paramString).replaceAll("").trim();
    if ("".equals(paramString)) {
      return new IcalObject[0];
    }
    String[] arrayOfString = NEWLINE.split(paramString);
    paramString = new IcalObject[arrayOfString.length];
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < arrayOfString.length)
      {
        String str = arrayOfString[j].trim();
        try
        {
          if (RULE.matcher(str).find()) {
            paramString[j] = new RRule(str);
          } else if (DATE.matcher(str).find()) {
            paramString[j] = new RDateList(str, paramTimeZone);
          }
        }
        catch (ParseException localParseException)
        {
          if (paramBoolean)
          {
            throw localParseException;
            throw new ParseException(arrayOfString[j], j);
          }
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          if (paramBoolean)
          {
            throw localIllegalArgumentException;
            LOGGER.log(Level.SEVERE, "Dropping bad recurrence rule line: " + str, localIllegalArgumentException);
            i += 1;
          }
          else
          {
            LOGGER.log(Level.SEVERE, "Dropping bad recurrence rule line: " + str, localIllegalArgumentException);
            i += 1;
          }
        }
      }
      else
      {
        if (i != 0)
        {
          paramTimeZone = new IcalObject[paramString.length - i];
          j = 0;
          i = k;
          while (j < paramTimeZone.length)
          {
            k = j;
            if (paramString[i] != null)
            {
              paramTimeZone[j] = paramString[i];
              k = j + 1;
            }
            i += 1;
            j = k;
          }
          return paramTimeZone;
        }
        return paramString;
      }
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.iter.RecurrenceIteratorFactory
 * JD-Core Version:    0.7.0.1
 */