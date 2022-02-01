import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class pgq
  implements View.OnClickListener
{
  public pgq(QCirclePushRankTopView paramQCirclePushRankTopView) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.getData() != null) && (QCirclePushRankTopView.a(this.a) != null) && (QCirclePushRankTopView.a(this.a).size() > QCirclePushRankTopView.a(this.a)) && (QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a)) != null))
    {
      String str = ouw.c(((QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a))).urlInfo.get(), "RankItemUrl");
      if (aqmr.isEmpty(str)) {
        QLog.w("QCirclePushRankTopView", 1, "rank url is empty");
      }
      oux.aX(this.a.getContext(), str);
      pco.a("", 9, 4L, 0L, ((QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.a).get(QCirclePushRankTopView.a(this.a))).containerType + "", "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pgq
 * JD-Core Version:    0.7.0.1
 */