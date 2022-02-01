package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

class PicPreDownloader$3
  implements Runnable
{
  PicPreDownloader$3(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt) {}
  
  public void run()
  {
    if (!this.this$0.asS())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAysnc(): cannot predownload");
      }
      this.this$0.d(this.h, -1);
    }
    while ((this.h == null) || (!(this.h instanceof MessageForPic))) {
      return;
    }
    this.this$0.b(this.h, this.val$type, 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.3
 * JD-Core Version:    0.7.0.1
 */