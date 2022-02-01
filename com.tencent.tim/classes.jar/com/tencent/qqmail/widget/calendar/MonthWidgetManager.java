package com.tencent.qqmail.widget.calendar;

import android.content.Intent;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.widget.QMWidgetDataManager;

public class MonthWidgetManager
  extends QMWidgetDataManager
{
  private static volatile MonthWidgetManager instance;
  
  public static MonthWidgetManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new MonthWidgetManager();
      }
      return instance;
    }
    finally {}
  }
  
  public void accountChange()
  {
    notifyDataChange();
  }
  
  public void notifyDataChange()
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.qqmail.widget.month.refresh.ui");
    QMApplicationContext.sharedInstance().sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.MonthWidgetManager
 * JD-Core Version:    0.7.0.1
 */