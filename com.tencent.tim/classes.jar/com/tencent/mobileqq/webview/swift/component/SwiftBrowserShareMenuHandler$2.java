package com.tencent.mobileqq.webview.swift.component;

import aobh;
import arbt;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import svi;

public class SwiftBrowserShareMenuHandler$2
  implements Runnable
{
  public SwiftBrowserShareMenuHandler$2(arbt paramarbt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    int j = 1;
    int k = this.this$0.b.a().policy;
    String str1;
    boolean bool;
    if (this.this$0.b.a().policy == 0)
    {
      str1 = this.this$0.c.mApp.getCurrentAccountUin();
      String str2 = this.this$0.b.a().cjj;
      String str3 = this.this$0.b.a().padId;
      if (this.this$0.b.a().docType == 3)
      {
        bool = true;
        if (aobh.a(str1, str2, str3, bool, false, 1, null, null, null)) {
          break label241;
        }
      }
    }
    label241:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        str1 = aobh.a(this.this$0.c.mApp.getCurrentAccountUin(), this.this$0.b.a());
        this.this$0.b.a().cjk = str1;
        if (str1 != null) {
          i = j;
        }
      }
      for (;;)
      {
        arbt.a(this.this$0, this.czi, this.czj, this.czk, this.czl);
        if ((i != 0) && ((this.this$0.c instanceof TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment))) {
          ((TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment)this.this$0.c).BH(k);
        }
        return;
        bool = false;
        break;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserShareMenuHandler.2
 * JD-Core Version:    0.7.0.1
 */