import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMsgHistoryActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class trl
  implements Runnable
{
  public trl(QQSettingMsgHistoryActivity paramQQSettingMsgHistoryActivity) {}
  
  public void run()
  {
    this.a.app.getPreferences().edit().putBoolean("chatHistoryEventEntryFirstShow", false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     trl
 * JD-Core Version:    0.7.0.1
 */