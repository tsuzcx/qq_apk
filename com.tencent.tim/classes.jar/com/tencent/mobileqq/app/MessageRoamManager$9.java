package com.tencent.mobileqq.app;

import achr;
import achs;
import android.content.SharedPreferences;
import android.os.Bundle;
import aquz;
import aqva;
import aqvc;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class MessageRoamManager$9
  implements Runnable
{
  public MessageRoamManager$9(achs paramachs) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg start...");
    }
    aqvc localaqvc = ((aqva)this.this$0.app.getManager(47)).a(1);
    if ((localaqvc != null) && (localaqvc.a(achr.boE) == null))
    {
      Object localObject = new File(achr.boF);
      aquz localaquz = new aquz(achr.boE, (File)localObject);
      if (((File)localObject).exists())
      {
        localObject = Long.valueOf(((File)localObject).lastModified());
        localaquz.lastModifiedTime = this.this$0.app.getPreferences().getLong("cloudSearchCfgLastModify", 0L);
        if (((Long)localObject).longValue() != localaquz.lastModifiedTime)
        {
          localaquz.cWv = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.roammsg.MessageRoamManager", 2, "checkCloudSearchCfg file modified local time: " + localObject + ", sp time: " + localaquz.lastModifiedTime);
          }
        }
      }
      localaquz.cWs = true;
      localaquz.cWy = false;
      localObject = new Bundle();
      localaqvc.a(localaquz, this.this$0.a, (Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.MessageRoamManager.9
 * JD-Core Version:    0.7.0.1
 */