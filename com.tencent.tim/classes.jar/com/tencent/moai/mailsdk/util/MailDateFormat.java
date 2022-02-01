package com.tencent.moai.mailsdk.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.text.FieldPosition;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class MailDateFormat
  extends SimpleDateFormat
{
  private static final int LEAP_SECOND = 60;
  private static final String PATTERN = "EEE, d MMM yyyy HH:mm:ss Z (z)";
  private static final int UNKNOWN_DAY_NAME = -1;
  private static final TimeZone UTC = TimeZone.getTimeZone("UTC");
  private static final long serialVersionUID = -8148227605210628779L;
  
  public MailDateFormat()
  {
    super("EEE, d MMM yyyy HH:mm:ss Z (z)", Locale.US);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    super.applyPattern("EEE, d MMM yyyy HH:mm:ss Z (z)");
  }
  
  private void superApplyPattern(String paramString)
  {
    super.applyPattern(paramString);
  }
  
  private Date toDate(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramInt7 == 60) {
      paramInt7 = 59;
    }
    for (;;)
    {
      TimeZone localTimeZone = this.calendar.getTimeZone();
      try
      {
        this.calendar.setTimeZone(UTC);
        this.calendar.clear();
        this.calendar.set(paramInt4, paramInt3, paramInt2, paramInt5, paramInt6, paramInt7);
        if ((paramInt1 == -1) || (paramInt1 == this.calendar.get(7)))
        {
          this.calendar.add(12, paramInt8);
          Date localDate = this.calendar.getTime();
          return localDate;
        }
        throw new IllegalArgumentException("Inconsistent day-name");
      }
      finally
      {
        this.calendar.setTimeZone(localTimeZone);
      }
    }
  }
  
  private Object writeReplace()
    throws ObjectStreamException
  {
    MailDateFormat localMailDateFormat = new MailDateFormat();
    localMailDateFormat.superApplyPattern("EEE, d MMM yyyy HH:mm:ss 'XXXXX' (z)");
    localMailDateFormat.setTimeZone(getTimeZone());
    return localMailDateFormat;
  }
  
  public StringBuffer format(Date paramDate, StringBuffer paramStringBuffer, FieldPosition paramFieldPosition)
  {
    return super.format(paramDate, paramStringBuffer, paramFieldPosition);
  }
  
  public Date parse(String paramString, ParsePosition paramParsePosition)
  {
    if ((paramString == null) || (paramParsePosition == null)) {
      throw new NullPointerException();
    }
    if ((paramParsePosition.getIndex() < 0) || (paramParsePosition.getIndex() >= paramString.length())) {
      return null;
    }
    if (isLenient()) {
      return new Rfc2822LenientParser(paramString, paramParsePosition).parse();
    }
    return new Rfc2822StrictParser(paramString, paramParsePosition).parse();
  }
  
  public Date parseMultiLine(String paramString)
    throws ParseException
  {
    String[] arrayOfString = paramString.split("\n");
    int i = arrayOfString.length - 1;
    while (i >= 0)
    {
      paramString = arrayOfString[i];
      int j = paramString.indexOf(";");
      if (j != -1) {}
      for (paramString = parse(paramString.substring(j + 1).trim()); paramString != null; paramString = parse(paramString.trim())) {
        return paramString;
      }
      i -= 1;
    }
    return null;
  }
  
  public void setCalendar(Calendar paramCalendar)
  {
    throw new UnsupportedOperationException("Method setCalendar() shouldn't be called");
  }
  
  public void setNumberFormat(NumberFormat paramNumberFormat)
  {
    throw new UnsupportedOperationException("Method setNumberFormat() shouldn't be called");
  }
  
  static abstract class AbstractDateParser
  {
    static final int INVALID_CHAR = -1;
    static final int MAX_YEAR_DIGITS = 8;
    final ParsePosition pos;
    final String text;
    
    AbstractDateParser(String paramString, ParsePosition paramParsePosition)
    {
      this.text = paramString;
      this.pos = paramParsePosition;
    }
    
    final int getAsciiDigit()
    {
      int i = -1;
      int j = getChar();
      if ((48 <= j) && (j <= 57)) {
        i = Character.digit((char)j, 10);
      }
      while (j == -1) {
        return i;
      }
      this.pos.setIndex(this.pos.getIndex() - 1);
      return -1;
    }
    
    final int getChar()
    {
      if (this.pos.getIndex() < this.text.length())
      {
        int i = this.text.charAt(this.pos.getIndex());
        this.pos.setIndex(this.pos.getIndex() + 1);
        return i;
      }
      return -1;
    }
    
    boolean isValidZoneOffset(int paramInt)
    {
      return paramInt % 100 < 60;
    }
    
    final Date parse()
    {
      int i = this.pos.getIndex();
      try
      {
        Date localDate = tryParse();
        return localDate;
      }
      catch (Exception localException)
      {
        this.pos.setErrorIndex(this.pos.getIndex());
        this.pos.setIndex(i + 1);
      }
      return null;
    }
    
    final int parseAsciiDigits(int paramInt)
      throws ParseException
    {
      return parseAsciiDigits(paramInt, paramInt);
    }
    
    final int parseAsciiDigits(int paramInt1, int paramInt2)
      throws ParseException
    {
      return parseAsciiDigits(paramInt1, paramInt2, false);
    }
    
    final int parseAsciiDigits(int paramInt1, int paramInt2, boolean paramBoolean)
      throws ParseException
    {
      int i = 0;
      int j = 0;
      while ((i < paramInt2) && (peekAsciiDigit()))
      {
        j = j * 10 + getAsciiDigit();
        i += 1;
      }
      if ((i < paramInt1) || ((i == paramInt2) && (!paramBoolean) && (peekAsciiDigit())))
      {
        this.pos.setIndex(this.pos.getIndex() - i);
        if (paramInt1 == paramInt2) {}
        for (String str = Integer.toString(paramInt1);; str = "between " + paramInt1 + " and " + paramInt2) {
          throw new ParseException("Invalid input: expected " + str + " ASCII digits", this.pos.getIndex());
        }
      }
      return j;
    }
    
    final void parseChar(char paramChar)
      throws ParseException
    {
      if (!skipChar(paramChar)) {
        throw new ParseException("Invalid input: expected '" + paramChar + "'", this.pos.getIndex());
      }
    }
    
    final int parseDayName()
      throws ParseException
    {
      switch (getChar())
      {
      default: 
      case 83: 
      case 84: 
      case 77: 
      case 87: 
      case 70: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  this.pos.setIndex(this.pos.getIndex() - 1);
                  throw new ParseException("Invalid day-name", this.pos.getIndex());
                  if (skipPair('u', 'n')) {
                    return 1;
                  }
                } while (!skipPair('a', 't'));
                return 7;
                if (skipPair('u', 'e')) {
                  return 3;
                }
              } while (!skipPair('h', 'u'));
              return 5;
            } while (!skipPair('o', 'n'));
            return 2;
          } while (!skipPair('e', 'd'));
          return 4;
        } while (!skipPair('r', 'i'));
        return 6;
      }
      throw new ParseException("Invalid day-name", this.pos.getIndex());
    }
    
    final void parseFoldingWhiteSpace()
      throws ParseException
    {
      if (!skipFoldingWhiteSpace()) {
        throw new ParseException("Invalid input: expected FWS", this.pos.getIndex());
      }
    }
    
    final int parseMonthName(boolean paramBoolean)
      throws ParseException
    {
      switch (getChar())
      {
      default: 
      case 106: 
      case 74: 
      case 109: 
      case 77: 
      case 97: 
      case 65: 
      case 100: 
      case 68: 
      case 111: 
      case 79: 
      case 115: 
      case 83: 
      case 110: 
      case 78: 
      case 102: 
      case 70: 
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      for (;;)
                      {
                        this.pos.setIndex(this.pos.getIndex() - 1);
                        throw new ParseException("Invalid month", this.pos.getIndex());
                        if (!paramBoolean) {
                          if ((skipChar('u')) || ((!paramBoolean) && (skipChar('U'))))
                          {
                            if ((skipChar('l')) || ((!paramBoolean) && (skipChar('L')))) {
                              return 6;
                            }
                            if ((skipChar('n')) || ((!paramBoolean) && (skipChar('N')))) {
                              return 5;
                            }
                            this.pos.setIndex(this.pos.getIndex() - 1);
                          }
                          else if ((skipPair('a', 'n')) || ((!paramBoolean) && (skipAlternativePair('a', 'A', 'n', 'N'))))
                          {
                            return 0;
                            if ((!paramBoolean) && ((skipChar('a')) || ((!paramBoolean) && (skipChar('A')))))
                            {
                              if ((skipChar('r')) || ((!paramBoolean) && (skipChar('R')))) {
                                return 2;
                              }
                              if ((skipChar('y')) || ((!paramBoolean) && (skipChar('Y')))) {
                                return 4;
                              }
                              this.pos.setIndex(this.pos.getIndex() - 1);
                            }
                          }
                        }
                      }
                    } while (paramBoolean);
                    if ((skipPair('u', 'g')) || ((!paramBoolean) && (skipAlternativePair('u', 'U', 'g', 'G')))) {
                      return 7;
                    }
                  } while ((!skipPair('p', 'r')) && ((paramBoolean) || (!skipAlternativePair('p', 'P', 'r', 'R'))));
                  return 3;
                } while ((paramBoolean) || ((!skipPair('e', 'c')) && ((paramBoolean) || (!skipAlternativePair('e', 'E', 'c', 'C')))));
                return 11;
              } while ((paramBoolean) || ((!skipPair('c', 't')) && ((paramBoolean) || (!skipAlternativePair('c', 'C', 't', 'T')))));
              return 9;
            } while ((paramBoolean) || ((!skipPair('e', 'p')) && ((paramBoolean) || (!skipAlternativePair('e', 'E', 'p', 'P')))));
            return 8;
          } while ((paramBoolean) || ((!skipPair('o', 'v')) && ((paramBoolean) || (!skipAlternativePair('o', 'O', 'v', 'V')))));
          return 10;
        } while ((paramBoolean) || ((!skipPair('e', 'b')) && ((paramBoolean) || (!skipAlternativePair('e', 'E', 'b', 'B')))));
        return 1;
      }
      throw new ParseException("Invalid month", this.pos.getIndex());
    }
    
    final int parseZoneOffset()
      throws ParseException
    {
      int i = -1;
      int k = getChar();
      if ((k == 43) || (k == 45))
      {
        int j = parseAsciiDigits(4, 4, true);
        if (!isValidZoneOffset(j))
        {
          this.pos.setIndex(this.pos.getIndex() - 5);
          throw new ParseException("Invalid zone", this.pos.getIndex());
        }
        if (k == 43) {}
        for (;;)
        {
          return i * (j / 100 * 60 + j % 100);
          i = 1;
        }
      }
      if (k != -1) {
        this.pos.setIndex(this.pos.getIndex() - 1);
      }
      throw new ParseException("Invalid zone", this.pos.getIndex());
    }
    
    final boolean peekAsciiDigit()
    {
      return (this.pos.getIndex() < this.text.length()) && ('0' <= this.text.charAt(this.pos.getIndex())) && (this.text.charAt(this.pos.getIndex()) <= '9');
    }
    
    final boolean peekChar(char paramChar)
    {
      return (this.pos.getIndex() < this.text.length()) && (this.text.charAt(this.pos.getIndex()) == paramChar);
    }
    
    boolean peekFoldingWhiteSpace()
    {
      return (this.pos.getIndex() < this.text.length()) && ((this.text.charAt(this.pos.getIndex()) == ' ') || (this.text.charAt(this.pos.getIndex()) == '\t') || (this.text.charAt(this.pos.getIndex()) == '\r'));
    }
    
    final boolean skipAlternative(char paramChar1, char paramChar2)
    {
      return (skipChar(paramChar1)) || (skipChar(paramChar2));
    }
    
    final boolean skipAlternativePair(char paramChar1, char paramChar2, char paramChar3, char paramChar4)
    {
      if (skipAlternative(paramChar1, paramChar2))
      {
        if (skipAlternative(paramChar3, paramChar4)) {
          return true;
        }
        this.pos.setIndex(this.pos.getIndex() - 1);
      }
      return false;
    }
    
    final boolean skipAlternativeTriple(char paramChar1, char paramChar2, char paramChar3, char paramChar4, char paramChar5, char paramChar6)
    {
      if (skipAlternativePair(paramChar1, paramChar2, paramChar3, paramChar4))
      {
        if (skipAlternative(paramChar5, paramChar6)) {
          return true;
        }
        this.pos.setIndex(this.pos.getIndex() - 2);
      }
      return false;
    }
    
    final boolean skipChar(char paramChar)
    {
      if ((this.pos.getIndex() < this.text.length()) && (this.text.charAt(this.pos.getIndex()) == paramChar))
      {
        this.pos.setIndex(this.pos.getIndex() + 1);
        return true;
      }
      return false;
    }
    
    boolean skipFoldingWhiteSpace()
    {
      if (skipChar(' ')) {
        if (!peekFoldingWhiteSpace()) {
          break label49;
        }
      }
      label16:
      int i;
      label49:
      label82:
      do
      {
        return true;
        this.pos.setIndex(this.pos.getIndex() - 1);
        do
        {
          i = this.pos.getIndex();
          if (!skipWhiteSpace()) {
            break label82;
          }
          if (!skipNewline()) {
            break label16;
          }
          if (skipWhiteSpace()) {
            break;
          }
          this.pos.setIndex(i);
          return false;
        } while (peekFoldingWhiteSpace());
        return false;
      } while ((skipNewline()) && (skipWhiteSpace()));
      this.pos.setIndex(i);
      return false;
    }
    
    final boolean skipNewline()
    {
      return skipPair('\r', '\n');
    }
    
    final boolean skipPair(char paramChar1, char paramChar2)
    {
      if (skipChar(paramChar1))
      {
        if (skipChar(paramChar2)) {
          return true;
        }
        this.pos.setIndex(this.pos.getIndex() - 1);
      }
      return false;
    }
    
    final boolean skipWhiteSpace()
    {
      int i = this.pos.getIndex();
      while (skipAlternative(' ', '\t')) {}
      return this.pos.getIndex() > i;
    }
    
    abstract Date tryParse()
      throws ParseException;
  }
  
  class Rfc2822LenientParser
    extends MailDateFormat.Rfc2822StrictParser
  {
    private Boolean hasDefaultFws;
    
    Rfc2822LenientParser(String paramString, ParsePosition paramParsePosition)
    {
      super(paramString, paramParsePosition);
    }
    
    boolean isMonthNameCaseSensitive()
    {
      return false;
    }
    
    boolean isValidZoneOffset(int paramInt)
    {
      return true;
    }
    
    int parseDay()
      throws ParseException
    {
      skipFoldingWhiteSpace();
      return parseAsciiDigits(1, 3);
    }
    
    void parseFwsBetweenTimeOfDayAndZone()
      throws ParseException
    {
      skipFoldingWhiteSpace();
    }
    
    void parseFwsInMonth()
      throws ParseException
    {
      if (this.hasDefaultFws == null)
      {
        if (!skipChar('-')) {}
        for (boolean bool = true;; bool = false)
        {
          this.hasDefaultFws = Boolean.valueOf(bool);
          skipFoldingWhiteSpace();
          return;
        }
      }
      if (this.hasDefaultFws.booleanValue())
      {
        skipFoldingWhiteSpace();
        return;
      }
      parseChar('-');
    }
    
    int parseHour()
      throws ParseException
    {
      return parseAsciiDigits(1, 2);
    }
    
    int parseMinute()
      throws ParseException
    {
      return parseAsciiDigits(1, 2);
    }
    
    int parseOptionalBegin()
    {
      while ((this.pos.getIndex() < this.text.length()) && (!peekAsciiDigit())) {
        this.pos.setIndex(this.pos.getIndex() + 1);
      }
      return -1;
    }
    
    int parseSecond()
      throws ParseException
    {
      return parseAsciiDigits(1, 2);
    }
    
    int parseYear()
      throws ParseException
    {
      int i = parseAsciiDigits(1, 8);
      if (i >= 1000) {
        return i;
      }
      if (i >= 50) {
        return i + 1900;
      }
      return i + 2000;
    }
    
    int parseZone()
      throws ParseException
    {
      int i;
      try
      {
        if (this.pos.getIndex() >= this.text.length()) {
          throw new ParseException("Missing zone", this.pos.getIndex());
        }
        if ((peekChar('+')) || (peekChar('-'))) {
          return parseZoneOffset();
        }
        if (skipAlternativePair('U', 'u', 'T', 't')) {
          return 0;
        }
        if (skipAlternativeTriple('G', 'g', 'M', 'm', 'T', 't')) {
          return 0;
        }
        if (skipAlternative('E', 'e')) {
          i = 4;
        }
        while (skipAlternativePair('S', 's', 'T', 't'))
        {
          i += 1;
          break label248;
          if (skipAlternative('C', 'c')) {
            i = 5;
          } else if (skipAlternative('M', 'm')) {
            i = 6;
          } else if (skipAlternative('P', 'p')) {
            i = 7;
          } else {
            throw new ParseException("Invalid zone", this.pos.getIndex());
          }
        }
        if (!skipAlternativePair('D', 'd', 'T', 't'))
        {
          this.pos.setIndex(this.pos.getIndex() - 1);
          throw new ParseException("Invalid zone", this.pos.getIndex());
        }
      }
      catch (ParseException localParseException)
      {
        return 0;
      }
      label248:
      return i * 60;
    }
    
    boolean peekFoldingWhiteSpace()
    {
      return (super.peekFoldingWhiteSpace()) || ((this.pos.getIndex() < this.text.length()) && (this.text.charAt(this.pos.getIndex()) == '\n'));
    }
    
    boolean skipFoldingWhiteSpace()
    {
      boolean bool = peekFoldingWhiteSpace();
      for (;;)
      {
        if (this.pos.getIndex() < this.text.length()) {}
        switch (this.text.charAt(this.pos.getIndex()))
        {
        default: 
          return bool;
        }
        this.pos.setIndex(this.pos.getIndex() + 1);
      }
    }
  }
  
  class Rfc2822StrictParser
    extends MailDateFormat.AbstractDateParser
  {
    Rfc2822StrictParser(String paramString, ParsePosition paramParsePosition)
    {
      super(paramParsePosition);
    }
    
    boolean isMonthNameCaseSensitive()
    {
      return true;
    }
    
    int parseDay()
      throws ParseException
    {
      skipFoldingWhiteSpace();
      return parseAsciiDigits(1, 2);
    }
    
    void parseFwsBetweenTimeOfDayAndZone()
      throws ParseException
    {
      parseFoldingWhiteSpace();
    }
    
    void parseFwsInMonth()
      throws ParseException
    {
      parseFoldingWhiteSpace();
    }
    
    int parseHour()
      throws ParseException
    {
      return parseAsciiDigits(2);
    }
    
    int parseMinute()
      throws ParseException
    {
      return parseAsciiDigits(2);
    }
    
    int parseMonth()
      throws ParseException
    {
      parseFwsInMonth();
      int i = parseMonthName(isMonthNameCaseSensitive());
      parseFwsInMonth();
      return i;
    }
    
    int parseOptionalBegin()
      throws ParseException
    {
      if (!peekAsciiDigit())
      {
        skipFoldingWhiteSpace();
        int i = parseDayName();
        parseChar(',');
        return i;
      }
      return -1;
    }
    
    int parseSecond()
      throws ParseException
    {
      return parseAsciiDigits(2);
    }
    
    int parseYear()
      throws ParseException
    {
      int i = parseAsciiDigits(4, 8);
      if (i >= 1900) {
        return i;
      }
      this.pos.setIndex(this.pos.getIndex() - 4);
      while (this.text.charAt(this.pos.getIndex() - 1) == '0') {
        this.pos.setIndex(this.pos.getIndex() - 1);
      }
      throw new ParseException("Invalid year", this.pos.getIndex());
    }
    
    int parseZone()
      throws ParseException
    {
      return parseZoneOffset();
    }
    
    Date tryParse()
      throws ParseException
    {
      int j = parseOptionalBegin();
      int k = parseDay();
      int m = parseMonth();
      int n = parseYear();
      parseFoldingWhiteSpace();
      int i1 = parseHour();
      parseChar(':');
      int i2 = parseMinute();
      if (skipChar(':')) {}
      for (int i = parseSecond();; i = 0)
      {
        parseFwsBetweenTimeOfDayAndZone();
        int i3 = parseZone();
        try
        {
          Date localDate = MailDateFormat.this.toDate(j, k, m, n, i1, i2, i, i3);
          return localDate;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          throw new ParseException("Invalid input: some of the calendar fields have invalid values, or day-name is inconsistent with date", this.pos.getIndex());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.moai.mailsdk.util.MailDateFormat
 * JD-Core Version:    0.7.0.1
 */