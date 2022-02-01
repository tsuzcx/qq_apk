package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.Iterator;
import java.util.List;

class ComposeNoteActivity$28
  implements Runnable
{
  ComposeNoteActivity$28(ComposeNoteActivity paramComposeNoteActivity, List paramList) {}
  
  public void run()
  {
    if (this.this$0.isDestroyed()) {
      return;
    }
    Iterator localIterator = this.val$attachInfos.iterator();
    for (;;)
    {
      AttachInfo localAttachInfo;
      if (localIterator.hasNext())
      {
        localAttachInfo = (AttachInfo)localIterator.next();
        if (ComposeNoteActivity.access$900(this.this$0) != ComposeNoteActivity.SendMailStatus.SENDCLOSED) {}
      }
      else
      {
        Threads.runOnMainThread(new ComposeNoteActivity.28.2(this));
        return;
      }
      ComposeNoteActivity.access$3400(this.this$0, localAttachInfo);
      Threads.runOnMainThread(new ComposeNoteActivity.28.1(this, localAttachInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.28
 * JD-Core Version:    0.7.0.1
 */