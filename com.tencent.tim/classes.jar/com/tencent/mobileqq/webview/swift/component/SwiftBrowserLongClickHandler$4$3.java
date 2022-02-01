package com.tencent.mobileqq.webview.swift.component;

import arbf;
import ausj;
import com.tencent.qphone.base.util.QLog;
import rvx;

class SwiftBrowserLongClickHandler$4$3
  implements Runnable
{
  SwiftBrowserLongClickHandler$4$3(SwiftBrowserLongClickHandler.4 param4, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserLongClickHandler", 2, "showQR Button");
    }
    if (rvx.fa(this.val$result)) {
      this.a.this$0.d.addButton(2131694760);
    }
    if (rvx.fb(this.val$result)) {
      this.a.this$0.d.addButton(2131694759);
    }
    this.a.this$0.d.updateAllButton();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4.3
 * JD-Core Version:    0.7.0.1
 */