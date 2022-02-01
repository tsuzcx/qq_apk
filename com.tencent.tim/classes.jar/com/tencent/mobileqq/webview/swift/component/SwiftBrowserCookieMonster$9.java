package com.tencent.mobileqq.webview.swift.component;

import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

final class SwiftBrowserCookieMonster$9
  implements Runnable
{
  public void run()
  {
    if (SwiftBrowserCookieMonster.a == null) {
      synchronized (SwiftBrowserCookieMonster.access$000())
      {
        if (SwiftBrowserCookieMonster.a == null)
        {
          Object localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
          if (localObject1 != null)
          {
            localObject1 = (TicketManager)((AppRuntime)localObject1).getManager(2);
            if (localObject1 != null)
            {
              SwiftBrowserCookieMonster.a = new SwiftBrowserCookieMonster.b();
              ((TicketManager)localObject1).registTicketManagerListener(SwiftBrowserCookieMonster.a);
            }
          }
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.9
 * JD-Core Version:    0.7.0.1
 */