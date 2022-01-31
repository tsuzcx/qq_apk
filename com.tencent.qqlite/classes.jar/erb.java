import android.media.MediaPlayer;
import android.media.MediaPlayer.OnSeekCompleteListener;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnSeekListener;

public class erb
  implements MediaPlayer.OnSeekCompleteListener
{
  public erb(VideoViewX paramVideoViewX) {}
  
  public void onSeekComplete(MediaPlayer paramMediaPlayer)
  {
    if (VideoViewX.a(this.a) != null) {
      VideoViewX.a(this.a).i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     erb
 * JD-Core Version:    0.7.0.1
 */