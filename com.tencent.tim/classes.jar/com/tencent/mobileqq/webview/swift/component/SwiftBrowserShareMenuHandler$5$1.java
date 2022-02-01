package com.tencent.mobileqq.webview.swift.component;

import aobh;
import arbt;
import arbw;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.os.MqqHandler;
import svi;

public class SwiftBrowserShareMenuHandler$5$1
  implements Runnable
{
  public SwiftBrowserShareMenuHandler$5$1(arbw paramarbw) {}
  
  public void run()
  {
    int i = this.a.this$0.b.a().policy;
    String str1 = this.a.this$0.c.mApp.getCurrentAccountUin();
    String str2 = this.a.this$0.b.a().cjj;
    String str3 = this.a.this$0.b.a().padId;
    if (this.a.this$0.b.a().docType == 3) {}
    for (boolean bool = true;; bool = false)
    {
      bool = aobh.a(str1, str2, str3, bool, false, 2, null, null, null);
      ThreadManager.getUIHandler().postDelayed(new SwiftBrowserShareMenuHandler.5.1.1(this, i, bool), 3000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.5.1
 * JD-Core Version:    0.7.0.1
 */