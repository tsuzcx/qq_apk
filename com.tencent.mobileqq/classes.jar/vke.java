import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class vke
  implements zxa<FeedCloudRead.StGetFeedDetailRsp>
{
  vke(vkb paramvkb, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.extInfo.has())) {
      this.jdField_a_of_type_Vkb.a((FeedCloudCommon.StCommonExt)paramStGetFeedDetailRsp.extInfo.get());
    }
    vkb.a(this.jdField_a_of_type_Vkb).postValue(new uzp(paramLong, paramString, paramStGetFeedDetailRsp, false));
    this.jdField_a_of_type_Vkb.a().a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vke
 * JD-Core Version:    0.7.0.1
 */