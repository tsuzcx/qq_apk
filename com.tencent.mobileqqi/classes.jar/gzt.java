import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnSeekListener;

public class gzt
  implements MediaPlayer.OnSeekCompleteListener
{
  public gzt(VideoViewX paramVideoViewX) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     gzt
 * JD-Core Version:    0.7.0.1
 */