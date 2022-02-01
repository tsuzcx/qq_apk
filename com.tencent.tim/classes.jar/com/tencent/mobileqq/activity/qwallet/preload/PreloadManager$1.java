package com.tencent.mobileqq.activity.qwallet.preload;

import aaai;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfig.a;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class PreloadManager$1
  implements Runnable
{
  PreloadManager$1(PreloadManager paramPreloadManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreloadManager", 2, "synDataFromMoggy");
    }
    Object localObject = (aaai)this.this$0.mApp.getManager(245);
    if (localObject != null)
    {
      ((aaai)localObject).a("preload", this.this$0);
      localObject = ((aaai)localObject).getConfigInfo("preload");
      this.this$0.a((QWalletConfig.a)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.1
 * JD-Core Version:    0.7.0.1
 */