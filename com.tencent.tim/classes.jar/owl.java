import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class owl
  implements MediaPlayer.OnPreparedListener
{
  owl(owk paramowk) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.d("QCircleFolderSplashPart", 1, "videoView onPrepared!");
    paramMediaPlayer.start();
    pco.a("", 19, 3L, 0L, "1");
    paramMediaPlayer.setOnInfoListener(new owm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     owl
 * JD-Core Version:    0.7.0.1
 */