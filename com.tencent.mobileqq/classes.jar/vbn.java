import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class vbn
  implements MediaPlayer.OnErrorListener
{
  vbn(vbk paramvbk) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    vbk.a(this.a);
    QLog.e("QCircleFolderSplashPart", 1, "play splash video error!what:" + paramInt1 + ",extra:" + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbn
 * JD-Core Version:    0.7.0.1
 */