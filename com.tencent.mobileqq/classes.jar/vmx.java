import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vmx
  implements View.OnClickListener
{
  vmx(vms paramvms) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a != null) {
      this.a.a.callOnClick();
    }
    uzk localuzk = vms.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder().append("tvTime getFeedCommentInfo is");
    if (localuzk != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
      if (localuzk != null) {
        vms.a(this.a, localuzk, 2);
      }
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmx
 * JD-Core Version:    0.7.0.1
 */