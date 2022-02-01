package tmsdk.common.module.pgsdk.manager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import com.meri.service.monitor.AccessibilityDispatcher;
import com.meri.service.monitor.a;
import taiji.b;
import taiji.bp.a;

public class AccessFactoryManager
{
  private IAccessFactory a;
  
  private void a()
  {
    if (this.a == null) {
      this.a = new DefaultAccessFactory();
    }
  }
  
  public static AccessFactoryManager get()
  {
    return Holder.a();
  }
  
  public IAccessFactory accessFactory()
  {
    a();
    return this.a;
  }
  
  public void init(IAccessFactory paramIAccessFactory)
  {
    this.a = paramIAccessFactory;
  }
  
  private class DefaultAccessFactory
    implements IAccessFactory
  {
    DefaultAccessFactory()
    {
      a();
    }
    
    private void a()
    {
      AccessibilityDispatcher.a = new a()
      {
        public boolean forceMonitorAllPkg()
        {
          return false;
        }
        
        public HandlerThread getHandlerThread(String paramAnonymousString)
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
        
        public Bundle onConnected(Bundle paramAnonymousBundle)
        {
          return paramAnonymousBundle;
        }
        
        public void onCreate() {}
        
        public void onException(Throwable paramAnonymousThrowable) {}
      };
    }
    
    public int canPlay(Context paramContext)
    {
      return AccessibilityDispatcher.a(paramContext);
    }
    
    public void cancelPlay() {}
    
    public void startPlay(Context paramContext, b paramb, bp.a parama)
    {
      AccessibilityDispatcher.a(paramContext, paramb, parama);
    }
  }
  
  private static final class Holder
  {
    private static final AccessFactoryManager a = new AccessFactoryManager(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.AccessFactoryManager
 * JD-Core Version:    0.7.0.1
 */