import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class tpx
{
  public static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, tqh paramtqh)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    uhs.a(paramActivity);
    int i = paramAdvertisementInfo.clickPos;
    boolean bool = tqg.a(paramAdvertisementInfo, paramActivity, paramtqh);
    if (bool)
    {
      paramInt1 = obb.T;
      paramAdvertisementInfo.clickPos = i;
    }
    for (;;)
    {
      tqk.a(bool, paramActivity, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpx
 * JD-Core Version:    0.7.0.1
 */