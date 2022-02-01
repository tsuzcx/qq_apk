import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class vnx
  implements aaav<FeedCloudRead.StGetFeedListRsp>
{
  vnx(vnv paramvnv, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean, aabu paramaabu) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d(this.jdField_a_of_type_Vnv.a(), 1, "requestRecommendFeedList onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getTraceId() + " | SeqId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleGetFeedListRequest.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.jdField_a_of_type_Boolean);
    aabu localaabu;
    if (paramStGetFeedListRsp != null)
    {
      this.jdField_a_of_type_Aabu.a(paramStGetFeedListRsp.feedAttchInfo.get());
      this.jdField_a_of_type_Aabu.c(paramStGetFeedListRsp.adAttchInfo.get());
      localaabu = this.jdField_a_of_type_Aabu;
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label230;
      }
    }
    label230:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localaabu.a(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.jdField_a_of_type_Vnv.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      uzg.a(vnv.a(this.jdField_a_of_type_Vnv), paramStGetFeedListRsp.vecFeed.get());
      vnv.a(this.jdField_a_of_type_Vnv).postValue(new vbf(paramLong, paramString, paramStGetFeedListRsp, this.jdField_a_of_type_Boolean));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vnx
 * JD-Core Version:    0.7.0.1
 */