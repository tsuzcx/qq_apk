import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mobileqq.utils.AudioUtil;

public final class etd
  implements MediaPlayer.OnCompletionListener
{
  public etd(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (AudioUtil.b() == 0)
    {
      if (this.a != null) {
        this.a.onCompletion(paramMediaPlayer);
      }
      return;
    }
    AudioUtil.c();
    AudioUtil.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     etd
 * JD-Core Version:    0.7.0.1
 */