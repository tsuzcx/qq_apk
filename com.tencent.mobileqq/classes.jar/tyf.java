import android.os.Handler;
import com.tencent.biz.qqcircle.report.QCircleLpReportDc05494.1;
import com.tencent.biz.qqcircle.report.QCircleTaskReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class tyf
{
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, String paramString3, long paramLong1, String paramString4, int paramInt4, String paramString5, long paramLong2, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString10, String paramString11, long paramLong3, String paramString12)
  {
    typ.a().a().post(new QCircleLpReportDc05494.1(paramInt1, paramInt2, paramInt3, paramString1, paramString2, paramString3, paramLong1, paramString4, paramInt4, paramString5, paramLong2, paramString6, paramString7, paramString8, paramString9, paramInt5, paramInt6, paramInt7, paramInt8, paramString10, paramString11, paramLong3, paramString12));
  }
  
  public static void a(ArrayList<QCircleTaskReportInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      QLog.e("QCircleReportHelper_QCircleLpReportDc05494", 2, "taskReportInfos == null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        QCircleTaskReportInfo localQCircleTaskReportInfo = (QCircleTaskReportInfo)paramArrayList.get(i);
        a(localQCircleTaskReportInfo.up_source, localQCircleTaskReportInfo.up_type, localQCircleTaskReportInfo.is_video, localQCircleTaskReportInfo.txtinfo, localQCircleTaskReportInfo.lloc, localQCircleTaskReportInfo.vid, localQCircleTaskReportInfo.photocubage, localQCircleTaskReportInfo.feedid, localQCircleTaskReportInfo.total_upload_num, localQCircleTaskReportInfo.shooting_time, localQCircleTaskReportInfo.orig_photocubage, localQCircleTaskReportInfo.place, localQCircleTaskReportInfo.up_place, localQCircleTaskReportInfo.shoot_product, localQCircleTaskReportInfo.shoot_model, localQCircleTaskReportInfo.width, localQCircleTaskReportInfo.height, localQCircleTaskReportInfo.orig_width, localQCircleTaskReportInfo.orig_height, localQCircleTaskReportInfo.picture_format, localQCircleTaskReportInfo.feed_tag, localQCircleTaskReportInfo.author_uin, localQCircleTaskReportInfo.shoot_place);
        i += 1;
      }
    }
  }
  
  private static int c()
  {
    return 5494;
  }
  
  private static int d()
  {
    return 36;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tyf
 * JD-Core Version:    0.7.0.1
 */