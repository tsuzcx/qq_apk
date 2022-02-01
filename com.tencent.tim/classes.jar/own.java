import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.qphone.base.util.QLog;

class own
  implements MediaPlayer.OnErrorListener
{
  own(owk paramowk) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    owk.a(this.this$0);
    QLog.e("QCircleFolderSplashPart", 1, "play splash video error!what:" + paramInt1 + ",extra:" + paramInt2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     own
 * JD-Core Version:    0.7.0.1
 */