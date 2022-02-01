package com.tencent.qqmail.activity.setting;

import com.tencent.qqmail.utilities.log.QMLog;

public class PasswordErrHandling
{
  private static boolean handling = false;
  private static boolean userClickHandle = false;
  
  public static boolean isHandling()
  {
    return handling;
  }
  
  public static boolean isUserClickHandle()
  {
    return userClickHandle;
  }
  
  public static void setHandling(boolean paramBoolean)
  {
    QMLog.log(4, "PasswordErrHandling", "set handling : " + paramBoolean);
    if (!paramBoolean) {
      setUserClickHandle(false);
    }
    handling = paramBoolean;
  }
  
  public static void setUserClickHandle(boolean paramBoolean)
  {
    userClickHandle = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.PasswordErrHandling
 * JD-Core Version:    0.7.0.1
 */