package com.tencent.biz.pubaccount.readinjoy.ugc;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import miu;
import miv;

public class KandianVideoUploadController$1$1
  implements Runnable
{
  public KandianVideoUploadController$1$1(miv parammiv) {}
  
  public void run()
  {
    WebProcessManager localWebProcessManager = (WebProcessManager)this.a.a.app.getManager(13);
    if ((localWebProcessManager != null) && (localWebProcessManager.aFT()))
    {
      localWebProcessManager.a(-1, null);
      if (QLog.isColorLevel()) {
        QLog.d("allentest", 2, "sbbbb");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.KandianVideoUploadController.1.1
 * JD-Core Version:    0.7.0.1
 */