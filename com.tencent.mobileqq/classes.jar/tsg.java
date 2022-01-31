import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class tsg
  implements MediaPlayer.OnPreparedListener
{
  tsg(tsf paramtsf) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.d("QCircleFolderSplashPart", 1, "videoView onPrepared!");
    paramMediaPlayer.start();
    paramMediaPlayer.setOnInfoListener(new tsh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tsg
 * JD-Core Version:    0.7.0.1
 */