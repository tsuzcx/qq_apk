import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedListRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedListRsp;

class pav
  implements rxc.a<FeedCloudRead.StGetFeedListRsp>
{
  pav(pat parampat, QCircleGetFeedListRequest paramQCircleGetFeedListRequest, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp)
  {
    boolean bool = true;
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString + " | isLoadMore:" + this.us);
    rxt localrxt;
    if (paramStGetFeedListRsp != null)
    {
      pat.a(this.b).sP(paramStGetFeedListRsp.feedAttchInfo.get());
      pat.a(this.b).sQ(paramStGetFeedListRsp.adAttchInfo.get());
      localrxt = pat.a(this.b);
      if (paramStGetFeedListRsp.isFinish.get() != 1) {
        break label227;
      }
    }
    label227:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localrxt.setFinish(paramBoolean);
      if (paramStGetFeedListRsp.extInfo.has()) {
        this.b.a((FeedCloudCommon.StCommonExt)paramStGetFeedListRsp.extInfo.get());
      }
      pat.a(this.b).postValue(new owb(paramLong, paramString, paramStGetFeedListRsp, this.us));
      this.b.getLoadInfo().setCurrentState(4);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pav
 * JD-Core Version:    0.7.0.1
 */