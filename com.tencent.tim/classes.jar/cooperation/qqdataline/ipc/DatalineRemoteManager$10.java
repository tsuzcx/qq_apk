package cooperation.qqdataline.ipc;

import android.os.Bundle;
import aviq;
import avix;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class DatalineRemoteManager$10
  implements Runnable
{
  public DatalineRemoteManager$10(aviq paramaviq) {}
  
  public void run()
  {
    for (;;)
    {
      Bundle localBundle;
      if (!this.this$0.EM.isEmpty())
      {
        localBundle = (Bundle)this.this$0.EM.remove(0);
        if (localBundle != null) {}
      }
      else
      {
        return;
      }
      String str = localBundle.getString("notify_cmd");
      try
      {
        localBundle.setClassLoader(getClass().getClassLoader());
        if (QLog.isColorLevel()) {
          QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send success strNotifyCmd:" + str);
        }
        this.this$0.a.b("com.qqdataline.action.notify", localBundle);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      if (QLog.isColorLevel()) {
        QLog.d("DatalineRemoteManager", 2, "doPostCachedMsg send failed strNotifyCmd:" + str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqdataline.ipc.DatalineRemoteManager.10
 * JD-Core Version:    0.7.0.1
 */