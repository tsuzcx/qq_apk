package com.tencent.qqmail.activity.setting.tableactivity.model;

import android.app.Activity;

public class StartActivityTableItem
  extends TableItem
{
  private Class<? extends Activity> activityClass;
  
  public StartActivityTableItem(int paramInt1, int paramInt2, Class<? extends Activity> paramClass)
  {
    super(paramInt1, paramInt2);
    this.activityClass = paramClass;
  }
  
  public Class<? extends Activity> getActivityClass()
  {
    return this.activityClass;
  }
  
  public void setActivityClass(Class<? extends Activity> paramClass)
  {
    this.activityClass = paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.model.StartActivityTableItem
 * JD-Core Version:    0.7.0.1
 */