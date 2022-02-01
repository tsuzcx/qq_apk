import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class ped
  implements rxc.a<FeedCloudRead.StGetMainPageRsp>
{
  ped(pec parampec, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = VSNetworkHelper.fQ(paramString);
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_b_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + this.jdField_b_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.us + " | isCache:" + bool);
    this.jdField_b_of_type_Pec.a(paramBoolean, paramLong, paramString, paramStGetMainPageRsp, Boolean.valueOf(this.us));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ped
 * JD-Core Version:    0.7.0.1
 */