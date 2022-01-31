package tmsdk.common.module.pgsdk.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.meri.service.monitor.d;

class AccessFactoryManager$DefaultAccessFactory$1
  implements d
{
  AccessFactoryManager$DefaultAccessFactory$1(AccessFactoryManager.DefaultAccessFactory paramDefaultAccessFactory) {}
  
  public boolean forceMonitorAllPkg()
  {
    return false;
  }
  
  public HandlerThread getHandlerThread(String paramString)
  {
    return new HandlerThread("AccessibilityDispatcher");
  }
  
  public Handler getMonitorCallbackHandler()
  {
    HandlerThread localHandlerThread = new HandlerThread("MonitorCallbackHandler");
    localHandlerThread.start();
    return new Handler(localHandlerThread.getLooper());
  }
  
  public void onAutoReturn() {}
  
  public Bundle onConnected(Bundle paramBundle)
  {
    return paramBundle;
  }
  
  public void onCreate() {}
  
  public void onException(Throwable paramThrowable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.AccessFactoryManager.DefaultAccessFactory.1
 * JD-Core Version:    0.7.0.1
 */