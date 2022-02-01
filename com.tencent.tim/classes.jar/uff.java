import android.view.View;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class uff
  implements ausj.a
{
  public uff(AddRequestActivity paramAddRequestActivity, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      this.val$sheet.dismiss();
      return;
    }
    if (aqiw.isNetSupport(BaseApplication.getContext()))
    {
      long l1 = anzd.a().hf();
      this.this$0.a = anzd.a().a(Long.valueOf(l1));
      if (this.this$0.a != null)
      {
        paramInt = this.this$0.a.msg_type.get();
        l1 = this.this$0.a.msg_seq.get();
        long l2 = this.this$0.a.req_uin.get();
        int i = this.this$0.a.msg.sub_type.get();
        int j = this.this$0.a.msg.src_id.get();
        int k = this.this$0.a.msg.sub_src_id.get();
        int m = this.this$0.a.msg.group_msg_type.get();
        paramView = this.this$0.a.msg.actions.get();
        if ((paramView != null) && (1 < paramView.size()))
        {
          ((structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get()).blacklist.set(true);
          AddRequestActivity.a(this.this$0, true);
          this.this$0.app.a().a().a(paramInt, l1, l2, i, j, k, m, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)paramView.get(1)).action_info.get(), 1, null, false);
          AddRequestActivity.a(this.this$0, 2131719519, 1000L, false);
        }
      }
    }
    for (;;)
    {
      anot.a(this.this$0.app, "CliOper", "", "", "Verification_msg", "Vfc_shield_clk", 0, 0, "", "", "", "");
      anot.a(this.this$0.app, "CliOper", "", "", "0X800AA45", "0X800AA45", 0, 0, "", "", "", "");
      break;
      StringBuilder localStringBuilder = new StringBuilder().append("shield, ");
      if (paramView != null) {}
      for (paramInt = paramView.size();; paramInt = -1)
      {
        QLog.d("Q.systemmsg.AddRequestActivity", 1, paramInt);
        break;
      }
      QLog.d("Q.systemmsg.AddRequestActivity", 1, "shield");
      continue;
      QQToast.a(this.this$0, 2131696272, 0).show(this.this$0.getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uff
 * JD-Core Version:    0.7.0.1
 */