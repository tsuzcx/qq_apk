package com.tencent.mobileqq.webview.swift.component;

import android.os.Handler;
import arbo;
import com.tencent.qphone.base.util.QLog;
import nnt;

public class SwiftBrowserScreenShotHandler$3
  implements Runnable
{
  public SwiftBrowserScreenShotHandler$3(arbo paramarbo, int paramInt) {}
  
  public void run()
  {
    this.this$0.czg = nnt.b(this.this$0.gC, "ShotCache_");
    if (QLog.isDevelopLevel()) {
      QLog.d("SwiftBrowserScreenShotHandler", 2, "onDetectScreenshot->save file time:" + System.currentTimeMillis());
    }
    this.this$0.cXB = false;
    if (this.this$0.cXC)
    {
      this.this$0.cXC = false;
      this.this$0.uiHandler.sendEmptyMessage(3);
    }
    while (this.lM != 2) {
      return;
    }
    this.this$0.uiHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.3
 * JD-Core Version:    0.7.0.1
 */