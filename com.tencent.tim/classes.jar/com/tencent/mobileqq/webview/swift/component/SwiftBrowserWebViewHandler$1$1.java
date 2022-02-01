package com.tencent.mobileqq.webview.swift.component;

import arcg;
import arcg.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class SwiftBrowserWebViewHandler$1$1
  implements Runnable
{
  SwiftBrowserWebViewHandler$1$1(SwiftBrowserWebViewHandler.1 param1) {}
  
  public void run()
  {
    Iterator localIterator = this.a.this$0.callbacks.iterator();
    while (localIterator.hasNext()) {
      ((arcg.a)localIterator.next()).ehq();
    }
    this.a.this$0.callbacks.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserWebViewHandler.1.1
 * JD-Core Version:    0.7.0.1
 */