import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

public class wbo
  implements MediaPlayer.OnPreparedListener
{
  public wbo(BlessActivity paramBlessActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onPrepared");
    }
    if (BlessActivity.a(this.a) != null) {
      BlessActivity.a(this.a).start();
    }
    BlessActivity.a(this.a).postDelayed(new wbp(this), 800L);
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.a), 2, "videoview onPrepared");
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */