package com.tencent.mobileqq.unifiedebug;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.qphone.base.util.QLog;

class SnapshotService$1
  implements Runnable
{
  SnapshotService$1(SnapshotService paramSnapshotService, SnapshotService.c paramc, SnapshotService.a parama) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(SnapshotService.access$000(), 2, "start once debug, webview id =" + SnapshotService.c.a(this.c) + ", seq=" + this.a.seq);
    }
    this.c.a.mWebview.invalidate();
    if (this.c.a.mWebview.getX5WebViewExtension() != null) {
      this.c.a.mWebview.loadUrl("javascript:window.scrollTo(0, 0);");
    }
    for (;;)
    {
      SnapshotService.a(this.this$0, this.a, this.c);
      return;
      this.c.a.mWebview.pageUp(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService.1
 * JD-Core Version:    0.7.0.1
 */