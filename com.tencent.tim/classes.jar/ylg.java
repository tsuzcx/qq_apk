import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessActivity.7.1;
import com.tencent.mobileqq.widget.QQVideoView;
import com.tencent.qphone.base.util.QLog;

public class ylg
  implements MediaPlayer.OnPreparedListener
{
  public ylg(BlessActivity paramBlessActivity) {}
  
  public void onPrepared(MediaPlayer paramMediaPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.this$0), 2, "videoview onPrepared");
    }
    if (BlessActivity.a(this.this$0) != null) {
      BlessActivity.a(this.this$0).start();
    }
    BlessActivity.a(this.this$0).postDelayed(new BlessActivity.7.1(this), 800L);
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.this$0), 2, "videoview onPrepared");
    }
    anot.a(this.this$0.app, "CliOper", "", "", "0X800632D", "0X800632D", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ylg
 * JD-Core Version:    0.7.0.1
 */