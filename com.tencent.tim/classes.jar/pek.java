import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class pek
  implements rxc.a<FeedCloudRead.StGetFeedListRsp>
{
  pek(pej parampej, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    QLog.d("QCircleTagPageViewModel", 1, "requestTagPageData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_b_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_b_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.us + " | isCache:" + bool);
    this.jdField_b_of_type_Pej.b(paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.us);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pek
 * JD-Core Version:    0.7.0.1
 */