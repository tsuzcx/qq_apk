import com.tencent.biz.pubaccount.readinjoy.redpacket.RIJRedPacketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgSubImageVideo;

final class xhy
  implements xeh.b
{
  public int b(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((((MessageForStructing)paramChatMessage).structingMsg instanceof StructMsgSubImageVideo)) {
      return 111;
    }
    if (RIJRedPacketManager.a().b(paramChatMessage)) {
      return 114;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xhy
 * JD-Core Version:    0.7.0.1
 */