package com.tencent.mobileqq.app;

import abcy;
import accy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;

public class ConfigHandler$3
  implements Runnable
{
  public ConfigHandler$3(accy paramaccy, String paramString, abcy paramabcy, long paramLong) {}
  
  public void run()
  {
    boolean bool = false;
    File localFile = new File(this.this$0.app.getApplication().getFilesDir(), "WeatherResource.zip");
    String str = MsfSdkUtils.insertMtype("ConfigCheck", this.val$url);
    int i = HttpDownloadUtil.a(this.this$0.app, str, localFile);
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "handleWeatherResources download: " + i + ",downloadpath" + localFile.getAbsolutePath());
    }
    if (i == 0) {
      bool = this.b.g(this.Pk, localFile.getAbsolutePath());
    }
    this.this$0.notifyUI(9, bool, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.3
 * JD-Core Version:    0.7.0.1
 */