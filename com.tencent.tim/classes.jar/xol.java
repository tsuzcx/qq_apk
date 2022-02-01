import android.app.Activity;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.mp.mobileqq_mp.SubscribeRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import mqq.app.NewIntent;

public class xol
  implements auuw.b
{
  public xol(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Activity paramActivity, AbsStructMsg paramAbsStructMsg) {}
  
  public void a(auuw.a parama)
  {
    if (StructingMsgItemBuilder.c(this.this$0)) {
      return;
    }
    String str = this.b.getExtInfoFromExtStr("msg_template_id");
    int i = this.b.istroop;
    NewIntent localNewIntent = new NewIntent(this.val$activity, kbs.class);
    localNewIntent.putExtra("cmd", "PubAccountFollowSvc.subscribe");
    mobileqq_mp.SubscribeRequest localSubscribeRequest = new mobileqq_mp.SubscribeRequest();
    localSubscribeRequest.msg_id.set(this.a.msgId);
    localSubscribeRequest.index.set(parama.id);
    long l1 = 0L;
    try
    {
      long l2 = Long.parseLong(this.b.frienduin);
      l1 = l2;
    }
    catch (Exception parama)
    {
      label108:
      break label108;
    }
    localSubscribeRequest.template_id.set(str);
    localSubscribeRequest.puin.set(l1);
    localNewIntent.setObserver(new xom(this, str));
    localNewIntent.putExtra("data", localSubscribeRequest.toByteArray());
    this.this$0.app.startServlet(localNewIntent);
    StructingMsgItemBuilder.c(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xol
 * JD-Core Version:    0.7.0.1
 */