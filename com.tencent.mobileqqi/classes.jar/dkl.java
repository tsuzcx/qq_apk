import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import com.tencent.mobileqq.activity.SplashActivityCore;
import com.tencent.qphone.base.util.QLog;

public class dkl
  implements Runnable
{
  public dkl(SplashActivityCore paramSplashActivityCore, Uri paramUri) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Splash.testCanPlayMp4", 4, "thread start....");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.mTestMp == null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.mTestMp = new MediaPlayer();
    }
    MediaPlayer localMediaPlayer = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.mTestMp;
    try
    {
      localMediaPlayer.setOnInfoListener(new dkm(this));
      localMediaPlayer.setOnCompletionListener(new dkn(this));
      localMediaPlayer.setOnPreparedListener(new dko(this));
      localMediaPlayer.setOnErrorListener(new dkp(this));
      localMediaPlayer.setVolume(0.0F, 0.0F);
      localMediaPlayer.setDataSource(SplashActivityCore.access$000(this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore), this.jdField_a_of_type_AndroidNetUri);
      localMediaPlayer.prepare();
      localMediaPlayer.start();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("Splash.testCanPlayMp4", 4, "Exception " + localException.getMessage());
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.mTestMp = null;
      this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivityCore.handler.sendEmptyMessage(5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dkl
 * JD-Core Version:    0.7.0.1
 */