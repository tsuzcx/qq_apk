import com.tencent.biz.qqcircle.requests.QCircleGetTabListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetBusiInfoRsp;

class ubw
  implements zac<FeedCloudRead.StGetBusiInfoRsp>
{
  ubw(ubv paramubv, QCircleGetTabListRequest paramQCircleGetTabListRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetBusiInfoRsp paramStGetBusiInfoRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCircleTabViewModel", 1, "requestTabData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetTabListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isCache:" + bool);
    this.jdField_a_of_type_Ubv.a(paramBoolean, paramLong, paramString, paramStGetBusiInfoRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubw
 * JD-Core Version:    0.7.0.1
 */