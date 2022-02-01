package com.tencent.qqmini.miniapp.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebviewContainer$4
  implements Runnable
{
  PageWebviewContainer$4(PageWebviewContainer paramPageWebviewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if ((PageWebviewContainer.access$300(this.this$0) != null) && (PageWebviewContainer.access$300(this.this$0).isRefreshing()))
    {
      PageWebviewContainer.access$300(this.this$0).setRefreshing(false);
      PageWebviewContainer.access$300(this.this$0).setEnabled(PageWebviewContainer.access$400(this.this$0));
      this.val$req.ok();
      return;
    }
    QMLog.e("PageWebviewContainer", "EVENT_STOP_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
    this.val$req.fail("refresh layout error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.4
 * JD-Core Version:    0.7.0.1
 */