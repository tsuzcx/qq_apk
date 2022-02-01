import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData;
import com.tencent.gdtad.aditem.GdtHandler.Params;

public class tjk
{
  public static long a;
  public static GdtHandler.Params a;
  
  static
  {
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean, int paramInt)
  {
    if (!(paramContext instanceof Activity)) {
      return;
    }
    a(paramContext, paramAdvertisementInfo, false, paramBoolean, paramInt);
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (((paramContext instanceof Activity)) && (paramAdvertisementInfo != null))
    {
      paramAdvertisementInfo.setClickPos(paramInt);
      Object localObject = JumpMode.FAIL;
      if (ugj.a(paramAdvertisementInfo))
      {
        if (paramAdvertisementInfo.isSoftAd()) {
          localObject = TKDAdJumpData.SoftAdJumpData.obtainJumpData(paramAdvertisementInfo).doJumpAction(paramContext);
        }
      }
      else
      {
        if (localObject == JumpMode.FAIL) {
          break label87;
        }
        uec.a(ReportAction.CLICK, (JumpMode)localObject, paramContext, paramAdvertisementInfo, 1, 1, 3);
      }
      label87:
      do
      {
        do
        {
          return;
          localObject = TKDAdJumpData.NormalAdJumpData.obtainJumpData(paramAdvertisementInfo).doJumpAction(paramContext);
          break;
          localObject = new udz();
          ((udz)localObject).d = paramBoolean1;
          ((udz)localObject).b = paramBoolean2;
          udq.a(paramAdvertisementInfo, (Activity)paramContext, 1, 1, 3, (udz)localObject);
        } while ((uki.a(paramAdvertisementInfo)) || ((paramAdvertisementInfo.isSoftAd()) && (paramAdvertisementInfo.mAdvertisementSoftInfo.c != 0)));
        paramAdvertisementInfo.setClickPos(paramInt);
        paramContext = udx.a(paramAdvertisementInfo, (Activity)paramContext, (udz)localObject);
      } while (paramContext == null);
      paramContext.f = ukr.b(paramAdvertisementInfo);
      jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = paramContext;
      jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    ukq.a("FastWebRecommendAdHelper", "onAdJump error: advertisementInfo is null or context is not activity");
  }
  
  public static void a(Context paramContext, BaseData paramBaseData, boolean paramBoolean, int paramInt)
  {
    if ((!(paramContext instanceof Activity)) || (!(paramBaseData instanceof AdData))) {
      return;
    }
    AdvertisementInfo localAdvertisementInfo2 = ((AdData)paramBaseData).a;
    AdvertisementInfo localAdvertisementInfo1 = localAdvertisementInfo2;
    if (localAdvertisementInfo2 == null) {
      localAdvertisementInfo1 = ukt.a((AdData)paramBaseData);
    }
    a(paramContext, localAdvertisementInfo1, false, paramBoolean, paramInt);
  }
  
  public void a()
  {
    uvp.a(2, jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params, jdField_a_of_type_Long);
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
  
  public void b()
  {
    jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = null;
    jdField_a_of_type_Long = -2147483648L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tjk
 * JD-Core Version:    0.7.0.1
 */