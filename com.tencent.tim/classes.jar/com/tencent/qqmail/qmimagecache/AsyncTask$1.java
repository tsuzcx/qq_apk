package com.tencent.qqmail.qmimagecache;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

class AsyncTask$1
  extends AsyncTask.WorkerRunnable<Params, Result>
{
  AsyncTask$1(AsyncTask paramAsyncTask)
  {
    super(null);
  }
  
  public Result call()
    throws Exception
  {
    AsyncTask.access$300(this.this$0).set(true);
    Process.setThreadPriority(10);
    return AsyncTask.access$400(this.this$0, this.this$0.doInBackground(this.mParams));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.qmimagecache.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */