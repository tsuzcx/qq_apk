package com.tencent.qqmail.widget.calendar;

import com.tencent.qqmail.model.mail.watcher.CalendarScheduleTableHookWatcher;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.timer.WidgetDataChangeTimer;
import com.tencent.qqmail.widget.QMWidgetDataManager;
import moai.core.watcher.Watchers;

public class CalendarWidgetManager
  extends QMWidgetDataManager
{
  private static final String TAG = "CalendarWidgetManager";
  private static volatile CalendarWidgetManager instance;
  private boolean hasInitDone = false;
  private CalendarScheduleTableHookWatcher watcher = new CalendarWidgetManager.1(this);
  private WidgetDataChangeTimer widgetDataChangeTimer = new WidgetDataChangeTimer();
  
  public static CalendarWidgetManager getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null)
      {
        instance = new CalendarWidgetManager();
        instance.init();
      }
      return instance;
    }
    finally {}
  }
  
  public void accountChange()
  {
    QMLog.log(4, "CalendarWidgetManager", "帐号切换");
    notifyDataChange();
  }
  
  public void init()
  {
    super.init();
    QMLog.log(4, "CalendarWidgetManager", "CalendarWidgetManager init");
    Watchers.bind(this.watcher);
  }
  
  public boolean isHasInitDone()
  {
    return this.hasInitDone;
  }
  
  public void notifyDataChange()
  {
    this.widgetDataChangeTimer.startWidgetDataChangeTimer(new CalendarWidgetManager.2(this), 500L);
  }
  
  public void release()
  {
    super.release();
    Watchers.unbind(this.watcher);
    instance = null;
  }
  
  public void setHasInitDone(boolean paramBoolean)
  {
    if (paramBoolean) {
      notifyDataChange();
    }
    this.hasInitDone = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.calendar.CalendarWidgetManager
 * JD-Core Version:    0.7.0.1
 */