import android.media.MediaPlayer;
import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.VideoController.c;
import com.tencent.av.app.VideoAppInterface;

public class ihb
  extends VideoController.c
{
  public ihb(VideoController paramVideoController)
  {
    super(paramVideoController);
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.this$0.aX != null)
    {
      this.this$0.mApp.getHandler().removeCallbacks(this.this$0.aX);
      this.this$0.aX = null;
    }
    igd.aK(VideoController.TAG, "onCompletion onCloseDoubleVideoMeeting");
    if (this.this$0.b().Qx)
    {
      if (paramMediaPlayer != null) {
        paramMediaPlayer.release();
      }
      long l = this.this$0.b().ll;
      this.this$0.mApp.l(new Object[] { Integer.valueOf(28), String.valueOf(l), Boolean.valueOf(true) });
      this.this$0.b(3, l, 85);
      this.this$0.b().R("OnCloseDoubleVideoMeetingListener", false);
      this.this$0.b().S("OnCloseDoubleVideoMeetingListener", false);
    }
    for (;;)
    {
      this.seq = 0L;
      return;
      igd.aL(VideoController.TAG, "mOnCloseDoubleVideoMeetingListener-->Is not in doubleMeetingRoom");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ihb
 * JD-Core Version:    0.7.0.1
 */