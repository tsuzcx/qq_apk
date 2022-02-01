package com.tencent.mobileqq.loginwelcome;

import aivs;
import aivs.a;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import ardp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.URL;

public class GateWayVerifyManager$4
  implements Runnable
{
  public GateWayVerifyManager$4(aivs paramaivs, String paramString, aivs.a parama) {}
  
  public void run()
  {
    for (;;)
    {
      int i;
      Object localObject2;
      boolean bool;
      try
      {
        Object localObject1 = (ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity");
        ardp.getMethod(ConnectivityManager.class, "startUsingNetworkFeature", new Class[] { Integer.TYPE, String.class }).invoke(localObject1, new Object[] { Integer.valueOf(0), "enableHIPRI" });
        i = 0;
        if (i < 4)
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(5);
          if (localObject2 == null) {
            QLog.e("GateWayVerifyManager", 1, "networkInfo is null");
          }
        }
        else
        {
          localObject2 = InetAddress.getByName(new URL(this.Iq).getHost());
          if (!(localObject2 instanceof Inet4Address)) {
            break label310;
          }
          i = aivs.a(this.this$0, ((InetAddress)localObject2).getHostAddress());
          localObject1 = ardp.getMethod(ConnectivityManager.class, "requestRouteToHost", new Class[] { Integer.TYPE, Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(5), Integer.valueOf(i) });
          if ((!(localObject1 instanceof Boolean)) || (!((Boolean)localObject1).booleanValue())) {
            break label369;
          }
          bool = true;
          QLog.d("GateWayVerifyManager", 1, new Object[] { "changeNetTypeToMobileV19 finish: ", Boolean.valueOf(bool) });
          if (!bool) {
            break label337;
          }
          aivs.a(this.this$0, this.Iq, this.a);
          return;
        }
        localObject2 = ((NetworkInfo)localObject2).getState();
        if (localObject2 == null)
        {
          QLog.e("GateWayVerifyManager", 1, "checkState is null");
          continue;
        }
        if (((NetworkInfo.State)localObject2).compareTo(NetworkInfo.State.CONNECTED) == 0) {
          continue;
        }
      }
      catch (Exception localException)
      {
        QLog.e("GateWayVerifyManager", 1, new Object[] { "switch network error", localException.getMessage() });
        this.a.c(localException);
        return;
      }
      Thread.sleep(1000L);
      i += 1;
      continue;
      label310:
      if ((localObject2 instanceof Inet6Address))
      {
        i = aivs.a(this.this$0, ((InetAddress)localObject2).getHostAddress()).intValue();
        continue;
        label337:
        QLog.e("GateWayVerifyManager", 1, "切换网络失败or无数据网络");
        this.a.c(new Exception("change network to mobile failed or no mobile network"));
      }
      else
      {
        i = 0;
        continue;
        label369:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginwelcome.GateWayVerifyManager.4
 * JD-Core Version:    0.7.0.1
 */