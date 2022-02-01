package com.tencent.qqmini.miniapp.core.page;

import android.support.v4.widget.SwipeRefreshLayout;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class PageWebviewContainer$3
  implements Runnable
{
  PageWebviewContainer$3(PageWebviewContainer paramPageWebviewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    if (PageWebviewContainer.access$300(this.this$0) != null)
    {
      PageWebviewContainer.access$300(this.this$0).setRefreshing(true);
      this.this$0.onRefresh();
      this.val$req.ok();
      return;
    }
    QMLog.e("PageWebviewContainer", "EVENT_START_PULLDOWN_REFRESH mSwipeRefreshLayout is null.");
    this.val$req.fail("refresh layout error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.PageWebviewContainer.3
 * JD-Core Version:    0.7.0.1
 */