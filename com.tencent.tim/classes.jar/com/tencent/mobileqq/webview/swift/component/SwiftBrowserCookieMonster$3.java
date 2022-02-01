package com.tencent.mobileqq.webview.swift.component;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;
import jqo;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

final class SwiftBrowserCookieMonster$3
  implements Runnable
{
  SwiftBrowserCookieMonster$3(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str;
    if ((SwiftBrowserCookieMonster.ci.get() == 2) && (this.a != null) && (this.a.isLogin()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SwiftBrowserCookieMonster", 2, "get common keys: " + this.a.getAccount());
      }
      ??? = (TicketManager)this.a.getManager(2);
      str = this.a.getAccount();
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.sKey))
      {
        SwiftBrowserCookieMonster.sKey = ((TicketManager)???).getSkey(str);
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.sKey)) {
          break label361;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, jqo.b("skey=" + SwiftBrowserCookieMonster.sKey, new String[0]));
      }
    }
    for (;;)
    {
      Ticket localTicket = ((TicketManager)???).GetLocalTicket(str, 4096);
      if (localTicket != null) {
        QLog.i("SwiftBrowserCookieMonster", 1, "last refresh skey time: " + localTicket._create_time);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.cyU)) {
        SwiftBrowserCookieMonster.cyU = ((TicketManager)???).getSuperkey(str);
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.cyW))
      {
        SwiftBrowserCookieMonster.cyW = ((TicketManager)???).getStweb(str);
        if (TextUtils.isEmpty(SwiftBrowserCookieMonster.cyW)) {
          break label372;
        }
        QLog.i("SwiftBrowserCookieMonster", 1, jqo.b("sTwxWeb=" + SwiftBrowserCookieMonster.cyW, new String[0]));
        label270:
        localTicket = ((TicketManager)???).GetLocalTicket(str, 32);
        if (localTicket != null) {
          QLog.i("SwiftBrowserCookieMonster", 1, "last refresh sTwxWeb time: " + localTicket._create_time);
        }
      }
      if (TextUtils.isEmpty(SwiftBrowserCookieMonster.hK)) {
        SwiftBrowserCookieMonster.hK = ((TicketManager)???).getA2(str);
      }
      synchronized (SwiftBrowserCookieMonster.ci)
      {
        if (SwiftBrowserCookieMonster.aGc())
        {
          SwiftBrowserCookieMonster.ci.compareAndSet(2, 3);
          SwiftBrowserCookieMonster.ci.notifyAll();
          return;
          label361:
          QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
          continue;
          label372:
          QLog.e("SwiftBrowserCookieMonster", 1, "sTwxWeb is null!");
          break label270;
        }
        SwiftBrowserCookieMonster.ci.compareAndSet(2, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.3
 * JD-Core Version:    0.7.0.1
 */