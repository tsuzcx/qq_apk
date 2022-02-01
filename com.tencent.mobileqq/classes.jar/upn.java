import UserGrowth.stCallInfo;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class upn
{
  public static void a(Activity paramActivity, upr paramupr)
  {
    stCallInfo localstCallInfo = ugd.a().a();
    if ((localstCallInfo != null) && (localstCallInfo.switch_call_live))
    {
      uqf.e("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstCallInfo);
      if (paramupr != null) {
        paramupr.b();
      }
      b(paramActivity, paramupr);
    }
    while (paramupr == null) {
      return;
    }
    paramupr.a();
  }
  
  private static void b(Activity paramActivity, upr paramupr)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramupr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     upn
 * JD-Core Version:    0.7.0.1
 */