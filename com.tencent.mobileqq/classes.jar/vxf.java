import com.tencent.biz.qqcircle.requests.QCircleGetMainPageRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetMainPageRsp;

class vxf
  implements aaav<FeedCloudRead.StGetMainPageRsp>
{
  vxf(vxe paramvxe, QCircleGetMainPageRequest paramQCircleGetMainPageRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d("QCirclePersonalDetailViewModel", 1, "requestData onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetMainPageRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean + " | isCache:" + bool);
    this.jdField_a_of_type_Vxe.a(paramBoolean, paramLong, paramString, paramStGetMainPageRsp, Boolean.valueOf(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxf
 * JD-Core Version:    0.7.0.1
 */