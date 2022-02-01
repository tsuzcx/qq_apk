import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class vuh
  implements zxa<FeedCloudRead.StGetFeedListRsp>
{
  vuh(vuf paramvuf, boolean paramBoolean, QCircleGetFeedListRequest paramQCircleGetFeedListRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    this.jdField_a_of_type_Vuf.a(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean);
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + VSNetworkHelper.a(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vuh
 * JD-Core Version:    0.7.0.1
 */