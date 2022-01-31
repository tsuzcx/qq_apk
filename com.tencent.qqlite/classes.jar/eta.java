import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public final class eta
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    com.tencent.mobileqq.utils.AudioUtil.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eta
 * JD-Core Version:    0.7.0.1
 */