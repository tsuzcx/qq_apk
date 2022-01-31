import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class tsn
  implements MediaPlayer.OnErrorListener
{
  tsn(tsk paramtsk) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    tsk.a(this.a);
    QLog.e("QCircleFolderSplashPart", 1, "play splash video error!what:" + paramInt1 + ",extra:" + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsn
 * JD-Core Version:    0.7.0.1
 */