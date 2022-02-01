import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class tnu
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, rvy paramrvy)
  {
    if (paramrvy == null) {}
    rwc localrwc;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localrwc = paramrvy.a();
        paramrvy = paramrvy.a();
      } while ((paramrvy == null) || (localrwc == null) || (!(localrwc.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localrwc.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramrvy, localAdvertisementInfo, localrwc);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, rwc paramrwc)
  {
    if ((paramrwc == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramrwc.a instanceof AdvertisementInfo)) || (!paramrwc.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    nzq.a(new tlx().a(paramActivity).a(nzq.F).b(nzq.N).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tnu
 * JD-Core Version:    0.7.0.1
 */