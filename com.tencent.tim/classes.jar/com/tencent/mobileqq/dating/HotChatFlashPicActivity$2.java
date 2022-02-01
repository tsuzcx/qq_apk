package com.tencent.mobileqq.dating;

import aqgy;
import java.util.concurrent.atomic.AtomicBoolean;

class HotChatFlashPicActivity$2
  implements Runnable
{
  HotChatFlashPicActivity$2(HotChatFlashPicActivity paramHotChatFlashPicActivity, String paramString) {}
  
  public void run()
  {
    aqgy.il(this.val$filePath, HotChatFlashPicActivity.c(this.this$0));
    HotChatFlashPicActivity.b(this.this$0, true);
    if (!HotChatFlashPicActivity.a(this.this$0).get()) {
      HotChatFlashPicActivity.b(this.this$0, this.val$filePath);
    }
    HotChatFlashPicActivity.a(this.this$0, this.val$filePath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.HotChatFlashPicActivity.2
 * JD-Core Version:    0.7.0.1
 */