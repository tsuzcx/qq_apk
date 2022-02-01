package com.tencent.qapmsdk.impl.instrumentation;

import android.annotation.TargetApi;
import android.os.Looper;
import com.tencent.qapmsdk.impl.util.TraceUtil;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

public class QAPMUnit
{
  protected volatile Set<UUID> children;
  public long entryTimestamp = 0L;
  public long exitTimestamp = 0L;
  public boolean isComplete = false;
  public String metricName = "";
  public final UUID myUuid;
  public UUID parentUuid = null;
  public String subMetricName = "";
  public long threadId = 0L;
  public String threadName = "main";
  
  public QAPMUnit()
  {
    initChildren();
    this.myUuid = new UUID(TraceUtil.getRandom().nextLong(), TraceUtil.getRandom().nextLong());
    this.threadId = Thread.currentThread().getId();
    this.threadName = Thread.currentThread().getName();
  }
  
  @TargetApi(9)
  private void initChildren()
  {
    if (this.children == null) {
      try
      {
        if (this.children == null) {
          this.children = new ConcurrentSkipListSet();
        }
        return;
      }
      finally {}
    }
  }
  
  public void addChild(QAPMUnit paramQAPMUnit)
  {
    this.children.add(paramQAPMUnit.myUuid);
  }
  
  public void complete()
  {
    this.exitTimestamp = System.currentTimeMillis();
    this.isComplete = true;
  }
  
  public Set<UUID> getChildren()
  {
    return this.children;
  }
  
  public boolean isComplete()
  {
    return this.isComplete;
  }
  
  public void setUnitThreadWithUiThread()
  {
    this.threadId = Looper.getMainLooper().getThread().getId();
    this.threadName = Looper.getMainLooper().getThread().getName();
  }
  
  public String toString()
  {
    return "QAPMUnit{entryTimestamp=" + this.entryTimestamp + ", exitTimestamp=" + this.exitTimestamp + ", metricName='" + this.metricName + '\'' + ", children=" + this.children + ", isComplete=" + this.isComplete + ", parentUuid=" + this.parentUuid + ", myUuid=" + this.myUuid + ", threadId=" + this.threadId + ", threadName='" + this.threadName + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.impl.instrumentation.QAPMUnit
 * JD-Core Version:    0.7.0.1
 */