package com.tencent.open.appstore.report;

import com.tencent.replacemonitor.replace.ReplaceMonitor;

public final class AppCenterReporter$6
  implements Runnable
{
  public AppCenterReporter$6(String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    ReplaceMonitor.get().onAppInstalled(this.abn, this.ddo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.appstore.report.AppCenterReporter.6
 * JD-Core Version:    0.7.0.1
 */