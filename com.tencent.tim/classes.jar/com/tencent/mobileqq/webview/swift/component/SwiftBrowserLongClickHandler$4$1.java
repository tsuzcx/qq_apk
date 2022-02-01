package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import arbf;
import arhz;
import com.tencent.mobileqq.widget.QQToast;

class SwiftBrowserLongClickHandler$4$1
  implements Runnable
{
  SwiftBrowserLongClickHandler$4$1(SwiftBrowserLongClickHandler.4 param4) {}
  
  public void run()
  {
    if ((this.a.this$0.m != null) && (this.a.this$0.m.isShowing())) {
      this.a.this$0.m.dismiss();
    }
    QQToast.a(this.a.this$0.s.getApplicationContext(), 1, 2131717216, 1).show(this.a.this$0.baA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.1
 * JD-Core Version:    0.7.0.1
 */