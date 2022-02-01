package com.tencent.mobileqq.webview.swift.component;

import arbl;
import arbl.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class SwiftBrowserOfflineHandler$3
  implements Runnable
{
  public SwiftBrowserOfflineHandler$3(arbl paramarbl) {}
  
  public void run()
  {
    if ((QLog.isColorLevel()) && (this.this$0.callbacks.size() != 0)) {
      QLog.i("SwiftBrowserOfflineHandler", 2, "now post offline callback, bid is " + this.this$0.businessId + ", mode: " + this.this$0.cj.get());
    }
    Iterator localIterator = this.this$0.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((arbl.a)localIterator.next()).onCheckOfflineFinish(this.this$0.cj.get());
    }
    this.this$0.callbacks.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.3
 * JD-Core Version:    0.7.0.1
 */