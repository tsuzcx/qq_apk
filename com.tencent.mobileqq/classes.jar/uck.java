import android.content.Context;
import com.tencent.biz.qqcircle.events.QCirclePushUpdateEvent;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudWrite.StDoPushRsp;

class uck
  implements yvn<FeedCloudWrite.StDoPushRsp>
{
  uck(ucj paramucj, QCircleDoRecommendRequest paramQCircleDoRecommendRequest) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudWrite.StDoPushRsp paramStDoPushRsp)
  {
    boolean bool = true;
    QLog.d("QCircleRecommend", 4, "QCircleDoRecommendRequest push is success:" + paramBoolean + " retCode:" + paramLong);
    if ((paramLong == 0L) && (paramStDoPushRsp != null))
    {
      QLog.d("QCircleRecommend", 4, "req traceId:" + this.jdField_a_of_type_ComTencentBizQqcircleRequestsQCircleDoRecommendRequest.getTraceId());
      QLog.d("QCircleRecommend", 4, "QCircleDoRecommendRequest push success myFuel:" + paramStDoPushRsp.myFuel.get() + "consumeFuel" + paramStDoPushRsp.consumeFuel.get());
      QCircleRecommendImageView.c(this.jdField_a_of_type_Ucj.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a) + paramStDoPushRsp.consumeFuel.get());
      paramString = new QCirclePushUpdateEvent(tqg.a(), QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a).id.get(), QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a));
      paramString.mHashCode = this.jdField_a_of_type_Ucj.a.hashCode();
      yej.a().a(paramString);
      QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a, paramStDoPushRsp.myFuel.get(), paramStDoPushRsp.consumeFuel.get());
      paramString = this.jdField_a_of_type_Ucj.a;
      if (QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a) <= 0) {
        break label454;
      }
    }
    label454:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      QCircleRecommendImageView.a(paramString, paramBoolean);
      QCircleRecommendImageView.b(this.jdField_a_of_type_Ucj.a, QCircleRecommendImageView.a(this.jdField_a_of_type_Ucj.a));
      return;
      if (paramLong == 700207L)
      {
        QLog.d("QCircleRecommend", 1, "CW_HAVE_PUSH_MAX_CNT");
        QCircleRecommendImageView.f(this.jdField_a_of_type_Ucj.a);
        break;
      }
      if (paramLong == 700202L)
      {
        tqt.a().a(this.jdField_a_of_type_Ucj.a.getContext(), this.jdField_a_of_type_Ucj.a.getContext().getString(2131698319));
        QCircleRecommendImageView.g(this.jdField_a_of_type_Ucj.a);
        break;
      }
      QLog.d("QCircleRecommend", 1, "net_error" + paramLong);
      tqt.a().a(this.jdField_a_of_type_Ucj.a.getContext(), this.jdField_a_of_type_Ucj.a.getContext().getString(2131694769) + paramLong);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uck
 * JD-Core Version:    0.7.0.1
 */