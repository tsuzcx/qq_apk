package com.tencent.qqmail.widget.inbox;

import com.tencent.qqmail.model.mail.QMMailListCursor.IRunOnMainThreadWithContext;
import com.tencent.qqmail.utilities.thread.Threads;

class InboxWidgetManager$3$2
  implements QMMailListCursor.IRunOnMainThreadWithContext
{
  InboxWidgetManager$3$2(InboxWidgetManager.3 param3) {}
  
  public void runOnMainThreadWithContext(Runnable paramRunnable)
  {
    Threads.runOnMainThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.widget.inbox.InboxWidgetManager.3.2
 * JD-Core Version:    0.7.0.1
 */