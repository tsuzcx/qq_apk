import UserGrowth.stCallInfo;
import UserGrowth.stGlobalConfig;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tky
{
  public static void a(Activity paramActivity, tlc paramtlc)
  {
    stGlobalConfig localstGlobalConfig = tee.a().a();
    if ((localstGlobalConfig != null) && (localstGlobalConfig.callinfo != null) && (localstGlobalConfig.callinfo.switch_call_live))
    {
      tlo.e("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstGlobalConfig.callinfo);
      if (paramtlc != null) {
        paramtlc.b();
      }
      b(paramActivity, paramtlc);
    }
    while (paramtlc == null) {
      return;
    }
    paramtlc.a();
  }
  
  private static void b(Activity paramActivity, tlc paramtlc)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramtlc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tky
 * JD-Core Version:    0.7.0.1
 */