import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCircleReportBean;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import feedcloud.FeedCloudMeta.StNotice;
import feedcloud.FeedCloudMeta.StOperation;
import feedcloud.FeedCloudMeta.StUser;

class vmj
  implements View.OnClickListener
{
  vmj(vmh paramvmh) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (!TextUtils.isEmpty(this.a.a.operation.opUser.id.get())))
    {
      if (paramView.getId() != 2131369037) {
        break label115;
      }
      vrf.a(this.a.a.operation.opUser.id.get(), 17, 8);
    }
    for (;;)
    {
      uxo.a(this.a.a.operation.opUser.id.get(), this.a.a().clone().setElementIdStr("portrait"));
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label115:
      if (paramView.getId() == 2131379783) {
        vrf.a(this.a.a.operation.opUser.id.get(), 17, 9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */