package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.activity.compose.richeditor.QMUIRichEditor.UpdateInnerHtmlCallback;

class ComposeMailActivity$96
  implements QMUIRichEditor.UpdateInnerHtmlCallback
{
  ComposeMailActivity$96(ComposeMailActivity paramComposeMailActivity) {}
  
  public void success()
  {
    ComposeMailActivity.access$11402(this.this$0, ((QMComposeMailView)this.this$0.composeView).getContentText(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.96
 * JD-Core Version:    0.7.0.1
 */