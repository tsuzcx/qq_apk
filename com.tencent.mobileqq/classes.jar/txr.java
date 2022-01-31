import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class txr
  implements zac<FeedCloudRead.StGetFeedDetailRsp>
{
  txr(txq paramtxq, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedDetailRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.extInfo.has())) {
      this.jdField_a_of_type_Txq.a((FeedCloudCommon.StCommonExt)paramStGetFeedDetailRsp.extInfo.get());
    }
    txq.a(this.jdField_a_of_type_Txq).postValue(new tsb(paramLong, paramString, paramStGetFeedDetailRsp, false));
    this.jdField_a_of_type_Txq.a().a(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txr
 * JD-Core Version:    0.7.0.1
 */