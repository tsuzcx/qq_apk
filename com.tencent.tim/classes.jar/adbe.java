import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class adbe
  implements MediaPlayer.OnPreparedListener
{
  adbe(adbc paramadbc) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + adbc.b(this.a));
      }
      this.a.mediaPlayer.seekTo(0);
      adbc.b(this.a, true);
      if (adbc.b(this.a))
      {
        this.a.mediaPlayer.start();
        adbc.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbe
 * JD-Core Version:    0.7.0.1
 */