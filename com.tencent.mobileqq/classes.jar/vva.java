import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushReq;

public class vva
  extends aadn<QCircleDoRecommendRequest, vuz>
{
  public long a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest)
  {
    return 1500L;
  }
  
  public QCircleDoRecommendRequest a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest1, QCircleDoRecommendRequest paramQCircleDoRecommendRequest2)
  {
    FeedCloudWrite.StDoPushReq localStDoPushReq = paramQCircleDoRecommendRequest1.getReq();
    paramQCircleDoRecommendRequest2 = paramQCircleDoRecommendRequest2.getReq();
    int i = localStDoPushReq.comboCount.get();
    int j = paramQCircleDoRecommendRequest2.comboCount.get();
    localStDoPushReq.comboCount.set(j + i);
    paramQCircleDoRecommendRequest1.setReq(localStDoPushReq);
    return paramQCircleDoRecommendRequest1;
  }
  
  public String a()
  {
    return "QCirclePushMergeReqInterceptor";
  }
  
  public String a(QCircleDoRecommendRequest paramQCircleDoRecommendRequest)
  {
    FeedCloudWrite.StDoPushReq localStDoPushReq = paramQCircleDoRecommendRequest.getReq();
    return paramQCircleDoRecommendRequest.getCmdName() + localStDoPushReq.feed.id.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vva
 * JD-Core Version:    0.7.0.1
 */