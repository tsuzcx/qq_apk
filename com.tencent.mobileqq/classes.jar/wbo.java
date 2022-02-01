import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class wbo
  implements View.OnClickListener
{
  public wbo(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a() != null) && (QCirclePushRankTopView.a(this.a) != null) && (QCirclePushRankTopView.a(this.a).size() > QCirclePushRankTopView.a(this.a)) && (QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a)) != null))
    {
      String str = uyw.a(((QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a))).urlInfo.get(), "RankItemUrl");
      if (bhsr.a(str)) {
        QLog.w("QCirclePushRankTopView", 1, "rank url is empty");
      }
      uyx.a(this.a.getContext(), str, null, -1);
      vtq.a("", 9, 4, 0, ((QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a))).containerType.get() + "", "", "", "", "", QCirclePushRankTopView.a(this.a), this.a.d(), -1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbo
 * JD-Core Version:    0.7.0.1
 */