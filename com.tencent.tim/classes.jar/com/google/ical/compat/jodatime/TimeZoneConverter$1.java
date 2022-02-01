package com.google.ical.compat.jodatime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

final class TimeZoneConverter$1
  extends TimeZone
{
  private static final long serialVersionUID = 58752546800455L;
  
  TimeZoneConverter$1(DateTimeZone paramDateTimeZone) {}
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof TimeZone)) {}
    do
    {
      return false;
      paramObject = (TimeZone)paramObject;
    } while ((!getID().equals(paramObject.getID())) || (!hasSameRules(paramObject)));
    return true;
  }
  
  public int getOffset(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    paramInt5 = paramInt6 / 3600000;
    int i = paramInt6 % 3600000;
    paramInt6 = i / 60000;
    int j = i % 60000;
    i = j / 1000;
    j %= 1000;
    if (paramInt1 == 0) {}
    for (paramInt1 = -(paramInt2 - 1);; paramInt1 = paramInt2) {
      try
      {
        DateTime localDateTime = new DateTime(paramInt1, paramInt3 + 1, paramInt4, paramInt5, paramInt6, i, j, this.val$dtz);
        return getOffset(new DateTime(paramInt1, paramInt3 + 1, paramInt4, paramInt5, paramInt6, i, j, DateTimeZone.forOffsetMillis(this.val$dtz.getStandardOffset(localDateTime.getMillis()))).getMillis());
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          Object localObject;
          if (paramInt5 < 23)
          {
            localObject = new DateTime(paramInt1, paramInt3 + 1, paramInt4, paramInt5 + 1, paramInt6, i, j, this.val$dtz);
          }
          else
          {
            localObject = new GregorianCalendar();
            ((Calendar)localObject).clear();
            ((Calendar)localObject).setTimeZone(TimeZone.getTimeZone("UTC"));
            ((Calendar)localObject).set(paramInt1, paramInt3, paramInt4, paramInt5, paramInt6, i);
            ((Calendar)localObject).add(11, 1);
            localObject = new DateTime(((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5), ((Calendar)localObject).get(11), paramInt6, i, j, this.val$dtz);
          }
        }
      }
    }
  }
  
  public int getOffset(long paramLong)
  {
    return this.val$dtz.getOffset(paramLong);
  }
  
  public int getRawOffset()
  {
    return this.val$dtz.getStandardOffset(0L);
  }
  
  public int hashCode()
  {
    return getID().hashCode();
  }
  
  public boolean inDaylightTime(Date paramDate)
  {
    long l = paramDate.getTime();
    return this.val$dtz.getStandardOffset(l) != this.val$dtz.getOffset(l);
  }
  
  public void setRawOffset(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return this.val$dtz.toString();
  }
  
  public boolean useDaylightTime()
  {
    long l = TimeZoneConverter.access$000();
    return l != this.val$dtz.nextTransition(l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.google.ical.compat.jodatime.TimeZoneConverter.1
 * JD-Core Version:    0.7.0.1
 */