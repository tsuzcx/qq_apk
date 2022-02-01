package com.tencent.mobileqq.app;

public class ThreadSetting
{
  public static int CLR = 2;
  public static int PROCESS_QQ;
  public static boolean isGrayVersion;
  public static boolean isPublicVersion = true;
  public static boolean logcatBgTaskMonitor;
  public static String revision;
  public static int sProcessId;
  
  static
  {
    isGrayVersion = false;
    revision = "0";
    PROCESS_QQ = 1;
    sProcessId = -1;
    logcatBgTaskMonitor = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadSetting
 * JD-Core Version:    0.7.0.1
 */