import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class tzg
  implements zac<FeedCloudRead.StGetBusiInfoRsp>
{
  tzg(tzf paramtzf, QCircleGetTabListRequest paramQCircleGetTabListRequest, ykg paramykg) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    QLog.d("QCircleFolderPreLoaderTask", 1, "QCircleFolderPreLoaderTask->onReceive: dispatch Success:" + paramBoolean + " |CmdName:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCmdName() + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if (this.jdField_a_of_type_Ykg != null) {
      this.jdField_a_of_type_Ykg.a(new Object[] { Boolean.valueOf(paramBoolean), Long.valueOf(paramLong), paramString, paramStGetBusiInfoRsp });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzg
 * JD-Core Version:    0.7.0.1
 */