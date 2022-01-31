import android.view.Window;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class umn
  implements Runnable
{
  public umn(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.a.setRequestedOrientation4Recording(true);
    this.a.a.getWindow().clearFlags(128);
    QQToast.a(this.a.a, 2131433770, 1).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     umn
 * JD-Core Version:    0.7.0.1
 */