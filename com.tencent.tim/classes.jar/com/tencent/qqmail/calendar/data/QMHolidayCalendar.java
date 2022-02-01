package com.tencent.qqmail.calendar.data;

import com.tencent.qqmail.QMApplicationContext;

public class QMHolidayCalendar
{
  private static final String HOLIDAY_TAG = QMApplicationContext.sharedInstance().getString(2131694631);
  public static final int HOLIDAY_TYPE = 1;
  public static final int NOT_HOLIDAY = -1;
  private static final String WORK_TAG = QMApplicationContext.sharedInstance().getString(2131721911);
  public static final int WORK_TYPE = 0;
  private int day;
  private boolean isHoliday;
  private int month;
  private int year;
  
  public QMHolidayCalendar(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.year = paramInt1;
    this.month = paramInt2;
    this.day = paramInt3;
    this.isHoliday = paramBoolean;
  }
  
  public int getDay()
  {
    return this.day;
  }
  
  public String getHolidayTag()
  {
    if (this.isHoliday) {
      return HOLIDAY_TAG;
    }
    return WORK_TAG;
  }
  
  public int getMonth()
  {
    return this.month;
  }
  
  public int getYear()
  {
    return this.year;
  }
  
  public boolean isHoliday()
  {
    return this.isHoliday;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.calendar.data.QMHolidayCalendar
 * JD-Core Version:    0.7.0.1
 */