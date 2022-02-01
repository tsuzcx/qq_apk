package org.apache.commons.lang3.time;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FastDateParser
  implements Serializable, DateParser
{
  private static final Strategy ABBREVIATED_YEAR_STRATEGY;
  private static final Strategy DAY_OF_MONTH_STRATEGY;
  private static final Strategy DAY_OF_WEEK_IN_MONTH_STRATEGY;
  private static final Strategy DAY_OF_YEAR_STRATEGY;
  private static final Strategy HOUR12_STRATEGY;
  private static final Strategy HOUR24_OF_DAY_STRATEGY;
  private static final Strategy HOUR_OF_DAY_STRATEGY;
  private static final Strategy HOUR_STRATEGY;
  private static final Strategy ISO_8601_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::?\\d{2})?))");
  static final Locale JAPANESE_IMPERIAL = new Locale("ja", "JP", "JP");
  private static final Strategy LITERAL_YEAR_STRATEGY;
  private static final Strategy MILLISECOND_STRATEGY;
  private static final Strategy MINUTE_STRATEGY;
  private static final Strategy NUMBER_MONTH_STRATEGY;
  private static final Strategy SECOND_STRATEGY;
  private static final Strategy WEEK_OF_MONTH_STRATEGY;
  private static final Strategy WEEK_OF_YEAR_STRATEGY;
  private static final ConcurrentMap<Locale, Strategy>[] caches;
  private static final Pattern formatPattern = Pattern.compile("D+|E+|F+|G+|H+|K+|M+|S+|W+|X+|Z+|a+|d+|h+|k+|m+|s+|w+|y+|z+|''|'[^']++(''[^']*+)*+'|[^'A-Za-z]++");
  private static final long serialVersionUID = 2L;
  private final int century;
  private transient String currentFormatField;
  private final Locale locale;
  private transient Strategy nextStrategy;
  private transient Pattern parsePattern;
  private final String pattern;
  private final int startYear;
  private transient Strategy[] strategies;
  private final TimeZone timeZone;
  
  static
  {
    caches = new ConcurrentMap[17];
    ABBREVIATED_YEAR_STRATEGY = new FastDateParser.1(1);
    NUMBER_MONTH_STRATEGY = new FastDateParser.2(2);
    LITERAL_YEAR_STRATEGY = new NumberStrategy(1);
    WEEK_OF_YEAR_STRATEGY = new NumberStrategy(3);
    WEEK_OF_MONTH_STRATEGY = new NumberStrategy(4);
    DAY_OF_YEAR_STRATEGY = new NumberStrategy(6);
    DAY_OF_MONTH_STRATEGY = new NumberStrategy(5);
    DAY_OF_WEEK_IN_MONTH_STRATEGY = new NumberStrategy(8);
    HOUR_OF_DAY_STRATEGY = new NumberStrategy(11);
    HOUR24_OF_DAY_STRATEGY = new FastDateParser.3(11);
    HOUR12_STRATEGY = new FastDateParser.4(10);
    HOUR_STRATEGY = new NumberStrategy(10);
    MINUTE_STRATEGY = new NumberStrategy(12);
    SECOND_STRATEGY = new NumberStrategy(13);
    MILLISECOND_STRATEGY = new NumberStrategy(14);
  }
  
  protected FastDateParser(String paramString, TimeZone paramTimeZone, Locale paramLocale)
  {
    this(paramString, paramTimeZone, paramLocale, null);
  }
  
  protected FastDateParser(String paramString, TimeZone paramTimeZone, Locale paramLocale, Date paramDate)
  {
    this.pattern = paramString;
    this.timeZone = paramTimeZone;
    this.locale = paramLocale;
    paramString = Calendar.getInstance(paramTimeZone, paramLocale);
    int i;
    if (paramDate != null)
    {
      paramString.setTime(paramDate);
      i = paramString.get(1);
    }
    for (;;)
    {
      this.century = (i / 100 * 100);
      this.startYear = (i - this.century);
      init(paramString);
      return;
      if (paramLocale.equals(JAPANESE_IMPERIAL))
      {
        i = 0;
      }
      else
      {
        paramString.setTime(new Date());
        i = paramString.get(1) - 80;
      }
    }
  }
  
  private int adjustYear(int paramInt)
  {
    int i = this.century + paramInt;
    if (paramInt >= this.startYear) {
      return i;
    }
    return i + 100;
  }
  
  private static StringBuilder escapeRegex(StringBuilder paramStringBuilder, String paramString, boolean paramBoolean)
  {
    paramStringBuilder.append("\\Q");
    int i = 0;
    char c;
    if (i < paramString.length())
    {
      c = paramString.charAt(i);
      switch (c)
      {
      }
    }
    for (;;)
    {
      paramStringBuilder.append(c);
      i += 1;
      break;
      if (paramBoolean)
      {
        i += 1;
        if (i == paramString.length()) {
          return paramStringBuilder;
        }
        c = paramString.charAt(i);
        continue;
        i += 1;
        if (i != paramString.length())
        {
          paramStringBuilder.append(c);
          c = paramString.charAt(i);
          if (c == 'E')
          {
            paramStringBuilder.append("E\\\\E\\");
            c = 'Q';
            continue;
            paramStringBuilder.append("\\E");
            return paramStringBuilder;
          }
        }
      }
    }
  }
  
  private static ConcurrentMap<Locale, Strategy> getCache(int paramInt)
  {
    synchronized (caches)
    {
      if (caches[paramInt] == null) {
        caches[paramInt] = new ConcurrentHashMap(3);
      }
      ConcurrentMap localConcurrentMap = caches[paramInt];
      return localConcurrentMap;
    }
  }
  
  private static Map<String, Integer> getDisplayNames(int paramInt, Calendar paramCalendar, Locale paramLocale)
  {
    return paramCalendar.getDisplayNames(paramInt, 0, paramLocale);
  }
  
  private Strategy getLocaleSpecificStrategy(int paramInt, Calendar paramCalendar)
  {
    ConcurrentMap localConcurrentMap = getCache(paramInt);
    Strategy localStrategy = (Strategy)localConcurrentMap.get(this.locale);
    if (localStrategy == null)
    {
      if (paramInt == 15) {}
      for (paramCalendar = new TimeZoneStrategy(this.locale);; paramCalendar = new CaseInsensitiveTextStrategy(paramInt, paramCalendar, this.locale))
      {
        localStrategy = (Strategy)localConcurrentMap.putIfAbsent(this.locale, paramCalendar);
        if (localStrategy == null) {
          break;
        }
        return localStrategy;
      }
    }
    paramCalendar = localStrategy;
    return paramCalendar;
  }
  
  private Strategy getStrategy(String paramString, Calendar paramCalendar)
  {
    switch (paramString.charAt(0))
    {
    default: 
    case '\'': 
      do
      {
        return new CopyQuotedStrategy(paramString);
      } while (paramString.length() <= 2);
      return new CopyQuotedStrategy(paramString.substring(1, paramString.length() - 1));
    case 'D': 
      return DAY_OF_YEAR_STRATEGY;
    case 'E': 
      return getLocaleSpecificStrategy(7, paramCalendar);
    case 'F': 
      return DAY_OF_WEEK_IN_MONTH_STRATEGY;
    case 'G': 
      return getLocaleSpecificStrategy(0, paramCalendar);
    case 'H': 
      return HOUR_OF_DAY_STRATEGY;
    case 'K': 
      return HOUR_STRATEGY;
    case 'M': 
      if (paramString.length() >= 3) {
        return getLocaleSpecificStrategy(2, paramCalendar);
      }
      return NUMBER_MONTH_STRATEGY;
    case 'S': 
      return MILLISECOND_STRATEGY;
    case 'W': 
      return WEEK_OF_MONTH_STRATEGY;
    case 'a': 
      return getLocaleSpecificStrategy(9, paramCalendar);
    case 'd': 
      return DAY_OF_MONTH_STRATEGY;
    case 'h': 
      return HOUR12_STRATEGY;
    case 'k': 
      return HOUR24_OF_DAY_STRATEGY;
    case 'm': 
      return MINUTE_STRATEGY;
    case 's': 
      return SECOND_STRATEGY;
    case 'w': 
      return WEEK_OF_YEAR_STRATEGY;
    case 'y': 
      if (paramString.length() > 2) {
        return LITERAL_YEAR_STRATEGY;
      }
      return ABBREVIATED_YEAR_STRATEGY;
    case 'X': 
      return ISO8601TimeZoneStrategy.getStrategy(paramString.length());
    case 'Z': 
      if (paramString.equals("ZZ")) {
        return ISO_8601_STRATEGY;
      }
      break;
    }
    return getLocaleSpecificStrategy(15, paramCalendar);
  }
  
  private void init(Calendar paramCalendar)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    ArrayList localArrayList = new ArrayList();
    Matcher localMatcher = formatPattern.matcher(this.pattern);
    if (!localMatcher.lookingAt()) {
      throw new IllegalArgumentException("Illegal pattern character '" + this.pattern.charAt(localMatcher.regionStart()) + "'");
    }
    this.currentFormatField = localMatcher.group();
    for (Strategy localStrategy = getStrategy(this.currentFormatField, paramCalendar);; localStrategy = this.nextStrategy)
    {
      localMatcher.region(localMatcher.end(), localMatcher.regionEnd());
      if (!localMatcher.lookingAt())
      {
        this.nextStrategy = null;
        if (localMatcher.regionStart() == localMatcher.regionEnd()) {
          break;
        }
        throw new IllegalArgumentException("Failed to parse \"" + this.pattern + "\" ; gave up at index " + localMatcher.regionStart());
      }
      String str = localMatcher.group();
      this.nextStrategy = getStrategy(str, paramCalendar);
      if (localStrategy.addRegex(this, localStringBuilder)) {
        localArrayList.add(localStrategy);
      }
      this.currentFormatField = str;
    }
    if (localStrategy.addRegex(this, localStringBuilder)) {
      localArrayList.add(localStrategy);
    }
    this.currentFormatField = null;
    this.strategies = ((Strategy[])localArrayList.toArray(new Strategy[localArrayList.size()]));
    this.parsePattern = Pattern.compile(localStringBuilder.toString());
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    init(Calendar.getInstance(this.timeZone, this.locale));
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof FastDateParser)) {}
    do
    {
      return false;
      paramObject = (FastDateParser)paramObject;
    } while ((!this.pattern.equals(paramObject.pattern)) || (!this.timeZone.equals(paramObject.timeZone)) || (!this.locale.equals(paramObject.locale)));
    return true;
  }
  
  int getFieldWidth()
  {
    return this.currentFormatField.length();
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  Pattern getParsePattern()
  {
    return this.parsePattern;
  }
  
  public String getPattern()
  {
    return this.pattern;
  }
  
  public TimeZone getTimeZone()
  {
    return this.timeZone;
  }
  
  public int hashCode()
  {
    return this.pattern.hashCode() + (this.timeZone.hashCode() + this.locale.hashCode() * 13) * 13;
  }
  
  boolean isNextNumber()
  {
    return (this.nextStrategy != null) && (this.nextStrategy.isNumber());
  }
  
  public Date parse(String paramString)
    throws ParseException
  {
    Date localDate = parse(paramString, new ParsePosition(0));
    if (localDate == null)
    {
      if (this.locale.equals(JAPANESE_IMPERIAL)) {
        throw new ParseException("(The " + this.locale + " locale does not support dates before 1868 AD)\n" + "Unparseable date: \"" + paramString + "\" does not match " + this.parsePattern.pattern(), 0);
      }
      throw new ParseException("Unparseable date: \"" + paramString + "\" does not match " + this.parsePattern.pattern(), 0);
    }
    return localDate;
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    int k = paramParsePosition.getIndex();
    paramString = this.parsePattern.matcher(paramString.substring(k));
    if (!paramString.lookingAt()) {
      return null;
    }
    Calendar localCalendar = Calendar.getInstance(this.timeZone, this.locale);
    localCalendar.clear();
    int j;
    for (int i = 0; i < this.strategies.length; i = j)
    {
      Strategy[] arrayOfStrategy = this.strategies;
      j = i + 1;
      arrayOfStrategy[i].setCalendar(this, localCalendar, paramString.group(j));
    }
    paramParsePosition.setIndex(paramString.end() + k);
    return localCalendar.getTime();
  }
  
  public Object parseObject(String paramString)
    throws ParseException
  {
    return parse(paramString);
  }
  
  public Object parseObject(String paramString, ParsePosition paramParsePosition)
  {
    return parse(paramString, paramParsePosition);
  }
  
  public String toString()
  {
    return "FastDateParser[" + this.pattern + "," + this.locale + "," + this.timeZone.getID() + "]";
  }
  
  static class CaseInsensitiveTextStrategy
    extends FastDateParser.Strategy
  {
    private final int field;
    private final Map<String, Integer> lKeyValues;
    private final Locale locale;
    
    CaseInsensitiveTextStrategy(int paramInt, Calendar paramCalendar, Locale paramLocale)
    {
      super();
      this.field = paramInt;
      this.locale = paramLocale;
      paramCalendar = FastDateParser.getDisplayNames(paramInt, paramCalendar, paramLocale);
      this.lKeyValues = new HashMap();
      paramCalendar = paramCalendar.entrySet().iterator();
      while (paramCalendar.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramCalendar.next();
        this.lKeyValues.put(((String)localEntry.getKey()).toLowerCase(paramLocale), localEntry.getValue());
      }
    }
    
    boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append("((?iu)");
      paramFastDateParser = this.lKeyValues.keySet().iterator();
      while (paramFastDateParser.hasNext()) {
        FastDateParser.escapeRegex(paramStringBuilder, (String)paramFastDateParser.next(), false).append('|');
      }
      paramStringBuilder.setCharAt(paramStringBuilder.length() - 1, ')');
      return true;
    }
    
    void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString)
    {
      paramFastDateParser = (Integer)this.lKeyValues.get(paramString.toLowerCase(this.locale));
      if (paramFastDateParser == null)
      {
        paramFastDateParser = new StringBuilder(paramString);
        paramFastDateParser.append(" not in (");
        paramCalendar = this.lKeyValues.keySet().iterator();
        while (paramCalendar.hasNext()) {
          paramFastDateParser.append((String)paramCalendar.next()).append(' ');
        }
        paramFastDateParser.setCharAt(paramFastDateParser.length() - 1, ')');
        throw new IllegalArgumentException(paramFastDateParser.toString());
      }
      paramCalendar.set(this.field, paramFastDateParser.intValue());
    }
  }
  
  static class CopyQuotedStrategy
    extends FastDateParser.Strategy
  {
    private final String formatField;
    
    CopyQuotedStrategy(String paramString)
    {
      super();
      this.formatField = paramString;
    }
    
    boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder)
    {
      FastDateParser.escapeRegex(paramStringBuilder, this.formatField, true);
      return false;
    }
    
    boolean isNumber()
    {
      char c2 = this.formatField.charAt(0);
      char c1 = c2;
      if (c2 == '\'') {
        c1 = this.formatField.charAt(1);
      }
      return Character.isDigit(c1);
    }
  }
  
  static class ISO8601TimeZoneStrategy
    extends FastDateParser.Strategy
  {
    private static final FastDateParser.Strategy ISO_8601_1_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}))");
    private static final FastDateParser.Strategy ISO_8601_2_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}\\d{2}))");
    private static final FastDateParser.Strategy ISO_8601_3_STRATEGY = new ISO8601TimeZoneStrategy("(Z|(?:[+-]\\d{2}(?::)\\d{2}))");
    private final String pattern;
    
    ISO8601TimeZoneStrategy(String paramString)
    {
      super();
      this.pattern = paramString;
    }
    
    static FastDateParser.Strategy getStrategy(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("invalid number of X");
      case 1: 
        return ISO_8601_1_STRATEGY;
      case 2: 
        return ISO_8601_2_STRATEGY;
      }
      return ISO_8601_3_STRATEGY;
    }
    
    boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.pattern);
      return true;
    }
    
    void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString)
    {
      if (paramString.equals("Z"))
      {
        paramCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
        return;
      }
      paramCalendar.setTimeZone(TimeZone.getTimeZone("GMT" + paramString));
    }
  }
  
  static class NumberStrategy
    extends FastDateParser.Strategy
  {
    private final int field;
    
    NumberStrategy(int paramInt)
    {
      super();
      this.field = paramInt;
    }
    
    boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder)
    {
      if (paramFastDateParser.isNextNumber()) {
        paramStringBuilder.append("(\\p{Nd}{").append(paramFastDateParser.getFieldWidth()).append("}+)");
      }
      for (;;)
      {
        return true;
        paramStringBuilder.append("(\\p{Nd}++)");
      }
    }
    
    boolean isNumber()
    {
      return true;
    }
    
    int modify(int paramInt)
    {
      return paramInt;
    }
    
    void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString)
    {
      paramCalendar.set(this.field, modify(Integer.parseInt(paramString)));
    }
  }
  
  static abstract class Strategy
  {
    abstract boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder);
    
    boolean isNumber()
    {
      return false;
    }
    
    void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString) {}
  }
  
  static class TimeZoneStrategy
    extends FastDateParser.Strategy
  {
    private static final int ID = 0;
    private static final int LONG_DST = 3;
    private static final int LONG_STD = 1;
    private static final int SHORT_DST = 4;
    private static final int SHORT_STD = 2;
    private final SortedMap<String, TimeZone> tzNames = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    private final String validTimeZoneChars;
    
    TimeZoneStrategy(Locale paramLocale)
    {
      super();
      paramLocale = DateFormatSymbols.getInstance(paramLocale).getZoneStrings();
      int j = paramLocale.length;
      int i = 0;
      if (i < j)
      {
        localIterator = paramLocale[i];
        if (localIterator[0].startsWith("GMT")) {}
        for (;;)
        {
          i += 1;
          break;
          TimeZone localTimeZone = TimeZone.getTimeZone(localIterator[0]);
          if (!this.tzNames.containsKey(localIterator[1])) {
            this.tzNames.put(localIterator[1], localTimeZone);
          }
          if (!this.tzNames.containsKey(localIterator[2])) {
            this.tzNames.put(localIterator[2], localTimeZone);
          }
          if (localTimeZone.useDaylightTime())
          {
            if (!this.tzNames.containsKey(localIterator[3])) {
              this.tzNames.put(localIterator[3], localTimeZone);
            }
            if (!this.tzNames.containsKey(localIterator[4])) {
              this.tzNames.put(localIterator[4], localTimeZone);
            }
          }
        }
      }
      paramLocale = new StringBuilder();
      paramLocale.append("(GMT[+-]\\d{1,2}:\\d{2}").append('|');
      paramLocale.append("[+-]\\d{4}").append('|');
      Iterator localIterator = this.tzNames.keySet().iterator();
      while (localIterator.hasNext()) {
        FastDateParser.escapeRegex(paramLocale, (String)localIterator.next(), false).append('|');
      }
      paramLocale.setCharAt(paramLocale.length() - 1, ')');
      this.validTimeZoneChars = paramLocale.toString();
    }
    
    boolean addRegex(FastDateParser paramFastDateParser, StringBuilder paramStringBuilder)
    {
      paramStringBuilder.append(this.validTimeZoneChars);
      return true;
    }
    
    void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString)
    {
      if ((paramString.charAt(0) == '+') || (paramString.charAt(0) == '-')) {
        paramFastDateParser = TimeZone.getTimeZone("GMT" + paramString);
      }
      TimeZone localTimeZone;
      do
      {
        for (;;)
        {
          paramCalendar.setTimeZone(paramFastDateParser);
          return;
          if (!paramString.startsWith("GMT")) {
            break;
          }
          paramFastDateParser = TimeZone.getTimeZone(paramString);
        }
        localTimeZone = (TimeZone)this.tzNames.get(paramString);
        paramFastDateParser = localTimeZone;
      } while (localTimeZone != null);
      throw new IllegalArgumentException(paramString + " is not a supported timezone name");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FastDateParser
 * JD-Core Version:    0.7.0.1
 */