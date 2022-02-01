package com.tencent.qqmail.utilities.log;

import android.util.Log;

class TracerouteWithPing$TimeOutAsyncTask$1
  implements Runnable
{
  TracerouteWithPing$TimeOutAsyncTask$1(TracerouteWithPing.TimeOutAsyncTask paramTimeOutAsyncTask) {}
  
  public void run()
  {
    if ((TracerouteWithPing.TimeOutAsyncTask.access$200(this.this$1) != null) && (!TracerouteWithPing.TimeOutAsyncTask.access$200(this.this$1).isWholePingTaskFinished()))
    {
      if (3 <= TracerouteWithPing.access$300(this.this$1.this$0))
      {
        Log.w("mason", "exceed MAX_TIMEOUT_NUM. exit ping.");
        TracerouteWithPing.ExecutePingAsyncTask.access$402(TracerouteWithPing.TimeOutAsyncTask.access$200(this.this$1), true);
        TracerouteWithPing.access$700(this.this$1.this$0, false, TracerouteWithPing.access$500(this.this$1.this$0), TracerouteWithPing.access$600(this.this$1.this$0));
      }
    }
    else {
      return;
    }
    TracerouteWithPing.access$308(this.this$1.this$0);
    String str = TracerouteWithPing.access$800(this.this$1.this$0);
    StringBuilder localStringBuilder = new StringBuilder().append(TracerouteWithPing.TimeOutAsyncTask.access$900(this.this$1)).append(" task.isFinished()").append(TracerouteWithPing.access$1000(this.this$1.this$0)).append(" ");
    if (TracerouteWithPing.TimeOutAsyncTask.access$900(this.this$1) == TracerouteWithPing.access$1000(this.this$1.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.e(str, bool);
      if (TracerouteWithPing.TimeOutAsyncTask.access$900(this.this$1) != TracerouteWithPing.access$1000(this.this$1.this$0)) {
        break;
      }
      TracerouteWithPing.TimeOutAsyncTask.access$200(this.this$1).cancel(true);
      TracerouteWithPing.access$700(this.this$1.this$0, false, TracerouteWithPing.access$500(this.this$1.this$0), TracerouteWithPing.access$600(this.this$1.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.log.TracerouteWithPing.TimeOutAsyncTask.1
 * JD-Core Version:    0.7.0.1
 */