import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;

class vmm
  implements View.OnClickListener
{
  vmm(vmk paramvmk) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    QCircleInitBean localQCircleInitBean = vmk.a(this.a, false);
    if (localQCircleInitBean != null)
    {
      vrf.a("", 17, 3);
      localQCircleInitBean.mFromReportBean = this.a.a().clone().setElementIdStr("portraitlist");
      if (QzoneConfig.getInstance().getConfig("qqcircle", "qqcircle_push_feeddetail_recom", 0) == 0) {
        bool = true;
      }
      localQCircleInitBean.isSingleFeed = bool;
      uxo.a(localQCircleInitBean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmm
 * JD-Core Version:    0.7.0.1
 */