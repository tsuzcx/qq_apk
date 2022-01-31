import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;

public class bsv
  implements MediaPlayer.OnCompletionListener
{
  public bsv(MediaPlayerManager paramMediaPlayerManager) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (paramMediaPlayer != null) {
      paramMediaPlayer.release();
    }
    com.tencent.mobileqq.utils.AudioUtil.a = null;
    if ((MediaPlayerManager.a(this.a) != null) && (MediaPlayerManager.a(this.a))) {
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsv
 * JD-Core Version:    0.7.0.1
 */