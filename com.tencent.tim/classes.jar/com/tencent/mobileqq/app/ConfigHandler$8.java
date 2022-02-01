package com.tencent.mobileqq.app;

import accy;
import com.tencent.qphone.base.util.QLog;
import protocol.KQQConfig.GetResourceRespInfo;
import wne;

public class ConfigHandler$8
  implements Runnable
{
  public ConfigHandler$8(accy paramaccy, GetResourceRespInfo paramGetResourceRespInfo) {}
  
  public void run()
  {
    if (!accy.a(this.this$0, this.c.strPkgName, 10000L)) {
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions dpc aio_eggs is false");
      }
    }
    while (wne.a().bH() != null) {
      return;
    }
    wne.a().dj(this.this$0.app.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler.8
 * JD-Core Version:    0.7.0.1
 */