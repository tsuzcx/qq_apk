package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.report.MiniGamePerformanceStatics;

class FileJsPlugin$22
  implements Runnable
{
  FileJsPlugin$22(FileJsPlugin paramFileJsPlugin, String paramString, boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    MiniGamePerformanceStatics.getInstance().recordFileApiTimeCost(this.val$event, this.val$isSuccess, this.val$waitingTime, this.val$workingTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.22
 * JD-Core Version:    0.7.0.1
 */