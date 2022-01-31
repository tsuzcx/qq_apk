import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.SplashActivityCore;
import com.tencent.qphone.base.util.QLog;

class dqg
  implements MediaPlayer.OnErrorListener
{
  dqg(dqc paramdqc) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Splash.testCanPlayMp4", 4, "onError");
    }
    this.a.a.handler.sendEmptyMessage(5);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dqg
 * JD-Core Version:    0.7.0.1
 */