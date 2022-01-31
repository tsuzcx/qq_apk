package mqq.app;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.List;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class ProxyIpManagerImpl
  implements ProxyIpManager
{
  private static final int MSG_NOTIFY_PROXY_IP_CHANGED = 10000;
  private static final String SP_KEY_PROXYIP = "_key_proxyip_";
  private static final String TAG = "ProxyIpManagerImpl";
  private final AppRuntime mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
    }
  };
  
  public ProxyIpManagerImpl(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    reloadCache(this.mApp.getAccount(), true);
  }
  
  public List<ProxyIpManager.ProxyIp> getProxyIp(int paramInt)
  {
    return null;
  }
  
  public boolean isMobileNetWork(Context paramContext)
  {
    try
    {
      boolean bool = isMobileNetworkInfo(((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo());
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public boolean isMobileNetworkInfo(NetworkInfo paramNetworkInfo)
  {
    if (paramNetworkInfo == null) {}
    while ((paramNetworkInfo.getType() != 0) && (50 != paramNetworkInfo.getType())) {
      return false;
    }
    return true;
  }
  
  public void onDestroy() {}
  
  public void reloadCache(String paramString, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.ProxyIpManagerImpl
 * JD-Core Version:    0.7.0.1
 */