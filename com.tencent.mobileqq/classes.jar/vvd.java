import android.text.TextUtils;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StPushList;
import feedcloud.FeedCloudWrite.StDoPushReq;
import feedcloud.FeedCloudWrite.StDoPushRsp;

public class vvd
  implements aadr<QCircleDoRecommendRequest, FeedCloudWrite.StDoPushRsp, vuz>
{
  public String a()
  {
    return "QCirclePushRspInterceptor";
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QCircleDoRecommendRequest paramQCircleDoRecommendRequest, FeedCloudWrite.StDoPushRsp paramStDoPushRsp, vuz paramvuz)
  {
    if ((paramBoolean) && (paramLong == 0L) && (paramQCircleDoRecommendRequest != null) && (paramStDoPushRsp != null))
    {
      if ((paramQCircleDoRecommendRequest.getReq() != null) && (!TextUtils.isEmpty(paramQCircleDoRecommendRequest.getReq().feed.id.get()))) {
        break label59;
      }
      QLog.d(a(), 4, "interceptReturnRsp params error");
    }
    label59:
    do
    {
      return;
      paramString = paramQCircleDoRecommendRequest.getReq().feed.id.get();
      paramQCircleDoRecommendRequest = vqt.a().a(paramString);
    } while (paramQCircleDoRecommendRequest == null);
    int i = paramQCircleDoRecommendRequest.hasClickCount.get() + paramStDoPushRsp.consumeFuel.get();
    vwl.a(paramQCircleDoRecommendRequest, i);
    vqt.a().a(paramString, paramQCircleDoRecommendRequest);
    paramString = new QCirclePushUpdateEvent(uyn.a(), paramString, i);
    aaak.a().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvd
 * JD-Core Version:    0.7.0.1
 */