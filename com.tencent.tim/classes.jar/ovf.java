import com.tencent.biz.qqcircle.adapter.QCircleFakeAdapter;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudRead.StGetFeedDetailRsp;
import java.util.ArrayList;

public class ovf
  implements rxc.a<FeedCloudRead.StGetFeedDetailRsp>
{
  public ovf(QCircleFakeAdapter paramQCircleFakeAdapter, QCircleFeedEvent paramQCircleFeedEvent, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFeedDetailRsp paramStGetFeedDetailRsp)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFeedDetailRsp.feed != null))
    {
      int i = QCircleFakeAdapter.a(this.this$0, this.a.mTargetId);
      if (i != -1)
      {
        oum.a(paramStGetFeedDetailRsp.feed.id.get(), (FeedCloudMeta.StFeed)this.this$0.getDataList().get(i));
        QCircleFakeAdapter.a(this.this$0, this.a.mTargetId);
        this.this$0.getDataList().remove(i);
        this.this$0.getDataList().add(i, paramStGetFeedDetailRsp.feed);
        this.this$0.notifyDataSetChanged();
        QLog.d("QCircleFakeAdapter", 1, "success replace feed");
      }
    }
    for (;;)
    {
      QLog.d("QCircleFakeAdapter", 1, "fetch real feed success:" + paramBoolean + "  retCode code:" + paramLong + "fromRetry" + this.ayH);
      return;
      this.this$0.f(this.a);
      QLog.d("QCircleFakeAdapter", 1, "start retry");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovf
 * JD-Core Version:    0.7.0.1
 */