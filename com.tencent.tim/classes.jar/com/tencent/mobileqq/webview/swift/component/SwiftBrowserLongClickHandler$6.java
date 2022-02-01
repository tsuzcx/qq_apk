package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import arbf;
import arhz;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$6
  implements Runnable
{
  public SwiftBrowserLongClickHandler$6(arbf paramarbf) {}
  
  public void run()
  {
    if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
      this.this$0.m.dismiss();
    }
    QQToast.a(this.this$0.s.getApplicationContext(), 1, 2131717216, 1).show(this.this$0.baA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.6
 * JD-Core Version:    0.7.0.1
 */