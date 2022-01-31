import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class tzk
  implements zac<FeedCloudRead.StGetMainPageRsp>
{
  tzk(tzj paramtzj, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, ykg paramykg) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    QLog.d("QCirclePersonalDetailPreLoaderTask", 1, "QCirclePersonalDetailPreLoaderTask->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if (this.jdField_a_of_type_Ykg != null) {
      this.jdField_a_of_type_Ykg.a(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetMainPageRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzk
 * JD-Core Version:    0.7.0.1
 */