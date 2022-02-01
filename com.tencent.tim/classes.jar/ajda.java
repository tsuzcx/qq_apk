import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;

class ajda
  extends achq
{
  ajda(ajcy paramajcy, QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, achq.a parama)
  {
    this.val$app.a().e(this.d.frienduin, this.d.istroop, this.d.uniseq);
    this.val$app.a().notifyUI(6003, true, new Object[] { this.d.frienduin, this.d.uniseq + "" });
    this.val$app.b().c(this.bQI, this.dhX, this.d.uniseq, this.d.msgData);
    if (paramBoolean)
    {
      ajcy.a(this.this$0, this.d, true);
      return;
    }
    ajcy localajcy = this.this$0;
    MessageForMixedMsg localMessageForMixedMsg = this.d;
    StringBuilder localStringBuilder = new StringBuilder().append("sendStructLongMsg fail : errCode = ");
    if (parama != null) {}
    for (parama = Integer.valueOf(parama.errCode);; parama = "")
    {
      ajcy.a(localajcy, localMessageForMixedMsg, true, parama);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajda
 * JD-Core Version:    0.7.0.1
 */