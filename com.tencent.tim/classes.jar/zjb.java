import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;

public class zjb
{
  public static String l(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForText))
    {
      paramMessageRecord = (MessageForText)paramMessageRecord;
      if (paramMessageRecord.sb != null) {
        return paramMessageRecord.sb.toString();
      }
      return paramMessageRecord.msg;
    }
    if ((paramMessageRecord instanceof MessageForMixedMsg)) {
      return String.valueOf(MessageForMixedMsg.getTextFromMixedMsg((MessageForMixedMsg)paramMessageRecord));
    }
    if ((paramMessageRecord instanceof MessageForReplyText))
    {
      paramMessageRecord = (MessageForReplyText)paramMessageRecord;
      if (paramMessageRecord.sb != null) {
        return paramMessageRecord.sb.toString();
      }
      return paramMessageRecord.msg;
    }
    if ((paramMessageRecord instanceof MessageForArkApp)) {
      return ((MessageForArkApp)paramMessageRecord).getJumpUrl();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjb
 * JD-Core Version:    0.7.0.1
 */