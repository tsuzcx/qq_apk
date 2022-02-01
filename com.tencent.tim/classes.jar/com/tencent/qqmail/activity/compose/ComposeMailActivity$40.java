package com.tencent.qqmail.activity.compose;

import android.content.Intent;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.utilities.thread.Threads;

class ComposeMailActivity$40
  implements Runnable
{
  ComposeMailActivity$40(ComposeMailActivity paramComposeMailActivity, String paramString) {}
  
  public void run()
  {
    int i = this.this$0.getIntent().getIntExtra("type", ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY.ordinal());
    ComposeMailUI.QMComposeMailType localQMComposeMailType = ComposeMailUI.QMComposeMailType.values()[i];
    if (!ComposeMailActivity.access$5300(this.this$0))
    {
      ComposeMailActivity.access$4200(this.this$0);
      this.this$0.composeView.getContentET().setMinLines(3);
      this.this$0.composeView.getContentET().setText("\n\n");
      this.this$0.composeView.getContentET().setSelection(this.this$0.composeView.getContentET().getText().length());
      this.this$0.composeView.setScrollable(false);
      this.this$0.composeView.addAttachImg(this.val$dstPath, "");
      if ((ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY.equals(localQMComposeMailType)) || (ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL.equals(localQMComposeMailType)))
      {
        Threads.runOnMainThread(new ComposeMailActivity.40.1(this), 1000L);
        return;
      }
      Threads.runOnMainThread(new ComposeMailActivity.40.2(this), 1000L);
      return;
    }
    ComposeMailActivity.access$4200(this.this$0);
    this.this$0.composeView.aaddAttachImgAtBegenning(this.val$dstPath, "");
    this.this$0.composeView.scrollToTop();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.40
 * JD-Core Version:    0.7.0.1
 */