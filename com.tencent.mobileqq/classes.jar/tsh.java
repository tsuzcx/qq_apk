import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import com.tencent.qphone.base.util.QLog;

class tsh
  implements MediaPlayer.OnInfoListener
{
  tsh(tsg paramtsg) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 3) {
      QLog.d("QCircleFolderSplashPart", 1, "videoView render start");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsh
 * JD-Core Version:    0.7.0.1
 */