import android.media.MediaPlayer;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.c;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

public class igz
  extends VideoController.c
{
  public igz(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    QLog.w(VideoController.TAG, 1, "onCompletion, request, mainSession[" + this.this$0.b() + "], seq[" + this.seq + "]");
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    if (!this.this$0.b().tf())
    {
      this.seq = 0L;
      return;
    }
    this.this$0.b.seq = this.seq;
    paramMediaPlayer = this.this$0;
    long l = this.seq;
    if (this.this$0.b().li == 2L) {}
    for (int i = 4;; i = 1)
    {
      paramMediaPlayer.a(l, 2131230754, i, this.this$0.b);
      this.this$0.b().Y("OnCompletionListener", 6);
      this.this$0.mApp.l(new Object[] { Integer.valueOf(14), Integer.valueOf(this.this$0.b().ana), this.this$0.b().peerUin, Long.valueOf(this.seq) });
      this.seq = 0L;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     igz
 * JD-Core Version:    0.7.0.1
 */