import UserGrowth.stCallInfo;
import UserGrowth.stGlobalConfig;
import android.app.Activity;
import com.tencent.biz.pubaccount.weishi_new.util.OuterInterceptManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class uoo
{
  public static void a(Activity paramActivity, uos paramuos)
  {
    stGlobalConfig localstGlobalConfig = ugb.a().a();
    if ((localstGlobalConfig != null) && (localstGlobalConfig.callinfo != null) && (localstGlobalConfig.callinfo.switch_call_live))
    {
      upe.e("OuterInterceptManager", "stGlobalConfig.callinfo: " + localstGlobalConfig.callinfo);
      if (paramuos != null) {
        paramuos.b();
      }
      b(paramActivity, paramuos);
    }
    while (paramuos == null) {
      return;
    }
    paramuos.a();
  }
  
  private static void b(Activity paramActivity, uos paramuos)
  {
    ThreadManager.getUIHandler().post(new OuterInterceptManager.1(paramActivity, paramuos));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uoo
 * JD-Core Version:    0.7.0.1
 */