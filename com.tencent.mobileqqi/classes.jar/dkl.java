import android.media.MediaPlayer;
import android.media.MediaPlayer.OnInfoListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.SplashActivityCore;
import com.tencent.qphone.base.util.QLog;

class dkl
  implements MediaPlayer.OnInfoListener
{
  dkl(dkk paramdkk) {}
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 700) || (paramInt1 == 1)) {
      this.a.a.handler.sendEmptyMessage(5);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("Splash.testCanPlayMp4", 1, "onInfo...what = ." + paramInt1 + " extra = " + paramInt2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dkl
 * JD-Core Version:    0.7.0.1
 */