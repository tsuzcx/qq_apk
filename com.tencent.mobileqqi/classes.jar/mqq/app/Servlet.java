package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import mqq.observer.BusinessObserver;

public abstract class Servlet
{
  private static final long HOLD_TIME = 300000L;
  private ServletContainer container;
  private long lastAccessTime;
  private AppRuntime mAppRuntime;
  
  protected void finalize()
    throws Throwable
  {
    super.finalize();
  }
  
  public AppRuntime getAppRuntime()
  {
    return this.mAppRuntime;
  }
  
  long getLastAccessTime()
  {
    return this.lastAccessTime;
  }
  
  ServletContainer getServletContainer()
  {
    return this.container;
  }
  
  void init(AppRuntime paramAppRuntime, ServletContainer paramServletContainer)
  {
    this.mAppRuntime = paramAppRuntime;
    this.container = paramServletContainer;
  }
  
  public void notifyObserver(Intent paramIntent, int paramInt, boolean paramBoolean, Bundle paramBundle, Class<? extends BusinessObserver> paramClass)
  {
    if ((paramIntent instanceof NewIntent))
    {
      paramIntent = ((NewIntent)paramIntent).getObserver();
      if (paramIntent != null) {
        getAppRuntime().notifyObserver(paramIntent, paramInt, paramBoolean, paramBundle);
      }
    }
    getAppRuntime().notifyObservers(paramClass, paramInt, paramBoolean, paramBundle);
  }
  
  protected void onCreate() {}
  
  protected void onDestroy() {}
  
  public abstract void service(Intent paramIntent);
  
  void updateAccessTime()
  {
    this.lastAccessTime = (SystemClock.uptimeMillis() + 300000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     mqq.app.Servlet
 * JD-Core Version:    0.7.0.1
 */