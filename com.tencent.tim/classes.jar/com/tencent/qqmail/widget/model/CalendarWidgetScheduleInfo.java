package com.tencent.qqmail.widget.model;

import com.tencent.qqmail.utilities.QMMath;
import java.util.ArrayList;
import java.util.Iterator;

public class CalendarWidgetScheduleInfo
{
  private int color;
  private int id;
  private long startTime;
  private String subject;
  
  public static int generateHash(ArrayList<CalendarWidgetItemInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return QMMath.hashInt("");
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      CalendarWidgetItemInfo localCalendarWidgetItemInfo = (CalendarWidgetItemInfo)paramArrayList.next();
      localStringBuilder.append(localCalendarWidgetItemInfo.getId());
      localStringBuilder.append("^");
      localStringBuilder.append(localCalendarWidgetItemInfo.getHourMinuteString());
      localStringBuilder.append("^");
      localStringBuilder.append(localCalendarWidgetItemInfo.getSchedule());
      localStringBuilder.append("^");
    }
    return QMMath.hashInt(localStringBuilder.toString());
  }
  
  public int getColor()
  {
    return this.color;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public long getStartTime()
  {
    return this.startTime;
  }
  
  public String getSubject()
  {
    return this.subject;
  }
  
  public void setColor(int paramInt)
  {
    this.color = paramInt;
  }
  
  public void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setStartTime(long paramLong)
  {
    this.startTime = paramLong;
  }
  
  public void setSubject(String paramString)
  {
    this.subject = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.model.CalendarWidgetScheduleInfo
 * JD-Core Version:    0.7.0.1
 */