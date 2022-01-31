import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05501.1;
import com.tencent.biz.qqcircle.report.ReportExtraTypeInfo;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import java.util.List;

public class tyg
{
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo)
  {
    a(paramInt1, paramInt2, paramExtraTypeInfo, null);
  }
  
  public static void a(int paramInt1, int paramInt2, ExtraTypeInfo paramExtraTypeInfo, List<FeedCloudCommon.Entry> paramList)
  {
    if ((!(paramExtraTypeInfo instanceof ReportExtraTypeInfo)) || (((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed == null))
    {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05501", 1, "ExtraTypeInfo is not ReportExtraTypeInfo,actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      return;
    }
    a(((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed.poster.id.get(), paramInt1, paramInt2, paramExtraTypeInfo.mDataPosition, ((ReportExtraTypeInfo)paramExtraTypeInfo).mFeed, paramList);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, String paramString2, String paramString3, String paramString4, int paramInt6, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    int i = tym.a().a();
    int j = tym.a().b();
    typ.a().a().post(new QCircleLpReportDc05501.1(paramString1, paramInt3, paramInt4, paramInt5, paramString2, paramString3, i, j, paramString4, paramInt6, paramList, paramStFeed, paramInt1, paramInt2));
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    if (paramStFeed == null) {
      return;
    }
    int[] arrayOfInt = tyc.a(paramStFeed);
    a(paramString, arrayOfInt[0], arrayOfInt[1], paramInt1, paramInt2, paramInt3, paramStFeed.id.get(), tyc.a(paramStFeed), paramStFeed.poster.id.get(), -1, paramStFeed, paramList);
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    a(paramString, paramStFeed, paramInt1, paramInt2, null);
  }
  
  public static void a(String paramString, FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2, List<FeedCloudCommon.Entry> paramList)
  {
    a(paramString, paramInt2, 2, paramInt1, paramStFeed, paramList);
  }
  
  private static int b()
  {
    return 5501;
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) || (paramInt1 == 2)) {}
    while ((paramInt1 == 3) && (paramInt2 == 1)) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyg
 * JD-Core Version:    0.7.0.1
 */