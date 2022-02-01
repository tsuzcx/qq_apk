package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class TaskManager$1
  implements INetInfoHandler
{
  TaskManager$1(TaskManager paramTaskManager) {}
  
  public void onNetMobile2None()
  {
    this.this$0.accept(TaskManager.getWifiStateJson("NONE"));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.this$0.accept(TaskManager.getWifiStateJson("WIFI"));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    this.this$0.accept(TaskManager.getWifiStateJson("WWAN"));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    this.this$0.accept(TaskManager.getWifiStateJson("WIFI"));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.this$0.accept(TaskManager.getWifiStateJson("WWAN"));
  }
  
  public void onNetWifi2None()
  {
    this.this$0.accept(TaskManager.getWifiStateJson("NONE"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.1
 * JD-Core Version:    0.7.0.1
 */