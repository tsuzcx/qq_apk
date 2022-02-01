package com.tencent.qqmail.activity.webviewexplorer;

import com.tencent.qqmail.view.FolderLockDialog;

class WebViewExplorer$1$2
  implements Runnable
{
  WebViewExplorer$1$2(WebViewExplorer.1 param1) {}
  
  public void run()
  {
    this.this$1.this$0.lockDialog.cancelDialog();
    this.this$1.this$0.lockDialog.dismissTips();
    this.this$1.this$0.lockDialog.errorDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.1.2
 * JD-Core Version:    0.7.0.1
 */