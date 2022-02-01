import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05502.1;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class vto
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList, int paramInt4, int paramInt5)
  {
    if (paramInt4 <= 0) {
      QLog.e("QCircleReportBean_QCircleLpReportDc05502", 1, "report invalid pageId," + paramInt4 + ",fpageId:" + paramInt5);
    }
    vtw.a().a().post(new QCircleLpReportDc05502.1(paramString1, paramInt3, paramString2, paramString3, paramInt4, paramInt5, paramString4, paramString5, paramString6, paramString7, paramList, paramStFeed, paramInt1, paramInt2));
  }
  
  private static int b()
  {
    return 5502;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vto
 * JD-Core Version:    0.7.0.1
 */