import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class txs
  implements zac<FeedCloudRead.StGetFeedListRsp>
{
  txs(txq paramtxq, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    yii localyii;
    if (paramStGetFeedListRsp != null)
    {
      txq.a(this.jdField_a_of_type_Txq).a(paramStGetFeedListRsp.feedAttchInfo.get());
      txq.a(this.jdField_a_of_type_Txq).b(paramStGetFeedListRsp.adAttchInfo.get());
      localyii = txq.a(this.jdField_a_of_type_Txq);
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label227;
      }
    }
    label227:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localyii.a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Txq.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      txq.a(this.jdField_a_of_type_Txq).postValue(new tsb(paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean));
      this.jdField_a_of_type_Txq.a().a(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     txs
 * JD-Core Version:    0.7.0.1
 */