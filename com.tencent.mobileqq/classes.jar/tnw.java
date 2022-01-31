import android.content.SharedPreferences;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Date;

public class tnw
  implements Runnable
{
  public tnw(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void run()
  {
    Object localObject = this.a.getSharedPreferences("sp_qs_settings", 0);
    long l1 = ((SharedPreferences)localObject).getLong("qsec_status_update_last_time" + this.a.app.getCurrentAccountUin(), 0L);
    long l2 = ((SharedPreferences)localObject).getLong("qsec_status_expired_time" + this.a.app.getCurrentAccountUin(), 3600L);
    if (new Date().getTime() - l1 <= l2 * 1000L)
    {
      localObject = ((SharedPreferences)localObject).getString("qsec_status_tip_text" + this.a.app.getCurrentAccountUin(), "");
      this.a.runOnUiThread(new tnx(this, (String)localObject));
      return;
    }
    QQSettingSettingActivity.c(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tnw
 * JD-Core Version:    0.7.0.1
 */