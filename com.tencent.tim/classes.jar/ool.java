import UserGrowth.stCallInfo;
import UserGrowth.stGlobalConfig;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class ool
{
  public static void a(Activity paramActivity, ool.a parama)
  {
    stGlobalConfig localstGlobalConfig = ohy.a().a();
    if ((localstGlobalConfig != null) && (localstGlobalConfig.callinfo != null) && (localstGlobalConfig.callinfo.switch_call_live))
    {
      ooz.bY("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstGlobalConfig.callinfo);
      if (parama != null) {
        parama.bfz();
      }
      b(paramActivity, parama);
    }
    while (parama == null) {
      return;
    }
    parama.bfy();
  }
  
  private static void b(Activity paramActivity, ool.a parama)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, parama));
  }
  
  public static abstract interface a
  {
    public abstract void bfA();
    
    public abstract void bfB();
    
    public abstract void bfy();
    
    public abstract void bfz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ool
 * JD-Core Version:    0.7.0.1
 */