import android.content.Context;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushRsp;

class pgv
  implements rxc.a<FeedCloudWrite.StDoPushRsp>
{
  pgv(pgu parampgu, QCircleDoRecommendRequest paramQCircleDoRecommendRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoPushRsp paramStDoPushRsp)
  {
    boolean bool = true;
    QLog.d("QCircleRecommend_", 1, "QCircleDoRecommendRequest push is success:" + paramBoolean + " retCode:" + paramLong);
    if ((paramLong == 0L) && (paramStDoPushRsp != null))
    {
      QLog.d("QCircleRecommend_", 1, "req traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoRecommendRequest.getTraceId());
      QLog.d("QCircleRecommend_", 1, "QCircleDoRecommendRequest push success myFuel:" + paramStDoPushRsp.myFuel.get() + "consumeFuel" + paramStDoPushRsp.consumeFuel.get());
      QCircleRecommendImageView.c(this.jdField_a_of_type_Pgu.this$0, QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0) + paramStDoPushRsp.consumeFuel.get());
      paramString = new QCirclePushUpdateEvent(oum.a(), QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0).id.get(), QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0));
      paramString.mHashCode = this.jdField_a_of_type_Pgu.this$0.hashCode();
      rwv.a().a(paramString);
      QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0, paramStDoPushRsp.myFuel.get(), paramStDoPushRsp.consumeFuel.get());
      paramString = this.jdField_a_of_type_Pgu.this$0;
      if (QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0) <= 0) {
        break label418;
      }
    }
    label418:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QCircleRecommendImageView.a(paramString, paramBoolean);
      QCircleRecommendImageView.b(this.jdField_a_of_type_Pgu.this$0, QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0));
      return;
      if (paramLong == 700207L)
      {
        QLog.d("QCircleRecommend_", 1, "CW_HAVE_PUSH_MAX_CNT");
        QCircleRecommendImageView.f(this.jdField_a_of_type_Pgu.this$0);
        break;
      }
      if (paramLong == 700202L)
      {
        ouy.a().aZ(this.jdField_a_of_type_Pgu.this$0.getContext(), this.jdField_a_of_type_Pgu.this$0.getContext().getString(2131700118));
        QCircleRecommendImageView.g(this.jdField_a_of_type_Pgu.this$0);
        break;
      }
      QLog.d("QCircleRecommend_", 1, "net_error" + paramLong);
      QCircleRecommendImageView.a(this.jdField_a_of_type_Pgu.this$0, paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgv
 * JD-Core Version:    0.7.0.1
 */