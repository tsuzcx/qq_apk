import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER.StDataReportRsp;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.CommandReportRequest;
import com.tencent.qphone.base.util.QLog;

class vtz
  implements aaav<APP_REPORT_TRANSFER.StDataReportRsp>
{
  vtz(vtw paramvtw, CommandReportRequest paramCommandReportRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, APP_REPORT_TRANSFER.StDataReportRsp paramStDataReportRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStDataReportRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReporter", 1, "performCommandReport error:" + paramString + ",traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsCommandReportRequest.getTraceId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtz
 * JD-Core Version:    0.7.0.1
 */