import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ovt
  implements View.OnClickListener
{
  ovt(ovs paramovs) {}
  
  public void onClick(View paramView)
  {
    if (ovs.a(this.a) != null)
    {
      if (aqmr.isEmpty(ovs.a(this.a))) {
        QLog.w("QCircleTaskCenterAdapter", 1, "task center url is empty");
      }
      oux.aX(ovs.a(this.a), ovs.a(this.a));
      pco.h(BaseApplicationImpl.getApplication().getRuntime().getAccount(), 8, 2L);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ovt
 * JD-Core Version:    0.7.0.1
 */