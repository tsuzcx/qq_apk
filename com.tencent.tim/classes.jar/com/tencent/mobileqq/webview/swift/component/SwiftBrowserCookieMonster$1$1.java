package com.tencent.mobileqq.webview.swift.component;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import jqo;
import mqq.app.AppRuntime;

class SwiftBrowserCookieMonster$1$1
  implements Runnable
{
  SwiftBrowserCookieMonster$1$1(SwiftBrowserCookieMonster.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.gG.keySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject3 = (String)localIterator.next();
      Object localObject2 = (CopyOnWriteArrayList)this.a.this$0.gG.get(localObject3);
      if (this.a.val$runtime == null) {}
      for (Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();; localObject1 = this.a.val$runtime)
      {
        localObject1 = this.a.this$0.a((String)localObject3, (AppRuntime)localObject1);
        localObject2 = ((CopyOnWriteArrayList)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SwiftBrowserCookieMonster.a)((Iterator)localObject2).next();
          if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "post callback onSetCookiesFinished " + jqo.filterKeyForLog((String)localObject1, new String[0]) + ", errorCode: " + this.a.this$0.aun);
          }
          if (this.a.this$0.cXz) {
            QLog.i("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + jqo.filterKeyForLog((String)localObject1, new String[0]));
          }
          ((SwiftBrowserCookieMonster.a)localObject3).a((String)localObject1, null, this.a.this$0.aun);
        }
        break;
      }
    }
    if ((this.a.this$0.cXz) || (this.a.this$0.aun > 0L))
    {
      this.a.this$0.destroy();
      return;
    }
    this.a.this$0.gG.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1.1
 * JD-Core Version:    0.7.0.1
 */