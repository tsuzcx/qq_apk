import UserGrowth.stCallInfo;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class vlx
{
  public static void a(Activity paramActivity, vmb paramvmb)
  {
    stCallInfo localstCallInfo = vau.a().a();
    if ((localstCallInfo != null) && (localstCallInfo.switch_call_live))
    {
      vmp.e("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstCallInfo);
      if (paramvmb != null) {
        paramvmb.b();
      }
      b(paramActivity, paramvmb);
    }
    while (paramvmb == null) {
      return;
    }
    paramvmb.a();
  }
  
  private static void b(Activity paramActivity, vmb paramvmb)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramvmb));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlx
 * JD-Core Version:    0.7.0.1
 */