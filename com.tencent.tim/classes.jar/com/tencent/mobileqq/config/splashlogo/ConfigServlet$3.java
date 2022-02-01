package com.tencent.mobileqq.config.splashlogo;

import aevk;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

public class ConfigServlet$3
  implements Runnable
{
  public void run()
  {
    boolean bool1 = false;
    int i;
    if (!this.ao.exists())
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "begin download url is " + this.val$url + " file is " + this.ao.getAbsolutePath() + " md5 " + this.val$md5);
      }
      bool1 = HttpDownloadUtil.a((AppInterface)this.this$0.getAppRuntime(), this.val$url, this.ao);
      if (bool1) {
        if (!this.ao.exists()) {}
      }
    }
    label276:
    label279:
    for (;;)
    {
      try
      {
        bool2 = MD5.getFileMD5(this.ao).equalsIgnoreCase(this.val$md5);
        if (!bool2) {}
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("SPLASH_ConfigServlet", 2, "down load success but check md5 failed");
          }
          bool1 = false;
          i += 1;
          if (bool1) {
            break label279;
          }
          if (i < 2) {
            break label276;
          }
          if ((!bool1) && (this.ao != null) && (this.ao.exists())) {
            this.ao.delete();
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            boolean bool2;
            bool1 = false;
          }
        }
        localThrowable1 = localThrowable1;
      }
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("SPLASH_ConfigServlet", 2, "down load pic failed try again");
      }
      continue;
      try
      {
        bool2 = MD5.getFileMD5(this.ao).equalsIgnoreCase(this.val$md5);
        if (!bool2) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SPLASH_ConfigServlet", 2, "splash has a file don't need download but check md5 get a exception");
        }
        localException.printStackTrace();
      }
      continue;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.3
 * JD-Core Version:    0.7.0.1
 */