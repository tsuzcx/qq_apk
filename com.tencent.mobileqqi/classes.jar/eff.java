import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
import com.tencent.mobileqq.adapter.SystemMsgListAdapter.ViewHolder;
import com.tencent.mobileqq.pb.PBEnumField;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class eff
  implements View.OnClickListener
{
  public eff(SystemMsgListView paramSystemMsgListView) {}
  
  public void onClick(View paramView)
  {
    paramView = (SystemMsgListAdapter.ViewHolder)paramView.getTag();
    if (paramView.a.msg_type.get() == 1) {
      this.a.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eff
 * JD-Core Version:    0.7.0.1
 */