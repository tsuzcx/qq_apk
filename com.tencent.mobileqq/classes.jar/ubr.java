import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class ubr
  implements zac<FeedCloudRead.StGetMainPageRsp>
{
  ubr(ubq paramubq, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    this.jdField_a_of_type_Ubq.a(paramBoolean, paramLong, paramString, paramStGetMainPageRsp, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ubr
 * JD-Core Version:    0.7.0.1
 */