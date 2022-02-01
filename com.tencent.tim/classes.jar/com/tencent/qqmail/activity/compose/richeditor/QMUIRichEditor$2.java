package com.tencent.qqmail.activity.compose.richeditor;

import android.os.Build.VERSION;

class QMUIRichEditor$2
  implements Runnable
{
  QMUIRichEditor$2(QMUIRichEditor paramQMUIRichEditor, String paramString) {}
  
  public void run()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.this$0.evaluateJavascript(this.val$trigger, null);
      return;
    }
    this.this$0.loadUrl(this.val$trigger);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.2
 * JD-Core Version:    0.7.0.1
 */