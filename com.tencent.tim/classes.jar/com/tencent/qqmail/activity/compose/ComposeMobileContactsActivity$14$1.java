package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.timer.TextChangeTimer.OnTextChangeListener;

class ComposeMobileContactsActivity$14$1
  implements TextChangeTimer.OnTextChangeListener
{
  ComposeMobileContactsActivity$14$1(ComposeMobileContactsActivity.14 param14) {}
  
  public void onTextChange()
  {
    Threads.runInBackground(new ComposeMobileContactsActivity.14.1.1(this));
    ComposeMobileContactsActivity.access$1800(this.this$1.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.14.1
 * JD-Core Version:    0.7.0.1
 */