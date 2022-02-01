import android.os.Handler;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView;
import com.tencent.biz.qqcircle.widgets.QCircleRecommendImageView.4.1;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class pgt
  implements ozo.c
{
  public pgt(QCircleRecommendImageView paramQCircleRecommendImageView, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Map<String, ozo.a> paramMap)
  {
    if (paramBoolean)
    {
      QCircleRecommendImageView.p(true);
      QCircleRecommendImageView.f(paramMap);
      QLog.i("QCircleRecommend_", 1, "onCreateSuccess ");
      try
      {
        ThreadManagerV2.getUIHandlerV2().post(new QCircleRecommendImageView.4.1(this));
        return;
      }
      catch (Exception paramMap)
      {
        QLog.i("QCircleRecommend_", 1, "playError " + paramMap.getMessage());
        paramMap.printStackTrace();
        return;
      }
    }
    QQToast.a(this.this$0.getContext(), "动画加载失败", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgt
 * JD-Core Version:    0.7.0.1
 */