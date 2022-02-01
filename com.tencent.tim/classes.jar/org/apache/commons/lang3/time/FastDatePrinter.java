package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class FastDatePrinter
  implements Serializable, DatePrinter
{
  public static final int FULL = 0;
  public static final int LONG = 1;
  public static final int MEDIUM = 2;
  public static final int SHORT = 3;
  private static final ConcurrentMap<TimeZoneDisplayKey, String> cTimeZoneDisplayCache = new ConcurrentHashMap(7);
  private static final long serialVersionUID = 1L;
  private final Locale mLocale;
  private transient int mMaxLengthEstimate;
  private final String mPattern;
  private transient Rule[] mRules;
  private final TimeZone mTimeZone;
  
  protected FastDatePrinter(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    this.mPattern = paramString;
    this.mTimeZone = paramTimeZone;
    this.mLocale = paramLocale;
    init();
  }
  
  private static void appendDigits(StringBuffer paramStringBuffer, int paramInt)
  {
    paramStringBuffer.append((char)(paramInt / 10 + 48));
    paramStringBuffer.append((char)(paramInt % 10 + 48));
  }
  
  private String applyRulesToString(Calendar paramCalendar)
  {
    return applyRules(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  static String getTimeZoneDisplay(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
  {
    TimeZoneDisplayKey localTimeZoneDisplayKey = new TimeZoneDisplayKey(paramTimeZone, paramBoolean, paramInt, paramLocale);
    String str2 = (String)cTimeZoneDisplayCache.get(localTimeZoneDisplayKey);
    String str1 = str2;
    if (str2 == null)
    {
      paramTimeZone = paramTimeZone.getDisplayName(paramBoolean, paramInt, paramLocale);
      str1 = (String)cTimeZoneDisplayCache.putIfAbsent(localTimeZoneDisplayKey, paramTimeZone);
      if (str1 == null) {}
    }
    else
    {
      return str1;
    }
    return paramTimeZone;
  }
  
  private void init()
  {
    List localList = parsePattern();
    this.mRules = ((Rule[])localList.toArray(new Rule[localList.size()]));
    int i = 0;
    int j = this.mRules.length;
    for (;;)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      i += this.mRules[j].estimateLength();
    }
    this.mMaxLengthEstimate = i;
  }
  
  private GregorianCalendar newCalendar()
  {
    return new GregorianCalendar(this.mTimeZone, this.mLocale);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init();
  }
  
  protected StringBuffer applyRules(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    Rule[] arrayOfRule = this.mRules;
    int j = arrayOfRule.length;
    int i = 0;
    while (i < j)
    {
      arrayOfRule[i].appendTo(paramStringBuffer, paramCalendar);
      i += 1;
    }
    return paramStringBuffer;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FastDatePrinter)) {}
    do
    {
      return false;
      paramObject = (FastDatePrinter)paramObject;
    } while ((!this.mPattern.equals(paramObject.mPattern)) || (!this.mTimeZone.equals(paramObject.mTimeZone)) || (!this.mLocale.equals(paramObject.mLocale)));
    return true;
  }
  
  public String format(long paramLong)
  {
    GregorianCalendar localGregorianCalendar = newCalendar();
    localGregorianCalendar.setTimeInMillis(paramLong);
    return applyRulesToString(localGregorianCalendar);
  }
  
  public String format(Calendar paramCalendar)
  {
    return format(paramCalendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
  }
  
  public String format(Date paramDate)
  {
    GregorianCalendar localGregorianCalendar = newCalendar();
    localGregorianCalendar.setTime(paramDate);
    return applyRulesToString(localGregorianCalendar);
  }
  
  public StringBuffer format(long paramLong, StringBuffer paramStringBuffer)
  {
    return format(new Date(paramLong), paramStringBuffer);
  }
  
  public StringBuffer format(Object paramObject, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    if ((paramObject instanceof Date)) {
      return format((Date)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Calendar)) {
      return format((Calendar)paramObject, paramStringBuffer);
    }
    if ((paramObject instanceof Long)) {
      return format(((Long)paramObject).longValue(), paramStringBuffer);
    }
    paramStringBuffer = new StringBuilder().append("Unknown class: ");
    if (paramObject == null) {}
    for (paramObject = "<null>";; paramObject = paramObject.getClass().getName()) {
      throw new IllegalArgumentException(paramObject);
    }
  }
  
  public StringBuffer format(Calendar paramCalendar, StringBuffer paramStringBuffer)
  {
    return applyRules(paramCalendar, paramStringBuffer);
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer)
  {
    GregorianCalendar localGregorianCalendar = newCalendar();
    localGregorianCalendar.setTime(paramDate);
    return applyRules(localGregorianCalendar, paramStringBuffer);
  }
  
  public Locale getLocale()
  {
    return this.mLocale;
  }
  
  public int getMaxLengthEstimate()
  {
    return this.mMaxLengthEstimate;
  }
  
  public String getPattern()
  {
    return this.mPattern;
  }
  
  public TimeZone getTimeZone()
  {
    return this.mTimeZone;
  }
  
  public int hashCode()
  {
    return this.mPattern.hashCode() + (this.mTimeZone.hashCode() + this.mLocale.hashCode() * 13) * 13;
  }
  
  protected List<Rule> parsePattern()
  {
    Object localObject = new DateFormatSymbols(this.mLocale);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString3 = ((DateFormatSymbols)localObject).getEras();
    String[] arrayOfString4 = ((DateFormatSymbols)localObject).getMonths();
    String[] arrayOfString5 = ((DateFormatSymbols)localObject).getShortMonths();
    String[] arrayOfString1 = ((DateFormatSymbols)localObject).getWeekdays();
    String[] arrayOfString2 = ((DateFormatSymbols)localObject).getShortWeekdays();
    String[] arrayOfString6 = ((DateFormatSymbols)localObject).getAmPmStrings();
    int k = this.mPattern.length();
    int[] arrayOfInt = new int[1];
    int i = 0;
    int m;
    int j;
    if (i < k)
    {
      arrayOfInt[0] = i;
      localObject = parseToken(this.mPattern, arrayOfInt);
      m = arrayOfInt[0];
      j = ((String)localObject).length();
      if (j != 0) {}
    }
    else
    {
      return localArrayList;
    }
    switch (((String)localObject).charAt(0))
    {
    default: 
      throw new IllegalArgumentException("Illegal pattern component: " + (String)localObject);
    case 'G': 
      localObject = new TextField(0, arrayOfString3);
    }
    for (;;)
    {
      localArrayList.add(localObject);
      i = m + 1;
      break;
      if (j == 2)
      {
        localObject = TwoDigitYearField.INSTANCE;
      }
      else
      {
        i = j;
        if (j < 4) {
          i = 4;
        }
        localObject = selectNumberRule(1, i);
        continue;
        if (j >= 4)
        {
          localObject = new TextField(2, arrayOfString4);
        }
        else if (j == 3)
        {
          localObject = new TextField(2, arrayOfString5);
        }
        else if (j == 2)
        {
          localObject = TwoDigitMonthField.INSTANCE;
        }
        else
        {
          localObject = UnpaddedMonthField.INSTANCE;
          continue;
          localObject = selectNumberRule(5, j);
          continue;
          localObject = new TwelveHourField(selectNumberRule(10, j));
          continue;
          localObject = selectNumberRule(11, j);
          continue;
          localObject = selectNumberRule(12, j);
          continue;
          localObject = selectNumberRule(13, j);
          continue;
          localObject = selectNumberRule(14, j);
          continue;
          if (j < 4) {}
          for (localObject = arrayOfString2;; localObject = arrayOfString1)
          {
            localObject = new TextField(7, (String[])localObject);
            break;
          }
          localObject = selectNumberRule(6, j);
          continue;
          localObject = selectNumberRule(8, j);
          continue;
          localObject = selectNumberRule(3, j);
          continue;
          localObject = selectNumberRule(4, j);
          continue;
          localObject = new TextField(9, arrayOfString6);
          continue;
          localObject = new TwentyFourHourField(selectNumberRule(11, j));
          continue;
          localObject = selectNumberRule(10, j);
          continue;
          localObject = Iso8601_Rule.getRule(j);
          continue;
          if (j >= 4)
          {
            localObject = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 1);
          }
          else
          {
            localObject = new TimeZoneNameRule(this.mTimeZone, this.mLocale, 0);
            continue;
            if (j == 1)
            {
              localObject = TimeZoneNumberRule.INSTANCE_NO_COLON;
            }
            else if (j == 2)
            {
              localObject = TimeZoneNumberRule.INSTANCE_ISO_8601;
            }
            else
            {
              localObject = TimeZoneNumberRule.INSTANCE_COLON;
              continue;
              localObject = ((String)localObject).substring(1);
              if (((String)localObject).length() == 1) {
                localObject = new CharacterLiteral(((String)localObject).charAt(0));
              } else {
                localObject = new StringLiteral((String)localObject);
              }
            }
          }
        }
      }
    }
  }
  
  protected String parseToken(String paramString, int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfInt[0];
    int m = paramString.length();
    char c = paramString.charAt(i);
    if (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')))
    {
      localStringBuilder.append(c);
      for (;;)
      {
        j = i;
        if (i + 1 >= m) {
          break;
        }
        j = i;
        if (paramString.charAt(i + 1) != c) {
          break;
        }
        localStringBuilder.append(c);
        i += 1;
      }
    }
    localStringBuilder.append('\'');
    int k = 0;
    int j = i;
    if (i < m)
    {
      c = paramString.charAt(i);
      if (c == '\'') {
        if ((i + 1 < m) && (paramString.charAt(i + 1) == '\''))
        {
          i += 1;
          localStringBuilder.append(c);
          j = k;
        }
      }
    }
    for (;;)
    {
      i += 1;
      k = j;
      break;
      if (k == 0)
      {
        j = 1;
      }
      else
      {
        j = 0;
        continue;
        if ((k == 0) && (((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z'))))
        {
          j = i - 1;
          paramArrayOfInt[0] = j;
          return localStringBuilder.toString();
        }
        localStringBuilder.append(c);
        j = k;
      }
    }
  }
  
  protected NumberRule selectNumberRule(int paramInt1, int paramInt2)
  {
    switch (paramInt2)
    {
    default: 
      return new PaddedNumberField(paramInt1, paramInt2);
    case 1: 
      return new UnpaddedNumberField(paramInt1);
    }
    return new TwoDigitNumberField(paramInt1);
  }
  
  public String toString()
  {
    return "FastDatePrinter[" + this.mPattern + "," + this.mLocale + "," + this.mTimeZone.getID() + "]";
  }
  
  static class CharacterLiteral
    implements FastDatePrinter.Rule
  {
    private final char mValue;
    
    CharacterLiteral(char paramChar)
    {
      this.mValue = paramChar;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.mValue);
    }
    
    public int estimateLength()
    {
      return 1;
    }
  }
  
  static class Iso8601_Rule
    implements FastDatePrinter.Rule
  {
    static final Iso8601_Rule ISO8601_HOURS = new Iso8601_Rule(3);
    static final Iso8601_Rule ISO8601_HOURS_COLON_MINUTES = new Iso8601_Rule(6);
    static final Iso8601_Rule ISO8601_HOURS_MINUTES = new Iso8601_Rule(5);
    final int length;
    
    Iso8601_Rule(int paramInt)
    {
      this.length = paramInt;
    }
    
    static Iso8601_Rule getRule(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid number of X");
      case 1: 
        return ISO8601_HOURS;
      case 2: 
        return ISO8601_HOURS_MINUTES;
      }
      return ISO8601_HOURS_COLON_MINUTES;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int i = paramCalendar.get(15);
      if (i == 0)
      {
        paramStringBuffer.append("Z");
        return;
      }
      i += paramCalendar.get(16);
      if (i < 0)
      {
        paramStringBuffer.append('-');
        i = -i;
      }
      for (;;)
      {
        int j = i / 3600000;
        FastDatePrinter.appendDigits(paramStringBuffer, j);
        if (this.length < 5) {
          break;
        }
        if (this.length == 6) {
          paramStringBuffer.append(':');
        }
        FastDatePrinter.appendDigits(paramStringBuffer, i / 60000 - j * 60);
        return;
        paramStringBuffer.append('+');
      }
    }
    
    public int estimateLength()
    {
      return this.length;
    }
  }
  
  static abstract interface NumberRule
    extends FastDatePrinter.Rule
  {
    public abstract void appendTo(StringBuffer paramStringBuffer, int paramInt);
  }
  
  static class PaddedNumberField
    implements FastDatePrinter.NumberRule
  {
    private final int mField;
    private final int mSize;
    
    PaddedNumberField(int paramInt1, int paramInt2)
    {
      if (paramInt2 < 3) {
        throw new IllegalArgumentException();
      }
      this.mField = paramInt1;
      this.mSize = paramInt2;
    }
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      int i = 0;
      while (i < this.mSize)
      {
        paramStringBuffer.append('0');
        i += 1;
      }
      i = paramStringBuffer.length();
      while (paramInt > 0)
      {
        i -= 1;
        paramStringBuffer.setCharAt(i, (char)(paramInt % 10 + 48));
        paramInt /= 10;
      }
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(this.mField));
    }
    
    public int estimateLength()
    {
      return this.mSize;
    }
  }
  
  static abstract interface Rule
  {
    public abstract void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar);
    
    public abstract int estimateLength();
  }
  
  static class StringLiteral
    implements FastDatePrinter.Rule
  {
    private final String mValue;
    
    StringLiteral(String paramString)
    {
      this.mValue = paramString;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.mValue);
    }
    
    public int estimateLength()
    {
      return this.mValue.length();
    }
  }
  
  static class TextField
    implements FastDatePrinter.Rule
  {
    private final int mField;
    private final String[] mValues;
    
    TextField(int paramInt, String[] paramArrayOfString)
    {
      this.mField = paramInt;
      this.mValues = paramArrayOfString;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      paramStringBuffer.append(this.mValues[paramCalendar.get(this.mField)]);
    }
    
    public int estimateLength()
    {
      int i = 0;
      int j = this.mValues.length;
      j -= 1;
      if (j >= 0)
      {
        int k = this.mValues[j].length();
        if (k <= i) {
          break label38;
        }
        i = k;
      }
      label38:
      for (;;)
      {
        break;
        return i;
      }
    }
  }
  
  static class TimeZoneDisplayKey
  {
    private final Locale mLocale;
    private final int mStyle;
    private final TimeZone mTimeZone;
    
    TimeZoneDisplayKey(TimeZone paramTimeZone, boolean paramBoolean, int paramInt, Locale paramLocale)
    {
      this.mTimeZone = paramTimeZone;
      if (paramBoolean) {}
      for (this.mStyle = (0x80000000 | paramInt);; this.mStyle = paramInt)
      {
        this.mLocale = paramLocale;
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof TimeZoneDisplayKey)) {
          break;
        }
        paramObject = (TimeZoneDisplayKey)paramObject;
      } while ((this.mTimeZone.equals(paramObject.mTimeZone)) && (this.mStyle == paramObject.mStyle) && (this.mLocale.equals(paramObject.mLocale)));
      return false;
      return false;
    }
    
    public int hashCode()
    {
      return (this.mStyle * 31 + this.mLocale.hashCode()) * 31 + this.mTimeZone.hashCode();
    }
  }
  
  static class TimeZoneNameRule
    implements FastDatePrinter.Rule
  {
    private final String mDaylight;
    private final Locale mLocale;
    private final String mStandard;
    private final int mStyle;
    
    TimeZoneNameRule(TimeZone paramTimeZone, Locale paramLocale, int paramInt)
    {
      this.mLocale = paramLocale;
      this.mStyle = paramInt;
      this.mStandard = FastDatePrinter.getTimeZoneDisplay(paramTimeZone, false, paramInt, paramLocale);
      this.mDaylight = FastDatePrinter.getTimeZoneDisplay(paramTimeZone, true, paramInt, paramLocale);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      TimeZone localTimeZone = paramCalendar.getTimeZone();
      if (paramCalendar.get(16) != 0)
      {
        paramStringBuffer.append(FastDatePrinter.getTimeZoneDisplay(localTimeZone, true, this.mStyle, this.mLocale));
        return;
      }
      paramStringBuffer.append(FastDatePrinter.getTimeZoneDisplay(localTimeZone, false, this.mStyle, this.mLocale));
    }
    
    public int estimateLength()
    {
      return Math.max(this.mStandard.length(), this.mDaylight.length());
    }
  }
  
  static class TimeZoneNumberRule
    implements FastDatePrinter.Rule
  {
    static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true, false);
    static final TimeZoneNumberRule INSTANCE_ISO_8601 = new TimeZoneNumberRule(true, true);
    static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false, false);
    final boolean mColon;
    final boolean mISO8601;
    
    TimeZoneNumberRule(boolean paramBoolean1, boolean paramBoolean2)
    {
      this.mColon = paramBoolean1;
      this.mISO8601 = paramBoolean2;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      if ((this.mISO8601) && (paramCalendar.getTimeZone().getID().equals("UTC")))
      {
        paramStringBuffer.append("Z");
        return;
      }
      int i = paramCalendar.get(15) + paramCalendar.get(16);
      if (i < 0)
      {
        paramStringBuffer.append('-');
        i = -i;
      }
      for (;;)
      {
        int j = i / 3600000;
        FastDatePrinter.appendDigits(paramStringBuffer, j);
        if (this.mColon) {
          paramStringBuffer.append(':');
        }
        FastDatePrinter.appendDigits(paramStringBuffer, i / 60000 - j * 60);
        return;
        paramStringBuffer.append('+');
      }
    }
    
    public int estimateLength()
    {
      return 5;
    }
  }
  
  static class TwelveHourField
    implements FastDatePrinter.NumberRule
  {
    private final FastDatePrinter.NumberRule mRule;
    
    TwelveHourField(FastDatePrinter.NumberRule paramNumberRule)
    {
      this.mRule = paramNumberRule;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      this.mRule.appendTo(paramStringBuffer, paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int j = paramCalendar.get(10);
      int i = j;
      if (j == 0) {
        i = paramCalendar.getLeastMaximum(10) + 1;
      }
      this.mRule.appendTo(paramStringBuffer, i);
    }
    
    public int estimateLength()
    {
      return this.mRule.estimateLength();
    }
  }
  
  static class TwentyFourHourField
    implements FastDatePrinter.NumberRule
  {
    private final FastDatePrinter.NumberRule mRule;
    
    TwentyFourHourField(FastDatePrinter.NumberRule paramNumberRule)
    {
      this.mRule = paramNumberRule;
    }
    
    public void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      this.mRule.appendTo(paramStringBuffer, paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      int j = paramCalendar.get(11);
      int i = j;
      if (j == 0) {
        i = paramCalendar.getMaximum(11) + 1;
      }
      this.mRule.appendTo(paramStringBuffer, i);
    }
    
    public int estimateLength()
    {
      return this.mRule.estimateLength();
    }
  }
  
  static class TwoDigitMonthField
    implements FastDatePrinter.NumberRule
  {
    static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      FastDatePrinter.appendDigits(paramStringBuffer, paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(2) + 1);
    }
    
    public int estimateLength()
    {
      return 2;
    }
  }
  
  static class TwoDigitNumberField
    implements FastDatePrinter.NumberRule
  {
    private final int mField;
    
    TwoDigitNumberField(int paramInt)
    {
      this.mField = paramInt;
    }
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 100)
      {
        FastDatePrinter.appendDigits(paramStringBuffer, paramInt);
        return;
      }
      paramStringBuffer.append(paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(this.mField));
    }
    
    public int estimateLength()
    {
      return 2;
    }
  }
  
  static class TwoDigitYearField
    implements FastDatePrinter.NumberRule
  {
    static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      FastDatePrinter.appendDigits(paramStringBuffer, paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(1) % 100);
    }
    
    public int estimateLength()
    {
      return 2;
    }
  }
  
  static class UnpaddedMonthField
    implements FastDatePrinter.NumberRule
  {
    static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
        return;
      }
      FastDatePrinter.appendDigits(paramStringBuffer, paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(2) + 1);
    }
    
    public int estimateLength()
    {
      return 2;
    }
  }
  
  static class UnpaddedNumberField
    implements FastDatePrinter.NumberRule
  {
    private final int mField;
    
    UnpaddedNumberField(int paramInt)
    {
      this.mField = paramInt;
    }
    
    public final void appendTo(StringBuffer paramStringBuffer, int paramInt)
    {
      if (paramInt < 10)
      {
        paramStringBuffer.append((char)(paramInt + 48));
        return;
      }
      if (paramInt < 100)
      {
        FastDatePrinter.appendDigits(paramStringBuffer, paramInt);
        return;
      }
      paramStringBuffer.append(paramInt);
    }
    
    public void appendTo(StringBuffer paramStringBuffer, Calendar paramCalendar)
    {
      appendTo(paramStringBuffer, paramCalendar.get(this.mField));
    }
    
    public int estimateLength()
    {
      return 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FastDatePrinter
 * JD-Core Version:    0.7.0.1
 */