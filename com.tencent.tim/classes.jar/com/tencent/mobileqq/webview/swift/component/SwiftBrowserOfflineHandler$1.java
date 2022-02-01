package com.tencent.mobileqq.webview.swift.component;

import arbl;
import arbm;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicInteger;
import jpa;

public class SwiftBrowserOfflineHandler$1
  implements Runnable
{
  public SwiftBrowserOfflineHandler$1(arbl paramarbl, String paramString) {}
  
  public void run()
  {
    this.this$0.egZ();
    long l = System.currentTimeMillis();
    if (arbl.ck.get() == 3) {}
    for (boolean bool = jpa.a(BaseApplicationImpl.getApplication().getApplicationContext(), this.val$url, new arbm(this, l));; bool = false)
    {
      if (!bool) {
        this.this$0.egY();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.1
 * JD-Core Version:    0.7.0.1
 */