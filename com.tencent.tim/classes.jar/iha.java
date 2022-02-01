import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.c;
import com.tencent.qphone.base.util.QLog;

public class iha
  extends VideoController.c
{
  public iha(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.w(VideoController.TAG, 1, "onCompletion, onClose, mainSession[" + this.this$0.b() + "], seq[" + this.seq + "]");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.this$0.b().tg())
    {
      igd.aK(VideoController.TAG, "onCompletion onClose is not Closing2");
      this.seq = 0L;
      return;
    }
    this.this$0.O(this.this$0.b().peerUin, 217);
    this.this$0.ko(217);
    this.this$0.P(this.this$0.b().peerUin, this.this$0.b().ana);
    this.seq = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iha
 * JD-Core Version:    0.7.0.1
 */