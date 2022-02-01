import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.launchbean.QCircleLayerBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

class vos
  implements View.OnClickListener
{
  vos(voq paramvoq) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    QCircleLayerBean localQCircleLayerBean = voq.a(this.a, false);
    if (localQCircleLayerBean != null)
    {
      vtq.a("", 17, 3);
      localQCircleLayerBean.setFromReportBean(this.a.a().clone().setElementIdStr("portraitlist"));
      if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_push_feeddetail_recom", 0) == 0) {
        bool = true;
      }
      localQCircleLayerBean.setSingleFeed(bool);
      uyx.a(paramView.getContext(), localQCircleLayerBean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vos
 * JD-Core Version:    0.7.0.1
 */