package com.tencent.qqmail;

import com.tencent.qqmail.utilities.thread.Threads;

class ManagerLifecycle$1
  implements Runnable
{
  ManagerLifecycle$1(ManagerLifecycle paramManagerLifecycle) {}
  
  public void run()
  {
    if (ManagerLifecycle.access$000(this.this$0) == 0)
    {
      ManagerLifecycle.access$102(this.this$0, true);
      this.this$0.onTerminate();
      return;
    }
    if (ManagerLifecycle.access$204(this.this$0) > 10000) {}
    Threads.runInBackground(this, 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.ManagerLifecycle.1
 * JD-Core Version:    0.7.0.1
 */