import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;

public class tli
  implements Runnable
{
  public tli(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    RichStatus localRichStatus = QQSettingMe.a(this.a).a(true);
    this.a.a.runOnUiThread(new tlj(this, localRichStatus));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tli
 * JD-Core Version:    0.7.0.1
 */