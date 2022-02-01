package com.tencent.qqmail.activity.compose;

import android.widget.EditText;

class ComposeMailActivity$40$1
  implements Runnable
{
  ComposeMailActivity$40$1(ComposeMailActivity.40 param40) {}
  
  public void run()
  {
    if (!this.this$1.this$0.isDestroyed())
    {
      this.this$1.this$0.composeView.getContentET().setSelection(0);
      this.this$1.this$0.composeView.setScrollable(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMailActivity.40.1
 * JD-Core Version:    0.7.0.1
 */