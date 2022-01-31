import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.qphone.base.util.QLog;

public class zul
  implements MediaPlayer.OnPreparedListener
{
  public zul(ARMusicController paramARMusicController) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ARMusicController", 2, "load bg music success. : " + ARMusicController.b(this.a));
      }
      this.a.a.seekTo(0);
      ARMusicController.b(this.a, true);
      if (ARMusicController.b(this.a))
      {
        this.a.a.start();
        ARMusicController.c(this.a, false);
      }
      return;
    }
    catch (Exception paramMediaPlayer)
    {
      paramMediaPlayer.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zul
 * JD-Core Version:    0.7.0.1
 */