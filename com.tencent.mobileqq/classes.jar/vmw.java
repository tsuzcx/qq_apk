import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class vmw
  implements View.OnClickListener
{
  vmw(vms paramvms, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    uzk localuzk;
    boolean bool;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))
    {
      localuzk = vms.a(this.jdField_a_of_type_Vms);
      StringBuilder localStringBuilder = new StringBuilder().append("startReply getFeedCommentInfo is");
      if (localuzk == null) {
        break label122;
      }
      bool = true;
      QLog.d("QCircleReplyMessagePresenter", 1, bool);
      if (localuzk != null)
      {
        if (this.jdField_a_of_type_Vms.a != 1) {
          break label127;
        }
        vms.a(this.jdField_a_of_type_Vms, localuzk, 6);
      }
    }
    for (;;)
    {
      vtd.a().a((Activity)this.jdField_a_of_type_AndroidContentContext, localuzk, vms.a(this.jdField_a_of_type_Vms), vms.a(this.jdField_a_of_type_Vms));
      vms.a(this.jdField_a_of_type_Vms, paramView);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label122:
      bool = false;
      break;
      label127:
      if (this.jdField_a_of_type_Vms.a == 2) {
        vms.a(this.jdField_a_of_type_Vms, localuzk, 10);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmw
 * JD-Core Version:    0.7.0.1
 */