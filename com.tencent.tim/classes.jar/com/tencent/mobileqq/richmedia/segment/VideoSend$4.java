package com.tencent.mobileqq.richmedia.segment;

import akyf.a;
import ambw;
import android.text.TextUtils;
import aqhq;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoSend$4
  implements Runnable
{
  public VideoSend$4(ambw paramambw, akyf.a parama) {}
  
  public void run()
  {
    if (this.b.result == 0)
    {
      this.this$0.c.videoFileStatus = 1003;
      this.this$0.c.uuid = this.b.uuid;
      this.this$0.c.md5 = this.b.md5;
      String str = ShortVideoUtils.a(this.this$0.c, "mp4");
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "onSend, md5:" + this.this$0.c.md5 + " destVideoPath:" + str + " mMessage.videoFileName:" + this.this$0.c.videoFileName);
      }
      if (TextUtils.isEmpty(this.this$0.c.videoFileName)) {
        break label280;
      }
      if ((!this.this$0.c.videoFileName.equals(str)) && (aqhq.copyFile(this.this$0.c.videoFileName, str))) {
        this.this$0.c.videoFileName = str;
      }
    }
    for (;;)
    {
      this.this$0.c.serial();
      this.this$0.mApp.b().c(this.this$0.c.frienduin, this.this$0.c.istroop, this.this$0.c.uniseq, this.this$0.c.msgData);
      this.this$0.a = this.b;
      this.this$0.destroy();
      return;
      label280:
      if (QLog.isColorLevel()) {
        QLog.d("VideoSend", 2, "onSend mMessage.videoFileName is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.segment.VideoSend.4
 * JD-Core Version:    0.7.0.1
 */