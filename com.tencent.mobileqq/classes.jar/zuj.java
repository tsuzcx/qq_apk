import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.ar.ARMusicController;
import com.tencent.qphone.base.util.QLog;

public class zuj
  implements MediaPlayer.OnErrorListener
{
  public zuj(ARMusicController paramARMusicController) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ARMusicController", 2, "ARMusicController, onError, what=" + paramInt1 + ", extra=" + paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     zuj
 * JD-Core Version:    0.7.0.1
 */