import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils.2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class uec
{
  public static ufy a(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, JumpMode paramJumpMode)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)pkh.a();
    paramJumpMode = new ufy().a(localQQAppInterface).a(BaseApplication.getContext()).a(paramInt2).b(paramInt1).a(paramJumpMode).a(paramAdvertisementInfo).d(ois.a(paramAdvertisementInfo));
    if (paramAdvertisementInfo.mReportDataJson != null) {
      paramJumpMode.c(paramAdvertisementInfo.mReportDataJson);
    }
    return paramJumpMode;
  }
  
  public static void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(null, JumpMode.UNKNOWN, paramContext, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  public static void a(JumpMode paramJumpMode, Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(null, paramJumpMode, paramContext, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  public static void a(ReportAction paramReportAction, JumpMode paramJumpMode, Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramReportAction, paramJumpMode, paramContext, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3, false);
  }
  
  public static void a(ReportAction paramReportAction, JumpMode paramJumpMode, Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    if ((paramJumpMode == JumpMode.AMS) && (paramInt2 == 1)) {
      paramInt1 = 8;
    }
    for (;;)
    {
      ThreadManager.getSubThreadHandler().post(new ReadInJoyAdReportUtils.1(paramAdvertisementInfo, paramInt2, paramInt3, paramBoolean, paramJumpMode, paramReportAction, paramContext, paramInt1));
      return;
    }
  }
  
  private static void b(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, JumpMode paramJumpMode, ReportAction paramReportAction)
  {
    int i = paramAdvertisementInfo.clickPos;
    paramInt1 = 0;
    ActionEntity localActionEntity;
    if (paramInt3 == 3)
    {
      paramInt1 = 2;
      localActionEntity = null;
    }
    for (;;)
    {
      int j = uek.a(paramAdvertisementInfo);
      paramContext = uek.a(paramContext, paramAdvertisementInfo, paramInt2, i, uek.a(paramAdvertisementInfo.downloadState, false), paramInt1, j);
      paramJumpMode = a(paramAdvertisementInfo, 35, paramInt2, paramJumpMode).a(paramReportAction).e(paramContext).a(localActionEntity);
      if (paramBoolean) {}
      for (paramContext = ExposeMode.LOOSE;; paramContext = ExposeMode.STRICT)
      {
        ois.a(paramJumpMode.a(paramContext).b(paramBoolean).a());
        ukq.a("ReadInJoyAdReportUtils", "softAdReport: scene = " + paramInt3 + " advertisementInfo = " + paramAdvertisementInfo.toString());
        if (paramAdvertisementInfo.mAdvertisementSoftInfo != null) {
          break label187;
        }
        return;
        if (paramInt3 == 4)
        {
          paramInt1 = 7;
          localActionEntity = ActionEntity.ArticleFloat;
          break;
        }
        if ((paramInt3 != 5) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {
          break label280;
        }
        paramInt1 = 8;
        localActionEntity = null;
        break;
      }
      label187:
      paramJumpMode = null;
      if (paramInt2 == 1)
      {
        paramContext = paramJumpMode;
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
        paramContext = paramJumpMode;
        if (paramInt2 == 2)
        {
          paramContext = paramJumpMode;
          if (!paramAdvertisementInfo.mAdvertisementSoftInfo.b)
          {
            paramContext = paramAdvertisementInfo.mAdvertisementSoftInfo.J;
            paramAdvertisementInfo.mAdvertisementSoftInfo.b = true;
          }
        }
      }
      label280:
      localActionEntity = null;
    }
  }
  
  private static void c(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, JumpMode paramJumpMode, ReportAction paramReportAction)
  {
    long l1;
    long l2;
    label22:
    Object localObject;
    if (paramInt1 == 2)
    {
      l1 = 6L;
      if (!uki.b(paramAdvertisementInfo)) {
        break label155;
      }
      l2 = 3010304L;
      String str = ueb.a(uki.d(paramAdvertisementInfo), uki.b(paramAdvertisementInfo), paramAdvertisementInfo.downloadState);
      if (paramInt2 != 3) {
        break label163;
      }
      localObject = "2";
      label48:
      localObject = ueb.a(paramAdvertisementInfo, l2, l1, str, (String)localObject);
      paramReportAction = a(paramAdvertisementInfo, 39, 119, paramJumpMode).a(paramReportAction).e((JSONObject)localObject);
      if (!paramBoolean) {
        break label170;
      }
    }
    label155:
    label163:
    label170:
    for (paramJumpMode = ExposeMode.LOOSE;; paramJumpMode = ExposeMode.STRICT)
    {
      ois.a(paramReportAction.a(paramJumpMode).b(paramBoolean).a());
      ukq.a("ReadInJoyAdReportUtils", "gameAdReport: scene = " + paramInt2 + " advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
      l1 = 9L;
      break;
      l2 = 3010204L;
      break label22;
      localObject = "1";
      break label48;
    }
  }
  
  private static void d(AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, boolean paramBoolean, JumpMode paramJumpMode, ReportAction paramReportAction)
  {
    paramReportAction = a(paramAdvertisementInfo, paramInt1, paramInt2, paramJumpMode).a(paramReportAction);
    if (paramBoolean) {}
    for (paramJumpMode = ExposeMode.LOOSE;; paramJumpMode = ExposeMode.STRICT)
    {
      ois.a(paramReportAction.a(paramJumpMode).b(paramBoolean).a());
      ukq.a("ReadInJoyAdReportUtils", "normalAdReport: advertisementInfo = " + paramAdvertisementInfo.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uec
 * JD-Core Version:    0.7.0.1
 */