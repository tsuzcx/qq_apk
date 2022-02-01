package com.tencent.monitor.file;

import anpl;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public final class ExternalDirFileOperationMonitor$1
  implements Runnable
{
  public ExternalDirFileOperationMonitor$1(String paramString) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("key_open_file_path", this.val$path);
    String str = "0";
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    anpl.c(str, "external_dir_file_Operation", localHashMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.monitor.file.ExternalDirFileOperationMonitor.1
 * JD-Core Version:    0.7.0.1
 */