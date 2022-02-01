import android.arch.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.requests.QCircleGetFeedDetailRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.StCommonExt;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;

class pau
  implements rxc.a<FeedCloudRead.StGetFeedDetailRsp>
{
  pau(pat parampat, QCircleGetFeedDetailRequest paramQCircleGetFeedDetailRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    QLog.d("QCircleContentModel", 1, "getSingleFeed onReceive: dispatch Success:" + paramBoolean + " | TraceId:" + this.a.getTraceId() + " | SeqId:" + this.a.getCurrentSeq() + " | retCode:" + paramLong + " | retMessage:" + paramString);
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.extInfo.has())) {
      this.b.a((FeedCloudCommon.StCommonExt)paramStGetFeedDetailRsp.extInfo.get());
    }
    pat.a(this.b).postValue(new owb(paramLong, paramString, paramStGetFeedDetailRsp, false));
    this.b.getLoadInfo().setCurrentState(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pau
 * JD-Core Version:    0.7.0.1
 */