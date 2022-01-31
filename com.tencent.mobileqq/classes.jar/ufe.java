import android.os.Handler;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.6.1;
import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class ufe
  implements yxu
{
  public ufe(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void a()
  {
    QCircleRecommendImageView.a(this.a, 0);
    if (!ndk.a(this.a.getContext()))
    {
      QCircleRecommendImageView.b(this.a, QCircleRecommendImageView.a(this.a));
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.6.1(this));
    }
    while ((QCircleRecommendImageView.a(this.a) == null) || (QCircleRecommendImageView.a(this.a) == null)) {
      return;
    }
    int i = QCircleRecommendImageView.b(this.a) - QCircleRecommendImageView.a(this.a);
    if (i <= 0)
    {
      QLog.d("QCircleRecommend_", 1, "addPushTimes" + i + "merge request");
      QCircleRecommendImageView.b(this.a, QCircleRecommendImageView.a(this.a));
      return;
    }
    QCircleRecommendImageView.a(this.a, i);
    QLog.d("QCircleRecommend_", 1, "QCircleDoRecommendRequest add push " + i);
    QCircleDoRecommendRequest localQCircleDoRecommendRequest = new QCircleDoRecommendRequest(QCircleRecommendImageView.a(this.a), i, QCircleRecommendImageView.a(this.a));
    VSNetworkHelper.a().a(this.a.getContext(), localQCircleDoRecommendRequest, new uff(this, localQCircleDoRecommendRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ufe
 * JD-Core Version:    0.7.0.1
 */