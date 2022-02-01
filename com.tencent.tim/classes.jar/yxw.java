import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.StructMsg;

public class yxw
  implements View.OnClickListener
{
  public yxw(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof ywa.a)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ywa.a locala = (ywa.a)paramView.getTag();
      if (locala.a.msg_type.get() == 2)
      {
        this.this$0.a(locala);
        if (locala.bDQ == 82) {
          anot.a(this.this$0.app, "P_CliOper", "Grp_public", "", "oper", "Clk_notice", 0, 0, "", "", "", locala.a.req_uin.get() + "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxw
 * JD-Core Version:    0.7.0.1
 */