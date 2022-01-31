import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.BaseApplicationImpl;

public class bvo
  implements MediaPlayer.OnCompletionListener
{
  public bvo(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvo
 * JD-Core Version:    0.7.0.1
 */