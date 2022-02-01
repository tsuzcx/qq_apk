import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class tkj
{
  public static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, tkr paramtkr)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    ubd.a(paramActivity);
    int i = paramAdvertisementInfo.clickPos;
    boolean bool = tkq.a(paramAdvertisementInfo, paramActivity, paramtkr);
    if (bool)
    {
      paramInt1 = nzq.T;
      paramAdvertisementInfo.clickPos = i;
    }
    for (;;)
    {
      tku.a(bool, paramActivity, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkj
 * JD-Core Version:    0.7.0.1
 */