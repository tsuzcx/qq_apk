import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class ttr
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, sdc paramsdc)
  {
    if (paramsdc == null) {}
    sdg localsdg;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localsdg = paramsdc.a();
        paramsdc = paramsdc.a();
      } while ((paramsdc == null) || (localsdg == null) || (!(localsdg.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localsdg.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramsdc, localAdvertisementInfo, localsdg);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, sdg paramsdg)
  {
    if ((paramsdg == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramsdg.a instanceof AdvertisementInfo)) || (!paramsdg.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    obb.a(new trn().a(paramActivity).a(obb.F).b(obb.N).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ttr
 * JD-Core Version:    0.7.0.1
 */