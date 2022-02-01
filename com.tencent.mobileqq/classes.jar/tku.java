import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.2;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class tku
{
  private static tlx a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    Object localObject = (QQAppInterface)ozs.a();
    localObject = new tlx().a((AppInterface)localObject).a(BaseApplication.getContext()).a(paramInt2).b(paramInt1).a(paramAdvertisementInfo).d(nzq.a(paramAdvertisementInfo));
    if (paramAdvertisementInfo.mReportDataJson != null) {
      ((tlx)localObject).c(paramAdvertisementInfo.mReportDataJson);
    }
    return localObject;
  }
  
  public static void a(boolean paramBoolean, Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if ((paramBoolean) && (paramInt2 == nzq.a)) {
      paramInt1 = nzq.T;
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.1(paramAdvertisementInfo, paramInt2, paramInt3, paramContext, paramInt1));
      return;
    }
  }
  
  private static void b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = nzq.an;
    int j = paramAdvertisementInfo.clickPos;
    if (paramInt3 == 3) {
      paramInt1 = 2;
    }
    for (;;)
    {
      int k = tlc.a(paramAdvertisementInfo);
      paramContext = tlc.a(paramContext, paramAdvertisementInfo, paramInt2, j, tlc.a(paramAdvertisementInfo.downloadState, false), paramInt1, k);
      tlx localtlx = a(paramAdvertisementInfo, i, paramInt2);
      localtlx.e(paramContext);
      nzq.a(localtlx.a());
      tpx.a("ReadInJoyAdReportUtils", "softAdReport: scene = " + paramInt3 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      if (paramAdvertisementInfo.mAdvertisementSoftInfo == null)
      {
        return;
        if (paramInt3 == 4)
        {
          paramInt1 = 7;
          continue;
        }
        if ((paramInt3 == 5) && (paramAdvertisementInfo.mAdvertisementSoftInfo != null)) {
          paramInt1 = 8;
        }
      }
      else
      {
        localtlx = null;
        if (paramInt2 == nzq.a)
        {
          paramContext = localtlx;
          if (!paramAdvertisementInfo.mAdvertisementSoftInfo.a)
          {
            paramContext = paramAdvertisementInfo.mAdvertisementSoftInfo.I;
            paramAdvertisementInfo.mAdvertisementSoftInfo.a = true;
          }
        }
        for (;;)
        {
          ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.2(paramContext));
          return;
          paramContext = localtlx;
          if (paramInt2 == nzq.b)
          {
            paramContext = localtlx;
            if (!paramAdvertisementInfo.mAdvertisementSoftInfo.b)
            {
              paramContext = paramAdvertisementInfo.mAdvertisementSoftInfo.J;
              paramAdvertisementInfo.mAdvertisementSoftInfo.b = true;
            }
          }
        }
      }
      paramInt1 = 0;
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    long l1;
    long l2;
    label23:
    Object localObject2;
    if (paramInt1 == nzq.b)
    {
      l1 = 6L;
      if (!tpp.b(paramAdvertisementInfo)) {
        break label132;
      }
      l2 = 3010304L;
      localObject2 = tkt.a(tpp.d(paramAdvertisementInfo), tpp.b(paramAdvertisementInfo), paramAdvertisementInfo.downloadState);
      if (paramInt2 != 3) {
        break label140;
      }
    }
    label132:
    label140:
    for (Object localObject1 = "2";; localObject1 = "1")
    {
      localObject1 = tkt.a(paramAdvertisementInfo, l2, l1, (String)localObject2, (String)localObject1);
      localObject2 = a(paramAdvertisementInfo, 39, 119);
      ((tlx)localObject2).e((JSONObject)localObject1);
      nzq.a(((tlx)localObject2).a());
      tpx.a("ReadInJoyAdReportUtils", "gameAdReport: scene = " + paramInt2 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
      l1 = 9L;
      break;
      l2 = 3010204L;
      break label23;
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2)
  {
    nzq.a(a(paramAdvertisementInfo, paramInt1, paramInt2).a());
    tpx.a("ReadInJoyAdReportUtils", "normalAdReport: advertisementInfo = " + paramAdvertisementInfo.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tku
 * JD-Core Version:    0.7.0.1
 */