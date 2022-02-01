import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.a;

public class aauv
  implements MediaPlayer.OnCompletionListener
{
  public aauv(FixedSizeVideoView paramFixedSizeVideoView) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.d.a != null)
    {
      if (FixedSizeVideoView.a(this.d) != null) {
        FixedSizeVideoView.a(this.d).removeMessages(0);
      }
      this.d.a.b(paramMediaPlayer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aauv
 * JD-Core Version:    0.7.0.1
 */