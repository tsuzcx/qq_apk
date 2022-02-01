package com.tencent.qqmail.activity.webviewexplorer;

import android.widget.Toast;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.activity.compose.NoteSender;
import com.tencent.qqmail.view.FolderLockDialog;

class WebViewExplorer$1$1
  implements Runnable
{
  WebViewExplorer$1$1(WebViewExplorer.1 param1) {}
  
  public void run()
  {
    this.this$1.this$0.lockDialog.cancelDialog();
    this.this$1.this$0.lockDialog.dismissTips();
    String str = this.this$1.this$0.getShareContent();
    Toast.makeText(QMApplicationContext.sharedInstance(), this.this$1.this$0.getString(2131718967), 0).show();
    new NoteSender(this.this$1.this$0.getMailId(), "1", "未分类", "folder").buildDataWithPredefinedHtmlAndTitle(str, this.this$1.this$0.getShareTitle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.webviewexplorer.WebViewExplorer.1.1
 * JD-Core Version:    0.7.0.1
 */