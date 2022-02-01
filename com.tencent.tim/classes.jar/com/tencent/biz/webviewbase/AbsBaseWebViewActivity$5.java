package com.tencent.biz.webviewbase;

import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class AbsBaseWebViewActivity$5
  implements Runnable
{
  AbsBaseWebViewActivity$5(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  public void run()
  {
    SystemClock.uptimeMillis();
    synchronized (this.this$0.sInitEngineLock)
    {
      if (this.this$0.mApp == null) {
        this.this$0.mApp = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      }
      if (this.this$0.mPluginEngine == null)
      {
        this.this$0.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.this$0.mApp, this.this$0, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.this$0.mPluginEngine, this.this$0.mApp, this.this$0);
        SystemClock.uptimeMillis();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.5
 * JD-Core Version:    0.7.0.1
 */