import android.os.Handler;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.1;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05504.2;
import feedcloud.FeedCloudCommon.Entry;
import java.util.List;

public class vrf
{
  private static void a(int paramInt1, int paramInt2) {}
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, 0, "", "", "", "", "");
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramString, paramInt1, paramInt2, paramInt3, "", "", "", "", "", null, -1, -1);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramString, paramInt1, paramInt2, paramInt3, "", "", "", "", "", null, paramInt4, -1);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, "", "", "", "", paramString2, null, -1, -1);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, int paramInt4)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, "", "", "", "", paramString2, null, paramInt4, -1);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, null, -1, -1);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt4)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, null, paramInt4, -1);
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, byte[] paramArrayOfByte, int paramInt4, int paramInt5)
  {
    if (paramInt4 == 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05504", 1, "report invalid pageId," + paramInt4 + ",actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      a(paramInt1, paramInt2);
    }
    vrl.a().a().post(new QCircleLpReportDc05504.2(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramInt4, paramInt5, paramArrayOfByte));
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, byte[] paramArrayOfByte, int paramInt4, int paramInt5)
  {
    a(paramString1, paramInt1, paramInt2, paramInt3, paramString2, paramString3, "", paramString4, paramString5, paramString6, paramArrayOfByte, paramInt4, paramInt5);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2, int paramInt3, List<FeedCloudCommon.Entry> paramList, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramInt4 == 0)
    {
      QLog.e("QCircleReportBean_QCircleLpReportDc05504", 1, "report invalid pageId," + paramInt4 + ",actionType:" + paramInt1 + ",subActionType:" + paramInt2);
      a(paramInt1, paramInt2);
    }
    vrl.a().a().post(new QCircleLpReportDc05504.1(paramString, paramInt1, paramInt2, paramInt3, paramInt4, paramList, paramArrayOfByte));
  }
  
  private static int b()
  {
    return 5504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrf
 * JD-Core Version:    0.7.0.1
 */