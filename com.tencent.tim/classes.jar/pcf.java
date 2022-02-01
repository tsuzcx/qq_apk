import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class pcf
  implements rxc.a<FeedCloudRead.StGetMainPageRsp>
{
  pcf(pce parampce, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, ryt paramryt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if (this.jdField_a_of_type_Ryt != null) {
      this.jdField_a_of_type_Ryt.u(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetMainPageRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pcf
 * JD-Core Version:    0.7.0.1
 */