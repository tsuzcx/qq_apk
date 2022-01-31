import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import qqcircle.QQCircleDitto.StItemContainer;

public class uez
  implements View.OnClickListener
{
  public uez(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (QCirclePushRankTopView.a(this.a) != null) && (QCirclePushRankTopView.a(this.a).size() > QCirclePushRankTopView.a(this.a)) && (QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a)) != null))
    {
      paramView = tqr.a(((QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a))).urlInfo.get(), "RankItemUrl");
      if (bdnn.a(paramView)) {
        QLog.w("QCirclePushRankTopView", 1, "rank url is empty");
      }
      tzv.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 4L);
      tqs.a(this.a.getContext(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uez
 * JD-Core Version:    0.7.0.1
 */