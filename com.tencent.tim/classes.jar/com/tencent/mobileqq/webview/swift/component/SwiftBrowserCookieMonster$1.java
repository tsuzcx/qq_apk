package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import jqo;
import mqq.app.AppRuntime;

class SwiftBrowserCookieMonster$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1(SwiftBrowserCookieMonster paramSwiftBrowserCookieMonster, AppRuntime paramAppRuntime, Intent paramIntent) {}
  
  public void run()
  {
    if (this.val$runtime == null)
    {
      ??? = BaseApplicationImpl.getApplication().getRuntime();
      if (this.this$0.state.get() == 2)
      {
        if (??? != null)
        {
          long l = System.currentTimeMillis();
          BrowserAppInterface.Dr(((AppRuntime)???).getAccount());
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "SwiftBrowserCookieMonster: removeLastUinCookies,cost=" + (System.currentTimeMillis() - l));
          }
        }
        this.this$0.egT();
        if (QLog.isColorLevel()) {
          QLog.i("SwiftBrowserCookieMonster", 2, "start set all cookies " + jqo.filterKeyForLog(this.this$0.czc, new String[0]));
        }
        this.this$0.a(this.this$0.a(this.val$intent, (AppRuntime)???), true);
        if (!this.this$0.state.compareAndSet(2, 3)) {}
      }
    }
    for (;;)
    {
      synchronized (this.this$0.state)
      {
        this.this$0.state.notifyAll();
        if (this.this$0.aun > 0L)
        {
          this.this$0.egX();
          QLog.e("SwiftBrowserCookieMonster", 1, "set cookie error :" + this.this$0.aun);
          jqo.lf("Web_qqbrowser_check_and_set_cookies");
          new Handler(Looper.getMainLooper()).post(new SwiftBrowserCookieMonster.1.1(this));
          return;
          ??? = this.val$runtime;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1
 * JD-Core Version:    0.7.0.1
 */