package com.tencent.qqmail.paintpad;

import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.thread.Threads;

class MailPaintPadActivity$8
  implements Runnable
{
  MailPaintPadActivity$8(MailPaintPadActivity paramMailPaintPadActivity) {}
  
  public void run()
  {
    ImageUtil.saveToGallery(this.this$0, MailPaintPadActivity.access$400(this.this$0));
    Threads.runOnMainThread(new MailPaintPadActivity.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.paintpad.MailPaintPadActivity.8
 * JD-Core Version:    0.7.0.1
 */