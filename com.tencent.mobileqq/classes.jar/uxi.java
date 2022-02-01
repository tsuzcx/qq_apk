import UserGrowth.stCallInfo;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uxi
{
  public static void a(Activity paramActivity, uxm paramuxm)
  {
    stCallInfo localstCallInfo = umu.a().a();
    if ((localstCallInfo != null) && (localstCallInfo.switch_call_live))
    {
      uya.e("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstCallInfo);
      if (paramuxm != null) {
        paramuxm.b();
      }
      b(paramActivity, paramuxm);
    }
    while (paramuxm == null) {
      return;
    }
    paramuxm.a();
  }
  
  private static void b(Activity paramActivity, uxm paramuxm)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramuxm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxi
 * JD-Core Version:    0.7.0.1
 */