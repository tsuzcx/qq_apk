import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.qphone.base.util.QLog;

public class yli
  implements MediaPlayer.OnErrorListener
{
  public yli(BlessActivity paramBlessActivity) {}
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(BlessActivity.a(this.this$0), 2, "videoview onError what=" + paramInt1 + ", extra=" + paramInt2);
    }
    BlessActivity.a(this.this$0, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yli
 * JD-Core Version:    0.7.0.1
 */