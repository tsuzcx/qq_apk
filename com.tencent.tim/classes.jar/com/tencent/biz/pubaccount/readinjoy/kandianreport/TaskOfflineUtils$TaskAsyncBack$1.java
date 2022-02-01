package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.qphone.base.util.QLog;

class TaskOfflineUtils$TaskAsyncBack$1
  implements Runnable
{
  TaskOfflineUtils$TaskAsyncBack$1(TaskOfflineUtils.TaskAsyncBack paramTaskAsyncBack, String paramString, int paramInt) {}
  
  public void run()
  {
    QLog.d(TaskOfflineUtils.access$000(), 2, "loaded: bid : " + TaskOfflineUtils.TaskAsyncBack.access$100(this.this$0) + " param " + this.val$param + " code : " + this.val$code);
    int n = 4;
    int m = -1;
    int i;
    int j;
    int k;
    if (this.val$code == 0)
    {
      i = m;
      j = n;
      k = m;
    }
    for (;;)
    {
      try
      {
        if (this.val$param == null)
        {
          k = m;
          TaskOfflineUtils.ConfigData localConfigData = TaskOfflineUtils.checkOffLineConfig(TaskOfflineUtils.TaskAsyncBack.access$100(this.this$0), TaskOfflineUtils.TaskAsyncBack.access$200(this.this$0));
          k = m;
          m = localConfigData.version;
          k = m;
          boolean bool = localConfigData.isValid;
          i = m;
          j = n;
          if (bool)
          {
            j = 0;
            i = m;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.d(TaskOfflineUtils.access$000(), 1, "loaded: bid : " + TaskOfflineUtils.TaskAsyncBack.access$100(this.this$0), localException);
        TaskException.reportException("loaded: bid : " + TaskOfflineUtils.TaskAsyncBack.access$100(this.this$0) + " " + localException.getMessage());
        i = k;
        j = n;
        continue;
      }
      if (TaskOfflineUtils.TaskAsyncBack.access$300(this.this$0) != null) {
        TaskOfflineUtils.TaskAsyncBack.access$300(this.this$0).onStateChange(j, i);
      }
      return;
      j = this.val$code;
      i = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskOfflineUtils.TaskAsyncBack.1
 * JD-Core Version:    0.7.0.1
 */