import android.content.Context;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushRsp;

class vyd
  implements zxa<FeedCloudWrite.StDoPushRsp>
{
  vyd(vyc paramvyc, QCircleDoRecommendRequest paramQCircleDoRecommendRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoPushRsp paramStDoPushRsp)
  {
    QLog.d(QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a), 1, "QCircleDoRecommendRequest push is success:" + paramBoolean + " retCode:" + paramLong);
    if ((paramLong == 0L) && (paramStDoPushRsp != null))
    {
      QLog.d(QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a), 1, "req traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoRecommendRequest.getTraceId());
      QLog.d(QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a), 1, "QCircleDoRecommendRequest push success myFuel:" + paramStDoPushRsp.myFuel.get() + "consumeFuel" + paramStDoPushRsp.consumeFuel.get());
      QCircleRecommendImageView.c(this.jdField_a_of_type_Vyc.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a) + paramStDoPushRsp.consumeFuel.get());
      QCircleRecommendImageView.b(this.jdField_a_of_type_Vyc.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a));
      paramString = new QCirclePushUpdateEvent(uxc.a(), QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a).id.get(), QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a));
      paramString.mHashCode = this.jdField_a_of_type_Vyc.a.hashCode();
      zwp.a().a(paramString);
      QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a, paramStDoPushRsp.myFuel.get(), paramStDoPushRsp.consumeFuel.get());
    }
    for (;;)
    {
      QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a));
      QCircleRecommendImageView.b(this.jdField_a_of_type_Vyc.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a));
      return;
      if (paramLong == 700207L)
      {
        QLog.d(QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a), 1, "CW_HAVE_PUSH_MAX_CNT");
        QCircleRecommendImageView.e(this.jdField_a_of_type_Vyc.a);
      }
      else if (paramLong == 700202L)
      {
        uxp.a().a(this.jdField_a_of_type_Vyc.a.getContext(), this.jdField_a_of_type_Vyc.a.getContext().getString(2131697172));
        QCircleRecommendImageView.f(this.jdField_a_of_type_Vyc.a);
      }
      else
      {
        QLog.d(QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a), 1, "net_error" + paramLong);
        QCircleRecommendImageView.a(this.jdField_a_of_type_Vyc.a, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vyd
 * JD-Core Version:    0.7.0.1
 */