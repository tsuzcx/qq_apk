package com.tencent.mobileqq.config.splashlogo;

import acdy;
import aevk;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;

public class ConfigServlet$11
  implements Runnable
{
  public ConfigServlet$11(aevk paramaevk, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.getAppRuntime();
    if ((this.a.content_list != null) && (this.a.content_list.size() > 0) && (this.a.version != null))
    {
      str = (String)this.a.content_list.get(0);
      i = this.a.version.get();
      j = aqmj.bf(localQQAppInterface.getApp());
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content: " + str + ",version: " + this.a.version.get());
      }
      if (i > j) {
        acdy.h(localQQAppInterface, str, i);
      }
    }
    while (!QLog.isColorLevel())
    {
      String str;
      int i;
      int j;
      return;
    }
    QLog.d("SPLASH_ConfigServlet", 2, "receiveAllConfigs|type: 63,content_list is empty ,version: " + this.a.version.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.11
 * JD-Core Version:    0.7.0.1
 */