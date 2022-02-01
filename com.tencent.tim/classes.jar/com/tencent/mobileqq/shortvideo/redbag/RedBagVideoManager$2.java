package com.tencent.mobileqq.shortvideo.redbag;

import aeif;
import aenp.a;
import anjo;
import anjs;
import aquz;
import aqva;
import aqvc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class RedBagVideoManager$2
  implements Runnable
{
  public RedBagVideoManager$2(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject;
    try
    {
      if (anjo.bXy)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : isLoadingRes = true");
        }
        return;
      }
      anjo.bXy = true;
      localObject = (aenp.a)aeif.a().o(252);
      String str1 = ((aenp.a)localObject).tT;
      localObject = ((aenp.a)localObject).resUrl;
      if ((QLog.isColorLevel()) && (str1 != null) && (localObject != null)) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes: md5 = " + str1 + ", url = " + (String)localObject);
      }
      if ((str1 == null) || (str1.length() == 0) || (localObject == null) || (((String)localObject).length() == 0))
      {
        anjo.bXy = false;
        return;
      }
    }
    finally {}
    if (!anjo.k(str2, this.val$app))
    {
      String str3 = anjo.ceq + "VideoRedbagRes_2.0_android.zip";
      aquz localaquz = new aquz((String)localObject, new File(str3));
      localaquz.cWw = true;
      aqvc localaqvc = ((aqva)this.val$app.getManager(47)).a(1);
      if (QLog.isColorLevel()) {
        QLog.d("RedBagVideoManager", 2, "checkAndDownloadRes : [download] startDownload: " + (String)localObject + " path=" + str3);
      }
      localaqvc.a(localaquz, new anjs(this, (String)localObject, str3, str2), null);
    }
    for (;;)
    {
      return;
      anjo.bXy = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager.2
 * JD-Core Version:    0.7.0.1
 */