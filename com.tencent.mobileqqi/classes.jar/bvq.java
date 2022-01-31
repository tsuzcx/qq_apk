import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.common.app.BaseApplicationImpl;

public class bvq
  implements MediaPlayer.OnCompletionListener
{
  public bvq(BaseApplicationImpl paramBaseApplicationImpl) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.release();
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     bvq
 * JD-Core Version:    0.7.0.1
 */