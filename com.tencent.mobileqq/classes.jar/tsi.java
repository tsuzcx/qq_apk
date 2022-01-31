import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class tsi
  implements MediaPlayer.OnErrorListener
{
  tsi(tsf paramtsf) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    tsf.a(this.a);
    QLog.e("QCircleFolderSplashPart", 1, "play splash video error!what:" + paramInt1 + ",extra:" + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsi
 * JD-Core Version:    0.7.0.1
 */