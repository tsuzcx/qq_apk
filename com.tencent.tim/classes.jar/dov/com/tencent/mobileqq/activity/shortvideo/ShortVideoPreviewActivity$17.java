package dov.com.tencent.mobileqq.activity.shortvideo;

import android.media.MediaPlayer;
import android.os.Message;
import android.widget.SeekBar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ShortVideoPreviewActivity$17
  implements Runnable
{
  ShortVideoPreviewActivity$17(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void run()
  {
    Message localMessage;
    if ((this.this$0.mMediaPlayer.isPlaying()) && (this.this$0.mMediaPlayer != null) && (this.this$0.mSurfaceView != null))
    {
      localMessage = Message.obtain();
      localMessage.arg1 = this.this$0.mMediaPlayer.getCurrentPosition();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.17
 * JD-Core Version:    0.7.0.1
 */