import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

final class aqgf
  implements MediaPlayer.OnCompletionListener
{
  aqgf(MediaPlayer.OnCompletionListener paramOnCompletionListener) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (aqge.access$100() == 0)
    {
      if (this.e != null)
      {
        this.e.onCompletion(aqge.d);
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
 * Qualified Name:     aqgf
 * JD-Core Version:    0.7.0.1
 */