import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.NotificationView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class ywd
  implements View.OnClickListener
{
  public ywd(NotificationView paramNotificationView) {}
  
  public void onClick(View paramView)
  {
    ywa.a locala = (ywa.a)paramView.getTag();
    if (locala.a.msg_type.get() == 2)
    {
      this.this$0.a(locala);
      if (locala.bDQ == 82) {
        anot.a(this.this$0.app, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", locala.a.req_uin.get() + "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywd
 * JD-Core Version:    0.7.0.1
 */