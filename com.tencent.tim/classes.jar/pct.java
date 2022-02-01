import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleHeartbeatSignalReportRequest;
import com.tencent.qphone.base.util.QLog;
import qqcircle.QQCircleReport.StHeartbeatSignalRsp;

class pct
  implements rxc.a<QQCircleReport.StHeartbeatSignalRsp>
{
  pct(pcr parampcr, QCircleHeartbeatSignalReportRequest paramQCircleHeartbeatSignalReportRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleReport.StHeartbeatSignalRsp paramStHeartbeatSignalRsp)
  {
    if (((!paramBoolean) || (paramLong != 0L) || (paramStHeartbeatSignalRsp == null)) && (!TextUtils.isEmpty(paramString))) {
      QLog.e("QCircleReportHelper", 1, "reportQCircleActiveIntervalTime error:" + paramString + ",traceId:" + this.a.getTraceId());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pct
 * JD-Core Version:    0.7.0.1
 */