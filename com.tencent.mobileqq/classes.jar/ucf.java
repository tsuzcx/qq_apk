import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import qqcircle.QQCircleDitto.StItemContainer;

public class ucf
  implements View.OnClickListener
{
  public ucf(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a() != null)
    {
      paramView = tqr.a(((QQCircleDitto.StItemContainer)this.a.a()).urlInfo.get(), "RankItemUrl");
      if (bdje.a(paramView)) {
        QLog.w("QCirclePushRankTopView", 1, "rank url is empty");
      }
      tyj.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 9, 4L);
      tqs.a(this.a.getContext(), paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ucf
 * JD-Core Version:    0.7.0.1
 */