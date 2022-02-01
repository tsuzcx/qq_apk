package cooperation.qqdataline.ipc;

import android.os.Bundle;
import avio;
import aviq;
import com.tencent.mobileqq.app.BaseActivity;

public class DatalineRemoteManager$12
  implements Runnable
{
  public DatalineRemoteManager$12(aviq paramaviq) {}
  
  public void run()
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("string_from", true);
    localBundle.putBoolean("string_uin", false);
    localBundle.putLong("device_din", 0L);
    localBundle.putInt("sTitleID", 0);
    avio.b(BaseActivity.sTopActivity, localBundle, "com.qqdataline.activity.LiteWifiphotoActivity");
    BaseActivity.sTopActivity.overridePendingTransition(2130772009, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.12
 * JD-Core Version:    0.7.0.1
 */