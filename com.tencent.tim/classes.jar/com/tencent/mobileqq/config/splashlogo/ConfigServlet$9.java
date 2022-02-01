package com.tencent.mobileqq.config.splashlogo;

import acgl;
import aevk;
import aqmj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;

public class ConfigServlet$9
  implements Runnable
{
  public ConfigServlet$9(aevk paramaevk, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.getAppRuntime();
    boolean bool = ((acgl)localQQAppInterface.getManager(123)).a(this.b);
    aqmj.g(localQQAppInterface.getApp(), this.b.version.get(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.9
 * JD-Core Version:    0.7.0.1
 */