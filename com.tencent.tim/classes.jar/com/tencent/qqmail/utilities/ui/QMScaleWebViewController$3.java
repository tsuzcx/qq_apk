package com.tencent.qqmail.utilities.ui;

import android.content.ClipboardManager.OnPrimaryClipChangedListener;
import com.tencent.qqmail.view.TitleBarWebView2;

class QMScaleWebViewController$3
  implements ClipboardManager.OnPrimaryClipChangedListener
{
  QMScaleWebViewController$3(QMScaleWebViewController paramQMScaleWebViewController) {}
  
  public void onPrimaryClipChanged()
  {
    if (QMScaleWebViewController.access$000(this.this$0) != null) {
      QMScaleWebViewController.access$000(this.this$0).setSelectionRanger(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMScaleWebViewController.3
 * JD-Core Version:    0.7.0.1
 */