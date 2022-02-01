package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.view.JBTitleBarWebView2;
import com.tencent.qqmail.view.TitleBarWebView2;

class ReadMailFragment$125
  implements Runnable
{
  ReadMailFragment$125(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$10900(this.this$0) != 0) && (ReadMailFragment.access$2300(this.this$0) != null))
    {
      TitleBarWebView2 localTitleBarWebView2 = ReadMailFragment.access$2300(this.this$0).getWebView();
      if (localTitleBarWebView2 != null)
      {
        if ((localTitleBarWebView2 instanceof JBTitleBarWebView2)) {
          ((JBTitleBarWebView2)localTitleBarWebView2).stopScrollToTop();
        }
        localTitleBarWebView2.scrollTo(localTitleBarWebView2.getScrollX(), ReadMailFragment.access$10900(this.this$0));
        QMLog.log(4, "ReadMailFragment", "scrollPositionBeforeTranslate : " + ReadMailFragment.access$10900(this.this$0));
        ReadMailFragment.access$10902(this.this$0, 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.125
 * JD-Core Version:    0.7.0.1
 */