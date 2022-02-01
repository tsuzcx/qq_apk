package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$MiniAppSubProcessorInfo$1
  implements Runnable
{
  AppBrandLaunchManager$MiniAppSubProcessorInfo$1(AppBrandLaunchManager.MiniAppSubProcessorInfo paramMiniAppSubProcessorInfo) {}
  
  public void run()
  {
    Object localObject2 = null;
    if (this.this$0.isForeground) {
      return;
    }
    if ((this.this$0.appConfig != null) && (this.this$0.appConfig.config != null)) {}
    for (String str = this.this$0.appConfig.config.appId;; str = null)
    {
      Object localObject1 = localObject2;
      if (this.this$0.appConfig != null)
      {
        localObject1 = localObject2;
        if (this.this$0.appConfig.config != null) {
          localObject1 = this.this$0.appConfig.config.name;
        }
      }
      QLog.i("miniapp-process_AppBrandLaunchManager", 1, "recycle process=" + this.this$0.processName + " appId=" + str + " appName=" + (String)localObject1);
      AppBrandLaunchManager.g().forceKillProcess(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.MiniAppSubProcessorInfo.1
 * JD-Core Version:    0.7.0.1
 */