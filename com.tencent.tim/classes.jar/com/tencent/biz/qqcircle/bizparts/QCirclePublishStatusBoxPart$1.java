package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.events.QCirclePublishBoxStatusEvent;
import ovd;
import oxg;
import pco;
import ram;

public class QCirclePublishStatusBoxPart$1
  implements Runnable
{
  public QCirclePublishStatusBoxPart$1(oxg paramoxg, QCirclePublishBoxStatusEvent paramQCirclePublishBoxStatusEvent) {}
  
  public void run()
  {
    if (this.a.taskCount <= 0)
    {
      oxg.a(this.this$0).setVisibility(8);
      ram.i("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  GONE");
      return;
    }
    if ((oxg.a(this.this$0) != null) && (ovd.a(oxg.a(this.this$0))))
    {
      pco.h("", 16, 1L);
      oxg.a(this.this$0).setVisibility(0);
    }
    for (;;)
    {
      ram.i("QCirclePushFeedPart", "updateUploadBoxStatus  PublishBoxStatusEvent  VISIBLE  taskCount = " + this.a.taskCount + "  hasRunningTask:" + this.a.hasRunningTask + "  hasOfflineWaitingTask:" + this.a.hasOfflineWaitingTask);
      if (!this.a.hasRunningTask) {
        break;
      }
      oxg.a(this.this$0).setBackgroundResource(2130844878);
      oxg.a(this.this$0, String.valueOf(this.a.taskCount));
      return;
      oxg.a(this.this$0).setVisibility(8);
    }
    if (this.a.hasOfflineWaitingTask)
    {
      oxg.a(this.this$0).setBackgroundResource(2130849516);
      oxg.a(this.this$0, "");
      return;
    }
    oxg.a(this.this$0).setBackgroundResource(2130849515);
    oxg.a(this.this$0, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishStatusBoxPart.1
 * JD-Core Version:    0.7.0.1
 */