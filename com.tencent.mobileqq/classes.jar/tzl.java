import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class tzl
  implements yvn<FeedCloudRead.StGetFeedListRsp>
{
  tzl(tzk paramtzk, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCircleTagPageViewModel", 1, "requestTagPageData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    this.jdField_a_of_type_Tzk.a(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tzl
 * JD-Core Version:    0.7.0.1
 */