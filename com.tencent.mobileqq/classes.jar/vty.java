import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleClientReportRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StDataReportRsp;

class vty
  implements aaav<QQCircleReport.StDataReportRsp>
{
  vty(vtw paramvtw, QCircleClientReportRequest paramQCircleClientReportRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StDataReportRsp paramStDataReportRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReporter", 1, "performClientReport error:" + paramString + ",traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleClientReportRequest.getTraceId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vty
 * JD-Core Version:    0.7.0.1
 */