import com.tencent.biz.qqcircle.requests.QCircleGetLightInteractRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetLightInteractListRsp;

class vxb
  implements aaav<FeedCloudRead.StGetLightInteractListRsp>
{
  vxb(vxa paramvxa, QCircleGetLightInteractRequest paramQCircleGetLightInteractRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetLightInteractListRsp paramStGetLightInteractListRsp)
  {
    boolean bool = VSNetworkHelper.a(paramString);
    QLog.d(vxa.a, 1, "requestPolyList onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetLightInteractRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetLightInteractRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isCache:" + bool);
    this.jdField_a_of_type_Vxa.a(paramBoolean, paramLong, this.jdField_a_of_type_Boolean, paramString, paramStGetLightInteractListRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vxb
 * JD-Core Version:    0.7.0.1
 */