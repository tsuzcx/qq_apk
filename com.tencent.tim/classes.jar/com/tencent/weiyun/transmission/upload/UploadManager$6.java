package com.tencent.weiyun.transmission.upload;

import com.tencent.weiyun.transmission.upload.processor.LocalProcessor;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.Job;
import com.tencent.weiyun.transmission.utils.thread.ThreadPool.JobContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

class UploadManager$6
  implements ThreadPool.Job<Void>
{
  UploadManager$6(UploadManager paramUploadManager) {}
  
  public Void run(ThreadPool.JobContext arg1)
  {
    ArrayList localArrayList;
    if (UploadManager.access$500().get() == -1L) {
      localArrayList = new ArrayList();
    }
    synchronized (UploadManager.access$600(this.this$0))
    {
      localArrayList.addAll(UploadManager.access$600(this.this$0).values());
      if (!localArrayList.isEmpty())
      {
        Collections.sort(localArrayList);
        ??? = (UploadJobContext)localArrayList.get(0);
        if ((???.statusInfo().canRunning()) && (UploadManager.access$500().compareAndSet(-1L, ???.dbId()))) {
          UploadManager.access$700(this.this$0).processor(???);
        }
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadManager.6
 * JD-Core Version:    0.7.0.1
 */