import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launchbean.QCircleInitBean;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class vop
  implements View.OnClickListener
{
  vop(von paramvon) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(this.a.a.operation.opUser.id.get())))
    {
      vtq.a(this.a.a.operation.opUser.id.get(), 17, 8);
      QCircleInitBean localQCircleInitBean = new QCircleInitBean();
      localQCircleInitBean.setUin(this.a.a.operation.opUser.id.get());
      localQCircleInitBean.setFromReportBean(this.a.a().clone().setElementIdStr("portrait"));
      uyx.b(paramView.getContext(), localQCircleInitBean);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vop
 * JD-Core Version:    0.7.0.1
 */