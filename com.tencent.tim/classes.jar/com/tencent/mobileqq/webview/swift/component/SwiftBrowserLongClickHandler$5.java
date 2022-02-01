package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import arbf;
import arhz;
import com.tencent.mobileqq.widget.QQToast;

public class SwiftBrowserLongClickHandler$5
  implements Runnable
{
  public SwiftBrowserLongClickHandler$5(arbf paramarbf, String paramString) {}
  
  public void run()
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    localIntent.setData(Uri.parse("file://" + this.cze));
    this.this$0.s.sendBroadcast(localIntent);
    if ((this.this$0.m != null) && (this.this$0.m.isShowing())) {
      this.this$0.m.dismiss();
    }
    QQToast.a(this.this$0.s.getApplicationContext(), 2, this.this$0.s.getString(2131717218, new Object[] { this.cze }), 1).show(this.this$0.baA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.5
 * JD-Core Version:    0.7.0.1
 */