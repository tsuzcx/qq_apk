import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05502.1;
import feedcloud.FeedCloudCommon.Entry;
import feedcloud.FeedCloudMeta.StFeed;
import java.util.List;

public class pcm
{
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, FeedCloudMeta.StFeed paramStFeed, List<FeedCloudCommon.Entry> paramList)
  {
    int i = pcr.a().getPageId();
    int j = pcr.a().sb();
    pcu.a().getReportHandler().post(new QCircleLpReportDc05502.1(paramString1, paramInt3, paramString2, paramString3, i, j, paramString4, paramString5, paramString6, paramString7, paramList, paramStFeed, paramInt1, paramInt2));
  }
  
  private static int sa()
  {
    return 5502;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcm
 * JD-Core Version:    0.7.0.1
 */