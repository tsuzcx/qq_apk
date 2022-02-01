package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import arbf;
import ausj;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.File;
import jqg;
import jqo;
import rvx;

public class SwiftBrowserLongClickHandler$4
  implements Runnable
{
  public SwiftBrowserLongClickHandler$4(arbf paramarbf, String paramString) {}
  
  public void run()
  {
    ??? = new Bundle();
    if (this.this$0.a == null)
    {
      this.this$0.a = CookieManager.getInstance();
      this.this$0.a.setAcceptCookie(true);
    }
    String str = this.this$0.a.getCookie(this.val$url);
    if (str != null)
    {
      ((Bundle)???).putString("Cookie", str);
      if (QLog.isColorLevel()) {
        QLog.d("SwiftBrowserLongClickHandler", 2, "Get cookie: " + jqo.b(str, new String[0]) + " from " + jqo.filterKeyForLog(this.val$url, new String[0]));
      }
    }
    ??? = jqg.a(BaseApplication.getContext(), this.val$url, (Bundle)???);
    this.this$0.mTempPath = ((String)???);
    if (QLog.isColorLevel()) {
      QLog.d("SwiftBrowserLongClickHandler", 2, "saveImage filepath = " + this.this$0.mTempPath);
    }
    if (??? == null) {
      this.this$0.s.runOnUiThread(new SwiftBrowserLongClickHandler.4.1(this));
    }
    for (;;)
    {
      return;
      if (this.this$0.eec == 0)
      {
        this.this$0.VW((String)???);
        this.this$0.s.runOnUiThread(new SwiftBrowserLongClickHandler.4.2(this));
        return;
      }
      if (this.this$0.eec == 1)
      {
        this.this$0.VV((String)???);
        return;
      }
      if (this.this$0.eec == 2)
      {
        this.this$0.VX((String)???);
        return;
      }
      int i = rvx.a(Uri.parse("file://" + new File((String)???).getAbsolutePath()), this.this$0.s, 3);
      if (i <= 0) {
        continue;
      }
      synchronized (this.this$0.fC)
      {
        this.this$0.czd = this.this$0.mTempPath;
        this.this$0.eed = i;
        if (!this.this$0.d.isShowing()) {
          continue;
        }
        this.this$0.s.runOnUiThread(new SwiftBrowserLongClickHandler.4.3(this, i));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4
 * JD-Core Version:    0.7.0.1
 */