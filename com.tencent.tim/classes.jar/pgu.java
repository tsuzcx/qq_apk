import android.os.Handler;
import com.tencent.biz.qqcircle.requests.QCircleDoRecommendRequest;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.6.1;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

public class pgu
  implements sow.a
{
  public pgu(QCircleRecommendImageView paramQCircleRecommendImageView) {}
  
  public void bkR()
  {
    QCircleRecommendImageView.a(this.this$0, 0);
    if (!jqi.isNetworkAvailable(this.this$0.getContext()))
    {
      QCircleRecommendImageView.b(this.this$0, QCircleRecommendImageView.a(this.this$0));
      ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.6.1(this));
    }
    while ((QCircleRecommendImageView.a(this.this$0) == null) || (QCircleRecommendImageView.a(this.this$0) == null)) {
      return;
    }
    int i = QCircleRecommendImageView.b(this.this$0) - QCircleRecommendImageView.a(this.this$0);
    if (i <= 0)
    {
      QLog.d("QCircleRecommend_", 1, "addPushTimes" + i + "merge request");
      QCircleRecommendImageView.b(this.this$0, QCircleRecommendImageView.a(this.this$0));
      return;
    }
    QCircleRecommendImageView.a(this.this$0, i);
    QLog.d("QCircleRecommend_", 1, "QCircleDoRecommendRequest add push " + i);
    QCircleDoRecommendRequest localQCircleDoRecommendRequest = new QCircleDoRecommendRequest(QCircleRecommendImageView.a(this.this$0), i, QCircleRecommendImageView.a(this.this$0));
    VSNetworkHelper.a().a(this.this$0.getContext(), localQCircleDoRecommendRequest, new pgv(this, localQCircleDoRecommendRequest));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgu
 * JD-Core Version:    0.7.0.1
 */