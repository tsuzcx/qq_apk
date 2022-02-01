import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

final class aqww
  implements MediaPlayer.OnPreparedListener
{
  aqww(aqxa paramaqxa) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    paramMediaPlayer.start();
    paramMediaPlayer.setLooping(true);
    if (this.b != null) {
      this.b.arP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqww
 * JD-Core Version:    0.7.0.1
 */