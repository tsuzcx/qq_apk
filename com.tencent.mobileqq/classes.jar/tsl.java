import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class tsl
  implements MediaPlayer.OnPreparedListener
{
  tsl(tsk paramtsk) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.d("QCircleFolderSplashPart", 1, "videoView onPrepared!");
    paramMediaPlayer.start();
    tzv.a("", 19, 3L, 0L, "1");
    paramMediaPlayer.setOnInfoListener(new tsm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsl
 * JD-Core Version:    0.7.0.1
 */