import android.content.Context;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.troop_apps.entry.ui.BulkSendMessageFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.troop.homework.ErrorInfo;
import tencent.im.troop.homework.ReqSend1V1Msg;
import tencent.im.troop.homework.RspSend1V1Msg;

public class apqf
  extends acnd
{
  public apqf(BulkSendMessageFragment paramBulkSendMessageFragment) {}
  
  protected void a(boolean paramBoolean, homework.RspSend1V1Msg paramRspSend1V1Msg, homework.ReqSend1V1Msg paramReqSend1V1Msg)
  {
    if (QLog.isColorLevel()) {
      if (paramRspSend1V1Msg != null) {
        break label97;
      }
    }
    label97:
    for (Object localObject = "null";; localObject = rpf.a(paramRspSend1V1Msg))
    {
      QLog.d(".troop.troop_app.BulkSendMessageFragment", 2, new Object[] { "Receive response succ=", Boolean.valueOf(paramBoolean), "resp: ", localObject });
      if (this.this$0.a != null)
      {
        this.this$0.a.dismiss();
        this.this$0.a = null;
      }
      localObject = this.this$0.getActivity();
      if (localObject != null) {
        break;
      }
      QLog.e(".troop.troop_app.BulkSendMessageFragment", 2, "onBulkSendMessage() Error: getActivity == null");
      return;
    }
    if (paramRspSend1V1Msg == null)
    {
      QQToast.a((Context)localObject, 1, acfp.m(2131703285), 1).show();
      return;
    }
    if (paramRspSend1V1Msg.result.error_code.get() != 0)
    {
      QQToast.a((Context)localObject, 1, paramRspSend1V1Msg.result.error_desc.get().toStringUtf8(), 1).show();
      return;
    }
    QQToast.a((Context)localObject, 2, acfp.m(2131703281), 1).show();
    ((FragmentActivity)localObject).finish();
    ((FragmentActivity)localObject).overridePendingTransition(0, 2130772013);
    paramRspSend1V1Msg = this.this$0.mApp.getHandler(Conversation.class);
    if (paramRspSend1V1Msg != null) {
      paramRspSend1V1Msg.sendEmptyMessage(1009);
    }
    paramRspSend1V1Msg = aqfr.r(this.this$0.mApp, this.this$0.mTroopUin);
    aqfr.b("Grp_edu", "MassMessage", "CreateMessage_Send", 0, 0, new String[] { this.this$0.mTroopUin, paramRspSend1V1Msg, paramReqSend1V1Msg.text.get().toStringUtf8(), String.valueOf(paramReqSend1V1Msg.to_uins.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqf
 * JD-Core Version:    0.7.0.1
 */