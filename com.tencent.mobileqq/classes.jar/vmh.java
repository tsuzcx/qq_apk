import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class vmh
  implements aaav<FeedCloudRead.StGetFeedListRsp>
{
  vmh(vmf paramvmf, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    QLog.d("QCircleContentModel", 1, "requestTagPageData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    vmf.a(this.jdField_a_of_type_Vmf, paramBoolean, paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmh
 * JD-Core Version:    0.7.0.1
 */