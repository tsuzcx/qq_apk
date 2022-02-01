package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;

class ComposeContactsActivity$17$1
  implements TextChangeTimer.OnTextChangeListener
{
  ComposeContactsActivity$17$1(ComposeContactsActivity.17 param17) {}
  
  public void onTextChange()
  {
    Threads.runInBackground(new ComposeContactsActivity.17.1.1(this));
    ComposeContactsActivity.access$2100(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.17.1
 * JD-Core Version:    0.7.0.1
 */