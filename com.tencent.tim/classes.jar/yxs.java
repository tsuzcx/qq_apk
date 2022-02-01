import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class yxs
  implements View.OnClickListener
{
  public yxs(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ywu)paramView.getTag();
    if (((ywu)localObject).a.msg.group_msg_type.get() == 80)
    {
      localObject = TroopInfoActivity.c(String.valueOf(((ywu)localObject).a.msg.group_code.get()), 5);
      TroopInfoActivity.i(this.this$0.getActivity(), (Bundle)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqiw.isNetSupport(this.this$0.getActivity())) {
        break;
      }
      QQToast.a(this.this$0.P, this.this$0.getActivity().getString(2131696270), 0).show(this.this$0.getTitleBarHeight());
    }
    ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).DG(String.valueOf(((ywu)localObject).a.req_uin.get()));
    yym.a((structmsg.StructMsg)((ywu)localObject).a.get());
    TroopNotifyAndRecommendView.a(this.this$0, (structmsg.StructMsg)((ywu)localObject).a.get(), ((ywu)localObject).uniseq);
    String str1 = ((ywu)localObject).a.msg.group_info.msg_alert.get();
    String str2 = ((ywu)localObject).a.msg.group_code.get() + "";
    if ((str1 == null) || ("".equals(str1)))
    {
      TroopNotifyAndRecommendView.b(this.this$0, 1, (structmsg.StructMsg)((ywu)localObject).a.get());
      if ((((ywu)localObject).a.msg.has()) && (((ywu)localObject).a.msg.req_uin_nick.has())) {
        ((TroopManager)this.this$0.app.getManager(52)).ax(str2, ((ywu)localObject).a.req_uin.get() + "", ((ywu)localObject).a.msg.req_uin_nick.get());
      }
      yym.a(((ywu)localObject).a, "unnormal_join");
    }
    for (;;)
    {
      TroopNotifyAndRecommendView.f(this.this$0);
      this.this$0.J.setMessage(2131719519);
      this.this$0.J.show();
      break;
      TroopNotifyAndRecommendView.b(this.this$0, 0, (structmsg.StructMsg)((ywu)localObject).a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yxs
 * JD-Core Version:    0.7.0.1
 */