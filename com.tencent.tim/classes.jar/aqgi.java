import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class aqgi
  implements MediaPlayer.OnCompletionListener
{
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    aqge.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgi
 * JD-Core Version:    0.7.0.1
 */