import android.media.MediaPlayer;
import android.media.MediaPlayer.OnBufferingUpdateListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;

public class etl
  implements MediaPlayer.OnBufferingUpdateListener
{
  public etl(VideoViewX paramVideoViewX) {}
  
  public void onBufferingUpdate(MediaPlayer paramMediaPlayer, int paramInt)
  {
    VideoViewX.e(this.a, paramInt);
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).onBufferingUpdate(VideoViewX.a(this.a), paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etl
 * JD-Core Version:    0.7.0.1
 */