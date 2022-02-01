import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yxp
  implements View.OnClickListener
{
  public yxp(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView, structmsg.SystemMsg paramSystemMsg) {}
  
  public void onClick(View paramView)
  {
    aldj.a(this.this$0.app, this.this$0.getActivity(), String.valueOf(this.a.group_code.get()), String.valueOf(this.a.action_uin.get()), -1, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxp
 * JD-Core Version:    0.7.0.1
 */