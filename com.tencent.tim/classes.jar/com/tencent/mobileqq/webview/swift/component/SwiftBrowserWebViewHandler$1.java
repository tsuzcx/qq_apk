package com.tencent.mobileqq.webview.swift.component;

import arcg;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebAccelerator;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class SwiftBrowserWebViewHandler$1
  implements Runnable
{
  public void run()
  {
    long l = System.currentTimeMillis();
    WebAccelerator.initTbsEnvironment(this.val$context, 2);
    this.this$0.state.compareAndSet(2, 3);
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserWebViewHandler", 2, "WebAccelerator.asyncInitWebView, cost=" + (System.currentTimeMillis() - l));
    }
    ThreadManager.getUIHandler().post(new SwiftBrowserWebViewHandler.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler.1
 * JD-Core Version:    0.7.0.1
 */