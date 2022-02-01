package com.tencent.mobileqq.config.splashlogo;

import aevk;
import aqmr;
import com.tencent.mobileqq.app.NearbyGrayTipsManager;
import com.tencent.mobileqq.app.NearbyGrayTipsManager.GrayTipsConfig;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import oicq.wlogin_sdk.tools.MD5;

public class ConfigServlet$8
  implements Runnable
{
  public ConfigServlet$8(aevk paramaevk, String paramString1, File paramFile, String paramString2, NearbyGrayTipsManager paramNearbyGrayTipsManager) {}
  
  public void run()
  {
    try
    {
      if (HttpDownloadUtil.a((QQAppInterface)this.this$0.getAppRuntime(), this.val$fUrl, this.val$file))
      {
        if (QLog.isColorLevel()) {
          QLog.d("nearby_aio_operation_gray_tips", 2, "file download succeed. url=" + this.val$fUrl);
        }
        Object localObject = MD5.getFileMD5(this.val$file);
        if ((aqmr.isEmpty(this.bCe)) || ((localObject != null) && (this.bCe.equals(((String)localObject).toLowerCase()))))
        {
          localObject = NearbyGrayTipsManager.a(this.val$file);
          if (localObject != null)
          {
            this.c.a((NearbyGrayTipsManager.GrayTipsConfig)localObject);
            this.c.a((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            this.c.b((NearbyGrayTipsManager.GrayTipsConfig)localObject, true);
            NearbyGrayTipsManager.a((NearbyGrayTipsManager.GrayTipsConfig)localObject);
          }
          this.val$file.delete();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("nearby_aio_operation_gray_tips", 2, "file download failed. url=" + this.val$fUrl);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("nearby_aio_operation_gray_tips", 2, "download file exp=", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.8
 * JD-Core Version:    0.7.0.1
 */