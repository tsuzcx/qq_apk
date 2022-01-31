import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class tqc
  implements Runnable
{
  public tqc(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    RichStatus localRichStatus = QQSettingMe.a(this.a).a(true);
    this.a.a.runOnUiThread(new tqd(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tqc
 * JD-Core Version:    0.7.0.1
 */