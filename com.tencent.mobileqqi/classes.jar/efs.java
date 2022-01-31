import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationAdapter.ViewHolder;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class efs
  implements View.OnClickListener
{
  public efs(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    paramView = (NotificationAdapter.ViewHolder)paramView.getTag();
    if (paramView.a.msg_type.get() == 2) {
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     efs
 * JD-Core Version:    0.7.0.1
 */