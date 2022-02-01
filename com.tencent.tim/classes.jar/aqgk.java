import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.utils.AudioUtil.6.1;

public final class aqgk
  implements MediaPlayer.OnCompletionListener
{
  aqgk(MediaPlayer.OnCompletionListener paramOnCompletionListener, Handler paramHandler) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (aqge.access$100() == 0)
    {
      if (this.e != null)
      {
        if ((this.dI == null) || (this.dI.getLooper() == Looper.myLooper()))
        {
          this.e.onCompletion(aqge.d);
          return;
        }
        aqge.bVz();
        this.dI.post(new AudioUtil.6.1(this));
        return;
      }
      aqge.bVz();
      return;
    }
    aqge.access$110();
    aqge.d.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqgk
 * JD-Core Version:    0.7.0.1
 */