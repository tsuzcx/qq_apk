package com.tencent.tmassistantbase.util;

import android.util.Log;

public class OuterCallLog
{
  public static final String OuterCall_DownloadApi_DoDownloadAction = "OuterCall_DownloadApi_DoDownloadAction";
  public static final String OuterCall_DownloadApi_DoDownloadActionByMyApp = "OuterCall_DownloadApi_DoDownloadActionByMyApp";
  public static final String OuterCall_JS_DoDownloadAction = "OuterCall_JS_DoDownloadAction";
  public static final String OuterCall_MyAppApi_HandleDownloadAction = "OuterCall_MyAppApi_HandleDownloadAction";
  public static final String OuterCall_MyAppApi_StartToAppDetail = "OuterCall_MyAppApi_StartToAppDetail";
  public static final String OuterCall_MyAppApi_StartToDownloadList = "OuterCall_MyAppApi_StartToDownloadList";
  public static final String OuterCall_QQ_Report = "OuterCall_QQ_Report";
  public static final String OuterCall_TMAssistantCallYYB_V2_StartToAppDetail = "OuterCall_TMAssistantCallYYB_V2_StartToAppDetail";
  public static final String OuterCall_TMAssistantCallYYB_V2_StartToDownloadList = "OuterCall_TMAssistantCallYYB_V2_StartToDownloadList";
  public static final String OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End = "OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_End";
  public static final String OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start = "OuterCall_TMQQDownloaderDataProcessor_HandleDownloadTask_Start";
  public static OuterCallLog sInstance = null;
  public volatile long lastTime = 0L;
  
  public static OuterCallLog getsInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new OuterCallLog();
      }
      OuterCallLog localOuterCallLog = sInstance;
      return localOuterCallLog;
    }
    finally {}
  }
  
  public void printCostTime(String paramString)
  {
    if (this.lastTime == 0L) {
      reset();
    }
    Log.i("OuterCallFromQQ", paramString + " costTime = " + (System.currentTimeMillis() - this.lastTime));
    this.lastTime = System.currentTimeMillis();
  }
  
  public void reset()
  {
    this.lastTime = System.currentTimeMillis();
    Log.i("OuterCallFromQQ", "reset_sdk");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistantbase.util.OuterCallLog
 * JD-Core Version:    0.7.0.1
 */