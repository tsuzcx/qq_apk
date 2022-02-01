package com.tencent.biz.qqcircle.events;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishBoxStatusEvent
  extends SimpleBaseEvent
{
  public boolean hasOfflineWaitingTask;
  public boolean hasRunningTask;
  public int taskCount;
  
  public QCirclePublishBoxStatusEvent(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.taskCount = paramBundle.getInt("taskCount", 0);
      this.hasRunningTask = paramBundle.getBoolean("hasRunningTask", false);
      this.hasOfflineWaitingTask = paramBundle.getBoolean("hasOfflineWaitingTask", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent
 * JD-Core Version:    0.7.0.1
 */