import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.AbsStructMsg;

public class xoc
  implements DialogInterface.OnClickListener
{
  public xoc(StructingMsgItemBuilder paramStructingMsgItemBuilder, MessageForStructing paramMessageForStructing) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if ((this.d.structingMsg.source_puin != null) && (!"".equals(this.d.structingMsg.source_puin))) {
      localBundle.putString("source_puin", this.d.structingMsg.source_puin);
    }
    localBundle.putInt("forward_type", -3);
    this.d.structingMsg.mCommentText = null;
    localBundle.putInt("structmsg_service_id", this.d.structingMsg.mMsgServiceID);
    localBundle.putByteArray("stuctmsg_bytes", this.d.structingMsg.getBytes());
    localBundle.putLong("structmsg_uniseq", this.d.uniseq);
    localBundle.putInt("accostType", this.d.structingMsg.sourceAccoutType);
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ahgq.f((Activity)this.this$0.mContext, localIntent, 21);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xoc
 * JD-Core Version:    0.7.0.1
 */