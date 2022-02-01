import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class alvn
{
  private static volatile alvn a;
  
  public static alvn a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new alvn();
      }
      return a;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString1, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, ujt.d paramd, MessageRecord paramMessageRecord, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList2)
  {
    MessageForReplyText localMessageForReplyText = new MessageForReplyText();
    localMessageForReplyText.msg = paramString1;
    localMessageForReplyText.istroop = paramSessionInfo.cZ;
    localMessageForReplyText.msgtype = -1049;
    localMessageForReplyText.atInfoList = paramArrayList1;
    localMessageForReplyText.mSourceMsgInfo = paramd.mSourceMsgInfo;
    localMessageForReplyText.setSourceMessageRecord(paramMessageRecord);
    localMessageForReplyText.isBarrageMsg = paramd.isBarrageMsg;
    localMessageForReplyText.barrageTimeLocation = paramd.barrageTimeLocation;
    localMessageForReplyText.barrageSourceMsgType = paramd.barrageSourceMsgType;
    if ((!TextUtils.isEmpty(paramString2)) && (paramArrayList2 != null) && (!paramArrayList2.isEmpty()))
    {
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_msg", paramString2);
      localMessageForReplyText.saveExtInfoToExtStr("sens_reply_special_at_list", appb.v(paramArrayList2));
    }
    int i = 2;
    if (!TextUtils.isEmpty(paramd.mSourceMsgInfo.mSourceMsgTroopName)) {
      i = 0;
    }
    a(paramQQAppInterface, localMessageForReplyText, paramSessionInfo, i, 0, false);
  }
  
  public void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    new ArrayList(1).add(paramChatMessage);
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramChatMessage);
    paramChatMessage = new ajlf();
    paramChatMessage.action = paramInt1;
    paramChatMessage.sessionInfo = paramSessionInfo;
    paramChatMessage.Dr = localArrayList;
    paramChatMessage.mb = null;
    paramChatMessage.bEW = paramInt2;
    paramChatMessage.djJ = 8;
    paramChatMessage.j = new MessageForStructing();
    paramChatMessage.cpg = paramBoolean;
    new alvm(paramQQAppInterface).e(paramChatMessage);
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForMixedMsg paramMessageForMixedMsg, SessionInfo paramSessionInfo, int paramInt)
  {
    if (paramMessageForMixedMsg == null) {
      return;
    }
    if (paramMessageForMixedMsg.getReplyMessage(paramQQAppInterface) != null)
    {
      new ArrayList(1).add(paramMessageForMixedMsg);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramMessageForMixedMsg);
      paramMessageForMixedMsg = new ajlf();
      paramMessageForMixedMsg.action = 0;
      paramMessageForMixedMsg.sessionInfo = paramSessionInfo;
      paramMessageForMixedMsg.Dr = localArrayList;
      paramMessageForMixedMsg.mb = null;
      paramMessageForMixedMsg.djJ = 9;
      paramMessageForMixedMsg.j = new MessageForStructing();
      new alvk(paramQQAppInterface).e(paramMessageForMixedMsg);
      return;
    }
    ((ajcy)paramQQAppInterface.getManager(174)).a(paramSessionInfo, paramMessageForMixedMsg, false, paramInt);
  }
  
  public void b(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("FORWARD_MSG_UNISEQ", 0L);
    if (l == 0L) {
      if (QLog.isColorLevel()) {
        QLog.d("ReplyMsgSender", 2, "sendReplyMessage uniseq=0");
      }
    }
    ChatMessage localChatMessage;
    do
    {
      return;
      localChatMessage = ((alvj)paramQQAppInterface.getManager(340)).c(l);
      if (localChatMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReplyMsgSender", 2, "sendReplyMessage chatMessage is null");
    return;
    a(paramQQAppInterface, localChatMessage, paramSessionInfo, 0, paramIntent.getIntExtra("KEY_MSG_FORWARD_ID", 0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alvn
 * JD-Core Version:    0.7.0.1
 */