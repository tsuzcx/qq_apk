package com.tencent.component.network.utils.thread;

import android.os.Process;
import java.util.concurrent.atomic.AtomicBoolean;

final class b
  extends AsyncTask.e<Params, Result>
{
  b(AsyncTask paramAsyncTask)
  {
    super((byte)0);
  }
  
  public final Result call()
    throws Exception
  {
    AsyncTask.a(this.b).set(true);
    Process.setThreadPriority(10);
    return AsyncTask.b(this.b, this.b.doInBackground(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.b
 * JD-Core Version:    0.7.0.1
 */