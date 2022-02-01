package com.tencent.mobileqq.activity.aio;

import aoiz;
import aoop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.PicPreDownloader;
import java.io.File;
import java.net.URL;

class BaseBubbleBuilder$1
  implements Runnable
{
  BaseBubbleBuilder$1(BaseBubbleBuilder paramBaseBubbleBuilder, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = aoiz.getFile(aoop.a((MessageForPic)this.k, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      this.this$0.app.a().a((MessageForPic)this.k, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.1
 * JD-Core Version:    0.7.0.1
 */