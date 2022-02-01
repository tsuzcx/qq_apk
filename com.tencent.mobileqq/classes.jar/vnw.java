import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class vnw
  implements aaav<FeedCloudRead.StGetFeedDetailRsp>
{
  vnw(vnv paramvnv, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d(this.jdField_a_of_type_Vnv.a(), 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.extInfo.has())) {
      this.jdField_a_of_type_Vnv.a((FeedCloudCommon.StCommonExt)paramStGetFeedDetailRsp.extInfo.get());
    }
    vnv.a(this.jdField_a_of_type_Vnv).postValue(new vbf(paramLong, paramString, paramStGetFeedDetailRsp, false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnw
 * JD-Core Version:    0.7.0.1
 */