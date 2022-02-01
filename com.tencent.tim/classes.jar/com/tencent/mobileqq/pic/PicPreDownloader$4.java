package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;

class PicPreDownloader$4
  implements Runnable
{
  PicPreDownloader$4(PicPreDownloader paramPicPreDownloader, MessageForPic paramMessageForPic, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (!this.this$0.asS())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PIC_TAG_PRELOAD", 2, "productAysnc(): cannot predownload");
      }
      this.this$0.d(this.h, -1);
      return;
    }
    this.this$0.a(this.h, this.val$type, this.val$priority);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PicPreDownloader.4
 * JD-Core Version:    0.7.0.1
 */