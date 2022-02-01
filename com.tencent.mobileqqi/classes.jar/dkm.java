import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.SplashActivityCore;
import com.tencent.qphone.base.util.QLog;

class dkm
  implements MediaPlayer.OnCompletionListener
{
  dkm(dkk paramdkk) {}
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Splash.testCanPlayMp4", 4, "OnCompletion");
    }
    if (paramMediaPlayer.getCurrentPosition() == 0)
    {
      this.a.a.handler.sendEmptyMessage(5);
      return;
    }
    this.a.a.handler.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dkm
 * JD-Core Version:    0.7.0.1
 */