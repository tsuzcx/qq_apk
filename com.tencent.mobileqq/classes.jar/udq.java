import android.app.Activity;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class udq
{
  public static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, udz paramudz)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    uvp.a(paramActivity);
    int i = paramAdvertisementInfo.clickPos;
    paramudz = udy.a(paramAdvertisementInfo, paramActivity, paramudz);
    if (paramudz == JumpMode.AMS)
    {
      paramInt1 = 8;
      paramAdvertisementInfo.clickPos = i;
    }
    for (;;)
    {
      uec.a(ReportAction.CLICK, paramudz, paramActivity, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     udq
 * JD-Core Version:    0.7.0.1
 */