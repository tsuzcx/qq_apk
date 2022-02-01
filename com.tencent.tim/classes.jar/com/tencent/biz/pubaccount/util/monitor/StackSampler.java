package com.tencent.biz.pubaccount.util.monitor;

import android.os.Looper;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mqq.os.MqqHandler;

class StackSampler
{
  private SampleRunnable a;
  private volatile boolean awI;
  private Map<Long, String> fd;
  
  private void bdS()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = Looper.getMainLooper().getThread().getStackTrace();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(localObject[i].toString()).append("\n");
      i += 1;
    }
    if (this.fd.size() == 100)
    {
      localObject = (Long)this.fd.keySet().iterator().next();
      this.fd.remove(localObject);
    }
    this.fd.put(Long.valueOf(System.nanoTime()), localStringBuilder.toString());
  }
  
  class SampleRunnable
    implements Runnable
  {
    public void run()
    {
      if (StackSampler.a(this.this$0))
      {
        StackSampler.a(this.this$0);
        ThreadManager.getSubThreadHandler().postDelayed(StackSampler.a(this.this$0), 52L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.monitor.StackSampler
 * JD-Core Version:    0.7.0.1
 */