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
    Object localObject = this.jdField_if.getAction();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return;
      if ("android.net.wifi.SCAN_RESULTS".equals(localObject))
      {
        db.a(this.jR.jQ);
        return;
      }
    } while (!"android.net.wifi.CONFIGURED_NETWORKS_CHANGE".equals(localObject));
    for (;;)
    {
      try
      {
        localObject = (WifiConfiguration)this.jdField_if.getParcelableExtra("wifiConfiguration");
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          i = this.jdField_if.getIntExtra("changeReason", -1);
          boolean bool = this.jdField_if.getBooleanExtra("multipleChanges", false);
          db.a(this.jR.jQ, (WifiConfiguration)localObject, i, bool);
          bw.c((WifiConfiguration)localObject);
          if ((localObject == null) || (bw.a(((WifiConfiguration)localObject).networkId, bw.as().at()) == null)) {
            break;
          }
          return;
        }
        catch (Throwable localThrowable2)
        {
          int i;
          break label123;
        }
        localThrowable1 = localThrowable1;
        localObject = null;
      }
      label123:
      localThrowable1.printStackTrace();
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wf7.db.1.1
 * JD-Core Version:    0.7.0.1
 */