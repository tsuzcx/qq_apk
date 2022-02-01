package wf7;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.text.TextUtils;

class db$1$1
  implements Runnable
{
  db$1$1(db.1 param1, Intent paramIntent) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_if.getAction();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    if ("android.net.wifi.SCAN_RESULTS".equals(localObject1))
    {
      db.a(this.jR.jQ);
      return;
    }
    if ("android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(localObject1))
    {
      Object localObject2 = null;
      int i = -1;
      try
      {
        localObject1 = (WifiConfiguration)this.jdField_if.getParcelableExtra("wifiConfiguration");
        try
        {
          int j = this.jdField_if.getIntExtra("changeReason", -1);
          i = j;
        }
        catch (Throwable localThrowable1) {}
        localThrowable2.printStackTrace();
      }
      catch (Throwable localThrowable2)
      {
        localObject1 = localObject2;
      }
      boolean bool = this.jdField_if.getBooleanExtra("multipleChanges", false);
      db.a(this.jR.jQ, (WifiConfiguration)localObject1, i, bool);
      bw.c((WifiConfiguration)localObject1);
      if (localObject1 != null) {
        bw.a(((WifiConfiguration)localObject1).networkId, bw.as().at());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.db.1.1
 * JD-Core Version:    0.7.0.1
 */