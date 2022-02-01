import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class uhy
{
  public static HashSet<String> a = new HashSet();
  
  public static void a()
  {
    a.clear();
  }
  
  public static void a(int paramInt, spg paramspg)
  {
    if (paramspg == null) {}
    spk localspk;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localspk = paramspg.a();
        paramspg = paramspg.a();
      } while ((paramspg == null) || (localspk == null) || (!(localspk.a instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localspk.a;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(paramspg, localAdvertisementInfo, localspk);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, spk paramspk)
  {
    if ((paramspk == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramspk.a instanceof AdvertisementInfo)) || (!paramspk.b) || (a.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    ois.a(new ufy().a(paramActivity).a(27).b(3).a(paramAdvertisementInfo).a());
    a.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhy
 * JD-Core Version:    0.7.0.1
 */