package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;

class ReadMailFragment$47
  implements Runnable
{
  ReadMailFragment$47(ReadMailFragment paramReadMailFragment) {}
  
  public void run()
  {
    if ((ReadMailFragment.access$900() != null) && (ReadMailFragment.access$900().webViewController != null) && (ReadMailFragment.access$900().webViewController.getWebView() != null)) {
      JSApiUitil.excuteJavaScript(ReadMailFragment.access$900().webViewController.getWebView(), "document.body.style.display=''");
    }
    this.this$0.render(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.47
 * JD-Core Version:    0.7.0.1
 */