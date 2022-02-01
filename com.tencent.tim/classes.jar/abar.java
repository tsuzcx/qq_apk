import android.media.AudioManager;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class abar
  implements aqup.a
{
  public abar(ShortVideoPreviewActivity paramShortVideoPreviewActivity) {}
  
  public void b(aqup paramaqup)
  {
    QLog.i("ShortVideoPreviewActivity", 1, "[onCompletion] ");
    if (VersionUtils.isrFroyo()) {
      ((AudioManager)this.this$0.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abar
 * JD-Core Version:    0.7.0.1
 */