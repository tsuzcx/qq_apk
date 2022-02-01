package org.apache.commons.lang3.time;

import java.util.Calendar;

final class FastDateParser$1
  extends FastDateParser.NumberStrategy
{
  FastDateParser$1(int paramInt)
  {
    super(paramInt);
  }
  
  void setCalendar(FastDateParser paramFastDateParser, Calendar paramCalendar, String paramString)
  {
    int j = Integer.parseInt(paramString);
    int i = j;
    if (j < 100) {
      i = FastDateParser.access$300(paramFastDateParser, j);
    }
    paramCalendar.set(1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.lang3.time.FastDateParser.1
 * JD-Core Version:    0.7.0.1
 */