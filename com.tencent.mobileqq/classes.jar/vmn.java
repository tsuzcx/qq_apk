import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vmn
  implements View.OnClickListener
{
  vmn(vmk paramvmk) {}
  
  public void onClick(View paramView)
  {
    QCircleInitBean localQCircleInitBean = vmk.a(this.a, true);
    if (localQCircleInitBean != null)
    {
      vrf.a("", 17, 3);
      localQCircleInitBean.mFromReportBean = this.a.a().clone().setElementIdStr("content");
      if ((this.a.c == null) || (paramView.getId() != this.a.c.getId()) || (this.a.a == null)) {
        break label122;
      }
      uxo.a(BaseApplication.getContext(), localQCircleInitBean, vsn.a(this.a.a, this.a.a.getWidth(), this.a.a.getHeight()));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label122:
      uxo.a(BaseApplication.getContext(), localQCircleInitBean, new Intent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmn
 * JD-Core Version:    0.7.0.1
 */