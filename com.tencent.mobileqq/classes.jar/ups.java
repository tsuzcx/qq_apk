import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ups
  implements Runnable
{
  public ups(CommonRecordSoundPanel paramCommonRecordSoundPanel) {}
  
  public void run()
  {
    this.a.b();
    QQToast.a(this.a.a, this.a.a.getString(2131433385), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ups
 * JD-Core Version:    0.7.0.1
 */