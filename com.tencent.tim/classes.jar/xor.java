import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class xor
  implements DialogInterface.OnClickListener
{
  public xor(StructingMsgItemBuilder paramStructingMsgItemBuilder, ChatMessage paramChatMessage, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.b instanceof MessageForStructing))
    {
      paramDialogInterface = (MessageForStructing)this.b;
      if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 35)) {
        ajlc.a().a(this.this$0.app, this.b.frienduin, this.b.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 0);
      }
      do
      {
        return;
        if ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 107))
        {
          ajlc.a().a(this.this$0.app, this.b.frienduin, this.b.istroop, "", paramDialogInterface.structingMsg, paramDialogInterface.uniseq, true, 5);
          return;
        }
      } while ((paramDialogInterface.structingMsg != null) && (paramDialogInterface.structingMsg.mMsgServiceID == 95) && (new aobs(this.this$0.app).a(paramDialogInterface, this.this$0.sessionInfo)));
    }
    ujt.a(this.this$0.app, this.val$context, this.this$0.sessionInfo, this.b.frienduin, this.b.istroop, this.b.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xor
 * JD-Core Version:    0.7.0.1
 */