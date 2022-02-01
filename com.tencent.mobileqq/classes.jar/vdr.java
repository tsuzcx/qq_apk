import com.tencent.biz.qqcircle.requests.QCircleGetRankingListRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetRankingListRsp;

class vdr
  implements zxa<FeedCloudRead.StGetRankingListRsp>
{
  vdr(vdq paramvdq, QCircleGetRankingListRequest paramQCircleGetRankingListRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetRankingListRsp paramStGetRankingListRsp)
  {
    QLog.d("QCircleTagHeaderPart", 1, "requestTagPageData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetRankingListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetRankingListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    vdq.a(this.jdField_a_of_type_Vdq, paramBoolean, paramLong, paramString, paramStGetRankingListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdr
 * JD-Core Version:    0.7.0.1
 */