package com.tencent.mobileqq.activity.shortvideo;

import android.os.Message;
import android.widget.SeekBar;
import aqup;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$21
  implements Runnable
{
  ShortVideoPreviewActivity$21(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    Message localMessage;
    if ((this.this$0.a.isPlaying()) && (this.this$0.mSurfaceView != null))
    {
      localMessage = Message.obtain();
      localMessage.arg1 = this.this$0.a.getCurrentPosition();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreviewActivity", 2, "此时时间为+" + localMessage.arg1);
      }
      this.this$0.p.setProgress(localMessage.arg1);
      if (this.this$0.B != null) {}
    }
    else
    {
      return;
    }
    this.this$0.B.sendMessage(localMessage);
    this.this$0.B.post(this.this$0.fo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.21
 * JD-Core Version:    0.7.0.1
 */