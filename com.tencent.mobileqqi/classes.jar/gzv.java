import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class gzv
  implements MediaPlayer.OnBufferingUpdateListener
{
  public gzv(VideoViewX paramVideoViewX) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    VideoViewX.e(this.a, paramInt);
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onBufferingUpdate(VideoViewX.a(this.a), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzv
 * JD-Core Version:    0.7.0.1
 */