import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class vlt
  implements zxa<FeedCloudRead.StGetFeedListRsp>
{
  vlt(vlr paramvlr, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean, zxz paramzxz) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d(this.jdField_a_of_type_Vlr.a(), 1, "requestRecommendFeedList onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    zxz localzxz;
    if (paramStGetFeedListRsp != null)
    {
      this.jdField_a_of_type_Zxz.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.jdField_a_of_type_Zxz.c(paramStGetFeedListRsp.adAttchInfo.get());
      localzxz = this.jdField_a_of_type_Zxz;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label230;
      }
    }
    label230:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localzxz.a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Vlr.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      uxx.a(vlr.a(this.jdField_a_of_type_Vlr), paramStGetFeedListRsp.vecFeed.get());
      vlr.a(this.jdField_a_of_type_Vlr).postValue(new uzp(paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vlt
 * JD-Core Version:    0.7.0.1
 */