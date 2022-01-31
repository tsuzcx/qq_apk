package btmsdkobf;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tmsdk.base.TMSDKBaseContext;
import com.tmsdk.base.utils.NetworkUtil;

class ff
  extends BroadcastReceiver
  implements eb.a
{
  public static boolean a = false;
  
  public void O()
  {
    if (bc.m())
    {
      bn.L();
      if (NetworkUtil.isWifiConnected())
      {
        TMSDKBaseContext.aroundWifiReport();
        TMSDKBaseContext.wifiConnectRetReport();
      }
    }
  }
  
  public void P() {}
  
  public void a(Context paramContext)
  {
    try
    {
      if (!a)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.USER_PRESENT");
        localIntentFilter.setPriority(2147483647);
        paramContext.registerReceiver(this, localIntentFilter);
        paramContext = eb.k(paramContext);
        if (paramContext != null) {
          paramContext.a(this);
        }
        a = true;
      }
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      if ("android.intent.action.USER_PRESENT".equals(paramIntent.getAction())) {}
      for (int i = 3; (i != -1) && (bc.m()); i = -1)
      {
        bn.L();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.ff
 * JD-Core Version:    0.7.0.1
 */