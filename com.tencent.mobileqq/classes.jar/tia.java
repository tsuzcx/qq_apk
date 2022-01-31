import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import mqq.app.MobileQQ;

public class tia
  implements Runnable
{
  public tia(QQSettingMe paramQQSettingMe) {}
  
  public void run()
  {
    if (this.a.a != null)
    {
      String str = this.a.a.getCurrentAccountUin();
      if (!TextUtils.isEmpty(str)) {
        WebProcessManager.a(str, "key_individuation_click_time");
      }
      this.a.a.getApplication().getSharedPreferences("emoticon_panel_" + this.a.a.getCurrentAccountUin(), 0).edit().putLong("sp_key_market_open_time", System.currentTimeMillis()).commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tia
 * JD-Core Version:    0.7.0.1
 */