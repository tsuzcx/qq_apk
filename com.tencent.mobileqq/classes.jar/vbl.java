import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import com.tencent.qphone.base.util.QLog;

class vbl
  implements MediaPlayer.OnPreparedListener
{
  vbl(vbk paramvbk) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    QLog.d("QCircleFolderSplashPart", 1, "videoView onPrepared!");
    paramMediaPlayer.start();
    vrf.a("", 19, 3, 0, "1");
    paramMediaPlayer.setOnInfoListener(new vbm(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vbl
 * JD-Core Version:    0.7.0.1
 */