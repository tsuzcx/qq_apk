import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.ArrayList;
import java.util.HashSet;

public class klv
{
  public static HashSet<String> H = new HashSet();
  
  public static void a(int paramInt, mye parammye)
  {
    if (parammye == null) {}
    mye.b localb;
    AdvertisementInfo localAdvertisementInfo;
    do
    {
      do
      {
        return;
        localb = parammye.c();
        parammye = parammye.getActivity();
      } while ((parammye == null) || (localb == null) || (!(localb.d instanceof AdvertisementInfo)));
      localAdvertisementInfo = (AdvertisementInfo)localb.d;
    } while (paramInt < localAdvertisementInfo.mC2SReportTriggerTime / 1000);
    a(parammye, localAdvertisementInfo, localb);
  }
  
  public static boolean a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo, mye.b paramb)
  {
    if ((paramb == null) || (paramActivity == null) || (paramAdvertisementInfo == null)) {}
    while ((!(paramb.d instanceof AdvertisementInfo)) || (!paramb.aqp) || (H.contains(paramAdvertisementInfo.mAdTraceId)) || (paramAdvertisementInfo.mC2SVideoPlayUrl == null) || (paramAdvertisementInfo.mC2SVideoPlayUrl.size() <= 0)) {
      return false;
    }
    jzk.a(new kku.a().a(paramActivity).a(jzk.aFo).b(jzk.aFw).a(paramAdvertisementInfo).a());
    H.add(paramAdvertisementInfo.mAdTraceId);
    return true;
  }
  
  public static void aEk()
  {
    H.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     klv
 * JD-Core Version:    0.7.0.1
 */