package com.tencent.qqmail.activity.readmail;

import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$8
  implements Runnable
{
  ReadMailFragment$8(ReadMailFragment paramReadMailFragment, String paramString) {}
  
  public void run()
  {
    if (ReadMailFragment.access$2400(this.this$0) == null) {
      return;
    }
    ReadMailFragment.access$2400(this.this$0).removeTargetBubble(QMReadMailView.BUBBLE_TYPE_SCREEN_SHOT);
    DataCollector.logEvent("Event_Screenshot_Bubble_Appear");
    ReadMailFragment.access$2400(this.this$0).initScreenShotTipView(this.val$path, new ReadMailFragment.8.1(this));
    ReadMailFragment.access$2400(this.this$0).showBubbleView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.8
 * JD-Core Version:    0.7.0.1
 */