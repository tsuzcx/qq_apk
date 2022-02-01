package com.tencent.mobileqq.vip;

import aquz;
import aqva;
import aqvm;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;

public class QueueDownloader$1
  implements Runnable
{
  public QueueDownloader$1(aqvm paramaqvm, aquz paramaquz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() downloadLimitCount=" + this.this$0.y.get() + ",task=" + this.a);
    }
    if ((this.a.cWm) && (aqva.aa(this.a.key)))
    {
      this.a.errCode = -101;
      this.a.setStatus(-1);
      this.a.cCN();
      this.this$0.a(this.a);
      this.this$0.y.addAndGet(-1);
      this.this$0.doTask();
      if (QLog.isColorLevel()) {
        QLog.d("QueueDownloader", 2, "doTask | run() task is limit of failTime, task=" + this.a);
      }
      return;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    int i = aqva.a(this.a, localAppRuntime);
    if (QLog.isColorLevel()) {
      QLog.d("QueueDownloader", 2, "doTask | run() download task result=" + i + ",task=" + this.a);
    }
    this.this$0.a(this.a);
    this.this$0.y.addAndGet(-1);
    this.this$0.doTask();
  }
  
  public String toString()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject;
      if ((this.a.GP == null) || (this.a.GP.size() == 0))
      {
        localObject = this.a.key;
        localObject = localStringBuilder.append("QueueDownloader").append(" current task:").append((String)localObject).append(",downloadQueue size:");
        if (aqvm.a(this.this$0) != null) {
          break label105;
        }
      }
      label105:
      for (int i = 0;; i = aqvm.a(this.this$0).size())
      {
        ((StringBuilder)localObject).append(i);
        return localStringBuilder.toString();
        localObject = (String)this.a.GP.get(0);
        break;
      }
      return super.toString();
    }
    catch (Exception localException)
    {
      QLog.e("QueueDownloader", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vip.QueueDownloader.1
 * JD-Core Version:    0.7.0.1
 */