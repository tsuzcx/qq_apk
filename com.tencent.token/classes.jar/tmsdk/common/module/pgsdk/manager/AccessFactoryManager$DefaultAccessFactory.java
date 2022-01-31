package tmsdk.common.module.pgsdk.manager;

import android.content.Context;
import com.meri.service.monitor.AccessibilityDispatcher;
import taiji.b;
import taiji.cq;

class AccessFactoryManager$DefaultAccessFactory
  implements IAccessFactory
{
  AccessFactoryManager$DefaultAccessFactory(AccessFactoryManager paramAccessFactoryManager)
  {
    a();
  }
  
  private void a()
  {
    AccessibilityDispatcher.a = new AccessFactoryManager.DefaultAccessFactory.1(this);
  }
  
  public int canPlay(Context paramContext)
  {
    return AccessibilityDispatcher.a(paramContext);
  }
  
  public void cancelPlay() {}
  
  public void startPlay(Context paramContext, b paramb, cq paramcq)
  {
    AccessibilityDispatcher.a(paramContext, paramb, paramcq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.AccessFactoryManager.DefaultAccessFactory
 * JD-Core Version:    0.7.0.1
 */