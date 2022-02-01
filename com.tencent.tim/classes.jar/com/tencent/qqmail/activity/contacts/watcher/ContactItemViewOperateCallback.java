package com.tencent.qqmail.activity.contacts.watcher;

public abstract interface ContactItemViewOperateCallback
{
  public static final int CLICK_EMAIL_TO_COMPOSE = 0;
  public static final int CLICK_TO_COPY = 1;
  
  public abstract void callPhone(String paramString);
  
  public abstract void clickToCopy(String paramString, int paramInt);
  
  public abstract void goToCalendar(String paramString);
  
  public abstract void notifyDataChange();
  
  public abstract void removeSelf();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.watcher.ContactItemViewOperateCallback
 * JD-Core Version:    0.7.0.1
 */