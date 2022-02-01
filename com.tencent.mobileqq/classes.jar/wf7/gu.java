package wf7;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.IBinder;
import java.lang.reflect.Constructor;

public class gu
{
  public static WifiManager G(Context paramContext)
  {
    Object localObject = gw.P("wifi");
    localObject = gs.a("android.net.wifi.IWifiManager$Stub", "asInterface", new Class[] { IBinder.class }, null, new Object[] { localObject });
    try
    {
      Constructor localConstructor = WifiManager.class.getConstructor(new Class[] { Context.class, Class.forName("android.net.wifi.IWifiManager") });
      localConstructor.setAccessible(true);
      paramContext = (WifiManager)localConstructor.newInstance(new Object[] { paramContext, localObject });
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wf7.gu
 * JD-Core Version:    0.7.0.1
 */