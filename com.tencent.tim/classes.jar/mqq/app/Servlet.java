package mqq.app;

import android.content.Intent;
import android.os.Bundle;
import mqq.observer.BusinessObserver;

public abstract class Servlet
{
  private ServletContainer container;
  private AppRuntime mAppRuntime;
  
  public AppRuntime getAppRuntime()
  {
    return this.mAppRuntime;
  }
  
  ServletContainer getServletContainer()
  {
    return this.container;
  }
  
  public void init(AppRuntime paramAppRuntime, ServletContainer paramServletContainer)
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
  
  public void onCreate() {}
  
  protected void onDestroy() {}
  
  public abstract void service(Intent paramIntent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.Servlet
 * JD-Core Version:    0.7.0.1
 */