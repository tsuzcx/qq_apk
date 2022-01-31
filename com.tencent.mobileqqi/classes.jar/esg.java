import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.widget.Button;
import com.tencent.mobileqq.activity.qquserguide.UserguideVideoFragment;

public class esg
  implements MediaPlayer.OnCompletionListener
{
  public esg(UserguideVideoFragment paramUserguideVideoFragment) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (this.a.a.getVisibility() == 8) {
      this.a.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esg
 * JD-Core Version:    0.7.0.1
 */