package com.tencent.mobileqq.app;

import accy;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceRespInfo;
import wne;

public class ConfigHandler$7
  implements Runnable
{
  public ConfigHandler$7(accy paramaccy, GetResourceRespInfo paramGetResourceRespInfo, String paramString, long paramLong) {}
  
  public void run()
  {
    if (!accy.a(this.this$0, this.c.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    do
    {
      return;
      File localFile = new File(this.this$0.app.getApplication().getFilesDir(), "eggs_config.zip");
      String str = MsfSdkUtils.insertMtype("ConfigCheck", this.val$url);
      int i = HttpDownloadUtil.a(this.this$0.app, str, localFile);
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions download: " + i);
      }
      if (i == 0)
      {
        wne.a().b(this.this$0.app, this.Pk, localFile.getAbsolutePath());
        return;
      }
    } while (wne.a().bH() != null);
    wne.a().dj(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.7
 * JD-Core Version:    0.7.0.1
 */