import android.view.Window;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class btn
  implements Runnable
{
  public btn(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.a.setRequestedOrientation4Recording(true);
    this.a.a.getWindow().clearFlags(128);
    QQToast.a(this.a.a, 2131363149, 1).b(this.a.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     btn
 * JD-Core Version:    0.7.0.1
 */